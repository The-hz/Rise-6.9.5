package com.alan.clients.module.impl.movement;

import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.MoveInputEvent;

@ModuleInfo(
    aliases = {"module.movement.snaptap.name", "Null Move", "SOCD", "Null Binds"},
    description = "module.movement.snaptap.description",
    category = Category.MOVEMENT
)
public class SnapTap extends Module {
    private boolean DW;
    private boolean DX;
    private boolean DY;
    private boolean DZ;
    private long Ea;
    private long Eb;
    private long Ec;
    private long Ed;
    @EventLink
    public final Listener<MoveInputEvent> Ee = var1 -> {
        boolean flag = aEg.gameSettings.keyBindForward.isKeyDown();
        boolean flag1 = aEg.gameSettings.keyBindBack.isKeyDown();
        boolean flag2 = aEg.gameSettings.keyBindLeft.isKeyDown();
        boolean flag3 = aEg.gameSettings.keyBindRight.isKeyDown();
        long i = System.currentTimeMillis();
        if (flag && !this.DW) {
            this.Ea = i;
        }

        if (flag1 && !this.DX) {
            this.Eb = i;
        }

        if (flag2 && !this.DY) {
            this.Ec = i;
        }

        if (flag3 && !this.DZ) {
            this.Ed = i;
        }

        if (flag && flag1) {
            if (this.Ea != this.Eb) {
                var1.setForward(this.Ea > this.Eb ? 1.0F : -1.0F);
            } else {
                var1.setForward(0.0F);
            }
        } else if (flag) {
            var1.setForward(1.0F);
        } else if (flag1) {
            var1.setForward(-1.0F);
        }

        if (flag2 && flag3) {
            if (this.Ec != this.Ed) {
                var1.setStrafe(this.Ec > this.Ed ? 1.0F : -1.0F);
            } else {
                var1.setStrafe(0.0F);
            }
        } else if (flag2) {
            var1.setStrafe(1.0F);
        } else if (flag3) {
            var1.setStrafe(-1.0F);
        }

        this.DW = flag;
        this.DX = flag1;
        this.DY = flag2;
        this.DZ = flag3;
    };

    public SnapTap() {
    }

    @Override
    public void onDisable() {
        this.DW = false;
        this.DX = false;
        this.DY = false;
        this.DZ = false;
        this.Ea = 0L;
        this.Eb = 0L;
        this.Ec = 0L;
        this.Ed = 0L;
    }
}
