package com.alan.clients.module.impl.combat.velocity;

import com.alan.clients.module.impl.combat.Velocity;
import com.alan.clients.module.impl.movement.Speed;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.MoveInputEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import hackclient.rise.bb;
import hackclient.rise.bv;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S12PacketEntityVelocity;

public final class MMCVelocity extends Mode<Velocity> {
    private boolean gD;
    @EventLink
    public final Listener<PacketReceiveEvent> uH = var1x -> {
        Packet packet = var1x.dq();
        if (packet instanceof S12PacketEntityVelocity && ((S12PacketEntityVelocity)packet).getEntityID() == aEg.thePlayer.getEntityId()) {
            this.gD = true;
        }
    };
    @EventLink
    public final Listener<PreMotionEvent> uI = var1x -> {
        if (!this.wj().qQ.wo() || aEg.thePlayer.isSwingInProgress) {
            bv.f(7.0);
            if (aEg.thePlayer.onGround && aEg.thePlayer.hurtTime > 0) {
                bb.a(false, true, false, false, false);
            }

            if (aEg.thePlayer.ae == 1) {
                aEg.thePlayer.motionX *= 0.0;
                aEg.thePlayer.motionZ *= 0.0;
            }

            if (aEg.thePlayer.ae == 1 && (aEg.thePlayer.isJumping || this.e(Speed.class).isEnabled())) {
                aEg.thePlayer.motionY -= 9.0;
            }

            if (aEg.thePlayer.cqL == 1 && aEg.thePlayer.ae < 4 && MoveUtil.speed() < 0.31) {
                MoveUtil.moveFlying(0.05);
            }
        }
    };
    @EventLink
    public final Listener<MoveInputEvent> uJ = var1x -> {
        if (!this.wj().qQ.wo() || aEg.thePlayer.isSwingInProgress) {
            ;
        }
    };

    public MMCVelocity(String var1, Velocity var2) {
        super(var1, var2);
    }
}
