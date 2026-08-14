package hackclient.rise;

import com.alan.clients.component.Component;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.other.ServerJoinEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import hackclient.rise.ahm;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.c;

public class ax
extends Component {
    @EventLink
    public Listener<PreMotionEvent> ct;
    public static Object[] oO00O0OO0ooO;
    public static Object[] o0Oo000O0oO;
    public static String cs;
    @EventLink
    public Listener<ServerJoinEvent> cv;
    public static int[] O0OoOO0OOOOO;
    public Pattern cq = Pattern.compile("Your new API key" + " is (.*)");
    @EventLink
    public Listener<PacketReceiveEvent> cu;
    public static boolean cr;
    public static Object[] fld_0oOOoOo0O00O_9;

    static {
        ax.Oo0o00000O00();
        fld_0oOOoOo0O00O_9 = new Object[4];
        ax.fld_0oOOoOo0O00O_9[0] = "65/zf6/R+G3Cmt2nYa41jxLAPFL4ansuZZik8hzEYw5O7BexLpLJpkXvuOL4o9Wi";
        ax.fld_0oOOoOo0O00O_9[1] = "PBKDF2WithHmacSHA1";
        ax.fld_0oOOoOo0O00O_9[2] = "AES";
        ax.fld_0oOOoOo0O00O_9[3] = "AES/CBC/PKCS5Padding";
        oO00O0OO0ooO = new Object[1];
        ax.oO00O0OO0ooO[0] = "\u0000\u0010Your new API key\u0000\b is (.*)";
        o0Oo000O0oO = new Object[2];
        ax.o0Oo000O0oO[0] = "Your new API key";
        ax.o0Oo000O0oO[1] = " is (.*)";
    }

    public ax() {
        this.ct = preMotionEvent -> {
            if (!cr && ax.aEg.thePlayer.ticksExisted == 2) {
                ahm.vn();
            }
        };
        this.cu = packetReceiveEvent -> {
            Packet<?> packet = packetReceiveEvent.dq();
            if (packet instanceof c) {
                if (!ahm.vn()) {
                    return;
                }
                c c2 = (c)packet;
                String string = c2.getChatComponent().getUnformattedText();
                Matcher matcher = this.cq.matcher(string);
                if (!c2.isChat() && matcher.find()) {
                    matcher.group(1);
                    if (!cr) {
                        packetReceiveEvent.setCancelled();
                    }
                    cr = true;
                }
            }
        };
        this.cv = serverJoinEvent -> {
            cr = false;
        };
    }

    public static void Oo0o00000O00() {
    }
}
