package com.alan.clients.module.impl.player.nofall;

import com.alan.clients.component.impl.player.RotationComponent;
import com.alan.clients.component.impl.player.SlotComponent;
import com.alan.clients.component.impl.player.rotationcomponent.MovementFix;
import com.alan.clients.module.impl.player.NoFall;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.Mode;
import hackclient.rise.afi;
import com.alan.clients.util.player.SlotUtil;
import com.alan.clients.util.rotation.RotationUtil;
import hackclient.rise.uo;
import java.util.Iterator;
import net.minecraft.init.Items;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import rip.vantage.commons.util.time.a;

public class ClutchNoFall extends Mode<NoFall> {
    private uo aic = uo.IDLE;
    private BlockPos aid = null;
    private BlockPos CG = null;
    private a aie = new a();
    private a aif = new a();
    private int CF = -1;
    private int aig = -1;
    private boolean aih = false;
    private boolean aii = false;
    private boolean aij = false;
    private Vector2f aik = null;
    @EventLink(value = 2)
    public final Listener<PreUpdateEvent> onPreUpdate = var1x -> {
        switch (this.aic) {
            case IDLE:
                if (aEg.thePlayer.onGround || aEg.thePlayer.motionY >= 0.0 || aEg.thePlayer.fallDistance < 2.0F) {
                    return;
                }

                this.CF = com.alan.clients.util.player.SlotUtil.findItem(Items.water_bucket);
                if (this.CF == -1) {
                    return;
                }

                this.aic = uo.PREDICT;
                this.aie.aX();
                break;
            case PREDICT:
                this.aid = this.kx();
                if (this.aid == null) {
                    return;
                }

                double d0 = aEg.thePlayer.posY - this.aid.getY();
                double d1 = 8.0;
                if (d0 < d1 && d0 > 3.0) {
                    this.aic = uo.ROTATE;
                    this.aie.aX();
                } else if (this.aie.T(50L)) {
                    this.aic = uo.IDLE;
                }
                break;
            case ROTATE:
                SlotComponent slotcomponent = this.d(SlotComponent.class);
                SlotComponent.setSlot(this.CF);
                RotationComponent.setRotations(new Vector2f(aEg.thePlayer.pl, 90.0F), 5.0, MovementFix.NORMAL);
                if (Math.abs(aEg.thePlayer.rotationPitch - 90.0F) < 15.0F || this.aie.T(200L)) {
                    this.aii = true;
                    this.aik = new Vector2f(aEg.thePlayer.pl, 90.0F);
                    this.aic = uo.PLACE;
                    this.aie.aX();
                }
                break;
            case PLACE:
                this.aii = true;
                break;
            case WAIT_LAND:
                if (aEg.thePlayer.onGround || this.aie.T(3000L)) {
                    if (this.CG != null) {
                        this.aig = com.alan.clients.util.player.SlotUtil.findItem(Items.bucket);
                        afi.b("S");
                        if (this.aig != -1) {
                            this.aic = uo.PICKUP;
                            this.aie.aX();
                        } else {
                            this.ky();
                        }
                    } else {
                        this.ky();
                    }
                }
                break;
            case PICKUP:
                if (this.CG == null) {
                    this.ky();
                } else if (aEg.thePlayer.getDistance(this.CG.getX() + 0.5, this.CG.getY() + 0.5, this.CG.getZ() + 0.5) < 5.0) {
                    SlotComponent slotcomponent1 = this.d(SlotComponent.class);
                    SlotComponent.setSlot(this.aig);
                    aEg.thePlayer.inventory.currentItem = this.aig;
                    Vec3 vec3 = new Vec3(this.CG.getX() + 0.5, this.CG.getY() + 0.5, this.CG.getZ() + 0.5);
                    this.aik = RotationUtil.h(vec3);
                    RotationComponent.setRotations(this.aik, 10.0, MovementFix.NORMAL);
                    this.aij = true;
                } else {
                    this.ky();
                }
        }
    };
    @EventLink(value = 4)
    public final Listener<PreMotionEvent> aim = var1x -> {
        if (this.aic == uo.PLACE && this.aii) {
            RotationComponent.setRotations(this.aik, 10.0, MovementFix.NORMAL);
            float f = aEg.thePlayer.rotationPitch;
            aEg.thePlayer.pl = this.aik.x;
            aEg.thePlayer.rotationPitch = this.aik.y;
            aEg.entityRenderer.getMouseOver(1.0F);
            SlotComponent slotcomponent = this.d(SlotComponent.class);
            SlotComponent.setSlot(this.CF);
            aEg.rightClickDelayTimer = 0;
            aEg.Az();
            aEg.thePlayer.rotationPitch = f;
            this.CG = new BlockPos(aEg.thePlayer.posX, aEg.thePlayer.posY - 1.0, aEg.thePlayer.posZ);
            this.aih = true;
            this.aif.aX();
            afi.b("MLG water placed at distance: " + (aEg.thePlayer.posY - this.aid.getY()));
            this.aic = uo.WAIT_LAND;
            this.aie.aX();
            this.aii = false;
        } else if (this.aic == uo.PICKUP && this.aij) {
            float f1 = aEg.thePlayer.rotationPitch;
            aEg.entityRenderer.getMouseOver(1.0F);
            aEg.rightClickDelayTimer = 0;
            afi.b("Picked up water MLG");
            this.ky();
            this.aij = false;
        }
    };
    @EventLink
    public final Listener<PacketSendEvent> onPacketSend = var1x -> {
        if (this.aic == uo.PLACE && this.aii) {
            var1x.setCancelled(true);
            this.aii = false;
        } else if (this.aic == uo.PICKUP && this.aij) {
            var1x.setCancelled(true);
            this.aij = false;
        }
    };

    public ClutchNoFall(String var1, NoFall noFall) {
        super(var1, noFall);
    }

    private BlockPos kx() {
        double d0 = aEg.thePlayer.posX;
        double d1 = aEg.thePlayer.posY;
        double d2 = aEg.thePlayer.posZ;
        double d3 = aEg.thePlayer.motionX;
        double d4 = aEg.thePlayer.motionY;
        double d5 = aEg.thePlayer.motionZ;
        AxisAlignedBB axisalignedbb = aEg.thePlayer.getEntityBoundingBox();
        int i = 0;

        while (d1 > 0.0 && i++ < 200) {
            float f = aEg.thePlayer.movementInput.moveStrafe;
            float f1 = aEg.thePlayer.movementInput.moveForward;
            float f2 = aEg.thePlayer.pl;
            float f3 = f * f + f1 * f1;
            if (f3 >= 1.0E-4F) {
                float f4 = MathHelper.sqrt_float(f3);
                if (f4 < 1.0F) {
                    f4 = 1.0F;
                }

                float f5 = 0.02F / f4;
                float f6 = f * f5;
                float f7 = f1 * f5;
                float f8 = MathHelper.sin(f2 * (float) Math.PI / 180.0F);
                float f9 = MathHelper.cos(f2 * (float) Math.PI / 180.0F);
                d3 += f6 * f9 - f7 * f8;
                d5 += f7 * f9 + f6 * f8;
            }

            double d6 = d4 - 0.08;
            double d7 = d6 * 0.98F;
            double d8 = d3 * 0.91F;
            double d9 = d5 * 0.91F;
            double d10 = d8;
            double d11 = d7;
            double d12 = d9;
            AxisAlignedBB axisalignedbb1 = axisalignedbb.addCoord(d10, 0.0, 0.0);
            Iterator iterator = aEg.theWorld.getCollidingBoundingBoxes(aEg.thePlayer, axisalignedbb1).iterator();

            while (iterator.hasNext()) {
                d10 = ((AxisAlignedBB)iterator.next()).calculateXOffset(axisalignedbb, d10);
            }

            AxisAlignedBB axisalignedbb2 = axisalignedbb.offset(d10, 0.0, 0.0);
            d0 += d10;
            double d13 = d11;
            AxisAlignedBB axisalignedbb3 = axisalignedbb2.addCoord(0.0, d11, 0.0);
            Iterator iterator1 = aEg.theWorld.getCollidingBoundingBoxes(aEg.thePlayer, axisalignedbb3).iterator();

            while (iterator1.hasNext()) {
                d11 = ((AxisAlignedBB)iterator1.next()).calculateYOffset(axisalignedbb2, d11);
            }

            AxisAlignedBB axisalignedbb4 = axisalignedbb2.offset(0.0, d11, 0.0);
            d1 += d11;
            AxisAlignedBB axisalignedbb5 = axisalignedbb4.addCoord(0.0, 0.0, d12);
            Iterator iterator2 = aEg.theWorld.getCollidingBoundingBoxes(aEg.thePlayer, axisalignedbb5).iterator();

            while (iterator2.hasNext()) {
                d12 = ((AxisAlignedBB)iterator2.next()).calculateZOffset(axisalignedbb4, d12);
            }

            axisalignedbb = axisalignedbb4.offset(0.0, 0.0, d12);
            d2 += d12;
            if (d11 != d13 && d13 < 0.0) {
                return new BlockPos(d0, d1, d2);
            }

            if (Math.abs(d8) < 0.003) {
            }

            if (Math.abs(d7) < 0.003) {
            }

            if (Math.abs(d9) < 0.003) {
            }

            d3 = d10;
            d4 = d11;
            d5 = d12;
        }

        return null;
    }

    private void ky() {
        this.aic = uo.IDLE;
        this.aid = null;
        this.CG = null;
        this.CF = -1;
        this.aig = -1;
        this.aih = false;
        this.aie.aX();
        this.aif.aX();
        this.aii = false;
        this.aij = false;
        this.aik = null;
    }
}
