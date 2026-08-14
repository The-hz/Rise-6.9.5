package hackclient.rise;

public class ajt<A, B, C> {
    private A aQu;
    private B aQv;
    private C aQw;

    public ajt(A var1, B var2, C var3) {
        this.aQu = (A)var1;
        this.aQv = (B)var2;
        this.aQw = (C)var3;
    }

    public A vT() {
        return this.aQu;
    }

    public void j(A var1) {
        this.aQu = (A)var1;
    }

    public B vU() {
        return this.aQv;
    }

    public void k(B var1) {
        this.aQv = (B)var1;
    }

    public C vV() {
        return this.aQw;
    }

    public void l(C var1) {
        this.aQw = (C)var1;
    }

    @Override
    public String toString() {
        return this.vT().toString() + " " + this.vU() + " " + this.vV();
    }
}
