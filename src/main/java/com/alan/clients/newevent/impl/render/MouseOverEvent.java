package com.alan.clients.newevent.impl.render;

import com.alan.clients.newevent.Event;
import lombok.Generated;
import net.minecraft.util.MovingObjectPosition;

public class MouseOverEvent implements Event {
    private double range;
    private float expand;
    private MovingObjectPosition kf;

    public MouseOverEvent(double var1, float var3) {
        this.range = var1;
        this.expand = var3;
    }

    @Generated
    public double dA() {
        return this.range;
    }

    @Generated
    public float dB() {
        return this.expand;
    }

    @Generated
    public MovingObjectPosition dC() {
        return this.kf;
    }

    @Generated
    public void i(double var1) {
        this.range = var1;
    }

    @Generated
    public void c(float var1) {
        this.expand = var1;
    }

    @Generated
    public void a(MovingObjectPosition var1) {
        this.kf = var1;
    }
}
