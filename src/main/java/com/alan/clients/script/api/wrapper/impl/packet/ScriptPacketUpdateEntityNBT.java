package com.alan.clients.script.api.wrapper.impl.packet;

import net.minecraft.network.play.server.S49PacketUpdateEntityNBT;

public class ScriptPacketUpdateEntityNBT extends ScriptPacket<S49PacketUpdateEntityNBT> {
    public ScriptPacketUpdateEntityNBT(S49PacketUpdateEntityNBT var1) {
        super(var1);
    }

    public int getEntityId() {
        return this.wrapped.getEntity(MC.theWorld) != null ? this.wrapped.getEntity(MC.theWorld).getEntityId() : -1;
    }
}
