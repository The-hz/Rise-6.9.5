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
    public ItemStack getItemToRender() {
        return this.itemToRender;
    }

    @Generated
    public void setEnumAction(EnumAction enumAction) {
        this.enumAction = enumAction;
    }

    @Generated
    public void setUseItem(boolean useItem) {
        this.useItem = useItem;
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
    public void setItemToRender(ItemStack itemToRender) {
        this.itemToRender = itemToRender;
    }

    @Generated
    public RenderItemEvent(EnumAction enumAction, boolean useItem, float var3, float var4, float var5, ItemStack itemToRender) {
        this.enumAction = enumAction;
        this.useItem = useItem;
        this.kl = var3;
        this.jZ = var4;
        this.km = var5;
        this.itemToRender = itemToRender;
    }
}
