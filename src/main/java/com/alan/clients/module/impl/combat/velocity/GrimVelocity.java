package com.alan.clients.module.impl.combat.velocity;

import com.alan.clients.component.impl.player.BlinkComponent;
import com.alan.clients.component.impl.player.RotationComponent;
import com.alan.clients.component.impl.player.rotationcomponent.MovementFix;
import com.alan.clients.module.impl.combat.Velocity;
import com.alan.clients.module.impl.movement.Speed;
import com.alan.clients.module.impl.movement.speed.GrimSpeed;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.JumpEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.other.MoveEvent;
import com.alan.clients.newevent.impl.other.TickEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import com.viaversion.viabackwards.protocol.v1_19to1_18_2.Protocol1_19To1_18_2;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.packet.ServerboundPackets1_19;
import de.florianmichael.vialoadingbase.ViaLoadingBase;
import com.alan.clients.util.packet.PacketUtil;
import hackclient.rise.aka;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S14PacketEntity;
import net.minecraft.network.play.server.S23PacketBlockChange;
import net.minecraft.network.play.server.S32PacketConfirmTransaction;
import net.minecraft.network.play.server.ad;
import net.minecraft.network.play.server.z;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public final class GrimVelocity extends Mode<Velocity> {
    private final BooleanValue tL = new BooleanValue("Smart Combat (for High Ping)", this, false);
    private final BooleanValue rotations = new BooleanValue("Rotate", this, true);
    private int tN;
    private final Set<BlockPos> tO = new HashSet<>();
    private boolean tP = false;
    public static boolean dk;
    public static boolean dj = false;
    public static boolean tt;
    public static boolean tQ = false;
    public static float jq;
    public static float jp;
    private int tR;
    public static int tS;
    private final ArrayList<Packet<?>> tT = new ArrayList<>();
    private double tU;
    private final double tV = 0.03;
    private final double tW = 0.053299998353843775;
    private final double tX = 1.0;
    private int tY;
    private boolean tZ;
    private aka ua;
    private boolean gD;
    private float ub;
    private boolean uc;
    private double ud;
    private double ue;
    private double uf;
    private int ug;
    @EventLink
    public final Listener<PacketReceiveEvent> onPacketReceive = var1x -> {
        Speed speed = this.e(Speed.class);
        boolean flag = speed.isEnabled() && speed.hl().wo() instanceof GrimSpeed && ((GrimSpeed)speed.hl().wo()).fastFall.wo();
        if (!tt && aEg.thePlayer.Zl >= 7 && !aEg.thePlayer.isInWeb && !flag) {
            Packet<?> packet = var1x.getPacket();
            if (packet instanceof S12PacketEntityVelocity s12packetentityvelocity
                && s12packetentityvelocity.getEntityID() == aEg.thePlayer.getEntityId()) {
                if (aEg.thePlayer.onGround) {
                    this.tP = true;
                } else {
                    this.tT.add(s12packetentityvelocity);
                    dj = true;
                }

                var1x.setCancelled();
            }

            Packet<?> packet1 = var1x.getPacket();
            if (packet1 instanceof S32PacketConfirmTransaction s32packetconfirmtransaction && dj) {
                this.tT.add(s32packetconfirmtransaction);
                var1x.setCancelled();
            }

            Packet<?> packet2 = var1x.getPacket();
            if (packet2 instanceof z z1 && dj) {
                this.tT.add(z1);
                var1x.setCancelled();
            }

            Packet<?> packet3 = var1x.getPacket();
            if (packet3 instanceof S14PacketEntity s14packetentity && dj) {
                this.tT.add(s14packetentity);
                var1x.setCancelled();
            }

            Packet<?> packet4 = var1x.getPacket();
            if (packet4 instanceof ad ad1 && dj) {
                this.tT.add(ad1);
                var1x.setCancelled();
            }

            Packet<?> packet5 = var1x.getPacket();
            if (packet5 instanceof S08PacketPlayerPosLook s08packetplayerposlook && dj) {
                this.tT.add(s08packetplayerposlook);
                var1x.setCancelled();
            }

            Packet<?> packet6 = var1x.getPacket();
            if (packet6 instanceof S23PacketBlockChange s23packetblockchange) {
                BlockPos blockpos = s23packetblockchange.getBlockPosition();
                if (this.tO.remove(blockpos) && this.tO.isEmpty()) {
                    this.tP = false;
                    this.ug = 0;
                }
            }
        }
    };
    @EventLink
    public final Listener<MoveEvent> onMove = var1x -> {
        Speed speed = this.e(Speed.class);
        boolean flag = speed.isEnabled() && speed.hl().wo() instanceof GrimSpeed && ((GrimSpeed)speed.hl().wo()).fastFall.wo();
        if (aEg.thePlayer.Zl >= 7 && !aEg.thePlayer.isInWeb && !flag || !aEg.thePlayer.onGround) {
            if (this.tP) {
                var1x.setCancelled();
            }

            if (aEg.thePlayer.tR > 25 && dj) {
                dj = false;
                tt = true;
                this.tT.forEach(PacketUtil::p);
                this.tT.clear();
                tt = false;
            }
        } else if (!this.tT.isEmpty() || this.tP || dj) {
            tt = true;
            this.ug = 0;
            this.tP = false;
            this.tO.clear();
            dj = false;
            this.uc = false;
            this.tT.forEach(PacketUtil::p);
            this.tT.clear();
            tt = false;
        }
    };
    @EventLink
    public final Listener<StrafeEvent> onStrafe = var1x -> {
        Speed speed = this.e(Speed.class);
        boolean flag = speed.isEnabled() && speed.hl().wo() instanceof GrimSpeed && ((GrimSpeed)speed.hl().wo()).fastFall.wo();
        if (aEg.thePlayer.Zl >= 7 && !aEg.thePlayer.isInWeb) {
            if (aEg.thePlayer.cqL > 3 && aEg.thePlayer.onGround && dj) {
                aEg.thePlayer.jump();
            }

            if (this.tP) {
                if (!this.uc) {
                    this.ud = aEg.thePlayer.motionX;
                    this.ue = aEg.thePlayer.motionY;
                    this.uf = aEg.thePlayer.motionZ;
                    this.uc = true;
                }
            } else if (this.uc) {
                aEg.thePlayer.motionX = this.ud;
                aEg.thePlayer.motionY = this.ue;
                aEg.thePlayer.motionZ = this.uf;
                this.uc = false;
            }
        }
    };
    @EventLink
    public final Listener<JumpEvent> onJump = var1x -> {
        Speed speed = this.e(Speed.class);
        boolean flag = speed.isEnabled() && speed.hl().wo() instanceof GrimSpeed && ((GrimSpeed)speed.hl().wo()).fastFall.wo();
        if (aEg.thePlayer.Zl >= 7 && !aEg.thePlayer.isInWeb && !flag && aEg.thePlayer.onGround && dj) {
            this.tP = true;
            dj = false;
            tt = true;
            BlinkComponent.dispatch();
            Vector2d vector2d = new Vector2d(aEg.thePlayer.motionX, aEg.thePlayer.motionZ);
            double d0 = aEg.thePlayer.motionY;
            this.tT.forEach(PacketUtil::p);
            this.tT.clear();
            aEg.thePlayer.motionX = vector2d.getX();
            aEg.thePlayer.motionZ = vector2d.getY();
            aEg.thePlayer.motionY = d0;
            tt = false;
        }
    };
    @EventLink
    public final Listener<TickEvent> onTick = var1x -> {
        Speed speed = this.e(Speed.class);
        boolean flag = speed.isEnabled() && speed.hl().wo() instanceof GrimSpeed && ((GrimSpeed)speed.hl().wo()).fastFall.wo();
        if (this.tP && !flag) {
            BlockPos blockpos = new BlockPos(aEg.thePlayer);
            if (this.rotations.wo()) {
                tQ = true;
                if (!this.tL.wo()) {
                    RotationComponent.d(false);
                    RotationComponent.setRotations(
                        new Vector2f(aEg.thePlayer.pl, (float)(90.0 - Math.random() * 0.1)), 10.0, MovementFix.NORMAL
                    );
                }
            } else {
                tQ = false;
            }

            EnumFacing enumfacing = EnumFacing.UP;
            float f = (float)(aEg.thePlayer.posX - blockpos.getX());
            float f1 = 1.0F;
            float f2 = (float)(aEg.thePlayer.posZ - blockpos.getZ());
            BlockPos blockpos1 = blockpos.down();
            if (ViaLoadingBase.getInstance().getTargetVersion().newerThanOrEqualTo(ProtocolVersion.v1_19)) {
                UserConnection userconnection = Via.getManager().getConnectionManager().getConnections().iterator().next();
                PacketWrapper packetwrapper = PacketWrapper.create(ServerboundPackets1_19.USE_ITEM_ON, userconnection);
                packetwrapper.write(Types.VAR_INT, 0);
                packetwrapper.write(Types.BLOCK_POSITION1_14, new BlockPosition(blockpos1.getX(), blockpos1.getY(), blockpos1.getZ()));
                packetwrapper.write(Types.VAR_INT, enumfacing.ordinal());
                packetwrapper.write(Types.FLOAT, f);
                packetwrapper.write(Types.FLOAT, f1);
                packetwrapper.write(Types.FLOAT, f2);
                packetwrapper.write(Types.BOOLEAN, false);
                packetwrapper.write(Types.VAR_INT, aEg.playerController.GZ());
                packetwrapper.sendToServer(Protocol1_19To1_18_2.class);
            } else {
                aEg.thePlayer
                    .sendQueue
                    .addToSendQueue(
                        new C08PacketPlayerBlockPlacement(blockpos1, enumfacing.getIndex(), aEg.thePlayer.getHeldItem(), f, f1, f2)
                    );
            }

            this.tO.add(blockpos1);
        } else {
            tQ = false;
        }
    };

    public GrimVelocity(String var1, Velocity velocity) {
        super(var1, velocity);
    }

    @Override
    public void onDisable() {
        dk = false;
        tQ = false;
        this.tT.forEach(PacketUtil::p);
        this.tT.clear();
        dj = false;
    }

    @Override
    public void onEnable() {
        dk = false;
        tQ = false;
        this.tT.forEach(PacketUtil::p);
        this.tT.clear();
        dj = false;
        this.tP = false;
        this.tO.clear();
    }
}
