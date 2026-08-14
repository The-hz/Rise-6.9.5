package hackclient.rise;

enum yk {
    PNG,
    JPEG,
    GIF,
    BMP,
    WEBP,
    UNKNOWN;

    private static final yk[] $VALUES = nl();

    yk() {
    }

    private static yk[] nl() {
        return new yk[]{PNG, JPEG, GIF, BMP, WEBP, UNKNOWN};
    }
}
