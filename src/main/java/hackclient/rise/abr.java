package hackclient.rise;

import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.value.Mode;
import com.alan.clients.value.Value;
import com.alan.clients.value.impl.ModeValue;

public class abr extends abl {
    public abr(Value<?> var1) {
        super(var1);
    }

    @Override
    public void a(Vector2d var1, int var2, int var3, float var4) {
        ModeValue modevalue = (ModeValue)this.ayC;
        this.apP = var1;
        String s = ahd.ce(this.ayC.getName()) + ":";
        gb.MAIN.a(16, gd.REGULAR).a(s, this.apP.x, this.apP.y, abw.SECONDARY_TEXT.Z(Math.min(this.ayD, abw.SECONDARY_TEXT.pV().getAlpha())));
        gb.MAIN
            .a(16, gd.REGULAR)
            .a(
                ahd.ce(modevalue.wo().getName()),
                this.apP.x + gb.MAIN.a(16, gd.REGULAR).getStringWidth(s) + 2.0,
                this.apP.y,
                abw.SECONDARY_TEXT.Z(Math.min(this.ayD, abw.SECONDARY_TEXT.pV().getAlpha()))
            );
    }

    @Override
    public boolean e(int var1, int var2, int var3) {
        if (this.apP == null) {
            return false;
        }

        ModeValue modevalue = (ModeValue)this.ayC;
        boolean flag = var3 == 0;
        boolean flag1 = var3 == 1;
        if (agj.c(this.apP.x, this.apP.y - 3.5, this.getStandardClickGUI().width - 70, this.jy, var1, var2)) {
            int i = modevalue.wF().indexOf(modevalue.wo());
            Mode mode = null;
            if (flag) {
                if (modevalue.wF().size() <= i + 1) {
                    mode = modevalue.wF().get(0);
                } else {
                    mode = modevalue.wF().get(i + 1);
                }
            } else if (flag1) {
                if (0 > i - 1) {
                    mode = modevalue.wF().get(modevalue.wF().size() - 1);
                } else {
                    mode = modevalue.wF().get(i - 1);
                }
            }

            if (mode != null) {
                modevalue.c(mode);
            }

            return true;
        }
        return false;
    }

    @Override
    public void pz() {
    }

    @Override
    public void ci() {
    }

    @Override
    public void b(char var1, int var2) {
    }
}
