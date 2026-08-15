package hackclient.rise;

import lombok.Generated;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.g;

public abstract class ahl implements Packet {
    private final int aNq;
    private final EnumConnectionState aNr;

    @Override
    public void readPacketData(PacketBuffer packetBuffer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void processPacket(g var1) {
    }

    @Generated
    public ahl(int var1, EnumConnectionState enumConnectionState) {
        this.aNq = var1;
        this.aNr = enumConnectionState;
    }

    @Generated
    public int uL() {
        return this.aNq;
    }

    @Generated
    public EnumConnectionState uM() {
        return this.aNr;
    }
}
