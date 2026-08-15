package com.alan.clients.module.impl.ghost;

import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.value.impl.NumberValue;
import hackclient.rise.bb;

@ModuleInfo(aliases = "module.ghost.clickassist.name", description = "module.ghost.clickassist.description", category = Category.GHOST)
public class ClickAssist extends Module {
    public final NumberValue extraLeftClicks = new NumberValue("Extra Left Clicks", this, 1, 0, 3, 1);
    public final NumberValue extraRightClicks = new NumberValue("Extra Right Clicks", this, 1, 0, 3, 1);
    public int AP;
    public int AQ;
    private boolean AR;
    private boolean AS;
    @EventLink
    public final Listener<PreMotionEvent> onPreMotionEvent = var1 -> {
        if (aEg.gameSettings.cgK.isKeyDown()) {
            if (!this.AR) {
                this.AP = this.extraLeftClicks.wo().intValue();
            }

            this.AR = true;
        } else {
            this.AR = false;
        }

        if (aEg.gameSettings.cgI.isKeyDown()) {
            if (!this.AS) {
                this.AQ = this.extraRightClicks.wo().intValue();
            }

            this.AS = true;
        } else {
            this.AS = false;
        }

        if (this.AP > 0 && Math.random() > 0.2) {
            this.AP--;
            if (!aEg.thePlayer.isUsingItem() && !bb.aW()) {
                aEg.Ay();
            }
        } else if (this.AQ > 0 && Math.random() > 0.2) {
            this.AQ--;
            if (!aEg.thePlayer.isUsingItem() && !bb.aW()) {
                aEg.Az();
            }
        }
    };

    public ClickAssist() {
    }
}
