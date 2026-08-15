package hackclient.rise;

import com.alan.clients.ui.click.standard.RiseClickGUI;
import com.alan.clients.util.font.FontManager;
import com.alan.clients.util.gui.GUIUtil;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.vector.Vector2f;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import lombok.Generated;
import org.jetbrains.annotations.NotNull;

public class acj extends ArrayList<aci> implements InstanceAccess {
    private String gK;
    private static float aAe = 10.0F;
    private Vector2f axI;
    private agk scrollUtil = new agk();

    public acj(int var1, String var2) {
        super(var1);
        this.gK = var2;
    }

    public acj(String var1) {
        this.gK = var1;
    }

    public acj(@NotNull Collection<? extends aci> var1, String var2) {
        super(var1);
        this.gK = var2;
    }

    public void j(Vector2f var1) {
        try {
            RiseClickGUI riseclickgui = this.getStandardClickGUI();
            this.axI = new Vector2f(var1.x, var1.y);
            FontManager.MAIN.a(18, gd.REGULAR).a(this.gK, this.axI.x, this.axI.y, Color.WHITE.getRGB());
            String s = this.size() + "";
            FontManager.MAIN.a(18, gd.REGULAR).a(s, this.axI.x + FontManager.MAIN.a(18, gd.REGULAR).getStringWidth(this.gK) + 10 / 2.0F, this.axI.y, this.rz().rA().getRGB());
            if (!this.isEmpty()) {
                this.scrollUtil.E(this.qz());
                this.scrollUtil.V(-this.size() * (10 + this.get(0).oX().x) + this.getStandardClickGUI().alh.x - this.getStandardClickGUI().axJ.aym - 10);
                if (!this.scrollUtil.bd()) {
                    this.scrollUtil.aJc = (float)Math.round(this.scrollUtil.aJc / (10 + this.get(0).oX().x)) * (10 + this.get(0).oX().x);
                }

                this.axI.y = this.axI.y + (10 + FontManager.MAIN.a(18, gd.REGULAR).height());
                this.axI.x = (float)(this.axI.x + this.scrollUtil.tE());

                for (aci aci : this) {
                    if (!(this.axI.x > riseclickgui.getScale().x + riseclickgui.getPosition().x) && !(this.axI.x + aci.oX().x < riseclickgui.axI.x + riseclickgui.axJ.aym)) {
                        aci.j(this.axI);
                    }

                    this.axI.x = this.axI.x + (10 + aci.oX().x);
                }
            }

            this.axI = new Vector2f(var1.x, var1.y);
        } catch (ConcurrentModificationException concurrentmodificationexception) {
            concurrentmodificationexception.printStackTrace();
        }
    }

    public int getHeight() {
        return (int)((this.isEmpty() ? 0.0F : this.get(0).oX().getY()) + 10 + FontManager.MAIN.a(18, gd.REGULAR).height());
    }

    public void f(int var1, int var2, int var3) {
        Iterator iterator = this.iterator();

        while (iterator.hasNext()) {
            ((aci)iterator.next()).f(var1, var2, var3);
        }
    }

    public void qF() {
        if (this.axI != null) {
            if (this.qz()) {
                aca.azE = false;
            }
        }
    }

    public boolean qz() {
        return this.isEmpty()
            ? false
            : GUIUtil.a(this.getStandardClickGUI().axI, this.getStandardClickGUI().alh, afl.sW())
                && GUIUtil.a(
                    new Vector2f((float)(this.getStandardClickGUI().axI.x + this.getStandardClickGUI().axJ.aym), this.axI.y),
                    new Vector2f((float)(this.getStandardClickGUI().alh.x - this.getStandardClickGUI().axJ.aym), this.get(0).oX().y + 20 + 10.0F),
                    afl.sW()
                );
    }

    public void init() {
        this.qe().setScroll(0.0);
        this.qe().U(0.0);
    }

    @Generated
    public String getName() {
        return this.gK;
    }

    @Generated
    public Vector2f oW() {
        return this.axI;
    }

    @Generated
    public agk qe() {
        return this.scrollUtil;
    }

    @Generated
    public void setName(String var1) {
        this.gK = var1;
    }

    @Generated
    public void i(Vector2f var1) {
        this.axI = var1;
    }

    @Generated
    public void a(agk var1) {
        this.scrollUtil = var1;
    }
}
