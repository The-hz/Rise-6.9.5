package hackclient.rise;

import com.alan.clients.module.impl.exploit.Disabler;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.value.Mode;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.network.play.client.C13PacketPlayerAbilities;

public class jr extends Mode<Disabler> {
    @EventLink
    public final Listener<StrafeEvent> onStrafe = var1x -> {
        if (this.getParent().deprecated.wo()) {
            if (aEg.thePlayer.ticksExisted % 5 == 0) {
                PlayerCapabilities playercapabilities = new PlayerCapabilities();
                playercapabilities.isFlying = true;
                ahj.l(new C13PacketPlayerAbilities(playercapabilities));
            }
        }
    };

    public jr(String var1, Disabler var2) {
        super(var1, var2);
    }
}
