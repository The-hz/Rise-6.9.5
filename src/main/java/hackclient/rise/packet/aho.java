package hackclient.rise.packet;

import hackclient.rise.ahl;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.PacketBuffer;

public final class aho extends ahl {
    private int aNt;

    public aho(int var1) {
        super(0, EnumConnectionState.PLAY);
        this.aNt = var1;
    }

    @Override
    public void readPacketData(PacketBuffer var1) {
        this.aNt = var1.readInt();
    }

    @Override
    public void writePacketData(PacketBuffer var1) {
        var1.writeInt(this.aNt);
    }

    @Override
    public int uL() {
        return 29;
    }
}
