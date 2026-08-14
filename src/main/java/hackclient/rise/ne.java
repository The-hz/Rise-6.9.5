package hackclient.rise;

import com.alan.clients.module.impl.movement.Flight;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.NumberValue;
import com.alan.clients.value.impl.SubMode;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;
import net.minecraft.network.play.client.C03PacketPlayer.C05PacketPlayerLook;
import net.minecraft.network.play.client.C03PacketPlayer.C06PacketPlayerPosLook;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.network.play.server.S12PacketEntityVelocity;

public class ne extends Mode<Flight> {
    private final ModeValue GC = new ModeValue("Lag Mode", this)
        .add(new SubMode("Packet"))
        .add(new SubMode("VoidTP"))
        .add(new SubMode("VoidTP2"))
        .add(new SubMode("Packet2"))
        .add(new SubMode("Packet3"))
        .setDefault("Packet");
    private final ModeValue GD = new ModeValue("Jump Mode", this).add(new SubMode("SlowJump")).add(new SubMode("Jump")).setDefault("SlowJump");
    private final BooleanValue GE = new BooleanValue("Motion Modify", this, false);
    private final NumberValue GF = new NumberValue("Motion", this, 0.27, 0.12, 0.4, 0.01, () -> !this.GE.wo());
    private final NumberValue GG = new NumberValue("Offset Size", this, 10.0, 10.0, 1024.0, 1.0);
    private final BooleanValue GH = new BooleanValue("Spoof Ground", this, false);
    private final NumberValue GI = new NumberValue("Timer", this, 0.1, 0.05, 1.0, 0.01);
    private final NumberValue GJ = new NumberValue("Min Flags", this, 1.0, 1.0, 5.0, 1.0);
    private final BooleanValue GK = new BooleanValue("C06 To C04", this, false);
    private final BooleanValue GL = new BooleanValue("Flat Test", this, false);
    private final NumberValue GM = new NumberValue("Flat Ticks", this, 10.0, 8.0, 12.0, 1.0);
    private final BooleanValue GN = new BooleanValue("Stuck When Not Flagged", this, false);
    private final BooleanValue GO = new BooleanValue("Only Send Once", this, false);
    private boolean GP;
    private boolean GQ;
    private int GR;
    private int GS;
    private int hV;
    private double x;
    private double y;
    private double z;
    private double ud;
    private double ue;
    private double uf;
    private boolean GT;
    private boolean GU;
    @EventLink
    public final Listener<PreUpdateEvent> GV = var1x -> {
        if (this.GS == 0 && this.hV >= 0) {
            if (aEg.thePlayer.onGround) {
                aEg.thePlayer.jump();
            }

            if (aEg.thePlayer.fallDistance >= 0.3F && !this.GT) {
                this.x = aEg.thePlayer.posX;
                this.y = aEg.thePlayer.posY;
                this.z = aEg.thePlayer.posZ;
                this.ud = aEg.thePlayer.motionX;
                this.ue = aEg.thePlayer.motionY;
                this.uf = aEg.thePlayer.motionZ;
                this.GT = true;
            }

            if (this.hV == 7) {
                aEg.thePlayer.motionX = this.ud;
                aEg.thePlayer.motionY = this.ue;
                aEg.thePlayer.motionZ = this.uf;
                this.hV = -4;
                this.GT = false;
            }

            if (this.hV != -4 && this.GT) {
                aEg.thePlayer.motionX = 0.0;
                aEg.thePlayer.motionY = 0.0;
                aEg.thePlayer.motionZ = 0.0;
                aEg.thePlayer.setPosition(this.x, this.y, this.z);
                this.hV++;
            }
        }

        if (this.GS == 1) {
            if (this.GP) {
                if (this.GE.wo()) {
                    MoveUtil.strafe(this.GF.wo().doubleValue());
                }

                label70: {
                    label69: {
                        String s = this.GD.wo().getName();
                        byte b0 = -1;
                        switch (s.hashCode()) {
                            case -1019425297:
                                if (s.equals("SlowJump")) {
                                    b0 = 0;
                                }
                                break;
                            case 2320462:
                                if (s.equals("Jump")) {
                                    boolean flag = true;
                                    break label69;
                                }
                        }

                        switch (b0) {
                            case 0:
                                aEg.thePlayer.motionY = 0.42;
                                break label70;
                            case 1:
                                break;
                            default:
                                break label70;
                        }
                    }

                    aEg.thePlayer.jump();
                }

                aEg.thePlayer.tR = 0;
                aEg.timer.dzD = 1.0F;
                this.GP = false;
                this.GU = false;
            } else if (this.GQ) {
                if (MoveUtil.isMoving()) {
                    if (aEg.thePlayer.motionY <= 0.05 && !aEg.gameSettings.keyBindJump.isKeyDown() || aEg.thePlayer.tR >= this.GM.wo().intValue()) {
                        this.GQ = false;
                        aEg.timer.dzD = 0.3F;
                    }
                } else if (aEg.thePlayer.motionY < -0.1) {
                    this.GQ = false;
                    aEg.timer.dzD = 0.1F;
                }
            }
        }
    };
    @EventLink
    public final Listener<PreMotionEvent> GW = var1x -> {
        if (this.GS == 1 && !this.GQ) {
            if (this.GN.wo()) {
                aEg.thePlayer.setPosition(aEg.thePlayer.lastTickPosX, aEg.thePlayer.lastTickPosY, aEg.thePlayer.lastTickPosZ);
            }

            aEg.timer.dzD = 1.0F;
            if (!this.GO.wo() || !this.GU) {
                label54: {
                    double d0;
                    double d1;
                    label53: {
                        label52: {
                            label51: {
                                label50: {
                                    aEg.timer.dzD = this.GI.wo().floatValue();
                                    d0 = var1x.getPosX() + this.GG.wo().doubleValue();
                                    d1 = var1x.getPosZ() + this.GG.wo().doubleValue();
                                    String s = this.GC.wo().getName();
                                    byte b0 = -1;
                                    switch (s.hashCode()) {
                                        case -2001194238:
                                            if (s.equals("VoidTP2")) {
                                                byte b1 = 2;
                                                break label52;
                                            }
                                            break;
                                        case -1911998296:
                                            if (s.equals("Packet")) {
                                                b0 = 0;
                                            }
                                            break;
                                        case -1727122640:
                                            if (s.equals("VoidTP")) {
                                                boolean flag = true;
                                                break label53;
                                            }
                                            break;
                                        case 857595018:
                                            if (s.equals("Packet2")) {
                                                byte b2 = 3;
                                                break label51;
                                            }
                                            break;
                                        case 857595019:
                                            if (s.equals("Packet3")) {
                                                byte b3 = 4;
                                                break label50;
                                            }
                                    }

                                    switch (b0) {
                                        case 0:
                                            double d2 = var1x.getPosY();
                                            ahj.m(new C04PacketPlayerPosition(d0, d2, d1, this.GH.wo()));
                                            break label54;
                                        case 1:
                                            break label53;
                                        case 2:
                                            break label52;
                                        case 3:
                                            break label51;
                                        case 4:
                                            break;
                                        default:
                                            break label54;
                                    }
                                }

                                double d4 = var1x.getPosY() + this.GG.wo().doubleValue();
                                ahj.m(new C04PacketPlayerPosition(d0, d4, d1, this.GH.wo()));
                                break label54;
                            }

                            double d3 = var1x.getPosY() - this.GG.wo().doubleValue();
                            ahj.m(new C04PacketPlayerPosition(d0, d3, d1, this.GH.wo()));
                            break label54;
                        }

                        var1x.setPosX(d0);
                        var1x.setPosZ(d1);
                        var1x.setPosY(var1x.getPosY() + this.GG.wo().doubleValue());
                        break label54;
                    }

                    var1x.setPosX(d0);
                    var1x.setPosZ(d1);
                    var1x.setPosY(var1x.getPosY() - this.GG.wo().doubleValue());
                }

                this.GU = true;
            }
        }
    };
    @EventLink
    public final Listener<PacketSendEvent> GX = var1x -> {
        Packet packet = var1x.dq();
        if (this.GT && this.GS != 1 && packet instanceof C03PacketPlayer) {
            var1x.setCancelled();
        }

        if (this.GK.wo() && this.GS == 1) {
            if (packet instanceof C06PacketPlayerPosLook c06packetplayerposlook) {
                var1x.setCancelled();
                ahj.m(
                    new C04PacketPlayerPosition(
                        c06packetplayerposlook.afD(), c06packetplayerposlook.afE(), c06packetplayerposlook.afF(), c06packetplayerposlook.isOnGround()
                    )
                );
            }

            if (packet instanceof C05PacketPlayerLook) {
                var1x.setCancelled();
            }
        }
    };
    @EventLink
    public final Listener<PacketReceiveEvent> GY = var1x -> {
        Packet packet = var1x.dq();
        if (packet instanceof S08PacketPlayerPosLook) {
            if (this.GS == 1) {
                this.GR++;
                if (this.GR >= this.GJ.wo().intValue() && !this.GP && !this.GQ) {
                    this.GP = true;
                    this.GQ = true;
                    this.GR = 0;
                }
            } else {
                this.GS = 1;
            }
        }

        if (packet instanceof S12PacketEntityVelocity && ((S12PacketEntityVelocity)packet).getEntityID() == aEg.thePlayer.getEntityId()) {
            var1x.setCancelled();
        }
    };

    public ne(String var1, Flight var2) {
        super(var1, var2);
    }

    @Override
    public void onEnable() {
        this.GP = false;
        this.GQ = false;
        this.GR = 0;
        this.GS = this.GL.wo() && MoveUtil.isMoving() ? 0 : 1;
        this.hV = 0;
        this.GT = false;
        this.GU = false;
    }

    @Override
    public void onDisable() {
        aEg.timer.dzD = 1.0F;
    }
}
