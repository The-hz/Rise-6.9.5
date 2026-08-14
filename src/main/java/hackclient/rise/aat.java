package hackclient.rise;

import com.alan.clients.Client;
import java.io.File;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.Locale;

public final class aat extends aaj {
    private final File awZ = new File(aed.rV() == aee.WINDOWS ? System.getenv("WinDir") + "\\System32\\drivers\\etc\\hosts" : "/etc/hosts");

    public aat() {
        super(aak.INITIALIZE, false);
    }

    @Override
    public boolean nX() {
        new Thread(() -> {
            try {
                while (true) {
                    if (!this.awZ.exists() || !this.awZ.canRead() || !this.awZ.isFile()) {
                        Client.a.f().oc();
                    }

                    Iterator iterator = Files.readAllLines(this.awZ.toPath()).iterator();

                    while (iterator.hasNext()) {
                        String s = ((String)iterator.next()).toLowerCase(Locale.ENGLISH).trim();
                        if (s.contains("riseclient.com") || s.contains("vantage")) {
                            Client.a.f().oc();
                        }
                    }

                    Thread.sleep(5000L);
                }
            } catch (Throwable throwable) {
                Client.a.f().oc();
            }
        }).start();
        return false;
    }
}
