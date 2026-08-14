package com.alan.clients.module.impl.movement.longjump;

import com.alan.clients.module.impl.movement.LongJump;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PostStrafeEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.value.Mode;
import hackclient.rise.ahj;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.network.play.server.S12PacketEntityVelocity;

public class GrimLongJump
extends Mode<LongJump> {
    public int Lh;
    public int Ll;
    public int hV;
    @EventLink
    public Listener<PacketReceiveEvent> Lp;
    public int Lm;
    public int Li;
    @EventLink
    public Listener<PreMotionEvent> Ln = preMotionEvent -> {
        long l2 = 0L;
        long l3 = -2156287223722575119L;
        GrimLongJump.aEg.timer.dzD = 2.0f;
        preMotionEvent.setPitch((float)((double)preMotionEvent.getPitch() + (double)((float)Math.random()) * 0.1));
        if (this.Li == 0) {
            return;
        }
        GrimLongJump.aEg.thePlayer.motionY = 0.42f;
        if (this.Lj == 1) {
            this.Lj = 2;
            this.Lm = 0;
            return;
        }
        if (this.Lj != 2) {
            GrimLongJump.aEg.thePlayer.motionY = 0.0;
            GrimLongJump.aEg.thePlayer.motionX = 0.0;
            GrimLongJump.aEg.thePlayer.motionZ = 0.0;
            this.Ll = 1;
            ++this.Lm;
            if (this.Lm <= 20) return;
            this.toggle();
            return;
        }
        long l4 = l3;
        long l5 = l4 ^ (0L ^ l4) & -1L << 32;
        while (true) {
            if ((int)(l5 >>> 32) >= 2) {
                this.Ll = 1;
                this.Lj = 0xFFFFFFC0 ^ 0xFFFFFFC0;
                return;
            }
            ahj.m(new C03PacketPlayer(false));
            l5 += 0x100000000L;
        }
    };
    public int Lj;
    public double Lg;
    public static int[] fld_0OOOoo00o0_32;
    public int Lk;
    @EventLink
    public Listener<PacketSendEvent> Lq;
    @EventLink
    public Listener<PostStrafeEvent> Lo = postStrafeEvent -> {
        long l2 = 0L;
        long l3 = -8335158128059520353L;
        if (this.Lh == 0) {
            GrimLongJump.aEg.thePlayer.jump();
        }
        if (this.Lh == 1) {
            this.Li = 1;
            long l4 = l3;
            long l5 = l4 ^ (0L ^ l4) & -1L << 32;
            while ((int)(l5 >>> 32) < 20) {
                ahj.m(new C03PacketPlayer(false));
                l5 += 0x100000000L;
            }
        }
        ++this.Lh;
    };

    public static void o0Oo000O0oO() {
        fld_0OOOoo00o0_32 = new int[87];
        GrimLongJump.fld_0OOOoo00o0_32[24] = 36;
        GrimLongJump.fld_0OOOoo00o0_32[77] = -64;
        GrimLongJump.fld_0OOOoo00o0_32[29] = 122;
        GrimLongJump.fld_0OOOoo00o0_32[48] = 97;
        GrimLongJump.fld_0OOOoo00o0_32[80] = -105;
        GrimLongJump.fld_0OOOoo00o0_32[82] = 113;
        GrimLongJump.fld_0OOOoo00o0_32[16] = 71;
        GrimLongJump.fld_0OOOoo00o0_32[7] = -37;
        GrimLongJump.fld_0OOOoo00o0_32[61] = -85;
        GrimLongJump.fld_0OOOoo00o0_32[30] = 193;
        GrimLongJump.fld_0OOOoo00o0_32[79] = -85;
        GrimLongJump.fld_0OOOoo00o0_32[50] = -8;
        GrimLongJump.fld_0OOOoo00o0_32[10] = 20;
        GrimLongJump.fld_0OOOoo00o0_32[1] = -6;
        GrimLongJump.fld_0OOOoo00o0_32[28] = -36;
        GrimLongJump.fld_0OOOoo00o0_32[54] = 27;
        GrimLongJump.fld_0OOOoo00o0_32[13] = 17;
        GrimLongJump.fld_0OOOoo00o0_32[45] = -117;
        GrimLongJump.fld_0OOOoo00o0_32[4] = 116;
        GrimLongJump.fld_0OOOoo00o0_32[26] = 60;
        GrimLongJump.fld_0OOOoo00o0_32[33] = -10;
        GrimLongJump.fld_0OOOoo00o0_32[46] = 72;
        GrimLongJump.fld_0OOOoo00o0_32[36] = -8;
        GrimLongJump.fld_0OOOoo00o0_32[27] = 87;
        GrimLongJump.fld_0OOOoo00o0_32[5] = 59;
        GrimLongJump.fld_0OOOoo00o0_32[81] = 3;
        GrimLongJump.fld_0OOOoo00o0_32[78] = 61;
        GrimLongJump.fld_0OOOoo00o0_32[21] = 34;
        GrimLongJump.fld_0OOOoo00o0_32[69] = -19;
        GrimLongJump.fld_0OOOoo00o0_32[68] = -16;
        GrimLongJump.fld_0OOOoo00o0_32[83] = -109;
        GrimLongJump.fld_0OOOoo00o0_32[44] = 24;
        GrimLongJump.fld_0OOOoo00o0_32[14] = 67;
        GrimLongJump.fld_0OOOoo00o0_32[74] = 104;
        GrimLongJump.fld_0OOOoo00o0_32[71] = -52;
        GrimLongJump.fld_0OOOoo00o0_32[84] = 107;
        GrimLongJump.fld_0OOOoo00o0_32[6] = -82;
        GrimLongJump.fld_0OOOoo00o0_32[23] = 61;
        GrimLongJump.fld_0OOOoo00o0_32[42] = 81;
        GrimLongJump.fld_0OOOoo00o0_32[35] = -111;
        GrimLongJump.fld_0OOOoo00o0_32[15] = -4;
        GrimLongJump.fld_0OOOoo00o0_32[86] = -90;
        GrimLongJump.fld_0OOOoo00o0_32[38] = -5;
        GrimLongJump.fld_0OOOoo00o0_32[67] = 42;
        GrimLongJump.fld_0OOOoo00o0_32[31] = -71;
        GrimLongJump.fld_0OOOoo00o0_32[52] = -44;
        GrimLongJump.fld_0OOOoo00o0_32[56] = 75;
        GrimLongJump.fld_0OOOoo00o0_32[57] = 128;
        GrimLongJump.fld_0OOOoo00o0_32[25] = -25;
        GrimLongJump.fld_0OOOoo00o0_32[72] = 186;
        GrimLongJump.fld_0OOOoo00o0_32[22] = 27;
        GrimLongJump.fld_0OOOoo00o0_32[40] = 22;
        GrimLongJump.fld_0OOOoo00o0_32[64] = -87;
        GrimLongJump.fld_0OOOoo00o0_32[58] = -54;
        GrimLongJump.fld_0OOOoo00o0_32[63] = 242;
        GrimLongJump.fld_0OOOoo00o0_32[43] = -71;
        GrimLongJump.fld_0OOOoo00o0_32[2] = -47;
        GrimLongJump.fld_0OOOoo00o0_32[32] = -121;
        GrimLongJump.fld_0OOOoo00o0_32[73] = 81;
        GrimLongJump.fld_0OOOoo00o0_32[37] = -35;
        GrimLongJump.fld_0OOOoo00o0_32[51] = 1;
        GrimLongJump.fld_0OOOoo00o0_32[19] = 22;
        GrimLongJump.fld_0OOOoo00o0_32[18] = 30;
        GrimLongJump.fld_0OOOoo00o0_32[62] = -42;
        GrimLongJump.fld_0OOOoo00o0_32[9] = -59;
        GrimLongJump.fld_0OOOoo00o0_32[75] = -139;
        GrimLongJump.fld_0OOOoo00o0_32[76] = 75;
        GrimLongJump.fld_0OOOoo00o0_32[60] = -95;
        GrimLongJump.fld_0OOOoo00o0_32[8] = -45;
        GrimLongJump.fld_0OOOoo00o0_32[66] = -56;
        GrimLongJump.fld_0OOOoo00o0_32[39] = 147;
        GrimLongJump.fld_0OOOoo00o0_32[3] = -57;
        GrimLongJump.fld_0OOOoo00o0_32[34] = -69;
        GrimLongJump.fld_0OOOoo00o0_32[65] = 123;
        GrimLongJump.fld_0OOOoo00o0_32[41] = -105;
        GrimLongJump.fld_0OOOoo00o0_32[70] = 33;
        GrimLongJump.fld_0OOOoo00o0_32[55] = -82;
        GrimLongJump.fld_0OOOoo00o0_32[17] = -75;
        GrimLongJump.fld_0OOOoo00o0_32[20] = 7;
        GrimLongJump.fld_0OOOoo00o0_32[53] = 43;
        GrimLongJump.fld_0OOOoo00o0_32[0] = 41;
        GrimLongJump.fld_0OOOoo00o0_32[59] = -72;
        GrimLongJump.fld_0OOOoo00o0_32[49] = -104;
        GrimLongJump.fld_0OOOoo00o0_32[11] = -39;
        GrimLongJump.fld_0OOOoo00o0_32[85] = 3;
        GrimLongJump.fld_0OOOoo00o0_32[12] = 82;
        GrimLongJump.fld_0OOOoo00o0_32[47] = -46;
    }

    @Override
    public void onDisable() {
    }

    @Override
    public void onEnable() {
        this.Lh = 0;
        this.Li = 0;
        this.Lj = 0;
        this.Lk = 0;
        this.Ll = 0;
        this.Lm = 0;
    }

    static {
        GrimLongJump.o0Oo000O0oO();
    }

    public GrimLongJump(String string, LongJump longJump) {
        super(string, longJump);
        this.Lp = packetReceiveEvent -> {
            S12PacketEntityVelocity s12PacketEntityVelocity;
            Packet<?> packet = packetReceiveEvent.dq();
            if (packet instanceof S12PacketEntityVelocity && (s12PacketEntityVelocity = (S12PacketEntityVelocity)packet).getEntityID() == GrimLongJump.aEg.thePlayer.getEntityId() && (double)s12PacketEntityVelocity.getMotionY() / 8000.0 < 0.0) {
                this.toggle();
            }
            if (packetReceiveEvent.dq() instanceof S08PacketPlayerPosLook) {
                this.Lj = 1;
            }
        };
        this.Lq = packetSendEvent -> {
            if (packetSendEvent.dq() instanceof C03PacketPlayer && this.Ll == 1) {
                this.Ll = 0;
                packetSendEvent.setCancelled();
            }
        };
    }
}
