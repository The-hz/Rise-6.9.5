package com.alan.clients.packet;

import hackclient.rise.ahl;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;

public class BlockPlacementPacket extends ahl {
    private final C08PacketPlayerBlockPlacement packet;

    public BlockPlacementPacket(C08PacketPlayerBlockPlacement packet) {
        super(46, EnumConnectionState.PLAY);
        this.packet = packet;
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) {
        packetBuffer.writeVarIntToBuffer(0);
        packetBuffer.writeBlockPos(this.packet.getPosition());
        packetBuffer.writeVarIntToBuffer(this.packet.getPlacedBlockDirection());
        packetBuffer.writeFloat(this.packet.facingX);
        packetBuffer.writeFloat(this.packet.facingY);
        packetBuffer.writeFloat(this.packet.facingZ);
        packetBuffer.writeBoolean(false);
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) {
    }
}
