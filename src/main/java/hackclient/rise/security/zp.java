package hackclient.rise.security;

import com.alan.clients.security.SecurityFeature;
import hackclient.rise.zh;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Arrays;
import java.util.Base64;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class zp
extends SecurityFeature
implements zh {
    public static Object[] fld_0OOOoo00o0_63;
    public static Object Oo0o00000O00;
    public volatile boolean avA;
    public static Object[] fld_0oOOoOo0O00O_64;
    public static Object[] oO00O0OO0ooO;
    public static Object[] o0Oo000O0oO;
    public static Pattern[] avR;

    @Override
    public void ar(String string) {
        if (string == null) return;
        if (this.avA) {
            return;
        }
        String string2 = string.trim().toLowerCase(Locale.ENGLISH);
        if (string2.isEmpty()) return;
        if (string2.startsWith("/")) return;
        if (string2.startsWith(".")) {
            return;
        }
        Pattern[] patternArray = avR;
        int count = patternArray.length;
        int i = 0;
        while (i < count) {
            if (patternArray[i].matcher(string2).find()) {
                this.avA = true;
                return;
            }
            i++;
        }
    }

    public static Object[] mth_0OOOoo00o0_30() {
        Object[] objectArray = fld_0oOOoOo0O00O_64;
        if (fld_0oOOoOo0O00O_64 == null) {
            fld_0oOOoOo0O00O_64 = new Object[4];
            objectArray = fld_0oOOoOo0O00O_64;
        }
        return objectArray;
    }

    public static Object o0Oo000O0oO(Object[] objectArray) {
        try {
            Object object;
            int n2 = (Integer)objectArray[1];
            String string = (String)objectArray[2];
            Object object2 = objectArray[0];
            Object[] objectArray2 = oO00O0OO0ooO;
            if (oO00O0OO0ooO == null) {
                objectArray2 = oO00O0OO0ooO = new Object[1];
            }
            if ((object = objectArray2[n2]) == null) {
                Object[] objectArray3 = (Object[])object2;
                if (objectArray3 == null) {
                    Object[] objectArray4 = new Object[1];
                    fld_0OOOoo00o0_63 = objectArray4;
                    objectArray3 = objectArray4;
                    byte[] byArray = new byte[16];
                    byArray[7] = 108;
                    byArray[4] = -92;
                    byArray[15] = -70;
                    byArray[10] = 97;
                    byArray[5] = -100;
                    byArray[9] = -41;
                    byArray[8] = -88;
                    byArray[2] = 70;
                    byArray[14] = 51;
                    byArray[12] = -126;
                    byArray[3] = -93;
                    byArray[1] = -72;
                    byArray[0] = 76;
                    byArray[6] = -38;
                    byArray[11] = 33;
                    byArray[13] = -86;
                    objectArray4[0] = byArray;
                }
                byte[] byArray = (byte[])objectArray3[0];
                if (Oo0o00000O00 == null) {
                    byte[] byArray2 = new byte[32];
                    byArray2[16] = 54;
                    byArray2[0] = -88;
                    byArray2[30] = 98;
                    byArray2[9] = -61;
                    byArray2[20] = -104;
                    byArray2[13] = 82;
                    byArray2[4] = 127;
                    byArray2[28] = 57;
                    byArray2[10] = 124;
                    byArray2[19] = -125;
                    byArray2[23] = 111;
                    byArray2[1] = 55;
                    byArray2[21] = 96;
                    byArray2[6] = 40;
                    byArray2[12] = 106;
                    byArray2[11] = -116;
                    byArray2[29] = -20;
                    byArray2[8] = 1;
                    byArray2[14] = 114;
                    byArray2[24] = 2;
                    byArray2[7] = 52;
                    byArray2[31] = 44;
                    byArray2[17] = 14;
                    byArray2[25] = 33;
                    byArray2[26] = -51;
                    byArray2[3] = -26;
                    byArray2[27] = 98;
                    byArray2[5] = -42;
                    byArray2[18] = 0;
                    byArray2[2] = 109;
                    byArray2[22] = -39;
                    byArray2[15] = -112;
                    byte[] byArray3 = new byte[byArray.length + byArray2.length];
                    System.arraycopy(byArray, 0, byArray3, 0, byArray.length);
                    System.arraycopy(byArray2, 0, byArray3, byArray.length, byArray2.length);
                    Object object3 = zp.mth_0OOOoo00o0_30()[1];
                    if (object3 == null) {
                        char[] cArray = "\u51a4\u51aa\u51a1\u51a8\u51ae\u507a\u519d\u5043\u51b8\u504c\u51ac\u5047\u504b\u5049\u5199\u51ac\u51ab\u507b".toCharArray();
                        for (int i2 = 0; i2 < 18; ++i2) {
                            char c2 = cArray[i2];
                            int n3 = c2 ^ 0x7660;
                            int n4 = n3 ^ 0x6D24;
                            int n5 = n4 + 45767;
                            int n6 = n5 - 46312;
                            int n7 = n6 - 33161;
                            int n8 = n7 - 34895;
                            int n9 = n8 + 41971;
                            int n10 = n9 + 6260;
                            int n11 = n10 - 59255;
                            int n12 = n11 + 55447;
                            int n13 = n12 - 50779;
                            int n14 = n13 + 21372;
                            int n15 = n14 ^ 0x79DF;
                            cArray[i2] = (char)n15;
                        }
                        object3 = zp.mth_0OOOoo00o0_30()[1] = new String(cArray);
                    }
                    SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance((String)object3);
                    byte[] byArray4 = new byte[16];
                    byArray4[14] = -110;
                    byArray4[5] = -48;
                    byArray4[7] = 9;
                    byArray4[1] = 45;
                    byArray4[8] = -52;
                    byArray4[10] = 73;
                    byArray4[6] = -99;
                    byArray4[11] = 96;
                    byArray4[15] = -59;
                    byArray4[9] = -25;
                    byArray4[2] = 119;
                    byArray4[0] = 31;
                    byArray4[4] = -86;
                    byArray4[12] = -79;
                    byArray4[13] = 7;
                    byArray4[3] = 20;
                    PBEKeySpec pBEKeySpec = new PBEKeySpec(new String(byArray3, StandardCharsets.UTF_8).toCharArray(), byArray4, 13, 256);
                    byte[] byArray5 = secretKeyFactory.generateSecret(pBEKeySpec).getEncoded();
                    Object object4 = zp.mth_0OOOoo00o0_30()[2];
                    if (object4 == null) {
                        char[] cArray = "\ub232\ub216\ub284".toCharArray();
                        for (int i3 = 0; i3 < 3; ++i3) {
                            char c3 = cArray[i3];
                            int n16 = c3 + 13312;
                            int n17 = n16 - 2513;
                            int n18 = n17 ^ 0xD932;
                            int n19 = n18 - 57443;
                            int n20 = n19 - 31717;
                            int n21 = n20 - 32149;
                            int n22 = n21 - 57127;
                            int n23 = n22 ^ 0x2818;
                            int n24 = n23 ^ 0x288A;
                            int n25 = n24 - 29179;
                            int n26 = n25 + 9567;
                            cArray[i3] = (char)n26;
                        }
                        object4 = zp.mth_0OOOoo00o0_30()[2] = new String(cArray);
                    }
                    Oo0o00000O00 = new SecretKeySpec(byArray5, (String)object4);
                }
                byte[] byArray6 = Base64.getDecoder().decode(string);
                byte[] byArray7 = Arrays.copyOfRange(byArray6, 0, 16);
                byte[] byArray8 = Arrays.copyOfRange(byArray6, 16, byArray6.length);
                Object object5 = zp.mth_0OOOoo00o0_30()[3];
                if (object5 == null) {
                    char[] cArray = "\uf781\uf77d\uf783\uf807\uf773\uf774\uf773\uf807\uf782\uf77b\uf773\uf783\uf82d\uf782\uf761\uf75e\uf75e\uf749\uf748\uf75f".toCharArray();
                    for (int i4 = 0; i4 < 20; ++i4) {
                        char c4 = cArray[i4];
                        int n27 = c4 + 35492;
                        int n28 = n27 + 23972;
                        int n29 = n28 + 42118;
                        int n30 = n29 ^ 0x1B88;
                        int n31 = n30 - 20299;
                        int n32 = n31 + 62155;
                        int n33 = n32 - 14219;
                        int n34 = n33 - 45901;
                        int n35 = n34 + 2253;
                        int n36 = n35 - 43600;
                        int n37 = n36 ^ 0xF4D1;
                        int n38 = n37 ^ 0xB873;
                        int n39 = n38 ^ 0xE234;
                        int n40 = n39 ^ 0x183B;
                        cArray[i4] = (char)n40;
                    }
                    object5 = zp.mth_0OOOoo00o0_30()[3] = new String(cArray);
                }
                Cipher cipher = Cipher.getInstance((String)object5);
                cipher.init(2, (Key)((SecretKey)Oo0o00000O00), new IvParameterSpec(byArray7));
                byte[] byArray9 = cipher.doFinal(byArray8);
                object = new String(byArray9, StandardCharsets.UTF_8);
            }
            return object;
        } catch (java.security.GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public boolean run() {
        return this.avA;
    }

    static {
        clinit: {
        o0Oo000O0oO = new Object[19];
        int l17_hi = 0;
        Object[] objectArray = new Object[3];
        objectArray[0] = fld_0OOOoo00o0_63;
        objectArray[1] = 0;
        Object object = zp.mth_0OOOoo00o0_30()[0];
        if (object == null) {
            char[] cArray = "\u6f34\u6fe8\u6f2b\u6f06\u6f08\u6f2b\u6f2e\u6f2b\u6ff4\u6f03\u6f0e\u6f05\u6f06\u6f0c\u6f0c\u6efc\u6f1b\u6f12\u6f12\u6f33\u6f05\u6f1a\u6f31\u6f11\u6f13\u6f0e\u6f30\u6f28\u6f1c\u6f33\u6f2d\u6f2b\u6f1c\u6fed\u6f16\u6f0c\u6f1c\u6f25\u6f27\u6f25\u6f2c\u6f03\u6f06\u6f04\u6f0c\u6f18\u6f32\u6f02\u6f07\u6f05\u6ef7\u6f2e\u6f04\u6f33\u6f05\u6f18\u6f28\u6fda\u6f1c\u6f28\u6fda\u6efb\u6f16\u6efc\u6f15\u6f31\u6fec\u6f1a\u6f2e\u6f2e\u6fe6\u6efb\u6f0f\u6fee\u6fe7\u6f0b\u6f03\u6f10\u6f25\u6efa\u6f08\u6ef5\u6f01\u6ef8\u6f13\u6f22\u6fda\u6f0c\u6f0f\u6ef8\u6f2e\u6f21\u6efb\u6efb\u6fe7\u6f10\u6f2e\u6f0f\u6ef6\u6f12\u6ef9\u6fee\u6f25\u6f1b\u6f0e\u6fe6\u6f21\u6f05\u6f0f\u6fe7\u6f34\u6f2f\u6f12\u6ff2\u6f25\u6ef5\u6f01\u6f08\u6f25\u6f04\u6f0d\u6f08\u6f1a\u6fe6\u6f1c\u6fee\u6f0c\u6ff2\u6f0d\u6f05\u6efa\u6f23\u6f12\u6f07\u6f03\u6f22\u6f33\u6f0f\u6f1a\u6fe8\u6fee\u6f23\u6f19\u6f1c\u6f0f\u6f26\u6f2c\u6f07\u6ef7\u6f28\u6fee\u6fe6\u6f33\u6ef5\u6f07\u6fe6\u6ff3\u6f04\u6ff4\u6efa\u6f2e\u6f11\u6f19\u6f24\u6ef8\u6f31\u6ff3\u6ff3\u6ef6\u6fec\u6f2d\u6f2d\u6f04\u6fe7\u6ff3\u6ff2\u6fe5\u6ef5\u6f1c\u6f21\u6f2c\u6efa\u6f27\u6f16\u6f22\u6f2c\u6f33\u6efa\u6ef8\u6fda\u6fe7\u6f06\u6f28\u6ff3\u6f05\u6f2f\u6f31\u6f22\u6f02\u6ef9\u6f25\u6fe5\u6ef9\u6ef8\u6ff1\u6f22\u6f33\u6f2c\u6f0b\u6f1a\u6f1b\u6f0d\u6f08\u6f03\u6efc\u6f10\u6f25\u6fe8\u6f27\u6f07\u6f04\u6fec\u6f2c\u6f13\u6ef8\u6f0f\u6f23\u6f26\u6ff3\u6f13\u6f24\u6f04\u6f21\u6f06\u6f28\u6f1c\u6fed\u6f10\u6efa\u6f12\u6f19\u6fed\u6f12\u6f24\u6fec\u6f26\u6f30\u6ef8\u6f34\u6f15\u6f1b\u6f1b\u6f22\u6f34\u6f22\u6efc\u6f22\u6f11\u6ff4\u6f13\u6f22\u6f18\u6f34\u6f24\u6fe6\u6f2c\u6f04\u6ef6\u6fe7\u6f19\u6f2f\u6ff1\u6f25\u6f12\u6f06\u6f17\u6efa\u6fe7\u6fe6\u6fe5\u6f01\u6efb\u6f28\u6f18\u6f04\u6f05\u6f32\u6f26\u6f0f\u6f04\u6f22\u6ef8\u6f32\u6f2b\u6f1c\u6f26\u6fe6\u6f01\u6f21\u6f25\u6fec\u6f2c\u6f16\u6fe8\u6f0b\u6f0c\u6f10\u6f28\u6fe6\u6ff1\u6fec\u6ff2\u6f19\u6f26\u6f33\u6ff4\u6f03\u6f01\u6f07\u6fe8\u6f06\u6ff2\u6fda\u6f16\u6fe7\u6f32\u6f19\u6f1b\u6fe6\u6fe5\u6f0d\u6fed\u6f0e\u6f25\u6f23\u6f0f\u6f23\u6f32\u6f0b\u6fed\u6ef8\u6f14\u6f17\u6fed\u6f32\u6f08\u6f24\u6ff2\u6efb\u6f31\u6f11\u6f1b\u6efa\u6efb\u6ff4\u6f13\u6ef5\u6f1c\u6ef9\u6ef7\u6fed\u6f0d\u6f02\u6f0c\u6ff4\u6f08\u6ff1\u6fed\u6f25\u6ff4\u6f06\u6ef5\u6f18\u6f30\u6f28\u6ff4\u6f2c\u6f19\u6f31\u6f22\u6f34\u6f07\u6f1c\u6f21\u6f0e\u6ff3\u6f0c\u6f2d\u6f16\u6f0f\u6ef6\u6f30\u6f19\u6f2c\u6f16\u6f34\u6f0e\u6efb\u6f21\u6f27\u6fec\u6ff1\u6ef5\u6f2d\u6f2e\u6ef9\u6f0c\u6ef5\u6f28\u6ff2\u6f25\u6f03\u6ff1\u6ff1\u6fed\u6ff2\u6f32\u6f1a\u6f33\u6ff3\u6f01\u6f1c\u6f19\u6ef6\u6f31\u6f10\u6f24\u6f07\u6f11\u6f2c\u6f15\u6f0e\u6f06\u6fed\u6f23\u6efa\u6f31\u6ef6\u6f01\u6efa\u6f1c\u6f11\u6f24\u6f33\u6ff3\u6ff4\u6f22\u6f28\u6f17\u6f25\u6f08\u6f18\u6fee\u6f30\u6f34\u6f0d\u6efb\u6f01\u6f0c\u6f1c\u6ef7\u6f21\u6ff4\u6f34\u6f24\u6f32\u6f12\u6f26\u6f12\u6fec\u6f0f\u6f1a\u6fee\u6fe5\u6f1b\u6efc\u6f2f\u6f0f\u6f06\u6ef6\u6f0f\u6ff4\u6fec\u6f23\u6f32\u6fe8\u6f12\u6f1c\u6f08\u6f23\u6f0f\u6efa\u6ff2\u6f17\u6ff4\u6f33\u6f02\u6ff1\u6efc\u6fe6\u6f2d\u6ef9\u6f2b\u6ff2\u6f22\u6f32\u6f02\u6f16\u6f1a\u6f33\u6f12\u6fec\u6f0e\u6f11\u6f05\u6f32\u6fec\u6f03\u6fda\u6f25\u6fe7\u6f13\u6fe5\u6f28\u6f2e\u6efb\u6f05\u6ef7\u6f21\u6f2c\u6ff2\u6efc\u6f31\u6ef5\u6ff2\u6f30\u6ff3\u6fec\u6f33\u6f0f\u6f21\u6ef7\u6f34\u6f0f\u6fec\u6f2c\u6f25\u6fe6\u6f08\u6ef7\u6fed\u6f34\u6f26\u6ef7\u6f2e\u6fc0".toCharArray();
            for (int i2 = 0; i2 < 556; ++i2) {
                char c2 = cArray[i2];
                int n2 = c2 - 64384;
                int n3 = n2 - 11474;
                int n4 = n3 - 62627;
                int n5 = n4 ^ 0xD454;
                int n6 = n5 + 11397;
                int n7 = n6 + 34999;
                int n8 = n7 + 54684;
                int n9 = n8 + 62060;
                int n10 = n9 + 64189;
                int n11 = n10 - 50909;
                int n12 = n11 + 62239;
                int n13 = n12 ^ 0x2ADF;
                cArray[i2] = (char)n13;
            }
            object = zp.mth_0OOOoo00o0_30()[0] = new String(cArray);
        }
        objectArray[2] = (String)object;
        char[] cArray = ((String)zp.o0Oo000O0oO(objectArray)).toCharArray();
        int l19_hi = 387;
        int l21_lo = 0;
        while (true) {
            if (l21_lo >= l19_hi) {
                avR = new Pattern[]{Pattern.compile("\\bpacket\\s*log(?:ger)?\\b", 2), Pattern.compile("\\bpacket\\s*debug(?:ger)?\\b", 2), Pattern.compile("\\bdebug(?:ger)?\\b", 2), Pattern.compile("\\bverbose\\b", 2), Pattern.compile("\\balerts?\\b", 2), Pattern.compile("\\bproxy\\b|\\bmitm\\b|\\bmitmproxy\\b|\\bsniff(?:er|ing)?\\b", 2), Pattern.compile("\\bwireshark\\b|\\bburp\\b|\\bcharles\\b|\\bproxyman\\b", 2), Pattern.compile("\\bfrida\\b|\\bjdwp\\b|\\bjfr\\b|\\battach\\b|\\bjavaagent\\b|\\bagentlib\\b", 2), Pattern.compile("\\brecaf\\b|\\bdecompil(?:e|er|ing)\\b|\\bbytecode\\b|\\bhook(?:ing)?\\b|\\binject(?:ion|ing)?\\b", 2)};
                break clinit;
            }
            int l21_lo2 = l21_lo + 1;
            int l10_lo = cArray[l21_lo];
            int l21_lo3 = l21_lo2 + 1;
            int l11_hi = cArray[l21_lo2];
            int limit = l10_lo << 16 | l11_hi;
            char[] cArray2 = new char[limit];
            int i = 0;
            while (i < limit) {
                cArray2[i] = cArray[l21_lo3 + i];
                i++;
            }
            int n14 = l17_hi;
            l17_hi++;
            zp.o0Oo000O0oO[n14] = new String(cArray2);
            l21_lo = l21_lo3 + limit;
        }
        }
    }

    @Override
    public String getReason() {
        return "suschat";
    }
}
