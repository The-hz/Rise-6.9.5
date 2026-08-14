package hackclient.rise;

public class yc {
    public final int aqt;
    public final float aqu;

    public yc(int var1, float var2) {
        this.aqt = var1;
        this.aqu = var2;
    }

    public float mm() {
        return this.aqt * this.aqu * 2.0F;
    }

    @Override
    public boolean equals(Object var1) {
        if (this == var1) {
            return true;
        }
        return !(var1 instanceof yc yc) ? false : this.aqt == yc.aqt && Float.compare(yc.aqu, this.aqu) == 0;
    }

    @Override
    public int hashCode() {
        int i = this.aqt;
        return 31 * i + (this.aqu != 0.0F ? Float.floatToIntBits(this.aqu) : 0);
    }
}
