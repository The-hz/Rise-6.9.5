package rip.vantage.commons.util.time;

public class a {
    public long aGh;

    public a() {
        this.aX();
    }

    public boolean T(long var1) {
        return System.currentTimeMillis() - var1 >= this.aGh;
    }

    public void aX() {
        this.aGh = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return System.currentTimeMillis() - this.aGh;
    }

    public void setMillis(long var1) {
        this.aGh = var1;
    }
}
