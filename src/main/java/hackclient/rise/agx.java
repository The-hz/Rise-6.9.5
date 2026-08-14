package hackclient.rise;

public final class agx {
    private static volatile boolean aKa = false;
    private static volatile boolean enabled = false;
    private static volatile int aKb = 0;

    private agx() {
    }

    public static boolean isEnabled() {
        return aKa && enabled;
    }

    public static int uA() {
        return aKb;
    }

    public static void K(boolean var0) {
        aKa = var0;
        if (!var0) {
            enabled = false;
            aKb++;
        }
    }

    public static void setEnabled(boolean var0) {
        if (!aKa) {
            enabled = false;
            aKb++;
        } else {
            if (enabled != var0) {
                enabled = var0;
                aKb++;
            }
        }
    }

    public static boolean uB() {
        if (!aKa) {
            setEnabled(false);
            return false;
        }
        setEnabled(!enabled);
        return isEnabled();
    }
}
