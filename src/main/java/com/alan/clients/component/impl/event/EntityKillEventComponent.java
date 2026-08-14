package com.alan.clients.component.impl.event;

import com.alan.clients.Client;
import com.alan.clients.component.Component;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.other.AttackEvent;
import com.alan.clients.newevent.impl.other.KillEvent;
import com.alan.clients.newevent.impl.other.WorldChangeEvent;
import hackclient.rise.aha;
import net.minecraft.entity.Entity;

public class EntityKillEventComponent extends Component implements aha {
    Entity by = null;
    @EventLink(cH = 1)
    public final Listener<PreMotionEvent> bz = var1 -> {
        if (this.by != null && !aEg.theWorld.loadedEntityList.contains(this.by)) {
            Client.a.e().d(new KillEvent(this.by));
            this.by = null;
        }
    };
    @EventLink(cH = 1)
    public final Listener<AttackEvent> bA = var1 -> this.by = var1.dc();
    @EventLink(cH = 1)
    public final Listener<WorldChangeEvent> bB = var1 -> this.by = null;

    public EntityKillEventComponent() {
    }
}
