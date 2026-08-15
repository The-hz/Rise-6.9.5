package hackclient.rise.packet;

import hackclient.rise.ahl;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;

public class ahn extends ahl {
    private final C08PacketPlayerBlockPlacement aNs;

    public ahn(C08PacketPlayerBlockPlacement packet) {
        super(46, EnumConnectionState.PLAY);
        this.aNs = packet;
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) {
        packetBuffer.writeVarIntToBuffer(0);
        packetBuffer.writeBlockPos(this.aNs.getPosition());
        packetBuffer.writeVarIntToBuffer(this.aNs.getPlacedBlockDirection());
        packetBuffer.writeFloat(this.aNs.facingX);
        packetBuffer.writeFloat(this.aNs.facingY);
        packetBuffer.writeFloat(this.aNs.facingZ);
        packetBuffer.writeBoolean(false);
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) {
    }
}
