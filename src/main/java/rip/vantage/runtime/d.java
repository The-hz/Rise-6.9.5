package rip.vantage.runtime;

public class d {
    public int eSe;
    public long eSc;
    public long eSb;
    public boolean eSa;
    public byte[] eSd;


    public boolean q(byte[] byArray) {
        long l2;
        long l3;
        block4: {
            long l6 = -5930842072470859199L;
            long l7 = 3328041367769057431L;
            if (this.eSa) {
                return false;
            }
            long l8 = l7;
            long l9 = l8 ^ ((long)(this.eSe / 8) ^ l8) & -1L >>> 32;
            long l10 = l6;
            l3 = l10 ^ ((long)(this.eSe % 8) << 32 ^ l10) & -1L << 32;
            long l11 = l9;
            l2 = l11 ^ (0L ^ l11) & -1L << 32;
            boolean bl = true;
            do {
                if (!bl || (bl = false) || !true) {
                    l2 += 0x100000000L;
                }
                if ((int)(l2 >>> 32) >= (int)l2) break block4;
            } while (byArray[(int)(l2 >>> 32)] == this.eSd[(int)(l2 >>> 32)]);
            return 106 - 12 + -94 != 0;
        }
        if ((int)(l3 >>> 32) == 0) {
            return true;
        }
        long l12 = l2;
        long l13 = l12 ^ ((long)(255 << 8 - (int)(l3 >>> 32)) << 32 ^ l12) & -1L << 32;
        if ((byArray[(int)l13] & (int)(l13 >>> 32)) != (this.eSd[(int)l13] & (int)(l13 >>> 32))) return false;
        return true;
    }

    static {
    }

    d(long l2, long l3) {
        this.eSa = true;
        this.eSb = l2;
        this.eSc = l3;
        this.eSd = null;
        this.eSe = 0;
    }

    public boolean U(long l2) {
        if (!this.eSa) {
            return false;
        }
        if ((l2 & this.eSc) != this.eSb) return false;
        return true;
    }

    d(byte[] byArray, int n2) {
        this.eSa = false;
        this.eSd = byArray;
        this.eSe = n2;
        this.eSb = 0L;
        this.eSc = 0L;
    }
}
