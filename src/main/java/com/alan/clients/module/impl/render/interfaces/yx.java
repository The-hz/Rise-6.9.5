package com.alan.clients.module.impl.render.interfaces;

import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.SubMode;

class yx extends ModeValue {
    yx(ModernInterface var1, String var2, Mode var3) {
        super(var2, var3);
        this.add(new SubMode("Apple UI"));
        this.add(new SubMode("Minecraft"));
        this.add(new SubMode("Custom"));
        this.setDefault("Apple UI");
    }
}
