package rip.vantage.commons.packet.api.abstracts;

import rip.vantage.commons.packet.api.interfaces.c;

public abstract class b implements c {
    private final byte eOr;

    public b(byte var1) {
        this.eOr = var1;
    }

    public byte aeq() {
        return this.eOr;
    }
}
