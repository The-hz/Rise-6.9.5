package com.alan.clients.module.impl.render.esp;

import com.alan.clients.module.impl.render.ESP;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.value.Mode;
import hackclient.rise.cf;
import hackclient.rise.cn;
import hackclient.rise.cs;
import java.awt.Color;

public class SkeletalESP extends Mode<ESP> {
    @EventLink
    public final Listener<PreUpdateEvent> asi = var1x -> {
        Color color = this.rz().rA();
        cf.a(new cs(new cn(color, color, color)));
    };

    public SkeletalESP(String var1, ESP var2) {
        super(var1, var2);
    }
}
