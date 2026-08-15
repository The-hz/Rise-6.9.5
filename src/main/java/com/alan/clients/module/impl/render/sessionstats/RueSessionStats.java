package com.alan.clients.module.impl.render.sessionstats;

import com.alan.clients.module.impl.render.SessionStats;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.other.KillEvent;
import com.alan.clients.newevent.impl.other.ServerJoinEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.DragValue;
import hackclient.rise.ahd;
import hackclient.rise.aip;
import hackclient.rise.gb;
import hackclient.rise.gd;
import hackclient.rise.gg;
import hackclient.rise.zv;
import java.awt.Color;
import java.util.concurrent.TimeUnit;
import net.minecraft.network.play.server.S45PacketTitle;
import net.minecraft.util.StringUtils;

public final class RueSessionStats extends Mode<SessionStats> {
    private final DragValue atY = this.getParent().mg();
    private zv atZ = new zv(0, 0, 0, 0, 0.0, 0.0);
    private String atL = "0 seconds";
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var1x -> {
        if (aEg.thePlayer.ticksExisted % 20 == 0) {
            long i = System.currentTimeMillis() - this.atZ.auf;
            long j = TimeUnit.MILLISECONDS.toHours(i);
            long k = TimeUnit.MILLISECONDS.toMinutes(i) % 60L;
            long l = TimeUnit.MILLISECONDS.toSeconds(i) % 60L;
            String s = "";
            if (j > 0L) {
                s = s + j + " " + (j == 1L ? ahd.ce("ui.sessionstats.hour") : ahd.ce("ui.sessionstats.hours")) + (k == 0L ? "" : " ");
            }

            if (k > 0L) {
                s = s + k + " " + (k == 1L ? ahd.ce("ui.sessionstats.minute") : ahd.ce("ui.sessionstats.minutes")) + (l != 0L && j <= 0L ? " " : "");
            }

            if (l > 0L && j == 0L) {
                s = s + l + " " + (l == 1L ? ahd.ce("ui.sessionstats.second") : ahd.ce("ui.sessionstats.seconds"));
            }

            this.atL = s;
        }
    };
    @EventLink
    public final Listener<Render2DEvent> onRender2D = var1x -> {
        double d0 = 8.0;
        this.atY.aHe = new Vector2d(130.0, 55.0);
        if (!aEg.gameSettings.bJf) {
            this.b(gg.BLUR).c(() -> RenderUtil.roundedRectangle(this.atY.apP.x, this.atY.apP.y, this.atY.aHe.x, this.atY.aHe.y, 11.0, Color.BLACK));
            this.b(gg.REGULAR, 1)
                .c(
                    () -> {
                        RenderUtil.roundedRectangle(this.atY.apP.x, this.atY.apP.y, this.atY.aHe.x, this.atY.aHe.y, 11.0, aip.d(Color.black, 100));
                        RenderUtil.roundedOutlineGradientRectangle(
                            this.atY.apP.x, this.atY.apP.y, this.atY.aHe.x, this.atY.aHe.y, 11.0, 0.5, aip.d(this.rz().rA(), 200), aip.d(this.rz().rB(), 200)
                        );
                        gb.MAIN
                            .a(24, gd.REGULAR)
                            .c(ahd.ce("ui.sessionstats.name"), this.atY.apP.x + this.atY.aHe.x / 2.0, this.atY.apP.y + d0, this.rz().rD().getRGB());
                        gb.MAIN
                            .a(18, gd.REGULAR)
                            .c(this.atL, this.atY.apP.x + this.atY.aHe.x / 2.0, this.atY.apP.y + d0 + 19.0, new Color(255, 255, 255, 200).getRGB());
                        gb.MAIN
                            .a(18, gd.REGULAR)
                            .c(
                                ahd.ce("ui.sessionstats.kills").toLowerCase() + " " + this.atZ.atR,
                                this.atY.apP.x + 35.0,
                                this.atY.apP.y + d0 + 32.0,
                                new Color(255, 255, 255, 200).getRGB()
                            );
                        gb.MAIN
                            .a(18, gd.REGULAR)
                            .c(
                                ahd.ce("ui.sessionstats.wins").toLowerCase() + " " + this.atZ.atS,
                                this.atY.apP.x + 95.0,
                                this.atY.apP.y + d0 + 32.0,
                                new Color(255, 255, 255, 200).getRGB()
                            );
                    }
                );
        }
    };
    @EventLink
    public final Listener<KillEvent> onKill = var1x -> this.atZ.atR++;
    @EventLink
    public final Listener<PacketReceiveEvent> onPacketReceive = var1x -> {
        if (var1x.getPacket() instanceof S45PacketTitle) {
            S45PacketTitle s45packettitle = (S45PacketTitle)var1x.getPacket();
            if (s45packettitle.getMessage() == null) {
                return;
            }

            if (StringUtils.stripControlCodes(s45packettitle.getMessage().getUnformattedText()).equals("VICTORY!")) {
                this.atZ.atS++;
            }
        }
    };
    @EventLink
    public final Listener<ServerJoinEvent> onServerJoin = var1x -> this.atZ = new zv(0, 0, 0, 0, 0.0, 0.0);

    public RueSessionStats(String var1, SessionStats var2) {
        super(var1, var2);
    }
}
