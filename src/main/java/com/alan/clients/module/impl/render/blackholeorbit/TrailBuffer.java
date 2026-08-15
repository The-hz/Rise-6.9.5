package com.alan.clients.module.impl.render.blackholeorbit;

public final class TrailBuffer {
    final int amJ;
    final double[] amK;
    final double[] amL;
    int amM = 0;
    boolean amN = false;

    public TrailBuffer(int var1) {
        this.amJ = var1;
        this.amK = new double[var1];
        this.amL = new double[var1];
    }

    public void h(double var1, double var3) {
        this.amK[this.amM] = var1;
        this.amL[this.amM] = var3;
        this.amM++;
        if (this.amM >= this.amJ) {
            this.amM = 0;
            this.amN = true;
        }
    }

    public void clear() {
        this.amM = 0;
        this.amN = false;
    }

    public int lm() {
        return this.amN ? this.amJ : this.amM;
    }

    public double O(int var1) {
        int i = this.Q(var1);
        return this.amK[i];
    }

    public double P(int var1) {
        int i = this.Q(var1);
        return this.amL[i];
    }

    int Q(int var1) {
        int i = this.amN ? this.amJ : this.amM;
        return i <= 0 ? 0 : ((this.amM - 1 + this.amJ) % this.amJ - (i - 1 - var1) + this.amJ) % this.amJ;
    }
}
