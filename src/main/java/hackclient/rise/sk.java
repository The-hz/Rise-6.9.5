package hackclient.rise;

import com.alan.clients.module.impl.other.Spotify;
import java.util.Comparator;
import java.util.List;

public class sk implements Comparator<Integer> {
    final int XO;
    final double[] XP;
    final List XQ;

    public sk(Spotify var1, int var2, double[] var3, List var4) {
        this.XO = var2;
        this.XP = var3;
        this.XQ = var4;
    }

    public int a(Integer var1, Integer var2) {
        if (var1 == this.XO - 1) {
            return -1;
        }

        if (var2 == this.XO - 1) {
            return 1;
        }

        int i = Double.compare(this.XP[var2], this.XP[var1]);
        return i != 0 ? i : -Integer.compare((Integer)this.XQ.get(var1), (Integer)this.XQ.get(var2));
    }

    public int compare(Integer var1, Integer var2) {
        return this.a(var1, var2);
    }
}
