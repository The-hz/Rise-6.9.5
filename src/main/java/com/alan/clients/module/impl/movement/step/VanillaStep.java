package com.alan.clients.module.impl.movement.step;

import com.alan.clients.module.impl.movement.Step;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.other.StepEvent;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.NumberValue;
import hackclient.rise.aih;

public class VanillaStep extends Mode<Step> {
    private final NumberValue Sj = new NumberValue("Height", this, 1, 1, 10, 0.1);
    private final BooleanValue reverse = new BooleanValue("Reverse", this, false);
    private final NumberValue Sl = new NumberValue("Timer", this, 0.5, 0.1, 1, 0.1);
    @EventLink
    public final Listener<PreMotionEvent> Sm = var1x -> {
        aEg.thePlayer.stepHeight = this.Sj.wo().floatValue();
        if (this.reverse.wo() && aih.ad(this.Sj.wo().floatValue() + aEg.thePlayer.getEyeHeight()) && !aih.vj()) {
            if (aEg.thePlayer.posY < aEg.thePlayer.aI && !aEg.thePlayer.onGround && aEg.thePlayer.tR <= 1) {
                aEg.thePlayer.motionY = -this.Sj.wo().doubleValue();
            }

            if (aEg.thePlayer.tR == 1 && aEg.thePlayer.posY < aEg.thePlayer.cqY) {
                aEg.timer.dzD = this.Sl.wo().floatValue();
            }
        }
    };
    @EventLink
    public final Listener<StepEvent> Sn = var1x -> {
        if (var1x.da() > 0.6) {
            aEg.timer.dzD = this.Sl.wo().floatValue();
        }
    };

    public VanillaStep(String var1, Step var2) {
        super(var1, var2);
    }

    @Override
    public void onDisable() {
        aEg.thePlayer.stepHeight = 0.6F;
    }
}
