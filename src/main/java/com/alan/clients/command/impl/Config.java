package com.alan.clients.command.impl;

import com.alan.clients.command.Command;
import com.alan.clients.util.file.config.ConfigFile;
import hackclient.rise.afi;
import hackclient.rise.afj;
import com.alan.clients.util.file.config.ConfigManager;
import hackclient.rise.ahd;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import net.minecraft.event.ClickEvent.Action;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.s;
import rip.vantage.commons.packet.impl.client.community.c;
import rip.vantage.network.core.a;

public final class Config extends Command {
    public Config() {
        super("command.config.description", "config", "configs", "cfg", "settings", "c");
    }

    @Override
    public void execute(String[] var1) {
        ConfigManager afx = this.rN().p();
        String s = var1[1].toLowerCase();
        switch (var1.length) {
            case 2:
                label48: {
                    String s3 = s;
                    byte b2 = -1;
                    switch (s3.hashCode()) {
                        case -1268966290:
                            if (s3.equals("folder")) {
                                break label48;
                            }
                            break;
                        case 3322014:
                            if (s3.equals("list")) {
                                b2 = 0;
                            }
                    }

                    switch (b2) {
                        case 0:
                            afi.b("command.config.selectload");
                            afx.update();
                            afx.forEach(
                                var1x -> {
                                    String s4 = var1x.getFile().getName().replace(".json", "");
                                    String s5 = ".config load " + s4;
                                    String s6 = this.rz().getChatAccentColor().toString();
                                    s sx = new s(s6 + "> " + s4);
                                    s sxx = new s(String.format(ahd.ce("command.config.loadhover"), s4));
                                    sx.getChatStyle()
                                        .setChatClickEvent(new ClickEvent(Action.RUN_COMMAND, s5))
                                        .setChatHoverEvent(new HoverEvent(net.minecraft.event.HoverEvent.Action.SHOW_TEXT, sxx));
                                    aEg.thePlayer.addChatMessage(sx);
                                }
                            );
                            return;
                        case 1:
                            break;
                        default:
                            afi.b("command.config.actions");
                            return;
                    }
                }

                try {
                    Desktop desktop = Desktop.getDesktop();
                    File file1 = new File(String.valueOf(afx.CONFIG_DIRECTORY));
                    desktop.open(file1);
                    afi.b("command.config.folder");
                } catch (IllegalArgumentException | IOException illegalargumentexception) {
                    afi.b("command.config.notfound");
                }
                break;
            case 3:
                String s1;
                label58: {
                    s1 = var1[2];
                    String s2 = s;
                    byte b0 = -1;
                    switch (s2.hashCode()) {
                        case -1352294148:
                            if (s2.equals("create")) {
                                break label58;
                            }
                            break;
                        case 3327206:
                            if (s2.equals("load")) {
                                b0 = 0;
                            }
                            break;
                        case 3522941:
                            if (s2.equals("save")) {
                                break label58;
                            }
                    }

                    switch (b0) {
                        case 0:
                            afx.update();
                            ConfigFile configfile = afx.get(s1);
                            if (configfile != null) {
                                CompletableFuture.runAsync(() -> {
                                    if (configfile.te()) {
                                        afi.b("command.config.loaded", s1);
                                        if (!s1.equalsIgnoreCase("latest")) {
                                            afi.b("command.config.accident");
                                        }

                                        try {
                                            afj.sJ().bC(s1);
                                        } catch (Throwable throwable) {
                                        }
                                    } else {
                                        a.aKB().aKK().sendMessage(new c(s1).aJk());
                                    }
                                });
                            } else {
                                a.aKB().aKK().sendMessage(new c(s1).aJk());
                            }

                            return;
                        case 1:
                        case 2:
                            break;
                        default:
                            afi.b("command.config.usage");
                            return;
                    }
                }

                if (s1.equalsIgnoreCase("latest")) {
                    afi.b("command.config.reserved");
                    return;
                }

                CompletableFuture.runAsync(() -> {
                    afx.d(s1, false);
                    afi.b("command.config.saved");
                    afi.b("command.config.reminder");
                });
                break;
            default:
                afi.b("command.config.actions");
        }
    }
}
