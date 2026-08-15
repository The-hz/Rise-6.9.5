package com.alan.clients.command.impl;

import com.alan.clients.command.Command;
import hackclient.rise.afi;
import com.alan.clients.util.social.FriendManager;
import net.minecraft.entity.player.EntityPlayer;

public final class Friend extends Command {
    public Friend() {
        super("command.friend.description", "friend", "setfriend", "f");
    }

    @Override
    public void execute(String[] var1) {
        if (var1.length != 3) {
            this.error(".f <add/remove> <player>");
        } else {
            String s = var1[1].toLowerCase();
            String s1 = var1[2];
            boolean flag = false;

            label36:
            for (EntityPlayer entityplayer : aEg.theWorld.playerEntities) {
                if (entityplayer.getName().equalsIgnoreCase(s1)) {
                    label32: {
                        String s2 = s;
                        byte b0 = -1;
                        switch (s2.hashCode()) {
                            case -934610812:
                                if (s2.equals("remove")) {
                                    break label32;
                                }
                                break;
                            case 96417:
                                if (s2.equals("add")) {
                                    b0 = 0;
                                }
                        }

                        switch (b0) {
                            case 0:
                                FriendManager.j(entityplayer.getName());
                                afi.b(String.format("Added %s to friends list", s1));
                                flag = true;
                                break label36;
                            case 1:
                                break;
                            default:
                                break label36;
                        }
                    }

                    FriendManager.k(entityplayer.getName());
                    afi.b(String.format("Removed %s from friends list", s1));
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                afi.b("That user could not be found.");
            }
        }
    }
}
