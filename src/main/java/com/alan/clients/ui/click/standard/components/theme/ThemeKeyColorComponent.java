package com.alan.clients.ui.click.standard.components.theme;

import com.alan.clients.ui.theme.KeyColors;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.render.ColorUtil;
import com.alan.clients.util.render.RenderUtil;
import hackclient.rise.aka;
import com.alan.clients.util.shader.ShaderQueueType;
import java.awt.Color;
import lombok.Generated;

public class ThemeKeyColorComponent implements InstanceAccess {
    private final KeyColors ayz;
    private aka ayu = new aka(0.0, 0.0, 0.0);
    private final Animation ayA = new Animation(Easing.EASE_OUT_QUINT, 500L);
    private final Animation ayB = new Animation(Easing.EASE_OUT_QUINT, 500L);

    public void a(double var1, double var3, double var5, boolean var7) {
        this.ayA.sG();
        RenderUtil.roundedRectangle(var1, var3, var5, 17.0, 5.0, new Color(18, 21, 30));
        RenderUtil.roundedRectangle(var1 + 0.5, var3 + 0.5, var5 - 1.0, 16.0, 4.0, this.ayz.nw());
        RenderUtil.roundedRectangle(var1, var3, var5, 17.0, 5.0, new Color(25, 25, 25, (int)((1.0 - this.ayA.sG()) * 128.0)));
        this.b(ShaderQueueType.BLOOM).c(() -> {
            RenderUtil.roundedRectangle(var1, var3, var5, 17.0, 5.0, new Color(18, 21, 30, (int)(this.ayB.sG() * 255.0)));
            RenderUtil.roundedRectangle(var1 + 0.5, var3 + 0.5, var5 - 1.0, 16.0, 4.0, ColorUtil.d(this.ayz.nw(), (int)(this.ayB.sG() * 255.0)));
        });
        this.ayu = new aka(var1, var3, var5);
    }

    @Generated
    public KeyColors pP() {
        return this.ayz;
    }

    @Generated
    public aka pL() {
        return this.ayu;
    }

    @Generated
    public Animation pQ() {
        return this.ayA;
    }

    @Generated
    public Animation pR() {
        return this.ayB;
    }

    @Generated
    public ThemeKeyColorComponent(KeyColors var1) {
        this.ayz = var1;
    }
}
