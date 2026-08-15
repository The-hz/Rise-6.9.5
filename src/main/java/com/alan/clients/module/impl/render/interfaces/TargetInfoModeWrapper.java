package com.alan.clients.module.impl.render.interfaces;

import com.alan.clients.module.Module;
import com.alan.clients.module.impl.render.Interface;
import com.alan.clients.module.impl.render.TargetInfo;
import com.alan.clients.value.Mode;
import lombok.Generated;

public class TargetInfoModeWrapper<I extends Module> extends Mode<Interface> {
    private final Mode<TargetInfo> atf;

    public TargetInfoModeWrapper(String var1, Interface var2, Mode<TargetInfo> mode) {
        super(var1, var2);
        this.atf = mode;
    }

    @Generated
    public Mode<TargetInfo> np() {
        return this.atf;
    }
}
