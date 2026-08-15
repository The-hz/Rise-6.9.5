package hackclient.rise;

import lombok.Generated;

public class adt {
    private final int aCR;
    private final int aCS;
    private final int aCT;
    private final int aCU;
    private final String[] split;

    public int getPart(int var1) {
        return Integer.parseInt(this.split[var1]);
    }

    public void setPart(int var1, int var2) {
        this.split[var1] = String.valueOf(var2);
    }

    public adt(int var1, int var2, int var3, int var4) {
        this.split = new String[]{String.valueOf(var1), String.valueOf(var2), String.valueOf(var3), String.valueOf(var4)};
        this.aCR = var1;
        this.aCS = var2;
        this.aCT = var3;
        this.aCU = var4;
    }

    public adt(String var1) {
        this.split = var1.split("\\.");
        this.aCR = Integer.parseInt(this.split[0]);
        this.aCS = Integer.parseInt(this.split[1]);
        this.aCT = Integer.parseInt(this.split[2]);
        this.aCU = Integer.parseInt(this.split[3]);
    }

    public static adt a(adt var0, adt var1) {
        int i = Math.min(var0.aCR, var1.aCR);
        int j = Math.min(var0.aCS, var1.aCS);
        int k = Math.min(var0.aCT, var1.aCT);
        int l = Math.min(var0.aCU, var1.aCU);
        return new adt(i, j, k, l);
    }

    public static adt b(adt var0, adt var1) {
        int i = Math.max(var0.aCR, var1.aCR);
        int j = Math.max(var0.aCS, var1.aCS);
        int k = Math.max(var0.aCT, var1.aCT);
        int l = Math.max(var0.aCU, var1.aCU);
        return new adt(i, j, k, l);
    }

    @Override
    public String toString() {
        return this.split[0] + "." + this.split[1] + "." + this.split[2] + "." + this.split[3];
    }

    @Generated
    public int ru() {
        return this.aCR;
    }

    @Generated
    public int rv() {
        return this.aCS;
    }

    @Generated
    public int rw() {
        return this.aCT;
    }

    @Generated
    public int getThird() {
        return this.aCU;
    }

    @Generated
    public String[] getSplit() {
        return this.split;
    }
}
