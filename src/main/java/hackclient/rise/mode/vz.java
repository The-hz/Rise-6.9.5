package hackclient.rise.mode;

import com.alan.clients.module.impl.player.Scaffold;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import de.florianmichael.vialoadingbase.ViaLoadingBase;

public class vz extends Mode<Scaffold> {
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var0 -> {
        if (aEg.gameSettings.keyBindJump.isKeyDown()) {
            if (aEg.thePlayer.onGround && !MoveUtil.enoughMovementForSprinting()) {
                aEg.thePlayer.jump();
            }

            if (ViaLoadingBase.getInstance().getTargetVersion().olderThan(ProtocolVersion.v1_18)) {
                if (aEg.thePlayer.tR == 4 && MoveUtil.speed() == 0.0) {
                    aEg.thePlayer.motionY -= 0.03;
                }

                if (aEg.thePlayer.tR == 5 && MoveUtil.speed() == 0.0) {
                    aEg.thePlayer.motionY -= 0.5;
                }
            }
        }
    };

    public vz(String var1, Scaffold var2) {
        super(var1, var2);
    }
}
