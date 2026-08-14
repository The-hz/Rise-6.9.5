package com.alan.clients.module.impl.other.clientspoofer;

import com.alan.clients.module.impl.other.ClientSpoofer;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.StringValue;
import hackclient.rise.ahj;
import hackclient.rise.ajt;
import hackclient.rise.ss;
import io.netty.buffer.Unpooled;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.C17PacketCustomPayload;

public class LabyModClientSpoofer extends Mode<ClientSpoofer> {
    public final StringValue ZF = new StringValue("Spoofed Version, Latest would be preferred", this, "4.2.31");
    @EventLink
    public final Listener<PacketSendEvent> ZG = var1x -> {
        if (var1x.dq() instanceof C17PacketCustomPayload) {
            ss ss = new ss(this);
            var1x.setCancelled();

            for (ajt ajt : ss) {
                PacketBuffer packetbuffer = new PacketBuffer(Unpooled.buffer());
                if ((Boolean)ajt.vV()) {
                    packetbuffer.writeString((String)ajt.vU());
                } else {
                    packetbuffer.writeBytes(((String)ajt.vU()).getBytes());
                }

                ahj.m(new C17PacketCustomPayload((String)ajt.vT(), packetbuffer));
            }
        }
    };

    public LabyModClientSpoofer(String var1, ClientSpoofer var2) {
        super(var1, var2);
    }
}
