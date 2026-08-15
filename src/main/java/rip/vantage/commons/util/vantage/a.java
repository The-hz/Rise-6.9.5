package rip.vantage.commons.util.vantage;

import java.awt.Color;

public enum a {
    RISE("Rise", "63d0f9bc46ca6bf7ad9572b7", "§b", new Color(71, 148, 253)),
    WEED("Weed", "63d32b8e3012b50e9686dd39", "§2", new Color(70, 200, 70)),
    PRESTIGE("Prestige", "", "§1", new Color(79, 70, 229)),
    MONSOON("Monsoon", "63d106727842de723ada3bf0", "§3", new Color(32, 117, 171));

    private final String eRl;
    private final String eRm;
    private final String eRn;
    private final Color eRo;
    private static final a[] $VALUES = aKA();

    a(String var3, String var4, String var5, Color color) {
        this.eRl = var3;
        this.eRm = var4;
        this.eRn = var5;
        this.eRo = color;
    }

    public String getDisplayName() {
        return this.eRl;
    }

    public String aKy() {
        return this.eRm;
    }

    public String aKz() {
        return this.eRn;
    }

    public Color nw() {
        return this.eRo;
    }

    private static a[] aKA() {
        return new a[]{RISE, WEED, PRESTIGE, MONSOON};
    }
}
