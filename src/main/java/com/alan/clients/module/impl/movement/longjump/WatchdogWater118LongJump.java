package com.alan.clients.module.impl.movement.longjump;

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
import java.util.Objects;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S32PacketConfirmTransaction;

public class WatchdogWater118LongJump extends Mode<LongJump>
{
    public int hV;
    @EventLink
    public Listener<JumpEvent> onJump;
    public int IU;
    @EventLink
    public Listener<StrafeEvent> onStrafe;
    @EventLink
    public Listener<MoveInputEvent> onMoveInput;
    public boolean tt;
    public int Kw;
    public boolean Kv;
    @EventLink(value = 4)
    public Listener<PreUpdateEvent> onPreUpdate;
    public boolean vq;
    @EventLink(value = 2)
    public Listener<PacketReceiveEvent> onPacketReceive;
    public ArrayList<Packet<?>> KM;
    @EventLink(value = 3)
    public Listener<PreMotionEvent> onPreMotion;
    public boolean dj;
    public int dE;
    @EventLink
    public Listener<KeyboardInputEvent> onKeyboardInput;
    public int Kx;
    public boolean HJ;
    public double jy;
    public double IW;


    @Override
    public void onDisable() {
        this.KM.forEach(PacketUtil::p);
        this.KM.clear();
        this.Kv = false;
        this.Kx = 0;
        MoveUtil.stop();
    }

    public WatchdogWater118LongJump(final String s, final LongJump longJump) {
        super(s, longJump);
        this.onPreMotion = (preMotionEvent -> {
            if (!WatchdogWater118LongJump.aEg.thePlayer.inWater) {
                ++this.Kw;
            }
            else {
                MoveUtil.strafe();
                this.Kw = 0;
            }
            if (WatchdogWater118LongJump.aEg.thePlayer.ae == 0 && this.Kv) {
                final EntityPlayerSP thePlayer = WatchdogWater118LongJump.aEg.thePlayer;
                thePlayer.motionX *= 4.1;
                final EntityPlayerSP thePlayer2 = WatchdogWater118LongJump.aEg.thePlayer;
                thePlayer2.motionZ *= 4.1;
                MoveUtil.strafe();
            }
            else if (WatchdogWater118LongJump.aEg.thePlayer.ae == 0) {
                MoveUtil.strafe();
            }
            preMotionEvent.setSprinting(true);
            if (!WatchdogWater118LongJump.aEg.thePlayer.inWater) {
                final EntityPlayerSP thePlayer3 = WatchdogWater118LongJump.aEg.thePlayer;
                thePlayer3.motionY += 0.0281;
            }
            final boolean inWater = WatchdogWater118LongJump.aEg.thePlayer.inWater;
            switch (WatchdogWater118LongJump.aEg.thePlayer.ae) {
                case 1: {}
                case 7: {
                    WatchdogWater118LongJump.aEg.thePlayer.motionY = 0.03;
                    break;
                }
                case 8: {
                    WatchdogWater118LongJump.aEg.thePlayer.motionY = 0.03;
                }
                case 9: {}
                case 11: {
                    final EntityPlayerSP thePlayer4 = WatchdogWater118LongJump.aEg.thePlayer;
                    thePlayer4.motionY += 0.01;
                    break;
                }
            }
            return;
        });
        this.KM = new ArrayList<Packet<?>>();
        this.IU = -1;
        this.IW = -1.0;
        this.onStrafe = (p0 -> {
            if (WatchdogWater118LongJump.aEg.thePlayer.inWater) {
                MoveUtil.stop();
                WatchdogWater118LongJump.aEg.timer.dzD = 0.33f;
                PacketUtil.l(new C03PacketPlayer(true));
                PacketUtil.l(new C03PacketPlayer.C04PacketPlayerPosition(WatchdogWater118LongJump.aEg.thePlayer.posX, WatchdogWater118LongJump.aEg.thePlayer.posY + 0.068, WatchdogWater118LongJump.aEg.thePlayer.posZ, true));
            }
            final boolean b = MoveUtil.speed() < 0.205;
            return;
        });
        this.onPacketReceive = (packetReceiveEvent -> {
            if (this.tt) {
                return;
            }
            else {
                final Packet packet = packetReceiveEvent.getPacket();
                Objects.requireNonNull(packet);
                switch (packet) {
                    case S12PacketEntityVelocity s12PacketEntityVelocity: {
                        if (!packetReceiveEvent.isCancelled() && s12PacketEntityVelocity.getEntityID() == WatchdogWater118LongJump.aEg.thePlayer.getEntityId()) {
                            new Vector2d(WatchdogWater118LongJump.aEg.thePlayer.motionX, WatchdogWater118LongJump.aEg.thePlayer.motionZ);
                            this.IW = s12PacketEntityVelocity.getMotionZ() / 8000.0;
                            this.IW = s12PacketEntityVelocity.getMotionY() / 8000.0;
                            packetReceiveEvent.setCancelled();
                            this.dj = true;
                            this.KM.add(s12PacketEntityVelocity);
                            break;
                        }
                        else {
                            break;
                        }
                    }
                    case S32PacketConfirmTransaction s32PacketConfirmTransaction: {
                        if (this.dj) {
                            this.KM.add(s32PacketConfirmTransaction);
                            packetReceiveEvent.setCancelled();
                            break;
                        }
                        else {
                            break;
                        }
                    }
                    default:
                        break;
                }
                return;
            }
        });
        this.onMoveInput = (moveInputEvent -> {
            if (WatchdogWater118LongJump.aEg.thePlayer.inWater) {
                moveInputEvent.setJump(true);
            }
            return;
        });
        this.onJump = (p0 -> {});
        this.onKeyboardInput = (keyboardInputEvent -> {
            if (keyboardInputEvent.getKeyCode() == this.getParent().getKey() && !this.HJ) {
                keyboardInputEvent.setCancelled();
                this.HJ = true;
            }
            return;
        });
        this.onPreUpdate = (p0 -> {
            if (this.dj && !WatchdogWater118LongJump.aEg.thePlayer.inWater) {
                WatchdogWater118LongJump.aEg.thePlayer.ae = 0;
                this.vq = true;
                this.dj = false;
                this.tt = true;
                new Vector2d(WatchdogWater118LongJump.aEg.thePlayer.motionX, WatchdogWater118LongJump.aEg.thePlayer.motionZ);
                this.KM.forEach(PacketUtil::p);
                if (this.IW > 0.41) {
                    ++this.Kx;
                }
                if (this.Kx == 2) {
                    this.Kv = true;
                }
                this.KM.clear();
                if (!this.Kv) {
                    final EntityPlayerSP thePlayer5 = WatchdogWater118LongJump.aEg.thePlayer;
                    thePlayer5.motionX *= 1.3;
                    final EntityPlayerSP thePlayer6 = WatchdogWater118LongJump.aEg.thePlayer;
                    thePlayer6.motionZ *= 1.3;
                }
                else {
                    final EntityPlayerSP thePlayer7 = WatchdogWater118LongJump.aEg.thePlayer;
                    thePlayer7.motionX *= 1.1;
                    final EntityPlayerSP thePlayer8 = WatchdogWater118LongJump.aEg.thePlayer;
                    thePlayer8.motionZ *= 1.1;
                }
                this.tt = false;
            }
        });
    }

    static {
    }

    @Override
    public void onEnable() {
        this.KM.forEach(PacketUtil::p);
        this.KM.clear();
        if (WatchdogWater118LongJump.aEg.thePlayer.onGround) {
            MoveUtil.stop();
        }
        FallDistanceComponent.cY = 0.0f;
    }

}
