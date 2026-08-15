package com.alan.clients.module.impl.ghost.wtap;

import com.alan.clients.module.impl.ghost.WTap;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.other.AttackEvent;
import com.alan.clients.value.Mode;
import net.minecraft.entity.EntityLivingBase;

public final class SilentWTap extends Mode<WTap> {
    private EntityLivingBase jE;
    @EventLink
    public final Listener<PreMotionEvent> onPreMotionEvent = var1x -> {
        if (this.jE != null && this.jE.hurtTime == 9) {
            var1x.setSprinting(false);
        }
    };
    @EventLink
    public final Listener<AttackEvent> onAttack = var1x -> this.jE = var1x.getLiving();

    public SilentWTap(String var1, WTap wTap) {
        super(var1, wTap);
    }
}
