package com.alan.clients.script.api.wrapper.impl.event.impl;

import com.alan.clients.newevent.impl.other.GameEvent;
import com.alan.clients.script.api.wrapper.impl.event.ScriptEvent;

public class ScriptGameEvent extends ScriptEvent<GameEvent> {
    public ScriptGameEvent(GameEvent var1) {
        super(var1);
    }

    @Override
    public String getHandlerName() {
        return "onGame";
    }
}
