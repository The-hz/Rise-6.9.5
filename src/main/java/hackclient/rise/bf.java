package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.component.Component;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.other.ServerJoinEvent;
import com.alan.clients.newevent.impl.other.TickEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.util.interfaces.InstanceAccess;
import hackclient.rise.event.er;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.s;
import org.json.JSONArray;
import org.json.JSONObject;
import rip.vantage.commons.packet.impl.client.community.g;
import rip.vantage.commons.packet.impl.server.community.c;
import rip.vantage.network.core.a;

public class bf extends Component implements InstanceAccess {
    public static HashMap<String, by> dc = new HashMap<>();
    public static List<String> dd = new ArrayList<>();
    public static List<String> de = new ArrayList<>();
    @EventLink
    public final Listener<ServerJoinEvent> onServerJoin = var0 -> {
        dc = new HashMap<>();
        dd = new ArrayList<>();
    };
    @EventLink
    public final Listener<TickEvent> onTick = var0 -> {
        ce.ch();
        ce.cg();

        for (EntityPlayer entityplayer : aEg.theWorld.playerEntities) {
            if (!dd.contains(entityplayer.getGameProfile().getName())) {
                dd.add(entityplayer.getGameProfile().getName());
                de.add(entityplayer.getGameProfile().getName());
            }
        }

        aZ();
    };
    @EventLink
    public final Listener<er> dh = var0 -> {
        if (var0.dd() instanceof c) {
            String s = ((c)var0.dd()).getMessage();
            JSONObject jsonobject = new JSONObject(s);

            for (String s1 : jsonobject.keySet()) {
                JSONObject jsonobject1 = new JSONObject(jsonobject.get(s1).toString());
                String s2 = jsonobject1.getString("f");
                by by = new by(s1);
                if (!s2.equals("") && !s2.equals(" ")) {
                    by.o(s2);
                    by.a(bz.Regular);
                    if (jsonobject1.getBoolean("h")) {
                        by.a(bz.Developer);
                    }

                    if (jsonobject1.getBoolean("g")) {
                        by.a(bz.Admin);
                    }

                    if (jsonobject1.getBoolean("i")) {
                        by.a(bz.Gato);
                    }

                    JSONArray jsonarray = jsonobject1.getJSONArray("j");
                    String[] astring = new String[jsonarray.length()];

                    for (int i = 0; i < jsonarray.length(); i++) {
                        astring[i] = jsonarray.getString(i);
                    }

                    by.b(astring);
                    dc.put(s1, by);
                }
            }
        }
    };
    @EventLink
    public final Listener<PacketReceiveEvent> onPacketReceive = var0 -> {
        if (var0.getPacket() instanceof net.minecraft.network.play.server.c c) {
            for (IChatComponent ichatcomponent : new ArrayList<>(c.getChatComponent().getSiblings())) {
                if (ichatcomponent instanceof s) {
                    String s = ichatcomponent.getFormattedText();
                    c.getChatComponent().getSiblings().remove(ichatcomponent);

                    for (Entry entry : dc.entrySet()) {
                        s = c(s, (String)entry.getKey());
                    }

                    if (s.equals(ichatcomponent.getFormattedText())) {
                        c.getChatComponent().getSiblings().add(ichatcomponent);
                    } else {
                        c.getChatComponent().getSiblings().add(new s(s));
                    }
                }
            }

            var0.setPacket(c);
        }
    };

    public bf() {
    }

    public static String c(String var0, String var1) {
        by by = dc.get(var1);
        if (by != null) {
            String s = " §7(" + var1 + "§7)§r";
            String s1 = "§" + by.bU() + by.bW() + " §7(";
            if (!var0.contains(s1)) {
                int i = var0.indexOf(var1);
                if (i > 1 && var0.toCharArray()[i - 2] == 167) {
                    s = " §7(§" + var0.toCharArray()[i - 1] + var1 + "§7)§r";
                }

                return var0.replaceAll(var1, "§" + by.bU() + by.bW() + s);
            }
        } else if (!dd.contains(var1)) {
            dd.add(var1);
            if (!var1.isBlank()) {
                de.add(var1);
            }
        }

        return var0;
    }

    public static void aZ() {
        if (!de.isEmpty() && de.get(0) != "") {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("[");

            for (String s : de) {
                stringbuilder.append("\"").append(s).append("\"");
            }

            stringbuilder.append("]");
            String s1 = "[\"" + String.join("\", \"", de) + "\"]";
            a.aKB().aKK().sendMessage(new g(s1).aJk());
            de = new ArrayList<>();
        }
    }

    public static String d(String var0, String var1) {
        String s = Client.a.k().rz().getChatAccentColor().toString();
        return EnumChatFormatting.BOLD + var1 + var0 + EnumChatFormatting.RESET + s + " » " + EnumChatFormatting.RESET;
    }
}
