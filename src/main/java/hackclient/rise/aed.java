package hackclient.rise;

import lombok.Generated;

public final class aed {
    public static aee rV() {
        String s = System.getProperty("os.name").toLowerCase();
        return s.contains("win")
            ? aee.WINDOWS
            : (
                s.contains("mac")
                    ? aee.MACOS
                    : (
                        s.contains("solaris")
                            ? aee.SOLARIS
                            : (s.contains("sunos") ? aee.SOLARIS : (s.contains("linux") ? aee.LINUX : (s.contains("unix") ? aee.LINUX : aee.UNKNOWN)))
                    )
            );
    }

    @Generated
    private aed() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
