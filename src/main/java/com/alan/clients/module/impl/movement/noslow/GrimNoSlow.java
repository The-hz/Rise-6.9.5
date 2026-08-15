package com.alan.clients.module.impl.movement.noslow;

import com.alan.clients.component.impl.player.SlotComponent;
import com.alan.clients.module.impl.movement.NoSlow;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.SlowDownEvent;
import com.alan.clients.value.Mode;
import com.alan.clients.util.packet.PacketUtil;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemSword;
import net.minecraft.network.play.client.l;

public class GrimNoSlow extends Mode<NoSlow> {
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var1x -> {
        this.hA();
        this.hB();
        this.hC();
        this.hD();
    };
    @EventLink
    public final Listener<SlowDownEvent> onSlowDown = var1x -> {
        if (this.getParent().food.wo() && aEg.thePlayer.isUsingItem() && aEg.thePlayer.getHeldItem().getItem() instanceof ItemFood) {
            var1x.setCancelled();
        }

        if (this.getParent().potion.wo() && aEg.thePlayer.isUsingItem() && aEg.thePlayer.getHeldItem().getItem() instanceof ItemPotion) {
            var1x.setCancelled();
        }

        if (this.getParent().sword.wo() && aEg.thePlayer.isUsingItem() && aEg.thePlayer.getHeldItem().getItem() instanceof ItemSword) {
            var1x.setCancelled();
        }

        if (this.getParent().bow.wo() && aEg.thePlayer.isUsingItem() && aEg.thePlayer.getHeldItem().getItem() instanceof ItemBow) {
            var1x.setCancelled();
        }
    };

    public GrimNoSlow(String var1, NoSlow noSlow) {
        super(var1, noSlow);
    }

    private void hA() {
        if (this.getParent().food.wo() && aEg.thePlayer.isUsingItem() && aEg.thePlayer.getHeldItem().getItem() instanceof ItemFood) {
            this.hE();
        }
    }

    private void hB() {
        if (this.getParent().potion.wo() && aEg.thePlayer.isUsingItem() && aEg.thePlayer.getHeldItem().getItem() instanceof ItemPotion) {
            this.hE();
        }
    }

    private void hC() {
        if (this.getParent().sword.wo() && aEg.thePlayer.isUsingItem() && aEg.thePlayer.getHeldItem().getItem() instanceof ItemSword) {
            this.hE();
        }
    }

    private void hD() {
        if (this.getParent().bow.wo() && aEg.thePlayer.isUsingItem() && aEg.thePlayer.getHeldItem().getItem() instanceof ItemBow) {
            this.hE();
        }
    }

    private void hE() {
        SlotComponent slotcomponent = this.d(SlotComponent.class);
        PacketUtil.send(new l(SlotComponent.bQ() % 8 + 1));
        slotcomponent = this.d(SlotComponent.class);
        PacketUtil.send(new l(SlotComponent.bQ()));
    }
}
