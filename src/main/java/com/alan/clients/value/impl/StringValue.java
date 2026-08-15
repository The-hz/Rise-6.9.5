package com.alan.clients.value.impl;

import com.alan.clients.module.Module;
import com.alan.clients.value.Mode;
import com.alan.clients.value.Value;
import com.alan.clients.ui.click.standard.components.value.ValueComponent;
import hackclient.rise.ui.value.abv;
import java.util.List;
import java.util.function.BooleanSupplier;

public class StringValue extends Value<String> {
    public StringValue(String var1, Module var2, String var3) {
        super(var1, var2, var3);
    }

    public StringValue(String var1, Mode<?> var2, String var3) {
        super(var1, var2, var3);
    }

    public StringValue(String var1, Module var2, String var3, BooleanSupplier var4) {
        super(var1, var2, var3, var4);
    }

    public StringValue(String var1, Mode<?> var2, String var3, BooleanSupplier var4) {
        super(var1, var2, var3, var4);
    }

    @Override
    public List<Value<?>> getSubValues() {
        return null;
    }

    public abv wH() {
        return new abv(this);
    }

    @Override
    public ValueComponent wl() {
        return this.wH();
    }
}
