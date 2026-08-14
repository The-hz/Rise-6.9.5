package com.alan.clients.newevent.impl.other;

import com.alan.clients.newevent.CancellableEvent;
import com.alan.clients.script.api.wrapper.impl.event.ScriptEvent;
import com.alan.clients.script.api.wrapper.impl.event.impl.ScriptMoveEvent;
import lombok.Generated;

public final class MoveEvent extends CancellableEvent {
    private double gW;
    private double gX;
    private double gY;

    @Override
    public ScriptEvent<?> getScriptEvent() {
        return new ScriptMoveEvent(this);
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
    public MoveEvent(double var1, double var3, double var5) {
        this.gW = var1;
        this.gX = var3;
        this.gY = var5;
    }
}
