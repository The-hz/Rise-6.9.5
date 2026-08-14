package com.alan.clients.script.api.wrapper.impl.packet;

import com.alan.clients.script.api.wrapper.ScriptWrapper;
import net.minecraft.network.Packet;

public abstract class ScriptPacket<T extends Packet<?>> extends ScriptWrapper<T> {
    public ScriptPacket(T var1) {
        super((T)var1);
    }

    public String getType() {
        return this.wrapped.getClass().getSimpleName();
    }

    public String getFullType() {
        return this.wrapped.getClass().getName();
    }

    public boolean isType(String var1) {
        String s = this.wrapped.getClass().getSimpleName();
        String s1 = this.wrapped.getClass().getName();
        return s.equals(var1) || s1.equals(var1) || s1.endsWith("." + var1);
    }

    public T getWrapped() {
        return this.wrapped;
    }
}
