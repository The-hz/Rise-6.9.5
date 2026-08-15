package com.alan.clients.util.font.impl.rise;

import lombok.Generated;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

public class FontCharacter {
    private final int aIt;
    private final float aIu;
    private final float aIv;

    public void e(float var1, float var2) {
        GlStateManager.bindTexture(this.aIt);
        GL11.glBegin(7);
        GL11.glTexCoord2f(0.0F, 0.0F);
        GL11.glVertex2f(var1, var2);
        GL11.glTexCoord2f(0.0F, 1.0F);
        GL11.glVertex2f(var1, var2 + this.aIv);
        GL11.glTexCoord2f(1.0F, 1.0F);
        GL11.glVertex2f(var1 + this.aIu, var2 + this.aIv);
        GL11.glTexCoord2f(1.0F, 0.0F);
        GL11.glVertex2f(var1 + this.aIu, var2);
        GL11.glEnd();
    }

    @Generated
    public int tx() {
        return this.aIt;
    }

    @Generated
    public float ty() {
        return this.aIu;
    }

    @Generated
    public float getHeight() {
        return this.aIv;
    }

    @Generated
    public FontCharacter(int var1, float var2, float var3) {
        this.aIt = var1;
        this.aIu = var2;
        this.aIv = var3;
    }
}
