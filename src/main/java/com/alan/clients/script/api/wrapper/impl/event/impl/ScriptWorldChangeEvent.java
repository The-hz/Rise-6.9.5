package com.alan.clients.script.api.wrapper.impl.event.impl;

import com.alan.clients.newevent.impl.other.WorldChangeEvent;
import com.alan.clients.script.api.wrapper.impl.event.ScriptEvent;

public class ScriptWorldChangeEvent extends ScriptEvent<WorldChangeEvent> {
    public ScriptWorldChangeEvent(WorldChangeEvent var1) {
        super(var1);
    }

    @Override
    public String getHandlerName() {
        return "onWorldChange";
    }
}
