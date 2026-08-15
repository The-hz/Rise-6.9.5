package hackclient.rise;

import com.alan.clients.ui.theme.Themes;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.font.FontManager;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.render.ColorUtil;
import com.alan.clients.util.render.RenderUtil;
import java.awt.Color;
import lombok.Generated;

public class abj implements InstanceAccess {
    private final Themes ayt;
    private aka ayu = new aka(0.0, 0.0, 0.0);
    private final Animation ayv = new Animation(Easing.EASE_OUT_QUINT, 500L);
    private final Animation ayw = new Animation(Easing.EASE_OUT_QUINT, 500L);
    private final Animation ayx = new Animation(Easing.EASE_OUT_QUINT, 500L);
    private final Animation ayy = new Animation(Easing.EASE_OUT_QUINT, 500L);

    public void k(double var1, double var3) {
        int i = (int)this.ayx.sG();
        boolean flag = this.ayt.equals(this.rz());
        Color color = flag ? new Color(15, 19, 26, (int)this.ayx.sG()) : new Color(18, 21, 30, i);
        double d0 = this.ayv.sG();
        double d1 = this.ayw.sG() + var1;
        RenderUtil.roundedRectangle(d0, d1, var3, 50.0, 10.0, color);
        if (this.ayt.isTriColor()) {
            RenderUtil.a(d0, d1, var3, 30.0, 9.0, ColorUtil.d(this.ayt.rA(), i), ColorUtil.d(this.ayt.rB(), i), ColorUtil.d(this.ayt.rC(), i), false, true, true, false, false);
        } else {
            RenderUtil.a(d0, d1, var3, 30.0, 9.0, ColorUtil.d(this.ayt.rA(), i), ColorUtil.d(this.ayt.rB(), i), false, true, true, false, false);
        }

        RenderUtil.d(d0, d1 + 30.0, var3, 10.0, color);
        FontManager.MAIN.a(16, gd.REGULAR).c(this.ayt.getThemeName(), d0 + var3 / 2.0, d1 + 37.0, flag ? ColorUtil.d(this.rz().rA(), i).getRGB() : new Color(255, 255, 255, i).getRGB());
        this.ayy.Q(this.ayt.equals(this.rz()) ? 255.0 : 0.0);
        int j = (int)Math.min(this.ayy.sG(), i);
        if (j > 0 && this.getStandardClickGUI().axS > 0.8) {
            this.b(gg.BLOOM, 3)
                .c(
                    () -> {
                        if (this.ayt.isTriColor()) {
                            RenderUtil.a(
                                d0,
                                d1,
                                var3,
                                30.0,
                                10.0,
                                ColorUtil.d(this.ayt.rA(), i),
                                ColorUtil.d(this.ayt.rB(), i),
                                ColorUtil.d(this.ayt.rC(), i),
                                false,
                                true,
                                true,
                                false,
                                false
                            );
                        } else {
                            RenderUtil.a(
                                d0 + 1.0, d1, var3 - 2.0, 30.0, 10.0, ColorUtil.d(this.ayt.rA(), j), ColorUtil.d(this.ayt.rB(), j), false, true, true, false, false
                            );
                        }

                        FontManager.MAIN.a(16, gd.REGULAR).c(this.ayt.getThemeName(), d0 + var3 / 2.0, d1 + 37.0, ColorUtil.d(this.ayt.rA(), j).getRGB());
                    }
                );
        }

        this.ayu = new aka(d0, d1, var3);
    }

    @Generated
    public Themes pK() {
        return this.ayt;
    }

    @Generated
    public aka pL() {
        return this.ayu;
    }

    @Generated
    public Animation pM() {
        return this.ayv;
    }

    @Generated
    public Animation pN() {
        return this.ayw;
    }

    @Generated
    public Animation pp() {
        return this.ayx;
    }

    @Generated
    public Animation pO() {
        return this.ayy;
    }

    @Generated
    public abj(Themes var1) {
        this.ayt = var1;
    }
}
