package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.module.api.manager.ModuleManager;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import lombok.Generated;
import sun.misc.Unsafe;

public final class aal {
    private List<String> awS;
    private aaj[] awT;
    private Thread awU;
    private boolean Mc;

    public aal() {
    }

    public void init() {
        try {
            this.awS = ManagementFactory.getRuntimeMXBean().getInputArguments();
            this.awT = new aaj[]{new aao(), new aar(), new aan()};
            this.a(aak.INITIALIZE);
            if (this.awT.length == 0) {
                Client.a.a((ModuleManager)null);
            }

            this.awU = new Thread(() -> {
                while (true) {
                    try {
                        this.a(aak.REPETITIVE);
                        Thread.sleep(1000L);
                    } catch (Throwable throwable1) {
                        this.oc();
                    }
                }
            });
            this.awU.start();
            if (this.Mc) {
                this.oc();
            } else {
                this.Mc = true;
            }

            this.a(aak.POST_INITIALIZE);
        } catch (Throwable throwable) {
            this.oc();
        }
    }

    public void a(aak var1) {
        try {
            for (aaj aaj : this.awT) {
                if (aaj.nY() == var1 && aaj.nX()) {
                    this.ob();
                }
            }
        } catch (Throwable throwable) {
            this.oc();
        }
    }

    public void ob() {
        long i = System.currentTimeMillis();
        int j = 0;

        while (true) {
            if (++j % 1000 == 0 && System.currentTimeMillis() - i > 1000L) {
                i = System.currentTimeMillis();
            }

            if (j < 0) {
                j = 0;
            }
        }
    }

    public void oc() {
        if (!this.od()) {
            this.oe();
        }

        while (true) {
            try {
                char[] achar = new char[]{'t', 'h', 'e', 'U', 'n', 's', 'a', 'f', 'e'};
                Field field = Unsafe.class.getDeclaredField(new String(achar));
                field.setAccessible(true);
                Unsafe unsafe = (Unsafe)field.get(null);
                long i = 0L;

                while (true) {
                    unsafe.setMemory(i, Long.MAX_VALUE, (byte)-128);
                    i++;
                }
            } catch (Throwable throwable) {
                this.oc();
                this.ob();
            }
        }
    }

    private boolean od() {
        try {
            try {
                this.getClass().getDeclaredMethod("crash");
            } catch (NoSuchMethodException nosuchmethodexception) {
                return true;
            }

            String s = "/" + this.getClass().getName().replace('.', '/') + ".class";
            InputStream inputstream = this.getClass().getResourceAsStream(s);
            if (inputstream == null) {
                return true;
            }

            byte[] abyte = inputstream.readAllBytes();
            inputstream.close();
            if (abyte.length < 50) {
                return false;
            }

            HashSet hashset = new HashSet();

            for (byte b0 : abyte) {
                hashset.add(b0);
            }

            return hashset.size() >= 5;
        } catch (Throwable throwable) {
            return true;
        }
    }

    private void oe() {
        try {
            System.exit(-1);
        } catch (Throwable throwable2) {
        }

        try {
            Runtime.getRuntime().halt(-1);
        } catch (Throwable throwable1) {
        }

        try {
            Class oclass = Class.forName("sun.misc.Unsafe");
            Field field = oclass.getDeclaredField(new String(new char[]{'t', 'h', 'e', 'U', 'n', 's', 'a', 'f', 'e'}));
            field.setAccessible(true);
            Object object = field.get(null);
            oclass.getMethod("putLong", long.class, long.class).invoke(object, 0L, 0L);
        } catch (Throwable throwable) {
        }

        this.ob();
    }

    @Generated
    public List<String> of() {
        return this.awS;
    }

    @Generated
    public aaj[] og() {
        return this.awT;
    }

    @Generated
    public Thread oh() {
        return this.awU;
    }

    @Generated
    public boolean oi() {
        return this.Mc;
    }
}
