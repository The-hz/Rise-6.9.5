package com.alan.clients.module.impl.movement.phase;

import com.alan.clients.module.impl.movement.Phase;
import com.alan.clients.newevent.CancellableEvent;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.PushOutOfBlockEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.other.BlockAABBEvent;
import com.alan.clients.newevent.impl.other.MoveEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.NumberValue;
import hackclient.rise.afi;
import hackclient.rise.ahj;
import hackclient.rise.aih;
import net.minecraft.block.BlockAir;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;

public class WatchdogSemiBlockPhase extends Mode<Phase> {
    private final NumberValue OH = new NumberValue("Amount", this, 1, 0.1, 1.5, 0.1);
    private final NumberValue OI = new NumberValue("Timer", this, 0.1, 0.1, 1, 0.1);
    private final BooleanValue OJ = new BooleanValue("Packet", this, false);
    private boolean OK;
    private boolean Od;
    private double OL;
    private double OM;
    @EventLink
    public final Listener<PreMotionEvent> ON = var1x -> {
        this.Od = false;
        double d0 = Math.toRadians(aEg.thePlayer.pl);
        double d1 = Math.sin(d0);
        double d2 = Math.cos(d0);
        if (aEg.thePlayer.isCollidedHorizontally) {
            aEg.thePlayer.setPosition(aEg.thePlayer.posX - d1 * 0.01, aEg.thePlayer.posY, aEg.thePlayer.posZ + d2 * 0.01);
            this.Od = true;
        } else if (this.OK && aih.vk()) {
            aEg.timer.dzD = this.OI.wo().floatValue();
            if (!this.OJ.wo()) {
                aEg.thePlayer
                    .setPosition(aEg.thePlayer.posX - d1 * this.OH.wo().doubleValue(), aEg.thePlayer.posY, aEg.thePlayer.posZ + d2 * this.OH.wo().doubleValue());
            } else {
                ahj.m(
                    new C04PacketPlayerPosition(
                        aEg.thePlayer.posX - d1 * this.OH.wo().doubleValue(), aEg.thePlayer.posY, aEg.thePlayer.posZ + d2 * this.OH.wo().doubleValue(), false
                    )
                );
            }

            this.Od = true;
        }
    };
    @EventLink
    public final Listener<StrafeEvent> OO = var1x -> {
        if (this.OK && aih.vk()) {
            MoveUtil.stop();
        }
    };
    @EventLink
    public final Listener<PushOutOfBlockEvent> OP = CancellableEvent::setCancelled;
    @EventLink
    public final Listener<BlockAABBEvent> OQ = var1x -> {
        if (var1x.df() instanceof BlockAir && this.Od) {
            double d2 = var1x.dg().getX();
            double d0 = var1x.dg().getY();
            d2 = var1x.dg().getZ();
            double d1;
            int i = (d1 = d0 - aEg.thePlayer.posY) == 0.0 ? 0 : (d1 < 0.0 ? -1 : 1);
        }
    };
    @EventLink
    private final Listener<MoveEvent> OR = var1x -> {
        if (this.OK) {
            aih.vk();
        }
    };
    @EventLink
    private final Listener<PacketReceiveEvent> OS = var1x -> {
        if (var1x.dq() instanceof S08PacketPlayerPosLook) {
            S08PacketPlayerPosLook s08packetplayerposlook = (S08PacketPlayerPosLook)var1x.dq();
            double d0 = s08packetplayerposlook.getX();
            double d1 = s08packetplayerposlook.getZ();
            double d2 = Math.abs(d0 - this.OL);
            double d3 = Math.abs(d1 - this.OM);
            this.OL = d0;
            this.OM = d1;
            if (d2 <= 0.001 && d3 <= 0.001) {
                this.OK = true;
            } else {
                this.OK = false;
            }
        }
    };

    public WatchdogSemiBlockPhase(String var1, Phase var2) {
        super(var1, var2);
    }

    @Override
    public void onEnable() {
        afi.b("try to jump around a bit before phasing if its the start of a game");
    }

    @Override
    public void onDisable() {
        this.OK = false;
    }
}
