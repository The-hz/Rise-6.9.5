package com.alan.clients.module.impl.movement.flight;

import com.alan.clients.module.impl.movement.Flight;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import hackclient.rise.afi;
import hackclient.rise.ahj;
import hackclient.rise.ahz;
import hackclient.rise.aia;
import net.minecraft.network.play.client.C03PacketPlayer.C06PacketPlayerPosLook;

public class VulcanDamageFlight extends Mode<Flight> {
    private int hQ;
    private int hV;
    private boolean IJ;
    public final BooleanValue IK = new BooleanValue("Self Damage (May Flag More) if not fly will wait for fall damage", this, true);
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var1x -> {
        if (this.IK.wo()) {
            MoveUtil.stop();
        }

        if (aEg.thePlayer.ae == 1) {
            ahj.l(
                new C06PacketPlayerPosLook(
                    aEg.thePlayer.posX, aEg.thePlayer.posY - 2.0, aEg.thePlayer.posZ, aEg.thePlayer.pl, aEg.thePlayer.rotationPitch, false
                )
            );
            this.IJ = true;
        }

        if (this.IJ) {
            this.hQ++;
            if (this.hQ < 10) {
                MoveUtil.stop();
            }

            aEg.thePlayer.motionY = 1.0E-10 + (aEg.gameSettings.keyBindJump.isKeyDown() ? 0.0 : 0.0) - (aEg.gameSettings.keyBindSneak.isKeyDown() ? 0.0 : 0.0);
            if (aEg.thePlayer.getDistance(aEg.thePlayer.lastReportedPosX, aEg.thePlayer.lastReportedPosY, aEg.thePlayer.lastReportedPosZ) <= 9.0) {
                var1x.setCancelled();
            } else {
                this.hV++;
                if (this.hV >= 3) {
                    MoveUtil.stop();
                    this.getParent().toggle();
                }
            }
        }
    };
    @EventLink
    public final Listener<StrafeEvent> onStrafe = var1x -> {
        if (this.hQ >= 10) {
            if (this.IJ) {
                var1x.setSpeed(1.0);
            }
        }
    };

    public VulcanDamageFlight(String var1, Flight var2) {
        super(var1, var2);
    }

    @Override
    public void onEnable() {
        this.hQ = 0;
        this.hV = 0;
        this.IJ = false;
        if (this.IK.wo()) {
            ahz.a(aia.POSITION, 3.42F, 1, false, false);
        } else {
            afi.b("take fall damage or turn on self damage");
        }
    }

    @Override
    public void onDisable() {
        MoveUtil.stop();
    }
}
