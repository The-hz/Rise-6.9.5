package hackclient.rise;

import com.google.gson.JsonParser;
import hackclient.rise.aek;
import hackclient.rise.aha;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import javax.net.ssl.HttpsURLConnection;

public class aej
implements aha {
    private static final String aED = "https://sessionserver.mojang.com/session/minecraft/profile/";
    private static final Map<UUID, aek> aEE = new ConcurrentHashMap<UUID, aek>();
    static final long aEF = TimeUnit.MINUTES.toMillis(5L);
    private static long aEG = 0L;
    private static final long aEH = 100L;

    public static void a(UUID uUID, Consumer<Boolean> consumer) {
        if (uUID == null) {
            consumer.accept(false);
            return;
        }
        aek aek2 = aEE.get(uUID);
        if (aek2 != null && !aek2.sd()) {
            consumer.accept(aek2.aEI);
            return;
        }
        aMR.execute(() -> {
            boolean bl = aej.c(uUID);
            aEE.put(uUID, new aek(bl));
            consumer.accept(bl);
        });
    }

    private static boolean c(UUID var0) {
        if (var0 == null) {
            return false;
        }
        synchronized (aej.class) {
            HttpsURLConnection httpsurlconnection = null;
            try {
                long l = System.currentTimeMillis() - aej.aEG;
                if (l < 100L) {
                    try {
                        Thread.sleep(100L - l);
                    } catch (InterruptedException interruptedexception) {
                        Thread.currentThread().interrupt();
                        return false;
                    }
                }
                aej.aEG = System.currentTimeMillis();

                String s = var0.toString().replace("-", "");
                URL url = new URL(aED + s);
                httpsurlconnection = (HttpsURLConnection)url.openConnection();
                httpsurlconnection.setRequestMethod("GET");
                httpsurlconnection.setConnectTimeout(5000);
                httpsurlconnection.setReadTimeout(5000);
                httpsurlconnection.setRequestProperty("User-Agent", "Rise-Client-AntiBot/1.0");

                int i = httpsurlconnection.getResponseCode();
                if (i == 200) {
                    BufferedReader bufferedreader =
                        new BufferedReader(new InputStreamReader(httpsurlconnection.getInputStream()));
                    StringBuilder stringbuilder = new StringBuilder();
                    String s1;
                    while ((s1 = bufferedreader.readLine()) != null) {
                        stringbuilder.append(s1);
                    }
                    bufferedreader.close();
                    try {
                        com.google.gson.JsonObject jsonobject =
                            JsonParser.parseString(stringbuilder.toString()).getAsJsonObject();
                        if (jsonobject.has("id") && jsonobject.has("name")) {
                            return jsonobject.get("id").getAsString().replace("-", "").equalsIgnoreCase(s);
                        }
                        return false;
                    } catch (Exception exception) {
                        return false;
                    }
                }
                if (i == 204 || i == 404) {
                    return false;
                }
                return true;
            } catch (Exception exception1) {
                return true;
            } finally {
                if (httpsurlconnection != null) {
                    httpsurlconnection.disconnect();
                }
            }
        }
    }

    public static void sb() {
        aEE.clear();
    }

    public static void sc() {
        aEE.entrySet().removeIf(entry -> ((aek)entry.getValue()).sd());
    }
}
