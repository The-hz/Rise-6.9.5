package hackclient.rise.component;

import com.alan.clients.component.Component;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.other.ServerJoinEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import hackclient.rise.ahm;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.c;

public class ax
extends Component {
    @EventLink
    public Listener<PreMotionEvent> onPreMotion;
    public static String cs;
    @EventLink
    public Listener<ServerJoinEvent> onServerJoin;
    public Pattern cq = Pattern.compile("Your new API key is (.*)");
    @EventLink
    public Listener<PacketReceiveEvent> onPacketReceive;
    public static boolean cr;

    static {
    }

    public ax() {
        this.onPreMotion = preMotionEvent -> {
            if (!cr && ax.aEg.thePlayer.ticksExisted == 2) {
                ahm.vn();
            }
        };
        this.onPacketReceive = packetReceiveEvent -> {
            Packet<?> packet = packetReceiveEvent.getPacket();
            if (packet instanceof c) {
                if (!ahm.vn()) {
                    return;
                }
                c c2 = (c)packet;
                String string = c2.getChatComponent().getUnformattedText();
                Matcher matcher = this.cq.matcher(string);
                if (!c2.isChat() && matcher.find()) {
                    matcher.group(1);
                    if (!cr) {
                        packetReceiveEvent.setCancelled();
                    }
                    cr = true;
                }
            }
        };
        this.onServerJoin = serverJoinEvent -> {
            cr = false;
        };
    }

}
