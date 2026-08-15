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
import com.alan.clients.ui.theme.Themes;
import hackclient.rise.agc;
import hackclient.rise.ahd;
import com.alan.clients.util.math.MathUtil;
import hackclient.rise.aip;
import hackclient.rise.ais;
import com.alan.clients.util.render.particle.Particle;
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

public class BMSTargetInfo extends Mode<TargetInfo> {
    private final agc aug = gb.MAIN.a(22, gd.LIGHT);
    private final agc auh = gb.MAIN.a(22, gd.LIGHT);
    private TargetInfo aui;
    private int auj = 4;
    private int auk = 4;
    private int aul = 4;
    private Animation aum = new Animation(Easing.EASE_OUT_ELASTIC, 500L);
    private Animation aun = new Animation(Easing.EASE_OUT_SINE, 500L);
    @EventLink
    public final Listener<Render2DEvent> onRender2D = var1x -> {
        if (this.aui == null) {
            this.aui = this.e(TargetInfo.class);
        }

        Entity entity = this.aui.target;
        if (entity != null) {
            boolean flag = !this.aui.inWorld || this.aui.rG.T(1000L);
            this.aum.h(flag ? 400L : 850L);
            this.aum.setEasing(flag ? Easing.EASE_IN_BACK : Easing.EASE_OUT_ELASTIC);
            this.aum.Q(flag ? 0.0 : 1.0);
            if (!(this.aum.sG() <= 0.0)) {
                String s = entity.getName();
                String s1 = bf.c(s, s);
                double d0 = this.aui.position.x;
                double d1 = this.aui.position.y;
                AbstractClientPlayer abstractclientplayer = (AbstractClientPlayer)entity;
                HealthBypass healthbypass = this.e(HealthBypass.class);
                float f = healthbypass != null && healthbypass.isEnabled() ? HealthBypass.B(abstractclientplayer) : abstractclientplayer.getHealth();
                double d2 = Math.min(!this.aui.inWorld ? 0.0 : MathUtil.round(f, 1), abstractclientplayer.getMaxHealth());
                double d3 = Math.max(0, 100);
                this.aun.Q(d2 / abstractclientplayer.getMaxHealth() * d3);
                this.aun.setEasing(Easing.EASE_OUT_QUINT);
                this.aun.h(250L);
                double d4 = this.aun.sG();
                double d5 = (abstractclientplayer.hurtTime == 0 ? 0.0F : abstractclientplayer.hurtTime - aEg.timer.bWm) * 0.0F;
                byte b0 = 32;
                double d6 = Math.round(d2 / abstractclientplayer.getMaxHealth() * 100.0);
                double d7 = d5 / 2.0;
                double d8 = this.auj + b0 + this.auj + d3 + this.aul + this.auj;
                double d9 = b0 + this.auj * 2;
                this.aui.positionValue.n(new Vector2d(d8, d9));
                double d10 = this.aum.sG();
                this.b(gg.REGULAR, 1)
                    .c(
                        () -> {
                            GlStateManager.pushMatrix();
                            GlStateManager.translate((d0 + d8 / 2.0) * (1.0 - d10), (d1 + d9 / 2.0) * (1.0 - d10), 0.0);
                            GlStateManager.scale(d10, d10, 0.0);
                            this.rz();
                            Color color = Themes.rK();
                            Color color1 = this.rz().rA();
                            RenderUtil.a(d0, d1, d8 - 4.0, d9, 6.0, color, color, true);
                            this.auh
                                .b(
                                    s1,
                                    d0 - 28.0 + b0 + this.auk + this.aug.getStringWidth(ahd.ce("ui.targethud.name")) + 3.0,
                                    d1 + this.auj + this.aul,
                                    Color.white.getRGB()
                                );
                            GlStateManager.popMatrix();
                            GlStateManager.pushMatrix();
                            GlStateManager.translate((d0 + d8 / 2.0) * (1.0 - d10), (d1 + d9 / 2.0) * (1.0 - d10), 0.0);
                            GlStateManager.scale(d10, d10, 0.0);
                            RenderUtil.color(aip.a(Color.RED, Color.WHITE, d5 / 9.0));
                            RenderUtil.dropShadow(3, d0 + this.auj + d7, d1 + this.auj + d7, b0 - d5, b0 - d5, 20.0, 5.0);
                            this.a(abstractclientplayer, d0 + this.auj + d7, d1 + this.auj + d7, b0 - d5);
                            RenderUtil.roundedRectangle(
                                d0 + this.auj + b0 + this.auk, d1 + this.auj + b0 - this.aul - 10.0, d3, 12.0, 2.0, Color.darkGray.darker()
                            );
                            RenderUtil.a(
                                d0 + this.auj + b0 + this.auk,
                                d1 + this.auj + b0 - this.aul - 10.0,
                                d4,
                                12.0,
                                2.0,
                                aip.d(color1, 100),
                                aip.d(color1, 100),
                                false
                            );
                            this.aug
                                .c(d6 + "%", d0 + this.auj + b0 + this.auk + d3 + this.aul - 50.0, d1 + this.auj + b0 - this.aul - 8.0, Color.WHITE.getRGB());
                            GlStateManager.popMatrix();
                        }
                    );
                this.b(gg.BLUR).c(() -> {
                    GlStateManager.pushMatrix();
                    GlStateManager.translate((d0 + d8 / 2.0) * (1.0 - d10), (d1 + d9 / 2.0) * (1.0 - d10), 0.0);
                    GlStateManager.scale(d10, d10, 0.0);
                    RenderUtil.roundedRectangle(d0, d1, d8 - 4.5, d9, 6.0, Color.BLACK);
                    GlStateManager.popMatrix();
                });
                this.b(gg.BLOOM).c(() -> {
                    GlStateManager.pushMatrix();
                    GlStateManager.translate((d0 + d8 / 2.0) * (1.0 - d10), (d1 + d9 / 2.0) * (1.0 - d10), 0.0);
                    GlStateManager.scale(d10, d10, 0.0);
                    Color color = this.rz().rE();
                    Color color1 = this.rz().rE();
                    RenderUtil.a(d0 + 0.5, d1, d8 - 4.5, d9, 7.0, color, color1, true);
                    GlStateManager.popMatrix();
                });
            }
        }
    };
    @EventLink
    public final Listener<TickEvent> onTick = var1x -> {
        if (this.aui != null) {
            Entity entity = this.aui.target;
            if (entity != null && !(this.aum.sG() <= 0.0)) {
                double d0 = (((AbstractClientPlayer)entity).hurtTime == 0 ? 0.0F : ((AbstractClientPlayer)entity).hurtTime - aEg.timer.bWm) * 0.0F;
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

    public BMSTargetInfo(String var1, TargetInfo var2) {
        super(var1, var2);
    }

    private void a(AbstractClientPlayer var1, double var2, double var4, double var6) {
        ais.vK();
        ais.vL();
        this.rz();
        RenderUtil.roundedRectangle(var2, var4, var6, var6, 3.0, Themes.rK());
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
    }
}
