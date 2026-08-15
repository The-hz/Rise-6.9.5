package hackclient.rise;

import com.alan.clients.anticheat.alert.AlertManager;
import com.alan.clients.anticheat.data.PlayerData;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Generated;
import net.minecraft.client.Minecraft;

public final class b {
    public final Map<UUID, PlayerData> M = new ConcurrentHashMap<>();
    private final n N = new n();
    private final AlertManager O = new AlertManager();

    public b() {
        l.setup();
    }

    public void F() {
        for (PlayerData playerdata : this.M.values()) {
            if (Minecraft.getMinecraft().theWorld.playerEntities.contains(playerdata.getPlayer())) {
                playerdata.incrementTick();
            } else {
                this.N.a(playerdata.getPlayer().getUniqueID());
            }
        }
    }

    @Generated
    public Map<UUID, PlayerData> G() {
        return this.M;
    }

    @Generated
    public n H() {
        return this.N;
    }

    @Generated
    public AlertManager I() {
        return this.O;
    }
}
