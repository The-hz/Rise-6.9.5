package com.alan.clients.newevent.impl.other;

import com.alan.clients.newevent.CancellableEvent;
import lombok.Generated;
import net.minecraft.network.play.client.C03PacketPlayer;

public final class TeleportEvent extends CancellableEvent {
    private C03PacketPlayer response;
    private double gW;
    private double gX;
    private double gY;
    private float gZ;
    private float ha;

    @Generated
    public C03PacketPlayer getResponse() {
        return this.response;
    }

    @Generated
    public double getPosX() {
        return this.gW;
    }

    @Generated
    public double getPosY() {
        return this.gX;
    }

    @Generated
    public double getPosZ() {
        return this.gY;
    }

    @Generated
    public float getYaw() {
        return this.gZ;
    }

    @Generated
    public float getPitch() {
        return this.ha;
    }

    @Generated
    public void setResponse(C03PacketPlayer response) {
        this.response = response;
    }

    @Generated
    public void setPosX(double var1) {
        this.gW = var1;
    }

    @Generated
    public void setPosY(double var1) {
        this.gX = var1;
    }

    @Generated
    public void setPosZ(double var1) {
        this.gY = var1;
    }

    @Generated
    public void setYaw(float var1) {
        this.gZ = var1;
    }

    @Generated
    public void setPitch(float pitch) {
        this.ha = pitch;
    }

    @Generated
    public TeleportEvent(C03PacketPlayer response, double var2, double var4, double var6, float var8, float var9) {
        this.response = response;
        this.gW = var2;
        this.gX = var4;
        this.gY = var6;
        this.gZ = var8;
        this.ha = var9;
    }
}
