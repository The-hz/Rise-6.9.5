package hackclient.rise;

import com.alan.clients.module.impl.movement.Flight;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.MoveInputEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.NumberValue;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;

public class mx extends Mode<Flight> {
    public static Object[] oO00O0OO0ooO = new Object[1];
    @EventLink
    public Listener<PacketSendEvent> FJ;
    public NumberValue FE;
    public static int[] O0OoOO0OOOOO;
    public BooleanValue FF;
    @EventLink
    public Listener<MoveInputEvent> FI;
    public static Object[] o0Oo000O0oO = new Object[2];
    public static Object[] fld_0oOOoOo0O00O_33 = new Object[4];
    @EventLink
    public Listener<StrafeEvent> FG;
    @EventLink
    public Listener<PreMotionEvent> FH;

    public mx(String var1, Flight var2) {
        super(var1, var2);
        this.FE = new NumberValue((String)o0Oo000O0oO[1], this, 1, 0.1, 9.5, 0.1);
        this.FF = new BooleanValue("Send Flying", this, false);
        this.FG = var1x -> {
            float f = 0.0F;
            float f1 = this.FE.wo().floatValue();
            var1x.setSpeed(f1);
        };
        this.FH = var1x -> {
            float f = 0.0F;
            float f1 = this.FE.wo().floatValue();
            aEg.thePlayer.motionY = -1.0E-10 + (aEg.gameSettings.keyBindJump.isKeyDown() ? f1 : 0.0) - (aEg.gameSettings.keyBindSneak.isKeyDown() ? f1 : 0.0);
            if (aEg.thePlayer.getDistance(aEg.thePlayer.lastReportedPosX, aEg.thePlayer.lastReportedPosY, aEg.thePlayer.lastReportedPosZ) <= 10.0F - f1 - 0.15) {
                var1x.setCancelled();
            }
        };
        this.FI = var0 -> var0.setSneak(false);
        this.FJ = var1x -> {
            if (!this.FF.wo()) {
                Packet packet = var1x.dq();
                if (packet instanceof C03PacketPlayer && !((C03PacketPlayer)packet).isMoving() && !bb.aW()) {
                    var1x.setCancelled();
                }
            }
        };
    }

    public static void Oo0o00000O00() {
    }

    @Override
    public void onDisable() {
        MoveUtil.stop();
    }

    static {
        Oo0o00000O00();
        oO00O0OO0ooO[0] = "\u0000\u000bSend Flying\u0000\u0005Speed";
        o0Oo000O0oO[0] = "Send Flying";
        o0Oo000O0oO[1] = "Speed";
        fld_0oOOoOo0O00O_33[0] = "tUFi/ULMyoMH3ZDhlGSj7ymnoTy18WlkquVgtPoNPMsvihkfEWjrdYC7A7eIzC71";
        fld_0oOOoOo0O00O_33[1] = "PBKDF2WithHmacSHA1";
        fld_0oOOoOo0O00O_33[2] = "AES";
        fld_0oOOoOo0O00O_33[3] = "AES/CBC/PKCS5Padding";
    }
}
