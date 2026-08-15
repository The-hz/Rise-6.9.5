package com.alan.clients.module.impl.render.keystrokes;

import com.alan.clients.module.impl.render.Interface;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.ui.theme.Themes;
import hackclient.rise.aip;
import com.alan.clients.util.font.FontManager;
import hackclient.rise.gd;
import java.awt.Color;
import lombok.Generated;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public class KeyStroke implements InstanceAccess {
    private Interface amf;
    private final Vector2f atq;
    private final Vector2f atr;
    private final String name;
    private final KeyBinding binding;
    private final Animation animation = new Animation(Easing.LINEAR, 200L);

    public KeyStroke(Vector2f var1, String var2, KeyBinding var3) {
        this(new Vector2f(22.0F, 22.0F), var1, var2, var3);
    }

    public KeyStroke(Vector2f var1, KeyBinding var2) {
        this(var1, Keyboard.getKeyName(var2.getKeyCode()), var2);
    }

    public void c(Vector2d var1) {
        Vector2d vector2d = new Vector2d(var1.getX() + this.atr.getX(), var1.getY() + this.atr.getY());
        if (this.amf == null) {
            this.amf = this.e(Interface.class);
        }

        double d0 = this.amf != null ? this.amf.lD() : 4.0;
        double d1 = vector2d.getX();
        double d2 = vector2d.getY();
        double d3 = this.atq.getX();
        double d4 = this.atq.getY();
        this.rz();
        RenderUtil.roundedRectangle(d1, d2, d3, d4, d0, aip.d(Themes.rK(), (int)this.animation.sG()));
        this.updateHeld();
        Vector2d vector2d1 = new Vector2d(FontManager.MAIN.a(20, gd.REGULAR).getStringWidth(this.name), FontManager.MAIN.a(20, gd.REGULAR).height());
        Vector2d vector2d2 = new Vector2d(
            vector2d.getX() + this.atq.getX() * 0.5F - FontManager.MAIN.a(20, gd.REGULAR).getStringWidth(this.name) * 0.5F,
            vector2d.getY() + (this.atq.getY() - vector2d1.getY()) / 2.0 + 3.0
        );
        FontManager.MAIN.a(20, gd.REGULAR).b(this.name, vector2d2.getX(), vector2d2.getY(), this.rz().rA().getRGB());
    }

    public void e(Vector2d var1) {
        if (this.amf == null) {
            this.amf = this.e(Interface.class);
        }

        double d0 = this.amf != null ? this.amf.lD() : 4.0;
        RenderUtil.roundedRectangle(var1.x + this.atr.x + 0.5, var1.y + this.atr.y + 0.5, this.atq.x - 1.0F, this.atq.y - 1.0F, d0, this.rz().rE());
    }

    public void d(Vector2d var1) {
        if (this.amf == null) {
            this.amf = this.e(Interface.class);
        }

        double d0 = this.amf != null ? this.amf.lD() : 4.0;
        RenderUtil.roundedRectangle(var1.x + this.atr.x, var1.y + this.atr.y, this.atq.x, this.atq.y, d0, Color.BLACK);
    }

    public void updateHeld() {
        this.rz();
        int i = Themes.rK().getAlpha();
        this.animation.Q(this.binding.isKeyDown() ? Math.min(i * 1.4F, 150.0F) : i);
    }

    @Generated
    public KeyStroke(Vector2f var1, Vector2f var2, String var3, KeyBinding var4) {
        this.atq = var1;
        this.atr = var2;
        this.name = var3;
        this.binding = var4;
    }
}
