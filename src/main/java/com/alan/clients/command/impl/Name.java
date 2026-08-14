package com.alan.clients.command.impl;

import com.alan.clients.command.Command;
import hackclient.rise.afi;
import hackclient.rise.aih;
import net.minecraft.client.gui.GuiScreen;

public final class Name extends Command {
    public Name() {
        super("command.name.description", "name", "ign", "username", "nick", "nickname");
    }

    @Override
    public void execute(String[] var1) {
        String s = aih.R();
        GuiScreen.setClipboardString(s);
        afi.b("command.name.copied", s);
    }
}
