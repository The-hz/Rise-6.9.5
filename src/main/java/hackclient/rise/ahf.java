package hackclient.rise;

import net.minecraft.entity.Entity;

public class ahf {
    public ahf() {
    }

    public static double l(double var0, double var2, double var4) {
        return var2 + (var0 - var2) * var4;
    }

    public static float d(float var0, float var1, float var2) {
        return var1 + (var0 - var1) * var2;
    }

    public static aka a(aka var0, aka var1, double var2) {
        return new aka(l(var0.getX(), var1.getX(), var2), l(var0.getY(), var1.getY(), var2), l(var0.getZ(), var1.getZ(), var2));
    }

    public static aka a(Entity var0, float var1) {
        return new aka(l(var0.posX, var0.prevPosX, var1), l(var0.posY, var0.prevPosY, var1), l(var0.posZ, var0.prevPosZ, var1));
    }
}
