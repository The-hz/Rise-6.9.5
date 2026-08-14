package com.alan.clients.module.impl.movement.speed;

import com.alan.clients.module.impl.movement.Speed;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.MoveInputEvent;
import com.alan.clients.newevent.impl.motion.JumpEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;

public class OldNCPYPortSpeed extends Mode<Speed> {
    public final BooleanValue QA = new BooleanValue("Smooth Camera", this, false);
    private boolean Lw;
    private double Lx;
    private boolean HJ;
    private double QB;
    private int FX;
    private double QC;
    private final double QD = 0.2873;
    @EventLink
    public final Listener<PreMotionEvent> QE = var1x -> {
        double d0 = aEg.thePlayer.posX - aEg.thePlayer.lastTickPosX;
        double d1 = aEg.thePlayer.posZ - aEg.thePlayer.lastTickPosZ;
        this.QC = Math.sqrt(d0 * d0 + d1 * d1);
        if (this.FX == 3) {
            var1x.setPosY(var1x.getPosY() + 0.4);
        }
    };
    @EventLink
    public final Listener<MoveInputEvent> QF = var0 -> var0.setJump(false);
    @EventLink
    public final Listener<StrafeEvent> QG = var1x -> {
        MoveUtil.isMoving();
        switch (this.FX) {
            case 2:
                this.Lx *= 2.14;
                this.FX = 3;
                break;
            case 3:
                this.FX = 2;
                double d0 = 0.66 * (this.QC - 0.2873);
                this.Lx = this.QC - d0;
                break;
            default:
                if (aEg.theWorld.getCollidingBoundingBoxes(aEg.thePlayer, aEg.thePlayer.getEntityBoundingBox().offset(0.0, aEg.thePlayer.motionY, 0.0)).size()
                        > 0
                    || aEg.thePlayer.isCollidedVertically) {
                    this.FX = 1;
                }

                this.Lx = this.QC - this.QC / 159.0;
        }

        if (aEg.thePlayer.isCollidedHorizontally) {
            this.Lx = 0.2873;
        }

        if (aEg.thePlayer.tR == 1 && aEg.thePlayer.Zl > 2) {
            this.Lx = 0.3873;
        }

        if (!aEg.thePlayer.onGround) {
            this.FX++;
        }

        var1x.setSpeed(this.Lx);
        MoveUtil.preventDiagonalSpeed();
    };
    @EventLink
    public final Listener<MoveInputEvent> QH = var0 -> var0.setJump(false);
    @EventLink
    public final Listener<JumpEvent> QI = var0 -> var0.setJumpMotion(0.4F);

    public OldNCPYPortSpeed(String var1, Speed var2) {
        super(var1, var2);
    }

    @Override
    public void onDisable() {
        this.Lx = 0.0;
    }

    @Override
    public void onEnable() {
        this.FX = 2;
        this.Lx = 0.2873;
        this.QC = 0.0;
    }
}
