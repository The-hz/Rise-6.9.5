package com.alan.clients.script.api.wrapper.impl.packet;

import net.minecraft.network.play.server.S20PacketEntityProperties;

public class ScriptPacketEntityProperties extends ScriptPacket<S20PacketEntityProperties> {
    public ScriptPacketEntityProperties(S20PacketEntityProperties var1) {
        super(var1);
    }

    public int getEntityId() {
        return this.wrapped.getEntityId();
    }
}
