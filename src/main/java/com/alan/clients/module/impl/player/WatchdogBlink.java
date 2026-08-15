package com.alan.clients.module.impl.player;

import com.alan.clients.component.impl.player.BlinkComponent;
import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PostMotionEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.other.WorldChangeEvent;
import com.alan.clients.value.impl.NumberValue;
import java.util.ArrayDeque;
import java.util.Deque;

@ModuleInfo(aliases = "module.player.watchdogblink.name", description = "module.player.watchdogblink.description", category = Category.PLAYER)
public class WatchdogBlink extends Module {
    public NumberValue interval = new NumberValue("Interval", this, 4, 1, 20, 1);
    public NumberValue disableTicks = new NumberValue("Disable Ticks", this, 15, 1, 40, 1);
    private final Deque<Integer> ahw = new ArrayDeque<>();
    private int ahx;
    private int qH;
    private boolean ahy;
    private boolean ahz;
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var0 -> BlinkComponent.blink();
    @EventLink
    public final Listener<PostMotionEvent> onPostMotion = var1 -> {
        int i = BlinkComponent.bg() - this.ahx;
        if (i > 0) {
            this.ahw.add(i);
        }

        if (this.ahy) {
            this.N(this.disableTicks.wo().intValue());
            if (this.ahw.isEmpty() && !BlinkComponent.bh()) {
                this.ahz = true;
                super.setEnabled(false);
                this.ahz = false;
                return;
            }
        } else {
            this.qH++;
            if (this.qH >= this.interval.wo().intValue()) {
                this.qH = 0;
                this.N(1);
            }
        }

        this.ahx = BlinkComponent.bg();
    };
    @EventLink
    public final Listener<WorldChangeEvent> onWorldChange = var1 -> {
        this.ahw.clear();
        this.qH = 0;
        this.ahy = false;
        this.ahx = BlinkComponent.bg();
    };

    public WatchdogBlink() {
    }

    @Override
    public void setEnabled(boolean enabled) {
        if (!enabled && this.isEnabled() && !this.ahz) {
            if (this.ahy) {
                return;
            }

            if (!this.ahw.isEmpty() || BlinkComponent.bh()) {
                this.ahy = true;
                this.qH = 0;
                return;
            }
        }

        super.setEnabled(enabled);
    }

    @Override
    public void onEnable() {
        this.ahy = false;
        this.ahz = false;
        this.ahw.clear();
        this.ahx = BlinkComponent.bg();
        this.qH = 0;
    }

    @Override
    public void onDisable() {
        this.ahy = false;
        this.ahz = false;
        this.ahw.clear();
        this.qH = 0;
        BlinkComponent.dispatch();
    }

    private void N(int var1) {
        for (int i = 0; i < var1; i++) {
            Integer integer = this.ahw.poll();
            if (integer == null) {
                break;
            }

            if (integer > 0) {
                this.d(integer);
            }
        }
    }

    private void d(int var1) {
        BlinkComponent.d(var1);
    }
}
