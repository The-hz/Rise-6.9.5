package com.alan.clients;

import com.alan.clients.command.Command;
import com.alan.clients.command.CommandManager;
import com.alan.clients.component.Component;
import com.alan.clients.component.ComponentManager;
import com.alan.clients.module.Module;
import com.alan.clients.module.api.manager.ModuleManager;
import com.alan.clients.newevent.Event;
import com.alan.clients.newevent.bus.impl.EventBus;
import com.alan.clients.script.ScriptManager;
import com.alan.clients.security.NativeDecryptor;
import com.alan.clients.security.SecurityFeature;
import com.alan.clients.security.SecurityFeatureManager;
import com.alan.clients.ui.click.standard.RiseClickGUI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.florianmichael.viamcp.ViaMCP;
import hackclient.rise.aal;
import hackclient.rise.aba;
import hackclient.rise.abs;
import hackclient.rise.adu;
import hackclient.rise.aeg;
import hackclient.rise.afr;
import hackclient.rise.afv;
import hackclient.rise.afx;
import hackclient.rise.afz;
import hackclient.rise.aga;
import hackclient.rise.agb;
import hackclient.rise.ahc;
import hackclient.rise.b;
import hackclient.rise.dg;
import hackclient.rise.gf;
import hackclient.rise.q;
import hackclient.rise.r;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Arrays;
import java.util.Base64;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import lombok.Generated;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;

public enum Client
{
    a;
    public static String f;
    public static String b;
    public Gson K;
    public static boolean i;
    public static String e;
    public static Object[] fld_0oOOoOo0O00O_0;
    public EventBus<Event> eventBus;
    public aba I;
    public ComponentManager componentManager;
    public static String g;
    public aal n;
    public static Object[] oO00O0OO0ooO;
    public static Object[] fld_0OOOoo00o0_1;
    public static Object[] o0Oo000O0oO;
    public q F;
    public ScriptManager scriptManager;
    public static String d;
    public afv C;
    public static String c;
    public static boolean j;
    public ModuleManager moduleManager;
    public SecurityFeatureManager securityManager;
    public agb D;
    public RiseClickGUI standardClickGUI;
    public adu t;
    public CommandManager commandManager;
    public afr A;
    public r s;
    public static int[] O0OoOO0OOOOO;
    public ExecutorService executor;
    public afz v;
    public static Object Oo0o00000O00;
    public dg J;
    public gf G;
    public afx B;
    public static Client[] $VALUES;


    public b w;
    public static boolean h;
    public ahc l;
    public com.alan.clients.security.b r;

    @Generated
    public void a(final ScriptManager scriptManager) {
        this.scriptManager = scriptManager;
    }

    @Generated
    public void a(final RiseClickGUI standardClickGUI) {
        this.standardClickGUI = standardClickGUI;
    }

    @Generated
    public com.alan.clients.security.b j() {
        return this.r;
    }

    @Generated
    public r x() {
        return this.s;
    }

    @Generated
    public ModuleManager g() {
        return this.moduleManager;
    }

    public static Object o0Oo000O0oO(final Object[] array) {
        try {
            final int intValue = (int)array[1];
            final String s = (String)array[2];
            final Object o = array[0];
            Object[] oo00O0OO0ooO;
            if ((oo00O0OO0ooO = Client.oO00O0OO0ooO) == null) {
                oo00O0OO0ooO = (Client.oO00O0OO0ooO = new Object[] { null });
            }
            Object o2;
            if ((o2 = oo00O0OO0ooO[intValue]) == null) {
                Object[] array2;
                if ((array2 = (Object[])o) == null) {
                    final Object[] array3 = Client.fld_0OOOoo00o0_1 = (array2 = new Object[] { null });
                    final int n = 0;
                    final byte[] array4 = new byte[16];
                    array4[13] = 6;
                    array4[1] = 48;
                    array4[6] = -79;
                    array4[15] = -101;
                    array4[12] = 63;
                    array4[10] = 72;
                    array4[5] = 119;
                    array4[11] = 61;
                    array4[4] = -3;
                    array4[14] = 52;
                    array4[7] = 6;
                    array4[3] = 98;
                    array4[0] = -71;
                    array4[2] = 77;
                    array4[8] = 78;
                    array4[9] = -10;
                    array3[n] = array4;
                }
                final byte[] array5 = (byte[])array2[0];
                if (Client.Oo0o00000O00 == null) {
                    final byte[] array6 = new byte[32];
                    array6[4] = 17;
                    array6[29] = 110;
                    array6[22] = -73;
                    array6[31] = 20;
                    array6[7] = 47;
                    array6[0] = 85;
                    array6[3] = 24;
                    array6[5] = 63;
                    array6[25] = 48;
                    array6[20] = -24;
                    array6[19] = 7;
                    array6[9] = -82;
                    array6[17] = 91;
                    array6[1] = 0;
                    array6[11] = -92;
                    array6[15] = 104;
                    array6[13] = 111;
                    array6[21] = -76;
                    array6[14] = -50;
                    array6[10] = 7;
                    array6[16] = -128;
                    array6[26] = 40;
                    array6[24] = 33;
                    array6[30] = 11;
                    array6[2] = 93;
                    array6[6] = -44;
                    array6[27] = 46;
                    array6[28] = 97;
                    array6[23] = 18;
                    array6[12] = 19;
                    array6[18] = 22;
                    array6[8] = 35;
                    final byte[] array7 = new byte[array5.length + array6.length];
                    System.arraycopy(array5, 0, array7, 0, array5.length);
                    System.arraycopy(array6, 0, array7, array5.length, array6.length);
                    Object o3;
                    if ((o3 = mth_0OOOoo00o0_0()[1]) == null) {
                        final char[] charArray = "\u3b24\u3b36\u3b2d\u3b38\u3d0a\u3e46\u3b39\u3d13\u3d08\u3cec\u3d0c\u3d07\u3d1b\u3d15\u3b25\u3d0c\u3b3b\u3e4b".toCharArray();
                        for (int i = 0; i < 18; ++i) {
                            charArray[i] = (char)((((charArray[i] + '\u58e2' - 34819 ^ 0x6328 ^ 0xB5EA) - 65484 + 60430 ^ 0x19AF) - 6321 - 57076 ^ 0x2894) + 437 - 47957 + 48278 - 53817);
                        }
                        o3 = (mth_0OOOoo00o0_0()[1] = new String(charArray));
                    }
                    final SecretKeyFactory instance = SecretKeyFactory.getInstance((String)o3);
                    final byte[] array8 = new byte[16];
                    array8[7] = -4;
                    array8[5] = 25;
                    array8[11] = 28;
                    array8[1] = -49;
                    array8[6] = -65;
                    array8[0] = -36;
                    array8[4] = -92;
                    array8[14] = 14;
                    array8[13] = -32;
                    array8[3] = 41;
                    array8[15] = 91;
                    array8[8] = -126;
                    array8[2] = -94;
                    array8[9] = -18;
                    array8[12] = 12;
                    array8[10] = -92;
                    final byte[] key = instance.generateSecret(new PBEKeySpec(new String(array7, StandardCharsets.UTF_8).toCharArray(), array8, 18, 256)).getEncoded();
                    Object o4;
                    if ((o4 = mth_0OOOoo00o0_0()[2]) == null) {
                        final char[] charArray2 = "\u4f1f\u4f33\u4f29".toCharArray();
                        for (int j = 0; j < 3; ++j) {
                            charArray2[j] = (char)((((charArray2[j] + '\ud4c0' + 30609 + 56978 + 56482 + 27827 ^ 0x4904 ^ 0x876) - 64359 ^ 0xC317) - 12412 ^ 0xA06D) - 46335);
                        }
                        o4 = (mth_0OOOoo00o0_0()[2] = new String(charArray2));
                    }
                    Client.Oo0o00000O00 = new SecretKeySpec(key, (String)o4);
                }
                final byte[] decode = Base64.getDecoder().decode(s);
                final byte[] copyOfRange = Arrays.copyOfRange(decode, 0, 16);
                final byte[] copyOfRange2 = Arrays.copyOfRange(decode, 16, decode.length);
                Object o5;
                if ((o5 = mth_0OOOoo00o0_0()[3]) == null) {
                    final char[] charArray3 = "\u27cb\u2757\u27c9\u276d\u27d9\u2756\u27d9\u276d\u27c8\u27d1\u27d9\u27c9\u2767\u27c8\u272b\u2734\u2734\u2723\u272a\u2735".toCharArray();
                    for (int k = 0; k < 20; ++k) {
                        charArray3[k] = (char)((((charArray3[k] + '\u0c64' - 64102 ^ 0xA647) - 56523 + 9035 + 12974 ^ 0xA390 ^ 0x2B51) + 26772 + 51607 ^ 0x75F9) - 30010 - 60154 - 22236);
                    }
                    o5 = (mth_0OOOoo00o0_0()[3] = new String(charArray3));
                }
                final Cipher instance2 = Cipher.getInstance((String)o5);
                instance2.init(2, (Key)Client.Oo0o00000O00, new IvParameterSpec(copyOfRange));
                o2 = (Client.oO00O0OO0ooO[intValue] = new String(instance2.doFinal(copyOfRange2), StandardCharsets.UTF_8));
            }
            return o2;
        } catch (java.security.GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    public static void Oo0o00000O00() {
        (Client.O0OoOO0OOOOO = new int[400])[389] = 17700;
        Client.O0OoOO0OOOOO[55] = -74;
        Client.O0OoOO0OOOOO[64] = 33;
        Client.O0OoOO0OOOOO[50] = 75;
        Client.O0OoOO0OOOOO[107] = -13;
        Client.O0OoOO0OOOOO[112] = 0;
        Client.O0OoOO0OOOOO[177] = 98;
        Client.O0OoOO0OOOOO[243] = 29954;
        Client.O0OoOO0OOOOO[115] = 2;
        Client.O0OoOO0OOOOO[26] = -11;
        Client.O0OoOO0OOOOO[4] = -33;
        Client.O0OoOO0OOOOO[208] = 6;
        Client.O0OoOO0OOOOO[267] = 46414;
        Client.O0OoOO0OOOOO[184] = -109;
        Client.O0OoOO0OOOOO[276] = 5751;
        Client.O0OoOO0OOOOO[308] = 36910;
        Client.O0OoOO0OOOOO[62] = -124;
        Client.O0OoOO0OOOOO[53] = 107;
        Client.O0OoOO0OOOOO[149] = -60;
        Client.O0OoOO0OOOOO[346] = 7333;
        Client.O0OoOO0OOOOO[323] = 12083;
        Client.O0OoOO0OOOOO[171] = -98;
        Client.O0OoOO0OOOOO[293] = 38362;
        Client.O0OoOO0OOOOO[109] = 26;
        Client.O0OoOO0OOOOO[98] = -59;
        Client.O0OoOO0OOOOO[75] = -33;
        Client.O0OoOO0OOOOO[371] = 61139;
        Client.O0OoOO0OOOOO[235] = 10575;
        Client.O0OoOO0OOOOO[172] = 99;
        Client.O0OoOO0OOOOO[258] = 33906;
        Client.O0OoOO0OOOOO[238] = 65302;
        Client.O0OoOO0OOOOO[230] = 53098;
        Client.O0OoOO0OOOOO[132] = 0;
        Client.O0OoOO0OOOOO[240] = 29956;
        Client.O0OoOO0OOOOO[88] = -53;
        Client.O0OoOO0OOOOO[160] = 105;
        Client.O0OoOO0OOOOO[85] = -85;
        Client.O0OoOO0OOOOO[194] = 31;
        Client.O0OoOO0OOOOO[383] = 23773;
        Client.O0OoOO0OOOOO[17] = -94;
        Client.O0OoOO0OOOOO[396] = 22297;
        Client.O0OoOO0OOOOO[198] = 64;
        Client.O0OoOO0OOOOO[241] = 29954;
        Client.O0OoOO0OOOOO[108] = -69;
        Client.O0OoOO0OOOOO[181] = 39;
        Client.O0OoOO0OOOOO[147] = -49;
        Client.O0OoOO0OOOOO[114] = 0;
        Client.O0OoOO0OOOOO[391] = 15464;
        Client.O0OoOO0OOOOO[336] = 37927;
        Client.O0OoOO0OOOOO[349] = 35124;
        Client.O0OoOO0OOOOO[311] = 19170;
        Client.O0OoOO0OOOOO[148] = -21;
        Client.O0OoOO0OOOOO[120] = 30816;
        Client.O0OoOO0OOOOO[207] = -50;
        Client.O0OoOO0OOOOO[63] = 84;
        Client.O0OoOO0OOOOO[97] = -85;
        Client.O0OoOO0OOOOO[45] = -45;
        Client.O0OoOO0OOOOO[169] = 95;
        Client.O0OoOO0OOOOO[131] = -39;
        Client.O0OoOO0OOOOO[219] = -7;
        Client.O0OoOO0OOOOO[342] = 46483;
        Client.O0OoOO0OOOOO[156] = -66;
        Client.O0OoOO0OOOOO[224] = 1;
        Client.O0OoOO0OOOOO[229] = 0;
        Client.O0OoOO0OOOOO[58] = -83;
        Client.O0OoOO0OOOOO[174] = 116;
        Client.O0OoOO0OOOOO[236] = 65319;
        Client.O0OoOO0OOOOO[90] = 5;
        Client.O0OoOO0OOOOO[213] = 57;
        Client.O0OoOO0OOOOO[140] = 204;
        Client.O0OoOO0OOOOO[327] = 3296;
        Client.O0OoOO0OOOOO[234] = 10569;
        Client.O0OoOO0OOOOO[201] = -115;
        Client.O0OoOO0OOOOO[283] = 3857;
        Client.O0OoOO0OOOOO[193] = 111;
        Client.O0OoOO0OOOOO[94] = 70;
        Client.O0OoOO0OOOOO[110] = 75;
        Client.O0OoOO0OOOOO[104] = 91;
        Client.O0OoOO0OOOOO[215] = 81;
        Client.O0OoOO0OOOOO[6] = -129;
        Client.O0OoOO0OOOOO[356] = 9206;
        Client.O0OoOO0OOOOO[296] = 0;
        Client.O0OoOO0OOOOO[319] = 14455;
        Client.O0OoOO0OOOOO[72] = 71;
        Client.O0OoOO0OOOOO[152] = 89;
        Client.O0OoOO0OOOOO[264] = 46410;
        Client.O0OoOO0OOOOO[35] = 57;
        Client.O0OoOO0OOOOO[15] = -33;
        Client.O0OoOO0OOOOO[369] = -48556;
        Client.O0OoOO0OOOOO[157] = 114;
        Client.O0OoOO0OOOOO[92] = 107;
        Client.O0OoOO0OOOOO[287] = 51202;
        Client.O0OoOO0OOOOO[123] = 10161;
        Client.O0OoOO0OOOOO[70] = -29;
        Client.O0OoOO0OOOOO[178] = 56;
        Client.O0OoOO0OOOOO[189] = 118;
        Client.O0OoOO0OOOOO[334] = 28178;
        Client.O0OoOO0OOOOO[225] = 2;
        Client.O0OoOO0OOOOO[329] = 3290;
        Client.O0OoOO0OOOOO[47] = -29;
        Client.O0OoOO0OOOOO[290] = 38928;
        Client.O0OoOO0OOOOO[291] = 39006;
        Client.O0OoOO0OOOOO[124] = 29777;
        Client.O0OoOO0OOOOO[352] = 60440;
        Client.O0OoOO0OOOOO[29] = -96;
        Client.O0OoOO0OOOOO[119] = 60176;
        Client.O0OoOO0OOOOO[310] = 36910;
        Client.O0OoOO0OOOOO[218] = 103;
        Client.O0OoOO0OOOOO[266] = -46413;
        Client.O0OoOO0OOOOO[48] = 221;
        Client.O0OoOO0OOOOO[317] = 42880;
        Client.O0OoOO0OOOOO[333] = 28194;
        Client.O0OoOO0OOOOO[307] = 36920;
        Client.O0OoOO0OOOOO[302] = 9079;
        Client.O0OoOO0OOOOO[351] = 60441;
        Client.O0OoOO0OOOOO[275] = 8463;
        Client.O0OoOO0OOOOO[69] = -18;
        Client.O0OoOO0OOOOO[42] = 107;
        Client.O0OoOO0OOOOO[158] = 203;
        Client.O0OoOO0OOOOO[263] = 64210;
        Client.O0OoOO0OOOOO[210] = 68;
        Client.O0OoOO0OOOOO[398] = 22297;
        Client.O0OoOO0OOOOO[106] = 37;
        Client.O0OoOO0OOOOO[242] = -30029;
        Client.O0OoOO0OOOOO[315] = 42920;
        Client.O0OoOO0OOOOO[74] = -121;
        Client.O0OoOO0OOOOO[211] = -37;
        Client.O0OoOO0OOOOO[321] = 14370;
        Client.O0OoOO0OOOOO[399] = 55402;
        Client.O0OoOO0OOOOO[360] = 11673;
        Client.O0OoOO0OOOOO[200] = -136;
        Client.O0OoOO0OOOOO[139] = -64;
        Client.O0OoOO0OOOOO[259] = 33797;
        Client.O0OoOO0OOOOO[49] = -114;
        Client.O0OoOO0OOOOO[376] = 44393;
        Client.O0OoOO0OOOOO[231] = 53114;
        Client.O0OoOO0OOOOO[27] = -120;
        Client.O0OoOO0OOOOO[239] = 65318;
        Client.O0OoOO0OOOOO[127] = 28167;
        Client.O0OoOO0OOOOO[381] = -33110;
        Client.O0OoOO0OOOOO[151] = -62;
        Client.O0OoOO0OOOOO[260] = 64217;
        Client.O0OoOO0OOOOO[357] = -9134;
        Client.O0OoOO0OOOOO[9] = -57;
        Client.O0OoOO0OOOOO[289] = 39006;
        Client.O0OoOO0OOOOO[256] = 33792;
        Client.O0OoOO0OOOOO[362] = 11673;
        Client.O0OoOO0OOOOO[91] = 112;
        Client.O0OoOO0OOOOO[89] = 103;
        Client.O0OoOO0OOOOO[214] = -31;
        Client.O0OoOO0OOOOO[86] = 74;
        Client.O0OoOO0OOOOO[221] = 111;
        Client.O0OoOO0OOOOO[295] = 38362;
        Client.O0OoOO0OOOOO[166] = -111;
        Client.O0OoOO0OOOOO[332] = 28178;
        Client.O0OoOO0OOOOO[244] = 61489;
        Client.O0OoOO0OOOOO[170] = 165;
        Client.O0OoOO0OOOOO[361] = 11761;
        Client.O0OoOO0OOOOO[93] = -95;
        Client.O0OoOO0OOOOO[226] = 0;
        Client.O0OoOO0OOOOO[299] = 9075;
        Client.O0OoOO0OOOOO[280] = 3857;
        Client.O0OoOO0OOOOO[167] = -118;
        Client.O0OoOO0OOOOO[343] = 7340;
        Client.O0OoOO0OOOOO[345] = -7413;
        Client.O0OoOO0OOOOO[206] = -62;
        Client.O0OoOO0OOOOO[341] = 46484;
        Client.O0OoOO0OOOOO[392] = 15478;
        Client.O0OoOO0OOOOO[78] = -203;
        Client.O0OoOO0OOOOO[251] = 45376;
        Client.O0OoOO0OOOOO[304] = 2871;
        Client.O0OoOO0OOOOO[269] = 32015;
        Client.O0OoOO0OOOOO[155] = -148;
        Client.O0OoOO0OOOOO[20] = 15;
        Client.O0OoOO0OOOOO[205] = -24;
        Client.O0OoOO0OOOOO[33] = 22;
        Client.O0OoOO0OOOOO[128] = 24603;
        Client.O0OoOO0OOOOO[227] = 1;
        Client.O0OoOO0OOOOO[138] = 16;
        Client.O0OoOO0OOOOO[228] = 1;
        Client.O0OoOO0OOOOO[309] = -36967;
        Client.O0OoOO0OOOOO[36] = 57;
        Client.O0OoOO0OOOOO[382] = 33066;
        Client.O0OoOO0OOOOO[161] = 234;
        Client.O0OoOO0OOOOO[14] = 3;
        Client.O0OoOO0OOOOO[133] = 71;
        Client.O0OoOO0OOOOO[285] = 51202;
        Client.O0OoOO0OOOOO[141] = 84;
        Client.O0OoOO0OOOOO[202] = 24;
        Client.O0OoOO0OOOOO[46] = 48;
        Client.O0OoOO0OOOOO[385] = 23791;
        Client.O0OoOO0OOOOO[378] = 44393;
        Client.O0OoOO0OOOOO[301] = 9062;
        Client.O0OoOO0OOOOO[101] = -110;
        Client.O0OoOO0OOOOO[199] = -62;
        Client.O0OoOO0OOOOO[81] = 9;
        Client.O0OoOO0OOOOO[387] = 17693;
        Client.O0OoOO0OOOOO[281] = 3857;
        Client.O0OoOO0OOOOO[222] = 118;
        Client.O0OoOO0OOOOO[95] = -25;
        Client.O0OoOO0OOOOO[32] = -104;
        Client.O0OoOO0OOOOO[197] = 127;
        Client.O0OoOO0OOOOO[320] = 14455;
        Client.O0OoOO0OOOOO[134] = -39;
        Client.O0OoOO0OOOOO[0] = -115;
        Client.O0OoOO0OOOOO[130] = 0;
        Client.O0OoOO0OOOOO[176] = 58;
        Client.O0OoOO0OOOOO[359] = 11670;
        Client.O0OoOO0OOOOO[338] = 37927;
        Client.O0OoOO0OOOOO[59] = -119;
        Client.O0OoOO0OOOOO[145] = 13;
        Client.O0OoOO0OOOOO[250] = 45439;
        Client.O0OoOO0OOOOO[366] = 10637;
        Client.O0OoOO0OOOOO[397] = 22340;
        Client.O0OoOO0OOOOO[105] = -40;
        Client.O0OoOO0OOOOO[365] = 10722;
        Client.O0OoOO0OOOOO[188] = -106;
        Client.O0OoOO0OOOOO[388] = 17669;
        Client.O0OoOO0OOOOO[216] = 112;
        Client.O0OoOO0OOOOO[87] = 50;
        Client.O0OoOO0OOOOO[335] = 37939;
        Client.O0OoOO0OOOOO[217] = 31;
        Client.O0OoOO0OOOOO[274] = 8457;
        Client.O0OoOO0OOOOO[150] = -1;
        Client.O0OoOO0OOOOO[306] = 2871;
        Client.O0OoOO0OOOOO[355] = 9213;
        Client.O0OoOO0OOOOO[82] = 101;
        Client.O0OoOO0OOOOO[262] = 64239;
        Client.O0OoOO0OOOOO[248] = 45388;
        Client.O0OoOO0OOOOO[316] = 42927;
        Client.O0OoOO0OOOOO[137] = -48;
        Client.O0OoOO0OOOOO[279] = 5748;
        Client.O0OoOO0OOOOO[192] = -65;
        Client.O0OoOO0OOOOO[54] = -138;
        Client.O0OoOO0OOOOO[11] = -5;
        Client.O0OoOO0OOOOO[330] = 3301;
        Client.O0OoOO0OOOOO[353] = 60440;
        Client.O0OoOO0OOOOO[297] = 18811;
        Client.O0OoOO0OOOOO[19] = -75;
        Client.O0OoOO0OOOOO[10] = 51;
        Client.O0OoOO0OOOOO[39] = 11;
        Client.O0OoOO0OOOOO[38] = 45;
        Client.O0OoOO0OOOOO[142] = 121;
        Client.O0OoOO0OOOOO[113] = 1;
        Client.O0OoOO0OOOOO[165] = -41;
        Client.O0OoOO0OOOOO[312] = 19197;
        Client.O0OoOO0OOOOO[318] = 42927;
        Client.O0OoOO0OOOOO[232] = 10562;
        Client.O0OoOO0OOOOO[223] = -8;
        Client.O0OoOO0OOOOO[122] = 1024;
        Client.O0OoOO0OOOOO[34] = -34;
        Client.O0OoOO0OOOOO[2] = 57;
        Client.O0OoOO0OOOOO[288] = 38998;
        Client.O0OoOO0OOOOO[182] = 44;
        Client.O0OoOO0OOOOO[294] = -38356;
        Client.O0OoOO0OOOOO[324] = 12080;
        Client.O0OoOO0OOOOO[12] = -62;
        Client.O0OoOO0OOOOO[159] = 66;
        Client.O0OoOO0OOOOO[209] = 44;
        Client.O0OoOO0OOOOO[273] = 8463;
        Client.O0OoOO0OOOOO[372] = 61149;
        Client.O0OoOO0OOOOO[144] = 53;
        Client.O0OoOO0OOOOO[65] = 19;
        Client.O0OoOO0OOOOO[253] = 35063;
        Client.O0OoOO0OOOOO[60] = -99;
        Client.O0OoOO0OOOOO[24] = 31;
        Client.O0OoOO0OOOOO[57] = 68;
        Client.O0OoOO0OOOOO[298] = 18779;
        Client.O0OoOO0OOOOO[3] = -26;
        Client.O0OoOO0OOOOO[373] = -61165;
        Client.O0OoOO0OOOOO[393] = 15485;
        Client.O0OoOO0OOOOO[292] = 38355;
        Client.O0OoOO0OOOOO[23] = 121;
        Client.O0OoOO0OOOOO[168] = 75;
        Client.O0OoOO0OOOOO[21] = 27;
        Client.O0OoOO0OOOOO[347] = 35198;
        Client.O0OoOO0OOOOO[390] = 17669;
        Client.O0OoOO0OOOOO[67] = 112;
        Client.O0OoOO0OOOOO[277] = 5748;
        Client.O0OoOO0OOOOO[80] = -123;
        Client.O0OoOO0OOOOO[191] = -48;
        Client.O0OoOO0OOOOO[350] = 35183;
        Client.O0OoOO0OOOOO[265] = 46414;
        Client.O0OoOO0OOOOO[99] = 103;
        Client.O0OoOO0OOOOO[73] = 50;
        Client.O0OoOO0OOOOO[5] = -57;
        Client.O0OoOO0OOOOO[83] = -110;
        Client.O0OoOO0OOOOO[331] = 28171;
        Client.O0OoOO0OOOOO[204] = 80;
        Client.O0OoOO0OOOOO[135] = 18;
        Client.O0OoOO0OOOOO[363] = 10624;
        Client.O0OoOO0OOOOO[61] = -7;
        Client.O0OoOO0OOOOO[254] = 35007;
        Client.O0OoOO0OOOOO[116] = 0;
        Client.O0OoOO0OOOOO[328] = 3301;
        Client.O0OoOO0OOOOO[305] = 2905;
        Client.O0OoOO0OOOOO[129] = 27743;
        Client.O0OoOO0OOOOO[237] = 65318;
        Client.O0OoOO0OOOOO[284] = 51200;
        Client.O0OoOO0OOOOO[245] = 61502;
        Client.O0OoOO0OOOOO[255] = 35063;
        Client.O0OoOO0OOOOO[111] = 3;
        Client.O0OoOO0OOOOO[354] = 60440;
        Client.O0OoOO0OOOOO[246] = -61531;
        Client.O0OoOO0OOOOO[272] = 8456;
        Client.O0OoOO0OOOOO[154] = 43;
        Client.O0OoOO0OOOOO[66] = 46;
        Client.O0OoOO0OOOOO[117] = 0;
        Client.O0OoOO0OOOOO[344] = 7333;
        Client.O0OoOO0OOOOO[153] = 18;
        Client.O0OoOO0OOOOO[102] = 155;
        Client.O0OoOO0OOOOO[278] = 5654;
        Client.O0OoOO0OOOOO[77] = -50;
        Client.O0OoOO0OOOOO[190] = -11;
        Client.O0OoOO0OOOOO[146] = -60;
        Client.O0OoOO0OOOOO[25] = -40;
        Client.O0OoOO0OOOOO[270] = 32059;
        Client.O0OoOO0OOOOO[339] = 46464;
        Client.O0OoOO0OOOOO[386] = 23751;
        Client.O0OoOO0OOOOO[185] = -60;
        Client.O0OoOO0OOOOO[322] = 14455;
        Client.O0OoOO0OOOOO[51] = 86;
        Client.O0OoOO0OOOOO[195] = 96;
        Client.O0OoOO0OOOOO[313] = 19177;
        Client.O0OoOO0OOOOO[126] = 1174;
        Client.O0OoOO0OOOOO[7] = -83;
        Client.O0OoOO0OOOOO[16] = -70;
        Client.O0OoOO0OOOOO[358] = 9206;
        Client.O0OoOO0OOOOO[300] = 9079;
        Client.O0OoOO0OOOOO[13] = -65;
        Client.O0OoOO0OOOOO[395] = 22299;
        Client.O0OoOO0OOOOO[103] = 64;
        Client.O0OoOO0OOOOO[261] = 64210;
        Client.O0OoOO0OOOOO[379] = 33082;
        Client.O0OoOO0OOOOO[257] = 33797;
        Client.O0OoOO0OOOOO[367] = 48629;
        Client.O0OoOO0OOOOO[268] = 32001;
        Client.O0OoOO0OOOOO[43] = -3;
        Client.O0OoOO0OOOOO[1] = 68;
        Client.O0OoOO0OOOOO[100] = -12;
        Client.O0OoOO0OOOOO[84] = -11;
        Client.O0OoOO0OOOOO[183] = -97;
        Client.O0OoOO0OOOOO[56] = -96;
        Client.O0OoOO0OOOOO[125] = 59937;
        Client.O0OoOO0OOOOO[162] = -97;
        Client.O0OoOO0OOOOO[186] = -67;
        Client.O0OoOO0OOOOO[252] = 35069;
        Client.O0OoOO0OOOOO[79] = 80;
        Client.O0OoOO0OOOOO[136] = -53;
        Client.O0OoOO0OOOOO[303] = 2858;
        Client.O0OoOO0OOOOO[340] = 46483;
        Client.O0OoOO0OOOOO[377] = 44398;
        Client.O0OoOO0OOOOO[22] = -87;
        Client.O0OoOO0OOOOO[247] = 61502;
        Client.O0OoOO0OOOOO[68] = 126;
        Client.O0OoOO0OOOOO[374] = 61149;
        Client.O0OoOO0OOOOO[375] = 44387;
        Client.O0OoOO0OOOOO[364] = 10637;
        Client.O0OoOO0OOOOO[28] = 24;
        Client.O0OoOO0OOOOO[394] = 15478;
        Client.O0OoOO0OOOOO[163] = -121;
        Client.O0OoOO0OOOOO[71] = 45;
        Client.O0OoOO0OOOOO[18] = -95;
        Client.O0OoOO0OOOOO[52] = 53;
        Client.O0OoOO0OOOOO[212] = -38;
        Client.O0OoOO0OOOOO[44] = -72;
        Client.O0OoOO0OOOOO[143] = 38;
        Client.O0OoOO0OOOOO[286] = 51279;
        Client.O0OoOO0OOOOO[326] = 12080;
        Client.O0OoOO0OOOOO[30] = 12;
        Client.O0OoOO0OOOOO[271] = 32015;
        Client.O0OoOO0OOOOO[175] = 78;
        Client.O0OoOO0OOOOO[41] = 52;
        Client.O0OoOO0OOOOO[164] = 102;
        Client.O0OoOO0OOOOO[121] = 52144;
        Client.O0OoOO0OOOOO[40] = -34;
        Client.O0OoOO0OOOOO[173] = -162;
        Client.O0OoOO0OOOOO[368] = 48608;
        Client.O0OoOO0OOOOO[337] = -37937;
        Client.O0OoOO0OOOOO[370] = 48608;
        Client.O0OoOO0OOOOO[233] = 10575;
        Client.O0OoOO0OOOOO[203] = -94;
        Client.O0OoOO0OOOOO[282] = -3928;
        Client.O0OoOO0OOOOO[384] = 23751;
        Client.O0OoOO0OOOOO[76] = -17;
        Client.O0OoOO0OOOOO[325] = 12072;
        Client.O0OoOO0OOOOO[96] = 95;
        Client.O0OoOO0OOOOO[249] = 45376;
        Client.O0OoOO0OOOOO[179] = -74;
        Client.O0OoOO0OOOOO[8] = -46;
        Client.O0OoOO0OOOOO[187] = -25;
        Client.O0OoOO0OOOOO[196] = 119;
        Client.O0OoOO0OOOOO[180] = 67;
        Client.O0OoOO0OOOOO[31] = 100;
        Client.O0OoOO0OOOOO[380] = 33066;
        Client.O0OoOO0OOOOO[220] = 106;
        Client.O0OoOO0OOOOO[348] = 35183;
        Client.O0OoOO0OOOOO[37] = -90;
        Client.O0OoOO0OOOOO[118] = 256;
        Client.O0OoOO0OOOOO[314] = 19197;
    }

    @Generated
    public afx p() {
        return this.B;
    }

    public void b() {
        if (this.p() != null && this.p().to() != null) {
            this.p().to().tf();
        }
    }

    public static Object[] mth_0OOOoo00o0_0() {
        Object[] fld_0oOOoOo0O00O_0;
        if ((fld_0oOOoOo0O00O_0 = Client.fld_0oOOoOo0O00O_0) == null) {
            fld_0oOOoOo0O00O_0 = (Client.fld_0oOOoOo0O00O_0 = new Object[4]);
        }
        return fld_0oOOoOo0O00O_0;
    }

    @Generated
    public b n() {
        return this.w;
    }

    public void a(ahc ahc2) {
        if (ahc2 == null) {
            return;
        }
        if (this.l == ahc2) {
            return;
        }
        this.l = ahc2;
        if (this.moduleManager != null) {
            for (Module module : this.moduleManager.ef()) {
                if (module == null || module.getModuleInfo() == null) continue;
                try {
                    module.setAliases((String[])Arrays.stream(module.getModuleInfo().aliases()).map(hackclient.rise.ahd::ce).toArray(String[]::new));
                } catch (Throwable throwable) {
                }
            }
        }
        try {
            com.alan.clients.module.impl.render.Interface interface_;
            if (this.moduleManager != null && (interface_ = this.moduleManager.c(com.alan.clients.module.impl.render.Interface.class)) != null) {
                interface_.lv();
                interface_.lw();
            }
        } catch (Throwable throwable) {
        }
        try {
            if (this.standardClickGUI != null) {
                try {
                    this.standardClickGUI.oS();
                } catch (Throwable throwable2) {
                }
                hackclient.rise.aha.aMR.execute(() -> {
                    try {
                        this.standardClickGUI.oS();
                        return;
                    } catch (Throwable throwable) {
                        return;
                    }
                });
            }
        } catch (Throwable throwable) {
        }
        try {
            if (this.I != null) {
                try {
                    this.I.om();
                } catch (Throwable throwable2) {
                }
                hackclient.rise.aha.aMR.execute(() -> {
                    try {
                        this.I.om();
                        return;
                    } catch (Throwable throwable) {
                        return;
                    }
                });
            }
        } catch (Throwable throwable) {
        }
    }

    @Generated
    public q t() {
        return this.F;
    }

    @Generated
    public ahc d() {
        return this.l;
    }

    @Generated
    public void a(final com.alan.clients.security.b r) {
        this.r = r;
    }

    @Generated
    public SecurityFeatureManager s() {
        return this.securityManager;
    }

    @Generated
    public void a(final ComponentManager componentManager) {
        this.componentManager = componentManager;
    }

    @Generated
    public void b(final ahc l) {
        this.l = l;
    }

    @Generated
    public ExecutorService c() {
        return this.executor;
    }

    @Generated
    public aal f() {
        return this.n;
    }

    @Generated
    public ScriptManager l() {
        return this.scriptManager;
    }

    public void a() {
        final long n = -6297520619757661444L;
        final long n2 = 876962712539923373L;
        final long n3 = 8521810644678046354L;
        final String[] array = { "hackclient.", "com.alan.clients." };
        final long n4 = array.length;
        final long n5 = n3;
        final long n6 = n5 ^ ((n4 ^ n5) & -1L >>> 32);
        final long n7 = 0L;
        final long n8 = n6;
        for (long n9 = n8 ^ ((n7 ^ n8) & -1L << 32); (int)(n9 >>> 32) < (int)n9; n9 += 4294967296L) {
            final String s = array[(int)(n9 >>> 32)];
            if (aeg.bc(s)) {
                final Class<?>[] array2 = aeg.ba(s);
                final long n10 = (long)array2.length << 32;
                final long n11 = n;
                final long n12 = n11 ^ ((n10 ^ n11) & -1L << 32);
                final long n13 = 0L;
                final long n14 = n2;
                long n15 = n14 ^ ((n13 ^ n14) & -1L << 32);
            Label_0241_Outer:
                while ((int)(n15 >>> 32) < (int)(n12 >>> 32)) {
                    final Class clazz = array2[(int)(n15 >>> 32)];
                    while (true) {
                        try {
                            if (!Modifier.isAbstract(clazz.getModifiers())) {
                                if (Component.class.isAssignableFrom(clazz)) {
                                    this.componentManager.a((Component)clazz.getConstructor((Class[])new Class[0]).newInstance(new Object[0]));
                                }
                                else if (Module.class.isAssignableFrom(clazz)) {
                                    this.moduleManager.a(clazz, (Module)clazz.getConstructor((Class[])new Class[0]).newInstance(new Object[0]));
                                }
                                else if (Command.class.isAssignableFrom(clazz)) {
                                    this.commandManager.aQ().add((Command)clazz.getConstructor((Class[])new Class[0]).newInstance(new Object[0]));
                                }
                                else if (SecurityFeature.class.isAssignableFrom(clazz)) {
                                    this.securityManager.a((SecurityFeature)clazz.getConstructor((Class[])new Class[0]).newInstance(new Object[0]));
                                }
                            }
                            n15 += 4294967296L;
                            continue Label_0241_Outer;
                        }
                        catch (final IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException ex) {
                            ((Throwable)ex).printStackTrace();
                            continue;
                        }
                    }
                }
                break;
            }
        }
    }

    public static Client[] E() {
        return new Client[] { Client.a };
    }

    @Generated
    public Gson A() {
        return this.K;
    }

    static {
        Oo0o00000O00();
        final long n = -6572660094731715013L;
        long n2 = 1225688883576723018L;
        long n3 = 4377125705540254908L;
        long n4 = 8247547237089773965L;
        final long n5 = 766514392127847450L;
        long n6 = -770659489898165532L;
        final long n7 = 3070900508343144582L;
        Client.o0Oo000O0oO = new Object[14];
        final long n8 = 0L;
        final long n9 = n7;
        long n10 = n9 ^ ((n8 ^ n9) & -1L << 32);
        final Object[] array = { Client.fld_0OOOoo00o0_1, 0, null };
        final int n11 = 2;
        Object o;
        if ((o = mth_0OOOoo00o0_0()[0]) == null) {
            final char[] charArray = "\ua18e\ua16d\ua1f9\ua199\ua1cf\ua1fe\ua1f1\ua16d\ua198\ua19a\ua18f\ua198\ua1c4\ua1c9\ua161\ua162\ua1fa\ua1d1\ua1cb\ua18d\ua1f0\ua18f\ua1f8\ua167\ua165\ua1c6\ua1c4\ua168\ua16b\ua1cf\ua1c1\ua161\ua18d\ua18f\ua163\ua1f8\ua1c1\ua1c2\ua164\ua19f\ua161\ua1cb\ua16b\ua1cb\ua18f\ua16a\ua1c2\ua163\ua1cb\ua18b\ua16d\ua168\ua161\ua18c\ua16f\ua1cd\ua19d\ua163\ua1fe\ua1ff\ua16f\ua188\ua1cb\ua18c\ua19d\ua1cc\ua1c3\ua1c6\ua18e\ua191\ua168\ua1cb\ua1cd\ua19c\ua19a\ua1f8\ua1ff\ua19a\ua16d\ua1f0\ua1f9\ua19a\ua187\ua18d\ua16e\ua1c8\ua1c0\ua1fa\ua1ca\ua19d\ua1fb\ua1f8\ua19f\ua1f1\ua16c\ua19e\ua16a\ua1ff\ua1f0\ua160\ua198\ua19d\ua16b\ua161\ua1c4\ua169\ua186\ua16f\ua1d1\ua168\ua1f9\ua188\ua19f\ua1c8\ua167\ua19d\ua18d\ua1f9\ua1fe\ua16c\ua1ca\ua1fe\ua1cd\ua1cb\ua191\ua186\ua19a\ua1c0\ua1c2\ua189\ua191\ua16b\ua183\ua19f\ua16d\ua19c\ua19e\ua1c4\ua18e\ua18b\ua167\ua163\ua1c7\ua1f0\ua1f8\ua1fb\ua19b\ua189\ua1c1\ua1c2\ua1c8\ua164\ua1d0\ua161\ua16a\ua18b\ua1f1\ua18b\ua18a\ua18f\ua169\ua19d\ua167\ua189\ua1f1\ua199\ua1ff\ua16b\ua1c2\ua1c8\ua1c4\ua19e\ua16c\ua16c\ua1d1\ua1fe\ua1c4\ua1c2\ua1c3\ua1fd\ua18c\ua168\ua18d\ua1cb\ua166\ua163\ua1c6\ua1fb\ua1fa\ua1c8\ua1ff\ua162\ua183\ua1fa\ua1fb\ua1fd\ua1cc\ua168\ua18f\ua161\ua1fd\ua186\ua1c4\ua1cf\ua1fa\ua1f8\ua1c0\ua1d1\ua1fa\ua1c8\ua167\ua16f\ua1fe\ua18a\ua1cb\ua1fe\ua18c\ua1cf\ua19c\ua16a\ua161\ua19c\ua1ff\ua1fe\ua1cb\ua1f8\ua1c7\ua1cb\ua191\ua167\ua189\ua18b\ua164\ua183\ua199\ua187\ua1f8\ua1ff\ua186\ua18a\ua1c2\ua165\ua16b\ua1c1\ua1c5\ua19b\ua1c6\ua1fd\ua162\ua1c5\ua1c3\ua1f1\ua19e\ua1ca\ua19d\ua183".toCharArray();
            for (int i = 0; i < 256; ++i) {
                charArray[i] = (char)(((charArray[i] ^ '\ueb10') + 30816 + 52144 + 1024 ^ 0x27B1) + 29777 - 59937 - 1174 - 28167 - 24603 - 27743);
            }
            o = (mth_0OOOoo00o0_0()[0] = new String(charArray));
        }
        array[n11] = o;
        final char[] charArray2 = ((String)o0Oo000O0oO(array)).toCharArray();
        final long n12 = 691489734656L;
        final long n13 = n;
        final long n14 = n13 ^ ((n12 ^ n13) & -1L << 32);
        final long n15 = 0L;
        final long n16 = n5;
        long n33;
        long n34;
        for (long n17 = n16 ^ ((n15 ^ n16) & -1L >>> 32); (int)n17 < (int)(n14 >>> 32); n17 = (n34 ^ ((n33 ^ n34) & -1L >>> 32))) {
            final char[] array2 = charArray2;
            final int n18 = (int)n17;
            final long n19 = n17;
            final long n20 = n19 ^ ((n19 ^ n19 + 1) & -1L >>> 32);
            final long n21 = array2[n18];
            final long n22 = n2;
            n2 = (n22 ^ ((n21 ^ n22) & -1L >>> 32));
            final char[] array3 = charArray2;
            final int n23 = (int)n20;
            final long n24 = n20;
            final long n25 = n24 ^ ((n24 ^ n24 + 1) & -1L >>> 32);
            final long n26 = (long)array3[n23] << 32;
            final long n27 = n3;
            n3 = (n27 ^ ((n26 ^ n27) & -1L << 32));
            final long n28 = (int)n2 << 16 | (int)(n3 >>> 32);
            final long n29 = n4;
            n4 = (n29 ^ ((n28 ^ n29) & -1L >>> 32));
            final char[] array4 = new char[(int)n4];
            final long n30 = 0L;
            final long n31 = n6;
            for (n6 = (n31 ^ ((n30 ^ n31) & -1L << 32)); (int)(n6 >>> 32) < (int)n4; n6 += 4294967296L) {
                array4[(int)(n6 >>> 32)] = charArray2[(int)n25 + (int)(n6 >>> 32)];
            }
            final Object[] o0Oo000O0oO = Client.o0Oo000O0oO;
            final int n32 = (int)(n10 >>> 32);
            n10 += 4294967296L;
            o0Oo000O0oO[n32] = new String(array4);
            n33 = (int)n25 + (int)n4;
            n34 = n25;
        }
        new StringBuilder().append("Made with <3 by Alan and ").append("The_Bi11iona1re").toString();
        new StringBuilder().append("\u00a9 Rise Client 2026. All Righ").append("ts Reserved").toString();
        final String s = "6.9.5";
        final String s2 = "6";
        Client.$VALUES = E();
        Client.b = "Rise";
    }

    @Generated
    public EventBus<Event> e() {
        return this.eventBus;
    }

    public void reload() {
        this.b();
        this.init();
        Client.a.p().tn();
    }

    @Generated
    public void a(final ModuleManager moduleManager) {
        this.moduleManager = moduleManager;
    }

    @Generated
    public RiseClickGUI v() {
        return this.standardClickGUI;
    }

    @Generated
    public ComponentManager h() {
        return this.componentManager;
    }

    @Generated
    public dg w() {
        return this.J;
    }

    @Generated
    public aba z() {
        return this.I;
    }

    @Generated
    public adu k() {
        return this.t;
    }

    @Generated
    public afv q() {
        return this.C;
    }

    @Generated
    public gf u() {
        return this.G;
    }

    Client() {
        this.executor = Executors.newSingleThreadExecutor();
        this.l = ahc.EN_US;
        this.K = new GsonBuilder().setPrettyPrinting().create();
    }

    @Generated
    public CommandManager i() {
        return this.commandManager;
    }

    @Generated
    public agb r() {
        return this.D;
    }

    @Generated
    public afr o() {
        return this.A;
    }

    public void init() {
        final Minecraft minecraft = Minecraft.getMinecraft();
        minecraft.gameSettings.guiScale = 2;
        minecraft.gameSettings.cij = false;
        minecraft.gameSettings.ciq = false;
        minecraft.gameSettings.chy = true;
        minecraft.gameSettings.chu = false;
        NativeDecryptor.ok();
        this.n = new aal();
        this.moduleManager = new ModuleManager();
        this.componentManager = new ComponentManager();
        this.commandManager = new CommandManager();
        this.A = new afr();
        this.B = new afx();
        this.C = new afv();
        this.D = new agb();
        this.v = new afz();
        this.r = new com.alan.clients.security.b();
        this.s = new r();
        this.t = new adu();
        this.scriptManager = new ScriptManager();
        this.w = new b();
        this.eventBus = new EventBus<Event>();
        this.securityManager = new SecurityFeatureManager();
        this.F = new q();
        this.G = new gf();
        new abs();
        this.A.init();
        this.v.init();
        this.n.init();
        this.moduleManager.init();
        this.r.init();
        this.s.init();
        this.componentManager.init();
        this.commandManager.init();
        this.C.init();
        this.D.init();
        this.scriptManager.init();
        this.securityManager.init();
        (this.standardClickGUI = new RiseClickGUI()).initGui();
        (this.I = new aba()).initGui();
        this.D.update();
        this.D.forEach(aga::te);
        this.J = new dg();
        new Thread(() -> {
            ViaMCP.create();
            ViaMCP.INSTANCE.initAsyncSlider();
            ViaMCP.INSTANCE.getAsyncVersionSlider().setVersion(47);
            return;
        }).start();
        this.B.init();
        this.F.init();
        Display.setTitle((Object)Client.b + " " + (Object)"6.9.5".replace(".0", ""));
    }

    @Generated
    public afz m() {
        return this.v;
    }

    @Generated
    public void a(final CommandManager commandManager) {
        this.commandManager = commandManager;
    }
}
