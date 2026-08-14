package hackclient.rise;

import java.awt.Color;
import net.minecraft.client.renderer.GlStateManager;

public class ajo {
    private final aiy aQp = new aiy("rq.frag", "vertex.vsh");

    public ajo() {
    }

    public void a(float var1, float var2, float var3, float var4, float var5, Color var6, boolean var7, boolean var8, boolean var9, boolean var10) {
        int i = this.aQp.vO();
        this.aQp.rt();
        aja.a(i, "u_size", var3, var4);
        aja.a(i, "u_radius", var5);
        aja.a(i, "u_color", var6.getRed() / 255.0F, var6.getGreen() / 255.0F, var6.getBlue() / 255.0F, var6.getAlpha() / 255.0F);
        aja.a(i, "u_edges", var7 ? 1.0F : 0.0F, var8 ? 1.0F : 0.0F, var9 ? 1.0F : 0.0F, var10 ? 1.0F : 0.0F);
        GlStateManager.enableBlend();
        aiy.h(var1, var2, var3, var4);
        GlStateManager.disableBlend();
        aiy.stop();
    }

    public void b(double var1, double var3, double var5, double var7, double var9, Color var11, boolean var12, boolean var13, boolean var14, boolean var15) {
        this.a((float)var1, (float)var3, (float)var5, (float)var7, (float)var9, var11, var12, var13, var14, var15);
    }

    public void d(double var1, double var3, double var5, double var7, double var9, Color var11) {
        this.a((float)var1, (float)var3, (float)var5, (float)var7, (float)var9, var11, true, true, true, true);
    }
}
