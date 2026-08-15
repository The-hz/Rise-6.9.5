package com.alan.clients.module.impl.combat.velocity;

import com.alan.clients.component.impl.player.BlinkComponent;
import com.alan.clients.module.impl.combat.KillAura;
import com.alan.clients.module.impl.combat.Velocity;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.MoveInputEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.NumberValue;
import com.alan.clients.value.impl.SubMode;
import hackclient.rise.afi;
import com.alan.clients.util.packet.PacketUtil;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.block.BlockWeb;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer.C05PacketPlayerLook;
import net.minecraft.network.play.client.C03PacketPlayer.C06PacketPlayerPosLook;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C0BPacketEntityAction.Action;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.network.play.server.S06PacketUpdateHealth;
import net.minecraft.network.play.server.S07PacketRespawn;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S23PacketBlockChange;
import net.minecraft.network.play.server.S29PacketSoundEffect;
import net.minecraft.network.play.server.S3EPacketTeams;
import net.minecraft.network.play.server.a;
import net.minecraft.network.play.server.ab;
import net.minecraft.network.play.server.bt;
import net.minecraft.network.play.server.c;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public final class GrimTestVelocity extends Mode<Velocity> {
    private final ModeValue mode = new ModeValue("Type", this)
        .add(new SubMode("Reduce"))
        .add(new SubMode("Jump Reset"))
        .add(new SubMode("Grim Full"))
        .setDefault("Reduce");
    private final NumberValue minAttacks = new NumberValue("Min Attacks", this, 2, 1, 5, 1, () -> !this.u("Reduce"));
    private final NumberValue maxAttacks = new NumberValue("Max Attacks", this, 3, 1, 10, 1, () -> !this.u("Reduce"));
    private final BooleanValue delayRelease = new BooleanValue("Delay Release", this, false, () -> !this.u("Reduce"));
    private final NumberValue delaySpeedThreshold = new NumberValue("Delay Speed Threshold", this, 0.6, 0.1, 2, 0.05, () -> !this.u("Reduce") || !this.delayRelease.wo());
    private final NumberValue sN = new NumberValue("Delay Timeout (ms)", this, 5000, 50, 10000, 50, () -> !this.u("Reduce") || !this.delayRelease.wo());
    private final BooleanValue delayLogging = new BooleanValue("Delay Logging", this, false, () -> !this.u("Reduce") || !this.delayRelease.wo());
    private final NumberValue jumpResetTick = new NumberValue("Jump Reset Tick", this, 1, 0, 9, 1, () -> !this.u("Jump Reset"));
    private final NumberValue grimLevel = new NumberValue("Grim Level", this, 0.001, 0.001, 0.1, 0.001, () -> !this.u("Grim Full"));
    private final BooleanValue logging = new BooleanValue("Logging", this, true);
    private Entity pY;
    private boolean sS;
    private int sT;
    private double sU;
    private int sV;
    private boolean sW;
    private long sX;
    private boolean sY;
    private int sZ;
    private final Random ta = new Random();
    private final Queue<Packet<?>> tb = new ConcurrentLinkedQueue<>();
    private boolean tc;
    private Vec3 td;
    private long te;
    private boolean tf;
    private boolean tg;
    @EventLink
    public final Listener<PacketSendEvent> onPacketSend = var1x -> {
        if (aEg.thePlayer != null && aEg.theWorld != null) {
            if (this.u("Grim Full")) {
                if (var1x.dq() instanceof C03PacketPlayer c03packetplayer && c03packetplayer.afG()) {
                    float f = c03packetplayer.getYaw();
                    float f1 = c03packetplayer.getPitch();
                    if (this.h(f) || this.h(f1)) {
                        float f2 = this.grimLevel.wo().floatValue();
                        float f3 = f + (this.ta.nextBoolean() ? 1 : -1) * f2;
                        float f4 = f1 + (this.ta.nextBoolean() ? 1 : -1) * f2;
                        if (c03packetplayer instanceof C06PacketPlayerPosLook) {
                            var1x.setPacket(
                                new C06PacketPlayerPosLook(
                                    c03packetplayer.afD(), c03packetplayer.afE(), c03packetplayer.afF(), f3, f4, c03packetplayer.isOnGround()
                                )
                            );
                        } else if (c03packetplayer instanceof C05PacketPlayerLook) {
                            var1x.setPacket(new C05PacketPlayerLook(f3, f4, c03packetplayer.isOnGround()));
                        }
                    }
                }
            }
        }
    };
    @EventLink
    public final Listener<PacketReceiveEvent> onPacketReceive = var1x -> {
        if (aEg.thePlayer != null && aEg.theWorld != null) {
            Packet packet = var1x.getPacket();
            if (this.u("Grim Full")) {
                if (packet instanceof S12PacketEntityVelocity s12packetentityvelocity && s12packetentityvelocity.getEntityID() == aEg.thePlayer.getEntityId()) {
                    var1x.setCancelled();
                    return;
                }

                if (packet instanceof S08PacketPlayerPosLook s08packetplayerposlook) {
                    aEg.thePlayer.setPosition(s08packetplayerposlook.getX(), s08packetplayerposlook.getY(), s08packetplayerposlook.getZ());
                    aEg.thePlayer.setVelocity(0.0, 0.0, 0.0);
                    var1x.setCancelled();
                    return;
                }
            }

            if (this.u("Reduce") && this.delayRelease.wo() && packet instanceof S08PacketPlayerPosLook && !this.tc) {
                this.tg = true;
                this.t("Flag detected, skipping next delay.");
            }

            if (packet instanceof ab ab && ab.getEntity(aEg.theWorld) == aEg.thePlayer && ab.getOpCode() == 2) {
                this.sW = true;
            }

            if (packet instanceof S12PacketEntityVelocity s12packetentityvelocity1) {
                if (s12packetentityvelocity1.getEntityID() != aEg.thePlayer.getEntityId()) {
                    return;
                }

                this.sS = true;
                KillAura killaura = this.e(KillAura.class);
                this.pY = killaura != null ? killaura.jE : null;
                double d0 = s12packetentityvelocity1.getMotionX() / 8000.0;
                double d1 = s12packetentityvelocity1.getMotionY() / 8000.0;
                double d2 = s12packetentityvelocity1.getMotionZ() / 8000.0;
                double d3 = Math.sqrt(d0 * d0 + d2 * d2);
                this.sU = d3;
                if (this.u("Reduce")) {
                    if (this.sW) {
                        this.sW = false;
                        if (this.gA()) {
                            return;
                        }

                        if (System.currentTimeMillis() - this.sX < 1000L) {
                            return;
                        }

                        if (d3 < 0.1) {
                            return;
                        }

                        if (!aEg.thePlayer.isSprinting()) {
                            return;
                        }

                        if (this.delayRelease.wo() && !this.tg) {
                            if (d3 >= this.delaySpeedThreshold.wo().doubleValue()) {
                                var1x.setCancelled();
                                this.tc = true;
                                this.td = new Vec3(d0, d1, d2);
                                this.te = System.currentTimeMillis();
                                this.t("Strong KB (speed: " + String.format("%.3f", d3) + "), delay started.");
                                return;
                            }

                            this.t("Weak KB (speed: " + String.format("%.3f", d3) + "), normal reduce.");
                        }

                        if (this.tg) {
                            this.tg = false;
                            this.t("Flagged, using normal reduce this time.");
                        }

                        this.sV = this.gz();
                        this.sY = !aEg.thePlayer.isSprinting();
                    }
                } else if (this.u("Jump Reset")) {
                    this.sT = this.jumpResetTick.wo().intValue();
                }
            }

            if (this.tc) {
                if (packet instanceof S23PacketBlockChange || packet instanceof S29PacketSoundEffect || packet instanceof c) {
                    return;
                }

                if (packet instanceof S3EPacketTeams || packet instanceof a) {
                    return;
                }

                if (packet instanceof S06PacketUpdateHealth s06packetupdatehealth) {
                    if (s06packetupdatehealth.getHealth() <= 0.0F) {
                        this.t("Player died, releasing all packets.");
                        this.r(true);
                    }

                    return;
                }

                if (packet instanceof bt || packet instanceof S07PacketRespawn || packet instanceof S08PacketPlayerPosLook) {
                    this.t("Critical packet received, releasing all packets.");
                    this.r(true);
                    return;
                }

                this.tb.add(packet);
                var1x.setCancelled();
            }
        }
    };
    @EventLink
    public final Listener<PreUpdateEvent> onPreUpdate = var1x -> {
        if (aEg.thePlayer != null) {
            if (aEg.thePlayer.hurtTime == 0) {
                this.sS = false;
                this.sU = 0.0;
            }

            if (this.sT > 0) {
                this.sT--;
            }

            if (this.tc && this.td != null) {
                MovingObjectPosition movingobjectposition = aEg.objectMouseOver;
                if (movingobjectposition != null && movingobjectposition.entityHit instanceof EntityPlayer entityplayer) {
                    int i = this.gz();
                    double d0 = 1.0;

                    for (int j = 0; j < i; j++) {
                        if (aEg.thePlayer.isSprinting()) {
                            aEg.thePlayer.setSprinting(false);
                        }

                        aEg.playerController.attackEntity(aEg.thePlayer, entityplayer);
                        aEg.thePlayer.swingItem();
                        d0 *= 0.6;
                    }

                    aEg.thePlayer.setVelocity(this.td.xCoord * d0, this.td.yCoord, this.td.zCoord * d0);
                    this.t("Target acquired, attacks: " + i + ", KB reduced to " + String.format("%.1f%%", d0 * 100.0));
                    this.tf = true;
                }

                if (!this.tf) {
                    long k = System.currentTimeMillis() - this.te;
                    if (k >= this.sN.wo().longValue()) {
                        aEg.thePlayer.setVelocity(this.td.xCoord, this.td.yCoord, this.td.zCoord);
                        this.t("Timeout (" + k + "ms), applying full KB.");
                        this.tf = true;
                    }
                }

                if (this.tf) {
                    this.r(true);
                }
            }

            if (this.tg && aEg.thePlayer.hurtTime == 0) {
                this.tg = false;
            }

            if (this.u("Reduce") && this.pY != null && this.sV > 0) {
                if (this.sY) {
                    aEg.getNetHandler().addToSendQueue(new C0BPacketEntityAction(aEg.thePlayer, Action.START_SPRINTING));
                }

                while (this.sV >= 1) {
                    aEg.getNetHandler().addToSendQueue(new C02PacketUseEntity(this.pY, net.minecraft.network.play.client.C02PacketUseEntity.Action.ATTACK));
                    aEg.thePlayer.swingItem();
                    aEg.thePlayer.setVelocity(aEg.thePlayer.motionX * 0.6, aEg.thePlayer.motionY, aEg.thePlayer.motionZ * 0.6);
                    aEg.thePlayer.onGround = false;
                    this.sV--;
                }

                if (this.sY) {
                    aEg.getNetHandler().addToSendQueue(new C0BPacketEntityAction(aEg.thePlayer, Action.STOP_SPRINTING));
                    this.sY = false;
                }
            }
        }
    };
    @EventLink
    public final Listener<MoveInputEvent> onMoveInput = var1x -> {
        if (aEg.thePlayer != null && this.u("Jump Reset") && aEg.thePlayer.onGround && this.sT == 1) {
            var1x.setJump(true);
            this.sT = 0;
            var1x.setForward(1.0F);
        }
    };

    public GrimTestVelocity(String var1, Velocity var2) {
        super(var1, var2);
    }

    @Override
    public void onEnable() {
        this.sX = System.currentTimeMillis();
    }

    @Override
    public void onDisable() {
        this.sS = false;
        this.sT = 0;
        this.pY = null;
        this.sU = 0.0;
        this.sV = 0;
        this.sW = false;
        this.sY = false;
        this.r(true);
    }

    private void r(boolean var1) {
        this.tc = false;
        if (var1) {
            BlinkComponent.dispatch();

            while (!this.tb.isEmpty()) {
                Packet packet = this.tb.poll();
                if (packet != null) {
                    PacketUtil.p(packet);
                }
            }
        } else {
            this.tb.clear();
        }

        this.td = null;
        this.tf = false;
        this.te = 0L;
    }

    private void t(String var1) {
        if (this.logging.wo() && this.delayLogging.wo()) {
            afi.d("%s", "[Delay] " + var1);
        }
    }

    private boolean h(float var1) {
        float f = Math.abs(var1 % 90.0F);
        return f < 0.01F || f > 89.99F;
    }

    private int gz() {
        int i = this.minAttacks.wo().intValue();
        int j = this.maxAttacks.wo().intValue();
        if (i < 1) {
            i = 1;
        }

        if (j < 1) {
            j = 1;
        }

        if (i > j) {
            int k = i;
            i = j;
            j = k;
        }

        if (i == j) {
            this.sZ = i;
            return i;
        }
        this.sZ = ThreadLocalRandom.current().nextInt(i, j + 1);
        return this.sZ;
    }

    private boolean gA() {
        if (aEg.thePlayer == null || aEg.theWorld == null) {
            return false;
        }

        if (aEg.thePlayer.isInWater() || aEg.thePlayer.isInLava()) {
            return true;
        }

        if (aEg.thePlayer.isOnLadder()) {
            return true;
        }

        BlockPos blockpos = aEg.thePlayer.getPosition();
        return aEg.theWorld.getBlockState(blockpos).getBlock() instanceof BlockWeb;
    }

    private boolean u(String var1) {
        return this.mode.wo() != null && this.mode.wo().getName().equalsIgnoreCase(var1);
    }
}
