package com.alan.clients.ui.menu.impl.serverfinder;

import lombok.Generated;

public class ServerIP {
    private final int aCR;
    private final int aCS;
    private final int aCT;
    private final int aCU;
    private final String[] split;

    public int getPart(int var1) {
        return Integer.parseInt(this.split[var1]);
    }

    public void setPart(int var1, int var2) {
        this.split[var1] = String.valueOf(var2);
    }

    public ServerIP(int var1, int var2, int var3, int var4) {
        this.split = new String[]{String.valueOf(var1), String.valueOf(var2), String.valueOf(var3), String.valueOf(var4)};
        this.aCR = var1;
        this.aCS = var2;
        this.aCT = var3;
        this.aCU = var4;
    }

    public ServerIP(String var1) {
        this.split = var1.split("\\.");
        this.aCR = Integer.parseInt(this.split[0]);
        this.aCS = Integer.parseInt(this.split[1]);
        this.aCT = Integer.parseInt(this.split[2]);
        this.aCU = Integer.parseInt(this.split[3]);
    }

    public static ServerIP a(ServerIP serverIP, ServerIP var1) {
        int i = Math.min(serverIP.aCR, var1.aCR);
        int j = Math.min(serverIP.aCS, var1.aCS);
        int k = Math.min(serverIP.aCT, var1.aCT);
        int l = Math.min(serverIP.aCU, var1.aCU);
        return new ServerIP(i, j, k, l);
    }

    public static ServerIP b(ServerIP serverIP, ServerIP var1) {
        int i = Math.max(serverIP.aCR, var1.aCR);
        int j = Math.max(serverIP.aCS, var1.aCS);
        int k = Math.max(serverIP.aCT, var1.aCT);
        int l = Math.max(serverIP.aCU, var1.aCU);
        return new ServerIP(i, j, k, l);
    }

    @Override
    public String toString() {
        return this.split[0] + "." + this.split[1] + "." + this.split[2] + "." + this.split[3];
    }

    @Generated
    public int ru() {
        return this.aCR;
    }

    @Generated
    public int rv() {
        return this.aCS;
    }

    @Generated
    public int rw() {
        return this.aCT;
    }

    @Generated
    public int getThird() {
        return this.aCU;
    }

    @Generated
    public String[] getSplit() {
        return this.split;
    }
}
