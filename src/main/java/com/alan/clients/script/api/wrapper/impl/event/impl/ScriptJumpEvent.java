package com.alan.clients.script.api.wrapper.impl.event.impl;

import com.alan.clients.newevent.impl.motion.JumpEvent;
import com.alan.clients.script.api.wrapper.impl.event.CancellableScriptEvent;

public class ScriptJumpEvent extends CancellableScriptEvent<JumpEvent> {
    public ScriptJumpEvent(JumpEvent var1) {
        super(var1);
    }

    public void setJumpMotion(float var1) {
        this.wrapped.setJumpMotion(var1);
    }

    public void setYaw(float var1) {
        this.wrapped.setYaw(var1);
    }

    public float getJumpMotion() {
        return this.wrapped.getJumpMotion();
    }

    public float getYaw() {
        return this.wrapped.getYaw();
    }

    @Override
    public String getHandlerName() {
        return "onJump";
    }
}
