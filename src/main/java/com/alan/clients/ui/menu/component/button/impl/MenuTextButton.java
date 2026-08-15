package com.alan.clients.ui.menu.component.button.impl;

import com.alan.clients.ui.menu.component.button.MenuButton;
import com.alan.clients.util.render.RenderUtil;
import hackclient.rise.agc;
import com.alan.clients.util.render.ColorUtil;
import com.alan.clients.util.font.FontManager;
import hackclient.rise.gd;
import hackclient.rise.gg;
import java.awt.Color;
import lombok.Generated;

public class MenuTextButton extends MenuButton {
    private agc lq = FontManager.MAIN.a(24, gd.BOLD);
    public String name;
    private float aCh = 5.0F;
    private int aCi = 32;

    public MenuTextButton(double var1, double var3, double var5, double var7, Runnable var9, String var10) {
        super(var1, var3, var5, var7, var9);
        this.name = var10;
    }

    @Override
    public void draw(int var1, int var2, float var3) {
        super.draw(var1, var2, var3);
        double d0 = this.getY();
        Color color = ColorUtil.d(Color.BLACK, 150);
        Color color1 = ColorUtil.d(aBT, (int)(150.0 + this.oL().sG()));
        this.b(gg.BLUR).c(() -> RenderUtil.roundedRectangle(this.getX(), this.getY(), this.oM(), this.da(), this.aCh, Color.WHITE));
        this.b(gg.BLOOM).c(() -> RenderUtil.roundedRectangle(this.getX() + 0.5, d0 + 0.5, this.oM() - 1.0, this.da() - 1.0, this.aCh + 1.0F, color));
        this.b(gg.REGULAR).c(() -> {
            RenderUtil.roundedRectangle(this.getX(), d0, this.oM(), this.da(), this.aCh, ColorUtil.d(aBV, (int)this.oL().sG() - 15));
            RenderUtil.roundedOutlineGradientRectangle(this.getX(), d0, this.oM(), this.da(), this.aCh, 1.0, ColorUtil.d(aBP, this.aCi), ColorUtil.d(aBO, this.aCi));
            this.lq.c(this.name, (float)(this.getX() + this.oM() / 2.0), (float)(d0 + this.da() / 2.0 - 4.0), color1.getRGB());
        });
    }

    @Generated
    public void c(agc var1) {
        this.lq = var1;
    }

    @Generated
    public void x(float var1) {
        this.aCh = var1;
    }

    @Generated
    public void ah(int var1) {
        this.aCi = var1;
    }
}
