package com.alan.clients.script.api.wrapper.impl.packet;

import net.minecraft.network.play.server.S29PacketSoundEffect;

public class ScriptPacketSoundEffect extends ScriptPacket<S29PacketSoundEffect> {
    public ScriptPacketSoundEffect(S29PacketSoundEffect var1) {
        super(var1);
    }

    public String getSoundName() {
        return this.wrapped.getSoundName();
    }

    public double getX() {
        return this.wrapped.getX();
    }

    public double getY() {
        return this.wrapped.getY();
    }

    public double getZ() {
        return this.wrapped.getZ();
    }

    public float getVolume() {
        return this.wrapped.getVolume();
    }

    public float getPitch() {
        return this.wrapped.getPitch();
    }
}
