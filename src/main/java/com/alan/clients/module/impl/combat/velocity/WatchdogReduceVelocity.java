package com.alan.clients.module.impl.combat.velocity;

import com.alan.clients.module.impl.combat.Velocity;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import hackclient.rise.ahj;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C02PacketUseEntity.Action;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S32PacketConfirmTransaction;
import net.minecraft.network.play.server.z;

public class WatchdogReduceVelocity extends Mode<Velocity> {
    private final BooleanValue cancelOnGround = new BooleanValue("Cancel On Ground", this, true);
    private final BooleanValue cancelOnAttack = new BooleanValue("Cancel On Attack", this, true);
    private final BooleanValue cancelExplosions = new BooleanValue("Cancel Explosions", this, true);
    private final List<Packet<?>> vL = new ArrayList<>();
    private boolean vM = false;
    @EventLink
    public final Listener<PacketReceiveEvent> onPacketReceive = var1x -> {
        if (!this.vM && aEg.thePlayer != null) {
            Packet packet = var1x.getPacket();
            if (packet instanceof S12PacketEntityVelocity s12packetentityvelocity) {
                if (s12packetentityvelocity.getEntityID() == aEg.thePlayer.getEntityId()) {
                    var1x.setCancelled();
                    synchronized (this.vL) {
                        this.vL.add(packet);
                    }
                }
            } else if (packet instanceof S32PacketConfirmTransaction) {
                synchronized (this.vL) {
                    if (!this.vL.isEmpty()) {
                        var1x.setCancelled();
                        this.vL.add(packet);
                    }
                }
            } else if (packet instanceof z) {
                synchronized (this.vL) {
                    if (!this.vL.isEmpty()) {
                        var1x.setCancelled();
                        this.vL.add(packet);
                    }
                }
            }
        }
    };
    @EventLink
    public final Listener<PacketSendEvent> onPacketSend = var1x -> {
        if (this.cancelOnAttack.wo()) {
            Packet packet = var1x.dq();
            if (packet instanceof C02PacketUseEntity && ((C02PacketUseEntity)packet).getAction() == Action.ATTACK) {
                this.v("attack");
            }
        }
    };
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var1x -> {
        if (this.cancelOnGround.wo()) {
            if (aEg.thePlayer.onGround && !this.vL.isEmpty()) {
                this.v("ground");
            }
        }
    };

    public WatchdogReduceVelocity(String var1, Velocity var2) {
        super(var1, var2);
    }

    private void v(String param1) {
        List<Packet<?>> list;
        synchronized (this.vL) {
            if (this.vL.isEmpty()) {
                return;
            }

            list = new ArrayList<>(this.vL);
            this.vL.clear();
        }

        this.vM = true;

        try {
            for (Packet<?> packet : list) {
                ahj.p(packet);
            }
        } finally {
            this.vM = false;
        }
    }

    @Override
    public void onDisable() {
        this.v("disable");
    }
}
