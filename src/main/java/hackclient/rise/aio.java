package hackclient.rise;

import lombok.Generated;

public final class aio {
    private float aPo;
    private float aPp;
    private float aIa;
    private float aIb;
    private float aPq;

    public void ju() {
        this.aIa = ahg.e(this.aIa, this.aPo, this.aPq);
        this.aIb = ahg.e(this.aIb, this.aPp, this.aPq);
        if (Math.abs(this.aIa - this.aPo) < 0.05F) {
            this.aIa = this.aPo;
        }

        if (Math.abs(this.aIb - this.aPp) < 0.05F) {
            this.aIb = this.aPp;
        }
    }

    public boolean vB() {
        return this.aIa == this.aPo && this.aIb == this.aPp;
    }

    @Generated
    public float vC() {
        return this.aPo;
    }

    @Generated
    public float vD() {
        return this.aPp;
    }

    @Generated
    public float vE() {
        return this.aIa;
    }

    @Generated
    public float vF() {
        return this.aIb;
    }

    @Generated
    public float vG() {
        return this.aPq;
    }

    @Generated
    public void D(float var1) {
        this.aPo = var1;
    }

    @Generated
    public void E(float var1) {
        this.aPp = var1;
    }

    @Generated
    public void F(float var1) {
        this.aIa = var1;
    }

    @Generated
    public void G(float var1) {
        this.aIb = var1;
    }

    @Generated
    public void H(float var1) {
        this.aPq = var1;
    }

    @Generated
    public aio(float var1, float var2, float var3, float var4, float var5) {
        this.aPo = var1;
        this.aPp = var2;
        this.aIa = var3;
        this.aIb = var4;
        this.aPq = var5;
    }

    @Generated
    public aio() {
    }
}
