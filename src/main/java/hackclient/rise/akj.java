package hackclient.rise;

import com.alan.clients.module.Module;
import com.alan.clients.value.Mode;
import com.alan.clients.value.Value;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class akj extends Value<Supplier<Double>> {
    public akj(String var1, Module var2) {
        super(var1, var2, null);
    }

    public akj(String var1, Mode<?> var2) {
        super(var1, var2, null);
    }

    public akj(String var1, Module var2, BooleanSupplier var3) {
        super(var1, var2, null, var3);
    }

    public akj(String var1, Mode<?> var2, BooleanSupplier var3) {
        super(var1, var2, null, var3);
    }

    @Override
    public List<Value<?>> getSubValues() {
        return null;
    }

    public abp wD() {
        return new abp(this);
    }

    @Override
    public abl wl() {
        return this.wD();
    }
}
