package com.alan.clients.module.impl.movement.step;

import com.alan.clients.module.impl.movement.Step;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.other.StepEvent;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import hackclient.rise.ahj;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;

public class MatrixStep extends Mode<Step> {
    private final BooleanValue RR = new BooleanValue("2 Block", this, true);
    private final BooleanValue RS = new BooleanValue("Instant", this, true, this.RR::wo);
    private int ticks;
    private boolean doJump;
    @EventLink
    public final Listener<PreMotionEvent> RU = var1x -> {
        aEg.thePlayer.stepHeight = this.RR.wo() ? 2.0F : 1.0F;
        if (this.doJump) {
            if (this.ticks > 0 && aEg.thePlayer.onGround || this.ticks > 5) {
                this.ticks = 0;
                this.doJump = false;
                return;
            }

            if (this.ticks % 3 == 0) {
                var1x.setOnGround(true);
                aEg.thePlayer.jump();
            }

            this.ticks++;
        }
    };
    @EventLink
    public final Listener<StepEvent> RV = var1x -> {
        if (var1x.da() > 1.0) {
            if (this.RS.wo()) {
                ahj.l(new C04PacketPlayerPosition(aEg.thePlayer.posX, aEg.thePlayer.posY + 0.41999998688698, aEg.thePlayer.posZ, false));
                ahj.l(new C04PacketPlayerPosition(aEg.thePlayer.posX, aEg.thePlayer.posY + 0.7531999805212, aEg.thePlayer.posZ, false));
                ahj.l(new C04PacketPlayerPosition(aEg.thePlayer.posX, aEg.thePlayer.posY + 1.00133597911215, aEg.thePlayer.posZ, true));
                ahj.l(new C04PacketPlayerPosition(aEg.thePlayer.posX, aEg.thePlayer.posY + 1.42133596599913, aEg.thePlayer.posZ, false));
                ahj.l(new C04PacketPlayerPosition(aEg.thePlayer.posX, aEg.thePlayer.posY + 1.75453595963335, aEg.thePlayer.posZ, false));
                ahj.l(new C04PacketPlayerPosition(aEg.thePlayer.posX, aEg.thePlayer.posY + 2.0026719582243, aEg.thePlayer.posZ, false));
                aEg.timer.dzD = 0.14285715F;
            } else {
                this.doJump = true;
                this.ticks = 0;
                aEg.thePlayer.setPosition(aEg.thePlayer.posX, aEg.thePlayer.posY, aEg.thePlayer.posZ);
            }
        } else {
            if (var1x.da() > 0.6F) {
                aEg.timer.dzD = 0.33333F;
                ahj.l(new C04PacketPlayerPosition(aEg.thePlayer.posX, aEg.thePlayer.posY + 0.42F, aEg.thePlayer.posZ, false));
                ahj.l(new C04PacketPlayerPosition(aEg.thePlayer.posX, aEg.thePlayer.posY + 0.42F, aEg.thePlayer.posZ, true));
            }
        }
    };

    public MatrixStep(String var1, Step var2) {
        super(var1, var2);
    }

    @Override
    public void onDisable() {
        aEg.thePlayer.stepHeight = 0.6F;
    }
}
