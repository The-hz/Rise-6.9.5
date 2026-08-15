package com.alan.clients.newevent.impl.packet;

import com.alan.clients.newevent.CancellableEvent;
import com.alan.clients.newevent.Event;
import com.alan.clients.script.api.wrapper.impl.event.ScriptEvent;
import com.alan.clients.script.api.wrapper.impl.event.impl.ScriptPacketSendEvent;
import lombok.Generated;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;

public final class PacketSendEvent extends CancellableEvent {
    private Packet<?> packet;
    private NetworkManager jS;

    @Override
    public ScriptEvent<? extends Event> getScriptEvent() {
        return new ScriptPacketSendEvent(this);
    }

    @Generated
    public Packet<?> dq() {
        return this.packet;
    }

    @Generated
    public NetworkManager dr() {
        return this.jS;
    }

    @Generated
    public void setPacket(Packet<?> var1) {
        this.packet = var1;
    }

    @Generated
    public void a(NetworkManager var1) {
        this.jS = var1;
    }

    @Generated
    public PacketSendEvent(Packet<?> var1, NetworkManager var2) {
        this.packet = var1;
        this.jS = var2;
    }
}
