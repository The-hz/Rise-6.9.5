package com.alan.clients.module.impl.player.scaffold.downwards;

import com.alan.clients.module.impl.player.Scaffold;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.value.Mode;
import org.lwjgl.input.Keyboard;

public class NormalDownwards extends Mode<Scaffold> {
    @EventLink(cH = 1)
    public final Listener<PreUpdateEvent> ajb = var1x -> {
        if (Keyboard.isKeyDown(aEg.gameSettings.keyBindSneak.getKeyCode())) {
            this.wj().agy = this.wj().agy.v(0.0, -1.0, 0.0);
        }
    };

    public NormalDownwards(String var1, Scaffold var2) {
        super(var1, var2);
    }
}
