package com.alan.clients.module.impl.movement.flight;

import com.alan.clients.module.impl.movement.Flight;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.other.MoveEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.NumberValue;

public final class SkyCaveFlight extends Mode<Flight> {
    private final NumberValue speed = new NumberValue("Speed", this, 1.2, 0.8, 10, 0.05);
    private final NumberValue damageSpeed = new NumberValue("Damage Speed", this, 5, 0.8, 10, 0.05);
    private double xv;
    private int FX;
    @EventLink(value = 4)
    private final Listener<MoveEvent> onMove = var1x -> {
        if (!MoveUtil.isMoving() || aEg.thePlayer.isCollidedHorizontally) {
            this.FX = -1;
        }

        if (aEg.thePlayer.ae == 1) {
            this.xv = this.damageSpeed.wo().doubleValue();
        }

        switch (this.FX) {
            case -1:
                aEg.thePlayer.motionY = 0.0;
                var1x.setPosY(-1.0E-5);
                break;
            case 0:
                this.xv = 0.3;
                break;
            case 1:
                if (aEg.thePlayer.onGround) {
                    var1x.setPosY(aEg.thePlayer.motionY = 0.3999);
                    this.xv *= 2.14;
                }
                break;
            case 2:
                this.xv = this.speed.wo().doubleValue();
                break;
            default:
                this.xv = this.xv - this.xv / 109.0;
                aEg.thePlayer.motionY = 0.0;
                var1x.setPosY(-1.0E-5);
        }

        if (aEg.thePlayer.ticksExisted % 20 == 0) {
            var1x.setPosY(-0.035);
        }

        if (this.FX != -1) {
            aEg.thePlayer.jumpMovementFactor = 0.0F;
            MoveUtil.setMoveEvent(var1x, Math.max(this.xv, MoveUtil.getAllowedHorizontalDistance()));
            this.FX++;
        }
    };

    public SkyCaveFlight(String var1, Flight var2) {
        super(var1, var2);
    }

    @Override
    public void onEnable() {
        this.xv = 0.0;
        this.FX = aEg.thePlayer.onGround ? 0 : -1;
    }
}
