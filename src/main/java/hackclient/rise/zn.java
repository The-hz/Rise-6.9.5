package hackclient.rise;

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

public class zn
extends SecurityFeature
implements zh {
    public static Object[] fld_0OOOoo00o0_61;
    public static Object[] o0Oo000O0oO;
    public static Object[] fld_0oOOoOo0O00O_62;
    public static Object[] oO00O0OO0ooO;
    public volatile boolean avA;
    public static Pattern avN;
    public static Object Oo0o00000O00;

    @Override
    public boolean nG() {
        return this.avA;
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
                    fld_0OOOoo00o0_61 = objectArray4;
                    objectArray3 = objectArray4;
                    byte[] byArray = new byte[16];
                    byArray[2] = 103;
                    byArray[1] = 65;
                    byArray[15] = 120;
                    byArray[11] = 9;
                    byArray[10] = 50;
                    byArray[9] = 10;
                    byArray[7] = 55;
                    byArray[4] = -116;
                    byArray[12] = 31;
                    byArray[0] = 76;
                    byArray[6] = 7;
                    byArray[8] = 113;
                    byArray[14] = -112;
                    byArray[3] = -73;
                    byArray[13] = -40;
                    byArray[5] = 107;
                    objectArray4[0] = byArray;
                }
                byte[] byArray = (byte[])objectArray3[0];
                if (Oo0o00000O00 == null) {
                    byte[] byArray2 = new byte[32];
                    byArray2[6] = 69;
                    byArray2[30] = 113;
                    byArray2[15] = -124;
                    byArray2[12] = 94;
                    byArray2[9] = 61;
                    byArray2[23] = 76;
                    byArray2[1] = -19;
                    byArray2[16] = 29;
                    byArray2[19] = 3;
                    byArray2[29] = -81;
                    byArray2[28] = -114;
                    byArray2[26] = -18;
                    byArray2[3] = -60;
                    byArray2[4] = 74;
                    byArray2[13] = 38;
                    byArray2[5] = 117;
                    byArray2[22] = -112;
                    byArray2[10] = -113;
                    byArray2[8] = -101;
                    byArray2[0] = -127;
                    byArray2[14] = 79;
                    byArray2[25] = 72;
                    byArray2[21] = -8;
                    byArray2[17] = -10;
                    byArray2[27] = -47;
                    byArray2[24] = -5;
                    byArray2[18] = 33;
                    byArray2[11] = 82;
                    byArray2[2] = -56;
                    byArray2[7] = 112;
                    byArray2[20] = -101;
                    byArray2[31] = 35;
                    byte[] byArray3 = new byte[byArray.length + byArray2.length];
                    System.arraycopy(byArray, 0, byArray3, 0, byArray.length);
                    System.arraycopy(byArray2, 0, byArray3, byArray.length, byArray2.length);
                    Object object3 = zn.mth_0OOOoo00o0_28()[1];
                    if (object3 == null) {
                        char[] cArray = "\u0d5c\u08aa\u0d43\u08a8\u08a6\u08ba\u0d57\u0d7d\u0d78\u0844\u08a4\u0d79\u0845\u084b\u0d5b\u08a4\u08a5\u08b5".toCharArray();
                        for (int i2 = 0; i2 < 18; ++i2) {
                            char c2 = cArray[i2];
                            int n3 = c2 ^ 0x8D61;
                            int n4 = n3 ^ 0xAC93;
                            int n5 = n4 - 1843;
                            int n6 = n5 ^ 0x3174;
                            int n7 = n6 - 12647;
                            int n8 = n7 + 32311;
                            int n9 = n8 ^ 0x3858;
                            int n10 = n9 + 26667;
                            int n11 = n10 + 20445;
                            int n12 = n11 - 4159;
                            cArray[i2] = (char)n12;
                        }
                        object3 = zn.mth_0OOOoo00o0_28()[1] = new String(cArray);
                    }
                    SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance((String)object3);
                    byte[] byArray4 = new byte[16];
                    byArray4[10] = 12;
                    byArray4[3] = -92;
                    byArray4[0] = -13;
                    byArray4[7] = 11;
                    byArray4[14] = 46;
                    byArray4[11] = 40;
                    byArray4[4] = -126;
                    byArray4[6] = 48;
                    byArray4[15] = -101;
                    byArray4[5] = 49;
                    byArray4[1] = -68;
                    byArray4[2] = 30;
                    byArray4[9] = 107;
                    byArray4[13] = 26;
                    byArray4[12] = 59;
                    byArray4[8] = -40;
                    PBEKeySpec pBEKeySpec = new PBEKeySpec(new String(byArray3, StandardCharsets.UTF_8).toCharArray(), byArray4, 11, 256);
                    byte[] byArray5 = secretKeyFactory.generateSecret(pBEKeySpec).getEncoded();
                    Object object4 = zn.mth_0OOOoo00o0_28()[2];
                    if (object4 == null) {
                        char[] cArray = "\ufdca\ufdc6\ufdec".toCharArray();
                        for (int i3 = 0; i3 < 3; ++i3) {
                            char c3 = cArray[i3];
                            int n13 = c3 + 47697;
                            int n14 = n13 ^ 0x19C1;
                            int n15 = n14 ^ 0x3D22;
                            int n16 = n15 - 49154;
                            int n17 = n16 ^ 0x9792;
                            int n18 = n17 + 34932;
                            int n19 = n18 + 38791;
                            int n20 = n19 - 49367;
                            int n21 = n20 - 20105;
                            int n22 = n21 ^ 0x8B6A;
                            int n23 = n22 + 10250;
                            int n24 = n23 ^ 0xF8DE;
                            cArray[i3] = (char)n24;
                        }
                        object4 = zn.mth_0OOOoo00o0_28()[2] = new String(cArray);
                    }
                    Oo0o00000O00 = new SecretKeySpec(byArray5, (String)object4);
                }
                byte[] byArray6 = Base64.getDecoder().decode(string);
                byte[] byArray7 = Arrays.copyOfRange(byArray6, 0, 16);
                byte[] byArray8 = Arrays.copyOfRange(byArray6, 16, byArray6.length);
                Object object5 = zn.mth_0OOOoo00o0_28()[3];
                if (object5 == null) {
                    char[] cArray = "\uecee\uecf2\uece0\uec3c\uecf0\uecf7\uecf0\uec3c\uecdd\uecd8\uecf0\uece0\uec42\uecdd\uec0e\uec11\uec11\uec16\uec03\uec14".toCharArray();
                    for (int i4 = 0; i4 < 20; ++i4) {
                        char c4 = cArray[i4];
                        int n25 = c4 ^ 0x683;
                        int n26 = n25 + 39207;
                        int n27 = n26 ^ 0x1C68;
                        int n28 = n27 ^ 0xF3C9;
                        int n29 = n28 ^ 0x25EC;
                        int n30 = n29 - 43087;
                        int n31 = n30 + 27568;
                        int n32 = n31 + 31248;
                        int n33 = n32 + 48753;
                        int n34 = n33 + 20085;
                        int n35 = n34 + 61495;
                        int n36 = n35 + 18808;
                        int n37 = n36 ^ 0xCD9E;
                        cArray[i4] = (char)n37;
                    }
                    object5 = zn.mth_0OOOoo00o0_28()[3] = new String(cArray);
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
    public void ar(String string) {
        if (string == null) return;
        if (this.avA) {
            return;
        }
        String string2 = string.trim().toLowerCase(Locale.ENGLISH);
        if (!string2.startsWith("/") || string2.contains(" ")) {
            return;
        }
        if (avN.matcher(string2).matches()) {
            this.avA = true;
        }
    }

    @Override
    public String getReason() {
        return "accommand";
    }


    public static Object[] mth_0OOOoo00o0_28() {
        Object[] objectArray = fld_0oOOoOo0O00O_62;
        if (fld_0oOOoOo0O00O_62 == null) {
            fld_0oOOoOo0O00O_62 = new Object[4];
            objectArray = fld_0oOOoOo0O00O_62;
        }
        return objectArray;
    }

    static {
        clinit: {
        long l9 = 2364201132449480976L;
        long l10 = -5346471382093092380L;
        long l11 = 5870921969992954931L;
        long l12 = -661853185985020065L;
        long l13 = -8349644040828007420L;
        long l14 = 7639139928974340856L;
        long l15 = 8553931662828788126L;
        o0Oo000O0oO = new Object[5];
        long l16 = l15;
        long l17 = l16 ^ (0L ^ l16) & -1L << 32;
        Object[] objectArray = new Object[3];
        objectArray[0] = fld_0OOOoo00o0_61;
        objectArray[1] = 0;
        Object object = zn.mth_0OOOoo00o0_28()[0];
        if (object == null) {
            char[] cArray = "\ufcd3\ufc21\ufa39\ufa42\ufa41\ufc20\ufaa4\ufc1c\ufbf9\ufa39\ufc04\ufa45\ufa3d\ufbf4\ufbfc\ufa48\ufc09\ufbf6\ufa45\ufc0a\ufbfa\ufa40\ufbf4\ufa13\ufc20\ufc00\ufbfc\ufcd3\ufa3d\ufc28\ufc1d\ufc04\ufa41\ufa41\ufbf9\ufc25\ufc20\ufcef\ufa48\ufc1d\ufc19\ufa3f\ufa48\ufa40\ufc00\ufc1e\ufbff\ufced\ufbfb\ufc0c\ufc1a\ufced\ufc0a\ufa39\ufc0e\ufa41\ufc0d\ufa14\ufc21\ufa40\ufa45\ufbfa\ufc25\ufbfb\ufa48\ufaa3\ufce9\ufa31\ufcea\ufc20\ufa3c\ufcec\ufcf0\ufc19\ufaa4\ufcf0\ufc0c\ufa3b\ufbf3\ufc10\ufc0c\ufc0d\ufcd3\ufa48\ufc09\ufc20\ufc0e\ufa3b\ufce9\ufcec\ufcee\ufa3c\ufbff\ufc19\ufc1a\ufa14\ufc27\ufcec\ufc10\ufc0e\ufa3a\ufa3c\ufc1d\ufc0f\ufa3a\ufc28\ufcf1\ufc27\ufc1b\ufc27\ufaa3\ufcef\ufc11\ufc09\ufc1a\ufbfc\ufa45\ufc1b\ufa45\ufc21\ufa31\ufc22\ufbf6\ufced\ufcd3\ufc10\ufbff\ufcee\ufa3f\ufc22\ufc16\ufa3f\ufa39\ufa39\ufce9\ufa3c\ufa47\ufc16\ufcee\ufc22\ufcef\ufc0e\ufbfd\ufcec\ufa39\ufc11\ufcea\ufbfa\ufa3f\ufbf4\ufc0c\ufced\ufc16\ufbf4\ufbf3\ufbfa\ufa3e\ufc00\ufbf6\ufcea\ufc09\ufc1a\ufc19\ufc21\ufc28\ufce9\ufc04\ufc09\ufc1c\ufc1a\ufc0a\ufa3c\ufc1d\ufc1f\ufc28\ufbff\ufc0f\ufc11\ufbfc\ufaa3\ufc03\ufa39\ufa47\ufbfa\ufc16\ufcf1\ufcea\ufc1b\ufa45\ufc21\ufc27\ufbfb\ufce9\ufc27\ufc10\ufa41\ufa3e\ufcef\ufa14\ufbfb\ufc25\ufbf3\ufc19\ufc0a\ufa31\ufa42\ufc11\ufbf3\ufc07\ufced\ufa3e\ufa14\ufbf9\ufc0e\ufa48\ufc00\ufcec\ufc21\ufc19\ufa13\ufc22\ufa42\ufa2e\ufbfd\ufc1e\ufa45\ufc19\ufc16\ufcec\ufbf9\ufc0e\ufcf0\ufbff\ufc09\ufc1e\ufce9\ufc1f\ufc0e\ufa36\ufc1a\ufa39\ufbfa\ufbf3\ufa3a\ufc0a\ufc04\ufbff\ufcd3\ufc0a\ufa48\ufa2e\ufa36\ufc20\ufc0c\ufbfb\ufa3b\ufa39\ufcf0\ufc10\ufc20\ufc1f\ufa41\ufc22\ufa13\ufbf4\ufcec\ufced\ufc1e\ufc20\ufcd3\ufbfa\ufbf3\ufa13\ufbfb\ufa3b\ufc0c\ufc1d\ufc10\ufbf6\ufa2e\ufc10\ufbf4\ufc10\ufc09\ufbfb\ufa48\ufc28\ufcee\ufa48\ufc1c\ufbf9\ufbff\ufa41\ufc21\ufbf9\ufc0f\ufa3b\ufa48\ufaa3\ufcd3\ufc0f\ufbff\ufc1d\ufcea\ufcf1\ufc03\ufc0c\ufc19\ufcef\ufbfa\ufc10\ufc20\ufce9\ufbfa\ufa45\ufaa3\ufc04\ufa3b\ufbff\ufa3e\ufcd3\ufc11\ufcf1\ufcea\ufc10\ufc19\ufc1e\ufbf4\ufc00\ufbf9\ufcf0\ufcec\ufc04\ufbfa\ufbff\ufbf6\ufa45\ufc27\ufa39\ufbf6\ufc1a\ufa13\ufbf5\ufbf5".toCharArray();
            for (int i2 = 0; i2 < 344; ++i2) {
                char c2 = cArray[i2];
                int n2 = c2 - 7717;
                int n3 = n2 + 31273;
                int n4 = n3 - 48682;
                int n5 = n4 - 53133;
                int n6 = n5 ^ 0xBA31;
                int n7 = n6 + 5841;
                int n8 = n7 - 46355;
                int n9 = n8 ^ 0xA1B3;
                int n10 = n9 + 56245;
                int n11 = n10 + 1944;
                int n12 = n11 ^ 0x2119;
                int n13 = n12 - 26809;
                int n14 = n13 + 50394;
                int n15 = n14 - 54202;
                cArray[i2] = (char)n15;
            }
            object = zn.mth_0OOOoo00o0_28()[0] = new String(cArray);
        }
        objectArray[2] = (String)object;
        char[] cArray = ((String)zn.o0Oo000O0oO(objectArray)).toCharArray();
        long l18 = l9;
        long l19 = l18 ^ (0xE200000000L ^ l18) & -1L << 32;
        long l20 = l13;
        long l21 = l20 ^ (0L ^ l20) & -1L >>> 32;
        boolean bl3 = true;
        char[] cArray2 = null;
        long l22 = 0L;
        while (true) {
            if (!bl3 || (bl3 = false) || !true) {
                if ((int)(l14 >>> 32) < (int)l12) {
                    cArray2[(int)(l14 >>> 32)] = cArray[(int)l22 + (int)(l14 >>> 32)];
                    l14 += 0x100000000L;
                    continue;
                }
                int n16 = (int)(l17 >>> 32);
                l17 += 0x100000000L;
                zn.o0Oo000O0oO[n16] = new String(cArray2);
                long l23 = l22;
                l21 = l23 ^ ((long)((int)l22 + (int)l12) ^ l23) & -1L >>> 32;
            }
            if ((int)l21 >= (int)(l19 >>> 32)) {
                avN = Pattern.compile("^/(?:ac[a-z]+|verus[a-z]*|grim[a-z]*|vulcan[a-z]*|alerts?[a-z]*|verbose[a-z]*|watchdog[a-z]*|anticheat[a-z]*|ncp[a-z]*|aac[a-z]*|karhu[a-z]*|matrix[a-z]*|spartan[a-z]*|intave[a-z]*|polar[a-z]*|hawk[a-z]*)$", 2);
                break clinit;
            }
            long l24 = l21;
            long l25 = l24 ^ (l24 ^ l24 + (long)1) & -1L >>> 32;
            long l26 = l10;
            l10 = l26 ^ ((long)cArray[(int)l21] ^ l26) & -1L >>> 32;
            long l27 = l25;
            l22 = l27 ^ (l27 ^ l27 + (long)(-69 - -100 ^ 0x1E)) & -1L >>> 32;
            long l28 = l11;
            l11 = l28 ^ ((long)cArray[(int)l25] << 32 ^ l28) & -1L << 32;
            long l29 = l12;
            l12 = l29 ^ ((long)((int)l10 << 16 | (int)(l11 >>> 32)) ^ l29) & -1L >>> 32;
            cArray2 = new char[(int)l12];
            long l30 = l14;
            l14 = l30 ^ (0L ^ l30) & -1L << 32;
        }
        }
    }
}
