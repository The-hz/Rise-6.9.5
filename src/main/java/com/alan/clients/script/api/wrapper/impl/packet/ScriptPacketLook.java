package com.alan.clients.script.api.wrapper.impl.packet;

import net.minecraft.network.play.client.C03PacketPlayer.C05PacketPlayerLook;

public class ScriptPacketLook extends ScriptPacket<C05PacketPlayerLook> {
    public ScriptPacketLook(C05PacketPlayerLook var1) {
        super(var1);
    }

    public float getYaw() {
        return this.wrapped.getYaw();
    }

    public float getPitch() {
        return this.wrapped.getPitch();
    }

    public boolean isOnGround() {
        return this.wrapped.isOnGround();
    }

    public void setYaw(float var1) {
        this.wrapped.yaw = var1;
    }

    public void setPitch(float var1) {
        this.wrapped.pitch = var1;
    }

    public void setOnGround(boolean var1) {
        this.wrapped.setOnGround(var1);
    }
}
