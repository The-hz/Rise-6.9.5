package rip.vantage.runtime;

import java.net.InetAddress;

public class e {
    public int eSg;
    public InetAddress eSf;

    e(InetAddress var1, int var2) {
        this.eSf = var1;
        this.eSg = var2;
    }

    public boolean aLj() {
        return this.eSf.isAnyLocalAddress() || this.eSf.isLoopbackAddress() || this.eSf.isSiteLocalAddress() || this.eSf.isLinkLocalAddress();
    }

    public static e kq(String var0) {
        long i1 = 7872638838417851558L;
        long j1 = -5678429381353550725L;
        long k1 = -8619498552416404284L;
        long l1 = -3669631147607874242L;
        String[] astring = var0.split(":");
        if (astring.length < 2) {
            return null;
        }

        String s = astring[0];
        long k2 = l1 ^ ((long)Integer.parseInt(astring[1], 16) << 32 ^ l1) & -1L << 32;
        if (s.length() == 8) {
            Long olong = rip.vantage.util.a.V(s, 16);
            long l2 = j1 ^ ((long)((int)(olong & 255L)) << 32 ^ j1) & -1L << 32;
            long i3 = k1 ^ ((long)((int)(olong >> 8 & 255L)) << 32 ^ k1) & -1L << 32;
            long j3 = i3 ^ ((int)(olong >> 16 & 255L) ^ i3) & -1L >>> 32;
            long k3 = i1 ^ ((long)((int)(olong >> 24 & 255L)) << 32 ^ i1) & -1L << 32;
            InetAddress inetaddress1 = rip.vantage.util.a.v(new byte[]{(byte)(l2 >>> 32), (byte)(j3 >>> 32), (byte)j3, (byte)(k3 >>> 32)});
            return (InetAddress)inetaddress1 != null ? new e(inetaddress1, (int)(k2 >>> 32)) : null;
        }

        if (s.length() != 32) {
            return null;
        }

        byte[] abyte = new byte[16];
        long i2 = j1 ^ (0L ^ j1) & -1L >>> 32;

        while ((int)i2 < 16) {
            long j2 = i2 ^ ((long)((15 - (int)i2) * 2) << 32 ^ i2) & -1L << 32;
            abyte[(int)j2] = (byte)Integer.parseInt(s.substring((int)(j2 >>> 32), (int)(j2 >>> 32) + 2), 16);
            i2 = j2 ^ (j2 ^ j2 + 1) & -1L >>> 32;
        }

        InetAddress inetaddress = rip.vantage.util.a.v(abyte);
        return (InetAddress)inetaddress != null ? new e(inetaddress, (int)(k2 >>> 32)) : null;
    }


    static {
    }

    public static e kp(String var0) {
        long k = 3525605572141610624L;
        long l = -7250742035096658392L;
        String s = var0.trim();
        String s1;
        long j1;
        if (s.startsWith("[")) {
            long i1 = k ^ ((long)s.indexOf(93) << 32 ^ k) & -1L << 32;
            s1 = s.substring(1, (int)(i1 >>> 32));
            j1 = l ^ ((long)Integer.parseInt(s.substring(s.indexOf(58, (int)(i1 >>> 32)) + 1)) << 32 ^ l) & -1L << 32;
        } else {
            long k1 = k ^ ((long)s.lastIndexOf(58) << 32 ^ k) & -1L << 32;
            if ((int)(k1 >>> 32) <= 0) {
                return null;
            }

            s1 = s.substring(0, (int)(k1 >>> 32));
            j1 = l ^ ((long)Integer.parseInt(s.substring((int)(k1 >>> 32) + 1)) << 32 ^ l) & -1L << 32;
        }

        InetAddress inetaddress = rip.vantage.util.a.kO(s1);
        return (InetAddress)inetaddress != null ? new e(inetaddress, (int)(j1 >>> 32)) : null;
    }
}
