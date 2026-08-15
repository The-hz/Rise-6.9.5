package com.alan.clients.module.impl.render.interfaces;

import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.SubMode;

class yz extends ModeValue {
    yz(ModernInterface var1, String var2, Mode var3) {
        super(var2, var3);
        this.add(new SubMode("Off"));
        this.add(new SubMode("Normal"));
        this.setDefault("Normal");
    }
}
