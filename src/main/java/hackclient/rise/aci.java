package hackclient.rise;

import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.font.FontManager;
import com.alan.clients.util.gui.GUIUtil;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2f;
import lombok.Generated;
import net.minecraft.util.StringUtils;
import rip.vantage.commons.util.time.a;

public class aci implements InstanceAccess {
    private String azY;
    private String azZ;
    private Runnable aAa;
    private Vector2f alh = new Vector2f(86.450005F, 86.450005F);
    private Animation aAb = new Animation(Easing.LINEAR, 200L);
    private Animation aAc = new Animation(Easing.EASE_OUT_EXPO, 500L);
    private Vector2f axI;
    private a asY;
    private agc aAd = FontManager.MAIN.a(20, gd.REGULAR);

    public aci(String var1, String var2) {
        this.azY = StringUtils.b(this.aAd, var2, 86.450005F - 20);
        this.azZ = var1;
        this.aAa = null;
    }

    public aci(String var1, String var2, Runnable var3) {
        String s = org.apache.commons.lang3.StringUtils.capitalize(var2);
        this.azY = StringUtils.b(this.aAd, s, 86.450005F - 20);
        this.aAa = var3;
        this.azZ = var1;
    }

    public void j(Vector2f var1) {
        this.axI = new Vector2f(var1.x, var1.y);
        if (!(this.axI.x + this.alh.x < this.getStandardClickGUI().axI.x + this.getStandardClickGUI().axJ.aym)
            && !(this.axI.x > this.getStandardClickGUI().axI.x + this.getStandardClickGUI().axJ.aym + this.getStandardClickGUI().alh.x)) {
            this.aAb.Q(this.qz() ? 75.0 : 0.0);
            this.aAc.Q(this.qz() ? 5.0 : 0.0);
            RenderUtil.roundedRectangle(this.axI.x, this.axI.y, this.alh.x, this.alh.y, 8.0, abw.OVERLAY.pV());
            RenderUtil.roundedRectangle(var1.x, var1.y, this.alh.x, this.alh.y, 8.0, abw.OVERLAY.Y((int)this.aAb.sG()));
            this.axI.y = this.axI.y + (this.alh.y / 2.0F - this.aAd.height() / 2.0F + 1.0F - 10 / 4.0F);
            this.aAd.c(this.azY, this.axI.x + this.alh.x / 2.0F, this.axI.y, abw.SECONDARY_TEXT.pW());
            this.axI.y = this.axI.y + (this.aAd.height() + 10 / 2.0F);
            this.k(this.axI);
            this.axI = new Vector2f(var1.x, var1.y);
        }
    }

    public void f(int var1, int var2, int var3) {
        if (this.axI != null) {
            if (GUIUtil.a(this.axI, this.alh, var1, var2) && this.aAa != null) {
                this.aAa.run();
            }
        }
    }

    public boolean qz() {
        return GUIUtil.a(this.axI, this.alh, afl.sW().getX(), afl.sW().getY());
    }

    public void k(Vector2f var1) {
        FontManager.MAIN.a(16, gd.REGULAR).c(this.azZ, var1.x + this.alh.x / 2.0F, var1.y, abw.TRINARY_TEXT.pW());
    }

    @Generated
    public String getTitle() {
        return this.azY;
    }

    @Generated
    public String getAction() {
        return this.azZ;
    }

    @Generated
    public Runnable qA() {
        return this.aAa;
    }

    @Generated
    public Vector2f oX() {
        return this.alh;
    }

    @Generated
    public Animation qB() {
        return this.aAb;
    }

    @Generated
    public Animation qC() {
        return this.aAc;
    }

    @Generated
    public Vector2f oW() {
        return this.axI;
    }

    @Generated
    public a qD() {
        return this.asY;
    }

    @Generated
    public agc qE() {
        return this.aAd;
    }

    @Generated
    public void aI(String var1) {
        this.azY = var1;
    }

    @Generated
    public void aJ(String var1) {
        this.azZ = var1;
    }

    @Generated
    public void e(Runnable var1) {
        this.aAa = var1;
    }

    @Generated
    public void l(Vector2f var1) {
        this.alh = var1;
    }

    @Generated
    public void b(Animation var1) {
        this.aAb = var1;
    }

    @Generated
    public void c(Animation var1) {
        this.aAc = var1;
    }

    @Generated
    public void i(Vector2f var1) {
        this.axI = var1;
    }

    @Generated
    public void b(a var1) {
        this.asY = var1;
    }

    @Generated
    public void b(agc var1) {
        this.aAd = var1;
    }
}
