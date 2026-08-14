package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.module.api.Category;
import com.alan.clients.ui.click.standard.RiseClickGUI;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.render.RenderUtil;
import java.awt.Color;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Generated;
import org.lwjgl.input.Mouse;

public final class abf implements InstanceAccess {
    private final List<abe> ayl;
    public double aym = 100.0;
    private double axT;
    private double ayn;
    private boolean ayo;
    private long ayj = 0L;
    private Animation animation = new Animation(Easing.EASE_OUT_EXPO, 300L);
    private Animation ayp = new Animation(Easing.LINEAR, 300L);

    public abf() {
        this.ayl = Arrays.stream(Category.values()).map(abe::new).collect(Collectors.toList());
    }

    public void pF() {
        RiseClickGUI riseclickgui = Client.a.v();
        Color color = abw.SECONDARY.Y((int)this.axT);
        this.animation.h(this.ayo ? 700L : 2000L);
        this.animation.Q(this.ayo ? 0.0 : -this.aym / 1.5);
        RenderUtil.a(
            riseclickgui.axI.x,
            riseclickgui.axI.y,
            this.aym + this.animation.sG(),
            riseclickgui.alh.y,
            this.getStandardClickGUI().pl(),
            color,
            true,
            false,
            false,
            true
        );
        this.ayp.h(1000L);
        this.ayp.Q(riseclickgui.oZ().qa() ? 255.0 : 0.0);
        RenderUtil.c(
            riseclickgui.axI.x + this.aym + this.animation.sG(),
            riseclickgui.axI.y,
            30.0,
            riseclickgui.alh.y,
            aip.d(Color.BLACK, (int)Math.min(this.ayp.sG(), this.axT / 7.0)),
            new Color(0, 0, 0, 0)
        );
    }

    public void d(float var1, float var2) {
        RiseClickGUI riseclickgui = Client.a.v();
        long i = System.currentTimeMillis();
        if (this.ayj == 0L) {
            this.ayj = i;
        }

        boolean flag = riseclickgui.axK.qa();
        if (this.ayo = (!Mouse.isButtonDown(0) || this.ayo)
                && agj.c(riseclickgui.axI.x - 200.0F, riseclickgui.axI.y, this.ayo ? 310.0 : 210.0, riseclickgui.alh.y, var1, var2)
            || !flag) {
            this.axT = Math.min(this.axT + (i - this.ayj) * 2L, 255.0);
        } else {
            this.axT = Math.max(this.axT - (float)(i - this.ayj) * 1.5F, 0.0);
        }

        if (agj.c(riseclickgui.axI.x, riseclickgui.axI.y, this.ayn > 0.0 ? 70.0 : 10.0, riseclickgui.alh.y, var1, var2) && flag) {
            this.ayn = Math.min(this.ayn + (i - this.ayj) * 2L, 255.0);
        } else {
            this.ayn = Math.max(this.ayn - (i - this.ayj), 0.0);
        }

        this.ayj = i;
        double d0 = 10.0;

        for (abe abe : this.ayl) {
            abe.a(d0 += 19.5, this.aym + this.animation.sG(), (int)this.axT, riseclickgui.axK);
        }

        float f = (float)(riseclickgui.axI.getX() + 9.0F + this.animation.sG());
        float f1 = riseclickgui.axI.getY() + (24.75F - gb.MAIN.a(42, gd.REGULAR).tq() / 2.0F);
        gb.MAIN.a(32, gd.REGULAR).a(Client.b, f + 5.0F, f1 + 2.0F, aip.d(Color.WHITE, (int)this.axT).hashCode());
        gb.MAIN
            .a(16, gd.REGULAR)
            .a("6.9.5", f + 5.0F + gb.MAIN.a(32, gd.REGULAR).getStringWidth(Client.b), f1, aip.d(this.rz().rA(), (int)Math.min(this.axT, 200.0)).getRGB());
    }

    public void ci() {
        Iterator iterator = this.ayl.iterator();

        while (iterator.hasNext()) {
            ((abe)iterator.next()).F(this.axT);
        }
    }

    public void b(float var1, float var2, int var3) {
        if (this.axT > 0.0) {
            Iterator iterator = this.ayl.iterator();

            while (iterator.hasNext()) {
                ((abe)iterator.next()).a(var1, var2, var3);
            }
        }
    }

    public void pE() {
        if (this.axT > 0.0) {
            Iterator iterator = this.ayl.iterator();

            while (iterator.hasNext()) {
                ((abe)iterator.next()).pE();
            }
        }
    }

    @Generated
    public boolean pG() {
        return this.ayo;
    }
}
