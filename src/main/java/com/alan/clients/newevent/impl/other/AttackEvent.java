package com.alan.clients.newevent.impl.other;

import com.alan.clients.newevent.CancellableEvent;
import com.alan.clients.newevent.Event;
import com.alan.clients.script.api.wrapper.impl.event.ScriptEvent;
import com.alan.clients.script.api.wrapper.impl.event.impl.ScriptAttackEvent;
import lombok.Generated;
import net.minecraft.entity.EntityLivingBase;

public final class AttackEvent extends CancellableEvent {
    private EntityLivingBase jE;

    @Override
    public ScriptEvent<? extends Event> getScriptEvent() {
        return new ScriptAttackEvent(this);
    }

    @Generated
    public EntityLivingBase dc() {
        return this.jE;
    }

    @Generated
    public void b(EntityLivingBase living) {
        this.jE = living;
    }

    @Generated
    public AttackEvent(EntityLivingBase living) {
        this.jE = living;
    }
}
