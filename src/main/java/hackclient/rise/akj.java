package hackclient.rise;

import com.alan.clients.module.Module;
import com.alan.clients.ui.click.standard.components.value.ValueComponent;
import com.alan.clients.value.Mode;
import com.alan.clients.value.Value;
import hackclient.rise.ui.value.abp;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class akj extends Value<Supplier<Double>> {
    public akj(String var1, Module module) {
        super(var1, module, null);
    }

    public akj(String var1, Mode<?> mode) {
        super(var1, mode, null);
    }

    public akj(String var1, Module module, BooleanSupplier booleanSupplier) {
        super(var1, module, null, booleanSupplier);
    }

    public akj(String var1, Mode<?> mode, BooleanSupplier booleanSupplier) {
        super(var1, mode, null, booleanSupplier);
    }

    @Override
    public List<Value<?>> getSubValues() {
        return null;
    }

    public abp wD() {
        return new abp(this);
    }

    @Override
    public ValueComponent wl() {
        return this.wD();
    }
}
