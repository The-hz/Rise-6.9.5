package com.alan.clients.newevent.impl.motion;

import com.alan.clients.newevent.CancellableEvent;
import com.alan.clients.newevent.Event;
import com.alan.clients.script.api.wrapper.impl.event.ScriptEvent;
import com.alan.clients.script.api.wrapper.impl.event.impl.ScriptPreMotionEvent;
import lombok.Generated;

public final class PreMotionEvent extends CancellableEvent {
    private double gW;
    private double gX;
    private double gY;
    private float gZ;
    private float ha;
    private boolean aO;
    private boolean jx;

    @Override
    public ScriptEvent<? extends Event> getScriptEvent() {
        return new ScriptPreMotionEvent(this);
    }

    @Generated
    public double getPosX() {
        return this.gW;
    }

    @Generated
    public double getPosY() {
        return this.gX;
    }

    @Generated
    public double getPosZ() {
        return this.gY;
    }

    @Generated
    public float getYaw() {
        return this.gZ;
    }

    @Generated
    public float getPitch() {
        return this.ha;
    }

    @Generated
    public boolean isOnGround() {
        return this.aO;
    }

    @Generated
    public boolean isSprinting() {
        return this.jx;
    }

    @Generated
    public void setPosX(double var1) {
        this.gW = var1;
    }

    @Generated
    public void setPosY(double var1) {
        this.gX = var1;
    }

    @Generated
    public void setPosZ(double var1) {
        this.gY = var1;
    }

    @Generated
    public void setYaw(float var1) {
        this.gZ = var1;
    }

    @Generated
    public void setPitch(float var1) {
        this.ha = var1;
    }

    @Generated
    public void setOnGround(boolean var1) {
        this.aO = var1;
    }

    @Generated
    public void setSprinting(boolean var1) {
        this.jx = var1;
    }

    @Generated
    public PreMotionEvent(double var1, double var3, double var5, float var7, float var8, boolean var9, boolean var10) {
        this.gW = var1;
        this.gX = var3;
        this.gY = var5;
        this.gZ = var7;
        this.ha = var8;
        this.aO = var9;
        this.jx = var10;
    }
}
