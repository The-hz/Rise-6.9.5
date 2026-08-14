package hackclient.rise;

import com.alan.clients.util.interfaces.InstanceAccess;
import lombok.Generated;

public final class ajr implements InstanceAccess {
    private static int aQt;

    public static void L(boolean var0) {
        if (aEg.thePlayer != null && aEg.thePlayer.ticksExisted != aQt) {
            if (var0) {
                cm("rise.toggle.enable");
            } else {
                cm("rise.toggle.disable");
            }

            aQt = aEg.thePlayer.ticksExisted;
        }
    }

    public static void cm(String var0) {
        a(var0, 1.0F, 1.0F);
    }

    public static void a(String var0, float var1, float var2) {
        aEg.theWorld.playSound(aEg.thePlayer.posX, aEg.thePlayer.posY, aEg.thePlayer.posZ, var0, var1, var2, false);
    }

    @Generated
    private ajr() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
