package com.alan.clients.module.impl.ghost;

import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.HitSlowDownEvent;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.NumberValue;

@ModuleInfo(aliases = "module.ghost.keepsprint.name", description = "module.ghost.keepsprint.description", category = Category.GHOST)
public class KeepSprint extends Module {
    private final NumberValue BE = new NumberValue("Hit Slow Down During Velocity", this, 0.6, 0, 1, 0.05);
    private final NumberValue BF = new NumberValue("Hit Slow Down Normal", this, 0.6, 0, 1, 0.05);
    private final NumberValue BG = new NumberValue("Buffer Decrease", this, 1, 0.1, 10, 0.1, () -> !this.BK.wo());
    private final NumberValue BH = new NumberValue("Max Buffer", this, 5, 1, 10, 1, () -> !this.BK.wo());
    private final BooleanValue BI = new BooleanValue("Velocity Hit Sprint", this, false);
    private final BooleanValue BJ = new BooleanValue("Normal Hit Sprint", this, false);
    private final BooleanValue BK = new BooleanValue("Buffer Abuse", this, false);
    private final BooleanValue BL = new BooleanValue("Only In Air", this, false);
    private boolean resetting;
    private double combo;
    @EventLink
    public final Listener<HitSlowDownEvent> onHitSlowDown = var1 -> {
        if (!aEg.thePlayer.onGround || !this.BL.wo()) {
            if (this.BK.wo()) {
                if (this.combo < this.BH.wo().intValue() && !this.resetting) {
                    this.combo++;
                } else {
                    if (this.combo > 0.0) {
                        this.combo = Math.max(0.0, this.combo - this.BG.wo().doubleValue());
                        this.resetting = true;
                        return;
                    }

                    this.resetting = false;
                }
            } else {
                this.combo = 0.0;
            }

            if (aEg.thePlayer.hurtTime > 0) {
                var1.setSlowDown(this.BE.wo().doubleValue());
                var1.setSprint(this.BI.wo());
            } else {
                var1.setSlowDown(this.BF.wo().doubleValue());
                var1.setSprint(this.BJ.wo());
            }
        }
    };

    public KeepSprint() {
    }
}
