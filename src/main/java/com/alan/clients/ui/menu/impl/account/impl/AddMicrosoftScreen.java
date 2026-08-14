package com.alan.clients.ui.menu.impl.account.impl;

import com.alan.clients.ui.menu.impl.account.AccountManagerScreen;
import com.alan.clients.ui.menu.impl.account.display.AccountViewModel;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import hackclient.rise.adh;
import hackclient.rise.adm;
import hackclient.rise.aeb;
import hackclient.rise.aep;
import hackclient.rise.agc;
import hackclient.rise.aiv;
import hackclient.rise.aiz;
import hackclient.rise.gb;
import hackclient.rise.gd;
import hackclient.rise.gg;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

public class AddMicrosoftScreen extends GuiScreen implements InstanceAccess {
    private static final agc FONT_RENDERER = gb.MAIN.a(36, gd.BOLD);
    private static final agc INFO_FONT_RENDERER = gb.MAIN.a(18, gd.REGULAR);
    private static AccountViewModel<aep> accountViewModel;
    private static GuiScreen reference;
    private final adh[] menuButtons = new adh[2];
    private Animation animation;
    private static final Runnable CANCEL_RUNNABLE = () -> aEg.displayGuiScreen(new AccountManagerScreen(reference));
    private static final Runnable ADD_RUNNABLE = () -> {
        if (accountViewModel.getAccount().kW()) {
            AccountManagerScreen.addAccount(accountViewModel.getAccount());
            CANCEL_RUNNABLE.run();
        }
    };
    private static final Runnable BACKGROUND_RUNNABLE = () -> {
        ScaledResolution scaledresolution = new ScaledResolution(aEg);
        RenderUtil.d(0.0, 0.0, scaledresolution.getScaledWidth(), scaledresolution.getScaledHeight(), Color.BLACK);
    };

    public AddMicrosoftScreen() {
        reference = this;
    }

    @Override
    public void drawScreen(int var1, int var2, float var3) {
        if (accountViewModel.getAccount().kW()) {
            this.animation.Q(36.0);
        } else {
            this.animation.Q(0.0);
        }

        aiv.aPL.a(aiz.OVERLAY, var3, null);
        this.b(gg.BLUR).c(BACKGROUND_RUNNABLE);
        this.b(gg.REGULAR)
            .c(
                () -> {
                    FONT_RENDERER.c("Log in to your microsoft account", this.width / 2, this.height / 2 - 96 + this.animation.sG(), Color.WHITE.getRGB());
                    INFO_FONT_RENDERER.c(
                        "A link has been copied to your clipboard.", this.width / 2, this.height / 2 - 64 + this.animation.sG(), Color.WHITE.darker().getRGB()
                    );
                    INFO_FONT_RENDERER.c(
                        "To load a cookie, please use firefox and install \"Cookie Quick Manager\".",
                        this.width / 2,
                        this.height / 2 - 48 + this.animation.sG(),
                        Color.WHITE.darker().getRGB()
                    );
                    INFO_FONT_RENDERER.c(
                        "To login to your own account, just fill out the form.",
                        this.width / 2,
                        this.height / 2 - 32 + this.animation.sG(),
                        Color.WHITE.darker().getRGB()
                    );
                    int k = this.width / 2;
                    int l = this.height / 2 + 4;
                    byte b0 = 12;
                    if (!accountViewModel.getAccount().kW()) {
                        GlStateManager.pushMatrix();
                        GlStateManager.translate(k, l + this.animation.sG(), 0.0);
                        GlStateManager.pushMatrix();
                        GlStateManager.enableBlend();
                        GlStateManager.blendFunc(770, 771);
                        GlStateManager.disableAlpha();
                        GlStateManager.disableTexture2D();
                        GL11.glEnable(2832);
                        GL11.glPointSize(8.0F);
                        GL11.glBegin(0);
                        long i1 = (long)(Minecraft.getSystemTime() * 0.5);
                        long j1 = i1 % 360L;
                        long k1 = j1 - j1 % 30L;

                        for (int b1 = 0; b1 < 360; b1 += 30) {
                            double d0 = (Math.PI * 2) * b1 / 360.0;
                            double d1 = Math.cos(d0);
                            double d2 = Math.sin(d0);
                            float f = 1.0F - (float)(b1 + k1) % 360.0F / 360.0F;
                            GL11.glColor4f(1.0F, 1.0F, 1.0F, f);
                            GL11.glVertex2d(d1 * b0, d2 * b0);
                        }

                        GL11.glEnd();
                        GL11.glDisable(2832);
                        GL11.glLineWidth(1.0F);
                        GlStateManager.enableTexture2D();
                        GlStateManager.disableBlend();
                        GlStateManager.enableAlpha();
                        GlStateManager.popMatrix();
                        GlStateManager.popMatrix();
                    }
                }
            );
        accountViewModel.draw();
        adh[] aadh = this.menuButtons;
        int i = aadh.length;

        for (int j = 0; j < i; j++) {
            aadh[j].c(var1, var2, var3);
        }
    }

    @Override
    public void mouseClicked(int var1, int var2, int var3) {
        for (adh adh : this.menuButtons) {
            if (aeb.a(adh.getX(), adh.getY(), adh.oM(), adh.da(), var1, var2)) {
                adh.rm();
                break;
            }
        }
    }

    @Override
    protected void keyTyped(char var1, int var2) {
    }

    @Override
    public void initGui() {
        byte b0 = 24;
        byte b1 = 4;
        float f = 196 / 2.0F;
        Vector2d vector2d = new Vector2d(this.width / 2 - 100, this.height / 2 + 76);
        this.menuButtons[0] = new adm(vector2d.x, vector2d.y, f, b0, ADD_RUNNABLE, "Add");
        this.menuButtons[1] = new adm(vector2d.x + f + b1, vector2d.y, f, b0, CANCEL_RUNNABLE, "Back");
        accountViewModel = new AccountViewModel<>(aep.sn(), this.width / 2 - 100, this.height / 2 + 32, 200.0F, 40.0F);
        accountViewModel.setScreenHeight(this.height);
        this.animation = new Animation(Easing.EASE_OUT_QUINT, 600L);
        this.animation.R(-200.0);
    }
}
