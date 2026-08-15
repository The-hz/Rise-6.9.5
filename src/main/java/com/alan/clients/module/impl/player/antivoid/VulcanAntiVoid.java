package com.alan.clients.module.impl.player.antivoid;

import com.alan.clients.module.impl.movement.Flight;
import com.alan.clients.module.impl.movement.LongJump;
import com.alan.clients.module.impl.movement.Speed;
import com.alan.clients.module.impl.player.AntiVoid;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.JumpEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.other.BlockAABBEvent;
import com.alan.clients.newevent.impl.other.WorldChangeEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.NumberValue;
import com.alan.clients.util.player.PlayerUtil;
import net.minecraft.block.BlockAir;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.util.AxisAlignedBB;

public class VulcanAntiVoid extends Mode<AntiVoid> {
    private final NumberValue distance = new NumberValue("Distance", this, 2.6, 0, 10, 0.1);
    private boolean zd;
    private boolean ahL;
    private Flight zm = null;
    private Speed uS = null;
    private LongJump ahM = null;
    private boolean ahN = false;
    private int zn;
    @EventLink
    public final Listener<PreMotionEvent> onPreMotionEvent = var1x -> {
        if (this.zm == null) {
            this.zm = this.e(Flight.class);
        }

        if (this.uS == null) {
            this.uS = this.e(Speed.class);
        }

        if (this.ahM == null) {
            this.ahM = this.e(LongJump.class);
        }

        if (aEg.thePlayer.fallDistance > this.distance.wo().floatValue() && !PlayerUtil.vh()) {
            this.ahL = true;
        }

        if (this.zm.isEnabled() || this.ahM.isEnabled()) {
            this.ahL = false;
        }

        if (this.uS.isEnabled() && this.ahL) {
            this.ahN = true;
            this.uS.toggle();
        }

        if (!this.ahL && !this.uS.isEnabled() && this.ahN) {
            this.uS.toggle();
            this.ahN = false;
        }
    };
    @EventLink
    public final Listener<BlockAABBEvent> onBlockAABB = var1x -> {
        if (var1x.getBlock() instanceof BlockAir && !aEg.thePlayer.isSneaking() && this.ahL) {
            double d0 = var1x.getBlockPos().getX();
            double d1 = var1x.getBlockPos().getY();
            double d2 = var1x.getBlockPos().getZ();
            if (d1 < aEg.thePlayer.posY) {
                var1x.setBoundingBox(AxisAlignedBB.fromBounds(-15.0, -1.0, -15.0, 15.0, 1.0, 15.0).offset(d0, d1, d2));
            }
        }

        if ((!(var1x.getBlock() instanceof BlockAir) || aEg.thePlayer.isSneaking()) && this.ahL && !aEg.thePlayer.isCollidedHorizontally) {
            this.ahL = false;
        }
    };
    @EventLink
    public final Listener<StrafeEvent> onStrafe = var1x -> {
        if (this.ahL) {
            MoveUtil.strafe(0.1);
            if (aEg.thePlayer.ticksExisted % 2 != 1 && aEg.thePlayer.moveForward == 0.0F) {
                MoveUtil.strafe(0.0);
                var1x.setForward(-1.0F);
            } else {
                var1x.setForward(1.0F);
            }
        }
    };
    @EventLink
    public final Listener<PacketReceiveEvent> onPacketReceive = var1x -> {
        Packet packet = var1x.getPacket();
        if (packet instanceof S08PacketPlayerPosLook) {
            this.ahL = false;
        }
    };
    @EventLink
    public final Listener<WorldChangeEvent> onWorldChange = var1x -> this.ahL = false;
    @EventLink
    public final Listener<JumpEvent> onJump = var1x -> {
        if (this.ahL) {
            var1x.setJumpMotion(0.0F);
        }
    };

    public VulcanAntiVoid(String var1, AntiVoid antiVoid) {
        super(var1, antiVoid);
    }
}
