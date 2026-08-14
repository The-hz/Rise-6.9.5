package hackclient.rise;

import com.alan.clients.security.a;
import java.util.regex.Pattern;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S29PacketSoundEffect;
import net.minecraft.network.play.server.c;
import net.minecraft.util.IChatComponent;

public final class aaw extends a {
    private static final Pattern axf = Pattern.compile(".*\\$\\{[^}]*}.*");

    public aaw() {
        super("Log4J RCE Check", "Someone attempted to utilize the Log4J exploit");
    }

    @Override
    public boolean j(Packet<?> var1) {
        if (var1 instanceof S29PacketSoundEffect) {
            String s = ((S29PacketSoundEffect)var1).getSoundName();
            return axf.matcher(s).matches();
        }

        if (!(var1 instanceof c)) {
            return false;
        }

        IChatComponent ichatcomponent = ((c)var1).getChatComponent();
        return axf.matcher(ichatcomponent.getUnformattedText()).matches() || axf.matcher(ichatcomponent.getFormattedText()).matches();
    }
}
