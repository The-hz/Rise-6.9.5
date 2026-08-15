package com.alan.clients.value.impl;

import com.alan.clients.module.Module;
import com.alan.clients.value.Mode;
import com.alan.clients.value.Value;
import com.alan.clients.ui.click.standard.components.value.ValueComponent;
import hackclient.rise.ui.value.abo;
import java.awt.Color;
import java.util.List;
import java.util.function.BooleanSupplier;

public class ColorValue extends Value<Color> {
    public ColorValue(String var1, Module var2, Color var3) {
        super(var1, var2, var3);
    }

    public ColorValue(String var1, Mode<?> var2, Color var3) {
        super(var1, var2, var3);
    }

    public ColorValue(String var1, Module var2, Color var3, BooleanSupplier var4) {
        super(var1, var2, var3, var4);
    }

    public ColorValue(String var1, Mode<?> var2, Color var3, BooleanSupplier var4) {
        super(var1, var2, var3, var4);
    }

    @Override
    public List<Value<?>> getSubValues() {
        return null;
    }

    public abo wC() {
        return new abo(this);
    }

    @Override
    public ValueComponent wl() {
        return this.wC();
    }
}
