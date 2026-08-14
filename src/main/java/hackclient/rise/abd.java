package hackclient.rise;

import com.alan.clients.module.Module;
import com.alan.clients.ui.click.standard.RiseClickGUI;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.util.vector.Vector2f;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import lombok.Generated;
import rip.vantage.commons.util.time.a;

public class abd implements InstanceAccess {
    public Module cg;
    public Vector2f alh = this.getStandardClickGUI().po();
    public boolean axv;
    public ArrayList<abl> cj = new ArrayList<>();
    public Vector2d apP;
    public double axT;
    public a rG = new a();
    public Animation axx = new Animation(Easing.LINEAR, 50L);
    public Animation aye = new Animation(Easing.LINEAR, 200L);
    public Animation ayf = new Animation(Easing.LINEAR, 5000L);
    public boolean ayg;

    public abd(Module var1) {
        this.cg = var1;
        this.aye.T(this.alh.y);
        this.ayf.T(0.0);
        var1.getAllValues().forEach(var1x -> {
            abl abl = var1x.wl();
            if (abl != null) {
                this.cj.add(abl);
            }
        });
    }

    public void a(Vector2d var1, int var2, int var3, float var4) {
        this.apP = var1;
        float f = 38.0F;
        float f1 = f;
        boolean flag = var1 != null
            && !(var1.y + this.alh.y < this.getStandardClickGUI().axI.y)
            && !(var1.y > this.getStandardClickGUI().axI.y + this.getStandardClickGUI().alh.y);
        if (flag) {
            RiseClickGUI riseclickgui = this.getStandardClickGUI();
            RenderUtil.roundedRectangle(var1.x, var1.y, this.alh.x, this.alh.y, 6.0, abw.OVERLAY.pV());
            Color color = abw.TEXT.Y(this.cg.isEnabled() ? 255 : 200);
            boolean flag1 = agj.c(var1.x, var1.y, this.alh.x, this.alh.y, var2, var3);
            this.axx.Q(flag1 ? (this.ayg ? 35.0 : 20.0) : 0.0);
            RenderUtil.roundedRectangle(var1.x, var1.y, this.alh.x, this.alh.y, 6.0, aip.d(Color.BLACK, (int)this.axx.sG()));
            if (riseclickgui.pa() instanceof acf) {
                gb.MAIN
                    .a(15, gd.REGULAR)
                    .a(
                        "(" + ahd.ce(this.cg.getModuleInfo().category().getName()) + ")",
                        (float)(var1.getX() + gb.MAIN.a(20, gd.REGULAR).getStringWidth(this.cg.getName()) + 10.0),
                        (float)var1.getY() + 10.0F,
                        aip.d(color, 64).hashCode()
                    );
            }

            gb.MAIN
                .a(20, gd.REGULAR)
                .a(
                    this.cg.getName(),
                    (float)var1.x + 6.0F,
                    (float)var1.y + 8.0F,
                    this.cg.isEnabled() ? this.rz().j(new Vector2d(0.0, var1.y / 5.0)).getRGB() : color.getRGB()
                );
            gb.MAIN.a(15, gd.REGULAR).a(ahd.ce(this.cg.getModuleInfo().description()), (float)var1.x + 6.0F, (float)var1.y + 25.0F, aip.d(color, 70).hashCode());
            this.alh = new Vector2f(this.getStandardClickGUI().axY.x, f1);
        }

        if (!this.aye.kv() || this.axv) {
            for (abl abl : this.pA()) {
                if ((abl.pS() == null || abl.pS().wm() == null || !abl.pS().wm().getAsBoolean()) && (abl.pS().wn() == null || !abl.pS().wn().getAsBoolean())) {
                    abl.U(abl.apP == null ? 0 : (abl.apP.y < var1.y + this.aye.sG() + 15.0 ? (int)this.ayf.sG() : 0));
                    abl.U(abl.pS().wm() == null ? abl.pT() : Math.max(abl.pT() - 40, 0));
                    if (flag) {
                        abl.a(
                            new Vector2d(var1.x + 6.0 + (abl.pS().wm() == null ? 0 : 10) + (abl.pS().wn() == null ? 0 : 10), (float)(var1.y + f1 + 1.0)),
                            var2,
                            var3,
                            var4
                        );
                    }

                    f1 = (float)(f1 + abl.da());
                }
            }

            f1--;
        }

        this.aye.h(Math.min((long)f1 * 3L, 450L));
        this.aye.a(Easing.EASE_OUT_EXPO);
        this.aye.Q(this.axv ? f1 : f);
        this.alh.y = (float)this.aye.sG();
        this.ayf.h(this.axv ? this.aye.sB() / 2L : this.aye.sB() / 3L);
        this.ayf.Q(this.axv ? 255.0 : 0.0);
    }

    public void b(char var1, int var2) {
        if (this.apP != null
            && !(this.apP.y + this.alh.y < this.getStandardClickGUI().axI.y)
            && !(this.apP.y > this.getStandardClickGUI().axI.y + this.getStandardClickGUI().alh.y)) {
            if (this.oJ()) {
                Iterator iterator = this.pA().iterator();

                while (iterator.hasNext()) {
                    ((abl)iterator.next()).b(var1, var2);
                }
            }
        }
    }

    public void d(int var1, int var2, int var3) {
        if (this.apP != null
            && !(this.apP.y + this.alh.y < this.getStandardClickGUI().axI.y)
            && !(this.apP.y > this.getStandardClickGUI().axI.y + this.getStandardClickGUI().alh.y)) {
            Vector2f vector2f = this.getStandardClickGUI().axI;
            Vector2f vector2f1 = this.getStandardClickGUI().alh;
            boolean flag = var3 == 0;
            boolean flag1 = var3 == 1;
            boolean flag2 = agj.c(vector2f.x, vector2f.y, vector2f1.x, vector2f1.y, var1, var2);
            if (agj.c(this.apP.x, this.apP.y, this.alh.x, this.getStandardClickGUI().axY.getY() - 3.0F, var1, var2) && this.getStandardClickGUI().axX == null) {
                this.ayg = true;
                double d0 = 0.0;

                for (abl ablxx : this.cj) {
                    d0 += ablxx.da();
                }

                if (flag) {
                    if (flag2) {
                        this.cg.toggle();
                    }
                } else if (flag1 && this.cg.getValues().size() != 0 && d0 != 0.0) {
                    this.axv = !this.axv;

                    for (abl abl : this.pA()) {
                        if (abl instanceof abn abn) {
                            abn.ayI = abn.ayJ = false;
                        } else if (abl instanceof abt) {
                            ((abt)abl).azi = false;
                        }
                    }
                }
            }

            if (this.oJ()) {
                for (abl ablx : this.pA()) {
                    if ((ablx.pS() == null || ablx.pS().wm() == null || !ablx.pS().wm().getAsBoolean())
                        && (ablx.pS().wn() == null || !ablx.pS().wn().getAsBoolean())
                        && ablx.e(var1, var2, var3)) {
                        break;
                    }
                }
            }
        }
    }

    public void ci() {
        if (this.apP != null) {
            if (!(this.apP.y + this.alh.y < this.getStandardClickGUI().axI.y)
                && !(this.apP.y > this.getStandardClickGUI().axI.y + this.getStandardClickGUI().alh.y)) {
                if (!this.aye.kv() || this.axv) {
                    for (abl abl : this.pA()) {
                        if (abl.pS() != null
                            && (abl.pS().wm() == null || !abl.pS().wm().getAsBoolean())
                            && (abl.pS().wn() == null || !abl.pS().wn().getAsBoolean())) {
                            abl.ci();
                        }
                    }
                }
            }
        }
    }

    public void pz() {
        this.ayg = false;
        if (this.oJ()) {
            Iterator iterator = this.pA().iterator();

            while (iterator.hasNext()) {
                ((abl)iterator.next()).pz();
            }
        }
    }

    @Generated
    public Module dl() {
        return this.cg;
    }

    @Generated
    public Vector2f oX() {
        return this.alh;
    }

    @Generated
    public boolean oJ() {
        return this.axv;
    }

    @Generated
    public ArrayList<abl> pA() {
        return this.cj;
    }

    @Generated
    public Vector2d nr() {
        return this.apP;
    }

    @Generated
    public double pj() {
        return this.axT;
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
