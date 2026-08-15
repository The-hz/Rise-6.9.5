package com.alan.clients.command.impl;

import com.alan.clients.Client;
import com.alan.clients.command.Command;
import com.alan.clients.module.Module;
import hackclient.rise.afi;
import hackclient.rise.ahd;
import net.minecraft.util.EnumChatFormatting;

public final class Toggle extends Command {
    public Toggle() {
        super("command.toggle.description", "toggle", "t");
    }

    @Override
    public void execute(String[] var1) {
        if (var1.length != 2) {
            this.error(String.format(".%s <module>", var1[0]));
        } else {
            Module module = Client.a.g().get(var1[1]);
            if (module == null) {
                afi.b(ahd.ce("command.bind.invalidmodule"));
            } else {
                module.toggle();
                afi.b(
                    ahd.ce("command.toggle.toggled"),
                    module.getAliases()[0] + " " + (module.isEnabled() ? EnumChatFormatting.GREEN + "on" : EnumChatFormatting.RED + "off")
                );
            }
        }
    }
}
