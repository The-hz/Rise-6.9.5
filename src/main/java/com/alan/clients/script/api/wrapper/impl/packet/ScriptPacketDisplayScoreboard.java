package com.alan.clients.script.api.wrapper.impl.packet;

import net.minecraft.network.play.server.bq;

public class ScriptPacketDisplayScoreboard extends ScriptPacket<bq> {
    public ScriptPacketDisplayScoreboard(bq var1) {
        super(var1);
    }

    public int getPosition() {
        return this.wrapped.func_149371_c();
    }

    public String getScoreName() {
        return this.wrapped.func_149370_d();
    }

    public void setPosition(int var1) {
        this.wrapped.setPosition(var1);
    }

    public void setScoreName(String var1) {
        this.wrapped.setScoreName(var1);
    }
}
