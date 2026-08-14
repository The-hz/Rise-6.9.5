package hackclient.rise;

import net.minecraft.util.Vec3i;

public class ahs extends Vec3i {
    public ahs(int var1, int var2, int var3) {
        super(var1, var2, var3);
    }

    public ahs(double var1, double var3, double var5) {
        super(var1, var3, var5);
    }

    public ahs(Vec3i var1) {
        super(var1.getX(), var1.getY(), var1.getZ());
    }
}
