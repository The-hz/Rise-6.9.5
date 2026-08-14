package com.alan.clients.script.api.wrapper.impl.packet;

import net.minecraft.network.play.client.C17PacketCustomPayload;

public class ScriptPacketCustomPayload extends ScriptPacket<C17PacketCustomPayload> {
    public ScriptPacketCustomPayload(C17PacketCustomPayload var1) {
        super(var1);
    }

    public String getChannelName() {
        return this.wrapped.getChannelName();
    }

    public void setChannel(String var1) {
        this.wrapped.setChannel(var1);
    }
}
