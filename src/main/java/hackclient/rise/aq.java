package hackclient.rise;

import com.alan.clients.component.Component;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S30PacketWindowItems;
import net.minecraft.network.play.server.c;
import rip.vantage.commons.util.time.a;

public class aq extends Component {
    private boolean bI;
    private boolean bJ;
    private boolean bK;
    private int bL;
    private float bM;
    public final a bN = new a();
    @EventLink
    public final Listener<PreMotionEvent> bO = var1 -> {
        if (aEg.thePlayer.ticksExisted % 100 == 0
            || this.bK
            || aEg.gameSettings.keyBindPlayerList.isKeyDown() != this.bI
            || aEg.gameSettings.bJf != this.bJ
            || aEg.thePlayer.ticksExisted <= 10
            || this.bL > 0) {
            add.aBL = true;
            this.bI = aEg.gameSettings.keyBindPlayerList.isKeyDown();
            this.bJ = aEg.gameSettings.bJf;
            this.bK = false;
        }

        if (this.bM != aEg.thePlayer.getHealth()) {
            this.bL = 3;
            this.bM = aEg.thePlayer.getHealth();
        }

        this.bL--;
    };
    @EventLink
    public final Listener<Render2DEvent> bP = var1 -> {
        if (aEg.currentScreen != null) {
            this.bK = true;
            add.aBL = true;
        }
    };
    @EventLink
    public final Listener<PacketReceiveEvent> bQ = var1 -> {
        Packet packet = var1.dq();
        if (packet instanceof c || packet instanceof S30PacketWindowItems || packet instanceof net.minecraft.network.play.server.az) {
            this.bN.aX();
            this.bK = true;
        }

        if (packet instanceof net.minecraft.network.play.server.o) {
            this.bL = 5;
        }
    };

    public aq() {
    }
}
