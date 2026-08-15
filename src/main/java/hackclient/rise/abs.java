package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class abs
{
    public static Object[] fld_0oOOoOo0O00O_4;
    public static Object[] o0Oo000O0oO;
    @EventLink
    public Listener<er> aHd;
    public static Object[] fld_0OOOoo00o0_5;
    public static Object Oo0o00000O00;
    public static double aHb;
    public static Object[] oO00O0OO0ooO;
    public static float aHc;


    public abs() {
        this.aHd = (Listener<er>)(var1 -> {
            if (var1.dd() instanceof rip.vantage.commons.packet.impl.server.protection.b) {
                final rip.vantage.commons.packet.impl.server.protection.b b = (rip.vantage.commons.packet.impl.server.protection.b)var1.dd();
                if (!rip.vantage.security.l.a(b, b.aKi())) {
                    System.out.println("EC91");

                    try {
                        System.exit(1);
                    }
                    catch (Throwable t) {}

                    try {
                        Runtime.getRuntime().halt(1);
                    }
                    catch (Throwable t2) {}

                    throw new SecurityException("EC91");
                }
                abs.aHb = b.aKk();
                abs.aHc = b.aKl();
            }
        });
        Client.a.e().b((Object)this);
    }

    static {
        abs.o0Oo000O0oO = new Object[2];
        int n10_hi = 0;
        final Object[] array = { abs.fld_0OOOoo00o0_5, Integer.valueOf(0), null };
        final int n11 = 2;
        Object o;
        if ((o = mth_0OOOoo00o0_2()[0]) == null) {
            final char[] charArray = "\u3446\u3441\u344c\u3440\u3458\u3468\u3402\u3460\u3444\u3445\u345b\u3458\u343c\u345f\u3465\u345a\u345d\u345c\u344c\u3447\u344a\u37ae\u37b1\u37b1\u3408\u3447\u3475\u3444\u3443\u345d\u345e\u3464\u378c\u3446\u345e\u3440\u343e\u3460\u346a\u3468\u344d\u344d\u345c\u3410".toCharArray();
            for (int i = 0; i < 44; ++i) {
                ((char[])charArray)[i] = (char)(((((((char[])charArray)[i] ^ '\ue581') + 14531 ^ 0xFC5) + 3110 + 35110 ^ 0x758B ^ 0x876B) - 36176 + 1843 + 13081 ^ 0xDB5B ^ 0x905D) + 41470);
            }
            o = (mth_0OOOoo00o0_2()[0] = new String(charArray));
        }
        array[n11] = o;
        final char[] charArray2 = ((String)o0Oo000O0oO(array)).toCharArray();
        int limit = 12;
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
                ((char[])array4)[j] = ((char[])charArray2)[n17_lo3 + j];
            }
            final Object[] o0Oo000O0oO = abs.o0Oo000O0oO;
            final int n32 = n10_hi;
            n10_hi++;
            o0Oo000O0oO[n32] = new String(array4);
            n33 = n17_lo3 + limit2;
        }
        abs.aHb = 6.283185307179586;
        abs.aHc = 180.0f;
    }

    public static Object[] mth_0OOOoo00o0_2() {
        Object[] fld_0oOOoOo0O00O_4;
        if ((fld_0oOOoOo0O00O_4 = abs.fld_0oOOoOo0O00O_4) == null) {
            fld_0oOOoOo0O00O_4 = (abs.fld_0oOOoOo0O00O_4 = new Object[4]);
        }
        return fld_0oOOoOo0O00O_4;
    }

    public static Object o0Oo000O0oO(final Object[] array) {
        try {
            final int intValue = (int)array[1];
            final String s = (String)array[2];
            final Object o = array[0];
            Object[] oo00O0OO0ooO;
            if ((oo00O0OO0ooO = abs.oO00O0OO0ooO) == null) {
                oo00O0OO0ooO = (abs.oO00O0OO0ooO = new Object[] { null });
            }
            Object o2;
            if ((o2 = oo00O0OO0ooO[intValue]) == null) {
                Object[] array2;
                if ((array2 = (Object[])o) == null) {
                    final Object[] array3 = abs.fld_0OOOoo00o0_5 = (array2 = new Object[] { null });
                    final int n = 0;
                    final byte[] array4 = new byte[16];
                    ((byte[])array4)[9] = -77;
                    ((byte[])array4)[8] = -35;
                    ((byte[])array4)[3] = -22;
                    ((byte[])array4)[4] = -70;
                    ((byte[])array4)[11] = 40;
                    ((byte[])array4)[13] = -105;
                    ((byte[])array4)[6] = -90;
                    ((byte[])array4)[1] = -23;
                    ((byte[])array4)[5] = 122;
                    ((byte[])array4)[10] = -50;
                    ((byte[])array4)[14] = -59;
                    ((byte[])array4)[2] = 11;
                    ((byte[])array4)[0] = -93;
                    ((byte[])array4)[15] = -46;
                    ((byte[])array4)[12] = 97;
                    ((byte[])array4)[7] = 21;
                    array3[n] = array4;
                }
                final byte[] array5 = (byte[])array2[0];
                if (abs.Oo0o00000O00 == null) {
                    final byte[] array6 = new byte[32];
                    ((byte[])array6)[5] = 39;
                    ((byte[])array6)[11] = -12;
                    ((byte[])array6)[16] = 9;
                    ((byte[])array6)[8] = -51;
                    ((byte[])array6)[14] = 14;
                    ((byte[])array6)[30] = 113;
                    ((byte[])array6)[2] = -7;
                    ((byte[])array6)[26] = 78;
                    ((byte[])array6)[4] = 19;
                    ((byte[])array6)[31] = 116;
                    ((byte[])array6)[23] = 102;
                    ((byte[])array6)[21] = -43;
                    ((byte[])array6)[29] = 37;
                    ((byte[])array6)[18] = -127;
                    ((byte[])array6)[24] = 38;
                    ((byte[])array6)[12] = 75;
                    ((byte[])array6)[9] = 98;
                    ((byte[])array6)[6] = 115;
                    ((byte[])array6)[3] = -9;
                    ((byte[])array6)[7] = -64;
                    ((byte[])array6)[0] = -31;
                    ((byte[])array6)[1] = -93;
                    ((byte[])array6)[15] = 16;
                    ((byte[])array6)[28] = 49;
                    ((byte[])array6)[19] = 72;
                    ((byte[])array6)[10] = -11;
                    ((byte[])array6)[20] = 103;
                    ((byte[])array6)[17] = -70;
                    ((byte[])array6)[13] = -39;
                    ((byte[])array6)[27] = 40;
                    ((byte[])array6)[22] = 85;
                    ((byte[])array6)[25] = 50;
                    final byte[] array7 = new byte[((byte[])array5).length + ((byte[])array6).length];
                    System.arraycopy(array5, 0, array7, 0, ((byte[])array5).length);
                    System.arraycopy(array6, 0, array7, ((byte[])array5).length, ((byte[])array6).length);
                    Object o3;
                    if ((o3 = mth_0OOOoo00o0_2()[1]) == null) {
                        final char[] charArray = "\uf92a\uf914\uf91f\uf916\uf920\uf924\uf953\uf93d\uf8e6\uf942\uf922\uf949\uf935\uf937\uf947\uf922\uf915\uf925".toCharArray();
                        for (int i = 0; i < 18; ++i) {
                            ((char[])charArray)[i] = (char)(((((char[])charArray)[i] + '\ud3f0' + 60930 - 50610 - 43939 + 53444 - 38101 ^ 0x49F8) - 1756 ^ 0x832D) + 36606 - 38622 - 15919);
                        }
                        o3 = (mth_0OOOoo00o0_2()[1] = new String(charArray));
                    }
                    final SecretKeyFactory instance = SecretKeyFactory.getInstance((String)o3);
                    final byte[] array8 = new byte[16];
                    ((byte[])array8)[14] = 74;
                    ((byte[])array8)[1] = 70;
                    ((byte[])array8)[10] = -62;
                    ((byte[])array8)[7] = 105;
                    ((byte[])array8)[8] = 2;
                    ((byte[])array8)[0] = -112;
                    ((byte[])array8)[4] = -97;
                    ((byte[])array8)[12] = 122;
                    ((byte[])array8)[5] = 39;
                    ((byte[])array8)[11] = -72;
                    ((byte[])array8)[13] = -96;
                    ((byte[])array8)[15] = -82;
                    ((byte[])array8)[3] = 114;
                    ((byte[])array8)[2] = -80;
                    ((byte[])array8)[9] = 66;
                    ((byte[])array8)[6] = 7;
                    final byte[] key = (byte[])((SecretKeyFactory)instance).generateSecret(new PBEKeySpec(new String(array7, StandardCharsets.UTF_8).toCharArray(), array8, 18, 256)).getEncoded();
                    Object o4;
                    if ((o4 = mth_0OOOoo00o0_2()[2]) == null) {
                        final char[] charArray2 = "\ud6f3\ud6ff\ud6e5".toCharArray();
                        for (int j = 0; j < 3; ++j) {
                            ((char[])charArray2)[j] = (char)(((((char[])charArray2)[j] ^ '\ua9c0') - 56928 - 881 + 61970 - 25444 ^ 0x5635) - 39109 + 38021 + 16667 - 20955 + 39708);
                        }
                        o4 = (mth_0OOOoo00o0_2()[2] = new String(charArray2));
                    }
                    abs.Oo0o00000O00 = new SecretKeySpec(key, (String)o4);
                }
                final byte[] decode = Base64.getDecoder().decode(s);
                final byte[] copyOfRange = Arrays.copyOfRange(decode, 0, 16);
                final byte[] copyOfRange2 = Arrays.copyOfRange(decode, 16, ((byte[])decode).length);
                Object o5;
                if ((o5 = mth_0OOOoo00o0_2()[3]) == null) {
                    final char[] charArray3 = "\u38bc\u38c0\u392a\u38d6\u38ba\u38bf\u38ba\u38d6\u3929\u38d2\u38ba\u392a\u38d0\u3929\u391c\u391d\u391d\u3934\u390b\u391e".toCharArray();
                    for (int k = 0; k < 20; ++k) {
                        ((char[])charArray3)[k] = (char)(((((char[])charArray3)[k] + '\u0cd3' + 47300 ^ 0x67F5) + 17798 - 33447 + 42409 - 34921 + 20442 + 23755 - 493 ^ 0x5CCE) + 34702);
                    }
                    o5 = (mth_0OOOoo00o0_2()[3] = new String(charArray3));
                }
                final Cipher instance2 = Cipher.getInstance((String)o5);
                ((Cipher)instance2).init(2, (java.security.Key)abs.Oo0o00000O00, (AlgorithmParameterSpec)new IvParameterSpec(copyOfRange));
                o2 = (abs.oO00O0OO0ooO[intValue] = new String(((Cipher)instance2).doFinal(copyOfRange2), StandardCharsets.UTF_8));
            }
            return o2;
        } catch (java.security.GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }
}
