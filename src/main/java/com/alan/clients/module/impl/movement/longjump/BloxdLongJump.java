package com.alan.clients.module.impl.movement.longjump;

import com.alan.clients.component.impl.player.SlotComponent;
import com.alan.clients.module.impl.movement.LongJump;
import com.alan.clients.module.impl.movement.TerrainSpeed;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import hackclient.rise.afi;
import hackclient.rise.bc;
import hackclient.rise.bd;
import hackclient.rise.bg;
import hackclient.rise.ci;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;

public class BloxdLongJump extends Mode<LongJump> {
    public Vec3 Jd = new Vec3(0.0, 0.0, 0.0);
    public int LA = 0;
    int IU = -1;
    double jy;
    double IW = -1.0;
    private int dE;
    private int hV;
    @EventLink
    public final Listener<StrafeEvent> onStrafe = var1x -> {
        if (aEg.thePlayer.ae > 0 && aEg.thePlayer.ae < 42) {
            ci.a((float)(aEg.thePlayer.ae / 41.0));
        }

        if (aEg.thePlayer.ae < 37 && aEg.thePlayer.ae > 1) {
            this.e(LongJump.class).setEnabled(true);
        }

        this.LA++;
        if (this.LA == 20) {
            this.e(TerrainSpeed.class).setEnabled(true);
        }

        if (!aEg.thePlayer.onGround) {
            float f;
            int i = (f = bd.cY - 1.0F) == 0.0F ? 0 : (f < 0.0F ? -1 : 1);
        }
    };
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var0 -> {
        if (aEg.thePlayer.onGround) {
            bc.cR = false;
        }

        aEg.thePlayer.cameraYaw = 0.1F;
        if (!aEg.thePlayer.onGround) {
            float f;
            int i = (f = bd.cY - 1.0F) == 0.0F ? 0 : (f < 0.0F ? -1 : 1);
        }
    };

    public BloxdLongJump(String var1, LongJump var2) {
        super(var1, var2);
    }

    @Override
    public void onEnable() {
        this.e(TerrainSpeed.class).setEnabled(false);
        MoveUtil.stop();
        this.IU = aEg.thePlayer.inventory.currentItem;
        if (this.hq() == -1) {
            afi.b("you need a projectile in your hotbar for this");
        } else {
            int i = this.hq();
            if (i != -1) {
                SlotComponent slotcomponent = this.d(SlotComponent.class);
                SlotComponent.setSlot(i);
            } else {
                afi.b("you need a projectile in your hotbar for this");
            }

            bg.damage(false);
            this.LA = 0;
        }
    }

    @Override
    public void onDisable() {
        this.e(TerrainSpeed.class).setEnabled(true);
    }

    private int hq() {
        for (int i = 0; i < 9; i++) {
            ItemStack itemstack = aEg.thePlayer.inventory.getStackInSlot(i);
            if (itemstack != null && itemstack.getItem() == Items.bow) {
                return i;
            }
        }

        for (int j = 0; j < 9; j++) {
            ItemStack itemstack1 = aEg.thePlayer.inventory.getStackInSlot(j);
            if (itemstack1 != null && itemstack1.getItem() == Items.fishing_rod) {
                return j;
            }
        }

        for (int k = 0; k < 9; k++) {
            ItemStack itemstack2 = aEg.thePlayer.inventory.getStackInSlot(k);
            if (itemstack2 != null && itemstack2.getItem() == Items.egg || itemstack2 != null && itemstack2.getItem() == Items.snowball) {
                return k;
            }
        }

        for (int l = 0; l < 9; l++) {
            ItemStack itemstack3 = aEg.thePlayer.inventory.getStackInSlot(l);
            if (itemstack3 != null && itemstack3.getItem() == Items.clay_ball || itemstack3 != null && itemstack3.getItem() == Items.snowball) {
                return l;
            }
        }

        return -1;
    }
}
