package com.alan.clients.module.impl.render;

import com.alan.clients.Client;
import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.other.ModuleToggleEvent;
import com.alan.clients.newevent.impl.other.ServerJoinEvent;
import com.alan.clients.newevent.impl.other.WorldChangeEvent;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.Value;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.NumberValue;
import com.alan.clients.ui.theme.Themes;
import hackclient.rise.agc;
import com.alan.clients.util.math.MathUtil;
import hackclient.rise.cg;
import hackclient.rise.gb;
import hackclient.rise.gd;
import hackclient.rise.value.xg;
import hackclient.rise.value.xh;
import hackclient.rise.value.xi;
import hackclient.rise.zc;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Generated;
import rip.vantage.commons.util.time.a;

@ModuleInfo(aliases = "module.render.interface.name", description = "module.render.interface.description", category = Category.RENDER, autoEnabled = true)
public final class Interface extends Module {
    private final ModeValue anX = new xg(this, "Mode", this);
    private final ModeValue anY = new xh(this, "Modules to Show", this);
    public BooleanValue suffix = new BooleanValue("Suffix", this, true);
    public BooleanValue lowercase = new BooleanValue("Lowercase", this, false);
    public BooleanValue removeSpaces = new BooleanValue("Remove Spaces", this, false);
    public BooleanValue aoc = new BooleanValue("Shaders", this, false);
    public BooleanValue toggleNotifications = new BooleanValue("Toggle Notifications", this, false);
    private final NumberValue blurRadius = new NumberValue("Blur Radius", this, 12, 1, 30, 1);
    private final NumberValue blurCompression = new NumberValue("Blur Compression", this, 3.0, 1.0, 10.0, 0.1);
    private final NumberValue bloomRadius = new NumberValue("Bloom Radius", this, 14, 1, 30, 1);
    private final NumberValue bloomCompression = new NumberValue("Bloom Compression", this, 2.0, 1.0, 10.0, 0.1);
    private final NumberValue backgroundAlpha = new NumberValue("Background Alpha", this, 110, 0, 255, 1);
    private final NumberValue roundingRadius = new NumberValue("Rounding Radius", this, 5, 0, 20, 0.5);
    private List<zc> aok = new ArrayList<>();
    private List<zc> aol = new ArrayList<>();
    private ModeValue aom = new xi(this, "Information Type", this);
    private final a aon = new a();
    private final a aoo = new a();
    public agc aop = gb.MAIN.a(20, gd.MEDIUM);
    public float aoq = 12.0F;
    public float aor;
    @EventLink
    public final Listener<WorldChangeEvent> onWorldChange = var1 -> this.lv();
    @EventLink
    public final Listener<ServerJoinEvent> onServerJoin = var1 -> this.lv();
    @EventLink
    public final Listener<ModuleToggleEvent> onModuleToggle = var1 -> {
        if (this.toggleNotifications.wo()) {
            cg.a("Toggled", "Toggled " + var1.getModule().getName() + " " + (var1.getModule().isEnabled() ? "on" : "off"), 900);
        }
    };
    a aov = new a();
    @EventLink
    public final Listener<PreUpdateEvent> onPreUpdate = var1 -> aMR.execute(() -> {
        Themes.c(new Color(0, 0, 0, this.aoc.wo() ? this.lC() : 150));
        if (this.aov.T(15000L)) {
            this.lx();
            this.aov.aX();
        }

        this.aoo.aX();

        for (zc zc : this.aol) {
            if (zc.ath != 0.0F) {
                for (Value value : zc.dl().getValues()) {
                    if (value instanceof ModeValue) {
                        String s = ((ModeValue)value).wo().getName();
                        if ("Bloxd".equalsIgnoreCase(s)) {
                            zc.an("Blocks");
                        } else {
                            zc.an(s);
                        }
                        break;
                    }

                    zc.an("");
                }
            }
        }

        this.createArrayList();
    });
    @EventLink
    public final Listener<Render2DEvent> onRender2D = var1 -> {
        for (zc zcx : this.aok) {
            float f = this.anX.wo().getName().equals("Classic") ? 10.0F : 100.0F;
            if (zcx.dl().isEnabled()) {
                zcx.ath = Math.min(zcx.ath + (float)this.aon.aKx() / f, 10.0F);
            } else {
                zcx.ath = Math.max(zcx.ath - (float)this.aon.aKx() / f, 0.0F);
            }
        }

        float f1 = var1.getScaledResolution().getScaledWidth();
        Vector2f vector2f = new Vector2f(0.0F, 0.0F);

        for (zc zc : this.aol) {
            if (zc.ath != 0.0F) {
                zc.atg = new Vector2d(f1 - zc.nu() - zc.nv(), vector2f.getY());
                if (!zc.dl().isEnabled() && zc.ath < 10.0F) {
                    zc.atg = new Vector2d(f1 + zc.nu() + zc.nv(), vector2f.getY());
                } else {
                    vector2f.setY(vector2f.getY() + this.aoq);
                }

                float f2 = this.aor;
                float f3 = this.aor;
                zc.atg.x -= f2;
                zc.atg.y += f3;
                if (!(Math.abs(zc.nr().getX() - zc.atg.x) > 0.5) && !(Math.abs(zc.nr().getY() - zc.atg.y) > 0.5) && (zc.ath == 0.0F || zc.ath == 10.0F)) {
                    zc.apP = zc.atg;
                } else {
                    zc.apP.x = MathUtil.m(zc.apP.x, zc.atg.x, 0.015F * (float)this.aon.aKx());
                    zc.apP.y = MathUtil.m(zc.apP.y, zc.atg.y, 0.015F * (float)this.aon.aKx());
                }
            }
        }

        this.aon.aX();
    };

    public Interface() {
        this.lv();
    }

    public void lv() {
        this.aok.clear();
        Client.a
            .g()
            .ef()
            .stream()
            .sorted(Comparator.comparingDouble(var1 -> -this.aop.getStringWidth(var1.getName())))
            .forEach(var1 -> this.aok.add(new zc(var1)));
        this.lx();
    }

    public void createArrayList() {
        this.aol = this.aok
            .stream()
            .filter(var1 -> var1.a(this))
            .sorted(Comparator.comparingDouble(var0 -> -var0.nu() - var0.nv()))
            .collect(Collectors.toCollection(ArrayList::new));
    }

    public void lx() {
        for (zc zc : this.aok) {
            zc.ao(zc.dl().getName());
        }
    }

    public int ly() {
        return this.blurRadius.wo().intValue();
    }

    public float lz() {
        return this.blurCompression.wo().floatValue();
    }

    public int lA() {
        return this.bloomRadius.wo().intValue();
    }

    public float lB() {
        return this.bloomCompression.wo().floatValue();
    }

    public int lC() {
        return this.backgroundAlpha.wo().intValue();
    }

    public double lD() {
        return this.roundingRadius.wo().doubleValue();
    }

    @Generated
    public ModeValue hl() {
        return this.anX;
    }

    @Generated
    public ModeValue lE() {
        return this.anY;
    }

    @Generated
    public BooleanValue lF() {
        return this.suffix;
    }

    @Generated
    public BooleanValue lG() {
        return this.lowercase;
    }

    @Generated
    public BooleanValue lH() {
        return this.removeSpaces;
    }

    @Generated
    public BooleanValue lI() {
        return this.aoc;
    }

    @Generated
    public BooleanValue lJ() {
        return this.toggleNotifications;
    }

    @Generated
    public List<zc> lK() {
        return this.aok;
    }

    @Generated
    public List<zc> lL() {
        return this.aol;
    }

    @Generated
    public ModeValue lM() {
        return this.aom;
    }

    @Generated
    public a lN() {
        return this.aon;
    }

    @Generated
    public a lO() {
        return this.aoo;
    }

    @Generated
    public agc lP() {
        return this.aop;
    }

    @Generated
    public float lQ() {
        return this.aoq;
    }

    @Generated
    public float lR() {
        return this.aor;
    }

    @Generated
    public Listener<WorldChangeEvent> getOnWorldChange() {
        return this.onWorldChange;
    }

    @Generated
    public Listener<ServerJoinEvent> lS() {
        return this.onServerJoin;
    }

    @Generated
    public Listener<ModuleToggleEvent> lT() {
        return this.onModuleToggle;
    }

    @Generated
    public a lU() {
        return this.aov;
    }

    @Generated
    public Listener<PreUpdateEvent> lV() {
        return this.onPreUpdate;
    }

    @Generated
    public Listener<Render2DEvent> lW() {
        return this.onRender2D;
    }

    @Generated
    public void a(BooleanValue var1) {
        this.suffix = var1;
    }

    @Generated
    public void b(BooleanValue var1) {
        this.lowercase = var1;
    }

    @Generated
    public void c(BooleanValue var1) {
        this.removeSpaces = var1;
    }

    @Generated
    public void d(BooleanValue var1) {
        this.aoc = var1;
    }

    @Generated
    public void e(BooleanValue var1) {
        this.toggleNotifications = var1;
    }

    @Generated
    public void n(List<zc> var1) {
        this.aok = var1;
    }

    @Generated
    public void o(List<zc> var1) {
        this.aol = var1;
    }

    @Generated
    public void a(ModeValue var1) {
        this.aom = var1;
    }

    @Generated
    public void a(agc var1) {
        this.aop = var1;
    }

    @Generated
    public void a(a var1) {
        this.aov = var1;
    }

    @Generated
    public void n(float var1) {
        this.aoq = var1;
    }

    @Generated
    public void o(float var1) {
        this.aor = var1;
    }

    private static void a(zc var0) {
        var0.apP = var0.atg;
    }
}
