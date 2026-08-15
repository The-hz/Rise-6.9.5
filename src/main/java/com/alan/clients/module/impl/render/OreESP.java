package com.alan.clients.module.impl.render;

import com.alan.clients.Client;
import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.render.Render3DEvent;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.NumberValue;
import com.alan.clients.util.render.ColorUtil;
import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import org.lwjgl.opengl.GL11;
import rip.vantage.commons.util.time.a;

@ModuleInfo(aliases = {"XRay", "X-Ray", "Ore ESP"}, description = "Shows ores through walls with ESP and tracers", category = Category.RENDER)
public final class OreESP extends Module {
    public static int apY;
    public static boolean apZ;
    public static List<Integer> aqa = Arrays.asList(
        10, 11, 8, 9, 14, 15, 16, 21, 41, 42, 46, 48, 52, 56, 57, 61, 62, 73, 74, 84, 89, 103, 116, 117, 118, 120, 129, 133, 137, 145, 152, 153, 154
    );
    public static List<BlockPos> aqb = new CopyOnWriteArrayList<>();
    private final a aqc = new a();
    private final NumberValue opacity = new NumberValue("Opacity", this, 160, 0, 255, 1);
    private final NumberValue worldOpacity = new NumberValue("World Opacity", this, 50, 0, 255, 1);
    private final BooleanValue eSP = new BooleanValue("ESP", this, true);
    private final BooleanValue tracers = new BooleanValue("Tracers", this, true);
    private final BooleanValue diamond = new BooleanValue("Diamond", this, true);
    private final BooleanValue redstone = new BooleanValue("Redstone", this, false);
    private final BooleanValue emerald = new BooleanValue("Emerald", this, false);
    private final BooleanValue lapis = new BooleanValue("Lapis", this, false);
    private final BooleanValue iron = new BooleanValue("Iron", this, false);
    private final BooleanValue coal = new BooleanValue("Coal", this, false);
    private final BooleanValue gold = new BooleanValue("Gold", this, false);
    private final NumberValue distance = new NumberValue("Distance", this, 42, 16, 64, 1);
    private final BooleanValue chunkUpdate = new BooleanValue("Chunk Update", this, false);
    private final NumberValue updateDelay = new NumberValue("Update Delay", this, 10.0, 1.0, 30.0, 0.5);
    @EventLink
    public final Listener<PreUpdateEvent> onPreUpdate = var1 -> {
        if (apY != this.opacity.wo().intValue()) {
            aEg.renderGlobal.loadRenderers();
            apY = this.opacity.wo().intValue();
        } else if (this.chunkUpdate.wo() && this.aqc.T(this.updateDelay.wo().longValue() * 1000L)) {
            aEg.renderGlobal.loadRenderers();
            this.aqc.aX();
        }

        this.mh();
    };
    @EventLink
    public final Listener<Render3DEvent> onRender3D = var1 -> {
        if (this.eSP.wo() || this.tracers.wo()) {
            for (BlockPos blockpos : aqb) {
                Block block = aEg.theWorld.getBlockState(blockpos).getBlock();
                Color color = this.f(block);
                if (color != null) {
                    this.a(blockpos, color.getRed(), color.getGreen(), color.getBlue());
                }
            }
        }
    };

    public OreESP() {
    }

    @Override
    public void onEnable() {
        this.w(true);
    }

    @Override
    public void onDisable() {
        this.w(false);
        this.aqc.aX();
    }

    private void w(boolean var1) {
        aqb.clear();
        aEg.renderGlobal.loadRenderers();
        apZ = var1;
    }

    private void mh() {
        if (aEg.thePlayer != null && aEg.theWorld != null) {
            aqb.clear();
            int i = this.distance.wo().intValue();
            BlockPos blockpos = new BlockPos(aEg.thePlayer.posX, aEg.thePlayer.posY, aEg.thePlayer.posZ);

            for (int j = -i; j <= i; j++) {
                for (int k = -i; k <= i; k++) {
                    for (int l = -i; l <= i; l++) {
                        BlockPos blockpos1 = blockpos.add(j, k, l);
                        Block block = aEg.theWorld.getBlockState(blockpos1).getBlock();
                        if (this.e(block)) {
                            aqb.add(blockpos1);
                        }
                    }
                }
            }
        }
    }

    private boolean e(Block var1) {
        if (this.diamond.wo() && var1 == Blocks.diamond_ore) {
            return true;
        } else if (this.iron.wo() && var1 == Blocks.iron_ore) {
            return true;
        } else if (this.gold.wo() && var1 == Blocks.gold_ore) {
            return true;
        } else if (this.lapis.wo() && var1 == Blocks.lapis_ore) {
            return true;
        } else if (!this.redstone.wo() || var1 != Blocks.redstone_ore && var1 != Blocks.lit_redstone_ore) {
            return this.coal.wo() && var1 == Blocks.coal_ore ? true : this.emerald.wo() && var1 == Blocks.emerald_ore;
        }
        return true;
    }

    private Color f(Block var1) {
        if (var1 == Blocks.diamond_ore) {
            return new Color(0, 255, 255);
        } else if (var1 == Blocks.iron_ore) {
            return new Color(225, 225, 225);
        } else if (var1 == Blocks.lapis_ore) {
            return new Color(0, 0, 255);
        } else if (var1 == Blocks.redstone_ore || var1 == Blocks.lit_redstone_ore) {
            return new Color(255, 0, 0);
        } else if (var1 == Blocks.coal_ore) {
            return new Color(64, 64, 64);
        } else if (var1 == Blocks.emerald_ore) {
            return new Color(0, 255, 0);
        }
        return var1 == Blocks.gold_ore ? new Color(255, 255, 0) : null;
    }

    private void a(BlockPos var1, int var2, int var3, int var4) {
        int i = this.opacity.wo().intValue();
        Color color = new Color(var2, var3, var4, i);
        if (this.eSP.wo()) {
            this.a(var1, color);
        }

        if (this.tracers.wo()) {
            this.b(var1, color);
        }
    }

    private void a(BlockPos var1, Color var2) {
        double d0 = var1.getX() - aEg.getRenderManager().viewerPosX;
        double d1 = var1.getY() - aEg.getRenderManager().viewerPosY;
        double d2 = var1.getZ() - aEg.getRenderManager().viewerPosZ;
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3553);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glDisable(2884);
        ColorUtil.d(var2);
        this.e(new AxisAlignedBB(d0, d1, d2, d0 + 1.0, d1 + 1.0, d2 + 1.0));
        GL11.glEnable(2884);
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }

    private void b(BlockPos var1, Color var2) {
        double d0 = var1.getX() + 0.5 - aEg.getRenderManager().viewerPosX;
        double d1 = var1.getY() + 0.5 - aEg.getRenderManager().viewerPosY;
        double d2 = var1.getZ() + 0.5 - aEg.getRenderManager().viewerPosZ;
        double d3 = aEg.thePlayer.lastTickPosX + (aEg.thePlayer.posX - aEg.thePlayer.lastTickPosX) * aEg.timer.bWm - aEg.getRenderManager().viewerPosX;
        double d4 = aEg.thePlayer.lastTickPosY
            + (aEg.thePlayer.posY - aEg.thePlayer.lastTickPosY) * aEg.timer.bWm
            - aEg.getRenderManager().viewerPosY
            + aEg.thePlayer.getEyeHeight();
        double d5 = aEg.thePlayer.lastTickPosZ + (aEg.thePlayer.posZ - aEg.thePlayer.lastTickPosZ) * aEg.timer.bWm - aEg.getRenderManager().viewerPosZ;
        RenderUtil.drawLine(d3, d4, d5, d0, d1, d2, var2, 2.0F);
    }

    private void e(AxisAlignedBB var1) {
        GL11.glBegin(7);
        GL11.glVertex3d(var1.minX, var1.minY, var1.minZ);
        GL11.glVertex3d(var1.maxX, var1.minY, var1.minZ);
        GL11.glVertex3d(var1.maxX, var1.minY, var1.maxZ);
        GL11.glVertex3d(var1.minX, var1.minY, var1.maxZ);
        GL11.glVertex3d(var1.minX, var1.maxY, var1.minZ);
        GL11.glVertex3d(var1.minX, var1.maxY, var1.maxZ);
        GL11.glVertex3d(var1.maxX, var1.maxY, var1.maxZ);
        GL11.glVertex3d(var1.maxX, var1.maxY, var1.minZ);
        GL11.glVertex3d(var1.minX, var1.minY, var1.maxZ);
        GL11.glVertex3d(var1.maxX, var1.minY, var1.maxZ);
        GL11.glVertex3d(var1.maxX, var1.maxY, var1.maxZ);
        GL11.glVertex3d(var1.minX, var1.maxY, var1.maxZ);
        GL11.glVertex3d(var1.maxX, var1.minY, var1.minZ);
        GL11.glVertex3d(var1.minX, var1.minY, var1.minZ);
        GL11.glVertex3d(var1.minX, var1.maxY, var1.minZ);
        GL11.glVertex3d(var1.maxX, var1.maxY, var1.minZ);
        GL11.glVertex3d(var1.minX, var1.minY, var1.minZ);
        GL11.glVertex3d(var1.minX, var1.minY, var1.maxZ);
        GL11.glVertex3d(var1.minX, var1.maxY, var1.maxZ);
        GL11.glVertex3d(var1.minX, var1.maxY, var1.minZ);
        GL11.glVertex3d(var1.maxX, var1.minY, var1.maxZ);
        GL11.glVertex3d(var1.maxX, var1.minY, var1.minZ);
        GL11.glVertex3d(var1.maxX, var1.maxY, var1.minZ);
        GL11.glVertex3d(var1.maxX, var1.maxY, var1.maxZ);
        GL11.glEnd();
    }

    public static boolean mi() {
        OreESP oreesp = Client.a.g().c(OreESP.class);
        return oreesp != null && oreesp.eSP.wo();
    }

    public static int mj() {
        OreESP oreesp = Client.a.g().c(OreESP.class);
        return oreesp != null ? oreesp.distance.wo().intValue() : 42;
    }

    public static boolean mk() {
        OreESP oreesp = Client.a.g().c(OreESP.class);
        return oreesp != null && oreesp.isEnabled();
    }

    public static float ml() {
        OreESP oreesp = Client.a.g().c(OreESP.class);
        return oreesp != null && oreesp.isEnabled() ? oreesp.worldOpacity.wo().floatValue() / 255.0F : 1.0F;
    }
}
