package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.ui.click.standard.RiseClickGUI;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.vector.Vector2d;
import hackclient.rise.abd;
import hackclient.rise.abw;
import hackclient.rise.abx;
import hackclient.rise.agk;
import hackclient.rise.agl;
import hackclient.rise.agm;
import hackclient.rise.ahd;
import hackclient.rise.aip;
import hackclient.rise.gb;
import hackclient.rise.gd;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import lombok.Generated;
import rip.vantage.commons.util.time.a;

public final class acf
implements abx,
InstanceAccess {
    public final agm azR = new agm(new Vector2d(200.0, 200.0), gb.MAIN.a(20, gd.REGULAR), Color.WHITE, agl.CENTER, ahd.ce("ui.search.text"), 150.0f);
    private final a azS = new a();
    public agk scrollUtil = new agk();
    public ArrayList<abd> relevantModules = new ArrayList();
    private double axT = 255.0;
    private double azC;
    private double azD;
    private boolean typedWhileOpen;

    @Override
    public void b(int n2, int n3, float f2) {
        double d2;
        RiseClickGUI riseClickGUI = this.getStandardClickGUI();
        this.axT = this.scrollUtil.tD() < 0.0 ? (this.axT -= (double)(this.azS.aKx() * 4L)) : (this.axT += (double)(this.azS.aKx() * 4L));
        this.axT = Math.min(Math.max(0.0, this.axT), 255.0);
        this.azR.setColor(aip.d(abw.TEXT.pV(), (int)this.axT));
        Vector2d vector2d = new Vector2d((double)riseClickGUI.axI.x + riseClickGUI.axJ.aym + ((double)riseClickGUI.alh.x - riseClickGUI.axJ.aym) / 2.0, (float)((double)(riseClickGUI.axI.y + 17.0f) + this.scrollUtil.tE()));
        this.azR.h(vector2d);
        String string = this.azR.aJm;
        if (riseClickGUI.a(this.azR)) {
            this.azR.aJm = "";
        }
        this.azR.draw();
        this.azR.aJm = string;
        this.scrollUtil.qx();
        this.azD = d2 = (double)(riseClickGUI.axI.y + 35.0f) + this.scrollUtil.tE();
        double d3 = 0.0;
        Iterator<abd> iterator = this.relevantModules.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.azC = d2;
                this.scrollUtil.V(-d3 + (double)riseClickGUI.alh.y - 37.0);
                double d4 = 7.0;
                double d5 = riseClickGUI.getScale().getX() + riseClickGUI.getPosition().getX() - 4.0f;
                double d6 = (double)riseClickGUI.getScale().getY() + d4;
                this.scrollUtil.a(new Vector2d(d5, d6 + 28.0), (double)this.getStandardClickGUI().alh.y - d4 * 2.0 - 28.0);
                this.azS.aX();
                return;
            }
            abd abd2 = iterator.next();
            abd2.draw(new Vector2d((double)riseClickGUI.axI.x + riseClickGUI.axJ.aym + 8.0, d2), n2, n3, f2);
            d2 += (double)(abd2.scale.y + 7.0f);
            d3 += (double)(abd2.scale.y + 7.0f);
        }
    }

    @Override
    public void a(char c2, int n2) {
        if (n2 == 208 || n2 == 200) {
            return;
        }
        if (!(this.typedWhileOpen || this.getStandardClickGUI().oV() || c2 == '\u0000' || Character.isISOControl(c2))) {
            this.typedWhileOpen = true;
            this.setSearchBarText("");
        }
        if (!this.getStandardClickGUI().oV()) {
            this.azR.I(true);
            this.azR.key(c2, n2);
            this.scrollUtil.U(0.0);
        }
        this.relevantModules = this.getRelevantModules(this.azR.getText());
        Iterator<abd> iterator = this.qf().iterator();
        while (iterator.hasNext()) {
            iterator.next().key(c2, n2);
        }
    }

    @Override
    public void f(int n2, int n3, int n4) {
        Iterator<abd> iterator = this.relevantModules.iterator();
        while (iterator.hasNext()) {
            iterator.next().click(n2, n3, n4);
        }
        this.azR.click(n2, n3, n4);
    }

    @Override
    public void oG() {
        Iterator<abd> iterator = this.qf().iterator();
        while (iterator.hasNext()) {
            iterator.next().pz();
        }
    }

    @Override
    public void pY() {
        Iterator<abd> iterator = this.qf().iterator();
        while (iterator.hasNext()) {
            iterator.next().ci();
        }
    }

    @Override
    public void aT() {
        this.relevantModules = this.getRelevantModules(this.azR.getText());
        this.typedWhileOpen = false;
    }

    public ArrayList<abd> getRelevantModules(String string) {
        ArrayList<abd> arrayList = new ArrayList<abd>();
        ArrayList<String> arrayList2 = new ArrayList<String>(Arrays.asList(string.toLowerCase().split(" ")));
        arrayList2.add(string.toLowerCase().replaceAll(" ", ""));
        for (String string2 : arrayList2) {
            for (abd abd2 : Client.a.v().getModuleList()) {
                String[] stringArray = abd2.getModule().getAliases();
                int n2 = stringArray.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    if (!stringArray[i2].toLowerCase().replaceAll(" ", "").contains(string2) || arrayList.contains(abd2)) continue;
                    arrayList.add(abd2);
                }
            }
        }
        return arrayList;
    }

    public void setSearchBarText(String string) {
        this.azR.bW(string);
        this.relevantModules = this.getRelevantModules(this.azR.getText());
    }

    @Generated
    public agm qr() {
        return this.azR;
    }

    @Generated
    public a lN() {
        return this.azS;
    }

    @Generated
    public agk qe() {
        return this.scrollUtil;
    }

    @Generated
    public ArrayList<abd> qf() {
        return this.relevantModules;
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
        return this.typedWhileOpen;
    }

    @Generated
    public void a(agk agk2) {
        this.scrollUtil = agk2;
    }

    @Generated
    public void setRelevantModules(ArrayList<abd> arrayList) {
        this.relevantModules = arrayList;
    }

    @Generated
    public void J(double d2) {
        this.axT = d2;
    }

    @Generated
    public void H(double d2) {
        this.azC = d2;
    }

    @Generated
    public void I(double d2) {
        this.azD = d2;
    }

    @Generated
    public void setTypedWhileOpen(boolean bl) {
        this.typedWhileOpen = bl;
    }
}
