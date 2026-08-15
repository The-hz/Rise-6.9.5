package hackclient.rise;

public class adj extends adm {
    public String aCb;
    public String aCc;

    public adj(double var1, double var3, double var5, double var7, Runnable var9, String var10, String var11) {
        super(var1, var3, var5, var7, var9, var10);
        this.aCb = var11;
        this.aCc = var10;
    }

    @Override
    public void draw(int var1, int var2, float var3) {
        super.draw(var1, var2, var3);
        if (!aeb.isHovered(this.getX(), this.getY(), this.oM(), this.da(), var1, var2)) {
            this.name = this.aCc;
        }
    }

    @Override
    public void runAction() {
        super.runAction();
        this.name = this.aCb;
    }
}
