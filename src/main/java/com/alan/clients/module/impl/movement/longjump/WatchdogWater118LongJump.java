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
import hackclient.rise.ahj;
import hackclient.rise.bd;
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
    public Listener<JumpEvent> KQ;
    public int IU;
    @EventLink
    public Listener<StrafeEvent> KN;
    @EventLink
    public Listener<MoveInputEvent> KP;
    public boolean tt;
    public int Kw;
    public boolean Kv;
    public static int[] fld_0OOOoo00o0_37;
    @EventLink(cH = 4)
    public Listener<PreUpdateEvent> KS;
    public boolean vq;
    @EventLink(cH = 2)
    public Listener<PacketReceiveEvent> KO;
    public ArrayList<Packet<?>> KM;
    @EventLink(cH = 3)
    public Listener<PreMotionEvent> KL;
    public boolean dj;
    public int dE;
    @EventLink
    public Listener<KeyboardInputEvent> KR;
    public int Kx;
    public boolean HJ;
    public double jy;
    public double IW;

    public static void o0Oo000O0oO() {
    }

    @Override
    public void onDisable() {
        this.KM.forEach(ahj::p);
        this.KM.clear();
        this.Kv = false;
        this.Kx = 0;
        MoveUtil.stop();
    }

    public WatchdogWater118LongJump(final String s, final LongJump longJump) {
        super(s, longJump);
        this.KL = (preMotionEvent -> {
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
            final long n = (long)WatchdogWater118LongJump.aEg.thePlayer.ae << 32;
            final long n2 = 4412184569908866215L;
            switch ((int)((n2 ^ ((n ^ n2) & -1L << 32)) >>> 32)) {
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
        this.KN = (p0 -> {
            if (WatchdogWater118LongJump.aEg.thePlayer.inWater) {
                MoveUtil.stop();
                WatchdogWater118LongJump.aEg.timer.dzD = 0.33f;
                ahj.l(new C03PacketPlayer(true));
                ahj.l(new C03PacketPlayer.C04PacketPlayerPosition(WatchdogWater118LongJump.aEg.thePlayer.posX, WatchdogWater118LongJump.aEg.thePlayer.posY + 0.068, WatchdogWater118LongJump.aEg.thePlayer.posZ, true));
            }
            final boolean b = MoveUtil.speed() < 0.205;
            return;
        });
        this.KO = (packetReceiveEvent -> {
            if (this.tt) {
                return;
            }
            else {
                final Packet packet = packetReceiveEvent.dq();
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
        this.KP = (moveInputEvent -> {
            if (WatchdogWater118LongJump.aEg.thePlayer.inWater) {
                moveInputEvent.setJump(true);
            }
            return;
        });
        this.KQ = (p0 -> {});
        this.KR = (keyboardInputEvent -> {
            if (keyboardInputEvent.cO() == this.wj().getKey() && !this.HJ) {
                keyboardInputEvent.setCancelled();
                this.HJ = true;
            }
            return;
        });
        this.KS = (p0 -> {
            if (this.dj && !WatchdogWater118LongJump.aEg.thePlayer.inWater) {
                WatchdogWater118LongJump.aEg.thePlayer.ae = 0;
                this.vq = true;
                this.dj = false;
                this.tt = true;
                new Vector2d(WatchdogWater118LongJump.aEg.thePlayer.motionX, WatchdogWater118LongJump.aEg.thePlayer.motionZ);
                this.KM.forEach(ahj::p);
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
        o0Oo000O0oO();
    }

    @Override
    public void onEnable() {
        this.KM.forEach(ahj::p);
        this.KM.clear();
        if (WatchdogWater118LongJump.aEg.thePlayer.onGround) {
            MoveUtil.stop();
        }
        bd.cY = 0.0f;
    }

}
