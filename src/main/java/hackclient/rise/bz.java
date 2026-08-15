package hackclient.rise;

import lombok.Generated;

public enum bz {
    Regular("b"),
    Admin("a"),
    Developer("c"),
    Gato("b");

    private final String colorCode;
    private static final bz[] $VALUES = cc();

    bz(String var3) {
        this.colorCode = var3;
    }

    @Generated
    public String getColorCode() {
        return this.colorCode;
    }

    private static bz[] cc() {
        return new bz[]{Regular, Admin, Developer, Gato};
    }
}
