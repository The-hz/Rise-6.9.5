package com.alan.clients.util.packet;

import net.minecraft.network.Packet;

public class TimedPacket {
    private final Packet<?> packet;
    private final long time;

    public TimedPacket(Packet<?> var1, long var2) {
        this.packet = var1;
        this.time = var2;
    }

    public TimedPacket(Packet<?> var1) {
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
