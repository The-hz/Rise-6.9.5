package com.alan.clients.anticheat.util;

import lombok.Generated;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S14PacketEntity.S16PacketEntityLook;
import net.minecraft.network.play.server.S14PacketEntity.S17PacketEntityLookMove;
import net.minecraft.network.play.server.S14PacketEntity;

public final class PacketUtil {
    public static boolean b(Packet<?> var0) {
        return var0 instanceof S14PacketEntity;
    }

    public static boolean c(Packet<?> var0) {
        return var0 instanceof S17PacketEntityLookMove || var0 instanceof S16PacketEntityLook;
    }

    @Generated
    private PacketUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
