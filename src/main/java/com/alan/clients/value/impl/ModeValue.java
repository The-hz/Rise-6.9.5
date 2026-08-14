package com.alan.clients.value.impl;

import com.alan.clients.module.Module;
import com.alan.clients.value.Mode;
import com.alan.clients.value.Value;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BooleanSupplier;
import lombok.Generated;

public class ModeValue extends ListValue<Mode<?>> {
    private final List<Mode<?>> modes = new ArrayList<>();

    public ModeValue(String var1, Module var2) {
        super(var1, var2);
    }

    public ModeValue(String var1, Mode<?> var2) {
        super(var1, var2);
    }

    public ModeValue(String var1, Module var2, BooleanSupplier var3) {
        super(var1, var2, var3);
    }

    public ModeValue(String var1, Mode<?> var2, BooleanSupplier var3) {
        super(var1, var2, var3);
    }

    public void c(Mode<?> var1) {
        if (this.wq() == null || this.wq() instanceof Module && !((Module)this.wq()).isEnabled()) {
            this.n(var1);
        } else {
            this.wo().unregister();
            this.n(var1);
            this.wo().a();
        }
    }

    public ModeValue add(Mode<?>... var1) {
        if (var1 == null) {
            return this;
        }

        this.modes.addAll(Arrays.asList(var1));
        return this;
    }

    public ModeValue setDefault(String var1) {
        this.n(this.modes.stream().filter(var1x -> var1x.getName().equalsIgnoreCase(var1)).findFirst().orElse(this.modes.get(0)));
        this.o(this.wo());
        this.modes.forEach(var1x -> var1x.getValues().forEach(var2 -> var2.b(() -> var1x != this.wo())));
        return this;
    }

    public void co(String var1) {
        this.n(this.modes.stream().filter(var1x -> var1x.getName().equalsIgnoreCase(var1)).findFirst().orElse(this.modes.get(0)));
    }

    @Override
    public List<Value<?>> getSubValues() {
        ArrayList arraylist = new ArrayList();

        for (Mode mode : this.wF()) {
            arraylist.addAll(mode.getValues());
        }

        return arraylist;
    }

    @Generated
    @Override
    public List<Mode<?>> wF() {
        return this.modes;
    }
}
