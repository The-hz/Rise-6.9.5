package rip.vantage.commons.util.encryption;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class XorCipher13 {
    private static final String eQT = "ふぎにかぁふぃいざふふかんじ";

    public XorCipher13() {
    }

    public static String kh(String var0) {
        byte[] abyte = "ふぎにかぁふぃいざふふかんじ".getBytes(StandardCharsets.UTF_8);
        byte[] abyte1 = var0.getBytes(StandardCharsets.UTF_8);
        byte[] abyte2 = new byte[abyte1.length];

        for (int i = 0; i < abyte1.length; i++) {
            abyte2[i] = (byte)(abyte1[i] ^ abyte[i % abyte.length]);
        }

        return Base64.getEncoder().encodeToString(abyte2);
    }

    public static String ki(String var0) {
        byte[] abyte = "ふぎにかぁふぃいざふふかんじ".getBytes(StandardCharsets.UTF_8);
        byte[] abyte1 = Base64.getDecoder().decode(var0);
        byte[] abyte2 = new byte[abyte1.length];

        for (int i = 0; i < abyte1.length; i++) {
            abyte2[i] = (byte)(abyte1[i] ^ abyte[i % abyte.length]);
        }

        return new String(abyte2, StandardCharsets.UTF_8);
    }
}
