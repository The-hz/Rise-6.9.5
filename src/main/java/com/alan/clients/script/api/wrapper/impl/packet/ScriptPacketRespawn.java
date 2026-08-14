package com.alan.clients.script.api.wrapper.impl.packet;

import net.minecraft.network.play.server.S07PacketRespawn;

public class ScriptPacketRespawn extends ScriptPacket<S07PacketRespawn> {
    public ScriptPacketRespawn(S07PacketRespawn var1) {
        super(var1);
    }

    public int getDimensionId() {
        return this.wrapped.getDimensionID();
    }

    public String getDifficulty() {
        return this.wrapped.getDifficulty().getDifficultyResourceKey();
    }

    public String getGameType() {
        return this.wrapped.getGameType().getName();
    }
}
