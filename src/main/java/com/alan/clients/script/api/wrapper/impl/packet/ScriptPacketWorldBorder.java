package com.alan.clients.script.api.wrapper.impl.packet;

import java.lang.reflect.Field;
import net.minecraft.network.play.server.S44PacketWorldBorder;

public class ScriptPacketWorldBorder extends ScriptPacket<S44PacketWorldBorder> {
    public ScriptPacketWorldBorder(S44PacketWorldBorder var1) {
        super(var1);
    }

    public String getAction() {
        try {
            Field field = this.wrapped.getClass().getDeclaredField("action");
            field.setAccessible(true);
            Object object = field.get(this.wrapped);
            return object != null ? object.toString() : "";
        } catch (Exception exception) {
            return "";
        }
    }

    public double getTargetSize() {
        try {
            Field field = this.wrapped.getClass().getDeclaredField("targetSize");
            field.setAccessible(true);
            return field.getDouble(this.wrapped);
        } catch (Exception exception) {
            return 0.0;
        }
    }

    public double getCenterX() {
        try {
            Field field = this.wrapped.getClass().getDeclaredField("centerX");
            field.setAccessible(true);
            return field.getDouble(this.wrapped);
        } catch (Exception exception) {
            return 0.0;
        }
    }

    public double getCenterZ() {
        try {
            Field field = this.wrapped.getClass().getDeclaredField("centerZ");
            field.setAccessible(true);
            return field.getDouble(this.wrapped);
        } catch (Exception exception) {
            return 0.0;
        }
    }

    public long getTimeUntilTarget() {
        try {
            Field field = this.wrapped.getClass().getDeclaredField("timeUntilTarget");
            field.setAccessible(true);
            return field.getLong(this.wrapped);
        } catch (Exception exception) {
            return 0L;
        }
    }

    public int getWarningTime() {
        try {
            Field field = this.wrapped.getClass().getDeclaredField("warningTime");
            field.setAccessible(true);
            return field.getInt(this.wrapped);
        } catch (Exception exception) {
            return 0;
        }
    }

    public int getWarningDistance() {
        try {
            Field field = this.wrapped.getClass().getDeclaredField("warningDistance");
            field.setAccessible(true);
            return field.getInt(this.wrapped);
        } catch (Exception exception) {
            return 0;
        }
    }
}
