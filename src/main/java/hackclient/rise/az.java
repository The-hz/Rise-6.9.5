package hackclient.rise;

import com.alan.clients.component.Component;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;

public class az extends Component {
    private boolean cF;
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var1 -> {
        if (aEg.currentScreen == null && this.cF) {
            for (KeyBinding keybinding : aEg.gameSettings.keyBindings) {
                keybinding.setPressed(GameSettings.isKeyDown(keybinding));
            }
        }

        this.cF = aEg.currentScreen != null;
    };

    public az() {
    }
}
