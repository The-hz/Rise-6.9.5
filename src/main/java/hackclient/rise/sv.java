package hackclient.rise;

import java.util.function.Function;
import lombok.Generated;
import net.minecraft.util.MathHelper;

public enum sv {
    DIFFERENCE(var0 -> var0[0] - var0[1]),
    EUCLIDEAN_DISTANCE(var0 -> Math.sqrt(Math.pow(var0[0], 2.0) + Math.pow(var0[1], 2.0))),
    WRAPPED_TO_180_DISTANCE(var0 -> MathHelper.wrapAngleTo180_double(var0[0] - var0[1]));

    private final Function<Double[], Double> ZO;
    private static final sv[] $VALUES = in();

    public double a(Double... var1) {
        return this.ZO.apply(var1);
    }

    @Generated
    sv(Function<Double[], Double> var3) {
        this.ZO = var3;
    }

    private static sv[] in() {
        return new sv[]{DIFFERENCE, EUCLIDEAN_DISTANCE, WRAPPED_TO_180_DISTANCE};
    }
}
