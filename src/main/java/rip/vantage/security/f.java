package rip.vantage.security;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;

public class f {
    public static int[] O0OoOO0OOOOO;
    public static Object[] o0Oo000O0oO = new Object[18];
    public static Object[] oO00O0OO0ooO = new Object[1];
    public Map<String, Object> eSp = new LinkedHashMap<>();

    public void g(String var1, long var2) {
        this.eSp.put(var1, var2);
    }

    @Override
    public String toString() {
        long j = -269106629741755986L;
        StringBuilder stringbuilder = new StringBuilder("{");
        long k = j ^ (4294967296L ^ j) & -1L << 32;
        Iterator iterator = this.eSp.entrySet().iterator();

        while (iterator.hasNext()) {
            Entry entry = (Entry)iterator.next();
            if ((int)(k >>> 32) == 0) {
                stringbuilder.append(",");
            }

            k ^= (0L ^ k) & -1L << 32;
            stringbuilder.append("\"").append((String)entry.getKey()).append("\":");
            Object object3 = entry.getValue();
            if (object3 instanceof f) {
                stringbuilder.append(object3.toString());
            } else if (object3 instanceof String) {
                stringbuilder.append("\"").append(h((String)object3)).append("\"");
            } else if (object3 instanceof Number) {
                stringbuilder.append(object3.toString());
            } else {
                stringbuilder.append("null");
            }
        }

        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    public static String h(String var0) {
        return var0 == null ? "" : var0.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\n").replace("", "\\r").replace("\t", "\t");
    }

    public static void Oo0o00000O00() {
    }

    public void U(String var1, int var2) {
        this.eSp.put(var1, var2);
    }

    static {
        Oo0o00000O00();
        oO00O0OO0ooO[0] = "\u0000\u0001{\u0000\u0001\"\u0000\u0004null\u0000\u0001\"\u0000\u0002\n\u0000\u0001\\\u0000\u0001\t\u0000\u0001\n\u0000\u0001";
        o0Oo000O0oO[0] = "{";
        o0Oo000O0oO[1] = "\"";
        o0Oo000O0oO[2] = "null";
        o0Oo000O0oO[3] = "\"";
        o0Oo000O0oO[4] = "\n";
        o0Oo000O0oO[5] = "\\";
        o0Oo000O0oO[6] = "\t";
        o0Oo000O0oO[7] = "\n";
        o0Oo000O0oO[8] = "";
        o0Oo000O0oO[9] = "\"";
        o0Oo000O0oO[10] = ",";
        o0Oo000O0oO[11] = "\":";
        o0Oo000O0oO[12] = "\\r";
        o0Oo000O0oO[13] = "\\\\";
        o0Oo000O0oO[14] = "\t";
        o0Oo000O0oO[15] = "\\\"";
        o0Oo000O0oO[16] = "\"";
        o0Oo000O0oO[17] = "}";
    }

    public void a(String var1, f var2) {
        this.eSp.put(var1, var2);
    }

    f() {
    }

    public void aK(String var1, String var2) {
        this.eSp.put(var1, var2);
    }
}
