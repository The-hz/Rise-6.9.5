package hackclient.rise;

import com.alan.clients.security.SecurityFeature;
import java.util.Locale;

public class zi extends SecurityFeature implements zh {
    public volatile boolean avA;
    public static int[] O0OoOO0OOOOO;

    public static void Oo0o00000O00() {
    }

    static {
        Oo0o00000O00();
    }

    @Override
    public boolean nG() {
        return this.avA;
    }

    @Override
    public String getReason() {
        return "debugorpacketcommand";
    }

    public zi() {
    }

    @Override
    public void ar(String var1) {
        if (var1 != null && !this.avA) {
            String s = var1.trim().toLowerCase(Locale.ENGLISH);
            if (s.startsWith("/") || s.startsWith(".")) {
                if (s.contains("debug") || s.contains("packet")) {
                    this.avA = true;
                }
            }
        }
    }
}
