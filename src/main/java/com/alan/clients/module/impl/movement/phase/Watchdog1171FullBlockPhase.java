package com.alan.clients.module.impl.movement.phase;

import com.alan.clients.module.impl.movement.Phase;
import com.alan.clients.module.impl.player.Scaffold;
import com.alan.clients.newevent.CancellableEvent;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.MoveInputEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.motion.PushOutOfBlockEvent;
import com.alan.clients.newevent.impl.other.BlockAABBEvent;
import com.alan.clients.newevent.impl.other.MoveEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import hackclient.rise.ahj;
import hackclient.rise.aih;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockSnow;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;
import net.minecraft.network.play.client.C03PacketPlayer.C06PacketPlayerPosLook;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import rip.vantage.commons.util.time.a;

public class Watchdog1171FullBlockPhase extends Mode<Phase> {
    public final BooleanValue Ow = new BooleanValue("Smart Mode (if you want it to be always be toggled on)", this, false);
    public final BooleanValue Ox = new BooleanValue("Silent", this, false);
    private boolean Op;
    private final a Oy = new a();
    private boolean ys;
    private static final int Oz = 10;
    private static final double OA = Math.cos(Math.toRadians(130.0));
    @EventLink
    public final Listener<PreUpdateEvent> OB = var1x -> {
        AxisAlignedBB axisalignedbb = aEg.thePlayer.getEntityBoundingBox().expand(0.05, 0.0, 0.05);
        boolean flag = !aEg.theWorld.getCollidingBoundingBoxes(aEg.thePlayer, axisalignedbb).isEmpty();
        if ((
                (aEg.thePlayer.isCollidedHorizontally && this.Ox.wo() || aEg.thePlayer.isCollidedHorizontally && !this.Ox.wo())
                        && this.Op
                        && aEg.thePlayer.cqL > 2
                        && !aEg.gameSettings.keyBindJump.isKeyDown()
                        && !this.e(Scaffold.class).isEnabled()
                        && !(aEg.currentScreen instanceof GuiContainer)
                    || !this.Ow.wo() && flag && this.Op
            )
            && !aih.vk()) {
            this.Op = false;
            BlockPos blockpos = this.u(10);
            if (blockpos != null) {
                double d0 = blockpos.getX() + 0.5;
                double d1 = blockpos.getY();
                double d2 = blockpos.getZ() + 0.5;
                ahj.m(new C04PacketPlayerPosition(d0, d1, d2, aEg.thePlayer.onGround));
            } else {
                ahj.m(new C04PacketPlayerPosition(aEg.thePlayer.posX + 0.5, aEg.thePlayer.posY, aEg.thePlayer.posZ + 0.5, aEg.thePlayer.onGround));
            }
        }
    };
    @EventLink
    public final Listener<PacketReceiveEvent> OC = var1x -> {
        Packet packet = var1x.dq();
        if (packet instanceof S08PacketPlayerPosLook && !this.Op && (!this.Ox.wo() || aih.vk())) {
            S08PacketPlayerPosLook s08packetplayerposlook = (S08PacketPlayerPosLook)packet;
            var1x.setCancelled();
            double d0 = s08packetplayerposlook.getX();
            double d1 = s08packetplayerposlook.getY();
            double d2 = s08packetplayerposlook.getZ();
            float f = s08packetplayerposlook.getYaw();
            float f1 = s08packetplayerposlook.getPitch();
            this.Op = true;
            ahj.m(new C06PacketPlayerPosLook(d0, d1, d2, f, f1, aEg.thePlayer.onGround));
            if (!this.Ox.wo()) {
                aEg.thePlayer.setPosition(d0, d1, d2);
            }
        }
    };
    @EventLink
    public final Listener<MoveEvent> OD = var1x -> {
        if (!this.Op && !this.Ox.wo()) {
            var1x.setPosZ(0.0);
            var1x.setPosX(0.0);
        }
    };
    @EventLink
    public final Listener<BlockAABBEvent> OE = var1x -> {
        if (!this.Op && var1x.df() instanceof Block && this.Ox.wo()) {
            BlockPos blockpos = var1x.dg();
            BlockPos blockpos1 = new BlockPos(
                MathHelper.floor_double(aEg.thePlayer.posX),
                (int)(aEg.thePlayer.getEntityBoundingBox().minY - 0.49),
                MathHelper.floor_double(aEg.thePlayer.posZ)
            );
            if (!blockpos.equals(blockpos1) && this.Ox.wo()) {
                if (aih.vk()) {
                    MoveUtil.strafe(-0.1);
                }

                var1x.setCancelled();
            }
        }
    };
    @EventLink
    public final Listener<MoveInputEvent> OF = var1x -> {};
    @EventLink
    public final Listener<PushOutOfBlockEvent> OG = CancellableEvent::setCancelled;

    public Watchdog1171FullBlockPhase(String var1, Phase var2) {
        super(var1, var2);
    }

    private boolean e(double var1, double var3) {
        double d0 = aEg.thePlayer.posX;
        double d1 = aEg.thePlayer.posZ;
        double d2 = Math.toRadians(aEg.thePlayer.pl);
        double d3 = -Math.sin(d2);
        double d4 = Math.cos(d2);
        double d5 = var1 - d0;
        double d6 = var3 - d1;
        double d7 = d3 * d5 + d4 * d6;
        double d8 = Math.sqrt(d3 * d3 + d4 * d4);
        double d9 = Math.sqrt(d5 * d5 + d6 * d6);
        return d9 < 1.0E-8 ? false : d7 / (d8 * d9) <= OA;
    }

    private BlockPos u(int var1) {
        double d0 = aEg.thePlayer.posX;
        double d1 = aEg.thePlayer.posY;
        double d2 = aEg.thePlayer.posZ;
        int i = MathHelper.floor_double(d1);
        double d3 = Double.MAX_VALUE;
        BlockPos blockpos = null;

        for (int j = -var1; j <= var1; j++) {
            for (int k = -var1; k <= var1; k++) {
                for (int l = -var1; l <= var1; l++) {
                    int i1 = MathHelper.floor_double(d0) + j;
                    int j1 = i + k;
                    int k1 = MathHelper.floor_double(d2) + l;
                    BlockPos blockpos1 = new BlockPos(i1, j1, k1);
                    Block block = aEg.theWorld.getBlockState(blockpos1).getBlock();
                    if (block.getMaterial().isSolid() && block.isFullBlock() && !(block instanceof BlockLeaves) && !(block instanceof BlockSnow)) {
                        double d4 = aEg.thePlayer.getDistance(blockpos1.getX() + 0.5, blockpos1.getY() + 0.5, blockpos1.getZ() + 0.5);
                        if (d4 >= 1.0 && d4 <= 10.0 && this.e(blockpos1.getX() + 0.5, blockpos1.getZ() + 0.5) && d4 < d3) {
                            d3 = d4;
                            blockpos = blockpos1;
                        }
                    }
                }
            }
        }

        return blockpos;
    }

    @Override
    public void onEnable() {
        this.Op = true;
    }
}
