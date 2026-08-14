package com.alan.clients.script.api.wrapper.impl.event.impl;

import com.alan.clients.newevent.impl.other.TickEvent;
import com.alan.clients.script.api.wrapper.impl.event.ScriptEvent;

public class ScriptTickEvent extends ScriptEvent<TickEvent> {
    public ScriptTickEvent(TickEvent var1) {
        super(var1);
    }

    @Override
    public String getHandlerName() {
        return "onTick";
    }
}
