package com.alan.clients.module.impl.render.jumpcircles;

import net.minecraft.util.Vec3;

public final class JumpCircle {
    private final Vec3 aoH;
    public double aoI;
    public float aoJ;

    public JumpCircle(Vec3 vec, double var2, float var4) {
        this.aoH = vec;
        this.aoI = var2;
        this.aoJ = var4;
    }

    public void y(double var1) {
        this.aoI += var1;
    }

    public Vec3 ma() {
        return this.aoH;
    }

    public double mb() {
        return this.aoI;
    }

    public float mc() {
        return this.aoJ;
    }

    public void p(float var1) {
        this.aoJ = var1;
    }
}
