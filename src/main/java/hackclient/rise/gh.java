package hackclient.rise;

import hackclient.rise.render.shader.ajd;
import hackclient.rise.render.shader.ajf;
import lombok.Generated;

public enum gh {
    REGULAR(null),
    BLOOM(ajd.class),
    BLUR(ajf.class);

    private final Class<?> lb;
    private static final gh[] $VALUES = dZ();

    @Generated
    gh(Class<?> var3) {
        this.lb = var3;
    }

    @Generated
    public Class<?> dY() {
        return this.lb;
    }

    private static gh[] dZ() {
        return new gh[]{REGULAR, BLOOM, BLUR};
    }
}
