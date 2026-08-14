package com.alan.clients.util.animation;

import lombok.Generated;

public class Animation {
    private Easing easing;
    private long aGg;
    private long aGh;
    private long fa;
    private double aGi;
    private double aGj;
    private double aGk;
    private boolean finished;

    public Animation(Easing var1, long var2) {
        this.easing = var1;
        this.fa = System.currentTimeMillis();
        this.aGg = var2;
    }

    public void Q(double var1) {
        this.aGh = System.currentTimeMillis();
        if (this.aGj != var1) {
            this.aGj = var1;
            this.reset();
        } else {
            this.finished = this.aGh - this.aGg > this.fa;
            if (this.finished) {
                this.aGk = var1;
                return;
            }
        }

        double d0 = this.easing.getFunction().apply(this.sz());
        if (this.aGk > var1) {
            this.aGk = this.aGi - (this.aGi - var1) * d0;
        } else {
            this.aGk = this.aGi + (var1 - this.aGi) * d0;
        }
    }

    public double sz() {
        return (double)(System.currentTimeMillis() - this.fa) / this.aGg;
    }

    public void reset() {
        this.fa = System.currentTimeMillis();
        this.aGi = this.aGk;
        this.finished = false;
    }

    @Generated
    public Easing sA() {
        return this.easing;
    }

    @Generated
    public long sB() {
        return this.aGg;
    }

    @Generated
    public long sC() {
        return this.aGh;
    }

    @Generated
    public long sD() {
        return this.fa;
    }

    @Generated
    public double sE() {
        return this.aGi;
    }

    @Generated
    public double sF() {
        return this.aGj;
    }

    @Generated
    public double sG() {
        return this.aGk;
    }

    @Generated
    public boolean kv() {
        return this.finished;
    }

    @Generated
    public void a(Easing var1) {
        this.easing = var1;
    }

    @Generated
    public void h(long var1) {
        this.aGg = var1;
    }

    @Generated
    public void i(long var1) {
        this.aGh = var1;
    }

    @Generated
    public void j(long var1) {
        this.fa = var1;
    }

    @Generated
    public void R(double var1) {
        this.aGi = var1;
    }

    @Generated
    public void S(double var1) {
        this.aGj = var1;
    }

    @Generated
    public void T(double var1) {
        this.aGk = var1;
    }

    @Generated
    public void B(boolean var1) {
        this.finished = var1;
    }
}
