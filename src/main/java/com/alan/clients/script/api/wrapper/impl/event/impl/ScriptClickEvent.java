package com.alan.clients.script.api.wrapper.impl.event.impl;

import com.alan.clients.newevent.impl.input.ClickEvent;
import com.alan.clients.script.api.wrapper.impl.event.ScriptEvent;

public class ScriptClickEvent extends ScriptEvent<ClickEvent> {
    public ScriptClickEvent(ClickEvent var1) {
        super(var1);
    }

    @Override
    public String getHandlerName() {
        return "onClick";
    }
}
