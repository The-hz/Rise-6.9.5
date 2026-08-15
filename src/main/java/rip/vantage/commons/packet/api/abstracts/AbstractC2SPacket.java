package rip.vantage.commons.packet.api.abstracts;

public abstract class AbstractC2SPacket implements rip.vantage.commons.packet.api.interfaces.C2SPacket {
    private final byte eOq;

    public AbstractC2SPacket(byte var1) {
        this.eOq = var1;
    }

    public byte aeq() {
        return this.eOq;
    }
}
