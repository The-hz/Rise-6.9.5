package com.alan.clients.module.impl.movement.flight;

import com.alan.clients.module.impl.movement.Flight;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.other.TeleportEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.SubMode;
import hackclient.rise.afi;
import hackclient.rise.ahj;
import hackclient.rise.aih;
import net.minecraft.network.play.client.C03PacketPlayer.C06PacketPlayerPosLook;
import net.minecraft.util.AxisAlignedBB;

public class LatestNCPFlight extends Mode<Flight> {
    private final ModeValue mode = new ModeValue("NCP Mode", this).add(new SubMode("Normal")).add(new SubMode("Clip")).setDefault("Normal");
    private double moveSpeed;
    private boolean yr;
    private boolean Gu;
    private boolean Gv;
    private boolean ys;
    @EventLink
    public final Listener<TeleportEvent> onTeleport = var1x -> {
        if (this.ys) {
            var1x.setCancelled();
            this.ys = false;
            afi.b("Teleported");
        }
    };
    @EventLink
    public final Listener<StrafeEvent> onStrafe = var1x -> {
        if (this.mode.wo().getName().equals("Clip")) {
            AxisAlignedBB axisalignedbb = aEg.thePlayer.getEntityBoundingBox().offset(0.0, 1.0, 0.0);
            if (!aEg.theWorld.getCollidingBoundingBoxes(aEg.thePlayer, axisalignedbb).isEmpty() && !this.yr) {
                this.Gu = true;
                if (this.Gv) {
                    return;
                }

                this.Gv = true;
                ahj.l(
                    new C06PacketPlayerPosLook(aEg.thePlayer.posX, aEg.thePlayer.posY, aEg.thePlayer.posZ, aEg.thePlayer.pl, aEg.thePlayer.rotationPitch, false)
                );
                ahj.l(
                    new C06PacketPlayerPosLook(
                        aEg.thePlayer.posX, aEg.thePlayer.posY - 0.1, aEg.thePlayer.posZ, aEg.thePlayer.pl, aEg.thePlayer.rotationPitch, false
                    )
                );
                ahj.l(
                    new C06PacketPlayerPosLook(aEg.thePlayer.posX, aEg.thePlayer.posY, aEg.thePlayer.posZ, aEg.thePlayer.pl, aEg.thePlayer.rotationPitch, false)
                );
                this.ys = true;
            } else {
                switch (aEg.thePlayer.tR) {
                    case 0:
                        if (this.Gu && this.Gv) {
                            this.yr = true;
                            var1x.setSpeed(10.0);
                            aEg.thePlayer.motionY = 0.42F;
                            this.Gu = false;
                        }
                        break;
                    case 1:
                        if (this.yr) {
                            var1x.setSpeed(9.6);
                        }
                }
            }

            MoveUtil.strafe();
            aEg.timer.dzD = 0.4F;
        }
    };
    @EventLink
    private final Listener<PreMotionEvent> preMotionEventListener = var1x -> {
        if (this.mode.wo().getName().equals("Normal")) {
            AxisAlignedBB axisalignedbb = aEg.thePlayer.getEntityBoundingBox().offset(0.0, 1.0, 0.0);
            if (this.yr) {
                aEg.thePlayer.motionY += 0.025;
                MoveUtil.strafe(this.moveSpeed *= 0.935F);
                if (aEg.thePlayer.motionY < -0.5 && !aih.vh()) {
                    this.toggle();
                }
            }

            if (aEg.theWorld.getCollidingBoundingBoxes(aEg.thePlayer, axisalignedbb).isEmpty() && !this.yr) {
                this.yr = true;
                aEg.thePlayer.jump();
                MoveUtil.strafe(this.moveSpeed = 9.0);
            }
        }
    };

    public LatestNCPFlight(String var1, Flight var2) {
        super(var1, var2);
    }

    @Override
    public void onDisable() {
        MoveUtil.stop();
    }

    @Override
    public void onEnable() {
        afi.b("Start the fly under the block and walk forward");
        this.moveSpeed = 0.0;
        this.Gu = false;
        this.yr = false;
        this.Gv = false;
        this.ys = false;
    }
}
