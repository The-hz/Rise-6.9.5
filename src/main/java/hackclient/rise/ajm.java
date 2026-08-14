package hackclient.rise;

import java.awt.Color;
import net.minecraft.client.renderer.GlStateManager;

public class ajm {
    private final aiy aQn = new aiy("rogq.frag", "vertex.vsh");

    public ajm() {
    }

    public void a(float var1, float var2, float var3, float var4, float var5, float var6, Color var7, Color var8) {
        int i = this.aQn.vO();
        this.aQn.rt();
        aja.a(i, "u_size", var3, var4);
        aja.a(i, "u_radius", var5);
        aja.a(i, "u_border_size", var6);
        aja.a(i, "u_color_1", var7.getRed() / 255.0F, var7.getGreen() / 255.0F, var7.getBlue() / 255.0F, var7.getAlpha() / 255.0F);
        aja.a(i, "u_color_2", var8.getRed() / 255.0F, var8.getGreen() / 255.0F, var8.getBlue() / 255.0F, var8.getAlpha() / 255.0F);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
        aiy.h(var1, var2, var3, var4);
        GlStateManager.disableBlend();
        aiy.stop();
    }

    public void b(double var1, double var3, double var5, double var7, double var9, double var11, Color var13, Color var14) {
        this.a((float)var1, (float)var3, (float)var5, (float)var7, (float)var9, (float)var11, var13, var14);
    }
}
