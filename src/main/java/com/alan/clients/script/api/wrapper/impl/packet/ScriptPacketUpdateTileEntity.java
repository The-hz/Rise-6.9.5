package com.alan.clients.script.api.wrapper.impl.packet;

import com.alan.clients.script.api.wrapper.impl.ScriptBlockPos;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;

public class ScriptPacketUpdateTileEntity extends ScriptPacket<S35PacketUpdateTileEntity> {
    public ScriptPacketUpdateTileEntity(S35PacketUpdateTileEntity var1) {
        super(var1);
    }

    public ScriptBlockPos getPosition() {
        return new ScriptBlockPos(this.wrapped.getPos());
    }

    public int getTileEntityType() {
        return this.wrapped.getTileEntityType();
    }
}
