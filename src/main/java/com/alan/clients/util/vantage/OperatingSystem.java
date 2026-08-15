package com.alan.clients.util.vantage;

public enum OperatingSystem {
    WINDOWS("Windows"),
    MACOSX("MacOS"),
    LINUX("Linux");

    private final String aQC;
    private static final OperatingSystem[] $VALUES = wd();

    OperatingSystem(String var3) {
        this.aQC = var3;
    }

    public String wc() {
        return this.aQC;
    }

    private static OperatingSystem[] wd() {
        return new OperatingSystem[]{WINDOWS, MACOSX, LINUX};
    }
}
