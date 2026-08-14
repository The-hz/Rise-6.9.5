package hackclient.rise;

public enum aak {
    INITIALIZE,
    REPETITIVE,
    POST_INITIALIZE,
    JOIN;

    private static final aak[] $VALUES = oa();

    aak() {
    }

    private static aak[] oa() {
        return new aak[]{INITIALIZE, REPETITIVE, POST_INITIALIZE, JOIN};
    }
}
