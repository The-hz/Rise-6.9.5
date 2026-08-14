package com.alan.clients.module.impl.player.scaffold.tower;

import com.alan.clients.module.impl.player.Scaffold;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.value.Mode;
import hackclient.rise.aih;

public class VanillaTower extends Mode<Scaffold> {
    @EventLink
    public final Listener<PreMotionEvent> onPreMotionEvent = var0 -> {
        if (aEg.gameSettings.keyBindJump.isKeyDown() && aih.ay(1)) {
            aEg.thePlayer.motionY = 0.42F;
        }
    };

    public VanillaTower(String var1, Scaffold var2) {
        super(var1, var2);
    }
}
