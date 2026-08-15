package com.alan.clients.module.impl.render.targetinfo;

import com.alan.clients.component.impl.render.NotificationComponent;
import com.alan.clients.module.impl.player.HealthBypass;
import com.alan.clients.module.impl.render.TargetInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.other.TickEvent;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.ui.theme.Themes;
import hackclient.rise.agc;
import hackclient.rise.ahd;
import com.alan.clients.util.math.MathUtil;
import hackclient.rise.aip;
import hackclient.rise.ais;
import com.alan.clients.util.render.particle.Particle;
import hackclient.rise.bf;
import com.alan.clients.util.font.FontManager;
import hackclient.rise.gd;
import hackclient.rise.gg;
import hackclient.rise.value.zy;
import java.awt.Color;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class CreidaModernTargetInfo extends Mode<TargetInfo> {
    private final BooleanValue particles = new BooleanValue("Particles", this, true);
    private final agc aur = FontManager.MAIN.a(22, gd.LIGHT);
    private final agc aus = FontManager.MAIN.a(22, gd.MEDIUM);
    private final ModeValue aut = new zy(this, "Background Mode", this);
    private TargetInfo aui;
    private final int auu = 10;
    private final int auv = 6;
    private final int auw = 4;
    private final Animation auxx = new Animation(Easing.EASE_OUT_ELASTIC, 500L);
    private final Animation auy = new Animation(Easing.EASE_OUT_SINE, 500L);
    private final Animation auz = new Animation(Easing.EASE_IN_OUT_CUBIC, 300L);
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
            this.auxx.h(flag ? 400L : 850L);
            this.auxx.setEasing(flag ? Easing.EASE_IN_BACK : Easing.EASE_OUT_ELASTIC);
            this.auxx.Q(flag ? 0.0 : 1.0);
            if (!(this.auxx.sG() <= 0.0)) {
                String s = entity.getName();
                String s1 = bf.c(s, s);
                double d0 = this.aui.position.x;
                double d1 = this.aui.position.y;
                AbstractClientPlayer abstractclientplayer = (AbstractClientPlayer)entity;
                HealthBypass healthbypass = this.e(HealthBypass.class);
                float f = healthbypass != null && healthbypass.isEnabled() ? HealthBypass.B(abstractclientplayer) : abstractclientplayer.getHealth();
                double d2 = this.aus.getStringWidth(s1);
                double d3 = Math.min(!this.aui.inWorld ? 0.0 : MathUtil.round(f, 1), abstractclientplayer.getMaxHealth());
                double d4 = this.aus.getStringWidth(String.valueOf(d3));
                double d5 = Math.max(d2 + 35.0 - d4, 75.0);
                this.auy.Q(d3 / abstractclientplayer.getMaxHealth() * d5);
                this.auy.setEasing(Easing.EASE_OUT_QUINT);
                this.auy.h(250L);
                double d6 = this.auy.sG();
                double d7 = (abstractclientplayer.hurtTime == 0 ? 0.0F : abstractclientplayer.hurtTime - aEg.timer.bWm) * 0.5;
                byte b0 = 32;
                this.auz.Q(d7 / 2.0);
                double d8 = this.auz.sG();
                double d9 = 52 + d5 + 4.0 + d4 + 10.0;
                double d10 = 42;
                this.aui.positionValue.n(new Vector2d(d9, d10));
                double d11 = this.auxx.sG();
                this.b(gg.REGULAR).c(() -> {
                    GlStateManager.pushMatrix();
                    GlStateManager.translate((d0 + d9 / 2.0) * (1.0 - d11), (d1 + d10 / 2.0) * (1.0 - d11), 0.0);
                    GlStateManager.scale(d11, d11, 0.0);
                    this.rz();
                    Color color = Themes.rK();
                    this.rz();
                    Color color1 = Themes.rK();
                    Color color2 = this.rz().rA();
                    Color color3 = this.rz().rB();
                    if (this.aut.wo().getName().equals("Tint")) {
                        Color color4 = this.rz().getAccentColor(new Vector2d(d0, d1));
                        Color color5 = this.rz().getAccentColor(new Vector2d(d0, d1 + d10));
                        color = new Color(color4.getRed() / 5, color4.getGreen() / 5, color4.getBlue() / 5, 128);
                        color1 = new Color(color5.getRed() / 5, color5.getGreen() / 5, color5.getBlue() / 5, 128);
                    } else if (this.aut.wo().getName().equals("Solid")) {
                        Color color6 = this.rz().rA();
                        Color color7 = this.rz().rB();
                        color = new Color(color6.getRed(), color6.getGreen(), color6.getBlue(), 128);
                        color1 = new Color(color7.getRed(), color7.getGreen(), color7.getBlue(), 128);
                        color2 = new Color(255, 255, 255);
                        color3 = new Color(164, 164, 164);
                    }

                    RenderUtil.a(d0 + 3.0, d1 + 5.0, d9 - 1.0, d10, 11.0, color, color1, true);
                    this.aur.b(ahd.ce("ui.targethud.name"), d0 + 10.0 + b0 + 6.0, d1 + 10.0 + 4.0 + 2.0, Color.WHITE.hashCode());
                    this.aus.b(s1, d0 + 10.0 + b0 + 6.0 + this.aur.getStringWidth(ahd.ce("ui.targethud.name")) + 3.0, d1 + 10.0 + 4.0 + 2.5, color2.hashCode());
                    GlStateManager.popMatrix();
                    GlStateManager.pushMatrix();
                    GlStateManager.translate((d0 + d9 / 2.0) * (1.0 - d11), (d1 + d10 / 2.0) * (1.0 - d11), 0.0);
                    GlStateManager.scale(d11, d11, 0.0);
                    double d12 = d0 + 10.0 + b0 + 6.0;
                    double d13 = d1 + 10.0 + b0 - 4.0 - 7.0;
                    this.rz();
                    Color color8 = Themes.rK();
                    this.rz();
                    color8 = aip.d(color8, (int)(Themes.rK().getAlpha() / 1.7F));
                    this.rz();
                    RenderUtil.a(d12, d13, d5, 6.5, 3.5, color8, Themes.rK(), true);
                    RenderUtil.b(d0 + 10.0 + b0 + 6.0, d1 + 10.0 + b0 - 4.0 - 7.0, d6, 6.5, 3.5, color3, color2, false);
                    this.aus.b(String.valueOf(d3), d0 + 10.0 + b0 + 6.0 + d5 + 4.0, d1 + 10.0 + b0 - 4.0 - 8.0, color2.hashCode());
                    GlStateManager.popMatrix();
                });
                this.b(gg.REGULAR, 1).c(() -> {
                    GlStateManager.pushMatrix();
                    GlStateManager.translate((d0 + d9 / 2.0) * (1.0 - d11), (d1 + d10 / 2.0) * (1.0 - d11), 0.0);
                    GlStateManager.scale(d11, d11, 0.0);
                    RenderUtil.color(aip.a(Color.RED, Color.WHITE, d7 / 9.0));
                    RenderUtil.dropShadow(3, d0 + 10.0 + d8, d1 + 10.0 + d8, b0 - d7, b0 - d7, 20.0, this.rz().getRound() * 2);
                    this.auz.Q(d7 / 2.0);
                    double d12 = this.auz.sG() == 0.0 ? 1.0 : this.auz.sG();
                    System.out.println(this.auz.sG());
                    this.a(abstractclientplayer, d0 + 10.0 + d12 / 2.0, d1 + 10.0 + d12 / 2.0, b0 - d7 / 2.0);
                    GlStateManager.popMatrix();
                });
                this.b(gg.BLUR).c(() -> {
                    GlStateManager.pushMatrix();
                    GlStateManager.translate((d0 + d9 / 2.0) * (1.0 - d11), (d1 + d10 / 2.0) * (1.0 - d11), 0.0);
                    GlStateManager.scale(d11, d11, 0.0);
                    RenderUtil.roundedRectangle(d0 + 3.0, d1 + 5.0, d9 - 1.0, d10, 11.0, Color.BLACK);
                    GlStateManager.popMatrix();
                });
                this.b(gg.BLOOM).c(() -> {
                    GlStateManager.pushMatrix();
                    GlStateManager.translate((d0 + d9 / 2.0) * (1.0 - d11), (d1 + d10 / 2.0) * (1.0 - d11), 0.0);
                    GlStateManager.scale(d11, d11, 0.0);
                    RenderUtil.roundedRectangle(d0 + 3.5, d1 + 5.5, d9 - 2.0, d10 - 1.0, 12.0, this.rz().rE());
                    Color color = this.rz().rA();
                    Color color1 = this.rz().rB();
                    RenderUtil.b(d0 + 10.0 + b0 + 6.0, d1 + 10.0 + b0 - 4.0 - 7.0, d6, 6.0, 3.0, aip.d(color1, 255), aip.d(color, 255), false);
                    GlStateManager.popMatrix();
                });
            }
        }
    };
    @EventLink
    public final Listener<TickEvent> onTick = var1x -> {
        if (this.aui != null) {
            Entity entity = this.aui.target;
            if (entity != null && !(this.auxx.sG() <= 0.0) && this.particles.wo()) {
                double d0 = (((AbstractClientPlayer)entity).hurtTime == 0 ? 0.0F : ((AbstractClientPlayer)entity).hurtTime - aEg.timer.bWm) * 0.5;
                if (d0 > 0.0) {
                    for (int i = 0; i < d0 * Math.random() / 2.0; i++) {
                        NotificationComponent.a(
                            new Particle(
                                new Vector2f((float)(this.aui.position.x + 20.0), (float)(this.aui.position.y + 20.0)),
                                new Vector2f((float)(Math.random() - 0.5) * 1.7F, (float)(Math.random() - 0.5) * 1.7F)
                            )
                        );
                    }
                }
            }
        }
    };

    public CreidaModernTargetInfo(String var1, TargetInfo var2) {
        super(var1, var2);
    }

    private void a(AbstractClientPlayer var1, double var2, double var4, double var6) {
        ais.vK();
        ais.vL();
        this.rz();
        RenderUtil.roundedRectangle(var2, var4, var6, var6, 7.0, Themes.rK());
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
