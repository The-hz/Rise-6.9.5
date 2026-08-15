package hackclient.rise;

import com.alan.clients.component.Component;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import rip.vantage.commons.util.time.a;

public class cl extends Component {
    public static double y;
    public static a bN = new a();
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var0 -> {
        if (!bN.T(80L)) {
            aEg.thePlayer.cameraYaw = 0.0F;
            aEg.thePlayer.cameraPitch = 0.0F;
        }
    };

    public cl() {
    }

    public static void setY(double var0) {
        bN.aX();
        y = var0;
    }

    public static void cn() {
        if (bN.T(80L)) {
            y = aEg.thePlayer.lastTickPosY;
        }

        bN.aX();
    }
}
