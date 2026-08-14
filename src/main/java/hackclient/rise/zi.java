package hackclient.rise;

import com.alan.clients.security.SecurityFeature;
import java.util.Locale;

public class zi extends SecurityFeature implements zh {
    public static Object[] oO00O0OO0ooO = new Object[1];
    public static Object[] o0Oo000O0oO = new Object[6];
    public static Object[] fld_0oOOoOo0O00O_52 = new Object[4];
    public volatile boolean avA;
    public static int[] O0OoOO0OOOOO;

    public static void Oo0o00000O00() {
    }

    static {
        Oo0o00000O00();
        fld_0oOOoOo0O00O_52[0] = "JHror5vTTt/lsgeAvtvKiHloCRn6iNZ0dbQyJVeRmAHlM8pLPSe8k599cwxVqGCHHII9xKBvONp7E91FtZd9Aw==";
        fld_0oOOoOo0O00O_52[1] = "PBKDF2WithHmacSHA1";
        fld_0oOOoOo0O00O_52[2] = "AES";
        fld_0oOOoOo0O00O_52[3] = "AES/CBC/PKCS5Padding";
        oO00O0OO0ooO[0] = "\u0000\u0001.\u0000\u0003and\u0000\u0005debug\u0000\u0001/\u0000\u0006packet\u0000\u0011debugorpacketcomm";
        o0Oo000O0oO[0] = ".";
        o0Oo000O0oO[1] = "and";
        o0Oo000O0oO[2] = "debug";
        o0Oo000O0oO[3] = "/";
        o0Oo000O0oO[4] = "packet";
        o0Oo000O0oO[5] = "debugorpacketcomm";
    }

    @Override
    public boolean nG() {
        return this.avA;
    }

    @Override
    public String getReason() {
        return "debugorpacketcomm" + (String)o0Oo000O0oO[1];
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
