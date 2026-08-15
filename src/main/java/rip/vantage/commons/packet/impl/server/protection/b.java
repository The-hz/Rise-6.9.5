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
            final StackTraceElement[] array = (StackTraceElement[])stackTrace;
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
        b.o0Oo000O0oO = new Object[62];
        int n10_hi = 0;
        final Object[] array = { b.fld_0OOOoo00o0_91, Integer.valueOf(0), null };
        final int n11 = 2;
        Object o;
        if ((o = mth_0OOOoo00o0_45()[0]) == null) {
            final char[] charArray = "\uc3f9\uc44b\uc3e7\uc3e0\uc3d2\uc44c\uc3e5\uc410\uc3d7\uc3e0\uc3e4\uc3da\uc3f9\uc42b\uc441\uc3e0\uc44c\uc440\uc394\uc3f3\uc3e6\uc3f2\uc3e3\uc3d3\uc3da\uc44c\uc3d7\uc3d9\uc3e5\uc3e4\uc440\uc3f6\uc3f9\uc445\uc3d3\uc3d3\uc450\uc3df\uc442\uc3e7\uc396\uc394\uc3f9\uc39a\uc3e0\uc39a\uc3df\uc3d3\uc3f3\uc3dc\uc450\uc3e0\uc396\uc3fe\uc445\uc3d8\uc394\uc3f7\uc410\uc441\uc3de\uc3f9\uc444\uc39a\uc3da\uc3f5\uc3dc\uc3fb\uc396\uc3d2\uc441\uc3f9\uc44b\uc410\uc3fc\uc44b\uc39e\uc42b\uc444\uc3f8\uc3f9\uc3f2\uc3f2\uc3f1\uc3de\uc3dd\uc39d\uc3f5\uc445\uc444\uc3e0\uc3e3\uc446\uc3d6\uc3f5\uc39e\uc3de\uc3e5\uc3d9\uc3f5\uc3e1\uc3db\uc3f3\uc3fa\uc440\uc3d8\uc3f8\uc39d\uc3d7\uc3f0\uc3df\uc3d8\uc3e2\uc447\uc3ec\uc3fd\uc42b\uc3e7\uc443\uc3d9\uc450\uc39d\uc3fc\uc442\uc3e1\uc3d7\uc393\uc3f8\uc442\uc3f3\uc3d4\uc3e1\uc3e3\uc445\uc393\uc442\uc3d6\uc3d7\uc3e5\uc42b\uc451\uc3da\uc3d9\uc447\uc3d7\uc39a\uc42b\uc450\uc395\uc3e5\uc3e7\uc3f9\uc3f3\uc393\uc3e4\uc445\uc393\uc3d6\uc3da\uc3d5\uc3e0\uc3fb\uc39d\uc444\uc39a\uc39e\uc3f5\uc3d2\uc3de\uc394\uc3e6\uc44b\uc395\uc3d6\uc3f0\uc410\uc3f3\uc39e\uc410\uc3e4\uc3e3\uc3f5\uc3d5\uc411\uc441\uc3e7\uc3dd\uc39a\uc3fa\uc394\uc392\uc3d7\uc3f3\uc396\uc3fd\uc3dd\uc3e1\uc443\uc3da\uc3e2\uc3e1\uc3fc\uc3f0\uc3ff\uc451\uc3fb\uc39c\uc3fb\uc447\uc411\uc3f8\uc3e3\uc3f6\uc450\uc3d6\uc440\uc3d5\uc3d5\uc3f8\uc3f6\uc3da\uc3e0\uc39c\uc396\uc3e3\uc410\uc3f2\uc3e2\uc3fb\uc3e3\uc3e1\uc3f2\uc3e0\uc395\uc39a\uc3e5\uc3ff\uc3fe\uc3fc\uc3f8\uc3e3\uc441\uc3f7\uc3fa\uc3e3\uc3df\uc3d2\uc392\uc3f9\uc397\uc410\uc3f2\uc39a\uc3d4\uc3f7\uc392\uc3f5\uc3e6\uc440\uc39c\uc440\uc3e6\uc393\uc3db\uc446\uc3de\uc3f5\uc3df\uc3e3\uc3f2\uc39e\uc39d\uc3dc\uc42b\uc39c\uc3fa\uc446\uc3e0\uc3f9\uc44b\uc39a\uc3f4\uc3fa\uc3e0\uc3f4\uc3fa\uc3d2\uc392\uc447\uc3dd\uc3f3\uc3d2\uc3d2\uc3d8\uc3d8\uc3d2\uc39c\uc3f0\uc3fa\uc3f0\uc3f8\uc3f6\uc442\uc3d5\uc3d4\uc3e5\uc3fe\uc3d5\uc451\uc445\uc3ec\uc394\uc3dd\uc395\uc3dc\uc442\uc3f3\uc441\uc44c\uc3fc\uc3f9\uc397\uc3e1\uc3f8\uc3f1\uc3da\uc397\uc443\uc3d8\uc3db\uc3e5\uc3f2\uc3f5\uc444\uc3d2\uc443\uc3de\uc42b\uc3f1\uc442\uc3f0\uc3fc\uc443\uc3e2\uc446\uc3fb\uc3f8\uc394\uc3ec\uc42b\uc3da\uc39d\uc3de\uc3f8\uc3d4\uc444\uc410\uc392\uc3f1\uc3f3\uc3f5\uc3d5\uc3e4\uc3dc\uc44c\uc395\uc3fa\uc3e2\uc44c\uc450\uc3f6\uc3ff\uc411\uc3fd\uc3d9\uc447\uc3f0\uc3d7\uc3d9\uc3d7\uc3db\uc394\uc3d4\uc3e1\uc450\uc3e0\uc445\uc3d7\uc446\uc450\uc3f5\uc447\uc451\uc3d4\uc3d3\uc42b\uc3f8\uc3f2\uc3e0\uc3ec\uc3da\uc3f7\uc411\uc39e\uc44c\uc3f5\uc445\uc3e3\uc446\uc3e7\uc3e1\uc3d3\uc451\uc3f2\uc3e0\uc3e4\uc3e0\uc443\uc3d4\uc393\uc442\uc3fe\uc3d7\uc44c\uc3e6\uc3e2\uc3d6\uc440\uc44b\uc44b\uc3f6\uc3f8\uc3f8\uc447\uc3e1\uc3da\uc440\uc3fd\uc3d9\uc393\uc44c\uc3e6\uc3dc\uc3d8\uc3e4\uc3ec\uc450\uc3d9\uc394\uc440\uc410\uc3fe\uc444\uc3f2\uc3e5\uc392\uc394\uc447\uc410\uc39c\uc3e2\uc446\uc411\uc3f4\uc3f5\uc3d2\uc3f7\uc392\uc396\uc392\uc3f2\uc394\uc3d6\uc39e\uc447\uc3dc\uc3d9\uc3fa\uc3f1\uc3f2\uc441\uc3e5\uc3f3\uc445\uc442\uc3e7\uc441\uc3e4\uc3d4\uc3f3\uc3db\uc39a\uc3fd\uc444\uc39a\uc3d2\uc441\uc3f5\uc3f0\uc3e7\uc410\uc440\uc3df\uc3e0\uc3dc\uc44b\uc3fb\uc445\uc44c\uc3e7\uc3e5\uc3e7\uc394\uc3e7\uc395\uc442\uc39e\uc3d8\uc395\uc395\uc397\uc393\uc3df\uc3e5\uc3d8\uc3f0\uc3e6\uc3fe\uc3f5\uc3fa\uc395\uc3e3\uc3f2\uc3d9\uc3e4\uc3f7\uc44c\uc442\uc3d6\uc39e\uc3f7\uc3f7\uc3d6\uc3f0\uc411\uc397\uc3f8\uc3f1\uc3d4\uc3ff\uc3d4\uc3e6\uc444\uc441\uc445\uc3e0\uc3d5\uc3d8\uc3f6\uc39d\uc447\uc3d8\uc39d\uc3df\uc396\uc3db\uc3de\uc3f3\uc395\uc450\uc445\uc3d8\uc44b\uc442\uc3ec\uc3f5\uc3d2\uc3fd\uc3df\uc3d5\uc3f2\uc44c\uc3fc\uc3df\uc3d4\uc42b\uc3ff\uc3d7\uc3fe\uc3ec\uc3f8\uc440\uc395\uc42b\uc393\uc447\uc395\uc3f2\uc39d\uc3e4\uc39e\uc3d9\uc3dc\uc397\uc3e0\uc42b\uc3df\uc450\uc42b\uc3fd\uc442\uc3f2\uc3d9\uc3d5\uc3e0\uc445\uc392\uc44b\uc3fc\uc44b\uc446\uc3fd\uc3e0\uc3fc\uc3fa\uc3e6\uc3e3\uc3df\uc397\uc393\uc3d7\uc3d7\uc395\uc450\uc3f7\uc411\uc411\uc3e4\uc410\uc3d7\uc3d2\uc3fa\uc396\uc3d2\uc3f6\uc3e3\uc3f9\uc3d7\uc3f0\uc3e6\uc441\uc396\uc3e1\uc3f6\uc3f0\uc3fa\uc3fc\uc3f0\uc39c\uc411\uc396\uc446\uc3e8\uc3e8".toCharArray();
            for (int i = 0; i < 664; ++i) {
                charArray[i] = (char)(((charArray[i] + '\u45f4' - 27206 ^ 0x2066 ^ 0x82A7) - 37399 + 31081 ^ 0x6DEA) + 53755 + 7469 - 14382);
            }
            o = (mth_0OOOoo00o0_45()[0] = new String(charArray));
        }
        array[n11] = o;
        final char[] charArray2 = ((String)o0Oo000O0oO(array)).toCharArray();
        int limit = 465;
        int n33;
        for (int n17_lo = 0; n17_lo < limit; n17_lo = n33) {
            final char[] array2 = (char[])charArray2;
            final int n18 = n17_lo;
            int n17_lo2 = n17_lo + 1;
            int n2_lo = array2[n18];
            final char[] array3 = (char[])charArray2;
            final int n23 = n17_lo2;
            int n17_lo3 = n17_lo2 + 1;
            int n3_hi = array3[n23];
            int limit2 = n2_lo << 16 | n3_hi;
            final char[] array4 = new char[limit2];
            for (int j = 0; j < limit2; j++) {
                array4[j] = charArray2[n17_lo3 + j];
            }
            final Object[] o0Oo000O0oO = b.o0Oo000O0oO;
            final int n32 = n10_hi;
            n10_hi++;
            o0Oo000O0oO[n32] = new String(array4);
            n33 = n17_lo3 + limit2;
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
                        array4[4] = 94;
                        array4[10] = 99;
                        array4[13] = 104;
                        array4[6] = -8;
                        array4[12] = 124;
                        array4[8] = 7;
                        array4[1] = -60;
                        array4[0] = 89;
                        array4[14] = -39;
                        array4[2] = -19;
                        array4[3] = -30;
                        array4[7] = 36;
                        array4[9] = 92;
                        array4[11] = -32;
                        array4[15] = 121;
                        array4[5] = -47;
                        array3[n] = array4;
                    }
                    final byte[] array5 = (byte[])array2[0];
                    if (b.Oo0o00000O00 == null) {
                        final byte[] array6 = new byte[32];
                        array6[20] = 65;
                        array6[29] = -20;
                        array6[31] = -102;
                        array6[9] = 85;
                        array6[27] = 80;
                        array6[2] = -32;
                        array6[18] = 8;
                        array6[28] = -10;
                        array6[19] = 28;
                        array6[16] = 115;
                        array6[11] = 100;
                        array6[3] = 48;
                        array6[21] = 123;
                        array6[8] = 126;
                        array6[23] = 78;
                        array6[10] = 80;
                        array6[13] = -37;
                        array6[12] = -10;
                        array6[14] = 6;
                        array6[30] = -48;
                        array6[25] = 89;
                        array6[17] = 118;
                        array6[0] = 41;
                        array6[4] = 71;
                        array6[6] = -112;
                        array6[7] = 0;
                        array6[22] = 126;
                        array6[24] = -94;
                        array6[5] = 14;
                        array6[1] = -128;
                        array6[15] = -119;
                        array6[26] = 60;
                        final byte[] array7 = new byte[array5.length + array6.length];
                        System.arraycopy(array5, 0, array7, 0, array5.length);
                        System.arraycopy(array6, 0, array7, array5.length, array6.length);
                        Object o3;
                        if ((o3 = mth_0OOOoo00o0_45()[1]) == null) {
                            final char[] charArray = "\ufaa6\uf978\ufaa5\ufaba\ufa8c\ufa68\uf941\uf823\uf82a\uf86e\ufa8e\uf807\uf82b\uf86d\uf95d\ufa8e\uf94b\uf97b".toCharArray();
                            for (int i = 0; i < 18; ++i) {
                                charArray[i] = (char)((((((charArray[i] ^ '\u4353') + 6868 ^ 0xF475) + 47510 ^ 0x567) + 2183 ^ 0xE779) + 35066 ^ 0x991E ^ 0xE9CE) - 63775);
                            }
                            o3 = (mth_0OOOoo00o0_45()[1] = new String(charArray));
                        }
                        final SecretKeyFactory instance = SecretKeyFactory.getInstance((String)o3);
                        final byte[] array8 = new byte[16];
                        array8[15] = 67;
                        array8[14] = -57;
                        array8[2] = 88;
                        array8[0] = 31;
                        array8[9] = 39;
                        array8[5] = 12;
                        array8[7] = 11;
                        array8[13] = 66;
                        array8[12] = -8;
                        array8[1] = 48;
                        array8[10] = -83;
                        array8[6] = 49;
                        array8[11] = 33;
                        array8[8] = 3;
                        array8[3] = -87;
                        array8[4] = 32;
                        final byte[] key = (byte[])((SecretKeyFactory)instance).generateSecret(new PBEKeySpec(new String(array7, StandardCharsets.UTF_8).toCharArray(), array8, 29, 256)).getEncoded();
                        Object o4;
                        if ((o4 = mth_0OOOoo00o0_45()[2]) == null) {
                            final char[] charArray2 = "\u5278\u5274\u526a".toCharArray();
                            for (int j = 0; j < 3; ++j) {
                                charArray2[j] = (char)(((charArray2[j] ^ '\u30f1') - 33939 + 58995 - 19446 + 61398 ^ 0xEB57 ^ 0xC5A) + 30843 - 19051 + 17133);
                            }
                            o4 = (mth_0OOOoo00o0_45()[2] = new String(charArray2));
                        }
                        b.Oo0o00000O00 = new SecretKeySpec(key, (String)o4);
                    }
                    final byte[] decode = Base64.getDecoder().decode(s);
                    final byte[] copyOfRange = Arrays.copyOfRange(decode, 0, 16);
                    final byte[] copyOfRange2 = Arrays.copyOfRange(decode, 16, decode.length);
                    Object o5;
                    if ((o5 = mth_0OOOoo00o0_45()[3]) == null) {
                        final char[] charArray3 = "\ueb6e\ueb72\ueb60\uec4c\ueb70\ueb6f\ueb70\uec4c\ueb5d\ueb68\ueb70\ueb60\uec42\ueb5d\ueb8e\ueb91\ueb91\ueb66\ueb8b\ueb94".toCharArray();
                        for (int k = 0; k < 20; ++k) {
                            charArray3[k] = (char)(((charArray3[k] + '\ua223' ^ 0x4D43 ^ 0x8AD4) - 52517 + 54343 ^ 0x707 ^ 0x6588) - 50185 - 4316 + 17404 - 41597);
                        }
                        o5 = (mth_0OOOoo00o0_45()[3] = new String(charArray3));
                    }
                    final Cipher instance2 = Cipher.getInstance((String)o5);
                    instance2.init(2, (java.security.Key)b.Oo0o00000O00, (AlgorithmParameterSpec)new IvParameterSpec(copyOfRange));
                    o2 = (b.oO00O0OO0ooO[intValue] = new String(instance2.doFinal(copyOfRange2), StandardCharsets.UTF_8));
                }
                return o2;
            } catch (java.security.NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        } catch (java.security.GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
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
        try {
            final String string = this.getClass().getName() + ".constructor";
            MessageDigest.getInstance("SHA-256");
            if (string.length() >= 10) {
                string.contains("S2CPacketAuthentication");
            }
            final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int n5_hi = 0;
            final StackTraceElement[] array = (StackTraceElement[])stackTrace;
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
