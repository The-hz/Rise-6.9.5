package com.alan.clients.module.impl.combat.antibot;

import com.alan.clients.Client;
import com.alan.clients.module.impl.combat.AntiBot;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.value.Mode;
import hackclient.rise.r;
import net.minecraft.entity.Entity;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public final class MiddleClickBotAntiBot extends Mode<AntiBot> {
    private boolean ji;
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var1x -> {
        if (Mouse.isButtonDown(2) || Keyboard.isKeyDown(29) && aEg.gameSettings.cgK.isKeyDown()) {
            if (this.ji) {
                return;
            }

            this.ji = true;
            if (aEg.objectMouseOver.typeOfHit == MovingObjectType.ENTITY) {
                r r = Client.a.x();
                Entity entity = aEg.objectMouseOver.entityHit;
                if (r.a(this, entity)) {
                    Client.a.x().c(this, entity);
                } else {
                    Client.a.x().b(this, entity);
                }
            }
        } else {
            this.ji = false;
        }
    };

    public MiddleClickBotAntiBot(String var1, AntiBot antiBot) {
        super(var1, antiBot);
    }

    @Override
    public void onDisable() {
        Client.a.x().a(this);
    }
}
