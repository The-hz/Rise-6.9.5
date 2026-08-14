package com.alan.clients.module.impl.movement.noslow;

import com.alan.clients.component.impl.player.RotationComponent;
import com.alan.clients.component.impl.player.rotationcomponent.MovementFix;
import com.alan.clients.module.impl.movement.NoSlow;
import com.alan.clients.module.impl.movement.Speed;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.MoveInputEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.motion.SlowDownEvent;
import com.alan.clients.newevent.impl.other.BlockAABBEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import hackclient.rise.ea;
import hackclient.rise.en;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemSword;
import net.minecraft.network.play.client.C0FPacketConfirmTransaction;

public class Grim30NoSlow extends Mode<NoSlow> {
    @EventLink
    public Listener<en> MU;
    public BooleanValue MP = new BooleanValue("Heypixel", this, false);
    public static Object[] oO00O0OO0ooO = new Object[1];
    @EventLink
    public Listener<ea> MV;
    public static Object[] fld_0oOOoOo0O00O_35 = new Object[4];
    public int hV;
    @EventLink
    public Listener<PacketSendEvent> MS;
    @EventLink
    public Listener<PreUpdateEvent> MR;
    public static Object[] o0Oo000O0oO = new Object[1];
    @EventLink
    public Listener<MoveInputEvent> MT;
    @EventLink
    public Listener<BlockAABBEvent> MQ = var0 -> {};
    @EventLink
    public Listener<SlowDownEvent> MW;
    public static int[] O0OoOO0OOOOO;

    public Grim30NoSlow(String var1, NoSlow var2) {
        super(var1, var2);
        this.MR = var1x -> {
            if (aEg.thePlayer.isUsingItem()
                && !aEg.thePlayer.onGround
                && !aEg.gameSettings.keyBindRight.isKeyDown()
                && !aEg.gameSettings.keyBindLeft.isKeyDown()) {
                RotationComponent.setRotations(new Vector2f(aEg.thePlayer.pl + 45.0F, aEg.thePlayer.rotationPitch), 10.0, MovementFix.NORMAL);
            }

            if (aEg.thePlayer.isInWeb) {
                MoveUtil.strafe(0.64);
            }

            if (aEg.thePlayer.isUsingItem() && aEg.thePlayer.cqL > 1 && !aEg.gameSettings.keyBindJump.isKeyDown()) {
                if (!this.e(Speed.class).isEnabled()) {
                    MoveUtil.moveFlying(2.0E-4);
                } else {
                    MoveUtil.moveFlying(1.0E-4);
                }

                if (!aEg.gameSettings.keyBindRight.isKeyDown()
                    && !aEg.gameSettings.keyBindLeft.isKeyDown()
                    && !(aEg.thePlayer.getHeldItem().getItem() instanceof ItemBow)) {
                    RotationComponent.setRotations(new Vector2f(aEg.thePlayer.pl + 45.0F, aEg.thePlayer.rotationPitch), 10.0, MovementFix.NORMAL);
                }
            }
        };
        this.MS = var1x -> {
            if (this.MP.wo() && var1x.dq() instanceof C0FPacketConfirmTransaction) {
                if (aEg.thePlayer.isUsingItem()
                    && (
                        aEg.thePlayer.getHeldItem().getItem() instanceof ItemFood
                            || aEg.thePlayer.getHeldItem().getItem() instanceof ItemPotion
                            || aEg.thePlayer.getHeldItem().getItem() instanceof ItemBow
                    )) {
                    var1x.setCancelled();
                }
            }
        };
        this.MT = var1x -> {
            if (this.hV >= 20) {
                ;
            }
        };
        this.MU = var0 -> {
            if (aEg.thePlayer.isUsingItem() && aEg.thePlayer.moveForward > 0.0F) {
                aEg.thePlayer.setSprinting(true);
            }
        };
        this.MV = var0 -> {
            if (aEg.thePlayer.tR % 2 == 1 && !aEg.thePlayer.onGround) {
                var0.setCancelled();
            }
        };
        this.MW = var1x -> {
            if (aEg.thePlayer.isUsingItem()) {
                this.hV++;
                if (!this.e(Speed.class).isEnabled()) {
                    MoveUtil.moveFlying(1.0E-4);
                }
            } else {
                this.hV = 0;
            }

            if (aEg.thePlayer.cqL == 1 || aEg.thePlayer.tR % 2 == 0 && !aEg.thePlayer.onGround || aEg.thePlayer.cqL % 2 == 1 && aEg.thePlayer.onGround) {
                if (this.wj().DO.wo() && aEg.thePlayer.isUsingItem() && aEg.thePlayer.getHeldItem().getItem() instanceof ItemFood) {
                    var1x.setCancelled();
                }

                if (this.wj().DP.wo() && aEg.thePlayer.isUsingItem() && aEg.thePlayer.getHeldItem().getItem() instanceof ItemPotion) {
                    var1x.setCancelled();
                }

                if (this.wj().DQ.wo() && aEg.thePlayer.isUsingItem() && aEg.thePlayer.getHeldItem().getItem() instanceof ItemSword) {
                    var1x.setCancelled();
                }

                if (this.wj().DR.wo() && aEg.thePlayer.isUsingItem() && aEg.thePlayer.getHeldItem().getItem() instanceof ItemBow) {
                    var1x.setCancelled();
                }
            }
        };
    }

    public static void Oo0o00000O00() {
        O0OoOO0OOOOO = new int[400];
        O0OoOO0OOOOO[27] = -71;
        O0OoOO0OOOOO[236] = 55732;
        O0OoOO0OOOOO[213] = -38324;
        O0OoOO0OOOOO[218] = 13933;
        O0OoOO0OOOOO[398] = 34712;
        O0OoOO0OOOOO[242] = 39605;
        O0OoOO0OOOOO[232] = 8607;
        O0OoOO0OOOOO[299] = 41889;
        O0OoOO0OOOOO[130] = 0;
        O0OoOO0OOOOO[243] = 45965;
        O0OoOO0OOOOO[54] = 0;
        O0OoOO0OOOOO[222] = 69114;
        O0OoOO0OOOOO[35] = 4;
        O0OoOO0OOOOO[41] = -86;
        O0OoOO0OOOOO[392] = 7168;
        O0OoOO0OOOOO[122] = -33;
        O0OoOO0OOOOO[200] = 0;
        O0OoOO0OOOOO[55] = 44;
        O0OoOO0OOOOO[40] = -82;
        O0OoOO0OOOOO[187] = 22471;
        O0OoOO0OOOOO[120] = -25;
        O0OoOO0OOOOO[68] = 25918;
        O0OoOO0OOOOO[277] = -67010;
        O0OoOO0OOOOO[257] = 37584;
        O0OoOO0OOOOO[2] = -80;
        O0OoOO0OOOOO[24] = -88;
        O0OoOO0OOOOO[311] = 32919;
        O0OoOO0OOOOO[393] = 40609;
        O0OoOO0OOOOO[133] = 0;
        O0OoOO0OOOOO[119] = -65;
        O0OoOO0OOOOO[85] = 45;
        O0OoOO0OOOOO[142] = 1410;
        O0OoOO0OOOOO[223] = 61171;
        O0OoOO0OOOOO[107] = -128;
        O0OoOO0OOOOO[230] = 46810;
        O0OoOO0OOOOO[155] = 24119;
        O0OoOO0OOOOO[356] = 3;
        O0OoOO0OOOOO[331] = 0;
        O0OoOO0OOOOO[205] = 51530;
        O0OoOO0OOOOO[17] = 26;
        O0OoOO0OOOOO[261] = -5997;
        O0OoOO0OOOOO[124] = 6;
        O0OoOO0OOOOO[207] = 570;
        O0OoOO0OOOOO[319] = 2916;
        O0OoOO0OOOOO[325] = 33086;
        O0OoOO0OOOOO[234] = 8607;
        O0OoOO0OOOOO[148] = 58372;
        O0OoOO0OOOOO[247] = 23656;
        O0OoOO0OOOOO[209] = -631;
        O0OoOO0OOOOO[239] = 39610;
        O0OoOO0OOOOO[32] = -27;
        O0OoOO0OOOOO[174] = -7139;
        O0OoOO0OOOOO[13] = -83;
        O0OoOO0OOOOO[136] = 56175;
        O0OoOO0OOOOO[304] = 50618;
        O0OoOO0OOOOO[71] = 111;
        O0OoOO0OOOOO[45] = 69;
        O0OoOO0OOOOO[268] = 56661;
        O0OoOO0OOOOO[86] = 152;
        O0OoOO0OOOOO[125] = -72;
        O0OoOO0OOOOO[44] = -41;
        O0OoOO0OOOOO[206] = 51505;
        O0OoOO0OOOOO[388] = 2;
        O0OoOO0OOOOO[1] = 113;
        O0OoOO0OOOOO[267] = 56662;
        O0OoOO0OOOOO[387] = 256;
        O0OoOO0OOOOO[53] = 0;
        O0OoOO0OOOOO[316] = 27654;
        O0OoOO0OOOOO[171] = 20902;
        O0OoOO0OOOOO[33] = 52;
        O0OoOO0OOOOO[199] = 36982;
        O0OoOO0OOOOO[170] = 20909;
        O0OoOO0OOOOO[374] = 12;
        O0OoOO0OOOOO[36] = -124;
        O0OoOO0OOOOO[128] = 1;
        O0OoOO0OOOOO[379] = 2;
        O0OoOO0OOOOO[138] = -56094;
        O0OoOO0OOOOO[336] = 18;
        O0OoOO0OOOOO[90] = 41;
        O0OoOO0OOOOO[294] = 15969;
        O0OoOO0OOOOO[385] = 69;
        O0OoOO0OOOOO[262] = 5969;
        O0OoOO0OOOOO[7] = 88;
        O0OoOO0OOOOO[364] = 0;
        O0OoOO0OOOOO[210] = 563;
        O0OoOO0OOOOO[233] = 8614;
        O0OoOO0OOOOO[219] = 69114;
        O0OoOO0OOOOO[211] = 38297;
        O0OoOO0OOOOO[368] = 9;
        O0OoOO0OOOOO[99] = 51;
        O0OoOO0OOOOO[308] = 16930;
        O0OoOO0OOOOO[372] = 2;
        O0OoOO0OOOOO[276] = 67062;
        O0OoOO0OOOOO[117] = -23;
        O0OoOO0OOOOO[297] = -30471;
        O0OoOO0OOOOO[357] = -50;
        O0OoOO0OOOOO[167] = 23262;
        O0OoOO0OOOOO[235] = 55742;
        O0OoOO0OOOOO[231] = 8593;
        O0OoOO0OOOOO[131] = 1;
        O0OoOO0OOOOO[21] = 126;
        O0OoOO0OOOOO[248] = 23677;
        O0OoOO0OOOOO[156] = 37512;
        O0OoOO0OOOOO[92] = -169;
        O0OoOO0OOOOO[25] = -101;
        O0OoOO0OOOOO[19] = 25;
        O0OoOO0OOOOO[139] = 56164;
        O0OoOO0OOOOO[339] = 51269;
        O0OoOO0OOOOO[152] = 24122;
        O0OoOO0OOOOO[287] = 44876;
        O0OoOO0OOOOO[290] = 44890;
        O0OoOO0OOOOO[0] = 33;
        O0OoOO0OOOOO[16] = 84;
        O0OoOO0OOOOO[129] = 2;
        O0OoOO0OOOOO[256] = 37533;
        O0OoOO0OOOOO[278] = 67062;
        O0OoOO0OOOOO[188] = 28870;
        O0OoOO0OOOOO[52] = 2;
        O0OoOO0OOOOO[185] = 22471;
        O0OoOO0OOOOO[228] = 46810;
        O0OoOO0OOOOO[102] = 60;
        O0OoOO0OOOOO[282] = 67301;
        O0OoOO0OOOOO[26] = 11;
        O0OoOO0OOOOO[285] = 9375;
        O0OoOO0OOOOO[194] = 37486;
        O0OoOO0OOOOO[273] = -13189;
        O0OoOO0OOOOO[94] = 110;
        O0OoOO0OOOOO[396] = 49747;
        O0OoOO0OOOOO[196] = 36977;
        O0OoOO0OOOOO[190] = -28842;
        O0OoOO0OOOOO[373] = -12;
        O0OoOO0OOOOO[288] = 44890;
        O0OoOO0OOOOO[4] = -84;
        O0OoOO0OOOOO[397] = 63429;
        O0OoOO0OOOOO[77] = -36;
        O0OoOO0OOOOO[84] = 119;
        O0OoOO0OOOOO[383] = 120;
        O0OoOO0OOOOO[137] = 56164;
        O0OoOO0OOOOO[362] = 10;
        O0OoOO0OOOOO[43] = -20;
        O0OoOO0OOOOO[250] = 23677;
        O0OoOO0OOOOO[197] = 36982;
        O0OoOO0OOOOO[291] = 15977;
        O0OoOO0OOOOO[157] = 37505;
        O0OoOO0OOOOO[172] = 7129;
        O0OoOO0OOOOO[60] = 31626;
        O0OoOO0OOOOO[246] = 45960;
        O0OoOO0OOOOO[151] = 58370;
        O0OoOO0OOOOO[80] = -35;
        O0OoOO0OOOOO[264] = 50463;
        O0OoOO0OOOOO[365] = -66;
        O0OoOO0OOOOO[249] = -23629;
        O0OoOO0OOOOO[279] = 67313;
        O0OoOO0OOOOO[192] = 37443;
        O0OoOO0OOOOO[100] = 43;
        O0OoOO0OOOOO[9] = -27;
        O0OoOO0OOOOO[59] = 14601;
        O0OoOO0OOOOO[176] = 27095;
        O0OoOO0OOOOO[104] = 97;
        O0OoOO0OOOOO[275] = 67041;
        O0OoOO0OOOOO[312] = 32900;
        O0OoOO0OOOOO[30] = -122;
        O0OoOO0OOOOO[314] = 32900;
        O0OoOO0OOOOO[118] = 6;
        O0OoOO0OOOOO[10] = 98;
        O0OoOO0OOOOO[98] = 56;
        O0OoOO0OOOOO[345] = 59253;
        O0OoOO0OOOOO[111] = -108;
        O0OoOO0OOOOO[64] = 19925;
        O0OoOO0OOOOO[67] = 21309;
        O0OoOO0OOOOO[363] = 110;
        O0OoOO0OOOOO[184] = 22471;
        O0OoOO0OOOOO[301] = -41857;
        O0OoOO0OOOOO[334] = 1;
        O0OoOO0OOOOO[366] = 4;
        O0OoOO0OOOOO[83] = -124;
        O0OoOO0OOOOO[87] = 66;
        O0OoOO0OOOOO[154] = -24089;
        O0OoOO0OOOOO[193] = 37451;
        O0OoOO0OOOOO[303] = 50615;
        O0OoOO0OOOOO[145] = 7141;
        O0OoOO0OOOOO[341] = 42926;
        O0OoOO0OOOOO[51] = 0;
        O0OoOO0OOOOO[38] = -117;
        O0OoOO0OOOOO[202] = 32714;
        O0OoOO0OOOOO[335] = 0;
        O0OoOO0OOOOO[337] = 49152;
        O0OoOO0OOOOO[78] = 24;
        O0OoOO0OOOOO[391] = 20096;
        O0OoOO0OOOOO[367] = 70;
        O0OoOO0OOOOO[352] = 1;
        O0OoOO0OOOOO[198] = -36924;
        O0OoOO0OOOOO[293] = 15935;
        O0OoOO0OOOOO[212] = 38274;
        O0OoOO0OOOOO[306] = 50618;
        O0OoOO0OOOOO[146] = -7141;
        O0OoOO0OOOOO[338] = 18181;
        O0OoOO0OOOOO[58] = 51689;
        O0OoOO0OOOOO[351] = 5247;
        O0OoOO0OOOOO[177] = 27091;
        O0OoOO0OOOOO[295] = 30580;
        O0OoOO0OOOOO[49] = 0;
        O0OoOO0OOOOO[217] = 13923;
        O0OoOO0OOOOO[377] = 53;
        O0OoOO0OOOOO[186] = -22411;
        O0OoOO0OOOOO[214] = 38274;
        O0OoOO0OOOOO[324] = 33118;
        O0OoOO0OOOOO[42] = -62;
        O0OoOO0OOOOO[390] = 3;
        O0OoOO0OOOOO[195] = 37451;
        O0OoOO0OOOOO[166] = -23235;
        O0OoOO0OOOOO[79] = -92;
        O0OoOO0OOOOO[123] = -7;
        O0OoOO0OOOOO[191] = 28869;
        O0OoOO0OOOOO[386] = 17;
        O0OoOO0OOOOO[258] = 37533;
        O0OoOO0OOOOO[220] = 69114;
        O0OoOO0OOOOO[245] = -46008;
        O0OoOO0OOOOO[370] = 5;
        O0OoOO0OOOOO[95] = 134;
        O0OoOO0OOOOO[162] = 54327;
        O0OoOO0OOOOO[310] = 16930;
        O0OoOO0OOOOO[181] = 33579;
        O0OoOO0OOOOO[353] = 16;
        O0OoOO0OOOOO[39] = -167;
        O0OoOO0OOOOO[332] = 0;
        O0OoOO0OOOOO[57] = 19462;
        O0OoOO0OOOOO[135] = 1596;
        O0OoOO0OOOOO[96] = -66;
        O0OoOO0OOOOO[91] = -111;
        O0OoOO0OOOOO[182] = 33620;
        O0OoOO0OOOOO[163] = 54322;
        O0OoOO0OOOOO[271] = 13202;
        O0OoOO0OOOOO[369] = -49;
        O0OoOO0OOOOO[47] = 86;
        O0OoOO0OOOOO[266] = 50463;
        O0OoOO0OOOOO[18] = 21;
        O0OoOO0OOOOO[328] = 68774;
        O0OoOO0OOOOO[23] = 125;
        O0OoOO0OOOOO[359] = -72;
        O0OoOO0OOOOO[348] = 30683;
        O0OoOO0OOOOO[63] = 34325;
        O0OoOO0OOOOO[169] = 20902;
        O0OoOO0OOOOO[286] = 9376;
        O0OoOO0OOOOO[272] = 13204;
        O0OoOO0OOOOO[147] = 7141;
        O0OoOO0OOOOO[298] = 30574;
        O0OoOO0OOOOO[215] = 13932;
        O0OoOO0OOOOO[56] = 59138;
        O0OoOO0OOOOO[226] = 61162;
        O0OoOO0OOOOO[251] = 46466;
        O0OoOO0OOOOO[108] = 48;
        O0OoOO0OOOOO[115] = -111;
        O0OoOO0OOOOO[103] = -94;
        O0OoOO0OOOOO[320] = 2927;
        O0OoOO0OOOOO[160] = 54332;
        O0OoOO0OOOOO[263] = 50439;
        O0OoOO0OOOOO[330] = 68774;
        O0OoOO0OOOOO[189] = 28869;
        O0OoOO0OOOOO[224] = 61162;
        O0OoOO0OOOOO[255] = 37505;
        O0OoOO0OOOOO[141] = 1421;
        O0OoOO0OOOOO[260] = 5969;
        O0OoOO0OOOOO[29] = -124;
        O0OoOO0OOOOO[75] = -20;
        O0OoOO0OOOOO[97] = -36;
        O0OoOO0OOOOO[22] = 2;
        O0OoOO0OOOOO[180] = 33575;
        O0OoOO0OOOOO[121] = 72;
        O0OoOO0OOOOO[106] = -11;
        O0OoOO0OOOOO[14] = 111;
        O0OoOO0OOOOO[12] = 193;
        O0OoOO0OOOOO[31] = 96;
        O0OoOO0OOOOO[289] = -44891;
        O0OoOO0OOOOO[159] = 37505;
        O0OoOO0OOOOO[349] = 64411;
        O0OoOO0OOOOO[216] = 13933;
        O0OoOO0OOOOO[321] = 2829;
        O0OoOO0OOOOO[110] = -87;
        O0OoOO0OOOOO[11] = -121;
        O0OoOO0OOOOO[389] = 0;
        O0OoOO0OOOOO[109] = 112;
        O0OoOO0OOOOO[73] = 46;
        O0OoOO0OOOOO[179] = 27091;
        O0OoOO0OOOOO[48] = 3;
        O0OoOO0OOOOO[375] = -97;
        O0OoOO0OOOOO[343] = 23793;
        O0OoOO0OOOOO[20] = -44;
        O0OoOO0OOOOO[313] = -32919;
        O0OoOO0OOOOO[318] = 27654;
        O0OoOO0OOOOO[346] = 13466;
        O0OoOO0OOOOO[8] = -41;
        O0OoOO0OOOOO[252] = 46469;
        O0OoOO0OOOOO[384] = 8;
        O0OoOO0OOOOO[315] = 27668;
        O0OoOO0OOOOO[329] = 68788;
        O0OoOO0OOOOO[3] = 94;
        O0OoOO0OOOOO[105] = 54;
        O0OoOO0OOOOO[113] = 7;
        O0OoOO0OOOOO[208] = 563;
        O0OoOO0OOOOO[50] = 1;
        O0OoOO0OOOOO[253] = -46591;
        O0OoOO0OOOOO[82] = 108;
        O0OoOO0OOOOO[149] = 58370;
        O0OoOO0OOOOO[378] = 13;
        O0OoOO0OOOOO[270] = 56661;
        O0OoOO0OOOOO[76] = -95;
        O0OoOO0OOOOO[342] = 52782;
        O0OoOO0OOOOO[292] = 15969;
        O0OoOO0OOOOO[168] = 20899;
        O0OoOO0OOOOO[225] = 61113;
        O0OoOO0OOOOO[355] = -98;
        O0OoOO0OOOOO[284] = 9376;
        O0OoOO0OOOOO[259] = 5967;
        O0OoOO0OOOOO[323] = 33116;
        O0OoOO0OOOOO[307] = 16934;
        O0OoOO0OOOOO[62] = 7089;
        O0OoOO0OOOOO[376] = 6;
        O0OoOO0OOOOO[144] = 7151;
        O0OoOO0OOOOO[322] = 2927;
        O0OoOO0OOOOO[81] = 72;
        O0OoOO0OOOOO[254] = 46469;
        O0OoOO0OOOOO[175] = 7126;
        O0OoOO0OOOOO[65] = 7447;
        O0OoOO0OOOOO[371] = 23;
        O0OoOO0OOOOO[283] = 9407;
        O0OoOO0OOOOO[350] = 52895;
        O0OoOO0OOOOO[394] = 47682;
        O0OoOO0OOOOO[240] = 39605;
        O0OoOO0OOOOO[227] = 46791;
        O0OoOO0OOOOO[237] = -55707;
        O0OoOO0OOOOO[69] = 43007;
        O0OoOO0OOOOO[127] = -6;
        O0OoOO0OOOOO[229] = -46758;
        O0OoOO0OOOOO[101] = -18;
        O0OoOO0OOOOO[241] = 39555;
        O0OoOO0OOOOO[15] = 112;
        O0OoOO0OOOOO[164] = 23260;
        O0OoOO0OOOOO[161] = 54322;
        O0OoOO0OOOOO[6] = 114;
        O0OoOO0OOOOO[173] = 7126;
        O0OoOO0OOOOO[61] = 30736;
        O0OoOO0OOOOO[221] = 69054;
        O0OoOO0OOOOO[140] = 1420;
        O0OoOO0OOOOO[395] = 19698;
        O0OoOO0OOOOO[114] = -74;
        O0OoOO0OOOOO[382] = 7;
        O0OoOO0OOOOO[326] = 33118;
        O0OoOO0OOOOO[46] = -49;
        O0OoOO0OOOOO[150] = -58483;
        O0OoOO0OOOOO[203] = 51488;
        O0OoOO0OOOOO[178] = 27122;
        O0OoOO0OOOOO[381] = -107;
        O0OoOO0OOOOO[89] = -71;
        O0OoOO0OOOOO[296] = 30574;
        O0OoOO0OOOOO[112] = 29;
        O0OoOO0OOOOO[201] = 32746;
        O0OoOO0OOOOO[5] = -10;
        O0OoOO0OOOOO[153] = 24119;
        O0OoOO0OOOOO[269] = -56647;
        O0OoOO0OOOOO[380] = 1;
        O0OoOO0OOOOO[333] = 0;
        O0OoOO0OOOOO[274] = 13204;
        O0OoOO0OOOOO[126] = -98;
        O0OoOO0OOOOO[93] = 91;
        O0OoOO0OOOOO[74] = 107;
        O0OoOO0OOOOO[280] = 67301;
        O0OoOO0OOOOO[204] = 51505;
        O0OoOO0OOOOO[344] = 26641;
        O0OoOO0OOOOO[37] = 18;
        O0OoOO0OOOOO[358] = 14;
        O0OoOO0OOOOO[399] = 45256;
        O0OoOO0OOOOO[244] = 45960;
        O0OoOO0OOOOO[116] = 15;
        O0OoOO0OOOOO[132] = 1;
        O0OoOO0OOOOO[281] = 67235;
        O0OoOO0OOOOO[302] = 41901;
        O0OoOO0OOOOO[265] = 50520;
        O0OoOO0OOOOO[183] = 33579;
        O0OoOO0OOOOO[165] = 23262;
        O0OoOO0OOOOO[66] = 28760;
        O0OoOO0OOOOO[361] = 10;
        O0OoOO0OOOOO[88] = -54;
        O0OoOO0OOOOO[158] = 37578;
        O0OoOO0OOOOO[309] = 17012;
        O0OoOO0OOOOO[347] = 60378;
        O0OoOO0OOOOO[134] = 1580;
        O0OoOO0OOOOO[70] = 0;
        O0OoOO0OOOOO[300] = 41901;
        O0OoOO0OOOOO[340] = 11915;
        O0OoOO0OOOOO[34] = 36;
        O0OoOO0OOOOO[72] = 33;
        O0OoOO0OOOOO[360] = 11;
        O0OoOO0OOOOO[354] = 15;
        O0OoOO0OOOOO[317] = 27720;
        O0OoOO0OOOOO[238] = 55732;
        O0OoOO0OOOOO[28] = -52;
        O0OoOO0OOOOO[305] = -50576;
        O0OoOO0OOOOO[143] = 1421;
        O0OoOO0OOOOO[327] = 68790;
    }

    static {
        Oo0o00000O00();
        fld_0oOOoOo0O00O_35[0] = "B6sSVXk1h4LYEXJCXiJckdSVUcuJX62zErtGS4YBNrA=";
        fld_0oOOoOo0O00O_35[1] = "PBKDF2WithHmacSHA1";
        fld_0oOOoOo0O00O_35[2] = "AES";
        fld_0oOOoOo0O00O_35[3] = "AES/CBC/PKCS5Padding";
        oO00O0OO0ooO[0] = "\u0000\bHeypixel";
        o0Oo000O0oO[0] = "Heypixel";
    }
}
