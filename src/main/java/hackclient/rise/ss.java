package hackclient.rise;

import com.alan.clients.module.impl.other.clientspoofer.LabyModClientSpoofer;
import java.util.ArrayList;

public class ss extends ArrayList<ajt<String, String, Boolean>> {
    final LabyModClientSpoofer ZH;

    public ss(LabyModClientSpoofer var1) {
        this.ZH = var1;
        this.add(new ajt<>("MC|Brand", "labymod", true));
        this.add(new ajt<>("REGISTER", "labymod:neominecraft:intavelabymod3:main", false));
        this.add(new ajt<>("labymod:neo", "{\"version\":\"" + this.ZH.ZF.wo() + "\"}", false));
        this.add(new ajt<>("labymod3:main", "INFO{\"version\":\"" + this.ZH.ZF.wo() + "\"}", false));
        this.add(new ajt<>("minecraft:intave", "L{\"legacySneakHeight\":false,\"legacyOldRange\":false,\"legacyOldSlowdown\":false}", false));
        this.add(new ajt<>("minecraft:intave", "\nclientconfigL{\"legacySneakHeight\":false,\"legacyOldRange\":false,\"legacyOldSlowdown\":false}", false));
    }
}
