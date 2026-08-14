package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.module.impl.render.Interface;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.other.GameEvent;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.newevent.impl.render.Render3DEvent;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.Generated;
import net.minecraft.client.renderer.GlStateManager;

public class gf {
    private final LinkedHashMap<Integer, LinkedHashMap<gg, ge>> kM = new LinkedHashMap<>();
    private final int kN = 3;
    private boolean kO;
    @EventLink(cH = -1)
    public final Listener<fu> kP = var1 -> this.b(aiz.OVERLAY);
    @EventLink(cH = -1)
    public final Listener<Render2DEvent> kQ = var1 -> {
        add.w(0.0F);
        this.b(aiz.OVERLAY);
    };
    @EventLink
    public final Listener<GameEvent> kR = var1 -> this.kO = Client.a.g().c(Interface.class).aoc.wo();
    @EventLink(cH = -1)
    public final Listener<Render3DEvent> kS = var1 -> this.b(aiz.CAMERA);

    public gf() {
        try {
            for (int i = 0; i <= 3; i++) {
                this.kM.put(i, new LinkedHashMap<>());

                for (gg gg : gg.values()) {
                    this.kM.get(i).put(gg, new ge(gg.dW().dY() == null ? null : (aix)gg.dW().dY().newInstance()));
                }
            }

            Client.a.e().b(this);
        } catch (RuntimeException | Error throwable) {
            throw throwable;
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public ge a(gg var1) {
        return this.a(var1, 0);
    }

    public ge a(gg var1, int var2) {
        return this.kM.get(var2).get(var1);
    }

    private void b(aiz var1) {
        try {
            this.kM.forEach((var2, var3) -> var3.values().forEach(var2x -> {
                if (var2x.dU() == null || this.kO) {
                    var2x.a(var1);
                }
            }));
        } finally {
            this.kM.forEach((var0, var1x) -> var1x.forEach((var0x, var1xx) -> var1xx.clear()));
        }

        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.disableLighting();
        GlStateManager.enableAlpha();
    }

    @Generated
    public LinkedHashMap<Integer, LinkedHashMap<gg, ge>> dV() {
        return this.kM;
    }

    private static void a(AtomicInteger var0, Integer var1, LinkedHashMap var2) {
        var2.values().forEach(var1x -> {
            if (((ge)var1x).dU() != null && !((ge)var1x).dT().isEmpty()) {
                var0.getAndIncrement();
            }
        });
    }
}
