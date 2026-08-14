package com.alan.clients.module.impl.combat.velocity;

import com.alan.clients.module.impl.combat.Velocity;
import com.alan.clients.module.impl.movement.Flight;
import com.alan.clients.module.impl.movement.Speed;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.other.TeleportEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S12PacketEntityVelocity;

public class MatrixVelocity
extends Mode<Velocity> {
    @EventLink
    public Listener<StrafeEvent> uL;
    public static int[] fld_0OOOoo00o0_23;
    @EventLink
    public Listener<TeleportEvent> uM;
    @EventLink(cH=0)
    public Listener<PacketReceiveEvent> uK = packetReceiveEvent -> {
        Object var11_2 = null;
        Object var12_3 = null;
        Packet<?> packet = packetReceiveEvent.dq();
        if (packet instanceof S12PacketEntityVelocity) {
            S12PacketEntityVelocity s12PacketEntityVelocity = (S12PacketEntityVelocity)packet;
            if (s12PacketEntityVelocity.getEntityID() == MatrixVelocity.aEg.thePlayer.getEntityId()) {
                MatrixVelocity.aEg.thePlayer.motionY = (double)s12PacketEntityVelocity.getMotionY() / 8000.0;
                if (!this.e(Speed.class).isEnabled() && MoveUtil.isMoving()) {
                    packetReceiveEvent.setCancelled();
                }
                return;
            }
            packetReceiveEvent.e((Packet<?>)s12PacketEntityVelocity);
        }
    };

    static {
        MatrixVelocity.o0Oo000O0oO();
    }

    public static void o0Oo000O0oO() {
        fld_0OOOoo00o0_23 = new int[21];
        MatrixVelocity.fld_0OOOoo00o0_23[2] = 49;
        MatrixVelocity.fld_0OOOoo00o0_23[15] = 75;
        MatrixVelocity.fld_0OOOoo00o0_23[18] = -169;
        MatrixVelocity.fld_0OOOoo00o0_23[16] = -1;
        MatrixVelocity.fld_0OOOoo00o0_23[10] = -70;
        MatrixVelocity.fld_0OOOoo00o0_23[3] = 82;
        MatrixVelocity.fld_0OOOoo00o0_23[14] = -52;
        MatrixVelocity.fld_0OOOoo00o0_23[19] = 67;
        MatrixVelocity.fld_0OOOoo00o0_23[1] = 64;
        MatrixVelocity.fld_0OOOoo00o0_23[11] = 75;
        MatrixVelocity.fld_0OOOoo00o0_23[17] = -64;
        MatrixVelocity.fld_0OOOoo00o0_23[6] = 132;
        MatrixVelocity.fld_0OOOoo00o0_23[12] = 13;
        MatrixVelocity.fld_0OOOoo00o0_23[9] = 12;
        MatrixVelocity.fld_0OOOoo00o0_23[8] = 102;
        MatrixVelocity.fld_0OOOoo00o0_23[13] = -50;
        MatrixVelocity.fld_0OOOoo00o0_23[7] = -36;
        MatrixVelocity.fld_0OOOoo00o0_23[0] = -14;
        MatrixVelocity.fld_0OOOoo00o0_23[20] = -101;
        MatrixVelocity.fld_0OOOoo00o0_23[4] = -20;
        MatrixVelocity.fld_0OOOoo00o0_23[5] = 63;
    }

    public MatrixVelocity(String string, Velocity velocity) {
        super(string, velocity);
        this.uL = strafeEvent -> {
            if (!MoveUtil.isMoving() && MatrixVelocity.aEg.thePlayer.ae == 1) {
                MatrixVelocity.aEg.thePlayer.motionX *= -0.1;
                MatrixVelocity.aEg.thePlayer.motionZ *= -0.1;
            } else if (MatrixVelocity.aEg.thePlayer.ae == 1 && !this.e(Speed.class).isEnabled()) {
                MoveUtil.strafe();
            }
            if (MatrixVelocity.aEg.thePlayer.ae < 6 && this.e(Speed.class).isEnabled()) {
                MoveUtil.strafe();
            } else if (MatrixVelocity.aEg.thePlayer.ae > 1 && !this.e(Speed.class).isEnabled() && MatrixVelocity.aEg.thePlayer.ae < 15 && !this.e(Flight.class).isEnabled()) {
                MatrixVelocity.aEg.thePlayer.motionY -= 0.00348;
            }
            if (MatrixVelocity.aEg.thePlayer.ae < 10 && MatrixVelocity.aEg.thePlayer.ae > 1) {
                this.e(Flight.class).isEnabled();
            }
        };
        this.uM = teleportEvent -> {
            double d2 = teleportEvent.getPosY() - (MatrixVelocity.aEg.thePlayer.posY - 2.0);
        };
    }
}
