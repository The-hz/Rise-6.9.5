package com.alan.clients.module.impl.combat.criticals;

import com.alan.clients.module.impl.combat.Criticals;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.value.Mode;
import hackclient.rise.bd;

public final class VulcanCriticals extends Mode<Criticals> {
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var0 -> {
        if (aEg.thePlayer.ae <= 18 && bd.cY < 1.8) {
            var0.setOnGround(false);
        }
    };

    public VulcanCriticals(String var1, Criticals var2) {
        super(var1, var2);
    }
}
