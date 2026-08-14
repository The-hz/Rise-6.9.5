package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.anticheat.data.PlayerData;
import java.util.UUID;
import net.minecraft.client.entity.EntityOtherPlayerMP;

public final class n {
    public n() {
    }

    public void b(EntityOtherPlayerMP var1) {
        Client.a.n().G().put(var1.getUniqueID(), new PlayerData(var1));
    }

    public void a(UUID var1) {
        Client.a.n().G().remove(var1);
    }
}
