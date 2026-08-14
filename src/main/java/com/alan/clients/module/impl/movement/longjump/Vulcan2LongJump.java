package com.alan.clients.module.impl.movement.longjump;

import com.alan.clients.module.impl.movement.LongJump;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.value.Mode;

public final class Vulcan2LongJump extends Mode<LongJump> {
    private int hV;
    @EventLink
    public final Listener<PreMotionEvent> LG = var1x -> {
        this.hV++;
        if (this.hV == 1) {
            aEg.thePlayer.motionY = 0.0;
            aEg.thePlayer.onGround = true;
            aEg.thePlayer.setPosition(aEg.thePlayer.posX, aEg.thePlayer.posY + 9.9, aEg.thePlayer.posZ);
        }

        if (this.hV > 0 && this.hV <= 3) {
            aEg.thePlayer.motionY = 0.0;
            aEg.thePlayer.onGround = true;
        }

        if (this.hV > 3 && this.hV % 2 == 0 & !aEg.thePlayer.onGround) {
            aEg.thePlayer.motionY = -0.155;
        } else if (this.hV % 2 != 0 || aEg.thePlayer.onGround) {
            aEg.thePlayer.motionY = -0.098;
        }
    };

    public Vulcan2LongJump(String var1, LongJump var2) {
        super(var1, var2);
    }

    @Override
    public void onEnable() {
        this.hV = 0;
    }
}
