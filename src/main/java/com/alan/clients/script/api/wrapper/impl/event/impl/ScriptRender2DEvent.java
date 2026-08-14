package com.alan.clients.script.api.wrapper.impl.event.impl;

import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.script.api.wrapper.impl.event.ScriptEvent;

public class ScriptRender2DEvent extends ScriptEvent<Render2DEvent> {
    public ScriptRender2DEvent(Render2DEvent var1) {
        super(var1);
    }

    public float getPartialTicks() {
        return this.wrapped.getPartialTicks();
    }

    public int getScaledWidth() {
        return this.wrapped.dx().getScaledWidth();
    }

    public int getScaledHeight() {
        return this.wrapped.dx().getScaledHeight();
    }

    public int getScaleFactor() {
        return this.wrapped.dx().getScaleFactor();
    }

    @Override
    public String getHandlerName() {
        return "onRender2D";
    }
}
