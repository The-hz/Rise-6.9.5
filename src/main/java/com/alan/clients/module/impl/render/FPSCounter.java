package com.alan.clients.module.impl.render;

import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.DragValue;
import hackclient.rise.adv;
import hackclient.rise.gb;
import hackclient.rise.gd;
import hackclient.rise.gg;
import java.awt.Color;
import net.minecraft.client.Minecraft;

@ModuleInfo(aliases = "module.render.fpscounter.name", description = "module.render.fpscounter.description", category = Category.RENDER)
public final class FPSCounter extends Module {
    private final BooleanValue showTitle = new BooleanValue("Title", this, false);
    private final DragValue position = new DragValue("Position", this, new Vector2d(200.0, 200.0));
    private final Vector2f scale = new Vector2f(22.0F, 22.0F);
    private int anq;
    @EventLink
    public final Listener<Render2DEvent> onRender2D = var1 -> {
        Vector2d vector2d = this.position.apP;
        String s = this.showTitle.wo() ? "FPS " : "";
        String s1 = Minecraft.getDebugFPS() + "";
        float f = gb.MAIN.a(20, gd.BOLD).getStringWidth(s);
        if (Minecraft.getDebugFPS() != this.anq) {
            this.scale.x = f + gb.MAIN.a(20, gd.REGULAR).getStringWidth(s1);
        }

        this.anq = Minecraft.getDebugFPS();
        this.b(gg.REGULAR, 1).c(() -> {
            double d2 = vector2d.x;
            double d3 = vector2d.y;
            double d4 = this.scale.x + 6.0F;
            double d5 = this.scale.y - 1.0F;
            double d6 = this.rz().getRound();
            this.rz();
            RenderUtil.roundedRectangle(d2, d3, d4, d5, d6, adv.rK());
            this.position.n(new Vector2d(this.scale.x + 6.0F, this.scale.y - 1.0F));
            double d0 = vector2d.x + 3.0;
            double d1 = vector2d.y + this.scale.y / 2.05F - gb.MAIN.a(20, gd.REGULAR).height() / 4.0F;
            gb.MAIN.a(20, gd.BOLD).b(s, d0, d1, this.rz().rA().getRGB());
            gb.MAIN.a(20, gd.REGULAR).b(s1, d0 + f, d1, Color.WHITE.getRGB());
        });
        this.b(gg.BLUR).c(() -> RenderUtil.roundedRectangle(vector2d.x, vector2d.y, this.scale.x + 6.0F, this.scale.y - 1.0F, this.rz().getRound() + 1, Color.BLACK));
        this.b(gg.BLOOM)
            .c(
                () -> RenderUtil.roundedRectangle(
                    vector2d.x + 0.5, vector2d.y + 0.5, this.scale.x + 6.0F - 1.0F, this.scale.y - 2.0F, this.rz().getRound() + 1, this.rz().rE()
                )
            );
    };

    public FPSCounter() {
    }
}
