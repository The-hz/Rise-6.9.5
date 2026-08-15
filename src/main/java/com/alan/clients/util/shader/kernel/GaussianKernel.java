package com.alan.clients.util.shader.kernel;

public class GaussianKernel {
    private final int aQr;
    private final float[] aQs;

    public GaussianKernel(int var1) {
        this.aQr = var1;
        this.aQs = new float[var1];
    }

    public void uR() {
        float f = this.aQr / 2.0F;
        float f1 = 0.0F;

        for (int i = 0; i < this.aQr; i++) {
            float f2 = i / f;
            this.aQs[i] = 1.0F / (Math.abs(f) * 2.5066283F) * (float)Math.exp(-0.5 * f2 * f2);
            f1 += i > 0 ? this.aQs[i] * 2.0F : this.aQs[0];
        }

        for (int j = 0; j < this.aQr; j++) {
            this.aQs[j] = this.aQs[j] / f1;
        }
    }

    public int getSize() {
        return this.aQr;
    }

    public float[] vS() {
        return this.aQs;
    }
}
