package hackclient.rise;

import com.alan.clients.module.impl.other.Spotify;
import java.util.Comparator;
import java.util.List;

public class sj implements Comparator<Integer> {
    final int XK;
    final int[] XL;
    final int[] XM;
    final List XN;

    public sj(Spotify spotify, int var2, int[] var3, int[] var4, List var5) {
        this.XK = var2;
        this.XL = var3;
        this.XM = var4;
        this.XN = var5;
    }

    public int a(Integer var1, Integer var2) {
        if (var1 == this.XK - 1) {
            return 1;
        }

        if (var2 == this.XK - 1) {
            return -1;
        }

        int i = this.XL[var1] - this.XM[var1];
        int j = this.XL[var2] - this.XM[var2];
        return i != j ? Integer.compare(j, i) : Integer.compare((Integer)this.XN.get(var1), (Integer)this.XN.get(var2));
    }

    public int compare(Integer var1, Integer var2) {
        return this.a(var1, var2);
    }
}
