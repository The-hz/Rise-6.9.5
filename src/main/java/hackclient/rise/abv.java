package hackclient.rise;

import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.value.Value;
import com.alan.clients.value.impl.StringValue;
import java.awt.Color;

public class abv extends abl {
    public final agm azo = new agm(new Vector2d(200.0, 200.0), gb.MAIN.a(16, gd.REGULAR), Color.WHITE, agl.LEFT, "", 20.0F);

    public abv(Value<?> var1) {
        super(var1);
        StringValue stringvalue = (StringValue)var1;
        this.azo.bW(stringvalue.wo());
        this.azo.ar(stringvalue.wo().length());
    }

    @Override
    public void a(Vector2d var1, int var2, int var3, float var4) {
        this.apP = var1;
        StringValue stringvalue = (StringValue)this.ayC;
        this.jy = 28.0;
        String s = ahd.ce(this.ayC.getName());
        gb.MAIN.a(16, gd.REGULAR).a(s, this.apP.x, this.apP.y, abw.SECONDARY_TEXT.Z(this.ayD));
        this.azo.b(aip.d(this.azo.nw(), this.ayD));
        this.apP = new Vector2d(this.apP.x, this.apP.y + 14.0);
        this.azo.h(this.apP);
        this.azo.z(230.5F);
        this.azo.pJ();
        stringvalue.n(this.azo.getText());
    }

    @Override
    public boolean e(int var1, int var2, int var3) {
        if (this.apP == null) {
            return false;
        }

        this.azo.d(var1, var2, var3);
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
        if (this.apP != null) {
            this.azo.b(var1, var2);
        }
    }
}
