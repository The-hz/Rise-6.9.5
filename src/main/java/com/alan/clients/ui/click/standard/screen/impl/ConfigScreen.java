package com.alan.clients.ui.click.standard.screen.impl;

import com.alan.clients.Client;
import com.alan.clients.ui.click.standard.RiseClickGUI;
import com.alan.clients.ui.click.standard.components.ModuleComponent;
import com.alan.clients.ui.click.standard.components.value.ValueComponent;
import com.alan.clients.ui.click.standard.screen.Screen;
import com.alan.clients.util.font.FontManager;
import com.alan.clients.util.gui.textbox.TextAlign;
import com.alan.clients.util.gui.textbox.TextBox;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.ui.click.standard.UIColors;
import hackclient.rise.agk;
import com.alan.clients.util.font.FontWeight;
import hackclient.rise.ui.value.abv;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import lombok.Generated;
import rip.vantage.commons.util.time.a;

public final class ConfigScreen implements Screen, InstanceAccess {
    public final TextBox azM = new TextBox(new Vector2d(200.0, 200.0), FontManager.MAIN.a(20, FontWeight.REGULAR), Color.WHITE, TextAlign.CENTER, "Start typing to search...", 150.0F);
    private final a azN = new a();
    public agk scrollUtil = new agk();
    public ArrayList<ModuleComponent> azB = new ArrayList<>();
    private double axT = 255.0;
    private double azC;
    private double azD;
    private boolean azO;

    public ConfigScreen() {
    }

    @Override
    public void b(int var1, int var2, float var3) {
        RiseClickGUI riseclickgui = this.getStandardClickGUI();
        if (this.scrollUtil.tD() < 0.0) {
            this.axT = this.axT - this.azN.getElapsedTime() * 4L;
        } else {
            this.axT = this.axT + this.azN.getElapsedTime() * 4L;
        }

        this.axT = Math.min(Math.max(0.0, this.axT), 255.0);
        this.azM.setColor(UIColors.TEXT.Y((int)this.axT));
        Vector2d vector2d = new Vector2d(
            riseclickgui.axI.x + riseclickgui.axJ.aym + (riseclickgui.alh.x - riseclickgui.axJ.aym) / 2.0,
            (float)(riseclickgui.axI.y + 17.0F + this.scrollUtil.tE())
        );
        this.azM.h(vector2d);
        this.azM.draw();
        this.scrollUtil.qx();
        double d0 = riseclickgui.axI.y + 35.0F + this.scrollUtil.tE();
        this.azD = d0;
        double d1 = 0.0;

        for (ModuleComponent moduleComponent : this.azB) {
            moduleComponent.draw(new Vector2d(riseclickgui.axI.x + riseclickgui.axJ.aym + 4.0, d0), var1, var2, var3);
            d0 += moduleComponent.scale.y + 5.0F;
            d1 += moduleComponent.scale.y + 5.0F;
        }

        this.azC = d0;
        this.scrollUtil.V(-d1 + riseclickgui.alh.y - 37.0);
        this.azN.aX();
    }

    @Override
    public void a(char var1, int var2) {
        if (!this.azO && var1 != 0 && !Character.isISOControl(var1)) {
            this.azO = true;
            this.aH(" ");
        }

        if (!this.oV()) {
            this.azM.I(true);
        }

        this.azM.key(var1, var2);
        this.scrollUtil.U(0.0);
        this.azB = this.aG(this.azM.getText());
        Iterator iterator = this.qf().iterator();

        while (iterator.hasNext()) {
            ((ModuleComponent)iterator.next()).key(var1, var2);
        }
    }

    @Override
    public void f(int var1, int var2, int var3) {
        Iterator iterator = this.azB.iterator();

        while (iterator.hasNext()) {
            ((ModuleComponent)iterator.next()).click(var1, var2, var3);
        }

        this.azM.click(var1, var2, var3);
    }

    @Override
    public void oG() {
        Iterator iterator = this.qf().iterator();

        while (iterator.hasNext()) {
            ((ModuleComponent)iterator.next()).pz();
        }
    }

    @Override
    public void pY() {
        Iterator iterator = this.qf().iterator();

        while (iterator.hasNext()) {
            ((ModuleComponent)iterator.next()).ci();
        }
    }

    @Override
    public void aT() {
        this.azB = this.aG(this.azM.getText());
        this.azO = false;
    }

    public ArrayList<ModuleComponent> aG(String var1) {
        ArrayList arraylist = new ArrayList();

        for (ModuleComponent moduleComponent : Client.a.v().getModuleList()) {
            String[] astring = moduleComponent.getModule().getAliases();
            int i = astring.length;

            for (int j = 0; j < i; j++) {
                if (astring[j].toLowerCase().replaceAll(" ", "").contains(var1.toLowerCase().replaceAll(" ", ""))) {
                    arraylist.add(moduleComponent);
                    break;
                }
            }
        }

        return arraylist;
    }

    public void aH(String var1) {
        this.azM.bW(var1);
        this.azB = this.aG(this.azM.getText());
    }

    public boolean oV() {
        Iterator iterator = this.azB.iterator();

        while (iterator.hasNext()) {
            for (ValueComponent valueComponent : ((ModuleComponent)iterator.next()).getValueList()) {
                if (valueComponent instanceof abv && ((abv)valueComponent).azo.ayU) {
                    return true;
                }
            }
        }

        return false;
    }

    @Generated
    public TextBox qr() {
        return this.azM;
    }

    @Generated
    public a lN() {
        return this.azN;
    }

    @Generated
    public agk qe() {
        return this.scrollUtil;
    }

    @Generated
    public ArrayList<ModuleComponent> qf() {
        return this.azB;
    }

    @Generated
    public double pj() {
        return this.axT;
    }

    @Generated
    public double qg() {
        return this.azC;
    }

    @Generated
    public double qh() {
        return this.azD;
    }

    @Generated
    public boolean qs() {
        return this.azO;
    }

    @Generated
    public void a(agk scrollUtil) {
        this.scrollUtil = scrollUtil;
    }

    @Generated
    public void b(ArrayList<ModuleComponent> moduleComponents) {
        this.azB = moduleComponents;
    }

    @Generated
    public void J(double var1) {
        this.axT = var1;
    }

    @Generated
    public void H(double var1) {
        this.azC = var1;
    }

    @Generated
    public void I(double var1) {
        this.azD = var1;
    }

    @Generated
    public void A(boolean var1) {
        this.azO = var1;
    }
}
