package com.alan.clients.module.impl.combat.velocity;

import com.alan.clients.module.impl.combat.Velocity;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.MoveInputEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.value.Mode;
import hackclient.rise.bb;
import hackclient.rise.bv;

public final class AACVelocity extends Mode<Velocity> {
    private boolean jump;
    @EventLink
    public final Listener<PreMotionEvent> sx = var1x -> {
        if (!this.wj().qQ.wo() || aEg.thePlayer.isSwingInProgress) {
            bv.f(7.0);
            if (aEg.thePlayer.onGround && aEg.thePlayer.hurtTime > 0 && !bb.a(false, true, false, false, false)) {
                aEg.thePlayer.motionX *= 0.6;
                aEg.thePlayer.motionZ *= 0.6;
            }

            this.jump = false;
        }
    };
    @EventLink
    public final Listener<MoveInputEvent> sy = var1x -> {
        if (!this.wj().qQ.wo() || aEg.thePlayer.isSwingInProgress) {
            if (this.jump) {
                var1x.setJump(true);
            }
        }
    };

    public AACVelocity(String var1, Velocity var2) {
        super(var1, var2);
    }
}
