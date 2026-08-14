package hackclient.rise;

public enum aid {
    PICKUP,
    QUICK_MOVE,
    SWAP,
    CLONE,
    THROW,
    QUICK_CRAFT,
    PICKUP_ALL;

    private static final aid[] $VALUES = vc();

    aid() {
    }

    private static aid[] vc() {
        return new aid[]{PICKUP, QUICK_MOVE, SWAP, CLONE, THROW, QUICK_CRAFT, PICKUP_ALL};
    }
}
