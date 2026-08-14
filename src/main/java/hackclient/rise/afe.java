package hackclient.rise;

import rip.vantage.commons.packet.impl.client.community.d;
import rip.vantage.network.core.a;

public final class afe {
    private afe() {
    }

    public static void A(String var0, String var1) {
        try {
            a aInstance = a.aKB();
            if (aInstance.aKK() == null || aInstance.bX() == null || aInstance.bX().trim().isEmpty()) {
                return;
            }

            aInstance.aKK().sendMessage(new d(aInstance.bX(), var0, var1).aJk());
        } catch (Exception exception) {
        }
    }
}
