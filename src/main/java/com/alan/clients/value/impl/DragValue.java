package com.alan.clients.value.impl;

import com.alan.clients.module.Module;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.value.Mode;
import com.alan.clients.value.Value;
import java.util.List;
import java.util.function.BooleanSupplier;
import lombok.Generated;
import net.minecraft.client.gui.ScaledResolution;

public class DragValue extends Value implements InstanceAccess {
    public Vector2d apP = new Vector2d(100.0, 100.0);
    public Vector2d atg = new Vector2d(100.0, 100.0);
    public Vector2d aHe = new Vector2d(100.0, 100.0);
    public Vector2d aQX = new Vector2d(-1.0, -1.0);
    public Animation aQY = new Animation(Easing.LINEAR, 600L);
    public Animation aQZ = new Animation(Easing.EASE_OUT_EXPO, 300L);
    public ScaledResolution lastScaledResolution = new ScaledResolution(aEg);
    public boolean fX = true;
    public boolean aRb;

    public DragValue(String var1, Module var2, Vector2d var3) {
        super(var1, var2, var3);
    }

    public DragValue(String var1, Module var2, Vector2d var3, boolean var4) {
        super(var1, var2, var3);
        this.fX = var4;
    }

    public DragValue(String var1, Module var2, Vector2d var3, boolean var4, boolean var5) {
        super(var1, var2, var3);
        this.fX = var4 && !var5;
        this.aRb = var5;
    }

    public DragValue(String var1, Mode<?> var2, Vector2d var3) {
        super(var1, var2, var3);
    }

    public DragValue(String var1, Module var2, Vector2d var3, BooleanSupplier var4) {
        super(var1, var2, var3, var4);
    }

    public DragValue(String var1, Mode<?> var2, Vector2d var3, BooleanSupplier var4) {
        super(var1, var2, var3, var4);
    }

    @Override
    public List<Value<?>> getSubValues() {
        return null;
    }

    public void n(Vector2d var1) {
        this.aHe = var1;
        if (this.aQX.x == -1.0 && this.aQX.y == -1.0) {
            this.aQX = this.aHe;
        }

        ScaledResolution scaledresolution = aEg.jY;
        if (this.apP.x > scaledresolution.getScaledWidth() / 2.0F) {
            this.atg.x = this.atg.x + (this.aQX.x - this.aHe.x);
            this.apP = this.atg;
        }

        if (this.apP.y > scaledresolution.getScaledHeight() / 2.0F) {
            this.atg.y = this.atg.y + (this.aQX.y - this.aHe.y);
            this.apP = this.atg;
        }

        this.aQX = var1;
        this.lastScaledResolution = scaledresolution;
    }

    @Generated
    public void h(Vector2d var1) {
        this.apP = var1;
    }

    @Generated
    public void i(Vector2d var1) {
        this.atg = var1;
    }

    @Generated
    public void o(Vector2d var1) {
        this.aQX = var1;
    }

    @Generated
    public void d(Animation var1) {
        this.aQY = var1;
    }

    @Generated
    public void e(Animation var1) {
        this.aQZ = var1;
    }

    @Generated
    public void d(ScaledResolution var1) {
        this.lastScaledResolution = var1;
    }

    @Generated
    public void m(boolean var1) {
        this.fX = var1;
    }

    @Generated
    public void N(boolean var1) {
        this.aRb = var1;
    }
}
