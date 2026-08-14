package hackclient.rise;

import com.alan.clients.component.impl.player.BlinkComponent;

public final class bn {
    private final long eh = BlinkComponent.dU.getAndIncrement();
    private final bp ei;
    public boolean dj = true;

    bn(bp var1) {
        this.ei = var1;
    }

    boolean a(long var1, long var3) {
        return var1 + this.ei.dQ < var3;
    }

    boolean bd() {
        return this.dj && this.ei.ek == this;
    }

    @Override
    public boolean equals(Object var1) {
        return var1 instanceof bn && ((bn)var1).eh == this.eh;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(this.eh);
    }
}
