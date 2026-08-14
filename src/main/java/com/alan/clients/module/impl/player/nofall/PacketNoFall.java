package com.alan.clients.module.impl.player.nofall;

import com.alan.clients.module.impl.player.NoFall;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.value.Mode;
import hackclient.rise.ahj;
import hackclient.rise.bd;
import net.minecraft.network.play.client.C03PacketPlayer;

public class PacketNoFall extends Mode<NoFall> {
    @EventLink
    public final Listener<PreMotionEvent> onPreMotionEvent = var0 -> {
        float f = bd.cY;
        if (bd.cY > 3.1 + aEg.thePlayer.motionY) {
            ahj.l(new C03PacketPlayer(true));
            f = 0.0F;
        }

        bd.cY = f;
    };

    public PacketNoFall(String var1, NoFall var2) {
        super(var1, var2);
    }
}
