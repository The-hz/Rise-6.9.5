package hackclient.rise;

import com.alan.clients.ui.click.standard.RiseClickGUI;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.util.vector.Vector2f;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import lombok.Generated;

public final class aby implements abx, InstanceAccess {
    private RiseClickGUI H;
    private ach azx = new ach(new ArrayList<>(), new Vector2f(0.0F, 0.0F), this.rz().rA());
    private ach azy = new ach(new ArrayList<>(), new Vector2f(0.0F, 0.0F), this.rz().rA());
    private float azz = 10.0F;
    public ArrayList<abl> cj = new ArrayList<>();

    public aby() {
    }

    @Override
    public void aT() {
    }

    @Override
    public void b(int var1, int var2, float var3) {
        Vector2f vector2f = new Vector2f(this.H.oW()).h(this.azz, 0.0F);
        RenderUtil.roundedRectangle(vector2f.getX(), vector2f.getY() + this.azz, this.H.alh.x - this.azz * 2.0F, 100.0, this.H.pl(), abw.SECONDARY.pV());
        this.azx.b(this.rz().rA());
        this.azx.i(new Vector2f(vector2f.h(this.azz, 0.0F)));
        this.azx.qx();
        this.azy.b(this.rz().rB());
        this.azy.i(new Vector2f(vector2f.h(this.azz, 0.0F)));
        this.azy.qx();
        Vector2f vector2f1 = vector2f.h(0.0F, 100.0F);
        Vector2f vector2f2 = vector2f1.h(0.0F, this.azz * 2.0F);
        RenderUtil.roundedRectangle(
            vector2f2.getX(),
            vector2f2.getY(),
            this.H.alh.x - this.azz * 2.0F,
            this.H.oX().getY() - (vector2f2.getY() - this.H.oW().getY()) - this.azz,
            this.H.pl(),
            abw.SECONDARY.pV()
        );
        Vector2f vector2f3 = vector2f2.h(0.0F, this.azz);

        for (abl abl : this.pA()) {
            if (abl.pS() == null || abl.pS().wm() == null || !abl.pS().wm().getAsBoolean()) {
                abl.U(200);
                abl.a(new Vector2d(vector2f3.x + 1.0F + this.azz + (abl.pS().wm() == null ? 0 : 10), vector2f3.y), var1, var2, var3);
                vector2f3 = vector2f3.h(0.0F, (float)abl.da());
            }
        }
    }

    @Override
    public void a(char var1, int var2) {
        Iterator iterator = this.pA().iterator();

        while (iterator.hasNext()) {
            ((abl)iterator.next()).b(var1, var2);
        }
    }

    @Override
    public void f(int var1, int var2, int var3) {
        for (abl abl : this.pA()) {
            if ((abl.pS() == null || abl.pS().wm() == null || !abl.pS().wm().getAsBoolean()) && abl.e(var1, var2, var3)) {
                break;
            }
        }
    }

    @Override
    public void oG() {
        Iterator iterator = this.pA().iterator();

        while (iterator.hasNext()) {
            ((abl)iterator.next()).pz();
        }
    }

    @Override
    public void pY() {
        new Vector2f(this.H.oW());
        this.azx.pY();
        this.azy.pY();
    }

    @Override
    public boolean qa() {
        return true;
    }

    @Override
    public boolean pZ() {
        return this.cj.stream().noneMatch(var0 -> {
            for (Field field : var0.getClass().getDeclaredFields()) {
                if (field.getType().equals(agm.class)) {
                    try {
                        return ((agm)field.get(var0)).tO();
                    } catch (IllegalAccessException illegalaccessexception) {
                    }
                }
            }

            return false;
        });
    }

    @Generated
    @Override
    public RiseClickGUI getStandardClickGUI() {
        return this.H;
    }

    @Generated
    public ach qb() {
        return this.azx;
    }

    @Generated
    public ach qc() {
        return this.azy;
    }

    @Generated
    public float qd() {
        return this.azz;
    }

    @Generated
    public ArrayList<abl> pA() {
        return this.cj;
    }

    @Generated
    public void a(RiseClickGUI var1) {
        this.H = var1;
    }

    @Generated
    public void a(ach var1) {
        this.azx = var1;
    }

    @Generated
    public void b(ach var1) {
        this.azy = var1;
    }

    @Generated
    public void v(float var1) {
        this.azz = var1;
    }

    @Generated
    public void a(ArrayList<abl> var1) {
        this.cj = var1;
    }
}
