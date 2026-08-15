package com.alan.clients.ui.click.standard.components;

import com.alan.clients.module.Module;
import com.alan.clients.ui.click.standard.RiseClickGUI;
import com.alan.clients.ui.click.standard.screen.impl.SearchScreen;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.ui.click.standard.components.value.ValueComponent;
import hackclient.rise.abw;
import com.alan.clients.util.gui.GUIUtil;
import hackclient.rise.ahd;
import hackclient.rise.aip;
import hackclient.rise.gb;
import hackclient.rise.gd;
import hackclient.rise.ui.value.abn;
import hackclient.rise.ui.value.abt;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import lombok.Generated;
import rip.vantage.commons.util.time.a;

public class ModuleComponent implements InstanceAccess {
    public Module module;
    public Vector2f scale = this.getStandardClickGUI().po();
    public boolean axv;
    public ArrayList<ValueComponent> valueList = new ArrayList<>();
    public Vector2d position;
    public double opacity;
    public a rG = new a();
    public Animation axx = new Animation(Easing.LINEAR, 50L);
    public Animation aye = new Animation(Easing.LINEAR, 200L);
    public Animation ayf = new Animation(Easing.LINEAR, 5000L);
    public boolean ayg;

    public ModuleComponent(Module var1) {
        this.module = var1;
        this.aye.T(this.scale.y);
        this.ayf.T(0.0);
        var1.getAllValues().forEach(var1x -> {
            ValueComponent abl = var1x.wl();
            if (abl != null) {
                this.valueList.add(abl);
            }
        });
    }

    public void draw(Vector2d var1, int var2, int var3, float var4) {
        this.position = var1;
        float f = 38.0F;
        float f1 = f;
        boolean flag = var1 != null
            && !(var1.y + this.scale.y < this.getStandardClickGUI().axI.y)
            && !(var1.y > this.getStandardClickGUI().axI.y + this.getStandardClickGUI().alh.y);
        if (flag) {
            RiseClickGUI riseclickgui = this.getStandardClickGUI();
            RenderUtil.roundedRectangle(var1.x, var1.y, this.scale.x, this.scale.y, 6.0, abw.OVERLAY.pV());
            Color color = abw.TEXT.Y(this.module.isEnabled() ? 255 : 200);
            boolean flag1 = GUIUtil.c(var1.x, var1.y, this.scale.x, this.scale.y, var2, var3);
            this.axx.Q(flag1 ? (this.ayg ? 35.0 : 20.0) : 0.0);
            RenderUtil.roundedRectangle(var1.x, var1.y, this.scale.x, this.scale.y, 6.0, aip.d(Color.BLACK, (int)this.axx.sG()));
            if (riseclickgui.pa() instanceof SearchScreen) {
                gb.MAIN
                    .a(15, gd.REGULAR)
                    .a(
                        "(" + ahd.ce(this.module.getModuleInfo().category().getName()) + ")",
                        (float)(var1.getX() + gb.MAIN.a(20, gd.REGULAR).getStringWidth(this.module.getName()) + 10.0),
                        (float)var1.getY() + 10.0F,
                        aip.d(color, 64).hashCode()
                    );
            }

            gb.MAIN
                .a(20, gd.REGULAR)
                .a(
                    this.module.getName(),
                    (float)var1.x + 6.0F,
                    (float)var1.y + 8.0F,
                    this.module.isEnabled() ? this.rz().getAccentColor(new Vector2d(0.0, var1.y / 5.0)).getRGB() : color.getRGB()
                );
            gb.MAIN.a(15, gd.REGULAR).a(ahd.ce(this.module.getModuleInfo().description()), (float)var1.x + 6.0F, (float)var1.y + 25.0F, aip.d(color, 70).hashCode());
            this.scale = new Vector2f(this.getStandardClickGUI().axY.x, f1);
        }

        if (!this.aye.isFinished() || this.axv) {
            for (ValueComponent abl : this.getValueList()) {
                if ((abl.getValue() == null || abl.getValue().wm() == null || !abl.getValue().wm().getAsBoolean()) && (abl.getValue().wn() == null || !abl.getValue().wn().getAsBoolean())) {
                    abl.U(abl.position == null ? 0 : (abl.position.y < var1.y + this.aye.sG() + 15.0 ? (int)this.ayf.sG() : 0));
                    abl.U(abl.getValue().wm() == null ? abl.pT() : Math.max(abl.pT() - 40, 0));
                    if (flag) {
                        abl.draw(
                            new Vector2d(var1.x + 6.0 + (abl.getValue().wm() == null ? 0 : 10) + (abl.getValue().wn() == null ? 0 : 10), (float)(var1.y + f1 + 1.0)),
                            var2,
                            var3,
                            var4
                        );
                    }

                    f1 = (float)(f1 + abl.getHeight());
                }
            }

            f1--;
        }

        this.aye.h(Math.min((long)f1 * 3L, 450L));
        this.aye.setEasing(Easing.EASE_OUT_EXPO);
        this.aye.Q(this.axv ? f1 : f);
        this.scale.y = (float)this.aye.sG();
        this.ayf.h(this.axv ? this.aye.sB() / 2L : this.aye.sB() / 3L);
        this.ayf.Q(this.axv ? 255.0 : 0.0);
    }

    public void key(char var1, int var2) {
        if (this.position != null
            && !(this.position.y + this.scale.y < this.getStandardClickGUI().axI.y)
            && !(this.position.y > this.getStandardClickGUI().axI.y + this.getStandardClickGUI().alh.y)) {
            if (this.oJ()) {
                Iterator iterator = this.getValueList().iterator();

                while (iterator.hasNext()) {
                    ((ValueComponent)iterator.next()).key(var1, var2);
                }
            }
        }
    }

    public void click(int var1, int var2, int var3) {
        if (this.position != null
            && !(this.position.y + this.scale.y < this.getStandardClickGUI().axI.y)
            && !(this.position.y > this.getStandardClickGUI().axI.y + this.getStandardClickGUI().alh.y)) {
            Vector2f vector2f = this.getStandardClickGUI().axI;
            Vector2f vector2f1 = this.getStandardClickGUI().alh;
            boolean flag = var3 == 0;
            boolean flag1 = var3 == 1;
            boolean flag2 = GUIUtil.c(vector2f.x, vector2f.y, vector2f1.x, vector2f1.y, var1, var2);
            if (GUIUtil.c(this.position.x, this.position.y, this.scale.x, this.getStandardClickGUI().axY.getY() - 3.0F, var1, var2) && this.getStandardClickGUI().axX == null) {
                this.ayg = true;
                double d0 = 0.0;

                for (ValueComponent ablxx : this.valueList) {
                    d0 += ablxx.getHeight();
                }

                if (flag) {
                    if (flag2) {
                        this.module.toggle();
                    }
                } else if (flag1 && this.module.getValues().size() != 0 && d0 != 0.0) {
                    this.axv = !this.axv;

                    for (ValueComponent abl : this.getValueList()) {
                        if (abl instanceof abn abn) {
                            abn.ayI = abn.ayJ = false;
                        } else if (abl instanceof abt) {
                            ((abt)abl).azi = false;
                        }
                    }
                }
            }

            if (this.oJ()) {
                for (ValueComponent ablx : this.getValueList()) {
                    if ((ablx.getValue() == null || ablx.getValue().wm() == null || !ablx.getValue().wm().getAsBoolean())
                        && (ablx.getValue().wn() == null || !ablx.getValue().wn().getAsBoolean())
                        && ablx.e(var1, var2, var3)) {
                        break;
                    }
                }
            }
        }
    }

    public void ci() {
        if (this.position != null) {
            if (!(this.position.y + this.scale.y < this.getStandardClickGUI().axI.y)
                && !(this.position.y > this.getStandardClickGUI().axI.y + this.getStandardClickGUI().alh.y)) {
                if (!this.aye.isFinished() || this.axv) {
                    for (ValueComponent abl : this.getValueList()) {
                        if (abl.getValue() != null
                            && (abl.getValue().wm() == null || !abl.getValue().wm().getAsBoolean())
                            && (abl.getValue().wn() == null || !abl.getValue().wn().getAsBoolean())) {
                            abl.released();
                        }
                    }
                }
            }
        }
    }

    public void pz() {
        this.ayg = false;
        if (this.oJ()) {
            Iterator iterator = this.getValueList().iterator();

            while (iterator.hasNext()) {
                ((ValueComponent)iterator.next()).pz();
            }
        }
    }

    @Generated
    public Module getModule() {
        return this.module;
    }

    @Generated
    public Vector2f getScale() {
        return this.scale;
    }

    @Generated
    public boolean oJ() {
        return this.axv;
    }

    @Generated
    public ArrayList<ValueComponent> getValueList() {
        return this.valueList;
    }

    @Generated
    public Vector2d getPosition() {
        return this.position;
    }

    @Generated
    public double getOpacity() {
        return this.opacity;
    }

    @Generated
    public a lN() {
        return this.rG;
    }

    @Generated
    public Animation oL() {
        return this.axx;
    }

    @Generated
    public Animation pB() {
        return this.aye;
    }

    @Generated
    public Animation pC() {
        return this.ayf;
    }

    @Generated
    public boolean pD() {
        return this.ayg;
    }
}
