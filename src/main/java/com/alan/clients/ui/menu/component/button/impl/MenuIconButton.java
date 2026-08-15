package com.alan.clients.ui.menu.component.button.impl;

import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.ui.menu.component.button.MenuButton;
import com.alan.clients.util.render.ColorUtil;
import hackclient.rise.gg;
import java.awt.Color;
import net.minecraft.util.ResourceLocation;

public class MenuIconButton extends MenuButton {
    private final ResourceLocation resourceLocation;

    public MenuIconButton(double var1, double var3, double var5, double var7, Runnable var9, ResourceLocation var10) {
        super(var1, var3, var5, var7, var9);
        this.resourceLocation = var10;
    }

    @Override
    public void draw(int var1, int var2, float var3) {
        super.draw(var1, var2, var3);
        double d0 = this.getY();
        double d1 = d0 / this.getY();
        Color color = ColorUtil.d(Color.BLACK, (int)(d1 * 100.0));
        Color color1 = ColorUtil.d(Color.WHITE, (int)(d1 * (50.0 + this.oL().sG() * 2.0)));
        this.b(gg.BLUR).c(() -> RenderUtil.roundedRectangle(this.getX(), this.getY(), this.oM(), this.da(), 5.0, Color.WHITE));
        this.b(gg.BLOOM).c(() -> RenderUtil.roundedRectangle(this.getX() + 0.5, d0 + 0.5, this.oM() - 1.0, this.da() - 1.0, 6.0, color));
        this.b(gg.REGULAR).c(() -> {
            RenderUtil.roundedRectangle(this.getX(), d0, this.oM(), this.da(), 5.0, ColorUtil.d(Color.WHITE, (int)this.oL().sG() / 3));
            RenderUtil.roundedOutlineRectangle(this.getX(), d0, this.oM(), this.da(), 5.0, 0.5, ColorUtil.d(Color.WHITE, (int)this.oL().sG() / 3));
            RenderUtil.image(this.resourceLocation, this.getX() + this.oM() / 2.0 - 8.0, d0 + this.da() / 2.0 - 8.0, 16.0, 16.0, color1);
        });
    }
}
