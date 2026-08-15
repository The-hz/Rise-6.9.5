package com.alan.clients.util.gui;

import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.util.vector.Vector2f;
import lombok.Generated;

public final class GUIUtil {
    public static boolean c(double var0, double var2, double var4, double var6, double var8, double var10) {
        return var8 > var0 && var8 < var0 + var4 && var10 > var2 && var10 < var2 + var6;
    }

    public static boolean mouseOver(Vector2d var0, Vector2d var1, double var2, double var4) {
        return var2 > var0.x && var2 < var0.x + var1.x && var4 > var0.y && var4 < var0.y + var1.y;
    }

    public static boolean a(Vector2f var0, Vector2f var1, double var2, double var4) {
        return var2 > var0.x && var2 < var0.x + var1.x && var4 > var0.y && var4 < var0.y + var1.y;
    }

    public static boolean a(Vector2f var0, Vector2f var1, Vector2d var2) {
        return var2.x > var0.x && var2.x < var0.x + var1.x && var2.y > var0.y && var2.y < var0.y + var1.y;
    }

    @Generated
    private GUIUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
