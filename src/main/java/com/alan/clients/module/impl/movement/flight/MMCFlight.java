package com.alan.clients.module.impl.movement.flight;

import com.alan.clients.module.impl.movement.Flight;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.other.TeleportEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import hackclient.rise.ahj;
import hackclient.rise.aih;
import hackclient.rise.bc;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;

public class MMCFlight extends Mode<Flight> {
    private boolean clipped;
    private int ticks;
    @EventLink
    public final Listener<PreMotionEvent> onPreMotionEvent = var1x -> {
        this.ticks++;
        if (aEg.thePlayer.onGround) {
            MoveUtil.stop();
            if (this.ticks == 1 && aih.p(0.0, -2.5, 0.0).isFullBlock()) {
                aEg.timer.dzD = 0.1F;
                bc.cR = true;
                ahj.l(new C04PacketPlayerPosition(aEg.thePlayer.posX, aEg.thePlayer.posY, aEg.thePlayer.posZ, true));
                ahj.l(
                    new C04PacketPlayerPosition(
                        aEg.thePlayer.posX, MoveUtil.roundToGround(aEg.thePlayer.posY - (2.5 - Math.random() / 100.0)), aEg.thePlayer.posZ, false
                    )
                );
                ahj.l(new C04PacketPlayerPosition(aEg.thePlayer.posX, aEg.thePlayer.posY, aEg.thePlayer.posZ, false));
                this.clipped = true;
                aEg.thePlayer.jump();
                MoveUtil.strafe(7.0 - Math.random() / 10.0);
            }
        }
    };
    @EventLink
    public final Listener<StrafeEvent> onStrafe = var0 -> MoveUtil.strafe();
    @EventLink
    public final Listener<TeleportEvent> onTeleport = var1x -> {
        if (this.clipped) {
            var1x.setCancelled();
            this.clipped = false;
        }
    };

    public MMCFlight(String var1, Flight var2) {
        super(var1, var2);
    }

    @Override
    public void onEnable() {
        this.clipped = false;
        this.ticks = 0;
    }

    @Override
    public void onDisable() {
        bc.cR = false;
        MoveUtil.stop();
    }
}
