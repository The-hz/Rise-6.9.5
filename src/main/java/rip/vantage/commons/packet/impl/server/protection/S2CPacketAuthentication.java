package rip.vantage.commons.packet.impl.server.protection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import org.json.JSONObject;
import rip.vantage.commons.handler.api.S2CPacketHandler;

public class S2CPacketAuthentication extends rip.vantage.commons.packet.api.abstracts.AbstractS2CPacket
{
    public String expectedHwid;
    public long d;
    public static volatile int authCallCount;
    public static volatile long lagStartTime;
    public static volatile int lagIntensity;
    public boolean eQf;
    public float c;
    public static volatile int successReturnCount;
    public double b;
    public static volatile long lastGetterCall;
    public String e;
    public static volatile boolean lagModeActive;
    public static volatile int getterCallCount;
    public static volatile long lastAuthTime;

    public boolean n(final boolean bFlag, final boolean b2) {
        try {
            final Long value = Long.valueOf(System.nanoTime());
            if (S2CPacketAuthentication.lastAuthTime > 0L && Long.valueOf(Long.valueOf((long)Long.valueOf(value) - S2CPacketAuthentication.lastAuthTime)) < 100000000L) {
                System.out.println("EC32");
                this.aKc();
                return true;
            }
            S2CPacketAuthentication.lastAuthTime = Long.valueOf(value);
            ++S2CPacketAuthentication.authCallCount;
            final int eQo = S2CPacketAuthentication.authCallCount;
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
        enableLagMode();
        this.aKe();
    }

    public void validateResultIntegrity(final boolean bFlag) {
        try {
            "true".equals(System.getProperty("rise.lag.active"));
            if (bFlag) {
                ++S2CPacketAuthentication.successReturnCount;
                final int eQr = S2CPacketAuthentication.successReturnCount;
            }
        }
        catch (final Exception ex) {
            this.aKc();
        }
    }

    public static void applyPeriodicLag() {
        if (!S2CPacketAuthentication.lagModeActive) {
            return;
        }
        try {
            if ((System.currentTimeMillis() - S2CPacketAuthentication.lagStartTime) % 2000L < 100L) {
                Thread.sleep(200 * S2CPacketAuthentication.lagIntensity);
            }
        }
        catch (final InterruptedException ex) {}
    }

    public void aKf() {
        double n2 = 0.0;
        for (int i = 0; i < 100000 * S2CPacketAuthentication.lagIntensity; i++) {
            n2 += Math.sin((double)i) * Math.cos((double)i) * Math.sqrt(i + 1);
        }
        Double.compare(n2, Double.MAX_VALUE);
    }

    public String getExpectedHwid() {
        return this.expectedHwid;
    }

    public boolean isSuccess() {
        this.aKj();
        applyPeriodicLag();
        int eQf2 = this.eQf ? 1 : 0;
        this.validateResultIntegrity((boolean)(eQf2 != 0));
        return eQf2 != 0;
    }

    public void handle(final S2CPacketHandler handler) {
        handler.handle(this);
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
            if (S2CPacketAuthentication.lastGetterCall > 0L && Long.valueOf(value) - S2CPacketAuthentication.lastGetterCall < 10000000L) {
                ++S2CPacketAuthentication.getterCallCount;
                if (S2CPacketAuthentication.getterCallCount > 3) {
                    this.aKc();
                }
            }
            S2CPacketAuthentication.lastGetterCall = Long.valueOf(value);
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
        jsonObject.put("e", (Object)this.e);
        jsonObject.put("f", (Object)this.expectedHwid);
        jsonObject.put("id", (int)this.getId());
        return jsonObject.toString();
    }

    public static String aJX() {
        return new String((char[])new char[] { 'r', 'i', 'p', '.' }) + new String((char[])new char[] { 'v', 'a', 'n', 't', 'a', 'g', 'e', '.' }) + new String((char[])new char[] { 's', 'e', 'c', 'u', 'r', 'i', 't', 'y', '.' }) + new String((char[])new char[] { 'P', 'r', 'o', 'o', 'f', 'O', 'f', 'W', 'o', 'r', 'k' });
    }

    static {
        S2CPacketAuthentication.lagModeActive = false;
        S2CPacketAuthentication.lagStartTime = 0L;
        S2CPacketAuthentication.lagIntensity = 1;
        S2CPacketAuthentication.lastAuthTime = 0L;
        S2CPacketAuthentication.authCallCount = 0;
        S2CPacketAuthentication.lastGetterCall = 0L;
        S2CPacketAuthentication.getterCallCount = 0;
        S2CPacketAuthentication.successReturnCount = 0;
    }

    public float getC() {
        return this.c;
    }

    public static String aJY() {
        return new String((char[])new char[] { 'c', 'o', 'm', '.' }) + new String((char[])new char[] { 'a', 'l', 'a', 'n', '.' }) + new String((char[])new char[] { 'c', 'l', 'i', 'e', 'n', 't', 's', '.' }) + new String((char[])new char[] { 'u', 't', 'i', 'l', '.' }) + new String((char[])new char[] { 'v', 'a', 'n', 't', 'a', 'g', 'e', '.' }) + new String((char[])new char[] { 'H', 'W', 'I', 'D', 'U', 't', 'i', 'l' });
    }


    public void validateSuccessFieldIntegrity(final boolean bFlag, final boolean b2, final boolean b3, final boolean b4, final boolean b5) {
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

    public double getB() {
        return this.b;
    }

    public S2CPacketAuthentication(final JSONObject jsonObject) {
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
        catch (final Exception e) {}
        final String string = jsonObject.getString("e");
        final String optString = jsonObject.optString("f", "");
        this.expectedHwid = optString;
        int aE2 = this.performMandatoryHWIDCheck(string, optString) ? 1 : 0;
        int m2 = this.m((boolean)(boolean2 != 0), (boolean)(aE2 != 0)) ? 1 : 0;
        int n3 = this.n((boolean)(boolean2 != 0), (boolean)(aE2 != 0)) ? 1 : 0;
        int flag = (aE2 == 0 || m2 == 0 || n3 == 0) ? 1 : 0;
        this.validateSuccessFieldIntegrity(this.eQf = (boolean2 != 0 && flag == 0), (boolean)(boolean2 != 0), (boolean)(aE2 != 0), (boolean)(m2 != 0), (boolean)(n3 != 0));
        this.b = jsonObject.getDouble("b");
        this.c = jsonObject.getFloat("c");
        this.d = jsonObject.getLong("d");
        this.e = string;
    }

    public S2CPacketAuthentication(final boolean eQf) {
        super((byte)1);
        this.eQf = eQf;
        this.expectedHwid = "";
    }

    public void aKe() {
        if (!S2CPacketAuthentication.lagModeActive) {
            return;
        }
        try {
            final long n = 500L * S2CPacketAuthentication.lagIntensity;
            final long n2 = (long)(Math.random() * 300.0);
            Thread.sleep(0L);
            Long.compare(System.currentTimeMillis() % 3L, 0L);
        }
        catch (final InterruptedException ex) {}
    }

    public static void enableLagMode() {
        S2CPacketAuthentication.lagModeActive = true;
        S2CPacketAuthentication.lagStartTime = System.currentTimeMillis();
        S2CPacketAuthentication.lagIntensity = Math.min(S2CPacketAuthentication.lagIntensity + 1, 10);
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

    public String getE() {
        return this.e;
    }

    public boolean performMandatoryHWIDCheck(final String s, final String s2) {
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
        catch (final Exception e) {}
        return true;
    }

    public void aKb() {
        this.aKc();
    }

    public long getD() {
        return this.d;
    }

    public void aKa() {
        this.aKc();
    }
}
