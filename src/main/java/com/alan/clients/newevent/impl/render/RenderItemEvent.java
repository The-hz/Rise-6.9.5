package com.alan.clients.newevent.impl.render;

import com.alan.clients.newevent.CancellableEvent;
import lombok.Generated;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;

public final class RenderItemEvent extends CancellableEvent {
    private EnumAction enumAction;
    private boolean useItem;
    private float kl;
    private float jZ;
    private float km;
    private ItemStack itemToRender;

    @Generated
    public EnumAction dD() {
        return this.enumAction;
    }

    @Generated
    public boolean db() {
        return this.useItem;
    }

    @Generated
    public float dE() {
        return this.kl;
    }

    @Generated
    public float getPartialTicks() {
        return this.jZ;
    }

    @Generated
    public float dF() {
        return this.km;
    }

    @Generated
    public ItemStack dG() {
        return this.itemToRender;
    }

    @Generated
    public void a(EnumAction var1) {
        this.enumAction = var1;
    }

    @Generated
    public void k(boolean var1) {
        this.useItem = var1;
    }

    @Generated
    public void d(float var1) {
        this.kl = var1;
    }

    @Generated
    public void e(float var1) {
        this.jZ = var1;
    }

    @Generated
    public void f(float var1) {
        this.km = var1;
    }

    @Generated
    public void f(ItemStack var1) {
        this.itemToRender = var1;
    }

    @Generated
    public RenderItemEvent(EnumAction var1, boolean var2, float var3, float var4, float var5, ItemStack var6) {
        this.enumAction = var1;
        this.useItem = var2;
        this.kl = var3;
        this.jZ = var4;
        this.km = var5;
        this.itemToRender = var6;
    }
}
