package hackclient.rise;

import com.alan.clients.util.interfaces.InstanceAccess;
import lombok.Generated;

public class adg implements adf, InstanceAccess {
    private double x;
    private double y;
    private double axy;
    private double jy;

    public adg(double var1, double var3, double var5, double var7) {
        this.x = var1;
        this.y = var3;
        this.axy = var5;
        this.jy = var7;
    }

    @Generated
    public double getX() {
        return this.x;
    }

    @Generated
    public double getY() {
        return this.y;
    }

    @Generated
    public double oM() {
        return this.axy;
    }

    @Generated
    public double da() {
        return this.jy;
    }

    @Generated
    public void setX(double var1) {
        this.x = var1;
    }

    @Generated
    public void setY(double var1) {
        this.y = var1;
    }

    @Generated
    public void P(double var1) {
        this.axy = var1;
    }

    @Generated
    public void h(double var1) {
        this.jy = var1;
    }
}
