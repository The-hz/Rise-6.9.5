package hackclient.rise;

import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.render.RenderUtil;
import java.awt.Color;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import rip.vantage.commons.util.time.a;

public class adq extends GuiScreen {
    private final Animation fadeAnimation = new Animation(Easing.EASE_IN_OUT_CUBIC, 1000L);
    private final a aCt = new a();

    public adq() {
    }

    @Override
    public void initGui() {
        this.fadeAnimation.reset();
        this.aCt.aX();
    }

    @Override
    public void drawScreen(int var1, int var2, float var3) {
        RenderUtil.d(0.0, 0.0, aEg.displayWidth, aEg.displayHeight, Color.BLACK);
        this.fadeAnimation.Q(this.aCt.aKx() > 4000L ? 0.0 : 255.0);
        ScaledResolution scaledresolution = new ScaledResolution(aEg);
        gb.MAIN
            .a(24, gd.REGULAR)
            .c(
                "Note: This is private prerelease software",
                scaledresolution.getScaledWidth() / 2.0,
                scaledresolution.getScaledHeight() / 2.0 - 70.0,
                aip.d(Color.WHITE, (int)this.fadeAnimation.sG()).getRGB()
            );
        gb.MAIN
            .a(24, gd.REGULAR)
            .c(
                "Features, interfaces and sequences are not final and can be expected to change at any time",
                scaledresolution.getScaledWidth() / 2.0,
                scaledresolution.getScaledHeight() / 2.0 - 50.0,
                aip.d(Color.WHITE, (int)this.fadeAnimation.sG()).getRGB()
            );
        gb.MAIN
            .a(16, gd.REGULAR)
            .c(
                "© Rise Client 2022. All Rights Reserved",
                scaledresolution.getScaledWidth() / 2.0,
                scaledresolution.getScaledHeight() / 2.0 + 70.0,
                aip.d(Color.WHITE, (int)this.fadeAnimation.sG() / 2).getRGB()
            );
        if (this.aCt.T(5000L)) {
            aEg.displayGuiScreen(new aap());
        }
    }
}
