package hackclient.rise;

import lombok.Generated;
import net.minecraft.util.ResourceLocation;

public class by {
    private bz gp;
    private String gq;
    private String gr;
    private String[] gs;
    private ResourceLocation[] gt;
    private boolean gu = false;
    private int gv = 0;

    public by(String var1) {
        this.gr = var1;
    }

    public ResourceLocation bS() {
        return this.gt[this.gv % this.gt.length];
    }

    public boolean bT() {
        return this.gs.length != 0;
    }

    public void a(bz var1) {
        this.gp = var1;
    }

    public void o(String var1) {
        this.gq = var1;
    }

    public String getColorCode() {
        return this.gp.getColorCode();
    }

    public bz bV() {
        return this.gp;
    }

    @Generated
    public String bW() {
        return this.gq;
    }

    @Generated
    public String bX() {
        return this.gr;
    }

    @Generated
    public String[] bY() {
        return this.gs;
    }

    @Generated
    public void b(String[] var1) {
        this.gs = var1;
    }

    @Generated
    public ResourceLocation[] bZ() {
        return this.gt;
    }

    @Generated
    public void a(ResourceLocation[] locations) {
        this.gt = locations;
    }

    @Generated
    public boolean ca() {
        return this.gu;
    }

    @Generated
    public void e(boolean var1) {
        this.gu = var1;
    }

    @Generated
    public int cb() {
        return this.gv;
    }

    @Generated
    public void j(int var1) {
        this.gv = var1;
    }
}
