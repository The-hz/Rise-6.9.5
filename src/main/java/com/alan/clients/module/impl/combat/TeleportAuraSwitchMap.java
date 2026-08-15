package com.alan.clients.module.impl.combat;

import net.minecraft.item.Item.ToolMaterial;

public class TeleportAuraSwitchMap {
    public static final int[] qr = new int[ToolMaterial.values().length];

    static {
        try {
            qr[ToolMaterial.WOOD.ordinal()] = 1;
        } catch (NoSuchFieldError nosuchfielderror4) {
        }

        try {
            qr[ToolMaterial.STONE.ordinal()] = 2;
        } catch (NoSuchFieldError nosuchfielderror3) {
        }

        try {
            qr[ToolMaterial.IRON.ordinal()] = 3;
        } catch (NoSuchFieldError nosuchfielderror2) {
        }

        try {
            qr[ToolMaterial.EMERALD.ordinal()] = 4;
        } catch (NoSuchFieldError nosuchfielderror1) {
        }

        try {
            qr[ToolMaterial.GOLD.ordinal()] = 5;
        } catch (NoSuchFieldError nosuchfielderror) {
        }
    }
}
