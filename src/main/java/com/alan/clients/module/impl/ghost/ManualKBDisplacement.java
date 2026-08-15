package com.alan.clients.module.impl.ghost;

import com.alan.clients.component.impl.player.RotationComponent;
import com.alan.clients.component.impl.player.rotationcomponent.MovementFix;
import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.module.impl.combat.KillAura;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.other.AttackEvent;
import com.alan.clients.newevent.impl.other.WorldChangeEvent;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.NumberValue;
import hackclient.rise.afi;
import com.alan.clients.util.rotation.RotationUtil;
import hackclient.rise.le;
import java.util.function.Predicate;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWeb;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;

@ModuleInfo(
    aliases = {"KB Displacement", "Manual KB Displacement"},
    description = "Silently steers your post-hit server yaw toward nearby hazards for manual fights.",
    category = Category.GHOST
)
public final class ManualKBDisplacement extends Module {
    private final NumberValue rotationSpeed = new NumberValue("Rotation Speed", this, 8, 1, 20, 1);
    private final NumberValue trackingRange = new NumberValue("Tracking Range", this, 6.0, 3.0, 8.0, 0.1);
    private final BooleanValue debug = new BooleanValue("Debug", this, false);
    private EntityLivingBase Bq;
    private le Br;
    private int Bs;
    private String Bt = "";
    private int Bu = -1;
    @EventLink
    public final Listener<WorldChangeEvent> onWorldChange = var1 -> this.gQ();
    @EventLink
    public final Listener<AttackEvent> onAttack = var1 -> {
        KillAura killaura = this.e(KillAura.class);
        if (killaura == null || !killaura.isEnabled()) {
            if (!var1.isCancelled() && var1.dc() != null) {
                this.Bq = var1.dc();
                this.Bs = 2;
                this.a("armed", null, this.Bq);
            }
        }
    };
    @EventLink
    public final Listener<PreUpdateEvent> onPreUpdate = var1 -> {
        if (this.Bq != null) {
            if (this.Bs > 0) {
                this.Bs--;
            }

            if (!this.x(this.Bq)) {
                this.a("rejected:no-target", null, this.Bq);
                this.gQ();
            } else if (!this.eT()) {
                this.a("rejected:no-kb-source", null, this.Bq);
            } else if (this.Bq.hurtTime <= 0 && this.Bs <= 0) {
                this.a("rejected:hurt-time-ended", null, this.Bq);
                this.gQ();
            } else if (this.h(this.Bq)) {
                this.a("rejected:crit-priority", null, this.Bq);
            } else {
                this.Br = this.y(this.Bq);
                if (this.Br == null) {
                    this.a("rejected:no-plan", null, this.Bq);
                } else {
                    Vector2f vector2f = RotationUtil.calculate(this.Bq, true, this.trackingRange.wo().doubleValue());
                    Vector2f vector2f1 = new Vector2f(this.Br.Bz, vector2f.getY());
                    RotationComponent.a(vector2f1, this.rotationSpeed.wo().doubleValue(), MovementFix.NORMAL, null, true);
                    this.f(vector2f1);
                    this.a("applied", this.Br, this.Bq);
                }
            }
        }
    };

    public ManualKBDisplacement() {
    }

    @Override
    public void onEnable() {
        this.gQ();
    }

    @Override
    public void onDisable() {
        this.gQ();
    }

    private void gQ() {
        this.Bq = null;
        this.Br = null;
        this.Bs = 0;
        this.Bt = "";
        this.Bu = -1;
    }

    private boolean x(EntityLivingBase var1) {
        return var1 != null
            && !var1.isDead
            && aEg.thePlayer != null
            && aEg.theWorld != null
            && aEg.thePlayer.getDistanceToEntity(var1) <= this.trackingRange.wo().doubleValue() + 1.0;
    }

    private boolean eT() {
        return aEg.thePlayer != null && (aEg.thePlayer.isSprinting() || EnchantmentHelper.getKnockbackModifier(aEg.thePlayer) > 0);
    }

    private boolean g(EntityLivingBase var1) {
        return var1 != null
            && aEg.thePlayer.fallDistance > 0.0F
            && !aEg.thePlayer.onGround
            && !aEg.thePlayer.isOnLadder()
            && !aEg.thePlayer.isInWater()
            && !aEg.thePlayer.isPotionActive(Potion.blindness)
            && aEg.thePlayer.ridingEntity == null;
    }

    private boolean h(EntityLivingBase var1) {
        return this.g(var1) && aEg.thePlayer.motionY < 0.0;
    }

    private le y(EntityLivingBase var1) {
        AxisAlignedBB axisalignedbb = var1.getEntityBoundingBox();
        le le = null;

        for (int i = 0; i < 32; i++) {
            double d0 = (Math.PI * 2) * i / 32.0;
            double d1 = -Math.sin(d0);
            double d2 = Math.cos(d0);

            for (double d3 = 0.8; d3 <= 5.0; d3 += 0.35) {
                AxisAlignedBB axisalignedbb1 = axisalignedbb.offset(d1 * d3, 0.0, d2 * d3);
                le lex = this.b(var1, axisalignedbb1, d1, d2, d3);
                if (lex != null && (le == null || lex.BC > le.BC)) {
                    le = lex;
                }

                if (!aEg.theWorld.getCollidingBoundingBoxes(var1, axisalignedbb1.contract(0.02, 0.0, 0.02)).isEmpty()) {
                    break;
                }
            }
        }

        return le != null && le.BC >= 45.0 ? le : null;
    }

    private le b(EntityLivingBase var1, AxisAlignedBB var2, double var3, double var5, double var7) {
        AxisAlignedBB axisalignedbb = var2.contract(0.05, 0.0, 0.05);
        AxisAlignedBB axisalignedbb1 = axisalignedbb.offset(0.0, -0.35, 0.0);
        String s = null;
        double d0 = Double.NEGATIVE_INFINITY;
        if (this.a(axisalignedbb, Material.lava) || this.a(axisalignedbb1, Material.lava)) {
            s = "Lava";
            d0 = 150.0 - var7 * 8.0;
        } else if (this.a(axisalignedbb, BlockWeb.class) || this.a(axisalignedbb1, BlockWeb.class)) {
            s = "Web";
            d0 = 125.0 - var7 * 7.0;
        } else if (this.b(axisalignedbb) || this.b(axisalignedbb1)) {
            s = "Fire";
            d0 = 100.0 - var7 * 7.0;
        } else if (!this.a(axisalignedbb, Blocks.cactus) && !this.a(axisalignedbb1, Blocks.cactus)) {
            double d1 = this.a(axisalignedbb1, 24);
            if (d1 < 0.0) {
                s = axisalignedbb1.minY <= 8.0 ? "Void" : "Deep Drop";
                d0 = (axisalignedbb1.minY <= 8.0 ? 145.0 : 108.0) - var7 * 7.0;
            } else if (d1 >= 4.0) {
                s = "Ditch";
                d0 = 88.0 + Math.min(d1, 10.0) * 3.5 - var7 * 6.0;
            } else if (this.a(axisalignedbb, Material.water) || this.a(axisalignedbb1, Material.water)) {
                s = "Water";
                d0 = 58.0 + Math.max(0.0, d1) * 2.0 - var7 * 5.0;
            }
        } else {
            s = "Cactus";
            d0 = 96.0 - var7 * 6.0;
        }

        if (s == null) {
            return null;
        }

        float f = (float)Math.toDegrees(Math.atan2(var5, var3)) - 90.0F;
        float f1 = RotationUtil.calculate(var1, true, this.trackingRange.wo().doubleValue()).getY();
        return new le(var1.getEntityId(), f, f1, var7, d0, s);
    }

    private double a(AxisAlignedBB var1, int var2) {
        int i = MathHelper.floor_double(var1.minX + 1.0E-4);
        int j = MathHelper.floor_double(var1.maxX - 1.0E-4);
        int k = MathHelper.floor_double(var1.minZ + 1.0E-4);
        int l = MathHelper.floor_double(var1.maxZ - 1.0E-4);
        int i1 = MathHelper.floor_double(var1.minY) - 1;
        int j1 = Math.max(0, i1 - var2);
        double d0 = Double.POSITIVE_INFINITY;

        for (int k1 = i; k1 <= j; k1++) {
            for (int l1 = k; l1 <= l; l1++) {
                boolean flag = false;

                for (int i2 = i1; i2 >= j1; i2--) {
                    BlockPos blockpos = new BlockPos(k1, i2, l1);
                    IBlockState iblockstate = aEg.theWorld.getBlockState(blockpos);
                    AxisAlignedBB axisalignedbb = iblockstate.getBlock().getCollisionBoundingBox(aEg.theWorld, blockpos, iblockstate);
                    if (axisalignedbb != null) {
                        double d1 = Math.max(0.0, var1.minY - axisalignedbb.maxY);
                        d0 = Math.min(d0, d1);
                        flag = true;
                        break;
                    }
                }

                if (!flag) {
                    return -1.0;
                }
            }
        }

        return d0 == Double.POSITIVE_INFINITY ? -1.0 : d0;
    }

    private boolean a(AxisAlignedBB var1, Material var2) {
        return this.a(var1, var1x -> var1x.getMaterial() == var2);
    }

    private boolean a(AxisAlignedBB var1, Class<? extends Block> var2) {
        return this.a(var1, var2::isInstance);
    }

    private boolean a(AxisAlignedBB var1, Block var2) {
        return this.a(var1, var1x -> var1x == var2);
    }

    private boolean b(AxisAlignedBB var1) {
        return this.a(var1, var0 -> var0 == Blocks.fire || var0 == Blocks.flowing_lava || var0 == Blocks.lava);
    }

    private boolean a(AxisAlignedBB var1, Predicate<Block> var2) {
        int i = MathHelper.floor_double(var1.minX + 1.0E-4);
        int j = MathHelper.floor_double(var1.maxX - 1.0E-4);
        int k = MathHelper.floor_double(var1.minY + 1.0E-4);
        int l = MathHelper.floor_double(var1.maxY - 1.0E-4);
        int i1 = MathHelper.floor_double(var1.minZ + 1.0E-4);
        int j1 = MathHelper.floor_double(var1.maxZ - 1.0E-4);

        for (int k1 = i; k1 <= j; k1++) {
            for (int l1 = k; l1 <= l; l1++) {
                for (int i2 = i1; i2 <= j1; i2++) {
                    Block block = aEg.theWorld.getBlockState(new BlockPos(k1, l1, i2)).getBlock();
                    if (var2.test(block)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private void f(Vector2f var1) {
        if (var1 != null) {
            float f = aEg.thePlayer.pl + MathHelper.wrapAngleTo180_float(var1.getX() - aEg.thePlayer.pl);
        }
    }

    private void a(String var1, le var2, EntityLivingBase var3) {
        if (this.debug.wo() && aEg.thePlayer != null) {
            String s = var2 == null
                ? String.format("%s hurt=%d", var1, var3 == null ? -1 : var3.hurtTime)
                : String.format(
                    "%s %s score=%.1f yaw=%.1f pitch=%.1f dist=%.2f hurt=%d",
                    var1,
                    var2.BD,
                    var2.BC,
                    var2.Bz,
                    var2.BA,
                    var2.BB,
                    var3 == null ? -1 : var3.hurtTime
                );
            if (!s.equals(this.Bt) || aEg.thePlayer.ticksExisted - this.Bu >= 8) {
                this.Bt = s;
                this.Bu = aEg.thePlayer.ticksExisted;
                afi.c(afi.getPrefix() + "[KB Module] " + s);
            }
        }
    }
}
