package com.alan.clients.script.api.wrapper.impl;

import com.alan.clients.script.api.RenderAPI;
import hackclient.rise.agf;

public class ScriptRiseFontRenderer extends ScriptFontRenderer<agf> {
    public ScriptRiseFontRenderer(agf var1) {
        super(var1);
    }

    @Override
    public double width(String var1) {
        return this.wrapped.getStringWidth(var1);
    }

    @Override
    public double height() {
        return this.wrapped.tq();
    }

    @Override
    public void draw(String var1, double var2, double var4, int[] var6) {
        this.wrapped.a(var1, var2, var4, RenderAPI.intArrayToColor(var6).getRGB());
    }

    @Override
    public void drawCentered(String var1, double var2, double var4, int[] var6) {
        this.wrapped.c(var1, var2, var4, RenderAPI.intArrayToColor(var6).getRGB());
    }

    @Override
    public void drawWithShadow(String var1, double var2, double var4, int[] var6) {
        this.wrapped.b(var1, var2, var4, RenderAPI.intArrayToColor(var6).getRGB());
    }

    @Override
    public void drawCenteredWithShadow(String var1, float var2, float var3, int[] var4) {
        this.wrapped.a(var1, var2, var3, RenderAPI.intArrayToColor(var4).getRGB());
    }
}
