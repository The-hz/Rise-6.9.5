package com.alan.clients.module.impl.combat.velocity;

import com.alan.clients.module.impl.combat.Velocity;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.other.BlockAABBEvent;
import com.alan.clients.value.Mode;
import net.minecraft.block.BlockAir;
import net.minecraft.util.AxisAlignedBB;

public final class KarhuVelocity extends Mode<Velocity> {
    @EventLink
    public final Listener<BlockAABBEvent> onBlockAABB = var1x -> {
        if (!this.wj().qQ.wo() || aEg.thePlayer.isSwingInProgress) {
            if (var1x.df() instanceof BlockAir && aEg.thePlayer.hurtTime > 0 && aEg.thePlayer.ae <= 9) {
                double d0 = var1x.dg().getX();
                double d1 = var1x.dg().getY();
                double d2 = var1x.dg().getZ();
                if (d1 == Math.floor(aEg.thePlayer.posY) + 1.0) {
                    var1x.a(AxisAlignedBB.fromBounds(0.0, 0.0, 0.0, 1.0, 0.0, 1.0).offset(d0, d1, d2));
                }
            }
        }
    };

    public KarhuVelocity(String var1, Velocity var2) {
        super(var1, var2);
    }
}
