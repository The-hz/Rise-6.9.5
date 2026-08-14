package hackclient.rise;

import java.util.ArrayList;

public class bx {
    private static final ArrayList<String> gn = new ArrayList<>();
    private static final ArrayList<String> go = new ArrayList<>();

    public bx() {
    }

    public static void j(String var0) {
        if (!gn.contains(var0)) {
            gn.add(var0);
        }
    }

    public static void k(String var0) {
        gn.remove(var0);
    }

    public static void l(String var0) {
        if (!go.contains(var0)) {
            go.add(var0);
        }
    }

    public static void m(String var0) {
        go.remove(var0);
    }

    public static boolean isFriend(String var0) {
        return gn.contains(var0);
    }

    public static boolean n(String var0) {
        return go.contains(var0);
    }
}
