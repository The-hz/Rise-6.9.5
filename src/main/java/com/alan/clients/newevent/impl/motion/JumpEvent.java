package com.alan.clients.newevent.impl.motion;

import com.alan.clients.newevent.CancellableEvent;
import com.alan.clients.newevent.Event;
import com.alan.clients.script.api.wrapper.impl.event.ScriptEvent;
import com.alan.clients.script.api.wrapper.impl.event.impl.ScriptJumpEvent;
import lombok.Generated;

public class JumpEvent extends CancellableEvent {
    private float ju;
    private float gZ;

    @Override
    public ScriptEvent<? extends Event> getScriptEvent() {
        return new ScriptJumpEvent(this);
    }

    @Generated
    public float getJumpMotion() {
        return this.ju;
    }

    @Generated
    public float getYaw() {
        return this.gZ;
    }

    @Generated
    public void setJumpMotion(float jumpMotion) {
        this.ju = jumpMotion;
    }

    @Generated
    public void setYaw(float var1) {
        this.gZ = var1;
    }

    @Generated
    public JumpEvent(float var1, float var2) {
        this.ju = var1;
        this.gZ = var2;
    }
}
