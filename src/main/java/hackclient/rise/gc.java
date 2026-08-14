package hackclient.rise;

class gc {
    static final int[] kC = new int[gd.values().length];

    static {
        try {
            kC[gd.LIGHT.ordinal()] = 1;
        } catch (NoSuchFieldError nosuchfielderror4) {
        }

        try {
            kC[gd.MEDIUM.ordinal()] = 2;
        } catch (NoSuchFieldError nosuchfielderror3) {
        }

        try {
            kC[gd.BOLD.ordinal()] = 3;
        } catch (NoSuchFieldError nosuchfielderror2) {
        }

        try {
            kC[gd.REGULAR.ordinal()] = 4;
        } catch (NoSuchFieldError nosuchfielderror1) {
        }

        try {
            kC[gd.NONE.ordinal()] = 5;
        } catch (NoSuchFieldError nosuchfielderror) {
        }
    }
}
