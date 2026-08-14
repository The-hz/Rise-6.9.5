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
import hackclient.rise.ahj;
import hackclient.rise.bd;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;
import net.minecraft.network.play.client.C03PacketPlayer.C06PacketPlayerPosLook;

public class MatrixDamageFlight extends Mode<Flight> {
    private final NumberValue Ia = new NumberValue("Timer Speed", this, 30, 1.0, 100.0, 0.1);
    private final NumberValue Ib = new NumberValue("Speed", this, 0.07, 0.0, 1.0, 0.01);
    private final BooleanValue Ic = new BooleanValue("No Speed", this, false);
    private final BooleanValue Id = new BooleanValue("Detect Damage", this, true);
    private final BooleanValue Ie = new BooleanValue("Auto Disable", this, true);
    private final NumberValue If = new NumberValue("Fly Ticks", this, 1000, 0.0, 1600.0, 10.0, () -> !this.Id.wo());
    private final BooleanValue Ig = new BooleanValue("Self Damage", this, true);
    private final BooleanValue Ih = new BooleanValue("New Self Damage", this, false);
    private final BooleanValue Ii = new BooleanValue("Packet", this, true);
    private final ModeValue Ij = new ModeValue("Motion Y", this)
        .add(new SubMode("None"))
        .add(new SubMode("Simple"))
        .add(new SubMode("Multiply"))
        .setDefault("None");
    private final NumberValue Ik = new NumberValue("Motion", this, -0.01, -0.3, 0.3, 0.01, () -> this.Ij.wo().getName().equals("None"));
    private float Il;
    private float Im;
    private int In;
    private int Hb;
    private int Io;
    private boolean Ip;
    @EventLink
    public final Listener<PreMotionEvent> Iq = var1x -> {
        if (this.Ig.wo() && aEg.thePlayer.hurtTime <= 0 && this.Hb < 4) {
            var1x.setOnGround(false);
        }

        if (this.Ih.wo() && bd.cY > 3.0F) {
            var1x.setOnGround(true);
            aEg.thePlayer.onGround = true;
            aEg.thePlayer.motionY = 0.0;
            bd.cY = 0.0F;
        }
    };
    @EventLink
    public final Listener<MoveInputEvent> Ir = var1x -> {
        if (this.Ig.wo() && !this.Ip && (this.Hb < 4 || !aEg.thePlayer.onGround)) {
            var1x.setSneak(false);
            var1x.setJump(false);
            var1x.setStrafe(0.0F);
            var1x.setForward(0.0F);
        }
    };
    @EventLink
    public final Listener<PreUpdateEvent> Is = var1x -> {
        if (aEg.thePlayer.hurtTime > 0 && !this.Ip && aEg.thePlayer.tR >= 3) {
            this.Io = 20 * this.Ia.wo().intValue();
            this.Ip = true;
        }

        if (this.Ig.wo() && aEg.thePlayer.hurtTime <= 0 && this.Hb < 4 && aEg.thePlayer.onGround) {
            aEg.thePlayer.jump();
            this.Hb++;
        }

        if (!this.Id.wo() || this.In <= this.If.wo().intValue() && this.Ip) {
            double d0 = this.Io > 0 ? this.Ib.wo().doubleValue() : 0.03;
            if (!this.Ic.wo()) {
                MoveUtil.strafe(d0);
            }

            label76: {
                label75: {
                    label74: {
                        aEg.timer.dzD = this.Ia.wo().floatValue();
                        String s = this.Ij.wo().getName();
                        byte b0 = -1;
                        switch (s.hashCode()) {
                            case -1808631973:
                                if (s.equals("Stable")) {
                                    boolean flag = true;
                                    break label75;
                                }
                                break;
                            case 2433880:
                                if (s.equals("None")) {
                                    b0 = 0;
                                }
                                break;
                            case 718473796:
                                if (s.equals("Multiply")) {
                                    byte b1 = 2;
                                    break label74;
                                }
                        }

                        switch (b0) {
                            case 0:
                                aEg.thePlayer.motionY *= 0.039;
                                break label76;
                            case 1:
                                break label75;
                            case 2:
                                break;
                            default:
                                break label76;
                        }
                    }

                    aEg.thePlayer.motionY = aEg.thePlayer.motionY * this.Ik.wo().doubleValue();
                    break label76;
                }

                aEg.thePlayer.motionY = this.Ik.wo().doubleValue();
            }

            if (this.Io > 0) {
                this.Io--;
            }

            this.In++;
        }

        if (this.Id.wo() && this.Ip) {
            if (!this.Ie.wo()) {
                if (this.In >= this.If.wo().intValue()) {
                    this.wj().toggle();
                }
            } else if (this.Io <= 0) {
                this.wj().toggle();
            }
        }
    };

    public MatrixDamageFlight(String var1, Flight var2) {
        super(var1, var2);
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
        if (this.Ii.wo()) {
            ahj.m(new C06PacketPlayerPosLook(aEg.thePlayer.posX, aEg.thePlayer.posY, aEg.thePlayer.posZ, aEg.thePlayer.pl, aEg.thePlayer.rotationPitch, false));
            ahj.m(new C04PacketPlayerPosition(aEg.thePlayer.posX, aEg.thePlayer.posY, aEg.thePlayer.posZ, false));
            ahj.m(new C06PacketPlayerPosLook(aEg.thePlayer.posX, aEg.thePlayer.posY, aEg.thePlayer.posZ, aEg.thePlayer.pl, aEg.thePlayer.rotationPitch, false));
        }
    }
}
