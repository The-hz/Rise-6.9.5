package hackclient.rise;

import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.other.WorldChangeEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.security.SecurityFeature;
import net.minecraft.network.play.server.c;

public class zl extends SecurityFeature {
    public static Object[] o0Oo000O0oO = new Object[11];
    public static int[] O0OoOO0OOOOO;
    public static Object[] oO00O0OO0ooO = new Object[1];
    public volatile int avJ;
    public volatile Object avF;
    @EventLink
    public Listener<WorldChangeEvent> avM;
    public volatile boolean avA;
    public volatile Object avI;
    public static String avB;
    public static String avC;
    public static int avE;
    @EventLink
    public Listener<PacketReceiveEvent> avL;
    public volatile boolean avH;
    public static int avD;
    public static Object[] fld_0oOOoOo0O00O_58 = new Object[4];
    public volatile int avK = Integer.MIN_VALUE;
    public volatile Object avG;

    public static void Oo0o00000O00() {
    }

    public zl() {
        this.avL = var1 -> {
            if (var1.dq() instanceof c && aEg != null && aEg.theWorld != null) {
                c c = (c)var1.dq();
                String s = c.getChatComponent() != null ? c.getChatComponent().getUnformattedText() : "";
                if (s != null && (s.contains("You were spawned in L" + "imbo.") || s.contains("You are AFK, Move around to r" + "eturn from AFK."))) {
                    this.avG = aEg.theWorld;
                    this.avH = true;
                    this.nR();
                }
            }
        };
        this.avM = var1 -> {
            if (this.avH) {
                this.avG = aEg != null ? aEg.theWorld : null;
                this.avH = false;
                this.nR();
            } else {
                this.avG = null;
                this.avH = false;
                this.nR();
            }
        };
    }

    @Override
    public String getReason() {
        return "hypixelipn" + (String)o0Oo000O0oO[5] + "d";
    }

    @Override
    public boolean nG() {
        long j = 1468521042548453867L;
        if (aEg == null || aEg.thePlayer == null || aEg.theWorld == null || aEg.isIntegratedServerRunning()) {
            this.avG = null;
            this.avH = false;
            this.nR();
            return false;
        }

        if (this.avG == aEg.theWorld) {
            return false;
        }

        if (this.avA && this.avF == aEg.theWorld) {
            return true;
        }

        if (aEg.thePlayer.ticksExisted < 150) {
            return false;
        }

        if (!ahm.vr()) {
            return false;
        }

        if (this.avI != aEg.theWorld) {
            this.avI = aEg.theWorld;
            this.avJ = 0;
            this.avK = Integer.MIN_VALUE;
        }

        if (ahm.vm()) {
            this.avJ = 0;
            this.avK = Integer.MIN_VALUE;
            return false;
        }

        long k = j ^ ((long)aEg.thePlayer.ticksExisted << 32 ^ j) & -1L << 32;
        if (this.avK == Integer.MIN_VALUE || (int)(k >>> 32) - this.avK >= 100) {
            this.avJ++;
            this.avK = (int)(k >>> 32);
        }

        if (this.avJ >= 5) {
            this.avA = true;
            this.avF = aEg.theWorld;
        }

        return this.avA;
    }

    public void nR() {
        this.avA = false;
        this.avF = null;
        this.avI = null;
        this.avJ = 0;
        this.avK = Integer.MIN_VALUE;
    }

    static {
        Oo0o00000O00();
        fld_0oOOoOo0O00O_58[0] = "VArZN560O3tUbglsptkM6HpD/Yo99HnFM7fno0Smgl+crghL2/zeq3VmLl/v5Z/9LRZBMVY1Co+lBnCseQO+UMX3ztpZj1ITNLDIVb/WnROw6eAQ/A8obNYZRbLIJufn1V0mcwxcB4qVNN9m/JXiczA4JvHqG9hGDPGlHRyHqliISmHYwaMEOw3e6l9n1ekeOvkQ9gk83+YiVV5s7nnbe8rIgLHwmr/Md47U4fnSh9Q/+r1e5J9VT18FSGzaUzdtZGCzQZtQ3MkBEmoAUPtHOw==";
        fld_0oOOoOo0O00O_58[1] = "PBKDF2WithHmacSHA1";
        fld_0oOOoOo0O00O_58[2] = "AES";
        fld_0oOOoOo0O00O_58[3] = "AES/CBC/PKCS5Padding";
        oO00O0OO0ooO[0] = "\u0000\u0001d\u0000$You are AFK, Move around to return f\u0000\u0015You were spawned in L\u0000\u000feturn from AFK.\u0000\u0007 Limbo.\u0000\noscoreboar\u0000\u001dYou are AFK, Move around to r\u0000\nhypixelipn\u0000\u0013You were spawned in\u0000\u0005imbo.\u0000\brom AFK.";
        o0Oo000O0oO[0] = "d";
        o0Oo000O0oO[1] = "You are AFK, Move around to return f";
        o0Oo000O0oO[2] = "You were spawned in L";
        o0Oo000O0oO[3] = "eturn from AFK.";
        o0Oo000O0oO[4] = " Limbo.";
        o0Oo000O0oO[5] = "oscoreboar";
        o0Oo000O0oO[6] = "You are AFK, Move around to r";
        o0Oo000O0oO[7] = "hypixelipn";
        o0Oo000O0oO[8] = "You were spawned in";
        o0Oo000O0oO[9] = "imbo.";
        o0Oo000O0oO[10] = "rom AFK.";
    }
}
