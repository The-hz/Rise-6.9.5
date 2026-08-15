package com.alan.clients.module.impl.render;

import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.module.impl.render.Interface;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.other.TickEvent;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.DragValue;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import hackclient.rise.agd;
import hackclient.rise.ahm;
import com.alan.clients.util.render.ColorUtil;
import hackclient.rise.ajz;
import hackclient.rise.gg;
import java.awt.Color;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.util.EnumChatFormatting;

@ModuleInfo(aliases={"module.render.scoreboard.name"}, description="module.render.scoreboard.description", category=Category.RENDER, autoEnabled=true)
public final class ScoreBoard
extends Module {
    private final DragValue position = new DragValue("Position", (Module)this, new Vector2d(200.0, 200.0));
    private final BooleanValue outline = new BooleanValue("Outline", (Module)this, (Boolean)false, () -> true);
    private final BooleanValue blurColor = new BooleanValue("Blur color", (Module)this, (Boolean)false, () -> true);
    private final BooleanValue replaceIPWithRiseWebsite = new BooleanValue("Replace IP with Rise Website", (Module)this, (Boolean)true);
    private Collection<Score> collection;
    private ScoreObjective scoreObjective;
    private int apB;
    private Interface amf;
    private final int apC = 3;
    private final int apD = 9;
    @EventLink
    public final Listener<Render2DEvent> onRender2D = render2DEvent -> {
        if (this.scoreObjective == null) {
            return;
        }
        if (this.amf == null) {
            this.amf = this.e(Interface.class);
        }
        ajz ajz2 = new ajz((int)this.position.apP.x, (int)this.position.apP.y);
        boolean bl = ((Mode)this.amf.lM().wo()).getName().equals("Rise");
        int n2 = this.amf != null ? (int)this.amf.lD() : (bl ? 5 : 1);
        this.b(gg.REGULAR).c(() -> {
            int n3 = this.collection.size();
            int n4 = this.apD * n3 + 3;
            if (((Boolean)this.outline.wo()).booleanValue()) {
                RenderUtil.roundedOutlineGradientRectangle(ajz2.ald - 1, ajz2.ale - 1, this.apB + 12 + 2, n4 + this.apD + 3 + 2, n2, 1.0, ColorUtil.d(this.rz().rA(), 100), ColorUtil.d(this.rz().rB(), 100));
            }
        });
        this.b(gg.BLUR).c(() -> this.a(ajz2.ald, ajz2.ale, Color.WHITE, false, n2, false));
        this.b(gg.BLOOM).c(() -> this.a(ajz2.ald, ajz2.ale, bl ? this.rz().rE() : Color.BLACK, false, n2 + 1, true));
        this.b(gg.REGULAR, 1).c(() -> this.a(ajz2.ald, ajz2.ale, (Boolean)this.blurColor.wo() != false ? new Color(this.rz().rB().getRed(), this.rz().rB().getGreen(), this.rz().rB().getBlue(), 60) : new Color(0, 0, 0, 100), true, n2, false));
    };
    @EventLink
    public final Listener<TickEvent> onTick = tickEvent -> {
        this.scoreObjective = this.getScoreObjective();
        if (this.scoreObjective == null) {
            return;
        }
        Collection<Score> collection = this.scoreObjective.getScoreboard().getSortedScores(this.scoreObjective);
        List list = collection.stream().filter(score -> {
            if (score.getPlayerName() == null) return false;
            if (score.getPlayerName().startsWith("#")) return false;
            return true;
        }).collect(Collectors.toList());
        this.collection = list.size() > 15 ? Lists.newArrayList(Iterables.skip(list, list.size() - 15)) : list;
        this.apB = ScoreBoard.aEg.fontRendererObj.getStringWidth(this.scoreObjective.getDisplayName());
        Iterator<Score> iterator = collection.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.apB += 2;
                return;
            }
            Score score2 = iterator.next();
            String string = ScorePlayerTeam.formatPlayerName(this.scoreObjective.getScoreboard().getPlayersTeam(score2.getPlayerName()), score2.getPlayerName());
            String string2 = this.X(string);
            this.apB = Math.max(this.apB, ScoreBoard.aEg.fontRendererObj.getStringWidth(string2));
        }
    };

    public ScoreBoard() {
    }

    private boolean W(String string) {
        if (!((Boolean)this.replaceIPWithRiseWebsite.wo()).booleanValue()) {
            return false;
        }
        String string2 = EnumChatFormatting.getTextWithoutFormattingCodes(string);
        if (string2 == null) {
            return false;
        }
        return string2.toLowerCase().contains("www.hypixel");
    }

    private String X(String string) {
        if (this.W(string)) {
            return this.mf();
        }
        return string;
    }

    private ScoreObjective getScoreObjective() {
        return ahm.vw();
    }

    private void a(int n2, int n3, Color color, boolean bl, int n4, boolean bl2) {
        agd agd2 = ScoreBoard.aEg.fontRendererObj;
        int n5 = this.collection.size();
        int n6 = this.apD * n5 + 3;
        Vector2d vector2d = new Vector2d(this.apB + 12, n6 + this.apD + 3);
        this.position.n(vector2d);
        if (bl2) {
            RenderUtil.roundedRectangle((float)n2 + 0.5f, (float)n3 + 0.5f, this.apB + 12 - 1, n6 + this.apD + 3 - 1, n4, color);
        } else {
            RenderUtil.roundedRectangle(n2, n3, this.apB + 12, n6 + this.apD + 3, n4, color);
        }
        if (!bl) {
            return;
        }
        int n7 = 0x20FFFFFF;
        int n8 = (int)((double)n3 + 4.5);
        String string = this.scoreObjective.getDisplayName();
        agd2.b(string, (float)(n2 += 6) + (float)this.apB / 2.0f - (float)agd2.getStringWidth(string) / 2.0f, n8, n7);
        Iterator<Score> iterator = this.collection.iterator();
        while (iterator.hasNext()) {
            Score score = iterator.next();
            n8 += this.apD;
            String string2 = ScorePlayerTeam.formatPlayerName(this.scoreObjective.getScoreboard().getPlayersTeam(score.getPlayerName()), score.getPlayerName());
            String string3 = this.X(string2);
            if (((Boolean)this.replaceIPWithRiseWebsite.wo()).booleanValue() && string3.equals(this.mf())) {
                this.a(agd2, string3, n2, n8);
                continue;
            }
            agd2.b(string3, n2, n8, n7);
        }
    }

    private String mf() {
        return String.valueOf((Object)this.rz().getChatAccentColor()) + "riseclient.com";
    }

    private void a(agd agd2, String string, int n2, int n3) {
        String string2 = EnumChatFormatting.getTextWithoutFormattingCodes(string);
        Color color = this.rz().rA();
        Color color2 = this.rz().rB();
        long l2 = System.currentTimeMillis();
        double d2 = 0.005;
        int n4 = n2;
        int n5 = string2.length();
        for (int i = 0; i < n5; ++i) {
            char c2 = string2.charAt(i);
            double d3 = (double)i / (double)n5 * Math.PI * 2.0;
            float f2 = (float)((Math.sin((double)l2 * d2 + d3) + 1.0) * 0.5);
            int n6 = (int)((float)color.getRed() + (float)(color2.getRed() - color.getRed()) * f2);
            int n7 = (int)((float)color.getGreen() + (float)(color2.getGreen() - color.getGreen()) * f2);
            int n8 = (int)((float)color.getBlue() + (float)(color2.getBlue() - color.getBlue()) * f2);
            int n9 = (int)((float)color.getAlpha() + (float)(color2.getAlpha() - color.getAlpha()) * f2);
            agd2.b(String.valueOf(c2), n4, n3, new Color(n6, n7, n8, n9).getRGB());
            n4 += agd2.getStringWidth(String.valueOf(c2));
        }
    }
}
