package hackclient.rise;

public final class rc {
    double x;
    public double y;
    double z;

    public rc(double var1, double var3, double var5) {
        this.d(var1, var3, var5);
    }

    public rc a(rc var1) {
        this.x = this.x + var1.x;
        this.y = this.y + var1.y;
        this.z = this.z + var1.z;
        return this;
    }

    rc p(double var1) {
        this.x *= var1;
        this.y *= var1;
        this.z *= var1;
        return this;
    }

    public rc d(double var1, double var3, double var5) {
        this.x = var1;
        this.y = var3;
        this.z = var5;
        return this;
    }
}
