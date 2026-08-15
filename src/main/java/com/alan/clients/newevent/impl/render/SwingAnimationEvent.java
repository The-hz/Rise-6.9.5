package com.alan.clients.newevent.impl.render;

import com.alan.clients.newevent.CancellableEvent;
import lombok.Generated;

public final class SwingAnimationEvent extends CancellableEvent {
    private int animationEnd;

    @Generated
    public int dK() {
        return this.animationEnd;
    }

    @Generated
    public void setAnimationEnd(int var1) {
        this.animationEnd = var1;
    }

    @Generated
    public SwingAnimationEvent(int var1) {
        this.animationEnd = var1;
    }
}
