package com.alan.clients.ui.click.standard;

import com.alan.clients.Client;
import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.impl.render.ClickGUI;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.render.AlphaEvent;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.ui.click.standard.components.ModuleComponent;
import com.alan.clients.ui.click.standard.components.category.SidebarCategory;
import com.alan.clients.ui.click.standard.components.value.ValueComponent;
import hackclient.rise.ui.value.abn;
import hackclient.rise.ui.value.abt;
import hackclient.rise.ui.value.abv;
import hackclient.rise.abw;
import hackclient.rise.abx;
import com.alan.clients.ui.click.standard.screen.impl.SearchScreen;
import com.alan.clients.ui.click.standard.screen.impl.ThemeScreen;
import com.alan.clients.util.gui.GUIUtil;
import com.alan.clients.util.gui.textbox.TextBox;
import hackclient.rise.agw;
import hackclient.rise.agx;
import hackclient.rise.aha;
import hackclient.rise.aip;
import hackclient.rise.aiz;
import com.alan.clients.util.shader.impl.AlphaShader;
import com.alan.clients.util.font.FontManager;
import hackclient.rise.gd;
import hackclient.rise.ge;
import hackclient.rise.gg;
import java.awt.Color;
import java.lang.reflect.Field;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import lombok.Generated;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import rip.vantage.commons.util.time.a;

public class RiseClickGUI extends GuiScreen implements aha {
    public Vector2f axI = new Vector2f(-1.0F, -1.0F);
    public Vector2f alh = new Vector2f(416.0F, 338.0F);
    public SidebarCategory axJ = new SidebarCategory();
    public abx axK = Category.SEARCH.ec();
    public abx axL = this.axK;
    public abx axM = this.axK;
    public float axN;
    public float axO;
    public boolean dragging;
    public a axP = new a();
    public a rG = new a();
    public ConcurrentLinkedQueue<ModuleComponent> moduleList = new ConcurrentLinkedQueue<>();
    public Vector2f axR;
    public double axS;
    public double axT;
    public double axU;
    public int round = 7;
    Vector2d translate;
    public ValueComponent axX;
    public Vector2f axY = new Vector2f(283.0F, 38.0F);
    public Animation hB = new Animation(Easing.EASE_IN_EXPO, 300L);
    public Animation axZ = new Animation(Easing.EASE_IN_EXPO, 300L);
    private final agw aya = new agw();
    private TextBox ayb;
    ge ayc = new ge(new AlphaShader());
    @EventLink(value = 0)
    public final Listener<AlphaEvent> onAlpha = var1 -> {
        if (this.axS <= 0.99) {
            this.oT();
        }
    };

    public RiseClickGUI() {
    }

    public boolean a(TextBox var1) {
        if (!agx.isEnabled()) {
            return false;
        }

        if (var1 == null) {
            return false;
        }

        if (var1 != this.ayb) {
            return false;
        }

        if (!this.aya.uc()) {
            return false;
        }

        String s = this.aya.uo();
        return s != null && !s.isEmpty();
    }

    public void oS() {
        this.moduleList.clear();
        System.out.println("PRE RMC");
        if (!Client.a.getSecurityManager().nN()) {
            System.out.println("RMC");
            ArrayList arraylist = Client.a.g().ef();
            arraylist.sort((var0, var1) -> Collator.getInstance().compare(((Module)var0).getName(), ((Module)var1).getName()));
            arraylist.forEach(var1 -> this.moduleList.add(new ModuleComponent((Module)var1)));
        }
    }

    @Override
    public void initGui() {
        if (this.moduleList == null || this.moduleList.isEmpty()) {
            this.oS();
        }

        aMR.execute(
            () -> {
                this.round = 12;
                this.hB.reset();
                this.hB.T(0.0);
                ScaledResolution scaledresolution = aEg.jY;
                this.axM = this.axK;
                this.axP.aX();
                this.axP.i(System.currentTimeMillis() - 150L);
                Keyboard.enableRepeatEvents(true);
                this.rG.aX();
                this.axK.aT();
                if (this.axI.x < 0.0F
                    || this.axI.y < 0.0F
                    || this.axI.x + this.alh.x > scaledresolution.getScaledWidth()
                    || this.axI.y + this.alh.y > scaledresolution.getScaledHeight()) {
                    this.axI.x = scaledresolution.getScaledWidth() / 2.0F - this.alh.x / 2.0F;
                    this.axI.y = scaledresolution.getScaledHeight() / 2.0F - this.alh.y / 2.0F;
                }

                this.moduleList.forEach(var0 -> var0.getValueList().forEach(var0x -> {
                    if (var0x instanceof abt) {
                        ((abt)var0x).pU();
                    } else if (var0x instanceof abn) {
                        ((abn)var0x).pU();
                    }
                }));
            }
        );
        if (Client.a.getSecurityManager().nN()) {
            this.moduleList.clear();
        }
    }

    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
        this.dragging = false;
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    public void cj() {
        this.alh = new Vector2f(400.0F, 300.0F);
        if (this.axS > 0.99) {
            this.oT();
        } else {
            ((AlphaShader)this.ayc.dU()).p((float)this.axT);
            this.ayc.c(this::oT);
            this.ayc.a(aiz.OVERLAY);
            this.ayc.clear();
        }
    }

    public void oT() {
        if (this.axR != null) {
            Minecraft minecraft = Minecraft.getMinecraft();
            int i = (int)this.axR.x;
            int j = (int)this.axR.y;
            float f = minecraft.getTimer().bWm;
            if (this.dragging) {
                if (this.axK instanceof ThemeScreen) {
                    ((ThemeScreen)this.axK).qw();
                }

                this.axI.x = i + this.axN;
                this.axI.y = j + this.axO;
            }

            this.axZ.setEasing(minecraft.currentScreen == Client.a.v() ? Easing.EASE_OUT_EXPO : Easing.LINEAR);
            this.axZ.h(minecraft.currentScreen == Client.a.v() ? 300L : 100L);
            this.axZ.Q(minecraft.currentScreen == Client.a.v() ? 1.0 : 0.0);
            this.axT = this.axZ.sG();
            this.hB.setEasing(minecraft.currentScreen == Client.a.v() ? Easing.EASE_OUT_EXPO : Easing.LINEAR);
            this.hB.Q(minecraft.currentScreen == Client.a.v() ? 1.0 : 0.0);
            this.axS = this.hB.sG();
            if (minecraft.currentScreen == Client.a.v() && this.axS == 0.0) {
                this.axS = 0.01;
            }

            if (this.axS == 0.0) {
                Client.a.g().c(ClickGUI.class).setEnabled(false);
            } else {
                this.translate = new Vector2d((this.axI.x + this.alh.x / 2.0F) * (1.0 - this.axS), (this.axI.y + this.alh.y / 2.0F) * (1.0 - this.axS));
                Runnable runnable = () -> {
                    GlStateManager.pushMatrix();
                    if (this.axS != 1.0) {
                        GlStateManager.translate(this.translate.x, this.translate.y, 0.0);
                        GlStateManager.scale(this.axS, this.axS, 0.0);
                    }
                };
                runnable.run();
                this.b(gg.BLOOM, 2).c(runnable);
                if (this.axS > 0.993) {
                    RenderUtil.dropShadow(18, this.axI.x, this.axI.y, this.alh.x, this.alh.y, 30.0, this.round * 1.3);
                }

                RenderUtil.roundedRectangle(this.axI.x, this.axI.y, this.alh.x, this.alh.y, this.round, abw.BACKGROUND.pV());
                Runnable runnable1 = () -> {
                    GL11.glEnable(3089);
                    byte b0 = 1;
                    RenderUtil.g(
                        this.axI.x * this.axS + this.translate.x + b0,
                        this.axI.y * this.axS + this.translate.y + b0,
                        this.alh.x * this.axS - b0 * 2,
                        this.alh.y * this.axS - b0 * 2
                    );
                };
                runnable1.run();
                this.b(gg.BLOOM, 2).c(runnable1);
                Runnable runnable2 = () -> {
                    GL11.glPushMatrix();
                    GL11.glTranslated(0.0, 0.0, 0.0);
                };
                this.b(gg.BLOOM, 2).c(runnable2);
                short short1 = 200;
                (this.axL = this.axP.T(short1) ? this.axK : this.axM).b(i, j, f);
                if (agx.isEnabled()) {
                    double d0 = this.axI.x * this.axS + this.translate.x + 1.0;
                    double d1 = this.axI.y * this.axS + this.translate.y + 1.0;
                    double d2 = this.alh.x * this.axS - 2.0;
                    double d3 = this.alh.y * this.axS - 2.0;
                    TextBox agm = this.oU();
                    if (agm != this.ayb) {
                        this.aya.aX();
                        this.ayb = agm;
                    }

                    if (agm != null && this.aya.uc()) {
                        String s = this.aya.uo();
                        List list = this.aya.up();
                        if (s != null && !s.isEmpty()) {
                            float f1 = agm.tL();
                            float f2 = agm.tM();
                            FontManager.MAIN.a(16, gd.REGULAR).a(s, f1, f2, aip.d(Color.WHITE, 210).getRGB());
                            RenderUtil.d(
                                f1, f2 + FontManager.MAIN.a(16, gd.REGULAR).height() + 1.0F, FontManager.MAIN.a(16, gd.REGULAR).getStringWidth(s), 1.0, aip.d(Color.WHITE, 140)
                            );
                            if (list != null && !list.isEmpty()) {
                                StringBuilder stringbuilder = new StringBuilder();
                                int i1 = Math.min(9, list.size());
                                int j1 = this.aya.un();

                                for (int k1 = 0; k1 < i1; k1++) {
                                    if (k1 > 0) {
                                        stringbuilder.append("  ");
                                    }

                                    String s1 = k1 + 1 + "." + (String)list.get(k1);
                                    if (k1 == j1) {
                                        stringbuilder.append('[').append(s1).append(']');
                                    } else {
                                        stringbuilder.append(s1);
                                    }
                                }

                                stringbuilder.append(this.aya.ut());
                                String s2 = stringbuilder.toString();
                                double d5 = 6.0;
                                double d6 = FontManager.MAIN.a(16, gd.REGULAR).getStringWidth(s2) + d5 * 2.0;
                                double d7 = FontManager.MAIN.a(16, gd.REGULAR).height() + d5 * 2.0 - 5.0;
                                double d8 = f1 - 2.0F;
                                double d9 = f2 + FontManager.MAIN.a(16, gd.REGULAR).height() + 6.0F;
                                double d10 = 8.0;
                                Color color = aip.d(Color.WHITE, 255);
                                this.b(gg.BLUR).c(() -> RenderUtil.roundedRectangle(d8, d9, d6, d7, d10, color));
                                this.b(gg.BLOOM, 2).c(() -> {
                                    GL11.glDisable(3089);
                                    RenderUtil.roundedRectangle(d8, d9, d6, d7, d10 + 2.0, this.rz().rE());
                                    GL11.glEnable(3089);
                                    RenderUtil.g(d0, d1, d2, d3);
                                });
                                boolean flag1 = GL11.glIsEnabled(3089);
                                if (flag1) {
                                    GL11.glDisable(3089);
                                }

                                RenderUtil.roundedRectangle(d8, d9, d6, d7, d10, aip.d(abw.BACKGROUND.pV(), (int)Math.min(220.0, this.axT * 255.0)));
                                FontManager.MAIN.a(16, gd.REGULAR).a(s2, d8 + d5, d9 + d5, aip.d(Color.WHITE, 240).getRGB());
                                if (flag1) {
                                    GL11.glEnable(3089);
                                    RenderUtil.g(d0, d1, d2, d3);
                                }
                            }
                        }
                    }
                }

                int k = 255
                    - (int)Math.max(
                        0.0F,
                        Math.min(
                            255.0F,
                            this.axP.aKx() < short1 ? 255.0F - (float)this.axP.aKx() * (255.0F / short1) : (float)(this.axP.aKx() - short1) * (255.0F / short1)
                        )
                    );
                if (this.axP.aKx() <= short1 * 2) {
                    RenderUtil.roundedRectangle(this.axI.x, this.axI.y, this.alh.x, this.alh.y, this.round, abw.BACKGROUND.Y(k));
                }

                this.axJ.pF();

                for (int l = 0; l <= 8; l++) {
                    double d4 = l * 50;
                    RenderUtil.c(this.axI.x + this.axJ.aym - d4 / 2.0, this.axI.y + this.alh.y / 2.0F - d4 / 2.0, d4, aip.d(this.rz().rA(), 1));
                }

                this.axJ.renderSidebar(i, j);
                Runnable runnable3 = () -> {
                    GL11.glDisable(3089);
                    GlStateManager.popMatrix();
                };
                runnable3.run();
                this.b(gg.BLOOM, 2).c(runnable3);
                Runnable runnable4 = GL11::glPopMatrix;
                this.b(gg.BLOOM, 2).c(runnable4);
                this.rG.aX();
            }
        }
    }

    @Override
    public void drawScreen(int var1, int var2, float var3) {
        this.axR = new Vector2f(var1, var2);
    }

    public void ci() {
        this.translate = new Vector2d((this.axI.x + this.alh.x / 2.0F) * (1.0 - this.axS), (this.axI.y + this.alh.y / 2.0F) * (1.0 - this.axS));
        GlStateManager.pushMatrix();
        if (this.axS != 1.0) {
            GlStateManager.translate(this.translate.x, this.translate.y, 0.0);
            GlStateManager.scale(this.axS, this.axS, 0.0);
        }

        GL11.glEnable(3089);
        RenderUtil.g(this.axI.x * this.axS + this.translate.x, this.axI.y * this.axS + this.translate.y, this.alh.x * this.axS, (this.alh.y - 4.0F) * this.axS);
        this.axL.pY();
        this.axJ.preRenderClickGUI();
        GL11.glDisable(3089);
        GlStateManager.popMatrix();
    }

    @Override
    public void mouseClicked(int var1, int var2, int var3) {
        if (GUIUtil.c(this.axI.x, this.axI.y, this.alh.x, 15.0, var1, var2) && this.axX == null) {
            this.axN = this.axI.x - var1;
            this.axO = this.axI.y - var2;
            this.dragging = true;
        } else if (GUIUtil.c(this.axI.getX(), this.axI.getY(), this.alh.getX(), this.alh.getY(), var1, var2)) {
            if (this.axX == null) {
                this.axJ.clickSidebar(var1, var2, var3);
            }

            this.axK.f(var1, var2, var3);
        }

        this.axX = null;
    }

    @Override
    protected void mouseReleased(int var1, int var2, int var3) {
        this.dragging = false;
        this.axK.oG();
    }

    @Override
    protected void keyTyped(char var1, int var2) {
        if (agx.isEnabled()) {
            TextBox agm = this.oU();
            if (agm != this.ayb) {
                this.aya.aX();
                this.ayb = agm;
            }

            if (agm != null && this.aya.a(agm, var1, var2)) {
                return;
            }
        }

        if ("abcdefghijklmnopqrstuvwxyz1234567890 ".contains(String.valueOf(var1).toLowerCase()) && this.axK.pZ() && !this.getStandardClickGUI().oV()) {
            this.switchScreen(Category.SEARCH);
        }

        super.keyTyped(var1, var2);
        this.axK.a(var1, var2);
    }

    private TextBox oU() {
        try {
            if (this.axK instanceof SearchScreen acf && !this.oV()) {
                return acf.azR;
            }

            try {
                if ("com.alan.clients.ui.click.standard.screen.impl.ConfigScreen".equals(this.axK.getClass().getName())) {
                    Field field = this.axK.getClass().getDeclaredField("searchBar");
                    field.setAccessible(true);
                    Object object = field.get(this.axK);
                    if (object instanceof TextBox && !this.oV()) {
                        return (TextBox)object;
                    }
                }
            } catch (Throwable throwable) {
            }

            for (ModuleComponent abd : this.moduleList) {
                for (ValueComponent abl : abd.getValueList()) {
                    if (abl instanceof abv abv && abv.azo != null && abv.azo.ayU) {
                        return abv.azo;
                    }
                }
            }
        } catch (Throwable throwable1) {
        }

        return null;
    }

    public void switchScreen(Category var1) {
        if (!var1.ec().equals(this.axK)) {
            this.axM = this.getStandardClickGUI().axK;
            this.axK = var1.ec();
            this.axP.aX();
            this.axK.aT();
            SearchScreen acf = (SearchScreen)Category.SEARCH.ec();
            acf.relevantModules = acf.getRelevantModules(acf.azR.getText());
        }
    }

    public void a(abx var1) {
        if (!this.axK.getClass().getSimpleName().equals(var1.getClass().getSimpleName())) {
            this.axM = this.getStandardClickGUI().axK;
            this.axK = var1;
            this.axP.aX();
            this.axK.aT();
            SearchScreen acf = (SearchScreen)Category.SEARCH.ec();
            acf.relevantModules = acf.getRelevantModules(acf.azR.getText());
        }
    }

    public boolean oV() {
        Iterator iterator = this.moduleList.iterator();

        while (iterator.hasNext()) {
            for (ValueComponent abl : ((ModuleComponent)iterator.next()).getValueList()) {
                if (abl instanceof abv && abl.position != null && ((abv)abl).azo.ayU && !((abv)abl).azo.aJv.T(50L)) {
                    return true;
                }

                if (abl instanceof abt && ((abt)abl).azm.tO() && !((abt)abl).azm.aJv.T(50L)) {
                    return true;
                }

                if (abl instanceof abn && ((abn)abl).ayS.tO() && !((abn)abl).ayS.aJv.T(50L)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Generated
    public Vector2f getScale() {
        return this.axI;
    }

    @Generated
    public Vector2f getPosition() {
        return this.alh;
    }

    @Generated
    public SidebarCategory oY() {
        return this.axJ;
    }

    @Generated
    public abx oZ() {
        return this.axK;
    }

    @Generated
    public abx pa() {
        return this.axL;
    }

    @Generated
    public abx pb() {
        return this.axM;
    }

    @Generated
    public float pc() {
        return this.axN;
    }

    @Generated
    public float pd() {
        return this.axO;
    }

    @Generated
    public boolean pe() {
        return this.dragging;
    }

    @Generated
    public a pf() {
        return this.axP;
    }

    @Generated
    public a lN() {
        return this.rG;
    }

    @Generated
    public ConcurrentLinkedQueue<ModuleComponent> getModuleList() {
        return this.moduleList;
    }

    @Generated
    public Vector2f ph() {
        return this.axR;
    }

    @Generated
    public double pi() {
        return this.axS;
    }

    @Generated
    public double pj() {
        return this.axT;
    }

    @Generated
    public double pk() {
        return this.axU;
    }

    @Generated
    public int getRound() {
        return this.round;
    }

    @Generated
    public Vector2d getTranslate() {
        return this.translate;
    }

    @Generated
    public ValueComponent pn() {
        return this.axX;
    }

    @Generated
    public Vector2f po() {
        return this.axY;
    }

    @Generated
    public Animation mE() {
        return this.hB;
    }

    @Generated
    public Animation pp() {
        return this.axZ;
    }

    @Generated
    public agw pq() {
        return this.aya;
    }

    @Generated
    public TextBox pr() {
        return this.ayb;
    }

    @Generated
    public ge ps() {
        return this.ayc;
    }

    @Generated
    public Listener<AlphaEvent> getOnAlpha() {
        return this.onAlpha;
    }
}
