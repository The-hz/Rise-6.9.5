package com.alan.clients.module.impl.movement.longjump;

import com.alan.clients.component.impl.player.BlinkComponent;
import com.alan.clients.module.impl.movement.LongJump;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.MoveInputEvent;
import com.alan.clients.newevent.impl.motion.JumpEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.other.MoveEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.newevent.impl.render.Render3DEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.NumberValue;
import hackclient.rise.afi;
import hackclient.rise.ahj;
import hackclient.rise.cg;
import hackclient.rise.ci;
import hackclient.rise.cl;
import hackclient.rise.gg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.potion.Potion;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import org.lwjgl.opengl.GL11;

public class Watchdog2LongJump extends Mode<LongJump>
{
    public static int hQ;
    public BooleanValue LT;
    public boolean LY;
    @EventLink
    public Listener<Render3DEvent> Mq;
    public static boolean LW;
    public static double Mi;
    public static int[] O0OoOO0OOOOO;
    public static boolean LX;
    public static Object[] fld_0oOOoOo0O00O_40;
    @EventLink
    public Listener<PreMotionEvent> Mo;
    public double Mh;
    public static Object[] o0Oo000O0oO;
    @EventLink
    public Listener<PreUpdateEvent> Mn;
    @EventLink
    public Listener<MoveEvent> Ml;
    public boolean Mc;
    @EventLink
    public Listener<JumpEvent> Mp;
    public double jy;
    public double Me;
    public static Object[] oO00O0OO0ooO;
    public NumberValue LV;
    public double Mf;
    @EventLink
    public Listener<MoveInputEvent> Mk;
    public List<BlockPos> Mb;
    @EventLink
    public Listener<StrafeEvent> Mm;
    public double Md;
    @EventLink
    public Listener<PacketReceiveEvent> Mj;
    public static int LZ;
    public static int Ma;
    public BooleanValue LU;
    public double Mg;
    public BooleanValue LS;

    @Override
    public void onDisable() {
        final double n = Watchdog2LongJump.aEg.thePlayer.posX - this.Md;
        final double n2 = Watchdog2LongJump.aEg.thePlayer.posY - this.Me;
        final double n3 = Watchdog2LongJump.aEg.thePlayer.posZ - this.Mf;
        final double sqrt = Math.sqrt(n * n + n2 * n2 + n3 * n3);
        Watchdog2LongJump.LW = false;
        this.LY = false;
        afi.b(Watchdog2LongJump.aEg.thePlayer.ae, new Object[0]);
        afi.c("Distance " + "traveled:" + " " + sqrt, new Object[0]);
        if (Watchdog2LongJump.aEg.thePlayer.onGround) {
            MoveUtil.stop();
        }
        this.Mb.clear();
        this.Mc = false;
    }

    public void hy() {
        long n = -1996028352194688054L;
        final long n2 = -6618392940758690381L;
        final long n3 = 5753357184221243133L;
        long n4 = 5379602857852028494L;
        this.Mb.clear();
        final long n5 = 128849018880L;
        final long n6 = n2;
        final long n7 = n6 ^ ((n5 ^ n6) & -1L << 32);
        final long n8 = -(int)(n7 >>> 32);
        final long n9 = n3;
        long n20;
        for (long n10 = n9 ^ ((n8 ^ n9) & -1L >>> 32); (int)n10 < (int)(n7 >>> 32); n10 = (n20 ^ ((n20 ^ n20 + 1) & -1L >>> -33 + Watchdog2LongJump.O0OoOO0OOOOO[154] + 121))) {
            final long n11 = (long)(-(int)(n7 >>> 32)) << 32;
            final long n12 = n4;
            for (n4 = (n12 ^ ((n11 ^ n12) & -1L << 32)); (int)(n4 >>> 32) < (int)(n7 >>> 32); n4 += 4294967296L) {
                final long n13 = -(int)(n7 >>> 32);
                final long n14 = n;
                long n19;
                for (n = (n14 ^ ((n13 ^ n14) & -1L >>> 32)); (int)n < (int)(n7 >>> 32); n = (n19 ^ ((n19 ^ n19 + 1) & -1L >>> 32))) {
                    final BlockPos blockPos = new BlockPos(Watchdog2LongJump.aEg.thePlayer.posX + (int)n10, Watchdog2LongJump.aEg.thePlayer.posY + (int)(n4 >>> 32), Watchdog2LongJump.aEg.thePlayer.posZ + (int)n);
                    final IBlockState blockState = Watchdog2LongJump.aEg.theWorld.getBlockState(blockPos);
                    final Block block = blockState.getBlock();
                    if (block != Blocks.air) {
                        final long n15 = 0L;
                        final long n16 = n;
                        n = (n16 ^ ((n15 ^ n16) & -1L << 32));
                        if (block instanceof BlockSlab) {
                            final long n17 = (long)(blockState.getProperties().containsKey(BlockSlab.HALF) ? 0 : 1) << 32;
                            final long n18 = n;
                            n = (n18 ^ ((n17 ^ n18) & -1L << 32));
                        }
                        if (block instanceof BlockStairs || block instanceof BlockSnow || (int)(n >>> 32) != 0) {
                            this.Mb.add(blockPos);
                        }
                    }
                    n19 = n;
                }
            }
            n20 = n10;
        }
        this.Mc = true;
    }

    public Watchdog2LongJump(final String s, final LongJump longJump) {
        super(s, longJump);
        this.LS = new BooleanValue("Timer", this, false);
        this.LT = new BooleanValue("Fly Mode", this, false);
        this.LU = new BooleanValue((String)Watchdog2LongJump.o0Oo000O0oO[10] + "ge Move", this, false);
        this.LV = new NumberValue("Delay Boost (go further with less he" + "ight)", this, 2, 0, 8, 1);
        this.Mb = new ArrayList<BlockPos>();
        this.Mc = false;
        this.Mj = (packetReceiveEvent -> {
            final Packet packet = packetReceiveEvent.dq();
            Objects.requireNonNull(packet);
            switch (packet) {
                case S12PacketEntityVelocity s12PacketEntityVelocity: {
                    if (!packetReceiveEvent.isCancelled() && s12PacketEntityVelocity.getEntityID() == Watchdog2LongJump.aEg.thePlayer.getEntityId()) {
                        Watchdog2LongJump.Mi = Math.hypot(s12PacketEntityVelocity.getMotionX() / 8000.0, s12PacketEntityVelocity.getMotionZ() / 8000.0);
                        if (Watchdog2LongJump.hQ > Watchdog2LongJump.LZ && Watchdog2LongJump.Mi > 0.0 && s12PacketEntityVelocity.getMotionY() / 8000.0 > 0.4) {
                            afi.c(MoveUtil.speed(), new Object[193 + Watchdog2LongJump.O0OoOO0OOOOO[336] - 112]);
                            MoveUtil.strafe(0.459999);
                            Watchdog2LongJump.aEg.thePlayer.motionY = s12PacketEntityVelocity.getMotionY() / 8000.0;
                            Watchdog2LongJump.aEg.thePlayer.ae = 0;
                            Watchdog2LongJump.LW = true;
                            afi.c(MoveUtil.speed(), new Object[0]);
                        }
                        else {
                            Watchdog2LongJump.LW = false;
                            cg.a("Watchdog Lon" + "gjump", "Bad knockback detected from the server... Cancelling and trying to save you from the v" + "oid", 5000);
                        }
                        packetReceiveEvent.setCancelled();
                        break;
                    }
                    else {
                        break;
                    }
                }
                default:
                    break;
            }
            return;
        });
        this.Mk = (moveInputEvent -> {
            if (Watchdog2LongJump.hQ < Watchdog2LongJump.Ma && Watchdog2LongJump.hQ > 7) {
                moveInputEvent.setForward(100.0f);
                moveInputEvent.setJump(false);
            }
            return;
        });
        this.Ml = (moveEvent -> {
            if (Watchdog2LongJump.hQ < Watchdog2LongJump.Ma && (Watchdog2LongJump.hQ > 7 || !this.LU.wo())) {
                moveEvent.setPosZ(0.0);
                moveEvent.setPosX(0.0);
            }
            return;
        });
        this.Mm = (p0 -> {
            if ((Watchdog2LongJump.aEg.thePlayer.posY > this.jy || Watchdog2LongJump.aEg.thePlayer.tR < 14) && this.LT.wo()) {
                cl.cn();
            }
            final int tr = Watchdog2LongJump.aEg.thePlayer.tR;
            MoveUtil.useDiagonalSpeed();
            if (Watchdog2LongJump.hQ < 8) {
                if (Watchdog2LongJump.aEg.thePlayer.onGround) {
                    MoveUtil.strafe();
                }
                if (Watchdog2LongJump.aEg.thePlayer.tR == 1) {
                    MoveUtil.strafe();
                    final EntityPlayerSP thePlayer = Watchdog2LongJump.aEg.thePlayer;
                    thePlayer.motionY += 0.05700000002980232;
                }
                if (Watchdog2LongJump.aEg.thePlayer.tR == 3) {
                    final EntityPlayerSP thePlayer2 = Watchdog2LongJump.aEg.thePlayer;
                    thePlayer2.motionY -= 0.13089999556541443;
                }
                if (Watchdog2LongJump.aEg.thePlayer.tR == 4) {
                    final EntityPlayerSP thePlayer3 = Watchdog2LongJump.aEg.thePlayer;
                    thePlayer3.motionY -= 0.2;
                }
            }
            return;
        });
        this.Mn = (p0 -> {
            if (Watchdog2LongJump.hQ > 44) {
                final int hq = Watchdog2LongJump.hQ;
            }
            return;
        });
        this.Mo = (preMotionEvent -> {
            final AxisAlignedBB axisAlignedBB = Watchdog2LongJump.aEg.thePlayer.getEntityBoundingBox();
            final WorldClient theWorld = Watchdog2LongJump.aEg.theWorld;
            double minX = axisAlignedBB.minX;
            final long n192 = -5169351316448240581L;
            long n = n192 ^ ((0L ^ n192) & -1L << 32);
            while (minX < axisAlignedBB.maxX) {
                double minZ = axisAlignedBB.minZ;
                while (minZ < axisAlignedBB.maxZ) {
                    final Block block = theWorld.getBlockState(new BlockPos(minX, axisAlignedBB.minY - 0.05, minZ)).getBlock();
                    if (block instanceof BlockStairs || block instanceof BlockSnow || (block instanceof BlockSlab && Math.abs(Watchdog2LongJump.aEg.thePlayer.posY - Math.round(Watchdog2LongJump.aEg.thePlayer.posY)) <= 0.03)) {
                        n = n ^ ((4294967296L ^ n) & -1L << 32);
                        break;
                    }
                    else {
                        minZ += 0.3;
                    }
                }
                if ((int)(n >>> 32) != 0) {
                    break;
                }
                else {
                    minX += 0.3;
                }
            }
            if ((int)(n >>> 32) != 0) {
                this.LY = true;
                Watchdog2LongJump.LZ = 35;
                Watchdog2LongJump.Ma = 34;
            }
            else if (Watchdog2LongJump.aEg.thePlayer.onGround) {
                Watchdog2LongJump.LZ = 67;
                Watchdog2LongJump.Ma = 66;
            }
            if (Watchdog2LongJump.aEg.thePlayer.tR > 10 && !MoveUtil.isMoving()) {
                MoveUtil.stop();
            }
            if (Watchdog2LongJump.hQ < 7) {
                this.Mg = Watchdog2LongJump.aEg.thePlayer.pl;
                this.Mh = Watchdog2LongJump.aEg.thePlayer.rotationPitch;
            }
            else if (Watchdog2LongJump.hQ > 8 && Watchdog2LongJump.hQ <= Watchdog2LongJump.LZ + this.LV.wo().intValue()) {
                Watchdog2LongJump.aEg.thePlayer.pl = (float)this.Mg;
            }
            preMotionEvent.setPitch((float)this.Mh);
            preMotionEvent.setYaw((float)this.Mg);
            final int hq2 = Watchdog2LongJump.hQ;
            if ((Watchdog2LongJump.aEg.thePlayer.onGround && ((Watchdog2LongJump.hQ > 67 && !this.LY) || (Watchdog2LongJump.hQ > 40 && this.LY))) || Watchdog2LongJump.aEg.thePlayer.Zl == 1) {
                MoveUtil.stop();
                this.wj().setEnabled(false);
            }
            if (this.LT.wo()) {
                Watchdog2LongJump.aEg.thePlayer.cameraYaw = 0.1f;
            }
            ++Watchdog2LongJump.hQ;
            if (Watchdog2LongJump.hQ < Watchdog2LongJump.LZ + this.LV.wo().intValue()) {
                BlinkComponent.a(500, true, true, true, true);
            }
            if (Watchdog2LongJump.hQ < Watchdog2LongJump.LZ) {
                if (Watchdog2LongJump.aEg.thePlayer.onGround) {
                    double n2;
                    if (this.LY) {
                        n2 = 34.0;
                    }
                    else {
                        n2 = 66.0;
                    }
                    ci.a((float)(Watchdog2LongJump.hQ / n2));
                }
                if (Watchdog2LongJump.aEg.thePlayer.onGround && Watchdog2LongJump.hQ > 3) {
                    if (!this.LY) {
                        preMotionEvent.setPosY(preMotionEvent.getPosY() + ((Watchdog2LongJump.hQ % 2 != 0) ? 0.0625 : (Math.random() / 5000.0)));
                    }
                    else {
                        preMotionEvent.setPosY(preMotionEvent.getPosY() + ((Watchdog2LongJump.hQ % 2 != 0) ? 0.14499999582767487 : (Math.random() / 5000.0)));
                    }
                    preMotionEvent.setOnGround(false);
                }
                if (Watchdog2LongJump.hQ == Watchdog2LongJump.Ma) {
                    if (!Watchdog2LongJump.aEg.thePlayer.isPotionActive(Potion.moveSpeed)) {
                        MoveUtil.strafe(MoveUtil.getAllowedHorizontalDistance() - 0.01);
                    }
                    else if (Watchdog2LongJump.aEg.thePlayer.getActivePotionEffect(Potion.moveSpeed).amplifier + 1 >= 2) {
                        MoveUtil.strafe(MoveUtil.getAllowedHorizontalDistance() - 0.01);
                    }
                    else {
                        MoveUtil.strafe(MoveUtil.getAllowedHorizontalDistance() - 0.045);
                    }
                    Watchdog2LongJump.aEg.thePlayer.jump();
                }
            }
            else if (Watchdog2LongJump.hQ == Watchdog2LongJump.LZ) {
                preMotionEvent.setPosY(preMotionEvent.getPosY() + 1.0E-13);
                ahj.l(new C03PacketPlayer(true));
                if (this.LS.wo()) {
                    Watchdog2LongJump.aEg.timer.dzD = 0.5f;
                }
                Watchdog2LongJump.LW = true;
            }
            final long n3 = (long)Watchdog2LongJump.aEg.thePlayer.ae << 32;
            final long n194 = -4809365704514670827L;
            final long n4 = n194 ^ ((n3 ^ n194) & -1L << 32);
            if ((((int)(n4 >>> 32) > 3 && (int)(n4 >>> 32) < 38) || ((int)(n4 >>> 32) > 37 && Watchdog2LongJump.aEg.thePlayer.motionY <= 0.0)) && Watchdog2LongJump.hQ > 40) {
                final EntityPlayerSP thePlayer4 = Watchdog2LongJump.aEg.thePlayer;
                thePlayer4.motionY += 0.0283;
            }
            switch ((int)(n4 >>> 32)) {
                case 1: {
                    final EntityPlayerSP thePlayer5 = Watchdog2LongJump.aEg.thePlayer;
                    thePlayer5.motionX *= 2.1;
                    final EntityPlayerSP thePlayer6 = Watchdog2LongJump.aEg.thePlayer;
                    thePlayer6.motionZ *= 2.1;
                }
                case 6: {
                    Watchdog2LongJump.aEg.thePlayer.motionY = 0.031;
                    break;
                }
                case 7: {
                    final EntityPlayerSP thePlayer7 = Watchdog2LongJump.aEg.thePlayer;
                    thePlayer7.motionX *= 1.02;
                    final EntityPlayerSP thePlayer8 = Watchdog2LongJump.aEg.thePlayer;
                    thePlayer8.motionZ *= 1.02;
                    Watchdog2LongJump.aEg.thePlayer.motionY = 0.01;
                    break;
                }
                case 8: {
                    final EntityPlayerSP thePlayer9 = Watchdog2LongJump.aEg.thePlayer;
                    thePlayer9.motionX *= 1.01;
                    final EntityPlayerSP thePlayer10 = Watchdog2LongJump.aEg.thePlayer;
                    thePlayer10.motionZ *= 1.01;
                    Watchdog2LongJump.aEg.thePlayer.motionY = 0.0;
                    break;
                }
                case 9: {
                    final EntityPlayerSP thePlayer11 = Watchdog2LongJump.aEg.thePlayer;
                    thePlayer11.motionY += 0.015;
                    break;
                }
                case 10: {
                    final EntityPlayerSP thePlayer12 = Watchdog2LongJump.aEg.thePlayer;
                    thePlayer12.motionX *= 1.12;
                    final EntityPlayerSP thePlayer13 = Watchdog2LongJump.aEg.thePlayer;
                    thePlayer13.motionZ *= 1.12;
                    final EntityPlayerSP thePlayer14 = Watchdog2LongJump.aEg.thePlayer;
                    thePlayer14.motionY += 0.015;
                    break;
                }
                case 11: {
                    Watchdog2LongJump.aEg.thePlayer.motionY = 0.0;
                    final EntityPlayerSP thePlayer15 = Watchdog2LongJump.aEg.thePlayer;
                    thePlayer15.motionX *= 1.04;
                    final EntityPlayerSP thePlayer16 = Watchdog2LongJump.aEg.thePlayer;
                    thePlayer16.motionZ *= 1.04;
                    break;
                }
                case 12: {
                    Watchdog2LongJump.aEg.thePlayer.motionY = 0.0;
                    final EntityPlayerSP thePlayer17 = Watchdog2LongJump.aEg.thePlayer;
                    thePlayer17.motionX *= 1.04;
                    final EntityPlayerSP thePlayer18 = Watchdog2LongJump.aEg.thePlayer;
                    thePlayer18.motionZ *= 1.04;
                    break;
                }
                case 13: {
                    final EntityPlayerSP thePlayer19 = Watchdog2LongJump.aEg.thePlayer;
                    thePlayer19.motionY += 0.01;
                    break;
                }
                case 14: {
                    final EntityPlayerSP thePlayer20 = Watchdog2LongJump.aEg.thePlayer;
                    thePlayer20.motionY += 0.015;
                    break;
                }
                case 15: {
                    final EntityPlayerSP thePlayer21 = Watchdog2LongJump.aEg.thePlayer;
                    thePlayer21.motionY += 0.01;
                    break;
                }
                case 18: {
                    final EntityPlayerSP thePlayer22 = Watchdog2LongJump.aEg.thePlayer;
                    thePlayer22.motionY += 0.032;
                    break;
                }
            }
            return;
        });
        this.Mp = (jumpEvent -> {
            if (Watchdog2LongJump.hQ > 45) {
                jumpEvent.setJumpMotion(0.42f);
            }
            return;
        });
        this.Mq = (p0 -> {
            if (!this.Mc) {
                this.hy();
            }
            this.b(gg.BLOOM).c(() -> {
                final Iterator iterator = this.Mb.iterator();
                while (iterator.hasNext()) {
                    final BlockPos blockPos = (BlockPos)iterator.next();
                    final AxisAlignedBB axisAlignedBB2 = new AxisAlignedBB(blockPos, blockPos.add(1, 1, 1));
                    if (!RenderUtil.isInViewFrustrum(axisAlignedBB2)) {
                        continue;
                    }
                    else {
                        GlStateManager.pushMatrix();
                        GlStateManager.pushAttrib();
                        GlStateManager.enableBlend();
                        GlStateManager.disableTexture2D();
                        GlStateManager.disableLighting();
                        GL11.glDepthMask(false);
                        RenderUtil.color(this.rz().rA());
                        RenderUtil.drawBoundingBox(axisAlignedBB2);
                        GlStateManager.enableTexture2D();
                        GlStateManager.enableLighting();
                        GlStateManager.disableBlend();
                        GL11.glDepthMask(true);
                        GlStateManager.popAttrib();
                        GlStateManager.popMatrix();
                        GlStateManager.resetColor();
                    }
                }
            });
        });
    }

    public static void Oo0o00000O00() {
        (Watchdog2LongJump.O0OoOO0OOOOO = new int[400])[35] = 99;
        Watchdog2LongJump.O0OoOO0OOOOO[37] = 6;
        Watchdog2LongJump.O0OoOO0OOOOO[240] = -35;
        Watchdog2LongJump.O0OoOO0OOOOO[79] = -119;
        Watchdog2LongJump.O0OoOO0OOOOO[289] = -13;
        Watchdog2LongJump.O0OoOO0OOOOO[293] = -32;
        Watchdog2LongJump.O0OoOO0OOOOO[181] = -19;
        Watchdog2LongJump.O0OoOO0OOOOO[65] = -11;
        Watchdog2LongJump.O0OoOO0OOOOO[264] = -156;
        Watchdog2LongJump.O0OoOO0OOOOO[135] = -93;
        Watchdog2LongJump.O0OoOO0OOOOO[167] = -27;
        Watchdog2LongJump.O0OoOO0OOOOO[106] = -20;
        Watchdog2LongJump.O0OoOO0OOOOO[272] = 22;
        Watchdog2LongJump.O0OoOO0OOOOO[115] = -114;
        Watchdog2LongJump.O0OoOO0OOOOO[322] = -107;
        Watchdog2LongJump.O0OoOO0OOOOO[32] = 39;
        Watchdog2LongJump.O0OoOO0OOOOO[271] = 100;
        Watchdog2LongJump.O0OoOO0OOOOO[179] = 87;
        Watchdog2LongJump.O0OoOO0OOOOO[251] = -78;
        Watchdog2LongJump.O0OoOO0OOOOO[250] = 108;
        Watchdog2LongJump.O0OoOO0OOOOO[254] = 95;
        Watchdog2LongJump.O0OoOO0OOOOO[68] = -16;
        Watchdog2LongJump.O0OoOO0OOOOO[170] = 2;
        Watchdog2LongJump.O0OoOO0OOOOO[9] = 69;
        Watchdog2LongJump.O0OoOO0OOOOO[17] = -78;
        Watchdog2LongJump.O0OoOO0OOOOO[176] = -76;
        Watchdog2LongJump.O0OoOO0OOOOO[314] = -67;
        Watchdog2LongJump.O0OoOO0OOOOO[72] = 218;
        Watchdog2LongJump.O0OoOO0OOOOO[334] = -87;
        Watchdog2LongJump.O0OoOO0OOOOO[151] = 1;
        Watchdog2LongJump.O0OoOO0OOOOO[50] = -89;
        Watchdog2LongJump.O0OoOO0OOOOO[156] = 95;
        Watchdog2LongJump.O0OoOO0OOOOO[192] = -77;
        Watchdog2LongJump.O0OoOO0OOOOO[350] = -109;
        Watchdog2LongJump.O0OoOO0OOOOO[15] = -131;
        Watchdog2LongJump.O0OoOO0OOOOO[345] = 120;
        Watchdog2LongJump.O0OoOO0OOOOO[36] = 14;
        Watchdog2LongJump.O0OoOO0OOOOO[373] = -43;
        Watchdog2LongJump.O0OoOO0OOOOO[311] = 74;
        Watchdog2LongJump.O0OoOO0OOOOO[295] = 55;
        Watchdog2LongJump.O0OoOO0OOOOO[380] = 0;
        Watchdog2LongJump.O0OoOO0OOOOO[214] = -58;
        Watchdog2LongJump.O0OoOO0OOOOO[38] = -7;
        Watchdog2LongJump.O0OoOO0OOOOO[89] = -96;
        Watchdog2LongJump.O0OoOO0OOOOO[150] = -34;
        Watchdog2LongJump.O0OoOO0OOOOO[12] = 62;
        Watchdog2LongJump.O0OoOO0OOOOO[51] = -38;
        Watchdog2LongJump.O0OoOO0OOOOO[369] = 90;
        Watchdog2LongJump.O0OoOO0OOOOO[255] = -42;
        Watchdog2LongJump.O0OoOO0OOOOO[145] = -113;
        Watchdog2LongJump.O0OoOO0OOOOO[129] = 108;
        Watchdog2LongJump.O0OoOO0OOOOO[201] = 73;
        Watchdog2LongJump.O0OoOO0OOOOO[360] = -72;
        Watchdog2LongJump.O0OoOO0OOOOO[155] = -121;
        Watchdog2LongJump.O0OoOO0OOOOO[199] = -124;
        Watchdog2LongJump.O0OoOO0OOOOO[6] = -137;
        Watchdog2LongJump.O0OoOO0OOOOO[342] = 8;
        Watchdog2LongJump.O0OoOO0OOOOO[85] = -21;
        Watchdog2LongJump.O0OoOO0OOOOO[377] = 0;
        Watchdog2LongJump.O0OoOO0OOOOO[288] = -34;
        Watchdog2LongJump.O0OoOO0OOOOO[340] = 89;
        Watchdog2LongJump.O0OoOO0OOOOO[177] = 42;
        Watchdog2LongJump.O0OoOO0OOOOO[108] = -199;
        Watchdog2LongJump.O0OoOO0OOOOO[310] = -83;
        Watchdog2LongJump.O0OoOO0OOOOO[109] = -81;
        Watchdog2LongJump.O0OoOO0OOOOO[245] = 119;
        Watchdog2LongJump.O0OoOO0OOOOO[165] = -47;
        Watchdog2LongJump.O0OoOO0OOOOO[372] = -113;
        Watchdog2LongJump.O0OoOO0OOOOO[171] = -27;
        Watchdog2LongJump.O0OoOO0OOOOO[142] = -106;
        Watchdog2LongJump.O0OoOO0OOOOO[91] = -24;
        Watchdog2LongJump.O0OoOO0OOOOO[160] = 1;
        Watchdog2LongJump.O0OoOO0OOOOO[163] = -22;
        Watchdog2LongJump.O0OoOO0OOOOO[219] = -25;
        Watchdog2LongJump.O0OoOO0OOOOO[233] = 6;
        Watchdog2LongJump.O0OoOO0OOOOO[107] = 123;
        Watchdog2LongJump.O0OoOO0OOOOO[66] = 49;
        Watchdog2LongJump.O0OoOO0OOOOO[247] = 51;
        Watchdog2LongJump.O0OoOO0OOOOO[232] = -82;
        Watchdog2LongJump.O0OoOO0OOOOO[224] = 124;
        Watchdog2LongJump.O0OoOO0OOOOO[356] = -20;
        Watchdog2LongJump.O0OoOO0OOOOO[368] = -169;
        Watchdog2LongJump.O0OoOO0OOOOO[387] = 14636;
        Watchdog2LongJump.O0OoOO0OOOOO[101] = 40;
        Watchdog2LongJump.O0OoOO0OOOOO[277] = 56;
        Watchdog2LongJump.O0OoOO0OOOOO[381] = 364;
        Watchdog2LongJump.O0OoOO0OOOOO[348] = 70;
        Watchdog2LongJump.O0OoOO0OOOOO[229] = -84;
        Watchdog2LongJump.O0OoOO0OOOOO[211] = 42;
        Watchdog2LongJump.O0OoOO0OOOOO[394] = 6751;
        Watchdog2LongJump.O0OoOO0OOOOO[305] = -176;
        Watchdog2LongJump.O0OoOO0OOOOO[90] = -138;
        Watchdog2LongJump.O0OoOO0OOOOO[379] = 0;
        Watchdog2LongJump.O0OoOO0OOOOO[221] = -28;
        Watchdog2LongJump.O0OoOO0OOOOO[105] = -71;
        Watchdog2LongJump.O0OoOO0OOOOO[1] = 68;
        Watchdog2LongJump.O0OoOO0OOOOO[195] = -64;
        Watchdog2LongJump.O0OoOO0OOOOO[374] = 3;
        Watchdog2LongJump.O0OoOO0OOOOO[395] = 0;
        Watchdog2LongJump.O0OoOO0OOOOO[2] = -54;
        Watchdog2LongJump.O0OoOO0OOOOO[55] = -124;
        Watchdog2LongJump.O0OoOO0OOOOO[54] = 92;
        Watchdog2LongJump.O0OoOO0OOOOO[104] = -115;
        Watchdog2LongJump.O0OoOO0OOOOO[275] = 113;
        Watchdog2LongJump.O0OoOO0OOOOO[341] = -99;
        Watchdog2LongJump.O0OoOO0OOOOO[28] = 82;
        Watchdog2LongJump.O0OoOO0OOOOO[359] = 33;
        Watchdog2LongJump.O0OoOO0OOOOO[337] = -112;
        Watchdog2LongJump.O0OoOO0OOOOO[26] = 111;
        Watchdog2LongJump.O0OoOO0OOOOO[74] = 95;
        Watchdog2LongJump.O0OoOO0OOOOO[213] = -131;
        Watchdog2LongJump.O0OoOO0OOOOO[44] = 77;
        Watchdog2LongJump.O0OoOO0OOOOO[144] = -162;
        Watchdog2LongJump.O0OoOO0OOOOO[316] = 42;
        Watchdog2LongJump.O0OoOO0OOOOO[218] = -57;
        Watchdog2LongJump.O0OoOO0OOOOO[124] = 78;
        Watchdog2LongJump.O0OoOO0OOOOO[230] = -52;
        Watchdog2LongJump.O0OoOO0OOOOO[383] = 8611;
        Watchdog2LongJump.O0OoOO0OOOOO[45] = 10;
        Watchdog2LongJump.O0OoOO0OOOOO[346] = -57;
        Watchdog2LongJump.O0OoOO0OOOOO[139] = -123;
        Watchdog2LongJump.O0OoOO0OOOOO[318] = -41;
        Watchdog2LongJump.O0OoOO0OOOOO[287] = -20;
        Watchdog2LongJump.O0OoOO0OOOOO[331] = 15;
        Watchdog2LongJump.O0OoOO0OOOOO[159] = -85;
        Watchdog2LongJump.O0OoOO0OOOOO[265] = -78;
        Watchdog2LongJump.O0OoOO0OOOOO[343] = -107;
        Watchdog2LongJump.O0OoOO0OOOOO[173] = -85;
        Watchdog2LongJump.O0OoOO0OOOOO[244] = 117;
        Watchdog2LongJump.O0OoOO0OOOOO[178] = 97;
        Watchdog2LongJump.O0OoOO0OOOOO[385] = 7050;
        Watchdog2LongJump.O0OoOO0OOOOO[309] = -33;
        Watchdog2LongJump.O0OoOO0OOOOO[136] = 2;
        Watchdog2LongJump.O0OoOO0OOOOO[40] = -70;
        Watchdog2LongJump.O0OoOO0OOOOO[353] = -25;
        Watchdog2LongJump.O0OoOO0OOOOO[21] = 31;
        Watchdog2LongJump.O0OoOO0OOOOO[298] = -12;
        Watchdog2LongJump.O0OoOO0OOOOO[215] = -12;
        Watchdog2LongJump.O0OoOO0OOOOO[123] = 49;
        Watchdog2LongJump.O0OoOO0OOOOO[149] = 52;
        Watchdog2LongJump.O0OoOO0OOOOO[87] = 223;
        Watchdog2LongJump.O0OoOO0OOOOO[7] = 102;
        Watchdog2LongJump.O0OoOO0OOOOO[117] = 54;
        Watchdog2LongJump.O0OoOO0OOOOO[147] = 19;
        Watchdog2LongJump.O0OoOO0OOOOO[399] = -159;
        Watchdog2LongJump.O0OoOO0OOOOO[270] = 68;
        Watchdog2LongJump.O0OoOO0OOOOO[313] = 106;
        Watchdog2LongJump.O0OoOO0OOOOO[236] = 63;
        Watchdog2LongJump.O0OoOO0OOOOO[234] = -6;
        Watchdog2LongJump.O0OoOO0OOOOO[324] = 87;
        Watchdog2LongJump.O0OoOO0OOOOO[78] = -109;
        Watchdog2LongJump.O0OoOO0OOOOO[19] = -120;
        Watchdog2LongJump.O0OoOO0OOOOO[53] = 125;
        Watchdog2LongJump.O0OoOO0OOOOO[57] = 142;
        Watchdog2LongJump.O0OoOO0OOOOO[382] = 59138;
        Watchdog2LongJump.O0OoOO0OOOOO[204] = -81;
        Watchdog2LongJump.O0OoOO0OOOOO[252] = 85;
        Watchdog2LongJump.O0OoOO0OOOOO[282] = 107;
        Watchdog2LongJump.O0OoOO0OOOOO[371] = -60;
        Watchdog2LongJump.O0OoOO0OOOOO[157] = -110;
        Watchdog2LongJump.O0OoOO0OOOOO[354] = -58;
        Watchdog2LongJump.O0OoOO0OOOOO[335] = 193;
        Watchdog2LongJump.O0OoOO0OOOOO[358] = -11;
        Watchdog2LongJump.O0OoOO0OOOOO[302] = -204;
        Watchdog2LongJump.O0OoOO0OOOOO[384] = 26118;
        Watchdog2LongJump.O0OoOO0OOOOO[154] = -56;
        Watchdog2LongJump.O0OoOO0OOOOO[23] = -23;
        Watchdog2LongJump.O0OoOO0OOOOO[27] = 157;
        Watchdog2LongJump.O0OoOO0OOOOO[336] = -81;
        Watchdog2LongJump.O0OoOO0OOOOO[18] = -245;
        Watchdog2LongJump.O0OoOO0OOOOO[196] = -35;
        Watchdog2LongJump.O0OoOO0OOOOO[43] = -97;
        Watchdog2LongJump.O0OoOO0OOOOO[100] = 102;
        Watchdog2LongJump.O0OoOO0OOOOO[253] = 10;
        Watchdog2LongJump.O0OoOO0OOOOO[242] = -5;
        Watchdog2LongJump.O0OoOO0OOOOO[273] = 17;
        Watchdog2LongJump.O0OoOO0OOOOO[398] = 52;
        Watchdog2LongJump.O0OoOO0OOOOO[132] = 182;
        Watchdog2LongJump.O0OoOO0OOOOO[16] = -59;
        Watchdog2LongJump.O0OoOO0OOOOO[95] = -87;
        Watchdog2LongJump.O0OoOO0OOOOO[323] = -54;
        Watchdog2LongJump.O0OoOO0OOOOO[209] = -93;
        Watchdog2LongJump.O0OoOO0OOOOO[180] = 72;
        Watchdog2LongJump.O0OoOO0OOOOO[243] = 239;
        Watchdog2LongJump.O0OoOO0OOOOO[93] = -84;
        Watchdog2LongJump.O0OoOO0OOOOO[59] = 104;
        Watchdog2LongJump.O0OoOO0OOOOO[222] = -103;
        Watchdog2LongJump.O0OoOO0OOOOO[320] = -9;
        Watchdog2LongJump.O0OoOO0OOOOO[134] = -93;
        Watchdog2LongJump.O0OoOO0OOOOO[390] = 33203;
        Watchdog2LongJump.O0OoOO0OOOOO[182] = -59;
        Watchdog2LongJump.O0OoOO0OOOOO[3] = 31;
        Watchdog2LongJump.O0OoOO0OOOOO[227] = 50;
        Watchdog2LongJump.O0OoOO0OOOOO[268] = 19;
        Watchdog2LongJump.O0OoOO0OOOOO[41] = 12;
        Watchdog2LongJump.O0OoOO0OOOOO[190] = -115;
        Watchdog2LongJump.O0OoOO0OOOOO[352] = 43;
        Watchdog2LongJump.O0OoOO0OOOOO[69] = 118;
        Watchdog2LongJump.O0OoOO0OOOOO[0] = 18;
        Watchdog2LongJump.O0OoOO0OOOOO[25] = -11;
        Watchdog2LongJump.O0OoOO0OOOOO[11] = 53;
        Watchdog2LongJump.O0OoOO0OOOOO[203] = -89;
        Watchdog2LongJump.O0OoOO0OOOOO[146] = -50;
        Watchdog2LongJump.O0OoOO0OOOOO[364] = 19;
        Watchdog2LongJump.O0OoOO0OOOOO[118] = 52;
        Watchdog2LongJump.O0OoOO0OOOOO[80] = -13;
        Watchdog2LongJump.O0OoOO0OOOOO[376] = 1;
        Watchdog2LongJump.O0OoOO0OOOOO[388] = 30834;
        Watchdog2LongJump.O0OoOO0OOOOO[258] = -16;
        Watchdog2LongJump.O0OoOO0OOOOO[75] = 22;
        Watchdog2LongJump.O0OoOO0OOOOO[338] = 8;
        Watchdog2LongJump.O0OoOO0OOOOO[168] = -80;
        Watchdog2LongJump.O0OoOO0OOOOO[152] = 36;
        Watchdog2LongJump.O0OoOO0OOOOO[300] = 55;
        Watchdog2LongJump.O0OoOO0OOOOO[103] = -50;
        Watchdog2LongJump.O0OoOO0OOOOO[153] = -33;
        Watchdog2LongJump.O0OoOO0OOOOO[378] = 2;
        Watchdog2LongJump.O0OoOO0OOOOO[363] = 98;
        Watchdog2LongJump.O0OoOO0OOOOO[278] = -124;
        Watchdog2LongJump.O0OoOO0OOOOO[184] = 20;
        Watchdog2LongJump.O0OoOO0OOOOO[5] = 26;
        Watchdog2LongJump.O0OoOO0OOOOO[186] = 89;
        Watchdog2LongJump.O0OoOO0OOOOO[393] = 60383;
        Watchdog2LongJump.O0OoOO0OOOOO[82] = -4;
        Watchdog2LongJump.O0OoOO0OOOOO[202] = 100;
        Watchdog2LongJump.O0OoOO0OOOOO[143] = -59;
        Watchdog2LongJump.O0OoOO0OOOOO[339] = 81;
        Watchdog2LongJump.O0OoOO0OOOOO[267] = 59;
        Watchdog2LongJump.O0OoOO0OOOOO[102] = 99;
        Watchdog2LongJump.O0OoOO0OOOOO[34] = -84;
        Watchdog2LongJump.O0OoOO0OOOOO[185] = 13;
        Watchdog2LongJump.O0OoOO0OOOOO[347] = 39;
        Watchdog2LongJump.O0OoOO0OOOOO[330] = 32;
        Watchdog2LongJump.O0OoOO0OOOOO[77] = -77;
        Watchdog2LongJump.O0OoOO0OOOOO[97] = 114;
        Watchdog2LongJump.O0OoOO0OOOOO[67] = 33;
        Watchdog2LongJump.O0OoOO0OOOOO[325] = 26;
        Watchdog2LongJump.O0OoOO0OOOOO[223] = 21;
        Watchdog2LongJump.O0OoOO0OOOOO[116] = 84;
        Watchdog2LongJump.O0OoOO0OOOOO[328] = 75;
        Watchdog2LongJump.O0OoOO0OOOOO[307] = 106;
        Watchdog2LongJump.O0OoOO0OOOOO[198] = -168;
        Watchdog2LongJump.O0OoOO0OOOOO[137] = -127;
        Watchdog2LongJump.O0OoOO0OOOOO[94] = -37;
        Watchdog2LongJump.O0OoOO0OOOOO[294] = 119;
        Watchdog2LongJump.O0OoOO0OOOOO[8] = -42;
        Watchdog2LongJump.O0OoOO0OOOOO[98] = 28;
        Watchdog2LongJump.O0OoOO0OOOOO[121] = 102;
        Watchdog2LongJump.O0OoOO0OOOOO[259] = 73;
        Watchdog2LongJump.O0OoOO0OOOOO[357] = 39;
        Watchdog2LongJump.O0OoOO0OOOOO[122] = 13;
        Watchdog2LongJump.O0OoOO0OOOOO[47] = -78;
        Watchdog2LongJump.O0OoOO0OOOOO[386] = 50122;
        Watchdog2LongJump.O0OoOO0OOOOO[326] = -1;
        Watchdog2LongJump.O0OoOO0OOOOO[128] = 63;
        Watchdog2LongJump.O0OoOO0OOOOO[42] = 171;
        Watchdog2LongJump.O0OoOO0OOOOO[189] = 72;
        Watchdog2LongJump.O0OoOO0OOOOO[125] = -95;
        Watchdog2LongJump.O0OoOO0OOOOO[33] = -57;
        Watchdog2LongJump.O0OoOO0OOOOO[306] = -71;
        Watchdog2LongJump.O0OoOO0OOOOO[281] = 97;
        Watchdog2LongJump.O0OoOO0OOOOO[206] = 76;
        Watchdog2LongJump.O0OoOO0OOOOO[286] = 79;
        Watchdog2LongJump.O0OoOO0OOOOO[161] = -87;
        Watchdog2LongJump.O0OoOO0OOOOO[231] = -87;
        Watchdog2LongJump.O0OoOO0OOOOO[64] = -70;
        Watchdog2LongJump.O0OoOO0OOOOO[344] = -62;
        Watchdog2LongJump.O0OoOO0OOOOO[332] = -123;
        Watchdog2LongJump.O0OoOO0OOOOO[304] = -94;
        Watchdog2LongJump.O0OoOO0OOOOO[61] = -123;
        Watchdog2LongJump.O0OoOO0OOOOO[367] = -109;
        Watchdog2LongJump.O0OoOO0OOOOO[276] = 54;
        Watchdog2LongJump.O0OoOO0OOOOO[303] = 124;
        Watchdog2LongJump.O0OoOO0OOOOO[315] = 112;
        Watchdog2LongJump.O0OoOO0OOOOO[127] = -97;
        Watchdog2LongJump.O0OoOO0OOOOO[283] = -48;
        Watchdog2LongJump.O0OoOO0OOOOO[257] = -30;
        Watchdog2LongJump.O0OoOO0OOOOO[366] = -69;
        Watchdog2LongJump.O0OoOO0OOOOO[48] = -172;
        Watchdog2LongJump.O0OoOO0OOOOO[24] = 119;
        Watchdog2LongJump.O0OoOO0OOOOO[207] = 67;
        Watchdog2LongJump.O0OoOO0OOOOO[308] = 58;
        Watchdog2LongJump.O0OoOO0OOOOO[4] = 5;
        Watchdog2LongJump.O0OoOO0OOOOO[138] = -102;
        Watchdog2LongJump.O0OoOO0OOOOO[261] = 7;
        Watchdog2LongJump.O0OoOO0OOOOO[49] = -83;
        Watchdog2LongJump.O0OoOO0OOOOO[131] = 78;
        Watchdog2LongJump.O0OoOO0OOOOO[141] = 79;
        Watchdog2LongJump.O0OoOO0OOOOO[396] = 135;
        Watchdog2LongJump.O0OoOO0OOOOO[210] = 98;
        Watchdog2LongJump.O0OoOO0OOOOO[208] = -23;
        Watchdog2LongJump.O0OoOO0OOOOO[351] = 66;
        Watchdog2LongJump.O0OoOO0OOOOO[174] = 218;
        Watchdog2LongJump.O0OoOO0OOOOO[39] = 78;
        Watchdog2LongJump.O0OoOO0OOOOO[225] = 3;
        Watchdog2LongJump.O0OoOO0OOOOO[193] = -66;
        Watchdog2LongJump.O0OoOO0OOOOO[126] = 66;
        Watchdog2LongJump.O0OoOO0OOOOO[96] = 78;
        Watchdog2LongJump.O0OoOO0OOOOO[284] = -2;
        Watchdog2LongJump.O0OoOO0OOOOO[188] = -13;
        Watchdog2LongJump.O0OoOO0OOOOO[22] = -1;
        Watchdog2LongJump.O0OoOO0OOOOO[260] = -91;
        Watchdog2LongJump.O0OoOO0OOOOO[112] = -103;
        Watchdog2LongJump.O0OoOO0OOOOO[14] = 34;
        Watchdog2LongJump.O0OoOO0OOOOO[389] = 26739;
        Watchdog2LongJump.O0OoOO0OOOOO[327] = -76;
        Watchdog2LongJump.O0OoOO0OOOOO[162] = 3;
        Watchdog2LongJump.O0OoOO0OOOOO[220] = -2;
        Watchdog2LongJump.O0OoOO0OOOOO[13] = 18;
        Watchdog2LongJump.O0OoOO0OOOOO[375] = 0;
        Watchdog2LongJump.O0OoOO0OOOOO[279] = -17;
        Watchdog2LongJump.O0OoOO0OOOOO[237] = -116;
        Watchdog2LongJump.O0OoOO0OOOOO[110] = -118;
        Watchdog2LongJump.O0OoOO0OOOOO[46] = 69;
        Watchdog2LongJump.O0OoOO0OOOOO[228] = 532;
        Watchdog2LongJump.O0OoOO0OOOOO[70] = -89;
        Watchdog2LongJump.O0OoOO0OOOOO[88] = 95;
        Watchdog2LongJump.O0OoOO0OOOOO[299] = -95;
        Watchdog2LongJump.O0OoOO0OOOOO[355] = -31;
        Watchdog2LongJump.O0OoOO0OOOOO[200] = -111;
        Watchdog2LongJump.O0OoOO0OOOOO[166] = 53;
        Watchdog2LongJump.O0OoOO0OOOOO[365] = 5024;
        Watchdog2LongJump.O0OoOO0OOOOO[296] = -107;
        Watchdog2LongJump.O0OoOO0OOOOO[30] = -4;
        Watchdog2LongJump.O0OoOO0OOOOO[10] = 16;
        Watchdog2LongJump.O0OoOO0OOOOO[269] = -8;
        Watchdog2LongJump.O0OoOO0OOOOO[391] = 22549;
        Watchdog2LongJump.O0OoOO0OOOOO[217] = -18;
        Watchdog2LongJump.O0OoOO0OOOOO[111] = -16;
        Watchdog2LongJump.O0OoOO0OOOOO[63] = 59;
        Watchdog2LongJump.O0OoOO0OOOOO[172] = -113;
        Watchdog2LongJump.O0OoOO0OOOOO[274] = 7;
        Watchdog2LongJump.O0OoOO0OOOOO[216] = 1;
        Watchdog2LongJump.O0OoOO0OOOOO[158] = -16;
        Watchdog2LongJump.O0OoOO0OOOOO[329] = 15;
        Watchdog2LongJump.O0OoOO0OOOOO[290] = -80;
        Watchdog2LongJump.O0OoOO0OOOOO[73] = 109;
        Watchdog2LongJump.O0OoOO0OOOOO[317] = 66;
        Watchdog2LongJump.O0OoOO0OOOOO[321] = 101;
        Watchdog2LongJump.O0OoOO0OOOOO[169] = 82;
        Watchdog2LongJump.O0OoOO0OOOOO[58] = -38;
        Watchdog2LongJump.O0OoOO0OOOOO[362] = 125;
        Watchdog2LongJump.O0OoOO0OOOOO[20] = 125;
        Watchdog2LongJump.O0OoOO0OOOOO[191] = 60;
        Watchdog2LongJump.O0OoOO0OOOOO[81] = 26;
        Watchdog2LongJump.O0OoOO0OOOOO[312] = 33;
        Watchdog2LongJump.O0OoOO0OOOOO[164] = -24;
        Watchdog2LongJump.O0OoOO0OOOOO[140] = 63;
        Watchdog2LongJump.O0OoOO0OOOOO[235] = 56;
        Watchdog2LongJump.O0OoOO0OOOOO[349] = 31;
        Watchdog2LongJump.O0OoOO0OOOOO[187] = 116;
        Watchdog2LongJump.O0OoOO0OOOOO[92] = 126;
        Watchdog2LongJump.O0OoOO0OOOOO[31] = -37;
        Watchdog2LongJump.O0OoOO0OOOOO[297] = 67;
        Watchdog2LongJump.O0OoOO0OOOOO[130] = -29;
        Watchdog2LongJump.O0OoOO0OOOOO[205] = -7;
        Watchdog2LongJump.O0OoOO0OOOOO[29] = 73;
        Watchdog2LongJump.O0OoOO0OOOOO[183] = 65;
        Watchdog2LongJump.O0OoOO0OOOOO[197] = 5;
        Watchdog2LongJump.O0OoOO0OOOOO[262] = -23;
        Watchdog2LongJump.O0OoOO0OOOOO[246] = 99;
        Watchdog2LongJump.O0OoOO0OOOOO[285] = 47;
        Watchdog2LongJump.O0OoOO0OOOOO[62] = -47;
        Watchdog2LongJump.O0OoOO0OOOOO[226] = 48;
        Watchdog2LongJump.O0OoOO0OOOOO[194] = -46;
        Watchdog2LongJump.O0OoOO0OOOOO[119] = 74;
        Watchdog2LongJump.O0OoOO0OOOOO[292] = -75;
        Watchdog2LongJump.O0OoOO0OOOOO[114] = 2;
        Watchdog2LongJump.O0OoOO0OOOOO[280] = 75;
        Watchdog2LongJump.O0OoOO0OOOOO[266] = -79;
        Watchdog2LongJump.O0OoOO0OOOOO[319] = -111;
        Watchdog2LongJump.O0OoOO0OOOOO[113] = 119;
        Watchdog2LongJump.O0OoOO0OOOOO[84] = 144;
        Watchdog2LongJump.O0OoOO0OOOOO[133] = -89;
        Watchdog2LongJump.O0OoOO0OOOOO[56] = -31;
        Watchdog2LongJump.O0OoOO0OOOOO[397] = 51;
        Watchdog2LongJump.O0OoOO0OOOOO[71] = 29;
        Watchdog2LongJump.O0OoOO0OOOOO[60] = -170;
        Watchdog2LongJump.O0OoOO0OOOOO[249] = 32;
        Watchdog2LongJump.O0OoOO0OOOOO[392] = 4440;
        Watchdog2LongJump.O0OoOO0OOOOO[248] = 78;
        Watchdog2LongJump.O0OoOO0OOOOO[52] = -89;
        Watchdog2LongJump.O0OoOO0OOOOO[83] = 30;
        Watchdog2LongJump.O0OoOO0OOOOO[333] = -4;
        Watchdog2LongJump.O0OoOO0OOOOO[76] = -91;
        Watchdog2LongJump.O0OoOO0OOOOO[370] = 94;
        Watchdog2LongJump.O0OoOO0OOOOO[238] = -73;
        Watchdog2LongJump.O0OoOO0OOOOO[301] = -9;
        Watchdog2LongJump.O0OoOO0OOOOO[239] = 44;
        Watchdog2LongJump.O0OoOO0OOOOO[120] = -57;
        Watchdog2LongJump.O0OoOO0OOOOO[291] = 19;
        Watchdog2LongJump.O0OoOO0OOOOO[361] = 44;
        Watchdog2LongJump.O0OoOO0OOOOO[86] = 123;
        Watchdog2LongJump.O0OoOO0OOOOO[212] = -48;
        Watchdog2LongJump.O0OoOO0OOOOO[241] = 33;
        Watchdog2LongJump.O0OoOO0OOOOO[148] = 65;
        Watchdog2LongJump.O0OoOO0OOOOO[256] = -55;
        Watchdog2LongJump.O0OoOO0OOOOO[99] = -110;
        Watchdog2LongJump.O0OoOO0OOOOO[263] = 31;
        Watchdog2LongJump.O0OoOO0OOOOO[175] = 97;
    }

    @Override
    public void onEnable() {
        this.Mg = Watchdog2LongJump.aEg.thePlayer.pl;
        this.Mh = Watchdog2LongJump.aEg.thePlayer.rotationPitch;
        Watchdog2LongJump.aEg.thePlayer.pl = (float)this.Mg;
        if (Watchdog2LongJump.aEg.thePlayer.onGround) {
            Watchdog2LongJump.aEg.thePlayer.jump();
        }
        else {
            afi.b("start on the " + "ground", new Object[0]);
            this.wj().setEnabled(false);
        }
        this.Md = Watchdog2LongJump.aEg.thePlayer.posX;
        this.Me = Watchdog2LongJump.aEg.thePlayer.posY;
        this.Mf = Watchdog2LongJump.aEg.thePlayer.posZ;
        this.jy = Watchdog2LongJump.aEg.thePlayer.posY;
        Watchdog2LongJump.LW = false;
        Watchdog2LongJump.hQ = 0;
    }

    static {
        Oo0o00000O00();
        (Watchdog2LongJump.fld_0oOOoOo0O00O_40 = new Object[4])[0] = "zFZIoCVlFU7BcPigSxyS5pF5IZLnYYRaijnO5WAtb4zq2HwfwdhBys7kb8r0Cs6OAGQ+ye9bo6xTYOiYPn5PjSaLH1L8ifbC4BWAGRM7kDjnyxG8UF44YdkLwlTH9kqBvxGFfLbiEsmnZKTI2aRJeSPPnu+cseQ0ax7WFGbDJ9ui+rP4lpm1bxjU0Ik9HTeveevAHLI/6n541QebFVjy1LpPhZ4fPGYGOBncNvcmL9/mD9mCpCGUAC9aSuBW+NwwUd4i2mXYqQ9lFqG8lxetI/T8+utb8P+fFSKpPVDTwe6ChMS0a9otayxgexzxTKNKjBkEAX3mzQAIuO/kHUpdWsifj42sFEYfZGPSC9RQy7E=";
        Watchdog2LongJump.fld_0oOOoOo0O00O_40[1] = "PBKDF2WithHmacSHA1";
        Watchdog2LongJump.fld_0oOOoOo0O00O_40[2] = "AES";
        Watchdog2LongJump.fld_0oOOoOo0O00O_40[3] = "AES/CBC/PKCS5Padding";
        (Watchdog2LongJump.oO00O0OO0ooO = new Object[1])[0] = "\u0000\ttraveled:\u0000\u0006ground\u0000\fWatchdog Lon\u0000\u0005ight)\u0000\u0005Timer\u0000VBad knockback detected from the server... Cancelling and trying to save you from the v\u0000\u0007ge Move\u0000";
        (Watchdog2LongJump.o0Oo000O0oO = new Object[15])[0] = "traveled:";
        Watchdog2LongJump.o0Oo000O0oO[1] = "ground";
        Watchdog2LongJump.o0Oo000O0oO[2] = "Watchdog Lon";
        Watchdog2LongJump.o0Oo000O0oO[3] = "ight)";
        Watchdog2LongJump.o0Oo000O0oO[4] = "Timer";
        Watchdog2LongJump.o0Oo000O0oO[5] = "Bad knockback detected from the server... Cancelling and trying to save you from the v";
        Watchdog2LongJump.o0Oo000O0oO[6] = "ge Move";
        Watchdog2LongJump.o0Oo000O0oO[7] = "start on the ";
        Watchdog2LongJump.o0Oo000O0oO[8] = "gjump";
        Watchdog2LongJump.o0Oo000O0oO[9] = "Delay Boost (go further with less he";
        Watchdog2LongJump.o0Oo000O0oO[10] = "Allow Dama";
        Watchdog2LongJump.o0Oo000O0oO[11] = "Fly Mode";
        Watchdog2LongJump.o0Oo000O0oO[12] = "oid";
        Watchdog2LongJump.o0Oo000O0oO[13] = " ";
        Watchdog2LongJump.o0Oo000O0oO[14] = "Distance ";
    }

}
