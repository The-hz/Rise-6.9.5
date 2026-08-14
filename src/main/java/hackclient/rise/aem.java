package hackclient.rise;

public enum aem {
    CRACKED("Cracked"),
    MICROSOFT("Microsoft"),
    RAVE("Rave");

    private final String aER;
    private static final aem[] $VALUES = sk();

    aem(String var3) {
        this.aER = var3;
    }

    public static aem bi(String var0) {
        for (aem aem : values()) {
            if (aem.getName().equalsIgnoreCase(var0)) {
                return aem;
            }
        }

        return null;
    }

    public String getName() {
        return this.aER;
    }

    private static aem[] sk() {
        return new aem[]{CRACKED, MICROSOFT, RAVE};
    }
}
