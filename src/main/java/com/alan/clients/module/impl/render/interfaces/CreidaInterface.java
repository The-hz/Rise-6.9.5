package com.alan.clients.module.impl.render.interfaces;

import com.alan.clients.Client;
import com.alan.clients.module.impl.render.Interface;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.other.TickEvent;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import hackclient.rise.agc;
import com.alan.clients.util.font.FontManager;
import com.alan.clients.util.font.FontWeight;
import com.alan.clients.util.shader.ShaderQueueType;
import com.alan.clients.module.impl.render.interfaces.ArrayListEntry;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.minecraft.client.renderer.GlStateManager;

public final class CreidaInterface extends Mode<Interface> {
    private final BooleanValue font = new BooleanValue("Font", this, true);
    private static final agc asn = FontManager.MINECRAFT.dM();
    private static final double aso = asn.height() + 2.0F;
    private static final int asp = 1;
    @EventLink
    public final Listener<Render2DEvent> onRender2D = var1x -> {
        for (ArrayListEntry zc : this.getParent().lL()) {
            float f = this.font.wo() ? 11.0F : 10.0F;
            this.getParent().n(aEg.fontRendererObj.height() + 3.0F);
            float f1;
            int i = (f1 = this.getParent().aoq - f) == 0.0F ? 0 : (f1 < 0.0F ? -1 : 1);
            this.getParent().o(3.0F);
            double d0 = zc.nr().getX() - 1.0 - 2.0;
            double d1 = zc.nr().getY() + 1.0;
            double d2 = zc.atj + zc.atk + 2.0F + 3.0F;
            this.b(ShaderQueueType.BLUR).c(() -> RenderUtil.d(d0 - 1.0, d1 - 2.0, d2, aso + 1.0, new Color(0, 0, 0, 255)));
            this.b(ShaderQueueType.BLOOM).c(() -> RenderUtil.d(d0 - 1.0, d1 - 2.0, d2, aso + 1.0, new Color(0, 0, 0, 255)));
            this.b(ShaderQueueType.REGULAR, 1).c(() -> {
                RenderUtil.d(d0 - 1.0, d1 - 2.0, d2, aso + 1.0, new Color(0, 0, 0, 110));
                RenderUtil.d(d0 + zc.atj + zc.atk + 4.0, d1 - 2.0, 1.0, aso + 1.0, this.rz().getAccentColor(new Vector2d(zc.nr().getX(), zc.nr().getY() / 1.5)));
                this.a(zc, d0 + 1.0, d1, this.rz().getAccentColor(new Vector2d(zc.nr().getX(), zc.nr().getY() / 1.5)).getRGB());
            });
        }

        this.b(ShaderQueueType.REGULAR).c(() -> {
            Date date = new Date();
            String s = new SimpleDateFormat("HH:mm:ss").format(date);
            String s1 = Client.b + " Client | 6.9.5 | " + aEg.thePlayer.getName() + " | " + s;
            RenderUtil.roundedRectangle(2.0, 3.0, (this.font.wo() ? 0 : 8) + this.nm().getStringWidth(s1), 15.0, 4.0, new Color(0, 0, 0, 100));
            GlStateManager.resetColor();
            int j = 0;

            for (int k = 0; k < s1.length(); k++) {
                char c0 = s1.charAt(k);
                this.nm().b(String.valueOf(c0), 6 + j, 8.0, this.rz().getAccentColor(new Vector2d(k, k)).getRGB());
                j += this.nm().getStringWidth(String.valueOf(c0));
            }
        });
        this.b(ShaderQueueType.BLUR).c(() -> {
            Date date = new Date();
            String s = new SimpleDateFormat("HH:mm:ss").format(date);
            String s1 = Client.b + " Client | 6.9.5 | " + aEg.thePlayer.getName() + " | " + s;
            RenderUtil.roundedRectangle(2.0, 3.0, (this.font.wo() ? 0 : 8) + this.nm().getStringWidth(s1), 15.0, 4.0, new Color(0, 0, 0, 255));
        });
        this.b(ShaderQueueType.BLOOM).c(() -> {
            Date date = new Date();
            String s = new SimpleDateFormat("HH:mm:ss").format(date);
            String s1 = Client.b + " Client | 6.9.5 | " + aEg.thePlayer.getName() + " | " + s;
            RenderUtil.roundedRectangle(2.0, 3.0, (this.font.wo() ? 0 : 8) + this.nm().getStringWidth(s1) - 1, 15.0, 5.0, new Color(0, 0, 0, 255));
        });
    };
    @EventLink
    public final Listener<TickEvent> onTick = var1x -> {
        for (ArrayListEntry zc : this.getParent().lL()) {
            if (zc.ath != 0.0F) {
                zc.y(!zc.getTag().isEmpty() && this.getParent().suffix.wo());
                String s = (this.getParent().lowercase.wo() ? zc.nx().toLowerCase() : zc.nx()).replace(this.getParent().lH().wo() ? " " : "", "");
                String s1 = (this.getParent().lowercase.wo() ? zc.getTag().toLowerCase() : zc.getTag()).replace(this.getParent().lH().wo() ? " " : "", "");
                zc.t(this.nm().getStringWidth(s));
                zc.u(zc.nA() ? this.nm().getStringWidth(s1) + 1 + 3 : 1.0F);
                zc.ap(s);
                zc.aq(s1);
            }
        }
    };

    public CreidaInterface(String var1, Interface var2) {
        super(var1, var2);
    }

    private agc nm() {
        return this.font.wo() ? FontManager.MAIN.a(24, FontWeight.REGULAR) : FontManager.MINECRAFT.dM();
    }

    private void a(ArrayListEntry var1, double var2, double var4, int var6) {
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
        this.nm().b(var1.getDisplayName(), var2, var4, var6);
        if (var1.nA()) {
            this.nm().b(var1.nz(), var2 + var1.nu() + 1.0 + 3.0, var4, -3355444);
        }

        GlStateManager.disableBlend();
    }
}
