package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import hackclient.rise.event.er;

public class abs
{
    @EventLink
    public Listener<er> aHd;
    public static double aHb;
    public static float aHc;


    public abs() {
        this.aHd = (Listener<er>)(var1 -> {
            if (var1.dd() instanceof rip.vantage.commons.packet.impl.server.protection.b) {
                final rip.vantage.commons.packet.impl.server.protection.b b = (rip.vantage.commons.packet.impl.server.protection.b)var1.dd();
                if (!rip.vantage.security.l.a(b, b.aKi())) {
                    System.out.println("EC91");

                    try {
                        System.exit(1);
                    }
                    catch (Throwable t) {}

                    try {
                        Runtime.getRuntime().halt(1);
                    }
                    catch (Throwable t2) {}

                    throw new SecurityException("EC91");
                }
                abs.aHb = b.aKk();
                abs.aHc = b.aKl();
            }
        });
        Client.a.e().b((Object)this);
    }

    static {
        abs.aHb = 6.283185307179586;
        abs.aHc = 180.0f;
    }

}
