package com.alan.clients.script.api.wrapper.impl.event.impl;

import com.alan.clients.newevent.impl.other.ModuleToggleEvent;
import com.alan.clients.script.api.wrapper.impl.ScriptModule;
import com.alan.clients.script.api.wrapper.impl.event.ScriptEvent;

public class ScriptModuleToggleEvent extends ScriptEvent<ModuleToggleEvent> {
    public ScriptModuleToggleEvent(ModuleToggleEvent var1) {
        super(var1);
    }

    public ScriptModule getModule() {
        return new ScriptModule(this.wrapped.dl());
    }

    @Override
    public String getHandlerName() {
        return "onModuleToggle";
    }
}
