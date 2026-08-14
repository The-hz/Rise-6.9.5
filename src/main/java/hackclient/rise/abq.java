package hackclient.rise;

import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.value.Mode;
import com.alan.clients.value.Value;
import com.alan.clients.value.impl.ListValue;
import com.alan.clients.value.impl.ModeValue;

public class abq extends abl {
    @Override
    public void a(Vector2d var1, int var2, int var3, float var4) {
        ListValue listvalue = (ListValue)this.ayC;
        this.apP = var1;
        String s = ahd.ce(this.ayC.getName()) + ":";
        gb.MAIN.a(16, gd.REGULAR).a(s, this.apP.x, this.apP.y, abw.SECONDARY_TEXT.Z(this.ayD));
        gb.MAIN
            .a(16, gd.REGULAR)
            .a(
                ahd.ce(listvalue instanceof ModeValue ? ((ModeValue)listvalue).wo().getName() : listvalue.wo().toString()),
                this.apP.x + gb.MAIN.a(16, gd.REGULAR).getStringWidth(s) + 2.0,
                this.apP.y,
                abw.SECONDARY_TEXT.Z(this.ayD)
            );
    }

    public abq(Value<?> var1) {
        super(var1);
    }

    @Override
    public boolean e(int var1, int var2, int var3) {
        if (this.apP == null) {
            return false;
        }

        ListValue listvalue = (ListValue)this.ayC;
        boolean flag = var3 == 0;
        boolean flag1 = var3 == 1;
        if (agj.c(this.apP.x, this.apP.y - 3.5, this.getStandardClickGUI().width - 70, this.jy, var1, var2)) {
            int i = listvalue.wF().indexOf(listvalue.wo());
            Object object = null;
            if (flag) {
                if (listvalue.wF().size() <= i + 1) {
                    object = listvalue.wF().get(0);
                } else {
                    object = listvalue.wF().get(i + 1);
                }
            } else if (flag1) {
                if (0 > i - 1) {
                    object = listvalue.wF().get(listvalue.wF().size() - 1);
                } else {
                    object = listvalue.wF().get(i - 1);
                }
            }

            if (object != null) {
                if (this.pS() instanceof ModeValue) {
                    ((ModeValue)listvalue).c((Mode<?>)object);
                } else {
                    listvalue.m(object);
                }
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
