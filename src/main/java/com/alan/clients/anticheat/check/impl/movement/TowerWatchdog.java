package com.alan.clients.anticheat.check.impl.movement;

import com.alan.clients.anticheat.check.Check;
import com.alan.clients.anticheat.check.api.CheckInfo;
import com.alan.clients.anticheat.data.PlayerData;
import hackclient.rise.o;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S14PacketEntity;
import net.minecraft.network.play.server.z;

@CheckInfo(R = "Tower", S = "Watchdog", description = "Impossible Motion")
public final class TowerWatchdog extends Check {
    public TowerWatchdog(PlayerData var1) {
        super(var1);
    }

    @Override
    public void handle(Packet<?> var1) {
        if (o.b(var1) && ((S14PacketEntity)var1).entityId == this.data.getPlayer().getEntityId() || var1 instanceof z && ((z)var1).cqK == this.data.getPlayer().getEntityId()) {
            if (this.data.getPlayer().isInvisible()) {
                return;
            }

            if (this.data.ae() <= 10 + this.data.aH()) {
                return;
            }

            if (this.data.aj() == 0.65625 && this.data.am() == 0.75) {
                this.J();
            }
        }
    }
}
