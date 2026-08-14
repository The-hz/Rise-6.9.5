package com.alan.clients.module.impl.combat.criticals;

import com.alan.clients.module.impl.combat.Criticals;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.JumpEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.other.AttackEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.NumberValue;
import rip.vantage.commons.util.time.a;

public final class WatchdogCriticals extends Mode<Criticals> {
    private final NumberValue rT = new NumberValue("Delay", this, 500, 0, 1000, 50);
    private final double[] rU = new double[]{1.0E-6, MoveUtil.predictedMotion(0.03125, 1)};
    private final a rV = new a();
    public static boolean gD;
    public static boolean pw;
    private int hV;
    private int rW;
    private int rX;
    @EventLink
    public final Listener<StrafeEvent> rY = var0 -> {};
    @EventLink
    public final Listener<PreMotionEvent> rZ = var1x -> {
        if (aEg.thePlayer.onGround && pw) {
            aEg.thePlayer.crd = true;
            aEg.thePlayer.stepHeight = 0.1F;
            this.hV++;
            this.rW = 0;
            if (this.hV > 2) {
                this.rW++;
            }

            switch (this.hV) {
                case 1:
                    var1x.setPosY(var1x.getPosY() + 0.001);
                    break;
                case 2:
                    pw = false;
            }

            var1x.setOnGround(false);
            if (this.hV > 4) {
                aEg.thePlayer.stepHeight = 0.6F;
            }

            if (aEg.thePlayer.onGround && this.hV < 6) {
                aEg.thePlayer.crd = true;
            }

            if (this.hV > 6) {
                aEg.thePlayer.crd = false;
            }
        } else {
            this.rW++;
            if (aEg.thePlayer.csk > 4 || this.rW > 4) {
                aEg.thePlayer.stepHeight = 0.6F;
            }

            if (this.rW < 5 && aEg.thePlayer.onGround && this.hV < 6) {
                aEg.thePlayer.crd = true;
            } else {
                aEg.thePlayer.crd = false;
            }

            pw = false;
            this.hV = 0;
        }
    };
    @EventLink
    public final Listener<AttackEvent> sa = var1x -> {
        if (aEg.thePlayer.onGround && !aEg.thePlayer.isOnLadder() && this.rV.T(this.rT.wo().longValue())) {
            aEg.thePlayer.onCriticalHit(var1x.dc());
            this.rV.aX();
            pw = true;
        }
    };
    @EventLink(cH = 4)
    public final Listener<JumpEvent> sb = var1x -> {
        if (this.hV <= 4 && this.rW <= 4 && aEg.thePlayer.cqL > 2) {
            var1x.setCancelled();
        }
    };

    public WatchdogCriticals(String var1, Criticals var2) {
        super(var1, var2);
    }
}
