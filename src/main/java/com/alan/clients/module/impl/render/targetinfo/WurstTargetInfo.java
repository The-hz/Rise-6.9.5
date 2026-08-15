package com.alan.clients.module.impl.render.targetinfo;

import com.alan.clients.module.impl.player.HealthBypass;
import com.alan.clients.module.impl.render.TargetInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.value.Mode;
import com.alan.clients.util.math.MathUtil;
import com.alan.clients.util.render.ColorUtil;
import hackclient.rise.bf;
import java.awt.Color;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.Entity;

public class WurstTargetInfo extends Mode<TargetInfo> {
    private TargetInfo aui;
    @EventLink
    public final Listener<Render2DEvent> onRender2D = var1x -> {
        if (this.aui == null) {
            this.aui = this.e(TargetInfo.class);
        }

        Entity entity = this.aui.target;
        boolean flag = !this.aui.inWorld || this.aui.rG.T(1000L);
        if (entity == null || flag) {
            return;
        }

        String s = entity.getName();
        String s1 = bf.c(s, s);
        double d0 = this.aui.position.x;
        double d1 = this.aui.position.y;
        RenderUtil.d(d0, d1, 185.0, 34.0, ColorUtil.d(Color.WHITE, 100));
        aEg.fontRendererObj.a("Name: " + s1, d0 + 4.0, d1 + 4.0, Color.BLACK.getRGB());
        this.aui.positionValue.aHe = new Vector2d(185.0, 50.0);
        AbstractClientPlayer abstractclientplayer = (AbstractClientPlayer)entity;
        HealthBypass healthbypass = this.e(HealthBypass.class);
        float f = healthbypass != null && healthbypass.isEnabled()
            ? HealthBypass.B(abstractclientplayer)
            : abstractclientplayer.getHealth();
        double d2 = Math.min(!this.aui.inWorld ? 0.0 : MathUtil.round(f, 1), abstractclientplayer.getMaxHealth());
        RenderUtil.d(d0 + 4.0, d1 + 16.0, 177.0 * (d2 / abstractclientplayer.getMaxHealth()), 10.0, Color.ORANGE);
    };

    public WurstTargetInfo(String var1, TargetInfo var2) {
        super(var1, var2);
    }
}
