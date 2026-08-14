package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.component.impl.player.PingSpoofComponent;
import com.alan.clients.module.impl.render.Interface;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.other.TickEvent;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.StringValue;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.minecraft.client.Minecraft;

public class ys extends Mode<Interface> {
    private final ModeValue ass = new yt(this, "ArrayList Color Mode", this);
    private final ModeValue ast = new yu(this, "ArrayList Alignment", this);
    private final BooleanValue asu = new BooleanValue("Arraylist Side Bar", this, false);
    private final BooleanValue asv = new BooleanValue("Arraylist Background", this, false);
    private final BooleanValue asw = new BooleanValue("Show Fps", this, false);
    private final BooleanValue asx = new BooleanValue("Show Time", this, false);
    private final BooleanValue asy = new BooleanValue("Show Ping", this, false);
    private final BooleanValue asz = new BooleanValue("Show Coordinates", this, true);
    private final StringValue asA = new StringValue("Custom Client Name", this, "Rise");
    @EventLink
    public final Listener<Render2DEvent> asB = var1x -> {
        if (aEg != null && !aEg.gameSettings.bJf && aEg.theWorld != null && aEg.thePlayer != null) {
            agc agc = Client.a.d() == ahc.ZH_ZH ? gb.MAIN.a(18, gd.REGULAR) : aEg.fontRendererObj;
            int i = 0;
            Color[] acolor = new Color[]{new Color(91, 206, 250), new Color(245, 169, 184), Color.WHITE, new Color(245, 169, 184)};
            int j = 0;
            this.wj().n(agc.tq() + 2.0F);
            this.wj().a(agc);
            this.wj().o(3.0F);
            double d0 = aEg.jY.getScaledHeight() - 10;
            String s = String.valueOf(Math.round(aEg.thePlayer.posX));
            String s1 = String.valueOf(Math.round(aEg.thePlayer.posY));
            String s2 = String.valueOf(Math.round(aEg.thePlayer.posZ));

            for (zc zc : this.wj().lL()) {
                if (zc.ath != 0.0F) {
                    boolean flag = !zc.getTag().isEmpty() && this.wj().anZ.wo();
                    double d1 = zc.nr().getX();
                    double d2 = zc.nr().getY();
                    if (this.ast.wo().getName().equals("Left")) {
                        d2 = zc.nr().getY() + agc.tq() + 2.0;
                        if (this.asu.wo()) {
                            d1 = 3.0F + zc.ath - 8.0F;
                        } else {
                            d1 = 3.0F + zc.ath - 10.0F;
                        }
                    }

                    Color color;
                    Color color1;
                    label88: {
                        label87: {
                            label86: {
                                color = zc.nw();
                                color1 = this.rz().rA();
                                String s3 = this.ass.wo().getName();
                                byte b0 = -1;
                                switch (s3.hashCode()) {
                                    case -1656737386:
                                        if (s3.equals("Rainbow")) {
                                            boolean flag1 = true;
                                            break label87;
                                        }
                                        break;
                                    case 2181788:
                                        if (s3.equals("Fade")) {
                                            b0 = 0;
                                        }
                                        break;
                                    case 81068680:
                                        if (s3.equals("Trans")) {
                                            byte b1 = 2;
                                            break label86;
                                        }
                                }

                                switch (b0) {
                                    case 0:
                                        color1 = this.rz().j(new Vector2d(0.0, zc.nr().getY()));
                                        break label88;
                                    case 1:
                                        break label87;
                                    case 2:
                                        break;
                                    default:
                                        break label88;
                                }
                            }

                            color = acolor[j];
                            break label88;
                        }

                        color1 = new Color(R(500 * i / 6));
                    }

                    if (this.asv.wo()) {
                        RenderUtil.d(d1 - 2.0, d2 - 2.0, zc.atj + zc.atk + 4.0F, this.wj().aoq, adv.rK());
                    }

                    if (this.asu.wo()) {
                        if (this.ast.wo().getName().equals("Left")) {
                            RenderUtil.d(d1 - (this.asv.wo() ? 2 : 3), d2 - 2.0, 1.0, this.wj().aoq, color1);
                        } else {
                            RenderUtil.d(d1 + (zc.atj + zc.atk) + 2.0, d2 - 2.0, 1.0, this.wj().aoq, color1);
                        }
                    }

                    agc.b(zc.getDisplayName(), d1, d2, color.getRGB());
                    i++;
                    j = (j + 1) % acolor.length;
                    if (flag) {
                        agc.b(zc.nz(), d1 + zc.nu() + 3.0, d2, -3355444);
                    }

                    zc.b(color1);
                }
            }

            int k = this.ass.wo().getName().equals("Rainbow") ? R(1000) : this.rz().rA().getRGB();
            agc.b(this.nn(), 3.0, 3.0, k);
            if (this.asz.wo()) {
                agc.b("X:§7 " + s, 3.0, d0 - aEg.fontRendererObj.tq() * 2.0F, k);
                agc.b("Y:§7 " + s1, 3.0, d0 - aEg.fontRendererObj.tq(), k);
                agc.b("Z:§7 " + s2, 3.0, d0, k);
            }
        }
    };
    @EventLink
    public final Listener<TickEvent> asC = var1x -> aMR.execute(() -> {
        for (zc zc : this.wj().lL()) {
            if (zc.ath != 0.0F) {
                agc agc = Client.a.d() == ahc.ZH_ZH ? gb.MAIN.a(18, gd.REGULAR) : aEg.fontRendererObj;
                zc.y(!zc.getTag().isEmpty() && this.wj().anZ.wo());
                String s = (this.wj().aoa.wo() ? zc.nx().toLowerCase() : zc.nx()).replace(this.wj().lH().wo() ? " " : "", "");
                String s1 = (this.wj().aoa.wo() ? zc.getTag().toLowerCase() : zc.getTag()).replace(this.wj().lH().wo() ? " " : "", "");
                zc.t(agc.getStringWidth(s));
                zc.u(zc.nA() ? agc.getStringWidth(s1) + 3 : 0.0F);
                zc.ap(s);
                zc.aq(s1);
            }
        }
    });

    public ys(String var1, Interface var2) {
        super(var1, var2);
    }

    private static int R(int var0) {
        return Color.getHSBColor((float)(Math.ceil((System.currentTimeMillis() + var0) / 10.0) % 360.0 / 360.0), 0.6F, 1.0F).getRGB();
    }

    private String nn() {
        if (!this.asA.wo().isEmpty()) {
            Date date = new Date();
            String s = new SimpleDateFormat("h:mm a").format(date);
            String s1 = this.asA.wo().charAt(0) + "§7" + this.asA.wo().substring(1);
            if (this.asx.wo()) {
                s1 = s1 + " [§f" + s + "§7]";
            }

            if (this.asw.wo()) {
                s1 = s1 + " [§f" + Minecraft.getDebugFPS() + " FPS§7]";
            }

            if (this.asy.wo()) {
                s1 = s1 + " [§f" + PingSpoofComponent.getPing() + "ms§7]";
            }

            return s1;
        }
        this.asA.n("Rise");
        return null;
    }
}
