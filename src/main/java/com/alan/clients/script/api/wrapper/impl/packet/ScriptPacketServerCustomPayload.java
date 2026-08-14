package com.alan.clients.script.api.wrapper.impl.packet;

import net.minecraft.network.play.server.S3FPacketCustomPayload;

public class ScriptPacketServerCustomPayload extends ScriptPacket<S3FPacketCustomPayload> {
    public ScriptPacketServerCustomPayload(S3FPacketCustomPayload var1) {
        super(var1);
    }

    public String getChannelName() {
        return this.wrapped.getChannelName();
    }
}
