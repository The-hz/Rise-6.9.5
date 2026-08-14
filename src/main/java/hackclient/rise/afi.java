package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.util.interfaces.InstanceAccess;
import lombok.Generated;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.util.s;

public final class afi implements InstanceAccess {
    public static void b(Object var0, Object... var1) {
        if (aEg.thePlayer != null) {
            String s = String.format(ahd.ce(var0.toString()), var1);
            aEg.thePlayer.addChatMessage(new s(getPrefix() + s));
            System.out.println(var0);
        }
    }

    public static void c(Object var0, Object... var1) {
    }

    public static void d(Object var0, Object... var1) {
        if (aEg.thePlayer != null) {
            String s = var1 != null && var1.length != 0 ? String.format(var0.toString(), var1) : var0.toString();
            aEg.thePlayer.addChatMessage(new s(s));
        }
    }

    public static void i(Object var0) {
        if (aEg.thePlayer != null) {
            ahj.l(new C01PacketChatMessage(var0.toString()));
        }
    }

    public static String getPrefix() {
        return Client.b + " » ";
    }

    @Generated
    private afi() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
