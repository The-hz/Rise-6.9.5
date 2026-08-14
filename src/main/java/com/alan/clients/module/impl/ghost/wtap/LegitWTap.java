package com.alan.clients.module.impl.ghost.wtap;

import com.alan.clients.module.impl.ghost.WTap;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.other.AttackEvent;
import com.alan.clients.value.Mode;

public class LegitWTap extends Mode<WTap> {
    private boolean Cu;
    private boolean Cv;
    @EventLink
    public final Listener<AttackEvent> Cw = var1x -> {
        this.Cv = Math.random() * 100.0 < this.wj().chance.wo().doubleValue() && var1x.dc().hurtTime >= 6;
        if (this.Cv && !this.Cu) {
            if (aEg.thePlayer.isSprinting() || aEg.gameSettings.cgG.isKeyDown()) {
                aEg.gameSettings.cgG.setPressed(true);
                this.Cu = true;
            }
        }
    };
    @EventLink
    public final Listener<PreMotionEvent> Cx = var1x -> {
        if (this.Cv) {
            if (this.Cu && Math.random() * 100.0 < this.wj().chance.wo().doubleValue()) {
                aEg.gameSettings.cgG.setPressed(false);
                this.Cu = false;
            }
        }
    };

    public LegitWTap(String var1, WTap var2) {
        super(var1, var2);
    }
}
