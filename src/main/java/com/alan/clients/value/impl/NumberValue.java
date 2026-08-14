package com.alan.clients.value.impl;

import com.alan.clients.module.Module;
import com.alan.clients.value.Mode;
import com.alan.clients.value.Value;
import hackclient.rise.abl;
import hackclient.rise.abt;
import java.util.List;
import java.util.function.BooleanSupplier;
import lombok.Generated;

public class NumberValue extends Value<Number> {
    private final Number aRe;
    private final Number aRf;
    private final Number aRg;

    public NumberValue(String var1, Module var2, Number var3, Number var4, Number var5, Number var6) {
        super(var1, var2, var3);
        this.aRg = var6;
        this.aRe = var4;
        this.aRf = var5;
    }

    public NumberValue(String var1, Mode<?> var2, Number var3, Number var4, Number var5, Number var6) {
        super(var1, var2, var3);
        this.aRg = var6;
        this.aRe = var4;
        this.aRf = var5;
    }

    public NumberValue(String var1, Module var2, Number var3, Number var4, Number var5, Number var6, BooleanSupplier var7) {
        super(var1, var2, var3, var7);
        this.aRg = var6;
        this.aRe = var4;
        this.aRf = var5;
    }

    public NumberValue(String var1, Mode<?> var2, Number var3, Number var4, Number var5, Number var6, BooleanSupplier var7) {
        super(var1, var2, var3, var7);
        this.aRg = var6;
        this.aRe = var4;
        this.aRf = var5;
    }

    @Override
    public List<Value<?>> getSubValues() {
        return null;
    }

    public abt wG() {
        return new abt(this);
    }

    @Generated
    public Number wx() {
        return this.aRe;
    }

    @Generated
    public Number wy() {
        return this.aRf;
    }

    @Generated
    public Number wz() {
        return this.aRg;
    }

    @Override
    public abl wl() {
        return this.wG();
    }
}
