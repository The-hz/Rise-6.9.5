package com.alan.clients.ui.menu.impl.main;

import com.alan.clients.Client;
import com.alan.clients.compat.NetworkToggles;
import com.alan.clients.compat.OfflineMode;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.ui.menu.Menu;
import com.alan.clients.ui.menu.component.button.MenuButton;
import com.alan.clients.ui.menu.component.button.impl.MenuTextButton;
import com.alan.clients.util.MouseUtil;
import hackclient.rise.adr;
import hackclient.rise.aec;
import hackclient.rise.agc;
import hackclient.rise.agl;
import com.alan.clients.util.gui.textbox.TextBox;
import hackclient.rise.aip;
import hackclient.rise.aiv;
import hackclient.rise.aiz;
import hackclient.rise.aju;
import hackclient.rise.event.er;
import com.alan.clients.util.font.FontManager;
import hackclient.rise.gd;
import hackclient.rise.gg;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import net.minecraft.client.gui.ScaledResolution;
import rip.vantage.commons.util.time.a;

public class LoginMenu
extends Menu {
    public String aCA;
    public a bN;
    public MenuTextButton aCx;
    @EventLink
    public Listener<er> aCE;
    public MenuButton[] menuButtons;
    public MenuTextButton aCw;
    public boolean aCz;
    public String jc;
    public Animation aCv;
    public String aCB = null;
    public TextBox aCy;
    public agc aCu = FontManager.MAIN.a(64, gd.LIGHT);
    public boolean aCC;
    public boolean aCD;
    public Animation animation = new Animation(Easing.EASE_OUT_QUINT, 600L);

    static {
    }


    @Override
    public void mouseClicked(final int n, final int n2, final int n3) {
        if (this.menuButtons == null) {
            return;
        }
        if (n3 == 0) {
            final MenuButton[] menuButtons = this.menuButtons;
            int count = menuButtons.length;
            for (int i = 0; i < count; i++) {
                final MenuButton adh = menuButtons[i];
                if (MouseUtil.isHovered(adh.getX(), adh.getY(), adh.oM(), adh.da(), n, n2)) {
                    adh.runAction();
                    break;
                }
            }
            this.aCy.click(n, n2, n3);
        }
    }

    @Override
    public void keyTyped(char c2, int n) {
        this.aCy.key(c2, n);
        if (n != 15) {
            if (n != 28) return;
            if (this.aCy.getText().isEmpty()) return;
            this.aCx.runAction();
            return;
        }
        this.aCy.I(!this.aCy.tO());
    }

    public void aW(String string) {
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
            try {
                if (this.aCA == null) {
                    this.rp();
                }

                String[] stringArray = "6.9.5".split("\\.");
                String[] stringArray2 = this.aCA.split("\\.");

                for (int i = 0; i < 2; i++) {
                    if (Float.parseFloat(stringArray[i]) < Float.parseFloat(stringArray2[i])) {
                        System.out.println("A newer version is available please update your client on https://Vantage.Rip");
                        this.aX("A newer version is available please update your client on https://Vantage.Rip");
                        return;
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
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

    public LoginMenu() {
        this.aCv = new Animation(Easing.EASE_IN_OUT_CUBIC, 3000L);
        this.bN = new a();
        this.aCE = er2 -> {
            String string;
            String string2;
            rip.vantage.commons.packet.impl.server.protection.b b2 = null;
            if (!(er2.dd() instanceof rip.vantage.commons.packet.impl.server.protection.b)) return;
            b2 = (rip.vantage.commons.packet.impl.server.protection.b)er2.dd();
            System.out.println("Auth");
            rip.vantage.network.handler.c.eRC.aX();
            int aKi2 = (int)(b2.aKi() ? 1L : 0L);
            this.aCC = false;
            if (aKi2 != 0 && (string2 = b2.aKh()) != null && !string2.isEmpty() && !rip.vantage.security.l.aL(string = aju.vW(), string2)) {
                System.out.println("EC61");
                aKi2 = 0;
                this.aCC = true;
                StringSelection stringSelection = new StringSelection(string);
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, new StringSelection("Rise"));
            }
            if (aKi2 != 0 && !rip.vantage.security.l.cV(aKi2 != 0)) {
                System.out.println("EC92");
                System.exit(1);
                Runtime.getRuntime().halt(1);
                throw new SecurityException("EC92");
            }
            if (aKi2 != 0) {
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
            int equalsIgnoreCase2 = this.aCC || b2.aKn() != null && b2.aKn().equalsIgnoreCase("HWID_MISMATCH") ? 1 : 0;
            if (equalsIgnoreCase2 == 0) return;
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
        int width2 = this.width / 2;
        int height2 = this.height / 2;
        int l17_lo = 180;
        int l19_hi = 24;
        int l21_hi = 6;
        int dL19 = width2 - l17_lo / 2;
        int l25_hi = height2 - l19_hi / 2 - l21_hi / 2 - l19_hi / 2;
        this.aCw = new MenuTextButton(dL19, l25_hi, l17_lo, l19_hi, () -> {}, "");
        this.aCx = new MenuTextButton(dL19, l25_hi + l19_hi + l21_hi, l17_lo, l19_hi, () -> this.aW(this.aCy.getText()), "Login");
        this.aCy = new TextBox(new Vector2d(width2, l25_hi + 9), FontManager.MAIN.a(24, gd.BOLD), Color.WHITE, agl.CENTER, "Username", l17_lo * 5);
        this.animation = new Animation(Easing.EASE_OUT_QUINT, 600L);
        this.menuButtons = new MenuButton[]{this.aCw, this.aCx};
        this.aCv.T(255.0);
        this.aCv.reset();
        this.aCz = false;
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        if (this.aCv.sG() < 255.0) {
            aiv.aPL.a(aiz.OVERLAY, f, null);
        }
        ScaledResolution scaledResolution = LoginMenu.aEg.jY;
        this.b(gg.BLUR).c(() -> RenderUtil.d(0.0, 0.0, scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight(), Color.BLACK));
        this.aCw.draw(n, n2, f);
        this.aCx.draw(n, n2, f);
        this.b(gg.REGULAR).c(() -> {
            double d = 0.0;
            this.aCy.draw();
            double d3 = this.aCw.getY() - (double)this.aCu.height();
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
                FontManager.MAIN.a(18, gd.LIGHT).c(this.jc, (float)this.width / 2.0f, d4 + 26.0, Color.RED.getRGB());
            }
            FontManager.MAIN.a(18, gd.REGULAR).d("Made with <3 by Alan and The_Bi11iona1re", scaledResolution.getScaledWidth() - 5, scaledResolution.getScaledHeight() - 20, aip.d(aBS, 100).getRGB());
            FontManager.MAIN.a(12, gd.REGULAR).d("\u00a9 Rise Client 2026. All Rights Reserved", scaledResolution.getScaledWidth() - 5, scaledResolution.getScaledHeight() - 10, aip.d(aBS, 100).getRGB());
            this.aCv.Q(0.0);
            RenderUtil.d(0.0, 0.0, LoginMenu.aEg.displayWidth, LoginMenu.aEg.displayHeight, new Color(0, 0, 0, (int)this.aCv.sG()));
        });
    }
}
