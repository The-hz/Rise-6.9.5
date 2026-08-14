package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.component.Component;
import com.alan.clients.module.impl.combat.KillAura;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.other.WorldChangeEvent;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.newevent.impl.render.Render3DEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class cf extends Component {
    public static ConcurrentLinkedQueue<cm> hc = new ConcurrentLinkedQueue<>();
    @EventLink(cH = 4)
    public final Listener<Render2DEvent> hd = var0 -> {
        if (!hc.isEmpty()) {
            hc.forEach(cm::co);
        }
    };
    @EventLink(cH = 4)
    public final Listener<ff> he = var0 -> {
        if (hc != null && !hc.isEmpty()) {
            Iterator iterator = hc.iterator();

            while (iterator.hasNext()) {
                ((cm)iterator.next()).a(var0.do_(), var0.dp());
            }
        }
    };
    @EventLink(cH = 4)
    public final Listener<Render3DEvent> hf = var0 -> {
        if (hc != null && !hc.isEmpty()) {
            hc.forEach(cm::cp);
        }
    };
    @EventLink(cH = 4)
    public final Listener<PreUpdateEvent> hg = var0 -> {
        KillAura killaura = Client.a.g().c(KillAura.class);
        List list = killaura.isEnabled() ? killaura.oM : new ArrayList();
        hc.removeIf(var1 -> var1.hQ + 10 < aEg.thePlayer.ticksExisted || !list.contains(var1.by));
        Iterator iterator = hc.iterator();

        while (iterator.hasNext()) {
            ((cm)iterator.next()).cq();
        }
    };
    @EventLink
    public final Listener<WorldChangeEvent> hh = var0 -> hc.clear();

    public cf() {
    }

    public static void a(cm var0) {
        hc.removeIf(var1 -> var0.getClass() == var1.getClass() && var0.by == var1.by);
        hc.add(var0);
    }
}
