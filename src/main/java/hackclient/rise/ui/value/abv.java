package hackclient.rise.ui.value;

import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.value.Value;
import com.alan.clients.value.impl.StringValue;
import com.alan.clients.ui.click.standard.components.value.ValueComponent;
import hackclient.rise.abw;
import hackclient.rise.agl;
import hackclient.rise.agm;
import hackclient.rise.ahd;
import hackclient.rise.aip;
import hackclient.rise.gb;
import hackclient.rise.gd;
import java.awt.Color;

public class abv extends ValueComponent {
    public final agm azo = new agm(new Vector2d(200.0, 200.0), gb.MAIN.a(16, gd.REGULAR), Color.WHITE, agl.LEFT, "", 20.0F);

    public abv(Value<?> var1) {
        super(var1);
        StringValue stringvalue = (StringValue)var1;
        this.azo.bW(stringvalue.wo());
        this.azo.ar(stringvalue.wo().length());
    }

    @Override
    public void draw(Vector2d var1, int var2, int var3, float var4) {
        this.position = var1;
        StringValue stringvalue = (StringValue)this.value;
        this.height = 28.0;
        String s = ahd.ce(this.value.getName());
        gb.MAIN.a(16, gd.REGULAR).a(s, this.position.x, this.position.y, abw.SECONDARY_TEXT.Z(this.ayD));
        this.azo.setColor(aip.d(this.azo.getColor(), this.ayD));
        this.position = new Vector2d(this.position.x, this.position.y + 14.0);
        this.azo.h(this.position);
        this.azo.z(230.5F);
        this.azo.draw();
        stringvalue.n(this.azo.getText());
    }

    @Override
    public boolean e(int var1, int var2, int var3) {
        if (this.position == null) {
            return false;
        }

        this.azo.click(var1, var2, var3);
        return false;
    }

    @Override
    public void pz() {
    }

    @Override
    public void released() {
    }

    @Override
    public void key(char var1, int var2) {
        if (this.position != null) {
            this.azo.key(var1, var2);
        }
    }
}
