package com.alan.clients.script.api.wrapper.impl.packet;

import net.minecraft.network.play.server.S2DPacketOpenWindow;

public class ScriptPacketOpenWindow extends ScriptPacket<S2DPacketOpenWindow> {
    public ScriptPacketOpenWindow(S2DPacketOpenWindow var1) {
        super(var1);
    }

    public int getWindowId() {
        return this.wrapped.getWindowId();
    }

    public String getGuiId() {
        return this.wrapped.getGuiId();
    }

    public String getWindowTitle() {
        return this.wrapped.getWindowTitle() != null ? this.wrapped.getWindowTitle().getUnformattedText() : "";
    }

    public int getSlotCount() {
        return this.wrapped.getSlotCount();
    }

    public boolean hasSlots() {
        return this.wrapped.hasSlots();
    }
}
