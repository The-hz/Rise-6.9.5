package hackclient.rise.security;

import com.alan.clients.security.SecurityFeature;
import rip.vantage.runtime.j;

public class zm extends SecurityFeature {

    @Override
    public boolean run() {
        return j.aLl();
    }


    static {
    }

    @Override
    public String getReason() {
        return "stackprobe";
    }

    public zm() {
    }
}
