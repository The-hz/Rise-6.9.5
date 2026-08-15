package com.alan.clients.util.player;

import lombok.Generated;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;

public class EnumFacingOffset {
    public EnumFacing aOa;
    private final Vec3 aOb;

    public EnumFacingOffset(EnumFacing facing, Vec3 vec) {
        this.aOa = facing;
        this.aOb = vec;
    }

    @Generated
    public EnumFacing va() {
        return this.aOa;
    }

    @Generated
    public Vec3 vb() {
        return this.aOb;
    }
}
