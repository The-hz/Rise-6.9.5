package com.alan.clients.util.value;

import com.alan.clients.Client;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import hackclient.rise.event.er;

public class ConstantManager
{
    @EventLink
    public Listener<er> aHd;
    public static double aHb;
    public static float aHc;


    public ConstantManager() {
        this.aHd = (Listener<er>)(var1 -> {
            if (var1.dd() instanceof rip.vantage.commons.packet.impl.server.protection.S2CPacketAuthentication) {
                final rip.vantage.commons.packet.impl.server.protection.S2CPacketAuthentication b = (rip.vantage.commons.packet.impl.server.protection.S2CPacketAuthentication)var1.dd();
                if (!rip.vantage.security.IntegrityGuard.a(b, b.aKi())) {
                    System.out.println("EC91");

                    try {
                        System.exit(1);
                    }
                    catch (Throwable t) {}

                    try {
                        Runtime.getRuntime().halt(1);
                    }
                    catch (Throwable e) {}

                    throw new SecurityException("EC91");
                }
                ConstantManager.aHb = b.aKk();
                ConstantManager.aHc = b.aKl();
            }
        });
        Client.a.e().b((Object)this);
    }

    static {
        ConstantManager.aHb = 6.283185307179586;
        ConstantManager.aHc = 180.0f;
    }

}
