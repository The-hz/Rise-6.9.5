package com.alan.clients.newevent.impl.motion;

import com.alan.clients.newevent.CancellableEvent;
import lombok.Generated;

public class MinimumMotionEvent extends CancellableEvent {
    private double minimumMotion;

    @Generated
    public double cY() {
        return this.minimumMotion;
    }

    @Generated
    public void g(double var1) {
        this.minimumMotion = var1;
    }

    @Generated
    public MinimumMotionEvent(double var1) {
        this.minimumMotion = var1;
    }
}
