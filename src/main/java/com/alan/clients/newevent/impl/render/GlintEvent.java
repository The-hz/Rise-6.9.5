package com.alan.clients.newevent.impl.render;

import com.alan.clients.newevent.CancellableEvent;
import lombok.Generated;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.item.ItemStack;

public final class GlintEvent extends CancellableEvent {
    private boolean jU;
    private boolean fX;
    private ItemStack itemStack;
    private IBakedModel model;

    @Generated
    public boolean dt() {
        return this.jU;
    }

    @Generated
    public boolean du() {
        return this.fX;
    }

    @Generated
    public ItemStack getItemStack() {
        return this.itemStack;
    }

    @Generated
    public IBakedModel getModel() {
        return this.model;
    }

    @Generated
    public void l(boolean var1) {
        this.jU = var1;
    }

    @Generated
    public void m(boolean var1) {
        this.fX = var1;
    }

    @Generated
    public void setItemStack(ItemStack var1) {
        this.itemStack = var1;
    }

    @Generated
    public void setModel(IBakedModel var1) {
        this.model = var1;
    }

    @Generated
    public GlintEvent(boolean var1, boolean var2, ItemStack var3, IBakedModel var4) {
        this.jU = var1;
        this.fX = var2;
        this.itemStack = var3;
        this.model = var4;
    }
}
