package com.alan.clients.newevent.impl.other;

import com.alan.clients.newevent.CancellableEvent;
import lombok.Generated;
import net.minecraft.util.BlockPos;

public final class BlockBreakEvent extends CancellableEvent {
    private BlockPos blockPos;

    @Generated
    public BlockPos getBlockPos() {
        return this.blockPos;
    }

    @Generated
    public void setBlockPos(BlockPos var1) {
        this.blockPos = var1;
    }

    @Generated
    public BlockBreakEvent(BlockPos var1) {
        this.blockPos = var1;
    }
}
