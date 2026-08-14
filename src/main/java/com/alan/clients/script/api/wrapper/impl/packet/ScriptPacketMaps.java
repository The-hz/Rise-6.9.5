package com.alan.clients.script.api.wrapper.impl.packet;

import java.lang.reflect.Field;
import net.minecraft.network.play.server.S34PacketMaps;

public class ScriptPacketMaps extends ScriptPacket<S34PacketMaps> {
    public ScriptPacketMaps(S34PacketMaps var1) {
        super(var1);
    }

    public int getMapId() {
        return this.wrapped.getMapId();
    }

    public byte getMapScale() {
        try {
            Field field = this.wrapped.getClass().getDeclaredField("mapScale");
            field.setAccessible(true);
            return field.getByte(this.wrapped);
        } catch (Exception exception) {
            return 0;
        }
    }
}
