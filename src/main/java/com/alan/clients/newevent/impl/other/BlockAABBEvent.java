package com.alan.clients.newevent.impl.other;

import com.alan.clients.newevent.CancellableEvent;
import lombok.Generated;
import net.minecraft.block.Block;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockAABBEvent extends CancellableEvent {
    private final World world;
    private final Block block;
    private final BlockPos blockPos;
    private AxisAlignedBB jJ;
    private final AxisAlignedBB jK;

    @Generated
    public World getWorld() {
        return this.world;
    }

    @Generated
    public Block getBlock() {
        return this.block;
    }

    @Generated
    public BlockPos getBlockPos() {
        return this.blockPos;
    }

    @Generated
    public AxisAlignedBB dh() {
        return this.jJ;
    }

    @Generated
    public AxisAlignedBB di() {
        return this.jK;
    }

    @Generated
    public void setBoundingBox(AxisAlignedBB boundingBox) {
        this.jJ = boundingBox;
    }

    @Generated
    public BlockAABBEvent(World world, Block block, BlockPos blockPos, AxisAlignedBB box, AxisAlignedBB var5) {
        this.world = world;
        this.block = block;
        this.blockPos = blockPos;
        this.jJ = box;
        this.jK = var5;
    }
}
