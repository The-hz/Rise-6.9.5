package com.alan.clients.util.packet;

import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.script.api.NetworkAPI;
import com.alan.clients.util.interfaces.InstanceAccess;
import java.util.Arrays;
import lombok.Generated;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;

public final class PacketUtil implements InstanceAccess {
    private static NetHandlerPlayClient uK() {
        return aEg != null ? aEg.getNetHandler() : null;
    }

    public static void l(Packet<?> packet) {
        NetHandlerPlayClient nethandlerplayclient = uK();
        if (nethandlerplayclient != null && packet != null) {
            nethandlerplayclient.addToSendQueue(packet);
        }
    }

    public static void m(Packet<?> packet) {
        NetHandlerPlayClient nethandlerplayclient = uK();
        if (nethandlerplayclient != null && packet != null) {
            nethandlerplayclient.u(packet);
        }
    }

    public static void n(Packet<?> packet) {
        if (packet == null) {
            System.out.println("Packet is null");
        } else {
            NetHandlerPlayClient nethandlerplayclient = uK();
            if (nethandlerplayclient != null) {
                if (s(packet)) {
                    nethandlerplayclient.addToSendQueue(packet);
                } else {
                    nethandlerplayclient.v(packet);
                }
            }
        }
    }

    public static void o(Packet<?> packet) {
        NetHandlerPlayClient nethandlerplayclient = uK();
        if (nethandlerplayclient != null && packet != null) {
            if (s(packet)) {
                nethandlerplayclient.u(packet);
            } else {
                nethandlerplayclient.w(packet);
            }
        }
    }

    public static void p(Packet<?> packet) {
        NetHandlerPlayClient nethandlerplayclient = uK();
        if (nethandlerplayclient != null && packet != null) {
            nethandlerplayclient.v(packet);
        }
    }

    public static void q(Packet<?> packet) {
        NetHandlerPlayClient nethandlerplayclient = uK();
        if (nethandlerplayclient != null && packet != null) {
            nethandlerplayclient.w(packet);
        }
    }

    public static boolean r(Packet<?> packet) {
        return !s(packet);
    }

    public static boolean s(Packet<?> packet) {
        return Arrays.stream(NetworkAPI.serverbound).anyMatch(var1 -> var1 == packet.getClass());
    }

    public static void j(PacketReceiveEvent event) {
    }

    @Generated
    private PacketUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
