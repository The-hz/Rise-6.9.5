package com.alan.clients.newevent.impl.other;

import com.alan.clients.newevent.Event;
import com.alan.clients.script.api.wrapper.impl.event.ScriptEvent;
import com.alan.clients.script.api.wrapper.impl.event.impl.ScriptKillEvent;
import lombok.Generated;
import net.minecraft.entity.Entity;

public final class KillEvent implements Event {
    Entity jM;

    @Override
    public ScriptEvent<? extends Event> getScriptEvent() {
        return new ScriptKillEvent(this);
    }

    @Generated
    public Entity dk() {
        return this.jM;
    }

    @Generated
    public KillEvent(Entity var1) {
        this.jM = var1;
    }
}
