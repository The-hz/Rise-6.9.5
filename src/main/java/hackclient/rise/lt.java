package hackclient.rise;

public enum lt {
    IDLE,
    ROTATING,
    PLACED,
    PICKUP;

    private static final lt[] $VALUES = gZ();

    lt() {
    }

    private static lt[] gZ() {
        return new lt[]{IDLE, ROTATING, PLACED, PICKUP};
    }
}
