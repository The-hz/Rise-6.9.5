package com.alan.clients.module.impl.combat.velocity;

import com.alan.clients.module.impl.combat.Velocity;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.other.TickEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.NumberValue;
import hackclient.rise.afi;
import hackclient.rise.ahj;
import hackclient.rise.il;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S27PacketExplosion;
import net.minecraft.network.play.server.S32PacketConfirmTransaction;

public class DelayVelocity extends Mode<Velocity> {
    private final NumberValue tl = new NumberValue("Delay (ticks)", this, 5, 0, 40, 1);
    private final BooleanValue pingSpoof = new BooleanValue("Delay Explosions", this, true);
    private final Deque<il> tn = new ArrayDeque<>();
    private boolean to = false;
    @EventLink
    public final Listener<PacketReceiveEvent> tp = var1x -> {
        if (!this.to && aEg.thePlayer != null) {
            Packet packet = var1x.dq();
            if (packet instanceof S12PacketEntityVelocity s12packetentityvelocity) {
                if (s12packetentityvelocity.getEntityID() == aEg.thePlayer.getEntityId()) {
                    var1x.setCancelled();
                    int i = this.tl.wo().intValue();
                    int j = aEg.thePlayer.ticksExisted;
                    this.tn.addLast(new il(s12packetentityvelocity, j + i));
                }
            } else if (packet instanceof S32PacketConfirmTransaction s32packetconfirmtransaction) {
                var1x.setCancelled();
                int k = this.tl.wo().intValue();
                int l = aEg.thePlayer.ticksExisted;
                this.tn.addLast(new il(s32packetconfirmtransaction, l + k));
            } else {
                if (this.pingSpoof.wo() && packet instanceof S27PacketExplosion) {
                    var1x.setCancelled();
                    int i1 = this.tl.wo().intValue();
                    int j1 = aEg.thePlayer.ticksExisted;
                    this.tn.addLast(new il(packet, j1 + i1));
                }
            }
        }
    };
    @EventLink
    public final Listener<TickEvent> tq = var1x -> {
        if (aEg.thePlayer != null && !this.tn.isEmpty()) {
            int i = aEg.thePlayer.ticksExisted;

            while (!this.tn.isEmpty() && this.tn.peekFirst().ts <= i) {
                Packet packet = this.tn.removeFirst().tr;
                this.to = true;

                try {
                    ahj.p(packet);
                } finally {
                    this.to = false;
                }
            }

            afi.c(this.tn.peekFirst().ts - i);
        }
    };

    public DelayVelocity(String var1, Velocity var2) {
        super(var1, var2);
    }

    @Override
    public void onDisable() {
        if (!this.tn.isEmpty()) {
            this.to = true;

            try {
                Iterator iterator = this.tn.iterator();

                while (iterator.hasNext()) {
                    ahj.p(((il)iterator.next()).tr);
                }
            } finally {
                this.to = false;
                this.tn.clear();
            }
        }
    }
}
