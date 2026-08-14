package hackclient.rise;

import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.impl.render.ClickGUI;
import com.alan.clients.module.impl.render.Interface;
import com.alan.clients.util.vector.Vector2d;
import java.awt.Color;
import lombok.Generated;

public final class zc {
    public Module cg;
    public Vector2d apP = new Vector2d(5000.0, 0.0);
    public Vector2d atg = new Vector2d(5000.0, 0.0);
    public float ath;
    public String ati = "";
    public float atj = 0.0F;
    public float atk;
    public Color amH = Color.WHITE;
    public String atl = "";
    public boolean atm = false;
    public String atn = "";
    public String ato = "";
    public boolean atp;

    public float nq() {
        return this.atj + this.atk;
    }

    public zc(Module var1) {
        this.cg = var1;
    }

    public boolean a(Interface var1) {
        if (this.dl() instanceof ClickGUI) {
            return false;
        }

        if (!this.dl().getModuleInfo().allowDisable()) {
            return false;
        }

        String s = var1.lE().wo().getName();
        byte b0 = -1;
        switch (s.hashCode()) {
            case 65921:
                if (s.equals("All")) {
                    b0 = 0;
                }
                break;
            case 672585770:
                if (s.equals("Only bound")) {
                    return this.dl().getKey() != 0;
                }
                break;
            case 1771450044:
                if (s.equals("Exclude render")) {
                    return !this.dl().getModuleInfo().category().equals(Category.RENDER);
                }
        }

        switch (b0) {
            case 0:
                return true;
            case 1:
                return !this.dl().getModuleInfo().category().equals(Category.RENDER);
            case 2:
                return this.dl().getKey() != 0;
            default:
                return true;
        }
    }

    @Generated
    public Module dl() {
        return this.cg;
    }

    @Generated
    public Vector2d nr() {
        return this.apP;
    }

    @Generated
    public Vector2d ns() {
        return this.atg;
    }

    @Generated
    public float nt() {
        return this.ath;
    }

    @Generated
    public String getTag() {
        return this.ati;
    }

    @Generated
    public float nu() {
        return this.atj;
    }

    @Generated
    public float nv() {
        return this.atk;
    }

    @Generated
    public Color nw() {
        return this.amH;
    }

    @Generated
    public String nx() {
        return this.atl;
    }

    @Generated
    public boolean ny() {
        return this.atm;
    }

    @Generated
    public String getDisplayName() {
        return this.atn;
    }

    @Generated
    public String nz() {
        return this.ato;
    }

    @Generated
    public boolean nA() {
        return this.atp;
    }

    @Generated
    public void k(Module var1) {
        this.cg = var1;
    }

    @Generated
    public void h(Vector2d var1) {
        this.apP = var1;
    }

    @Generated
    public void i(Vector2d var1) {
        this.atg = var1;
    }

    @Generated
    public void s(float var1) {
        this.ath = var1;
    }

    @Generated
    public void an(String var1) {
        this.ati = var1;
    }

    @Generated
    public void t(float var1) {
        this.atj = var1;
    }

    @Generated
    public void u(float var1) {
        this.atk = var1;
    }

    @Generated
    public void b(Color var1) {
        this.amH = var1;
    }

    @Generated
    public void ao(String var1) {
        this.atl = var1;
    }

    @Generated
    public void x(boolean var1) {
        this.atm = var1;
    }

    @Generated
    public void ap(String var1) {
        this.atn = var1;
    }

    @Generated
    public void aq(String var1) {
        this.ato = var1;
    }

    @Generated
    public void y(boolean var1) {
        this.atp = var1;
    }
}
