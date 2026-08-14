package com.alan.clients.module.impl.ghost.autoclicker;

import com.alan.clients.module.impl.ghost.AutoClicker;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.other.AttackEvent;
import com.alan.clients.newevent.impl.other.TickEvent;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.BoundsNumberValue;
import hackclient.rise.aih;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import rip.vantage.commons.util.time.a;

public class NormalAutoClicker extends Mode<AutoClicker> {
    private final BoundsNumberValue cps = new BoundsNumberValue("CPS", this, 8, 14, 1, 20, 0.1);
    private final BooleanValue Cl = new BooleanValue("Right Click", this, false);
    private final BooleanValue Cm = new BooleanValue("Left Click", this, true);
    private final BooleanValue Cn = new BooleanValue("Hit Select", this, false);
    private final BooleanValue Co = new BooleanValue("Break Blocks", this, true);
    private final BooleanValue Cp = new BooleanValue("ButterFly", this, true);
    private final a Cq = new a();
    private int Cr;
    private int BV;
    private long nT;
    @EventLink
    public final Listener<TickEvent> Cs = var1x -> {
        this.BV++;
        if (this.Cq.T(this.nT) && (!this.Cn.wo() || this.BV >= 10 || aEg.thePlayer.hurtTime > 0 && this.Cq.T(this.nT)) && aEg.currentScreen == null) {
            long i = (long)(this.cps.wv().longValue() * 1.5);
            if (aEg.gameSettings.cgK.isKeyDown()) {
                this.Cr++;
            } else {
                this.Cr = 0;
            }

            if (this.nT >= 100L && this.Cp.wo()) {
                this.nT = (long)(Math.random() * 100.0);
            } else {
                this.nT = 1000L / i;
            }

            if (this.Cl.wo() && aEg.gameSettings.cgI.isKeyDown() && !aEg.gameSettings.cgK.isKeyDown()) {
                aih.h(1, true);
                if (Math.random() > 0.9) {
                    aih.h(1, true);
                }
            }

            if (!this.Cm.wo()
                || this.Cr <= 1
                || aEg.gameSettings.cgI.isKeyDown()
                || this.Co.wo() && aEg.objectMouseOver != null && aEg.objectMouseOver.typeOfHit == MovingObjectType.BLOCK) {
                if (!this.Co.wo()) {
                    aEg.playerController.curBlockDamageMP = 0.0F;
                }
            } else {
                aih.h(0, true);
            }

            this.Cq.aX();
        }
    };
    @EventLink
    public final Listener<AttackEvent> Ct = var1x -> this.BV = 0;

    public NormalAutoClicker(String var1, AutoClicker var2) {
        super(var1, var2);
    }
}
