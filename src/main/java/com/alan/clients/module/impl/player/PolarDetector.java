package com.alan.clients.module.impl.player;

import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.other.WorldChangeEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import hackclient.rise.afi;
import hackclient.rise.cg;
import net.minecraft.network.play.client.C0FPacketConfirmTransaction;

@ModuleInfo(aliases = "module.player.polardetector.name", description = "module.player.polardetector.description", category = Category.PLAYER)
public class PolarDetector extends Module {
    boolean afF = false;
    @EventLink
    public final Listener<PreMotionEvent> afG = var1 -> {
        if (aEg.thePlayer.ticksExisted == 30) {
            afi.b(this.afF ? "Polar is enabled" : "Polar is disabled");
        }
    };
    @EventLink
    public final Listener<PacketSendEvent> afH = var1 -> {
        if (var1.dq() instanceof C0FPacketConfirmTransaction) {
            this.afF = true;
        }
    };
    @EventLink
    public final Listener<WorldChangeEvent> afI = var1 -> this.afF = false;

    public PolarDetector() {
    }

    @Override
    public void onEnable() {
        cg.e("Polar Detector", "Join a game and this module will notify you of polars status");
    }
}
