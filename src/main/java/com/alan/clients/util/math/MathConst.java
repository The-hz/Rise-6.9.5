package com.alan.clients.util.math;

import net.minecraft.util.MathHelper;

public class MathConst {
    public static final float aNd = (float) Math.PI;
    public static final float aNe = (float) (Math.PI / 180.0);
    public static final float aNf = 180.0F / (float)Math.PI;
    public static final float[] aNg = new float[361];
    public static final float[] aNh = new float[361];

    public MathConst() {
    }

    public static int C(float var0) {
        return (int)(var0 % 360.0F + 360.0F) % 360;
    }

    static {
        for (int i = 0; i <= 360; i++) {
            aNg[i] = MathHelper.cos(i * (float) (Math.PI / 180.0));
            aNh[i] = MathHelper.sin(i * (float) (Math.PI / 180.0));
        }
    }
}
