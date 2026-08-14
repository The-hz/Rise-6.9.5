package hackclient.rise;

import net.minecraft.network.Packet;

public class ahk {
    private final Packet<?> aNo;
    private final long aNp;

    public ahk(Packet<?> var1, long var2) {
        this.aNo = var1;
        this.aNp = var2;
    }

    public ahk(Packet<?> var1) {
        this.aNo = var1;
        this.aNp = System.currentTimeMillis();
    }

    public Packet<?> dq() {
        return this.aNo;
    }

    public long getTime() {
        return this.aNp;
    }
}
