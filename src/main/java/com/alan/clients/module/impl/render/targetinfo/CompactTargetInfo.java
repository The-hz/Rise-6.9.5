package com.alan.clients.module.impl.render.targetinfo;

import com.alan.clients.component.impl.render.NotificationComponent;
import com.alan.clients.module.impl.player.HealthBypass;
import com.alan.clients.module.impl.render.Interface;
import com.alan.clients.module.impl.render.TargetInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.value.Mode;
import com.alan.clients.ui.theme.Themes;
import hackclient.rise.agc;
import com.alan.clients.util.math.MathUtil;
import hackclient.rise.aip;
import hackclient.rise.ais;
import hackclient.rise.bf;
import hackclient.rise.gb;
import hackclient.rise.gd;
import hackclient.rise.gg;
import java.awt.Color;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class CompactTargetInfo extends Mode<TargetInfo> {
    private final agc auT = gb.MAIN.a(18, gd.LIGHT);
    private TargetInfo aui;
    private final int auU = 6;
    private final int auV = 7;
    private final int auW = 4;
    private final Animation auXX = new Animation(Easing.EASE_OUT_ELASTIC, 500L);
    private final Animation auY = new Animation(Easing.EASE_OUT_SINE, 500L);
    @EventLink
    public final Listener<Render2DEvent> onRender2D = var1x -> {
        if (this.aui == null) {
            this.aui = this.e(TargetInfo.class);
        }

        this.b(gg.BLOOM).c(NotificationComponent::ci);
        this.b(gg.REGULAR, 1).c(NotificationComponent::cj);
        Entity entity = this.aui.target;
        if (entity != null) {
            boolean flag = !this.aui.inWorld || this.aui.rG.T(1000L);
            this.auXX.h(flag ? 400L : 850L);
            this.auXX.setEasing(flag ? Easing.EASE_IN_BACK : Easing.EASE_OUT_ELASTIC);
            this.auXX.Q(flag ? 0.0 : 1.0);
            if (!(this.auXX.sG() <= 0.0)) {
                String s = entity.getName();
                String s1 = bf.c(s, s);
                double d0 = this.aui.position.x;
                double d1 = this.aui.position.y;
                AbstractClientPlayer abstractclientplayer = (AbstractClientPlayer)entity;
                HealthBypass healthbypass = this.e(HealthBypass.class);
                float f = healthbypass != null && healthbypass.isEnabled() ? HealthBypass.B(abstractclientplayer) : abstractclientplayer.getHealth();
                double d2 = this.auT.getStringWidth(s1);
                double d3 = Math.min(!this.aui.inWorld ? 0.0 : MathUtil.round(f, 1), abstractclientplayer.getMaxHealth());
                double d4 = Math.max(d2 + 15.0, 70.0);
                this.auY.Q(d3 / abstractclientplayer.getMaxHealth() * d4);
                this.auY.setEasing(Easing.EASE_OUT_QUINT);
                this.auY.h(250L);
                double d5 = this.auY.sG();
                double d6 = (abstractclientplayer.hurtTime == 0 ? 0.0F : abstractclientplayer.hurtTime - aEg.timer.bWm) * 0.5;
                byte b0 = 35;
                double d7 = d6 / 2.0;
                double d8 = 47 + d4 + 4.0 + 6.0;
                double d9 = 47;
                this.aui.positionValue.n(new Vector2d(d8, d9));
                double d10 = this.auXX.sG();
                this.b(gg.REGULAR).c(() -> {
                    GlStateManager.pushMatrix();
                    GlStateManager.translate((d0 + d8 / 2.0) * (1.0 - d10), (d1 + d9 / 2.0) * (1.0 - d10), 0.0);
                    GlStateManager.scale(d10, d10, 0.0);
                    this.rz();
                    Color color = Themes.rK();
                    this.rz();
                    Themes.rK();
                    Color color1 = this.rz().rA();
                    Color color2 = this.rz().rB();
                    if (!this.e(Interface.class).aoc.wo()) {
                        RenderUtil.roundedRectangle(d0, d1, d8 - 3.5, d9 - 5.0, 8.0, color);
                    }

                    RenderUtil.roundedOutlineGradientRectangle(d0, d1, d8 - 3.5, d9 - 5.0, 8.0, 0.5, aip.d(this.rz().rA(), 200), aip.d(this.rz().rB(), 200));
                    GlStateManager.pushMatrix();
                    this.auT.b(s1, d0 + 6.0 + b0 + 7.0 - 2.5, d1 + 6.0 + 4.0 + 1.0, Color.WHITE.hashCode());
                    this.auT.c(String.valueOf(Math.round(f)), d0 + b0 + d4 + 4.5, d1 + 6.0 + 4.0 + 1.0, color2.hashCode());
                    GlStateManager.popMatrix();
                    GlStateManager.popMatrix();
                    GlStateManager.pushMatrix();
                    GlStateManager.translate((d0 + d8 / 2.0) * (1.0 - d10), (d1 + d9 / 2.0) * (1.0 - d10), 0.0);
                    GlStateManager.scale(d10, d10, 0.0);
                    double d11 = d0 + 6.0 + b0 + 7.0 - 2.5;
                    double d12 = d1 + 6.0 + b0 - 4.0 - 10.0;
                    this.rz();
                    Color color3 = Themes.rK();
                    this.rz();
                    color3 = aip.d(color3, (int)(Themes.rK().getAlpha() / 1.7F));
                    this.rz();
                    RenderUtil.a(d11, d12, d4, 6.0, 3.0, color3, Themes.rK(), true);
                    RenderUtil.a(d0 + 6.0 + b0 + 7.0 - 2.5, d1 + 6.0 + b0 - 4.0 - 10.0, d5, 6.0, 3.0, color2, color1, false);
                    GlStateManager.popMatrix();
                });
                this.b(gg.REGULAR, 1).c(() -> {
                    GlStateManager.pushMatrix();
                    GlStateManager.translate((d0 + d8 / 2.0) * (1.0 - d10), (d1 + d9 / 2.0) * (1.0 - d10), 0.0);
                    GlStateManager.scale(d10, d10, 0.0);
                    RenderUtil.color(aip.a(Color.RED, Color.WHITE, d6 / 9.0));
                    RenderUtil.dropShadow(3, d0 + 6.0 + d7 - 2.5, d1 + 6.0 + d7 - 2.5, b0 - d6, b0 - d6, 20.0, this.rz().getRound() * 2);
                    this.a(abstractclientplayer, d0 + 6.0 + d7 - 2.5, d1 + 6.0 + d7 - 2.5, b0 - d6);
                    GlStateManager.popMatrix();
                });
                this.b(gg.BLUR).c(() -> {
                    GlStateManager.pushMatrix();
                    GlStateManager.translate((d0 + d8 / 2.0) * (1.0 - d10), (d1 + d9 / 2.0) * (1.0 - d10), 0.0);
                    GlStateManager.scale(d10, d10, 0.0);
                    RenderUtil.roundedRectangle(d0, d1, d8 - 3.5, d9 - 5.0, 8.0, Color.BLACK);
                    GlStateManager.popMatrix();
                });
                this.b(gg.BLOOM).c(() -> {
                    GlStateManager.pushMatrix();
                    GlStateManager.translate((d0 + d8 / 2.0) * (1.0 - d10), (d1 + d9 / 2.0) * (1.0 - d10), 0.0);
                    GlStateManager.scale(d10, d10, 0.0);
                    RenderUtil.roundedOutlineGradientRectangle(d0, d1, d8 - 3.5, d9 - 5.0, 7.0, 3.0, this.rz().rA(), this.rz().rB());
                    GlStateManager.popMatrix();
                });
            }
        }
    };

    public CompactTargetInfo(String var1, TargetInfo var2) {
        super(var1, var2);
    }

    private void a(AbstractClientPlayer var1, double var2, double var4, double var6) {
        ais.vK();
        ais.vL();
        double d0 = this.rz().getRound() * 2;
        this.rz();
        RenderUtil.roundedRectangle(var2, var4, var6, var6, d0, Themes.rK());
        ais.aD(1);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
        GlStateManager.alphaFunc(516, 0.0F);
        GlStateManager.enableTexture2D();
        HealthBypass healthbypass = this.e(HealthBypass.class);
        float f = healthbypass != null && healthbypass.isEnabled() ? HealthBypass.B(var1) : var1.getHealth();
        ResourceLocation resourcelocation = this.aui.inWorld && f > 0.0F ? var1.getLocationSkin() : RenderSkeleton.getEntityTexture();
        aEg.getTextureManager().bindTexture(resourcelocation);
        Gui.drawScaledCustomSizeModalRect(var2, var4, 4.0F, 4.0F, 4.0F, 4.0F, var6, var6, 32.0F, 32.0F);
        GlStateManager.disableBlend();
        ais.vM();
        float f1 = 0.5F;
        RenderUtil.roundedOutlineRectangle(var2 - f1, var4 - f1, var6 + f1 * 2.0F, var6 + f1 * 2.0F, this.rz().getRound() * 2, 0.5, aip.d(Color.BLACK, 40));
    }
}
