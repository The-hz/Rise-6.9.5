package hackclient.rise;

import net.minecraft.util.Vec3;

public final class xl {
    private final Vec3 aoH;
    public double aoI;
    public float aoJ;

    public xl(Vec3 vec, double var2, float var4) {
        this.aoH = vec;
        this.aoI = var2;
        this.aoJ = var4;
    }

    public void y(double var1) {
        this.aoI += var1;
    }

    public Vec3 ma() {
        return this.aoH;
    }

    public double mb() {
        return this.aoI;
    }

    public float mc() {
        return this.aoJ;
    }

    public void p(float var1) {
        this.aoJ = var1;
    }
}
