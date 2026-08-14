package hackclient.rise;

public class ajv {
    private static final String aQy = System.getProperty("os.name").toLowerCase();

    public ajv() {
    }

    public static ajw wb() {
        if (aQy.contains("win")) {
            return ajw.WINDOWS;
        } else if (aQy.contains("mac")) {
            return ajw.MACOSX;
        } else if (!aQy.contains("nix") && !aQy.contains("nux") && !aQy.contains("aix")) {
            System.exit(0);
            return null;
        }
        return ajw.LINUX;
    }
}
