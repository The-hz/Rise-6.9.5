package com.alan.clients.module.impl.movement.step;

import com.alan.clients.module.impl.movement.Step;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import net.minecraft.potion.Potion;

public class NCPPacketlessStep extends Mode<Step> {
    private boolean RW;
    @EventLink
    public final Listener<PreMotionEvent> RX = var1x -> {
        if (aEg.thePlayer.onGround && aEg.thePlayer.isCollidedHorizontally && !aEg.thePlayer.isPotionActive(Potion.jump)) {
            aEg.thePlayer.jump();
            MoveUtil.stop();
            this.RW = true;
        }

        if (aEg.thePlayer.tR == 3 && this.RW) {
            aEg.thePlayer.motionY = MoveUtil.predictedMotion(aEg.thePlayer.motionY, 2);
            MoveUtil.strafe(MoveUtil.getAllowedHorizontalDistance() * 0.6 - Math.random() / 100.0 - 0.05);
            this.RW = false;
        }
    };

    public NCPPacketlessStep(String var1, Step var2) {
        super(var1, var2);
    }

    @Override
    public void onDisable() {
        aEg.thePlayer.stepHeight = 0.6F;
    }
}
