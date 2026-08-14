package com.alan.clients.newevent.impl.motion;

import com.alan.clients.newevent.CancellableEvent;
import com.alan.clients.newevent.Event;
import com.alan.clients.script.api.wrapper.impl.event.ScriptEvent;
import com.alan.clients.script.api.wrapper.impl.event.impl.ScriptStrafeEvent;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.player.MoveUtil;
import lombok.Generated;

public final class StrafeEvent extends CancellableEvent implements InstanceAccess {
    private float jp;
    private float jq;
    private float jC;
    private float gZ;

    public void setSpeed(double var1, double var3) {
        this.setFriction((float)(this.getForward() != 0.0F && this.getStrafe() != 0.0F ? var1 * 0.98F : var1));
        aEg.thePlayer.motionX *= var3;
        aEg.thePlayer.motionZ *= var3;
    }

    public void setSpeed(double var1) {
        this.setFriction((float)(this.getForward() != 0.0F && this.getStrafe() != 0.0F ? var1 * 0.98F : var1));
        MoveUtil.stop();
    }

    @Override
    public ScriptEvent<? extends Event> getScriptEvent() {
        return new ScriptStrafeEvent(this);
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
    public float getFriction() {
        return this.jC;
    }

    @Generated
    public float getYaw() {
        return this.gZ;
    }

    @Generated
    public void setForward(float var1) {
        this.jp = var1;
    }

    @Generated
    public void setStrafe(float var1) {
        this.jq = var1;
    }

    @Generated
    public void setFriction(float var1) {
        this.jC = var1;
    }

    @Generated
    public void setYaw(float var1) {
        this.gZ = var1;
    }

    @Generated
    public StrafeEvent(float var1, float var2, float var3, float var4) {
        this.jp = var1;
        this.jq = var2;
        this.jC = var3;
        this.gZ = var4;
    }
}
