package com.alan.clients.module.impl.movement.flight;

import com.alan.clients.Client;
import com.alan.clients.component.impl.player.BlinkComponent;
import com.alan.clients.component.impl.player.RotationComponent;
import com.alan.clients.component.impl.player.rotationcomponent.MovementFix;
import com.alan.clients.module.impl.combat.KillAura;
import com.alan.clients.module.impl.movement.Flight;
import com.alan.clients.module.impl.movement.LongJump;
import com.alan.clients.module.impl.player.AntiFireBall;
import com.alan.clients.module.impl.player.Scaffold;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PostMotionEvent;
import com.alan.clients.newevent.impl.motion.PostStrafeEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.Mode;
import hackclient.rise.afi;
import com.alan.clients.util.packet.PacketUtil;
import com.alan.clients.component.impl.player.PacketlessDamageComponent;
import java.util.ArrayList;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFireball;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S32PacketConfirmTransaction;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;
import rip.vantage.commons.util.time.a;

public class WatchdogFlight extends Mode<Flight> {
    private int qI = -1;
    private int hV = -1;
    private boolean IN;
    public static boolean IO;
    private boolean IP;
    private int IQ;
    private boolean IR;
    private AntiFireBall IS;
    private final ArrayList<Packet<?>> IT = new ArrayList<>();
    a bN = new a();
    private boolean dj;
    private boolean tt;
    private boolean vq;
    int IU = -1;
    double IV = 0.0;
    double IW = -1.0;
    private int dE;
    @EventLink(value = 1)
    public final Listener<PacketReceiveEvent> receive = var1x -> {
        if (!this.tt) {
            if (aEg.thePlayer != null && aEg.theWorld != null) {
                if (var1x.getPacket() instanceof S12PacketEntityVelocity) {
                    if (((S12PacketEntityVelocity)var1x.getPacket()).getEntityID() != aEg.thePlayer.getEntityId()) {
                        return;
                    }

                    if (this.IR) {
                        this.hV = 0;
                        this.IN = true;
                        this.IR = false;
                        IO = true;
                    }
                }

                switch (var1x.getPacket()) {
                    case S12PacketEntityVelocity s12packetentityvelocity:
                        if (!var1x.isCancelled() && s12packetentityvelocity.getEntityID() == aEg.thePlayer.getEntityId() && !this.vq) {
                            this.IW = aEg.thePlayer.motionY;
                            Vector2d vector2d = new Vector2d(aEg.thePlayer.motionX, aEg.thePlayer.motionZ);
                            aEg.thePlayer.motionX = vector2d.getX();
                            aEg.thePlayer.motionZ = vector2d.getY();
                            aEg.thePlayer.motionY = this.IW;
                            var1x.setCancelled();
                            this.dj = true;
                            this.IT.add(s12packetentityvelocity);
                        } else if (!var1x.isCancelled() && s12packetentityvelocity.getEntityID() == aEg.thePlayer.getEntityId()) {
                            var1x.setCancelled();
                        }
                        break;
                    case S32PacketConfirmTransaction s32packetconfirmtransaction:
                        if (this.dj) {
                            this.IT.add(s32packetconfirmtransaction);
                            var1x.setCancelled();
                        }
                        break;
                    default:
                }
            }
        }
    };
    @EventLink
    public final Listener<PacketSendEvent> onPacketSend = var1x -> {
        if (var1x.dq() instanceof C08PacketPlayerBlockPlacement
            && ((C08PacketPlayerBlockPlacement)var1x.dq()).getStack() != null
            && ((C08PacketPlayerBlockPlacement)var1x.dq()).getStack().getItem() instanceof ItemFireball) {
            this.IR = true;
        }
    };
    @EventLink
    public final Listener<StrafeEvent> IZ = var0 -> {
        if (aEg.thePlayer.ae == 1) {
            double d0 = (
                    MathHelper.wrapAngleTo180_double(
                            Math.toDegrees(MoveUtil.direction(aEg.thePlayer.pl, aEg.thePlayer.moveForward, aEg.thePlayer.moveStrafing))
                        )
                        + 360.0
                )
                % 360.0
                % 90.0
                / 90.0;
            double d1 = 1.05 + 0.549 * (1.0 - 4.0 * d0 * (1.0 - d0));
            if (!aEg.thePlayer.isPotionActive(Potion.moveSpeed)) {
                MoveUtil.strafe(d1);
            } else {
                MoveUtil.strafe(d1);
            }
        }

        if (aEg.thePlayer.ae == 20) {
            aEg.gameSettings.keyBindJump.isPressed();
        }

        if (aEg.thePlayer.tR > 3 && aEg.thePlayer.tR < 33) {
            MoveUtil.strafe();
        }

        MoveUtil.useDiagonalSpeed();
        if (aEg.thePlayer.tR == 31) {
            aEg.gameSettings.keyBindJump.isKeyDown();
        }

        if (aEg.thePlayer.tR == 32) {
            aEg.gameSettings.keyBindJump.isKeyDown();
        }

        if (aEg.thePlayer.tR == 33) {
            aEg.gameSettings.keyBindJump.isKeyDown();
        }
    };
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var1x -> {
        if (!this.dj && aEg.thePlayer.tR < 7) {
            aEg.thePlayer.crd = true;
        }

        if (aEg.thePlayer.tR < 2 && aEg.gameSettings.keyBindJump.isPressed()) {
            aEg.gameSettings.keyBindJump.setPressed(false);
        }

        if (this.e(LongJump.class).autoDisable.wo() && !PacketlessDamageComponent.bd() && aEg.thePlayer.onGround && this.dE >= 999) {
            ;
        }

        if (aEg.thePlayer.onGround) {
            aEg.thePlayer.tR = 0;
        }

        if ((aEg.thePlayer.ae != 0 || !aEg.thePlayer.isPotionActive(Potion.moveSpeed)) && aEg.thePlayer.ae == 0) {
        }

        if (aEg.thePlayer.ae > 4 && aEg.thePlayer.ae < 20 && this.vq && aEg.gameSettings.keyBindJump.isKeyDown() && !this.e(KillAura.class).isEnabled()) {
            aEg.thePlayer.motionY = 0.35;
            MoveUtil.strafe();
        } else if (aEg.thePlayer.ae > 0 && aEg.thePlayer.ae < 21 && this.vq) {
            aEg.thePlayer.motionY = 0.005;
            MoveUtil.strafe();
        } else {
            aEg.thePlayer.motionY += 0.028;
        }

        if (aEg.thePlayer.onGround && this.vq) {
            this.e(Flight.class).toggle();
        }

        if (aEg.thePlayer.onGround && this.dE >= 999) {
            ;
        }

        if (this.dE >= 999 && this.dj && aEg.thePlayer.tR == 0) {
            double d0 = (
                    MathHelper.wrapAngleTo180_double(
                            Math.toDegrees(MoveUtil.direction(aEg.thePlayer.pl, aEg.thePlayer.moveForward, aEg.thePlayer.moveStrafing))
                        )
                        + 360.0
                )
                % 360.0
                % 90.0
                / 90.0;
            this.IV = 1.05 + 0.35 * (1.0 - 4.0 * d0 * (1.0 - d0));
            if (!aEg.thePlayer.isPotionActive(Potion.moveSpeed)) {
                MoveUtil.strafe(this.IV);
            } else {
                MoveUtil.strafe(this.IV);
            }
        }

        if (this.dE >= 999 && this.dj) {
            MoveUtil.strafe(this.IV);
        }

        if (aEg.thePlayer.tR == 1) {
            aEg.thePlayer.isPotionActive(Potion.moveSpeed);
        }

        aEg.thePlayer.isPotionActive(Potion.moveSpeed);
        MoveUtil.speed();
        if (this.IQ == 0) {
            RotationComponent.d(false);
            RotationComponent.setRotations(new Vector2f(aEg.thePlayer.pl - 180.0F, 89.0F), 10.0, MovementFix.OFF);
            int i = this.hr();
            if (i != -1 && i != aEg.thePlayer.inventory.currentItem) {
                this.qI = aEg.thePlayer.inventory.currentItem;
                aEg.thePlayer.inventory.currentItem = i;
            }
        }

        if (this.IQ == 1) {
            if (!this.IP) {
                PacketUtil.l(new C08PacketPlayerBlockPlacement(aEg.thePlayer.getHeldItem()));
                this.IP = true;
                if (this.IS != null && this.IS.isEnabled()) {
                    this.IS.aaW = 1500;
                    this.IS.aaV.aX();
                }
            }
        } else if (this.IQ == 2 && this.qI != -1) {
            aEg.thePlayer.inventory.currentItem = this.qI;
            this.qI = -1;
        }

        if (this.hV > 1) {
            this.toggle();
        } else {
            if (this.IN) {
                IO = true;
                this.hV++;
            }

            if (this.IQ < 3) {
                this.IQ++;
            }

            if (this.IN) {
                if (this.hV > 1) {
                    IO = this.IN = false;
                    this.hV = 0;
                    return;
                }

                IO = true;
                this.hV++;
            }

            MoveUtil.useDiagonalSpeed();
        }
    };
    @EventLink(value = 4)
    public final Listener<PostStrafeEvent> onStrafe = var1x -> {
        if (aEg.thePlayer.hurtTime > 0) {
            this.dE = 999;
        }

        if (this.dj && aEg.thePlayer.tR == 7) {
            aEg.thePlayer.ae = 0;
            this.vq = true;
            this.dj = false;
            this.tt = true;
            new Vector2d(aEg.thePlayer.motionX, aEg.thePlayer.motionZ);
            BlinkComponent.dispatch();
            MoveUtil.strafe();
            this.IT.forEach(PacketUtil::p);
            aEg.thePlayer.motionY = 0.005;
            MoveUtil.strafe(1.59F);
            this.IT.clear();
            this.tt = false;
        }
    };
    @EventLink
    public final Listener<PostMotionEvent> onPostMotion = var1x -> {};

    public WatchdogFlight(String var1, Flight var2) {
        super(var1, var2);
    }

    @Override
    public void onEnable() {
        aEg.thePlayer.crd = true;
        if (this.e(Scaffold.class).isEnabled()) {
            this.e(Scaffold.class).toggle();
        }

        this.IS = Client.a.g().c(AntiFireBall.class);
        this.dE = 0;
        if (this.hr() == -1) {
            afi.b("Could not find Fireball");
            this.toggle();
        } else {
            aEg.thePlayer.motionX *= -1.0;
            aEg.thePlayer.motionZ *= -1.0;
            IO = true;
            this.IQ = 0;
            this.dj = false;
            this.tt = false;
            this.IU = aEg.thePlayer.inventory.currentItem;
            this.vq = false;
            this.hV = 0;
        }
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

        return -1;
    }

    @Override
    public void onDisable() {
        BlinkComponent.dispatch();
        if (aEg.thePlayer.onGround) {
            MoveUtil.stop();
        }

        if (this.IU != -1) {
            aEg.thePlayer.inventory.currentItem = this.IU;
        }

        this.IT.forEach(PacketUtil::p);
        this.IT.clear();
        if (this.qI != -1) {
            aEg.thePlayer.inventory.currentItem = this.qI;
        }

        this.hV = this.qI = -1;
        this.IN = IO = this.IP = false;
    }

    private int hr() {
        int i = -1;

        for (int j = 0; j < 9; j++) {
            ItemStack itemstack = aEg.thePlayer.inventory.getStackInSlot(j);
            if (itemstack != null && itemstack.getItem() == Items.fire_charge) {
                i = j;
                break;
            }
        }

        return i;
    }

    private void hs() {
        MoveUtil.strafe(1.768F);
    }
}
