package com.alan.clients.anticheat.check.impl.combat;

import com.alan.clients.anticheat.check.Check;
import com.alan.clients.anticheat.check.api.CheckInfo;
import com.alan.clients.anticheat.data.PlayerData;
import hackclient.rise.o;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S14PacketEntity;
import net.minecraft.network.play.server.ad;

@CheckInfo(R = "AutoBlock", S = "A", description = "Unlikely sword blocking/unblocking")
public final class AutoBlockA extends Check {
    public AutoBlockA(PlayerData var1) {
        super(var1);
    }

    @Override
    public void handle(Packet<?> var1) {
        if (var1 instanceof ad ad && ad.getEntityId() == this.data.getPlayer().getEntityId() && ad.func_149376_c() != null) {
            int i = this.a(this.data.getPlayer());
            int j = this.data.W();
            if (i != -1 && j > i) {
                if (this.a(1.0) > 2.0) {
                    this.J();
                }
            } else {
                this.b(0.1F);
            }
        }

        if (o.b(var1) && ((S14PacketEntity)var1).entityId == this.data.getPlayer().getEntityId() && !this.data.V()) {
            this.b(0.985F);
        }
    }

    private int a(EntityOtherPlayerMP var1) {
        ItemStack itemstack = var1.getHeldItem();
        if (itemstack == null) {
            return -1;
        }
        Item item = itemstack.getItem();
        if (item == Items.bow) {
            return 4;
        }
        return !(item instanceof ItemSword)
                && !(item instanceof ItemFood)
                && (!(item instanceof ItemPotion) || ItemPotion.isSplash(itemstack.getMetadata()))
            ? -1
            : 1;
    }
}
