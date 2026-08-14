package hackclient.rise;

import com.alan.clients.util.render.RenderUtil;
import java.awt.Color;

public class adl extends adm {
    private static final agc aCe = gb.MAIN.a(14, gd.LIGHT);
    private static final Color aCf = aip.d(Color.WHITE, 150);
    private final Color aCg;

    public adl(double var1, double var3, double var5, double var7, Runnable var9, String var10, Color var11) {
        super(var1, var3, var5, var7, var9, var10);
        this.aCg = aip.d(var11, 150);
    }

    @Override
    public void c(int var1, int var2, float var3) {
        RenderUtil.roundedRectangle(this.getX(), this.getY(), this.oM(), this.da(), 2.0, this.aCg);
        aCe.a(this.gK, this.getX() + this.oM() / 2.0 - aCe.getStringWidth(this.gK) / 2.0F, this.getY() + this.da() / 2.0 - aCe.tq() / 4.0F + 0.5, aCf.getRGB());
    }
}
