package hackclient.rise;

import lombok.Generated;

public enum gd {
    NONE(0, ""),
    LIGHT(1, "Light", "light", "LIGHT"),
    MEDIUM(2, "Medium", "medium", "MEDIUM"),
    REGULAR(3, "Regular", "regular", "REGULAR"),
    BOLD(4, "Bold", "bold", "BOLD");

    private final int kI;
    private final String[] aliases;
    private static final gd[] $VALUES = dS();

    gd(int var3, String... var4) {
        this.kI = var3;
        this.aliases = var4;
    }

    @Generated
    public int dR() {
        return this.kI;
    }

    @Generated
    public String[] getAliases() {
        return this.aliases;
    }

    private static gd[] dS() {
        return new gd[]{NONE, LIGHT, MEDIUM, REGULAR, BOLD};
    }
}
