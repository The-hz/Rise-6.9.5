package com.alan.clients.module.impl.render.esp;

import com.alan.clients.module.impl.render.ESP;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.value.Mode;
import com.alan.clients.component.impl.render.ESPComponent;
import com.alan.clients.component.impl.render.espcomponent.api.ESPColor;
import hackclient.rise.component.esp.cs;
import java.awt.Color;

public class SkeletalESP extends Mode<ESP> {
    @EventLink
    public final Listener<PreUpdateEvent> onPreUpdate = var1x -> {
        Color color = this.rz().rA();
        ESPComponent.a(new cs(new ESPColor(color, color, color)));
    };

    public SkeletalESP(String var1, ESP var2) {
        super(var1, var2);
    }
}
