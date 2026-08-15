package com.alan.clients.value;

import com.alan.clients.module.Module;
import com.alan.clients.util.interfaces.Toggleable;
import com.alan.clients.ui.click.standard.components.value.ValueComponent;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import lombok.Generated;

public abstract class Value<T> {
    private final String name;
    public BooleanSupplier aQJ;
    public BooleanSupplier aQK;
    private T aQL;
    private boolean visible;
    private Toggleable aQM;
    private Consumer<T> valueChangeConsumer;
    private T aQO;

    public Value(String name, Module module, T var3) {
        this.name = name;
        this.aQJ = null;
        this.aQM = module;
        this.aQO = var3;
        this.n(var3);
        module.getValues().add(this);
    }

    public Value(String name, Mode<?> mode, T var3) {
        this.name = name;
        this.aQJ = null;
        this.aQO = var3;
        this.aQM = mode;
        this.n(var3);
        mode.getValues().add(this);
    }

    public Value(String name, Module module, T var3, BooleanSupplier booleanSupplier) {
        this.name = name;
        this.aQJ = booleanSupplier;
        this.aQM = module;
        this.aQO = var3;
        this.n(var3);
        module.getValues().add(this);
    }

    public Value(String name, Mode<?> mode, T var3, BooleanSupplier booleanSupplier) {
        this.name = name;
        this.aQJ = booleanSupplier;
        this.aQO = var3;
        this.n(var3);
        mode.getValues().add(this);
    }

    public void setValueAsObject(Object valueAsObject) {
        if (this.valueChangeConsumer != null) {
            this.valueChangeConsumer.accept((T)valueAsObject);
        }

        this.aQL = (T)valueAsObject;
    }

    public void n(T var1) {
        if (this.valueChangeConsumer != null) {
            this.valueChangeConsumer.accept((T)var1);
        }

        this.aQL = (T)var1;
    }

    public abstract List<Value<?>> getSubValues();

    public void o(T var1) {
        this.aQO = var1;
    }

    public ValueComponent wl() {
        return null;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Generated
    public String getName() {
        return this.name;
    }

    @Generated
    public BooleanSupplier wm() {
        return this.aQJ;
    }

    @Generated
    public BooleanSupplier wn() {
        return this.aQK;
    }

    @Generated
    public T wo() {
        return this.aQL;
    }

    @Generated
    public boolean isVisible() {
        return this.visible;
    }

    @Generated
    public Toggleable wq() {
        return this.aQM;
    }

    @Generated
    public Consumer<T> getValueChangeConsumer() {
        return this.valueChangeConsumer;
    }

    @Generated
    public T ws() {
        return this.aQO;
    }

    @Generated
    public void setHideIf(BooleanSupplier hideIf) {
        this.aQJ = hideIf;
    }

    @Generated
    public void b(BooleanSupplier booleanSupplier) {
        this.aQK = booleanSupplier;
    }

    @Generated
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Generated
    public void a(Toggleable toggleable) {
        this.aQM = toggleable;
    }

    @Generated
    public void setValueChangeConsumer(Consumer<T> valueChangeConsumer) {
        this.valueChangeConsumer = valueChangeConsumer;
    }
}
