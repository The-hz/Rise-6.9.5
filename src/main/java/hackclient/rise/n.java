package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.anticheat.data.PlayerData;
import java.util.UUID;
import net.minecraft.client.entity.EntityOtherPlayerMP;

public final class n {
    public n() {
    }

    public void b(EntityOtherPlayerMP other) {
        Client.a.n().getPlayerMap().put(other.getUniqueID(), new PlayerData(other));
    }

    public void handleDestroy(UUID uuid) {
        Client.a.n().getPlayerMap().remove(uuid);
    }
}
