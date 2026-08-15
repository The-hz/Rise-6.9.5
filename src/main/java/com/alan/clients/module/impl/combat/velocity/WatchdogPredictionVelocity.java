package com.alan.clients.module.impl.combat.velocity;

import com.alan.clients.component.impl.player.BlinkComponent;
import com.alan.clients.component.impl.player.LastConnectionComponent;
import com.alan.clients.module.impl.combat.KillAura;
import com.alan.clients.module.impl.combat.Velocity;
import com.alan.clients.module.impl.movement.Flight;
import com.alan.clients.module.impl.movement.LongJump;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.MoveInputEvent;
import com.alan.clients.newevent.impl.motion.JumpEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.NumberValue;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import de.florianmichael.vialoadingbase.ViaLoadingBase;
import hackclient.rise.afi;
import hackclient.rise.ahj;
import hackclient.rise.bv;
import java.util.ArrayList;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S14PacketEntity;
import net.minecraft.network.play.server.S32PacketConfirmTransaction;
import net.minecraft.network.play.server.S3BPacketScoreboardObjective;
import net.minecraft.network.play.server.S3CPacketUpdateScore;
import net.minecraft.network.play.server.S3EPacketTeams;
import net.minecraft.network.play.server.a;
import net.minecraft.network.play.server.bq;
import net.minecraft.network.play.server.z;
import net.minecraft.network.status.server.S01PacketPong;

public class WatchdogPredictionVelocity extends Mode<Velocity> {
    public final NumberValue velocityToLetThrough = new NumberValue("Velocity to let through", this, 0.3, 0, 0.6, 0.01);
    private final BooleanValue preventGhosting = new BooleanValue("Prevent Ghosting", this, true);
    public static boolean dj = false;
    public static boolean tt;
    private int tR;
    private final ArrayList<Packet<?>> vA = new ArrayList<>();
    private float ub;
    private double vB;
    private double vC;
    private boolean gD;
    private int dE;
    @EventLink(value = 2)
    public final Listener<PacketReceiveEvent> onPacketReceive = var1x -> {
        if (!tt && (!this.e(LongJump.class).isEnabled() || aEg.thePlayer.tR >= 29) && !this.e(Flight.class).isEnabled() && aEg.thePlayer.ticksExisted >= 50) {
            switch (var1x.getPacket()) {
                case S12PacketEntityVelocity s12packetentityvelocity:
                    if (s12packetentityvelocity.getEntityID() == aEg.thePlayer.getEntityId() && !var1x.isCancelled()) {
                        if (s12packetentityvelocity.getEntityID() == aEg.thePlayer.getEntityId() && s12packetentityvelocity.motionY > 0
                            || aEg.thePlayer.ae <= 14
                            || aEg.thePlayer.cqL <= 1) {
                            this.gD = true;
                        }

                        if (!aEg.thePlayer.onGround && aEg.thePlayer.Zl > 4) {
                            dj = true;
                            double d0 = s12packetentityvelocity.getMotionX() / 8000.0;
                            double d1 = s12packetentityvelocity.getMotionZ() / 8000.0;
                            this.ub = (float)Math.toDegrees(Math.atan2(d1, d0));
                            if (this.ub < -180.0F) {
                                this.ub += 360.0F;
                            }

                            if (this.ub > 180.0F) {
                                this.ub -= 360.0F;
                            }

                            this.vA.add(s12packetentityvelocity);
                            var1x.setCancelled();
                            this.vB = d0;
                            this.vC = d1;
                        }
                    }
                    break;
                case S32PacketConfirmTransaction s32packetconfirmtransaction:
                    if (dj) {
                        var1x.setCancelled();
                        this.vA.add(s32packetconfirmtransaction);
                    }
                    break;
                case a a:
                    if (dj) {
                        var1x.setCancelled();
                        this.vA.add(a);
                    }
                    break;
                case z z:
                    break;
                case S14PacketEntity s14packetentity:
                    break;
                default:
                    if (var1x.getPacket() instanceof S3BPacketScoreboardObjective
                        || var1x.getPacket() instanceof S3CPacketUpdateScore
                        || var1x.getPacket() instanceof bq
                        || var1x.getPacket() instanceof S3EPacketTeams) {
                        return;
                    }

                    Packet packet = var1x.getPacket();
                    String s = packet.getClass().getName();
                    if (dj && s.startsWith("net.minecraft.network.play.server.")) {
                        var1x.setCancelled();
                        this.vA.add(packet);
                    }
            }
        }
    };
    @EventLink
    public final Listener<PreUpdateEvent> vE = var0 -> {
        if (BlinkComponent.enabled) {
            dj = true;
        }

        if (!bv.f(7.0).isEmpty()) {
            ;
        }
    };
    @EventLink
    public final Listener<PreUpdateEvent> vF = var1x -> {
        if (dj) {
            ;
        }

        if (this.e(KillAura.class).lV.wo().getName().equals("Watchdog 1.8")
            && !ViaLoadingBase.getInstance().getTargetVersion().newerThanOrEqualTo(ProtocolVersion.v1_13)
            && LastConnectionComponent.ip != null
            && LastConnectionComponent.ip.contains("hypixel")
            && aEg.thePlayer.ticksExisted % 5 == 0) {
            afi.b("don't use this velocity with this autoblock instead use legit or any other mode");
        }

        if (dj || aEg.thePlayer.Zl == 1) {
            float f = aEg.thePlayer.pl % 360.0F;
            if (f < -180.0F) {
                f += 360.0F;
            }

            if (f > 180.0F) {
                f -= 360.0F;
            }

            float f1 = Math.abs(f - this.ub);
            float f2 = 15.0F;
            if (!aEg.thePlayer.onGround && (!(Math.random() > 0.98) || !this.preventGhosting.wo())) {
                if (f1 <= f2 || f1 >= 360.0F - f2) {
                    tt = true;
                    dj = false;
                    this.vA.stream().filter(var0 -> !(var0 instanceof S01PacketPong)).forEach(ahj::p);
                    this.vA.clear();
                    tt = false;
                    this.tR = 0;
                } else if (aEg.thePlayer.tR > 13) {
                    tt = true;
                    dj = false;
                    this.vA.stream().filter(var0 -> !(var0 instanceof S01PacketPong)).forEach(ahj::p);
                    this.vA.clear();
                    tt = false;
                }
            } else {
                if (aEg.thePlayer.tR > 3 && aEg.gameSettings.keyBindJump.isKeyDown() && this.preventGhosting.wo()) {
                    double d0;
                    int i = (d0 = Math.hypot(aEg.thePlayer.crI, aEg.thePlayer.crK) - this.velocityToLetThrough.wo().doubleValue()) == 0.0 ? 0 : (d0 < 0.0 ? -1 : 1);
                }

                tt = true;
                dj = false;
                this.vA.stream().filter(var0 -> !(var0 instanceof S01PacketPong)).forEach(ahj::p);
                this.vA.clear();
                tt = false;
            }
        }
    };
    @EventLink
    public final Listener<JumpEvent> onJump = var1x -> this.dE++;
    @EventLink
    public final Listener<MoveInputEvent> onMoveInput = var1x -> {
        if (this.gD) {
            if (!ViaLoadingBase.getInstance().getTargetVersion().newerThan(ProtocolVersion.v1_12_1) || !aEg.thePlayer.isJumping) {
                var1x.setJump(true);
            }

            this.gD = false;
        }

        if (dj || tt) {
            this.gD = false;
        }

        if (!dj) {
            ;
        }
    };

    public WatchdogPredictionVelocity(String var1, Velocity var2) {
        super(var1, var2);
    }
}
