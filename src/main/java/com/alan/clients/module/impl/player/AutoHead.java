package com.alan.clients.module.impl.player;

import com.alan.clients.component.impl.player.SlotComponent;
import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.value.impl.BoundsNumberValue;
import com.alan.clients.value.impl.NumberValue;
import hackclient.rise.ahg;
import hackclient.rise.ahj;
import hackclient.rise.bb;
import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import rip.vantage.commons.util.time.a;

@ModuleInfo(aliases = "module.player.autohead.name", description = "module.player.autohead.description", category = Category.PLAYER)
public class AutoHead extends Module {
    private final NumberValue health = new NumberValue("Health", this, 15, 1, 20, 1);
    private final BoundsNumberValue delay = new BoundsNumberValue("Delay", this, 500, 1000, 50, 5000, 50);
    private final a abf = new a();
    private long nextUse;
    @EventLink
    public final Listener<PreMotionEvent> onPreMotionEvent = var1 -> {
        if (this.abf.T(this.nextUse) && !(aEg.thePlayer.getAbsorptionAmount() > 0.0F) && !this.e(Scaffold.class).isEnabled()) {
            for (int i = 0; i < 9; i++) {
                ItemStack itemstack = aEg.thePlayer.inventory.getStackInSlot(i);
                if (itemstack != null && itemstack.getItem() instanceof ItemSkull && !(aEg.thePlayer.getHealth() > this.health.wo().floatValue())) {
                    SlotComponent slotcomponent = this.d(SlotComponent.class);
                    SlotComponent.setSlot(i);
                    if (!bb.aW()) {
                        aEg.playerController.syncCurrentPlayItem();
                        SlotComponent slotcomponent1 = this.d(SlotComponent.class);
                        ahj.l(new C08PacketPlayerBlockPlacement(SlotComponent.getItemStack()));
                        this.nextUse = Math.round(ahg.l(this.delay.wo().longValue(), this.delay.wA().longValue()));
                        this.abf.aX();
                    }
                }
            }
        }
    };

    public AutoHead() {
    }
}
