package com.alan.clients.module.impl.movement.speed;

import com.alan.clients.component.impl.player.RotationComponent;
import com.alan.clients.component.impl.player.rotationcomponent.MovementFix;
import com.alan.clients.module.impl.movement.Speed;
import com.alan.clients.module.impl.player.Scaffold;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.MoveInputEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.other.AttackEvent;
import com.alan.clients.newevent.impl.other.MoveEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.SubMode;
import com.alan.clients.util.packet.PacketUtil;
import com.alan.clients.util.player.SlotUtil;
import com.alan.clients.component.impl.player.BadPacketsComponent;
import java.util.Random;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.potion.Potion;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public class VerusSpeed extends Mode<Speed> {
    private int hV;
    private boolean QL;
    private boolean QM;
    private int QN;
    private boolean Lw;
    private double Lx;
    private float jp;
    private float jq;
    private boolean GQ = true;
    private boolean cJ = false;
    private int QO = 0;
    private final ModeValue mode = new ModeValue("Sub-Mode", this)
        .add(new SubMode("Hop"))
        .add(new SubMode("yPort"))
        .add(new SubMode("Fast"))
        .add(new SubMode("LowHop"))
        .setDefault("Hop");
    @EventLink
    public final Listener<PreMotionEvent> onPreMotionEvent = var1x -> {
        if (MoveUtil.isMoving()) {
            switch (this.mode.wo().getName()) {
                case "Fast":
                    if (!(aEg.thePlayer.moveForward > 0.0F)) {
                        this.QM = true;
                        return;
                    } else if (aEg.thePlayer.onGround) {
                        if (MoveUtil.speed() > 0.3) {
                            this.QM = false;
                        }

                        var1x.setOnGround(true);
                        MoveUtil.strafe(0.41);
                        aEg.thePlayer.motionY = 0.42F;
                        aEg.timer.dzD = 2.1F;
                        this.hV = 0;
                    } else if (this.hV >= 10) {
                        this.QL = true;
                        MoveUtil.strafe(0.35F);
                        return;
                    } else {
                        if (this.QL) {
                            if (this.QM) {
                                MoveUtil.strafe(0.2);
                            } else if (this.hV <= 1) {
                                MoveUtil.strafe(0.35F);
                            } else {
                                MoveUtil.strafe(0.69F - (this.hV - 2.0F) * 0.019F);
                            }
                        }

                        aEg.thePlayer.motionY = 0.0;
                        aEg.timer.dzD = 0.9F;
                        var1x.setOnGround(true);
                        aEg.thePlayer.onGround = true;
                    }
                default:
                    this.hV++;
            }
        }
    };
    @EventLink
    public final Listener<StrafeEvent> onStrafe = var1x -> {
        switch (this.mode.wo().getName()) {
            case "Hop":
                double d0 = MoveUtil.getAllowedHorizontalDistance();
                if (MoveUtil.isMoving()) {
                    switch (aEg.thePlayer.tR) {
                        case 0:
                            float f = 0.39F;
                            float f1 = aEg.thePlayer.isCollidedHorizontally ? 0.42F : (f == 0.4F ? f : 0.42F);
                            aEg.thePlayer.motionY = MoveUtil.jumpBoostMotion(f1);
                            this.Lx = d0 * 1.76;
                            break;
                        case 1:
                            this.Lx = this.Lx - 0.439 * (this.Lx - d0);
                            break;
                        default:
                            this.Lx = this.Lx - this.Lx / 159.9F;
                    }

                    aEg.timer.dzD = 1.0F;
                    this.Lw = false;
                } else if (!this.Lw) {
                    this.Lx = MoveUtil.getAllowedHorizontalDistance();
                    aEg.timer.dzD = 1.0F;
                    this.Lw = true;
                }

                var1x.setSpeed(Math.max(this.Lx, d0), Math.random() / 2000.0);
                if (aEg.thePlayer.crG <= 20) {
                    var1x.setSpeed(this.Lx * 2.0);
                }

                if (aEg.thePlayer.isInWater()) {
                    var1x.setSpeed(0.4);
                }

                if (aEg.thePlayer.isPotionActive(Potion.moveSpeed)) {
                    var1x.setSpeed(0.93 * Math.max(this.Lx, d0), 1.0);
                    if (aEg.thePlayer.isCollidedHorizontally) {
                        this.Lx = MoveUtil.getAllowedHorizontalDistance();
                    }

                    if (aEg.thePlayer.crG <= 20) {
                        var1x.setSpeed(this.Lx * 2.0);
                    }
                }
        }

        if (this.mode.wo().getName().equals("yPort")) {
            MoveUtil.preventDiagonalSpeed();
            if (this.QO > 0) {
                this.QO--;
            } else {
                this.cJ = false;
            }

            if (aEg.gameSettings.keyBindJump.isKeyDown() && aEg.thePlayer.onGround) {
                aEg.thePlayer.motionY = 0.42F;
            }

            if (!aEg.gameSettings.keyBindJump.isKeyDown() && aEg.thePlayer.tR < 2) {
                int i = SlotUtil.vx();
                if (!BadPacketsComponent.bad(false, true, false, false, false) && !this.e(Scaffold.class).isEnabled()) {
                    Random random = new Random();
                    float f2 = random.nextFloat();
                    float f3 = random.nextFloat();
                    PacketUtil.l(
                        new C08PacketPlayerBlockPlacement(
                            new BlockPos(aEg.thePlayer.posX, aEg.thePlayer.posY, aEg.thePlayer.posZ),
                            EnumFacing.UP.getIndex(),
                            new ItemStack(Items.water_bucket),
                            f2,
                            1.0F,
                            f3
                        )
                    );
                }

                if (this.GQ) {
                    this.GQ = false;
                }

                if (aEg.thePlayer.isPotionActive(Potion.moveSpeed)) {
                    MoveUtil.strafe(0.179 * (1 + aEg.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier()) + 0.46);
                } else {
                    MoveUtil.strafe(0.4645);
                }

                BadPacketsComponent.bad(false, true, true, false, false);
                if (!BadPacketsComponent.bad(false, true, false, false, false) & this.cJ) {
                    this.QN = aEg.thePlayer.ticksExisted + 2;
                }

                if (!BadPacketsComponent.bad(false, true, false, false, false) & aEg.thePlayer.ticksExisted % 10 == 1) {
                    this.QN = aEg.thePlayer.ticksExisted + 2;
                }

                if (aEg.thePlayer.onGround) {
                    aEg.thePlayer.motionY = 0.0;
                    if (aEg.thePlayer.isPotionActive(Potion.moveSpeed)) {
                        MoveUtil.strafe(0.092 * (1 + aEg.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier()) + 0.55);
                    } else {
                        MoveUtil.strafe(0.558);
                    }
                }

                MoveUtil.preventDiagonalSpeed();
            } else {
                this.GQ = true;
                if (aEg.thePlayer.isPotionActive(Potion.moveSpeed)) {
                    MoveUtil.strafe(0.04 * (1 + aEg.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier()) + 0.41);
                } else {
                    var1x.setSpeed(0.41);
                }
            }

            MoveUtil.preventDiagonalSpeed();
        }
    };
    @EventLink
    public final Listener<MoveEvent> onMove = var1x -> {
        if (MoveUtil.isMoving()) {
            if (this.mode.wo().getName().equals("LowHop")) {
                if (aEg.thePlayer.onGround) {
                    var1x.setPosY(0.42F);
                    MoveUtil.strafe(0.69F + MoveUtil.speedPotionAmp(0.1));
                    aEg.thePlayer.motionY = 0.0;
                } else {
                    MoveUtil.strafe(0.41F + MoveUtil.speedPotionAmp(0.055));
                }

                if (aEg.thePlayer.crG <= 20) {
                    MoveUtil.strafe(1.0 + MoveUtil.speedPotionAmp(0.055));
                }

                aEg.thePlayer.setSprinting(true);
                aEg.thePlayer.bjQ = true;
            }
        }
    };
    @EventLink
    public final Listener<MoveInputEvent> onMoveInput = var1x -> {
        var1x.setJump(false);
        var1x.setSneak(false);
        this.jp = var1x.getForward();
        this.jq = var1x.getStrafe();
    };
    @EventLink
    public final Listener<AttackEvent> onAttack = var1x -> {
        this.cJ = true;
        this.QO = 10;
    };
    @EventLink(value = 1)
    Listener<PreUpdateEvent> onPreUpdate = var1x -> {
        if (this.mode.wo().getName().equals("Hop")) {
            RotationComponent.setRotations(
                new Vector2f((float)Math.toDegrees(MoveUtil.g(this.jp, this.jq)), aEg.thePlayer.rotationPitch), 2.0, MovementFix.BACKWARDS_SPRINT
            );
        }
    };

    public VerusSpeed(String var1, Speed speed) {
        super(var1, speed);
    }

    @Override
    public void onEnable() {
        this.GQ = true;
        if (this.mode.wo().getName().equals("yPort") && !BadPacketsComponent.bad(true, true, true, true, true) && !this.e(Scaffold.class).isEnabled()) {
            Random random = new Random();
            float f = random.nextFloat();
            float f1 = random.nextFloat();
            PacketUtil.l(
                new C08PacketPlayerBlockPlacement(
                    new BlockPos(aEg.thePlayer.posX, aEg.thePlayer.posY, aEg.thePlayer.posZ),
                    EnumFacing.UP.getIndex(),
                    new ItemStack(Items.water_bucket),
                    f,
                    1.0F,
                    f1
                )
            );
        }

        this.QL = this.QM = false;
        this.hV = 0;
    }

    @Override
    public void onDisable() {
        if (this.mode.wo().getName().equals("yPort") && !BadPacketsComponent.bad(true, true, true, true, true) && !this.e(Scaffold.class).isEnabled()) {
            Random random = new Random();
            float f = random.nextFloat();
            float f1 = random.nextFloat();
            PacketUtil.l(
                new C08PacketPlayerBlockPlacement(
                    new BlockPos(aEg.thePlayer.posX, aEg.thePlayer.posY, aEg.thePlayer.posZ),
                    EnumFacing.UP.getIndex(),
                    new ItemStack(Items.water_bucket),
                    f,
                    1.0F,
                    f1
                )
            );
        }
    }
}
