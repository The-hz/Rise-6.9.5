package com.alan.clients.module.impl.movement.flight;

import com.alan.clients.module.impl.movement.Flight;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PostStrafeEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.other.TeleportEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.NumberValue;
import hackclient.rise.ahj;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.server.S12PacketEntityVelocity;

public class Grim191181Flight extends Mode<Flight> {
    public static Object[] o0Oo000O0oO = new Object[4];
    public BooleanValue Gb = new BooleanValue("Glide less/Fly m" + "ore", this, true);
    public static int[] O0OoOO0OOOOO;
    public static Object[] oO00O0OO0ooO = new Object[1];
    @EventLink
    public Listener<PostStrafeEvent> Ge;
    public NumberValue Gd;
    public static Object[] fld_0oOOoOo0O00O_30 = new Object[4];
    @EventLink
    public Listener<PreMotionEvent> Gf;
    @EventLink
    public Listener<TeleportEvent> Gh;
    @EventLink
    public Listener<PacketReceiveEvent> Gg;
    public boolean Ga;
    public NumberValue Gc = new NumberValue("Speed", this, 0.275, 0, 0.32, 0.001);
    public boolean Eo;

    public Grim191181Flight(String var1, Flight var2) {
        super(var1, var2);
        this.Gd = new NumberValue("Timer", this, 1, 0.1, 10, 0.1);
        this.Ge = var1x -> {
            aEg.timer.dzD = this.Gd.wo().floatValue();
            if (!this.Eo && aEg.thePlayer.fallDistance > 0.0F) {
                ahj.l(new C03PacketPlayer(true));
                aEg.thePlayer.fallDistance = 0.0F;
                this.Eo = true;
            }

            if (this.Eo) {
                aEg.thePlayer.motionX = 0.0;
                aEg.thePlayer.motionZ = 0.0;
                aEg.thePlayer.motionY = 0.0;
            }

            if (this.Ga) {
                MoveUtil.preventDiagonalSpeed();
                MoveUtil.moveFlying(this.Gc.wo().doubleValue());
                if (this.Gb.wo()) {
                    aEg.thePlayer.motionY = -1.1E-4;
                } else {
                    aEg.thePlayer.motionY = -2.0E-4;
                }

                MoveUtil.preventDiagonalSpeed();
                this.Ga = false;
            }

            MoveUtil.preventDiagonalSpeed();
        };
        this.Gf = var1x -> {
            if (this.Eo) {
                var1x.setCancelled();
            }
        };
        this.Gg = var1x -> {
            Packet packet = var1x.dq();
            if (packet instanceof S12PacketEntityVelocity && ((S12PacketEntityVelocity)packet).getEntityID() == aEg.thePlayer.getEntityId()) {
                this.Eo = false;
                var1x.setCancelled();
                this.Ga = true;
            }
        };
        this.Gh = var0 -> {};
    }

    @Override
    public void onEnable() {
        this.Eo = false;
    }

    public static void Oo0o00000O00() {
    }

    static {
        Oo0o00000O00();
        fld_0oOOoOo0O00O_30[0] = "FbeXFN4jWp6c1MdrMedOBVWj0Dr309ZgWT/B/LLs6/kxh9FAeGrn8mVKBAmyVyvEOqzFMzzmJqUkPyoJpVAdjw==";
        fld_0oOOoOo0O00O_30[1] = "PBKDF2WithHmacSHA1";
        fld_0oOOoOo0O00O_30[2] = "AES";
        fld_0oOOoOo0O00O_30[3] = "AES/CBC/PKCS5Padding";
        oO00O0OO0ooO[0] = "\u0000\u0005Speed\u0000\u0003ore\u0000\u0005Timer\u0000\u0010Glide less/Fly m";
        o0Oo000O0oO[0] = "Speed";
        o0Oo000O0oO[1] = "ore";
        o0Oo000O0oO[2] = "Timer";
        o0Oo000O0oO[3] = "Glide less/Fly m";
    }

    @Override
    public void onDisable() {
    }
}
