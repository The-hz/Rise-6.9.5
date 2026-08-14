package com.alan.clients.newevent.impl.motion;

import com.alan.clients.newevent.CancellableEvent;
import com.alan.clients.newevent.Event;
import com.alan.clients.script.api.wrapper.impl.event.ScriptEvent;
import com.alan.clients.script.api.wrapper.impl.event.impl.ScriptHitSlowDownEvent;
import lombok.Generated;

public final class HitSlowDownEvent extends CancellableEvent {
    public double slowDown;
    public boolean sprint;

    @Override
    public ScriptEvent<? extends Event> getScriptEvent() {
        return new ScriptHitSlowDownEvent(this);
    }

    @Generated
    public double getSlowDown() {
        return this.slowDown;
    }

    @Generated
    public boolean isSprint() {
        return this.sprint;
    }

    @Generated
    public void setSlowDown(double var1) {
        this.slowDown = var1;
    }

    @Generated
    public void setSprint(boolean var1) {
        this.sprint = var1;
    }

    @Generated
    public HitSlowDownEvent(double var1, boolean var3) {
        this.slowDown = var1;
        this.sprint = var3;
    }
}
