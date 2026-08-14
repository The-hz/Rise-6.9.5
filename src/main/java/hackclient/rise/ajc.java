package hackclient.rise;

import java.util.List;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.shader.Framebuffer;
import org.lwjgl.opengl.Display;

public class ajc extends aix {
    private final aiy aPW = new aiy("baw.frag", "vertex.vsh");
    private Framebuffer aPX = new Framebuffer(aEg.displayWidth, aEg.displayHeight, true);

    public ajc() {
    }

    @Override
    public void a(aiz var1, float var2, List<Runnable> var3) {
        if (Display.isVisible()) {
            if (var1 == aiz.OVERLAY) {
                this.ju();
                this.aPW.vO();
                new ScaledResolution(aEg);
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(770, 771);
                GlStateManager.disableAlpha();
                aEg.getFramebuffer().bindFramebuffer(true);
                this.aPW.rt();
                aiy.vN();
                aiy.stop();
            }
        }
    }

    @Override
    public void ju() {
        this.c(true);
        if (aEg.displayWidth == this.aPX.framebufferWidth && aEg.displayHeight == this.aPX.framebufferHeight) {
            this.aPX.framebufferClear();
        } else {
            this.aPX.deleteFramebuffer();
            this.aPX = new Framebuffer(aEg.displayWidth, aEg.displayHeight, true);
        }
    }
}
