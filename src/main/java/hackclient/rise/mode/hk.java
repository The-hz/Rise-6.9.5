package hackclient.rise.mode;

import com.alan.clients.Client;
import com.alan.clients.module.impl.combat.AntiBot;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.value.Mode;
import hackclient.rise.afi;

public final class hk extends Mode<AntiBot> {
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var1x -> aEg.theWorld.playerEntities.forEach(var1xx -> {
        String s = var1xx.getDisplayName().getUnformattedText();
        if (!r(s)) {
            afi.c("Detected bot (invalid colour start): " + s);
            Client.a.x().b(this, var1xx);
        }
    });

    public hk(String var1, AntiBot var2) {
        super(var1, var2);
    }

    public static boolean r(String var0) {
        return var0 != null && !var0.isEmpty() ? var0.matches("^§[0-9a-fk-or].*") : false;
    }

    @Override
    public void onDisable() {
        Client.a.x().a(this);
    }
}
