package com.alan.clients.module.impl.movement.jesus;

import com.alan.clients.component.impl.player.BlinkComponent;
import com.alan.clients.module.impl.movement.Flight;
import com.alan.clients.module.impl.movement.Jesus;
import com.alan.clients.module.impl.movement.LongJump;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.KeyboardInputEvent;
import com.alan.clients.newevent.impl.input.MoveInputEvent;
import com.alan.clients.newevent.impl.motion.JumpEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.value.Mode;
import com.alan.clients.util.packet.PacketUtil;
import com.alan.clients.component.impl.player.FallDistanceComponent;
import java.util.ArrayList;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S32PacketConfirmTransaction;

public class WatchdogDolphin118Jesus extends Mode<Jesus> {
    public static int Km = 0;
    private boolean Kv;
    private boolean HJ;
    private int Kw;
    private int Kx;
    @EventLink(value = 3)
    public final Listener<PreMotionEvent> onPreMotion = var1x -> {
        if (!this.e(LongJump.class).isEnabled() && !this.e(Flight.class).isEnabled() && Km <= 30) {
            if (!aEg.thePlayer.inWater) {
                this.Kw++;
            } else {
                MoveUtil.strafe();
                this.Kw = 0;
            }

            if (!aEg.thePlayer.inWater && aEg.thePlayer.onGround) {
                Km = 31;
            }

            if (aEg.thePlayer.ae == 0 && this.Kv) {
                MoveUtil.strafe();
            } else if (aEg.thePlayer.ae == 0) {
                MoveUtil.strafe();
            }

            var1x.setSprinting(true);
            if (aEg.thePlayer.inWater) {
                Km = 0;
            } else {
                Km++;
                if (aEg.thePlayer.ae > 1 && Km < 30) {
                    aEg.thePlayer.motionY += 0.0281;
                }
            }

            switch (aEg.thePlayer.ae) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
            }
        }
    };
    private final ArrayList<Packet<?>> Kz = new ArrayList<>();
    private boolean dj;
    private boolean tt;
    private boolean vq;
    int IU = -1;
    double jy;
    double IW = -1.0;
    private int dE;
    private int hV;
    @EventLink
    public final Listener<StrafeEvent> onStrafe = var0 -> {
        if (aEg.thePlayer.inWater) {
            aEg.timer.dzD = 0.5F;
            PacketUtil.l(new C03PacketPlayer(true));
        }

        if (aEg.thePlayer.inWater) {
            BlinkComponent.a(100, true, true, false, false, false);
            var0.setSpeed(0.2);
        }

        double d0;
        int i = (d0 = MoveUtil.speed() - 0.205) == 0.0 ? 0 : (d0 < 0.0 ? -1 : 1);
    };
    @EventLink(value = 2)
    public final Listener<PacketReceiveEvent> onPacketReceive = var1x -> {
        if (!this.tt) {
            switch (var1x.getPacket()) {
                case S12PacketEntityVelocity s12packetentityvelocity:
                    if (!var1x.isCancelled()
                        && s12packetentityvelocity.getEntityID() == aEg.thePlayer.getEntityId()
                        && (Km < 30 || aEg.thePlayer.inWater)
                        && (s12packetentityvelocity.getMotionY() / 8000.0 > 0.4 || s12packetentityvelocity.getMotionY() / 8000.0 < 0.1)) {
                        new Vector2d(aEg.thePlayer.motionX, aEg.thePlayer.motionZ);
                        this.IW = s12packetentityvelocity.getMotionZ() / 8000.0;
                        this.IW = s12packetentityvelocity.getMotionY() / 8000.0;
                        var1x.setCancelled();
                        this.dj = true;
                        this.Kz.add(s12packetentityvelocity);
                        if (this.IW > 0.2) {
                            this.Kx++;
                        }

                        if (this.Kx == 2) {
                            this.Kv = true;
                        }
                    } else {
                        var1x.setCancelled();
                    }
                    break;
                case S32PacketConfirmTransaction s32packetconfirmtransaction:
                    if (this.dj) {
                        this.Kz.add(s32packetconfirmtransaction);
                        var1x.setCancelled();
                    }
                    break;
                default:
            }
        }
    };
    @EventLink
    public final Listener<MoveInputEvent> onMoveInput = var0 -> {
        if (aEg.thePlayer.inWater) {
            var0.setJump(true);
        }
    };
    @EventLink
    public final Listener<JumpEvent> onJump = var0 -> {};
    @EventLink
    public final Listener<KeyboardInputEvent> onKeyboardInput = var1x -> {
        if (var1x.getKeyCode() == this.getParent().getKey() && !this.HJ) {
            var1x.setCancelled();
            this.HJ = true;
        }
    };
    @EventLink(value = 4)
    public final Listener<PreUpdateEvent> onPreUpdate = var1x -> {
        if (this.dj && (!aEg.thePlayer.inWater || this.Kv) && Km < 30) {
            aEg.thePlayer.ae = 1;
            this.vq = true;
            this.dj = false;
            this.tt = true;
            new Vector2d(aEg.thePlayer.motionX, aEg.thePlayer.motionZ);
            this.Kz.forEach(PacketUtil::p);
            this.Kv = false;
            if (aEg.thePlayer.Zl > 20 && this.IW > 0.4) {
                aEg.thePlayer.motionX *= 1.23;
                aEg.thePlayer.motionZ *= 1.23;
            }

            this.Kz.clear();
            this.tt = false;
        }
    };

    public WatchdogDolphin118Jesus(String var1, Jesus var2) {
        super(var1, var2);
    }

    @Override
    public void onEnable() {
        this.Kz.forEach(PacketUtil::p);
        this.Kz.clear();
        FallDistanceComponent.cY = 0.0F;
    }

    @Override
    public void onDisable() {
        this.Kz.forEach(PacketUtil::p);
        this.Kz.clear();
        this.Kv = false;
        this.Kx = 0;
    }
}
