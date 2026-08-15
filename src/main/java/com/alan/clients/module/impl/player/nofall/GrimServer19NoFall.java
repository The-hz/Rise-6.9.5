package com.alan.clients.module.impl.player.nofall;

import com.alan.clients.module.impl.player.NoFall;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.MoveInputEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import hackclient.rise.ahj;
import hackclient.rise.aih;
import hackclient.rise.bd;
import java.util.ArrayList;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S32PacketConfirmTransaction;
import net.minecraft.network.play.server.a;

public class GrimServer19NoFall extends Mode<NoFall> {
    private boolean aiE;
    public static boolean dj = false;
    public static boolean tt;
    private int tR;
    private final ArrayList<Packet<?>> aiF = new ArrayList<>();
    private float ub;
    private double vB;
    private double vC;
    private final BooleanValue newestGrimMayFlagTheAnticheat = new BooleanValue("Newest Grim, may flag the anticheat", this, false);
    private boolean gD;
    @EventLink(value = 2)
    public final Listener<PacketReceiveEvent> onPacketReceive = var1x -> {
        if (!tt && aEg.thePlayer.ticksExisted >= 10 && !aEg.thePlayer.isCollidedHorizontally) {
            switch (var1x.getPacket()) {
                case S12PacketEntityVelocity s12packetentityvelocity:
                    if (s12packetentityvelocity.getEntityID() == aEg.thePlayer.getEntityId() && !var1x.isCancelled()) {
                        if (s12packetentityvelocity.getEntityID() == aEg.thePlayer.getEntityId() && s12packetentityvelocity.motionY > 0
                            || aEg.thePlayer.ae <= 14
                            || aEg.thePlayer.cqL <= 1) {
                            this.gD = true;
                        }

                        if (!aEg.thePlayer.onGround && this.aiE) {
                            dj = true;
                        }
                    }
                    break;
                case S32PacketConfirmTransaction s32packetconfirmtransaction:
                    if (dj) {
                        return;
                    }
                    break;
                case a a:
                    if (dj) {
                        return;
                    }
                    break;
                default:
            }
        }
    };
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var1x -> {
        if (!aEg.thePlayer.isCollidedHorizontally) {
            float f = bd.cY;
            if (aEg.thePlayer.motionY > 0.1) {
                this.aiE = false;
            }

            if (f > 3.0F) {
                this.aiE = true;
            }

            if (this.aiE && aEg.thePlayer.onGround) {
                if (!this.newestGrimMayFlagTheAnticheat.wo()) {
                    var1x.setCancelled(true);
                } else {
                    ahj.l(new C04PacketPlayerPosition(aEg.thePlayer.posX, aEg.thePlayer.posY + 0.01, aEg.thePlayer.posZ, true));
                }

                var1x.setCancelled(true);
                ahj.l(new C03PacketPlayer(true));
                aEg.gameSettings.keyBindJump.setPressed(false);
                f = 0.0F;
            }

            if (this.aiE) {
                aEg.gameSettings.keyBindJump.setPressed(false);
            }

            if (aih.vi() > 5.0 && aEg.thePlayer.tR == 9 && aEg.thePlayer.Zl > 200 && this.newestGrimMayFlagTheAnticheat.wo()) {
                aEg.thePlayer.motionY = MoveUtil.predictedMotion(aEg.thePlayer.motionY, 10);
            }

            bd.cY = f;
        }
    };
    @EventLink(value = 2)
    public final Listener<PreUpdateEvent> onPreUpdate = var1x -> {
        if (dj && aEg.thePlayer.onGround) {
            tt = true;
            dj = false;
            this.aiF.forEach(ahj::p);
            this.aiF.clear();
            tt = false;
        }
    };
    @EventLink
    public final Listener<MoveInputEvent> onMoveInput = var1x -> {
        if (!aEg.thePlayer.isCollidedHorizontally) {
            if (this.gD && this.aiE) {
                var1x.setJump(true);
                this.gD = false;
            } else if (this.aiE) {
            }
        }
    };

    public GrimServer19NoFall(String var1, NoFall var2) {
        super(var1, var2);
    }

    @Override
    public void onEnable() {
        this.aiE = false;
    }
}
