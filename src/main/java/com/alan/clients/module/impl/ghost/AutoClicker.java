package com.alan.clients.module.impl.ghost;

import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.module.impl.ghost.autoclicker.DragClickSimulationsAutoClicker;
import com.alan.clients.module.impl.ghost.autoclicker.NormalAutoClicker;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.ClickEvent;
import com.alan.clients.newevent.impl.render.Render3DEvent;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.ModeValue;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import rip.vantage.commons.util.time.a;

@ModuleInfo(aliases = "module.ghost.autoclicker.name", description = "module.ghost.autoclicker.description", category = Category.GHOST)
public class AutoClicker extends Module {
    private final ModeValue mode = new ModeValue("Mode", this)
        .add(new NormalAutoClicker("Normal", this))
        .add(new DragClickSimulationsAutoClicker("Drag Click Simulations", this))
        .setDefault("Normal");
    private final BooleanValue jitter = new BooleanValue("Jitter", this, false);
    private final a AI = new a();
    private double AJ;
    private double AK;
    @EventLink
    public final Listener<ClickEvent> AL = var1 -> {
        this.AI.aX();
        this.AJ = (Math.random() - 0.5) * 4.0;
        this.AK = (Math.random() - 0.5) * 4.0;
    };
    @EventLink
    public final Listener<Render3DEvent> AM = var1 -> {
        aEg.leftClickCounter = -1;
        if (!this.AI.T(100L) && this.jitter.wo() && aEg.gameSettings.cgK.isKeyDown()) {
            EntityRenderer.bIp = (float)((Math.random() - 0.5) * 400.0 / Minecraft.getDebugFPS() * this.AJ);
            EntityRenderer.bIq = (float)((Math.random() - 0.5) * 400.0 / Minecraft.getDebugFPS() * this.AK);
        }
    };

    public AutoClicker() {
    }
}
