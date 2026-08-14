package hackclient.rise;

public enum uo {
    IDLE,
    PREDICT,
    ROTATE,
    PLACE,
    WAIT_LAND,
    PICKUP;

    private static final uo[] $VALUES = kz();

    uo() {
    }

    private static uo[] kz() {
        return new uo[]{IDLE, PREDICT, ROTATE, PLACE, WAIT_LAND, PICKUP};
    }
}
