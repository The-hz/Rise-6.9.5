package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.util.vector.Vector2f;
import lombok.Generated;
import net.minecraft.util.ResourceLocation;

public class abg implements InstanceAccess {
    private final ahc ayq;
    private final String ayr;
    private final String ays;
    private double au;

    public void G(double var1) {
        Vector2f vector2f = this.getStandardClickGUI().oW();
        double d0 = this.getStandardClickGUI().oY().aym;
        RenderUtil.roundedRectangle(vector2f.getX() + d0 + 8.0, vector2f.getY() + var1, 285.0, 38.0, 6.0, abw.OVERLAY.pV());
        gb.MAIN
            .a(20, gd.REGULAR)
            .a(
                this.ays,
                vector2f.getX() + d0 + 18.0,
                vector2f.getY() + var1 + 9.0,
                Client.a.d().equals(this.ayq) ? this.rz().j(new Vector2d(0.0, vector2f.y / 5.0F)).getRGB() : abw.TEXT.pW()
            );
        gb.MAIN.a(17, gd.REGULAR).a(this.ayr, vector2f.getX() + d0 + 18.0, vector2f.getY() + var1 + 24.0, abw.TEXT.Z(100));
        RenderUtil.image(
            new ResourceLocation("rise/icons/language/" + this.ayq.uE() + ".png"),
            vector2f.getX() + d0 + gb.MAIN.a(20, gd.REGULAR).getStringWidth(this.ays) + 25.0,
            vector2f.getY() + var1 + 5.0,
            15.0,
            15.0
        );
        this.au = var1;
    }

    public void j(double var1, double var3) {
        Vector2f vector2f = this.getStandardClickGUI().oW();
        double d0 = this.getStandardClickGUI().oY().aym;
        if (agj.c(vector2f.getX() + d0 + 8.0, vector2f.getY() + this.au, 285.0, 38.0, var1, var3)) {
            Client.a.a(this.ayq);
        }
    }

    @Generated
    public ahc d() {
        return this.ayq;
    }

    @Generated
    public String pH() {
        return this.ayr;
    }

    @Generated
    public String pI() {
        return this.ays;
    }

    @Generated
    public double ag() {
        return this.au;
    }

    @Generated
    public abg(ahc var1, String var2, String var3) {
        this.ayq = var1;
        this.ayr = var2;
        this.ays = var3;
    }
}
