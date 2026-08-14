package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.component.Component;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.other.ServerJoinEvent;
import com.alan.clients.newevent.impl.other.WorldChangeEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.minecraft.network.Packet;
import net.minecraft.network.handshake.client.C00Handshake;
import net.minecraft.network.login.client.C00PacketLoginStart;
import net.minecraft.network.login.client.C01PacketEncryptionResponse;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.status.client.C00PacketServerQuery;
import net.minecraft.network.status.client.C01PacketPing;
import rip.vantage.commons.util.time.a;

public final class bc extends Component {
    private static boolean cP = true;
    public static final ConcurrentLinkedQueue<Packet<?>> cQ = new ConcurrentLinkedQueue<>();
    public static boolean cR;
    public static boolean cS;
    public static ArrayList<Class<?>> cT = new ArrayList<>();
    public static a cU = new a();
    @EventLink(cH = 0)
    public final Listener<PacketSendEvent> cV = var0 -> {
        if (aEg.thePlayer == null) {
            cQ.clear();
            cT.clear();
        } else {
            if (aEg.thePlayer.ticksExisted < 10 && cP) {
                Client.a.p().tn();
                cP = false;
            }

            if (!aEg.thePlayer.isDead && !aEg.isSingleplayer() && aEg.getNetHandler().doneLoadingTerrain) {
                Packet packet = var0.dq();
                if (!(packet instanceof C00Handshake)
                    && !(packet instanceof C00PacketLoginStart)
                    && !(packet instanceof C00PacketServerQuery)
                    && !(packet instanceof C01PacketPing)
                    && !(packet instanceof C01PacketEncryptionResponse)) {
                    if (cR && !cS) {
                        if (cU.T(100L)) {
                            cU.aX();
                            cT.clear();
                        }

                        if (!var0.isCancelled() && cT.stream().noneMatch(var1 -> var1 == packet.getClass())) {
                            cQ.add(packet);
                            var0.setCancelled();
                        }
                    } else if (packet instanceof C03PacketPlayer) {
                        cQ.forEach(ahj::m);
                        cQ.clear();
                        cS = false;
                    }
                }
            } else {
                cQ.forEach(ahj::m);
                cQ.clear();
                cR = false;
                cT.clear();
                if (aEg.thePlayer.ticksExisted < 10 && cP) {
                    Client.a.p().tn();
                    cP = false;
                }
            }
        }
    };
    @EventLink(cH = 0)
    public final Listener<WorldChangeEvent> cW = var0 -> {
        cQ.clear();
        cR = false;
    };
    @EventLink(cH = 0)
    public final Listener<ServerJoinEvent> cX = var0 -> {
        afi.b("s");
        cQ.clear();
        cR = false;
    };

    public bc() {
    }

    public static void a(Class<?>... var0) {
        cT = new ArrayList<>(Arrays.asList(var0));
        cU.aX();
    }

    public static void dispatch() {
        cS = true;
    }
}
