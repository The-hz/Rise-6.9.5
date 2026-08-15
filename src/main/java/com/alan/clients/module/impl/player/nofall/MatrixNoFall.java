package com.alan.clients.module.impl.player.nofall;

import com.alan.clients.module.impl.player.NoFall;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.value.Mode;
import com.alan.clients.util.packet.PacketUtil;
import net.minecraft.network.play.client.C03PacketPlayer;

public class MatrixNoFall extends Mode<NoFall> {
    private int aiL = 0;
    private boolean aiM = false;
    private boolean aiN = false;
    @EventLink
    public final Listener<PreUpdateEvent> onPreUpdate = var1x -> {
        if (Math.round(aEg.thePlayer.fallDistance) - aEg.thePlayer.motionY > 3.0) {
            aEg.thePlayer.motionY = 0.0;
            aEg.thePlayer.fallDistance = 0.0F;
            aEg.thePlayer.motionX *= 0.1;
            aEg.thePlayer.motionZ *= 0.1;
            this.aiN = true;
        }

        if (aEg.thePlayer.fallDistance / 3.0F > this.aiL) {
            this.aiL = Math.round(aEg.thePlayer.fallDistance) / 3;
            this.aiM = true;
        }

        if (aEg.thePlayer.onGround) {
            this.aiL = 0;
        }
    };
    @EventLink
    public final Listener<PacketSendEvent> onPacketSend = var1x -> {
        if (var1x.dq() instanceof C03PacketPlayer c03packetplayer && this.aiN) {
            aEg.timer.dzD = 0.5F;
            c03packetplayer.aO = false;
            PacketUtil.m(new C03PacketPlayer(true));
            this.aiN = false;
        }
    };

    public MatrixNoFall(String var1, NoFall noFall) {
        super(var1, noFall);
    }

    @Override
    public void onEnable() {
        this.aiN = false;
        this.aiM = false;
        this.aiL = 0;
    }
}
