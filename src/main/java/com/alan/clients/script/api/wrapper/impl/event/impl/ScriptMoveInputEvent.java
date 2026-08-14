package com.alan.clients.script.api.wrapper.impl.event.impl;

import com.alan.clients.newevent.impl.input.MoveInputEvent;
import com.alan.clients.script.api.wrapper.impl.event.ScriptEvent;

public class ScriptMoveInputEvent extends ScriptEvent<MoveInputEvent> {
    public ScriptMoveInputEvent(MoveInputEvent var1) {
        super(var1);
    }

    public void setForward(float var1) {
        this.wrapped.setForward(var1);
    }

    public void setStrafe(float var1) {
        this.wrapped.setStrafe(var1);
    }

    public void setJump(boolean var1) {
        this.wrapped.setJump(var1);
    }

    public void setSneak(boolean var1) {
        this.wrapped.setSneak(var1);
    }

    public void setSneakSlowDownMultiplier(double var1) {
        this.wrapped.setSneakSlowDownMultiplier(var1);
    }

    public float getForward() {
        return this.wrapped.getForward();
    }

    public float getStrafe() {
        return this.wrapped.getStrafe();
    }

    public boolean isJump() {
        return this.wrapped.isJump();
    }

    public boolean isSneak() {
        return this.wrapped.isSneak();
    }

    public double getSneakSlowDownMultiplier() {
        return this.wrapped.getSneakSlowDownMultiplier();
    }

    @Override
    public String getHandlerName() {
        return "onMoveInput";
    }
}
