package com.alan.clients.module.impl.combat.velocity;

import com.alan.clients.module.impl.combat.Velocity;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.NumberValue;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S27PacketExplosion;

public final class BufferAbuseVelocity extends Mode<Velocity> {
    private final NumberValue sD = new NumberValue("Horizontal", this, 100, 0, 100, 1);
    private final NumberValue sE = new NumberValue("Vertical", this, 100, 0, 100, 1);
    private final NumberValue sF = new NumberValue("Buffer", this, 1, 1, 3, 1);
    private int amount;
    @EventLink
    public final Listener<PacketReceiveEvent> onPacketReceiveEvent = var1x -> {
        if ((!this.wj().qQ.wo() || aEg.thePlayer.isSwingInProgress) && !var1x.isCancelled()) {
            Packet packet = var1x.dq();
            double d0 = this.sD.wo().doubleValue();
            double d1 = this.sE.wo().doubleValue();
            if (packet instanceof S12PacketEntityVelocity s12packetentityvelocity && s12packetentityvelocity.getEntityID() == aEg.thePlayer.getEntityId()) {
                if (this.amount < this.sF.wo().intValue()) {
                    var1x.setCancelled();
                    this.amount++;
                    return;
                }

                var1x.e(s12packetentityvelocity);
                this.amount = 0;
            }

            if (packet instanceof S27PacketExplosion s27packetexplosion) {
                if (this.amount < this.sF.wo().intValue()) {
                    var1x.setCancelled();
                    this.amount++;
                    return;
                }

                s27packetexplosion.posX *= d0 / 100.0;
                s27packetexplosion.posY *= d1 / 100.0;
                s27packetexplosion.posZ *= d0 / 100.0;
                var1x.e(s27packetexplosion);
                this.amount = 0;
            }
        }
    };

    public BufferAbuseVelocity(String var1, Velocity var2) {
        super(var1, var2);
    }
}
