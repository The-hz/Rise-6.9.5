package hackclient.rise;

import net.minecraft.block.material.MapColor;
import net.minecraft.item.ItemStack;

public class wk {
    private final ItemStack alV;
    private final String alW;
    private final String alX;
    private final double alY;
    private final double alZ;
    private final MapColor ama;
    private final aka amb;
    private final boolean amc;
    private final boolean amd;

    public wk(ItemStack stack, double var2, MapColor mapColor, aka var5, boolean var6, boolean var7) {
        this.alV = stack;
        this.amc = var6;
        this.amd = var7;
        if (var7) {
            this.alW = "Not Protected";
        } else if (var6) {
            this.alW = "Incomplete";
        } else {
            this.alW = stack.getDisplayName();
        }

        this.alY = var2;
        this.alZ = Math.sqrt(var2);
        this.ama = mapColor;
        this.amb = var5;
        this.alX = t(this.alZ);
    }

    private static String t(double var0) {
        return Math.round(var0 * 10.0) / 10.0 + "m";
    }

    public ItemStack lb() {
        return this.alV;
    }

    public String lc() {
        return this.alW;
    }

    public double kU() {
        return this.alY;
    }

    public double ld() {
        return this.alZ;
    }

    public MapColor le() {
        return this.ama;
    }

    public aka lf() {
        return this.amb;
    }

    public boolean lg() {
        return this.amc;
    }

    public boolean lh() {
        return this.amd;
    }

    public String li() {
        return this.alX;
    }
}
