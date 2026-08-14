package com.alan.clients.module.impl.ghost.autoclicker;

import com.alan.clients.module.impl.ghost.AutoClicker;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.other.TickEvent;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BoundsNumberValue;
import hackclient.rise.aih;

public class DragClickSimulationsAutoClicker extends Mode<AutoClicker> {
    private final BoundsNumberValue Cf = new BoundsNumberValue("Drag Click Length", this, 17, 18, 1, 50, 1);
    private final BoundsNumberValue Cg = new BoundsNumberValue("Delay Between Dragging", this, 6, 6, 1, 20, 1);
    private int Ch;
    private int Ci;
    @EventLink
    public final Listener<TickEvent> Cj = var1x -> {
        if (aEg.gameSettings.cgK.isKeyDown()) {
            if (this.Ch < 0) {
                this.Ci--;
                if (this.Ci < 0) {
                    this.Ci = this.Cg.wv().intValue();
                    this.Ch = this.Cf.wv().intValue();
                }
            } else if (Math.random() < 0.95) {
                this.Ch--;
                aih.h(0, true);
            }
        }
    };

    public DragClickSimulationsAutoClicker(String var1, AutoClicker var2) {
        super(var1, var2);
    }
}
