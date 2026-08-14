package hackclient.rise;

import java.awt.Color;
import net.minecraft.client.renderer.GlStateManager;

public class ajn {
    private final aiy aQo = new aiy("roq.glsl", "vertex.vsh");

    public ajn() {
    }

    public void a(float var1, float var2, float var3, float var4, float var5, float var6, Color var7) {
        int i = this.aQo.vO();
        this.aQo.rt();
        aja.a(i, "u_size", var3, var4);
        aja.a(i, "u_radius", var5);
        aja.a(i, "u_border_size", var6);
        aja.a(i, "u_color", var7.getRed() / 255.0F, var7.getGreen() / 255.0F, var7.getBlue() / 255.0F, var7.getAlpha() / 255.0F);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
        aiy.h(var1, var2, var3, var4);
        GlStateManager.disableBlend();
        aiy.stop();
    }

    public void b(double var1, double var3, double var5, double var7, double var9, double var11, Color var13) {
        this.a((float)var1, (float)var3, (float)var5, (float)var7, (float)var9, (float)var11, var13);
    }
}
