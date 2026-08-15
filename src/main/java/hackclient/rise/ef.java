package hackclient.rise;

import com.alan.clients.newevent.CancellableEvent;
import lombok.Generated;
import net.minecraft.util.Vec3;

public final class ef extends CancellableEvent {
    private Vec3 jw;

    @Generated
    public Vec3 cZ() {
        return this.jw;
    }

    @Generated
    public void b(Vec3 vec) {
        this.jw = vec;
    }

    @Generated
    public ef(Vec3 vec) {
        this.jw = vec;
    }
}
