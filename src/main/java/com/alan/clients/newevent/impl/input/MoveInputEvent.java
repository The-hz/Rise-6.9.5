package com.alan.clients.newevent.impl.input;

import com.alan.clients.newevent.Event;
import com.alan.clients.script.api.wrapper.impl.event.ScriptEvent;
import com.alan.clients.script.api.wrapper.impl.event.impl.ScriptMoveInputEvent;
import lombok.Generated;

public class MoveInputEvent implements Event {
    private float jp;
    private float jq;
    private boolean gD;
    private boolean jr;
    private double sneakSlowDownMultiplier;

    @Override
    public ScriptEvent<? extends Event> getScriptEvent() {
        return new ScriptMoveInputEvent(this);
    }

    @Generated
    public float getForward() {
        return this.jp;
    }

    @Generated
    public float getStrafe() {
        return this.jq;
    }

    @Generated
    public boolean isJump() {
        return this.gD;
    }

    @Generated
    public boolean isSneak() {
        return this.jr;
    }

    @Generated
    public double getSneakSlowDownMultiplier() {
        return this.sneakSlowDownMultiplier;
    }

    @Generated
    public void setForward(float forward) {
        this.jp = forward;
    }

    @Generated
    public void setStrafe(float strafe) {
        this.jq = strafe;
    }

    @Generated
    public void setJump(boolean jump) {
        this.gD = jump;
    }

    @Generated
    public void setSneak(boolean sneak) {
        this.jr = sneak;
    }

    @Generated
    public void setSneakSlowDownMultiplier(double var1) {
        this.sneakSlowDownMultiplier = var1;
    }

    @Generated
    public MoveInputEvent(float var1, float var2, boolean var3, boolean var4, double var5) {
        this.jp = var1;
        this.jq = var2;
        this.gD = var3;
        this.jr = var4;
        this.sneakSlowDownMultiplier = var5;
    }
}
