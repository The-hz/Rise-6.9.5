package com.alan.clients.ui.click.standard.components.category;

import com.alan.clients.Client;
import com.alan.clients.module.api.Category;
import com.alan.clients.ui.click.standard.RiseClickGUI;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.ui.click.standard.screen.Screen;
import com.alan.clients.util.gui.GUIUtil;
import hackclient.rise.ahd;
import com.alan.clients.util.render.ColorUtil;
import com.alan.clients.util.font.FontManager;
import hackclient.rise.gd;
import java.awt.Color;
import net.minecraft.client.renderer.GlStateManager;

public final class CategoryComponent implements InstanceAccess {
    private final Animation animation = new Animation(Easing.LINEAR, 500L);
    public final Category category;
    private long lastTime = 0L;
    private double selectorOpacity;
    private float x;
    private float y;
    private boolean down;

    public CategoryComponent(Category category) {
        this.category = category;
    }

    public void a(double var1, double var3, double var5, Screen screen) {
        RiseClickGUI riseclickgui = Client.a.v();
        if (System.currentTimeMillis() - this.lastTime > 300L) {
            this.lastTime = System.currentTimeMillis();
        }

        long now = System.currentTimeMillis();
        this.x = (float)(riseclickgui.axI.x - (69.0 - var3) - 21.0);
        this.y = (float)(riseclickgui.axI.y + var1) + 16.0F;
        this.animation.h(200L);
        this.animation.Q(screen.equals(this.category.ec()) ? 255.0 : 0.0);
        double d0 = FontManager.MAIN.a(16, gd.REGULAR).getStringWidth(ahd.ce(this.category.getName())) + 8.0 + this.category.eb().getStringWidth(this.category.ea());
        GlStateManager.pushMatrix();
        RenderUtil.roundedRectangle(
            this.x, this.y - 5.5, d0 + 8.0, 15.0, 5.0, ColorUtil.d(this.rz().getAccentColor(new Vector2d(0.0, this.y / 5.0)), (int)Math.min(this.animation.sG(), var5)).darker()
        );
        int j = new Color(255, 255, 255, Math.min(screen.equals(this.category.ec()) ? 255 : 200, (int)var5)).hashCode();
        this.category.eb().a(this.category.ea(), (float)(this.x + this.animation.sG() / 80.0 + 3.0), this.y, j);
        FontManager.MAIN
            .a(16, gd.REGULAR)
            .a(ahd.ce(this.category.getName()), (float)(this.x + this.animation.sG() / 80.0 + 3.0 + 4.0) + FontManager.ICONS_1.o(17).getStringWidth(this.category.ea()), this.y, j);
        GlStateManager.popMatrix();
        this.lastTime = now;
    }

    public void click(float var1, float var2, int var3) {
        boolean flag = var3 == 0;
        if (GUIUtil.c(this.x - 11.0F, this.y - 5.0F, 70.0, 22.0, var1, var2) && flag) {
            this.getStandardClickGUI().switchScreen(this.category);
            this.down = true;
        }
    }

    public void bloom(double var1) {
        double d0 = FontManager.MAIN.a(16, gd.REGULAR).getStringWidth(ahd.ce(this.category.getName())) + 8.0 + this.category.eb().getStringWidth(this.category.ea());
        RenderUtil.roundedRectangle(
            this.x, this.y - 5.0F, d0 + 8.0, 14.0, 5.0, ColorUtil.d(this.rz().getAccentColor(new Vector2d(0.0, this.y / 5.0)), (int)Math.min(this.animation.sG(), var1)).darker()
        );
    }

    public void release() {
        this.down = false;
    }
}
