package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.module.api.Category;
import com.alan.clients.ui.click.standard.RiseClickGUI;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.vector.Vector2d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;
import lombok.Generated;
import rip.vantage.commons.util.time.a;

public final class abz implements abx, InstanceAccess {
    private final a azA = new a();
    public agk scrollUtil = new agk();
    public ArrayList<abd> azB;
    public Category axt;
    private double azC;
    private double azD;

    public abz() {
    }

    @Override
    public void b(int var1, int var2, float var3) {
        if (this.axt != null) {
            RiseClickGUI riseclickgui = this.getStandardClickGUI();
            this.scrollUtil.qx();
            double d0 = riseclickgui.axI.y + 7.0F + this.scrollUtil.tE();
            this.azD = d0;
            double d1 = 0.0;

            for (abd abd : this.azB) {
                abd.a(new Vector2d(riseclickgui.axI.x + riseclickgui.axJ.aym + 8.0, d0), var1, var2, var3);
                d0 += abd.alh.y + 7.0F;
                d1 += abd.alh.y + 7.0F;
            }

            this.azC = d0;
            double d2 = 7.0;
            double d3 = riseclickgui.oW().getX() + riseclickgui.oX().getX() - 4.0F;
            double d4 = riseclickgui.oW().getY() + d2;
            this.scrollUtil.a(new Vector2d(d3, d4), this.getStandardClickGUI().alh.y - d2 * 2.0);
            this.scrollUtil.V(-d1 + riseclickgui.alh.y - 7.0);
            this.azA.aX();
        }
    }

    @Override
    public void a(char var1, int var2) {
        Iterator iterator = this.qf().iterator();

        while (iterator.hasNext()) {
            ((abd)iterator.next()).b(var1, var2);
        }
    }

    @Override
    public void f(int var1, int var2, int var3) {
        if (this.azB != null) {
            Iterator iterator = this.azB.iterator();

            while (iterator.hasNext()) {
                ((abd)iterator.next()).d(var1, var2, var3);
            }
        }
    }

    @Override
    public void oG() {
        if (this.axt != null) {
            Iterator iterator = this.qf().iterator();

            while (iterator.hasNext()) {
                ((abd)iterator.next()).pz();
            }
        }
    }

    @Override
    public void pY() {
        if (this.axt != null) {
            Iterator iterator = this.qf().iterator();

            while (iterator.hasNext()) {
                ((abd)iterator.next()).ci();
            }
        }
    }

    @Override
    public void aT() {
        this.axt = this.oH();
        if (this.axt != null) {
            this.azB = Client.a
                .v()
                .pg()
                .stream()
                .filter(var1 -> var1.dl().getModuleInfo().category() == this.axt)
                .collect(Collectors.toCollection(ArrayList::new));
        }
    }

    private Category oH() {
        for (Category category : Category.values()) {
            if (category.ec() == this.getStandardClickGUI().oZ()) {
                return category;
            }
        }

        return null;
    }

    @Generated
    public a lN() {
        return this.azA;
    }

    @Generated
    public agk qe() {
        return this.scrollUtil;
    }

    @Generated
    public ArrayList<abd> qf() {
        return this.azB;
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
    public void a(agk var1) {
        this.scrollUtil = var1;
    }

    @Generated
    public void b(ArrayList<abd> var1) {
        this.azB = var1;
    }

    @Generated
    public void b(Category var1) {
        this.axt = var1;
    }

    @Generated
    public void H(double var1) {
        this.azC = var1;
    }

    @Generated
    public void I(double var1) {
        this.azD = var1;
    }
}
