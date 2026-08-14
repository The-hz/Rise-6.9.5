package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.ui.click.standard.RiseClickGUI;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.vector.Vector2d;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import lombok.Generated;
import rip.vantage.commons.util.time.a;

public final class acb implements abx, InstanceAccess {
    public final agm azM = new agm(new Vector2d(200.0, 200.0), gb.MAIN.a(20, gd.REGULAR), Color.WHITE, agl.CENTER, "Start typing to search...", 150.0F);
    private final a azN = new a();
    public agk scrollUtil = new agk();
    public ArrayList<abd> azB = new ArrayList<>();
    private double axT = 255.0;
    private double azC;
    private double azD;
    private boolean azO;

    public acb() {
    }

    @Override
    public void b(int var1, int var2, float var3) {
        RiseClickGUI riseclickgui = this.getStandardClickGUI();
        if (this.scrollUtil.tD() < 0.0) {
            this.axT = this.axT - this.azN.aKx() * 4L;
        } else {
            this.axT = this.axT + this.azN.aKx() * 4L;
        }

        this.axT = Math.min(Math.max(0.0, this.axT), 255.0);
        this.azM.b(abw.TEXT.Y((int)this.axT));
        Vector2d vector2d = new Vector2d(
            riseclickgui.axI.x + riseclickgui.axJ.aym + (riseclickgui.alh.x - riseclickgui.axJ.aym) / 2.0,
            (float)(riseclickgui.axI.y + 17.0F + this.scrollUtil.tE())
        );
        this.azM.h(vector2d);
        this.azM.pJ();
        this.scrollUtil.qx();
        double d0 = riseclickgui.axI.y + 35.0F + this.scrollUtil.tE();
        this.azD = d0;
        double d1 = 0.0;

        for (abd abd : this.azB) {
            abd.a(new Vector2d(riseclickgui.axI.x + riseclickgui.axJ.aym + 4.0, d0), var1, var2, var3);
            d0 += abd.alh.y + 5.0F;
            d1 += abd.alh.y + 5.0F;
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

        this.azM.b(var1, var2);
        this.scrollUtil.U(0.0);
        this.azB = this.aG(this.azM.getText());
        Iterator iterator = this.qf().iterator();

        while (iterator.hasNext()) {
            ((abd)iterator.next()).b(var1, var2);
        }
    }

    @Override
    public void f(int var1, int var2, int var3) {
        Iterator iterator = this.azB.iterator();

        while (iterator.hasNext()) {
            ((abd)iterator.next()).d(var1, var2, var3);
        }

        this.azM.d(var1, var2, var3);
    }

    @Override
    public void oG() {
        Iterator iterator = this.qf().iterator();

        while (iterator.hasNext()) {
            ((abd)iterator.next()).pz();
        }
    }

    @Override
    public void pY() {
        Iterator iterator = this.qf().iterator();

        while (iterator.hasNext()) {
            ((abd)iterator.next()).ci();
        }
    }

    @Override
    public void aT() {
        this.azB = this.aG(this.azM.getText());
        this.azO = false;
    }

    public ArrayList<abd> aG(String var1) {
        ArrayList arraylist = new ArrayList();

        for (abd abd : Client.a.v().pg()) {
            String[] astring = abd.dl().getAliases();
            int i = astring.length;

            for (int j = 0; j < i; j++) {
                if (astring[j].toLowerCase().replaceAll(" ", "").contains(var1.toLowerCase().replaceAll(" ", ""))) {
                    arraylist.add(abd);
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
            for (abl abl : ((abd)iterator.next()).pA()) {
                if (abl instanceof abv && ((abv)abl).azo.ayU) {
                    return true;
                }
            }
        }

        return false;
    }

    @Generated
    public agm qr() {
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
    public ArrayList<abd> qf() {
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
    public void a(agk var1) {
        this.scrollUtil = var1;
    }

    @Generated
    public void b(ArrayList<abd> var1) {
        this.azB = var1;
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
