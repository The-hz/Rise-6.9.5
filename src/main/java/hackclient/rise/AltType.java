package hackclient.rise;

public enum AltType {
    CRACKED("Cracked"),
    MICROSOFT("Microsoft"),
    RAVE("Rave");

    private final String aER;
    private static final AltType[] $VALUES = sk();

    AltType(String var3) {
        this.aER = var3;
    }

    public static AltType bi(String var0) {
        for (AltType aem : values()) {
            if (aem.getName().equalsIgnoreCase(var0)) {
                return aem;
            }
        }

        return null;
    }

    public String getName() {
        return this.aER;
    }

    private static AltType[] sk() {
        return new AltType[]{CRACKED, MICROSOFT, RAVE};
    }
}
