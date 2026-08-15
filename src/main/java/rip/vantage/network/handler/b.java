package rip.vantage.network.handler;

import com.alan.clients.Client;
import com.alan.clients.module.Module;
import com.alan.clients.module.impl.render.ClickGUI;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.value.Mode;
import com.alan.clients.value.Value;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.BoundsNumberValue;
import com.alan.clients.value.impl.ColorValue;
import com.alan.clients.value.impl.DragValue;
import com.alan.clients.value.impl.ListValue;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.NumberValue;
import com.alan.clients.value.impl.StringValue;
import com.alan.clients.ui.theme.Themes;
import hackclient.rise.aha;
import com.alan.clients.util.localization.Locale;
import hackclient.rise.ahd;
import hackclient.rise.aju;
import hackclient.rise.event.er;
import java.awt.Color;
import java.util.HashMap;
import java.util.regex.Pattern;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.NetworkManager;
import net.minecraft.util.Session;
import rip.vantage.commons.packet.impl.client.protection.d;
import rip.vantage.commons.packet.impl.server.monitoring.S2CPacketStopRecording;
import rip.vantage.commons.packet.impl.server.protection.S2CPacketServerJoin;
import rip.vantage.commons.packet.impl.server.protection.S2CPacketConfig;
import rip.vantage.commons.packet.impl.server.protection.S2CPacketProofOfWorkChallenge;
import rip.vantage.security.IntegrityGuard;

public final class b implements rip.vantage.commons.handler.api.S2CPacketHandler {
    private final rip.vantage.commons.util.time.a eRz = new rip.vantage.commons.util.time.a();

    public b() {
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.protection.S2CPacketAuthentication packet) {
        String s = packet.aKh();
        if (s != null && !s.isEmpty()) {
            String s1 = aju.vW();
            if (!IntegrityGuard.aL(s1, s)) {
                System.out.println("EC57");
                rip.vantage.util.NativeBridge.a(packet, boolean.class, false);
                rip.vantage.util.NativeBridge.kQ(s1);
            }
        }

        long i = IntegrityGuard.a(packet, packet.aKi(), packet.aKk(), packet.aKl(), packet.aKm());
        if (!IntegrityGuard.V(i)) {
            System.out.println("EC74");
            rip.vantage.util.NativeBridge.kF(1);
            rip.vantage.util.NativeBridge.kG(1);
            throw new SecurityException("EC74");
        }

        Client.a.e().d(new er(packet));
        this.eRz.aX();
        NetHandlerPlayClient nethandlerplayclient = InstanceAccess.aEg.getNetHandler();
        if (nethandlerplayclient != null) {
            NetworkManager networkmanager = nethandlerplayclient.getNetworkManager();
            String s2 = networkmanager.getRemoteAddress().toString().split(":")[0];
            int j = Integer.parseInt(networkmanager.getRemoteAddress().toString().split(":")[1]);
            rip.vantage.network.core.a.aKB().aKK().sendMessage(new d(s2, j, InstanceAccess.aEg.getSession().getUsername()).aJk());
        }
    }

    @Override
    public void a(S2CPacketConfig packet) {
        aha.aMR
            .execute(
                () -> {
                    HashMap hashmap = new HashMap();

                    for (Module module : Client.a.g().ef()) {
                        module.setEnabled(false);
                        String s = module.getModuleInfo().aliases()[0];
                        hashmap.put(s, module);

                        for (Locale locale : Locale.values()) {
                            String s1 = ahd.a(s, locale);
                            if (s1 != null && !s1.isEmpty() && !s1.equals(s)) {
                                hashmap.putIfAbsent(s1, module);
                            }
                        }

                        String[] astring = rip.vantage.util.NativeBridge.n(module);
                        if (astring != null) {
                            for (String s2 : astring) {
                                if (s2 != null && !s2.isEmpty()) {
                                    hashmap.putIfAbsent(s2, module);
                                }
                            }
                        }

                        for (Value value : module.getAllValues()) {
                            value.setValueAsObject(value.ws());
                        }
                    }

                    boolean flag = false;

                    for (String s3 : packet.aJw().split("\n")) {
                        if (!flag) {
                            String[] astring1 = s3.split("th_");
                            if (astring1.length > 1) {
                                rip.vantage.util.NativeBridge.a(() -> Client.a.k().a(Themes.valueOf(astring1[1])));
                            }

                            flag = true;
                        } else {
                            String s4 = s3.split("_")[0].trim();
                            if (hashmap.containsKey(s4)) {
                                Module module1 = (Module)hashmap.get(s4);
                                String s5 = s3.split("_")[1].split("_")[0];
                                String s6 = s5;
                                String s7;
                                int i;
                                switch (s6) {
                                    case "e1":
                                    case "kc":
                                        continue;
                                    default:
                                        s7 = s3.split("_" + Pattern.quote(s5) + "_")[1].split("_")[0];
                                        i = 0;
                                }

                                for (Value value1 : module1.getAllValues()) {
                                    i++;
                                    String s8 = value1.getName()
                                        + " in "
                                        + (
                                            value1.wq() != null
                                                ? (
                                                    value1.wq() instanceof Module
                                                        ? ((Module)value1.wq()).getModuleInfo().aliases()[0] + " Module"
                                                        : ((Mode)value1.wq()).getName() + " Mode"
                                                )
                                                : "Unknown"
                                        );
                                    if (s5.contains("*")) {
                                        s8 = value1.getName() + "*" + i;
                                    }

                                    if (s8.equalsIgnoreCase(s5)) {
                                        if (value1 instanceof ModeValue modevalue) {
                                            modevalue.co(s3.split("_" + Pattern.quote(s7) + "_")[1]);
                                        } else if (value1 instanceof BooleanValue booleanvalue) {
                                            booleanvalue.setValue(Boolean.parseBoolean(s3.split("_" + Pattern.quote(s7) + "_")[1]));
                                        } else if (value1 instanceof StringValue stringvalue) {
                                            if (s3.contains("_" + Pattern.quote(s7) + "_")) {
                                                stringvalue.n(s3.split("_" + Pattern.quote(s7) + "_")[1].replaceAll("<percentsign>", "%"));
                                            }
                                        } else if (value1 instanceof NumberValue numbervalue) {
                                            numbervalue.n(Double.parseDouble(s3.split("_" + Pattern.quote(s7) + "_")[1]));
                                        } else if (value1 instanceof BoundsNumberValue boundsnumbervalue) {
                                            double d0;
                                            label198: {
                                                d0 = Double.parseDouble(s3.split("_" + Pattern.quote(s7) + "_")[1]);
                                                String s9 = s7;
                                                switch (s9) {
                                                    case "first":
                                                        boundsnumbervalue.n(d0);
                                                        continue;
                                                    case "second":
                                                        break;
                                                    default:
                                                        continue;
                                                }
                                            }

                                            boundsnumbervalue.a(d0);
                                        } else if (value1 instanceof ColorValue colorvalue) {
                                            Color color;
                                            int j;
                                            label220: {
                                                label219: {
                                                    label218: {
                                                        color = colorvalue.wo();
                                                        j = Integer.parseInt(s3.split("_" + Pattern.quote(s7) + "_")[1]);
                                                        String s10 = s7;
                                                        switch (s10) {
                                                            case "red":
                                                                colorvalue.n(new Color(j, color.getGreen(), color.getBlue(), color.getAlpha()));
                                                                continue;
                                                            case "green":
                                                                break label220;
                                                            case "blue":
                                                                break label219;
                                                            case "alpha":
                                                                break;
                                                            default:
                                                                continue;
                                                        }
                                                    }

                                                    colorvalue.n(new Color(color.getRed(), color.getGreen(), color.getBlue(), j));
                                                    continue;
                                                }

                                                colorvalue.n(new Color(color.getRed(), color.getGreen(), j, color.getAlpha()));
                                                continue;
                                            }

                                            colorvalue.n(new Color(color.getRed(), j, color.getBlue(), color.getAlpha()));
                                        } else if (!(value1 instanceof DragValue dragvalue)) {
                                            if (value1 instanceof ListValue listvalue) {
                                                for (Object object : listvalue.getModes()) {
                                                    if (object.toString().equalsIgnoreCase(s3.split("_" + Pattern.quote(s7) + "_")[1])) {
                                                        listvalue.setValueAsObject(object);
                                                    }
                                                }
                                            }
                                        } else {
                                            double d1;
                                            label241: {
                                                label240: {
                                                    label239: {
                                                        d1 = Double.parseDouble(s3.split("_" + Pattern.quote(s7) + "_")[1]);
                                                        String s11 = s7;
                                                        switch (s11) {
                                                            case "positionX":
                                                                dragvalue.h(new Vector2d(d1, dragvalue.apP.y));
                                                                dragvalue.i(new Vector2d(d1, dragvalue.atg.y));
                                                                continue;
                                                            case "positionY":
                                                                break label241;
                                                            case "scaleX":
                                                                break label240;
                                                            case "scaleY":
                                                                break;
                                                            default:
                                                                continue;
                                                        }
                                                    }

                                                    dragvalue.n(new Vector2d(dragvalue.aHe.x, d1));
                                                    continue;
                                                }

                                                dragvalue.n(new Vector2d(d1, dragvalue.aHe.y));
                                                continue;
                                            }

                                            dragvalue.h(new Vector2d(dragvalue.apP.x, d1));
                                            dragvalue.i(new Vector2d(dragvalue.atg.x, d1));
                                        }
                                    }
                                }
                            }
                        }
                    }

                    for (String s12 : packet.aJw().split("\n")) {
                        String s13 = s12.split("_")[0];
                        if (hashmap.containsKey(s13)) {
                            Module module2;
                            label152: {
                                module2 = (Module)hashmap.get(s13);
                                String s14 = s12.split("_")[1].split("_")[0];
                                String s15 = s14;
                                switch (s15) {
                                    case "e1":
                                        if (!(module2 instanceof ClickGUI)) {
                                            module2.setEnabled(Boolean.parseBoolean(s12.split("_e1_")[1]));
                                        }
                                        continue;
                                    case "kc":
                                        break;
                                    default:
                                        continue;
                                }
                            }

                            module2.setKey(Integer.parseInt(s12.split("_kc_")[1]));
                        }
                    }
                }
            );
    }

    @Override
    public void a(S2CPacketServerJoin packet) {
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.protection.S2CPacketAccount packet) {
        Minecraft.getMinecraft().session = new Session(packet.bX(), packet.sh(), packet.si(), "microsoft");
        Client.a.e().d(new er(packet));
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.management.S2CPacketHudRefresh packet) {
        Minecraft.getMinecraft().ingameGUI.lastSystemTime = -50L;
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.community.S2CPacketChatMessage packet) {
        Client.a.e().d(new er(packet));
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.community.S2CPacketUserData packet) {
        Client.a.e().d(new er(packet));
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.protection.S2CPacketEntityListRequest packet) {
        Client.a.e().d(new er(packet));
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.community.S2CPacketTitle packet) {
        Client.a.e().d(new er(packet));
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.community.S2CPacketConfigList packet) {
        Client.a.e().d(new er(packet));
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.community.e var1) {
        Client.a.e().d(new er(var1));
    }

    public void a(rip.vantage.commons.packet.impl.server.general.a var1) {
        c.eRC.aX();
        this.eRz.aX();
    }

    @Override
    public void a(S2CPacketProofOfWorkChallenge packet) {
        byte[] abyte = packet.aJF();
        if (abyte != null && abyte.length == 32) {
            long i = packet.nb();
            if (i > 0L && Math.abs(System.currentTimeMillis() - i) > 60000L) {
                System.out.println("EC152");
            }

            if (!IntegrityGuard.aMs()) {
                System.out.println("EC40 - ProofOfWork integrity failed");
                rip.vantage.util.NativeBridge.kF(1);
                rip.vantage.util.NativeBridge.kG(1);
                throw new SecurityException("EC40");
            }

            rip.vantage.network.core.a.aKB().n(abyte);
        } else {
            System.out.println("EC151");
            rip.vantage.util.NativeBridge.kF(1);
            rip.vantage.util.NativeBridge.kG(1);
            throw new SecurityException("EC151");
        }
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.monitoring.S2CPacketStartRecording packet) {
        Client.a.e().d(new er(packet));
    }

    @Override
    public void a(S2CPacketStopRecording packet) {
        Client.a.e().d(new er(packet));
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.monitoring.S2CPacketCaptureRequest packet) {
        Client.a.e().d(new er(packet));
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.monitoring.S2CPacketCaptureCancel packet) {
        Client.a.e().d(new er(packet));
    }

    @Override
    public void b(rip.vantage.commons.packet.impl.server.monitoring.S2CPacketMonitorConsent packet) {
        Client.a.e().d(new er(packet));
    }

    @Override
    public void b(rip.vantage.commons.packet.impl.server.monitoring.S2CPacketMonitorRequest packet) {
        Client.a.e().d(new er(packet));
    }

    @Override
    public void b(rip.vantage.commons.packet.impl.server.monitoring.S2CPacketMonitorCommand packet) {
        Client.a.e().d(new er(packet));
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.monitoring.S2CPacketMonitorPing packet) {
        Client.a.e().d(new er(packet));
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.protection.h var1) {
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.protection.S2CPacketJdkUnlockGrant packet) {
        Client.a.e().d(new er(packet));
    }
}
