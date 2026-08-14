package hackclient.rise;

public enum aee {
    LINUX,
    SOLARIS,
    WINDOWS,
    MACOS,
    UNKNOWN;

    private static final aee[] $VALUES = rW();

    aee() {
    }

    private static aee[] rW() {
        return new aee[]{LINUX, SOLARIS, WINDOWS, MACOS, UNKNOWN};
    }
}
