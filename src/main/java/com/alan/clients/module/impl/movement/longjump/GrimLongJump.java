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
