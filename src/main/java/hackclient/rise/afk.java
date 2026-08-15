package hackclient.rise;

import com.alan.clients.util.gui.GUIUtil;
import com.alan.clients.util.vector.Vector2d;
import rip.vantage.commons.util.time.a;

public class afk {
    public Vector2d apP;
    public Vector2d atg;
    public Vector2d aHe;
    public Vector2d bS = new Vector2d(0.0, 0.0);
    public boolean dragging = false;
    public a bN = new a();

    public afk(Vector2d var1, Vector2d var2) {
        this.apP = this.atg = var1;
        this.aHe = var2;
    }

    public void al(int var1) {
        Vector2d vector2d = afl.sW();
        if (GUIUtil.mouseOver(this.apP, this.aHe, vector2d.x, vector2d.y) && var1 == 0) {
            this.dragging = true;
            this.bS.x = this.atg.x - vector2d.x;
            this.bS.y = this.atg.y - vector2d.y;
        }
    }

    public void cj() {
        Vector2d vector2d = afl.sW();
        if (this.dragging) {
            if (this.atg == null) {
                this.atg = new Vector2d(0.0, 0.0);
            }

            this.atg.x = vector2d.x + this.bS.x;
            this.atg.y = vector2d.y + this.bS.y;
        }

        if (this.atg != null) {
            if (Math.abs(this.apP.x - this.atg.x) > 1.0 || Math.abs(this.apP.y - this.atg.y) > 1.0) {
                for (int i = 0; i <= this.bN.aKx(); i++) {
                    this.apP.x = (this.apP.x * 38.0 + this.atg.x) / 39.0;
                    this.apP.y = (this.apP.y * 38.0 + this.atg.y) / 39.0;
                }
            }

            this.bN.aX();
        }
    }

    public void pE() {
        this.dragging = false;
    }
}
