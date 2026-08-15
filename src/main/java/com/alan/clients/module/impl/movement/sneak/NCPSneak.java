package com.alan.clients.module.impl.movement.sneak;

import com.alan.clients.module.impl.movement.Sneak;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PostMotionEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.value.Mode;
import hackclient.rise.ahj;
import net.minecraft.network.play.client.C0BPacketEntityAction.Action;
import net.minecraft.network.play.client.C0BPacketEntityAction;

public class NCPSneak extends Mode<Sneak> {
    @EventLink
    public final Listener<PreMotionEvent> onPreMotionEvent = var0 -> {
        aEg.thePlayer.movementInput.sneak = aEg.thePlayer.sendQueue.doneLoadingTerrain;
        ahj.l(new C0BPacketEntityAction(aEg.thePlayer, Action.STOP_SNEAKING));
    };
    @EventLink
    public final Listener<PostMotionEvent> onPostMotion = var0 -> ahj.l(new C0BPacketEntityAction(aEg.thePlayer, Action.START_SNEAKING));

    public NCPSneak(String var1, Sneak var2) {
        super(var1, var2);
    }

    @Override
    public void onDisable() {
        ahj.l(new C0BPacketEntityAction(aEg.thePlayer, Action.STOP_SNEAKING));
    }
}
