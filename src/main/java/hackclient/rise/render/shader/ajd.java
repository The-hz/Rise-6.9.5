package hackclient.rise.render.shader;

import com.alan.clients.module.impl.render.Interface;
import com.alan.clients.util.shader.base.RiseShaderProgram;
import com.alan.clients.util.shader.base.ShaderUniforms;
import hackclient.rise.aix;
import hackclient.rise.aiz;
import hackclient.rise.ajq;
import java.nio.FloatBuffer;
import java.util.List;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.shader.Framebuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL13;

public class ajd extends aix {
    private final RiseShaderProgram aPY = new RiseShaderProgram("bloom.frag", "vertex.vsh");
    private Framebuffer aPV = new Framebuffer(aEg.displayWidth, aEg.displayHeight, true);
    private Framebuffer aPZ = new Framebuffer(aEg.displayWidth, aEg.displayHeight, true);
    private ajq aQa = new ajq(0);
    private Interface amf;

    public ajd() {
    }

    @Override
    public void a(aiz var1, float var2, List<Runnable> var3) {
        if (Display.isVisible()) {
            boolean flag = System.getProperty("os.name").toLowerCase().contains("mac");
            switch (aje.aQb[var1.ordinal()]) {
                case 1:
                    RendererLivingEntity.bWd = 0.0F;
                    RendererLivingEntity.bWe = 0.0F;
                    this.aPV.bindFramebuffer(true);

                    for (Runnable runnable : var3) {
                        runnable.run();
                    }

                    aEg.getFramebuffer().bindFramebuffer(true);
                    RendererLivingEntity.bWd = 64.0F;
                    RendererLivingEntity.bWe = 32.0F;
                    RenderHelper.disableStandardItemLighting();
                    aEg.entityRenderer.IU();
                    break;
                case 2:
                    this.aPV.bindFramebuffer(true);

                    for (Runnable runnable1 : var3) {
                        runnable1.run();
                    }

                    if (this.amf == null) {
                        this.amf = this.e(Interface.class);
                    }

                    int i = this.amf != null ? this.amf.lA() : 14;
                    float f = this.amf != null ? this.amf.lB() : 2.0F;
                    int j = this.aPY.getProgramId();
                    this.aPZ.bindFramebuffer(true);
                    this.aPY.rt();
                    if (this.aQa.getSize() != i) {
                        this.aQa = new ajq(i);
                        this.aQa.uR();
                        FloatBuffer floatbuffer = BufferUtils.createFloatBuffer(i);
                        floatbuffer.put(this.aQa.vS());
                        floatbuffer.flip();
                        ShaderUniforms.uniform1f(j, "u_radius", (float)i);
                        ShaderUniforms.uniformFB(j, "u_kernel", floatbuffer);
                        ShaderUniforms.uniform1i(j, "u_diffuse_sampler", 0);
                        ShaderUniforms.uniform1i(j, "u_other_sampler", flag ? 3 : 16);
                    }

                    ShaderUniforms.uniform2f(j, "u_texel_size", 1.0F / aEg.displayWidth, 1.0F / aEg.displayHeight);
                    ShaderUniforms.uniform2f(j, "u_direction", f, 0.0F);
                    GlStateManager.enableBlend();
                    GlStateManager.blendFunc(1, 770);
                    GlStateManager.alphaFunc(516, 0.0F);
                    this.aPV.bindFramebufferTexture();
                    RiseShaderProgram.vN();
                    aEg.getFramebuffer().bindFramebuffer(true);
                    GlStateManager.blendFunc(770, 771);
                    ShaderUniforms.uniform2f(j, "u_direction", 0.0F, f);
                    this.aPZ.bindFramebufferTexture();
                    GL13.glActiveTexture(flag ? 33987 : 34000);
                    this.aPV.bindFramebufferTexture();
                    GL13.glActiveTexture(33984);
                    RiseShaderProgram.vN();
                    GlStateManager.disableBlend();
                    RiseShaderProgram.stop();
            }
        }
    }

    @Override
    public void update() {
        int i = aEg.displayWidth;
        int j = aEg.displayHeight;
        if (this.aPV.ah(i, j)) {
            this.aPV.deleteFramebuffer();
            this.aPV = new Framebuffer(aEg.displayWidth, aEg.displayHeight, true);
        } else {
            this.aPV.framebufferClear();
        }

        if (this.aPZ.ah(i, j)) {
            this.aPZ.deleteFramebuffer();
            this.aPZ = new Framebuffer(aEg.displayWidth, aEg.displayHeight, true);
        } else {
            this.aPZ.framebufferClear();
        }

        this.aPV.setFramebufferColor(0.0F, 0.0F, 0.0F, 0.0F);
        this.aPZ.setFramebufferColor(0.0F, 0.0F, 0.0F, 0.0F);
    }
}
