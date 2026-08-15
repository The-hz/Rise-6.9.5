package com.alan.clients.module.impl.render.chat;

import java.awt.image.BufferedImage;
import java.util.Arrays;

public class ChatImage {
    private static final int are = 300;
    private static final int arf = 200;
    private final String arg;
    private final int arh;
    private final int ari;
    private final long arj;
    private volatile BufferedImage[] ark;
    private volatile int[] arl = new int[0];
    private volatile int[] arm = new int[]{100};
    private volatile int arn;
    private volatile int aro;
    private volatile boolean loaded;
    private volatile boolean arp;
    private volatile boolean arq;
    private volatile long arr = System.currentTimeMillis();

    public ChatImage(String var1, int var2, int var3) {
        this.arg = var1;
        this.arh = var2;
        this.ari = var3;
        this.arj = System.currentTimeMillis();
    }

    public String mY() {
        return this.arg;
    }

    public int mZ() {
        return this.arh;
    }

    public int na() {
        return this.ari;
    }

    public long nb() {
        return this.arj;
    }

    public boolean isLoaded() {
        return this.loaded;
    }

    public boolean nc() {
        return this.arp;
    }

    public int[] nd() {
        return this.arl;
    }

    public synchronized void b(BufferedImage image) {
        this.a(new BufferedImage[]{image}, new int[]{100});
    }

    public synchronized void a(BufferedImage[] images, int[] var2) {
        this.ark = images;
        this.arn = images[0].getWidth();
        this.aro = images[0].getHeight();
        this.loaded = true;
        this.arp = false;
        this.arq = true;
        this.arl = new int[images.length];
        Arrays.fill(this.arl, -1);
        this.arm = var2 != null && var2.length == images.length ? var2 : new int[images.length];

        for (int i = 0; i < this.arm.length; i++) {
            if (this.arm[i] <= 0) {
                this.arm[i] = 100;
            }
        }

        this.arr = System.currentTimeMillis();
    }

    public synchronized boolean ne() {
        return this.arq && this.ark != null && this.arl.length > 0 && this.arl[0] < 0;
    }

    public synchronized BufferedImage[] nf() {
        return this.ark;
    }

    public synchronized void a(int[] var1) {
        this.arl = var1;
        this.arq = false;
        this.ark = null;
    }

    public synchronized void ng() {
        this.arp = true;
        this.loaded = false;
        this.arq = false;
        this.ark = null;
        this.arl = new int[0];
    }

    public int nh() {
        int[] aint = this.arl;
        if (aint != null && aint.length != 0) {
            if (aint.length == 1) {
                return aint[0];
            }

            int[] aint1 = this.arm;
            int i = 0;

            for (int j : aint1) {
                i += Math.max(j, 20);
            }

            if (i <= 0) {
                return aint[0];
            }

            long k = (System.currentTimeMillis() - this.arr) % i;

            for (int l = 0; l < aint.length; l++) {
                k -= Math.max(aint1[l], 20);
                if (k < 0L) {
                    return aint[l];
                }
            }

            return aint[0];
        }
        return -1;
    }

    public int q(float var1) {
        if (this.arn > 0 && this.aro > 0) {
            float f = Math.min(var1, 300.0F);
            float f1 = (float)this.arn / this.aro;
            int i = Math.min(this.arn, (int)f);
            int j = Math.max(1, Math.round(i / f1));
            if (j > 200) {
                short short1 = 200;
                i = Math.max(1, Math.round(short1 * f1));
            }

            return Math.max(1, i);
        }
        return Math.min((int)var1, 300);
    }

    public int r(float var1) {
        if (this.arn > 0 && this.aro > 0) {
            float f = (float)this.arn / this.aro;
            int i = Math.min(this.arn, Math.min((int)var1, 300));
            return Math.min(Math.max(1, Math.round(i / f)), 200);
        }
        return 0;
    }
}
