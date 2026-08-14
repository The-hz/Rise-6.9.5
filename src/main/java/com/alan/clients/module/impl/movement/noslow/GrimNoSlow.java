package com.alan.clients.module.impl.movement.noslow;

import com.alan.clients.component.impl.player.SlotComponent;
import com.alan.clients.module.impl.movement.NoSlow;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.SlowDownEvent;
import com.alan.clients.value.Mode;
import hackclient.rise.ahj;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemSword;
import net.minecraft.network.play.client.l;

public class GrimNoSlow extends Mode<NoSlow> {
    @EventLink
    public final Listener<PreMotionEvent> MX = var1x -> {
        this.hA();
        this.hB();
        this.hC();
        this.hD();
    };
    @EventLink
    public final Listener<SlowDownEvent> MY = var1x -> {
        if (this.wj().DO.wo() && aEg.thePlayer.isUsingItem() && aEg.thePlayer.getHeldItem().getItem() instanceof ItemFood) {
            var1x.setCancelled();
        }

        if (this.wj().DP.wo() && aEg.thePlayer.isUsingItem() && aEg.thePlayer.getHeldItem().getItem() instanceof ItemPotion) {
            var1x.setCancelled();
        }

        if (this.wj().DQ.wo() && aEg.thePlayer.isUsingItem() && aEg.thePlayer.getHeldItem().getItem() instanceof ItemSword) {
            var1x.setCancelled();
        }

        if (this.wj().DR.wo() && aEg.thePlayer.isUsingItem() && aEg.thePlayer.getHeldItem().getItem() instanceof ItemBow) {
            var1x.setCancelled();
        }
    };

    public GrimNoSlow(String var1, NoSlow var2) {
        super(var1, var2);
    }

    private void hA() {
        if (this.wj().DO.wo() && aEg.thePlayer.isUsingItem() && aEg.thePlayer.getHeldItem().getItem() instanceof ItemFood) {
            this.hE();
        }
    }

    private void hB() {
        if (this.wj().DP.wo() && aEg.thePlayer.isUsingItem() && aEg.thePlayer.getHeldItem().getItem() instanceof ItemPotion) {
            this.hE();
        }
    }

    private void hC() {
        if (this.wj().DQ.wo() && aEg.thePlayer.isUsingItem() && aEg.thePlayer.getHeldItem().getItem() instanceof ItemSword) {
            this.hE();
        }
    }

    private void hD() {
        if (this.wj().DR.wo() && aEg.thePlayer.isUsingItem() && aEg.thePlayer.getHeldItem().getItem() instanceof ItemBow) {
            this.hE();
        }
    }

    private void hE() {
        SlotComponent slotcomponent = this.d(SlotComponent.class);
        ahj.l(new l(SlotComponent.bQ() % 8 + 1));
        slotcomponent = this.d(SlotComponent.class);
        ahj.l(new l(SlotComponent.bQ()));
    }
}
