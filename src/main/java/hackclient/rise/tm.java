package hackclient.rise;

import net.minecraft.item.ItemStack;

public class tm {
    private final ItemStack acJ;
    private final int acK;

    public tm(ItemStack stack, int var2) {
        this.acJ = stack;
        this.acK = var2;
    }

    public ItemStack bO() {
        return this.acJ;
    }

    public int jH() {
        return this.acK;
    }

    public int jI() {
        return this.acJ.stackSize;
    }
}
