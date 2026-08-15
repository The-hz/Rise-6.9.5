package com.alan.clients.module.impl.movement.flight;

import com.alan.clients.module.impl.movement.Flight;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.MoveInputEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.NumberValue;
import com.alan.clients.value.impl.SubMode;
import com.alan.clients.util.packet.PacketUtil;
import com.alan.clients.component.impl.player.FallDistanceComponent;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;
import net.minecraft.network.play.client.C03PacketPlayer.C06PacketPlayerPosLook;

public class MatrixDamageFlight extends Mode<Flight> {
    private final NumberValue timerSpeed = new NumberValue("Timer Speed", this, 30, 1.0, 100.0, 0.1);
    private final NumberValue speed = new NumberValue("Speed", this, 0.07, 0.0, 1.0, 0.01);
    private final BooleanValue noSpeed = new BooleanValue("No Speed", this, false);
    private final BooleanValue detectDamage = new BooleanValue("Detect Damage", this, true);
    private final BooleanValue autoDisable = new BooleanValue("Auto Disable", this, true);
    private final NumberValue flyTicks = new NumberValue("Fly Ticks", this, 1000, 0.0, 1600.0, 10.0, () -> !this.detectDamage.wo());
    private final BooleanValue selfDamage = new BooleanValue("Self Damage", this, true);
    private final BooleanValue newSelfDamage = new BooleanValue("New Self Damage", this, false);
    private final BooleanValue packet = new BooleanValue("Packet", this, true);
    private final ModeValue motionY = new ModeValue("Motion Y", this)
        .add(new SubMode("None"))
        .add(new SubMode("Simple"))
        .add(new SubMode("Multiply"))
        .setDefault("None");
    private final NumberValue motion = new NumberValue("Motion", this, -0.01, -0.3, 0.3, 0.01, () -> this.motionY.wo().getName().equals("None"));
    private float Il;
    private float Im;
    private int In;
    private int Hb;
    private int Io;
    private boolean Ip;
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var1x -> {
        if (this.selfDamage.wo() && aEg.thePlayer.hurtTime <= 0 && this.Hb < 4) {
            var1x.setOnGround(false);
        }

        if (this.newSelfDamage.wo() && FallDistanceComponent.cY > 3.0F) {
            var1x.setOnGround(true);
            aEg.thePlayer.onGround = true;
            aEg.thePlayer.motionY = 0.0;
            FallDistanceComponent.cY = 0.0F;
        }
    };
    @EventLink
    public final Listener<MoveInputEvent> onMoveInput = var1x -> {
        if (this.selfDamage.wo() && !this.Ip && (this.Hb < 4 || !aEg.thePlayer.onGround)) {
            var1x.setSneak(false);
            var1x.setJump(false);
            var1x.setStrafe(0.0F);
            var1x.setForward(0.0F);
        }
    };
    @EventLink
    public final Listener<PreUpdateEvent> onPreUpdate = var1x -> {
        if (aEg.thePlayer.hurtTime > 0 && !this.Ip && aEg.thePlayer.tR >= 3) {
            this.Io = 20 * this.timerSpeed.wo().intValue();
            this.Ip = true;
        }

        if (this.selfDamage.wo() && aEg.thePlayer.hurtTime <= 0 && this.Hb < 4 && aEg.thePlayer.onGround) {
            aEg.thePlayer.jump();
            this.Hb++;
        }

        if (!this.detectDamage.wo() || this.In <= this.flyTicks.wo().intValue() && this.Ip) {
            double d0 = this.Io > 0 ? this.speed.wo().doubleValue() : 0.03;
            if (!this.noSpeed.wo()) {
                MoveUtil.strafe(d0);
            }

            label76: {
                label75: {
                    {
                        aEg.timer.dzD = this.timerSpeed.wo().floatValue();
                        String s = this.motionY.wo().getName();
                        switch (s) {
                            case "None":
                                aEg.thePlayer.motionY *= 0.039;
                                break label76;
                            case "Stable":
                                break label75;
                            case "Multiply":
                                break;
                            default:
                                break label76;
                        }
                    }

                    aEg.thePlayer.motionY = aEg.thePlayer.motionY * this.motion.wo().doubleValue();
                    break label76;
                }

                aEg.thePlayer.motionY = this.motion.wo().doubleValue();
            }

            if (this.Io > 0) {
                this.Io--;
            }

            this.In++;
        }

        if (this.detectDamage.wo() && this.Ip) {
            if (!this.autoDisable.wo()) {
                if (this.In >= this.flyTicks.wo().intValue()) {
                    this.getParent().toggle();
                }
            } else if (this.Io <= 0) {
                this.getParent().toggle();
            }
        }
    };

    public MatrixDamageFlight(String var1, Flight flight) {
        super(var1, flight);
    }

    @Override
    public void onEnable() {
        this.In = 0;
        this.Hb = 0;
        this.Io = 0;
        this.Ip = false;
        this.Il = aEg.thePlayer.pl;
        this.Im = aEg.thePlayer.rotationPitch;
    }

    @Override
    public void onDisable() {
        this.In = 0;
        this.Hb = 0;
        this.Io = 0;
        this.Ip = false;
        aEg.timer.dzD = 1.0F;
        if (this.packet.wo()) {
            PacketUtil.m(new C06PacketPlayerPosLook(aEg.thePlayer.posX, aEg.thePlayer.posY, aEg.thePlayer.posZ, aEg.thePlayer.pl, aEg.thePlayer.rotationPitch, false));
            PacketUtil.m(new C04PacketPlayerPosition(aEg.thePlayer.posX, aEg.thePlayer.posY, aEg.thePlayer.posZ, false));
            PacketUtil.m(new C06PacketPlayerPosLook(aEg.thePlayer.posX, aEg.thePlayer.posY, aEg.thePlayer.posZ, aEg.thePlayer.pl, aEg.thePlayer.rotationPitch, false));
        }
    }
}
