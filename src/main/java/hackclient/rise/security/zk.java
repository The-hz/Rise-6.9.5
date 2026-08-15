package hackclient.rise.security;

import com.alan.clients.security.SecurityFeature;
import hackclient.rise.ahm;

public class zk extends SecurityFeature
{
    public volatile boolean avA;

    public boolean run() {
        if (this.avA) {
            return true;
        }
        if (zk.aEg == null || zk.aEg.thePlayer == null || zk.aEg.theWorld == null || zk.aEg.isIntegratedServerRunning()) {
            return 14 - 14 != 0;
        }
        return ahm.vr() && !ahm.vp() && (this.avA = true);
    }

    public String getReason() {
        return "hypixelbrandaddressmismatch";
    }

    static {
    }

}
