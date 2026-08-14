package rip.vantage.commons.packet.impl.server.protection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;
import rip.vantage.commons.handler.api.c;

public class b extends rip.vantage.commons.packet.api.abstracts.b
{
    public static Object[] fld_0OOOoo00o0_91;
    public String eQj;
    public long eQi;
    public static volatile int eQo;
    public static volatile long eQl;
    public static volatile int eQm;
    public static Object[] oO00O0OO0ooO;
    public boolean eQf;
    public float eQh;
    public static volatile int eQr;
    public static Object[] fld_0oOOoOo0O00O_92;
    public double eQg;
    public static volatile long eQp;
    public String eOM;
    public static volatile boolean eQk;
    public static volatile int eQq;
    public static volatile long eQn;
    public static int[] O0OoOO0OOOOO;
    public static Object[] o0Oo000O0oO;
    public static Object Oo0o00000O00;

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
            if (((String)name).contains("debug") || ((String)name).contains("test") || ((String)name).contains("exploit")) {
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
        final long n = -3974787580592546974L;
        double n2 = 0.0;
        final long n3 = 0L;
        final long n4 = n;
        for (long n5 = n4 ^ ((n3 ^ n4) & -1L << 32); (int)(n5 >>> 32) < 100000 * b.eQm; n5 += 4294967296L) {
            n2 += Math.sin((double)(n5 >>> 32)) * Math.cos((double)(n5 >>> 32)) * Math.sqrt((int)(n5 >>> 32) + 1);
        }
        Double.compare(n2, Double.MAX_VALUE);
    }

    public String aKh() {
        return this.eQj;
    }

    public boolean aKi() {
        final long n = -7371658355298920343L;
        this.aKj();
        aKg();
        final long n2 = (long)(this.eQf ? 1 : 0) << 32;
        final long n3 = n;
        final long n4 = n3 ^ ((n2 ^ n3) & -1L << 32);
        this.cT((boolean)((int)(n4 >>> 32) != 0));
        return (int)(n4 >>> 32) != 0;
    }

    public void a(final c c) {
        c.a(this);
    }

    public void aKj() {
        final long n = 2697462253570956184L;
        final long n2 = -2890373160484677072L;
        try {
            final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            final long n3 = 0L;
            final long n4 = n2;
            final long n5 = n4 ^ ((n3 ^ n4) & -1L << 32);
            final StackTraceElement[] array = (StackTraceElement[])stackTrace;
            final long n6 = (long)((StackTraceElement[])array).length << 32;
            final long n7 = n;
            final long n8 = n7 ^ ((n6 ^ n7) & -1L << 32);
            final long n9 = 0L;
            final long n10 = n5;
            long n11;
            long n14;
            for (n11 = (n10 ^ ((n9 ^ n10) & -1L >>> 32)); (int)n11 < (int)(n8 >>> 32); n11 = (n14 ^ ((n14 ^ n14 + 1) & -1L >>> 32))) {
                final String className = ((StackTraceElement[])array)[(int)n11].getClassName();
                if (((String)className).contains("LoginMenu") || ((String)className).contains("ServerPacketHandler") || ((String)className).contains("BackendPacketEvent")) {
                    final long n12 = 4294967296L;
                    final long n13 = n11;
                    n11 = (n13 ^ ((n12 ^ n13) & -1L << 32));
                    break;
                }
                n14 = n11;
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
        ((JSONObject)jsonObject).put("a", this.eQf);
        ((JSONObject)jsonObject).put("b", 3.141592653589793);
        ((JSONObject)jsonObject).put("c", 90.0f);
        ((JSONObject)jsonObject).put("d", System.currentTimeMillis());
        ((JSONObject)jsonObject).put("e", (Object)this.eOM);
        ((JSONObject)jsonObject).put("f", (Object)this.eQj);
        ((JSONObject)jsonObject).put("id", (int)this.aeq());
        return ((JSONObject)jsonObject).toString();
    }

    public static String aJX() {
        return new String((char[])new char[] { 'r', 'i', 'p', '.' }) + new String((char[])new char[] { 'v', 'a', 'n', 't', 'a', 'g', 'e', '.' }) + new String((char[])new char[] { 's', 'e', 'c', 'u', 'r', 'i', 't', 'y', '.' }) + new String((char[])new char[] { 'P', 'r', 'o', 'o', 'f', 'O', 'f', 'W', 'o', 'r', 'k' });
    }

    static {
        Oo0o00000O00();
        final long n = 8206604562419419418L;
        long n2 = -8396133904584098207L;
        long n3 = -6240036008439105079L;
        long n4 = -9222199121060613376L;
        final long n5 = -4695731078722333687L;
        long n6 = -4813147122225441300L;
        final long n7 = 3623040437861569829L;
        b.o0Oo000O0oO = new Object[62];
        final long n8 = 0L;
        final long n9 = n7;
        long n10 = n9 ^ ((n8 ^ n9) & -1L << 32);
        final Object[] array = { b.fld_0OOOoo00o0_91, Integer.valueOf(0), null };
        final int n11 = 2;
        Object o;
        if ((o = mth_0OOOoo00o0_45()[0]) == null) {
            final char[] charArray = "\uc3f9\uc44b\uc3e7\uc3e0\uc3d2\uc44c\uc3e5\uc410\uc3d7\uc3e0\uc3e4\uc3da\uc3f9\uc42b\uc441\uc3e0\uc44c\uc440\uc394\uc3f3\uc3e6\uc3f2\uc3e3\uc3d3\uc3da\uc44c\uc3d7\uc3d9\uc3e5\uc3e4\uc440\uc3f6\uc3f9\uc445\uc3d3\uc3d3\uc450\uc3df\uc442\uc3e7\uc396\uc394\uc3f9\uc39a\uc3e0\uc39a\uc3df\uc3d3\uc3f3\uc3dc\uc450\uc3e0\uc396\uc3fe\uc445\uc3d8\uc394\uc3f7\uc410\uc441\uc3de\uc3f9\uc444\uc39a\uc3da\uc3f5\uc3dc\uc3fb\uc396\uc3d2\uc441\uc3f9\uc44b\uc410\uc3fc\uc44b\uc39e\uc42b\uc444\uc3f8\uc3f9\uc3f2\uc3f2\uc3f1\uc3de\uc3dd\uc39d\uc3f5\uc445\uc444\uc3e0\uc3e3\uc446\uc3d6\uc3f5\uc39e\uc3de\uc3e5\uc3d9\uc3f5\uc3e1\uc3db\uc3f3\uc3fa\uc440\uc3d8\uc3f8\uc39d\uc3d7\uc3f0\uc3df\uc3d8\uc3e2\uc447\uc3ec\uc3fd\uc42b\uc3e7\uc443\uc3d9\uc450\uc39d\uc3fc\uc442\uc3e1\uc3d7\uc393\uc3f8\uc442\uc3f3\uc3d4\uc3e1\uc3e3\uc445\uc393\uc442\uc3d6\uc3d7\uc3e5\uc42b\uc451\uc3da\uc3d9\uc447\uc3d7\uc39a\uc42b\uc450\uc395\uc3e5\uc3e7\uc3f9\uc3f3\uc393\uc3e4\uc445\uc393\uc3d6\uc3da\uc3d5\uc3e0\uc3fb\uc39d\uc444\uc39a\uc39e\uc3f5\uc3d2\uc3de\uc394\uc3e6\uc44b\uc395\uc3d6\uc3f0\uc410\uc3f3\uc39e\uc410\uc3e4\uc3e3\uc3f5\uc3d5\uc411\uc441\uc3e7\uc3dd\uc39a\uc3fa\uc394\uc392\uc3d7\uc3f3\uc396\uc3fd\uc3dd\uc3e1\uc443\uc3da\uc3e2\uc3e1\uc3fc\uc3f0\uc3ff\uc451\uc3fb\uc39c\uc3fb\uc447\uc411\uc3f8\uc3e3\uc3f6\uc450\uc3d6\uc440\uc3d5\uc3d5\uc3f8\uc3f6\uc3da\uc3e0\uc39c\uc396\uc3e3\uc410\uc3f2\uc3e2\uc3fb\uc3e3\uc3e1\uc3f2\uc3e0\uc395\uc39a\uc3e5\uc3ff\uc3fe\uc3fc\uc3f8\uc3e3\uc441\uc3f7\uc3fa\uc3e3\uc3df\uc3d2\uc392\uc3f9\uc397\uc410\uc3f2\uc39a\uc3d4\uc3f7\uc392\uc3f5\uc3e6\uc440\uc39c\uc440\uc3e6\uc393\uc3db\uc446\uc3de\uc3f5\uc3df\uc3e3\uc3f2\uc39e\uc39d\uc3dc\uc42b\uc39c\uc3fa\uc446\uc3e0\uc3f9\uc44b\uc39a\uc3f4\uc3fa\uc3e0\uc3f4\uc3fa\uc3d2\uc392\uc447\uc3dd\uc3f3\uc3d2\uc3d2\uc3d8\uc3d8\uc3d2\uc39c\uc3f0\uc3fa\uc3f0\uc3f8\uc3f6\uc442\uc3d5\uc3d4\uc3e5\uc3fe\uc3d5\uc451\uc445\uc3ec\uc394\uc3dd\uc395\uc3dc\uc442\uc3f3\uc441\uc44c\uc3fc\uc3f9\uc397\uc3e1\uc3f8\uc3f1\uc3da\uc397\uc443\uc3d8\uc3db\uc3e5\uc3f2\uc3f5\uc444\uc3d2\uc443\uc3de\uc42b\uc3f1\uc442\uc3f0\uc3fc\uc443\uc3e2\uc446\uc3fb\uc3f8\uc394\uc3ec\uc42b\uc3da\uc39d\uc3de\uc3f8\uc3d4\uc444\uc410\uc392\uc3f1\uc3f3\uc3f5\uc3d5\uc3e4\uc3dc\uc44c\uc395\uc3fa\uc3e2\uc44c\uc450\uc3f6\uc3ff\uc411\uc3fd\uc3d9\uc447\uc3f0\uc3d7\uc3d9\uc3d7\uc3db\uc394\uc3d4\uc3e1\uc450\uc3e0\uc445\uc3d7\uc446\uc450\uc3f5\uc447\uc451\uc3d4\uc3d3\uc42b\uc3f8\uc3f2\uc3e0\uc3ec\uc3da\uc3f7\uc411\uc39e\uc44c\uc3f5\uc445\uc3e3\uc446\uc3e7\uc3e1\uc3d3\uc451\uc3f2\uc3e0\uc3e4\uc3e0\uc443\uc3d4\uc393\uc442\uc3fe\uc3d7\uc44c\uc3e6\uc3e2\uc3d6\uc440\uc44b\uc44b\uc3f6\uc3f8\uc3f8\uc447\uc3e1\uc3da\uc440\uc3fd\uc3d9\uc393\uc44c\uc3e6\uc3dc\uc3d8\uc3e4\uc3ec\uc450\uc3d9\uc394\uc440\uc410\uc3fe\uc444\uc3f2\uc3e5\uc392\uc394\uc447\uc410\uc39c\uc3e2\uc446\uc411\uc3f4\uc3f5\uc3d2\uc3f7\uc392\uc396\uc392\uc3f2\uc394\uc3d6\uc39e\uc447\uc3dc\uc3d9\uc3fa\uc3f1\uc3f2\uc441\uc3e5\uc3f3\uc445\uc442\uc3e7\uc441\uc3e4\uc3d4\uc3f3\uc3db\uc39a\uc3fd\uc444\uc39a\uc3d2\uc441\uc3f5\uc3f0\uc3e7\uc410\uc440\uc3df\uc3e0\uc3dc\uc44b\uc3fb\uc445\uc44c\uc3e7\uc3e5\uc3e7\uc394\uc3e7\uc395\uc442\uc39e\uc3d8\uc395\uc395\uc397\uc393\uc3df\uc3e5\uc3d8\uc3f0\uc3e6\uc3fe\uc3f5\uc3fa\uc395\uc3e3\uc3f2\uc3d9\uc3e4\uc3f7\uc44c\uc442\uc3d6\uc39e\uc3f7\uc3f7\uc3d6\uc3f0\uc411\uc397\uc3f8\uc3f1\uc3d4\uc3ff\uc3d4\uc3e6\uc444\uc441\uc445\uc3e0\uc3d5\uc3d8\uc3f6\uc39d\uc447\uc3d8\uc39d\uc3df\uc396\uc3db\uc3de\uc3f3\uc395\uc450\uc445\uc3d8\uc44b\uc442\uc3ec\uc3f5\uc3d2\uc3fd\uc3df\uc3d5\uc3f2\uc44c\uc3fc\uc3df\uc3d4\uc42b\uc3ff\uc3d7\uc3fe\uc3ec\uc3f8\uc440\uc395\uc42b\uc393\uc447\uc395\uc3f2\uc39d\uc3e4\uc39e\uc3d9\uc3dc\uc397\uc3e0\uc42b\uc3df\uc450\uc42b\uc3fd\uc442\uc3f2\uc3d9\uc3d5\uc3e0\uc445\uc392\uc44b\uc3fc\uc44b\uc446\uc3fd\uc3e0\uc3fc\uc3fa\uc3e6\uc3e3\uc3df\uc397\uc393\uc3d7\uc3d7\uc395\uc450\uc3f7\uc411\uc411\uc3e4\uc410\uc3d7\uc3d2\uc3fa\uc396\uc3d2\uc3f6\uc3e3\uc3f9\uc3d7\uc3f0\uc3e6\uc441\uc396\uc3e1\uc3f6\uc3f0\uc3fa\uc3fc\uc3f0\uc39c\uc411\uc396\uc446\uc3e8\uc3e8".toCharArray();
            for (int i = 0; i < 664; ++i) {
                ((char[])charArray)[i] = (char)(((((char[])charArray)[i] + '\u45f4' - 27206 ^ 0x2066 ^ 0x82A7) - 37399 + 31081 ^ 0x6DEA) + 53755 + 7469 - 14382);
            }
            o = (mth_0OOOoo00o0_45()[0] = new String(charArray));
        }
        array[n11] = o;
        final char[] charArray2 = ((String)o0Oo000O0oO(array)).toCharArray();
        final long n12 = 1997159792640L;
        final long n13 = n;
        final long n14 = n13 ^ ((n12 ^ n13) & -1L << 32);
        final long n15 = 0L;
        final long n16 = n5;
        long n33;
        long n34;
        for (long n17 = n16 ^ ((n15 ^ n16) & -1L >>> 32); (int)n17 < (int)(n14 >>> (142 - 99 ^ 0xB)); n17 = (n34 ^ ((n33 ^ n34) & -1L >>> 32))) {
            final char[] array2 = (char[])charArray2;
            final int n18 = (int)n17;
            final long n19 = n17;
            final long n20 = n19 ^ ((n19 ^ n19 + 1) & -1L >>> 32);
            final long n21 = (long)array2[n18];
            final long n22 = n2;
            n2 = (n22 ^ ((n21 ^ n22) & -1L >>> 32));
            final char[] array3 = (char[])charArray2;
            final int n23 = (int)n20;
            final long n24 = n20;
            final long n25 = n24 ^ ((n24 ^ n24 + 1) & -1L >>> 32);
            final long n26 = (long)array3[n23] << 32;
            final long n27 = n3;
            n3 = (n27 ^ ((n26 ^ n27) & -1L << 32));
            final long n28 = (long)((int)n2 << 16 | (int)(n3 >>> 32));
            final long n29 = n4;
            n4 = (n29 ^ ((n28 ^ n29) & -1L >>> 32));
            final char[] array4 = new char[(int)n4];
            final long n30 = 0L;
            final long n31 = n6;
            for (n6 = (n31 ^ ((n30 ^ n31) & -1L << 32)); (int)(n6 >>> 32) < (int)n4; n6 += 4294967296L) {
                ((char[])array4)[(int)(n6 >>> 32)] = ((char[])charArray2)[(int)n25 + (int)(n6 >>> 32)];
            }
            final Object[] o0Oo000O0oO = b.o0Oo000O0oO;
            final int n32 = (int)(n10 >>> 32);
            n10 += 4294967296L;
            o0Oo000O0oO[n32] = new String(array4);
            n33 = (int)n25 + (int)n4;
            n34 = n25;
        }
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

    public static Object o0Oo000O0oO(final Object[] array) {
        try {
            try {
                final int intValue = (int)array[1];
                final String s = (String)array[2];
                final Object o = array[0];
                Object[] oo00O0OO0ooO;
                if ((oo00O0OO0ooO = b.oO00O0OO0ooO) == null) {
                    oo00O0OO0ooO = (b.oO00O0OO0ooO = new Object[] { null });
                }
                Object o2;
                if ((o2 = oo00O0OO0ooO[intValue]) == null) {
                    Object[] array2;
                    if ((array2 = (Object[])o) == null) {
                        final Object[] array3 = b.fld_0OOOoo00o0_91 = (array2 = new Object[] { null });
                        final int n = 0;
                        final byte[] array4 = new byte[16];
                        ((byte[])array4)[4] = 94;
                        ((byte[])array4)[10] = 99;
                        ((byte[])array4)[13] = 104;
                        ((byte[])array4)[6] = -8;
                        ((byte[])array4)[12] = 124;
                        ((byte[])array4)[8] = 7;
                        ((byte[])array4)[1] = -60;
                        ((byte[])array4)[0] = 89;
                        ((byte[])array4)[14] = -39;
                        ((byte[])array4)[2] = -19;
                        ((byte[])array4)[3] = -30;
                        ((byte[])array4)[7] = 36;
                        ((byte[])array4)[9] = 92;
                        ((byte[])array4)[11] = -32;
                        ((byte[])array4)[15] = 121;
                        ((byte[])array4)[5] = -47;
                        array3[n] = array4;
                    }
                    final byte[] array5 = (byte[])array2[0];
                    if (b.Oo0o00000O00 == null) {
                        final byte[] array6 = new byte[32];
                        ((byte[])array6)[20] = 65;
                        ((byte[])array6)[29] = -20;
                        ((byte[])array6)[31] = -102;
                        ((byte[])array6)[9] = 85;
                        ((byte[])array6)[27] = 80;
                        ((byte[])array6)[2] = -32;
                        ((byte[])array6)[18] = 8;
                        ((byte[])array6)[28] = -10;
                        ((byte[])array6)[19] = 28;
                        ((byte[])array6)[16] = 115;
                        ((byte[])array6)[11] = 100;
                        ((byte[])array6)[3] = 48;
                        ((byte[])array6)[21] = 123;
                        ((byte[])array6)[8] = 126;
                        ((byte[])array6)[23] = 78;
                        ((byte[])array6)[10] = 80;
                        ((byte[])array6)[13] = -37;
                        ((byte[])array6)[12] = -10;
                        ((byte[])array6)[14] = 6;
                        ((byte[])array6)[30] = -48;
                        ((byte[])array6)[25] = 89;
                        ((byte[])array6)[17] = 118;
                        ((byte[])array6)[0] = 41;
                        ((byte[])array6)[4] = 71;
                        ((byte[])array6)[6] = -112;
                        ((byte[])array6)[7] = 0;
                        ((byte[])array6)[22] = 126;
                        ((byte[])array6)[24] = -94;
                        ((byte[])array6)[5] = 14;
                        ((byte[])array6)[1] = -128;
                        ((byte[])array6)[15] = -119;
                        ((byte[])array6)[26] = 60;
                        final byte[] array7 = new byte[((byte[])array5).length + ((byte[])array6).length];
                        System.arraycopy(array5, 0, array7, 0, ((byte[])array5).length);
                        System.arraycopy(array6, 0, array7, ((byte[])array5).length, ((byte[])array6).length);
                        Object o3;
                        if ((o3 = mth_0OOOoo00o0_45()[1]) == null) {
                            final char[] charArray = "\ufaa6\uf978\ufaa5\ufaba\ufa8c\ufa68\uf941\uf823\uf82a\uf86e\ufa8e\uf807\uf82b\uf86d\uf95d\ufa8e\uf94b\uf97b".toCharArray();
                            for (int i = 0; i < 18; ++i) {
                                ((char[])charArray)[i] = (char)((((((((char[])charArray)[i] ^ '\u4353') + 6868 ^ 0xF475) + 47510 ^ 0x567) + 2183 ^ 0xE779) + 35066 ^ 0x991E ^ 0xE9CE) - 63775);
                            }
                            o3 = (mth_0OOOoo00o0_45()[1] = new String(charArray));
                        }
                        final SecretKeyFactory instance = SecretKeyFactory.getInstance((String)o3);
                        final byte[] array8 = new byte[16];
                        ((byte[])array8)[15] = 67;
                        ((byte[])array8)[14] = -57;
                        ((byte[])array8)[2] = 88;
                        ((byte[])array8)[0] = 31;
                        ((byte[])array8)[9] = 39;
                        ((byte[])array8)[5] = 12;
                        ((byte[])array8)[7] = 11;
                        ((byte[])array8)[13] = 66;
                        ((byte[])array8)[12] = -8;
                        ((byte[])array8)[1] = 48;
                        ((byte[])array8)[10] = -83;
                        ((byte[])array8)[6] = 49;
                        ((byte[])array8)[11] = 33;
                        ((byte[])array8)[8] = 3;
                        ((byte[])array8)[3] = -87;
                        ((byte[])array8)[4] = 32;
                        final byte[] key = (byte[])((SecretKeyFactory)instance).generateSecret(new PBEKeySpec(new String(array7, StandardCharsets.UTF_8).toCharArray(), array8, 29, 256)).getEncoded();
                        Object o4;
                        if ((o4 = mth_0OOOoo00o0_45()[2]) == null) {
                            final char[] charArray2 = "\u5278\u5274\u526a".toCharArray();
                            for (int j = 0; j < 3; ++j) {
                                ((char[])charArray2)[j] = (char)(((((char[])charArray2)[j] ^ '\u30f1') - 33939 + 58995 - 19446 + 61398 ^ 0xEB57 ^ 0xC5A) + 30843 - 19051 + 17133);
                            }
                            o4 = (mth_0OOOoo00o0_45()[2] = new String(charArray2));
                        }
                        b.Oo0o00000O00 = new SecretKeySpec(key, (String)o4);
                    }
                    final byte[] decode = Base64.getDecoder().decode(s);
                    final byte[] copyOfRange = Arrays.copyOfRange(decode, 0, 16);
                    final byte[] copyOfRange2 = Arrays.copyOfRange(decode, 16, ((byte[])decode).length);
                    Object o5;
                    if ((o5 = mth_0OOOoo00o0_45()[3]) == null) {
                        final char[] charArray3 = "\ueb6e\ueb72\ueb60\uec4c\ueb70\ueb6f\ueb70\uec4c\ueb5d\ueb68\ueb70\ueb60\uec42\ueb5d\ueb8e\ueb91\ueb91\ueb66\ueb8b\ueb94".toCharArray();
                        for (int k = 0; k < 20; ++k) {
                            ((char[])charArray3)[k] = (char)(((((char[])charArray3)[k] + '\ua223' ^ 0x4D43 ^ 0x8AD4) - 52517 + 54343 ^ 0x707 ^ 0x6588) - 50185 - 4316 + 17404 - 41597);
                        }
                        o5 = (mth_0OOOoo00o0_45()[3] = new String(charArray3));
                    }
                    final Cipher instance2 = Cipher.getInstance((String)o5);
                    ((Cipher)instance2).init(2, (java.security.Key)b.Oo0o00000O00, (AlgorithmParameterSpec)new IvParameterSpec(copyOfRange));
                    o2 = (b.oO00O0OO0ooO[intValue] = new String(((Cipher)instance2).doFinal(copyOfRange2), StandardCharsets.UTF_8));
                }
                return o2;
            } catch (java.security.NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        } catch (java.security.GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    public static void Oo0o00000O00() {
        (b.O0OoOO0OOOOO = new int[400])[15] = 68;
        b.O0OoOO0OOOOO[25] = -100;
        b.O0OoOO0OOOOO[120] = -104;
        b.O0OoOO0OOOOO[367] = 17;
        b.O0OoOO0OOOOO[324] = 101;
        b.O0OoOO0OOOOO[357] = 76;
        b.O0OoOO0OOOOO[371] = -8;
        b.O0OoOO0OOOOO[327] = -22;
        b.O0OoOO0OOOOO[229] = -127;
        b.O0OoOO0OOOOO[35] = -27;
        b.O0OoOO0OOOOO[129] = -109;
        b.O0OoOO0OOOOO[133] = -33;
        b.O0OoOO0OOOOO[29] = 29;
        b.O0OoOO0OOOOO[224] = 72;
        b.O0OoOO0OOOOO[17] = -16;
        b.O0OoOO0OOOOO[66] = 104;
        b.O0OoOO0OOOOO[351] = -101;
        b.O0OoOO0OOOOO[346] = 73;
        b.O0OoOO0OOOOO[231] = 81;
        b.O0OoOO0OOOOO[383] = -107;
        b.O0OoOO0OOOOO[282] = 119;
        b.O0OoOO0OOOOO[356] = 115;
        b.O0OoOO0OOOOO[330] = 118;
        b.O0OoOO0OOOOO[160] = -94;
        b.O0OoOO0OOOOO[328] = -119;
        b.O0OoOO0OOOOO[390] = 24;
        b.O0OoOO0OOOOO[397] = 69;
        b.O0OoOO0OOOOO[243] = -67;
        b.O0OoOO0OOOOO[52] = 65;
        b.O0OoOO0OOOOO[238] = 86;
        b.O0OoOO0OOOOO[287] = 69;
        b.O0OoOO0OOOOO[317] = 128;
        b.O0OoOO0OOOOO[219] = -18;
        b.O0OoOO0OOOOO[6] = 67;
        b.O0OoOO0OOOOO[216] = 6;
        b.O0OoOO0OOOOO[32] = -121;
        b.O0OoOO0OOOOO[228] = 24;
        b.O0OoOO0OOOOO[283] = 88;
        b.O0OoOO0OOOOO[51] = 33;
        b.O0OoOO0OOOOO[205] = -124;
        b.O0OoOO0OOOOO[22] = -41;
        b.O0OoOO0OOOOO[195] = 41;
        b.O0OoOO0OOOOO[237] = 37;
        b.O0OoOO0OOOOO[208] = -18;
        b.O0OoOO0OOOOO[341] = 43;
        b.O0OoOO0OOOOO[1] = -71;
        b.O0OoOO0OOOOO[81] = -68;
        b.O0OoOO0OOOOO[244] = 36;
        b.O0OoOO0OOOOO[37] = -88;
        b.O0OoOO0OOOOO[246] = 116;
        b.O0OoOO0OOOOO[180] = 70;
        b.O0OoOO0OOOOO[90] = 148;
        b.O0OoOO0OOOOO[3] = -129;
        b.O0OoOO0OOOOO[69] = 3;
        b.O0OoOO0OOOOO[78] = 41;
        b.O0OoOO0OOOOO[92] = 79;
        b.O0OoOO0OOOOO[114] = 22;
        b.O0OoOO0OOOOO[196] = -47;
        b.O0OoOO0OOOOO[102] = -95;
        b.O0OoOO0OOOOO[215] = 28;
        b.O0OoOO0OOOOO[322] = -58;
        b.O0OoOO0OOOOO[10] = 117;
        b.O0OoOO0OOOOO[221] = -87;
        b.O0OoOO0OOOOO[241] = -5;
        b.O0OoOO0OOOOO[177] = -1;
        b.O0OoOO0OOOOO[4] = -69;
        b.O0OoOO0OOOOO[236] = 115;
        b.O0OoOO0OOOOO[100] = 115;
        b.O0OoOO0OOOOO[164] = -14;
        b.O0OoOO0OOOOO[119] = -83;
        b.O0OoOO0OOOOO[156] = 57;
        b.O0OoOO0OOOOO[79] = -71;
        b.O0OoOO0OOOOO[352] = -78;
        b.O0OoOO0OOOOO[49] = -42;
        b.O0OoOO0OOOOO[292] = -113;
        b.O0OoOO0OOOOO[82] = 17;
        b.O0OoOO0OOOOO[275] = 84;
        b.O0OoOO0OOOOO[372] = -17;
        b.O0OoOO0OOOOO[318] = 110;
        b.O0OoOO0OOOOO[222] = -20;
        b.O0OoOO0OOOOO[146] = -48;
        b.O0OoOO0OOOOO[76] = -100;
        b.O0OoOO0OOOOO[264] = -41;
        b.O0OoOO0OOOOO[77] = 31;
        b.O0OoOO0OOOOO[217] = 26;
        b.O0OoOO0OOOOO[358] = -61;
        b.O0OoOO0OOOOO[234] = -20;
        b.O0OoOO0OOOOO[206] = 114;
        b.O0OoOO0OOOOO[85] = -11;
        b.O0OoOO0OOOOO[312] = -36;
        b.O0OoOO0OOOOO[45] = -174;
        b.O0OoOO0OOOOO[293] = -76;
        b.O0OoOO0OOOOO[311] = 103;
        b.O0OoOO0OOOOO[14] = -60;
        b.O0OoOO0OOOOO[398] = 2;
        b.O0OoOO0OOOOO[334] = -77;
        b.O0OoOO0OOOOO[168] = -50;
        b.O0OoOO0OOOOO[214] = 50;
        b.O0OoOO0OOOOO[169] = 2;
        b.O0OoOO0OOOOO[384] = 63;
        b.O0OoOO0OOOOO[39] = 33;
        b.O0OoOO0OOOOO[125] = -62;
        b.O0OoOO0OOOOO[96] = 59;
        b.O0OoOO0OOOOO[248] = -111;
        b.O0OoOO0OOOOO[94] = -12;
        b.O0OoOO0OOOOO[242] = -118;
        b.O0OoOO0OOOOO[360] = 48;
        b.O0OoOO0OOOOO[187] = 39;
        b.O0OoOO0OOOOO[131] = -95;
        b.O0OoOO0OOOOO[362] = 33;
        b.O0OoOO0OOOOO[165] = 43;
        b.O0OoOO0OOOOO[38] = 109;
        b.O0OoOO0OOOOO[387] = -121;
        b.O0OoOO0OOOOO[42] = -34;
        b.O0OoOO0OOOOO[284] = 42;
        b.O0OoOO0OOOOO[203] = -44;
        b.O0OoOO0OOOOO[380] = 125;
        b.O0OoOO0OOOOO[258] = 57;
        b.O0OoOO0OOOOO[173] = 56;
        b.O0OoOO0OOOOO[305] = 160;
        b.O0OoOO0OOOOO[321] = -117;
        b.O0OoOO0OOOOO[23] = 43;
        b.O0OoOO0OOOOO[226] = -57;
        b.O0OoOO0OOOOO[140] = -73;
        b.O0OoOO0OOOOO[366] = -113;
        b.O0OoOO0OOOOO[95] = -127;
        b.O0OoOO0OOOOO[157] = -28;
        b.O0OoOO0OOOOO[181] = 96;
        b.O0OoOO0OOOOO[132] = 66;
        b.O0OoOO0OOOOO[361] = -89;
        b.O0OoOO0OOOOO[198] = -56;
        b.O0OoOO0OOOOO[175] = 3;
        b.O0OoOO0OOOOO[329] = 29;
        b.O0OoOO0OOOOO[151] = -83;
        b.O0OoOO0OOOOO[342] = -54;
        b.O0OoOO0OOOOO[344] = -65;
        b.O0OoOO0OOOOO[91] = 37;
        b.O0OoOO0OOOOO[235] = -41;
        b.O0OoOO0OOOOO[153] = -107;
        b.O0OoOO0OOOOO[210] = 38;
        b.O0OoOO0OOOOO[343] = -24;
        b.O0OoOO0OOOOO[40] = -3;
        b.O0OoOO0OOOOO[209] = 143;
        b.O0OoOO0OOOOO[182] = 38;
        b.O0OoOO0OOOOO[333] = -83;
        b.O0OoOO0OOOOO[254] = 47;
        b.O0OoOO0OOOOO[178] = 120;
        b.O0OoOO0OOOOO[304] = -73;
        b.O0OoOO0OOOOO[257] = 65;
        b.O0OoOO0OOOOO[7] = 21;
        b.O0OoOO0OOOOO[347] = 116;
        b.O0OoOO0OOOOO[276] = -86;
        b.O0OoOO0OOOOO[139] = -7;
        b.O0OoOO0OOOOO[46] = -101;
        b.O0OoOO0OOOOO[155] = -108;
        b.O0OoOO0OOOOO[126] = -15;
        b.O0OoOO0OOOOO[99] = 11;
        b.O0OoOO0OOOOO[47] = -105;
        b.O0OoOO0OOOOO[251] = 121;
        b.O0OoOO0OOOOO[315] = -123;
        b.O0OoOO0OOOOO[130] = 46;
        b.O0OoOO0OOOOO[144] = -48;
        b.O0OoOO0OOOOO[101] = -72;
        b.O0OoOO0OOOOO[331] = 109;
        b.O0OoOO0OOOOO[225] = -19;
        b.O0OoOO0OOOOO[377] = 249;
        b.O0OoOO0OOOOO[21] = 84;
        b.O0OoOO0OOOOO[376] = -54;
        b.O0OoOO0OOOOO[220] = -53;
        b.O0OoOO0OOOOO[193] = -3;
        b.O0OoOO0OOOOO[204] = 48;
        b.O0OoOO0OOOOO[393] = 6;
        b.O0OoOO0OOOOO[306] = -85;
        b.O0OoOO0OOOOO[265] = 79;
        b.O0OoOO0OOOOO[340] = 95;
        b.O0OoOO0OOOOO[86] = -45;
        b.O0OoOO0OOOOO[274] = -124;
        b.O0OoOO0OOOOO[179] = -123;
        b.O0OoOO0OOOOO[65] = -76;
        b.O0OoOO0OOOOO[13] = -20;
        b.O0OoOO0OOOOO[19] = 8;
        b.O0OoOO0OOOOO[394] = -28;
        b.O0OoOO0OOOOO[190] = -51;
        b.O0OoOO0OOOOO[309] = 48;
        b.O0OoOO0OOOOO[288] = 96;
        b.O0OoOO0OOOOO[385] = -96;
        b.O0OoOO0OOOOO[121] = 17;
        b.O0OoOO0OOOOO[250] = -126;
        b.O0OoOO0OOOOO[277] = -107;
        b.O0OoOO0OOOOO[122] = -88;
        b.O0OoOO0OOOOO[152] = 110;
        b.O0OoOO0OOOOO[336] = -120;
        b.O0OoOO0OOOOO[399] = -86;
        b.O0OoOO0OOOOO[123] = -29;
        b.O0OoOO0OOOOO[118] = -66;
        b.O0OoOO0OOOOO[161] = 77;
        b.O0OoOO0OOOOO[350] = 40;
        b.O0OoOO0OOOOO[64] = 67;
        b.O0OoOO0OOOOO[70] = -123;
        b.O0OoOO0OOOOO[176] = -45;
        b.O0OoOO0OOOOO[227] = -115;
        b.O0OoOO0OOOOO[289] = -73;
        b.O0OoOO0OOOOO[349] = 108;
        b.O0OoOO0OOOOO[150] = 5;
        b.O0OoOO0OOOOO[396] = 16;
        b.O0OoOO0OOOOO[245] = 30;
        b.O0OoOO0OOOOO[87] = -119;
        b.O0OoOO0OOOOO[142] = 6;
        b.O0OoOO0OOOOO[247] = 126;
        b.O0OoOO0OOOOO[110] = -76;
        b.O0OoOO0OOOOO[194] = -8;
        b.O0OoOO0OOOOO[395] = 131;
        b.O0OoOO0OOOOO[154] = -42;
        b.O0OoOO0OOOOO[199] = -62;
        b.O0OoOO0OOOOO[185] = 75;
        b.O0OoOO0OOOOO[54] = -70;
        b.O0OoOO0OOOOO[335] = 112;
        b.O0OoOO0OOOOO[307] = 73;
        b.O0OoOO0OOOOO[230] = -104;
        b.O0OoOO0OOOOO[127] = -53;
        b.O0OoOO0OOOOO[388] = 57;
        b.O0OoOO0OOOOO[256] = -63;
        b.O0OoOO0OOOOO[379] = -27;
        b.O0OoOO0OOOOO[313] = 72;
        b.O0OoOO0OOOOO[80] = -126;
        b.O0OoOO0OOOOO[363] = 68;
        b.O0OoOO0OOOOO[249] = 7;
        b.O0OoOO0OOOOO[290] = 88;
        b.O0OoOO0OOOOO[5] = -59;
        b.O0OoOO0OOOOO[8] = -56;
        b.O0OoOO0OOOOO[84] = -2;
        b.O0OoOO0OOOOO[31] = -102;
        b.O0OoOO0OOOOO[30] = 347;
        b.O0OoOO0OOOOO[255] = -110;
        b.O0OoOO0OOOOO[2] = 109;
        b.O0OoOO0OOOOO[72] = -91;
        b.O0OoOO0OOOOO[202] = -47;
        b.O0OoOO0OOOOO[55] = -121;
        b.O0OoOO0OOOOO[268] = -60;
        b.O0OoOO0OOOOO[137] = -95;
        b.O0OoOO0OOOOO[294] = 117;
        b.O0OoOO0OOOOO[263] = -124;
        b.O0OoOO0OOOOO[186] = -48;
        b.O0OoOO0OOOOO[267] = -103;
        b.O0OoOO0OOOOO[24] = -47;
        b.O0OoOO0OOOOO[261] = 43;
        b.O0OoOO0OOOOO[145] = 96;
        b.O0OoOO0OOOOO[345] = 8;
        b.O0OoOO0OOOOO[170] = 84;
        b.O0OoOO0OOOOO[53] = -64;
        b.O0OoOO0OOOOO[103] = 85;
        b.O0OoOO0OOOOO[43] = 36;
        b.O0OoOO0OOOOO[71] = 126;
        b.O0OoOO0OOOOO[98] = 7;
        b.O0OoOO0OOOOO[365] = -13;
        b.O0OoOO0OOOOO[33] = -147;
        b.O0OoOO0OOOOO[375] = -19;
        b.O0OoOO0OOOOO[240] = 19;
        b.O0OoOO0OOOOO[167] = -47;
        b.O0OoOO0OOOOO[61] = -86;
        b.O0OoOO0OOOOO[183] = -94;
        b.O0OoOO0OOOOO[172] = 49;
        b.O0OoOO0OOOOO[232] = 58;
        b.O0OoOO0OOOOO[280] = 25;
        b.O0OoOO0OOOOO[108] = 167;
        b.O0OoOO0OOOOO[58] = -65;
        b.O0OoOO0OOOOO[369] = 35;
        b.O0OoOO0OOOOO[124] = 33;
        b.O0OoOO0OOOOO[260] = -103;
        b.O0OoOO0OOOOO[337] = -15;
        b.O0OoOO0OOOOO[184] = -20;
        b.O0OoOO0OOOOO[308] = 72;
        b.O0OoOO0OOOOO[286] = 13;
        b.O0OoOO0OOOOO[323] = -38;
        b.O0OoOO0OOOOO[386] = -57;
        b.O0OoOO0OOOOO[135] = 120;
        b.O0OoOO0OOOOO[134] = 92;
        b.O0OoOO0OOOOO[320] = -240;
        b.O0OoOO0OOOOO[26] = 52;
        b.O0OoOO0OOOOO[355] = -55;
        b.O0OoOO0OOOOO[200] = 36;
        b.O0OoOO0OOOOO[302] = -34;
        b.O0OoOO0OOOOO[326] = 4;
        b.O0OoOO0OOOOO[117] = -117;
        b.O0OoOO0OOOOO[20] = 123;
        b.O0OoOO0OOOOO[73] = 48;
        b.O0OoOO0OOOOO[48] = 21;
        b.O0OoOO0OOOOO[298] = 124;
        b.O0OoOO0OOOOO[56] = 60;
        b.O0OoOO0OOOOO[212] = -49;
        b.O0OoOO0OOOOO[128] = 6;
        b.O0OoOO0OOOOO[252] = 4;
        b.O0OoOO0OOOOO[382] = -70;
        b.O0OoOO0OOOOO[364] = 102;
        b.O0OoOO0OOOOO[158] = 30;
        b.O0OoOO0OOOOO[278] = -77;
        b.O0OoOO0OOOOO[105] = -114;
        b.O0OoOO0OOOOO[149] = 37;
        b.O0OoOO0OOOOO[211] = -95;
        b.O0OoOO0OOOOO[191] = 56;
        b.O0OoOO0OOOOO[11] = 38;
        b.O0OoOO0OOOOO[188] = -77;
        b.O0OoOO0OOOOO[314] = -191;
        b.O0OoOO0OOOOO[296] = -103;
        b.O0OoOO0OOOOO[89] = 78;
        b.O0OoOO0OOOOO[223] = -86;
        b.O0OoOO0OOOOO[189] = -11;
        b.O0OoOO0OOOOO[300] = 113;
        b.O0OoOO0OOOOO[297] = 97;
        b.O0OoOO0OOOOO[301] = 1;
        b.O0OoOO0OOOOO[0] = 179;
        b.O0OoOO0OOOOO[104] = -9;
        b.O0OoOO0OOOOO[115] = 51;
        b.O0OoOO0OOOOO[41] = -4;
        b.O0OoOO0OOOOO[285] = 36;
        b.O0OoOO0OOOOO[299] = 113;
        b.O0OoOO0OOOOO[259] = 121;
        b.O0OoOO0OOOOO[319] = 14;
        b.O0OoOO0OOOOO[159] = 31;
        b.O0OoOO0OOOOO[316] = -80;
        b.O0OoOO0OOOOO[192] = -1;
        b.O0OoOO0OOOOO[291] = -33;
        b.O0OoOO0OOOOO[253] = -112;
        b.O0OoOO0OOOOO[74] = -75;
        b.O0OoOO0OOOOO[136] = 22;
        b.O0OoOO0OOOOO[27] = 53;
        b.O0OoOO0OOOOO[273] = 9;
        b.O0OoOO0OOOOO[68] = -11;
        b.O0OoOO0OOOOO[389] = 85;
        b.O0OoOO0OOOOO[303] = 8;
        b.O0OoOO0OOOOO[12] = 8;
        b.O0OoOO0OOOOO[218] = -37;
        b.O0OoOO0OOOOO[18] = -130;
        b.O0OoOO0OOOOO[148] = -116;
        b.O0OoOO0OOOOO[271] = 31;
        b.O0OoOO0OOOOO[28] = -82;
        b.O0OoOO0OOOOO[239] = 49;
        b.O0OoOO0OOOOO[59] = 34;
        b.O0OoOO0OOOOO[9] = 111;
        b.O0OoOO0OOOOO[166] = 58;
        b.O0OoOO0OOOOO[162] = -40;
        b.O0OoOO0OOOOO[116] = -41;
        b.O0OoOO0OOOOO[97] = 34;
        b.O0OoOO0OOOOO[57] = 97;
        b.O0OoOO0OOOOO[370] = 88;
        b.O0OoOO0OOOOO[163] = 26;
        b.O0OoOO0OOOOO[44] = -38;
        b.O0OoOO0OOOOO[374] = -30;
        b.O0OoOO0OOOOO[339] = 49;
        b.O0OoOO0OOOOO[113] = -30;
        b.O0OoOO0OOOOO[174] = -16;
        b.O0OoOO0OOOOO[332] = -125;
        b.O0OoOO0OOOOO[207] = 64;
        b.O0OoOO0OOOOO[36] = -165;
        b.O0OoOO0OOOOO[34] = 118;
        b.O0OoOO0OOOOO[147] = -153;
        b.O0OoOO0OOOOO[368] = 57;
        b.O0OoOO0OOOOO[88] = -25;
        b.O0OoOO0OOOOO[16] = 20;
        b.O0OoOO0OOOOO[279] = -104;
        b.O0OoOO0OOOOO[270] = 35;
        b.O0OoOO0OOOOO[381] = -49;
        b.O0OoOO0OOOOO[266] = 43;
        b.O0OoOO0OOOOO[281] = -79;
        b.O0OoOO0OOOOO[171] = -73;
        b.O0OoOO0OOOOO[310] = 10;
        b.O0OoOO0OOOOO[63] = -105;
        b.O0OoOO0OOOOO[295] = 41;
        b.O0OoOO0OOOOO[201] = 43;
        b.O0OoOO0OOOOO[93] = 147;
        b.O0OoOO0OOOOO[60] = 105;
        b.O0OoOO0OOOOO[338] = 188;
        b.O0OoOO0OOOOO[262] = 79;
        b.O0OoOO0OOOOO[213] = -1;
        b.O0OoOO0OOOOO[378] = -117;
        b.O0OoOO0OOOOO[107] = 42;
        b.O0OoOO0OOOOO[359] = 236;
        b.O0OoOO0OOOOO[348] = 107;
        b.O0OoOO0OOOOO[272] = -132;
        b.O0OoOO0OOOOO[373] = 123;
        b.O0OoOO0OOOOO[325] = 70;
        b.O0OoOO0OOOOO[233] = 33;
        b.O0OoOO0OOOOO[67] = -98;
        b.O0OoOO0OOOOO[391] = 44;
        b.O0OoOO0OOOOO[106] = 72;
        b.O0OoOO0OOOOO[353] = -121;
        b.O0OoOO0OOOOO[112] = 58;
        b.O0OoOO0OOOOO[109] = -59;
        b.O0OoOO0OOOOO[392] = -22;
        b.O0OoOO0OOOOO[62] = 62;
        b.O0OoOO0OOOOO[269] = 144;
        b.O0OoOO0OOOOO[197] = -5;
        b.O0OoOO0OOOOO[141] = -54;
        b.O0OoOO0OOOOO[75] = -98;
        b.O0OoOO0OOOOO[354] = -87;
        b.O0OoOO0OOOOO[50] = -31;
        b.O0OoOO0OOOOO[111] = -8;
        b.O0OoOO0OOOOO[138] = 90;
        b.O0OoOO0OOOOO[83] = -19;
        b.O0OoOO0OOOOO[143] = -7;
    }

    public void c(final boolean bFlag, final boolean b2, final boolean b3, final boolean b4, final boolean b5) {
        final long n = -8916039876471170094L;
        try {
            final long n2 = (long)((b2 && b3 && b4 && b5) ? 1 : 0) << 32;
            final long n3 = n;
            if ((bFlag ? 1 : 0) != (int)((n3 ^ ((n2 ^ n3) & -1L << 32)) >>> 32)) {
                System.out.println("EC36");
                final Field declaredField = this.getClass().getDeclaredField("success");
                ((Field)declaredField).setAccessible(true);
                ((Field)declaredField).set(this, Boolean.valueOf(false));
            }
            if (bFlag && (!b2 || !b3 || !b4 || !b5)) {
                System.out.println("EC37");
                final Field declaredField2 = this.getClass().getDeclaredField("success");
                ((Field)declaredField2).setAccessible(true);
                ((Field)declaredField2).set(this, Boolean.valueOf(false));
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
        final long n = -4225072733441483207L;
        final long n2 = 3330615166180782677L;
        long n3 = -5575152126601245434L;
        long n4 = 4058213722662846145L;
        try {
            final Class<?> forName = Class.forName(aJX());
            Method method = null;
            final Method[] declaredMethods = ((Class<?>)forName).getDeclaredMethods();
            final long n5 = (long)declaredMethods.length;
            final long n6 = n3;
            n3 = (n6 ^ ((n5 ^ n6) & -1L >>> 32));
            final long n7 = 0L;
            final long n8 = n4;
            for (n4 = (n8 ^ ((n7 ^ n8) & -1L << 32)); (int)(n4 >>> 32) < (int)n3; n4 += 4294967296L) {
                final Method method2 = declaredMethods[(int)(n4 >>> 32)];
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
        final long n9 = (long)(jsonObject.getBoolean("a") ? 1 : 0) << 32;
        final long n10 = n2;
        final long n11 = n10 ^ ((n9 ^ n10) & -1L << 32);
        try {
            final Class<?> forName2 = Class.forName(aJX());
            Method method3 = null;
            final Method[] declaredMethods2 = forName2.getDeclaredMethods();
            final long n12 = (long)((Method[])declaredMethods2).length << 32;
            final long n13 = n4;
            n4 = (n13 ^ ((n12 ^ n13) & -1L << 32));
            final long n14 = 0L;
            final long n15 = n4;
            long n16;
            for (n4 = (n15 ^ ((n14 ^ n15) & -1L >>> 32)); (int)n4 < (int)(n4 >>> 32); n4 = (n16 ^ ((n16 ^ n16 + 1) & -1L >>> 32))) {
                final Method method4 = ((Method[])declaredMethods2)[(int)n4];
                if (Modifier.isPublic(method4.getModifiers()) && Modifier.isStatic(method4.getModifiers()) && method4.getReturnType() == Void.TYPE && method4.getParameterCount() == 1 && method4.getParameterTypes()[0] == Boolean.TYPE) {
                    method3 = method4;
                    break;
                }
                n16 = n4;
            }
            if (method3 != null) {
                method3.invoke(null, Boolean.valueOf((boolean)((int)(n11 >>> 32) != 0)));
            }
        }
        catch (final Exception ex2) {}
        final String string = jsonObject.getString("e");
        final String optString = jsonObject.optString("f", "");
        this.eQj = optString;
        final long n17 = (long)(this.aE(string, optString) ? 1 : 0);
        final long n18 = n3;
        final long n19 = n18 ^ ((n17 ^ n18) & -1L >>> 32);
        final long n20 = (long)(this.m((boolean)((int)(n11 >>> 32) != 0), (boolean)((int)n19 != 0)) ? 1 : 0) << 32;
        final long n21 = n4;
        final long n22 = n21 ^ ((n20 ^ n21) & -1L << 32);
        final long n23 = (long)(this.n((boolean)((int)(n11 >>> 32) != 0), (boolean)((int)n19 != 0)) ? 1 : 0);
        final long n24 = n22;
        final long n25 = n24 ^ ((n23 ^ n24) & -1L >>> 32);
        final long n26 = (long)(((int)n19 == 0 || (int)(n25 >>> 32) == 0 || (int)n25 == 0) ? 1 : (-114 + b.O0OoOO0OOOOO[106] + 42)) << 32;
        final long n27 = n;
        final long n28 = n27 ^ ((n26 ^ n27) & -1L << 32);
        this.c(this.eQf = ((int)(n11 >>> 32) != 0 && (int)(n28 >>> 32) == 0), (boolean)((int)(n11 >>> 32) != 0), (boolean)((int)n19 != 0), (boolean)((int)(n25 >>> 32) != 0), (boolean)((int)n25 != 0));
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

    public static Object[] mth_0OOOoo00o0_45() {
        Object[] fld_0oOOoOo0O00O_92;
        if ((fld_0oOOoOo0O00O_92 = b.fld_0oOOoOo0O00O_92) == null) {
            fld_0oOOoOo0O00O_92 = (b.fld_0oOOoOo0O00O_92 = new Object[4]);
        }
        return fld_0oOOoOo0O00O_92;
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
        final long n = 7353636659324986445L;
        final long n2 = 4468805584694927464L;
        try {
            final String string = this.getClass().getName() + ".constructor";
            MessageDigest.getInstance("SHA-256");
            if (((String)string).length() >= 10) {
                ((String)string).contains("S2CPacketAuthentication");
            }
            final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            final long n3 = 0L;
            final long n4 = n2;
            final long n5 = n4 ^ ((n3 ^ n4) & -1L << 32);
            final StackTraceElement[] array = (StackTraceElement[])stackTrace;
            final long n6 = (long)((StackTraceElement[])array).length << 32;
            final long n7 = n;
            final long n8 = n7 ^ ((n6 ^ n7) & -1L << 32);
            final long n9 = 0L;
            final long n10 = n5;
            long n11;
            long n14;
            for (n11 = (n10 ^ ((n9 ^ n10) & -1L >>> 32)); (int)n11 < (int)(n8 >>> 32); n11 = (n14 ^ ((n14 ^ n14 + 1) & -1L >>> 32))) {
                final StackTraceElement stackTraceElement = ((StackTraceElement[])array)[(int)n11];
                if (stackTraceElement.getClassName().contains("WebSocketClient") || stackTraceElement.getClassName().contains("ServerPacketHandler")) {
                    final long n12 = 4294967296L;
                    final long n13 = n11;
                    n11 = (n13 ^ ((n12 ^ n13) & -1L << 32));
                    break;
                }
                n14 = n11;
            }
            if ((int)(n11 >>> 32) == 0) {
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
        final long n = -838929360264287475L;
        final long n2 = -2508622849679906202L;
        try {
            final String s3 = (String)((Method)((Class<?>)Class.forName(aJY())).getMethod("getHWID", (Class<?>[])new Class[0])).invoke(null, new Object[0]);
            if (s3 == null || ((String)s3).length() < 32 || !((String)s3).contains("dleotn6oc94kb")) {
                System.out.println("EC19");
                if (s3 == null || ((String)s3).length() < 10) {
                    this.aKc();
                }
                return false;
            }
            if (s2 != null && !s2.isEmpty()) {
                try {
                    final Class<?> forName = Class.forName(aJX());
                    Method method = null;
                    final Method[] declaredMethods = ((Class<?>)forName).getDeclaredMethods();
                    final long n3 = (long)((Method[])declaredMethods).length;
                    final long n4 = n2;
                    final long n5 = n4 ^ ((n3 ^ n4) & -1L >>> 32);
                    final long n6 = 0L;
                    final long n7 = n5;
                    for (long n8 = n7 ^ ((n6 ^ n7) & -1L << 32); (int)(n8 >>> 32) < (int)n8; n8 += 4294967296L) {
                        final Method method2 = ((Method[])declaredMethods)[(int)(n8 >>> 32)];
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
                    final long n9 = (long)(((boolean)method.invoke(null, s3, s2)) ? 1 : 0) << 32;
                    final long n10 = n;
                    if ((int)((n10 ^ ((n9 ^ n10) & -1L << 32)) >>> 32) == 0) {
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
            final String encodeToString = Base64.getEncoder().encodeToString(((MessageDigest)instance).digest(((String)s3).getBytes(StandardCharsets.UTF_8)));
            final String encodeToString2 = Base64.getEncoder().encodeToString(((MessageDigest)instance).digest((s3 + "|" + String.valueOf((long)Long.valueOf(Long.valueOf(System.currentTimeMillis())) / 60000L)).getBytes(StandardCharsets.UTF_8)));
            if (encodeToString.length() < 20 || ((String)encodeToString2).length() < 20) {
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
