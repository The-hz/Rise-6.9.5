package com.alan.clients.ui.click.standard.screen.impl;

import com.alan.clients.Client;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.util.vector.Vector2f;
import hackclient.rise.abj;
import hackclient.rise.abk;
import com.alan.clients.ui.click.standard.screen.Screen;
import com.alan.clients.ui.theme.Themes;
import hackclient.rise.adw;
import com.alan.clients.util.gui.GUIUtil;
import hackclient.rise.agk;
import hackclient.rise.ahd;
import com.alan.clients.util.font.FontManager;
import hackclient.rise.gd;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Objects;

public class ThemeScreen implements Screen, InstanceAccess {
    private final ArrayList<abj> azT = new ArrayList<>();
    private ArrayList<abj> azU = new ArrayList<>();
    private final ArrayList<abk> azV = new ArrayList<>();
    private final agk azW = new agk();
    private abk azX = null;

    public ThemeScreen() {
        for (Themes adv : Themes.values()) {
            this.azT.add(new abj(adv));
        }

        for (adw adw : adw.values()) {
            this.azV.add(new abk(adw));
        }
    }

    @Override
    public void b(int var1, int var2, float var3) {
        this.azW.qx();
        double d0 = Math.ceil(this.azU.size() / 3.0);
        this.azW.V(-57.0 * Math.max(0.0, d0 - 3.0));
        double d1 = 7.0;
        double d2 = this.getStandardClickGUI().getScale().getX() + this.getStandardClickGUI().getPosition().getX() - 4.0F;
        double d3 = this.getStandardClickGUI().getScale().getY() + d1;
        this.azW.a(new Vector2d(d2, d3), this.getStandardClickGUI().alh.y - d1 * 2.0);
        Vector2f vector2f = this.getStandardClickGUI().getScale();
        Vector2f vector2f1 = this.getStandardClickGUI().getPosition();
        double d4 = this.getStandardClickGUI().oY().aym;
        double d5 = vector2f.getY() + 44.0F + this.azW.tE();
        double d6 = (vector2f1.getX() - d4 - 29.0) / 3.0;
        double d7 = (vector2f1.getX() - d4 - 43.0) / 5.0;
        FontManager.MAIN
            .a(16, gd.REGULAR)
            .d(
                ahd.ce("ui.themes.text"),
                vector2f.getX() + vector2f1.getX() - 20.0F,
                vector2f.getY() + 20.0F + this.azW.tE(),
                new Color(255, 255, 255, 128).getRGB()
            );

        for (int i = 0; i < this.azV.size(); i++) {
            abk abk = this.azV.get(i);
            abk.a(vector2f.getX() + d4 + 7.0 + (7.0 + d7) * (i % 5), d5 + Math.floor(i / 5.0) * 24.0, d7, this.azX != null && this.azX.equals(abk));
            abk.pQ().Q(this.azX != null && !this.azX.equals(abk) ? 0.0 : 1.0);
            abk.pR().Q(Objects.equals(this.azX, abk) ? 1.0 : 0.0);
        }

        for (int j = 0; j < this.azU.size(); j++) {
            abj abjx = this.azU.get(j);
            abjx.pM().Q(vector2f.getX() + d4 + 7.0 + (7.0 + d6) * (j % 3));
            abjx.pN().Q(vector2f.getY() + 44.0F + Math.floor(j / 3.0) * 57.0 + 60.0);
        }

        for (abj abj : this.azT) {
            if (abj.pp().sG() > 0.0) {
                abj.k(this.azW.tE(), d6);
            }

            abj.pp().Q(this.azU.contains(abj) ? 255.0 : 0.0);
        }
    }

    @Override
    public void f(int var1, int var2, int var3) {
        if (var3 <= 0) {
            for (abj abj : this.azU) {
                if (GUIUtil.c(abj.pL().getX(), abj.pL().getY(), abj.pL().getZ(), 50.0, var1, var2)) {
                    Client.a.k().a(abj.pK());
                }
            }

            for (abk abk : this.azV) {
                if (GUIUtil.c(abk.pL().getX(), abk.pL().getY(), abk.pL().getZ(), 17.0, var1, var2)) {
                    if (this.azX == abk) {
                        this.azX = null;
                    } else {
                        this.azX = abk;
                    }

                    this.qv();
                }
            }
        }
    }

    private void qv() {
        this.azU.clear();
        if (this.azX == null) {
            this.azU = new ArrayList<>(this.azT);
            this.azU.forEach(var0 -> var0.pp().Q(255.0));
        } else {
            for (abj abj : this.azT) {
                if (abj.pK().getKeyColors().contains(this.azX.pP())) {
                    this.azU.add(abj);
                    abj.pp().Q(255.0);
                }
            }
        }
    }

    @Override
    public void aT() {
        this.azT.forEach(var0 -> var0.pp().T(255.0));
        this.azU = new ArrayList<>(this.azT);
        this.azX = null;
        this.azW.aX();
        this.qw();
    }

    public void qw() {
        Vector2f vector2f = this.getStandardClickGUI().getScale();
        Vector2f vector2f1 = this.getStandardClickGUI().getPosition();
        double d0 = this.getStandardClickGUI().oY().aym;
        double d1 = (vector2f1.getX() - d0 - 29.0) / 3.0;

        for (int i = 0; i < this.azU.size(); i++) {
            abj abj = this.azU.get(i);
            abj.pM().T(vector2f.getX() + d0 + 7.0 + (7.0 + d1) * (i % 3));
            abj.pN().T(vector2f.getY() + 44.0F + Math.floor(i / 3.0) * 57.0 + 60.0);
        }
    }
}
