package hackclient.rise;

import java.util.Set;
import net.minecraft.network.Packet;

public final class br extends ahk {
    private final Set<bn> eu;

    public br(Packet<?> var1, Set<bn> var2) {
        super(var1);
        this.eu = var2;
    }

    public boolean a(bn var1) {
        return this.eu.remove(var1);
    }

    public void c(long var1) {
        this.eu.removeIf(var3 -> var3.a(this.getTime(), var1));
    }

    public boolean b(bn var1) {
        return this.eu.contains(var1);
    }

    public boolean bt() {
        return this.eu.stream().anyMatch(var0 -> ((bn)var0).bd());
    }
}
