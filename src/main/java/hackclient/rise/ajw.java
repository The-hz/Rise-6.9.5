package hackclient.rise;

public enum ajw {
    WINDOWS("Windows"),
    MACOSX("MacOS"),
    LINUX("Linux");

    private final String aQC;
    private static final ajw[] $VALUES = wd();

    ajw(String var3) {
        this.aQC = var3;
    }

    public String wc() {
        return this.aQC;
    }

    private static ajw[] wd() {
        return new ajw[]{WINDOWS, MACOSX, LINUX};
    }
}
