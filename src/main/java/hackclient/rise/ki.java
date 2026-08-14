package hackclient.rise;

import com.alan.clients.module.impl.exploit.Disabler;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.value.Mode;

public class ki extends Mode<Disabler> {
    @EventLink
    public final Listener<PreMotionEvent> yL = var1x -> {
        if (this.wj().wJ.wo()) {
            var1x.setSprinting(false);
        }
    };

    public ki(String var1, Disabler var2) {
        super(var1, var2);
    }
}
