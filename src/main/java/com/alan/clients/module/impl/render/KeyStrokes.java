package com.alan.clients.module.impl.render;

import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.DragValue;
import hackclient.rise.gg;
import hackclient.rise.xn;
import com.alan.clients.module.impl.render.keystrokes.KeyStroke;
import java.util.ArrayList;

@ModuleInfo(aliases = "module.render.keystrokes.name", description = "module.render.keystrokes.description", category = Category.RENDER)
public final class KeyStrokes extends Module {
    private final DragValue position = new DragValue("Position", this, new Vector2d(100.0, 100.0), false);
    public final BooleanValue space = new BooleanValue("Space", this, true);
    private boolean lastSpace;
    private final int gap = 3;
    private ArrayList<KeyStroke> keyStrokes = new ArrayList<>();
    @EventLink
    public final Listener<Render2DEvent> onRender2D = var1 -> {
        if (aEg.currentScreen != null) {
            if (this.lastSpace != this.space.wo()) {
                this.keyStrokes = new xn(this);
            }

            this.lastSpace = this.space.wo();
        }

        this.position.n(new Vector2d(72.0, 72.0));
        this.b(gg.REGULAR).c(() -> this.keyStrokes.forEach(var1x -> var1x.c(this.position.apP)));
        this.b(gg.BLUR).c(() -> this.keyStrokes.forEach(var1x -> var1x.d(this.position.apP)));
        this.b(gg.BLOOM).c(() -> this.keyStrokes.forEach(var1x -> var1x.e(this.position.apP)));
    };

    public KeyStrokes() {
    }
}
