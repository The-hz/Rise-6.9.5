package hackclient.rise;

import com.alan.clients.component.impl.player.BlinkComponent;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import net.minecraft.network.Packet;
import net.minecraft.util.Tuple;

public final class bp {
    private final String ej;
    public bn ek;
    long dQ;
    public long el;
    private boolean em;
    private boolean af;
    private boolean en;
    private boolean eo;
    private boolean ep;
    private boolean eq;
    private boolean er;
    private final Deque<Integer> es = new ArrayDeque<>();
    private int et;

    public bp(String var1) {
        this.ej = var1;
    }

    public void a(long var1, boolean var3, boolean var4, boolean var5, boolean var6, boolean var7, boolean var8, boolean var9) {
        this.dQ = var1;
        this.em = var3;
        this.af = var4;
        this.en = var5;
        this.eo = var6;
        this.ep = var7;
        this.eq = var8;
        this.er = var9;
        this.el = System.currentTimeMillis();
        this.bo();
    }

    public void bo() {
        if (this.ek == null) {
            this.ek = new bn(this);
        }

        this.el = System.currentTimeMillis();
    }

    public bn bp() {
        bn bn = this.ek;
        if (bn != null) {
            bn.dj = false;
            this.ek = null;
        }

        this.bs();
        return bn;
    }

    public boolean d(Packet<?> var1) {
        return a(BlinkComponent.dV, this.em, var1)
            || a(BlinkComponent.dW, this.af, var1)
            || a(BlinkComponent.dX, this.en, var1)
            || a(BlinkComponent.dY, this.eo, var1)
            || a(BlinkComponent.dZ, this.ep, var1)
            || a(BlinkComponent.ea, this.eq, var1)
            || a(BlinkComponent.eb, this.er, var1);
    }

    public boolean bd() {
        return this.ek != null && this.ek.dj;
    }

    public void bq() {
        this.et++;
    }

    public void br() {
        if (this.et > 0) {
            this.es.add(this.et);
            this.et = 0;
        }
    }

    public int g(int var1) {
        int i = 0;

        for (int j = 0; j < var1; j++) {
            Integer integer = this.es.poll();
            if (integer == null) {
                break;
            }

            i += integer;
        }

        return i;
    }

    private void bs() {
        this.es.clear();
        this.et = 0;
    }

    private static boolean a(Tuple<Class[], Boolean> var0, boolean var1, Packet<?> var2) {
        return var1 && Arrays.<Class>stream((Class[])var0.getFirst()).anyMatch(var1x -> var1x == var2.getClass());
    }
}
