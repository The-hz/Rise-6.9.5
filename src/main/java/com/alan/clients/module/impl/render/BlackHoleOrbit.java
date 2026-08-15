package com.alan.clients.module.impl.render;

import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.value.impl.DragValue;
import com.alan.clients.ui.theme.Themes;
import com.alan.clients.util.render.ColorUtil;
import com.alan.clients.util.font.FontManager;
import hackclient.rise.gd;
import hackclient.rise.gg;
import hackclient.rise.wn;
import hackclient.rise.wo;
import hackclient.rise.wp;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

@ModuleInfo(aliases = "module.render.blackholeorbit.name", description = "module.render.blackholeorbit.description", category = Category.RENDER)
public final class BlackHoleOrbit extends Module {
    private final DragValue position = new DragValue("Position", this, new Vector2d(260.0, 140.0), false);
    private Interface amf;
    private static final double amg = 190.0;
    private static final double amh = 135.0;
    private static final double ami = 120000.0;
    private static final double amj = 3.0;
    private static final double amk = 13.2;
    private static final double aml = 14.0;
    private static final double amm = 4.4;
    private static final double amn = 12.0;
    private static final double amo = 0.12;
    private static final double amp = 2.35;
    private static final double amq = 4000.0;
    private static final int amr = 8;
    private final wn ams = new wn();
    private final wn amt = new wn();
    private final wp amu = new wp(72);
    private final wp amv = new wp(72);
    private final ArrayList<wo> amw = new ArrayList<>();
    private long amx = -1L;
    @EventLink
    public final Listener<Render2DEvent> onRender2D = var1 -> {
        this.position.n(new Vector2d(190.0, 135.0));
        Vector2d vector2d = this.position.apP;
        this.b(gg.BLUR).c(() -> this.d(vector2d));
        this.b(gg.BLOOM).c(() -> this.e(vector2d));
        this.b(gg.REGULAR).c(() -> this.c(vector2d));
    };

    public BlackHoleOrbit() {
    }

    @Override
    public void onEnable() {
        this.amx = -1L;
        this.lk();
    }

    private void c(Vector2d var1) {
        double d0 = this.ll();
        RenderUtil.roundedRectangle(var1.x, var1.y, 190.0, 135.0, d0, ColorUtil.d(Themes.rK(), 140));
        String s = this.getName();
        FontManager.MAIN.a(18, gd.BOLD).b(s, var1.x + 10.0, var1.y + 11.0, this.rz().rA().getRGB());
        double d1 = var1.x + 10.0;
        double d2 = var1.y + 28.0;
        RenderUtil.roundedRectangle(d1, d2, 170.0, 97.0, Math.max(3.0, d0 - 1.0), ColorUtil.d(Color.BLACK, 55));
        double d3 = d1 + 85.0;
        double d4 = d2 + 52.38;
        RenderUtil.g(d1, d2, 170.0, 97.0);

        try {
            this.b(d1, d2, 170.0, 97.0, d3, d4);
            this.lj();
            this.g(d3, d4);
            this.f(d3, d4);
        } finally {
            GL11.glDisable(3089);
        }
    }

    private void d(Vector2d vector2d) {
        RenderUtil.roundedRectangle(vector2d.x, vector2d.y, 190.0, 135.0, this.ll(), Color.BLACK);
    }

    private void e(Vector2d vector2d) {
        double d0 = this.ll();
        RenderUtil.roundedRectangle(vector2d.x + 0.5, vector2d.y + 0.5, 189.0, 134.0, d0, this.rz().rE());
        double d1 = vector2d.x + 10.0;
        double d2 = vector2d.y + 28.0;
        double d3 = d1 + 85.0;
        double d4 = d2 + 52.38;
        Color color = ColorUtil.d(this.rz().rA(), 55);
        RenderUtil.c(d3, d4, 26.0, color);
    }

    private void f(double var1, double var3) {
        Color color = this.rz().rA();
        Color color1 = this.rz().rB();
        RenderUtil.c(var1, var3, 22.0, ColorUtil.d(ColorUtil.a(color, color1, 0.5), 35));
        RenderUtil.c(var1, var3, 18.0, ColorUtil.d(ColorUtil.a(color1, color, 0.65), 28));
        RenderUtil.c(var1, var3, 15.5, ColorUtil.d(new Color(10, 10, 12), 255));
        RenderUtil.c(var1, var3, 13.0, ColorUtil.d(Color.BLACK, 255));
    }

    private void lj() {
        long i = System.nanoTime();
        if (this.amx < 0L) {
            this.amx = i;
        } else {
            double d0 = (i - this.amx) / 1.0E9;
            this.amx = i;
            double d1 = c(d0, 0.004166666666666667, 0.05);
            this.a(this.ams, d1);
            this.a(this.amt, d1);
            if (this.ams.dj) {
                this.amu.h(this.ams.x, this.ams.y);
            }

            if (this.amt.dj) {
                this.amv.h(this.amt.x, this.amt.y);
            }

            Iterator iterator = this.amw.iterator();

            while (iterator.hasNext()) {
                wo wo = (wo)iterator.next();
                wo.amF += d1;
                double d2 = Math.sqrt(wo.x * wo.x + wo.y * wo.y + 9.0);
                if (!(wo.amF >= wo.amG) && !(d2 <= 14.0)) {
                    this.a(wo, d1);
                    wo.amI.h(wo.x, wo.y);
                } else {
                    iterator.remove();
                }
            }
        }
    }

    private void a(wn var1, double var2) {
        if (!var1.dj) {
            var1.amD -= var2;
            if (var1.amD <= 0.0) {
                var1.dj = true;
                this.a(var1, var1.amB);
            }
        } else {
            double d0 = var1.x * var1.x + var1.y * var1.y + 9.0;
            double d1 = Math.sqrt(d0);
            if (d1 <= 14.0) {
                var1.dj = false;
                var1.amD = 0.65;
            } else {
                double d2 = 1.0 / (d0 * d1);
                double d3 = -120000.0 * var1.x * d2;
                double d4 = -120000.0 * var1.y * d2;
                double d5 = 12.0 / d0;
                double d6 = -d5 * var1.amz;
                double d7 = -d5 * var1.amA;
                var1.amz += (d3 + d6) * var2;
                var1.amA += (d4 + d7) * var2;
                var1.x = var1.x + var1.amz * var2;
                var1.y = var1.y + var1.amA * var2;
                double d8 = d0 * d1;
                double d9 = 240000.0 / d8;
                double d10 = 0.5 * d9 * 0.12 * 0.12;
                double d11 = c(1.0 + d10, 1.0, 6.0);
                if (!var1.amC && d11 >= 2.35) {
                    var1.amC = true;
                    this.b(var1, d11);
                    var1.dj = false;
                    var1.amD = 1.1;
                }
            }
        }
    }

    private void a(wo var1, double var2) {
        double d0 = var1.x * var1.x + var1.y * var1.y + 9.0;
        double d1 = Math.sqrt(d0);
        double d2 = 1.0 / (d0 * d1);
        double d3 = -120000.0 * var1.x * d2;
        double d4 = -120000.0 * var1.y * d2;
        double d5 = 19.200000000000003 / d0;
        var1.amz = var1.amz + (d3 - d5 * var1.amz) * var2;
        var1.amA = var1.amA + (d4 - d5 * var1.amA) * var2;
        var1.x = var1.x + var1.amz * var2;
        var1.y = var1.y + var1.amA * var2;
    }

    private void g(double var1, double var3) {
        this.a(var1, var3, this.ams, this.amu, this.rz().rA());
        this.a(var1, var3, this.amt, this.amv, this.rz().rB());

        for (wo wo : this.amw) {
            this.a(var1, var3, wo);
        }

        RenderUtil.c(var1, var3, 13.2, ColorUtil.d(Color.WHITE, 10));
    }

    private void a(double var1, double var3, wn var5, wp var6, Color var7) {
        if (var5.dj) {
            int i = var6.lm();
            if (i > 1) {
                for (int j = 0; j < i; j++) {
                    double d0 = (double)j / (i - 1);
                    double d1 = 160.0 * (d0 * d0);
                    double d2 = 1.2 + 1.2 * d0;
                    double d3 = var1 + var6.O(j);
                    double d4 = var3 + var6.P(j);
                    RenderUtil.c(d3, d4, d2, ColorUtil.d(var7, (int)d1));
                }
            }

            double d5 = var5.x * var5.x + var5.y * var5.y + 9.0;
            double d6 = Math.sqrt(d5);
            double d7 = d5 * d6;
            double d8 = 240000.0 / d7;
            double d9 = -120000.0 / d7;
            double d10 = 0.5 * d8 * 0.12 * 0.12;
            double d11 = 0.5 * d9 * 0.12 * 0.12;
            double d12 = c(1.0 + d10, 1.0, 6.0);
            double d13 = c(1.0 + d11, 0.12, 1.0);
            double d14 = u((d6 - 13.2) / 6.0);
            int k = (int)(215.0 * d14);
            double d15 = Math.atan2(var5.y, var5.x);
            double d16 = var1 + var5.x;
            double d17 = var3 + var5.y;
            Color color = ColorUtil.d(var7, k);
            this.a(d16, d17, 4.4 * d12, 4.4 * d13, d15, color);
            Color color1 = ColorUtil.d(Color.WHITE, (int)(110.0 * d14));
            this.a(d16 - 0.7, d17 - 0.7, Math.max(1.0, 2.4200000000000004), Math.max(0.8, 1.2320000000000002), d15, color1);
        }
    }

    private void a(double var1, double var3, wo var5) {
        int i = var5.amI.lm();
        if (i > 1) {
            for (int j = 0; j < i; j++) {
                double d0 = (double)j / (i - 1);
                double d1 = 110.0 * (d0 * d0);
                double d2 = 0.8 + 0.9 * d0;
                RenderUtil.c(var1 + var5.amI.O(j), var3 + var5.amI.P(j), d2, ColorUtil.d(var5.amH, (int)d1));
            }
        }

        double d3 = var5.x * var5.x + var5.y * var5.y + 9.0;
        double d4 = Math.sqrt(d3);
        double d5 = d3 * d4;
        double d6 = 240000.0 / d5;
        double d7 = -120000.0 / d5;
        double d8 = 0.5 * d6 * 0.12 * 0.12;
        double d9 = 0.5 * d7 * 0.12 * 0.12;
        double d10 = c(1.0 + d8, 1.0, 5.0);
        double d11 = c(1.0 + d9, 0.18, 1.0);
        double d12 = u(1.0 - var5.amF / var5.amG);
        double d13 = u((d4 - 13.2) / 5.0) * d12;
        int k = (int)(170.0 * d13);
        double d14 = Math.atan2(var5.y, var5.x);
        this.a(var1 + var5.x, var3 + var5.y, var5.amE * d10, var5.amE * d11, d14, ColorUtil.d(var5.amH, k));
    }

    private void b(double var1, double var3, double var5, double var7, double var9, double var11) {
        int i = (int)Math.ceil(var5 / 8.0);
        int j = (int)Math.ceil(var7 / 8.0);
        Color color = ColorUtil.d(Color.BLACK, 18);
        Color color1 = ColorUtil.d(Color.BLACK, 10);
        Color color2 = ColorUtil.d(this.rz().rA(), 55);

        for (int k = 0; k < j; k++) {
            for (int l = 0; l < i; l++) {
                double d0 = var1 + l * 8;
                double d1 = var3 + k * 8;
                double d2 = d0 + 4.0;
                double d3 = d1 + 4.0;
                double d4 = d2 - var9;
                double d5 = d3 - var11;
                double d6 = d4 * d4 + d5 * d5 + 9.0;
                double d7 = 120000.0 / d6;
                if (this.ams.dj) {
                    d7 += 4000.0 / (v(d2 - (var9 + this.ams.x)) + v(d3 - (var11 + this.ams.y)) + 25.0);
                }

                if (this.amt.dj) {
                    d7 += 4000.0 / (v(d2 - (var9 + this.amt.x)) + v(d3 - (var11 + this.amt.y)) + 25.0);
                }

                for (wo wo : this.amw) {
                    d7 += 1400.0 / (v(d2 - (var9 + wo.x)) + v(d3 - (var11 + wo.y)) + 20.0);
                }

                double d8 = u((d7 - 18.0) / 140.0);
                double d9 = 1.0 / Math.max(1.0, d6);
                double d10 = -120000.0 * d4 * d9 * d9;
                double d11 = -120000.0 * d5 * d9 * d9;
                double d12 = c(d10 * 8.0E-4, -1.6, 1.6);
                double d13 = c(d11 * 8.0E-4, -1.6, 1.6);
                Color color3 = (l + k & 1) == 0 ? color : color1;
                Color color4 = ColorUtil.d(ColorUtil.a(color2, color3, d8), (int)(30.0 + 110.0 * d8));
                RenderUtil.d(d0 + d12, d1 + d13, 7.0, 7.0, color4);
            }
        }
    }

    private void b(wn var1, double var2) {
        double d0 = Math.atan2(var1.y, var1.x);
        double d1 = Math.cos(d0);
        double d2 = Math.sin(d0);
        double d3 = -d2;
        double d4 = d1;
        double d5 = c(var2, 1.0, 4.5);

        for (int i = 0; i < 9; i++) {
            double d6 = (i / 8.0 * 2.0 - 1.0) * (2.6 * d5);
            double d7 = ThreadLocalRandom.current().nextDouble(-0.8, 0.8);
            wo wo = new wo();
            wo.x = var1.x + d1 * d6 + d3 * d7;
            wo.y = var1.y + d2 * d6 + d4 * d7;
            double d8 = ThreadLocalRandom.current().nextDouble(6.0, 18.0);
            double d9 = ThreadLocalRandom.current().nextDouble(-14.0, 14.0);
            wo.amz = var1.amz + -d1 * d8 + d3 * d9 * 0.25;
            wo.amA = var1.amA + -d2 * d8 + d4 * d9 * 0.25;
            wo.amE = ThreadLocalRandom.current().nextDouble(1.0, 1.8);
            wo.amG = 1.6 + ThreadLocalRandom.current().nextDouble(0.0, 1.0);
            wo.amF = 0.0;
            wo.amH = ColorUtil.d(ColorUtil.a(this.rz().rA(), this.rz().rB(), ThreadLocalRandom.current().nextDouble()), 255);
            wo.amI = new wp(54);
            this.amw.add(wo);
        }
    }

    private void a(double var1, double var3, double var5, double var7, double var9, Color color) {
        GlStateManager.pushMatrix();
        GlStateManager.translate(var1, var3, 0.0);
        GlStateManager.rotate((float)Math.toDegrees(var9), 0.0F, 0.0F, 1.0F);
        RenderUtil.rt();
        ColorUtil.d(color);
        GL11.glBegin(6);
        GL11.glVertex2d(0.0, 0.0);

        for (int i = 0; i <= 36; i++) {
            double d0 = i / 36.0 * (Math.PI * 2);
            GL11.glVertex2d(Math.cos(d0) * var5, Math.sin(d0) * var7);
        }

        GL11.glEnd();
        RenderUtil.stop();
        GlStateManager.popMatrix();
    }

    private void lk() {
        this.ams.amB = 1;
        this.amt.amB = 2;
        this.a(this.ams, this.ams.amB);
        this.a(this.amt, this.amt.amB);
        this.amu.clear();
        this.amv.clear();
        this.amw.clear();
    }

    private void a(wn var1, int var2) {
        double d0 = var2 == 1 ? 52.0 : 44.0;
        double d1 = ThreadLocalRandom.current().nextDouble(0.0, Math.PI * 2);
        var1.x = Math.cos(d1) * d0;
        var1.y = Math.sin(d1) * d0;
        var1.amC = false;
        var1.dj = true;
        var1.amD = 0.0;
        double d2 = Math.sqrt(120000.0 / d0);
        double d3 = -Math.sin(d1);
        double d4 = Math.cos(d1);
        double d5 = (var2 == 1 ? 1.0 : -1.0) * 0.06;
        var1.amz = d3 * d2 * (1.0 + d5);
        var1.amA = d4 * d2 * (1.0 + d5);
    }

    private double ll() {
        if (this.amf == null) {
            this.amf = this.e(Interface.class);
        }

        return this.amf != null ? this.amf.lD() : 4.0;
    }

    private static double u(double var0) {
        return var0 < 0.0 ? 0.0 : (var0 > 1.0 ? 1.0 : var0);
    }

    private static double c(double var0, double var2, double var4) {
        return var0 < var2 ? var2 : (var0 > var4 ? var4 : var0);
    }

    private static double v(double var0) {
        return var0 * var0;
    }
}
