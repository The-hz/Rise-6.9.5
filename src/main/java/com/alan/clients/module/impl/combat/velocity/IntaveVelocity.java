package com.alan.clients.module.impl.combat.velocity;

import com.alan.clients.module.impl.combat.Velocity;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.HitSlowDownEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.other.AttackEvent;
import com.alan.clients.value.Mode;

public final class IntaveVelocity extends Mode<Velocity> {
    private boolean pw;
    private boolean ux;
    @EventLink
    public final Listener<PreUpdateEvent> onPreUpdate = var1x -> {
        if (!this.getParent().onSwing.wo() || aEg.thePlayer.isSwingInProgress) {
            if (this.pw && !this.ux && aEg.thePlayer.isSprinting()) {
                aEg.thePlayer.motionX *= 0.6;
                aEg.thePlayer.motionZ *= 0.6;
                aEg.thePlayer.setSprinting(false);
            }

            this.pw = false;
            this.ux = false;
        }
    };
    @EventLink
    public final Listener<HitSlowDownEvent> onHitSlowDown = var1x -> this.ux = true;
    @EventLink
    public final Listener<AttackEvent> onAttack = var1x -> this.pw = true;

    public IntaveVelocity(String var1, Velocity var2) {
        super(var1, var2);
    }
}
