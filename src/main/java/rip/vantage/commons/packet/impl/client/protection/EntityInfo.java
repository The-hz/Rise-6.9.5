package rip.vantage.commons.packet.impl.client.protection;

public class EntityInfo {
    private final int ePf;
    private final int ePg;
    private final boolean ePh;

    public EntityInfo(int var1, int var2, boolean var3) {
        this.ePf = var1;
        this.ePg = var2;
        this.ePh = var3;
    }

    public int getEntityId() {
        return this.ePf;
    }

    public int getType() {
        return this.ePg;
    }

    public boolean isInvisible() {
        return this.ePh;
    }
}
