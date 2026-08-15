package hackclient.rise;

import com.alan.clients.util.shader.impl.BloomShader;
import com.alan.clients.util.shader.impl.GaussianBlurShader;
import lombok.Generated;

public enum gh {
    REGULAR(null),
    BLOOM(BloomShader.class),
    BLUR(GaussianBlurShader.class);

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
