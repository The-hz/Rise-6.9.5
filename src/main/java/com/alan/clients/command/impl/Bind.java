package com.alan.clients.command.impl;

import com.alan.clients.Client;
import com.alan.clients.command.Command;
import hackclient.rise.afi;
import hackclient.rise.p;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.s;
import org.lwjgl.input.Keyboard;

public final class Bind extends Command
{
    public Bind() {
        super("command.bind.description", new String[] { "bind", "binds", "keybind", "b" });
    }

    @Override
    public void execute(final String[] array) {
        if (array.length == 3) {
            final p a = Client.a.t().a(array[1]);
            if (a == null) {
                afi.b("command.bind.invalidmodule", new Object[0]);
                return;
            }
            final int d = d(array[2]);
            a.setKey(d);
            afi.b("Bound " + a.getName() + " to " + b(d), new Object[0]);
            afi.b("Remember you can bind configs by doing .bind configname key", new Object[0]);
        }
        else if (array.length == 2 && array[1].equalsIgnoreCase("list")) {
            afi.b("Displaying all active binds", new Object[0]);
            Client.a.t().aP().forEach(p -> {
                if (p.getKey() != 0) {
                    final s s = new s(this.rz().rH().toString() + "> " + p.getAliases()[0] + "§f " + b(p.getKey()));
                    s.getChatStyle().setChatClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ".bind " + p.getName().replace((CharSequence)" ", (CharSequence)"") + " none")).setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (IChatComponent)new s("Click to remove " + p.getAliases()[0] + " bind")));
                    Bind.aEg.thePlayer.addChatMessage((IChatComponent)s);
                }
            });
        }
        else {
            this.error(".bind <list/module/config> (KEY)");
        }
    }

    public static int d(final String s) {
        if (s == null) {
            return 0;
        }
        final String upperCase = s.trim().toUpperCase();
        if (upperCase.isEmpty()) {
            return 0;
        }
        final String s2 = upperCase;
        int n = -1;
        switch (s2.hashCode()) {
            case 2402104: {
                if (s2.equals("NONE")) {
                    n = 0;
                    break;
                }
                break;
            }
            case 424865381: {
                if (s2.equals("UNBOUND")) {
                    return 0;
                }
                break;
            }
            case 237052353: {
                if (s2.equals("LEFTCLICK")) {
                    return -100;
                }
                break;
            }
            case 246388958: {
                if (s2.equals("LEFTMOUSE")) {
                    return -100;
                }
                break;
            }
            case -2014950324: {
                if (s2.equals("MOUSE1")) {
                    return -100;
                }
                break;
            }
            case 76092: {
                if (s2.equals("MB1")) {
                    return -100;
                }
                break;
            }
            case -899096340: {
                if (s2.equals("RIGHTCLICK")) {
                    return -99;
                }
                break;
            }
            case -889759735: {
                if (s2.equals("RIGHTMOUSE")) {
                    return -99;
                }
                break;
            }
            case -2014950323: {
                if (s2.equals("MOUSE2")) {
                    return -99;
                }
                break;
            }
            case 76093: {
                if (s2.equals("MB2")) {
                    return -99;
                }
                break;
            }
            case -1717291789: {
                if (s2.equals("MIDDLECLICK")) {
                    return -98;
                }
                break;
            }
            case -1707955184: {
                if (s2.equals("MIDDLEMOUSE")) {
                    return -98;
                }
                break;
            }
            case -2014950322: {
                if (s2.equals("MOUSE3")) {
                    return -98;
                }
                break;
            }
            case 76094: {
                if (s2.equals("MB3")) {
                    return -98;
                }
                break;
            }
        }
        switch (n) {
            case 0:
            case 1: {
                return 0;
            }
            case 2:
            case 3:
            case 4:
            case 5: {
                return -100;
            }
            case 6:
            case 7:
            case 8:
            case 9: {
                return -99;
            }
            case 10:
            case 11:
            case 12:
            case 13: {
                return -98;
            }
            default: {
                if (upperCase.startsWith("MOUSE") || upperCase.startsWith("MB")) {
                    final String s3 = upperCase.startsWith("MOUSE") ? upperCase.substring(5) : upperCase.substring(2);
                    try {
                        final int int1 = Integer.parseInt(s3);
                        if (int1 >= 1) {
                            return int1 - 101;
                        }
                    }
                    catch (final NumberFormatException ex) {}
                }
                break;
            }
        }
        return Keyboard.getKeyIndex(upperCase);
    }

    public static String b(final int n) {
        switch (n) {
            case -100: {
                return "Left Click";
            }
            case -99: {
                return "Right Click";
            }
            case -98: {
                return "Middle Click";
            }
            default: {
                final String keyDisplayString = GameSettings.getKeyDisplayString(n);
                return (keyDisplayString == null || keyDisplayString.trim().isEmpty()) ? "NONE" : keyDisplayString;
            }
        }
    }

    public static String c(final int n) {
        if (n == 0) {
            return "NONE";
        }
        if (n < 0) {
            return "MOUSE" + (n + 101);
        }
        final String keyName = Keyboard.getKeyName(n);
        return (keyName == null || keyName.trim().isEmpty()) ? "NONE" : keyName.toUpperCase();
    }
}
