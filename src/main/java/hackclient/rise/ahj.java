package hackclient.rise;

import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.script.api.NetworkAPI;
import com.alan.clients.util.interfaces.InstanceAccess;
import java.util.Arrays;
import lombok.Generated;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;

public final class ahj implements InstanceAccess {
    private static NetHandlerPlayClient uK() {
        return aEg != null ? aEg.getNetHandler() : null;
    }

    public static void l(Packet<?> var0) {
        NetHandlerPlayClient nethandlerplayclient = uK();
        if (nethandlerplayclient != null && var0 != null) {
            nethandlerplayclient.addToSendQueue(var0);
        }
    }

    public static void m(Packet<?> var0) {
        NetHandlerPlayClient nethandlerplayclient = uK();
        if (nethandlerplayclient != null && var0 != null) {
            nethandlerplayclient.u(var0);
        }
    }

    public static void n(Packet<?> var0) {
        if (var0 == null) {
            System.out.println("Packet is null");
        } else {
            NetHandlerPlayClient nethandlerplayclient = uK();
            if (nethandlerplayclient != null) {
                if (s(var0)) {
                    nethandlerplayclient.addToSendQueue(var0);
                } else {
                    nethandlerplayclient.v(var0);
                }
            }
        }
    }

    public static void o(Packet<?> var0) {
        NetHandlerPlayClient nethandlerplayclient = uK();
        if (nethandlerplayclient != null && var0 != null) {
            if (s(var0)) {
                nethandlerplayclient.u(var0);
            } else {
                nethandlerplayclient.w(var0);
            }
        }
    }

    public static void p(Packet<?> var0) {
        NetHandlerPlayClient nethandlerplayclient = uK();
        if (nethandlerplayclient != null && var0 != null) {
            nethandlerplayclient.v(var0);
        }
    }

    public static void q(Packet<?> var0) {
        NetHandlerPlayClient nethandlerplayclient = uK();
        if (nethandlerplayclient != null && var0 != null) {
            nethandlerplayclient.w(var0);
        }
    }

    public static boolean r(Packet<?> var0) {
        return !s(var0);
    }

    public static boolean s(Packet<?> var0) {
        return Arrays.stream(NetworkAPI.serverbound).anyMatch(var1 -> var1 == var0.getClass());
    }

    public static void j(PacketReceiveEvent var0) {
    }

    @Generated
    private ahj() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
