package hackclient.rise;

import lombok.Generated;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;

public class aib {
    public EnumFacing aOa;
    private final Vec3 aOb;

    public aib(EnumFacing facing, Vec3 vec) {
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
