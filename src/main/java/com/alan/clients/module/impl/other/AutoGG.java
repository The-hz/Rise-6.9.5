package com.alan.clients.module.impl.other;

import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.other.WorldChangeEvent;
import com.alan.clients.value.impl.StringValue;

@ModuleInfo(aliases = "module.other.autogg.name", description = "module.other.autogg.description", category = Category.PLAYER)
public final class AutoGG extends Module {
    private final StringValue message = new StringValue("Message", this, "Why waste another game without Rise?");
    private boolean dj;
    private boolean Tq;
    @EventLink
    public final Listener<PreMotionEvent> Tr = var1 -> {
        if (aEg.thePlayer.ticksExisted % 18 == 0 && aEg.thePlayer.sendQueue.doneLoadingTerrain && !aEg.isIntegratedServerRunning()) {
            if (aEg.theWorld.playerEntities.stream().filter(var0 -> !var0.isInvisible() || var0 == aEg.thePlayer).count() <= 1L) {
                if (this.dj) {
                    aEg.thePlayer.sendChatMessage(this.message.wo());
                    this.dj = false;
                }
            } else if (this.Tq) {
                this.dj = true;
                this.Tq = false;
            }
        }
    };
    @EventLink
    public final Listener<WorldChangeEvent> Ts = var1 -> this.Tq = true;

    public AutoGG() {
    }

    @Override
    public void onEnable() {
        this.Tq = true;
    }
}
