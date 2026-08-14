package hackclient.rise;

import com.alan.clients.module.Module;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.value.Value;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.BoundsNumberValue;
import com.alan.clients.value.impl.ColorValue;
import com.alan.clients.value.impl.DragValue;
import com.alan.clients.value.impl.ListValue;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.NumberValue;
import com.alan.clients.value.impl.StringValue;
import java.awt.Color;
import java.util.ArrayList;
import net.minecraft.client.renderer.GlStateManager;

public class au implements InstanceAccess {
    public Module cg;
    public DragValue ch;
    public Animation animation = new Animation(Easing.EASE_OUT_ELASTIC, 300L);
    public boolean ci;
    public ArrayList<abl> cj = new ArrayList<>();

    public au(Module var1, DragValue var2) {
        this.cg = var1;
        this.ch = var2;

        for (Value value : var1.getAllValues()) {
            if (value instanceof ModeValue) {
                this.cj.add(new abr(value));
            } else if (value instanceof BooleanValue) {
                this.cj.add(new abm(value));
            } else if (value instanceof StringValue) {
                this.cj.add(new abv(value));
            } else if (value instanceof NumberValue) {
                this.cj.add(new abt(value));
            } else if (value instanceof BoundsNumberValue) {
                this.cj.add(new abn(value));
            } else if (value instanceof DragValue) {
                this.cj.add(new abu(value));
            } else if (value instanceof ListValue) {
                this.cj.add(new abq(value));
            } else if (value instanceof ColorValue) {
                this.cj.add(new abo(value));
            }
        }
    }

    public void render(int var1, int var2, float var3) {
        double d0 = 100.0;
        double d1 = 100.0;
        this.animation.h(300L);
        this.animation.a(this.ci ? Easing.EASE_IN_EXPO : Easing.EASE_OUT_EXPO);
        this.animation.Q(this.ci ? 0.0 : 1.0);
        double d2 = this.animation.sG();
        if (!(d2 <= 1.0E-4)) {
            this.b(gg.REGULAR).c(() -> {
                GlStateManager.pushMatrix();
                GlStateManager.translate(this.ch.apP.x * (1.0 - d2), (this.ch.apP.y + this.ch.aHe.y / 2.0) * (1.0 - d2), 0.0);
                GlStateManager.scale(d2, d2, 1.0);
                double d3 = this.ch.apP.x - d0 - 10.0;
                double d4 = this.ch.apP.y + this.ch.aHe.y / 2.0 - d1 / 2.0;
                double d5 = this.rz().pl();
                this.rz();
                Color color = adv.rK();
                double d6 = this.animation.sG();
                this.rz();
                RenderUtil.roundedRectangle(d3, d4, d0, d1, d5, aip.d(color, (int)(d6 * adv.rK().getAlpha())));

                for (abl abl : this.cj) {
                    if (abl.pS() != null && abl.pS().wm() != null && abl.pS().wm().getAsBoolean()) {
                    }
                }

                GlStateManager.popMatrix();
            });
            this.b(gg.BLUR).c(() -> {
                GlStateManager.pushMatrix();
                GlStateManager.translate(this.ch.apP.x * (1.0 - d2), (this.ch.apP.y + this.ch.aHe.y / 2.0) * (1.0 - d2), 0.0);
                GlStateManager.scale(d2, d2, 1.0);
                RenderUtil.roundedRectangle(this.ch.apP.x - d0 - 10.0, this.ch.apP.y + this.ch.aHe.y / 2.0 - d1 / 2.0, d0, d1, this.rz().pl(), Color.BLACK);
                GlStateManager.popMatrix();
            });
        }
    }

    public void close() {
        this.ci = true;
    }
}
