package rip.vantage.commons.packet.impl.server.protection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import org.json.JSONObject;
import rip.vantage.commons.handler.api.c;

public class b extends rip.vantage.commons.packet.api.abstracts.b
{
    public String eQj;
    public long eQi;
    public static volatile int eQo;
    public static volatile long eQl;
    public static volatile int eQm;
    public boolean eQf;
    public float eQh;
    public static volatile int eQr;
    public double eQg;
    public static volatile long eQp;
    public String eOM;
    public static volatile boolean eQk;
    public static volatile int eQq;
    public static volatile long eQn;

    public boolean n(final boolean bFlag, final boolean b2) {
        try {
            final Long value = Long.valueOf(System.nanoTime());
            if (b.eQn > 0L && Long.valueOf(Long.valueOf((long)Long.valueOf(value) - b.eQn)) < 100000000L) {
                System.out.println("EC32");
                this.aKc();
                return true;
            }
            b.eQn = Long.valueOf(value);
            ++b.eQo;
            final int eQo = b.eQo;
            final String name = Thread.currentThread().getName();
            if (name.contains("debug") || name.contains("test") || name.contains("exploit")) {
                System.out.println("EC34");
                this.aKc();
                return true;
            }
            return true;
        }
        catch (final Exception ex) {
            System.out.println("EC35");
            this.aKc();
            return true;
        }
    }

    public void aKc() {
        aKd();
        this.aKe();
    }

    public void cT(final boolean bFlag) {
        try {
            "true".equals(System.getProperty("rise.lag.active"));
            if (bFlag) {
                ++b.eQr;
                final int eQr = b.eQr;
            }
        }
        catch (final Exception ex) {
            this.aKc();
        }
    }

    public static void aKg() {
        if (!b.eQk) {
            return;
        }
        try {
            if ((System.currentTimeMillis() - b.eQl) % 2000L < 100L) {
                Thread.sleep(200 * b.eQm);
            }
        }
        catch (final InterruptedException ex) {}
    }

    public void aKf() {
        double n2 = 0.0;
        for (int i = 0; i < 100000 * b.eQm; i++) {
            n2 += Math.sin((double)i) * Math.cos((double)i) * Math.sqrt(i + 1);
        }
        Double.compare(n2, Double.MAX_VALUE);
    }

    public String aKh() {
        return this.eQj;
    }

    public boolean aKi() {
        this.aKj();
        aKg();
        int eQf2 = this.eQf ? 1 : 0;
        this.cT((boolean)(eQf2 != 0));
        return eQf2 != 0;
    }

    public void a(final c c) {
        c.a(this);
    }

    public void aKj() {
        try {
            final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int n5_hi = 0;
            final StackTraceElement[] array = stackTrace;
            int limit = array.length;
            for (int n11_lo = 0; n11_lo < limit; n11_lo = n11_lo + 1) {
                final String className = array[n11_lo].getClassName();
                if (className.contains("LoginMenu") || className.contains("ServerPacketHandler") || className.contains("BackendPacketEvent")) {
                    int n11_hi = 1;
                    break;
                }
            }
            final Long value = Long.valueOf(System.nanoTime());
            if (b.eQp > 0L && Long.valueOf(value) - b.eQp < 10000000L) {
                ++b.eQq;
                if (b.eQq > 3) {
                    this.aKc();
                }
            }
            b.eQp = Long.valueOf(value);
        }
        catch (final Exception ex) {
            this.aKc();
        }
    }

    public boolean m(final boolean bFlag, final boolean b2) {
        try {
            while (((String)Base64.getEncoder().encodeToString(((MessageDigest)MessageDigest.getInstance("SHA-256")).digest(((String)(bFlag + "|" + b2 + "|" + System.currentTimeMillis())).getBytes(StandardCharsets.UTF_8)))).length() >= 20) {
                if (!bFlag && b2 && System.currentTimeMillis() % 2L == 0L) {
                    this.aKc();
                    return true;
                }
                return true;
            }
            System.out.println("EC46");
            this.aKc();
            return true;
        }
        catch (final Exception ex) {
            System.out.println("EC31");
            this.aKc();
            return true;
        }
    }

    public String aJk() {
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put("a", this.eQf);
        jsonObject.put("b", 3.141592653589793);
        jsonObject.put("c", 90.0f);
        jsonObject.put("d", System.currentTimeMillis());
        jsonObject.put("e", (Object)this.eOM);
        jsonObject.put("f", (Object)this.eQj);
        jsonObject.put("id", (int)this.aeq());
        return jsonObject.toString();
    }

    public static String aJX() {
        return new String((char[])new char[] { 'r', 'i', 'p', '.' }) + new String((char[])new char[] { 'v', 'a', 'n', 't', 'a', 'g', 'e', '.' }) + new String((char[])new char[] { 's', 'e', 'c', 'u', 'r', 'i', 't', 'y', '.' }) + new String((char[])new char[] { 'P', 'r', 'o', 'o', 'f', 'O', 'f', 'W', 'o', 'r', 'k' });
    }

    static {
        b.eQk = false;
        b.eQl = 0L;
        b.eQm = 1;
        b.eQn = 0L;
        b.eQo = 0;
        b.eQp = 0L;
        b.eQq = 0;
        b.eQr = 0;
    }

    public float aKl() {
        return this.eQh;
    }

    public static String aJY() {
        return new String((char[])new char[] { 'c', 'o', 'm', '.' }) + new String((char[])new char[] { 'a', 'l', 'a', 'n', '.' }) + new String((char[])new char[] { 'c', 'l', 'i', 'e', 'n', 't', 's', '.' }) + new String((char[])new char[] { 'u', 't', 'i', 'l', '.' }) + new String((char[])new char[] { 'v', 'a', 'n', 't', 'a', 'g', 'e', '.' }) + new String((char[])new char[] { 'H', 'W', 'I', 'D', 'U', 't', 'i', 'l' });
    }


    public void c(final boolean bFlag, final boolean b2, final boolean b3, final boolean b4, final boolean b5) {
        try {
            if ((bFlag ? 1 : 0) != ((b2 && b3 && b4 && b5) ? 1 : 0)) {
                System.out.println("EC36");
                final Field declaredField = this.getClass().getDeclaredField("success");
                declaredField.setAccessible(true);
                declaredField.set(this, Boolean.valueOf(false));
            }
            if (bFlag && (!b2 || !b3 || !b4 || !b5)) {
                System.out.println("EC37");
                final Field declaredField2 = this.getClass().getDeclaredField("success");
                declaredField2.setAccessible(true);
                declaredField2.set(this, Boolean.valueOf(false));
            }
        }
        catch (final Exception ex) {
            System.out.println("EC38");
            this.aKc();
        }
    }

    public double aKk() {
        return this.eQg;
    }

    public b(final JSONObject jsonObject) {
        super((byte)1);
        try {
            final Class<?> forName = Class.forName(aJX());
            Method method = null;
            final Method[] declaredMethods = ((Class<?>)forName).getDeclaredMethods();
            int count = declaredMethods.length;
            for (int i = 0; i < count; i++) {
                final Method method2 = declaredMethods[i];
                if (Modifier.isPublic(method2.getModifiers()) && Modifier.isStatic(method2.getModifiers()) && method2.getReturnType() == Void.TYPE && method2.getParameterCount() == 1 && method2.getParameterTypes()[0] == Integer.TYPE) {
                    method = method2;
                    break;
                }
            }
            if (method != null) {
                method.invoke(null, Integer.valueOf(124));
            }
        }
        catch (final Exception ex) {}
        this.aJZ();
        int boolean2 = jsonObject.getBoolean("a") ? 1 : 0;
        try {
            final Class<?> forName2 = Class.forName(aJX());
            Method method3 = null;
            final Method[] declaredMethods2 = forName2.getDeclaredMethods();
            int n4_hi = declaredMethods2.length;
            for (int limit = 0; limit < n4_hi; limit = limit + 1) {
                final Method method4 = declaredMethods2[limit];
                if (Modifier.isPublic(method4.getModifiers()) && Modifier.isStatic(method4.getModifiers()) && method4.getReturnType() == Void.TYPE && method4.getParameterCount() == 1 && method4.getParameterTypes()[0] == Boolean.TYPE) {
                    method3 = method4;
                    break;
                }
            }
            if (method3 != null) {
                method3.invoke(null, Boolean.valueOf((boolean)(boolean2 != 0)));
            }
        }
        catch (final Exception ex2) {}
        final String string = jsonObject.getString("e");
        final String optString = jsonObject.optString("f", "");
        this.eQj = optString;
        int aE2 = this.aE(string, optString) ? 1 : 0;
        int m2 = this.m((boolean)(boolean2 != 0), (boolean)(aE2 != 0)) ? 1 : 0;
        int n3 = this.n((boolean)(boolean2 != 0), (boolean)(aE2 != 0)) ? 1 : 0;
        int flag = (aE2 == 0 || m2 == 0 || n3 == 0) ? 1 : 0;
        this.c(this.eQf = (boolean2 != 0 && flag == 0), (boolean)(boolean2 != 0), (boolean)(aE2 != 0), (boolean)(m2 != 0), (boolean)(n3 != 0));
        this.eQg = jsonObject.getDouble("b");
        this.eQh = jsonObject.getFloat("c");
        this.eQi = jsonObject.getLong("d");
        this.eOM = string;
    }

    public b(final boolean eQf) {
        super((byte)1);
        this.eQf = eQf;
        this.eQj = "";
    }

    public void aKe() {
        if (!b.eQk) {
            return;
        }
        try {
            final long n = 500L * b.eQm;
            final long n2 = (long)(Math.random() * 300.0);
            Thread.sleep(0L);
            Long.compare(System.currentTimeMillis() % 3L, 0L);
        }
        catch (final InterruptedException ex) {}
    }

    public static void aKd() {
        b.eQk = true;
        b.eQl = System.currentTimeMillis();
        b.eQm = Math.min(b.eQm + 1, 10);
        System.setProperty("rise.lag.active", "true");
    }

    public void aJZ() {
        try {
            final String string = this.getClass().getName() + ".constructor";
            MessageDigest.getInstance("SHA-256");
            if (string.length() >= 10) {
                string.contains("S2CPacketAuthentication");
            }
            final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int n5_hi = 0;
            final StackTraceElement[] array = stackTrace;
            int limit = array.length;
            for (int n11_lo = 0; n11_lo < limit; n11_lo = n11_lo + 1) {
                final StackTraceElement stackTraceElement = array[n11_lo];
                if (stackTraceElement.getClassName().contains("WebSocketClient") || stackTraceElement.getClassName().contains("ServerPacketHandler")) {
                    n5_hi = 1;
                    break;
                }
            }
            if (n5_hi == 0) {
                return;
            }
            return;
        }
        catch (final Exception ex) {}
        System.out.println("EC29");
        this.aKc();
    }

    public String aKn() {
        return this.eOM;
    }

    public boolean aE(final String s, final String s2) {
        try {
            final String s3 = (String)((Method)((Class<?>)Class.forName(aJY())).getMethod("getHWID", (Class<?>[])new Class[0])).invoke(null, new Object[0]);
            if (s3 == null || s3.length() < 32 || !s3.contains("dleotn6oc94kb")) {
                System.out.println("EC19");
                if (s3 == null || s3.length() < 10) {
                    this.aKc();
                }
                return false;
            }
            if (s2 != null && !s2.isEmpty()) {
                try {
                    final Class<?> forName = Class.forName(aJX());
                    Method method = null;
                    final Method[] declaredMethods = ((Class<?>)forName).getDeclaredMethods();
                    int n5_lo = declaredMethods.length;
                    for (int i = 0; i < n5_lo; i++) {
                        final Method method2 = declaredMethods[i];
                        if (Modifier.isPublic(method2.getModifiers()) && Modifier.isStatic(method2.getModifiers()) && method2.getReturnType() == Boolean.TYPE && method2.getParameterCount() == 2 && method2.getParameterTypes()[0] == String.class && method2.getParameterTypes()[1] == String.class) {
                            method = method2;
                            break;
                        }
                    }
                    if (method == null) {
                        System.out.println("EC48");
                        this.aKc();
                        return false;
                    }
                    if ((((boolean)method.invoke(null, s3, s2)) ? 1 : 0) == 0) {
                        System.out.println("EC47");
                        this.aKc();
                        return false;
                    }
                }
                catch (final Exception ex) {
                    System.out.println("EC48");
                    this.aKc();
                    return false;
                }
            }
            if (s == null || s.trim().isEmpty() || s.equals("INVALID") || s.equals("HWID_MISMATCH")) {
                System.out.println("EC20");
                if (s != null && !s.equals("INVALID")) {
                    s.equals("HWID_MISMATCH");
                }
                return false;
            }
            final MessageDigest instance = MessageDigest.getInstance("SHA-256");
            final String encodeToString = Base64.getEncoder().encodeToString(instance.digest(s3.getBytes(StandardCharsets.UTF_8)));
            final String encodeToString2 = Base64.getEncoder().encodeToString(instance.digest((s3 + "|" + String.valueOf((long)Long.valueOf(Long.valueOf(System.currentTimeMillis())) / 60000L)).getBytes(StandardCharsets.UTF_8)));
            if (encodeToString.length() < 20 || encodeToString2.length() < 20) {
                System.out.println("EC27");
                this.aKc();
                return false;
            }
            return true;
        }
        catch (final Exception ex2) {}
        return true;
    }

    public void aKb() {
        this.aKc();
    }

    public long aKm() {
        return this.eQi;
    }

    public void aKa() {
        this.aKc();
    }
}
