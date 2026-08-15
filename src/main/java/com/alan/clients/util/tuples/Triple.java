package com.alan.clients.util.tuples;

public class Triple<A, B, C> {
    private A aQu;
    private B aQv;
    private C aQw;

    public Triple(A var1, B var2, C var3) {
        this.aQu = var1;
        this.aQv = var2;
        this.aQw = var3;
    }

    public A vT() {
        return this.aQu;
    }

    public void j(A var1) {
        this.aQu = var1;
    }

    public B vU() {
        return this.aQv;
    }

    public void k(B var1) {
        this.aQv = var1;
    }

    public C vV() {
        return this.aQw;
    }

    public void l(C var1) {
        this.aQw = var1;
    }

    @Override
    public String toString() {
        return this.vT().toString() + " " + this.vU() + " " + this.vV();
    }
}
