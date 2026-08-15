package com.alan.clients.module.impl.player;

import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.module.impl.movement.InventoryMove;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.other.AttackEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.BoundsNumberValue;
import com.alan.clients.value.impl.NumberValue;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import de.florianmichael.vialoadingbase.ViaLoadingBase;
import com.alan.clients.util.math.MathUtil;
import com.alan.clients.util.packet.PacketUtil;
import com.alan.clients.util.player.ItemUtil;
import com.alan.clients.util.player.PlayerUtil;
import com.alan.clients.component.impl.player.BadPacketsComponent;
import com.alan.clients.component.impl.player.SelectorDetectionComponent;
import hackclient.rise.en;
import hackclient.rise.tp;
import com.alan.clients.util.render.IntGatherer;
import hackclient.rise.tr;
import hackclient.rise.ts;
import hackclient.rise.tt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lombok.Generated;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.be;
import net.minecraft.item.bw;
import net.minecraft.item.cn;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C16PacketClientStatus.EnumState;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.network.play.client.q;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import rip.vantage.commons.util.time.a;

@ModuleInfo(aliases = {"module.player.manager.name", "Manager"}, description = "module.player.manager.description", category = Category.PLAYER)
public class Manager extends Module {
    private final BoundsNumberValue delay = new BoundsNumberValue("Delay", this, 100, 150, 0, 500, 50);
    private final BooleanValue legit = new BooleanValue("Legit", this, false);
    private final BooleanValue dropCustomItems = new BooleanValue("Drop Custom Items", this, false);
    private final BooleanValue useCustomItems = new BooleanValue("Use Custom Items", this, false);
    private final BooleanValue prioritizeSplashPotions = new BooleanValue("Prioritize Splash Potions", this, false);
    private final NumberValue blockLimit = new NumberValue("Block Limit", this, 512, 0, 512, 4);
    private final NumberValue arrowLimit = new NumberValue("Arrow Limit", this, 128, 0, 512, 4);
    private final NumberValue bucketLimit = new NumberValue("Bucket Limit", this, 1, 0, 4, 1);
    private final NumberValue snowballEggLimit = new NumberValue("Snowball/Egg Limit", this, 16, 0, 64, 1);
    private final NumberValue enderPearlLimit = new NumberValue("Ender Pearl Limit", this, 16, 0, 64, 1);
    private final NumberValue swordSlot = new NumberValue("Sword Slot", this, 1, 0, 9, 1);
    private final NumberValue secondSwordSlot = new NumberValue("Second Sword Slot", this, 2, 0, 9, 1);
    private final NumberValue pickaxeSlot = new NumberValue("Pickaxe Slot", this, 2, 0, 9, 1);
    private final NumberValue axeSlot = new NumberValue("Axe Slot", this, 3, 0, 9, 1);
    private final NumberValue shovelSlot = new NumberValue("Shovel Slot", this, 4, 0, 9, 1);
    private final BoundsNumberValue blockSlot = new BoundsNumberValue("Block Slot", this, 5, 5, 0, 9, 1);
    private final BoundsNumberValue potionSlot = new BoundsNumberValue("Potion Slot", this, 6, 6, 0, 9, 1);
    private final NumberValue bowSlot = new NumberValue("Bow Slot", this, 7, 0, 9, 1);
    private final NumberValue add = new NumberValue("Rod Slot", this, 8, 0, 9, 1);
    private final BoundsNumberValue foodSlot = new BoundsNumberValue("Food Slot", this, 9, 9, 0, 9, 1);
    private static final int adf = 39;
    private static final int adg = 38;
    private static final int adh = 37;
    private static final int adi = 36;
    private int adj = 0;
    private static final int adk = 0;
    private static final int adl = 8;
    private static final int adm = 9;
    private static final int adn = 35;
    private final a ado = new a();
    private int adp;
    private int BV;
    private int adq;
    private boolean adr;
    private boolean ads;
    private long nextClick;
    private boolean adu = false;
    private int adv;
    private int adw;
    private boolean adx = false;
    private int ady = 0;
    private int adz = 0;
    @EventLink(value = 2)
    public final Listener<PreMotionEvent> onPreMotionEvent = var1 -> {
        if (aEg.thePlayer != null && aEg.theWorld != null) {
            if (aEg.thePlayer.ticksExisted > 40) {
                if (this.s(4.5)) {
                    this.adj = 10;
                } else if (this.adj > 0) {
                    this.adj--;
                }

                if (this.adu && aEg.currentScreen == null && this.ads && !BadPacketsComponent.bad(false, false, false, false, true) && (this.adj == 0 || this.adq >= 10)) {
                    PacketUtil.l(new q(aEg.thePlayer.inventoryContainer.windowId));
                    this.jX();
                    this.adu = false;
                    this.ads = false;
                }

                if (this.jV()) {
                    this.adp = 0;
                } else {
                    this.adp++;
                }

                this.BV++;
                this.adq++;
                if (this.legit.wo() && !(aEg.currentScreen instanceof GuiInventory)) {
                    this.ado.aX();
                    this.u(false);
                } else if (!this.ado.T(this.nextClick) || this.adp < 10 || this.BV < 10 || this.adq < 10 || this.e(Scaffold.class).isEnabled()) {
                    this.u(false);
                } else if (this.jV()) {
                    this.u(false);
                } else if (!this.e(InventoryMove.class).isEnabled() && !(aEg.currentScreen instanceof GuiInventory)) {
                    this.u(false);
                } else {
                    this.adr = false;
                    tr tr = this.jR();
                    boolean flag = this.a(tr);
                    if (!this.adx) {
                        if (!flag) {
                            return;
                        }

                        this.jT();
                        if (this.ady > 0) {
                            this.ady--;
                            return;
                        }
                    } else {
                        if (!flag) {
                            this.u(true);
                            return;
                        }

                        if (this.ady > 0) {
                            this.ady--;
                            return;
                        }
                    }

                    if (this.jW()) {
                        this.jQ();
                    } else if (this.c(0, tr.adF)) {
                        this.jQ();
                    } else if (this.c(1, tr.adG)) {
                        this.jQ();
                    } else if (this.c(2, tr.adH)) {
                        this.jQ();
                    } else if (this.c(3, tr.adI)) {
                        this.jQ();
                    } else if (this.d(tr)) {
                        this.jQ();
                    } else if (this.e(tr)) {
                        this.jQ();
                    } else if (this.f(tr)) {
                        this.jQ();
                    } else if (this.g(tr)) {
                        this.jQ();
                    } else if (this.b(var1x -> {
                        int k = 0;

                        for (int l = 0; l <= 39; l++) {
                            ItemStack itemstack = aEg.thePlayer.inventory.getStackInSlot(l);
                            if (itemstack != null && itemstack.getItem() instanceof ItemBlock) {
                                var1x.add(l);
                                k += itemstack.stackSize;
                            }
                        }

                        return k;
                    }, this.blockLimit.wo().intValue())) {
                        this.jQ();
                    } else if (this.b(var1x -> {
                        int k = 0;

                        for (int l = 0; l <= 39; l++) {
                            ItemStack itemstack = aEg.thePlayer.inventory.getStackInSlot(l);
                            if (itemstack != null && itemstack.getItem() == Items.arrow) {
                                var1x.add(l);
                                k += itemstack.stackSize;
                            }
                        }

                        return k;
                    }, this.arrowLimit.wo().intValue())) {
                        this.jQ();
                    } else if (this.b(var1x -> {
                        int k = 0;

                        for (int l = 0; l <= 39; l++) {
                            ItemStack itemstack = aEg.thePlayer.inventory.getStackInSlot(l);
                            if (itemstack != null) {
                                Item item = itemstack.getItem();
                                if (item == Items.bucket || item == Items.water_bucket || item == Items.lava_bucket || item == Items.milk_bucket) {
                                    var1x.add(l);
                                    k += itemstack.stackSize;
                                }
                            }
                        }

                        return k;
                    }, this.bucketLimit.wo().intValue())) {
                        this.jQ();
                    } else if (this.b(var1x -> {
                        int k = 0;

                        for (int l = 0; l <= 39; l++) {
                            ItemStack itemstack = aEg.thePlayer.inventory.getStackInSlot(l);
                            if (itemstack != null) {
                                Item item = itemstack.getItem();
                                if (item == Items.snowball || item == Items.egg) {
                                    var1x.add(l);
                                    k += itemstack.stackSize;
                                }
                            }
                        }

                        return k;
                    }, this.snowballEggLimit.wo().intValue())) {
                        this.jQ();
                    } else if (this.b(var1x -> {
                        int k = 0;

                        for (int l = 0; l <= 39; l++) {
                            ItemStack itemstack = aEg.thePlayer.inventory.getStackInSlot(l);
                            if (itemstack != null && itemstack.getItem() == Items.ender_pearl) {
                                var1x.add(l);
                                k += itemstack.stackSize;
                            }
                        }

                        return k;
                    }, this.enderPearlLimit.wo().intValue())) {
                        this.jQ();
                    } else {
                        int i = this.jS();
                        if (i != -1 && this.f(i, true)) {
                            this.G(i);
                            this.jQ();
                        } else {
                            int j = this.h(tr);
                            if (j != -1 && this.f(j, true)) {
                                this.G(j);
                                this.jQ();
                            } else {
                                this.jQ();
                            }
                        }
                    }
                }
            }
        }
    };
    @EventLink
    public final Listener<AttackEvent> onAttack = var1 -> this.BV = 0;
    @EventLink
    public final Listener<en> adC = var1 -> {
        if (this.jY() && this.adv > 0) {
            this.adw = Math.max(this.adw, this.adv + this.hk());
        }

        this.adv = 0;
        if (this.jY() && this.adw > 0) {
            aEg.thePlayer.setSprinting(false);
            this.adw--;
        } else if (!this.jY()) {
            this.adw = 0;
        }
    };
    @EventLink
    public final Listener<PacketSendEvent> onPacketSend = var1 -> {
        if (var1.dq() instanceof C08PacketPlayerBlockPlacement) {
            C08PacketPlayerBlockPlacement c08packetplayerblockplacement = (C08PacketPlayerBlockPlacement)var1.dq();
            if (c08packetplayerblockplacement.getStack() == null || c08packetplayerblockplacement.getStack().getItem() != Items.water_bucket) {
                this.adq = 0;
            }
        }
    };

    public Manager() {
    }

    public boolean jJ() {
        return aEg != null
            && aEg.thePlayer != null
            && aEg.theWorld != null
            && this.ado.T(this.nextClick)
            && this.adp >= 10
            && this.BV >= 10
            && this.adq >= 10
            && (this.jU() || aEg.currentScreen instanceof GuiInventory);
    }

    public int jK() {
        return this.blockLimit.wo().intValue();
    }

    public int jL() {
        return this.arrowLimit.wo().intValue();
    }

    public int jM() {
        return this.bucketLimit.wo().intValue();
    }

    public int jN() {
        return this.snowballEggLimit.wo().intValue();
    }

    public int jO() {
        return this.enderPearlLimit.wo().intValue();
    }

    public boolean jP() {
        return this.dropCustomItems.wo();
    }

    private boolean s(double var1) {
        if (aEg.thePlayer != null && aEg.theWorld != null) {
            MovingObjectPosition movingobjectposition = aEg.thePlayer.rayTrace(var1, 1.0F);
            if (movingobjectposition != null && movingobjectposition.typeOfHit == MovingObjectType.BLOCK) {
                BlockPos blockpos = movingobjectposition.getBlockPos();
                Block block = aEg.theWorld.getBlockState(blockpos).getBlock();
                return block instanceof BlockChest || block instanceof BlockEnderChest || block instanceof BlockFurnace || block instanceof BlockWorkbench;
            }
            return false;
        }
        return false;
    }

    private void jQ() {
        if (this.adr) {
            this.adz = 0;
        } else {
            this.adz++;
            if (this.adz >= 2) {
                this.u(true);
            }
        }
    }

    @Override
    public void onDisable() {
        this.u(false);
        this.adv = 0;
        this.adw = 0;
    }

    private tr jR() {
        tr tr = new tr();
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        ArrayList arraylist2 = new ArrayList();
        ArrayList arraylist3 = new ArrayList();
        ArrayList arraylist4 = new ArrayList();
        ArrayList arraylist5 = new ArrayList();
        ArrayList arraylist6 = new ArrayList();
        ArrayList arraylist7 = new ArrayList();
        ArrayList arraylist8 = new ArrayList();
        ArrayList arraylist9 = new ArrayList();

        for (int i = 0; i <= 39; i++) {
            ItemStack itemstack = aEg.thePlayer.inventory.getStackInSlot(i);
            if (itemstack != null) {
                Item item = itemstack.getItem();
                if (!ItemUtil.u(itemstack)) {
                    tr.aef.add(i);
                } else {
                    if (item instanceof ItemBlock) {
                        tr.adQ.add(new ts(i, itemstack));
                    }

                    if (item instanceof ItemPotion) {
                        tr.adR.add(new ts(i, itemstack));
                    }

                    if (item instanceof ItemFood) {
                        tr.adS.add(new ts(i, itemstack));
                    }

                    if (item instanceof ItemArmor) {
                        switch (((ItemArmor)item).armorType) {
                            case 0:
                                arraylist.add(i);
                                break;
                            case 1:
                                arraylist1.add(i);
                                break;
                            case 2:
                                arraylist2.add(i);
                                break;
                            case 3:
                                arraylist3.add(i);
                        }
                    } else if (item instanceof ItemSword) {
                        arraylist4.add(i);
                    } else if (item instanceof bw) {
                        arraylist5.add(i);
                    } else if (item instanceof ItemAxe) {
                        arraylist6.add(i);
                    } else if (item instanceof cn) {
                        arraylist7.add(i);
                    } else if (item instanceof ItemBow) {
                        arraylist8.add(i);
                    } else if (item instanceof be) {
                        arraylist9.add(i);
                    }
                }
            }
        }

        tr.adF = this.a(arraylist, tr.aeb, this::armorReduction);
        tr.adG = this.a(arraylist1, tr.aec, this::armorReduction);
        tr.adH = this.a(arraylist2, tr.aed, this::armorReduction);
        tr.adI = this.a(arraylist3, tr.aee, this::armorReduction);
        this.a(arraylist4, tr);
        tr.adL = this.a(arraylist5, tr.adU, var1 -> {
            Item item1 = var1.getItem();
            int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, var1);
            float f = j > 0 ? j * j + 1 : 0.0F;
            if (item1 instanceof bw) {
                return ((bw)item1).getToolMaterial().getEfficiencyOnProperMaterial() + f;
            } else if (item1 instanceof cn) {
                return ((cn)item1).getToolMaterial().getEfficiencyOnProperMaterial() + f;
            }
            return item1 instanceof ItemAxe ? ((ItemAxe)item1).getToolMaterial().getEfficiencyOnProperMaterial() + f : 0.0F;
        });
        tr.adM = this.a(arraylist6, tr.adV, var1 -> {
            Item item1 = var1.getItem();
            int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, var1);
            float f = j > 0 ? j * j + 1 : 0.0F;
            if (item1 instanceof bw) {
                return ((bw)item1).getToolMaterial().getEfficiencyOnProperMaterial() + f;
            } else if (item1 instanceof cn) {
                return ((cn)item1).getToolMaterial().getEfficiencyOnProperMaterial() + f;
            }
            return item1 instanceof ItemAxe ? ((ItemAxe)item1).getToolMaterial().getEfficiencyOnProperMaterial() + f : 0.0F;
        });
        tr.adN = this.a(arraylist7, tr.adW, var1 -> {
            Item item1 = var1.getItem();
            int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, var1);
            float f = j > 0 ? j * j + 1 : 0.0F;
            if (item1 instanceof bw) {
                return ((bw)item1).getToolMaterial().getEfficiencyOnProperMaterial() + f;
            } else if (item1 instanceof cn) {
                return ((cn)item1).getToolMaterial().getEfficiencyOnProperMaterial() + f;
            }
            return item1 instanceof ItemAxe ? ((ItemAxe)item1).getToolMaterial().getEfficiencyOnProperMaterial() + f : 0.0F;
        });
        tr.adO = this.a(arraylist8, tr.adZ, var1 -> EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, var1));
        tr.adP = this.b(arraylist9, tr.aea);
        return tr;
    }

    private int a(List<Integer> var1, List<Integer> var2, tt var3) {
        if (var1.isEmpty()) {
            return -1;
        }

        int i = (Integer)var1.get(0);
        float f = var3.score(aEg.thePlayer.inventory.getStackInSlot(i));

        for (int j = 1; j < var1.size(); j++) {
            int k = (Integer)var1.get(j);
            float f1 = var3.score(aEg.thePlayer.inventory.getStackInSlot(k));
            if (f1 > f) {
                var2.add(i);
                i = k;
                f = f1;
            } else {
                var2.add(k);
            }
        }

        return i;
    }

    private void a(List<Integer> var1, tr var2) {
        var1.sort((var1x, var2x) -> Float.compare(this.j(aEg.thePlayer.inventory.getStackInSlot(var2x)), this.j(aEg.thePlayer.inventory.getStackInSlot(var1x))));
        if (!var1.isEmpty()) {
            var2.adJ = (Integer)var1.get(0);
            boolean flag = this.swordSlot.wo().intValue() != 0
                && this.secondSwordSlot.wo().intValue() != 0
                && this.secondSwordSlot.wo().intValue() != this.swordSlot.wo().intValue();
            byte b0 = 1;
            if (flag && var1.size() > 1) {
                var2.adK = (Integer)var1.get(1);
                b0 = 2;
            }

            for (int i = b0; i < var1.size(); i++) {
                var2.adT.add((Integer)var1.get(i));
            }
        }
    }

    private int b(List<Integer> var1, List<Integer> var2) {
        if (var1.isEmpty()) {
            return -1;
        }

        int i = (Integer)var1.get(0);

        for (int j = 1; j < var1.size(); j++) {
            var2.add((Integer)var1.get(j));
        }

        return i;
    }

    private boolean a(tr var1) {
        if (aEg.thePlayer.inventory.getItemStack() != null) {
            return true;
        } else if (this.b(0, var1.adF)) {
            return true;
        } else if (this.b(1, var1.adG)) {
            return true;
        } else if (this.b(2, var1.adH)) {
            return true;
        } else if (this.b(3, var1.adI)) {
            return true;
        } else if (this.a(var1.adJ, this.swordSlot)) {
            return true;
        } else if (this.a(var1.adK, this.secondSwordSlot)) {
            return true;
        } else if (!this.a(var1, this.pickaxeSlot) && this.a(var1.adL, this.pickaxeSlot)) {
            return true;
        } else if (!this.a(var1, this.axeSlot) && this.a(var1.adM, this.axeSlot)) {
            return true;
        } else if (!this.a(var1, this.shovelSlot) && this.a(var1.adN, this.shovelSlot)) {
            return true;
        } else if (!this.a(var1, this.bowSlot) && this.a(var1.adO, this.bowSlot)) {
            return true;
        }
        int i = this.add.wo().intValue();
        int j = this.bowSlot.wo().intValue();
        if (!this.a(var1, this.add) && i != 0 && (j == 0 || i != j || var1.adO == -1) && this.a(var1.adP, this.add)) {
            return true;
        } else if (this.a(var1.adQ, this.blockSlot)) {
            return true;
        } else if (this.b(var1)) {
            return true;
        } else if (this.c(var1)) {
            return true;
        } else if (this.a(var1x -> {
            int k = 0;

            for (int l = 0; l <= 39; l++) {
                ItemStack itemstack = aEg.thePlayer.inventory.getStackInSlot(l);
                if (itemstack != null && itemstack.getItem() instanceof ItemBlock) {
                    var1x.add(l);
                    k += itemstack.stackSize;
                }
            }

            return k;
        }, this.blockLimit.wo().intValue())) {
            return true;
        } else if (this.a(var1x -> {
            int k = 0;

            for (int l = 0; l <= 39; l++) {
                ItemStack itemstack = aEg.thePlayer.inventory.getStackInSlot(l);
                if (itemstack != null && itemstack.getItem() == Items.arrow) {
                    var1x.add(l);
                    k += itemstack.stackSize;
                }
            }

            return k;
        }, this.arrowLimit.wo().intValue())) {
            return true;
        } else if (this.a(var1x -> {
            int k = 0;

            for (int l = 0; l <= 39; l++) {
                ItemStack itemstack = aEg.thePlayer.inventory.getStackInSlot(l);
                if (itemstack != null) {
                    Item item = itemstack.getItem();
                    if (item == Items.bucket || item == Items.water_bucket || item == Items.lava_bucket || item == Items.milk_bucket) {
                        var1x.add(l);
                        k += itemstack.stackSize;
                    }
                }
            }

            return k;
        }, this.bucketLimit.wo().intValue())) {
            return true;
        } else if (this.a(var1x -> {
            int k = 0;

            for (int l = 0; l <= 39; l++) {
                ItemStack itemstack = aEg.thePlayer.inventory.getStackInSlot(l);
                if (itemstack != null) {
                    Item item = itemstack.getItem();
                    if (item == Items.snowball || item == Items.egg) {
                        var1x.add(l);
                        k += itemstack.stackSize;
                    }
                }
            }

            return k;
        }, this.snowballEggLimit.wo().intValue())) {
            return true;
        } else if (this.a(var1x -> {
            int k = 0;

            for (int l = 0; l <= 39; l++) {
                ItemStack itemstack = aEg.thePlayer.inventory.getStackInSlot(l);
                if (itemstack != null && itemstack.getItem() == Items.ender_pearl) {
                    var1x.add(l);
                    k += itemstack.stackSize;
                }
            }

            return k;
        }, this.enderPearlLimit.wo().intValue())) {
            return true;
        } else {
            return this.jS() != -1
                ? true
                : !var1.adT.isEmpty()
                    || !var1.adU.isEmpty()
                    || !var1.adV.isEmpty()
                    || !var1.adW.isEmpty()
                    || !var1.adZ.isEmpty()
                    || !var1.aea.isEmpty()
                    || !var1.aeb.isEmpty()
                    || !var1.aec.isEmpty()
                    || !var1.aed.isEmpty()
                    || !var1.aee.isEmpty();
        }
    }

    private boolean b(int var1, int var2) {
        if (var2 == -1) {
            return false;
        }
        int i = this.E(var1);
        ItemStack itemstack = aEg.thePlayer.inventory.getStackInSlot(i);
        ItemStack itemstack1 = aEg.thePlayer.inventory.getStackInSlot(var2);
        if (itemstack1 != null && itemstack1.getItem() instanceof ItemArmor) {
            int j = this.armorReduction(itemstack1);
            int k = itemstack != null && itemstack.getItem() instanceof ItemArmor ? this.armorReduction(itemstack) : Integer.MIN_VALUE;
            return var2 == i ? false : j > k;
        }
        return false;
    }

    private boolean a(Integer var1, NumberValue numberValue) {
        if (numberValue.wo().intValue() != 0 && var1 != null && var1 != -1) {
            int i = numberValue.wo().intValue() - 1;
            return !this.f(var1, i);
        }
        return false;
    }

    private boolean a(tr var1, NumberValue numberValue) {
        int i = numberValue.wo().intValue();
        return i != 0 && (var1.adJ != -1 && this.swordSlot.wo().intValue() == i || var1.adK != -1 && this.secondSwordSlot.wo().intValue() == i);
    }

    private boolean a(List<ts> var1, BoundsNumberValue boundsNumberValue) {
        int i = boundsNumberValue.wo().intValue();
        int j = boundsNumberValue.wA().intValue();
        if (i == 0 || i > j) {
            return false;
        }

        if (var1.isEmpty()) {
            return false;
        }

        var1.sort(Comparator.comparingInt(var0 -> -var0.aeh.stackSize));
        int k = j - i + 1;

        for (int l = 0; l < k && l < var1.size(); l++) {
            int i1 = i - 1 + l;
            int j1 = ((ts)var1.get(l)).aeg;
            if (!this.f(j1, i1)) {
                return true;
            }
        }

        return false;
    }

    private boolean b(tr var1) {
        int i = this.potionSlot.wo().intValue();
        int j = this.potionSlot.wA().intValue();
        if (i != 0 && i <= j) {
            ArrayList arraylist = new ArrayList();

            for (ts ts : var1.adR) {
                List list = ((ItemPotion)ts.aeh.getItem()).getEffects(ts.aeh);
                if (list != null && !list.isEmpty()) {
                    arraylist.add(ts);
                }
            }

            if (arraylist.isEmpty()) {
                return false;
            }

            arraylist.sort((var1x, var2) -> {
                boolean flag = ItemPotion.isSplash(((ts)var1x).aeh.getMetadata());
                boolean flag1 = ItemPotion.isSplash(((ts)var2).aeh.getMetadata());
                if (this.prioritizeSplashPotions.wo()) {
                    if (flag && !flag1) {
                        return -1;
                    }

                    if (!flag && flag1) {
                        return 1;
                    }
                }

                int k1 = PlayerUtil.potionRanking(((ItemPotion)((ts)var1x).aeh.getItem()).getEffects(((ts)var1x).aeh).get(0).getPotionID());
                return Integer.compare(PlayerUtil.potionRanking(((ItemPotion)((ts)var2).aeh.getItem()).getEffects(((ts)var2).aeh).get(0).getPotionID()), k1);
            });
            int k = j - i + 1;

            for (int l = 0; l < k && l < arraylist.size(); l++) {
                int i1 = i - 1 + l;
                int j1 = ((ts)arraylist.get(l)).aeg;
                if (!this.f(j1, i1)) {
                    return true;
                }
            }

            return false;
        }
        return false;
    }

    private boolean c(tr var1) {
        int i = this.foodSlot.wo().intValue();
        int j = this.foodSlot.wA().intValue();
        if (i == 0 || i > j) {
            return false;
        }

        if (var1.adS.isEmpty()) {
            return false;
        }

        var1.adS
            .sort(
                (var0, var1x) -> Float.compare(
                    ((ItemFood)var1x.aeh.getItem()).getSaturationModifier(var1x.aeh), ((ItemFood)var0.aeh.getItem()).getSaturationModifier(var0.aeh)
                )
            );
        int k = j - i + 1;

        for (int l = 0; l < k && l < var1.adS.size(); l++) {
            int i1 = i - 1 + l;
            int j1 = var1.adS.get(l).aeg;
            if (!this.f(j1, i1)) {
                return true;
            }
        }

        return false;
    }

    private boolean a(IntGatherer intGatherer, int var2) {
        ArrayList arraylist = new ArrayList();
        return intGatherer.gather(arraylist) > var2;
    }

    private boolean c(int var1, int var2) {
        if (var2 == -1) {
            return false;
        }

        int i = this.E(var1);
        ItemStack itemstack = aEg.thePlayer.inventory.getStackInSlot(i);
        ItemStack itemstack1 = aEg.thePlayer.inventory.getStackInSlot(var2);
        if (itemstack1 != null && itemstack1.getItem() instanceof ItemArmor) {
            int j = this.armorReduction(itemstack1);
            int k = itemstack != null && itemstack.getItem() instanceof ItemArmor ? this.armorReduction(itemstack) : Integer.MIN_VALUE;
            if (var2 != i && j > k) {
                int l = aEg.thePlayer.inventoryContainer.windowId;
                int i1 = this.I(var2);
                int j1 = this.F(var1);
                if (aEg.thePlayer.inventory.getItemStack() != null) {
                    return false;
                }

                if (ViaLoadingBase.getInstance().getTargetVersion().olderThanOrEqualTo(ProtocolVersion.v1_12)) {
                    this.a(l, i1, 0, 0);
                    this.a(l, j1, 0, 0);
                    this.a(l, i1, 0, 0);
                } else {
                    this.a(l, i1, 1, 1);
                    this.a(l, j1, 1, 1);
                    this.a(l, i1, 1, 1);
                }

                this.jZ();
                return true;
            }
            return false;
        }
        return false;
    }

    private int E(int var1) {
        switch (var1) {
            case 0:
                return 39;
            case 1:
                return 38;
            case 2:
                return 37;
            case 3:
                return 36;
            default:
                return 39;
        }
    }

    private int F(int var1) {
        switch (var1) {
            case 0:
                return 5;
            case 1:
                return 6;
            case 2:
                return 7;
            case 3:
                return 8;
            default:
                return 5;
        }
    }

    private boolean d(tr var1) {
        if (this.b(var1.adJ, this.swordSlot)) {
            return true;
        }

        if (this.b(var1.adK, this.secondSwordSlot)) {
            return true;
        }

        if (!this.a(var1, this.pickaxeSlot) && this.b(var1.adL, this.pickaxeSlot)) {
            return true;
        }

        if (!this.a(var1, this.axeSlot) && this.b(var1.adM, this.axeSlot)) {
            return true;
        }

        if (!this.a(var1, this.shovelSlot) && this.b(var1.adN, this.shovelSlot)) {
            return true;
        }

        if (!this.a(var1, this.bowSlot) && this.b(var1.adO, this.bowSlot)) {
            return true;
        }

        int i = this.add.wo().intValue();
        int j = this.bowSlot.wo().intValue();
        return !this.a(var1, this.add) && i != 0 && (j == 0 || i != j || var1.adO == -1) && this.b(var1.adP, this.add);
    }

    private boolean e(tr var1) {
        int i = this.blockSlot.wo().intValue();
        int j = this.blockSlot.wA().intValue();
        if (i != 0 && i <= j) {
            var1.adQ.sort(Comparator.comparingInt(var0 -> -var0.aeh.stackSize));
            int k = j - i + 1;

            for (int l = 0; l < k && l < var1.adQ.size(); l++) {
                int i1 = i - 1 + l;
                int j1 = var1.adQ.get(l).aeg;
                if (!this.f(j1, i1) && this.e(j1, false)) {
                    this.e(j1, i1);
                    return true;
                }
            }

            return false;
        }
        return false;
    }

    private boolean f(tr var1) {
        int i = this.potionSlot.wo().intValue();
        int j = this.potionSlot.wA().intValue();
        if (i != 0 && i <= j) {
            ArrayList arraylist = new ArrayList();

            for (ts ts : var1.adR) {
                List list = ((ItemPotion)ts.aeh.getItem()).getEffects(ts.aeh);
                if (list != null && !list.isEmpty()) {
                    arraylist.add(ts);
                }
            }

            arraylist.sort((var1x, var2) -> {
                boolean flag = ItemPotion.isSplash(((ts)var1x).aeh.getMetadata());
                boolean flag1 = ItemPotion.isSplash(((ts)var2).aeh.getMetadata());
                if (this.prioritizeSplashPotions.wo()) {
                    if (flag && !flag1) {
                        return -1;
                    }

                    if (!flag && flag1) {
                        return 1;
                    }
                }

                int k1 = PlayerUtil.potionRanking(((ItemPotion)((ts)var1x).aeh.getItem()).getEffects(((ts)var1x).aeh).get(0).getPotionID());
                return Integer.compare(PlayerUtil.potionRanking(((ItemPotion)((ts)var2).aeh.getItem()).getEffects(((ts)var2).aeh).get(0).getPotionID()), k1);
            });
            int k = j - i + 1;

            for (int l = 0; l < k && l < arraylist.size(); l++) {
                int i1 = i - 1 + l;
                int j1 = ((ts)arraylist.get(l)).aeg;
                if (!this.f(j1, i1) && this.e(j1, false)) {
                    this.e(j1, i1);
                    return true;
                }
            }

            return false;
        }
        return false;
    }

    private boolean g(tr var1) {
        int i = this.foodSlot.wo().intValue();
        int j = this.foodSlot.wA().intValue();
        if (i != 0 && i <= j) {
            var1.adS
                .sort(
                    (var0, var1x) -> Float.compare(
                        ((ItemFood)var1x.aeh.getItem()).getSaturationModifier(var1x.aeh), ((ItemFood)var0.aeh.getItem()).getSaturationModifier(var0.aeh)
                    )
                );
            int k = j - i + 1;

            for (int l = 0; l < k && l < var1.adS.size(); l++) {
                int i1 = i - 1 + l;
                int j1 = var1.adS.get(l).aeg;
                if (!this.f(j1, i1) && this.e(j1, false)) {
                    this.e(j1, i1);
                    return true;
                }
            }

            return false;
        }
        return false;
    }

    private boolean b(IntGatherer intGatherer, int var2) {
        ArrayList arraylist = new ArrayList();
        int i = intGatherer.gather(arraylist);
        if (i <= var2) {
            return false;
        }

        int j = i - var2;

        for (int k = arraylist.size() - 1; k >= 0; k--) {
            int l = (Integer)arraylist.get(k);
            ItemStack itemstack = aEg.thePlayer.inventory.getStackInSlot(l);
            if (itemstack != null) {
                int i1 = itemstack.stackSize;
                if (this.f(l, true)) {
                    if (j >= i1) {
                        this.G(l);
                        return true;
                    }

                    int j1 = i1 - j;
                    this.d(l, j1);
                    return true;
                }
            }
        }

        return false;
    }

    private int jS() {
        for (int i = 0; i <= 39; i++) {
            ItemStack itemstack = aEg.thePlayer.inventory.getStackInSlot(i);
            if (itemstack != null && !ItemUtil.u(itemstack)) {
                return i;
            }
        }

        return -1;
    }

    private int h(tr var1) {
        for (int i : var1.adT) {
            if (this.f(i, true)) {
                return i;
            }
        }

        for (int j : var1.adU) {
            if (this.f(j, true)) {
                return j;
            }
        }

        for (int k : var1.adV) {
            if (this.f(k, true)) {
                return k;
            }
        }

        for (int l : var1.adW) {
            if (this.f(l, true)) {
                return l;
            }
        }

        for (int i1 : var1.adZ) {
            if (this.f(i1, true)) {
                return i1;
            }
        }

        for (int j1 : var1.aea) {
            if (this.f(j1, true)) {
                return j1;
            }
        }

        for (int k1 : var1.aeb) {
            if (this.f(k1, true)) {
                return k1;
            }
        }

        for (int l1 : var1.aec) {
            if (this.f(l1, true)) {
                return l1;
            }
        }

        for (int i2 : var1.aed) {
            if (this.f(i2, true)) {
                return i2;
            }
        }

        for (int j2 : var1.aee) {
            if (this.f(j2, true)) {
                return j2;
            }
        }

        return -1;
    }

    private void jT() {
        this.adz = 0;
        if (!this.jV()) {
            if (aEg.currentScreen instanceof GuiInventory) {
                this.adx = true;
                this.ady = 0;
            } else {
                if (this.jU() && !this.ads && aEg.currentScreen == null && !BadPacketsComponent.bad(false, false, false, false, true)) {
                    PacketUtil.l(new C16PacketClientStatus(EnumState.OPEN_INVENTORY_ACHIEVEMENT));
                    this.jX();
                    this.ads = true;
                    this.adx = true;
                    this.ady = 1;
                }
            }
        }
    }

    private void u(boolean var1) {
        if (this.adx) {
            if (this.ads) {
                if (var1 && aEg.currentScreen == null && !BadPacketsComponent.bad(false, false, false, false, true)) {
                    this.ads = false;
                } else {
                    this.adu = true;
                }
            }

            this.adx = false;
            this.ady = 0;
            this.adz = 0;
        }
    }

    private boolean jU() {
        boolean flag = this.e(InventoryMove.class).isEnabled();
        boolean flag1 = aEg.currentScreen == null;
        boolean flag2 = this.e(Scaffold.class).isEnabled();
        return flag && flag1 && !flag2 && !aEg.gameSettings.cgK.isKeyDown() && !aEg.gameSettings.cgI.isKeyDown();
    }

    private boolean jV() {
        return aEg.currentScreen instanceof GuiContainer && !(aEg.currentScreen instanceof GuiInventory);
    }

    private boolean jW() {
        if (aEg.thePlayer.inventory.getItemStack() == null) {
            return false;
        }

        int i = aEg.thePlayer.inventoryContainer.windowId;

        for (int j = 0; j <= 39; j++) {
            if (j != 36 && j != 37 && j != 38 && j != 39 && aEg.thePlayer.inventory.getStackInSlot(j) == null) {
                this.a(i, this.I(j), 0, 0);
                this.jZ();
                return true;
            }
        }

        this.a(i, -999, 0, 0);
        this.jZ();
        return true;
    }

    private void G(int var1) {
        if (this.f(var1, true)) {
            int i = aEg.thePlayer.inventoryContainer.windowId;
            int j = this.I(var1);
            this.a(i, j, 1, 4);
            this.jZ();
        }
    }

    private void d(int var1, int var2) {
        if (this.f(var1, true) && var2 >= 0) {
            int i = aEg.thePlayer.inventoryContainer.windowId;
            int j = this.I(var1);
            this.a(i, j, 0, 0);

            for (int k = 0; k < var2; k++) {
                this.a(i, j, 1, 0);
            }

            this.a(i, -999, 0, 0);
            this.jZ();
        }
    }

    private void H(int var1) {
        if (this.e(var1, false)) {
            int i = aEg.thePlayer.inventoryContainer.windowId;
            int j = this.I(var1);
            this.a(i, j, 0, 1);
            this.jZ();
        }
    }

    private void e(int var1, int var2) {
        if (this.e(var1, false) && var2 >= 0 && var2 <= 8) {
            int i = aEg.thePlayer.inventoryContainer.windowId;
            int j = this.I(var1);
            this.a(i, j, var2, 2);
            this.jZ();
        }
    }

    private boolean b(Integer var1, NumberValue numberValue) {
        if (numberValue.wo().intValue() != 0 && var1 != null && var1 != -1) {
            int i = numberValue.wo().intValue() - 1;
            if (this.f(var1, i)) {
                return false;
            }

            if (!this.e(var1, false)) {
                return false;
            }

            this.e(var1, i);
            return true;
        }
        return false;
    }

    private boolean f(int var1, int var2) {
        return var1 >= 0 && var1 <= 8 && var1 == var2;
    }

    private void a(int var1, int var2, int var3, int var4) {
        aEg.playerController.windowClick(var1, var2, var3, var4, aEg.thePlayer);
        this.jX();
    }

    private void jX() {
        if (this.jY()) {
            this.adv++;
        }
    }

    private boolean jY() {
        InventoryMove inventorymove = this.e(InventoryMove.class);
        return inventorymove != null && inventorymove.isEnabled() && inventorymove.hj();
    }

    private int hk() {
        InventoryMove inventorymove = this.e(InventoryMove.class);
        return inventorymove == null ? 9 : inventorymove.hk();
    }

    private void jZ() {
        this.nextClick = Math.round(MathUtil.l(this.delay.wo().intValue(), this.delay.wA().intValue()));
        this.ado.aX();
        this.adr = true;
        this.adz = 0;
    }

    private boolean e(int var1, boolean var2) {
        if (this.adr && this.nextClick > 0L) {
            return false;
        }

        boolean flag = var2 ? !this.dropCustomItems.wo() : !this.useCustomItems.wo();
        return !SelectorDetectionComponent.a(var1, flag);
    }

    private boolean f(int var1, boolean var2) {
        return this.e(var1, true);
    }

    private float j(ItemStack stack) {
        ItemSword itemsword = (ItemSword)stack.getItem();
        int i = EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, stack);
        int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, stack);
        return (float)(itemsword.getDamageVsEntity() + i * 1.25 + j * 2.5);
    }

    private int armorReduction(ItemStack stack) {
        ItemArmor itemarmor = (ItemArmor)stack.getItem();
        int i = itemarmor.damageReduceAmount;

        byte b0 = switch (tp.adE[itemarmor.getArmorMaterial().ordinal()]) {
            case 1 -> 5;
            case 2 -> 4;
            case 3 -> 3;
            case 4 -> 2;
            case 5 -> 1;
            default -> 0;
        };
        int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.protection.effectId, stack);
        int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.projectileProtection.effectId, stack);
        int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.fireProtection.effectId, stack);
        int i1 = EnchantmentHelper.getEnchantmentLevel(Enchantment.blastProtection.effectId, stack);
        return i * 100 + b0 * 10 + j * 6 + (k + l + i1) * 2;
    }

    private int I(int var1) {
        if (var1 >= 0 && var1 <= 8) {
            return 36 + var1;
        } else if (var1 >= 9 && var1 <= 35) {
            return var1;
        } else if (var1 == 39) {
            return 5;
        } else if (var1 == 38) {
            return 6;
        } else if (var1 == 37) {
            return 7;
        }
        return var1 == 36 ? 8 : var1;
    }

    @Generated
    public boolean ka() {
        return this.adr;
    }

    @Generated
    public boolean kb() {
        return this.ads;
    }
}
