package hackclient.rise;

public enum ScaffoldState {
    IDLE,
    ROTATING,
    PLACED,
    PICKUP;

    private static final ScaffoldState[] $VALUES = gZ();

    ScaffoldState() {
    }

    private static ScaffoldState[] gZ() {
        return new ScaffoldState[]{IDLE, ROTATING, PLACED, PICKUP};
    }
}
