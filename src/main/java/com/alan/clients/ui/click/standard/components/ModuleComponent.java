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
import com.alan.clients.ui.click.standard.UIColors;
import com.alan.clients.util.gui.GUIUtil;
import hackclient.rise.ahd;
import com.alan.clients.util.render.ColorUtil;
import com.alan.clients.util.font.FontManager;
import com.alan.clients.util.font.FontWeight;
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

    public ModuleComponent(Module module) {
        this.module = module;
        this.aye.T(this.scale.y);
        this.ayf.T(0.0);
        module.getAllValues().forEach(var1x -> {
            ValueComponent valueComponent = var1x.wl();
            if (valueComponent != null) {
                this.valueList.add(valueComponent);
            }
        });
    }

    public void draw(Vector2d position, int var2, int var3, float var4) {
        this.position = position;
        float f = 38.0F;
        float f1 = f;
        boolean flag = position != null
            && !(position.y + this.scale.y < this.getStandardClickGUI().axI.y)
            && !(position.y > this.getStandardClickGUI().axI.y + this.getStandardClickGUI().alh.y);
        if (flag) {
            RiseClickGUI riseclickgui = this.getStandardClickGUI();
            RenderUtil.roundedRectangle(position.x, position.y, this.scale.x, this.scale.y, 6.0, UIColors.OVERLAY.pV());
            Color color = UIColors.TEXT.Y(this.module.isEnabled() ? 255 : 200);
            boolean flag1 = GUIUtil.c(position.x, position.y, this.scale.x, this.scale.y, var2, var3);
            this.axx.Q(flag1 ? (this.ayg ? 35.0 : 20.0) : 0.0);
            RenderUtil.roundedRectangle(position.x, position.y, this.scale.x, this.scale.y, 6.0, ColorUtil.d(Color.BLACK, (int)this.axx.sG()));
            if (riseclickgui.pa() instanceof SearchScreen) {
                FontManager.MAIN
                    .a(15, FontWeight.REGULAR)
                    .a(
                        "(" + ahd.ce(this.module.getModuleInfo().category().getName()) + ")",
                        (float)(position.getX() + FontManager.MAIN.a(20, FontWeight.REGULAR).getStringWidth(this.module.getName()) + 10.0),
                        (float)position.getY() + 10.0F,
                        ColorUtil.d(color, 64).hashCode()
                    );
            }

            FontManager.MAIN
                .a(20, FontWeight.REGULAR)
                .a(
                    this.module.getName(),
                    (float)position.x + 6.0F,
                    (float)position.y + 8.0F,
                    this.module.isEnabled() ? this.rz().getAccentColor(new Vector2d(0.0, position.y / 5.0)).getRGB() : color.getRGB()
                );
            FontManager.MAIN.a(15, FontWeight.REGULAR).a(ahd.ce(this.module.getModuleInfo().description()), (float)position.x + 6.0F, (float)position.y + 25.0F, ColorUtil.d(color, 70).hashCode());
            this.scale = new Vector2f(this.getStandardClickGUI().axY.x, f1);
        }

        if (!this.aye.isFinished() || this.axv) {
            for (ValueComponent valueComponent : this.getValueList()) {
                if ((valueComponent.getValue() == null || valueComponent.getValue().wm() == null || !valueComponent.getValue().wm().getAsBoolean()) && (valueComponent.getValue().wn() == null || !valueComponent.getValue().wn().getAsBoolean())) {
                    valueComponent.U(valueComponent.position == null ? 0 : (valueComponent.position.y < position.y + this.aye.sG() + 15.0 ? (int)this.ayf.sG() : 0));
                    valueComponent.U(valueComponent.getValue().wm() == null ? valueComponent.pT() : Math.max(valueComponent.pT() - 40, 0));
                    if (flag) {
                        valueComponent.draw(
                            new Vector2d(position.x + 6.0 + (valueComponent.getValue().wm() == null ? 0 : 10) + (valueComponent.getValue().wn() == null ? 0 : 10), (float)(position.y + f1 + 1.0)),
                            var2,
                            var3,
                            var4
                        );
                    }

                    f1 = (float)(f1 + valueComponent.getHeight());
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

                    for (ValueComponent valueComponent : this.getValueList()) {
                        if (valueComponent instanceof abn abn) {
                            abn.ayI = abn.ayJ = false;
                        } else if (valueComponent instanceof abt) {
                            ((abt)valueComponent).azi = false;
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
                    for (ValueComponent valueComponent : this.getValueList()) {
                        if (valueComponent.getValue() != null
                            && (valueComponent.getValue().wm() == null || !valueComponent.getValue().wm().getAsBoolean())
                            && (valueComponent.getValue().wn() == null || !valueComponent.getValue().wn().getAsBoolean())) {
                            valueComponent.released();
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
