package com.alan.clients.command.impl;

import com.alan.clients.command.Command;
import hackclient.rise.afi;
import hackclient.rise.ahj;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;

public final class Stuck extends Command {
    public Stuck() {
        super("command.stuck.description", "stuck");
    }

    @Override
    public void execute(String[] var1) {
        ahj.m(new C04PacketPlayerPosition(aEg.thePlayer.posX, -1.0, aEg.thePlayer.posZ, false));
        afi.b("command.stuck.sent");
    }
}
