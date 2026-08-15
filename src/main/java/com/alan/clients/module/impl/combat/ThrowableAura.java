package com.alan.clients.module.impl.combat;

import com.alan.clients.Client;
import com.alan.clients.component.impl.player.RotationComponent;
import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.module.impl.ghost.AimBacktrack;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.NumberValue;
import hackclient.rise.aef;
import hackclient.rise.aih;
import hackclient.rise.aik;
import java.util.Comparator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

@ModuleInfo(aliases = "module.combat.throwableaura.name", description = "module.combat.throwableaura.description", category = Category.COMBAT)
public class ThrowableAura extends Module {
    public int qH;
    public BooleanValue qy;
    public int qI;
    public EntityLivingBase jE;
    public BooleanValue qB;
    public NumberValue qw;
    public boolean qJ;
    public BooleanValue qx;
    public BooleanValue qC;
    public NumberValue qu;
    public NumberValue qt;
    public BooleanValue qA;
    @EventLink
    public Listener<PreUpdateEvent> qK;
    public BooleanValue qF;
    public BooleanValue qE;
    public BooleanValue qG;
    public NumberValue qv;
    public NumberValue qs = new NumberValue("Rotation Range", this, 8.0, 1.0, 15.0, 0.1);
    public BooleanValue qz;
    public BooleanValue qD;

    @Override
    public void onEnable() {
        this.qH = 0;
        this.qI = -1;
        this.qJ = false;
        this.jE = null;
    }


    public Vec3 i(Entity var1) {
        Vec3 vec3 = var1.getPositionVector().addVector(0.0, var1.getEyeHeight() * 0.5, 0.0);
        double d1 = aEg.thePlayer.getDistanceToEntity(var1) / 1.5;
        return vec3.addVector(var1.motionX * d1, var1.motionY * d1, var1.motionZ * d1);
    }

    @Override
    public void onDisable() {
        if (this.qA.wo() && this.qI != -1 && aEg.thePlayer != null) {
            aEg.thePlayer.inventory.currentItem = this.qI;
        }

        this.qJ = false;
        this.jE = null;
        this.qI = -1;
    }

    public boolean s(EntityLivingBase var1) {
        Vec3 vec3 = this.qB.wo() ? this.i(var1) : var1.getPositionVector().addVector(0.0, var1.getEyeHeight() * 0.5, 0.0);
        Vec3 vec31 = aEg.thePlayer.getPositionEyes(1.0F);
        Vec3 vec32 = aEg.thePlayer.getLookVec().normalize();
        Vec3 vec33 = vec3.subtract(vec31).normalize();
        return vec32.dotProduct(vec33) > 0.9;
    }

    public void g(Entity var1) {
        if (aEg.playerController != null && var1 != null) {
            float f2 = aEg.thePlayer.pl;
            float f3 = aEg.thePlayer.rotationPitch;
            this.h(var1);
            ItemStack itemstack = aEg.thePlayer.getHeldItem();
            if (itemstack != null) {
                aEg.thePlayer.swingItem();
                aEg.playerController.sendUseItem(aEg.thePlayer, aEg.theWorld, itemstack);
                aEg.getNetHandler().addToSendQueue(new C08PacketPlayerBlockPlacement(itemstack));
            }

            aEg.thePlayer.pl = f2;
            aEg.thePlayer.rotationPitch = f3;
        }
    }

    static {
    }

    public boolean gs() {
        if (!this.qC.wo()) {
            return true;
        }

        AimBacktrack aimbacktrack = this.e(AimBacktrack.class);
        return aimbacktrack == null || !aimbacktrack.isEnabled();
    }

    public void h(Entity var1) {
        Vec3 vec3 = this.qB.wo() ? this.i(var1) : var1.getPositionVector().addVector(0.0, var1.getEyeHeight() * 0.5, 0.0);
        Vec3 vec31 = aEg.thePlayer.getPositionEyes(1.0F);
        double d6 = vec3.xCoord - vec31.xCoord;
        double d7 = vec3.yCoord - vec31.yCoord;
        double d8 = vec3.zCoord - vec31.zCoord;
        double d9 = Math.atan2(d8, d6) * 180.0 / Math.PI - 90.0;
        double d10 = Math.sqrt(d6 * d6 + d8 * d8);
        double d11 = -(Math.atan2(d7, d10) * 180.0 / Math.PI);
        aEg.thePlayer.pl = (float)d9;
        aEg.thePlayer.rotationPitch = (float)d11;
    }

    public boolean a(KillAura var1) {
        return var1 != null && var1.isEnabled() && var1.jE != null ? !this.b(var1) : false;
    }

    public ThrowableAura() {
        this.qt = new NumberValue("Range", this, 6.0, 1.0, 12.0, 0.1);
        this.qu = new NumberValue("Minimum Range", this, 3.0, 1.0, 10.0, 0.1);
        this.qv = new NumberValue("Throw Delay", this, 5.0, 0.0, 100.0, 1.0);
        this.qw = new NumberValue("FOV", this, 180.0, 30.0, 360.0, 1.0);
        this.qx = new BooleanValue("Player Teammates", this, true);
        this.qy = new BooleanValue("Players", this, true);
        this.qz = new BooleanValue("Mobs", this, true);
        this.qA = new BooleanValue("Auto Switch", this, true);
        this.qB = new BooleanValue("Prediction", this, true);
        this.qC = new BooleanValue("Module Check", this, true);
        this.qD = new BooleanValue("AntiBot", this, true);
        this.qE = new BooleanValue("Snowballs", this, true);
        this.qF = new BooleanValue("Eggs", this, true);
        this.qG = new BooleanValue("Through Walls", this, true);
        this.qI = -1;
        this.qK = var1 -> {
            long k = 2705662454777865896L;
            long l = 7055313991864828554L;
            if (aEg.thePlayer != null && aEg.theWorld != null && !this.qJ) {
                if (this.gs()) {
                    if (this.qH < this.qv.wo().intValue()) {
                        this.qH++;
                    } else {
                        this.qH = 0;
                        this.jE = this.gt();
                        if (this.jE != null) {
                            double d1 = aEg.thePlayer.getDistanceToEntity(this.jE);
                            if (!(d1 > this.qt.wo().doubleValue()) && !(d1 <= this.qu.wo().doubleValue())) {
                                long i1 = l ^ ((long)this.gu() << 32 ^ l) & -1L << 32;
                                if ((int)(i1 >>> 32) != -1) {
                                    if (this.s(this.jE) && this.t(this.jE)) {
                                        long j1 = k ^ (aEg.thePlayer.inventory.currentItem ^ k) & -1L >>> 32;
                                        if (this.qA.wo() && (int)j1 != (int)(i1 >>> 32)) {
                                            if (this.qI == -1) {
                                                this.qI = (int)j1;
                                            }

                                            aEg.thePlayer.inventory.currentItem = (int)(i1 >>> 32);
                                        }

                                        ItemStack itemstack = aEg.thePlayer.getHeldItem();
                                        if (!this.g(itemstack)) {
                                            if (this.qA.wo() && this.qI != -1) {
                                                aEg.thePlayer.inventory.currentItem = this.qI;
                                                this.qI = -1;
                                            }
                                        } else {
                                            KillAura killaura = this.e(KillAura.class);
                                            EntityLivingBase entitylivingbase = this.a(killaura) ? killaura.jE : null;
                                            if (entitylivingbase != null) {
                                                killaura.jE = null;
                                            }

                                            this.qJ = true;
                                            this.g(this.jE);
                                            this.qJ = false;
                                            if (entitylivingbase != null && killaura != null) {
                                                killaura.jE = entitylivingbase;
                                            }

                                            if (this.qA.wo() && this.qI != -1) {
                                                aEg.thePlayer.inventory.currentItem = this.qI;
                                                this.qI = -1;
                                            }

                                            this.jE = null;
                                        }
                                    }
                                }
                            } else {
                                this.jE = null;
                            }
                        }
                    }
                }
            }
        };
    }

    public boolean t(EntityLivingBase var1) {
        if (aEg.objectMouseOver != null && aEg.objectMouseOver.entityHit == var1) {
            return true;
        }

        MovingObjectPosition movingobjectposition = aef.a(new Vector2f(aEg.thePlayer.pl, aEg.thePlayer.rotationPitch), this.qt.wo().doubleValue(), 0.1F);
        return movingobjectposition != null && movingobjectposition.entityHit == var1;
    }

    public int gu() {
        long j = 6284645629799752712L;
        if (this.qE.wo()) {
            j ^= ((long)aik.e(Items.snowball) << 32 ^ j) & -1L << 32;
            if ((int)(j >>> 32) != -1) {
                return (int)(j >>> 32);
            }
        }

        if (this.qF.wo()) {
            long k = j ^ ((long)aik.e(Items.egg) << 32 ^ j) & -1L << 32;
            if ((int)(k >>> 32) != -1) {
                return (int)(k >>> 32);
            }
        }

        return -1;
    }

    public boolean g(ItemStack var1) {
        return var1 == null ? false : this.qE.wo() && var1.getItem() == Items.snowball || this.qF.wo() && var1.getItem() == Items.egg;
    }

    public boolean b(KillAura var1) {
        EntityLivingBase entitylivingbase = var1.jE;
        if (entitylivingbase == null) {
            return false;
        }

        double d1 = var1.mh.wo().doubleValue();
        MovingObjectPosition movingobjectposition = aef.c(RotationComponent.fk, d1);
        return (MovingObjectPosition)movingobjectposition != null && movingobjectposition.entityHit == (EntityLivingBase)entitylivingbase
            ? true ^ true
            : aEg.thePlayer.getDistanceToEntity(entitylivingbase) <= d1;
    }

    public EntityLivingBase gt() {
        return aEg.theWorld.loadedEntityList.stream().filter(EntityLivingBase.class::isInstance).map(EntityLivingBase.class::cast).filter(var1 -> {
            if (var1 != aEg.thePlayer && var1.isEntityAlive()) {
                double d1 = aEg.thePlayer.getDistanceToEntity(var1);
                if (d1 > this.qs.wo().doubleValue() || d1 <= this.qu.wo().doubleValue()) {
                    return true ^ true;
                } else if (!this.r(var1)) {
                    return false;
                } else if (this.qG.wo() && !aEg.thePlayer.canEntityBeSeen(var1)) {
                    return false;
                } else if (this.qD.wo() && Client.a.x().a(var1)) {
                    return false;
                } else if (var1 instanceof EntityPlayer) {
                    return !this.qy.wo() ? false : !this.qx.wo() || !aih.D(var1);
                }
                return var1 instanceof IMob ? this.qz.wo() : false;
            }
            return false;
        }).min(Comparator.comparingDouble(var0 -> aEg.thePlayer.getDistanceSqToEntity(var0))).orElse(null);
    }

    public boolean r(EntityLivingBase var1) {
        if (this.qw.wo().doubleValue() >= 360.0) {
            return true;
        }

        Vec3 vec3 = aEg.thePlayer.getLookVec().normalize();
        Vec3 vec31 = var1.getPositionVector().addVector(0.0, var1.getEyeHeight() * 0.5, 0.0).subtract(aEg.thePlayer.getPositionEyes(1.0F)).normalize();
        return Math.toDegrees(Math.acos(MathHelper.clamp_double(vec3.dotProduct(vec31), -1.0, 1.0))) <= this.qw.wo().doubleValue() / 2.0;
    }
}
