package com.alan.clients.module.impl.movement.step;

import com.alan.clients.module.impl.movement.Step;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.other.StepEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.NumberValue;
import hackclient.rise.ahj;
import hackclient.rise.aih;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;

public class NewNCPStep extends Mode<Step> {
    private final NumberValue Sd = new NumberValue("Height", this, 1, 1, 1.5, 0.1);
    private final NumberValue Se = new NumberValue("Timer", this, 0.5, 0.1, 1, 0.1);
    private double Sf;
    @EventLink
    public final Listener<PreMotionEvent> Sg = var1x -> {
        if (aEg.thePlayer.onGround && !aih.vj()) {
            aEg.thePlayer.stepHeight = this.Sd.wo().floatValue();
        } else {
            aEg.thePlayer.stepHeight = 0.6F;
        }
    };
    @EventLink
    public final Listener<StepEvent> Sh = var1x -> {
        if (aEg.thePlayer.onGround && !aih.vj()) {
            double d0 = var1x.da();
            this.Sf = d0;
            if (!(d0 <= 0.6F)) {
                double[] adouble;
                if (d0 > 1.015) {
                    adouble = new double[]{0.42F, 0.7532F, 1.0, 0.98F};
                } else if (d0 > 0.875) {
                    adouble = new double[]{0.42F, 0.7532F, 1.0};
                } else {
                    adouble = new double[]{0.39F, 0.6938F};
                }

                aEg.timer.dzD = this.Se.wo().floatValue();

                for (double d1 : adouble) {
                    ahj.m(new C04PacketPlayerPosition(aEg.thePlayer.posX, aEg.thePlayer.posY + d1, aEg.thePlayer.posZ, false));
                }
            }
        }
    };
    @EventLink
    private final Listener<PacketSendEvent> Si = var1x -> {
        double[] adouble;
        if (this.Sf > 1.015) {
            adouble = new double[]{0.42F, 0.7532F, 1.0, 0.98F};
        } else if (this.Sf > 0.875) {
            adouble = new double[]{0.42F, 0.7532F, 1.0};
        } else {
            adouble = new double[]{0.39F, 0.6938F};
        }

        if (var1x.dq() instanceof C04PacketPlayerPosition && aih.vg()) {
            for (double d0 : adouble) {
                ;
            }
        }
    };

    public NewNCPStep(String var1, Step var2) {
        super(var1, var2);
    }

    @Override
    public void onDisable() {
        aEg.thePlayer.stepHeight = 0.6F;
    }
}
