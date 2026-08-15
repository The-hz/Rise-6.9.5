package com.alan.clients.module.impl.movement.flight;

import com.alan.clients.module.impl.movement.Flight;
import com.alan.clients.module.impl.player.Scaffold;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.other.TeleportEvent;
import com.alan.clients.value.Mode;
import hackclient.rise.afi;
import com.alan.clients.util.packet.PacketUtil;
import com.alan.clients.component.impl.player.BadPacketsComponent;
import java.util.Random;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public class BloxdFlight extends Mode<Flight> {
    @EventLink
    private final Listener<TeleportEvent> onTeleport = var0 -> {};
    @EventLink
    private final Listener<PreMotionEvent> onPreMotion = var1x -> {
        if (!BadPacketsComponent.bad(true, true, true, true, true) && !this.e(Scaffold.class).isEnabled()) {
            Random random = new Random();
            float f = random.nextFloat();
            float f1 = random.nextFloat();
            PacketUtil.l(
                new C08PacketPlayerBlockPlacement(
                    new BlockPos(aEg.thePlayer.posX, aEg.thePlayer.posY, aEg.thePlayer.posZ),
                    EnumFacing.UP.getIndex(),
                    new ItemStack(Items.water_bucket),
                    f,
                    1.0F,
                    f1
                )
            );
        }
    };

    public BloxdFlight(String var1, Flight var2) {
        super(var1, var2);
    }

    @Override
    public void onEnable() {
        afi.b("Collide with a block to fly and remember to collide into a wall in Bedwars to avoid fall damage when landing, press shift to fall faster");
    }
}
