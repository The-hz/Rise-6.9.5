package hackclient.rise;

import java.util.List;
import lombok.Generated;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.shader.Framebuffer;
import org.lwjgl.opengl.Display;

public class ajb extends aix {
    private final aiy aPU = new aiy("alpha.frag", "vertex.vsh");
    private Framebuffer aPV = new Framebuffer(aEg.displayWidth, aEg.displayHeight, true);
    private float aoJ;

    public ajb() {
    }

    @Override
    public void a(aiz var1, float var2, List<Runnable> var3) {
        if (Display.isVisible()) {
            if (var1 == aiz.OVERLAY) {
                this.ju();
                this.c(true);
                if (this.bd()) {
                    this.aPV.bindFramebuffer(true);
                    var3.forEach(Runnable::run);
                    aEg.getFramebuffer().bindFramebuffer(true);
                    int i = this.aPU.vO();
                    this.aPU.rt();
                    aja.a(i, "u_diffuse_sampler", 0);
                    aja.a(i, "u_alpha", this.aoJ);
                    GlStateManager.enableBlend();
                    GlStateManager.blendFunc(770, 771);
                    GlStateManager.alphaFunc(516, 0.0F);
                    this.aPV.bindFramebufferTexture();
                    aiy.vN();
                    GlStateManager.disableBlend();
                    aiy.stop();
                }
            }
        }
    }

    @Override
    public void ju() {
        if (aEg.displayWidth == this.aPV.framebufferWidth && aEg.displayHeight == this.aPV.framebufferHeight) {
            this.aPV.framebufferClear();
        } else {
            this.aPV.deleteFramebuffer();
            this.aPV = new Framebuffer(aEg.displayWidth, aEg.displayHeight, true);
        }

        this.aPV.setFramebufferColor(0.0F, 0.0F, 0.0F, 0.0F);
    }

    @Generated
    public void p(float var1) {
        this.aoJ = var1;
    }
}
