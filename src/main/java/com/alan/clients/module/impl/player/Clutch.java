package com.alan.clients.module.impl.player;

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
import com.alan.clients.value.impl.BoundsNumberValue;
import hackclient.rise.aef;
import com.alan.clients.util.math.MathUtil;
import com.alan.clients.util.packet.PacketUtil;
import com.alan.clients.util.player.EnumFacingOffset;
import com.alan.clients.util.player.PlayerUtil;
import com.alan.clients.util.player.SlotUtil;
import com.alan.clients.util.rotation.RotationUtil;
import hackclient.rise.aka;
import com.alan.clients.component.impl.player.BadPacketsComponent;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.m;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.Vec3i;

@ModuleInfo(aliases = "module.player.clutch.name", description = "module.player.clutch.description", category = Category.PLAYER)
public class Clutch extends Module {
    private final BoundsNumberValue rotationSpeed = new BoundsNumberValue("Rotation Speed", this, 5, 10, 0, 10, 1);
    private final BoundsNumberValue placeDelay = new BoundsNumberValue("Place Delay", this, 0, 0, 0, 1, 1);
    private Vec3 Yw;
    private EnumFacingOffset acr;
    private BlockPos Yx;
    private float acs;
    private float act;
    private int acu;
    private int acv;
    @EventLink
    public final Listener<PreUpdateEvent> onPreUpdate = var1 -> {
        if (aEg.thePlayer.Zl > 15
            && aEg.thePlayer.ticksExisted > 50
            && !BadPacketsComponent.aW()
            && !this.e(Scaffold.class).isEnabled()
            && aEg.gameSettings.keyBindSneak.isKeyDown()) {
            if (aEg.thePlayer.tR > 3 && !PlayerUtil.ad(10.0)) {
                this.acv = 10;
            }

            if (this.acv-- >= 0) {
                SlotComponent slotcomponent = this.d(SlotComponent.class);
                SlotComponent.setSlot(SlotUtil.vx());
                Vec3i vec3i = new Vec3i(0, 0, 0);
                if (PlayerUtil.p(vec3i.getX(), -1 + vec3i.getY(), vec3i.getZ()).isReplaceable(aEg.theWorld, new BlockPos(aEg.thePlayer).down())) {
                    this.acu++;
                } else {
                    this.acu = 0;
                }

                this.Yw = PlayerUtil.getPlacePossibility(vec3i.getX(), vec3i.getY(), vec3i.getZ());
                if (this.Yw != null) {
                    this.acr = PlayerUtil.e(this.Yw);
                    if (this.acr != null) {
                        BlockPos blockpos = new BlockPos(this.Yw.xCoord, this.Yw.yCoord, this.Yw.zCoord);
                        this.Yx = blockpos.add(this.acr.vb().xCoord, this.acr.vb().yCoord, this.acr.vb().zCoord);
                        if (this.Yx != null && this.acr != null) {
                            this.jF();
                            if (this.Yw != null && this.acr != null && this.Yx != null) {
                                int i = aEg.thePlayer.inventory.cIT;
                                SlotComponent slotcomponent1 = this.d(SlotComponent.class);
                                if (i == SlotComponent.bQ()) {
                                    if (!BadPacketsComponent.bad(false, true, false, false, true)
                                        && this.acu > MathUtil.l(this.placeDelay.wo().intValue(), this.placeDelay.wA().intValue())
                                        && aef.overBlock(this.acr.va(), this.Yx, true)) {
                                        Vec3 vec3 = aef.c(RotationComponent.fk, aEg.playerController.getBlockReachDistance()).hitVec;
                                        PlayerControllerMP playercontrollermp = aEg.playerController;
                                        EntityPlayerSP entityplayersp = aEg.thePlayer;
                                        WorldClient worldclient = aEg.theWorld;
                                        SlotComponent slotcomponent3 = this.d(SlotComponent.class);
                                        if (playercontrollermp.onPlayerRightClick(
                                            entityplayersp, worldclient, SlotComponent.getItemStack(), this.Yx, this.acr.va(), vec3
                                        )) {
                                            PacketUtil.l(new m());
                                        }

                                        aEg.rightClickDelayTimer = 0;
                                        this.acu = 0;
                                        slotcomponent = this.d(SlotComponent.class);
                                        if (!acx && SlotComponent.getItemStack() == null) {
                                            throw new AssertionError();
                                        }

                                        slotcomponent = this.d(SlotComponent.class);
                                        if (SlotComponent.getItemStack() != null) {
                                            slotcomponent = this.d(SlotComponent.class);
                                            if (SlotComponent.getItemStack().stackSize == 0) {
                                                ItemStack[] aitemstack = aEg.thePlayer.inventory.mainInventory;
                                                slotcomponent1 = this.d(SlotComponent.class);
                                                aitemstack[SlotComponent.bQ()] = null;
                                            }
                                        }
                                    } else if (Math.random() > 0.92 && aEg.rightClickDelayTimer <= 0) {
                                        SlotComponent slotcomponent2 = this.d(SlotComponent.class);
                                        PacketUtil.l(new C08PacketPlayerBlockPlacement(SlotComponent.getItemStack()));
                                        aEg.rightClickDelayTimer = 0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    static final boolean acx = !Clutch.class.desiredAssertionStatus();

    public Clutch() {
    }

    @Override
    public void onEnable() {
        this.acs = aEg.thePlayer.pl - 180.0F;
        this.act = 90.0F;
        this.Yw = null;
    }

    public void jF() {
        if (this.acu > 0 && !aef.a(RotationComponent.fk, this.acr.va(), this.Yx, true)) {
            this.D(0);
        }

        double rotationSpeed = this.rotationSpeed.wo().doubleValue();
        double d1 = this.rotationSpeed.wA().doubleValue();
        float f = (float)MathUtil.l(rotationSpeed, d1);
        if (f != 0.0F) {
            RotationComponent.setRotations(new Vector2f(this.acs, this.act), f, MovementFix.NORMAL);
        }
    }

    public void D(int var1) {
        EntityPlayerSP entityplayersp = aEg.thePlayer;
        double d0 = entityplayersp.posY + entityplayersp.getEyeHeight() - this.Yw.yCoord - 0.1 - Math.random() * 0.8;

        for (int i = -180 + var1; i <= 180; i += 45) {
            entityplayersp.setPosition(entityplayersp.posX, entityplayersp.posY - d0, entityplayersp.posZ);
            MovingObjectPosition movingobjectposition = aef.c(new Vector2f(entityplayersp.pl + i, 0.0F), 4.5);
            entityplayersp.setPosition(entityplayersp.posX, entityplayersp.posY + d0, entityplayersp.posZ);
            if (movingobjectposition != null
                && new BlockPos(this.Yx).equals(movingobjectposition.getBlockPos())
                && this.acr.va() == movingobjectposition.sideHit) {
                Vector2f vector2f = RotationUtil.h(movingobjectposition.hitVec);
                this.acs = vector2f.x;
                this.act = vector2f.y;
                return;
            }
        }

        Vector2f vector2f1 = RotationUtil.a(new aka(this.Yx.getX(), this.Yx.getY(), this.Yx.getZ()), this.acr.va());
        this.acs = vector2f1.x;
        this.act = vector2f1.y;
    }
}
