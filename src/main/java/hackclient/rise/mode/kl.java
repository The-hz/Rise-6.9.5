package hackclient.rise.mode;

import com.alan.clients.module.impl.exploit.Disabler;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.value.Mode;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C0FPacketConfirmTransaction;

public class kl extends Mode<Disabler> {
    @EventLink
    public final Listener<PacketSendEvent> onPacketSend = var0 -> {
        Packet packet = var0.dq();
        if (packet instanceof C0FPacketConfirmTransaction) {
            var0.setCancelled();
        }
    };

    public kl(String var1, Disabler disabler) {
        super(var1, disabler);
    }
}
