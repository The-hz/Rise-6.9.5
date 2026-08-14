package com.alan.clients.module.impl.movement.teleport;

import com.alan.clients.module.impl.movement.Teleport;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.value.Mode;
import hackclient.rise.afi;
import net.minecraft.util.Vec3;

public final class WatchdogBedWarsTeleport extends Mode<Teleport> {
    public Vec3 Jd = new Vec3(0.0, 0.0, 0.0);
    @EventLink
    public final Listener<PreMotionEvent> Sw = var1x -> {
        var1x.setPosY(this.Jd.yCoord);
        var1x.setPosX(this.Jd.xCoord);
        var1x.setPosZ(this.Jd.zCoord);
    };

    public WatchdogBedWarsTeleport(String var1, Teleport var2) {
        super(var1, var2);
    }

    @Override
    public void onEnable() {
        this.Jd = new Vec3(aEg.thePlayer.posX, aEg.thePlayer.posY, aEg.thePlayer.posZ);
        afi.b("Die -> Fly to where you want to teleport -> Toggle");
    }
}
