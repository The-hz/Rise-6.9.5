package com.alan.clients.newevent.impl.other;

import com.alan.clients.newevent.Event;
import lombok.Generated;

public final class StepEvent implements Event {
    private double height;

    @Generated
    public double da() {
        return this.height;
    }

    @Generated
    public StepEvent(double var1) {
        this.height = var1;
    }
}
