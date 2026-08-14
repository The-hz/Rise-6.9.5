package com.alan.clients.module.impl.movement.step;

import com.alan.clients.module.impl.movement.Step;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.other.StepEvent;
import com.alan.clients.value.Mode;
import hackclient.rise.ahj;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;

public class VulcanStep extends Mode<Step> {
    @EventLink
    public final Listener<PreMotionEvent> So = var0 -> {
        if (aEg.thePlayer.cuz > 11) {
            aEg.thePlayer.stepHeight = 1.0F;
        } else {
            aEg.thePlayer.stepHeight = 0.6F;
        }
    };
    @EventLink
    public final Listener<StepEvent> Sp = var0 -> {
        if (var0.da() > 0.6) {
            aEg.timer.dzD = 0.5F;
            ahj.l(new C04PacketPlayerPosition(aEg.thePlayer.posX, aEg.thePlayer.posY + 0.5, aEg.thePlayer.posZ, true));
        }
    };

    public VulcanStep(String var1, Step var2) {
        super(var1, var2);
    }

    @Override
    public void onDisable() {
        aEg.thePlayer.stepHeight = 0.6F;
    }
}
