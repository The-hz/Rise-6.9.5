package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.module.impl.combat.AntiBot;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.value.Mode;

public final class hl extends Mode<AntiBot> {
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var1x -> aEg.theWorld.playerEntities.forEach(var1xx -> {
        if (aEg.theWorld.playerEntities.stream().anyMatch(var1xxx -> var1xxx.getEntityId() == var1xx.getEntityId() && var1xxx != var1xx)) {
            Client.a.x().b(this, var1xx);
        }
    });

    public hl(String var1, AntiBot var2) {
        super(var1, var2);
    }

    @Override
    public void onDisable() {
        Client.a.x().a(this);
    }
}
