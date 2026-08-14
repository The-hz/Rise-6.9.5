package com.alan.clients.module.impl.movement.speed;

import com.alan.clients.module.impl.movement.Speed;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.MoveInputEvent;
import com.alan.clients.newevent.impl.motion.JumpEvent;
import com.alan.clients.newevent.impl.motion.PostMotionEvent;
import com.alan.clients.newevent.impl.motion.PostStrafeEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.other.TeleportEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.NumberValue;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import de.florianmichael.vialoadingbase.ViaLoadingBase;
import hackclient.rise.afi;
import hackclient.rise.ahj;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.network.play.server.S12PacketEntityVelocity;

public class Grim2Speed
extends Mode<Speed> {
    public static int[] O0OoOO0OOOOO;
    public boolean gD;
    public int Pj;
    @EventLink
    public Listener<PreMotionEvent> Pp;
    public int Ho;
    @EventLink
    public Listener<TeleportEvent> Pt;
    public boolean Ga;
    public BooleanValue Pk = new BooleanValue("High Ping Mode (May be slower)", (Mode<?>)this, (Boolean)false);
    public NumberValue Pl = new NumberValue("Speed", this, (Number)1, (Number)0, (Number)1, (Number)0.001);
    @EventLink
    public Listener<JumpEvent> Pm = jumpEvent -> {
        if (!Grim2Speed.aEg.thePlayer.isJumping) {
            jumpEvent.setCancelled();
        }
    };
    @EventLink
    public Listener<MoveInputEvent> Pr;
    @EventLink
    public Listener<PostMotionEvent> Pq;
    @EventLink
    public Listener<PacketReceiveEvent> Ps;
    @EventLink
    public Listener<StrafeEvent> Pn = strafeEvent -> {
        double d2 = 0.0;
        this.Pj = Grim2Speed.aEg.thePlayer.onGround ? ++this.Pj : 0;
        if (this.Pj >= 1) {
            boolean cfr_ignored_0 = Grim2Speed.aEg.thePlayer.onGround;
        }
        if (this.Ho > -1) {
            double d3 = 0.03;
            if (this.Ho % 2 == 0) {
                d3 = Grim2Speed.aEg.thePlayer.onGround ? 0.085 : 0.03;
            }
            MoveUtil.moveFlying(d3 * ((Number)this.Pl.wo()).doubleValue());
        }
        ++this.Ho;
    };
    public boolean Eo;
    @EventLink
    public Listener<PostStrafeEvent> Po = postStrafeEvent -> {
        this.Eo = this.Eo;
    };

    static {
        Grim2Speed.Oo0o00000O00();
    }

    public static void Oo0o00000O00() {
        O0OoOO0OOOOO = new int[400];
        Grim2Speed.O0OoOO0OOOOO[126] = 0;
        Grim2Speed.O0OoOO0OOOOO[133] = 43629;
        Grim2Speed.O0OoOO0OOOOO[46] = -114;
        Grim2Speed.O0OoOO0OOOOO[310] = 51763;
        Grim2Speed.O0OoOO0OOOOO[334] = 25578;
        Grim2Speed.O0OoOO0OOOOO[76] = -21;
        Grim2Speed.O0OoOO0OOOOO[314] = 55972;
        Grim2Speed.O0OoOO0OOOOO[224] = 27906;
        Grim2Speed.O0OoOO0OOOOO[393] = -11956;
        Grim2Speed.O0OoOO0OOOOO[20] = -47;
        Grim2Speed.O0OoOO0OOOOO[247] = 57561;
        Grim2Speed.O0OoOO0OOOOO[300] = 24463;
        Grim2Speed.O0OoOO0OOOOO[115] = 14;
        Grim2Speed.O0OoOO0OOOOO[274] = 51743;
        Grim2Speed.O0OoOO0OOOOO[41] = -94;
        Grim2Speed.O0OoOO0OOOOO[176] = -229;
        Grim2Speed.O0OoOO0OOOOO[350] = 37124;
        Grim2Speed.O0OoOO0OOOOO[122] = 1;
        Grim2Speed.O0OoOO0OOOOO[186] = 67;
        Grim2Speed.O0OoOO0OOOOO[109] = -97;
        Grim2Speed.O0OoOO0OOOOO[38] = 31;
        Grim2Speed.O0OoOO0OOOOO[52] = -51;
        Grim2Speed.O0OoOO0OOOOO[320] = 169;
        Grim2Speed.O0OoOO0OOOOO[180] = 43;
        Grim2Speed.O0OoOO0OOOOO[231] = 13436;
        Grim2Speed.O0OoOO0OOOOO[136] = 30774;
        Grim2Speed.O0OoOO0OOOOO[301] = -24500;
        Grim2Speed.O0OoOO0OOOOO[380] = 40936;
        Grim2Speed.O0OoOO0OOOOO[282] = 22264;
        Grim2Speed.O0OoOO0OOOOO[60] = 16;
        Grim2Speed.O0OoOO0OOOOO[326] = 3032;
        Grim2Speed.O0OoOO0OOOOO[250] = 9226;
        Grim2Speed.O0OoOO0OOOOO[80] = 107;
        Grim2Speed.O0OoOO0OOOOO[160] = -95;
        Grim2Speed.O0OoOO0OOOOO[37] = 20;
        Grim2Speed.O0OoOO0OOOOO[92] = 15;
        Grim2Speed.O0OoOO0OOOOO[387] = 15078;
        Grim2Speed.O0OoOO0OOOOO[219] = 55042;
        Grim2Speed.O0OoOO0OOOOO[236] = 52724;
        Grim2Speed.O0OoOO0OOOOO[29] = 121;
        Grim2Speed.O0OoOO0OOOOO[23] = 125;
        Grim2Speed.O0OoOO0OOOOO[336] = 39283;
        Grim2Speed.O0OoOO0OOOOO[189] = -21;
        Grim2Speed.O0OoOO0OOOOO[51] = -61;
        Grim2Speed.O0OoOO0OOOOO[16] = 68;
        Grim2Speed.O0OoOO0OOOOO[279] = 22249;
        Grim2Speed.O0OoOO0OOOOO[269] = 22984;
        Grim2Speed.O0OoOO0OOOOO[146] = 97;
        Grim2Speed.O0OoOO0OOOOO[285] = -26763;
        Grim2Speed.O0OoOO0OOOOO[227] = 27916;
        Grim2Speed.O0OoOO0OOOOO[168] = -19;
        Grim2Speed.O0OoOO0OOOOO[253] = 7610;
        Grim2Speed.O0OoOO0OOOOO[195] = 40;
        Grim2Speed.O0OoOO0OOOOO[323] = 3011;
        Grim2Speed.O0OoOO0OOOOO[333] = -25500;
        Grim2Speed.O0OoOO0OOOOO[230] = 13354;
        Grim2Speed.O0OoOO0OOOOO[72] = 175;
        Grim2Speed.O0OoOO0OOOOO[48] = -158;
        Grim2Speed.O0OoOO0OOOOO[273] = 51775;
        Grim2Speed.O0OoOO0OOOOO[13] = 57;
        Grim2Speed.O0OoOO0OOOOO[71] = 9;
        Grim2Speed.O0OoOO0OOOOO[267] = 35092;
        Grim2Speed.O0OoOO0OOOOO[213] = 10785;
        Grim2Speed.O0OoOO0OOOOO[197] = -126;
        Grim2Speed.O0OoOO0OOOOO[358] = 8858;
        Grim2Speed.O0OoOO0OOOOO[56] = -110;
        Grim2Speed.O0OoOO0OOOOO[392] = 11921;
        Grim2Speed.O0OoOO0OOOOO[252] = 7600;
        Grim2Speed.O0OoOO0OOOOO[383] = 15683;
        Grim2Speed.O0OoOO0OOOOO[70] = -73;
        Grim2Speed.O0OoOO0OOOOO[359] = 11495;
        Grim2Speed.O0OoOO0OOOOO[290] = 39365;
        Grim2Speed.O0OoOO0OOOOO[386] = 15692;
        Grim2Speed.O0OoOO0OOOOO[239] = 52735;
        Grim2Speed.O0OoOO0OOOOO[172] = -25;
        Grim2Speed.O0OoOO0OOOOO[284] = 26777;
        Grim2Speed.O0OoOO0OOOOO[44] = 25;
        Grim2Speed.O0OoOO0OOOOO[257] = 29045;
        Grim2Speed.O0OoOO0OOOOO[368] = 5585;
        Grim2Speed.O0OoOO0OOOOO[397] = -40518;
        Grim2Speed.O0OoOO0OOOOO[317] = 5089;
        Grim2Speed.O0OoOO0OOOOO[258] = -28940;
        Grim2Speed.O0OoOO0OOOOO[3] = 99;
        Grim2Speed.O0OoOO0OOOOO[298] = 4016;
        Grim2Speed.O0OoOO0OOOOO[209] = 54058;
        Grim2Speed.O0OoOO0OOOOO[233] = 13521;
        Grim2Speed.O0OoOO0OOOOO[389] = 15020;
        Grim2Speed.O0OoOO0OOOOO[25] = -55;
        Grim2Speed.O0OoOO0OOOOO[388] = 15094;
        Grim2Speed.O0OoOO0OOOOO[235] = 13521;
        Grim2Speed.O0OoOO0OOOOO[120] = 3;
        Grim2Speed.O0OoOO0OOOOO[346] = 6007;
        Grim2Speed.O0OoOO0OOOOO[228] = 13434;
        Grim2Speed.O0OoOO0OOOOO[135] = 33717;
        Grim2Speed.O0OoOO0OOOOO[375] = 39663;
        Grim2Speed.O0OoOO0OOOOO[79] = -4;
        Grim2Speed.O0OoOO0OOOOO[50] = -111;
        Grim2Speed.O0OoOO0OOOOO[332] = 25578;
        Grim2Speed.O0OoOO0OOOOO[398] = 40506;
        Grim2Speed.O0OoOO0OOOOO[139] = 54265;
        Grim2Speed.O0OoOO0OOOOO[64] = -33;
        Grim2Speed.O0OoOO0OOOOO[272] = 0;
        Grim2Speed.O0OoOO0OOOOO[45] = 112;
        Grim2Speed.O0OoOO0OOOOO[69] = -65;
        Grim2Speed.O0OoOO0OOOOO[191] = 88;
        Grim2Speed.O0OoOO0OOOOO[277] = 2655;
        Grim2Speed.O0OoOO0OOOOO[307] = 51771;
        Grim2Speed.O0OoOO0OOOOO[127] = 216;
        Grim2Speed.O0OoOO0OOOOO[73] = -63;
        Grim2Speed.O0OoOO0OOOOO[366] = 11920;
        Grim2Speed.O0OoOO0OOOOO[85] = 33;
        Grim2Speed.O0OoOO0OOOOO[295] = 4007;
        Grim2Speed.O0OoOO0OOOOO[77] = -121;
        Grim2Speed.O0OoOO0OOOOO[229] = 13436;
        Grim2Speed.O0OoOO0OOOOO[57] = -66;
        Grim2Speed.O0OoOO0OOOOO[256] = 29040;
        Grim2Speed.O0OoOO0OOOOO[222] = 17287;
        Grim2Speed.O0OoOO0OOOOO[169] = -126;
        Grim2Speed.O0OoOO0OOOOO[148] = 41;
        Grim2Speed.O0OoOO0OOOOO[187] = -106;
        Grim2Speed.O0OoOO0OOOOO[74] = 111;
        Grim2Speed.O0OoOO0OOOOO[184] = 110;
        Grim2Speed.O0OoOO0OOOOO[53] = -10;
        Grim2Speed.O0OoOO0OOOOO[149] = 154;
        Grim2Speed.O0OoOO0OOOOO[385] = 15701;
        Grim2Speed.O0OoOO0OOOOO[299] = 24461;
        Grim2Speed.O0OoOO0OOOOO[104] = -88;
        Grim2Speed.O0OoOO0OOOOO[357] = 8911;
        Grim2Speed.O0OoOO0OOOOO[78] = -112;
        Grim2Speed.O0OoOO0OOOOO[105] = 95;
        Grim2Speed.O0OoOO0OOOOO[365] = -11910;
        Grim2Speed.O0OoOO0OOOOO[42] = -96;
        Grim2Speed.O0OoOO0OOOOO[241] = 38104;
        Grim2Speed.O0OoOO0OOOOO[164] = -43;
        Grim2Speed.O0OoOO0OOOOO[150] = -28;
        Grim2Speed.O0OoOO0OOOOO[370] = 5585;
        Grim2Speed.O0OoOO0OOOOO[129] = 26979;
        Grim2Speed.O0OoOO0OOOOO[138] = 18649;
        Grim2Speed.O0OoOO0OOOOO[18] = -132;
        Grim2Speed.O0OoOO0OOOOO[43] = -69;
        Grim2Speed.O0OoOO0OOOOO[118] = 102;
        Grim2Speed.O0OoOO0OOOOO[208] = 54055;
        Grim2Speed.O0OoOO0OOOOO[337] = 39175;
        Grim2Speed.O0OoOO0OOOOO[331] = 25586;
        Grim2Speed.O0OoOO0OOOOO[86] = -72;
        Grim2Speed.O0OoOO0OOOOO[124] = 2;
        Grim2Speed.O0OoOO0OOOOO[82] = 96;
        Grim2Speed.O0OoOO0OOOOO[354] = 54266;
        Grim2Speed.O0OoOO0OOOOO[255] = 7610;
        Grim2Speed.O0OoOO0OOOOO[55] = -91;
        Grim2Speed.O0OoOO0OOOOO[19] = 86;
        Grim2Speed.O0OoOO0OOOOO[81] = 183;
        Grim2Speed.O0OoOO0OOOOO[106] = -3;
        Grim2Speed.O0OoOO0OOOOO[145] = 22;
        Grim2Speed.O0OoOO0OOOOO[260] = 15192;
        Grim2Speed.O0OoOO0OOOOO[212] = 10790;
        Grim2Speed.O0OoOO0OOOOO[161] = 28;
        Grim2Speed.O0OoOO0OOOOO[111] = -161;
        Grim2Speed.O0OoOO0OOOOO[291] = 44478;
        Grim2Speed.O0OoOO0OOOOO[96] = 26;
        Grim2Speed.O0OoOO0OOOOO[220] = 17301;
        Grim2Speed.O0OoOO0OOOOO[373] = 45291;
        Grim2Speed.O0OoOO0OOOOO[63] = -126;
        Grim2Speed.O0OoOO0OOOOO[9] = -162;
        Grim2Speed.O0OoOO0OOOOO[311] = 55970;
        Grim2Speed.O0OoOO0OOOOO[394] = 11921;
        Grim2Speed.O0OoOO0OOOOO[340] = 24256;
        Grim2Speed.O0OoOO0OOOOO[83] = 87;
        Grim2Speed.O0OoOO0OOOOO[211] = 54058;
        Grim2Speed.O0OoOO0OOOOO[54] = -201;
        Grim2Speed.O0OoOO0OOOOO[143] = 53;
        Grim2Speed.O0OoOO0OOOOO[283] = 26770;
        Grim2Speed.O0OoOO0OOOOO[325] = 2964;
        Grim2Speed.O0OoOO0OOOOO[194] = 101;
        Grim2Speed.O0OoOO0OOOOO[330] = 59498;
        Grim2Speed.O0OoOO0OOOOO[264] = 35092;
        Grim2Speed.O0OoOO0OOOOO[361] = 11396;
        Grim2Speed.O0OoOO0OOOOO[190] = 101;
        Grim2Speed.O0OoOO0OOOOO[11] = 53;
        Grim2Speed.O0OoOO0OOOOO[313] = -56044;
        Grim2Speed.O0OoOO0OOOOO[116] = -47;
        Grim2Speed.O0OoOO0OOOOO[188] = 48;
        Grim2Speed.O0OoOO0OOOOO[352] = 54266;
        Grim2Speed.O0OoOO0OOOOO[94] = 32;
        Grim2Speed.O0OoOO0OOOOO[61] = 76;
        Grim2Speed.O0OoOO0OOOOO[304] = 36225;
        Grim2Speed.O0OoOO0OOOOO[91] = 13;
        Grim2Speed.O0OoOO0OOOOO[245] = 57561;
        Grim2Speed.O0OoOO0OOOOO[342] = 24256;
        Grim2Speed.O0OoOO0OOOOO[293] = -44428;
        Grim2Speed.O0OoOO0OOOOO[328] = 59498;
        Grim2Speed.O0OoOO0OOOOO[374] = 45268;
        Grim2Speed.O0OoOO0OOOOO[201] = 2;
        Grim2Speed.O0OoOO0OOOOO[155] = 237;
        Grim2Speed.O0OoOO0OOOOO[34] = 80;
        Grim2Speed.O0OoOO0OOOOO[355] = 8858;
        Grim2Speed.O0OoOO0OOOOO[5] = 109;
        Grim2Speed.O0OoOO0OOOOO[33] = 46;
        Grim2Speed.O0OoOO0OOOOO[292] = 44477;
        Grim2Speed.O0OoOO0OOOOO[110] = 20;
        Grim2Speed.O0OoOO0OOOOO[371] = 45277;
        Grim2Speed.O0OoOO0OOOOO[329] = -59453;
        Grim2Speed.O0OoOO0OOOOO[49] = -47;
        Grim2Speed.O0OoOO0OOOOO[8] = 24;
        Grim2Speed.O0OoOO0OOOOO[103] = -55;
        Grim2Speed.O0OoOO0OOOOO[204] = 1;
        Grim2Speed.O0OoOO0OOOOO[117] = 180;
        Grim2Speed.O0OoOO0OOOOO[167] = 139;
        Grim2Speed.O0OoOO0OOOOO[163] = 30;
        Grim2Speed.O0OoOO0OOOOO[152] = 91;
        Grim2Speed.O0OoOO0OOOOO[47] = 2;
        Grim2Speed.O0OoOO0OOOOO[199] = 43;
        Grim2Speed.O0OoOO0OOOOO[95] = 76;
        Grim2Speed.O0OoOO0OOOOO[271] = 22984;
        Grim2Speed.O0OoOO0OOOOO[244] = 57552;
        Grim2Speed.O0OoOO0OOOOO[246] = 57476;
        Grim2Speed.O0OoOO0OOOOO[318] = 5040;
        Grim2Speed.O0OoOO0OOOOO[316] = 5040;
        Grim2Speed.O0OoOO0OOOOO[181] = 14;
        Grim2Speed.O0OoOO0OOOOO[12] = -118;
        Grim2Speed.O0OoOO0OOOOO[339] = 24263;
        Grim2Speed.O0OoOO0OOOOO[367] = 5570;
        Grim2Speed.O0OoOO0OOOOO[24] = -161;
        Grim2Speed.O0OoOO0OOOOO[159] = -8;
        Grim2Speed.O0OoOO0OOOOO[166] = 14;
        Grim2Speed.O0OoOO0OOOOO[179] = -25;
        Grim2Speed.O0OoOO0OOOOO[2] = -99;
        Grim2Speed.O0OoOO0OOOOO[249] = 9283;
        Grim2Speed.O0OoOO0OOOOO[202] = 0;
        Grim2Speed.O0OoOO0OOOOO[312] = 55972;
        Grim2Speed.O0OoOO0OOOOO[128] = 34752;
        Grim2Speed.O0OoOO0OOOOO[266] = 35174;
        Grim2Speed.O0OoOO0OOOOO[376] = 39650;
        Grim2Speed.O0OoOO0OOOOO[308] = 51763;
        Grim2Speed.O0OoOO0OOOOO[372] = 45268;
        Grim2Speed.O0OoOO0OOOOO[306] = 36225;
        Grim2Speed.O0OoOO0OOOOO[351] = 54267;
        Grim2Speed.O0OoOO0OOOOO[390] = 15094;
        Grim2Speed.O0OoOO0OOOOO[113] = 61;
        Grim2Speed.O0OoOO0OOOOO[102] = 96;
        Grim2Speed.O0OoOO0OOOOO[174] = -122;
        Grim2Speed.O0OoOO0OOOOO[30] = -28;
        Grim2Speed.O0OoOO0OOOOO[270] = -23029;
        Grim2Speed.O0OoOO0OOOOO[134] = 14224;
        Grim2Speed.O0OoOO0OOOOO[36] = -10;
        Grim2Speed.O0OoOO0OOOOO[137] = 58520;
        Grim2Speed.O0OoOO0OOOOO[193] = 126;
        Grim2Speed.O0OoOO0OOOOO[97] = 66;
        Grim2Speed.O0OoOO0OOOOO[343] = 5986;
        Grim2Speed.O0OoOO0OOOOO[341] = 24313;
        Grim2Speed.O0OoOO0OOOOO[275] = 2666;
        Grim2Speed.O0OoOO0OOOOO[173] = 91;
        Grim2Speed.O0OoOO0OOOOO[217] = 55042;
        Grim2Speed.O0OoOO0OOOOO[205] = 0;
        Grim2Speed.O0OoOO0OOOOO[7] = -99;
        Grim2Speed.O0OoOO0OOOOO[287] = 39371;
        Grim2Speed.O0OoOO0OOOOO[232] = 13534;
        Grim2Speed.O0OoOO0OOOOO[35] = 122;
        Grim2Speed.O0OoOO0OOOOO[276] = 2679;
        Grim2Speed.O0OoOO0OOOOO[345] = -5992;
        Grim2Speed.O0OoOO0OOOOO[344] = 6007;
        Grim2Speed.O0OoOO0OOOOO[112] = -101;
        Grim2Speed.O0OoOO0OOOOO[242] = 38018;
        Grim2Speed.O0OoOO0OOOOO[32] = -107;
        Grim2Speed.O0OoOO0OOOOO[67] = -60;
        Grim2Speed.O0OoOO0OOOOO[107] = -99;
        Grim2Speed.O0OoOO0OOOOO[315] = 5026;
        Grim2Speed.O0OoOO0OOOOO[338] = 39283;
        Grim2Speed.O0OoOO0OOOOO[196] = -29;
        Grim2Speed.O0OoOO0OOOOO[384] = 15692;
        Grim2Speed.O0OoOO0OOOOO[185] = -11;
        Grim2Speed.O0OoOO0OOOOO[262] = 15115;
        Grim2Speed.O0OoOO0OOOOO[363] = 11919;
        Grim2Speed.O0OoOO0OOOOO[223] = 17303;
        Grim2Speed.O0OoOO0OOOOO[4] = -6;
        Grim2Speed.O0OoOO0OOOOO[130] = 13510;
        Grim2Speed.O0OoOO0OOOOO[65] = -92;
        Grim2Speed.O0OoOO0OOOOO[381] = 40923;
        Grim2Speed.O0OoOO0OOOOO[379] = 40946;
        Grim2Speed.O0OoOO0OOOOO[178] = -102;
        Grim2Speed.O0OoOO0OOOOO[294] = 44477;
        Grim2Speed.O0OoOO0OOOOO[158] = -121;
        Grim2Speed.O0OoOO0OOOOO[100] = 99;
        Grim2Speed.O0OoOO0OOOOO[90] = -1;
        Grim2Speed.O0OoOO0OOOOO[58] = 25;
        Grim2Speed.O0OoOO0OOOOO[305] = -36247;
        Grim2Speed.O0OoOO0OOOOO[99] = -204;
        Grim2Speed.O0OoOO0OOOOO[278] = 2679;
        Grim2Speed.O0OoOO0OOOOO[327] = 59516;
        Grim2Speed.O0OoOO0OOOOO[238] = -52610;
        Grim2Speed.O0OoOO0OOOOO[221] = 17303;
        Grim2Speed.O0OoOO0OOOOO[210] = -54120;
        Grim2Speed.O0OoOO0OOOOO[303] = 36229;
        Grim2Speed.O0OoOO0OOOOO[268] = 22988;
        Grim2Speed.O0OoOO0OOOOO[87] = 84;
        Grim2Speed.O0OoOO0OOOOO[265] = 35092;
        Grim2Speed.O0OoOO0OOOOO[183] = -75;
        Grim2Speed.O0OoOO0OOOOO[254] = 7559;
        Grim2Speed.O0OoOO0OOOOO[75] = 110;
        Grim2Speed.O0OoOO0OOOOO[68] = 11;
        Grim2Speed.O0OoOO0OOOOO[28] = -69;
        Grim2Speed.O0OoOO0OOOOO[192] = -70;
        Grim2Speed.O0OoOO0OOOOO[84] = 105;
        Grim2Speed.O0OoOO0OOOOO[362] = 11513;
        Grim2Speed.O0OoOO0OOOOO[280] = 22264;
        Grim2Speed.O0OoOO0OOOOO[214] = 10843;
        Grim2Speed.O0OoOO0OOOOO[131] = 18537;
        Grim2Speed.O0OoOO0OOOOO[382] = 40936;
        Grim2Speed.O0OoOO0OOOOO[132] = 63052;
        Grim2Speed.O0OoOO0OOOOO[156] = 118;
        Grim2Speed.O0OoOO0OOOOO[154] = -27;
        Grim2Speed.O0OoOO0OOOOO[162] = 3;
        Grim2Speed.O0OoOO0OOOOO[66] = -49;
        Grim2Speed.O0OoOO0OOOOO[170] = 69;
        Grim2Speed.O0OoOO0OOOOO[101] = -105;
        Grim2Speed.O0OoOO0OOOOO[119] = 46;
        Grim2Speed.O0OoOO0OOOOO[297] = -4012;
        Grim2Speed.O0OoOO0OOOOO[142] = 0;
        Grim2Speed.O0OoOO0OOOOO[175] = -15;
        Grim2Speed.O0OoOO0OOOOO[296] = 4016;
        Grim2Speed.O0OoOO0OOOOO[395] = 40483;
        Grim2Speed.O0OoOO0OOOOO[88] = 11;
        Grim2Speed.O0OoOO0OOOOO[198] = -55;
        Grim2Speed.O0OoOO0OOOOO[289] = 39423;
        Grim2Speed.O0OoOO0OOOOO[286] = 26777;
        Grim2Speed.O0OoOO0OOOOO[15] = 106;
        Grim2Speed.O0OoOO0OOOOO[288] = 39365;
        Grim2Speed.O0OoOO0OOOOO[153] = 71;
        Grim2Speed.O0OoOO0OOOOO[165] = 89;
        Grim2Speed.O0OoOO0OOOOO[26] = 106;
        Grim2Speed.O0OoOO0OOOOO[369] = -5607;
        Grim2Speed.O0OoOO0OOOOO[396] = 40506;
        Grim2Speed.O0OoOO0OOOOO[216] = 55043;
        Grim2Speed.O0OoOO0OOOOO[123] = 0;
        Grim2Speed.O0OoOO0OOOOO[6] = 75;
        Grim2Speed.O0OoOO0OOOOO[259] = 29045;
        Grim2Speed.O0OoOO0OOOOO[141] = 5663;
        Grim2Speed.O0OoOO0OOOOO[203] = 1;
        Grim2Speed.O0OoOO0OOOOO[263] = 15184;
        Grim2Speed.O0OoOO0OOOOO[360] = 11513;
        Grim2Speed.O0OoOO0OOOOO[147] = -106;
        Grim2Speed.O0OoOO0OOOOO[225] = 27916;
        Grim2Speed.O0OoOO0OOOOO[21] = 121;
        Grim2Speed.O0OoOO0OOOOO[377] = -39668;
        Grim2Speed.O0OoOO0OOOOO[309] = 51795;
        Grim2Speed.O0OoOO0OOOOO[59] = -43;
        Grim2Speed.O0OoOO0OOOOO[151] = 94;
        Grim2Speed.O0OoOO0OOOOO[206] = 34175;
        Grim2Speed.O0OoOO0OOOOO[215] = 10785;
        Grim2Speed.O0OoOO0OOOOO[399] = 52040;
        Grim2Speed.O0OoOO0OOOOO[10] = 112;
        Grim2Speed.O0OoOO0OOOOO[182] = 217;
        Grim2Speed.O0OoOO0OOOOO[17] = 38;
        Grim2Speed.O0OoOO0OOOOO[364] = 11920;
        Grim2Speed.O0OoOO0OOOOO[302] = 24463;
        Grim2Speed.O0OoOO0OOOOO[347] = 37134;
        Grim2Speed.O0OoOO0OOOOO[93] = 44;
        Grim2Speed.O0OoOO0OOOOO[378] = 39650;
        Grim2Speed.O0OoOO0OOOOO[121] = 0;
        Grim2Speed.O0OoOO0OOOOO[324] = 3032;
        Grim2Speed.O0OoOO0OOOOO[243] = 38104;
        Grim2Speed.O0OoOO0OOOOO[157] = 87;
        Grim2Speed.O0OoOO0OOOOO[356] = 8858;
        Grim2Speed.O0OoOO0OOOOO[89] = 95;
        Grim2Speed.O0OoOO0OOOOO[98] = 87;
        Grim2Speed.O0OoOO0OOOOO[177] = -99;
        Grim2Speed.O0OoOO0OOOOO[281] = -22203;
        Grim2Speed.O0OoOO0OOOOO[207] = 34159;
        Grim2Speed.O0OoOO0OOOOO[226] = -27989;
        Grim2Speed.O0OoOO0OOOOO[322] = 169;
        Grim2Speed.O0OoOO0OOOOO[237] = 52735;
        Grim2Speed.O0OoOO0OOOOO[1] = -33;
        Grim2Speed.O0OoOO0OOOOO[0] = -127;
        Grim2Speed.O0OoOO0OOOOO[251] = 9283;
        Grim2Speed.O0OoOO0OOOOO[349] = -37175;
        Grim2Speed.O0OoOO0OOOOO[31] = 113;
        Grim2Speed.O0OoOO0OOOOO[39] = 43;
        Grim2Speed.O0OoOO0OOOOO[261] = 15184;
        Grim2Speed.O0OoOO0OOOOO[200] = 1;
        Grim2Speed.O0OoOO0OOOOO[391] = 11933;
        Grim2Speed.O0OoOO0OOOOO[144] = 3;
        Grim2Speed.O0OoOO0OOOOO[22] = -3;
        Grim2Speed.O0OoOO0OOOOO[125] = 0;
        Grim2Speed.O0OoOO0OOOOO[108] = -119;
        Grim2Speed.O0OoOO0OOOOO[27] = -62;
        Grim2Speed.O0OoOO0OOOOO[353] = 54148;
        Grim2Speed.O0OoOO0OOOOO[240] = 38107;
        Grim2Speed.O0OoOO0OOOOO[62] = 61;
        Grim2Speed.O0OoOO0OOOOO[218] = 55051;
        Grim2Speed.O0OoOO0OOOOO[248] = 9295;
        Grim2Speed.O0OoOO0OOOOO[114] = 56;
        Grim2Speed.O0OoOO0OOOOO[335] = 39286;
        Grim2Speed.O0OoOO0OOOOO[321] = -216;
        Grim2Speed.O0OoOO0OOOOO[348] = 37124;
        Grim2Speed.O0OoOO0OOOOO[319] = 189;
        Grim2Speed.O0OoOO0OOOOO[14] = 78;
        Grim2Speed.O0OoOO0OOOOO[171] = 66;
        Grim2Speed.O0OoOO0OOOOO[140] = 2620;
        Grim2Speed.O0OoOO0OOOOO[40] = 51;
        Grim2Speed.O0OoOO0OOOOO[234] = -13481;
    }

    public Grim2Speed(String string, Speed speed) {
        super(string, speed);
        this.Pp = preMotionEvent -> {
            this.gD = false;
        };
        this.Pq = postMotionEvent -> {
            if (this.Ho % 2 == 0) {
                if (!((Boolean)this.Pk.wo()).booleanValue()) {
                    ahj.l(new C03PacketPlayer(true));
                    ahj.l(new C03PacketPlayer(false));
                } else {
                    ahj.l(new C03PacketPlayer(false));
                    ahj.l(new C03PacketPlayer(false));
                }
                this.Eo = true;
            }
        };
        this.Pr = moveInputEvent -> {
            if (this.gD) {
                moveInputEvent.setJump(true);
            }
        };
        this.Ps = packetReceiveEvent -> {
            Packet<?> packet = packetReceiveEvent.dq();
            if (packet instanceof S08PacketPlayerPosLook) {
                if (this.Ho % 2 == 1) {
                    ++this.Ho;
                }
                Grim2Speed.aEg.timer.dzD = 1.0f;
            }
            if (packet instanceof S12PacketEntityVelocity) {
                S12PacketEntityVelocity s12PacketEntityVelocity = (S12PacketEntityVelocity)packet;
                this.Eo = false;
                if (s12PacketEntityVelocity.getEntityID() == Grim2Speed.aEg.thePlayer.getEntityId()) {
                    this.gD = true;
                }
            }
        };
        this.Pt = teleportEvent -> {
            Grim2Speed.aEg.timer.dzD = 1.0f;
        };
    }

    @Override
    public void onDisable() {
        Grim2Speed.aEg.timer.dzD = 1.0f;
    }

    @Override
    public void onEnable() {
        if (!((Boolean)this.Pk.wo()).booleanValue()) {
            ahj.l(new C03PacketPlayer(true));
            ahj.l(new C03PacketPlayer(false));
        } else {
            ahj.l(new C03PacketPlayer(false));
            ahj.l(new C03PacketPlayer(false));
        }
        if (ViaLoadingBase.getInstance().getTargetVersion().equalTo(ProtocolVersion.v1_8) || ViaLoadingBase.getInstance().getTargetVersion().newerThanOrEqualTo(ProtocolVersion.v1_18_2)) {
            afi.b("this will only work 1.9-1.18.1", new Object[0]);
        } else {
            afi.b("ping needs to be below 150ms for this to work consistantly", new Object[0]);
        }
        this.Ho = 0;
        this.Pj = 0;
        Grim2Speed.aEg.timer.dzD = 1.0f;
    }
}
