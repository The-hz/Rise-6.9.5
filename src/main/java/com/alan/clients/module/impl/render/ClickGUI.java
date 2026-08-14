package com.alan.clients.module.impl.render;

import com.alan.clients.Client;
import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.SubMode;
import hackclient.rise.dt;
import hackclient.rise.gg;
import org.lwjgl.input.Keyboard;
import rip.vantage.commons.util.time.a;

@ModuleInfo(aliases = "module.render.clickgui.name", description = "module.render.clickgui.description", category = Category.RENDER, keyBind = 54)
public final class ClickGUI extends Module {
    private final a and = new a();
    public final ModeValue ane = new ModeValue("Mode", this).add(new SubMode("Modern")).add(new SubMode("Dropdown")).setDefault("Modern");
    @EventLink(cH = 3)
    public final Listener<Render2DEvent> anf = var1 -> {
        if (this.ane.wo().getName().equals("Modern")) {
            this.b(gg.REGULAR, 2).c(() -> Client.a.v().cj());
            this.b(gg.BLOOM, 3).c(() -> Client.a.v().ci());
        } else {
            this.b(gg.REGULAR, 2).c(() -> Client.a.z().cj());
            this.b(gg.BLOOM, 3).c(() -> Client.a.z().ci());
        }
    };
    @EventLink
    public final Listener<dt> ang = var1 -> {
        if (this.and.T(50L)) {
            if (var1.cO() == this.getKey()) {
                aEg.displayGuiScreen(null);
                if (aEg.currentScreen == null) {
                    aEg.Av();
                }
            }
        }
    };

    public ClickGUI() {
    }

    @Override
    public void onEnable() {
        if (this.ane.wo().getName().equals("Modern")) {
            aEg.displayGuiScreen(Client.a.v());
        } else {
            aEg.displayGuiScreen(Client.a.z());
        }

        this.and.aX();
    }

    @Override
    public void onDisable() {
        aEg.Av();
        Keyboard.enableRepeatEvents(false);
        Client.a.e().c(Client.a.v());
        Client.a.e().c(Client.a.z());
        aMR.execute(() -> Client.a.p().to().tf());
    }
}
