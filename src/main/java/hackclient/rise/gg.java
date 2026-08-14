package hackclient.rise;

import lombok.Generated;

public enum gg {
    BLOOM(gh.BLOOM),
    BLUR(gh.BLUR),
    REGULAR(gh.REGULAR);

    final gh kW;
    private static final gg[] $VALUES = dX();

    @Generated
    public gh dW() {
        return this.kW;
    }

    @Generated
    gg(gh var3) {
        this.kW = var3;
    }

    private static gg[] dX() {
        return new gg[]{BLOOM, BLUR, REGULAR};
    }
}
