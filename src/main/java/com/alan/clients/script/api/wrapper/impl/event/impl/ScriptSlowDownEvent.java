package com.alan.clients.script.api.wrapper.impl.event.impl;

import com.alan.clients.newevent.impl.motion.SlowDownEvent;
import com.alan.clients.script.api.wrapper.impl.event.CancellableScriptEvent;

public class ScriptSlowDownEvent extends CancellableScriptEvent<SlowDownEvent> {
    public ScriptSlowDownEvent(SlowDownEvent var1) {
        super(var1);
    }

    public void setStrafeMultiplier(float var1) {
        this.wrapped.setStrafeMultiplier(var1);
    }

    public void setForwardMultiplier(float var1) {
        this.wrapped.setStrafeMultiplier(var1);
    }

    public float getStrafeMultiplier() {
        return this.wrapped.getStrafeMultiplier();
    }

    public float getForwardMultiplier() {
        return this.wrapped.getForwardMultiplier();
    }

    @Override
    public String getHandlerName() {
        return "onSlowDown";
    }
}
