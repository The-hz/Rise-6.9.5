package com.alan.clients.module.impl.movement.noslow;

import com.alan.clients.module.impl.movement.NoSlow;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.SlowDownEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.value.Mode;
import hackclient.rise.bc;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.play.server.S29PacketSoundEffect;

public class LegitNoSlow extends Mode<NoSlow> {
    private static final int Ng = 32;
    private static final int Nh = 12;
    private static final int Ni = 0;
    private int Nj;
    private boolean Nk;
    private boolean Nl;
    private boolean Nm;
    private int Nn;
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var1x -> {
        if (aEg.thePlayer != null && aEg.thePlayer.getHeldItem() != null) {
            if (bc.cR) {
                this.Nj++;
            }

            if (this.hF()) {
                if (!bc.cR) {
                    bc.cR = true;
                    this.Nj = aEg.thePlayer.getItemInUseDuration();
                }

                aEg.thePlayer.stopUsingItem();
                aEg.gameSettings.cgI.setPressed(false);
            }

            if (bc.cR && (this.Nj >= 32 || this.Nk)) {
                this.gx();
            }
        }
    };
    @EventLink
    public final Listener<SlowDownEvent> onSlowDown = var1x -> {
        if (!this.hG()) {
            this.hH();
        } else {
            boolean flag = aEg.thePlayer.getItemInUseDuration() % 3 != 0;
            if (!flag) {
                this.hH();
            } else if (!this.Nl) {
                this.Nm = true;
                this.Nn = 0;
                this.Nl = true;
            } else if (this.Nm) {
                this.Nn--;
                if (this.Nn <= 0) {
                    this.Nm = false;
                    aEg.thePlayer.setSprinting(true);
                }
            } else {
                aEg.thePlayer.setSprinting(true);
            }
        }
    };
    @EventLink
    public final Listener<PacketReceiveEvent> onPacketReceive = var1x -> {
        if (var1x.getPacket() instanceof S29PacketSoundEffect) {
            S29PacketSoundEffect s29packetsoundeffect = (S29PacketSoundEffect)var1x.getPacket();
            if (s29packetsoundeffect.getSoundName() != null && s29packetsoundeffect.getSoundName().contains("random.burp")) {
                this.Nk = true;
            }
        }
    };

    public LegitNoSlow(String var1, NoSlow var2) {
        super(var1, var2);
    }

    @Override
    public void onDisable() {
        this.gx();
        this.hH();
        aEg.gameSettings.cgI.setPressed(GameSettings.isKeyDown(aEg.gameSettings.cgI));
    }

    private boolean hF() {
        if (!aEg.thePlayer.isUsingItem()) {
            return false;
        }

        ItemStack itemstack = aEg.thePlayer.getHeldItem();
        if (itemstack == null) {
            return false;
        }

        Item item = itemstack.getItem();
        return aEg.thePlayer.getItemInUseDuration() > 12 && !(item instanceof ItemBow) && this.b(itemstack, false);
    }

    private boolean hG() {
        if (!aEg.thePlayer.isUsingItem()) {
            return false;
        }

        ItemStack itemstack = aEg.thePlayer.getHeldItem();
        return itemstack != null && this.b(itemstack, true);
    }

    private boolean b(ItemStack var1, boolean var2) {
        Item item = var1.getItem();
        if (item instanceof ItemFood) {
            return this.getParent().food.wo();
        } else if (item instanceof ItemPotion) {
            return this.getParent().potion.wo() && !ItemPotion.isSplash(var1.getMetadata());
        }
        return item instanceof ItemSword ? this.getParent().sword.wo() : var2 && item instanceof ItemBow && this.getParent().bow.wo();
    }

    private void gx() {
        if (bc.cR) {
            bc.dispatch();
            bc.cR = false;
        }

        this.Nk = false;
        this.Nj = 0;
    }

    private void hH() {
        this.Nl = false;
        this.Nm = false;
        this.Nn = 0;
    }
}
