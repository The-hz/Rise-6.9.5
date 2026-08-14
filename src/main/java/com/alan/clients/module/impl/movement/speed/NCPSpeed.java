package com.alan.clients.module.impl.movement.speed;

import com.alan.clients.module.impl.movement.Speed;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.other.TeleportEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.NumberValue;
import net.minecraft.network.play.server.S12PacketEntityVelocity;

public class NCPSpeed extends Mode<Speed> {
    private boolean reset;
    private double Lx;
    private final NumberValue Qi = new NumberValue("Jump Motion", this, 0.4, 0.4, 0.42, 0.01);
    private final NumberValue Qj = new NumberValue("Ground Speed", this, 1.75, 0.1, 2.5, 0.05);
    private final NumberValue Qk = new NumberValue("Bunny Slope", this, 0.66, 0, 1, 0.01);
    private final NumberValue Ql = new NumberValue("Timer", this, 1, 0.1, 10, 0.05);
    private final BooleanValue Qm = new BooleanValue("Damage Boost", this, true);
    private final BooleanValue Qn = new BooleanValue("Custom Boost", this, false);
    private final NumberValue Qo = new NumberValue("Boost Speed", this, 0.8, 0.1, 9.5, 0.1);
    private final BooleanValue Qp = new BooleanValue("Low Hop", this, false);
    private final BooleanValue Qq = new BooleanValue("Y-port Hop", this, false);
    private final NumberValue Qr = new NumberValue("Hurt Time", this, 6, 1, 10, 1);
    @EventLink
    public final Listener<PacketReceiveEvent> Qs = var1x -> {
        if (this.Qm.wo()) {
            if (var1x.dq() instanceof S12PacketEntityVelocity s12packetentityvelocity && s12packetentityvelocity.getEntityID() == aEg.thePlayer.getEntityId()) {
                this.Lx = Math.hypot(s12packetentityvelocity.motionX / 8000.0, s12packetentityvelocity.motionZ / 8000.0);
            }
        }
    };
    @EventLink
    public final Listener<StrafeEvent> Qt = var1x -> {
        if (this.Qp.wo() && aEg.thePlayer.tR == 4) {
            aEg.thePlayer.motionY = -0.09800000190734864;
        }

        if (this.Qq.wo() && aEg.thePlayer.tR == 5 && Math.abs(aEg.thePlayer.motionY - 0.09800000190734864) < 0.12) {
            aEg.thePlayer.motionY = -0.09800000190734864;
        }

        if (this.Qn.wo() && aEg.thePlayer.crG <= this.Qr.wo().intValue()) {
            this.Lx = this.Qo.wo().doubleValue();
        }

        double d0 = MoveUtil.getAllowedHorizontalDistance();
        if (MoveUtil.isMoving()) {
            switch (aEg.thePlayer.tR) {
                case 0:
                    float f = this.Qi.wo().floatValue();
                    float f1 = aEg.thePlayer.isCollidedHorizontally ? 0.42F : (f == 0.4F ? f : 0.42F);
                    aEg.thePlayer.motionY = MoveUtil.jumpBoostMotion(f1);
                    this.Lx = d0 * this.Qj.wo().doubleValue();
                    break;
                case 1:
                    this.Lx = this.Lx - this.Qk.wo().doubleValue() * (this.Lx - d0);
                    break;
                default:
                    this.Lx = this.Lx - this.Lx / 159.9F;
            }

            aEg.timer.dzD = this.Ql.wo().floatValue();
            this.reset = false;
        } else if (!this.reset) {
            this.Lx = MoveUtil.getAllowedHorizontalDistance();
            aEg.timer.dzD = 1.0F;
            this.reset = true;
        }

        if (aEg.thePlayer.isCollidedHorizontally) {
            this.Lx = MoveUtil.getAllowedHorizontalDistance();
        }

        var1x.setSpeed(Math.max(this.Lx, d0), Math.random() / 2000.0);
    };
    @EventLink
    public final Listener<TeleportEvent> Qu = var1x -> this.Lx = 0.0;

    public NCPSpeed(String var1, Speed var2) {
        super(var1, var2);
    }

    @Override
    public void onDisable() {
        this.Lx = 0.0;
    }
}
