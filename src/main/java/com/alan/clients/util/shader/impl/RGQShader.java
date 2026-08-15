package com.alan.clients.util.shader.impl;

import com.alan.clients.util.shader.base.RiseShaderProgram;
import com.alan.clients.util.shader.base.ShaderUniforms;
import java.awt.Color;
import net.minecraft.client.renderer.GlStateManager;

public class RGQShader {
    private final RiseShaderProgram aQl = new RiseShaderProgram("rgq.glsl", "vertex.vsh");

    public RGQShader() {
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
        int i = this.aQl.getProgramId();
        this.aQl.rt();
        ShaderUniforms.uniform2f(i, "u_size", var3, var4);
        ShaderUniforms.uniform1f(i, "u_radius", var5);
        ShaderUniforms.uniform4f(i, "u_first_color", var6.getRed() / 255.0F, var6.getGreen() / 255.0F, var6.getBlue() / 255.0F, var6.getAlpha() / 255.0F);
        ShaderUniforms.uniform4f(i, "u_second_color", var7.getRed() / 255.0F, var7.getGreen() / 255.0F, var7.getBlue() / 255.0F, var7.getAlpha() / 255.0F);
        ShaderUniforms.uniform4f(i, "u_edges", var9 ? 1.0F : 0.0F, var10 ? 1.0F : 0.0F, var11 ? 1.0F : 0.0F, var12 ? 1.0F : 0.0F);
        ShaderUniforms.uniform1i(i, "u_direction", var8 ? 1 : 0);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
        RiseShaderProgram.h(var1, var2, var3, var4);
        GlStateManager.disableBlend();
        RiseShaderProgram.stop();
    }

    public void c(
        double var1,
        double var3,
        double var5,
        double var7,
        double var9,
        Color var11,
        Color var12,
        boolean var13,
        boolean var14,
        boolean var15,
        boolean var16,
        boolean var17
    ) {
        this.a((float)var1, (float)var3, (float)var5, (float)var7, (float)var9, var11, var12, var13, var14, var15, var16, var17);
    }

    public void draw(double var1, double var3, double var5, double var7, double var9, Color var11, Color var12, boolean var13) {
        this.a((float)var1, (float)var3, (float)var5, (float)var7, (float)var9, var11, var12, var13, true, true, true, true);
    }
}
