package hackclient.rise;

import com.alan.clients.security.a;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S2APacketParticles;

public final class aax extends a {
    private int axg;

    public aax() {
        super("ParticleCheck", "Server attempted to crash the client with a large amount of particles");
    }

    @Override
    public boolean j(Packet<?> var1) {
        if (!(var1 instanceof S2APacketParticles s2apacketparticles)) {
            return false;
        }
        this.axg = this.axg + s2apacketparticles.getParticleCount();
        this.axg -= 6;
        this.axg = Math.min(this.axg, 150);
        return this.axg > 100
            || s2apacketparticles.getParticleCount() < 1
            || Math.abs(s2apacketparticles.getParticleCount()) > 20
            || s2apacketparticles.getParticleSpeed() < 0.0F
            || s2apacketparticles.getParticleSpeed() > 1000.0F;
    }
}
