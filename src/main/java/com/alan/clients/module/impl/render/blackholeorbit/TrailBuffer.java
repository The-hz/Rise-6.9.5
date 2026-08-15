package com.alan.clients.module.impl.render.blackholeorbit;

public final class TrailBuffer {
    final int capacity;
    final double[] amK;
    final double[] amL;
    int writeIndex = 0;
    boolean wrapped = false;

    public TrailBuffer(int var1) {
        this.capacity = var1;
        this.amK = new double[var1];
        this.amL = new double[var1];
    }

    public void h(double var1, double var3) {
        this.amK[this.writeIndex] = var1;
        this.amL[this.writeIndex] = var3;
        this.writeIndex++;
        if (this.writeIndex >= this.capacity) {
            this.writeIndex = 0;
            this.wrapped = true;
        }
    }

    public void clear() {
        this.writeIndex = 0;
        this.wrapped = false;
    }

    public int size() {
        return this.wrapped ? this.capacity : this.writeIndex;
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
        int i = this.wrapped ? this.capacity : this.writeIndex;
        return i <= 0 ? 0 : ((this.writeIndex - 1 + this.capacity) % this.capacity - (i - 1 - var1) + this.capacity) % this.capacity;
    }
}
