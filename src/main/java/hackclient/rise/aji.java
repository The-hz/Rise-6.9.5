package hackclient.rise;

import com.alan.clients.util.shader.base.RiseShaderProgram;
import com.alan.clients.util.shader.base.ShaderUniforms;
import java.util.List;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.shader.Framebuffer;
import org.lwjgl.opengl.Display;

public class aji extends aix {
    private final RiseShaderProgram aQj = new RiseShaderProgram("outline.frag", "vertex.vsh");
    private Framebuffer aPV = new Framebuffer(aEg.displayWidth, aEg.displayHeight, true);

    public aji() {
    }

    @Override
    public void a(aiz var1, float var2, List<Runnable> var3) {
        if (Display.isVisible()) {
            switch (ajj.aQk[var1.ordinal()]) {
                case 1:
                    this.update();
                    this.setActive(!var3.isEmpty());
                    if (this.isActive()) {
                        RendererLivingEntity.bWd = 0.0F;
                        RendererLivingEntity.bWe = 0.0F;
                        this.aPV.bindFramebuffer(true);
                        var3.forEach(Runnable::run);
                        aEg.getFramebuffer().bindFramebuffer(true);
                        RendererLivingEntity.bWd = 64.0F;
                        RendererLivingEntity.bWe = 32.0F;
                        RenderHelper.disableStandardItemLighting();
                        aEg.entityRenderer.IU();
                    }
                    break;
                case 2:
                    this.setActive(this.isActive() || !var3.isEmpty());
                    if (this.isActive()) {
                        this.aPV.bindFramebuffer(true);
                        var3.forEach(Runnable::run);
                        int i = this.aQj.getProgramId();
                        aEg.getFramebuffer().bindFramebuffer(true);
                        this.aQj.rt();
                        ShaderUniforms.uniform1i(i, "u_texture", 0);
                        ShaderUniforms.uniform1f(i, "u_radius", 1.0F);
                        ShaderUniforms.uniform2f(i, "u_texel_size", 1.0F / aEg.displayWidth, 1.0F / aEg.displayHeight);
                        GlStateManager.enableBlend();
                        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                        GlStateManager.alphaFunc(516, 0.0F);
                        this.aPV.bindFramebufferTexture();
                        RiseShaderProgram.vN();
                        GlStateManager.disableBlend();
                        RiseShaderProgram.stop();
                    }
            }
        }
    }

    @Override
    public void update() {
        this.setActive(false);
        if (aEg.displayWidth == this.aPV.framebufferWidth && aEg.displayHeight == this.aPV.framebufferHeight) {
            this.aPV.framebufferClear();
        } else {
            this.aPV.deleteFramebuffer();
            this.aPV = new Framebuffer(aEg.displayWidth, aEg.displayHeight, true);
        }
    }
}
