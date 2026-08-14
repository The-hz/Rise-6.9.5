package hackclient.rise;

import com.alan.clients.module.impl.movement.Flight;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.NumberValue;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S12PacketEntityVelocity;

public class ng extends Mode<Flight> {
    private final NumberValue Hl = new NumberValue("Duration", this, 3000.0, 1000.0, 10000.0, 100.0);
    private final NumberValue Hm = new NumberValue("Timer", this, 1.0, 0.1, 2.0, 0.1);
    private long Hn;
    private boolean dj;
    private int Ho;
    @EventLink
    public final Listener<PacketReceiveEvent> Hp = var1x -> {
        Packet packet = var1x.dq();
        if (packet instanceof S12PacketEntityVelocity && ((S12PacketEntityVelocity)packet).getEntityID() == aEg.thePlayer.getEntityId()) {
            this.Hn = System.currentTimeMillis();
            this.dj = true;
        }
    };
    @EventLink
    public final Listener<PreUpdateEvent> Hq = var1x -> {
        if (this.dj) {
            if (System.currentTimeMillis() - this.Hn >= this.Hl.wo().longValue()) {
                if (this.Ho == 1) {
                    this.wj().toggle();
                }
            } else {
                aEg.timer.dzD = this.Hm.wo().floatValue();
                this.Ho = 1;
                if (aEg.thePlayer.onGround && aEg.thePlayer.isCollidedVertically) {
                    aEg.thePlayer.motionY = 0.42;
                } else {
                    MoveUtil.strafe(0.002);
                    aEg.timer.dzD = 4.0F;
                    aEg.thePlayer.motionY = Math.max(-1.0E-8, aEg.thePlayer.motionY);
                }

                if (aEg.thePlayer.isCollidedHorizontally) {
                    aEg.timer.dzD = 1.0F;
                    this.wj().toggle();
                }
            }
        }
    };
    @EventLink
    public final Listener<PreMotionEvent> Hr = var1x -> {
        if (this.dj) {
            if (System.currentTimeMillis() - this.Hn < this.Hl.wo().longValue()) {
                var1x.setOnGround(false);
            }
        }
    };

    public ng(String var1, Flight var2) {
        super(var1, var2);
    }

    @Override
    public void onEnable() {
        this.Hn = 0L;
        this.dj = false;
        this.Ho = 0;
    }

    @Override
    public void onDisable() {
        aEg.timer.dzD = 1.0F;
        MoveUtil.stop();
        this.dj = false;
        this.Ho = 0;
    }
}
