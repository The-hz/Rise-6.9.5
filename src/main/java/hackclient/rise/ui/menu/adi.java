package hackclient.rise.ui.menu;

import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.ui.menu.component.button.impl.MenuTextButton;
import com.alan.clients.util.MouseUtil;
import hackclient.rise.agc;
import hackclient.rise.aip;
import hackclient.rise.gb;
import hackclient.rise.gd;
import hackclient.rise.gg;
import java.awt.Color;
import net.minecraft.util.ResourceLocation;

public class adi extends MenuTextButton {
    private static final agc aBZ = gb.MAIN.a(24, gd.BOLD);
    private final ResourceLocation aCa;

    public adi(double var1, double var3, double var5, double var7, Runnable var9, String var10, ResourceLocation var11) {
        super(var1, var3, var5, var7, var9, var10);
        this.aCa = var11;
    }

    @Override
    public void draw(int var1, int var2, float var3) {
        this.oL().Q(MouseUtil.isHovered(this.getX(), this.getY(), this.oM(), this.da(), var1, var2) ? 100.0 : 45.0);
        double d0 = this.getY();
        Color color = aip.d(Color.BLACK, 150);
        Color color1 = aip.d(Color.WHITE, (int)(150.0 + this.oL().sG()));
        this.b(gg.BLUR).c(() -> RenderUtil.roundedRectangle(this.getX(), this.getY(), this.oM(), this.da(), 5.0, Color.WHITE));
        this.b(gg.BLOOM).c(() -> RenderUtil.roundedRectangle(this.getX() + 0.5, d0 + 0.5, this.oM() - 1.0, this.da() - 1.0, 6.0, color));
        this.b(gg.REGULAR).c(() -> {
            RenderUtil.roundedRectangle(this.getX(), d0, this.oM(), this.da(), 5.0, aip.d(aBV, (int)this.oL().sG() - 15));
            RenderUtil.roundedOutlineGradientRectangle(this.getX(), d0, this.oM(), this.da(), 5.0, 1.0, aip.d(aBP, 32), aip.d(aBO, 32));
            byte b0 = 64;
            RenderUtil.image(this.aCa, this.getX() + this.oM() / 2.0 - 32, d0 + this.da() / 2.0 - 32, b0, b0, color1);
            agc agc = aBZ;
            float f = (float)(this.oM() - 8.0);

            for (int i = 24; i > 11 && agc.getStringWidth(this.name) > f; i--) {
                agc = gb.MAIN.a(i, gd.BOLD);
            }

            agc.c(this.name, (float)(this.getX() + this.oM() / 2.0), (float)(d0 + this.da() / 2.0 - b0 / 2 - 24.0), color1.getRGB());
        });
    }
}
