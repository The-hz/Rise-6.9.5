package com.alan.clients.module.impl.movement.flight;

import com.alan.clients.module.impl.movement.Flight;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.NumberValue;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer.C06PacketPlayerPosLook;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;

public class MatrixHighJumpFlight extends Mode<Flight> {
    private final BooleanValue selfDamage = new BooleanValue("Self Damage", this, false);
    private final NumberValue height = new NumberValue("Height", this, 1.0, 0.42, 7.0, 0.1);
    private int Hb;
    private boolean Hc;
    private boolean Hd;
    private double He;
    private double Hf;
    private double Hg;
    @EventLink
    public final Listener<PreUpdateEvent> onPreUpdate = var1x -> {
        if (this.Hd) {
            aEg.thePlayer.motionY = this.height.wo().doubleValue();
        }

        if (aEg.thePlayer.hurtTime >= 1 && aEg.thePlayer.hurtTime <= 8) {
            if (aEg.thePlayer.onGround) {
                aEg.thePlayer.jump();
            } else if (aEg.thePlayer.motionY < 0.2) {
                this.Hd = true;
            }
        }

        if (this.Hb < 4 && this.selfDamage.wo() && aEg.thePlayer.onGround) {
            aEg.thePlayer.jump();
            this.Hb++;
        }
    };
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var1x -> {
        if (this.Hb < 4 && this.selfDamage.wo()) {
            var1x.setOnGround(false);
        }
    };
    @EventLink
    public final Listener<PacketSendEvent> onPacketSend = var1x -> {
        if (var1x.dq() instanceof C06PacketPlayerPosLook && this.Hc) {
            this.Hc = false;
            aEg.thePlayer.motionX = this.He;
            aEg.thePlayer.motionY = this.Hf;
            aEg.thePlayer.motionZ = this.Hg;
        }
    };
    @EventLink
    public final Listener<PacketReceiveEvent> onPacketReceive = var1x -> {
        Packet packet = var1x.getPacket();
        if (this.Hd && packet instanceof S08PacketPlayerPosLook) {
            this.Hc = true;
            this.He = aEg.thePlayer.motionX;
            this.Hf = aEg.thePlayer.motionY;
            this.Hg = aEg.thePlayer.motionZ;
            this.Hd = false;
        }
    };

    public MatrixHighJumpFlight(String var1, Flight var2) {
        super(var1, var2);
    }

    @Override
    public void onEnable() {
        this.Hb = 0;
        this.Hd = false;
        this.Hc = false;
    }

    @Override
    public void onDisable() {
        MoveUtil.stop();
    }
}
