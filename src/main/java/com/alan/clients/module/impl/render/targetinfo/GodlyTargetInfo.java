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
import com.alan.clients.util.render.ColorUtil;
import hackclient.rise.ais;
import hackclient.rise.bf;
import com.alan.clients.util.font.FontManager;
import com.alan.clients.util.font.FontWeight;
import com.alan.clients.util.shader.ShaderQueueType;
import java.awt.Color;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class GodlyTargetInfo extends Mode<TargetInfo> {
    private final agc avg = FontManager.MAIN.a(18, FontWeight.REGULAR);
    private TargetInfo aui;
    private final int avh = 6;
    private final int avi = 7;
    private final int avj = 4;
    private final Animation avk = new Animation(Easing.EASE_OUT_ELASTIC, 500L);
    private final Animation avl = new Animation(Easing.EASE_OUT_SINE, 500L);
    @EventLink
    public final Listener<Render2DEvent> onRender2D = var1x -> {
        if (this.aui == null) {
            this.aui = this.e(TargetInfo.class);
        }

        this.b(ShaderQueueType.BLOOM).c(NotificationComponent::ci);
        this.b(ShaderQueueType.REGULAR, 1).c(NotificationComponent::cj);
        Entity entity = this.aui.target;
        if (entity != null) {
            boolean flag = !this.aui.inWorld || this.aui.rG.T(1000L);
            this.avk.h(flag ? 400L : 850L);
            this.avk.setEasing(flag ? Easing.EASE_IN_BACK : Easing.EASE_OUT_ELASTIC);
            this.avk.Q(flag ? 0.0 : 1.0);
            if (!(this.avk.sG() <= 0.0)) {
                String s = entity.getName();
                String s1 = bf.c(s, s);
                double d0 = this.aui.position.x;
                double d1 = this.aui.position.y;
                AbstractClientPlayer abstractclientplayer = (AbstractClientPlayer)entity;
                HealthBypass healthbypass = this.e(HealthBypass.class);
                float f = healthbypass != null && healthbypass.isEnabled() ? HealthBypass.B(abstractclientplayer) : abstractclientplayer.getHealth();
                double d2 = this.avg.getStringWidth(s1);
                double d3 = Math.min(!this.aui.inWorld ? 0.0 : MathUtil.round(f, 1), abstractclientplayer.getMaxHealth());
                double d4 = Math.max(d2 + 15.0, 70.0);
                this.avl.Q(d3 / abstractclientplayer.getMaxHealth() * d4);
                this.avl.setEasing(Easing.EASE_OUT_QUINT);
                this.avl.h(250L);
                double d5 = this.avl.sG();
                double d6 = (abstractclientplayer.hurtTime == 0 ? 0.0F : abstractclientplayer.hurtTime - aEg.timer.bWm) * 0.5;
                byte b0 = 32;
                double d7 = d6 / 2.0;
                double d8 = 44 + d4 + 4.0 + 6.0;
                double d9 = 44;
                this.aui.positionValue.n(new Vector2d(d8, d9));
                double d10 = this.avk.sG();
                this.b(ShaderQueueType.REGULAR).c(() -> {
                    GlStateManager.pushMatrix();
                    GlStateManager.translate((d0 + d8 / 2.0) * (1.0 - d10), (d1 + d9 / 2.0) * (1.0 - d10), 0.0);
                    GlStateManager.scale(d10, d10, 0.0);
                    Color color = this.rz().rA();
                    Color color1 = this.rz().rB();
                    if (!this.e(Interface.class).aoc.wo()) {
                        double d15 = d8 - 3.5;
                        double d16 = d9 - 4.0;
                        this.rz();
                        RenderUtil.roundedRectangle(d0, d1, d15, d16, 8.0, Themes.rK());
                    }

                    double d11 = d8 - 3.5;
                    double d12 = d9 - 4.0;
                    this.rz();
                    RenderUtil.roundedRectangle(d0, d1, d11, d12, 8.0, Themes.rK());
                    String s2 = String.valueOf(Math.round(f));
                    GlStateManager.pushMatrix();
                    this.avg.b(s1, d0 + 6.0 + b0 + 7.0 - 2.5, d1 + 6.0 + 4.0 - 2.0, color.hashCode());
                    this.avg.b(s2, d0 + b0 + aEg.fontRendererObj.getStringWidth("❤️") + 2.0, d1 + 6.0 + 4.0 + 8.0, -1);
                    aEg.fontRendererObj.b("§4❤", d0 + b0 + 11.0, d1 + 6.0 + 4.0 + 7.5, -1);
                    GlStateManager.popMatrix();
                    GlStateManager.popMatrix();
                    GlStateManager.pushMatrix();
                    GlStateManager.translate((d0 + d8 / 2.0) * (1.0 - d10), (d1 + d9 / 2.0) * (1.0 - d10), 0.0);
                    GlStateManager.scale(d10, d10, 0.0);
                    double d13 = d0 + 6.0 + b0 + 7.0 - 2.5;
                    double d14 = d1 + 6.0 + b0 - 4.0 - 6.0;
                    this.rz();
                    Color color2 = Themes.rK();
                    this.rz();
                    color2 = ColorUtil.d(color2, (int)(Themes.rK().getAlpha() / 1.7F));
                    this.rz();
                    RenderUtil.a(d13, d14, d4, 6.0, 3.0, color2, Themes.rK(), true);
                    RenderUtil.a(d0 + 6.0 + b0 + 7.0 - 2.5, d1 + 6.0 + b0 - 4.0 - 6.0, d5, 6.0, 3.0, color1, color, false);
                    GlStateManager.popMatrix();
                });
                this.b(ShaderQueueType.REGULAR, 1).c(() -> {
                    GlStateManager.pushMatrix();
                    GlStateManager.translate((d0 + d8 / 2.0) * (1.0 - d10), (d1 + d9 / 2.0) * (1.0 - d10), 0.0);
                    GlStateManager.scale(d10, d10, 0.0);
                    RenderUtil.color(ColorUtil.a(Color.RED, Color.WHITE, d6 / 9.0));
                    RenderUtil.dropShadow(3, d0 + 6.0 + d7 - 2.0, d1 + 6.0 + d7 - 2.0, b0 - d6, b0 - d6, 20.0, this.rz().getRound() * 2);
                    this.a(abstractclientplayer, d0 + 6.0 + d7 - 2.0, d1 + 6.0 + d7 - 2.0, b0 - d6);
                    GlStateManager.popMatrix();
                });
                this.b(ShaderQueueType.BLUR).c(() -> {
                    GlStateManager.pushMatrix();
                    GlStateManager.translate((d0 + d8 / 2.0) * (1.0 - d10), (d1 + d9 / 2.0) * (1.0 - d10), 0.0);
                    GlStateManager.scale(d10, d10, 0.0);
                    RenderUtil.roundedRectangle(d0, d1, d8 - 3.5, d9 - 4.0, 8.0, Color.BLACK);
                    GlStateManager.popMatrix();
                });
                this.b(ShaderQueueType.BLOOM).c(() -> {
                    GlStateManager.pushMatrix();
                    GlStateManager.translate((d0 + d8 / 2.0) * (1.0 - d10), (d1 + d9 / 2.0) * (1.0 - d10), 0.0);
                    GlStateManager.scale(d10, d10, 0.0);
                    GlStateManager.popMatrix();
                });
            }
        }
    };

    public GodlyTargetInfo(String var1, TargetInfo targetInfo) {
        super(var1, targetInfo);
    }

    private void a(AbstractClientPlayer abstractClientPlayer, double var2, double var4, double var6) {
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
        float f = healthbypass != null && healthbypass.isEnabled() ? HealthBypass.B(abstractClientPlayer) : abstractClientPlayer.getHealth();
        ResourceLocation resourcelocation = this.aui.inWorld && f > 0.0F ? abstractClientPlayer.getLocationSkin() : RenderSkeleton.getEntityTexture();
        aEg.getTextureManager().bindTexture(resourcelocation);
        Gui.drawScaledCustomSizeModalRect(var2, var4, 4.0F, 4.0F, 4.0F, 4.0F, var6, var6, 32.0F, 32.0F);
        GlStateManager.disableBlend();
        ais.vM();
        float f1 = 0.5F;
        RenderUtil.roundedOutlineRectangle(var2 - f1, var4 - f1, var6 + f1 * 2.0F, var6 + f1 * 2.0F, this.rz().getRound() * 2, 0.5, ColorUtil.d(Color.BLACK, 40));
    }
}
