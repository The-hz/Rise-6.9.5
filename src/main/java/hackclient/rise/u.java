package hackclient.rise;

public enum u {
    NOT_A_COMMAND,
    EXECUTED,
    UNKNOWN;

    private static final u[] $VALUES = aR();

    u() {
    }

    private static u[] aR() {
        return new u[]{NOT_A_COMMAND, EXECUTED, UNKNOWN};
    }
}
