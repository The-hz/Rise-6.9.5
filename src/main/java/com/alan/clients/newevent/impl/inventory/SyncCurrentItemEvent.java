package com.alan.clients.newevent.impl.inventory;

import com.alan.clients.newevent.Event;
import lombok.Generated;

public class SyncCurrentItemEvent implements Event {
    private int slot;

    @Generated
    public int cX() {
        return this.slot;
    }

    @Generated
    public void setSlot(int var1) {
        this.slot = var1;
    }

    @Generated
    public SyncCurrentItemEvent(int var1) {
        this.slot = var1;
    }
}
