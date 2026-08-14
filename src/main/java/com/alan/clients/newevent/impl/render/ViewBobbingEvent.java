package com.alan.clients.newevent.impl.render;

import com.alan.clients.newevent.CancellableEvent;
import lombok.Generated;

public final class ViewBobbingEvent extends CancellableEvent {
    private int time;

    @Generated
    public int dL() {
        return this.time;
    }

    @Generated
    public void n(int var1) {
        this.time = var1;
    }

    @Generated
    public ViewBobbingEvent(int var1) {
        this.time = var1;
    }
}
