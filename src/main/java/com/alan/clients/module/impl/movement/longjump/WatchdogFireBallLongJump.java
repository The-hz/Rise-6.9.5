package com.alan.clients.module.impl.movement.longjump;

import com.alan.clients.component.impl.player.RotationComponent;
import com.alan.clients.component.impl.player.rotationcomponent.MovementFix;
import com.alan.clients.module.impl.movement.LongJump;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.MoveInputEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import hackclient.rise.afi;
import com.alan.clients.util.packet.PacketUtil;
import java.util.ArrayList;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFireball;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S32PacketConfirmTransaction;
import rip.vantage.commons.util.time.a;

public class WatchdogFireBallLongJump extends Mode<LongJump> {
    public final BooleanValue boost = new BooleanValue("Boost", this, true);
    private int qI = -1;
    private int hV = -1;
    private boolean IN;
    public static boolean IO;
    private boolean IP;
    private int IQ;
    private boolean IR;
    private boolean Ms;
    a bN = new a();
    public static boolean dj = false;
    public static boolean tt;
    private int tR;
    private final ArrayList<Packet<?>> Mt = new ArrayList<>();
    private float ub;
    private double vB;
    private double vC;
    private boolean gD;
    @EventLink
    public final Listener<PacketSendEvent> onPacketSend = var1x -> {
        if (var1x.dq() instanceof C08PacketPlayerBlockPlacement
            && ((C08PacketPlayerBlockPlacement)var1x.dq()).getStack() != null
            && ((C08PacketPlayerBlockPlacement)var1x.dq()).getStack().getItem() instanceof ItemFireball) {
            this.IR = true;
        }
    };
    @EventLink(value = 2)
    public final Listener<PacketReceiveEvent> onPacketReceive = var1x -> {
        Packet packet = var1x.getPacket();
        if (!tt) {
            if (packet instanceof S12PacketEntityVelocity) {
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
                    if (s12packetentityvelocity.getEntityID() == aEg.thePlayer.getEntityId() && !var1x.isCancelled()) {
                        this.hV = 0;
                        this.IN = true;
                        this.IR = false;
                        IO = true;
                        this.Mt.add(s12packetentityvelocity);
                        var1x.setCancelled();
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

                        this.vB = d0;
                        this.vC = d1;
                    }
                    break;
                case S32PacketConfirmTransaction s32packetconfirmtransaction:
                    if (dj) {
                        var1x.setCancelled();
                        this.Mt.add(s32packetconfirmtransaction);
                    }
                    break;
                case net.minecraft.network.play.server.a a:
                    if (dj) {
                        var1x.setCancelled();
                        this.Mt.add(a);
                    }
                    break;
                default:
                    if (dj) {
                    }
            }
        }
    };
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var1x -> {
        if (this.IQ == 0) {
            RotationComponent.d(false);
            RotationComponent.setRotations(new Vector2f(aEg.thePlayer.pl, 89.0F), 10.0, MovementFix.NORMAL);
            int i = this.hr();
            if (i != -1 && i != aEg.thePlayer.inventory.currentItem) {
                this.qI = aEg.thePlayer.inventory.currentItem;
                if (aEg.thePlayer.cqL > 1) {
                    aEg.thePlayer.inventory.currentItem = i;
                }
            }
        }

        if (this.IQ == 1) {
            if (!this.IP) {
                PacketUtil.l(new C08PacketPlayerBlockPlacement(aEg.thePlayer.getHeldItem()));
                this.IP = true;
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
        }
    };
    @EventLink(value = 2)
    public final Listener<PreUpdateEvent> onPreUpdate = var1x -> {
        if (dj && aEg.thePlayer.tR == 13) {
            tt = true;
            dj = false;
            this.Mt.forEach(PacketUtil::p);
            this.Mt.clear();
            tt = false;
            this.tR = 0;
        }

        if (!aEg.thePlayer.onGround) {
            RotationComponent.setRotations(new Vector2f(aEg.thePlayer.pl + 45.0F, aEg.thePlayer.rotationPitch), 10.0, MovementFix.NORMAL);
        }
    };
    @EventLink
    public final Listener<MoveInputEvent> onMoveInput = var1x -> {
        if (this.gD) {
            this.gD = false;
        }

        if (dj || tt) {
            this.gD = false;
        }

        if (!dj) {
            ;
        }
    };

    public WatchdogFireBallLongJump(String var1, LongJump longJump) {
        super(var1, longJump);
    }

    @Override
    public void onDisable() {
        this.Mt.clear();
        tt = false;
        dj = false;
        if (aEg.thePlayer.onGround) {
            MoveUtil.stop();
        }

        if (this.qI != -1) {
            aEg.thePlayer.inventory.currentItem = this.qI;
        }

        this.hV = this.qI = -1;
        this.IN = IO = this.IP = false;
        this.IQ = 0;
    }

    @Override
    public void onEnable() {
        this.Mt.clear();
        tt = false;
        dj = false;
        if (this.hr() == -1) {
            afi.b("Could not find Fireball");
            this.toggle();
        } else {
            IO = true;
            this.IQ = 0;
        }
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
}
