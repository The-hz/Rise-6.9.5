package hackclient.rise;

import com.alan.clients.security.SecurityFeature;

public class zk extends SecurityFeature
{
    public static Object[] fld_0oOOoOo0O00O_55;
    public volatile boolean avA;
    public static Object[] oO00O0OO0ooO;
    public static Object[] o0Oo000O0oO;
    public static int[] O0OoOO0OOOOO;

    public boolean nG() {
        if (this.avA) {
            return true;
        }
        if (zk.aEg == null || zk.aEg.thePlayer == null || zk.aEg.theWorld == null || zk.aEg.isIntegratedServerRunning()) {
            return 14 - 14 != 0;
        }
        return ahm.vr() && !ahm.vp() && (this.avA = true);
    }

    public String getReason() {
        return "hypixelbrandaddressmis" + "match";
    }

    static {
        Oo0o00000O00();
        (zk.oO00O0OO0ooO = new Object[1])[0] = "\u0000\u0005match\u0000\u0016hypixelbrandaddressmis";
        (zk.o0Oo000O0oO = new Object[2])[0] = "match";
        zk.o0Oo000O0oO[1] = "hypixelbrandaddressmis";
        (zk.fld_0oOOoOo0O00O_55 = new Object[4])[0] = "ig3SGx8f6V28E7nF6xI/pfb8agPbj7QY5ue3UtOfjJkpkrtmHuSb92VMMZwoR0JL";
        zk.fld_0oOOoOo0O00O_55[1] = "PBKDF2WithHmacSHA1";
        zk.fld_0oOOoOo0O00O_55[2] = "AES";
        zk.fld_0oOOoOo0O00O_55[3] = "AES/CBC/PKCS5Padding";
    }

    public static void Oo0o00000O00() {
    }
}
