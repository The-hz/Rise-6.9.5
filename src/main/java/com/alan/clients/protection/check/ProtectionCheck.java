package com.alan.clients.protection.check;

import com.alan.clients.protection.check.api.McqBFVadWB;
import lombok.Generated;

public abstract class ProtectionCheck {
    private final McqBFVadWB awL;
    private final boolean exemptDev;

    public abstract boolean check() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException;

    @Generated
    public McqBFVadWB nY() {
        return this.awL;
    }

    @Generated
    public boolean nZ() {
        return this.exemptDev;
    }

    @Generated
    public ProtectionCheck(McqBFVadWB mcqBFVadWB, boolean exemptDev) {
        this.awL = mcqBFVadWB;
        this.exemptDev = exemptDev;
    }
}
