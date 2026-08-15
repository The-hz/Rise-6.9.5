package com.alan.clients.module.impl.other;

import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.other.WorldChangeEvent;
import com.alan.clients.value.impl.BooleanValue;
import hackclient.rise.afi;
import java.util.Collection;
import java.util.HashSet;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.util.EnumChatFormatting;

@ModuleInfo(aliases = "module.other.bwutils.name", description = "module.other.bwutils.description", category = Category.PLAYER)
public final class BedwarsUtils extends Module {
    private final Collection<EntityPlayer> TE = new HashSet<>();
    private final Collection<EntityPlayer> TF = new HashSet<>();
    private final Collection<EntityPlayer> TG = new HashSet<>();
    private final Collection<EntityPlayer> TH = new HashSet<>();
    private final Collection<EntityPlayer> TI = new HashSet<>();
    private final Collection<EntityPlayer> TJ = new HashSet<>();
    private final Collection<EntityPlayer> TK = new HashSet<>();
    private final BooleanValue swordReveal = new BooleanValue("Sword Reveal", this, true);
    private final BooleanValue includeStone = new BooleanValue("Include Stone", this, false, () -> !this.swordReveal.wo());
    private final BooleanValue armorReveal = new BooleanValue("Armor Reveal", this, true);
    private final BooleanValue invisibleCheck = new BooleanValue("Invisible Check", this, true);
    private final BooleanValue invisibilityStatus = new BooleanValue("Invisibility Status", this, false);
    private boolean TQ = false;
    @EventLink
    private final Listener<PreUpdateEvent> onPreUpdate = var1 -> {
        for (EntityPlayer entityplayer : aEg.theWorld.playerEntities) {
            if (aEg.thePlayer == null && aEg.theWorld == null) {
                this.TF.clear();
                this.TE.clear();
                this.TG.clear();
                this.TH.clear();
                this.TJ.clear();
                this.TI.clear();
                this.TK.clear();
            } else {
                if (entityplayer.getHeldItem() != null) {
                    Item item = entityplayer.getHeldItem().getItem();
                    if (this.swordReveal.wo() && item instanceof ItemSword) {
                        String s = ((ItemSword)item).getToolMaterialName().toLowerCase();
                        if (s.contains("iron") && !this.TE.contains(entityplayer)) {
                            this.TE.add(entityplayer);
                            afi.b(
                                "Player "
                                    + EnumChatFormatting.RED
                                    + entityplayer.getName()
                                    + EnumChatFormatting.WHITE
                                    + " has an "
                                    + EnumChatFormatting.AQUA
                                    + "Iron Sword"
                            );
                        }

                        if (s.contains("emerald") && !this.TF.contains(entityplayer)) {
                            this.TF.add(entityplayer);
                            afi.b(
                                "Player "
                                    + EnumChatFormatting.RED
                                    + entityplayer.getName()
                                    + EnumChatFormatting.WHITE
                                    + " has a "
                                    + EnumChatFormatting.AQUA
                                    + "Diamond Sword"
                            );
                        }

                        if (s.contains("stone") && !this.TG.contains(entityplayer)) {
                            this.TG.add(entityplayer);
                            if (this.includeStone.wo()) {
                                afi.b(
                                    "Player "
                                        + EnumChatFormatting.RED
                                        + entityplayer.getName()
                                        + EnumChatFormatting.WHITE
                                        + " has a "
                                        + EnumChatFormatting.AQUA
                                        + "Stone Sword"
                                );
                            }
                        }

                        if (s.contains("wood")) {
                            this.TG.remove(entityplayer);
                            this.TE.remove(entityplayer);
                            this.TF.remove(entityplayer);
                        }
                    }
                }

                if (this.armorReveal.wo()) {
                    ItemStack itemstack = entityplayer.getCurrentArmor(1);
                    if (itemstack != null && itemstack.getItem() instanceof ItemArmor) {
                        if (((ItemArmor)itemstack.getItem()).getArmorMaterial().equals(ArmorMaterial.CHAIN) && !this.TI.contains(entityplayer)) {
                            this.TI.add(entityplayer);
                            afi.b(
                                "Player "
                                    + EnumChatFormatting.RED
                                    + entityplayer.getName()
                                    + EnumChatFormatting.WHITE
                                    + " has "
                                    + EnumChatFormatting.LIGHT_PURPLE
                                    + "Chain Armor"
                            );
                        }

                        if (((ItemArmor)itemstack.getItem()).getArmorMaterial().equals(ArmorMaterial.IRON) && !this.TJ.contains(entityplayer)) {
                            this.TJ.add(entityplayer);
                            afi.b(
                                "Player "
                                    + EnumChatFormatting.RED
                                    + entityplayer.getName()
                                    + EnumChatFormatting.WHITE
                                    + " has "
                                    + EnumChatFormatting.LIGHT_PURPLE
                                    + "Iron Armor"
                            );
                        }

                        if (((ItemArmor)itemstack.getItem()).getArmorMaterial().equals(ArmorMaterial.DIAMOND) && !this.TH.contains(entityplayer)) {
                            this.TH.add(entityplayer);
                            afi.b(
                                "Player "
                                    + EnumChatFormatting.RED
                                    + entityplayer.getName()
                                    + EnumChatFormatting.WHITE
                                    + " has "
                                    + EnumChatFormatting.LIGHT_PURPLE
                                    + "Diamond Armor"
                            );
                        }

                        if (((ItemArmor)itemstack.getItem()).getArmorMaterial().equals(ArmorMaterial.LEATHER)) {
                            this.TH.remove(entityplayer);
                            this.TJ.remove(entityplayer);
                            this.TI.remove(entityplayer);
                        }
                    }
                }

                if (this.invisibleCheck.wo()) {
                    if (entityplayer.getActivePotionEffect(Potion.invisibility) != null) {
                        if (!this.TK.contains(entityplayer)) {
                            this.TK.add(entityplayer);
                            afi.b(
                                "Player "
                                    + EnumChatFormatting.RED
                                    + entityplayer.getName()
                                    + EnumChatFormatting.WHITE
                                    + " is now "
                                    + EnumChatFormatting.GOLD
                                    + "Invisible"
                            );
                        }
                    } else if (this.TK.contains(entityplayer)) {
                        this.TK.remove(entityplayer);
                        afi.b(
                            "Player "
                                + EnumChatFormatting.RED
                                + entityplayer.getName()
                                + EnumChatFormatting.WHITE
                                + " is now "
                                + EnumChatFormatting.GOLD
                                + "Visible"
                        );
                    }
                }

                if (this.invisibilityStatus.wo()) {
                    if (aEg.thePlayer.getActivePotionEffect(Potion.invisibility) != null) {
                        this.TQ = true;
                        if (aEg.thePlayer.ticksExisted % 200 == 0) {
                            afi.b(
                                "Your Invisibility"
                                    + EnumChatFormatting.RED
                                    + " expires "
                                    + EnumChatFormatting.RESET
                                    + "in "
                                    + EnumChatFormatting.RED
                                    + aEg.thePlayer.getActivePotionEffect(Potion.invisibility).getDuration() / 20
                                    + EnumChatFormatting.RESET
                                    + " second(s)"
                            );
                        }
                    }
                } else if (this.TQ) {
                    afi.b("Invisibility" + EnumChatFormatting.RED + " Expired");
                    this.TQ = false;
                }
            }
        }
    };
    @EventLink
    private final Listener<WorldChangeEvent> onWorldChange = var1 -> {
        this.TF.clear();
        this.TE.clear();
        this.TG.clear();
        this.TI.clear();
        this.TJ.clear();
        this.TH.clear();
        this.TK.clear();
    };

    public BedwarsUtils() {
    }
}
