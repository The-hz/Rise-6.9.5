package hackclient.rise;

import com.alan.clients.security.a;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S27PacketExplosion;

public final class aav extends a {
    public aav() {
        super("Explosion Checker", "Server attempted to crash the client with a large explosion");
    }

    @Override
    public boolean j(Packet<?> var1) {
        return !(var1 instanceof S27PacketExplosion s27packetexplosion)
            ? false
            : s27packetexplosion.func_149149_c() >= 127.0F || s27packetexplosion.func_149144_d() >= 127.0F || s27packetexplosion.func_149147_e() >= 127.0F;
    }
}
