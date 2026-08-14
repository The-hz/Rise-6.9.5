package hackclient.rise;

import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.value.Value;
import com.alan.clients.value.impl.NumberValue;
import rip.vantage.commons.util.time.a;

public class abt extends abl {
    private static final double azf = 100.0;
    private final double azg = 5.0;
    private final a azh = new a();
    public boolean azi;
    private double azj;
    private double azk;
    private double azl;
    private boolean ayQ;
    private float ayR;
    public final agm azm = new agm(
        new Vector2d(0.0, 0.0),
        gb.MAIN.a(16, gd.REGULAR),
        abw.SECONDARY_TEXT.pV(),
        agl.LEFT,
        ((NumberValue)this.ayC).ws().toString().replace(".0", ""),
        45.0F,
        "1234567890."
    );

    public abt(Value<?> var1) {
        super(var1);
        this.pU();
    }

    public void pU() {
        NumberValue numbervalue = (NumberValue)this.ayC;
        this.azj = Math.min(
            Math.max(
                0.0, (-numbervalue.wx().doubleValue() + numbervalue.wo().doubleValue()) / (-numbervalue.wx().doubleValue() + numbervalue.wy().doubleValue())
            ),
            1.0
        );
    }

    @Override
    public void a(Vector2d var1, int var2, int var3, float var4) {
        this.apP = var1;
        NumberValue numbervalue = (NumberValue)this.ayC;
        String s = String.valueOf(numbervalue.wo().doubleValue());
        String s1 = ahd.ce(this.ayC.getName());
        float f = gb.MAIN.a(16, gd.REGULAR).getStringWidth(s1) + 7;
        if (s.endsWith(".0")) {
            s = s.replace(".0", "");
        }

        this.ayQ = agj.c(this.apP.x + f - 5.0, this.apP.y - 3.5, 110.0, this.jy, var2, var3);
        if (this.ayQ) {
            this.ayR = Math.min(1.0F, this.ayR + (float)this.azh.aKx() / 200.0F);
        } else {
            this.ayR = Math.max(0.0F, this.ayR - (float)this.azh.aKx() / 200.0F);
        }

        gb.MAIN.a(16, gd.REGULAR).a(s1, this.apP.x, this.apP.y, abw.SECONDARY_TEXT.Z(this.ayD));
        this.azm.h(new Vector2d(this.apP.x + f + 105.0, this.apP.y));
        if (!this.azm.tO()) {
            this.azm.bW(s);
        }

        this.azm.z(20.0F);
        this.azm.b(aip.d(this.azm.nw(), this.ayD));
        this.azm.pJ();
        RenderUtil.roundedRectangle(this.apP.x + f, this.apP.y + 1.5, 100.0, 2.0, 1.0, abw.BACKGROUND.Y(this.ayD));
        this.azk = this.apP.x + f;
        if (this.getStandardClickGUI().axS < 0.8) {
            this.azi = false;
        }

        if (this.azi) {
            this.azj = var2 - this.azk;
            this.azj /= 100.0;
            this.azj = Math.max(Math.min(this.azj, 1.0), 0.0);
            numbervalue.n(numbervalue.wx().doubleValue() + (numbervalue.wy().doubleValue() - numbervalue.wx().doubleValue()) * this.azj);
            numbervalue.n(ahg.m(numbervalue.wo().doubleValue(), numbervalue.wz().floatValue()));
        }

        for (int i = 0; i <= this.azh.aKx(); i++) {
            this.azl = (this.azl * 29.0 + this.azj) / 30.0;
        }

        RenderUtil.roundedRectangle(this.azk + this.azl * 100.0 - 2.5, this.apP.y, 5.0, 5.0, 2.5, aip.d(this.rz().rA(), this.ayD));
        this.azh.aX();
    }

    @Override
    public boolean e(int var1, int var2, int var3) {
        if (this.apP == null) {
            return false;
        }

        boolean flag = var3 == 0;
        if (flag && this.ayQ) {
            this.azi = true;
            return true;
        }
        this.azm.d(var1, var2, var3);
        return false;
    }

    @Override
    public void pz() {
        this.azi = false;
    }

    @Override
    public void ci() {
        if (this.apP != null) {
            RenderUtil.roundedRectangle(this.azk + this.azl * 100.0 - 2.5, this.apP.y, 5.0, 5.0, 2.5, aip.d(this.rz().rA(), this.ayD));
        }
    }

    @Override
    public void b(char var1, int var2) {
        if (var2 == 28) {
            NumberValue numbervalue = (NumberValue)this.ayC;
            if (this.azm.getText().isEmpty()) {
                numbervalue.n(numbervalue.ws());
            } else {
                double d0 = Double.parseDouble(this.azm.getText());
                numbervalue.n(d0);
            }

            this.azm.I(false);
            this.pU();
        } else {
            this.azm.b(var1, var2);
        }
    }
}
