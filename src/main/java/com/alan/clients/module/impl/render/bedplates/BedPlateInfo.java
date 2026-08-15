package com.alan.clients.module.impl.render.bedplates;

import hackclient.rise.aka;
import net.minecraft.block.material.MapColor;
import net.minecraft.item.ItemStack;

public class BedPlateInfo {
    private final ItemStack stack;
    private final String alW;
    private final String distanceText;
    private final double distanceSquared;
    private final double distance;
    private final MapColor mapColor;
    private final aka amb;
    private final boolean incomplete;
    private final boolean notProtected;

    public BedPlateInfo(ItemStack stack, double var2, MapColor mapColor, aka var5, boolean var6, boolean var7) {
        this.stack = stack;
        this.incomplete = var6;
        this.notProtected = var7;
        if (var7) {
            this.alW = "Not Protected";
        } else if (var6) {
            this.alW = "Incomplete";
        } else {
            this.alW = stack.getDisplayName();
        }

        this.distanceSquared = var2;
        this.distance = Math.sqrt(var2);
        this.mapColor = mapColor;
        this.amb = var5;
        this.distanceText = t(this.distance);
    }

    private static String t(double var0) {
        return Math.round(var0 * 10.0) / 10.0 + "m";
    }

    public ItemStack getStack() {
        return this.stack;
    }

    public String getDisplayName() {
        return this.alW;
    }

    public double getDistanceSquared() {
        return this.distanceSquared;
    }

    public double getDistance() {
        return this.distance;
    }

    public MapColor getMapColor() {
        return this.mapColor;
    }

    public aka getPosition() {
        return this.amb;
    }

    public boolean isIncomplete() {
        return this.incomplete;
    }

    public boolean isNotProtected() {
        return this.notProtected;
    }

    public String getDistanceText() {
        return this.distanceText;
    }
}
