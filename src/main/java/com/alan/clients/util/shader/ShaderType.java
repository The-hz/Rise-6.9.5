package com.alan.clients.util.shader;

import com.alan.clients.util.shader.impl.BloomShader;
import com.alan.clients.util.shader.impl.GaussianBlurShader;
import lombok.Generated;

public enum ShaderType {
    REGULAR(null),
    BLOOM(BloomShader.class),
    BLUR(GaussianBlurShader.class);

    private final Class<?> lb;
    private static final ShaderType[] $VALUES = dZ();

    @Generated
    ShaderType(Class<?> type) {
        this.lb = type;
    }

    @Generated
    public Class<?> dY() {
        return this.lb;
    }

    private static ShaderType[] dZ() {
        return new ShaderType[]{REGULAR, BLOOM, BLUR};
    }
}
