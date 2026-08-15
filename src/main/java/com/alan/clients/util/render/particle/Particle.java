package com.alan.clients.util.render.particle;

import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2f;
import hackclient.rise.aip;
import java.awt.Color;
import rip.vantage.commons.util.time.a;

public class Particle implements InstanceAccess {
    private final Vector2f aPu;
    private final Vector2f aPv;
    private final float aPw;
    private final Color aPx;
    private Color aPy;
    private Color aPz;
    public a bN = new a();
    public a hj = new a();
    public float aoJ;

    public Particle(Vector2f var1, Color var2, Vector2f var3, float var4) {
        this.aPu = var1;
        this.aPx = var2;
        this.aPv = var3;
        this.aPw = var4;
        this.bN.aX();
        this.aoJ = var2.getAlpha();
    }

    public Particle(Vector2f var1, Vector2f var2) {
        this.aPu = var1;
        this.aPx = aip.d(aip.a(this.rz().rA(), this.rz().rB(), Math.random()), (int)(Math.random() * 255.0));
        this.aPv = var2;
        this.aPw = (float)(2.0 + Math.random() * 3.0);
        this.bN.aX();
        this.aoJ = this.aPx.getAlpha();
    }

    public void cj() {
        if (this.aPy != null && this.aPz != null) {
            RenderUtil.roundedRectangle(this.aPu.x, this.aPu.y, this.aPw, this.aPw, this.aPw / 2.0F, this.aPy);
        }
    }

    public void ci() {
        if (this.aPy != null && this.aPz != null) {
            RenderUtil.roundedRectangle(this.aPu.x, this.aPu.y, this.aPw, this.aPw, this.aPw / 2.0F, this.aPz);
        }
    }

    public void ju() {
        for (int i = 0; i <= this.bN.aKx(); i++) {
            this.aPu.setX(this.aPu.getX() + this.aPv.getX() / 10.0F);
            this.aPu.setY(this.aPu.getY() + this.aPv.getY() / 10.0F);
            this.aPv.setX(this.aPv.getX() * 0.999F);
            this.aPv.setY(this.aPv.getY() * 0.999F);
        }

        this.aPz = aip.d(this.aPx, (int)this.aoJ * 3);
        this.aPy = aip.d(this.aPx, (int)this.aoJ);
        this.aoJ = Math.max(this.aoJ - (float)this.bN.aKx() / 18.0F, 0.0F);
        this.bN.aX();
    }
}
