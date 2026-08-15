package com.alan.clients.newevent.impl.other;

import com.alan.clients.newevent.CancellableEvent;
import lombok.Generated;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public final class BlockDamageEvent extends CancellableEvent {
    private EntityPlayerSP player;
    private World world;
    private BlockPos blockPos;

    public BlockDamageEvent(EntityPlayerSP var1, World var2, BlockPos var3) {
        this.player = var1;
        this.world = var2;
        this.blockPos = var3;
    }

    @Generated
    public EntityPlayerSP getPlayer() {
        return this.player;
    }

    @Generated
    public World getWorld() {
        return this.world;
    }

    @Generated
    public BlockPos getBlockPos() {
        return this.blockPos;
    }

    @Generated
    public void setPlayer(EntityPlayerSP var1) {
        this.player = var1;
    }

    @Generated
    public void setWorld(World var1) {
        this.world = var1;
    }

    @Generated
    public void setBlockPos(BlockPos var1) {
        this.blockPos = var1;
    }
}
