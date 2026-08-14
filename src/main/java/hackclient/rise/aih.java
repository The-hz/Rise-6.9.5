package hackclient.rise;

import com.alan.clients.component.impl.player.RotationComponent;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.util.vector.Vector2f;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import lombok.Generated;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.Vec3i;
import net.minecraft.util.Vector3d;

public final class aih implements InstanceAccess {
    private static final HashMap<Integer, Integer> aOK = new aii();

    public static Block o(double var0, double var2, double var4) {
        return aEg.theWorld.getBlockState(new BlockPos(var0, var2, var4)).getBlock();
    }

    public static Block q(BlockPos var0) {
        return aEg.theWorld.getBlockState(var0).getBlock();
    }

    public static Block a(Vec3i var0) {
        return q(new BlockPos(var0));
    }

    public static Block c(aka var0) {
        return o(var0.getX(), var0.getY(), var0.getZ());
    }

    public static Block a(Vector3d var0) {
        return q(new BlockPos(new Vec3i(var0.x, var0.y, var0.z)));
    }

    public static double a(BlockPos var0, BlockPos var1) {
        double d0 = var0.getX() - var1.getX();
        double d1 = var0.getY() - var1.getY();
        double d2 = var0.getZ() - var1.getZ();
        return d0 * d0 + d1 * d1 + d2 * d2;
    }

    public static boolean vg() {
        return av(0);
    }

    public static boolean av(int var0) {
        if (aEg.thePlayer.onGround && aEg.thePlayer.isCollidedHorizontally) {
            for (ajz ajz : new ajz[]{new ajz(0, 1), new ajz(1, 0), new ajz(0, -1), new ajz(-1, 0)}) {
                if (!(p(ajz.ald, var0, ajz.ale) instanceof BlockAir) && p(ajz.ald, 1 + var0, ajz.ale) instanceof BlockAir) {
                    return true;
                }
            }

            return false;
        }
        return false;
    }

    public static Block p(double var0, double var2, double var4) {
        return o(aEg.thePlayer.posX + var0, aEg.thePlayer.posY + var2, aEg.thePlayer.posZ + var4);
    }

    public static Block o(double var0, double var2) {
        return p(-Math.sin(MoveUtil.direction()) * var0, var2, Math.cos(MoveUtil.direction()) * var0);
    }

    public static String g(EntityPlayer var0) {
        return var0.getName();
    }

    public static String R() {
        return aEg.thePlayer.getName();
    }

    public static boolean D(EntityLivingBase var0) {
        if (var0.getTeam() != null && aEg.thePlayer.getTeam() != null) {
            char c0 = var0.getDisplayName().getFormattedText().charAt(1);
            char c1 = aEg.thePlayer.getDisplayName().getFormattedText().charAt(1);
            return c0 == c1;
        }
        return false;
    }

    public static boolean ad(double var0) {
        return a(var0, true);
    }

    public static boolean a(double var0, boolean var2) {
        if (var2) {
            AxisAlignedBB axisalignedbb = aEg.thePlayer.getEntityBoundingBox().offset(0.0, -var0, 0.0);
            if (!aEg.theWorld.getCollidingBoundingBoxes(aEg.thePlayer, axisalignedbb).isEmpty()) {
                return true;
            }
        } else {
            for (int i = 0; i < var0; i++) {
                if (p(0.0, -i, 0.0).isFullBlock()) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean b(double var0, boolean var2) {
        AxisAlignedBB axisalignedbb = aEg.thePlayer.getEntityBoundingBox().offset(0.0, var0 / 2.0, 0.0).expand(0.0, var0 - aEg.thePlayer.height, 0.0);
        return !aEg.theWorld.getCollidingBoundingBoxes(aEg.thePlayer, axisalignedbb).isEmpty();
    }

    public static boolean vh() {
        return ad(10.0);
    }

    public static boolean ae(double var0) {
        AxisAlignedBB axisalignedbb = aEg.thePlayer.getEntityBoundingBox().offset(0.0, var0, 0.0);
        return !aEg.theWorld.getCollidingBoundingBoxes(aEg.thePlayer, axisalignedbb).isEmpty();
    }

    public static double vi() {
        AxisAlignedBB axisalignedbb = aEg.thePlayer.getEntityBoundingBox();
        int i = MathHelper.floor_double(axisalignedbb.minX + 1.0E-7);
        int j = MathHelper.floor_double(axisalignedbb.maxX - 1.0E-7);
        int k = MathHelper.floor_double(axisalignedbb.minZ + 1.0E-7);
        int l = MathHelper.floor_double(axisalignedbb.maxZ - 1.0E-7);
        double d0 = axisalignedbb.minY;
        double d1 = Double.POSITIVE_INFINITY;

        for (int i1 = i; i1 <= j; i1++) {
            for (int j1 = k; j1 <= l; j1++) {
                for (int k1 = MathHelper.floor_double(d0) - 1; k1 >= 0; k1--) {
                    BlockPos blockpos = new BlockPos(i1, k1, j1);
                    IBlockState iblockstate = aEg.theWorld.getBlockState(blockpos);
                    AxisAlignedBB axisalignedbb1 = iblockstate.getBlock().getCollisionBoundingBox(aEg.theWorld, blockpos, iblockstate);
                    if (axisalignedbb1 != null) {
                        double d2 = axisalignedbb1.maxY;
                        if (d0 >= d2) {
                            double d3 = d0 - d2;
                            if (d3 < d1) {
                                d1 = d3;
                            }
                        } else {
                            d1 = 0.0;
                        }
                        break;
                    }
                }
            }
        }

        return d1 == Double.POSITIVE_INFINITY ? -1.0 : d1;
    }

    public static boolean aw(int var0) {
        return aOK.containsKey(var0);
    }

    public static int ax(int var0) {
        return aOK.getOrDefault(var0, -1);
    }

    public static boolean vj() {
        return aEg.thePlayer.isInWater() || aEg.thePlayer.isInLava();
    }

    public static void fakeDamage() {
        aEg.thePlayer.handleStatusUpdate((byte)2);
        aEg.ingameGUI.healthUpdateCounter = aEg.ingameGUI.updateCounter + 20;
    }

    public static boolean ay(int var0) {
        for (int i = -var0; i <= var0; i++) {
            for (int j = -var0; j <= var0; j++) {
                for (int k = -var0; k <= var0; k++) {
                    if (!(p(i, j, k) instanceof BlockAir)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean a(int var0, Material var1) {
        for (int i = -var0; i <= var0; i++) {
            for (int j = -var0; j <= var0; j++) {
                for (int k = -var0; k <= var0; k++) {
                    if (p(i, j, k).getMaterial().equals(var1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean vk() {
        if (aEg.thePlayer.ticksExisted < 5) {
            return false;
        }

        EntityPlayerSP entityplayersp = aEg.thePlayer;
        WorldClient worldclient = aEg.theWorld;
        AxisAlignedBB axisalignedbb = entityplayersp.getEntityBoundingBox();

        for (int i = MathHelper.floor_double(axisalignedbb.minX); i < MathHelper.floor_double(axisalignedbb.maxX) + 1; i++) {
            for (int j = MathHelper.floor_double(axisalignedbb.minY); j < MathHelper.floor_double(axisalignedbb.maxY) + 1; j++) {
                for (int k = MathHelper.floor_double(axisalignedbb.minZ); k < MathHelper.floor_double(axisalignedbb.maxZ) + 1; k++) {
                    Block block = worldclient.getBlockState(new BlockPos(i, j, k)).getBlock();
                    AxisAlignedBB axisalignedbb1;
                    if (block != null
                        && !(block instanceof BlockAir)
                        && (
                                axisalignedbb1 = block.getCollisionBoundingBox(
                                    worldclient, new BlockPos(i, j, k), worldclient.getBlockState(new BlockPos(i, j, k))
                                )
                            )
                            != null
                        && entityplayersp.getEntityBoundingBox().intersectsWith(axisalignedbb1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void h(int var0, boolean var1) {
        int i = var0 == 0 ? aEg.gameSettings.cgK.getKeyCode() : aEg.gameSettings.cgI.getKeyCode();
        KeyBinding.setKeyBindState(i, var1);
        if (var1) {
            KeyBinding.onTick(i);
        }
    }

    public static boolean vl() {
        boolean flag = false;
        AxisAlignedBB axisalignedbb = aEg.thePlayer.getEntityBoundingBox();
        WorldClient worldclient = aEg.theWorld;
        int i = (int)axisalignedbb.offset(0.0, -0.01, 0.0).minY;

        for (int j = MathHelper.floor_double(axisalignedbb.minX); j < MathHelper.floor_double(axisalignedbb.maxX) + 1; j++) {
            for (int k = MathHelper.floor_double(axisalignedbb.minZ); k < MathHelper.floor_double(axisalignedbb.maxZ) + 1; k++) {
                Block block = worldclient.getBlockState(new BlockPos(j, i, k)).getBlock();
                if (block != null && !(block instanceof BlockAir)) {
                    if (!(block instanceof BlockLiquid)) {
                        return false;
                    }

                    flag = true;
                }
            }
        }

        return flag;
    }

    public static aib e(Vec3 var0) {
        return a(var0, false);
    }

    public static aib a(Vec3 var0, boolean var1) {
        ArrayList arraylist = new ArrayList();

        for (byte b0 = -1; b0 <= 1; b0 += 2) {
            if (!o(var0.xCoord, var0.yCoord, var0.zCoord + b0).isReplaceable(aEg.theWorld, new BlockPos(var0.xCoord, var0.yCoord, var0.zCoord + b0))) {
                if (b0 < 0) {
                    arraylist.add(new aib(EnumFacing.SOUTH, new Vec3(0.0, 0.0, b0)));
                } else {
                    arraylist.add(new aib(EnumFacing.NORTH, new Vec3(0.0, 0.0, b0)));
                }
            }
        }

        for (byte b1 = -1; b1 <= 1; b1 += 2) {
            if (!o(var0.xCoord + b1, var0.yCoord, var0.zCoord).isReplaceable(aEg.theWorld, new BlockPos(var0.xCoord + b1, var0.yCoord, var0.zCoord))) {
                if (b1 > 0) {
                    arraylist.add(new aib(EnumFacing.WEST, new Vec3(b1, 0.0, 0.0)));
                } else {
                    arraylist.add(new aib(EnumFacing.EAST, new Vec3(b1, 0.0, 0.0)));
                }
            }
        }

        arraylist.sort(Comparator.comparingDouble(var0x -> {
            double d0 = Math.toDegrees(Math.atan2(((aib)var0x).vb().zCoord, ((aib)var0x).vb().xCoord)) % 360.0;
            double d1 = RotationComponent.fk.x % 360.0F + 90.0F;
            return Math.abs(ahg.n(d0, d1));
        }));
        if (!arraylist.isEmpty()) {
            return (aib)arraylist.get(0);
        }

        for (byte b2 = -1; b2 <= 1; b2 += 2) {
            if (!o(var0.xCoord, var0.yCoord + b2, var0.zCoord).isReplaceable(aEg.theWorld, new BlockPos(var0.xCoord, var0.yCoord + b2, var0.zCoord))) {
                if (b2 < 0) {
                    return new aib(EnumFacing.UP, new Vec3(0.0, b2, 0.0));
                }

                if (var1) {
                    return new aib(EnumFacing.DOWN, new Vec3(0.0, b2, 0.0));
                }
            }
        }

        return null;
    }

    public static Vec3 q(double var0, double var2, double var4) {
        return a(var0, var2, var4, (Integer)null);
    }

    public static Vec3 a(double var0, double var2, double var4, Integer var6) {
        ArrayList arraylist = new ArrayList();
        int i = (int)(5.0 + (Math.abs(var0) + Math.abs(var4)));

        for (int j = -i; j <= i; j++) {
            for (int k = -i; k <= i; k++) {
                for (int l = -i; l <= i; l++) {
                    BlockPos blockpos = new BlockPos(aEg.thePlayer.posX + j, aEg.thePlayer.posY + k, aEg.thePlayer.posZ + l);
                    Block block = aEg.theWorld.getBlockState(blockpos).getBlock();
                    if (block != Blocks.chest
                        && block != Blocks.trapped_chest
                        && block != Blocks.anvil
                        && block != Blocks.crafting_table
                        && block != Blocks.furnace
                        && block != Blocks.lit_furnace
                        && block != Blocks.hopper
                        && block != Blocks.dropper
                        && block != Blocks.dispenser
                        && block != Blocks.noteblock
                        && block != Blocks.jukebox) {
                        if ((!block.isFullBlock() || !block.isNormalCube())
                            && !(block instanceof BlockStairs)
                            && block instanceof BlockSlab
                            && aEg.thePlayer.onGround) {
                            double d0;
                            d0 = Math.abs(aEg.thePlayer.posY - Math.round(aEg.thePlayer.posY)) - 0.03;
                        }

                        if (!block.isReplaceable(aEg.theWorld, blockpos)) {
                            for (byte b0 = -1; b0 <= 1; b0 += 2) {
                                arraylist.add(new Vec3(aEg.thePlayer.posX + j + b0, aEg.thePlayer.posY + k, aEg.thePlayer.posZ + l));
                            }

                            for (byte b1 = -1; b1 <= 1; b1 += 2) {
                                arraylist.add(new Vec3(aEg.thePlayer.posX + j, aEg.thePlayer.posY + k + b1, aEg.thePlayer.posZ + l));
                            }

                            for (byte b2 = -1; b2 <= 1; b2 += 2) {
                                arraylist.add(new Vec3(aEg.thePlayer.posX + j, aEg.thePlayer.posY + k, aEg.thePlayer.posZ + l + b2));
                            }
                        }
                    }
                }
            }
        }

        arraylist.removeIf(
            var0x -> aEg.thePlayer.getDistance(((Vec3)var0x).xCoord, ((Vec3)var0x).yCoord, ((Vec3)var0x).zCoord) > 5.0
                || !o(((Vec3)var0x).xCoord, ((Vec3)var0x).yCoord, ((Vec3)var0x).zCoord).isReplaceable(aEg.theWorld, new BlockPos(((Vec3)var0x).xCoord, ((Vec3)var0x).yCoord, ((Vec3)var0x).zCoord))
        );
        if (arraylist.isEmpty()) {
            return null;
        }

        if (var6 != null) {
            arraylist.removeIf(var1 -> Math.floor(((Vec3)var1).yCoord + 1.0) != var6.intValue());
        }

        arraylist.sort(Comparator.comparingDouble(var6x -> {
            double d1 = aEg.thePlayer.posX + var0 - ((Vec3)var6x).xCoord;
            double d2 = aEg.thePlayer.posY - 1.0 + var2 - ((Vec3)var6x).yCoord;
            double d3 = aEg.thePlayer.posZ + var4 - ((Vec3)var6x).zCoord;
            return MathHelper.sqrt_double(d1 * d1 + d2 * d2 + d3 * d3);
        }));
        return arraylist.isEmpty() ? null : (Vec3)arraylist.getFirst();
    }

    public static EntityOtherPlayerMP c(EntityOtherPlayerMP var0) {
        EntityOtherPlayerMP entityotherplayermp = new EntityOtherPlayerMP(var0.getEntityWorld(), var0.getGameProfile());
        entityotherplayermp.motionX = var0.motionX;
        entityotherplayermp.motionY = var0.motionY;
        entityotherplayermp.motionZ = var0.motionZ;
        entityotherplayermp.pl = var0.pl;
        entityotherplayermp.setEntityId(var0.getEntityId());
        entityotherplayermp.lastTickPosX = var0.lastTickPosX;
        entityotherplayermp.lastTickPosY = var0.lastTickPosY;
        entityotherplayermp.lastTickPosZ = var0.lastTickPosZ;
        entityotherplayermp.setPosition(var0.posX, var0.posY, var0.posZ);
        return entityotherplayermp;
    }

    public static double v(Entity var0) {
        if (var0 != null && aEg.thePlayer != null) {
            AxisAlignedBB axisalignedbb = var0.getEntityBoundingBox();
            if (axisalignedbb != null && !axisalignedbb.hasNaN() && w(var0)) {
                Vec3 vec3 = aEg.thePlayer.getPositionEyes(1.0F);
                if (af(vec3.xCoord) && af(vec3.yCoord) && af(vec3.zCoord)) {
                    Vector2f vector2f = aiu.y(var0);
                    if (vector2f != null && af(vector2f.getX()) && af(vector2f.getY())) {
                        Vec3 vec31 = aEg.thePlayer.getVectorForRotation(vector2f.getY(), vector2f.getX());
                        if (af(vec31.xCoord) && af(vec31.yCoord) && af(vec31.zCoord)) {
                            MovingObjectPosition movingobjectposition = axisalignedbb.expand(0.1, 0.1, 0.1)
                                .calculateIntercept(vec3, vec3.addVector(vec31.xCoord * 1000.0, vec31.yCoord * 1000.0, vec31.zCoord * 1000.0));
                            if (movingobjectposition != null && movingobjectposition.hitVec != null) {
                                double d0 = movingobjectposition.hitVec.distanceTo(vec3);
                                return af(d0) ? d0 : aEg.thePlayer.getDistanceToEntity(var0);
                            }
                            return aEg.thePlayer.getDistanceToEntity(var0);
                        } else {
                            return aEg.thePlayer.getDistanceToEntity(var0);
                        }
                    } else {
                        return aEg.thePlayer.getDistanceToEntity(var0);
                    }
                } else {
                    return aEg.thePlayer.getDistanceToEntity(var0);
                }
            } else {
                return aEg.thePlayer.getDistanceToEntity(var0);
            }
        } else {
            return Double.MAX_VALUE;
        }
    }

    private static boolean w(Entity var0) {
        return af(var0.posX) && af(var0.posY) && af(var0.posZ);
    }

    private static boolean af(double var0) {
        return !Double.isNaN(var0) && !Double.isInfinite(var0);
    }

    @Generated
    private aih() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
