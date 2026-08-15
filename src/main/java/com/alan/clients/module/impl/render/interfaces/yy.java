package com.alan.clients.module.impl.render.interfaces;

import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.SubMode;

class yy extends ModeValue {
    yy(ModernInterface var1, String var2, Mode var3) {
        super(var2, var3);
        this.add(new SubMode("Glow"));
        this.add(new SubMode("Shadow"));
        this.setDefault("Shadow");
    }
}
