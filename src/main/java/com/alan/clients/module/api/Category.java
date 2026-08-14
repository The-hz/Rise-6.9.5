package com.alan.clients.module.api;

import hackclient.rise.abx;
import hackclient.rise.abz;
import hackclient.rise.aca;
import hackclient.rise.ace;
import hackclient.rise.acf;
import hackclient.rise.acg;
import hackclient.rise.agc;
import hackclient.rise.gb;
import lombok.Generated;

public enum Category {
    SEARCH("category.search", gb.ICONS_2.o(17), "U", 1, new acf()),
    COMBAT("category.combat", gb.ICONS_1.o(17), "a", 2, new abz()),
    MOVEMENT("category.movement", gb.ICONS_1.o(17), "b", 3, new abz()),
    PLAYER("category.player", gb.ICONS_1.o(17), "c", 4, new abz()),
    RENDER("category.render", gb.ICONS_1.o(17), "g", 5, new abz()),
    EXPLOIT("category.exploit", gb.ICONS_1.o(17), "a", 6, new abz()),
    GHOST("category.ghost", gb.ICONS_1.o(17), "f", 7, new abz()),
    SCRIPT("category.script", gb.ICONS_2.o(17), "m", 7, new aca()),
    THEME("category.themes", gb.ICONS_2.o(17), "U", 10, new acg()),
    LANGUAGE("category.language", gb.ICONS_2.o(17), "U", 10, new ace());

    private final String ln;
    private final String lo;
    private final int color;
    private final agc lq;
    public final abx lr;
    private static final Category[] $VALUES = ee();

    Category(String var3, agc var4, String var5, int var6, abx var7) {
        this.ln = var3;
        this.lo = var5;
        this.color = var6;
        this.lr = var7;
        this.lq = var4;
    }

    @Generated
    public String ea() {
        return this.lo;
    }

    @Generated
    public agc eb() {
        return this.lq;
    }

    @Generated
    public abx ec() {
        return this.lr;
    }

    @Generated
    public String getName() {
        return this.ln;
    }

    @Generated
    public int getColor() {
        return this.color;
    }

    private static Category[] ee() {
        return new Category[]{SEARCH, COMBAT, MOVEMENT, PLAYER, RENDER, EXPLOIT, GHOST, SCRIPT, THEME, LANGUAGE};
    }
}
