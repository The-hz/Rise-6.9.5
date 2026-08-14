package com.alan.clients.script.api.wrapper.impl.packet;

import java.lang.reflect.Field;
import net.minecraft.network.play.client.C19PacketResourcePackStatus;

public class ScriptPacketResourcePackStatus extends ScriptPacket<C19PacketResourcePackStatus> {
    public ScriptPacketResourcePackStatus(C19PacketResourcePackStatus var1) {
        super(var1);
    }

    public String getHash() {
        try {
            Field field = this.wrapped.getClass().getDeclaredField("hash");
            field.setAccessible(true);
            return (String)field.get(this.wrapped);
        } catch (Exception exception) {
            return "";
        }
    }

    public String getStatus() {
        try {
            Field field = this.wrapped.getClass().getDeclaredField("status");
            field.setAccessible(true);
            Object object = field.get(this.wrapped);
            return object != null ? object.toString() : "";
        } catch (Exception exception) {
            return "";
        }
    }
}
