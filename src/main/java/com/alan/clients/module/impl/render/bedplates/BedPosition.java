package com.alan.clients.module.impl.render.bedplates;

import net.minecraft.util.BlockPos;

public class BedPosition {
    private final BlockPos alU;

    public BedPosition(BlockPos pos) {
        this.alU = pos;
    }

    public BlockPos getPosition() {
        return this.alU;
    }
}
