package hackclient.rise;

import com.alan.clients.component.Component;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PostStrafeEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.util.player.MoveUtil;
import lombok.Generated;

public final class bk extends Component {
    private static boolean dj;
    private static float dD;
    private static int dE;
    @EventLink
    public final Listener<PreMotionEvent> dF = var0 -> {
        if (dj) {
            if (dE < 4) {
                aEg.timer.dzD = dD;
                if (aEg.thePlayer.onGround) {
                    aEg.thePlayer.jump();
                    dE++;
                }

                var0.setOnGround(false);
            } else if (aEg.thePlayer.tR >= 11) {
                aEg.timer.dzD = 1.0F;
                dj = false;
                dD = 1.0F;
                dE = 0;
            }
        }
    };
    @EventLink
    public final Listener<PostStrafeEvent> dG = var0 -> {
        if (dj) {
            MoveUtil.stop();
        }
    };

    public bk() {
    }

    public static void a(float var0) {
        dj = true;
        dD = var0;
        dE = 0;
    }

    @Generated
    public static boolean bd() {
        return dj;
    }

    @Generated
    public static int be() {
        return dE;
    }
}
