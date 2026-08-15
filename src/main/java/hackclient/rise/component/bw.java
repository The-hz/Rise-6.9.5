package hackclient.rise.component;

import com.alan.clients.component.Component;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import hackclient.rise.cc;
import hackclient.rise.cd;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.network.Packet;

public class bw extends Component {
    private Map<Integer, cd> gk = new HashMap<>();
    private final Map<Class<? extends Packet<?>>, cc> gl = new HashMap<>();
    @EventLink
    public final Listener<PacketReceiveEvent> onPacketReceive = var1 -> {
        if (!var1.isCancelled()) {
            Packet packet = var1.getPacket();
            cc cc = this.gl.get(packet.getClass());
            if (cc != null) {
                Map map = cc.a(packet, this.gk);
                if (map != null) {
                    this.gk = map;
                }
            }
        }
    };

    public bw() {
    }

    @Override
    public void aT() {
        for (cc cc : cc.values()) {
            this.gl.put(cc.ce(), cc);
        }
    }

    public cd i(int var1) {
        return this.gk.get(var1);
    }
}
