package com.alan.clients.util.render;

import com.alan.clients.Client;
import com.alan.clients.util.math.MathUtil;
import com.alan.clients.util.vector.Vector2d;
import hackclient.rise.adu;
import hackclient.rise.agc;
import java.awt.Color;
import org.lwjgl.opengl.GL11;

public final class ColorUtil {
    private ColorUtil() {
    }

    public static void aA(int var0) {
        float f = (var0 >> 24 & 0xFF) / 255.0F;
        float f1 = (var0 >> 16 & 0xFF) / 255.0F;
        float f2 = (var0 >> 8 & 0xFF) / 255.0F;
        float f3 = (var0 & 0xFF) / 255.0F;
        GL11.glColor4f(f1, f2, f3, f);
    }

    public static void d(Color var0) {
        GL11.glColor4f(var0.getRed() / 255.0F, var0.getGreen() / 255.0F, var0.getBlue() / 255.0F, var0.getAlpha() / 255.0F);
    }

    public static Color a(Color var0, float var1) {
        return new Color(
            Math.max((int)(var0.getRed() * var1), 0), Math.max((int)(var0.getGreen() * var1), 0), Math.max((int)(var0.getBlue() * var1), 0), var0.getAlpha()
        );
    }

    public static Color b(Color var0, float var1) {
        int i = var0.getRed();
        int j = var0.getGreen();
        int k = var0.getBlue();
        int l = var0.getAlpha();
        int i1 = (int)(1.0F / (1.0F - var1));
        if (i == 0 && j == 0 && k == 0) {
            return new Color(i1, i1, i1, l);
        }

        if (i > 0 && i < i1) {
            i = i1;
        }

        if (j > 0 && j < i1) {
            j = i1;
        }

        if (k > 0 && k < i1) {
            k = i1;
        }

        return new Color(Math.min((int)(i / var1), 255), Math.min((int)(j / var1), 255), Math.min((int)(k / var1), 255), l);
    }

    public static Color a(Color var0, int var1) {
        return new Color(var1, var0.getGreen(), var0.getBlue());
    }

    public static Color b(Color var0, int var1) {
        return new Color(var0.getRed(), var1, var0.getBlue());
    }

    public static Color c(Color var0, int var1) {
        return new Color(var0.getRed(), var0.getGreen(), var1);
    }

    public static Color d(Color var0, int var1) {
        return var1 == var0.getAlpha() ? var0 : new Color(var0.getRed(), var0.getGreen(), var0.getBlue(), (int)MathUtil.c(0.0, 255.0, var1));
    }

    public static Color a(Color var0, Color var1, double var2) {
        double d0 = 1.0 - var2;
        int i = (int)(var0.getRed() * var2 + var1.getRed() * d0);
        int j = (int)(var0.getGreen() * var2 + var1.getGreen() * d0);
        int k = (int)(var0.getBlue() * var2 + var1.getBlue() * d0);
        return new Color(i, j, k);
    }

    public static double k(Vector2d var0) {
        return Math.sin(System.currentTimeMillis() / 600.0 + var0.getX() * 0.005 + var0.getY() * 0.06) * 0.5 + 0.5;
    }

    public static Color aB(int var0) {
        return Color.getHSBColor((float)(Math.ceil((System.currentTimeMillis() + var0) / 10.0) % 360.0 / 360.0), 0.6F, 1.0F);
    }

    public static void a(agc var0, String var1, double var2, double var4, boolean var6) {
        float f = 0.0F;
        adu adu = Client.a.k();

        for (int i = 0; i < var1.length(); i++) {
            String s = String.valueOf(var1.charAt(i));
            Color color = a(adu.rz().rA(), adu.rz().rB(), Math.sin(i * 0.095) * 0.5 + 0.5);
            if (var6) {
                var0.b(s, var2 + f, var4, color.getRGB());
            } else {
                var0.a(s, var2 + f, var4, color.getRGB());
            }

            f += var0.getStringWidth(s) + 0.5F;
        }
    }

    public static void a(agc var0, String var1, double var2, double var4) {
        a(var0, var1, var2, var4, true);
    }
}
