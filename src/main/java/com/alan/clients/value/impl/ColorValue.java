package com.alan.clients.value.impl;

import com.alan.clients.module.Module;
import com.alan.clients.value.Mode;
import com.alan.clients.value.Value;
import hackclient.rise.abl;
import hackclient.rise.abo;
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
    public abl wl() {
        return this.wC();
    }
}
