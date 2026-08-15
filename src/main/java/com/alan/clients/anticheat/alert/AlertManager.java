package com.alan.clients.anticheat.alert;

import com.alan.clients.anticheat.check.Check;
import hackclient.rise.aha;
import java.util.HashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent.Action;
import net.minecraft.event.HoverEvent;
import net.minecraft.init.Items;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.s;

public final class AlertManager implements aha {
    private final Minecraft mc = Minecraft.getMinecraft();
    private final HashMap<String, s> Q = new HashMap<>();

    public AlertManager() {
    }

    public void sendAlert(Check var1) {
        aMR.execute(
            () -> {
                String sxxx = var1.getData().getPlayer().getName();
                String s1 = sxxx + var1.getCheckInfo().R() + var1.getCheckInfo().S();
                String s2 = "§cRise §c» §c%player%§7 has failed §c%check% §7(§c%type%§7)%dev% (Violations: §c%vl%§7)"
                    .replaceAll("%player%", sxxx)
                    .replaceAll("%check%", var1.getCheckInfo().R())
                    .replaceAll("%type%", var1.getCheckInfo().S())
                    .replaceAll("%dev%", "")
                    .replaceAll("%vl%", String.valueOf(var1.P()));
                NetworkPlayerInfo networkplayerinfo = this.mc.getNetHandler().getPlayerInfo(this.mc.thePlayer.getUniqueID());
                NetworkPlayerInfo networkplayerinfo1 = this.mc.getNetHandler().getPlayerInfo(var1.getData().getPlayer().getUniqueID());
                int i = networkplayerinfo != null && !this.mc.isSingleplayer() ? networkplayerinfo.getResponseTime() : 0;
                int j = networkplayerinfo1 != null && !this.mc.isSingleplayer() ? networkplayerinfo1.getResponseTime() : 0;
                String s3 = "§dDescription: §f" + var1.getCheckInfo().description().concat("\n").concat("§dYour Ping: " + i).concat("\n").concat("§dTheir Ping: " + j);
                ChatStyle chatstyle = new ChatStyle().setChatHoverEvent(new HoverEvent(Action.SHOW_TEXT, new s(s3)));
                if (!"Flight".equalsIgnoreCase(var1.getCheckInfo().R())
                    && (this.mc.thePlayer.inventory.getStackInSlot(0) == null || this.mc.thePlayer.inventory.getStackInSlot(0).getItem() != Items.compass)) {
                    String s4 = ".target add " + sxxx;
                    if (s4.startsWith("/")) {
                        s4 = s4.substring(1);
                    }

                    s sx = new s("§7[§cTarget Player§7]");
                    sx.setChatStyle(
                        new ChatStyle()
                            .setChatClickEvent(new ClickEvent(net.minecraft.event.ClickEvent.Action.RUN_COMMAND, s4))
                            .setChatHoverEvent(new HoverEvent(Action.SHOW_TEXT, new s("Click to run: " + s4)))
                    );
                    s sxx = new s(s2);
                    sxx.setChatStyle(chatstyle);
                    sxx.appendSibling(sx);
                    synchronized (this.Q) {
                        if (this.Q.containsKey(s1)) {
                            s sxxx2 = this.Q.get(s1);
                            sxxx2.setChatStyle(chatstyle);
                            sxxx2.getSiblings().clear();
                            sxxx2.appendSibling(sx);
                        } else {
                            this.Q.put(s1, sxx);
                            this.mc.addScheduledTask(() -> this.mc.thePlayer.addChatMessage(sx));
                        }
                    }
                }
            }
        );
    }
}
