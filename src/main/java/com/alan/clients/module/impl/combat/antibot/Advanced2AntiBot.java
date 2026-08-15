package com.alan.clients.module.impl.combat.antibot;

import com.alan.clients.Client;
import com.alan.clients.module.impl.combat.AntiBot;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.other.WorldChangeEvent;
import com.alan.clients.value.Mode;
import com.alan.clients.util.account.AntiBotProfileLookup;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import net.minecraft.entity.player.EntityPlayer;

public final class Advanced2AntiBot extends Mode<AntiBot> {
    private final Set<UUID> ri = new HashSet<>();
    private final Set<UUID> rj = new HashSet<>();
    private final Set<String> rk = new HashSet<>();
    private final Map<String, Integer> rl = new HashMap<>();
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var1x -> {
        if (aEg.theWorld != null && aEg.thePlayer != null) {
            for (Object object : aEg.theWorld.playerEntities) {
                if (object instanceof EntityPlayer entityplayer && entityplayer != aEg.thePlayer) {
                    String s = entityplayer.getName();
                    this.rl.putIfAbsent(s, entityplayer.getEntityId());
                    if (this.rk.contains(s) && this.rl.get(s) != entityplayer.getEntityId()) {
                        Client.a.x().b(this, entityplayer);
                    } else {
                        this.rk.add(s);
                        if (entityplayer.getGameProfile() == null) {
                            Client.a.x().b(this, entityplayer);
                        } else {
                            UUID uuid = entityplayer.getGameProfile().getId();
                            if (uuid == null) {
                                Client.a.x().b(this, entityplayer);
                            } else if (uuid.version() != 4) {
                                Client.a.x().b(this, entityplayer);
                            } else if (this.rj.contains(uuid)) {
                                Client.a.x().b(this, entityplayer);
                            } else if (!this.ri.contains(uuid)) {
                                this.ri.add(uuid);
                                AntiBotProfileLookup.a(
                                    uuid,
                                    var2x -> {
                                        this.ri.remove(uuid);
                                        if (!var2x) {
                                            this.rj.add(uuid);
                                            if (aEg.theWorld != null) {
                                                for (Object object1 : aEg.theWorld.playerEntities) {
                                                    if (object1 instanceof EntityPlayer entityplayer1
                                                        && entityplayer1.getGameProfile() != null
                                                        && uuid.equals(entityplayer1.getGameProfile().getId())) {
                                                        Client.a.x().b(this, entityplayer1);
                                                    }
                                                }
                                            }
                                        } else if (aEg.theWorld != null) {
                                            for (Object object2 : aEg.theWorld.playerEntities) {
                                                if (object2 instanceof EntityPlayer entityplayer2
                                                    && entityplayer2.getGameProfile() != null
                                                    && uuid.equals(entityplayer2.getGameProfile().getId())) {
                                                    Client.a.x().c(this, entityplayer2);
                                                }
                                            }
                                        }
                                    }
                                );
                            }
                        }
                    }
                }
            }
        }
    };
    @EventLink
    public final Listener<WorldChangeEvent> onWorldChange = var1x -> {
        Client.a.x().a(this);
        this.ri.clear();
        this.rj.clear();
        this.rk.clear();
        this.rl.clear();
        AntiBotProfileLookup.sb();
    };

    public Advanced2AntiBot(String var1, AntiBot antiBot) {
        super(var1, antiBot);
    }

    @Override
    public void onDisable() {
        Client.a.x().a(this);
        this.ri.clear();
        this.rj.clear();
        this.rk.clear();
        this.rl.clear();
    }
}
