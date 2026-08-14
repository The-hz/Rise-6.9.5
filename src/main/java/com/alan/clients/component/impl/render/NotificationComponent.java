package com.alan.clients.component.impl.render;

import com.alan.clients.component.Component;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import hackclient.rise.aha;
import hackclient.rise.ait;
import java.util.concurrent.ConcurrentLinkedQueue;

public class NotificationComponent extends Component implements aha {
    public static ConcurrentLinkedQueue<ait> hu = new ConcurrentLinkedQueue<>();
    public static int hv;
    public static int hw;
    @EventLink(cH = 4)
    public final Listener<Render2DEvent> hx = var1 -> hu.isEmpty();

    public NotificationComponent() {
    }

    public static void ci() {
        hu.forEach(ait::ci);
        hw = aEg.ingameGUI.bnh;
    }

    public static void cj() {
        hv = aEg.ingameGUI.bnh;
        hu.forEach(var0 -> {
            var0.cj();
            if (var0.hj.aKx() > 3000L) {
                hu.remove(var0);
            }
        });
        if (!hu.isEmpty()) {
            aMR.execute(() -> hu.forEach(ait::ju));
        }
    }

    public static void a(ait var0) {
        hu.add(var0);
    }
}
