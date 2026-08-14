package com.alan.clients.script.api.wrapper.impl.event.impl;

import com.alan.clients.newevent.impl.motion.HitSlowDownEvent;
import com.alan.clients.script.api.wrapper.impl.event.ScriptEvent;

public class ScriptHitSlowDownEvent extends ScriptEvent<HitSlowDownEvent> {
    public ScriptHitSlowDownEvent(HitSlowDownEvent var1) {
        super(var1);
    }

    public void setSlowDown(double var1) {
        this.wrapped.setSlowDown(var1);
    }

    public void setSprint(boolean var1) {
        this.wrapped.setSprint(var1);
    }

    public double getSlowDown() {
        return this.wrapped.getSlowDown();
    }

    public boolean isSprint() {
        return this.wrapped.isSprint();
    }

    @Override
    public String getHandlerName() {
        return "onHitSlowDown";
    }
}
