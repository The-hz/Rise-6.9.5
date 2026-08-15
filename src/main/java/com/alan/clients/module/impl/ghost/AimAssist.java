package com.alan.clients.module.impl.ghost;

import com.alan.clients.component.impl.player.RotationComponent;
import com.alan.clients.component.impl.player.SlotComponent;
import com.alan.clients.component.impl.player.rotationcomponent.MovementFix;
import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.module.impl.combat.Piercing;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.NumberValue;
import com.alan.clients.value.impl.SubMode;
import hackclient.rise.aef;
import hackclient.rise.aiu;
import hackclient.rise.bv;
import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemSword;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.MovingObjectPosition;

@ModuleInfo(aliases = "module.ghost.aimassist.name", description = "module.ghost.aimassist.description", category = Category.GHOST)
public final class AimAssist extends Module {
    private final ModeValue mode = new ModeValue("Mode", this).add(new SubMode("Legit")).add(new SubMode("Blatant")).setDefault("Legit");
    private final NumberValue speed = new NumberValue("Speed", this, 2, 1, 180, 1);
    private final BooleanValue silent = new BooleanValue("Silent", this, false);
    private final BooleanValue requireSwinging = new BooleanValue("Require Swinging", this, true);
    private final BooleanValue sticky = new BooleanValue("Sticky", this, false);
    private final BooleanValue requireMouseMovement = new BooleanValue("Require Mouse Movement", this, false);
    private final BooleanValue limitItems = new BooleanValue("Limit Items", this, false);
    private final BooleanValue aimWhilstOnTarget = new BooleanValue("Aim Whilst on Target", this, false);
    private final NumberValue fOV = new NumberValue("FOV", this, 90, 0, 360, 1);
    private final BooleanValue showTargets = new BooleanValue("Targets", this, false);
    public final BooleanValue player = new BooleanValue("Player", this, true, () -> !this.showTargets.wo());
    public final BooleanValue invisibles = new BooleanValue("Invisibles", this, false, () -> !this.showTargets.wo());
    public final BooleanValue animals = new BooleanValue("Animals", this, false, () -> !this.showTargets.wo());
    public final BooleanValue mobs = new BooleanValue("Mobs", this, false, () -> !this.showTargets.wo());
    public final BooleanValue playerTeammates = new BooleanValue("Player Teammates", this, true, () -> !this.showTargets.wo());
    EntityLivingBase target;
    @EventLink
    public final Listener<PreUpdateEvent> onPreUpdate = var1 -> {
        double d0 = this.n(4.0);
        Vector2f vector2f = new Vector2f(aEg.thePlayer.pl, aEg.thePlayer.rotationPitch);
        if (this.d(vector2f)) {
            this.e(vector2f);
        } else {
            List list = bv.a(d0, this.player.wo(), this.invisibles.wo(), this.animals.wo(), this.mobs.wo(), this.playerTeammates.wo());
            if (list.isEmpty()) {
                this.target = null;
            } else {
                this.target = (EntityLivingBase)list.get(0);
                if (this.target != null) {
                    boolean flag = this.gO();
                    Vector2f vector2f1 = this.gN();
                    Vector2f vector2f2 = this.b(this.target, d0, flag);
                    float f = Math.abs(MathHelper.wrapAngleTo180_float(aiu.y(this.target).getX() - vector2f.getX()));
                    if (flag || aiu.a(vector2f2, this.target, d0, false, this.gP() ? this.gr() : 0.0F)) {
                        if (!(f > this.fOV.wo().intValue())) {
                            if (this.limitItems.wo()) {
                                SlotComponent slotcomponent = this.d(SlotComponent.class);
                                if (SlotComponent.getItemStack() == null) {
                                    return;
                                }

                                slotcomponent = this.d(SlotComponent.class);
                                if (!(SlotComponent.getItemStack().getItem() instanceof ItemSword)) {
                                    return;
                                }
                            }

                            double d1 = this.i(f);
                            if (this.s(flag)) {
                                Vector2f vector2f3 = this.a(vector2f1, vector2f2, flag);
                                RotationComponent.d(false);
                                RotationComponent.a(vector2f3, d1 / 36.0, MovementFix.NORMAL, null, this.silent.wo(), !this.silent.wo());
                            }
                        }
                    }
                }
            }
        }
    };

    public AimAssist() {
    }

    private boolean d(Vector2f var1) {
        if (!aEg.bgA || aEg.currentScreen != null) {
            return false;
        }

        if (!aEg.gameSettings.cgI.isKeyDown() && !aEg.gameSettings.cgK.isKeyDown()) {
            return false;
        }

        MovingObjectPosition movingobjectposition = aef.a(var1, aEg.playerController.getBlockReachDistance(), 0.0F, aEg.thePlayer, false);
        return movingobjectposition != null && movingobjectposition.typeOfHit == MovingObjectType.BLOCK;
    }

    private void e(Vector2f var1) {
        this.target = null;
        RotationComponent.d(false);
        RotationComponent.a(var1, 10.0, MovementFix.NORMAL, null, true, false);
    }

    private boolean s(boolean var1) {
        if (this.requireMouseMovement.wo() && aEg.bgr.dyD == 0 && aEg.bgr.dyE == 0) {
            return false;
        }

        if (this.requireSwinging.wo() && !aEg.thePlayer.isSwingInProgress) {
            return false;
        }

        if (this.aimWhilstOnTarget.wo()) {
            return true;
        }

        MovingObjectPosition movingobjectposition = aef.a(new Vector2f(aEg.thePlayer.pl, aEg.thePlayer.rotationPitch), 3.0, 0.0F, aEg.thePlayer, false);
        return movingobjectposition == null || movingobjectposition.typeOfHit != MovingObjectType.ENTITY;
    }

    private Vector2f gN() {
        return this.silent.wo() ? RotationComponent.bH() : new Vector2f(aEg.thePlayer.pl, aEg.thePlayer.rotationPitch);
    }

    private double i(float var1) {
        double d0 = this.speed.wo().doubleValue() * (this.sticky.wo() ? 10 : 1);
        double d1 = Math.min(1.0, var1 / 45.0);
        return Math.max(0.05, d0 * (0.35 + d1 * 0.65));
    }

    private Vector2f a(Vector2f var1, Vector2f var2, boolean var3) {
        return new Vector2f(var2.getX(), !this.gP() && !var3 ? var1.getY() : var2.getY());
    }

    private Vector2f b(EntityLivingBase var1, double var2, boolean var4) {
        if (!this.gP() && !var4) {
            return aiu.y(var1);
        }

        AxisAlignedBB axisalignedbb = var1.getEntityBoundingBox();
        float f = this.gr();
        if (axisalignedbb != null && !axisalignedbb.hasNaN()) {
            if (f > 0.0F) {
                axisalignedbb = axisalignedbb.expand(f, f, f);
            }

            return aiu.a(var1, axisalignedbb, true, var2, var4, f);
        }
        return aiu.y(var1);
    }

    private double n(double var1) {
        Piercing piercing = this.e(Piercing.class);
        if (piercing != null && piercing.isEnabled()) {
            return Math.max(var1, piercing.gq());
        }

        Reach reach = this.e(Reach.class);
        return reach != null && reach.isEnabled() ? Math.max(var1, reach.range.wA().doubleValue()) : var1;
    }

    private float gr() {
        Piercing piercing = this.e(Piercing.class);
        if (piercing != null && piercing.isEnabled()) {
            return piercing.gr();
        }

        HitBox hitbox = this.e(HitBox.class);
        return hitbox != null && hitbox.isEnabled() ? hitbox.expand.wo().floatValue() : 0.0F;
    }

    private boolean gO() {
        Piercing piercing = this.e(Piercing.class);
        return piercing != null && piercing.isEnabled();
    }

    private boolean gP() {
        return this.mode.wo().getName().equals("Blatant");
    }
}
