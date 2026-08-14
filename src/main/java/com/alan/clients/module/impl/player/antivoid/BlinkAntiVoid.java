package com.alan.clients.module.impl.player.antivoid;

import com.alan.clients.component.impl.player.BlinkComponent;
import com.alan.clients.module.impl.player.AntiVoid;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PostMotionEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.Mode;
import hackclient.rise.aih;
import hackclient.rise.aka;
import hackclient.rise.bd;

public class BlinkAntiVoid extends Mode<AntiVoid> {
    private aka Ft;
    private aka EC;
    private Vector2f ka;
    @EventLink
    public final Listener<PostMotionEvent> onPreUpdate = var1x -> {
        if (aEg.thePlayer.ticksExisted > 60) {
            if (this.Ft == null || this.EC == null || this.ka == null || aih.a(50.0, true)) {
                this.Ft = new aka(aEg.thePlayer.posX, aEg.thePlayer.posY, aEg.thePlayer.posZ);
                this.EC = new aka(aEg.thePlayer.motionX, aEg.thePlayer.motionY, aEg.thePlayer.motionZ);
                this.ka = new Vector2f(aEg.thePlayer.pl, aEg.thePlayer.rotationPitch);
            } else if (bd.cY > 4.0F) {
                aEg.thePlayer.setPosition(this.Ft.x, this.Ft.y, this.Ft.z);
                aEg.thePlayer.motionX = 0.0;
                aEg.thePlayer.motionY = MoveUtil.predictedMotion(this.EC.y);
                aEg.thePlayer.motionZ = 0.0;
                aEg.thePlayer.pl = this.ka.x;
                aEg.thePlayer.rotationPitch = this.ka.y;
                bd.cY = 0.0F;
                BlinkComponent.disable();
                BlinkComponent.dispatch();
            }
        }
    };

    public BlinkAntiVoid(String var1, AntiVoid var2) {
        super(var1, var2);
    }
}
