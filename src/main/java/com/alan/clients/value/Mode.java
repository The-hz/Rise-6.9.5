package com.alan.clients.value;

import com.alan.clients.Client;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.interfaces.Toggleable;
import hackclient.rise.aha;
import java.util.ArrayList;
import java.util.List;
import lombok.Generated;

public abstract class Mode<T> implements InstanceAccess, aha, Toggleable {
    private final String name;
    private final T parent;
    private final List<Value<?>> values = new ArrayList<>();

    public void a() {
        Client.a.e().b(this);
        this.onEnable();
    }

    public void unregister() {
        Client.a.e().c(this);
        this.onDisable();
    }

    @Override
    public void toggle() {
    }

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
    }

    @Generated
    public String getName() {
        return this.name;
    }

    @Generated
    public T getParent() {
        return this.parent;
    }

    @Generated
    public List<Value<?>> getValues() {
        return this.values;
    }

    @Generated
    public Mode(String var1, T var2) {
        this.name = var1;
        this.parent = var2;
    }
}
