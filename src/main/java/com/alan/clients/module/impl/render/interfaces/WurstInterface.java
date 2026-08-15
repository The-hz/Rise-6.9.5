package com.alan.clients.module.impl.render.interfaces;

import com.alan.clients.Client;
import com.alan.clients.module.impl.render.Interface;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.other.TickEvent;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.value.Mode;
import hackclient.rise.agc;
import com.alan.clients.util.localization.Locale;
import hackclient.rise.aip;
import com.alan.clients.util.font.FontManager;
import hackclient.rise.gd;
import hackclient.rise.zc;
import java.awt.Color;
import net.minecraft.util.ResourceLocation;

public class WurstInterface extends Mode<Interface> {
    private agc ky;
    private final ResourceLocation atc = new ResourceLocation("rise/logo/wurst.png");
    @EventLink
    public final Listener<Render2DEvent> onRender2D = var1x -> {
        if (aEg != null && !aEg.gameSettings.bJf && aEg.theWorld != null && aEg.thePlayer != null) {
            this.getParent().n(this.ky.height() + 1.0F);
            this.getParent().a(this.ky);
            this.getParent().o(4.0F);

            for (zc zc : this.getParent().lL()) {
                if (zc.ath != 0.0F) {
                    double d0 = zc.nr().getX();
                    double d1 = zc.nr().getY();
                    Color color = Color.WHITE;
                    this.ky.b(zc.nx(), d0, d1, color.getRGB());
                }
            }

            RenderUtil.d(0.0, 10.0, 185.0, 12.0, aip.d(Color.WHITE, 100));
            RenderUtil.image(this.atc, 2.0, 5.5, 89.17647F, 22.588236F);
            this.ky.a("v6 MC 1.8.9", 95.0, 14.0, Color.BLACK.getRGB());
        }
    };
    @EventLink
    public final Listener<TickEvent> onTick = var1x -> aMR.execute(() -> {
        for (zc zc : this.getParent().lL()) {
            if (zc.ath != 0.0F) {
                String s = zc.nx();
                zc.t(this.ky.getStringWidth(s));
                zc.u(0.0F);
                zc.an("");
            }
        }
    });

    public WurstInterface(String var1, Interface var2) {
        super(var1, var2);
        this.ky = Client.a.getLocale() == Locale.ZH_ZH ? FontManager.MAIN.a(18, gd.REGULAR) : aEg.fontRendererObj;
    }
}
