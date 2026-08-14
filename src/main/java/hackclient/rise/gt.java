package hackclient.rise;

import net.minecraft.item.Item.ToolMaterial;

public class gt {
    public static final int[] pe = new int[ToolMaterial.values().length];

    static {
        try {
            pe[ToolMaterial.WOOD.ordinal()] = 1;
        } catch (NoSuchFieldError nosuchfielderror3) {
        }

        try {
            pe[ToolMaterial.STONE.ordinal()] = 2;
        } catch (NoSuchFieldError nosuchfielderror2) {
        }

        try {
            pe[ToolMaterial.IRON.ordinal()] = 3;
        } catch (NoSuchFieldError nosuchfielderror1) {
        }

        try {
            pe[ToolMaterial.GOLD.ordinal()] = 4;
        } catch (NoSuchFieldError nosuchfielderror) {
        }
    }
}
