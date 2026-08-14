package com.alan.clients.script.api.wrapper.impl.event.impl;

import com.alan.clients.newevent.impl.motion.WaterEvent;
import com.alan.clients.script.api.wrapper.impl.event.ScriptEvent;

public class ScriptWaterEvent extends ScriptEvent<WaterEvent> {
    public ScriptWaterEvent(WaterEvent var1) {
        super(var1);
    }

    public void setWater(boolean var1) {
        this.wrapped.setWater(var1);
    }

    public boolean isWater() {
        return this.wrapped.isWater();
    }

    @Override
    public String getHandlerName() {
        return "onWater";
    }
}
