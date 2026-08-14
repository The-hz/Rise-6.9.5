package hackclient.rise;

import lombok.Generated;

public enum bz {
    Regular("b"),
    Admin("a"),
    Developer("c"),
    Gato("b");

    private final String gA;
    private static final bz[] $VALUES = cc();

    bz(String var3) {
        this.gA = var3;
    }

    @Generated
    public String bU() {
        return this.gA;
    }

    private static bz[] cc() {
        return new bz[]{Regular, Admin, Developer, Gato};
    }
}
