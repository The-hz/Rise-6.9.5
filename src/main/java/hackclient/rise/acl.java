package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.command.Command;
import com.alan.clients.command.impl.Bind;
import com.alan.clients.module.Module;
import com.alan.clients.module.impl.render.Interface;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.file.config.ConfigFile;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import com.google.gson.JsonObject;
import hackclient.rise.acm;
import hackclient.rise.acn;
import hackclient.rise.acp;
import hackclient.rise.acq;
import hackclient.rise.acr;
import hackclient.rise.acs;
import hackclient.rise.act;
import hackclient.rise.acu;
import hackclient.rise.acv;
import hackclient.rise.acw;
import hackclient.rise.acx;
import hackclient.rise.acy;
import hackclient.rise.acz;
import hackclient.rise.ada;
import hackclient.rise.adb;
import hackclient.rise.adc;
import hackclient.rise.adv;
import hackclient.rise.aeb;
import hackclient.rise.afj;
import hackclient.rise.agc;
import hackclient.rise.agk;
import hackclient.rise.agl;
import hackclient.rise.agm;
import hackclient.rise.agw;
import hackclient.rise.agx;
import hackclient.rise.ahd;
import hackclient.rise.aip;
import hackclient.rise.gb;
import hackclient.rise.gd;
import hackclient.rise.gg;
import hackclient.rise.p;
import hackclient.rise.u;
import java.awt.Color;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Keyboard;
import rip.vantage.commons.util.time.a;

public final class acl
extends GuiScreen {
    private static final double aAl = -0.5;
    private static final double aAm = 28.0;
    private static final double aAn = 2.0;
    private static final long aAo = 3000L;
    private static final agc aAp = gb.MAIN.a(17, gd.MEDIUM);
    private static final agc aAq = gb.MAIN.a(13, gd.REGULAR);
    private static final agc aAr = gb.MAIN.a(12, gd.REGULAR);
    private final GuiScreen aAs;
    private final agm aAt;
    private final agw aAu = new agw();
    private final agk aAv = new agk();
    private final Animation aAw = new Animation(Easing.EASE_OUT_QUAD, 1L);
    private final a aAx = new a();
    private final List<acr> aAy = new ArrayList<acr>();
    private List<acr> aAz = new ArrayList<acr>();
    private final Map<String, ada> aAA = new HashMap<String, ada>();
    private List<acy> aAB = new ArrayList<acy>();
    private boolean aAC;
    private boolean aAD;
    private acz aAE;
    private double aAF;
    private double aAG;
    private double aAH;
    private double aAI;
    private double aAJ = 36.0;
    private double aAK;
    private double aAL;
    private double aAM;
    private double aAN;
    private String aAO = "";
    private int aAP;
    private String statusMessage = "";
    private Color statusColor = new Color(255, 90, 90);
    private String aAQ;
    private String aAR;
    private String aAS;
    private boolean aAT;
    private String aAU;
    private boolean aAV;
    private boolean aAW;
    private boolean aAX = true;
    private long aAY;
    private long aAZ;
    @EventLink
    public final Listener<Render2DEvent> onRender2D = render2DEvent -> {
        if (acl.aEg.currentScreen != this) {
            return;
        }
        double d2 = 10.0;
        try {
            Interface interface_ = (Interface)this.e(Interface.class);
            if (interface_ != null && ((Boolean)interface_.aoc.wo()).booleanValue()) {
                Color color = aip.d(adv.rK(), 255);
                this.b(gg.BLUR).c(() -> RenderUtil.roundedRectangle(this.aAF, this.aAG, this.aAH, this.aAI, d2, color));
                this.b(gg.BLOOM).c(() -> RenderUtil.roundedRectangle(this.aAF, this.aAG, this.aAH, this.aAI, d2 + 2.0, this.rz().rE()));
            }
            return;
        }
        catch (Throwable throwable) {
            return;
        }
    };

    public acl(GuiScreen guiScreen) {
        this.aAs = guiScreen;
        this.aAt = new agm(new Vector2d(0.0, 0.0), gb.MAIN.a(20, gd.REGULAR), Color.WHITE, agl.LEFT, ahd.ce("ui.command.palette.placeholder"), 400.0f);
        this.aAt.I(true);
        this.aAt.bW(".");
        this.aAt.ar(1);
        this.aAw.T(0.0);
        this.aAw.R(0.0);
        Client.a.getCommandManager().aQ().forEach(command -> this.aAy.add(new acr((Command)command)));
        this.aAz = new ArrayList<acr>(this.aAy);
        this.re();
        Client.a.e().b((Object)this);
    }

    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.aAt.I(true);
        this.aAt.ar(this.aAt.getText().length());
        this.statusMessage = "";
        this.aAx.aX();
        try {
            afj.sJ().sS();
            return;
        }
        catch (Throwable throwable) {
            return;
        }
    }

    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
        Client.a.e().c((Object)this);
    }

    public void drawScreen(int n2, int n3, float f2) {
        double d2 = this.qJ();
        this.qS();
        this.qU();
        this.K(d2);
        this.qK();
        this.L(d2);
        this.M(d2);
        this.N(d2);
        this.a(n2, n3, d2);
        this.O(d2);
        super.drawScreen(n2, n3, f2);
    }

    protected void keyTyped(char c2, int n2) {
        if (this.ab(n2)) {
            return;
        }
        if (agx.isEnabled() && this.aAu.a(this.aAt, c2, n2)) {
            this.qL();
            return;
        }
        switch (n2) {
            case 1: {
                aEg.displayGuiScreen(this.aAs);
                return;
            }
            case 200: {
                this.aa(-1);
                return;
            }
            case 208: {
                this.aa(1);
                return;
            }
            case 15: {
                if (this.aAC) {
                    this.rc();
                    return;
                }
                this.qN();
                return;
            }
            case 28: {
                if (!this.aAC) {
                    String string;
                    String string2 = this.aAt.getText();
                    if (string2 == null) {
                        string2 = "";
                    }
                    if (!(string = this.aS(string2)).isEmpty() && !string.contains(" ")) {
                        int n3;
                        String string3 = null;
                        int n4 = this.qV();
                        int n5 = this.qW();
                        if (n4 != -1 && this.aAP == n4) {
                            String string4 = this.aAR == null ? "" : this.aAR;
                            String string5 = this.aS(string4);
                            String[] stringArray = string5.trim().isEmpty() ? new String[]{} : string5.trim().split("\\s+");
                            if (stringArray.length > 0) {
                                string3 = stringArray[0];
                            }
                        } else if (n5 != -1 && this.aAP == n5) {
                            String string6 = this.aAQ == null ? "" : this.aAQ;
                            String string7 = this.aS(string6);
                            String[] stringArray = string7.trim().isEmpty() ? new String[]{} : string7.trim().split("\\s+");
                            if (stringArray.length > 0) {
                                string3 = stringArray[0];
                            }
                        } else if (!this.aAz.isEmpty() && (n3 = this.ag(this.aAP)) >= 0 && n3 < this.aAz.size()) {
                            acr acr2 = this.aAz.get(n3);
                            string3 = acr2.aBk;
                        }
                        if (string3 != null && !string3.isEmpty()) {
                            String string8 = string2.trim();
                            boolean bl = string2.endsWith(" ");
                            boolean bl2 = (string8.equals("." + string3) || string8.equals("/" + string3)) && bl;
                            if (bl2) {
                                this.qO();
                            } else {
                                this.qN();
                            }
                            return;
                        }
                        this.qN();
                        return;
                    }
                }
                if (this.aAC && this.qI()) {
                    this.rc();
                    return;
                }
                if (this.aAt.getText().trim().isEmpty()) {
                    this.qN();
                    return;
                }
                this.qO();
                return;
            }
        }
        this.aAt.key(c2, n2);
        this.qL();
    }

    private boolean qI() {
        char c2;
        String string;
        if (!this.aAC) return false;
        if (this.aAB.isEmpty()) {
            return false;
        }
        String string2 = this.aAt.getText();
        if (string2 == null) {
            string2 = "";
        }
        if ((string = ((c2 = this.aP(string2)) != '\u0000' && string2.startsWith(String.valueOf(c2)) ? string2.substring(1) : string2).trim()).isEmpty()) {
            return false;
        }
        String[] stringArray = string.split("\\s+");
        if (stringArray.length == 0) {
            return false;
        }
        int n2 = Math.max(0, Math.min(this.aAP, this.aAB.size() - 1));
        acy acy2 = this.aAB.get(n2);
        int n3 = acy2.aBD;
        if (n3 + 1 >= stringArray.length) {
            return true;
        }
        String string3 = stringArray[n3 + 1];
        String string4 = acy2.aBC;
        if (string3.equals(string4)) return false;
        return true;
    }

    public void mouseClicked(int n2, int n3, int n4) {
        block5: {
            block7: {
                int n5;
                int n6;
                block8: {
                    block6: {
                        if (this.ac(n4)) {
                            return;
                        }
                        if (n4 == 0 && !aeb.isHovered(this.aAF, this.aAG, this.aAH, this.aAI, n2, n3)) {
                            aEg.displayGuiScreen(this.aAs);
                            return;
                        }
                        this.aAt.click(n2, n3, n4);
                        if (n4 != 0 || (n6 = this.j(n2, n3)) == -1) break block5;
                        this.aAP = n6;
                        if (!this.aAC) break block6;
                        this.rc();
                        break block5;
                    }
                    if (!GuiScreen.isShiftKeyDown()) break block7;
                    int n7 = this.qV();
                    n5 = this.qW();
                    if (n7 == -1 || n6 != n7) break block8;
                    this.qY();
                    break block5;
                }
                if (n5 != -1 && n6 == n5) {
                    this.rb();
                    break block5;
                }
                int n8 = this.ag(n6);
                if (n8 >= 0 && n8 < this.aAz.size()) {
                    this.a(this.aAz.get(n8));
                }
                break block5;
            }
            this.qN();
        }
        super.mouseClicked(n2, n3, n4);
    }

    public boolean doesGuiPauseGame() {
        return false;
    }

    private double qJ() {
        this.aAw.Q(1.0);
        return Math.min(1.0, this.aAw.sG());
    }

    private void K(double d2) {
        this.aAH = Math.min(this.width - 80, 500);
        int n2 = Math.max(1, this.qR());
        double d3 = Math.max(28.0, (double)n2 * 30.0 - 2.0);
        double d4 = Math.min((double)(this.height - 80), Math.max(300.0, (double)this.height * 0.6));
        double d5 = 200.0;
        double d6 = this.aAJ + -1.0 + 14.0 + d3 + 10.0;
        double d7 = Math.max(d5, Math.min(d4, d6));
        if (this.aAI == 0.0) {
            this.aAI = d7;
        } else {
            double d8 = 1.0;
            this.aAI += (d7 - this.aAI) * d8;
        }
        this.aAF = ((double)this.width - this.aAH) / 2.0;
        double d9 = ((double)this.height - d4) / 2.0;
        this.aAG = d9 + (1.0 - d2) * 12.0;
        this.aAK = this.aAF + -0.5;
        this.aAM = this.aAH - -1.0;
        this.aAL = this.aAG + -0.5 + this.aAJ + 10.0;
        this.aAN = this.aAI - (this.aAJ + -1.0 + 14.0);
    }

    private void L(double d2) {
        double d3 = 10.0;
        Color color = aip.d(Color.BLACK, (int)(43.0 * d2));
        RenderUtil.roundedRectangle(this.aAF - 3.0, this.aAG - 3.0, this.aAH + 6.0, this.aAI + 6.0, d3 + 2.0, color);
        Color color2 = aip.d(adv.rK(), 115);
        RenderUtil.roundedRectangle(this.aAF, this.aAG, this.aAH, this.aAI, d3, color2);
        Color color3 = aip.d(this.rz().rA(), (int)(65.0 * d2));
        Color color4 = aip.d(this.rz().rB(), (int)(40.0 * d2));
        RenderUtil.roundedOutlineGradientRectangle(this.aAF, this.aAG, this.aAH, this.aAI, d3, 1.0, color3, color4);
    }

    private void M(double d2) {
        String string;
        double d3 = this.aAF + -0.5;
        double d4 = this.aAG + -0.5;
        double d5 = this.aAH - -1.0;
        this.aAt.z((float)(d5 - 24.0));
        this.aAt.h(new Vector2d(d3 + 12.0, d4 + (this.aAJ - (double)this.aAt.eb().height()) / 2.0 + 1.5));
        this.aAt.setColor(aip.d(Color.WHITE, (int)(255.0 * d2)));
        this.aAt.I(true);
        String string2 = this.aAt.aJm;
        if (agx.isEnabled() && this.aAu.uc() && (string = this.aAu.uo()) != null && !string.isEmpty()) {
            this.aAt.aJm = "";
        }
        this.aAt.draw();
        this.aAt.aJm = string2;
        this.k(d3 + 12.0, d4 + (this.aAJ - (double)this.aAt.eb().height()) / 2.0 + 1.5, d2);
        if (agx.isEnabled() && this.aAu.uc()) {
            String string3 = this.aAu.uo();
            List<String> list = this.aAu.up();
            if (string3 != null && !string3.isEmpty()) {
                float f2 = this.aAt.tL();
                float f3 = this.aAt.tM();
                int n2 = aip.d(Color.WHITE, (int)(215.0 * d2)).getRGB();
                aAp.a(string3, f2, f3, n2);
                RenderUtil.d(f2, f3 + aAp.height() + 1.0f, aAp.getStringWidth(string3), 1.0, aip.d(Color.WHITE, (int)(160.0 * d2)));
                if (list != null && !list.isEmpty()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    int n3 = Math.min(9, list.size());
                    int n4 = this.aAu.un();
                    for (int i2 = 0; i2 < n3; ++i2) {
                        if (i2 > 0) {
                            stringBuilder.append("  ");
                        }
                        String string4 = i2 + 1 + "." + list.get(i2);
                        if (i2 == n4) {
                            stringBuilder.append('[').append(string4).append(']');
                            continue;
                        }
                        stringBuilder.append(string4);
                    }
                    stringBuilder.append(this.aAu.ut());
                    String string5 = stringBuilder.toString();
                    double d6 = 6.0;
                    double d7 = (double)aAp.getStringWidth(string5) + d6 * 2.0;
                    double d8 = (double)aAp.height() + d6 * 2.0;
                    double d9 = f2 - 2.0f;
                    double d10 = f3 + aAp.height() + 6.0f;
                    double d11 = 8.0;
                    this.b(gg.BLOOM).c(() -> RenderUtil.roundedRectangle(d9, d10, d7, d8, d11 + 2.0, this.rz().rE()));
                    RenderUtil.roundedRectangle(d9, d10, d7, d8, d11, aip.d(adv.rK(), 190));
                    aAp.a(string5, d9 + d6, d10 + d6, aip.d(Color.WHITE, 230).getRGB());
                }
            }
        }
    }

    private void k(double d2, double d3, double d4) {
        Object object;
        String string;
        block17: {
            block16: {
                int n2;
                boolean bl;
                String string2;
                if (agx.isEnabled() && this.aAu.uc() && (string2 = this.aAu.uo()) != null && !string2.isEmpty()) {
                    return;
                }
                string = this.aAt.getText();
                if (string == null || string.isEmpty()) {
                    return;
                }
                object = null;
                if (!this.aAC || this.aAB.isEmpty()) break block16;
                this.aAP = Math.max(0, Math.min(this.aAP, this.aAB.size() - 1));
                acy acy2 = this.aAB.get(this.aAP);
                String string3 = this.aS(string);
                String[] stringArray = string3.trim().isEmpty() ? new String[]{} : string3.split("\\s+");
                bl = stringArray.length > (n2 = acy2.aBD + 1);
                String string4 = bl ? stringArray[n2] : null;
                if (string4 != null && !string4.isEmpty()) {
                    String string5 = acy2.aBC;
                    if (string5.toLowerCase(Locale.ROOT).startsWith(string4.toLowerCase(Locale.ROOT)) && !string4.equalsIgnoreCase(string5)) {
                        object = string5.substring(string4.length());
                    }
                    break block17;
                }
                boolean bl3 = stringArray.length <= n2;
                boolean bl4 = string.endsWith(" ");
                String string6 = acy2.aBC;
                object = (bl3 && !bl4 ? " " : "") + string6;
                break block17;
            }
            if (!this.aAz.isEmpty()) {
                int n3 = this.qV();
                int n4 = this.qW();
                if (n3 != -1 && this.aAP == n3 && this.aAR != null && (string.startsWith(".") || string.startsWith("/"))) {
                    String string7;
                    string7 = string.length() > 0 ? string.substring(1) : "";
                    String string9 = this.aAR.trim();
                    if (string9.startsWith(".") || string9.startsWith("/")) {
                        string9 = string9.substring(1);
                    }
                    if (string9.toLowerCase(Locale.ROOT).startsWith(string7.toLowerCase(Locale.ROOT)) && !string7.equalsIgnoreCase(string9)) {
                        object = string9.substring(Math.min(string7.length(), string9.length()));
                    }
                } else if (n4 != -1 && this.aAP == n4 && this.aAQ != null && (string.startsWith(".") || string.startsWith("/"))) {
                    String string10;
                    string10 = string.length() > 0 ? string.substring(1) : "";
                    String string12 = this.aAQ.trim();
                    if (string12.startsWith(".") || string12.startsWith("/")) {
                        string12 = string12.substring(1);
                    }
                    if (string12.toLowerCase(Locale.ROOT).startsWith(string10.toLowerCase(Locale.ROOT)) && !string10.equalsIgnoreCase(string12)) {
                        object = string12.substring(Math.min(string10.length(), string12.length()));
                    }
                } else {
                    int n5 = this.ag(this.aAP);
                    int n6 = Math.max(0, Math.min(n5, this.aAz.size() - 1));
                    acr acr2 = this.aAz.get(n6);
                    String string13 = this.aS(string);
                    String string14 = acr2.aBk;
                    if ((string.startsWith(".") || string.startsWith("/")) && string14.toLowerCase(Locale.ROOT).startsWith(string13.toLowerCase(Locale.ROOT)) && !string13.equalsIgnoreCase(string14)) {
                        object = string14.substring(string13.length());
                    }
                }
            }
        }
        if (object != null && !((String)object).isEmpty()) {
            agc agc2 = this.aAt.eb();
            double d5 = d2 + (double)agc2.getStringWidth(string);
            int n7 = aip.d(Color.WHITE, (int)(120.0 * d4)).getRGB();
            agc2.a((String)object, d5, d3, n7);
        }
    }

    private void N(double d2) {
        int n2 = aip.d(Color.WHITE, (int)(155.0 * d2)).getRGB();
        String string = this.aS(this.aAt.getText());
        String string2 = (string.isEmpty() ? new String[]{} : string.split("\\s+")).length >= 2 ? (this.aAC ? ahd.ce("ui.command.palette.hint.arguments") : ahd.ce("ui.command.palette.hint.commands")) : (this.aAC ? ahd.ce("ui.command.palette.hint.arguments") : ahd.ce("ui.command.palette.hint.commands"));
        double d3 = this.aAF + -0.5 + 8.0;
        double d4 = this.aAG + -0.5 + this.aAJ + 3.0;
        aAr.a(string2, d3, d4, n2);
    }

    private void a(int n2, int n3, double d2) {
        RenderUtil.roundedRectangle(this.aAK, this.aAL, this.aAM, this.aAN, 8.0, aip.d(Color.BLACK, (int)(45.0 * d2)));
        double d3 = this.aAK + 6.0;
        double d4 = this.aAM - 12.0;
        double d5 = this.aAN - 8.0;
        int n4 = this.qR();
        double d6 = Math.max(0.0, (double)n4 * 30.0 - 2.0);
        double d7 = Math.max(0.0, d6 - d5);
        this.aAv.V(-d7);
        this.aAv.qx();
        RenderUtil.g(this.aAK, this.aAL, this.aAM, this.aAN);
        double d8 = this.aAL + 5.0 + this.aAv.tE();
        int n5 = this.j(n2, n3);
        for (int i2 = 0; i2 < n4; ++i2) {
            double d9 = d8 + (double)i2 * 30.0;
            if (d9 + 28.0 < this.aAL || d9 > this.aAL + this.aAN) continue;
            boolean bl = i2 == this.aAP;
            boolean bl2 = i2 == n5;
            double d10 = 1.0;
            if (n4 > 1) {
                double d11 = (double)i2 / (double)(n4 - 1);
                d10 = 1.0 - d11 * 0.35;
            }
            int n6 = bl ? 95 : (bl2 ? 60 : 38);
            int n7 = (int)((double)n6 * d10);
            RenderUtil.roundedRectangle(d3, d9, d4, 28.0, 6.0, aip.d(Color.WHITE, (int)((double)n7 * d2)));
            if (this.aAC) {
                acy acy2 = this.aAB.get(i2);
                this.a(acy2, d3 + 8.0, d9 + 5.0, d4 - 16.0, d2);
                continue;
            }
            int n8 = this.qV();
            int n9 = this.qW();
            if (n8 != -1 && i2 == n8) {
                Color color = aip.d(this.rz().rA(), (int)(85.0 * d2));
                Color color2 = aip.d(this.rz().rB(), (int)(55.0 * d2));
                RenderUtil.roundedOutlineGradientRectangle(d3, d9, d4, 28.0, 6.0, 1.0, color, color2);
                this.a(this.aAR, this.aAS, d3 + 8.0, d9 + 5.0, d4 - 16.0, d2);
                continue;
            }
            if (n9 != -1 && i2 == n9) {
                this.a(this.aAQ, d3 + 8.0, d9 + 5.0, d4 - 16.0, d2);
                continue;
            }
            int n10 = this.ag(i2);
            if (n10 < 0 || n10 >= this.aAz.size()) continue;
            acr acr2 = this.aAz.get(n10);
            this.a(acr2, d3 + 8.0, d9 + 5.0, d4 - 16.0, d2);
        }
        if (n4 == 0) {
            agc agc2 = gb.MAIN.a(15, gd.REGULAR);
            String string = this.rd();
            agc2.c(string, this.aAK + this.aAM / 2.0, this.aAL + this.aAN / 2.0 - (double)agc2.height() / 2.0, aip.d(Color.WHITE, (int)(180.0 * d2)).getRGB());
        }
        RenderUtil.vJ();
        this.aAv.a(new Vector2d(this.aAK + this.aAM - 4.0, this.aAL + 6.0), this.aAN - 12.0);
    }

    private void a(acr acr2, double d2, double d3, double d4, double d5) {
        double d6 = d3 + (28.0 - (double)aAp.height()) / 2.0;
        int n2 = aip.d(Color.WHITE, (int)(255.0 * d5)).getRGB();
        String string = "." + acr2.aBk;
        aAp.a(string, d2, d6, n2);
        double d7 = d2 + (double)aAp.getStringWidth(string) + 10.0;
        double d8 = d6 + (double)aAp.height() - (double)aAq.height() - 1.0;
        StringBuilder stringBuilder = new StringBuilder();
        if (acr2.aBm != null && !acr2.aBm.isEmpty()) {
            stringBuilder.append(acr2.aBm);
        }
        if (acr2.aBo != null && !acr2.aBo.isEmpty()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("  ");
            }
            stringBuilder.append(acr2.aBo);
        }
        if (stringBuilder.length() > 0) {
            int n3 = aip.d(Color.WHITE, (int)(205.0 * d5)).getRGB();
            aAq.a(stringBuilder.toString(), d7, d8, n3);
            d7 += (double)aAq.getStringWidth(stringBuilder.toString());
        }
        if (!acr2.aBp.isEmpty()) {
            if (stringBuilder.length() > 0) {
                d7 += (double)aAq.getStringWidth("  ");
            }
            int n4 = aip.d(Color.WHITE, (int)(155.0 * d5)).getRGB();
            aAq.a(acr2.aBp, d7, d8, n4);
        }
    }

    private void a(acy acy2, double d2, double d3, double d4, double d5) {
        double d6 = d3 + (28.0 - (double)aAp.height()) / 2.0;
        int n2 = aip.d(Color.WHITE, (int)(250.0 * d5)).getRGB();
        String string = acy2.aBz;
        aAp.a(string, d2, d6, n2);
        double d7 = d2 + (double)aAp.getStringWidth(string) + 10.0;
        double d8 = d6 + (double)aAp.height() - (double)aAq.height();
        if (!acy2.aBA.isEmpty()) {
            int n3 = aip.d(Color.WHITE, (int)(220.0 * d5)).getRGB();
            aAq.a(acy2.aBA, d7, d8, n3);
            d7 += (double)aAq.getStringWidth(acy2.aBA);
        }
        if (!acy2.aBB.isEmpty()) {
            if (!acy2.aBA.isEmpty()) {
                d7 += (double)aAq.getStringWidth("  ");
            }
            int n4 = aip.d(Color.WHITE, (int)(155.0 * d5)).getRGB();
            aAq.a(acy2.aBB, d7, d8, n4);
        }
    }

    private void O(double d2) {
        if (!this.statusMessage.isEmpty() && !this.aAx.T(3000L)) {
            double d3 = 1.0 - (double)this.aAx.aKx() / 3000.0;
            double d4 = Math.max(0.0, Math.min(1.0, d3));
            int n2 = (int)((double)this.statusColor.getAlpha() * d4);
            agc agc2 = gb.MAIN.a(13, gd.MEDIUM);
            agc2.a(this.statusMessage, this.aAF + -0.5, this.aAG + this.aAI - -0.5 - (double)agc2.height() + 4.0, aip.d(this.statusColor, n2).getRGB());
        }
    }

    private void qK() {
        String string = this.aAt.getText();
        if (string == null) {
            string = "";
        }
        if (string.equals(this.aAO)) {
            return;
        }
        this.aAO = string;
        String string2 = this.aS(string);
        String string3 = string2.toLowerCase(Locale.ROOT);
        ArrayList<acr> arrayList = new ArrayList<acr>();
        if (string3.isEmpty()) {
            arrayList.addAll(this.aAy);
            arrayList.sort((acr2, acr3) -> {
                long l2;
                long l3 = acl.aR(acr2.aBk);
                if (l3 != (l2 = acl.aR(acr3.aBk))) {
                    return Long.compare(l2, l3);
                }
                return acr2.aBk.compareToIgnoreCase(acr3.aBk);
            });
        } else {
            for (acr acr4 : this.aAy) {
                double d2 = acr4.aU(string3);
                if (!(d2 > 0.0)) continue;
                acr4.aBq = d2;
                arrayList.add(acr4);
            }
            arrayList.sort((acr2, acr3) -> {
                long l2;
                int n2 = Double.compare(acr3.aBq, acr2.aBq);
                if (n2 != 0) {
                    return n2;
                }
                long l3 = acl.aR(acr2.aBk);
                if (l3 != (l2 = acl.aR(acr3.aBk))) {
                    return Long.compare(l2, l3);
                }
                return acr2.aBk.compareToIgnoreCase(acr3.aBk);
            });
        }
        this.aAz = arrayList;
        this.aK(string2);
        this.qQ();
    }

    private void qL() {
        this.aAO = null;
        this.qK();
    }

    private void aa(int n2) {
        int n3 = this.qR();
        if (n3 == 0) {
            return;
        }
        this.aAP = Math.max(0, Math.min(n3 - 1, this.aAP + n2));
        this.qM();
    }

    private void qM() {
        if (this.qR() == 0) {
            return;
        }
        double d2 = this.aAL + 6.0;
        double d3 = this.aAL + this.aAN - 6.0;
        double d4 = this.aAL + 6.0 + this.aAv.tE() + (double)this.aAP * 30.0;
        double d5 = d4 + 28.0;
        if (d4 < d2) {
            this.aAv.U(Math.min(0.0, this.aAv.tD() + (d2 - d4)));
            return;
        }
        if (!(d5 > d3)) return;
        this.aAv.U(Math.max(this.aAv.tF(), this.aAv.tD() - (d5 - d3)));
    }

    private void qN() {
        if (this.aAC) {
            return;
        }
        int n2 = this.qV();
        int n3 = this.qW();
        if (n2 != -1 && this.aAP == n2) {
            this.qX();
            return;
        }
        if (n3 != -1 && this.aAP == n3) {
            this.ra();
            return;
        }
        if (this.aAz.isEmpty()) {
            return;
        }
        int n4 = this.ag(this.aAP);
        if (n4 < 0 || n4 >= this.aAz.size()) {
            return;
        }
        String string = "." + this.aAz.get(n4).aBk + " ";
        this.aAt.bW(string);
        this.aAt.ar(string.length());
        this.qL();
    }

    private void qO() {
        String string = this.aAt.getText().trim();
        if (string.isEmpty()) {
            return;
        }
        u u2 = Client.a.getCommandManager().a(string, false);
        if (u2 == u.EXECUTED) {
            aEg.displayGuiScreen(this.aAs);
            return;
        }
        if (u2 != u.UNKNOWN) return;
        this.a(ahd.ce("command.unknown"), new Color(255, 90, 90));
    }

    private boolean ab(int n2) {
        p p2 = this.qP();
        if (p2 == null) {
            return false;
        }
        if (n2 == 0) {
            return false;
        }
        int n3 = n2 == 1 ? 0 : n2;
        this.a(p2, n3);
        return true;
    }

    private boolean ac(int n2) {
        p p2 = this.qP();
        if (p2 == null) {
            return false;
        }
        this.a(p2, n2 - 100);
        return true;
    }

    private void a(p p2, int n2) {
        String[] stringArray = p2.getAliases();
        if (stringArray == null || stringArray.length == 0) {
            this.a(ahd.ce("command.bind.invalidmodule"), new Color(255, 90, 90));
            return;
        }
        String string = ".bind " + stringArray[0].replace(" ", "") + " " + Bind.c(n2);
        u u2 = Client.a.getCommandManager().a(string, false);
        if (u2 == u.EXECUTED) {
            aEg.displayGuiScreen(this.aAs);
            return;
        }
        if (u2 != u.UNKNOWN) return;
        this.a(ahd.ce("command.unknown"), new Color(255, 90, 90));
    }

    private p qP() {
        if (!this.aAD || this.aAE == null) {
            return null;
        }
        if (!this.aT(this.aAE.rj())) {
            return null;
        }
        String[] stringArray = this.aAE.rk();
        if (stringArray.length == 0) {
            return null;
        }
        String string = stringArray[0] == null ? "" : stringArray[0].trim();
        if (string.isEmpty()) {
            return null;
        }
        if (stringArray.length >= 2 && !(stringArray[1] == null ? "" : stringArray[1].trim()).isEmpty()) {
            return null;
        }
        return Client.a.t().a(string);
    }

    private void a(acr acr2) {
        String string = "." + acr2.aBk;
        if (Client.a.getCommandManager().a(string, false) == u.EXECUTED) {
            aEg.displayGuiScreen(this.aAs);
            return;
        }
        this.a(ahd.ce("command.unknown"), new Color(255, 90, 90));
    }

    private void aK(String string) {
        List<acy> list;
        this.aAB = Collections.emptyList();
        this.aAC = false;
        this.aAD = false;
        this.aAE = null;
        String string2 = this.aAt.getText();
        if (string2 == null) {
            string2 = "";
        }
        if (string2.isEmpty()) {
            this.qQ();
            return;
        }
        String string3 = string2;
        char c2 = this.aP(string2);
        if (c2 != '\u0000' && string2.startsWith(String.valueOf(c2))) {
            string3 = string2.substring(1);
        }
        boolean bl = string3.endsWith(" ");
        String string4 = string3.trim();
        if (string4.isEmpty()) {
            this.qQ();
            return;
        }
        String[] stringArray = string4.split("\\s+");
        if (stringArray.length == 0) {
            this.qQ();
            return;
        }
        String string5 = stringArray[0];
        ada ada2 = this.aAA.get(string5.toLowerCase(Locale.ROOT));
        if (ada2 == null) {
            this.qQ();
            return;
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        if (stringArray.length == 1) {
            arrayList.add(stringArray[0].length() == string4.length() ? "" : string4.substring(stringArray[0].length()).trim());
        } else {
            arrayList.addAll(Arrays.asList(stringArray).subList(1, stringArray.length));
            if (bl) {
                arrayList.add("");
            }
        }
        String[] stringArray2 = arrayList.toArray(new String[0]);
        acz acz2 = new acz(string5, stringArray2, string4);
        this.aAD = true;
        this.aAE = acz2;
        try {
            ada2.a(acz2);
        }
        catch (Throwable throwable) {}
        this.aAB = (list = ada2.b(acz2)) == null ? Collections.emptyList() : list;
        this.aAC = !this.aAB.isEmpty();
        this.qQ();
    }

    private void qQ() {
        int n2 = this.qR();
        if (n2 <= 0) {
            this.aAP = 0;
            this.aAv.U(0.0);
            return;
        }
        this.aAP = Math.max(0, Math.min(this.aAP, n2 - 1));
    }

    private int qR() {
        if (this.aAC) {
            return this.aAB.size();
        }
        int n2 = 0;
        if (this.aAR != null) {
            ++n2;
        }
        if (this.aAT && this.aAQ != null) {
            ++n2;
        }
        return this.aAz.size() + n2;
    }

    private void qS() {
        if (this.aAC) {
            return;
        }
        String string = this.aS(this.aAt.getText());
        boolean bl = string == null || string.isEmpty();
        if (!bl) {
            if (this.aAX && this.aAW && !this.aAV && this.aAU != null) {
                try {
                    afj.sJ().bI(this.aAU);
                }
                catch (Throwable throwable) {}
            }
            this.aAW = false;
            this.aAV = false;
            this.aAX = false;
            this.aAY = 0L;
            this.aAR = null;
            this.aAS = null;
            this.aAU = null;
            return;
        }
        this.aAX = true;
        try {
            afj afj2 = afj.sJ();
            long l2 = System.currentTimeMillis();
            long l3 = afj2.sQ();
            boolean bl2 = l3 > 0L && l2 - l3 <= 60000L;
            if (this.aAW && this.aAR != null && this.aAU != null && !this.aAV && !bl2 && l2 - this.aAZ < 1000L) {
                return;
            }
            this.aAR = null;
            this.aAS = null;
            this.aAU = null;
            if (bl2) {
                String string2 = this.aM(afj2.sR());
                String string3 = "serverJoin.configLoad" + (string2 == null ? "" : ":" + string2.toLowerCase(Locale.ROOT));
                String string4 = afj2.sN();
                long l5 = afj2.sP();
                boolean bl3 = string2 != null && string4 != null && string2.equalsIgnoreCase(string4) && l5 > 0L && l5 >= l3;
                if (!bl3 && afj2.bF(string3)) {
                    this.aAU = string3;
                    String string5 = this.aL("config");
                    this.aAR = string2 == null ? string5 + " load " : string5 + " load " + string2;
                    this.aAS = "ui.command.palette.suggested.reason.serverJoin";
                    afj2.bG(string3);
                    this.aAW = true;
                    this.aAZ = l2;
                    return;
                }
            }
            boolean bl4 = afj2.c("cmd:bind", 30000L);
            boolean bl5 = afj2.c("cmd:toggle", 30000L);
            boolean bl6 = afj2.c("cmd:module", 30000L);
            boolean bl7 = afj2.c("cmd:friend", 30000L);
            String string6 = afj2.sN();
            String string7 = afj2.sO();
            long l6 = afj2.sP();
            block36: {
                if (string6 == null || string6.trim().isEmpty() || string7 == null || string7.trim().isEmpty() || "latest".equalsIgnoreCase(string6.trim())) break block36;
                if (l6 > 0L && System.currentTimeMillis() - l6 < 7500L) break block36;
                String string8 = acl.a(ConfigFile.b(false, false));
                boolean bl8 = string8 != null && !string8.equals(string7);
                if (bl8) {
                    if (this.aAY == 0L) {
                        this.aAY = System.currentTimeMillis();
                    }
                } else {
                    this.aAY = 0L;
                }
                if (!bl8) break block36;
                String string9 = "config.save.dirty:" + string6.trim().toLowerCase(Locale.ROOT);
                if (!afj2.bF(string9)) break block36;
                this.aAU = string9;
                this.aAR = this.aL("config") + " save " + string6.trim();
                this.aAS = "ui.command.palette.suggested.reason.dirtyConfig";
                afj2.bG(string9);
                this.aAW = true;
                this.aAZ = l2;
                return;
            }
            block37: {
                try {
                    long l7 = afj2.sT();
                    int n2 = afj2.sU();
                    if (l7 < 180000L || n2 < 6 || string6 == null || string6.trim().isEmpty() || string7 == null || string7.trim().isEmpty() || "latest".equalsIgnoreCase(string6.trim())) break block37;
                    String string10 = acl.a(ConfigFile.b(false, false));
                    boolean bl9 = string10 != null && !string10.equals(string7);
                    if (!bl9) break block37;
                    String string11 = "config.save.big:" + string6.trim().toLowerCase(Locale.ROOT);
                    if (!afj2.bF(string11)) break block37;
                    this.aAU = string11;
                    this.aAR = this.aL("config") + " save " + string6.trim();
                    this.aAS = "ui.command.palette.suggested.reason.dirtyConfig";
                    afj2.bG(string11);
                    this.aAW = true;
                    this.aAZ = l2;
                    return;
                }
                catch (Throwable throwable) {}
            }
            if (bl4) {
                List<acm> list = this.ad(6);
                for (acm acm2 : list) {
                    String string12 = "bind.unbound:" + acm2.aBc;
                    if (!afj2.bF(string12)) continue;
                    this.aAU = string12;
                    this.aAR = this.aL("bind") + " " + acm2.aBb;
                    this.aAS = "ui.command.palette.suggested.reason.bindUnboundFrequent";
                    afj2.bG(string12);
                    this.aAW = true;
                    this.aAZ = l2;
                    return;
                }
            }
            if (bl5) {
                List<acu> list2 = this.ae(6);
                for (acu acu2 : list2) {
                    String string13 = "toggle.recent:" + acu2.aBu;
                    if (!afj2.bF(string13)) continue;
                    this.aAU = string13;
                    this.aAR = this.aL("toggle") + " " + acu2.aBt;
                    this.aAS = "ui.command.palette.suggested.reason.toggleRecent";
                    afj2.bG(string13);
                    this.aAW = true;
                    this.aAZ = l2;
                    return;
                }
            }
            if (bl6) {
                List<acu> list3 = this.af(6);
                for (acu acu3 : list3) {
                    String string14 = "module.recent:" + acu3.aBu;
                    if (!afj2.bF(string14)) continue;
                    this.aAU = string14;
                    this.aAR = this.aL("module") + " " + acu3.aBt;
                    this.aAS = "ui.command.palette.suggested.reason.moduleRecent";
                    afj2.bG(string14);
                    this.aAW = true;
                    this.aAZ = l2;
                    return;
                }
            }
            if (bl7) {
                String string15 = "friend.recent";
                if (afj2.bF(string15)) {
                    this.aAU = string15;
                    this.aAR = this.aL("friend") + " ";
                    this.aAS = "ui.command.palette.suggested.reason.friendRecent";
                    afj2.bG(string15);
                    this.aAW = true;
                    this.aAZ = l2;
                    return;
                }
            }
            if (afj2.c("cmd:config", 30000L)) {
                String string16 = this.qT();
                if (string16 != null && (l6 == 0L || System.currentTimeMillis() - l6 > 120000L)) {
                    String string17 = "config.load.mostUsed";
                    if (afj2.bF(string17)) {
                        this.aAU = string17;
                        String string18 = this.aL("config");
                        this.aAR = string18 + string16.substring(".config".length());
                        this.aAS = "ui.command.palette.suggested.reason.mostUsedConfig";
                        afj2.bG(string17);
                        this.aAW = true;
                        this.aAZ = l2;
                        return;
                    }
                }
            }
            String string19 = this.qZ();
            if (string19 != null && !string19.isEmpty()) {
                String string20 = "cmd.mostUsed";
                if (afj2.bF(string20)) {
                    this.aAU = string20;
                    this.aAR = "." + string19;
                    this.aAS = "ui.command.palette.suggested.reason.mostUsed";
                    afj2.bG(string20);
                    this.aAW = true;
                    this.aAZ = l2;
                }
            }
            if (this.aAR == null) {
                if (string19 != null && !string19.isEmpty()) {
                    this.aAU = "cmd.mostUsed";
                    this.aAR = "." + string19;
                    this.aAS = "ui.command.palette.suggested.reason.mostUsed";
                    this.aAW = true;
                    this.aAZ = l2;
                } else if (!this.aAz.isEmpty()) {
                    this.aAU = "cmd.topResult";
                    this.aAR = "." + this.aAz.get(0).aBk;
                    this.aAS = "ui.command.palette.suggested.reason.mostUsed";
                    this.aAW = true;
                    this.aAZ = l2;
                }
            }
        }
        catch (Throwable throwable) {
            this.aAR = null;
            this.aAS = null;
            this.aAU = null;
        }
    }

    private String aL(String string) {
        try {
            if (string == null || string.isEmpty()) {
                return ".";
            }
            Object t2 = Client.a.getCommandManager().get(string);
            if (t2 == null) {
                return "." + string;
            }
            String[] stringArray = ((Command)t2).getExpressions();
            String string2 = afj.sJ().a(string, stringArray);
            if (string2 != null && !string2.trim().isEmpty()) return "." + string2.trim();
            string2 = string;
            return "." + string2.trim();
        }
        catch (Throwable throwable) {
            String string3;
            if (string == null) {
                string3 = "";
                return "." + string3;
            }
            string3 = string;
            return "." + string3;
        }
    }

    private String aM(String string) {
        try {
            String string2;
            string2 = string == null ? "" : string.trim().toLowerCase(Locale.ROOT);
            if (string2.isEmpty()) {
                return null;
            }
            int n2 = string2.indexOf(58);
            if (n2 > 0) {
                string2 = string2.substring(0, n2);
            }
            if (string2.isEmpty()) {
                return null;
            }
            String[] stringArray = this.aN(string2);
            if (stringArray.length == 0) {
                return null;
            }
            String string4 = null;
            int n3 = -1;
            long l2 = -1L;
            for (ConfigFile configFile : Client.a.p()) {
                long l3;
                int n4;
                String string5;
                String[] stringArray2;
                String string6;
                if (configFile == null || configFile.getName() == null || (string6 = configFile.getName().trim()).isEmpty() || "latest".equalsIgnoreCase(string6) || (stringArray2 = this.aN(string5 = string6.toLowerCase(Locale.ROOT))).length == 0 || (n4 = this.a(stringArray, stringArray2, string5)) < 2 || (l3 = afj.sJ().bz("config.load:" + string5)) <= l2 && (l3 != l2 || n4 <= n3)) continue;
                l2 = l3;
                n3 = n4;
                string4 = string6;
            }
            return string4;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private String[] aN(String string) {
        if (string == null) {
            return new String[0];
        }
        String string2 = string.replace("https://", "").replace("http://", "").replace("www.", "");
        String string3 = string2.replaceAll("[^a-z0-9]+", " ");
        String string4 = string3.trim();
        if (string4.isEmpty()) {
            return new String[0];
        }
        String[] stringArray = string4.split("\\s+");
        ArrayList<String> arrayList = new ArrayList<String>();
        String[] stringArray2 = stringArray;
        int n2 = stringArray2.length;
        int n3 = 0;
        while (n3 < n2) {
            String string5 = stringArray2[n3];
            if (!(string5 == null || string5.length() < 3 || string5.equals("play") || string5.equals("mc") || string5.equals("server") || string5.equals("net") || string5.equals("com") || string5.equals("org"))) {
                arrayList.add(string5);
            }
            ++n3;
        }
        return arrayList.toArray(new String[0]);
    }

    private int a(String[] stringArray, String[] stringArray2, String string) {
        int n2 = 0;
        String[] stringArray3 = stringArray;
        int n3 = stringArray3.length;
        int n4 = 0;
        block0: while (n4 < n3) {
            String string2 = stringArray3[n4];
            String[] stringArray4 = stringArray2;
            int n5 = stringArray4.length;
            int n6 = 0;
            while (true) {
                block9: {
                    block7: {
                        String string3;
                        block8: {
                            if (n6 >= n5) break block7;
                            string3 = stringArray4[n6];
                            if (!string2.equals(string3)) break block8;
                            n2 += 3;
                            break block7;
                        }
                        if (!string3.startsWith(string2) && !string2.startsWith(string3)) break block9;
                        n2 += 2;
                    }
                    if (string.contains(string2)) {
                        n2 += 2;
                    }
                    ++n4;
                    continue block0;
                }
                ++n6;
            }
        }
        return n2;
    }

    private List<acm> ad(int n2) {
        try {
            if (n2 <= 0) {
                return Collections.emptyList();
            }
            afj afj2 = afj.sJ();
            ArrayList<acm> arrayList = new ArrayList<acm>();
            for (Module module : Client.a.g().ef()) {
                String string;
                String string2;
                if (module == null || module.getKey() != 0 || module instanceof Interface) continue;
                String string3 = null;
                String string4 = null;
                long l2 = 0L;
                ArrayList<String> arrayList2 = new ArrayList<String>();
                try {
                    String[] stringArray = module.getAliases();
                    if (stringArray != null) {
                        for (String string5 : stringArray) {
                            String string6;
                            if (string5 == null || (string6 = string5.replace(" ", "").trim()).isEmpty()) continue;
                            arrayList2.add(string6);
                        }
                    }
                }
                catch (Throwable throwable) {}
                if ((string2 = module.getName()) != null && !(string = string2.replace(" ", "").trim()).isEmpty()) {
                    arrayList2.add(string);
                }
                HashSet<String> hashSet = new HashSet<String>();
                ArrayList<String> arrayList3 = new ArrayList<String>();
                for (String string7 : arrayList2) {
                    String string8 = string7.toLowerCase(Locale.ROOT);
                    if (!hashSet.add(string8)) continue;
                    arrayList3.add(string7);
                }
                Iterator iterator = arrayList3.iterator();
                while (iterator.hasNext()) {
                    long l3 = 0L;
                    String string9 = (String)iterator.next();
                    String string10 = string9.toLowerCase(Locale.ROOT);
                    long l4 = l3 + afj2.bz("bind.target:" + string10) * 3L;
                    long l5 = l4 + afj2.bz("arg:toggle:0:" + string10) * 2L;
                    long l6 = l5 + afj2.bz("arg:bind:0:" + string10);
                    if (l6 <= l2) continue;
                    l2 = l6;
                    string3 = string9;
                    string4 = string10;
                }
                if (string3 == null || string4 == null || l2 <= 0L) continue;
                arrayList.add(new acm(string3, string4, l2));
            }
            arrayList.sort((acm2, acm3) -> Long.compare(acm3.aBd, acm2.aBd));
            if (arrayList.size() > n2) {
                return new ArrayList<acm>(arrayList.subList(0, n2));
            }
            return arrayList;
        }
        catch (Throwable throwable) {
            return Collections.emptyList();
        }
    }

    private List<acu> ae(int n2) {
        return this.a("arg:toggle:0:", 2L, 1L, n2, true);
    }

    private List<acu> af(int n2) {
        return this.a("arg:module:0:", 1L, 0L, n2, false);
    }

    private List<acu> a(String string, long l2, long l3, int n2, boolean bl) {
        try {
            if (n2 <= 0) {
                return Collections.emptyList();
            }
            afj afj2 = afj.sJ();
            ArrayList<acu> arrayList = new ArrayList<acu>();
            Iterator<Module> iterator = Client.a.g().ef().iterator();
            while (true) {
                Iterator<String> iterator2;
                long l4;
                long l5;
                String string2;
                String string3;
                Module module;
                if (iterator.hasNext()) {
                    List<String> list;
                    module = iterator.next();
                    if (module == null || module instanceof Interface || (list = this.m(module)).isEmpty()) continue;
                    string3 = null;
                    string2 = null;
                    l5 = 0L;
                    l4 = 0L;
                    iterator2 = list.iterator();
                } else {
                    arrayList.sort((acu2, acu3) -> {
                        if (!bl) return Long.compare(acu3.aBv, acu2.aBv);
                        if (acu2.aBw == acu3.aBw) return Long.compare(acu3.aBv, acu2.aBv);
                        if (!acu2.aBw) return -1;
                        return 1;
                    });
                    if (arrayList.size() > n2) {
                        return new ArrayList<acu>(arrayList.subList(0, n2));
                    }
                    return arrayList;
                }
                while (iterator2.hasNext()) {
                    String string4 = iterator2.next();
                    String string5 = string4.toLowerCase(Locale.ROOT);
                    long l6 = afj2.bz(string + string5);
                    long l7 = l3 > 0L ? afj2.bz("arg:toggle:0:" + string5) : 0L;
                    long l8 = l6 * l2 + l7 * l3;
                    l4 += l8;
                    if (l8 <= l5) continue;
                    l5 = l8;
                    string3 = string4;
                    string2 = string5;
                }
                if (string3 == null || string2 == null || l4 <= 0L) continue;
                arrayList.add(new acu(string3, string2, l4, module.isEnabled()));
            }
        }
        catch (Throwable throwable) {
            return Collections.emptyList();
        }
    }

    private List<String> m(Module module) {
        String string;
        String string2;
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            String[] stringArray = module.getAliases();
            if (stringArray != null) {
                for (String string3 : stringArray) {
                    String string4;
                    if (string3 == null || (string4 = string3.replace(" ", "").trim()).isEmpty()) continue;
                    arrayList.add(string4);
                }
            }
        }
        catch (Throwable throwable) {}
        if ((string2 = module.getName()) != null && !(string = string2.replace(" ", "").trim()).isEmpty()) {
            arrayList.add(string);
        }
        HashSet<String> hashSet = new HashSet<String>();
        ArrayList<String> arrayList2 = new ArrayList<String>();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String string5 = (String)iterator.next();
            String string6 = string5.toLowerCase(Locale.ROOT);
            if (!hashSet.add(string6)) continue;
            arrayList2.add(string5);
        }
        return arrayList2;
    }

    private String qT() {
        try {
            List<String> list = afj.sJ().j("config.load:", 8);
            if (list == null || list.isEmpty()) {
                return null;
            }
            for (String string : list) {
                String string2 = this.r(string, "config.load:");
                if (string2 == null || string2.isEmpty() || "latest".equalsIgnoreCase(string2)) continue;
                for (ConfigFile configFile : Client.a.p()) {
                    if (configFile == null || configFile.getName() == null || "latest".equalsIgnoreCase(configFile.getName()) || !configFile.getName().equalsIgnoreCase(string2)) continue;
                    return ".config load " + configFile.getName();
                }
                return ".config load " + string2;
            }
            return null;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private String r(String string, String string2) {
        if (string == null || string2 == null) {
            return null;
        }
        if (!string.startsWith(string2)) {
            return null;
        }
        return string.substring(string2.length());
    }

    private static String a(JsonObject jsonObject) {
        try {
            if (jsonObject == null) {
                return null;
            }
            JsonObject jsonObject2 = jsonObject.deepCopy();
            jsonObject2.remove("Metadata");
            jsonObject2.remove("theme");
            return acl.aO(Client.a.A().toJson(jsonObject2));
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static String aO(String string) {
        if (string == null) {
            return null;
        }
        try {
            byte[] byArray = MessageDigest.getInstance("SHA-256").digest(string.getBytes(StandardCharsets.UTF_8));
            StringBuilder stringBuilder = new StringBuilder(byArray.length * 2);
            for (byte by2 : byArray) {
                stringBuilder.append(String.format("%02x", by2));
            }
            return stringBuilder.toString();
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private void qU() {
        if (this.aAC) {
            this.aAT = false;
            return;
        }
        String string = this.aS(this.aAt.getText());
        if (string != null && !string.isEmpty()) {
            this.aAT = false;
            return;
        }
        try {
            String[] stringArray;
            String string2 = afj.sJ().sM();
            if (string2 == null) {
                this.aAT = false;
                return;
            }
            Object object = string2.trim();
            if (((String)object).isEmpty()) {
                this.aAT = false;
                return;
            }
            String string3 = this.aS((String)object).toLowerCase(Locale.ROOT).trim();
            stringArray = string3.isEmpty() ? new String[]{} : string3.split("\\s+");
            if (stringArray.length >= 3 && "load".equalsIgnoreCase(stringArray[1]) && "latest".equalsIgnoreCase(stringArray[2])) {
                try {
                    Object t2 = Client.a.getCommandManager().get("config");
                    if (t2 != null) {
                        String string4 = stringArray[0];
                        for (String string5 : ((Command)t2).getExpressions()) {
                            if (string5 == null || !string5.trim().equalsIgnoreCase(string4)) continue;
                            this.aAT = false;
                            return;
                        }
                    }
                }
                catch (Throwable throwable) {

                }
            }
            if (!((String)object).startsWith(".") && !((String)object).startsWith("/")) {
                object = "." + (String)object;
            }
            this.aAQ = (String)object;
            this.aAT = true;
        }
        catch (Throwable throwable) {
            this.aAT = false;
        }
    }

    private int qV() {
        if (this.aAC) {
            return -1;
        }
        if (this.aAR != null) return 0;
        return -1;
    }

    private int qW() {
        if (this.aAC) {
            return -1;
        }
        if (!this.aAT) return -1;
        if (this.aAQ == null) {
            return -1;
        }
        if (this.qV() != -1) {
            return 1;
        }
        if (!this.aAz.isEmpty()) return 1;
        return 0;
    }

    private int ag(int n2) {
        int n3 = this.qV();
        if (n3 != -1 && n2 == n3) {
            return -1;
        }
        int n4 = this.qW();
        if (n4 == -1) {
            return n2;
        }
        if (n2 == n4) {
            return -1;
        }
        int n5 = 0;
        if (n3 != -1 && n2 > n3) {
            ++n5;
        }
        if (n4 != -1 && n2 > n4) {
            ++n5;
        }
        return n2 - n5;
    }

    private void qX() {
        if (this.aAR == null) {
            return;
        }
        if (this.aAU != null) {
            try {
                afj.sJ().bH(this.aAU);
            }
            catch (Throwable throwable) {}
        }
        this.aAV = true;
        Object object = this.aAR;
        if (!((String)object).endsWith(" ")) {
            object = (String)object + " ";
        }
        this.aAt.bW((String)object);
        this.aAt.ar(((String)object).length());
        this.qL();
    }

    private void qY() {
        if (this.aAR == null) {
            return;
        }
        if (this.aAU != null) {
            try {
                afj.sJ().bH(this.aAU);
            }
            catch (Throwable throwable) {}
        }
        this.aAV = true;
        if (Client.a.getCommandManager().a(this.aAR, false) == u.EXECUTED) {
            aEg.displayGuiScreen(this.aAs);
            return;
        }
        this.a(ahd.ce("command.unknown"), new Color(255, 90, 90));
    }

    private void a(String string, String string2, double d2, double d3, double d4, double d5) {
        String string3;
        if (string == null) {
            return;
        }
        double d6 = d3 + (28.0 - (double)aAp.height()) / 2.0;
        int n2 = aip.d(Color.WHITE, (int)(255.0 * d5)).getRGB();
        String string4 = ahd.ce("ui.command.palette.suggested.meta");
        int n3 = aip.d(Color.WHITE, (int)(175.0 * d5)).getRGB();
        double d7 = aAq.getStringWidth(string4);
        double d8 = d2 + Math.max(0.0, d4 - d7);
        double d9 = d6 + (double)aAp.height() - (double)aAq.height() - 1.0;
        aAq.a(string4, d8, d9, n3);
        string3 = string2 == null ? "" : ahd.ce(string2);
        if (string2 != null && string2.equals(string3)) {
            string3 = "";
        }
        double d10 = Math.max(0.0, d4 - d7 - 10.0);
        String string6 = this.a(aAp, string, d10);
        aAp.a(string6, d2, d6, n2);
        if (!string3.isEmpty()) {
            double d11 = d2 + (double)aAp.getStringWidth(string6) + 10.0;
            double d12 = Math.max(0.0, d8 - d11 - 10.0);
            String string7 = this.a(aAq, string3, d12);
            int n4 = aip.d(Color.WHITE, (int)(160.0 * d5)).getRGB();
            aAq.a(string7, d11, d9, n4);
        }
    }

    private String qZ() {
        try {
            String string = null;
            long l2 = 0L;
            for (acr acr2 : this.aAy) {
                long l3;
                if (acr2 == null || acr2.aBk == null || (l3 = acl.aR(acr2.aBk)) <= l2) continue;
                l2 = l3;
                string = acr2.aBk;
            }
            return string;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private void ra() {
        if (this.aAQ == null) {
            return;
        }
        Object object = this.aAQ;
        if (!((String)object).endsWith(" ")) {
            object = (String)object + " ";
        }
        this.aAt.bW((String)object);
        this.aAt.ar(((String)object).length());
        this.qL();
    }

    private void rb() {
        if (this.aAQ == null) {
            return;
        }
        if (Client.a.getCommandManager().a(this.aAQ, false) == u.EXECUTED) {
            aEg.displayGuiScreen(this.aAs);
            return;
        }
        this.a(ahd.ce("command.unknown"), new Color(255, 90, 90));
    }

    private void a(String string, double d2, double d3, double d4, double d5) {
        if (string == null) {
            return;
        }
        double d6 = d3 + (28.0 - (double)aAp.height()) / 2.0;
        int n2 = aip.d(Color.WHITE, (int)(255.0 * d5)).getRGB();
        String string2 = ahd.ce("ui.command.palette.previous.meta");
        int n3 = aip.d(Color.WHITE, (int)(165.0 * d5)).getRGB();
        double d7 = aAq.getStringWidth(string2);
        double d8 = d2 + Math.max(0.0, d4 - d7);
        double d9 = d6 + (double)aAp.height() - (double)aAq.height() - 1.0;
        aAq.a(string2, d8, d9, n3);
        double d10 = Math.max(0.0, d4 - d7 - 10.0);
        String string3 = this.a(aAp, string, d10);
        aAp.a(string3, d2, d6, n2);
    }

    private String a(agc agc2, String string, double d2) {
        if (string == null) {
            return "";
        }
        if (d2 <= 0.0) {
            return "";
        }
        if ((double)agc2.getStringWidth(string) <= d2) {
            return string;
        }
        String string2 = "\u2026";
        if ((double)agc2.getStringWidth(string2) > d2) {
            return "";
        }
        int n2 = 0;
        int n3 = string.length();
        while (n2 < n3) {
            int n4 = n2 + n3 + 1 >>> 1;
            String string3 = string.substring(0, n4) + string2;
            if ((double)agc2.getStringWidth(string3) <= d2) {
                n2 = n4;
                continue;
            }
            n3 = n4 - 1;
        }
        return string.substring(0, n2) + string2;
    }

    private void rc() {
        if (!this.aAC || this.aAB.isEmpty()) {
            return;
        }
        this.aAP = Math.max(0, Math.min(this.aAP, this.aAB.size() - 1));
        this.a(this.aAB.get(this.aAP));
    }

    private void a(acy acy2) {
        if (acy2 == null) {
            return;
        }
        this.a(acy2.aBD, acy2.aBC, acy2.aBE);
    }

    private void a(int n2, String string, boolean bl) {
        String string2 = this.aAt.getText();
        if (string2 == null) {
            string2 = "";
        }
        char c2 = this.aP(string2);
        String string3 = this.aS(string2);
        if (string3.isEmpty()) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(string3.split("\\s+")));
        while (arrayList.size() <= n2 + 1) {
            arrayList.add("");
        }
        arrayList.set(n2 + 1, string);
        ArrayList<String> arrayList2 = new ArrayList<String>();
        for (String string4 : arrayList) {
            if (string4 == null || string4.isEmpty()) continue;
            arrayList2.add(string4);
        }
        Object object = String.join((CharSequence)" ", arrayList2);
        if (c2 != '\u0000') {
            object = c2 + (String)object;
        }
        if (bl) {
            object = (String)object + " ";
        }
        this.aAt.bW((String)object);
        this.aAt.ar(((String)object).length());
        this.qL();
    }

    private char aP(String string) {
        if (string == null) {
            return '\u0000';
        }
        String string2 = string.trim();
        if (string2.startsWith(".")) {
            return '.';
        }
        if (string2.startsWith("/")) {
            return '/';
        }
        return '\u0000';
    }

    private void a(String string, Color color) {
        this.statusMessage = string;
        this.statusColor = color;
        this.aAx.aX();
    }

    static String aQ(String string) {
        if (string == null) {
            return "";
        }
        String string2 = string.trim();
        if (string2.isEmpty()) {
            return "";
        }
        try {
            String[] stringArray;
            Object t2 = Client.a.getCommandManager().get(string2);
            if (t2 != null && (stringArray = ((Command)t2).getExpressions()) != null && stringArray.length > 0 && stringArray[0] != null && !stringArray[0].trim().isEmpty()) {
                return stringArray[0].trim().toLowerCase(Locale.ROOT);
            }
            return string2.toLowerCase(Locale.ROOT);
        }
        catch (Throwable throwable) {
            return string2.toLowerCase(Locale.ROOT);
        }
    }

    private static long aR(String string) {
        if (string == null || string.trim().isEmpty()) {
            return 0L;
        }
        return afj.sJ().bz("cmd:" + string.trim().toLowerCase(Locale.ROOT));
    }

    static long b(String string, int n2, String string2) {
        if (string == null || string.isEmpty()) {
            return 0L;
        }
        if (n2 < 0) {
            return 0L;
        }
        if (string2 == null) {
            return 0L;
        }
        String string3 = string2.trim();
        if (string3.isEmpty()) {
            return 0L;
        }
        String string4 = string.toLowerCase(Locale.ROOT);
        String string5 = string3.toLowerCase(Locale.ROOT);
        return afj.sJ().bz("arg:" + string4 + ":" + n2 + ":" + string5);
    }

    private int j(int n2, int n3) {
        if (!aeb.isHovered(this.aAK, this.aAL, this.aAM, this.aAN, n2, n3)) {
            return -1;
        }
        int n4 = this.qR();
        if (n4 == 0) {
            return -1;
        }
        double d2 = this.aAL + 6.0 + this.aAv.tE();
        for (int i2 = 0; i2 < n4; ++i2) {
            double d3 = d2 + (double)i2 * 30.0;
            if (!((double)n3 >= d3) || !((double)n3 <= d3 + 28.0)) continue;
            return i2;
        }
        return -1;
    }

    private String aS(String string) {
        if (string == null) {
            return "";
        }
        String string2 = string.trim();
        if (string2.startsWith(".") || string2.startsWith("/")) {
            string2 = string2.substring(1);
        }
        return string2;
    }

    private String rd() {
        if (!this.aAD || this.aAE == null) {
            return ahd.ce("ui.command.palette.empty");
        }
        String string = this.aAE.rj().toLowerCase(Locale.ROOT);
        String[] stringArray = this.aAE.rk();
        if ((string.equals("spotify") || string.equals("music")) && stringArray.length >= 1 && !stringArray[0].isEmpty()) {
            return "Paste in the respective ID from the API dashboard";
        }
        if ((string.equals("bind") || string.equals("binds") || string.equals("keybind") || string.equals("b")) && this.qP() != null) {
            return "In game, press any key or mouse button to bind, or Escape for NONE";
        }
        if ((string.equals("clip") || string.equals("vclip") || string.equals("hclip")) && stringArray.length >= 1 && !stringArray[0].isEmpty()) {
            return "Type a number distance and press, Enter to clip";
        }
        return ahd.ce("ui.command.palette.empty");
    }

    private void re() {
        acn acn2 = new acn();
        this.a(acn2, "bind", "binds", "keybind", "b");
        acq acq2 = new acq();
        this.a(acq2, "config", "configs", "cfg", "settings", "c");
        acs acs2 = new acs();
        this.a(acs2, "friend", "setfriend", "f");
        adb adb2 = new adb();
        this.a(adb2, "target", "settarget");
        adc adc2 = new adc();
        this.a(adc2, "toggle", "t");
        acw acw2 = new acw();
        this.a(acw2, "script", "scripts", "js");
        acx acx2 = new acx();
        this.a(acx2, "spotify", "music");
        act act2 = new act();
        this.a(act2, "insults", "killinsults", "insult");
        acp acp2 = new acp();
        this.a(acp2, "clip", "vclip", "hclip");
        acv acv2 = new acv();
        this.a(acv2, "module", "modules");
    }

    private void a(ada ada2, String ... stringArray) {
        for (String string : stringArray) {
            this.aAA.put(string.toLowerCase(Locale.ROOT), ada2);
        }
    }

    private boolean aT(String string) {
        if (string == null) {
            return false;
        }
        String string2 = string.trim().toLowerCase(Locale.ROOT);
        if (string2.equals("bind")) return true;
        if (string2.equals("binds")) return true;
        if (string2.equals("keybind")) return true;
        if (!string2.equals("b")) return false;
        return true;
    }
}
