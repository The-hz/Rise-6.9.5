package hackclient.rise;

import java.util.UUID;

public class aeo extends ael {
    public aeo(String var1) {
        super(aem.CRACKED, var1, bl(var1), "accessToken");
    }

    private static String bl(String var0) {
        return UUID.nameUUIDFromBytes(("OfflinePlayer:" + var0).getBytes()).toString().replace("-", "");
    }
}
