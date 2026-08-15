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

    public static aka a(Entity entity, float var1) {
        return new aka(l(entity.posX, entity.prevPosX, var1), l(entity.posY, entity.prevPosY, var1), l(entity.posZ, entity.prevPosZ, var1));
    }
}
