package com.alan.clients.module.impl.movement;

import com.alan.clients.component.impl.player.RotationComponent;
import com.alan.clients.component.impl.player.SlotComponent;
import com.alan.clients.component.impl.player.rotationcomponent.MovementFix;
import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.NumberValue;
import hackclient.rise.aef;
import hackclient.rise.ahj;
import hackclient.rise.aik;
import hackclient.rise.aiu;
import hackclient.rise.cg;
import hackclient.rise.ls;
import hackclient.rise.lt;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.m;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

@ModuleInfo(aliases = "module.movement.automlg.name", description = "module.movement.automlg.description", category = Category.MOVEMENT)
public class AutoMLG extends Module {
    private final NumberValue CA = new NumberValue("Fall Distance", this, 4.0, 3.0, 20.0, 0.5);
    private final NumberValue CB = new NumberValue("Pickup Delay", this, 4, 1, 20, 1);
    private final BooleanValue CC = new BooleanValue("Auto Pickup", this, true);
    private final BooleanValue CD = new BooleanValue("Auto Disable", this, false);
    private lt CE = lt.IDLE;
    private int CF = -1;
    private int qH;
    private BlockPos CG;
    @EventLink(cH = 3)
    public final Listener<PreUpdateEvent> CH = var1 -> {
        if (aEg.thePlayer != null && aEg.theWorld != null && !aEg.thePlayer.isDead) {
            if (this.CE != lt.IDLE && this.CF != -1) {
                SlotComponent.b(this.CF, true);
            }

            switch (this.CE) {
                case IDLE:
                    this.gV();
                    break;
                case ROTATING:
                    this.gW();
                    break;
                case PLACED:
                    this.gX();
                    break;
                case PICKUP:
                    this.gY();
            }
        }
    };

    public AutoMLG() {
    }

    @Override
    public void onEnable() {
        this.gS();
    }

    @Override
    public void onDisable() {
        this.CE = lt.IDLE;
        this.CF = -1;
        this.CG = null;
    }

    private void gS() {
        this.CE = lt.IDLE;
        this.CF = -1;
        this.qH = 0;
        this.CG = null;
    }

    private boolean o(double var1) {
        AxisAlignedBB axisalignedbb = aEg.thePlayer.getEntityBoundingBox().offset(0.0, var1, 0.0);
        return !aEg.theWorld.getCollidingBoundingBoxes(aEg.thePlayer, axisalignedbb).isEmpty();
    }

    private Vec3 a(BlockPos var1, EnumFacing var2, MovingObjectPosition var3) {
        Vec3 vec3 = new Vec3(var1.getX() + Math.random(), var1.getY() + Math.random(), var1.getZ() + Math.random());
        switch (ls.CI[var2.ordinal()]) {
            case 1:
                vec3.yCoord = var1.getY();
                break;
            case 2:
                vec3.yCoord = var1.getY() + 1;
                break;
            case 3:
                vec3.zCoord = var1.getZ();
                break;
            case 4:
                vec3.zCoord = var1.getZ() + 1;
                break;
            case 5:
                vec3.xCoord = var1.getX();
                break;
            case 6:
                vec3.xCoord = var1.getX() + 1;
        }

        if (var3 != null && var3.hitVec != null && var3.getBlockPos() != null && var3.getBlockPos().equals(var1) && var3.sideHit == var2) {
            vec3 = var3.hitVec;
        }

        return vec3;
    }

    private BlockPos d(MovingObjectPosition var1) {
        if (var1 != null && var1.getBlockPos() != null && var1.sideHit != null) {
            BlockPos blockpos = var1.getBlockPos();
            BlockPos blockpos1 = blockpos.offset(var1.sideHit);
            Block block = aEg.theWorld.getBlockState(blockpos1).getBlock();
            return !block.isReplaceable(aEg.theWorld, blockpos1) && !block.getMaterial().isLiquid() ? blockpos : blockpos1;
        }
        return null;
    }

    private boolean e(BlockPos var1) {
        if (var1 == null) {
            return false;
        }

        IBlockState iblockstate = aEg.theWorld.getBlockState(var1);
        Block block = iblockstate.getBlock();
        return (block == Blocks.water || block == Blocks.flowing_water) && block instanceof BlockLiquid && iblockstate.getValue(BlockLiquid.LEVEL) == 0;
    }

    private BlockPos gT() {
        BlockPos blockpos = new BlockPos(aEg.thePlayer);
        BlockPos blockpos1 = null;
        double d0 = Double.MAX_VALUE;

        for (int i = -3; i <= 3; i++) {
            for (int j = -2; j <= 2; j++) {
                for (int k = -3; k <= 3; k++) {
                    BlockPos blockpos2 = blockpos.add(i, j, k);
                    if (this.e(blockpos2)) {
                        double d1 = aEg.thePlayer.getDistanceSq(blockpos2.getX() + 0.5, blockpos2.getY() + 0.5, blockpos2.getZ() + 0.5);
                        if (d1 < d0) {
                            d0 = d1;
                            blockpos1 = blockpos2;
                        }
                    }
                }
            }
        }

        return blockpos1;
    }

    private BlockPos gU() {
        if (this.e(this.CG)) {
            return this.CG;
        }

        BlockPos blockpos = this.gT();
        if (blockpos != null) {
            this.CG = blockpos;
        }

        return this.CG;
    }

    private boolean a(ItemStack var1, BlockPos var2) {
        if (var1 != null && var1.getItem() == Items.bucket && var2 != null) {
            Vector2f vector2f = aiu.h(new Vec3(var2.getX() + 0.5, var2.getY() + 0.5, var2.getZ() + 0.5));
            float f = aEg.thePlayer.pl;
            float f1 = aEg.thePlayer.rotationPitch;
            aEg.thePlayer.pl = vector2f.x;
            aEg.thePlayer.rotationPitch = vector2f.y;
            boolean flag = aEg.playerController.sendUseItem(aEg.thePlayer, aEg.theWorld, var1);
            aEg.thePlayer.pl = f;
            aEg.thePlayer.rotationPitch = f1;
            if (flag) {
                aEg.rightClickDelayTimer = 0;
            }

            return flag;
        }
        return false;
    }

    private void gV() {
        if (!(aEg.thePlayer.fallDistance < this.CA.wo().floatValue())
            && !(aEg.thePlayer.motionY >= 0.0)
            && !aEg.thePlayer.isInWater()
            && !aEg.thePlayer.isInLava()
            && !aEg.thePlayer.onGround
            && !aEg.thePlayer.capabilities.isFlying) {
            int i = aik.e(Items.water_bucket);
            if (i != -1) {
                this.CF = i;
                SlotComponent.b(this.CF, true);
                this.CE = lt.ROTATING;
                this.qH = 0;
            }
        }
    }

    private void gW() {
        this.qH++;
        if (aEg.thePlayer.onGround || aEg.thePlayer.isInWater() || aEg.thePlayer.isDead || this.qH > 100) {
            cg.e("Auto MLG", "Failed - couldn't place water in time");
            this.gS();
        } else if (aEg.thePlayer.motionY > 0.5) {
            this.gS();
        } else {
            ItemStack itemstack = SlotComponent.getItemStack();
            if (itemstack != null && itemstack.getItem() == Items.water_bucket) {
                RotationComponent.setRotations(new Vector2f(aEg.thePlayer.pl, 90.0F), 10.0, MovementFix.NORMAL);
                double d0 = Math.max(aEg.thePlayer.motionY * 2.0, -4.5);
                if (this.o(d0)) {
                    MovingObjectPosition movingobjectposition = aef.c(RotationComponent.fk, aEg.playerController.getBlockReachDistance());
                    if (movingobjectposition != null
                        && movingobjectposition.typeOfHit == MovingObjectType.BLOCK
                        && movingobjectposition.sideHit != null
                        && movingobjectposition.getBlockPos() != null
                        && !(movingobjectposition.getBlockPos().getY() >= aEg.thePlayer.posY)) {
                        this.a(movingobjectposition.getBlockPos(), movingobjectposition.sideHit, movingobjectposition);
                        ItemStack itemstack1 = SlotComponent.getItemStack();
                        if (itemstack1 != null && itemstack1.getItem() == Items.water_bucket) {
                            ahj.l(new m());
                            ahj.l(new C08PacketPlayerBlockPlacement(itemstack1));
                            boolean flag1 = true;
                            if (flag1) {
                                this.CG = this.d(movingobjectposition);
                                aEg.rightClickDelayTimer = 0;
                                this.CE = lt.PLACED;
                                this.qH = 0;
                            }
                        } else {
                            cg.e("Auto MLG", "Failed - no water bucket in hand");
                            this.gS();
                        }
                    }
                }
            } else {
                cg.e("Auto MLG", "Failed - no water bucket in hand");
                this.gS();
            }
        }
    }

    private void gX() {
        this.qH++;
        RotationComponent.setRotations(new Vector2f(aEg.thePlayer.pl, 90.0F), 10.0, MovementFix.NORMAL);
        if (!aEg.thePlayer.onGround && !aEg.thePlayer.isInWater()) {
            if (this.qH > 60) {
                cg.e("Auto MLG", "Failed - landing timed out");
                this.gS();
            }
        } else {
            if (this.CC.wo()) {
                this.CE = lt.PICKUP;
                this.qH = 0;
            } else {
                cg.e("Auto MLG", "Water placed successfully!");
                this.gS();
                if (this.CD.wo()) {
                    this.toggle();
                }
            }
        }
    }

    private void gY() {
        this.qH++;
        ItemStack itemstack = SlotComponent.getItemStack();
        if (itemstack != null && itemstack.getItem() == Items.water_bucket) {
            cg.e("Auto MLG", "MLG successful!");
            this.gS();
            if (this.CD.wo()) {
                this.toggle();
            }
        } else {
            BlockPos blockpos = this.gU();
            if (blockpos != null) {
                RotationComponent.setRotations(aiu.h(new Vec3(blockpos.getX() + 0.5, blockpos.getY() + 0.5, blockpos.getZ() + 0.5)), 30.0, MovementFix.NORMAL);
            } else {
                RotationComponent.setRotations(new Vector2f(aEg.thePlayer.pl, 90.0F), 10.0, MovementFix.NORMAL);
            }

            if (this.qH >= this.CB.wo().intValue()) {
                ItemStack itemstack1 = SlotComponent.getItemStack();
                if (itemstack1 != null && itemstack1.getItem() == Items.bucket && blockpos != null && this.a(itemstack1, blockpos)) {
                    ahj.l(new m());
                    cg.e("Auto MLG", "MLG successful!");
                    this.gS();
                    if (this.CD.wo()) {
                        this.toggle();
                    }
                }
            }

            if (this.qH > this.CB.wo().intValue() + 40) {
                cg.e("Auto MLG", "Pickup timed out, resetting");
                this.gS();
            }
        }
    }
}
