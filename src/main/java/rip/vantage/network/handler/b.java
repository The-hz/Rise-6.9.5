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
import hackclient.rise.adv;
import hackclient.rise.aha;
import hackclient.rise.ahc;
import hackclient.rise.ahd;
import hackclient.rise.aju;
import hackclient.rise.er;
import java.awt.Color;
import java.util.HashMap;
import java.util.regex.Pattern;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.NetworkManager;
import net.minecraft.util.Session;
import rip.vantage.commons.packet.impl.client.protection.d;
import rip.vantage.commons.packet.impl.server.monitoring.h;
import rip.vantage.commons.packet.impl.server.protection.e;
import rip.vantage.commons.packet.impl.server.protection.f;
import rip.vantage.commons.packet.impl.server.protection.g;
import rip.vantage.security.l;

public final class b implements rip.vantage.commons.handler.api.c {
    private final rip.vantage.commons.util.time.a eRz = new rip.vantage.commons.util.time.a();

    public b() {
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.protection.b var1) {
        String s = var1.aKh();
        if (s != null && !s.isEmpty()) {
            String s1 = aju.vW();
            if (!l.aL(s1, s)) {
                System.out.println("EC57");
                rip.vantage.util.a.a(var1, boolean.class, false);
                rip.vantage.util.a.kQ(s1);
            }
        }

        long i = l.a(var1, var1.aKi(), var1.aKk(), var1.aKl(), var1.aKm());
        if (!l.V(i)) {
            System.out.println("EC74");
            rip.vantage.util.a.kF(1);
            rip.vantage.util.a.kG(1);
            throw new SecurityException("EC74");
        }

        Client.a.e().d(new er(var1));
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
    public void a(f var1) {
        aha.aMR
            .execute(
                () -> {
                    HashMap hashmap = new HashMap();

                    for (Module module : Client.a.g().ef()) {
                        module.setEnabled(false);
                        String s = module.getModuleInfo().aliases()[0];
                        hashmap.put(s, module);

                        for (ahc ahc : ahc.values()) {
                            String s1 = ahd.a(s, ahc);
                            if (s1 != null && !s1.isEmpty() && !s1.equals(s)) {
                                hashmap.putIfAbsent(s1, module);
                            }
                        }

                        String[] astring = rip.vantage.util.a.n(module);
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

                    for (String s3 : var1.aJw().split("\n")) {
                        if (!flag) {
                            String[] astring1 = s3.split("th_");
                            if (astring1.length > 1) {
                                rip.vantage.util.a.a(() -> Client.a.k().a(adv.valueOf(astring1[1])));
                            }

                            flag = true;
                        } else {
                            String s4 = s3.split("_")[0].trim();
                            if (hashmap.containsKey(s4)) {
                                Module module1 = (Module)hashmap.get(s4);
                                String s5 = s3.split("_")[1].split("_")[0];
                                String s6 = s5;
                                byte b0 = -1;
                                switch (s6.hashCode()) {
                                    case 3180:
                                        if (s6.equals("e1")) {
                                            b0 = 0;
                                        }
                                        break;
                                    case 3416:
                                        if (s6.equals("kc")) {
                                            continue;
                                        }
                                }

                                String s7;
                                int i;
                                switch (b0) {
                                    case 0:
                                    case 1:
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
                                                byte b1 = -1;
                                                switch (s9.hashCode()) {
                                                    case -906279820:
                                                        if (s9.equals("second")) {
                                                            break label198;
                                                        }
                                                        break;
                                                    case 97440432:
                                                        if (s9.equals("first")) {
                                                            b1 = 0;
                                                        }
                                                }

                                                switch (b1) {
                                                    case 0:
                                                        boundsnumbervalue.n(d0);
                                                        continue;
                                                    case 1:
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
                                                        byte b2 = -1;
                                                        switch (s10.hashCode()) {
                                                            case 112785:
                                                                if (s10.equals("red")) {
                                                                    b2 = 0;
                                                                }
                                                                break;
                                                            case 3027034:
                                                                if (s10.equals("blue")) {
                                                                    break label219;
                                                                }
                                                                break;
                                                            case 92909918:
                                                                if (s10.equals("alpha")) {
                                                                    break label218;
                                                                }
                                                                break;
                                                            case 98619139:
                                                                if (s10.equals("green")) {
                                                                    break label220;
                                                                }
                                                        }

                                                        switch (b2) {
                                                            case 0:
                                                                colorvalue.n(new Color(j, color.getGreen(), color.getBlue(), color.getAlpha()));
                                                                continue;
                                                            case 1:
                                                                break label220;
                                                            case 2:
                                                                break label219;
                                                            case 3:
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
                                                        byte b5 = -1;
                                                        switch (s11.hashCode()) {
                                                            case -908189618:
                                                                if (s11.equals("scaleX")) {
                                                                    break label240;
                                                                }
                                                                break;
                                                            case -908189617:
                                                                if (s11.equals("scaleY")) {
                                                                    break label239;
                                                                }
                                                                break;
                                                            case 1707117647:
                                                                if (s11.equals("positionX")) {
                                                                    b5 = 0;
                                                                }
                                                                break;
                                                            case 1707117648:
                                                                if (s11.equals("positionY")) {
                                                                    break label241;
                                                                }
                                                        }

                                                        switch (b5) {
                                                            case 0:
                                                                dragvalue.h(new Vector2d(d1, dragvalue.apP.y));
                                                                dragvalue.i(new Vector2d(d1, dragvalue.atg.y));
                                                                continue;
                                                            case 1:
                                                                break label241;
                                                            case 2:
                                                                break label240;
                                                            case 3:
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

                    for (String s12 : var1.aJw().split("\n")) {
                        String s13 = s12.split("_")[0];
                        if (hashmap.containsKey(s13)) {
                            Module module2;
                            label152: {
                                module2 = (Module)hashmap.get(s13);
                                String s14 = s12.split("_")[1].split("_")[0];
                                String s15 = s14;
                                byte b8 = -1;
                                switch (s15.hashCode()) {
                                    case 3180:
                                        if (s15.equals("e1")) {
                                            b8 = 0;
                                        }
                                        break;
                                    case 3416:
                                        if (s15.equals("kc")) {
                                            break label152;
                                        }
                                }

                                switch (b8) {
                                    case 0:
                                        if (!(module2 instanceof ClickGUI)) {
                                            module2.setEnabled(Boolean.parseBoolean(s12.split("_e1_")[1]));
                                        }
                                        continue;
                                    case 1:
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
    public void a(e var1) {
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.protection.a var1) {
        Minecraft.getMinecraft().session = new Session(var1.bX(), var1.sh(), var1.si(), "microsoft");
        Client.a.e().d(new er(var1));
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.management.a var1) {
        Minecraft.getMinecraft().ingameGUI.lastSystemTime = -50L;
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.community.b var1) {
        Client.a.e().d(new er(var1));
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.community.c var1) {
        Client.a.e().d(new er(var1));
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.protection.c var1) {
        Client.a.e().d(new er(var1));
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.community.d var1) {
        Client.a.e().d(new er(var1));
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.community.a var1) {
        Client.a.e().d(new er(var1));
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
    public void a(g var1) {
        byte[] abyte = var1.aJF();
        if (abyte != null && abyte.length == 32) {
            long i = var1.nb();
            if (i > 0L && Math.abs(System.currentTimeMillis() - i) > 60000L) {
                System.out.println("EC152");
            }

            if (!l.aMs()) {
                System.out.println("EC40 - ProofOfWork integrity failed");
                rip.vantage.util.a.kF(1);
                rip.vantage.util.a.kG(1);
                throw new SecurityException("EC40");
            }

            rip.vantage.network.core.a.aKB().n(abyte);
        } else {
            System.out.println("EC151");
            rip.vantage.util.a.kF(1);
            rip.vantage.util.a.kG(1);
            throw new SecurityException("EC151");
        }
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.monitoring.a var1) {
        Client.a.e().d(new er(var1));
    }

    @Override
    public void a(h var1) {
        Client.a.e().d(new er(var1));
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.monitoring.b var1) {
        Client.a.e().d(new er(var1));
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.monitoring.d var1) {
        Client.a.e().d(new er(var1));
    }

    @Override
    public void b(rip.vantage.commons.packet.impl.server.monitoring.e var1) {
        Client.a.e().d(new er(var1));
    }

    @Override
    public void b(rip.vantage.commons.packet.impl.server.monitoring.f var1) {
        Client.a.e().d(new er(var1));
    }

    @Override
    public void b(rip.vantage.commons.packet.impl.server.monitoring.c var1) {
        Client.a.e().d(new er(var1));
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.monitoring.g var1) {
        Client.a.e().d(new er(var1));
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.protection.h var1) {
    }

    @Override
    public void a(rip.vantage.commons.packet.impl.server.protection.d var1) {
        Client.a.e().d(new er(var1));
    }
}
