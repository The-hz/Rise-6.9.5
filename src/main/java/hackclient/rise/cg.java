package hackclient.rise;

import com.alan.clients.component.Component;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.ui.theme.Themes;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.font.FontManager;
import com.alan.clients.util.render.ColorUtil;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import java.awt.Color;
import net.minecraft.client.renderer.GlStateManager;
import rip.vantage.commons.util.time.a;

public class cg extends Component {
    private static final adz<ajt<String, String, Integer>> hi = new adz<>(5);
    private static final a hj = new a();
    private static ajt<String, String, Integer> hk;
    private static final Animation hl = new Animation(Easing.EASE_OUT_EXPO, 900L);
    private static final Vector2d hm = new Vector2d(140.0, 30.0);
    private static final Vector2d hn = new Vector2d(20.0, 20.0);
    private static final Vector2d ho = new Vector2d(5.0, 126.0);
    private static final double hp = (hm.y - hn.y) / 2.0;
    private static final agc hq = FontManager.MAIN.a(15, gd.BOLD);
    private static final agc hr = FontManager.MAIN.a(15, gd.LIGHT);
    @EventLink(value = 4)
    public final Listener<Render2DEvent> onRender2D = var1 -> {
        if (hk != null) {
            boolean flag = hj.T(hk.vV().intValue());
            hl.Q(flag ? 1.1 : 1.0);
            hl.h(500L);
            hl.setEasing(Easing.EASE_OUT_EXPO);
            double d0 = hl.sG();
            double d1 = 1.0 - 10.0 * Math.abs(1.0 - hl.sG());
            if (!hl.isFinished() || !flag) {
                this.b(gg.REGULAR, 1).c(() -> {
                    GlStateManager.pushMatrix();
                    GlStateManager.translate((ho.x + hm.x / 2.0) * (1.0 - d0), (ho.y + hm.y / 2.0) * (1.0 - d0), 0.0);
                    GlStateManager.scale(d0, d0, 0.0);
                    double d2 = ho.x;
                    double d3 = ho.y;
                    double d4 = hm.x;
                    double d5 = hm.y;
                    this.rz();
                    Color color = Themes.rK();
                    this.rz();
                    RenderUtil.roundedRectangle(d2, d3, d4, d5, 10.0, ColorUtil.d(color, (int)(Themes.rK().getAlpha() * d1)));
                    RenderUtil.roundedRectangle(ho.x + hp, ho.y + hp, hn.x, hn.y, 6.0, ColorUtil.d(Color.WHITE, (int)(255.0 * d1)));
                    hq.b(hk.vT(), ho.x + hp + hn.x + hp, ho.y + hp + 3.0, ColorUtil.d(this.rz().rA(), (int)(255.0 * d1)).getRGB());
                    hr.b(hk.vU(), ho.x + hp + hn.x + hp, ho.y + hp + 0.5 + hp * 0.7 + hq.height(), ColorUtil.d(Color.WHITE, (int)(255.0 * d1)).getRGB());
                    GlStateManager.popMatrix();
                });
                this.b(gg.BLOOM)
                    .c(
                        () -> {
                            GlStateManager.pushMatrix();
                            GlStateManager.translate((ho.x + hm.x / 2.0) * (1.0 - d0), (ho.y + hm.y / 2.0) * (1.0 - d0), 0.0);
                            GlStateManager.scale(d0, d0, 0.0);
                            RenderUtil.roundedRectangle(
                                ho.x + 0.5, ho.y + 0.5, hm.x - 1.0, hm.y - 1.0, 11.0, ColorUtil.d(this.rz().rE(), (int)(this.rz().rE().getAlpha() * d1))
                            );
                            GlStateManager.popMatrix();
                        }
                    );
                this.b(gg.BLUR).c(() -> {
                    if (!(Math.abs(hl.sG() - 1.0) > 0.045)) {
                        GlStateManager.pushMatrix();
                        GlStateManager.translate((ho.x + hm.x / 2.0) * (1.0 - d0), (ho.y + hm.y / 2.0) * (1.0 - d0), 0.0);
                        GlStateManager.scale(d0, d0, 0.0);
                        RenderUtil.roundedRectangle(ho.x, ho.y, hm.x, hm.y, 10.0, ColorUtil.d(Color.BLACK, (int)(255.0 * d1)));
                        GlStateManager.popMatrix();
                    }
                });
            }
        }
    };
    @EventLink(value = 4)
    public final Listener<PreMotionEvent> onPreMotion = var0 -> {
        if (aEg.thePlayer.ticksExisted % 5 == 0) {
            if (!hi.isEmpty() && (hk == null || hj.T(hk.vV() + 200))) {
                if (hk != null) {
                    hi.remove(hk);
                }

                if (!hi.isEmpty()) {
                    hk = hi.get(0);
                    hj.aX();
                }

                hm.x = Math.max(140.0, hr.getStringWidth(hk.vU()) + hp * 3.0 + hn.x + 2.0);
            }
        }
    };

    public cg() {
    }

    public static void e(String var0, String var1) {
        a(var0, var1, 3000);
    }

    public static void a(String var0, String var1, Integer var2) {
        hi.add(new ajt<>(var0, var1, var2));
    }
}
