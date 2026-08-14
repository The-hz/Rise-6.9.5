package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.compat.NetworkToggles;
import com.alan.clients.compat.OfflineMode;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import hackclient.rise.ade;
import hackclient.rise.adh;
import hackclient.rise.adm;
import hackclient.rise.aeb;
import hackclient.rise.aec;
import hackclient.rise.agc;
import hackclient.rise.agl;
import hackclient.rise.agm;
import hackclient.rise.aip;
import hackclient.rise.aiv;
import hackclient.rise.aiz;
import hackclient.rise.aju;
import hackclient.rise.er;
import hackclient.rise.gb;
import hackclient.rise.gd;
import hackclient.rise.gg;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import net.minecraft.client.gui.ScaledResolution;
import rip.vantage.commons.util.time.a;

public class aap
extends ade {
    public String aCA;
    public a bN;
    public adm aCx;
    @EventLink
    public Listener<er> aCE;
    public adh[] menuButtons;
    public adm aCw;
    public boolean aCz;
    public String jc;
    public Animation aCv;
    public String aCB = null;
    public agm aCy;
    public agc aCu = gb.MAIN.a(64, gd.LIGHT);
    public boolean aCC;
    public boolean aCD;
    public Animation animation = new Animation(Easing.EASE_OUT_QUINT, 600L);
    public static int[] O0OoOO0OOOOO;

    static {
        aap.Oo0o00000O00();
    }

    public static void Oo0o00000O00() {
        O0OoOO0OOOOO = new int[400];
        aap.O0OoOO0OOOOO[78] = -110;
        aap.O0OoOO0OOOOO[274] = 72;
        aap.O0OoOO0OOOOO[319] = -88;
        aap.O0OoOO0OOOOO[131] = 47;
        aap.O0OoOO0OOOOO[97] = -114;
        aap.O0OoOO0OOOOO[122] = -109;
        aap.O0OoOO0OOOOO[7] = -1;
        aap.O0OoOO0OOOOO[88] = -100;
        aap.O0OoOO0OOOOO[350] = 27024;
        aap.O0OoOO0OOOOO[192] = 112;
        aap.O0OoOO0OOOOO[391] = -89;
        aap.O0OoOO0OOOOO[126] = -24;
        aap.O0OoOO0OOOOO[270] = -40;
        aap.O0OoOO0OOOOO[237] = -58;
        aap.O0OoOO0OOOOO[177] = -89;
        aap.O0OoOO0OOOOO[372] = 18;
        aap.O0OoOO0OOOOO[62] = 24;
        aap.O0OoOO0OOOOO[220] = -115;
        aap.O0OoOO0OOOOO[53] = -10;
        aap.O0OoOO0OOOOO[393] = -121;
        aap.O0OoOO0OOOOO[334] = 42;
        aap.O0OoOO0OOOOO[90] = -104;
        aap.O0OoOO0OOOOO[235] = -44;
        aap.O0OoOO0OOOOO[254] = 42;
        aap.O0OoOO0OOOOO[358] = 62938;
        aap.O0OoOO0OOOOO[95] = -94;
        aap.O0OoOO0OOOOO[282] = 40;
        aap.O0OoOO0OOOOO[318] = 98;
        aap.O0OoOO0OOOOO[387] = -114;
        aap.O0OoOO0OOOOO[57] = 142;
        aap.O0OoOO0OOOOO[250] = -65;
        aap.O0OoOO0OOOOO[125] = 61;
        aap.O0OoOO0OOOOO[169] = 42;
        aap.O0OoOO0OOOOO[148] = -106;
        aap.O0OoOO0OOOOO[356] = 21464;
        aap.O0OoOO0OOOOO[158] = -124;
        aap.O0OoOO0OOOOO[195] = -27;
        aap.O0OoOO0OOOOO[87] = 248;
        aap.O0OoOO0OOOOO[82] = -8;
        aap.O0OoOO0OOOOO[159] = 167;
        aap.O0OoOO0OOOOO[292] = 64;
        aap.O0OoOO0OOOOO[375] = 122;
        aap.O0OoOO0OOOOO[113] = -62;
        aap.O0OoOO0OOOOO[360] = -43;
        aap.O0OoOO0OOOOO[8] = 25;
        aap.O0OoOO0OOOOO[104] = -15;
        aap.O0OoOO0OOOOO[331] = -58;
        aap.O0OoOO0OOOOO[301] = 85;
        aap.O0OoOO0OOOOO[246] = 118;
        aap.O0OoOO0OOOOO[229] = 81;
        aap.O0OoOO0OOOOO[142] = 60;
        aap.O0OoOO0OOOOO[314] = -80;
        aap.O0OoOO0OOOOO[112] = 53;
        aap.O0OoOO0OOOOO[55] = 67;
        aap.O0OoOO0OOOOO[11] = -104;
        aap.O0OoOO0OOOOO[369] = -167;
        aap.O0OoOO0OOOOO[15] = 26;
        aap.O0OoOO0OOOOO[346] = 54502;
        aap.O0OoOO0OOOOO[71] = 9;
        aap.O0OoOO0OOOOO[359] = 0;
        aap.O0OoOO0OOOOO[283] = 2;
        aap.O0OoOO0OOOOO[29] = -25;
        aap.O0OoOO0OOOOO[139] = -71;
        aap.O0OoOO0OOOOO[316] = -120;
        aap.O0OoOO0OOOOO[293] = -105;
        aap.O0OoOO0OOOOO[267] = -34;
        aap.O0OoOO0OOOOO[151] = -124;
        aap.O0OoOO0OOOOO[176] = -38;
        aap.O0OoOO0OOOOO[135] = 95;
        aap.O0OoOO0OOOOO[224] = -12;
        aap.O0OoOO0OOOOO[365] = -15;
        aap.O0OoOO0OOOOO[33] = -51;
        aap.O0OoOO0OOOOO[288] = -66;
        aap.O0OoOO0OOOOO[4] = -46;
        aap.O0OoOO0OOOOO[109] = 104;
        aap.O0OoOO0OOOOO[105] = -40;
        aap.O0OoOO0OOOOO[196] = 50;
        aap.O0OoOO0OOOOO[329] = -16;
        aap.O0OoOO0OOOOO[134] = 117;
        aap.O0OoOO0OOOOO[198] = 80;
        aap.O0OoOO0OOOOO[162] = 184;
        aap.O0OoOO0OOOOO[56] = -89;
        aap.O0OoOO0OOOOO[30] = -27;
        aap.O0OoOO0OOOOO[348] = 9482;
        aap.O0OoOO0OOOOO[390] = -130;
        aap.O0OoOO0OOOOO[242] = -87;
        aap.O0OoOO0OOOOO[300] = -71;
        aap.O0OoOO0OOOOO[310] = -75;
        aap.O0OoOO0OOOOO[389] = 74;
        aap.O0OoOO0OOOOO[357] = 58009;
        aap.O0OoOO0OOOOO[205] = 86;
        aap.O0OoOO0OOOOO[100] = -113;
        aap.O0OoOO0OOOOO[6] = 90;
        aap.O0OoOO0OOOOO[305] = 6;
        aap.O0OoOO0OOOOO[175] = 81;
        aap.O0OoOO0OOOOO[69] = 45;
        aap.O0OoOO0OOOOO[384] = -13;
        aap.O0OoOO0OOOOO[166] = -37;
        aap.O0OoOO0OOOOO[59] = 23;
        aap.O0OoOO0OOOOO[143] = 29;
        aap.O0OoOO0OOOOO[9] = -188;
        aap.O0OoOO0OOOOO[40] = 116;
        aap.O0OoOO0OOOOO[249] = 13;
        aap.O0OoOO0OOOOO[63] = -211;
        aap.O0OoOO0OOOOO[147] = 126;
        aap.O0OoOO0OOOOO[207] = -1;
        aap.O0OoOO0OOOOO[86] = -80;
        aap.O0OoOO0OOOOO[39] = 92;
        aap.O0OoOO0OOOOO[327] = 111;
        aap.O0OoOO0OOOOO[41] = 46;
        aap.O0OoOO0OOOOO[388] = -72;
        aap.O0OoOO0OOOOO[117] = 76;
        aap.O0OoOO0OOOOO[296] = -80;
        aap.O0OoOO0OOOOO[302] = -120;
        aap.O0OoOO0OOOOO[20] = -47;
        aap.O0OoOO0OOOOO[3] = -121;
        aap.O0OoOO0OOOOO[248] = -120;
        aap.O0OoOO0OOOOO[137] = 30;
        aap.O0OoOO0OOOOO[89] = -116;
        aap.O0OoOO0OOOOO[138] = -30;
        aap.O0OoOO0OOOOO[92] = 87;
        aap.O0OoOO0OOOOO[153] = 12;
        aap.O0OoOO0OOOOO[114] = 16;
        aap.O0OoOO0OOOOO[178] = 18;
        aap.O0OoOO0OOOOO[119] = -73;
        aap.O0OoOO0OOOOO[17] = 77;
        aap.O0OoOO0OOOOO[102] = 71;
        aap.O0OoOO0OOOOO[216] = -92;
        aap.O0OoOO0OOOOO[383] = 6;
        aap.O0OoOO0OOOOO[154] = 72;
        aap.O0OoOO0OOOOO[70] = 39;
        aap.O0OoOO0OOOOO[243] = -161;
        aap.O0OoOO0OOOOO[204] = -36;
        aap.O0OoOO0OOOOO[60] = 58;
        aap.O0OoOO0OOOOO[297] = -90;
        aap.O0OoOO0OOOOO[108] = -3;
        aap.O0OoOO0OOOOO[325] = 84;
        aap.O0OoOO0OOOOO[187] = 7;
        aap.O0OoOO0OOOOO[210] = 36;
        aap.O0OoOO0OOOOO[34] = -102;
        aap.O0OoOO0OOOOO[241] = 0;
        aap.O0OoOO0OOOOO[54] = -54;
        aap.O0OoOO0OOOOO[174] = 43;
        aap.O0OoOO0OOOOO[253] = -52;
        aap.O0OoOO0OOOOO[236] = -96;
        aap.O0OoOO0OOOOO[284] = 24;
        aap.O0OoOO0OOOOO[366] = 161;
        aap.O0OoOO0OOOOO[273] = -90;
        aap.O0OoOO0OOOOO[268] = 2;
        aap.O0OoOO0OOOOO[278] = -14;
        aap.O0OoOO0OOOOO[211] = -3;
        aap.O0OoOO0OOOOO[149] = 25;
        aap.O0OoOO0OOOOO[287] = 110;
        aap.O0OoOO0OOOOO[345] = 4293;
        aap.O0OoOO0OOOOO[66] = 43;
        aap.O0OoOO0OOOOO[141] = 121;
        aap.O0OoOO0OOOOO[367] = -35;
        aap.O0OoOO0OOOOO[128] = 126;
        aap.O0OoOO0OOOOO[394] = 100;
        aap.O0OoOO0OOOOO[289] = 74;
        aap.O0OoOO0OOOOO[2] = -107;
        aap.O0OoOO0OOOOO[80] = -106;
        aap.O0OoOO0OOOOO[363] = 24;
        aap.O0OoOO0OOOOO[294] = -155;
        aap.O0OoOO0OOOOO[50] = -48;
        aap.O0OoOO0OOOOO[28] = -17;
        aap.O0OoOO0OOOOO[123] = -150;
        aap.O0OoOO0OOOOO[377] = 12;
        aap.O0OoOO0OOOOO[309] = -137;
        aap.O0OoOO0OOOOO[343] = 748;
        aap.O0OoOO0OOOOO[193] = -61;
        aap.O0OoOO0OOOOO[313] = 53;
        aap.O0OoOO0OOOOO[245] = -123;
        aap.O0OoOO0OOOOO[21] = 78;
        aap.O0OoOO0OOOOO[118] = -37;
        aap.O0OoOO0OOOOO[168] = 54;
        aap.O0OoOO0OOOOO[140] = 9;
        aap.O0OoOO0OOOOO[347] = 25288;
        aap.O0OoOO0OOOOO[317] = 59;
        aap.O0OoOO0OOOOO[332] = 111;
        aap.O0OoOO0OOOOO[226] = 23;
        aap.O0OoOO0OOOOO[328] = -95;
        aap.O0OoOO0OOOOO[298] = -116;
        aap.O0OoOO0OOOOO[349] = 30223;
        aap.O0OoOO0OOOOO[311] = -63;
        aap.O0OoOO0OOOOO[396] = -70;
        aap.O0OoOO0OOOOO[303] = -88;
        aap.O0OoOO0OOOOO[295] = 80;
        aap.O0OoOO0OOOOO[190] = -74;
        aap.O0OoOO0OOOOO[179] = -71;
        aap.O0OoOO0OOOOO[99] = -111;
        aap.O0OoOO0OOOOO[165] = 149;
        aap.O0OoOO0OOOOO[286] = -115;
        aap.O0OoOO0OOOOO[336] = 3;
        aap.O0OoOO0OOOOO[173] = -105;
        aap.O0OoOO0OOOOO[271] = -59;
        aap.O0OoOO0OOOOO[374] = -55;
        aap.O0OoOO0OOOOO[269] = -56;
        aap.O0OoOO0OOOOO[376] = -102;
        aap.O0OoOO0OOOOO[72] = 79;
        aap.O0OoOO0OOOOO[136] = 33;
        aap.O0OoOO0OOOOO[398] = 102;
        aap.O0OoOO0OOOOO[341] = 0;
        aap.O0OoOO0OOOOO[281] = -25;
        aap.O0OoOO0OOOOO[94] = 16;
        aap.O0OoOO0OOOOO[156] = -42;
        aap.O0OoOO0OOOOO[23] = -61;
        aap.O0OoOO0OOOOO[212] = -45;
        aap.O0OoOO0OOOOO[51] = -81;
        aap.O0OoOO0OOOOO[68] = 31;
        aap.O0OoOO0OOOOO[304] = -70;
        aap.O0OoOO0OOOOO[206] = 57;
        aap.O0OoOO0OOOOO[157] = 58;
        aap.O0OoOO0OOOOO[115] = -45;
        aap.O0OoOO0OOOOO[200] = 119;
        aap.O0OoOO0OOOOO[260] = -126;
        aap.O0OoOO0OOOOO[285] = -243;
        aap.O0OoOO0OOOOO[264] = 66;
        aap.O0OoOO0OOOOO[186] = -88;
        aap.O0OoOO0OOOOO[1] = 20;
        aap.O0OoOO0OOOOO[75] = 35;
        aap.O0OoOO0OOOOO[164] = -62;
        aap.O0OoOO0OOOOO[5] = 79;
        aap.O0OoOO0OOOOO[221] = 68;
        aap.O0OoOO0OOOOO[26] = 21;
        aap.O0OoOO0OOOOO[121] = -7;
        aap.O0OoOO0OOOOO[392] = -57;
        aap.O0OoOO0OOOOO[22] = -100;
        aap.O0OoOO0OOOOO[145] = -84;
        aap.O0OoOO0OOOOO[96] = -233;
        aap.O0OoOO0OOOOO[397] = 0;
        aap.O0OoOO0OOOOO[116] = -63;
        aap.O0OoOO0OOOOO[46] = -50;
        aap.O0OoOO0OOOOO[259] = 115;
        aap.O0OoOO0OOOOO[240] = 108;
        aap.O0OoOO0OOOOO[265] = -8;
        aap.O0OoOO0OOOOO[197] = -79;
        aap.O0OoOO0OOOOO[234] = 140;
        aap.O0OoOO0OOOOO[19] = 77;
        aap.O0OoOO0OOOOO[161] = 95;
        aap.O0OoOO0OOOOO[238] = 24;
        aap.O0OoOO0OOOOO[323] = 108;
        aap.O0OoOO0OOOOO[202] = 18;
        aap.O0OoOO0OOOOO[373] = -5;
        aap.O0OoOO0OOOOO[258] = -16;
        aap.O0OoOO0OOOOO[129] = 10;
        aap.O0OoOO0OOOOO[215] = 95;
        aap.O0OoOO0OOOOO[378] = 80;
        aap.O0OoOO0OOOOO[337] = 0;
        aap.O0OoOO0OOOOO[101] = 30;
        aap.O0OoOO0OOOOO[322] = -39;
        aap.O0OoOO0OOOOO[0] = -79;
        aap.O0OoOO0OOOOO[58] = -119;
        aap.O0OoOO0OOOOO[231] = 122;
        aap.O0OoOO0OOOOO[227] = -45;
        aap.O0OoOO0OOOOO[279] = 88;
        aap.O0OoOO0OOOOO[47] = -43;
        aap.O0OoOO0OOOOO[12] = 10;
        aap.O0OoOO0OOOOO[330] = -73;
        aap.O0OoOO0OOOOO[257] = 12;
        aap.O0OoOO0OOOOO[326] = -71;
        aap.O0OoOO0OOOOO[84] = -70;
        aap.O0OoOO0OOOOO[352] = 9012;
        aap.O0OoOO0OOOOO[324] = 13;
        aap.O0OoOO0OOOOO[107] = -45;
        aap.O0OoOO0OOOOO[263] = 77;
        aap.O0OoOO0OOOOO[368] = -94;
        aap.O0OoOO0OOOOO[199] = 71;
        aap.O0OoOO0OOOOO[181] = -36;
        aap.O0OoOO0OOOOO[194] = 109;
        aap.O0OoOO0OOOOO[217] = -119;
        aap.O0OoOO0OOOOO[42] = -97;
        aap.O0OoOO0OOOOO[183] = 113;
        aap.O0OoOO0OOOOO[189] = -39;
        aap.O0OoOO0OOOOO[18] = 156;
        aap.O0OoOO0OOOOO[160] = 46;
        aap.O0OoOO0OOOOO[74] = -58;
        aap.O0OoOO0OOOOO[364] = 71;
        aap.O0OoOO0OOOOO[152] = 11;
        aap.O0OoOO0OOOOO[73] = 115;
        aap.O0OoOO0OOOOO[167] = -110;
        aap.O0OoOO0OOOOO[43] = 82;
        aap.O0OoOO0OOOOO[225] = -21;
        aap.O0OoOO0OOOOO[61] = -52;
        aap.O0OoOO0OOOOO[103] = 24;
        aap.O0OoOO0OOOOO[130] = 25;
        aap.O0OoOO0OOOOO[64] = -82;
        aap.O0OoOO0OOOOO[342] = 0;
        aap.O0OoOO0OOOOO[222] = 81;
        aap.O0OoOO0OOOOO[351] = 22385;
        aap.O0OoOO0OOOOO[251] = 110;
        aap.O0OoOO0OOOOO[144] = 39;
        aap.O0OoOO0OOOOO[361] = 69;
        aap.O0OoOO0OOOOO[79] = -2;
        aap.O0OoOO0OOOOO[290] = -14;
        aap.O0OoOO0OOOOO[25] = 16;
        aap.O0OoOO0OOOOO[228] = -41;
        aap.O0OoOO0OOOOO[184] = 5;
        aap.O0OoOO0OOOOO[306] = -108;
        aap.O0OoOO0OOOOO[362] = -80;
        aap.O0OoOO0OOOOO[133] = -38;
        aap.O0OoOO0OOOOO[77] = -127;
        aap.O0OoOO0OOOOO[81] = 83;
        aap.O0OoOO0OOOOO[111] = 147;
        aap.O0OoOO0OOOOO[182] = -23;
        aap.O0OoOO0OOOOO[98] = -121;
        aap.O0OoOO0OOOOO[65] = 116;
        aap.O0OoOO0OOOOO[340] = 2;
        aap.O0OoOO0OOOOO[191] = 111;
        aap.O0OoOO0OOOOO[280] = -113;
        aap.O0OoOO0OOOOO[13] = -49;
        aap.O0OoOO0OOOOO[308] = -61;
        aap.O0OoOO0OOOOO[354] = 3512;
        aap.O0OoOO0OOOOO[93] = 142;
        aap.O0OoOO0OOOOO[247] = -2;
        aap.O0OoOO0OOOOO[110] = 109;
        aap.O0OoOO0OOOOO[132] = 123;
        aap.O0OoOO0OOOOO[38] = 10;
        aap.O0OoOO0OOOOO[380] = -32;
        aap.O0OoOO0OOOOO[27] = -10;
        aap.O0OoOO0OOOOO[214] = -4;
        aap.O0OoOO0OOOOO[275] = 47;
        aap.O0OoOO0OOOOO[266] = 40;
        aap.O0OoOO0OOOOO[48] = -66;
        aap.O0OoOO0OOOOO[321] = 147;
        aap.O0OoOO0OOOOO[171] = -9;
        aap.O0OoOO0OOOOO[45] = 59;
        aap.O0OoOO0OOOOO[203] = 98;
        aap.O0OoOO0OOOOO[223] = 68;
        aap.O0OoOO0OOOOO[83] = 107;
        aap.O0OoOO0OOOOO[91] = -17;
        aap.O0OoOO0OOOOO[335] = -79;
        aap.O0OoOO0OOOOO[14] = -7;
        aap.O0OoOO0OOOOO[291] = 54;
        aap.O0OoOO0OOOOO[395] = -61;
        aap.O0OoOO0OOOOO[262] = -23;
        aap.O0OoOO0OOOOO[35] = 71;
        aap.O0OoOO0OOOOO[353] = 27928;
        aap.O0OoOO0OOOOO[44] = -47;
        aap.O0OoOO0OOOOO[252] = -42;
        aap.O0OoOO0OOOOO[276] = 7;
        aap.O0OoOO0OOOOO[37] = -2;
        aap.O0OoOO0OOOOO[52] = -39;
        aap.O0OoOO0OOOOO[256] = 4;
        aap.O0OoOO0OOOOO[244] = 39;
        aap.O0OoOO0OOOOO[36] = 29;
        aap.O0OoOO0OOOOO[344] = 20768;
        aap.O0OoOO0OOOOO[32] = -28;
        aap.O0OoOO0OOOOO[355] = 2392;
        aap.O0OoOO0OOOOO[261] = -119;
        aap.O0OoOO0OOOOO[170] = 28;
        aap.O0OoOO0OOOOO[312] = -128;
        aap.O0OoOO0OOOOO[239] = 57;
        aap.O0OoOO0OOOOO[299] = 22;
        aap.O0OoOO0OOOOO[127] = 118;
        aap.O0OoOO0OOOOO[315] = 71;
        aap.O0OoOO0OOOOO[201] = 81;
        aap.O0OoOO0OOOOO[233] = -25;
        aap.O0OoOO0OOOOO[371] = -76;
        aap.O0OoOO0OOOOO[307] = -67;
        aap.O0OoOO0OOOOO[185] = 76;
        aap.O0OoOO0OOOOO[382] = 52;
        aap.O0OoOO0OOOOO[85] = 42;
        aap.O0OoOO0OOOOO[255] = 40;
        aap.O0OoOO0OOOOO[146] = -85;
        aap.O0OoOO0OOOOO[320] = 110;
        aap.O0OoOO0OOOOO[208] = -34;
        aap.O0OoOO0OOOOO[338] = 1;
        aap.O0OoOO0OOOOO[76] = -126;
        aap.O0OoOO0OOOOO[381] = -14;
        aap.O0OoOO0OOOOO[24] = -4;
        aap.O0OoOO0OOOOO[399] = 63;
        aap.O0OoOO0OOOOO[188] = -127;
        aap.O0OoOO0OOOOO[16] = 83;
        aap.O0OoOO0OOOOO[272] = 124;
        aap.O0OoOO0OOOOO[150] = -81;
        aap.O0OoOO0OOOOO[230] = -118;
        aap.O0OoOO0OOOOO[180] = 48;
        aap.O0OoOO0OOOOO[172] = -99;
        aap.O0OoOO0OOOOO[209] = 38;
        aap.O0OoOO0OOOOO[213] = 123;
        aap.O0OoOO0OOOOO[120] = 104;
        aap.O0OoOO0OOOOO[370] = -92;
        aap.O0OoOO0OOOOO[219] = -156;
        aap.O0OoOO0OOOOO[49] = -20;
        aap.O0OoOO0OOOOO[124] = 121;
        aap.O0OoOO0OOOOO[232] = -65;
        aap.O0OoOO0OOOOO[163] = -117;
        aap.O0OoOO0OOOOO[339] = 0;
        aap.O0OoOO0OOOOO[31] = -27;
        aap.O0OoOO0OOOOO[277] = -7;
        aap.O0OoOO0OOOOO[386] = 29;
        aap.O0OoOO0OOOOO[106] = 43;
        aap.O0OoOO0OOOOO[67] = 3;
        aap.O0OoOO0OOOOO[385] = -74;
        aap.O0OoOO0OOOOO[218] = 59;
        aap.O0OoOO0OOOOO[10] = 116;
        aap.O0OoOO0OOOOO[333] = -5;
        aap.O0OoOO0OOOOO[155] = -59;
        aap.O0OoOO0OOOOO[379] = -79;
    }

    @Override
    public void mouseClicked(final int n, final int n2, final int n3) {
        final long n4 = -8667487250350770505L;
        final long n5 = 4612836758129553145L;
        if (this.menuButtons == null) {
            return;
        }
        if (n3 == 0) {
            final adh[] menuButtons = this.menuButtons;
            final long n6 = menuButtons.length;
            final long n7 = n4;
            final long n8 = n7 ^ ((n6 ^ n7) & -1L >>> 32);
            final long n9 = 0L;
            final long n10 = n5;
            for (long n11 = n10 ^ ((n9 ^ n10) & -1L << 32); (int)(n11 >>> 32) < (int)n8; n11 += 4294967296L) {
                final adh adh = menuButtons[(int)(n11 >>> 32)];
                if (aeb.a(adh.getX(), adh.getY(), adh.oM(), adh.da(), n, n2)) {
                    adh.rm();
                    break;
                }
            }
            this.aCy.d(n, n2, n3);
        }
    }

    @Override
    public void keyTyped(char c2, int n) {
        this.aCy.b(c2, n);
        if (n != 15) {
            if (n != 28) return;
            if (this.aCy.getText().isEmpty()) return;
            this.aCx.rm();
            return;
        }
        this.aCy.I(!this.aCy.tO());
    }

    public void aW(String string) {
        long l3 = 5085688074218688810L;
        if (this.aCz) {
            return;
        }
        try {
            String string2 = aju.vW();
            if (this.aCB != null) {
                this.aCB.equals(string2);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        //add code
        if (NetworkToggles.versionCheck()) {
            block59: while (true) {
                try {
                    if (this.aCA == null) {
                        this.rp();
                    }
                    String[] stringArray = "6.9.5".split("\\.");
                    String[] stringArray2 = this.aCA.split("\\.");
                    long l4 = l3;
                    l3 = l4 ^ (0L ^ l4) & -1L << 32;
                    while ((int)(l3 >>> 32) < 2) {
                        if (Float.parseFloat(stringArray[(int)(l3 >>> 32)]) < Float.parseFloat(stringArray2[(int)(l3 >>> 32)])) {
                            System.out.println("A newer version is available please update your client on https://Vantage.Rip");
                            this.aX("A newer version is available please update your client on https://Vantage.Rip");
                            return;
                        }
                        try {
                            l3 += 0x100000000L;
                        } catch (Exception exception) {
                            exception.printStackTrace();
                            break;
                        }
                    }
                    break block59;
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
        rip.vantage.network.core.a.aKB().kj(string);
        rip.vantage.network.core.a.aKB().aKI();
        this.aCz = true;
        this.bN.aX();
    }

    public void aX(String string) {
        this.jc = string;
        this.bN.aX();
        this.aCz = false;
    }

    public aap() {
        this.aCv = new Animation(Easing.EASE_IN_OUT_CUBIC, 3000L);
        this.bN = new a();
        this.aCE = er2 -> {
            String string;
            String string2;
            rip.vantage.commons.packet.impl.server.protection.b b2 = null;
            long l4 = 6187545175897021594L;
            long l5 = 2076766356004144021L;
            if (!(er2.dd() instanceof rip.vantage.commons.packet.impl.server.protection.b)) return;
            b2 = (rip.vantage.commons.packet.impl.server.protection.b)er2.dd();
            System.out.println("Auth");
            rip.vantage.network.handler.c.eRC.aX();
            long l6 = l4;
            l4 = l6 ^ ((b2.aKi() ? 1L : 0L) << 32 ^ l6) & -1L << 32;
            this.aCC = false;
            if ((int)(l4 >>> 32) != 0 && (string2 = b2.aKh()) != null && !string2.isEmpty() && !rip.vantage.security.l.aL(string = aju.vW(), string2)) {
                System.out.println("EC61");
                long l7 = l4;
                l4 = l7 ^ (0L ^ l7) & -1L << 32;
                this.aCC = true;
                StringSelection stringSelection = new StringSelection(string);
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, new StringSelection("Rise"));
            }
            if ((int)(l4 >>> 32) != 0 && !rip.vantage.security.l.cV((int)(l4 >>> 32) != 0)) {
                System.out.println("EC92");
                System.exit(1);
                Runtime.getRuntime().halt(1);
                throw new SecurityException("EC92");
            }
            if ((int)(l4 >>> 32) != 0) {
                this.aCB = null;
                this.aCD = false;
                aEg.displayGuiScreen(new adr());
                Client.a.p().tn();
                return;
            }
            this.aX(b2.aKn());
            String string3 = null;
            string3 = aju.vW();
            StringSelection stringSelection = new StringSelection(string3);
            java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, new StringSelection("Rise"));
            long l8 = l5;
            l5 = l8 ^ ((long)(this.aCC || b2.aKn() != null && b2.aKn().equalsIgnoreCase("HWID_MISMATCH") ? 1 : 0) << 32 ^ l8) & -1L << 32;
            if ((int)(l5 >>> 32) == 0) return;
            if (this.aCD) return;
            this.aCD = true;
            this.aCB = string3;
            try {
                java.awt.Desktop.getDesktop().browse(new java.net.URI("https://youtu.be/jeYDms69hBo"));
            } catch (java.io.IOException | java.net.URISyntaxException e) {
                e.printStackTrace();
            }
        };
        Client.a.e().b(this);
    }

    @Override
    public void onGuiClosed() {
        Client.a.e().c(this);
    }

    //add code
    public void rp() {
        this.aCA = OfflineMode.offline()
            ? null
            : aec.aY("https://raw.githubusercontent.com/risellc/LatestRiseVersion/main/Version");
    }

    @Override
    public void initGui() {
        long l2;
        long l8 = -6610901742768452103L;
        long l9 = 4695415886190673032L;
        long l10 = -3848389860043264573L;
        long l11 = -2088766917341031741L;
        long l12 = l2 = -6408109000536517085L;
        long l13 = l12 ^ ((long)(this.width / 2) ^ l12) & -1L >>> 32;
        long l14 = l8;
        long l15 = l14 ^ ((long)(this.height / 2) << 32 ^ l14) & -1L << 32;
        long l16 = l11;
        long l17 = l16 ^ (0xB4L ^ l16) & -1L >>> 32;
        long l18 = l13;
        long l19 = l18 ^ (0x1800000000L ^ l18) & -1L << 32;
        long l20 = l17;
        long l21 = l20 ^ (0x600000000L ^ l20) & -1L << 32;
        long l22 = l9;
        long l23 = l22 ^ ((long)((int)l19 - (int)l21 / 2) ^ l22) & -1L >>> 32;
        long l24 = l10;
        long l25 = l24 ^ ((long)((int)(l15 >>> 32) - (int)(l19 >>> 32) / 2 - (int)(l21 >>> 32) / 2 - (int)(l19 >>> 32) / 2) << 32 ^ l24) & -1L << 32;
        this.aCw = new adm((int)l23, (int)(l25 >>> 32), (int)l21, (int)(l19 >>> 32), () -> {}, "");
        this.aCx = new adm((int)l23, (int)(l25 >>> 32) + (int)(l19 >>> 32) + (int)(l21 >>> 32), (int)l21, (int)(l19 >>> 32), () -> this.aW(this.aCy.getText()), "Login");
        this.aCy = new agm(new Vector2d((int)l19, (int)(l25 >>> 32) + 9), gb.MAIN.a(24, gd.BOLD), Color.WHITE, agl.CENTER, "Username", (int)l21 * 5);
        this.animation = new Animation(Easing.EASE_OUT_QUINT, 600L);
        this.menuButtons = new adh[]{this.aCw, this.aCx};
        this.aCv.T(255.0);
        this.aCv.reset();
        this.aCz = false;
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        if (this.aCv.sG() < 255.0) {
            aiv.aPL.a(aiz.OVERLAY, f, null);
        }
        ScaledResolution scaledResolution = aap.aEg.jY;
        this.b(gg.BLUR).c(() -> RenderUtil.d(0.0, 0.0, scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight(), Color.BLACK));
        this.aCw.c(n, n2, f);
        this.aCx.c(n, n2, f);
        this.b(gg.REGULAR).c(() -> {
            double d = 0.0;
            this.aCy.pJ();
            double d3 = this.aCw.getY() - (double)this.aCu.tq();
            this.animation.Q(d3);
            double d4 = this.animation.sG();
            Color color = aip.d(Color.WHITE, (int)(d4 / d3 * 200.0));
            this.aCu.c("Welcome", (float)this.width / 2.0f, d4 - 10.0, color.getRGB());
            if (this.bN.T(3000L)) {
                if (this.aCz) {
                    try {
                        String string = aju.vW();
                        StringSelection stringSelection = new StringSelection(string);
                        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, new StringSelection("Rise"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    this.aX("Login is taking longer than expected. HWID copied to clipboard.");
                }
                this.aCz = false;
            } else if (this.jc != null) {
                gb.MAIN.a(18, gd.LIGHT).c(this.jc, (float)this.width / 2.0f, d4 + 26.0, Color.RED.getRGB());
            }
            gb.MAIN.a(18, gd.REGULAR).d("Made with <3 by Alan and The_Bi11iona1re", scaledResolution.getScaledWidth() - 5, scaledResolution.getScaledHeight() - 20, aip.d(aBS, 100).getRGB());
            gb.MAIN.a(12, gd.REGULAR).d("\u00a9 Rise Client 2026. All Rights Reserved", scaledResolution.getScaledWidth() - 5, scaledResolution.getScaledHeight() - 10, aip.d(aBS, 100).getRGB());
            this.aCv.Q(0.0);
            RenderUtil.d(0.0, 0.0, aap.aEg.displayWidth, aap.aEg.displayHeight, new Color(0, 0, 0, (int)this.aCv.sG()));
        });
    }
}
