package hackclient.rise;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;

public final class ajl {
    private final aiy aQm = new aiy("rgqtest.glsl", "vertex.vsh");

    public ajl() {
    }

    public void a(
        float var1,
        float var2,
        float var3,
        float var4,
        float var5,
        Color var6,
        Color var7,
        boolean var8,
        boolean var9,
        boolean var10,
        boolean var11,
        boolean var12
    ) {
        int i = this.aQm.vO();
        this.aQm.rt();
        aja.a(i, "u_size", var3, var4);
        aja.a(i, "u_radius", var5);
        aja.a(i, "u_first_color", var6.getRed() / 255.0F, var6.getGreen() / 255.0F, var6.getBlue() / 255.0F, var6.getAlpha() / 255.0F);
        aja.a(i, "u_second_color", var7.getRed() / 255.0F, var7.getGreen() / 255.0F, var7.getBlue() / 255.0F, var7.getAlpha() / 255.0F);
        aja.a(i, "u_direction", var8 ? 1 : 0);
        aja.a(i, "u_time", (float)(System.currentTimeMillis() - Minecraft.getMinecraft().Bx()) / 1000.0F);
        aja.a(i, "u_edges", var9 ? 1.0F : 0.0F, var10 ? 1.0F : 0.0F, var11 ? 1.0F : 0.0F, var12 ? 1.0F : 0.0F);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
        aiy.h(var1, var2, var3, var4);
        GlStateManager.disableBlend();
        aiy.stop();
    }

    public void c(double var1, double var3, double var5, double var7, double var9, Color var11, Color var12, boolean var13) {
        this.a((float)var1, (float)var3, (float)var5, (float)var7, (float)var9, var11, var12, var13, true, true, true, true);
    }
}
