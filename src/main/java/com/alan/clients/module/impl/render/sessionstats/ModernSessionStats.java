package com.alan.clients.module.impl.render.sessionstats;

import com.alan.clients.module.impl.render.Interface;
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
import hackclient.rise.abw;
import hackclient.rise.ahd;
import com.alan.clients.util.render.ColorUtil;
import com.alan.clients.util.font.FontManager;
import hackclient.rise.gd;
import hackclient.rise.gg;
import hackclient.rise.zt;
import java.awt.Color;
import java.util.concurrent.TimeUnit;
import net.minecraft.network.play.server.S45PacketTitle;
import net.minecraft.util.StringUtils;

public final class ModernSessionStats extends Mode<SessionStats> {
    private final DragValue atJ = this.getParent().mg();
    private zt atK = new zt(0, 0, 0, 0, 0.0, 0.0);
    private String atL = "0 seconds";
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var1x -> {
        if (aEg.thePlayer.ticksExisted % 20 == 0) {
            long i = System.currentTimeMillis() - this.atK.atX;
            long j = TimeUnit.MILLISECONDS.toHours(i);
            long k = TimeUnit.MILLISECONDS.toMinutes(i) % 60L;
            long l = TimeUnit.MILLISECONDS.toSeconds(i) % 60L;
            String s = "";
            String s1 = s + j + ahd.ce("h ");
            String s2 = s1 + k + ahd.ce("m ");
            String s3 = s2 + l + ahd.ce("s ");
            this.atL = s3;
        }
    };
    @EventLink
    public final Listener<Render2DEvent> onRender2D = var1x -> {
        double d0 = 10.0;
        this.atJ.aHe = new Vector2d(130.0, 50.0);
        if (!aEg.gameSettings.bJf) {
            if (this.e(Interface.class).aoc.wo()) {
                this.b(gg.BLUR).c(() -> {
                    RenderUtil.a(this.atJ.apP.x, this.atJ.apP.y - 14.0, this.atJ.aHe.x, 14.0, 6.0, abw.SECONDARY.pV(), true, true, false, false);
                    RenderUtil.a(this.atJ.apP.x, this.atJ.apP.y, this.atJ.aHe.x, this.atJ.aHe.y, 6.0, abw.BACKGROUND.pV(), false, false, true, true);
                });
                this.b(gg.BLOOM).c(() -> {
                    RenderUtil.roundedRectangle(this.atJ.apP.x, this.atJ.apP.y - 14.0, this.atJ.aHe.x, this.atJ.aHe.y + 14.0, 7.0, this.rz().rE());
                    double d1 = this.atJ.apP.x + this.atJ.aHe.x / 2.0 - (FontManager.MAIN.a(18, gd.REGULAR).getStringWidth("Information") / 2.0 + 1.0);
                    FontManager.MAIN.a(18, gd.BOLD).c(ahd.ce("session"), d1, this.atJ.apP.y - 9.0, ColorUtil.d(this.rz().rA(), 200).getRGB());
                });
            }

            this.b(gg.REGULAR, 1)
                .c(
                    () -> {
                        Color color = this.rz().rA();
                        Color color1 = new Color(
                            Math.min(255, abw.BACKGROUND.pV().getRed() + color.getRed() / 26),
                            Math.min(255, abw.BACKGROUND.pV().getGreen() + color.getGreen() / 26),
                            Math.min(255, abw.BACKGROUND.pV().getBlue() + color.getBlue() / 26),
                            245
                        );
                        RenderUtil.a(this.atJ.apP.x, this.atJ.apP.y - 14.0, this.atJ.aHe.x, 14.0, 6.0, ColorUtil.d(abw.SECONDARY.pV(), 170), true, true, false, false);
                        RenderUtil.a(this.atJ.apP.x, this.atJ.apP.y, this.atJ.aHe.x, this.atJ.aHe.y, 6.0, color1, false, false, true, true);
                        double d1 = this.atJ.apP.x + this.atJ.aHe.x / 2.0 - (FontManager.MAIN.a(18, gd.REGULAR).getStringWidth("Information") / 2.0 + 1.0);
                        FontManager.MAIN.a(18, gd.BOLD).c(ahd.ce("session"), d1, this.atJ.apP.y - 9.0, this.rz().rD().getRGB());
                        FontManager.MAIN
                            .a(18, gd.REGULAR)
                            .c(
                                ahd.ce("Information"),
                                this.atJ.apP.x + this.atJ.aHe.x / 2.0 + (FontManager.MAIN.a(18, gd.BOLD).getStringWidth("session") / 2.0 + 1.0),
                                this.atJ.apP.y - 9.0,
                                abw.TEXT.pW()
                            );
                        FontManager.MAIN.a(24, gd.BOLD).a(this.atL, this.atJ.apP.x + d0, this.atJ.apP.y + d0 - 1.8, abw.TEXT.pW());
                        FontManager.MAIN
                            .a(16, gd.REGULAR)
                            .a(
                                ahd.ce("You have gotten ") + this.atK.atR + " kills",
                                this.atJ.apP.x + d0,
                                this.atJ.apP.y + d0 + FontManager.MAIN.a(24, gd.BOLD).height(),
                                abw.TRINARY_TEXT.pW()
                            );
                        FontManager.MAIN
                            .a(16, gd.REGULAR)
                            .a(
                                ahd.ce("You have won " + this.atK.atS) + " games",
                                this.atJ.apP.x + d0,
                                this.atJ.apP.y + d0 + FontManager.MAIN.a(24, gd.BOLD).height() + FontManager.MAIN.a(16, gd.REGULAR).height() + 2.0,
                                abw.TRINARY_TEXT.pW()
                            );
                    }
                );
        }
    };
    @EventLink
    public final Listener<KillEvent> onKill = var1x -> this.atK.atR++;
    @EventLink
    public final Listener<PacketReceiveEvent> onPacketReceive = var1x -> {
        if (var1x.getPacket() instanceof S45PacketTitle) {
            S45PacketTitle s45packettitle = (S45PacketTitle)var1x.getPacket();
            if (s45packettitle.getMessage() == null) {
                return;
            }

            if (StringUtils.stripControlCodes(s45packettitle.getMessage().getUnformattedText()).equals("VICTORY!")) {
                this.atK.atS++;
            }
        }
    };
    @EventLink
    public final Listener<ServerJoinEvent> onServerJoin = var1x -> this.atK = new zt(0, 0, 0, 0, 0.0, 0.0);

    public ModernSessionStats(String var1, SessionStats sessionStats) {
        super(var1, sessionStats);
    }
}
