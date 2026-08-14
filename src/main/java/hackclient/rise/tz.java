package hackclient.rise;

import net.minecraft.item.ItemArmor.ArmorMaterial;

public class tz {
    public static final int[] afE = new int[ArmorMaterial.values().length];

    static {
        try {
            afE[ArmorMaterial.DIAMOND.ordinal()] = 1;
        } catch (NoSuchFieldError nosuchfielderror4) {
        }

        try {
            afE[ArmorMaterial.IRON.ordinal()] = 2;
        } catch (NoSuchFieldError nosuchfielderror3) {
        }

        try {
            afE[ArmorMaterial.CHAIN.ordinal()] = 3;
        } catch (NoSuchFieldError nosuchfielderror2) {
        }

        try {
            afE[ArmorMaterial.GOLD.ordinal()] = 4;
        } catch (NoSuchFieldError nosuchfielderror1) {
        }

        try {
            afE[ArmorMaterial.LEATHER.ordinal()] = 5;
        } catch (NoSuchFieldError nosuchfielderror) {
        }
    }
}
