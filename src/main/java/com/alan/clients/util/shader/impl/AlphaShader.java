package com.alan.clients.util.shader.impl;

import hackclient.rise.aix;
import com.alan.clients.util.shader.base.RiseShaderProgram;
import hackclient.rise.aiz;
import com.alan.clients.util.shader.base.ShaderUniforms;
import java.util.List;
import lombok.Generated;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.shader.Framebuffer;
import org.lwjgl.opengl.Display;

public class AlphaShader extends aix {
    private final RiseShaderProgram aPU = new RiseShaderProgram("alpha.frag", "vertex.vsh");
    private Framebuffer aPV = new Framebuffer(aEg.displayWidth, aEg.displayHeight, true);
    private float aoJ;

    public AlphaShader() {
    }

    @Override
    public void a(aiz var1, float var2, List<Runnable> runnables) {
        if (Display.isVisible()) {
            if (var1 == aiz.OVERLAY) {
                this.update();
                this.setActive(true);
                if (this.isActive()) {
                    this.aPV.bindFramebuffer(true);
                    runnables.forEach(Runnable::run);
                    aEg.getFramebuffer().bindFramebuffer(true);
                    int i = this.aPU.getProgramId();
                    this.aPU.rt();
                    ShaderUniforms.uniform1i(i, "u_diffuse_sampler", 0);
                    ShaderUniforms.uniform1f(i, "u_alpha", this.aoJ);
                    GlStateManager.enableBlend();
                    GlStateManager.blendFunc(770, 771);
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
