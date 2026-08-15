package com.alan.clients.module.impl.render.targetinfo;

import com.alan.clients.module.impl.player.HealthBypass;
import com.alan.clients.module.impl.render.TargetInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.value.Mode;
import com.alan.clients.util.math.MathUtil;
import hackclient.rise.aip;
import hackclient.rise.bf;
import hackclient.rise.gg;
import java.awt.Color;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public final class NovolineTargetInfo extends Mode<TargetInfo> {
    private TargetInfo ava;
    private final Animation avb = new Animation(Easing.EASE_OUT_SINE, 500L);
    private final Animation avc = new Animation(Easing.EASE_IN_OUT_SINE, 300L);
    private Entity avd = null;
    private double ave = 0.0;
    @EventLink
    private final Listener<Render2DEvent> onRender2D = var1x -> {
        if (this.ava == null) {
            this.ava = this.e(TargetInfo.class);
        }

        Entity entity = this.ava.target;
        boolean flag = !this.ava.inWorld || this.ava.rG.T(1000L);
        if (entity == null || flag) {
            this.avb.reset();
            this.avc.reset();
            this.avd = null;
            return;
        }

        double d0 = this.ava.position.x;
        double d1 = this.ava.position.y;
        AbstractClientPlayer abstractclientplayer = (AbstractClientPlayer)entity;
        HealthBypass healthbypass = this.e(HealthBypass.class);
        float f = healthbypass != null && healthbypass.isEnabled()
            ? HealthBypass.B(abstractclientplayer)
            : abstractclientplayer.getHealth();
        double d2 = Math.min(!this.ava.inWorld ? 0.0 : MathUtil.round(f, 1), abstractclientplayer.getMaxHealth());
        double d3 = abstractclientplayer.getMaxHealth();
        double d4 = d2 / d3 * 100.0;
        String s = entity.getName();
        String s1 = bf.c(s, s);
        double d5 = aEg.fontRendererObj.getStringWidth(s1);
        double d6 = 74.0;
        double d7 = d6 + d5;
        if (this.avd != entity) {
            this.avc.reset();
            this.avc.T(this.ave);
            this.avc.Q(d7);
            this.avd = entity;
        } else {
            this.avc.Q(d7);
        }

        double d8 = this.avc.sG();
        double d9 = 42.0;
        RenderUtil.d(d0, d1, d8, d9, new Color(40, 40, 40, 255));
        aEg.fontRendererObj.b(s1, d0 + 44.0, d1 + 10.0, Color.WHITE.getRGB());
        double d10 = 26.0 + d5;
        RenderUtil.d(d0 + 44.0, d1 + 22.0, d10, 11.0, new Color(21, 21, 21, 150));
        double d11 = d10 * (d2 / d3);
        this.avb.Q(d11);
        double d12 = this.avb.sG();
        RenderUtil.d(d0 + 44.0, d1 + 22.0, d12, 11.0, aip.a(this.rz().rB(), 0.5F));
        double d13 = d11;
        RenderUtil.d(d0 + 44.0, d1 + 22.0, d13, 11.0, this.rz().rA());
        String s2 = String.format("%.1f%%", d4);
        double d14 = aEg.fontRendererObj.getStringWidth(s2);
        aEg.fontRendererObj.b(s2, d0 + 44.0 + d10 / 2.0 - d14 / 2.0, d1 + 24.5, Color.WHITE.getRGB());
        if (this.nF()) {
            this.b(gg.BLOOM).c(() -> {
                RenderUtil.d(d0 + 44.0, d1 + 22.0, d13, 11.0, this.rz().rA());
                RenderUtil.d(d0 + 44.0, d1 + 22.0, d12, 11.0, aip.a(this.rz().rB(), 0.5F));
            });
        }

        if (entity instanceof AbstractClientPlayer) {
            this.a(abstractclientplayer, d0 + 1.0, d1 + 1.0, 40.0);
        }

        this.ave = d8;
    };

    public NovolineTargetInfo(String var1, TargetInfo var2) {
        super(var1, var2);
    }

    private void a(AbstractClientPlayer var1, double var2, double var4, double var6) {
        if (this.ava == null) {
            this.ava = this.e(TargetInfo.class);
        }

        Entity entity = this.ava.target;
        boolean flag = !this.ava.inWorld || this.ava.rG.T(1000L);
        if (entity == null || flag) {
            return;
        }

        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
        GlStateManager.alphaFunc(516, 0.0F);
        GlStateManager.enableTexture2D();
        HealthBypass healthbypass = this.e(HealthBypass.class);
        float f = healthbypass != null && healthbypass.isEnabled() ? HealthBypass.B(var1) : var1.getHealth();
        ResourceLocation resourcelocation = this.ava.inWorld && f > 0.0F ? var1.getLocationSkin() : RenderSkeleton.getEntityTexture();
        aEg.getTextureManager().bindTexture(resourcelocation);
        Gui.drawScaledCustomSizeModalRect((int)var2, (int)var4, 8.0F, 8.0F, 8.0F, 8.0F, (int)var6, (int)var6, 64.0F, 64.0F);
        Gui.drawScaledCustomSizeModalRect((int)var2, (int)var4, 40.0F, 8.0F, 8.0F, 8.0F, (int)var6, (int)var6, 64.0F, 64.0F);
        GlStateManager.disableBlend();
    }

    private Color nE() {
        return this.rz().rA();
    }

    private boolean nF() {
        return true;
    }
}
