package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.compat.NetworkToggles;
import com.alan.clients.compat.OfflineMode;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import hackclient.rise.ade;
import hackclient.rise.adh;
import hackclient.rise.adm;
import hackclient.rise.aeb;
import hackclient.rise.aec;
import hackclient.rise.agc;
import hackclient.rise.agl;
import hackclient.rise.agm;
import hackclient.rise.aip;
import hackclient.rise.aiv;
import hackclient.rise.aiz;
import hackclient.rise.aju;
import hackclient.rise.er;
import hackclient.rise.gb;
import hackclient.rise.gd;
import hackclient.rise.gg;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import net.minecraft.client.gui.ScaledResolution;
import rip.vantage.commons.util.time.a;

public class aap
extends ade {
    public String aCA;
    public a bN;
    public adm aCx;
    @EventLink
    public Listener<er> aCE;
    public adh[] menuButtons;
    public adm aCw;
    public boolean aCz;
    public String jc;
    public Animation aCv;
    public String aCB = null;
    public agm aCy;
    public agc aCu = gb.MAIN.a(64, gd.LIGHT);
    public boolean aCC;
    public boolean aCD;
    public Animation animation = new Animation(Easing.EASE_OUT_QUINT, 600L);

    static {
    }


    @Override
    public void mouseClicked(final int n, final int n2, final int n3) {
        final long n4 = -8667487250350770505L;
        final long n5 = 4612836758129553145L;
        if (this.menuButtons == null) {
            return;
        }
        if (n3 == 0) {
            final adh[] menuButtons = this.menuButtons;
            final long n6 = menuButtons.length;
            final long n7 = n4;
            final long n8 = n7 ^ ((n6 ^ n7) & -1L >>> 32);
            final long n9 = 0L;
            final long n10 = n5;
            for (long n11 = n10 ^ ((n9 ^ n10) & -1L << 32); (int)(n11 >>> 32) < (int)n8; n11 += 4294967296L) {
                final adh adh = menuButtons[(int)(n11 >>> 32)];
                if (aeb.a(adh.getX(), adh.getY(), adh.oM(), adh.da(), n, n2)) {
                    adh.rm();
                    break;
                }
            }
            this.aCy.d(n, n2, n3);
        }
    }

    @Override
    public void keyTyped(char c2, int n) {
        this.aCy.b(c2, n);
        if (n != 15) {
            if (n != 28) return;
            if (this.aCy.getText().isEmpty()) return;
            this.aCx.rm();
            return;
        }
        this.aCy.I(!this.aCy.tO());
    }

    public void aW(String string) {
        long l3 = 5085688074218688810L;
        if (this.aCz) {
            return;
        }
        try {
            String string2 = aju.vW();
            if (this.aCB != null) {
                this.aCB.equals(string2);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        //add code
        if (NetworkToggles.versionCheck()) {
            block59: while (true) {
                try {
                    if (this.aCA == null) {
                        this.rp();
                    }
                    String[] stringArray = "6.9.5".split("\\.");
                    String[] stringArray2 = this.aCA.split("\\.");
                    long l4 = l3;
                    l3 = l4 ^ (0L ^ l4) & -1L << 32;
                    while ((int)(l3 >>> 32) < 2) {
                        if (Float.parseFloat(stringArray[(int)(l3 >>> 32)]) < Float.parseFloat(stringArray2[(int)(l3 >>> 32)])) {
                            System.out.println("A newer version is available please update your client on https://Vantage.Rip");
                            this.aX("A newer version is available please update your client on https://Vantage.Rip");
                            return;
                        }
                        try {
                            l3 += 0x100000000L;
                        } catch (Exception exception) {
                            exception.printStackTrace();
                            break;
                        }
                    }
                    break block59;
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
        rip.vantage.network.core.a.aKB().kj(string);
        rip.vantage.network.core.a.aKB().aKI();
        this.aCz = true;
        this.bN.aX();
    }

    public void aX(String string) {
        this.jc = string;
        this.bN.aX();
        this.aCz = false;
    }

    public aap() {
        this.aCv = new Animation(Easing.EASE_IN_OUT_CUBIC, 3000L);
        this.bN = new a();
        this.aCE = er2 -> {
            String string;
            String string2;
            rip.vantage.commons.packet.impl.server.protection.b b2 = null;
            long l4 = 6187545175897021594L;
            long l5 = 2076766356004144021L;
            if (!(er2.dd() instanceof rip.vantage.commons.packet.impl.server.protection.b)) return;
            b2 = (rip.vantage.commons.packet.impl.server.protection.b)er2.dd();
            System.out.println("Auth");
            rip.vantage.network.handler.c.eRC.aX();
            long l6 = l4;
            l4 = l6 ^ ((b2.aKi() ? 1L : 0L) << 32 ^ l6) & -1L << 32;
            this.aCC = false;
            if ((int)(l4 >>> 32) != 0 && (string2 = b2.aKh()) != null && !string2.isEmpty() && !rip.vantage.security.l.aL(string = aju.vW(), string2)) {
                System.out.println("EC61");
                long l7 = l4;
                l4 = l7 ^ (0L ^ l7) & -1L << 32;
                this.aCC = true;
                StringSelection stringSelection = new StringSelection(string);
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, new StringSelection("Rise"));
            }
            if ((int)(l4 >>> 32) != 0 && !rip.vantage.security.l.cV((int)(l4 >>> 32) != 0)) {
                System.out.println("EC92");
                System.exit(1);
                Runtime.getRuntime().halt(1);
                throw new SecurityException("EC92");
            }
            if ((int)(l4 >>> 32) != 0) {
                this.aCB = null;
                this.aCD = false;
                aEg.displayGuiScreen(new adr());
                Client.a.p().tn();
                return;
            }
            this.aX(b2.aKn());
            String string3 = null;
            string3 = aju.vW();
            StringSelection stringSelection = new StringSelection(string3);
            java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, new StringSelection("Rise"));
            long l8 = l5;
            l5 = l8 ^ ((long)(this.aCC || b2.aKn() != null && b2.aKn().equalsIgnoreCase("HWID_MISMATCH") ? 1 : 0) << 32 ^ l8) & -1L << 32;
            if ((int)(l5 >>> 32) == 0) return;
            if (this.aCD) return;
            this.aCD = true;
            this.aCB = string3;
            try {
                java.awt.Desktop.getDesktop().browse(new java.net.URI("https://youtu.be/jeYDms69hBo"));
            } catch (java.io.IOException | java.net.URISyntaxException e) {
                e.printStackTrace();
            }
        };
        Client.a.e().b(this);
    }

    @Override
    public void onGuiClosed() {
        Client.a.e().c(this);
    }

    //add code
    public void rp() {
        this.aCA = OfflineMode.offline()
            ? null
            : aec.aY("https://raw.githubusercontent.com/risellc/LatestRiseVersion/main/Version");
    }

    @Override
    public void initGui() {
        long l2;
        long l8 = -6610901742768452103L;
        long l9 = 4695415886190673032L;
        long l10 = -3848389860043264573L;
        long l11 = -2088766917341031741L;
        long l12 = l2 = -6408109000536517085L;
        long l13 = l12 ^ ((long)(this.width / 2) ^ l12) & -1L >>> 32;
        long l14 = l8;
        long l15 = l14 ^ ((long)(this.height / 2) << 32 ^ l14) & -1L << 32;
        long l16 = l11;
        long l17 = l16 ^ (0xB4L ^ l16) & -1L >>> 32;
        long l18 = l13;
        long l19 = l18 ^ (0x1800000000L ^ l18) & -1L << 32;
        long l20 = l17;
        long l21 = l20 ^ (0x600000000L ^ l20) & -1L << 32;
        long l22 = l9;
        long l23 = l22 ^ ((long)((int)l19 - (int)l21 / 2) ^ l22) & -1L >>> 32;
        long l24 = l10;
        long l25 = l24 ^ ((long)((int)(l15 >>> 32) - (int)(l19 >>> 32) / 2 - (int)(l21 >>> 32) / 2 - (int)(l19 >>> 32) / 2) << 32 ^ l24) & -1L << 32;
        this.aCw = new adm((int)l23, (int)(l25 >>> 32), (int)l21, (int)(l19 >>> 32), () -> {}, "");
        this.aCx = new adm((int)l23, (int)(l25 >>> 32) + (int)(l19 >>> 32) + (int)(l21 >>> 32), (int)l21, (int)(l19 >>> 32), () -> this.aW(this.aCy.getText()), "Login");
        this.aCy = new agm(new Vector2d((int)l19, (int)(l25 >>> 32) + 9), gb.MAIN.a(24, gd.BOLD), Color.WHITE, agl.CENTER, "Username", (int)l21 * 5);
        this.animation = new Animation(Easing.EASE_OUT_QUINT, 600L);
        this.menuButtons = new adh[]{this.aCw, this.aCx};
        this.aCv.T(255.0);
        this.aCv.reset();
        this.aCz = false;
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        if (this.aCv.sG() < 255.0) {
            aiv.aPL.a(aiz.OVERLAY, f, null);
        }
        ScaledResolution scaledResolution = aap.aEg.jY;
        this.b(gg.BLUR).c(() -> RenderUtil.d(0.0, 0.0, scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight(), Color.BLACK));
        this.aCw.c(n, n2, f);
        this.aCx.c(n, n2, f);
        this.b(gg.REGULAR).c(() -> {
            double d = 0.0;
            this.aCy.pJ();
            double d3 = this.aCw.getY() - (double)this.aCu.tq();
            this.animation.Q(d3);
            double d4 = this.animation.sG();
            Color color = aip.d(Color.WHITE, (int)(d4 / d3 * 200.0));
            this.aCu.c("Welcome", (float)this.width / 2.0f, d4 - 10.0, color.getRGB());
            if (this.bN.T(3000L)) {
                if (this.aCz) {
                    try {
                        String string = aju.vW();
                        StringSelection stringSelection = new StringSelection(string);
                        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, new StringSelection("Rise"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    this.aX("Login is taking longer than expected. HWID copied to clipboard.");
                }
                this.aCz = false;
            } else if (this.jc != null) {
                gb.MAIN.a(18, gd.LIGHT).c(this.jc, (float)this.width / 2.0f, d4 + 26.0, Color.RED.getRGB());
            }
            gb.MAIN.a(18, gd.REGULAR).d("Made with <3 by Alan and The_Bi11iona1re", scaledResolution.getScaledWidth() - 5, scaledResolution.getScaledHeight() - 20, aip.d(aBS, 100).getRGB());
            gb.MAIN.a(12, gd.REGULAR).d("\u00a9 Rise Client 2026. All Rights Reserved", scaledResolution.getScaledWidth() - 5, scaledResolution.getScaledHeight() - 10, aip.d(aBS, 100).getRGB());
            this.aCv.Q(0.0);
            RenderUtil.d(0.0, 0.0, aap.aEg.displayWidth, aap.aEg.displayHeight, new Color(0, 0, 0, (int)this.aCv.sG()));
        });
    }
}
