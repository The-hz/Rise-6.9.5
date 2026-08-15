package com.alan.clients.module.impl.movement.flight;

import com.alan.clients.module.impl.movement.Flight;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.KeyboardInputEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.other.BlockAABBEvent;
import com.alan.clients.newevent.impl.other.TeleportEvent;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.NumberValue;
import hackclient.rise.aka;
import net.minecraft.block.BlockAir;
import net.minecraft.util.AxisAlignedBB;

public class VulcanDeprecatedFlight extends Mode<Flight> {
    private final NumberValue speed = new NumberValue("Speed", this, 1, 1, 10, 0.1);
    private aka HI;
    private boolean HJ;
    private int HK;
    @EventLink
    public final Listener<StrafeEvent> onStrafe = var1x -> {
        if (this.HK > 0 && !this.HJ) {
            this.HK--;
            aEg.timer.dzD = this.speed.wo().floatValue();
        }
    };
    @EventLink
    public final Listener<BlockAABBEvent> onBlockAABB = var0 -> {
        if (var0.getBlock() instanceof BlockAir && !aEg.thePlayer.isSneaking()) {
            double d0 = var0.getBlockPos().getX();
            double d1 = var0.getBlockPos().getY();
            double d2 = var0.getBlockPos().getZ();
            if (d1 < aEg.thePlayer.posY) {
                var0.setBoundingBox(AxisAlignedBB.fromBounds(-15.0, -1.0, -15.0, 15.0, 1.0, 15.0).offset(d0, d1, d2));
            }
        }
    };
    @EventLink
    public final Listener<TeleportEvent> onTeleport = var1x -> {
        aka aka = new aka(var1x.getPosX(), var1x.getPosY(), var1x.getPosZ());
        if (this.HI == null) {
            this.HI = aka;
            var1x.setCancelled();
            this.HK += 2;
        } else if (!this.HI.equals(aka)) {
            this.getParent().toggle();
        } else {
            var1x.setCancelled();
            this.HK += 2;
        }
    };
    @EventLink
    public final Listener<KeyboardInputEvent> onKeyboardInput = var1x -> {
        if (var1x.getKeyCode() == this.getParent().getKey() && !this.HJ) {
            var1x.setCancelled();
            aEg.thePlayer.jump();
            this.HJ = true;
        }
    };

    public VulcanDeprecatedFlight(String var1, Flight var2) {
        super(var1, var2);
    }

    @Override
    public void onEnable() {
        this.HI = null;
        this.HJ = false;
        this.HK = 0;
    }
}
