package hackclient.rise;

import com.alan.clients.security.a;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S2BPacketChangeGameState;

public final class aau extends a {
    public aau() {
        super("Demo Check", "Server attempted to prevent gameplay with a demo screen");
    }

    @Override
    public boolean handle(Packet<?> var1) {
        return !(var1 instanceof S2BPacketChangeGameState s2bpacketchangegamestate)
            ? false
            : s2bpacketchangegamestate.getGameState() == 5 && s2bpacketchangegamestate.func_149137_d() == 0.0F;
    }
}
