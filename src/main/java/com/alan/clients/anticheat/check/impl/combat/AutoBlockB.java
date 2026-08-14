package com.alan.clients.anticheat.check.impl.combat;

import com.alan.clients.anticheat.check.Check;
import com.alan.clients.anticheat.check.api.CheckInfo;
import com.alan.clients.anticheat.data.PlayerData;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.ad;

@CheckInfo(R = "AutoBlock", S = "B", description = "Impossible 'Sprinting' and 'Use-Item' status combination.")
public final class AutoBlockB extends Check {
    public AutoBlockB(PlayerData var1) {
        super(var1);
    }

    @Override
    public void handle(Packet<?> var1) {
        if (var1 instanceof ad ad
            && ad.getEntityId() == this.data.Y().getEntityId()
            && ad.func_149376_c() != null
            && this.data.W() > 1
            && this.data.isUsingItem()
            && this.data.isSprinting()) {
            ItemStack itemstack = this.data.Y().getHeldItem();
            if (itemstack != null && itemstack.getItem() instanceof ItemSword && this.a(1.0) >= 4.0) {
                this.J();
                this.M();
            }
        }
    }
}
