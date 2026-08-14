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
    public static int[] O0OoOO0OOOOO;
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
        if (!string2.startsWith("/") || string2.contains((String)o0Oo000O0oO[0x5F ^ 0x5B])) {
            return;
        }
        if (avN.matcher(string2).matches()) {
            this.avA = true;
        }
    }

    @Override
    public String getReason() {
        return (String)o0Oo000O0oO[2];
    }

    public static void Oo0o00000O00() {
        O0OoOO0OOOOO = new int[399];
        zn.O0OoOO0OOOOO[114] = 61418;
        zn.O0OoOO0OOOOO[48] = 113;
        zn.O0OoOO0OOOOO[3] = 170;
        zn.O0OoOO0OOOOO[218] = 67326;
        zn.O0OoOO0OOOOO[221] = 5841;
        zn.O0OoOO0OOOOO[26] = 7717;
        zn.O0OoOO0OOOOO[275] = -45470;
        zn.O0OoOO0OOOOO[394] = 18808;
        zn.O0OoOO0OOOOO[308] = 21938;
        zn.O0OoOO0OOOOO[51] = 91;
        zn.O0OoOO0OOOOO[243] = 56014;
        zn.O0OoOO0OOOOO[21] = 0;
        zn.O0OoOO0OOOOO[129] = 36057;
        zn.O0OoOO0OOOOO[164] = -25754;
        zn.O0OoOO0OOOOO[171] = 22078;
        zn.O0OoOO0OOOOO[15] = -90;
        zn.O0OoOO0OOOOO[222] = 5837;
        zn.O0OoOO0OOOOO[248] = 8470;
        zn.O0OoOO0OOOOO[355] = 12;
        zn.O0OoOO0OOOOO[300] = 27268;
        zn.O0OoOO0OOOOO[282] = 7653;
        zn.O0OoOO0OOOOO[251] = -40242;
        zn.O0OoOO0OOOOO[80] = -67;
        zn.O0OoOO0OOOOO[75] = 65;
        zn.O0OoOO0OOOOO[367] = 49154;
        zn.O0OoOO0OOOOO[398] = 4;
        zn.O0OoOO0OOOOO[37] = 26809;
        zn.O0OoOO0OOOOO[166] = 3896;
        zn.O0OoOO0OOOOO[58] = 120;
        zn.O0OoOO0OOOOO[118] = 58929;
        zn.O0OoOO0OOOOO[325] = 1;
        zn.O0OoOO0OOOOO[364] = 47697;
        zn.O0OoOO0OOOOO[9] = -29;
        zn.O0OoOO0OOOOO[313] = 0;
        zn.O0OoOO0OOOOO[326] = 16;
        zn.O0OoOO0OOOOO[204] = 4289;
        zn.O0OoOO0OOOOO[289] = 21041;
        zn.O0OoOO0OOOOO[103] = -72;
        zn.O0OoOO0OOOOO[137] = 14290;
        zn.O0OoOO0OOOOO[393] = 61495;
        zn.O0OoOO0OOOOO[55] = 29;
        zn.O0OoOO0OOOOO[237] = 58174;
        zn.O0OoOO0OOOOO[380] = 3;
        zn.O0OoOO0OOOOO[203] = 4237;
        zn.O0OoOO0OOOOO[88] = -77;
        zn.O0OoOO0OOOOO[126] = 36050;
        zn.O0OoOO0OOOOO[78] = 109;
        zn.O0OoOO0OOOOO[117] = 61416;
        zn.O0OoOO0OOOOO[59] = -69;
        zn.O0OoOO0OOOOO[269] = 13848;
        zn.O0OoOO0OOOOO[249] = 40267;
        zn.O0OoOO0OOOOO[31] = 5841;
        zn.O0OoOO0OOOOO[261] = 18702;
        zn.O0OoOO0OOOOO[42] = -83;
        zn.O0OoOO0OOOOO[280] = 26422;
        zn.O0OoOO0OOOOO[200] = 64850;
        zn.O0OoOO0OOOOO[354] = 26;
        zn.O0OoOO0OOOOO[319] = 12647;
        zn.O0OoOO0OOOOO[99] = 102;
        zn.O0OoOO0OOOOO[386] = 62409;
        zn.O0OoOO0OOOOO[13] = 26;
        zn.O0OoOO0OOOOO[139] = 53617;
        zn.O0OoOO0OOOOO[392] = 20085;
        zn.O0OoOO0OOOOO[160] = 67739;
        zn.O0OoOO0OOOOO[66] = 48;
        zn.O0OoOO0OOOOO[373] = 35690;
        zn.O0OoOO0OOOOO[154] = 59723;
        zn.O0OoOO0OOOOO[79] = 6;
        zn.O0OoOO0OOOOO[324] = 4159;
        zn.O0OoOO0OOOOO[199] = 64879;
        zn.O0OoOO0OOOOO[260] = 49675;
        zn.O0OoOO0OOOOO[382] = 20;
        zn.O0OoOO0OOOOO[27] = 31273;
        zn.O0OoOO0OOOOO[150] = 41995;
        zn.O0OoOO0OOOOO[250] = 40257;
        zn.O0OoOO0OOOOO[121] = 58928;
        zn.O0OoOO0OOOOO[214] = 7639;
        zn.O0OoOO0OOOOO[336] = 46;
        zn.O0OoOO0OOOOO[65] = -24;
        zn.O0OoOO0OOOOO[284] = 7653;
        zn.O0OoOO0OOOOO[389] = 27568;
        zn.O0OoOO0OOOOO[101] = 34;
        zn.O0OoOO0OOOOO[151] = 41995;
        zn.O0OoOO0OOOOO[47] = -67;
        zn.O0OoOO0OOOOO[317] = 1843;
        zn.O0OoOO0OOOOO[50] = 20;
        zn.O0OoOO0OOOOO[273] = 45445;
        zn.O0OoOO0OOOOO[256] = 61014;
        zn.O0OoOO0OOOOO[0] = -9;
        zn.O0OoOO0OOOOO[135] = 14290;
        zn.O0OoOO0OOOOO[163] = 25846;
        zn.O0OoOO0OOOOO[109] = 1;
        zn.O0OoOO0OOOOO[292] = 21050;
        zn.O0OoOO0OOOOO[107] = 2;
        zn.O0OoOO0OOOOO[288] = 19111;
        zn.O0OoOO0OOOOO[104] = 67;
        zn.O0OoOO0OOOOO[82] = -77;
        zn.O0OoOO0OOOOO[54] = -77;
        zn.O0OoOO0OOOOO[18] = 3;
        zn.O0OoOO0OOOOO[67] = -72;
        zn.O0OoOO0OOOOO[181] = 14889;
        zn.O0OoOO0OOOOO[381] = 0;
        zn.O0OoOO0OOOOO[19] = 0;
        zn.O0OoOO0OOOOO[38] = 50394;
        zn.O0OoOO0OOOOO[342] = 48;
        zn.O0OoOO0OOOOO[73] = 103;
        zn.O0OoOO0OOOOO[146] = 16973;
        zn.O0OoOO0OOOOO[179] = 25309;
        zn.O0OoOO0OOOOO[267] = 62649;
        zn.O0OoOO0OOOOO[366] = 15650;
        zn.O0OoOO0OOOOO[339] = 4;
        zn.O0OoOO0OOOOO[133] = 9687;
        zn.O0OoOO0OOOOO[120] = 58993;
        zn.O0OoOO0OOOOO[287] = 19078;
        zn.O0OoOO0OOOOO[22] = 2;
        zn.O0OoOO0OOOOO[96] = -3;
        zn.O0OoOO0OOOOO[106] = 1;
        zn.O0OoOO0OOOOO[241] = 55998;
        zn.O0OoOO0OOOOO[363] = 3;
        zn.O0OoOO0OOOOO[170] = 22067;
        zn.O0OoOO0OOOOO[254] = 61014;
        zn.O0OoOO0OOOOO[212] = 68361;
        zn.O0OoOO0OOOOO[84] = -48;
        zn.O0OoOO0OOOOO[61] = 30;
        zn.O0OoOO0OOOOO[112] = 61612;
        zn.O0OoOO0OOOOO[76] = -15;
        zn.O0OoOO0OOOOO[63] = 3;
        zn.O0OoOO0OOOOO[41] = -121;
        zn.O0OoOO0OOOOO[11] = -28;
        zn.O0OoOO0OOOOO[33] = 41395;
        zn.O0OoOO0OOOOO[108] = 0;
        zn.O0OoOO0OOOOO[131] = 9687;
        zn.O0OoOO0OOOOO[387] = 9708;
        zn.O0OoOO0OOOOO[64] = 73;
        zn.O0OoOO0OOOOO[223] = -5821;
        zn.O0OoOO0OOOOO[350] = 30;
        zn.O0OoOO0OOOOO[189] = 46918;
        zn.O0OoOO0OOOOO[196] = 40832;
        zn.O0OoOO0OOOOO[274] = 45460;
        zn.O0OoOO0OOOOO[71] = -16;
        zn.O0OoOO0OOOOO[169] = 3899;
        zn.O0OoOO0OOOOO[6] = 93;
        zn.O0OoOO0OOOOO[23] = 0;
        zn.O0OoOO0OOOOO[379] = 16;
        zn.O0OoOO0OOOOO[14] = 29;
        zn.O0OoOO0OOOOO[332] = -13;
        zn.O0OoOO0OOOOO[29] = 53133;
        zn.O0OoOO0OOOOO[233] = 44489;
        zn.O0OoOO0OOOOO[98] = -83;
        zn.O0OoOO0OOOOO[334] = 11;
        zn.O0OoOO0OOOOO[306] = 21938;
        zn.O0OoOO0OOOOO[144] = -49617;
        zn.O0OoOO0OOOOO[365] = 6593;
        zn.O0OoOO0OOOOO[81] = 101;
        zn.O0OoOO0OOOOO[220] = 67326;
        zn.O0OoOO0OOOOO[128] = 36048;
        zn.O0OoOO0OOOOO[74] = 97;
        zn.O0OoOO0OOOOO[268] = 62705;
        zn.O0OoOO0OOOOO[295] = -49259;
        zn.O0OoOO0OOOOO[369] = 34932;
        zn.O0OoOO0OOOOO[359] = 11;
        zn.O0OoOO0OOOOO[376] = 2;
        zn.O0OoOO0OOOOO[307] = 21905;
        zn.O0OoOO0OOOOO[25] = 344;
        zn.O0OoOO0OOOOO[167] = 3899;
        zn.O0OoOO0OOOOO[155] = 59725;
        zn.O0OoOO0OOOOO[202] = 4289;
        zn.O0OoOO0OOOOO[91] = 63;
        zn.O0OoOO0OOOOO[10] = -3;
        zn.O0OoOO0OOOOO[305] = 21933;
        zn.O0OoOO0OOOOO[314] = 18;
        zn.O0OoOO0OOOOO[8] = 38;
        zn.O0OoOO0OOOOO[4] = -75;
        zn.O0OoOO0OOOOO[102] = -30;
        zn.O0OoOO0OOOOO[228] = 34443;
        zn.O0OoOO0OOOOO[246] = 8470;
        zn.O0OoOO0OOOOO[285] = 19125;
        zn.O0OoOO0OOOOO[184] = 14895;
        zn.O0OoOO0OOOOO[24] = 0;
        zn.O0OoOO0OOOOO[335] = 14;
        zn.O0OoOO0OOOOO[318] = 12660;
        zn.O0OoOO0OOOOO[368] = 38802;
        zn.O0OoOO0OOOOO[383] = 1667;
        zn.O0OoOO0OOOOO[310] = 0;
        zn.O0OoOO0OOOOO[253] = 61022;
        zn.O0OoOO0OOOOO[198] = 64850;
        zn.O0OoOO0OOOOO[343] = 15;
        zn.O0OoOO0OOOOO[266] = 62705;
        zn.O0OoOO0OOOOO[94] = 11;
        zn.O0OoOO0OOOOO[312] = 1;
        zn.O0OoOO0OOOOO[113] = 61628;
        zn.O0OoOO0OOOOO[53] = -74;
        zn.O0OoOO0OOOOO[36] = 8473;
        zn.O0OoOO0OOOOO[309] = 0;
        zn.O0OoOO0OOOOO[43] = 10;
        zn.O0OoOO0OOOOO[44] = 124;
        zn.O0OoOO0OOOOO[136] = 14296;
        zn.O0OoOO0OOOOO[209] = 68377;
        zn.O0OoOO0OOOOO[344] = -101;
        zn.O0OoOO0OOOOO[111] = 0;
        zn.O0OoOO0OOOOO[395] = 52638;
        zn.O0OoOO0OOOOO[226] = 34443;
        zn.O0OoOO0OOOOO[323] = 20445;
        zn.O0OoOO0OOOOO[259] = -49782;
        zn.O0OoOO0OOOOO[374] = 10250;
        zn.O0OoOO0OOOOO[263] = 18767;
        zn.O0OoOO0OOOOO[97] = -53;
        zn.O0OoOO0OOOOO[138] = 53622;
        zn.O0OoOO0OOOOO[258] = 49675;
        zn.O0OoOO0OOOOO[371] = 49367;
        zn.O0OoOO0OOOOO[40] = 0;
        zn.O0OoOO0OOOOO[330] = -92;
        zn.O0OoOO0OOOOO[191] = -46899;
        zn.O0OoOO0OOOOO[206] = 37497;
        zn.O0OoOO0OOOOO[384] = 39207;
        zn.O0OoOO0OOOOO[195] = 40926;
        zn.O0OoOO0OOOOO[252] = 40257;
        zn.O0OoOO0OOOOO[327] = 10;
        zn.O0OoOO0OOOOO[348] = -68;
        zn.O0OoOO0OOOOO[159] = 67818;
        zn.O0OoOO0OOOOO[192] = 46921;
        zn.O0OoOO0OOOOO[360] = 256;
        zn.O0OoOO0OOOOO[351] = 9;
        zn.O0OoOO0OOOOO[303] = -25726;
        zn.O0OoOO0OOOOO[187] = 63597;
        zn.O0OoOO0OOOOO[2] = -32;
        zn.O0OoOO0OOOOO[286] = 19111;
        zn.O0OoOO0OOOOO[271] = -13835;
        zn.O0OoOO0OOOOO[349] = 2;
        zn.O0OoOO0OOOOO[358] = -40;
        zn.O0OoOO0OOOOO[238] = 58163;
        zn.O0OoOO0OOOOO[264] = 18688;
        zn.O0OoOO0OOOOO[281] = 7677;
        zn.O0OoOO0OOOOO[70] = -120;
        zn.O0OoOO0OOOOO[83] = 67;
        zn.O0OoOO0OOOOO[168] = -3956;
        zn.O0OoOO0OOOOO[141] = 53617;
        zn.O0OoOO0OOOOO[52] = 110;
        zn.O0OoOO0OOOOO[46] = 89;
        zn.O0OoOO0OOOOO[174] = 69405;
        zn.O0OoOO0OOOOO[234] = 44493;
        zn.O0OoOO0OOOOO[86] = -73;
        zn.O0OoOO0OOOOO[247] = -8570;
        zn.O0OoOO0OOOOO[244] = 55995;
        zn.O0OoOO0OOOOO[140] = 53574;
        zn.O0OoOO0OOOOO[211] = 68372;
        zn.O0OoOO0OOOOO[346] = 49;
        zn.O0OoOO0OOOOO[197] = 64859;
        zn.O0OoOO0OOOOO[69] = 117;
        zn.O0OoOO0OOOOO[353] = 13;
        zn.O0OoOO0OOOOO[207] = -37484;
        zn.O0OoOO0OOOOO[156] = 59722;
        zn.O0OoOO0OOOOO[361] = 2;
        zn.O0OoOO0OOOOO[338] = 40;
        zn.O0OoOO0OOOOO[172] = -22042;
        zn.O0OoOO0OOOOO[230] = 61321;
        zn.O0OoOO0OOOOO[5] = 91;
        zn.O0OoOO0OOOOO[217] = 67299;
        zn.O0OoOO0OOOOO[347] = 1;
        zn.O0OoOO0OOOOO[116] = 61327;
        zn.O0OoOO0OOOOO[345] = 5;
        zn.O0OoOO0OOOOO[388] = 43087;
        zn.O0OoOO0OOOOO[276] = 45460;
        zn.O0OoOO0OOOOO[157] = 59725;
        zn.O0OoOO0OOOOO[272] = 13837;
        zn.O0OoOO0OOOOO[231] = -61363;
        zn.O0OoOO0OOOOO[340] = -126;
        zn.O0OoOO0OOOOO[16] = -97;
        zn.O0OoOO0OOOOO[145] = 49571;
        zn.O0OoOO0OOOOO[57] = -67;
        zn.O0OoOO0OOOOO[158] = 67810;
        zn.O0OoOO0OOOOO[177] = 69400;
        zn.O0OoOO0OOOOO[242] = 55995;
        zn.O0OoOO0OOOOO[152] = 42055;
        zn.O0OoOO0OOOOO[194] = 40832;
        zn.O0OoOO0OOOOO[93] = 4;
        zn.O0OoOO0OOOOO[328] = 12;
        zn.O0OoOO0OOOOO[216] = 7639;
        zn.O0OoOO0OOOOO[298] = 27268;
        zn.O0OoOO0OOOOO[293] = 49247;
        zn.O0OoOO0OOOOO[85] = 131;
        zn.O0OoOO0OOOOO[186] = 63516;
        zn.O0OoOO0OOOOO[391] = 48753;
        zn.O0OoOO0OOOOO[299] = 27380;
        zn.O0OoOO0OOOOO[190] = 46921;
        zn.O0OoOO0OOOOO[28] = 48682;
        zn.O0OoOO0OOOOO[377] = 0;
        zn.O0OoOO0OOOOO[90] = 104;
        zn.O0OoOO0OOOOO[257] = 49675;
        zn.O0OoOO0OOOOO[193] = 40844;
        zn.O0OoOO0OOOOO[35] = 1944;
        zn.O0OoOO0OOOOO[62] = 108;
        zn.O0OoOO0OOOOO[12] = 60;
        zn.O0OoOO0OOOOO[396] = 3;
        zn.O0OoOO0OOOOO[315] = 36193;
        zn.O0OoOO0OOOOO[161] = 67818;
        zn.O0OoOO0OOOOO[245] = 8448;
        zn.O0OoOO0OOOOO[110] = 1;
        zn.O0OoOO0OOOOO[225] = 34449;
        zn.O0OoOO0OOOOO[378] = 16;
        zn.O0OoOO0OOOOO[329] = 3;
        zn.O0OoOO0OOOOO[72] = -71;
        zn.O0OoOO0OOOOO[224] = 5837;
        zn.O0OoOO0OOOOO[362] = 0;
        zn.O0OoOO0OOOOO[331] = 0;
        zn.O0OoOO0OOOOO[175] = 69400;
        zn.O0OoOO0OOOOO[87] = 26;
        zn.O0OoOO0OOOOO[322] = 26667;
        zn.O0OoOO0OOOOO[255] = -60979;
        zn.O0OoOO0OOOOO[34] = 56245;
        zn.O0OoOO0OOOOO[30] = 47665;
        zn.O0OoOO0OOOOO[77] = 92;
        zn.O0OoOO0OOOOO[279] = -26393;
        zn.O0OoOO0OOOOO[182] = 14895;
        zn.O0OoOO0OOOOO[236] = 44493;
        zn.O0OoOO0OOOOO[270] = 13837;
        zn.O0OoOO0OOOOO[210] = 68361;
        zn.O0OoOO0OOOOO[124] = 56162;
        zn.O0OoOO0OOOOO[321] = 14424;
        zn.O0OoOO0OOOOO[375] = 63710;
        zn.O0OoOO0OOOOO[92] = -35;
        zn.O0OoOO0OOOOO[205] = 37496;
        zn.O0OoOO0OOOOO[89] = -5;
        zn.O0OoOO0OOOOO[95] = 18;
        zn.O0OoOO0OOOOO[130] = 9693;
        zn.O0OoOO0OOOOO[185] = 63490;
        zn.O0OoOO0OOOOO[283] = -7650;
        zn.O0OoOO0OOOOO[127] = 36057;
        zn.O0OoOO0OOOOO[134] = 14299;
        zn.O0OoOO0OOOOO[372] = 20105;
        zn.O0OoOO0OOOOO[162] = 25848;
        zn.O0OoOO0OOOOO[149] = 16961;
        zn.O0OoOO0OOOOO[183] = 14954;
        zn.O0OoOO0OOOOO[385] = 7272;
        zn.O0OoOO0OOOOO[294] = 49245;
        zn.O0OoOO0OOOOO[240] = 58163;
        zn.O0OoOO0OOOOO[180] = 25341;
        zn.O0OoOO0OOOOO[115] = 61416;
        zn.O0OoOO0OOOOO[390] = 31248;
        zn.O0OoOO0OOOOO[297] = 27267;
        zn.O0OoOO0OOOOO[333] = 7;
        zn.O0OoOO0OOOOO[352] = 107;
        zn.O0OoOO0OOOOO[337] = 11;
        zn.O0OoOO0OOOOO[356] = 59;
        zn.O0OoOO0OOOOO[165] = 25846;
        zn.O0OoOO0OOOOO[208] = 37497;
        zn.O0OoOO0OOOOO[213] = 7620;
        zn.O0OoOO0OOOOO[232] = 61321;
        zn.O0OoOO0OOOOO[397] = 2;
        zn.O0OoOO0OOOOO[7] = 54;
        zn.O0OoOO0OOOOO[17] = 25;
        zn.O0OoOO0OOOOO[105] = -7;
        zn.O0OoOO0OOOOO[201] = 4310;
        zn.O0OoOO0OOOOO[235] = 44423;
        zn.O0OoOO0OOOOO[304] = 25625;
        zn.O0OoOO0OOOOO[60] = -100;
        zn.O0OoOO0OOOOO[68] = 237;
        zn.O0OoOO0OOOOO[56] = -27;
        zn.O0OoOO0OOOOO[148] = 16990;
        zn.O0OoOO0OOOOO[20] = 1;
        zn.O0OoOO0OOOOO[123] = 56090;
        zn.O0OoOO0OOOOO[301] = 25613;
        zn.O0OoOO0OOOOO[45] = -69;
        zn.O0OoOO0OOOOO[277] = 26413;
        zn.O0OoOO0OOOOO[357] = 8;
        zn.O0OoOO0OOOOO[176] = 69491;
        zn.O0OoOO0OOOOO[316] = 44179;
        zn.O0OoOO0OOOOO[178] = 0;
        zn.O0OoOO0OOOOO[119] = 58928;
        zn.O0OoOO0OOOOO[311] = 0;
        zn.O0OoOO0OOOOO[239] = 58133;
        zn.O0OoOO0OOOOO[142] = 49575;
        zn.O0OoOO0OOOOO[125] = 56090;
        zn.O0OoOO0OOOOO[291] = 21096;
        zn.O0OoOO0OOOOO[143] = 49571;
        zn.O0OoOO0OOOOO[215] = 7636;
        zn.O0OoOO0OOOOO[100] = -61;
        zn.O0OoOO0OOOOO[229] = 61322;
        zn.O0OoOO0OOOOO[153] = 41995;
        zn.O0OoOO0OOOOO[290] = 21050;
        zn.O0OoOO0OOOOO[147] = 16961;
        zn.O0OoOO0OOOOO[320] = 32311;
        zn.O0OoOO0OOOOO[296] = 49245;
        zn.O0OoOO0OOOOO[173] = 22078;
        zn.O0OoOO0OOOOO[262] = 18688;
        zn.O0OoOO0OOOOO[278] = 26422;
        zn.O0OoOO0OOOOO[32] = 46355;
        zn.O0OoOO0OOOOO[302] = 25625;
        zn.O0OoOO0OOOOO[370] = 38791;
        zn.O0OoOO0OOOOO[188] = 63516;
        zn.O0OoOO0OOOOO[132] = 9701;
        zn.O0OoOO0OOOOO[227] = -34459;
        zn.O0OoOO0OOOOO[49] = 84;
        zn.O0OoOO0OOOOO[219] = -67247;
        zn.O0OoOO0OOOOO[265] = 62696;
        zn.O0OoOO0OOOOO[39] = 54202;
        zn.O0OoOO0OOOOO[341] = 6;
        zn.O0OoOO0OOOOO[122] = 56085;
        zn.O0OoOO0OOOOO[1] = 22;
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
        zn.Oo0o00000O00();
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
                avN = Pattern.compile((String)o0Oo000O0oO[0] + (String)o0Oo000O0oO[3], 2);
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
