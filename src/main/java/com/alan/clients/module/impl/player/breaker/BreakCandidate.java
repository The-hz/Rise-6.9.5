package com.alan.clients.module.impl.player.breaker;

import java.util.List;
import net.minecraft.util.BlockPos;

public final class BreakCandidate {
    private final BlockPos acm;
    public final List<BlockPos> acn;
    public final double aco;

    public BreakCandidate(BlockPos pos, List<BlockPos> poses, double var3) {
        this.acm = pos;
        this.acn = poses;
        this.aco = var3;
    }
}
