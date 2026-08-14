package com.alan.clients.module.impl.player.scaffold.tower;

import com.alan.clients.module.impl.player.Scaffold;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.value.Mode;
import hackclient.rise.aih;

public class AirJumpTower extends Mode<Scaffold> {
    @EventLink
    public final Listener<PreMotionEvent> onPreMotionEvent = var0 -> {
        if (aEg.gameSettings.keyBindJump.isKeyDown() && aEg.thePlayer.ticksExisted % 2 == 0 && aih.ay(2)) {
            aEg.thePlayer.motionY = 0.42F;
            var0.setOnGround(true);
        }
    };

    public AirJumpTower(String var1, Scaffold var2) {
        super(var1, var2);
    }
}
