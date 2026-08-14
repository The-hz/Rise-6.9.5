package hackclient.rise;

import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;

public class adh extends adg {
    private final Runnable aBW;
    private final Animation aBX = new Animation(Easing.EASE_OUT_QUINT, 500L);
    private final Animation aBY = new Animation(Easing.EASE_OUT_SINE, 250L);

    public adh(double var1, double var3, double var5, double var7, Runnable var9) {
        super(var1, var3, var5, var7);
        this.aBW = var9;
    }

    public void c(int var1, int var2, float var3) {
        this.aBY.Q(aeb.a(this.getX(), this.getY(), this.oM(), this.da(), var1, var2) ? 100.0 : 45.0);
    }

    public void rm() {
        this.aBW.run();
    }

    public Animation mB() {
        return this.aBX;
    }

    public Animation oL() {
        return this.aBY;
    }
}
