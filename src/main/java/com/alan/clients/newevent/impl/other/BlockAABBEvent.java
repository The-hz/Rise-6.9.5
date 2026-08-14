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
    public World de() {
        return this.world;
    }

    @Generated
    public Block df() {
        return this.block;
    }

    @Generated
    public BlockPos dg() {
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
    public void a(AxisAlignedBB var1) {
        this.jJ = var1;
    }

    @Generated
    public BlockAABBEvent(World var1, Block var2, BlockPos var3, AxisAlignedBB var4, AxisAlignedBB var5) {
        this.world = var1;
        this.block = var2;
        this.blockPos = var3;
        this.jJ = var4;
        this.jK = var5;
    }
}
