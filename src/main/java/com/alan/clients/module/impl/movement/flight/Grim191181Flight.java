package com.alan.clients.module.impl.movement.flight;

import com.alan.clients.module.impl.movement.Flight;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PostStrafeEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.other.TeleportEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.NumberValue;
import hackclient.rise.ahj;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.server.S12PacketEntityVelocity;

public class Grim191181Flight extends Mode<Flight> {
    public BooleanValue glideLessFlyMore = new BooleanValue("Glide less/Fly more", this, true);
    @EventLink
    public Listener<PostStrafeEvent> onPostStrafe;
    public NumberValue timer;
    @EventLink
    public Listener<PreMotionEvent> onPreMotion;
    @EventLink
    public Listener<TeleportEvent> onTeleport;
    @EventLink
    public Listener<PacketReceiveEvent> onPacketReceive;
    public boolean Ga;
    public NumberValue speed = new NumberValue("Speed", this, 0.275, 0, 0.32, 0.001);
    public boolean Eo;

    public Grim191181Flight(String var1, Flight var2) {
        super(var1, var2);
        this.timer = new NumberValue("Timer", this, 1, 0.1, 10, 0.1);
        this.onPostStrafe = var1x -> {
            aEg.timer.dzD = this.timer.wo().floatValue();
            if (!this.Eo && aEg.thePlayer.fallDistance > 0.0F) {
                ahj.l(new C03PacketPlayer(true));
                aEg.thePlayer.fallDistance = 0.0F;
                this.Eo = true;
            }

            if (this.Eo) {
                aEg.thePlayer.motionX = 0.0;
                aEg.thePlayer.motionZ = 0.0;
                aEg.thePlayer.motionY = 0.0;
            }

            if (this.Ga) {
                MoveUtil.preventDiagonalSpeed();
                MoveUtil.moveFlying(this.speed.wo().doubleValue());
                if (this.glideLessFlyMore.wo()) {
                    aEg.thePlayer.motionY = -1.1E-4;
                } else {
                    aEg.thePlayer.motionY = -2.0E-4;
                }

                MoveUtil.preventDiagonalSpeed();
                this.Ga = false;
            }

            MoveUtil.preventDiagonalSpeed();
        };
        this.onPreMotion = var1x -> {
            if (this.Eo) {
                var1x.setCancelled();
            }
        };
        this.onPacketReceive = var1x -> {
            Packet packet = var1x.getPacket();
            if (packet instanceof S12PacketEntityVelocity && ((S12PacketEntityVelocity)packet).getEntityID() == aEg.thePlayer.getEntityId()) {
                this.Eo = false;
                var1x.setCancelled();
                this.Ga = true;
            }
        };
        this.onTeleport = var0 -> {};
    }

    @Override
    public void onEnable() {
        this.Eo = false;
    }


    static {
    }

    @Override
    public void onDisable() {
    }
}
