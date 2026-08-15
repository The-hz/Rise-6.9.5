package hackclient.rise.ui.value;

import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.value.Mode;
import com.alan.clients.value.Value;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.ui.click.standard.components.value.ValueComponent;
import hackclient.rise.abw;
import com.alan.clients.util.gui.GUIUtil;
import hackclient.rise.ahd;
import com.alan.clients.util.font.FontManager;
import hackclient.rise.gd;

public class abr extends ValueComponent {
    public abr(Value<?> var1) {
        super(var1);
    }

    @Override
    public void draw(Vector2d var1, int var2, int var3, float var4) {
        ModeValue modevalue = (ModeValue)this.value;
        this.position = var1;
        String s = ahd.ce(this.value.getName()) + ":";
        FontManager.MAIN.a(16, gd.REGULAR).a(s, this.position.x, this.position.y, abw.SECONDARY_TEXT.Z(Math.min(this.ayD, abw.SECONDARY_TEXT.pV().getAlpha())));
        FontManager.MAIN
            .a(16, gd.REGULAR)
            .a(
                ahd.ce(modevalue.wo().getName()),
                this.position.x + FontManager.MAIN.a(16, gd.REGULAR).getStringWidth(s) + 2.0,
                this.position.y,
                abw.SECONDARY_TEXT.Z(Math.min(this.ayD, abw.SECONDARY_TEXT.pV().getAlpha()))
            );
    }

    @Override
    public boolean e(int var1, int var2, int var3) {
        if (this.position == null) {
            return false;
        }

        ModeValue modevalue = (ModeValue)this.value;
        boolean flag = var3 == 0;
        boolean flag1 = var3 == 1;
        if (GUIUtil.c(this.position.x, this.position.y - 3.5, this.getStandardClickGUI().width - 70, this.height, var1, var2)) {
            int i = modevalue.getModes().indexOf(modevalue.wo());
            Mode mode = null;
            if (flag) {
                if (modevalue.getModes().size() <= i + 1) {
                    mode = modevalue.getModes().get(0);
                } else {
                    mode = modevalue.getModes().get(i + 1);
                }
            } else if (flag1) {
                if (0 > i - 1) {
                    mode = modevalue.getModes().get(modevalue.getModes().size() - 1);
                } else {
                    mode = modevalue.getModes().get(i - 1);
                }
            }

            if (mode != null) {
                modevalue.update(mode);
            }

            return true;
        }
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
    }
}
