package com.alan.clients.module.impl.render.bedplates;

import hackclient.rise.aka;

public class BedPlateEntry {
    private final aka alO;
    private final double alP;
    private final BedPlateInfo alQ;
    private boolean alR = true;
    private double[] alS = null;
    private int alT = 999;

    public BedPlateEntry(aka var1, double var2, BedPlateInfo var4) {
        this.alO = var1;
        this.alP = var2;
        this.alQ = var4;
    }

    public aka kT() {
        return this.alO;
    }

    public double kU() {
        return this.alP;
    }

    public BedPlateInfo kV() {
        return this.alQ;
    }

    public boolean kW() {
        return this.alR;
    }

    public void v(boolean var1) {
        this.alR = var1;
    }

    public double[] kX() {
        return this.alS;
    }

    public void a(double[] var1) {
        this.alS = var1;
        this.alT = 0;
    }

    public int kY() {
        return this.alT;
    }

    public void kZ() {
        this.alT++;
    }
}
