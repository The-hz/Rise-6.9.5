package hackclient.rise;

public final class rb {
    public rc SU = new rc(0.0, 0.0, 0.0);
    public rc SV = new rc(0.0, 0.0, 0.0);
    public rc SW = new rc(0.0, 0.0, 0.0);
    rc SX = new rc(0.0, -10.0, 0.0);
    double SY = 2.0;
    double SZ = 1.0;

    public rb() {
    }

    public rc hI() {
        double d0 = 1.0 / this.SZ;
        this.SV.p(d0);
        this.SV.a(this.SX).p(this.SY);
        this.SU.p(d0);
        this.SV.p(0.03333333333333333);
        this.SU.a(this.SV);
        this.SW.a(this.SU);
        this.SV.d(0.0, 0.0, 0.0);
        this.SU.d(0.0, 0.0, 0.0);
        return this.SW;
    }
}
