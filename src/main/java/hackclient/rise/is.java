package hackclient.rise;

import com.alan.clients.module.impl.combat.Velocity;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.MoveInputEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.NumberValue;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import de.florianmichael.vialoadingbase.ViaLoadingBase;
import net.minecraft.network.play.server.S12PacketEntityVelocity;

public final class is extends Mode<Velocity> {
    public final NumberValue uC = new NumberValue("Chance", this, 100, 0, 100, 1);
    public final BooleanValue uD = new BooleanValue("Legit Timing", this, false);
    private boolean gD;
    @EventLink
    public final Listener<PreMotionEvent> uE = var1x -> this.gD = false;
    @EventLink
    public final Listener<MoveInputEvent> uF = var1x -> {
        if (!this.wj().qQ.wo() || aEg.thePlayer.isSwingInProgress) {
            if (this.gD && Math.random() * 100.0 < this.uC.wo().doubleValue()) {
                var1x.setJump(true);
                ViaLoadingBase.getInstance().getTargetVersion().newerThanOrEqualTo(ProtocolVersion.v1_21_2);
            }
        }
    };
    @EventLink
    public final Listener<PacketReceiveEvent> uG = var1x -> {
        if ((!this.wj().qQ.wo() || aEg.thePlayer.isSwingInProgress) && !var1x.isCancelled()) {
            if (aEg.thePlayer.onGround) {
                if (var1x.dq() instanceof S12PacketEntityVelocity s12packetentityvelocity
                    && s12packetentityvelocity.getEntityID() == aEg.thePlayer.getEntityId()
                    && s12packetentityvelocity.motionY > 0
                    && (!this.uD.wo() || aEg.thePlayer.ae <= 14 || aEg.thePlayer.cqL <= 1)) {
                    this.gD = true;
                }
            }
        }
    };

    public is(String var1, Velocity var2) {
        super(var1, var2);
    }
}
