package com.alan.clients.module.impl.movement.flight;

import com.alan.clients.module.impl.movement.Flight;
import com.alan.clients.newevent.CancellableEvent;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.motion.PushOutOfBlockEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.other.BlockAABBEvent;
import com.alan.clients.newevent.impl.other.TeleportEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.NumberValue;
import hackclient.rise.afi;
import hackclient.rise.ahj;
import hackclient.rise.aih;
import hackclient.rise.aka;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLeaves;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;

public class MiniBloxFlight extends Mode<Flight> {
    private final NumberValue Fs = new NumberValue("Speed", this, 5, 5, 9.5, 0.1);
    private aka Ft;
    private Vector2f ka;
    private static final int Fu = 50;
    private boolean zd;
    @EventLink
    public final Listener<PreMotionEvent> Fv = var1x -> {
        double d0 = Math.toRadians(aEg.thePlayer.pl);
        double d1 = Math.sin(d0);
        double d2 = Math.cos(d0);
        if (aEg.thePlayer.isCollidedHorizontally) {
            aEg.thePlayer.setPosition(aEg.thePlayer.posX - d1 * 0.005, aEg.thePlayer.posY, aEg.thePlayer.posZ + d2 * 0.005);
        } else if (aih.vk()) {
            ahj.m(new C04PacketPlayerPosition(aEg.thePlayer.posX - d1 * 9.5, aEg.thePlayer.posY, aEg.thePlayer.posZ + d2 * 9.5, true));
            aEg.thePlayer.motionX *= 0.3;
            aEg.thePlayer.motionZ *= 0.3;
        }

        if (aEg.thePlayer.ticksExisted % 20 == 0) {
            BlockPos blockpos = this.s(50);
            if (blockpos != null) {
                aEg.thePlayer.setPosition(blockpos.getX() + 0.5, blockpos.getY(), blockpos.getZ() + 0.5);
                this.zd = true;
            }
        } else if (this.zd) {
            this.zd = false;
        }

        float f = this.Fs.wo().floatValue();
        aEg.thePlayer.motionY = 0.0 + (aEg.gameSettings.keyBindJump.isKeyDown() ? f : 0.0) - (aEg.gameSettings.keyBindSneak.isKeyDown() ? f : 0.0);
    };
    @EventLink
    public final Listener<StrafeEvent> Fw = var1x -> {
        float f = this.Fs.wo().floatValue();
        var1x.setSpeed(f);
    };
    @EventLink
    public final Listener<TeleportEvent> Fx = var0 -> {};
    @EventLink
    public final Listener<PacketSendEvent> Fy = var0 -> {
        boolean flag = var0.dq() instanceof C03PacketPlayer;
    };
    @EventLink
    public final Listener<PushOutOfBlockEvent> Fz = CancellableEvent::setCancelled;
    @EventLink
    public final Listener<PreUpdateEvent> FA = var0 -> {};
    @EventLink
    public final Listener<BlockAABBEvent> FB = var0 -> {
        if (var0.df() instanceof BlockAir) {
            double d0 = var0.dg().getX();
            double d1 = var0.dg().getY();
            double d2 = var0.dg().getZ();
            if (d1 < aEg.thePlayer.posY) {
                var0.a(AxisAlignedBB.fromBounds(-15.0, -1.0, -15.0, 15.0, 1.0, 15.0).offset(d0, d1, d2));
            }
        }
    };

    public MiniBloxFlight(String var1, Flight var2) {
        super(var1, var2);
    }

    @Override
    public void onDisable() {
        MoveUtil.stop();
        BlockPos blockpos = this.s(50);
        if (blockpos != null) {
            aEg.thePlayer.setPosition(blockpos.getX() + 0.51, blockpos.getY(), blockpos.getZ() + 0.51);
        }

        double d0 = Math.toRadians(aEg.thePlayer.pl);
        Math.sin(d0);
        Math.cos(d0);
        aEg.timer.dzD = 0.2F;
    }

    @Override
    public void onEnable() {
        afi.b("try to clip through a block on disable");
        BlockPos blockpos = this.s(50);
        if (blockpos != null) {
            aEg.thePlayer.setPosition(blockpos.getX() + 0.51, blockpos.getY(), blockpos.getZ() + 0.51);
        }

        aEg.timer.dzD = 0.2F;
    }

    private BlockPos s(int var1) {
        double d0 = aEg.thePlayer.posX;
        double d1 = aEg.thePlayer.posY;
        double d2 = aEg.thePlayer.posZ;
        int i = MathHelper.floor_double(d1);
        double d3 = Double.MAX_VALUE;
        BlockPos blockpos = null;

        for (int j = -var1; j <= var1; j++) {
            for (int k = -var1; k <= var1; k++) {
                int l = MathHelper.floor_double(d0) + j;
                int i1 = MathHelper.floor_double(d2) + k;
                BlockPos blockpos1 = new BlockPos(l, i, i1);
                Block block = aEg.theWorld.getBlockState(blockpos1).getBlock();
                if (block.getMaterial().isSolid() && block.isFullBlock() && !(block instanceof BlockLeaves)) {
                    double d4 = aEg.thePlayer.getDistance(blockpos1.getX() + 0.5, blockpos1.getY(), blockpos1.getZ() + 0.5);
                    if (d4 < d3) {
                        d3 = d4;
                        blockpos = blockpos1;
                    }
                }
            }
        }

        return blockpos;
    }
}
