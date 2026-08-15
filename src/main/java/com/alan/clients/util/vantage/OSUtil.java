package com.alan.clients.util.vantage;

public class OSUtil {
    private static final String aQy = System.getProperty("os.name").toLowerCase();

    public OSUtil() {
    }

    public static OperatingSystem wb() {
        if (aQy.contains("win")) {
            return OperatingSystem.WINDOWS;
        } else if (aQy.contains("mac")) {
            return OperatingSystem.MACOSX;
        } else if (!aQy.contains("nix") && !aQy.contains("nux") && !aQy.contains("aix")) {
            System.exit(0);
            return null;
        }
        return OperatingSystem.LINUX;
    }
}
