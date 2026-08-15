package com.alan.clients.module.impl.movement.speed;

import com.alan.clients.module.impl.combat.KillAura;
import com.alan.clients.module.impl.movement.Speed;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PostStrafeEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.NumberValue;
import hackclient.rise.aka;

public class WatchdogPredictionSpeed extends Mode<Speed> {
    private final NumberValue speed = new NumberValue("Speed", this, 1, 1, 10, 1);
    private double tU;
    private final double PI = 0.03;
    private final double PJ = 0.053299998353843775;
    private final double PK = 1.0;
    private int tY;
    private boolean tZ;
    private aka ua;
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var0 -> {};
    @EventLink
    public final Listener<StrafeEvent> onStrafe = var0 -> {};
    @EventLink
    public final Listener<PostStrafeEvent> onPostStrafe = var1x -> {
        if (aEg.thePlayer.onGround && MoveUtil.isMoving() && !aEg.thePlayer.inWater) {
            aEg.thePlayer.jump();
        }

        if (aEg.thePlayer.tR == 5 && aEg.thePlayer.ae > 7) {
            this.ua = new aka(aEg.thePlayer.motionX, aEg.thePlayer.motionY, aEg.thePlayer.motionZ);
            aEg.thePlayer.motionY = 0.0;
            MoveUtil.stop();
        } else if (this.ua != null && aEg.thePlayer.ae > 7 && aEg.thePlayer.tR == 6) {
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
            aEg.thePlayer.motionY = this.ua.getY() - 0.02 * d0;
            aEg.thePlayer.motionZ = this.ua.getZ() * d0;
            if (KillAura.nQ) {
                MoveUtil.moveFlying(0.1);
            } else {
                MoveUtil.moveFlying(0.1);
            }

            this.ua = null;
            this.tZ = true;
        } else if (this.tZ && aEg.thePlayer.ae > 7 && !KillAura.nQ && aEg.thePlayer.tR == 7) {
            double d1 = aEg.thePlayer.tR <= 1 ? 0.5460000157356262 : 1.0;
            MoveUtil.moveFlying(0.06);
            this.tZ = false;
        }

        if (aEg.thePlayer.inWater) {
            aEg.gameSettings.keyBindJump.setPressed(true);
            if ((aEg.thePlayer.tR - 1) % 3 == 0 && aEg.thePlayer.ae > 1) {
                this.ua = new aka(aEg.thePlayer.motionX, aEg.thePlayer.motionY, aEg.thePlayer.motionZ);
                aEg.thePlayer.motionY = 0.0;
                MoveUtil.stop();
            } else if (this.ua != null && aEg.thePlayer.ae > 2) {
                if (Math.abs(this.ua.getX()) < 0.005) {
                    this.ua.setX(0.0);
                }

                if (Math.abs(this.ua.getY()) < 0.005) {
                    this.ua.setY(0.0);
                }

                if (Math.abs(this.ua.getZ()) < 0.005) {
                    this.ua.setZ(0.0);
                }

                double d2 = aEg.thePlayer.tR <= 1 ? 0.5460000157356262 : 1.0;
                double d3 = 1.0;
                aEg.thePlayer.motionX = this.ua.getX() * d2;
                aEg.thePlayer.motionY = (this.ua.getY() - 1.0E-14) * d3;
                aEg.thePlayer.motionZ = this.ua.getZ() * d2;
                if (!KillAura.nQ) {
                    MoveUtil.moveFlying(0.087);
                } else {
                    MoveUtil.moveFlying(0.063);
                }

                this.ua = null;
                this.tZ = true;
            } else if (this.tZ && aEg.thePlayer.ae > 2) {
                this.tZ = false;
                if (!KillAura.nQ) {
                    MoveUtil.moveFlying(0.086);
                } else {
                    MoveUtil.moveFlying(0.063);
                }
            }
        }
    };

    public WatchdogPredictionSpeed(String var1, Speed var2) {
        super(var1, var2);
    }

    @Override
    public void onDisable() {
        this.tU = 0.0;
        if (aEg.gameSettings.keyBindJump.isKeyDown()) {
            aEg.gameSettings.keyBindJump.setPressed(false);
        }

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
        this.tU = 0.0;
        this.tY = 0;
    }
}
