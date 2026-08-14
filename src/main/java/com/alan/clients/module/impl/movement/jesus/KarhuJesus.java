package com.alan.clients.module.impl.movement.jesus;

import com.alan.clients.module.impl.movement.Jesus;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.other.BlockAABBEvent;
import com.alan.clients.value.Mode;
import hackclient.rise.aih;
import net.minecraft.block.BlockLiquid;
import net.minecraft.util.AxisAlignedBB;

public class KarhuJesus extends Mode<Jesus> {
    @EventLink
    public final Listener<BlockAABBEvent> Ko = var0 -> {
        if (var0.df() instanceof BlockLiquid && !aEg.gameSettings.keyBindSneak.isKeyDown()) {
            int i = var0.dg().getX();
            int j = var0.dg().getY();
            int k = var0.dg().getZ();
            var0.a(AxisAlignedBB.fromBounds(i, j, k, i + 1, j + 1, k + 1));
        }
    };
    @EventLink
    public final Listener<PreMotionEvent> Kp = var0 -> {
        if (aih.vl()) {
            var0.setPosY(var0.getPosY() - (aEg.thePlayer.ticksExisted % 2 == 0 ? 0.015625 : 0.0));
            var0.setOnGround(false);
        }
    };

    public KarhuJesus(String var1, Jesus var2) {
        super(var1, var2);
    }
}
