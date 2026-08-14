package hackclient.rise;

import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;

public class ahn extends ahl {
    private final C08PacketPlayerBlockPlacement aNs;

    public ahn(C08PacketPlayerBlockPlacement var1) {
        super(46, EnumConnectionState.PLAY);
        this.aNs = var1;
    }

    @Override
    public void writePacketData(PacketBuffer var1) {
        var1.writeVarIntToBuffer(0);
        var1.writeBlockPos(this.aNs.getPosition());
        var1.writeVarIntToBuffer(this.aNs.getPlacedBlockDirection());
        var1.writeFloat(this.aNs.facingX);
        var1.writeFloat(this.aNs.facingY);
        var1.writeFloat(this.aNs.facingZ);
        var1.writeBoolean(false);
    }

    @Override
    public void readPacketData(PacketBuffer var1) {
    }
}
