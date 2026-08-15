package com.alan.clients.newevent.impl.render;

import com.alan.clients.newevent.Event;
import lombok.Generated;
import net.minecraft.client.gui.ScaledResolution;

public final class LimitedRender2DEvent implements Event {
    private final ScaledResolution scaledResolution;
    private final float partialTicks;

    @Generated
    public ScaledResolution getScaledResolution() {
        return this.scaledResolution;
    }

    @Generated
    public float getPartialTicks() {
        return this.partialTicks;
    }

    @Generated
    public LimitedRender2DEvent(ScaledResolution var1, float var2) {
        this.scaledResolution = var1;
        this.partialTicks = var2;
    }
}
