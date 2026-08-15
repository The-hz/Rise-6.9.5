package com.alan.clients.module.impl.movement.flight;

import com.alan.clients.module.impl.combat.KillAura;
import com.alan.clients.module.impl.movement.Flight;
import com.alan.clients.module.impl.movement.Speed;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PostStrafeEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import hackclient.rise.aka;

public class SlimeNCPFlight extends Mode<Flight> {
    private double tU;
    private final double HU = 0.03;
    private final double HV = 0.053299998353843775;
    private final double HW = 1.0;
    private int tY;
    private boolean started;
    private aka ua;
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var0 -> {};
    @EventLink
    public final Listener<StrafeEvent> onStrafe = var0 -> {
        int i = (aEg.thePlayer.tR - 1) % 3;
    };
    @EventLink
    public final Listener<PostStrafeEvent> onPostStrafe = var1x -> {
        if (aEg.thePlayer.onGround) {
            aEg.thePlayer.jump();
        } else if ((aEg.thePlayer.tR - 1) % 3 == 0) {
            this.ua = new aka(aEg.thePlayer.motionX, aEg.thePlayer.motionY, aEg.thePlayer.motionZ);
            aEg.thePlayer.motionY = 0.0;
            MoveUtil.stop();
        } else if (this.ua != null) {
            if (Math.abs(this.ua.getX()) < 0.005) {
                this.ua.setX(0.0);
            }

            if (Math.abs(this.ua.getY()) < 0.005) {
                this.ua.setY(0.0);
            }

            if (Math.abs(this.ua.getZ()) < 0.005) {
                this.ua.setZ(0.0);
            }

            double d0 = aEg.thePlayer.tR <= 1 ? 0.5460000157356262 : 1.0;
            aEg.thePlayer.motionX = this.ua.getX() * d0;
            aEg.thePlayer.motionY = this.ua.getY() * d0;
            aEg.thePlayer.motionZ = this.ua.getZ() * d0;
            this.ua = null;
            this.started = true;
        } else if (this.started) {
            this.started = false;
            if (!KillAura.nQ) {
            }
        }
    };

    public SlimeNCPFlight(String var1, Flight flight) {
        super(var1, flight);
    }

    @Override
    public void onDisable() {
        this.tU = 0.0;
        aEg.timer.dzD = 1.0F;
        if (this.ua != null) {
            aEg.thePlayer.motionX = this.ua.getX() * 0.91F;
            aEg.thePlayer.motionY = this.ua.getY();
            aEg.thePlayer.motionZ = this.ua.getZ() * 0.91F;
            this.ua = null;
        }
    }

    @Override
    public void onEnable() {
        if (this.e(Speed.class).isEnabled()) {
            this.e(Speed.class).setEnabled(false);
        }

        this.tU = 0.0;
        this.tY = 0;
    }
}
