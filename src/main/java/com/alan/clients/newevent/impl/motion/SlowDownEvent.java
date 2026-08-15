package com.alan.clients.newevent.impl.motion;

import com.alan.clients.newevent.CancellableEvent;
import com.alan.clients.newevent.Event;
import com.alan.clients.script.api.wrapper.impl.event.ScriptEvent;
import com.alan.clients.script.api.wrapper.impl.event.impl.ScriptSlowDownEvent;
import lombok.Generated;

public class SlowDownEvent extends CancellableEvent {
    private float jz;
    private float jA;
    private boolean jB;

    @Override
    public ScriptEvent<? extends Event> getScriptEvent() {
        return new ScriptSlowDownEvent(this);
    }

    @Generated
    public float getStrafeMultiplier() {
        return this.jz;
    }

    @Generated
    public float getForwardMultiplier() {
        return this.jA;
    }

    @Generated
    public boolean db() {
        return this.jB;
    }

    @Generated
    public void setStrafeMultiplier(float strafeMultiplier) {
        this.jz = strafeMultiplier;
    }

    @Generated
    public void setForwardMultiplier(float forwardMultiplier) {
        this.jA = forwardMultiplier;
    }

    @Generated
    public void k(boolean var1) {
        this.jB = var1;
    }

    @Generated
    public SlowDownEvent(float var1, float var2, boolean var3) {
        this.jz = var1;
        this.jA = var2;
        this.jB = var3;
    }
}
