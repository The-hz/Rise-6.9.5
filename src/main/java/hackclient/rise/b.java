package hackclient.rise;

import com.alan.clients.anticheat.alert.AlertManager;
import com.alan.clients.anticheat.check.manager.CheckManager;
import com.alan.clients.anticheat.data.PlayerData;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Generated;
import net.minecraft.client.Minecraft;

public final class b {
    public final Map<UUID, PlayerData> playerMap = new ConcurrentHashMap<>();
    private final n registrationListener = new n();
    private final AlertManager alertManager = new AlertManager();

    public b() {
        CheckManager.setup();
    }

    public void incrementTick() {
        for (PlayerData playerdata : this.playerMap.values()) {
            if (Minecraft.getMinecraft().theWorld.playerEntities.contains(playerdata.getPlayer())) {
                playerdata.incrementTick();
            } else {
                this.registrationListener.handleDestroy(playerdata.getPlayer().getUniqueID());
            }
        }
    }

    @Generated
    public Map<UUID, PlayerData> getPlayerMap() {
        return this.playerMap;
    }

    @Generated
    public n H() {
        return this.registrationListener;
    }

    @Generated
    public AlertManager getAlertManager() {
        return this.alertManager;
    }
}
