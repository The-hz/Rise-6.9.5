package com.alan.clients.script.api.wrapper.impl.event.impl;

import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.script.api.wrapper.impl.event.CancellableScriptEvent;

public class ScriptStrafeEvent extends CancellableScriptEvent<StrafeEvent> {
    public ScriptStrafeEvent(StrafeEvent var1) {
        super(var1);
    }

    public void setForward(float var1) {
        this.wrapped.setForward(var1);
    }

    public void setStrafe(float var1) {
        this.wrapped.setStrafe(var1);
    }

    public void setFriction(float var1) {
        this.wrapped.setFriction(var1);
    }

    public void setYaw(float var1) {
        this.wrapped.setYaw(var1);
    }

    public float getForward() {
        return this.wrapped.getForward();
    }

    public float getStrafe() {
        return this.wrapped.getStrafe();
    }

    public float getFriction() {
        return this.wrapped.getFriction();
    }

    public float getYaw() {
        return this.wrapped.getYaw();
    }

    public void setSpeed(double var1, double var3) {
        this.wrapped.setSpeed(var1, var3);
    }

    public void setSpeed(double var1) {
        this.wrapped.setSpeed(var1);
    }

    @Override
    public String getHandlerName() {
        return "onStrafe";
    }
}
