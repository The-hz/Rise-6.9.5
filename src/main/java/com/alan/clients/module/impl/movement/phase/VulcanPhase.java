package com.alan.clients.module.impl.movement.phase;

import com.alan.clients.module.impl.movement.Phase;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.PushOutOfBlockEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.other.BlockAABBEvent;
import com.alan.clients.newevent.impl.other.TickEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import hackclient.rise.afi;
import hackclient.rise.aih;
import hackclient.rise.aik;
import hackclient.rise.cl;
import net.minecraft.block.BlockAir;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.potion.Potion;
import net.minecraft.util.AxisAlignedBB;

public class VulcanPhase extends Mode<Phase> {
    @EventLink
    public Listener<BlockAABBEvent> Ok;
    public boolean Oi;
    public boolean El;
    @EventLink
    public Listener<PushOutOfBlockEvent> Oo;
    public static int[] O0OoOO0OOOOO;
    public int Og;
    public int qH;
    public int Oh;
    public boolean ys = false;
    public boolean Jq;
    public boolean GQ;
    public boolean JM = false;
    @EventLink
    public Listener<TickEvent> Ol;
    @EventLink
    public Listener<PacketReceiveEvent> On;
    @EventLink
    public Listener<PreMotionEvent> Oj;
    @EventLink
    public Listener<StrafeEvent> Om;

    static {
        Oo0o00000O00();
    }

    @Override
    public void onDisable() {
        this.JM = false;
    }

    public static void Oo0o00000O00() {
        O0OoOO0OOOOO = new int[400];
        O0OoOO0OOOOO[371] = -39555;
        O0OoOO0OOOOO[179] = -65;
        O0OoOO0OOOOO[24] = 162;
        O0OoOO0OOOOO[114] = -44;
        O0OoOO0OOOOO[239] = 43982;
        O0OoOO0OOOOO[205] = -156;
        O0OoOO0OOOOO[397] = 23224;
        O0OoOO0OOOOO[313] = 52643;
        O0OoOO0OOOOO[380] = 51187;
        O0OoOO0OOOOO[197] = 99;
        O0OoOO0OOOOO[48] = 29;
        O0OoOO0OOOOO[186] = -126;
        O0OoOO0OOOOO[359] = -10604;
        O0OoOO0OOOOO[267] = 54871;
        O0OoOO0OOOOO[78] = 72;
        O0OoOO0OOOOO[290] = 54367;
        O0OoOO0OOOOO[171] = -124;
        O0OoOO0OOOOO[9] = -104;
        O0OoOO0OOOOO[129] = 28;
        O0OoOO0OOOOO[285] = 16695;
        O0OoOO0OOOOO[291] = 54281;
        O0OoOO0OOOOO[4] = 119;
        O0OoOO0OOOOO[182] = 7;
        O0OoOO0OOOOO[31] = -20;
        O0OoOO0OOOOO[195] = 111;
        O0OoOO0OOOOO[27] = -43;
        O0OoOO0OOOOO[241] = 43982;
        O0OoOO0OOOOO[281] = 20862;
        O0OoOO0OOOOO[61] = -118;
        O0OoOO0OOOOO[287] = 54365;
        O0OoOO0OOOOO[303] = 50480;
        O0OoOO0OOOOO[246] = 29260;
        O0OoOO0OOOOO[152] = 58676;
        O0OoOO0OOOOO[316] = 52655;
        O0OoOO0OOOOO[57] = 117;
        O0OoOO0OOOOO[221] = 64440;
        O0OoOO0OOOOO[217] = 1;
        O0OoOO0OOOOO[164] = -93;
        O0OoOO0OOOOO[235] = 23066;
        O0OoOO0OOOOO[92] = 21;
        O0OoOO0OOOOO[343] = -30673;
        O0OoOO0OOOOO[75] = 21;
        O0OoOO0OOOOO[177] = 13;
        O0OoOO0OOOOO[53] = -125;
        O0OoOO0OOOOO[331] = 69219;
        O0OoOO0OOOOO[294] = 49924;
        O0OoOO0OOOOO[105] = 237;
        O0OoOO0OOOOO[79] = -22;
        O0OoOO0OOOOO[315] = 52657;
        O0OoOO0OOOOO[180] = 6;
        O0OoOO0OOOOO[123] = -60;
        O0OoOO0OOOOO[321] = 7306;
        O0OoOO0OOOOO[266] = 54870;
        O0OoOO0OOOOO[74] = -97;
        O0OoOO0OOOOO[69] = -74;
        O0OoOO0OOOOO[54] = -14;
        O0OoOO0OOOOO[384] = 14383;
        O0OoOO0OOOOO[67] = -40;
        O0OoOO0OOOOO[6] = -31;
        O0OoOO0OOOOO[59] = -69;
        O0OoOO0OOOOO[183] = 62;
        O0OoOO0OOOOO[174] = 43;
        O0OoOO0OOOOO[301] = 50528;
        O0OoOO0OOOOO[289] = 54340;
        O0OoOO0OOOOO[47] = 70;
        O0OoOO0OOOOO[192] = -87;
        O0OoOO0OOOOO[254] = 66711;
        O0OoOO0OOOOO[224] = -33281;
        O0OoOO0OOOOO[143] = 44961;
        O0OoOO0OOOOO[341] = 30617;
        O0OoOO0OOOOO[398] = 23222;
        O0OoOO0OOOOO[228] = -32449;
        O0OoOO0OOOOO[248] = 29189;
        O0OoOO0OOOOO[26] = 76;
        O0OoOO0OOOOO[198] = -102;
        O0OoOO0OOOOO[66] = -9;
        O0OoOO0OOOOO[134] = 118;
        O0OoOO0OOOOO[56] = -78;
        O0OoOO0OOOOO[146] = 31781;
        O0OoOO0OOOOO[189] = 93;
        O0OoOO0OOOOO[96] = -46;
        O0OoOO0OOOOO[45] = -102;
        O0OoOO0OOOOO[97] = -76;
        O0OoOO0OOOOO[196] = -39;
        O0OoOO0OOOOO[80] = -126;
        O0OoOO0OOOOO[148] = 2698;
        O0OoOO0OOOOO[86] = -78;
        O0OoOO0OOOOO[243] = 25367;
        O0OoOO0OOOOO[247] = 29259;
        O0OoOO0OOOOO[37] = 1;
        O0OoOO0OOOOO[83] = -92;
        O0OoOO0OOOOO[16] = 115;
        O0OoOO0OOOOO[387] = -44018;
        O0OoOO0OOOOO[225] = 33403;
        O0OoOO0OOOOO[15] = -117;
        O0OoOO0OOOOO[170] = 27;
        O0OoOO0OOOOO[73] = 96;
        O0OoOO0OOOOO[34] = 100;
        O0OoOO0OOOOO[206] = -18;
        O0OoOO0OOOOO[393] = 64662;
        O0OoOO0OOOOO[168] = -96;
        O0OoOO0OOOOO[17] = -8;
        O0OoOO0OOOOO[165] = -46;
        O0OoOO0OOOOO[308] = 39434;
        O0OoOO0OOOOO[333] = 10925;
        O0OoOO0OOOOO[178] = -103;
        O0OoOO0OOOOO[292] = 54367;
        O0OoOO0OOOOO[335] = 10980;
        O0OoOO0OOOOO[18] = -8;
        O0OoOO0OOOOO[233] = 67643;
        O0OoOO0OOOOO[286] = 0;
        O0OoOO0OOOOO[297] = 42601;
        O0OoOO0OOOOO[14] = -92;
        O0OoOO0OOOOO[330] = 69133;
        O0OoOO0OOOOO[259] = 21853;
        O0OoOO0OOOOO[237] = 23066;
        O0OoOO0OOOOO[204] = -122;
        O0OoOO0OOOOO[115] = -99;
        O0OoOO0OOOOO[222] = 33401;
        O0OoOO0OOOOO[278] = 20856;
        O0OoOO0OOOOO[234] = 23057;
        O0OoOO0OOOOO[94] = 100;
        O0OoOO0OOOOO[3] = -10;
        O0OoOO0OOOOO[43] = 121;
        O0OoOO0OOOOO[167] = -46;
        O0OoOO0OOOOO[351] = 9197;
        O0OoOO0OOOOO[280] = -20752;
        O0OoOO0OOOOO[112] = -1;
        O0OoOO0OOOOO[277] = 37796;
        O0OoOO0OOOOO[364] = 7162;
        O0OoOO0OOOOO[260] = 21819;
        O0OoOO0OOOOO[203] = -19;
        O0OoOO0OOOOO[378] = 51187;
        O0OoOO0OOOOO[377] = 51196;
        O0OoOO0OOOOO[88] = 53;
        O0OoOO0OOOOO[298] = 42594;
        O0OoOO0OOOOO[113] = 62;
        O0OoOO0OOOOO[353] = 40126;
        O0OoOO0OOOOO[340] = 45506;
        O0OoOO0OOOOO[124] = -55;
        O0OoOO0OOOOO[131] = -72;
        O0OoOO0OOOOO[60] = -158;
        O0OoOO0OOOOO[370] = 39634;
        O0OoOO0OOOOO[209] = -125;
        O0OoOO0OOOOO[311] = -40223;
        O0OoOO0OOOOO[368] = 33998;
        O0OoOO0OOOOO[135] = 3;
        O0OoOO0OOOOO[163] = 81;
        O0OoOO0OOOOO[350] = 9136;
        O0OoOO0OOOOO[355] = 40132;
        O0OoOO0OOOOO[295] = 50020;
        O0OoOO0OOOOO[346] = 30775;
        O0OoOO0OOOOO[81] = -117;
        O0OoOO0OOOOO[117] = 45;
        O0OoOO0OOOOO[22] = -81;
        O0OoOO0OOOOO[193] = 72;
        O0OoOO0OOOOO[58] = -50;
        O0OoOO0OOOOO[338] = 45506;
        O0OoOO0OOOOO[41] = 44;
        O0OoOO0OOOOO[283] = 16695;
        O0OoOO0OOOOO[157] = 139;
        O0OoOO0OOOOO[391] = 51095;
        O0OoOO0OOOOO[128] = 85;
        O0OoOO0OOOOO[5] = 109;
        O0OoOO0OOOOO[373] = 22769;
        O0OoOO0OOOOO[226] = 32496;
        O0OoOO0OOOOO[139] = 2;
        O0OoOO0OOOOO[181] = -23;
        O0OoOO0OOOOO[271] = 44829;
        O0OoOO0OOOOO[0] = -210;
        O0OoOO0OOOOO[238] = 43982;
        O0OoOO0OOOOO[322] = 7318;
        O0OoOO0OOOOO[362] = 7162;
        O0OoOO0OOOOO[367] = -34016;
        O0OoOO0OOOOO[326] = 6498;
        O0OoOO0OOOOO[305] = 39443;
        O0OoOO0OOOOO[214] = 1;
        O0OoOO0OOOOO[369] = 39640;
        O0OoOO0OOOOO[72] = -192;
        O0OoOO0OOOOO[375] = 22667;
        O0OoOO0OOOOO[51] = 53;
        O0OoOO0OOOOO[137] = 1;
        O0OoOO0OOOOO[273] = 44829;
        O0OoOO0OOOOO[317] = 69298;
        O0OoOO0OOOOO[210] = 30;
        O0OoOO0OOOOO[231] = 67643;
        O0OoOO0OOOOO[87] = -63;
        O0OoOO0OOOOO[348] = 30775;
        O0OoOO0OOOOO[274] = 37805;
        O0OoOO0OOOOO[162] = -95;
        O0OoOO0OOOOO[216] = 0;
        O0OoOO0OOOOO[10] = 64;
        O0OoOO0OOOOO[213] = -13;
        O0OoOO0OOOOO[199] = 104;
        O0OoOO0OOOOO[352] = 9136;
        O0OoOO0OOOOO[323] = -7399;
        O0OoOO0OOOOO[8] = 11;
        O0OoOO0OOOOO[250] = 40774;
        O0OoOO0OOOOO[383] = -14408;
        O0OoOO0OOOOO[32] = 44;
        O0OoOO0OOOOO[227] = 32501;
        O0OoOO0OOOOO[390] = 51198;
        O0OoOO0OOOOO[149] = 30796;
        O0OoOO0OOOOO[120] = -94;
        O0OoOO0OOOOO[107] = 111;
        O0OoOO0OOOOO[307] = 39535;
        O0OoOO0OOOOO[118] = -49;
        O0OoOO0OOOOO[358] = 10589;
        O0OoOO0OOOOO[25] = -85;
        O0OoOO0OOOOO[242] = 25375;
        O0OoOO0OOOOO[30] = -63;
        O0OoOO0OOOOO[194] = 71;
        O0OoOO0OOOOO[229] = 32501;
        O0OoOO0OOOOO[185] = 9;
        O0OoOO0OOOOO[103] = -100;
        O0OoOO0OOOOO[150] = 55982;
        O0OoOO0OOOOO[188] = 67;
        O0OoOO0OOOOO[374] = 22776;
        O0OoOO0OOOOO[104] = 99;
        O0OoOO0OOOOO[36] = -73;
        O0OoOO0OOOOO[394] = 64670;
        O0OoOO0OOOOO[296] = 49924;
        O0OoOO0OOOOO[256] = -66789;
        O0OoOO0OOOOO[219] = 0;
        O0OoOO0OOOOO[156] = 0;
        O0OoOO0OOOOO[318] = 69296;
        O0OoOO0OOOOO[147] = 16903;
        O0OoOO0OOOOO[158] = -52;
        O0OoOO0OOOOO[155] = 55806;
        O0OoOO0OOOOO[344] = 30605;
        O0OoOO0OOOOO[20] = 74;
        O0OoOO0OOOOO[125] = -8;
        O0OoOO0OOOOO[334] = 10924;
        O0OoOO0OOOOO[126] = -85;
        O0OoOO0OOOOO[252] = -40823;
        O0OoOO0OOOOO[42] = 91;
        O0OoOO0OOOOO[106] = -126;
        O0OoOO0OOOOO[173] = -24;
        O0OoOO0OOOOO[175] = -62;
        O0OoOO0OOOOO[385] = 43954;
        O0OoOO0OOOOO[363] = -7074;
        O0OoOO0OOOOO[328] = 6498;
        O0OoOO0OOOOO[381] = 14392;
        O0OoOO0OOOOO[68] = 43;
        O0OoOO0OOOOO[77] = 93;
        O0OoOO0OOOOO[299] = 42572;
        O0OoOO0OOOOO[257] = 66713;
        O0OoOO0OOOOO[232] = -67609;
        O0OoOO0OOOOO[76] = -42;
        O0OoOO0OOOOO[140] = 0;
        O0OoOO0OOOOO[44] = -30;
        O0OoOO0OOOOO[144] = 48930;
        O0OoOO0OOOOO[19] = -82;
        O0OoOO0OOOOO[324] = 7318;
        O0OoOO0OOOOO[396] = 64670;
        O0OoOO0OOOOO[202] = 75;
        O0OoOO0OOOOO[116] = 72;
        O0OoOO0OOOOO[190] = 168;
        O0OoOO0OOOOO[110] = -64;
        O0OoOO0OOOOO[218] = 1;
        O0OoOO0OOOOO[337] = 45528;
        O0OoOO0OOOOO[342] = 30605;
        O0OoOO0OOOOO[376] = 22776;
        O0OoOO0OOOOO[282] = 16696;
        O0OoOO0OOOOO[62] = -39;
        O0OoOO0OOOOO[354] = 40108;
        O0OoOO0OOOOO[325] = 6502;
        O0OoOO0OOOOO[265] = 36809;
        O0OoOO0OOOOO[356] = 40108;
        O0OoOO0OOOOO[127] = 0;
        O0OoOO0OOOOO[98] = -29;
        O0OoOO0OOOOO[269] = 54871;
        O0OoOO0OOOOO[11] = -40;
        O0OoOO0OOOOO[169] = -119;
        O0OoOO0OOOOO[360] = 10589;
        O0OoOO0OOOOO[249] = 29259;
        O0OoOO0OOOOO[329] = 69150;
        O0OoOO0OOOOO[357] = 10571;
        O0OoOO0OOOOO[145] = 8226;
        O0OoOO0OOOOO[244] = -25362;
        O0OoOO0OOOOO[276] = -37814;
        O0OoOO0OOOOO[382] = 14383;
        O0OoOO0OOOOO[251] = 40778;
        O0OoOO0OOOOO[52] = 73;
        O0OoOO0OOOOO[138] = 0;
        O0OoOO0OOOOO[392] = 51198;
        O0OoOO0OOOOO[236] = -23103;
        O0OoOO0OOOOO[361] = 7147;
        O0OoOO0OOOOO[172] = 99;
        O0OoOO0OOOOO[161] = -56;
        O0OoOO0OOOOO[386] = 43959;
        O0OoOO0OOOOO[40] = 115;
        O0OoOO0OOOOO[339] = -45547;
        O0OoOO0OOOOO[395] = -64739;
        O0OoOO0OOOOO[336] = 10924;
        O0OoOO0OOOOO[310] = 40311;
        O0OoOO0OOOOO[365] = 33997;
        O0OoOO0OOOOO[399] = 23177;
        O0OoOO0OOOOO[122] = -24;
        O0OoOO0OOOOO[270] = 44823;
        O0OoOO0OOOOO[255] = 66713;
        O0OoOO0OOOOO[70] = 96;
        O0OoOO0OOOOO[302] = 50541;
        O0OoOO0OOOOO[12] = -166;
        O0OoOO0OOOOO[95] = -105;
        O0OoOO0OOOOO[90] = 21;
        O0OoOO0OOOOO[142] = 152;
        O0OoOO0OOOOO[258] = 21849;
        O0OoOO0OOOOO[2] = -91;
        O0OoOO0OOOOO[264] = -36773;
        O0OoOO0OOOOO[345] = 30769;
        O0OoOO0OOOOO[366] = 33998;
        O0OoOO0OOOOO[201] = 68;
        O0OoOO0OOOOO[99] = -114;
        O0OoOO0OOOOO[184] = 167;
        O0OoOO0OOOOO[46] = 33;
        O0OoOO0OOOOO[212] = 107;
        O0OoOO0OOOOO[63] = 184;
        O0OoOO0OOOOO[84] = -179;
        O0OoOO0OOOOO[39] = 95;
        O0OoOO0OOOOO[111] = 61;
        O0OoOO0OOOOO[389] = 51179;
        O0OoOO0OOOOO[309] = 40296;
        O0OoOO0OOOOO[275] = 37796;
        O0OoOO0OOOOO[263] = 36809;
        O0OoOO0OOOOO[245] = 25367;
        O0OoOO0OOOOO[89] = 12;
        O0OoOO0OOOOO[153] = 31737;
        O0OoOO0OOOOO[130] = 49;
        O0OoOO0OOOOO[49] = -56;
        O0OoOO0OOOOO[272] = 44923;
        O0OoOO0OOOOO[71] = -22;
        O0OoOO0OOOOO[85] = 102;
        O0OoOO0OOOOO[82] = 50;
        O0OoOO0OOOOO[327] = -6426;
        O0OoOO0OOOOO[187] = 144;
        O0OoOO0OOOOO[372] = 39634;
        O0OoOO0OOOOO[262] = 36810;
        O0OoOO0OOOOO[159] = 119;
        O0OoOO0OOOOO[388] = 43959;
        O0OoOO0OOOOO[379] = 51081;
        O0OoOO0OOOOO[33] = 21;
        O0OoOO0OOOOO[261] = 21853;
        O0OoOO0OOOOO[151] = 4625;
        O0OoOO0OOOOO[300] = 42594;
        O0OoOO0OOOOO[21] = 38;
        O0OoOO0OOOOO[306] = 39434;
        O0OoOO0OOOOO[38] = -72;
        O0OoOO0OOOOO[64] = 58;
        O0OoOO0OOOOO[132] = -1;
        O0OoOO0OOOOO[191] = -49;
        O0OoOO0OOOOO[347] = 30739;
        O0OoOO0OOOOO[312] = 40311;
        O0OoOO0OOOOO[23] = -120;
        O0OoOO0OOOOO[332] = 69133;
        O0OoOO0OOOOO[1] = 119;
        O0OoOO0OOOOO[230] = 67638;
        O0OoOO0OOOOO[268] = -54788;
        O0OoOO0OOOOO[102] = 5;
        O0OoOO0OOOOO[314] = 52655;
        O0OoOO0OOOOO[154] = 53149;
        O0OoOO0OOOOO[7] = -43;
        O0OoOO0OOOOO[208] = 187;
        O0OoOO0OOOOO[121] = -70;
        O0OoOO0OOOOO[91] = 0;
        O0OoOO0OOOOO[211] = 152;
        O0OoOO0OOOOO[29] = 125;
        O0OoOO0OOOOO[207] = 106;
        O0OoOO0OOOOO[240] = 43995;
        O0OoOO0OOOOO[35] = -120;
        O0OoOO0OOOOO[101] = -95;
        O0OoOO0OOOOO[319] = -69291;
        O0OoOO0OOOOO[100] = 19;
        O0OoOO0OOOOO[293] = 49946;
        O0OoOO0OOOOO[109] = -55;
        O0OoOO0OOOOO[93] = -7;
        O0OoOO0OOOOO[119] = -29;
        O0OoOO0OOOOO[50] = 45;
        O0OoOO0OOOOO[215] = 2;
        O0OoOO0OOOOO[55] = -92;
        O0OoOO0OOOOO[160] = -183;
        O0OoOO0OOOOO[136] = 0;
        O0OoOO0OOOOO[133] = 85;
        O0OoOO0OOOOO[141] = 0;
        O0OoOO0OOOOO[349] = 9143;
        O0OoOO0OOOOO[253] = 40778;
        O0OoOO0OOOOO[166] = -77;
        O0OoOO0OOOOO[288] = 54397;
        O0OoOO0OOOOO[320] = 69296;
        O0OoOO0OOOOO[304] = 50541;
        O0OoOO0OOOOO[220] = 64424;
        O0OoOO0OOOOO[200] = -4;
        O0OoOO0OOOOO[284] = -16657;
        O0OoOO0OOOOO[176] = -76;
        O0OoOO0OOOOO[279] = 20862;
        O0OoOO0OOOOO[28] = -88;
        O0OoOO0OOOOO[13] = -74;
        O0OoOO0OOOOO[108] = 34;
        O0OoOO0OOOOO[223] = 33403;
        O0OoOO0OOOOO[65] = 125;
    }

    @Override
    public void onEnable() {
        this.JM = false;
        this.Jq = true;
        this.GQ = true;
        this.Oh = 0;
        this.Og = 0;
        this.ys = false;
        this.El = true;
        if (aEg.thePlayer.onGround) {
            aEg.thePlayer.setPosition(aEg.thePlayer.posX, aEg.thePlayer.posY - 1.0, aEg.thePlayer.posZ);
            MoveUtil.stop();
        } else {
            afi.b("You must me on the ground to do this");
            this.e(Phase.class).toggle();
        }
    }

    public VulcanPhase(String var1, Phase var2) {
        super(var1, var2);
        this.El = true;
        this.Og = 0;
        this.Oh = 0;
        this.qH = 0;
        this.Oi = false;
        this.Jq = true;
        this.GQ = true;
        this.Oj = var1x -> {
            aEg.thePlayer.cameraYaw = 0.1F;
            if (this.Oh > 25 && aih.vk()) {
                double d0;
                int i = (d0 = aEg.thePlayer.motionY - 0.0) == 0.0 ? 0 : (d0 < 0.0 ? -1 : 1);
                aEg.thePlayer.onGround = false;
            }

            if (aih.vk()) {
                this.Oh++;
            }

            if (this.Jq && this.Oh < 25) {
                cl.cn();
            }

            if (aih.vk() && !this.El && this.GQ) {
                this.GQ = false;
                afi.b("Phased");
            }

            if (aih.vk()) {
                ;
            }
        };
        this.Ok = var1x -> {
            double d0 = 0.0;
            if (aih.vk()) {
                var1x.a(null);
                if (!(var1x.df() instanceof BlockAir) && !aEg.gameSettings.keyBindSneak.isKeyDown()) {
                    double d3 = var1x.dg().getX();
                    double d4 = var1x.dg().getY();
                    double d5 = var1x.dg().getZ();
                    if (d4 < aEg.thePlayer.posY) {
                        var1x.a(AxisAlignedBB.fromBounds(-15.0, -1.0, -15.0, 15.0, 1.0, 15.0).offset(d3, d4, d5));
                    }
                }
            } else if (!this.ys) {
                if (var1x.df() instanceof BlockAir && !aEg.thePlayer.isSneaking()) {
                    double d6 = var1x.dg().getX();
                    double d7 = var1x.dg().getY();
                    double d8 = var1x.dg().getZ();
                    if (d7 < aEg.thePlayer.posY) {
                        var1x.a(AxisAlignedBB.fromBounds(-15.0, -1.0, -15.0, 15.0, 1.0, 15.0).offset(d6, d7, d8));
                    }
                }
            } else if (this.ys && !aih.vk()) {
                afi.b("Disabled due to not being in a block");
                this.e(Phase.class).toggle();
            }
        };
        this.Ol = var0 -> {};
        this.Om = var1x -> {
            long i = 0L;
            long j = -4480092840615981475L;
            long k = j ^ ((long)aik.vx() << 32 ^ j) & -1L << 32;
            if ((!aEg.gameSettings.keyBindJump.isKeyDown() || aEg.thePlayer.hurtTime <= 0)
                && !aEg.gameSettings.keyBindSneak.isKeyDown()
                && !aEg.gameSettings.keyBindJump.isKeyDown()
                && aih.vk()) {
                ;
            }

            if (aih.vk()) {
                if (aEg.thePlayer.isPotionActive(Potion.moveSpeed)) {
                    var1x.setSpeed(0.0605 * (1 + aEg.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier()) + 0.306);
                } else {
                    var1x.setSpeed(0.306);
                }
            }

            if (aEg.thePlayer.onGround && this.El && this.ys) {
                aEg.thePlayer.jump();
                this.ys = false;
                this.El = false;
            }

            if (aEg.thePlayer.onGround && !this.ys && !this.El) {
                if (aEg.thePlayer.ticksExisted % 2 != 1 && aEg.thePlayer.moveForward == 0.0F) {
                    MoveUtil.strafe(0.0);
                    var1x.setForward(-1.0F);
                } else {
                    var1x.setForward(1.0F);
                }
            }
        };
        this.On = var1x -> {
            if (var1x.dq() instanceof S08PacketPlayerPosLook) {
                this.ys = true;
                this.Og++;
            }

            if (this.Og > 4) {
                this.Jq = false;
            } else {
                this.Jq = (O0OoOO0OOOOO[72] + 96 - -97) != 0;
            }
        };
        this.Oo = var0 -> var0.setCancelled();
    }
}
