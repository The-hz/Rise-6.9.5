package com.alan.clients.newevent.impl.render;

import com.alan.clients.newevent.CancellableEvent;
import lombok.Generated;

public final class HurtRenderEvent extends CancellableEvent {
    private boolean oldDamage;

    @Generated
    public boolean dw() {
        return this.oldDamage;
    }

    @Generated
    public void n(boolean var1) {
        this.oldDamage = var1;
    }

    @Generated
    public HurtRenderEvent(boolean var1) {
        this.oldDamage = var1;
    }
}
