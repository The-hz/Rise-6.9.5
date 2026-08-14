package com.alan.clients.command.impl;

import com.alan.clients.Client;
import com.alan.clients.command.Command;
import hackclient.rise.afi;
import hackclient.rise.ahd;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

public final class Help extends Command {
    public Help() {
        super("command.help.description", "help", "?");
    }

    @Override
    public void execute(String[] var1) {
        Client.a
            .i()
            .aQ()
            .forEach(
                var0 -> afi.b(
                    StringUtils.capitalize(var0.getExpressions()[0]) + " " + Arrays.toString(var0.getExpressions()) + " §8» §7" + ahd.ce(var0.getDescription())
                )
            );
    }
}
