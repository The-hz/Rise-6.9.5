package com.alan.clients.script.api.wrapper.impl.packet;

import com.alan.clients.script.api.wrapper.impl.ScriptBlockPos;
import net.minecraft.network.play.server.S24PacketBlockAction;

public class ScriptPacketBlockAction extends ScriptPacket<S24PacketBlockAction> {
    public ScriptPacketBlockAction(S24PacketBlockAction var1) {
        super(var1);
    }

    public ScriptBlockPos getPosition() {
        return new ScriptBlockPos(this.wrapped.getBlockPosition());
    }

    public int getData1() {
        return this.wrapped.getData1();
    }

    public int getData2() {
        return this.wrapped.getData2();
    }
}
