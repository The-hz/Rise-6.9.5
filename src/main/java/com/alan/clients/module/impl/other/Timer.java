package com.alan.clients.module.impl.other;

import com.alan.clients.component.impl.player.BlinkComponent;
import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.KeyboardInputEvent;
import com.alan.clients.newevent.impl.input.MoveInputEvent;
import com.alan.clients.newevent.impl.motion.JumpEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.other.TeleportEvent;
import com.alan.clients.newevent.impl.other.TickEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.BoundsNumberValue;
import com.alan.clients.value.impl.NumberValue;
import hackclient.rise.afi;
import hackclient.rise.ahg;
import hackclient.rise.ahj;
import hackclient.rise.ahk;
import hackclient.rise.bc;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S32PacketConfirmTransaction;

@ModuleInfo(aliases = "module.other.timer.name", description = "module.other.timer.description", category = Category.MOVEMENT)
public final class Timer extends Module {
    private boolean HJ;
    public static ConcurrentLinkedQueue<ahk> Zk = new ConcurrentLinkedQueue<>();
    private int Zl;
    private long Ss;
    private final BoundsNumberValue timer = new BoundsNumberValue("Timer", this, 1, 2, 0.1, 20, 0.05);
    public final BooleanValue Zn = new BooleanValue("Watchdog", this, false);
    public final BooleanValue Zo = new BooleanValue("Compensate Low Timer", this, false);
    public final NumberValue Zp = new NumberValue("Compensate Speed", this, 1.5, 1.0, 5.0, 0.05, () -> !this.Zo.wo());
    public final NumberValue Zq = new NumberValue("Balance Multiplier", this, 1, 0.1, 10.0, 0.05, () -> !this.Zo.wo());
    private double yC = 0.0;
    private boolean Zr;
    @EventLink(cH = 2)
    public final Listener<PreMotionEvent> Zs = var1 -> {
        if (!this.Zn.wo()) {
            if (!this.Zr) {
                aEg.timer.dzD = (float)ahg.l(this.timer.wo().floatValue(), this.timer.wA().floatValue());
            }

            if (this.Zo.wo() && this.Zr) {
                aEg.timer.dzD = this.Zp.wo().floatValue();
            }
        } else if (this.Zn.wo()) {
            var1.setOnGround(true);
            if (this.HJ && System.currentTimeMillis() > this.Ss) {
                aEg.thePlayer.motionX *= 0.0;
                aEg.thePlayer.motionZ *= 0.0;
                this.Ss = 0L;
                this.e(Timer.class).toggle();
            }
        }
    };
    @EventLink(cH = 3)
    public final Listener<PreUpdateEvent> Zt = var1 -> {
        if (this.Zn.wo()) {
            BlinkComponent.a(9999999, false, false, false, false, true);
            aEg.thePlayer.crd = true;
        }
    };
    @EventLink
    public final Listener<TickEvent> Zu = var1 -> {
        if (this.Zn.wo() && !this.HJ) {
            if (aEg.thePlayer.onGround) {
                this.Zl++;
                double d0 = aEg.thePlayer.posX;
                double d1 = aEg.thePlayer.posY;
                double d2 = aEg.thePlayer.posZ;
                ahj.l(new C04PacketPlayerPosition(d0, d1, d2, true));
                ahj.l(new C04PacketPlayerPosition(d0, d1 - 1.0E-16, d2, true));
                ahj.l(new C04PacketPlayerPosition(d0, d1 + 0.07, d2, true));
                ahj.l(new C04PacketPlayerPosition(d0, d1, d2, true));
                aEg.timer.dzD = this.timer.wo().floatValue();
            } else if (this.Zn.wo()) {
            }
        }
    };
    @EventLink
    public final Listener<MoveInputEvent> Zv = var1 -> {
        if (this.Zn.wo() && aEg.thePlayer.onGround && this.Zl == 0) {
            MoveUtil.stop();
        }
    };
    @EventLink
    public final Listener<StrafeEvent> Zw = var1 -> {
        if (this.Zn.wo() && this.HJ) {
            MoveUtil.stop();
            aEg.timer.dzD = 1.0F;
            if (aEg.thePlayer.onGround) {
                Zk.forEach(var0 -> ahj.n(var0.dq()));
                Zk.clear();
                BlinkComponent.dispatch();
            }
        }
    };
    @EventLink(cH = 0)
    public final Listener<PacketSendEvent> Zx = var1 -> {
        if (this.Zo.wo()) {
            Packet packet = var1.dq();
            if (packet instanceof C03PacketPlayer && (!var1.isCancelled() || bc.cR)) {
                if (this.Zr) {
                    if (this.yC > 0.0) {
                        this.yC--;
                        if (this.yC <= 0.0) {
                            this.Zr = false;
                            aEg.timer.dzD = 1.0F;
                            this.toggle();
                        }
                    }
                } else if (this.ig()) {
                    this.yC = this.yC + this.Zq.wo().doubleValue();
                }
            }
        }

        if (this.Zn.wo() && aEg.thePlayer.onGround) {
            Packet packet1 = var1.dq();
            if (packet1 instanceof S32PacketConfirmTransaction) {
                Zk.add(new ahk(packet1));
                var1.setCancelled();
            }
        }
    };
    @EventLink
    public final Listener<PacketReceiveEvent> Zy = var1 -> {
        if (this.Zn.wo()) {
            Packet packet = var1.dq();
            if (packet instanceof S12PacketEntityVelocity) {
                var1.setCancelled();
            }

            if (packet instanceof S08PacketPlayerPosLook) {
                var1.setCancelled();
            }
        }
    };
    @EventLink(cH = 4)
    public final Listener<TeleportEvent> Zz = var0 -> {};
    @EventLink
    public final Listener<JumpEvent> ZA = var1 -> {
        if (this.Zn.wo()) {
            var1.setCancelled();
        }
    };
    @EventLink
    public final Listener<KeyboardInputEvent> ZB = var1 -> {
        if (this.Zo.wo() && var1.cO() == this.e(Timer.class).getKey() && this.isEnabled()) {
            if (!this.Zr && this.yC > 0.0) {
                this.Zr = true;
                aEg.timer.dzD = this.Zp.wo().floatValue();
                var1.setCancelled();
                return;
            }

            if (this.Zr) {
                var1.setCancelled();
                return;
            }
        }

        if (this.Zn.wo() && var1.cO() == this.e(Timer.class).getKey() && !this.HJ) {
            this.Ss = System.currentTimeMillis() + 200L;
            this.HJ = true;
            afi.b("sent");
            var1.setCancelled();
        }

        if (this.Zn.wo() && this.HJ) {
            var1.setCancelled();
        }
    };

    public Timer() {
    }

    @Override
    public void onEnable() {
        this.yC = 0.0;
        this.Zr = false;
        if (this.Zn.wo()) {
            aEg.thePlayer.stepHeight = 0.0F;
            this.HJ = false;
            this.Zl = 0;
            this.Ss = 0L;
        }
    }

    @Override
    public void onDisable() {
        if (aEg.timer.dzD != 1.0F) {
            aEg.timer.dzD = 1.0F;
        }

        if (this.Zn.wo()) {
            aEg.thePlayer.stepHeight = 0.6F;
            aEg.thePlayer.motionX *= 0.0;
            aEg.thePlayer.motionZ *= 0.0;
        }
    }

    private boolean ig() {
        return this.timer.wo().floatValue() < 1.0F || aEg.timer.dzD < 1.0F;
    }
}
