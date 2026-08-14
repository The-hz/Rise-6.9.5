package com.alan.clients.script.api.wrapper.impl.packet;

import net.minecraft.network.play.client.C13PacketPlayerAbilities;

public class ScriptPacketAbilities extends ScriptPacket<C13PacketPlayerAbilities> {
    public ScriptPacketAbilities(C13PacketPlayerAbilities var1) {
        super(var1);
    }

    public boolean isInvulnerable() {
        return this.wrapped.isInvulnerable();
    }

    public boolean isFlying() {
        return this.wrapped.isFlying();
    }

    public boolean isAllowFlying() {
        return this.wrapped.isAllowFlying();
    }

    public boolean isCreativeMode() {
        return this.wrapped.isCreativeMode();
    }

    public void setInvulnerable(boolean var1) {
        this.wrapped.setInvulnerable(var1);
    }

    public void setFlying(boolean var1) {
        this.wrapped.setFlying(var1);
    }

    public void setAllowFlying(boolean var1) {
        this.wrapped.setAllowFlying(var1);
    }

    public void setCreativeMode(boolean var1) {
        this.wrapped.setCreativeMode(var1);
    }
}
