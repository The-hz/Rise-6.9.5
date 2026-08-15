package com.alan.clients.module.impl.render;

import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.render.ViewBobbingEvent;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.SubMode;

@ModuleInfo(aliases = "module.render.viewbobbing.name", description = "module.render.viewbobbing.description", category = Category.RENDER)
public final class ViewBobbing extends Module {
    public final ModeValue viewBobbingMode = new ModeValue("Mode", this)
        .add(new SubMode("Smooth"))
        .add(new SubMode("Meme"))
        .add(new SubMode("None"))
        .setDefault("None");
    @EventLink
    public final Listener<ViewBobbingEvent> onViewBobbing = var1 -> {
        if (this.viewBobbingMode.wo().getName().equals("Smooth") && (var1.getTime() == 0 || var1.getTime() == 2)) {
            var1.setCancelled();
        }
    };
    @EventLink
    public final Listener<PreMotionEvent> onPreMotionEvent = var1 -> {
        label22: {
            aEg.gameSettings.cfG = true;
            String s = this.viewBobbingMode.wo().getName();
            byte b0 = -1;
            switch (s.hashCode()) {
                case 2394448:
                    if (s.equals("Meme")) {
                        b0 = 0;
                    }
                    break;
                case 2433880:
                    if (s.equals("None")) {
                        boolean flag = true;
                        break label22;
                    }
            }

            switch (b0) {
                case 0:
                    aEg.thePlayer.cameraYaw = 0.5F;
                    return;
                case 1:
                    break;
                default:
                    return;
            }
        }

        aEg.thePlayer.distanceWalkedModified = 0.0F;
    };

    public ViewBobbing() {
    }
}
