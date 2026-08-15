package hackclient.rise;

public class yc {
    public final int hunger;
    public final float saturationModifier;

    public yc(int var1, float var2) {
        this.hunger = var1;
        this.saturationModifier = var2;
    }

    public float getSaturationIncrement() {
        return this.hunger * this.saturationModifier * 2.0F;
    }

    @Override
    public boolean equals(Object var1) {
        if (this == var1) {
            return true;
        }
        return !(var1 instanceof yc yc) ? false : this.hunger == yc.hunger && Float.compare(yc.saturationModifier, this.saturationModifier) == 0;
    }

    @Override
    public int hashCode() {
        int i = this.hunger;
        return 31 * i + (this.saturationModifier != 0.0F ? Float.floatToIntBits(this.saturationModifier) : 0);
    }
}
