package com.alan.clients.module.impl.player;

import com.alan.clients.Client;
import com.alan.clients.component.impl.player.BlinkComponent;
import com.alan.clients.component.impl.player.RotationComponent;
import com.alan.clients.component.impl.player.rotationcomponent.MovementFix;
import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.other.BlockDamageEvent;
import com.alan.clients.newevent.impl.other.TeleportEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.newevent.impl.render.MouseOverEvent;
import com.alan.clients.newevent.impl.render.Render3DEvent;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.ListValue;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.NumberValue;
import com.alan.clients.value.impl.SubMode;
import hackclient.rise.aef;
import hackclient.rise.afi;
import com.alan.clients.util.packet.PacketUtil;
import com.alan.clients.util.player.PlayerUtil;
import com.alan.clients.util.rotation.RotationUtil;
import hackclient.rise.aka;
import hackclient.rise.akb;
import hackclient.rise.component.ci;
import hackclient.rise.gg;
import hackclient.rise.tg;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C07PacketPlayerDigging.Action;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S23PacketBlockChange;
import net.minecraft.network.play.server.S32PacketConfirmTransaction;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

@ModuleInfo(aliases = "module.player.breaker.name", description = "module.player.breaker.description", category = Category.PLAYER)
public class Breaker extends Module {
    public final ModeValue mode = new ModeValue("Mode", this).add(new SubMode("Normal")).add(new SubMode("Instant")).setDefault("Normal");
    public final NumberValue range = new NumberValue("Range", this, 4.5, 1, 6, 0.1);
    public final BooleanValue bed = new BooleanValue("Bed", this, true);
    public final BooleanValue keepBreakProgressWhenOutOfRange = new BooleanValue("Keep Break Progress When Out Of Range", this, true);
    public final BooleanValue abA = new BooleanValue("Cancel velocity whilst breaking, so you don't slow down in air", this, true);
    public final BooleanValue delayVelocityUntilBedBroken = new BooleanValue("Delay Velocity Until Bed Broken", this, false);
    public final BooleanValue throughWalls = new BooleanValue("Through Walls", this, true);
    private final BooleanValue emptySurrounding = new BooleanValue("Empty Surrounding", this, false, () -> !this.throughWalls.wo());
    private final ModeValue surroundings = new ModeValue("Surroundings", this).add(new SubMode("Single")).add(new SubMode("Full")).setDefault("Single");
    private final NumberValue surroundingLayers = new NumberValue("Surrounding Layers", this, 3, 1, 6, 1, () -> !this.surroundings.wo().getName().equals("Full"));
    private final BooleanValue showBestStandPosition = new BooleanValue("Show Best Stand Position", this, false, () -> !this.surroundings.wo().getName().equals("Full"));
    private final BooleanValue heypixel = new BooleanValue("Heypixel", this, false, () -> !this.throughWalls.wo() || !this.emptySurrounding.wo());
    private final BooleanValue watchdogGroundSpoof = new BooleanValue("Watchdog Ground Spoof", this, false);
    public final BooleanValue attackWhileBreaking = new BooleanValue("Attack While Breaking", this, true);
    private final BooleanValue showBreakerPercentage = new BooleanValue("Show Breaker Percentage", this, true);
    public final BooleanValue rotations = new BooleanValue("Rotate", this, true);
    public final BooleanValue onlyRotateAtStartAndStop = new BooleanValue("Only Rotate at Start and Stop", this, true);
    public final BooleanValue whiteListOwnBed = new BooleanValue("Whitelist Own Bed", this, true);
    public final BooleanValue slowDownInAir = new BooleanValue("Slow Down In Air", this, true);
    private final ListValue<MovementFix> movementCorrection = new ListValue<>("Movement Correction", this);
    public static aka abQ;
    public static aka abR;
    public static aka abS;
    private int aaW;
    public static boolean iq;
    public static boolean ir;
    public static boolean abT = false;
    private int dm;
    private boolean ji;
    private float abU;
    public static boolean tt;
    private Animation abV = new Animation(Easing.LINEAR, 50L);
    private BlockPos blockPos;
    private Vec3 abX;
    private int abY;
    private int abZ;
    private final ArrayList<Packet<?>> aca = new ArrayList<>();
    private boolean acb = false;
    @EventLink
    public final Listener<Render3DEvent> acc = var1 -> {
        if (abQ != null) {
            if (Client.a.g().c(FastBreak.class).isEnabled() && this.showBreakerPercentage.wo()) {
                ci.a((float)(1.21 * this.abU + (Double)Client.a.g().c(FastBreak.class).speed.wo() / 100.0));
            } else if (this.showBreakerPercentage.wo()) {
                ci.a((float)(1.21 * this.abU));
            }

            akb akb = new akb((int)Math.floor(abQ.getX()), (int)Math.floor(abQ.getY()), (int)Math.floor(abQ.getZ()));
            this.abV.Q(this.abU);
            this.b(gg.BLOOM).c(() -> {
                GlStateManager.pushMatrix();
                GlStateManager.pushAttrib();
                GlStateManager.enableBlend();
                GlStateManager.disableTexture2D();
                GlStateManager.disableLighting();
                GL11.glDepthMask(false);
                RenderUtil.color(this.rz().rA());
                RenderUtil.drawBoundingBox(new AxisAlignedBB(akb.we(), akb.wf(), akb.wi(), akb.we() + 1, akb.wf() + 1.0 * this.abV.sG(), akb.wi() + 1));
                GlStateManager.enableTexture2D();
                GlStateManager.enableLighting();
                GlStateManager.disableBlend();
                GL11.glDepthMask(true);
                GlStateManager.popAttrib();
                GlStateManager.popMatrix();
                GlStateManager.resetColor();
            });
        }
    };
    @EventLink
    public final Listener<Render3DEvent> acd = var1 -> {
        BlockPos blockpos = this.blockPos;
        if (blockpos != null) {
            AxisAlignedBB axisalignedbb = new AxisAlignedBB(blockpos, blockpos.add(1, 1, 1));
            this.a(axisalignedbb, this.rz().rA());
            this.b(gg.BLOOM).c(() -> this.a(axisalignedbb, this.rz().rA()));
        }
    };
    @EventLink(value = 2)
    public final Listener<PacketReceiveEvent> onPacketReceive = var1 -> {
        Packet packet = var1.getPacket();
        if (!tt) {
            if (this.delayVelocityUntilBedBroken.wo()) {
                if (packet instanceof S12PacketEntityVelocity s12packetentityvelocity) {
                    if (s12packetentityvelocity.getEntityID() == aEg.thePlayer.getEntityId() && abT) {
                        this.acb = true;
                        this.aca.add(packet);
                        var1.setCancelled();
                    }
                } else if (packet instanceof S32PacketConfirmTransaction && this.acb) {
                    afi.b(aEg.thePlayer.ticksExisted);
                    this.aca.add(packet);
                    var1.setCancelled();
                }
            }

            if (abQ != null && this.abA.wo()) {
                if (packet instanceof S12PacketEntityVelocity s12packetentityvelocity1 && s12packetentityvelocity1.getEntityID() == aEg.thePlayer.getEntityId()
                    )
                 {
                    var1.setCancelled();
                }

                if (packet instanceof S23PacketBlockChange s23packetblockchange) {
                    BlockPos blockpos = s23packetblockchange.getBlockPosition();
                    IBlockState iblockstate = s23packetblockchange.getBlockState();
                    if (abQ != null
                        && blockpos.getX() == (int)abQ.getX()
                        && blockpos.getY() == (int)abQ.getY()
                        && blockpos.getZ() == (int)abQ.getZ()
                        && iblockstate.getBlock() == Blocks.air) {
                        abQ = null;
                        if (this.jx() == null) {
                            abT = false;
                        }
                    }
                }
            }
        }
    };
    @EventLink(value = 4)
    public final Listener<PacketSendEvent> onPacketSend = var1 -> {
        Packet packet = var1.dq();
        if (packet instanceof C07PacketPlayerDigging && abQ != null && this.watchdogGroundSpoof.wo()) {
            C07PacketPlayerDigging c07packetplayerdigging = (C07PacketPlayerDigging)packet;
            if (c07packetplayerdigging.getStatus() == Action.START_DESTROY_BLOCK || c07packetplayerdigging.getStatus() == Action.STOP_DESTROY_BLOCK) {
                iq = true;
                this.dm = aEg.thePlayer.ticksExisted;
            }
        }
    };
    @EventLink(value = 0)
    public final Listener<PreMotionEvent> onPreMotion = var0 -> {
        float f;
        int i = (f = aEg.playerController.curBlockDamageMP - 0.0F) == 0.0F ? 0 : (f < 0.0F ? -1 : 1);
        if (iq) {
            BlinkComponent.blink();
            var0.setOnGround(true);
        }

        if (aEg.thePlayer.onGround && iq) {
            BlinkComponent.dispatch();
            iq = false;
        }
    };
    @EventLink
    public final Listener<StrafeEvent> onStrafe = var0 -> {
        if (iq) {
            ;
        }
    };
    @EventLink(value = 4)
    public final Listener<BlockDamageEvent> onBlockDamage = var1 -> this.abU = aEg.playerController.curBlockDamageMP;
    @EventLink(value = 4)
    public final Listener<PreUpdateEvent> onPreUpdate = var1 -> {
        this.jA();
        if (this.delayVelocityUntilBedBroken.wo() && !abT && this.acb) {
            tt = true;
            this.aca.forEach(PacketUtil::p);
            this.aca.clear();
            this.acb = false;
            tt = false;
            afi.b(aEg.thePlayer.ticksExisted);
        }

        this.aaW--;
        if (this.aaW <= 0) {
            this.jz();
            if (abQ == null
                || aEg.thePlayer.getDistance(abQ.getX(), abQ.getY(), abQ.getZ()) > this.range.wo().doubleValue() + 2.5
                || PlayerUtil.o(abQ.getX(), abQ.getY(), abQ.getZ()) instanceof BlockAir) {
                this.jv();
                if (this.ji) {
                    aEg.gameSettings.cgK.setPressed(false);
                    this.ji = false;
                }

                if (abQ == null) {
                    return;
                }
            }

            this.jD();
        }
    };
    @EventLink
    public final Listener<MouseOverEvent> onMouseOver = var1 -> {
        if (abQ != null) {
            BlockPos blockpos = new BlockPos(abQ.getX(), abQ.getY(), abQ.getZ());
            Vec3 vec3 = aEg.thePlayer.getPositionEyes(1.0F);
            Vector2f vector2f = this.onlyRotateAtStartAndStop.wo() ? this.jE() : RotationComponent.fk;
            Vec3 vec31 = aEg.thePlayer.getVectorForRotation(vector2f.getY(), vector2f.getX());
            double d0 = this.range.wo().doubleValue() + 1.0;
            Vec3 vec32 = vec3.addVector(vec31.xCoord * d0, vec31.yCoord * d0, vec31.zCoord * d0);
            MovingObjectPosition movingobjectposition = PlayerUtil.block(blockpos).collisionRayTrace(aEg.theWorld, blockpos, aEg.thePlayer.getPositionEyes(1.0F), vec32);
            var1.a(movingobjectposition);
        }
    };
    @EventLink
    public final Listener<TeleportEvent> onTeleport = var0 -> {
        if (aEg.thePlayer.getDistance(var0.getPosX(), var0.getPosY(), var0.getPosZ()) > 40.0) {
            abS = new aka(var0.getPosX(), var0.getPosY(), var0.getPosZ());
        }
    };

    public Breaker() {
        for (MovementFix movementfix : MovementFix.values()) {
            this.movementCorrection.add(movementfix);
        }

        this.movementCorrection.setDefault(MovementFix.OFF);
    }

    @Override
    public void onEnable() {
        abQ = null;
        this.abU = 0.0F;
        this.aaW = 0;
        this.blockPos = null;
        this.abX = null;
        abT = false;
        this.aca.clear();
        this.aca.forEach(PacketUtil::p);
        this.acb = false;
    }

    @Override
    public void onDisable() {
        abQ = null;
        iq = false;
        abT = false;
        this.blockPos = null;
        this.abX = null;
        if (!this.aca.isEmpty()) {
            this.aca.forEach(PacketUtil::p);
            this.aca.clear();
        }

        this.acb = false;
        if (this.ji) {
            aEg.gameSettings.cgK.setPressed(false);
            this.ji = false;
        }
    }

    private void a(AxisAlignedBB var1, Color var2) {
        double d0 = aEg.getRenderManager().viewerPosX;
        double d1 = aEg.getRenderManager().viewerPosY;
        double d2 = aEg.getRenderManager().viewerPosZ;
        GlStateManager.pushMatrix();
        GlStateManager.pushAttrib();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.disableLighting();
        GlStateManager.disableDepth();
        GL11.glDepthMask(false);
        GL11.glLineWidth(1.5F);
        RenderUtil.color(var2);
        RenderGlobal.drawSelectionBoundingBox(var1.expand(0.002, 0.002, 0.002).offset(-d0, -d1, -d2));
        GL11.glDepthMask(true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GlStateManager.popAttrib();
        GlStateManager.popMatrix();
        GlStateManager.resetColor();
    }

    public void jv() {
        if (abQ == null
            || PlayerUtil.o(abQ.x, abQ.y, abQ.z) instanceof BlockAir
            || aEg.thePlayer.getDistance(abQ.x, abQ.y - aEg.thePlayer.getEyeHeight(), abQ.z) > this.range.wo().doubleValue() + 2.5) {
            if (abR != null && !this.keepBreakProgressWhenOutOfRange.wo()) {
                aEg.playerController.curBlockDamageMP = 0.0F;
            }

            abR = abQ;
            aka aka = this.jx();
            if (aka != null) {
                abT = true;
            } else {
                abT = false;
            }

            abQ = aka;
        }
    }

    public void jw() {
        BlockPos blockpos = new BlockPos(abQ.getX(), abQ.getY(), abQ.getZ());
        float f = PlayerUtil.block(blockpos).getPlayerRelativeBlockHardness(aEg.thePlayer, aEg.theWorld, blockpos);
        if (!this.onlyRotateAtStartAndStop.wo() || aEg.playerController.curBlockDamageMP == 0.0F || !(aEg.playerController.curBlockDamageMP <= 1.0F - f - 0.001)) {
            if (this.rotations.wo()) {
                RotationComponent.setRotations(this.jE(), 10.0, this.movementCorrection.wo());
            }
        }
    }

    public aka jx() {
        if (abS != null && aEg.thePlayer.getDistanceSq(abS.getX(), abS.getY(), abS.getZ()) < 1225.0 && this.whiteListOwnBed.wo()) {
            return null;
        }

        if (this.throughWalls.wo() && this.emptySurrounding.wo() && this.surroundings.wo().getName().equals("Full")) {
            return this.jy();
        }

        int i = 0;

        for (int j = -5; j <= 5; j++) {
            for (int k = -5; k <= 5; k++) {
                for (int l = -5; l <= 5; l++) {
                    Block block = PlayerUtil.p(j, k, l);
                    aka akax = new aka(aEg.thePlayer.posX + j, aEg.thePlayer.posY + k, aEg.thePlayer.posZ + l);
                    if (block instanceof BlockBed) {
                        if (++i > 1) {
                            MovingObjectPosition movingobjectposition = aef.c(RotationUtil.d(akax), this.range.wo().floatValue() + 1.0F);
                            if (movingobjectposition != null
                                && !(
                                    movingobjectposition.hitVec
                                            .distanceTo(new Vec3(aEg.thePlayer.posX, aEg.thePlayer.posY - aEg.thePlayer.getEyeHeight(), aEg.thePlayer.posZ))
                                        > this.range.wo().doubleValue() + 2.0
                                )) {
                                if (this.throughWalls.wo()) {
                                    if (this.emptySurrounding.wo()) {
                                        aka akax2 = akax;
                                        double d0 = Double.MAX_VALUE;
                                        boolean flag = false;
                                        int i1 = this.heypixel.wo() ? 0 : 4;
                                        int j1 = this.heypixel.wo() ? 1 : 0;

                                        for (int k1 = -i1; k1 <= i1; k1++) {
                                            for (int l1 = j1; l1 <= 1; l1++) {
                                                for (int i2 = -i1; i2 <= i1; i2++) {
                                                    Block block1 = PlayerUtil.o(akax2.getX() + k1, akax2.getY() + l1, akax2.getZ() + i2);
                                                    if (!(block1 instanceof BlockBed)
                                                        && !flag
                                                        && !(aEg.thePlayer.getDistance(akax2.getX() + k1, akax2.getY() + l1, akax2.getZ()) + i2 > 46.0)
                                                        && !this.a(akax2.v(k1, l1, i2)).stream().noneMatch(var0 -> var0 instanceof BlockBed)) {
                                                        if (!(block1 instanceof BlockAir) && !(block1 instanceof BlockLiquid)) {
                                                            if (!(
                                                                aEg.thePlayer
                                                                        .getDistance(
                                                                            akax2.getX() + k1, akax2.getY() + l1 - aEg.thePlayer.getEyeHeight(), akax2.getZ() + i2
                                                                        )
                                                                    > this.range.wo().doubleValue() + 2.0
                                                            )) {
                                                                double d1 = block1.wX();
                                                                if (d1 < d0) {
                                                                    d0 = d1;
                                                                    akax2 = akax2.v(k1, l1, i2);
                                                                }
                                                            }
                                                        } else {
                                                            flag = true;
                                                        }
                                                    }
                                                }
                                            }
                                        }

                                        if (!flag) {
                                            if (akax2.equals(akax2)) {
                                                return null;
                                            }

                                            return akax2;
                                        }
                                    }

                                    return akax;
                                }

                                BlockPos blockpos = movingobjectposition.getBlockPos();
                                if (blockpos.h(akax)) {
                                    return akax;
                                }
                            }
                        }
                    }
                }
            }
        }

        return null;
    }

    private aka jy() {
        tg tg = this.a(aEg.thePlayer.getPositionEyes(1.0F), this.jC());
        if (tg == null) {
            return null;
        }

        BlockPos blockpos = tg.acn.get(0);
        return new aka(blockpos.getX() + 0.5, blockpos.getY() + 0.5, blockpos.getZ() + 0.5);
    }

    private tg a(Vec3 var1, List<BlockPos> var2) {
        tg tgx = null;

        for (tg tgx2 : this.b(var1, var2)) {
            if (tgx == null || tgx2.aco < tgx.aco) {
                tgx = tgx2;
            }
        }

        return tgx;
    }

    private List<tg> b(Vec3 var1, List<BlockPos> var2) {
        ArrayList arraylist = new ArrayList();

        for (BlockPos blockpos : var2) {
            for (Vec3 vec3 : this.k(blockpos)) {
                tg tg = this.a(var1, blockpos, vec3);
                if (tg != null) {
                    arraylist.add(tg);
                }
            }
        }

        return arraylist;
    }

    private tg a(Vec3 var1, BlockPos var2, Vec3 var3) {
        double d0 = this.range.wo().doubleValue();
        int i = this.surroundingLayers.wo().intValue();
        ArrayList arraylist = new ArrayList();
        double d1 = 0.0;

        for (BlockPos blockpos : this.b(var1, var3)) {
            if (this.a(var1, blockpos) > d0) {
                return null;
            }

            if (blockpos.equals(var2)) {
                arraylist.add(var2);
                return new tg(var2, arraylist, d1);
            }

            if (!this.j(blockpos)) {
                Block block = PlayerUtil.block(blockpos);
                if (block instanceof BlockBed || block.getBlockHardness(aEg.theWorld, blockpos) < 0.0F || arraylist.size() >= i) {
                    return null;
                }

                arraylist.add(blockpos);
                d1 += 1.0F / Math.max(block.getPlayerRelativeBlockHardness(aEg.thePlayer, aEg.theWorld, blockpos), 1.0E-4F);
            }
        }

        return null;
    }

    private List<BlockPos> b(Vec3 var1, Vec3 var2) {
        ArrayList arraylist = new ArrayList();
        int i = MathHelper.floor_double(var1.xCoord);
        int j = MathHelper.floor_double(var1.yCoord);
        int k = MathHelper.floor_double(var1.zCoord);
        int l = MathHelper.floor_double(var2.xCoord);
        int i1 = MathHelper.floor_double(var2.yCoord);
        int j1 = MathHelper.floor_double(var2.zCoord);
        double d0 = var2.xCoord - var1.xCoord;
        double d1 = var2.yCoord - var1.yCoord;
        double d2 = var2.zCoord - var1.zCoord;
        int k1 = d0 > 0.0 ? 1 : (d0 < 0.0 ? -1 : 0);
        int l1 = d1 > 0.0 ? 1 : (d1 < 0.0 ? -1 : 0);
        int i2 = d2 > 0.0 ? 1 : (d2 < 0.0 ? -1 : 0);
        double d3 = k1 == 0 ? Double.MAX_VALUE : 1.0 / Math.abs(d0);
        double d4 = l1 == 0 ? Double.MAX_VALUE : 1.0 / Math.abs(d1);
        double d5 = i2 == 0 ? Double.MAX_VALUE : 1.0 / Math.abs(d2);
        double d6 = k1 == 0 ? Double.MAX_VALUE : (k1 > 0 ? i + 1 - var1.xCoord : var1.xCoord - i) / Math.abs(d0);
        double d7 = l1 == 0 ? Double.MAX_VALUE : (l1 > 0 ? j + 1 - var1.yCoord : var1.yCoord - j) / Math.abs(d1);
        double d8 = i2 == 0 ? Double.MAX_VALUE : (i2 > 0 ? k + 1 - var1.zCoord : var1.zCoord - k) / Math.abs(d2);
        arraylist.add(new BlockPos(i, j, k));

        for (; (i != l || j != i1 || k != j1) && arraylist.size() < 64; arraylist.add(new BlockPos(i, j, k))) {
            if (d6 <= d7 && d6 <= d8) {
                i += k1;
                d6 += d3;
            } else if (d7 <= d8) {
                j += l1;
                d7 += d4;
            } else {
                k += i2;
                d8 += d5;
            }
        }

        return arraylist;
    }

    private void jz() {
        if (abQ != null && this.throughWalls.wo() && this.emptySurrounding.wo() && this.surroundings.wo().getName().equals("Full")) {
            Vec3 vec3 = new Vec3(aEg.thePlayer.posX, aEg.thePlayer.posY, aEg.thePlayer.posZ);
            if (this.abX != null && !(this.abX.squareDistanceTo(vec3) < 0.25) && aEg.thePlayer.ticksExisted - this.abZ >= 5) {
                this.abX = vec3;
                this.abZ = aEg.thePlayer.ticksExisted;
                BlockPos blockpos = new BlockPos(abQ.getX(), abQ.getY(), abQ.getZ());
                tg tgxx = null;
                tg tgx = null;

                for (tg tgxx2 : this.b(aEg.thePlayer.getPositionEyes(1.0F), this.jC())) {
                    if (tgx == null || tgxx2.aco < tgx.aco) {
                        tgx = tgxx2;
                    }

                    if (tgxx2.acn.get(0).equals(blockpos) && (tgxx == null || tgxx2.aco < tgxx.aco)) {
                        tgxx = tgxx2;
                    }
                }

                if (tgx != null && !tgx.acn.get(0).equals(blockpos)) {
                    if (tgxx != null) {
                        double d0 = aEg.playerController.curBlockDamageMP
                            / Math.max(PlayerUtil.block(blockpos).getPlayerRelativeBlockHardness(aEg.thePlayer, aEg.theWorld, blockpos), 1.0E-4F);
                        if (tgx.aco >= (tgxx.aco - d0) * 0.9) {
                            return;
                        }
                    }

                    aEg.playerController.curBlockDamageMP = 0.0F;
                    this.abU = 0.0F;
                    if (this.ji) {
                        aEg.gameSettings.cgK.setPressed(false);
                        this.ji = false;
                    }

                    abQ = null;
                }
            } else {
                if (this.abX == null) {
                    this.abX = vec3;
                }
            }
        } else {
            this.abX = null;
        }
    }

    private void jA() {
        if (!this.showBestStandPosition.wo() || !this.throughWalls.wo() || !this.emptySurrounding.wo() || !this.surroundings.wo().getName().equals("Full")) {
            this.blockPos = null;
        } else if (aEg.thePlayer.ticksExisted - this.abY >= 10) {
            this.abY = aEg.thePlayer.ticksExisted;
            this.blockPos = this.jB();
        }
    }

    private BlockPos jB() {
        double d0 = this.range.wo().doubleValue();
        int i = (int)Math.ceil(d0) + 1;
        List list = this.jC();
        if (list.isEmpty()) {
            return null;
        }

        BlockPos blockpos = (BlockPos)list.get(0);
        BlockPos blockpos1 = null;
        double d1 = 0.0;
        double d2 = 0.0;

        for (int j = -i; j <= i; j++) {
            for (int k = -2; k <= 2; k++) {
                for (int l = -i; l <= i; l++) {
                    BlockPos blockpos2 = blockpos.add(j, k, l);
                    Vec3 vec3 = new Vec3(blockpos2.getX() + 0.5, blockpos2.getY() + aEg.thePlayer.getEyeHeight(), blockpos2.getZ() + 0.5);
                    boolean flag = false;

                    for (BlockPos blockpos3 : (Iterable<BlockPos>)list) {
                        if (this.a(vec3, blockpos3) <= d0) {
                            flag = true;
                            break;
                        }
                    }

                    if (flag && this.i(blockpos2)) {
                        tg tg = this.a(vec3, list);
                        if (tg != null) {
                            double d3 = aEg.thePlayer.getDistanceSq(blockpos2.getX() + 0.5, blockpos2.getY(), blockpos2.getZ() + 0.5);
                            if (blockpos1 == null || tg.aco < d1 - 0.001 || Math.abs(tg.aco - d1) <= 0.001 && d3 < d2) {
                                blockpos1 = blockpos2;
                                d1 = tg.aco;
                                d2 = d3;
                            }
                        }
                    }
                }
            }
        }

        return blockpos1;
    }

    private boolean i(BlockPos var1) {
        return this.j(var1)
            && this.j(var1.up())
            && PlayerUtil.block(var1.down()).getCollisionBoundingBox(aEg.theWorld, var1.down(), aEg.theWorld.getBlockState(var1.down())) != null;
    }

    private boolean j(BlockPos var1) {
        return PlayerUtil.block(var1).getCollisionBoundingBox(aEg.theWorld, var1, aEg.theWorld.getBlockState(var1)) == null;
    }

    private double a(Vec3 var1, BlockPos var2) {
        double d0 = Math.max(var2.getX() - var1.xCoord, Math.max(0.0, var1.xCoord - (var2.getX() + 1)));
        double d1 = Math.max(var2.getY() - var1.yCoord, Math.max(0.0, var1.yCoord - (var2.getY() + 1)));
        double d2 = Math.max(var2.getZ() - var1.zCoord, Math.max(0.0, var1.zCoord - (var2.getZ() + 1)));
        return Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
    }

    private List<BlockPos> jC() {
        ArrayList arraylist = new ArrayList();

        for (int i = -5; i <= 5; i++) {
            for (int j = -5; j <= 5; j++) {
                for (int k = -5; k <= 5; k++) {
                    if (PlayerUtil.p(i, j, k) instanceof BlockBed) {
                        arraylist.add(new BlockPos(aEg.thePlayer.posX + i, aEg.thePlayer.posY + j, aEg.thePlayer.posZ + k));
                    }
                }
            }
        }

        return arraylist;
    }

    private Vec3[] k(BlockPos var1) {
        return new Vec3[]{
            new Vec3(var1.getX() + 0.5, var1.getY() + 0.5, var1.getZ() + 0.5),
            new Vec3(var1.getX() + 0.1, var1.getY() + 0.1, var1.getZ() + 0.1),
            new Vec3(var1.getX() + 0.9, var1.getY() + 0.1, var1.getZ() + 0.9),
            new Vec3(var1.getX() + 0.1, var1.getY() + 0.5, var1.getZ() + 0.9),
            new Vec3(var1.getX() + 0.9, var1.getY() + 0.5, var1.getZ() + 0.1)
        };
    }

    public List<Block> a(aka var1) {
        ArrayList arraylist = new ArrayList();

        for (EnumFacing enumfacing : EnumFacing.values()) {
            if (enumfacing != EnumFacing.UP) {
                aka aka = var1.e(new aka(enumfacing.getDirectionVec().getX(), enumfacing.getDirectionVec().getY(), enumfacing.getDirectionVec().getZ()));
                arraylist.add(PlayerUtil.c(aka));
            }
        }

        return arraylist;
    }

    public void l(BlockPos var1) {
        BlockDamageEvent blockdamageevent = new BlockDamageEvent(aEg.thePlayer, aEg.thePlayer.worldObj, var1);
        Client.a.e().d(blockdamageevent);
    }

    public void jD() {
        boolean flag = this.slowDownInAir.wo();
        boolean flag1 = aEg.thePlayer.onGround;
        if (!flag) {
            aEg.thePlayer.onGround = true;
        }

        label26: {
            BlockPos blockpos;
            label25: {
                blockpos = new BlockPos(abQ.getX(), abQ.getY(), abQ.getZ());
                String s = this.mode.wo().getName();
                byte b0 = -1;
                switch (s.hashCode()) {
                    case -1955878649:
                        if (s.equals("Normal")) {
                            break label25;
                        }
                        break;
                    case -672743999:
                        if (s.equals("Instant")) {
                            b0 = 0;
                        }
                }

                switch (b0) {
                    case 0:
                        this.jw();
                        this.l(blockpos);
                        aEg.thePlayer.swingItem();
                        PacketUtil.l(new C07PacketPlayerDigging(Action.START_DESTROY_BLOCK, blockpos, EnumFacing.UP));
                        aEg.thePlayer.swingItem();
                        PacketUtil.l(new C07PacketPlayerDigging(Action.STOP_DESTROY_BLOCK, blockpos, EnumFacing.UP));
                        abQ = null;
                        this.aaW = 20;
                        aEg.playerController.onPlayerDestroyBlock(blockpos, EnumFacing.DOWN);
                        break label26;
                    case 1:
                        break;
                    default:
                        break label26;
                }
            }

            this.l(blockpos);
            this.jw();
            aEg.gameSettings.cgK.setPressed(true);
            this.ji = true;
        }

        aEg.thePlayer.onGround = flag1;
    }

    public Vector2f jE() {
        return RotationUtil.d(
            new aka(
                Math.floor(abQ.getX()) + 0.5 + (Math.random() - 0.5) / 4.0,
                Math.floor(abQ.getY()) + 0.1,
                Math.floor(abQ.getZ()) + 0.5 + (Math.random() - 0.5) / 4.0
            )
        );
    }
}
