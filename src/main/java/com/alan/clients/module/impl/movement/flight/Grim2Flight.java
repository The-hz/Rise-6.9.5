package com.alan.clients.module.impl.movement.flight;

import com.alan.clients.module.impl.movement.Flight;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.other.WorldChangeEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.value.Mode;
import com.viaversion.viarewind.protocol.v1_9to1_8.Protocol1_9To1_8;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ServerboundPackets1_9;
import de.florianmichael.vialoadingbase.ViaLoadingBase;
import hackclient.rise.ahj;
import java.util.LinkedList;
import java.util.Queue;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C0FPacketConfirmTransaction;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.network.play.server.S12PacketEntityVelocity;

public class Grim2Flight extends Mode<Flight> {
    private boolean Gi = false;
    private boolean Gj = false;
    private int Gk = 0;
    public static final Queue<Packet<?>> Gl = new LinkedList<>();
    @EventLink
    public final Listener<WorldChangeEvent> onWorldChange = var1x -> {
        this.getParent().toggle();
        this.Gk = 0;
        this.Gi = false;
        this.Gj = false;
        Gl.clear();
    };
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var1x -> {
        if (this.Gi) {
            this.Gk++;
            if (this.Gk >= 8) {
                for (int i = 0; i < 1; i++) {
                    this.hp();
                }
            }

            this.Gk = 0;
            this.Gi = false;
        }
    };
    @EventLink
    public final Listener<PacketSendEvent> onPacketSend = var1x -> {
        Packet packet = var1x.dq();
        if (packet instanceof C0FPacketConfirmTransaction && this.Gj) {
            var1x.setCancelled(true);
            if (Gl.isEmpty()) {
                this.Gi = true;
            }

            Gl.add(packet);
        }

        if (packet instanceof C02PacketUseEntity && this.Gj && !Gl.isEmpty()) {
            while (!Gl.isEmpty()) {
                ahj.m(Gl.poll());
            }
        }
    };
    @EventLink
    public final Listener<PacketReceiveEvent> onPacketReceive = var1x -> {
        Packet packet = var1x.getPacket();
        if (packet instanceof S08PacketPlayerPosLook && this.Gj && !Gl.isEmpty()) {
            while (!Gl.isEmpty()) {
                ahj.m(Gl.poll());
            }
        }

        if (packet instanceof S12PacketEntityVelocity && ((S12PacketEntityVelocity)packet).getEntityID() == aEg.thePlayer.getEntityId()) {
            if (this.Gj || !Gl.isEmpty()) {
                return;
            }

            this.Gk = 0;
            this.Gj = true;
            var1x.setCancelled(true);
        }
    };

    public Grim2Flight(String var1, Flight var2) {
        super(var1, var2);
    }

    @Override
    public void onEnable() {
        this.Gk = 0;
        this.Gi = false;
        this.Gj = false;
        Gl.clear();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        this.Gk = 0;
        this.Gi = false;
        this.Gj = false;

        while (!Gl.isEmpty()) {
            ahj.m(Gl.poll());
        }

        super.onDisable();
    }

    private void hp() {
        if (ViaLoadingBase.getInstance().getTargetVersion().newerThanOrEqualTo(ProtocolVersion.v1_9)) {
            UserConnection userconnection = Via.getManager().getConnectionManager().getConnections().iterator().next();
            PacketWrapper packetwrapper = PacketWrapper.create(ServerboundPackets1_9.PLAYER_COMMAND, userconnection);
            packetwrapper.write(Types.VAR_INT, aEg.thePlayer.getEntityId());
            packetwrapper.write(Types.VAR_INT, 8);
            packetwrapper.write(Types.VAR_INT, 0);
            packetwrapper.sendToServer(Protocol1_9To1_8.class);
        }
    }
}
