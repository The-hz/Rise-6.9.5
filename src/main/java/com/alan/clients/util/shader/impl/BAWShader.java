package com.alan.clients.util.shader.impl;

import hackclient.rise.aix;
import com.alan.clients.util.shader.base.RiseShaderProgram;
import hackclient.rise.aiz;
import java.util.List;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.shader.Framebuffer;
import org.lwjgl.opengl.Display;

public class BAWShader extends aix {
    private final RiseShaderProgram aPW = new RiseShaderProgram("baw.frag", "vertex.vsh");
    private Framebuffer aPX = new Framebuffer(aEg.displayWidth, aEg.displayHeight, true);

    public BAWShader() {
    }

    @Override
    public void a(aiz var1, float var2, List<Runnable> runnables) {
        if (Display.isVisible()) {
            if (var1 == aiz.OVERLAY) {
                this.update();
                this.aPW.getProgramId();
                new ScaledResolution(aEg);
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(770, 771);
                GlStateManager.disableAlpha();
                aEg.getFramebuffer().bindFramebuffer(true);
                this.aPW.rt();
                RiseShaderProgram.vN();
                RiseShaderProgram.stop();
            }
        }
    }

    @Override
    public void update() {
        this.setActive(true);
        if (aEg.displayWidth == this.aPX.framebufferWidth && aEg.displayHeight == this.aPX.framebufferHeight) {
            this.aPX.framebufferClear();
        } else {
            this.aPX.deleteFramebuffer();
            this.aPX = new Framebuffer(aEg.displayWidth, aEg.displayHeight, true);
        }
    }
}
