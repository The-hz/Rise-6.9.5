package com.alan.clients.script.api.wrapper.impl.packet;

import net.minecraft.network.play.client.C0FPacketConfirmTransaction;

public class ScriptPacketTransaction extends ScriptPacket<C0FPacketConfirmTransaction> {
    public ScriptPacketTransaction(C0FPacketConfirmTransaction var1) {
        super(var1);
    }

    public int getWindowId() {
        return this.wrapped.getWindowId();
    }

    public short getUid() {
        return this.wrapped.getUid();
    }

    public void setWindowId(int var1) {
        this.wrapped.setWindowId(var1);
    }

    public void setUid(short var1) {
        this.wrapped.setUid(var1);
    }

    public void setAccepted(boolean var1) {
        this.wrapped.setAccepted(var1);
    }
}
