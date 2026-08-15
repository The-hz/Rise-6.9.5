package hackclient.rise.event;

import com.alan.clients.newevent.CancellableEvent;
import io.netty.buffer.ByteBuf;
import lombok.Generated;

public final class fj extends CancellableEvent {
    private ByteBuf jT;
    private int id;

    @Generated
    public ByteBuf ds() {
        return this.jT;
    }

    @Generated
    public int getId() {
        return this.id;
    }

    @Generated
    public void a(ByteBuf var1) {
        this.jT = var1;
    }

    @Generated
    public void k(int var1) {
        this.id = var1;
    }

    @Generated
    public fj(ByteBuf var1, int var2) {
        this.jT = var1;
        this.id = var2;
    }
}
