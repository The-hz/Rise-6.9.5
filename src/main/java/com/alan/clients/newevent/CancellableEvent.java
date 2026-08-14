package com.alan.clients.newevent;

public class CancellableEvent implements Event {
    private boolean cancelled;

    public CancellableEvent() {
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean var1) {
        this.cancelled = var1;
    }

    public void setCancelled() {
        this.cancelled = true;
    }
}
