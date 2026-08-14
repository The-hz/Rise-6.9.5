package hackclient.rise;

import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.value.Value;
import com.alan.clients.value.impl.BooleanValue;
import rip.vantage.commons.util.time.a;

public class abm extends abl {
    private final a ayE = new a();
    private double axp;

    public abm(Value<?> var1) {
        super(var1);
    }

    @Override
    public void a(Vector2d var1, int var2, int var3, float var4) {
        this.apP = var1;
        BooleanValue booleanvalue = (BooleanValue)this.ayC;
        String s = ahd.ce(this.ayC.getName());
        gb.MAIN.a(16, gd.REGULAR).a(s, this.apP.x, this.apP.y, abw.SECONDARY_TEXT.Z(this.ayD));
        double d0 = this.apP.x + gb.MAIN.a(16, gd.REGULAR).getStringWidth(s) + 3.0;
        if (booleanvalue.wo()) {
            this.axp = Math.min(5.0, this.axp + (float)this.ayE.aKx() / 20.0F);
        } else {
            this.axp = Math.max(0.0, this.axp - (float)this.ayE.aKx() / 20.0F);
        }

        RenderUtil.roundedRectangle(d0 - 2.5 + 5.0, this.apP.y - 2.5 + 2.5, 5.0, 5.0, 2.5, abw.BACKGROUND.Y(this.ayD));
        if (this.axp != 0.0) {
            RenderUtil.roundedRectangle(
                d0 - this.axp / 2.0 + 5.0, this.apP.y - this.axp / 2.0 + 2.5, this.axp, this.axp, this.axp / 2.0, aip.d(this.rz().rA(), this.ayD)
            );
        }

        this.ayE.aX();
    }

    @Override
    public boolean e(int var1, int var2, int var3) {
        if (this.apP == null) {
            return false;
        }
        BooleanValue booleanvalue = (BooleanValue)this.ayC;
        if (agj.c(this.apP.x, this.apP.y - 3.5, this.getStandardClickGUI().width - 70, this.jy, var1, var2)) {
            booleanvalue.setValue(!booleanvalue.wo());
            return true;
        }
        return false;
    }

    @Override
    public void pz() {
    }

    @Override
    public void ci() {
        if (this.apP != null) {
            String s = ahd.ce(this.ayC.getName());
            RenderUtil.roundedRectangle(
                this.apP.x + gb.MAIN.a(16, gd.REGULAR).getStringWidth(s) + 2.0 - this.axp / 2.0 + 4.0,
                this.apP.y - this.axp / 2.0 + 2.5,
                this.axp,
                this.axp,
                this.axp / 2.0,
                aip.d(this.rz().rA(), this.ayD)
            );
        }
    }

    @Override
    public void b(char var1, int var2) {
    }
}
