package hackclient.rise;

import com.alan.clients.module.impl.render.appleskin.FoodValues;
import com.alan.clients.util.interfaces.InstanceAccess;
import lombok.Generated;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;

public final class yb implements InstanceAccess {
    public static FoodValues s(ItemStack var0) {
        ItemFood itemfood = (ItemFood)var0.getItem();
        int i = itemfood != null ? itemfood.getHealAmount(var0) : 0;
        float f = itemfood != null ? itemfood.getSaturationModifier(var0) : 0.0F;
        return new FoodValues(i, f);
    }

    public static boolean t(ItemStack var0) {
        if (!(var0.getItem() instanceof ItemFood)) {
            return false;
        }

        ItemFood itemfood = (ItemFood)var0.getItem();
        return itemfood.getPotionEffect(var0) != null ? Potion.potionTypes[itemfood.getPotionId()].isBadEffect() : false;
    }

    @Generated
    private yb() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
