package com.alan.clients.module.impl.player;

import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.BoundsNumberValue;
import com.alan.clients.util.math.MathUtil;
import com.alan.clients.util.player.ItemUtil;
import com.alan.clients.component.impl.player.GUIDetectionComponent;
import com.alan.clients.component.impl.player.SelectorDetectionComponent;
import java.util.function.Predicate;
import lombok.Generated;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import rip.vantage.commons.util.time.a;

@ModuleInfo(aliases = {"module.player.stealer.name", "Stealer"}, description = "module.player.stealer.description", category = Category.PLAYER)
public class Stealer extends Module {
    private final BoundsNumberValue delay = new BoundsNumberValue("Delay", this, 100, 150, 0, 500, 50);
    private final BoundsNumberValue firstItemDelay = new BoundsNumberValue("First Item Delay", this, 0, 0, 0, 500, 50);
    private final BooleanValue ignoreTrash = new BooleanValue("Ignore Trash", this, true);
    private final BooleanValue respectManagerRules = new BooleanValue("Respect Manager Rules", this, true);
    private final BooleanValue guiDetection = new BooleanValue("Gui Detection", this, true);
    private final a ahm = new a();
    private long nextClick;
    private int ahn;
    private int aho;
    private int ahp;
    private boolean fY;
    private boolean ahq;
    @EventLink
    public final Listener<PreMotionEvent> onPreMotionEvent = var1 -> {
        if (aEg.currentScreen instanceof GuiChest) {
            this.ahp++;
            this.fY = false;
            ContainerChest containerchest = (ContainerChest)aEg.thePlayer.openContainer;
            if (this.ahp == 1 && !this.ahq) {
                int i = this.firstItemDelay.wo().intValue();
                int j = this.firstItemDelay.wA().intValue();
                if (i > 0 || j > 0) {
                    this.nextClick = Math.round(MathUtil.l(i, j));
                    this.ahm.aX();
                    this.ahq = true;
                    return;
                }

                this.ahq = true;
            }

            if (this.guiDetection.wo() && GUIDetectionComponent.inGUI() || !this.ahm.T(this.nextClick)) {
                return;
            }

            this.aho++;

            for (int k = 0; k < containerchest.inventorySlots.size(); k++) {
                ItemStack itemstack = containerchest.getLowerChestInventory().getStackInSlot(k);
                if (itemstack != null && this.aho > 1 && (!this.ignoreTrash.wo() || ItemUtil.u(itemstack)) && (!this.respectManagerRules.wo() || !this.r(itemstack))) {
                    this.nextClick = Math.round(MathUtil.l(this.delay.wo().intValue(), this.delay.wA().intValue()));
                    aEg.playerController.windowClick(containerchest.windowId, k, 0, 1, aEg.thePlayer);
                    this.ahm.aX();
                    this.ahn = 0;
                    if (this.nextClick > 0L) {
                        return;
                    }
                }
            }

            this.ahn++;
            if (this.ahn > 1 && this.ahp > 2.0 + 2.0 * Math.random()) {
                aEg.thePlayer.closeScreen();
                this.fY = true;
            }
        } else {
            this.ahn = 0;
            this.ahp = 0;
            this.aho = 0;
            this.ahq = false;
        }
    };

    public Stealer() {
    }

    public boolean kv() {
        return this.fY;
    }

    private boolean r(ItemStack var1) {
        if (var1 != null && var1.getItem() != null) {
            Item item = var1.getItem();
            Manager manager = this.e(Manager.class);
            Container container = aEg.thePlayer.inventoryContainer;
            if (manager != null && SelectorDetectionComponent.a(var1, true) && manager.jP()) {
                return true;
            } else if (!ItemUtil.u(var1)) {
                return true;
            } else if (item instanceof ItemSword) {
                return !ItemUtil.b(var1, container);
            } else if (item instanceof ItemTool) {
                return !ItemUtil.b(var1, container, ItemUtil.d((ItemTool)item));
            } else if (item instanceof ItemBow) {
                return !ItemUtil.c(var1, container);
            } else if (item instanceof ItemArmor) {
                return !ItemUtil.a(var1, container, ((ItemArmor)item).armorType);
            } else if (item instanceof net.minecraft.item.be) {
                return this.a(var0 -> var0 instanceof net.minecraft.item.be) >= 1;
            }
            int i = manager != null ? manager.jL() : 128;
            int j = manager != null ? manager.jM() : 1;
            int k = manager != null ? manager.jN() : 16;
            int l = manager != null ? manager.jO() : 16;
            int i1 = manager != null ? manager.jK() : 512;
            if (item == Items.arrow) {
                return this.a(Items.arrow) + var1.stackSize > i;
            } else if (item == Items.ender_pearl) {
                return this.a(Items.ender_pearl) + var1.stackSize > l;
            } else if (item == Items.bucket || item == Items.water_bucket || item == Items.lava_bucket || item == Items.milk_bucket) {
                return this.a(Items.bucket) + this.a(Items.water_bucket) + this.a(Items.lava_bucket) + this.a(Items.milk_bucket) + var1.stackSize > j;
            } else if (item == Items.snowball || item == Items.egg) {
                return this.a(Items.snowball) + this.a(Items.egg) + var1.stackSize > k;
            }
            return item instanceof ItemBlock ? this.a(var0 -> var0 instanceof ItemBlock) + var1.stackSize > i1 : false;
        }
        return true;
    }

    private int a(Item var1) {
        int i = 0;

        for (int j = 0; j <= 39; j++) {
            ItemStack itemstack = aEg.thePlayer.inventory.getStackInSlot(j);
            if (itemstack != null && itemstack.getItem() == var1) {
                i += itemstack.stackSize;
            }
        }

        return i;
    }

    private int a(Predicate<Item> var1) {
        int i = 0;

        for (int j = 0; j <= 39; j++) {
            ItemStack itemstack = aEg.thePlayer.inventory.getStackInSlot(j);
            if (itemstack != null && var1.test(itemstack.getItem())) {
                i += itemstack.stackSize;
            }
        }

        return i;
    }

    @Generated
    public int kw() {
        return this.ahp;
    }
}
