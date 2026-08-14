package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.module.api.Category;
import com.alan.clients.ui.click.standard.RiseClickGUI;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import java.awt.Color;
import net.minecraft.client.renderer.GlStateManager;

public final class abe implements InstanceAccess {
    private final Animation ayh = new Animation(Easing.LINEAR, 500L);
    public final Category ayi;
    private long ayj = 0L;
    private double ayk;
    private float x;
    private float y;
    private boolean ji;

    public abe(Category var1) {
        this.ayi = var1;
    }

    public void a(double var1, double var3, double var5, abx var7) {
        RiseClickGUI riseclickgui = Client.a.v();
        if (System.currentTimeMillis() - this.ayj > 300L) {
            this.ayj = System.currentTimeMillis();
        }

        long i = System.currentTimeMillis();
        this.x = (float)(riseclickgui.axI.x - (69.0 - var3) - 21.0);
        this.y = (float)(riseclickgui.axI.y + var1) + 16.0F;
        this.ayh.h(200L);
        this.ayh.Q(var7.equals(this.ayi.ec()) ? 255.0 : 0.0);
        double d0 = gb.MAIN.a(16, gd.REGULAR).getStringWidth(ahd.ce(this.ayi.getName())) + 8.0 + this.ayi.eb().getStringWidth(this.ayi.ea());
        GlStateManager.pushMatrix();
        RenderUtil.roundedRectangle(
            this.x, this.y - 5.5, d0 + 8.0, 15.0, 5.0, aip.d(this.rz().j(new Vector2d(0.0, this.y / 5.0)), (int)Math.min(this.ayh.sG(), var5)).darker()
        );
        int j = new Color(255, 255, 255, Math.min(var7.equals(this.ayi.ec()) ? 255 : 200, (int)var5)).hashCode();
        this.ayi.eb().a(this.ayi.ea(), (float)(this.x + this.ayh.sG() / 80.0 + 3.0), this.y, j);
        gb.MAIN
            .a(16, gd.REGULAR)
            .a(ahd.ce(this.ayi.getName()), (float)(this.x + this.ayh.sG() / 80.0 + 3.0 + 4.0) + gb.ICONS_1.o(17).getStringWidth(this.ayi.ea()), this.y, j);
        GlStateManager.popMatrix();
        this.ayj = i;
    }

    public void a(float var1, float var2, int var3) {
        boolean flag = var3 == 0;
        if (agj.c(this.x - 11.0F, this.y - 5.0F, 70.0, 22.0, var1, var2) && flag) {
            this.getStandardClickGUI().switchScreen(this.ayi);
            this.ji = true;
        }
    }

    public void F(double var1) {
        double d0 = gb.MAIN.a(16, gd.REGULAR).getStringWidth(ahd.ce(this.ayi.getName())) + 8.0 + this.ayi.eb().getStringWidth(this.ayi.ea());
        RenderUtil.roundedRectangle(
            this.x, this.y - 5.0F, d0 + 8.0, 14.0, 5.0, aip.d(this.rz().j(new Vector2d(0.0, this.y / 5.0)), (int)Math.min(this.ayh.sG(), var1)).darker()
        );
    }

    public void pE() {
        this.ji = false;
    }
}
