package com.alan.clients.module.impl.player.nofall;

import com.alan.clients.module.impl.player.NoFall;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.value.Mode;
import hackclient.rise.bd;

public class VulcanNoFall extends Mode<NoFall> {
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var0 -> {
        if (bd.cY > 3.0F) {
            var0.setOnGround(true);
            aEg.thePlayer.onGround = true;
            aEg.thePlayer.motionY = -0.09800000190735147;
            bd.cY = 0.0F;
        }
    };

    public VulcanNoFall(String var1, NoFall var2) {
        super(var1, var2);
    }
}
