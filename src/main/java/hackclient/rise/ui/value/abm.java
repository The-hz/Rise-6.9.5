package hackclient.rise.ui.value;

import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.value.Value;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.ui.click.standard.components.value.ValueComponent;
import hackclient.rise.abw;
import com.alan.clients.util.gui.GUIUtil;
import hackclient.rise.ahd;
import hackclient.rise.aip;
import hackclient.rise.gb;
import hackclient.rise.gd;
import rip.vantage.commons.util.time.a;

public class abm extends ValueComponent {
    private final a ayE = new a();
    private double axp;

    public abm(Value<?> var1) {
        super(var1);
    }

    @Override
    public void draw(Vector2d var1, int var2, int var3, float var4) {
        this.position = var1;
        BooleanValue booleanvalue = (BooleanValue)this.value;
        String s = ahd.ce(this.value.getName());
        gb.MAIN.a(16, gd.REGULAR).a(s, this.position.x, this.position.y, abw.SECONDARY_TEXT.Z(this.ayD));
        double d0 = this.position.x + gb.MAIN.a(16, gd.REGULAR).getStringWidth(s) + 3.0;
        if (booleanvalue.wo()) {
            this.axp = Math.min(5.0, this.axp + (float)this.ayE.aKx() / 20.0F);
        } else {
            this.axp = Math.max(0.0, this.axp - (float)this.ayE.aKx() / 20.0F);
        }

        RenderUtil.roundedRectangle(d0 - 2.5 + 5.0, this.position.y - 2.5 + 2.5, 5.0, 5.0, 2.5, abw.BACKGROUND.Y(this.ayD));
        if (this.axp != 0.0) {
            RenderUtil.roundedRectangle(
                d0 - this.axp / 2.0 + 5.0, this.position.y - this.axp / 2.0 + 2.5, this.axp, this.axp, this.axp / 2.0, aip.d(this.rz().rA(), this.ayD)
            );
        }

        this.ayE.aX();
    }

    @Override
    public boolean e(int var1, int var2, int var3) {
        if (this.position == null) {
            return false;
        }
        BooleanValue booleanvalue = (BooleanValue)this.value;
        if (GUIUtil.c(this.position.x, this.position.y - 3.5, this.getStandardClickGUI().width - 70, this.height, var1, var2)) {
            booleanvalue.setValue(!booleanvalue.wo());
            return true;
        }
        return false;
    }

    @Override
    public void pz() {
    }

    @Override
    public void released() {
        if (this.position != null) {
            String s = ahd.ce(this.value.getName());
            RenderUtil.roundedRectangle(
                this.position.x + gb.MAIN.a(16, gd.REGULAR).getStringWidth(s) + 2.0 - this.axp / 2.0 + 4.0,
                this.position.y - this.axp / 2.0 + 2.5,
                this.axp,
                this.axp,
                this.axp / 2.0,
                aip.d(this.rz().rA(), this.ayD)
            );
        }
    }

    @Override
    public void key(char var1, int var2) {
    }
}
