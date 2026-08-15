package hackclient.rise;

import net.minecraft.network.Packet;

public class ahk {
    private final Packet<?> packet;
    private final long time;

    public ahk(Packet<?> var1, long var2) {
        this.packet = var1;
        this.time = var2;
    }

    public ahk(Packet<?> var1) {
        this.packet = var1;
        this.time = System.currentTimeMillis();
    }

    public Packet<?> getPacket() {
        return this.packet;
    }

    public long getTime() {
        return this.time;
    }
}
