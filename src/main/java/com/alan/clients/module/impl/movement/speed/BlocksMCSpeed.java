package com.alan.clients.module.impl.movement.speed;

import com.alan.clients.module.impl.movement.Speed;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.other.TeleportEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.potion.Potion;

public class BlocksMCSpeed extends Mode<Speed> {
    private boolean Lw;
    private double Lx;
    @EventLink
    public final Listener<StrafeEvent> OY = var1x -> {
        double d0 = MoveUtil.getAllowedHorizontalDistance();
        boolean flag = aEg.thePlayer.isPotionActive(Potion.moveSpeed);
        if (MoveUtil.isMoving()) {
            switch (aEg.thePlayer.tR) {
                case 0:
                    aEg.thePlayer.motionY = MoveUtil.jumpBoostMotion(0.42F);
                    this.Lx = d0 * (flag ? 1.4 : 2.15);
                    break;
                case 1:
                    this.Lx = this.Lx - 0.8 * (this.Lx - d0);
                    break;
                default:
                    this.Lx = this.Lx - this.Lx / 159.9F;
            }

            this.Lw = false;
        } else if (!this.Lw) {
            this.Lx = 0.0;
            this.Lw = true;
            this.Lx = MoveUtil.getAllowedHorizontalDistance();
        }

        if (aEg.thePlayer.isCollidedHorizontally) {
            this.Lx = MoveUtil.getAllowedHorizontalDistance();
        }

        var1x.setSpeed(Math.max(this.Lx, d0), Math.random() / 2000.0);
    };
    @EventLink
    public final Listener<TeleportEvent> OZ = var1x -> this.Lx = 0.0;
    @EventLink
    public final Listener<PreMotionEvent> Pa = var0 -> {
        if (!MoveUtil.isMoving()) {
            var0.setPosX(var0.getPosX() + (Math.random() - 0.5) / 3.0);
            var0.setPosZ(var0.getPosZ() + (Math.random() - 0.5) / 3.0);
        }
    };
    @EventLink
    public final Listener<PacketSendEvent> Pb = var0 -> {
        boolean flag = var0.dq() instanceof C0BPacketEntityAction;
    };

    public BlocksMCSpeed(String var1, Speed var2) {
        super(var1, var2);
    }

    @Override
    public void onDisable() {
        this.Lx = 0.0;
    }
}
