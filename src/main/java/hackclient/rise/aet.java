package hackclient.rise;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;

public final class aet {
    private static final String aFl = "https://localts.store/v1";
    private static final String aFm = "campaign=rise";
    private static final int aFn = 10000;
    private static final int aFo = 15000;

    private aet() {
    }

    public static aex ss() {
        aez aez = b("GET", "/products?campaign=rise", null);
        if (!aez.st()) {
            return new aex(false, Collections.emptyList(), aez.aFR);
        }

        JsonObject jsonobject = aez.aFQ;
        if (!c(jsonobject)) {
            return new aex(false, Collections.emptyList(), a(jsonobject, "Localts did not return products"));
        }

        ArrayList arraylist = new ArrayList();

        for (JsonElement jsonelement : e(jsonobject, "products")) {
            if (jsonelement.isJsonObject()) {
                JsonObject jsonobject1 = jsonelement.getAsJsonObject();
                arraylist.add(
                    new aew(
                        b(jsonobject1, "id"),
                        b(jsonobject1, "name"),
                        b(jsonobject1, "description"),
                        b(jsonobject1, "category"),
                        d(jsonobject1, "priceInCredits"),
                        c(jsonobject1, "stock"),
                        b(jsonobject1, "type")
                    )
                );
            }
        }

        return new aex(true, arraylist, "");
    }

    public static afa bu(String var0) {
        aez aez = b("GET", "/me?campaign=rise", var0);
        if (!aez.st()) {
            return new afa(false, "", 0, aez.aFR);
        }

        JsonObject jsonobject = aez.aFQ;
        return !c(jsonobject)
            ? new afa(false, "", 0, a(jsonobject, "Invalid Localts API key"))
            : new afa(true, b(jsonobject, "username"), d(jsonobject, "balance"), "");
    }

    public static aey c(String var0, String var1, int var2) {
        if (var1 != null && !var1.isEmpty()) {
            try {
                String s = "/products/" + URLEncoder.encode(var1, "UTF-8") + "/purchase?amount=" + var2 + "&campaign=rise";
                aez aez = b("POST", s, var0);
                if (!aez.st()) {
                    return new aey(false, "", aez.aFR);
                }

                JsonObject jsonobject = aez.aFQ;
                return !c(jsonobject) ? new aey(false, "", a(jsonobject, "Purchase failed")) : new aey(true, b(jsonobject, "orderId"), "");
            } catch (Exception exception) {
                return new aey(false, "", "Unable to create Localts purchase request");
            }
        } else {
            return new aey(false, "", "Choose a Localts product first");
        }
    }

    public static aeu z(String var0, String var1) {
        try {
            aez aez = b("GET", "/orders/get-order?id=" + URLEncoder.encode(var1, "UTF-8") + "&campaign=rise", var0);
            if (!aez.st()) {
                return new aeu(false, var1, "", "", new JsonArray(), aez.aFR);
            }

            JsonObject jsonobject = aez.aFQ;
            return !c(jsonobject)
                ? new aeu(false, var1, "", "", new JsonArray(), a(jsonobject, "Could not retrieve order"))
                : new aeu(true, b(jsonobject, "order-id"), b(jsonobject, "status"), b(jsonobject, "product-name"), e(jsonobject, "items"), "");
        } catch (Exception exception) {
            return new aeu(false, var1, "", "", new JsonArray(), "Unable to retrieve Localts order");
        }
    }

    public static aev b(String var0, int var1, int var2) {
        if (var1 >= 0 && var2 >= 1 && var2 <= 100) {
            aez aez = b("GET", "/orders?page=" + var1 + "&size=" + var2 + "&campaign=rise", var0);
            if (!aez.st()) {
                return new aev(false, new JsonArray(), 0, 0, 0, 0, aez.aFR);
            }

            JsonObject jsonobject = aez.aFQ;
            return !c(jsonobject)
                ? new aev(false, new JsonArray(), 0, 0, 0, 0, a(jsonobject, "Could not retrieve Localts orders"))
                : new aev(
                    true,
                    e(jsonobject, "orders"),
                    c(jsonobject, "page"),
                    c(jsonobject, "size"),
                    c(jsonobject, "totalPages"),
                    c(jsonobject, "totalElements"),
                    ""
                );
        }
        return new aev(false, new JsonArray(), 0, 0, 0, 0, "Invalid order page or size");
    }

    private static aez b(String var0, String var1, String var2) {
        HttpURLConnection httpurlconnection = null;

        try {
            httpurlconnection = (HttpURLConnection)new URL("https://localts.store/v1" + var1).openConnection();
            httpurlconnection.setRequestMethod(var0);
            httpurlconnection.setConnectTimeout(10000);
            httpurlconnection.setReadTimeout(15000);
            httpurlconnection.setRequestProperty("Accept", "application/json");
            httpurlconnection.setRequestProperty("User-Agent", "Rise-Client/6.7.10");
            if (var2 != null && !var2.trim().isEmpty()) {
                httpurlconnection.setRequestProperty("X-API-Key", var2.trim());
            }

            int i = httpurlconnection.getResponseCode();
            InputStream inputstream = i >= 200 && i < 300 ? httpurlconnection.getInputStream() : httpurlconnection.getErrorStream();
            String s = a(inputstream);
            JsonElement jsonelement = s.isEmpty() ? null : JsonParser.parseString(s);
            return jsonelement != null && jsonelement.isJsonObject()
                ? new aez(i, jsonelement.getAsJsonObject(), "")
                : new aez(i, null, i == 401 ? "Invalid Localts API key" : "Localts API returned HTTP " + i);
        } catch (Exception exception) {
            return new aez(0, null, "Unable to reach Localts API");
        } finally {
            if (httpurlconnection != null) {
                httpurlconnection.disconnect();
            }
        }
    }

    private static String a(InputStream var0) throws java.io.IOException {
        if (var0 == null) {
            return "";
        }

        StringBuilder stringbuilder = new StringBuilder();

        String s;
        try (BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(var0, StandardCharsets.UTF_8))) {
            while ((s = bufferedreader.readLine()) != null) {
                stringbuilder.append(s);
            }
        }

        return stringbuilder.toString();
    }

    private static boolean c(JsonObject var0) {
        return var0.has("success") && !var0.get("success").isJsonNull() && var0.get("success").getAsBoolean();
    }

    private static String a(JsonObject var0, String var1) {
        return var0.has("error") && !var0.get("error").isJsonNull() ? var0.get("error").getAsString() : var1;
    }

    private static String b(JsonObject var0, String var1) {
        return var0.has(var1) && !var0.get(var1).isJsonNull() ? var0.get(var1).getAsString() : "";
    }

    private static int c(JsonObject var0, String var1) {
        return var0.has(var1) && !var0.get(var1).isJsonNull() ? var0.get(var1).getAsInt() : 0;
    }

    private static int d(JsonObject var0, String var1) {
        return var0.has(var1) && !var0.get(var1).isJsonNull() ? var0.get(var1).getAsInt() : 0;
    }

    private static JsonArray e(JsonObject var0, String var1) {
        return var0.has(var1) && var0.get(var1).isJsonArray() ? var0.getAsJsonArray(var1) : new JsonArray();
    }
}
