package com.alan.clients.security;

import com.alan.clients.util.interfaces.InstanceAccess;
import net.minecraft.network.Packet;

public abstract class a implements InstanceAccess {
    private final String axb;
    private final String axc;

    public a(String var1, String var2) {
        this.axb = var1;
        this.axc = var2;
    }

    public abstract boolean j(Packet<?> var1);
}
