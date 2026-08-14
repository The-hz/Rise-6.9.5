package hackclient.rise;

import lombok.Generated;

public class akb {
    public int ald;
    public int ale;
    public int aQE;

    public akb(int var1, int var2, int var3) {
        this.ald = var1;
        this.ale = var2;
        this.aQE = var3;
    }

    public akb l(int var1, int var2, int var3) {
        return new akb(this.ald + var1, this.ale + var2, this.aQE + var3);
    }

    public akb c(akb var1) {
        return this.l(var1.ald, var1.ale, var1.aQE);
    }

    public akb m(int var1, int var2, int var3) {
        return this.l(-var1, -var2, -var3);
    }

    public akb d(akb var1) {
        return this.l(-var1.ald, -var1.ale, -var1.aQE);
    }

    public double wg() {
        return Math.sqrt(this.ald * this.ald + this.ale * this.ale + this.aQE * this.aQE);
    }

    public int we() {
        return this.ald;
    }

    public int wf() {
        return this.ale;
    }

    public int wi() {
        return this.aQE;
    }

    public aka ag(double var1) {
        return new aka(this.ald * var1, this.ale * var1, this.aQE * var1);
    }

    public double e(akb var1) {
        return Math.sqrt(Math.pow(var1.ald - this.ald, 2.0) + Math.pow(var1.ale - this.ale, 2.0) + Math.pow(var1.aQE - this.aQE, 2.0));
    }

    @Override
    public boolean equals(Object var1) {
        return !(var1 instanceof aka aka) ? false : this.ald == Math.floor(aka.x) && this.ale == Math.floor(aka.y) && this.aQE == Math.floor(aka.z);
    }

    @Generated
    public void aG(int var1) {
        this.ald = var1;
    }

    @Generated
    public void aH(int var1) {
        this.ale = var1;
    }

    @Generated
    public void aI(int var1) {
        this.aQE = var1;
    }
}
