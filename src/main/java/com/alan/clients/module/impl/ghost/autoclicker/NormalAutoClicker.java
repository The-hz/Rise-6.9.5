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
    private final BooleanValue rightClick = new BooleanValue("Right Click", this, false);
    private final BooleanValue leftClick = new BooleanValue("Left Click", this, true);
    private final BooleanValue hitSelect = new BooleanValue("Hit Select", this, false);
    private final BooleanValue breakBlocks = new BooleanValue("Break Blocks", this, true);
    private final BooleanValue butterFly = new BooleanValue("ButterFly", this, true);
    private final a Cq = new a();
    private int Cr;
    private int BV;
    private long nextSwing;
    @EventLink
    public final Listener<TickEvent> onTick = var1x -> {
        this.BV++;
        if (this.Cq.T(this.nextSwing) && (!this.hitSelect.wo() || this.BV >= 10 || aEg.thePlayer.hurtTime > 0 && this.Cq.T(this.nextSwing)) && aEg.currentScreen == null) {
            long i = (long)(this.cps.wv().longValue() * 1.5);
            if (aEg.gameSettings.cgK.isKeyDown()) {
                this.Cr++;
            } else {
                this.Cr = 0;
            }

            if (this.nextSwing >= 100L && this.butterFly.wo()) {
                this.nextSwing = (long)(Math.random() * 100.0);
            } else {
                this.nextSwing = 1000L / i;
            }

            if (this.rightClick.wo() && aEg.gameSettings.cgI.isKeyDown() && !aEg.gameSettings.cgK.isKeyDown()) {
                aih.h(1, true);
                if (Math.random() > 0.9) {
                    aih.h(1, true);
                }
            }

            if (!this.leftClick.wo()
                || this.Cr <= 1
                || aEg.gameSettings.cgI.isKeyDown()
                || this.breakBlocks.wo() && aEg.objectMouseOver != null && aEg.objectMouseOver.typeOfHit == MovingObjectType.BLOCK) {
                if (!this.breakBlocks.wo()) {
                    aEg.playerController.curBlockDamageMP = 0.0F;
                }
            } else {
                aih.h(0, true);
            }

            this.Cq.aX();
        }
    };
    @EventLink
    public final Listener<AttackEvent> onAttack = var1x -> this.BV = 0;

    public NormalAutoClicker(String var1, AutoClicker var2) {
        super(var1, var2);
    }
}
