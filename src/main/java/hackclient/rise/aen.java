package hackclient.rise;

import com.alan.clients.util.account.auth.MicrosoftLogin;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;

public final class aen {
    private static final String aET = "https://api.minecraftservices.com/minecraft/profile";

    private aen() {
    }

    public static Session bj(String var0) throws IOException {
        if (var0 == null) {
            throw new IOException("Empty token");
        }
        String s = var0.trim();
        if (s.isEmpty()) {
            throw new IOException("Empty token");
        }
        if (s.matches("^\\d+$")) {
            String s1;
            try {
                s1 = afm.am(Integer.parseInt(s));
            } catch (NumberFormatException numberformatexception) {
                throw new IOException("Invalid ref id", numberformatexception);
            }
            if (s1 == null || s1.trim().isEmpty()) {
                throw new IOException("Invalid ref id");
            }
            s = s1.trim();
        }

        try {
            String s2 = akc.I(aET, s);
            if (s2 == null || s2.trim().isEmpty()) {
                throw new IOException("Invalid/expired token");
            }
            JsonObject jsonobject;
            try {
                jsonobject = JsonParser.parseString(s2).getAsJsonObject();
            } catch (Exception exception) {
                throw new IOException("Invalid/expired token", exception);
            }
            if (!jsonobject.has("name") || !jsonobject.has("id")) {
                throw new IOException("Invalid/expired token");
            }
            Session session = new Session(
                jsonobject.get("name").getAsString(), jsonobject.get("id").getAsString(), s, "mojang");
            Minecraft.getMinecraft().setSession(session);
            return session;
        } catch (IOException ioexception) {
            com.alan.clients.util.account.auth.d akd1 = MicrosoftLogin.login(s);
            if (akd1 == null || !akd1.sm() || akd1.aCj == null || akd1.aEL == null) {
                throw ioexception;
            }
            Session session1 = new Session(akd1.aCj, akd1.aEL, akd1.aEX, "mojang");
            Minecraft.getMinecraft().setSession(session1);
            return session1;
        }
    }
}
