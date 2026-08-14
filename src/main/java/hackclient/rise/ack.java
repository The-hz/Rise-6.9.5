package hackclient.rise;

import com.alan.clients.compat.NetworkToggles;
import com.alan.clients.script.ScriptManager;
import java.io.File;
import lombok.Generated;

public enum ack {
    CONFIG("https://199.247.6.233/getconfig?id=", afx.aHL + File.separator, ".json"),
    SCRIPT("https://199.247.6.233/getscript?id=", ScriptManager.SCRIPT_DIRECTORY + File.separator, ".js");

    private final String aAh;
    private final String aAi;
    private final String aAj;
    private static final ack[] $VALUES = qH();

    @Generated
    ack(String var3, String var4, String var5) {
        this.aAh = var3;
        this.aAi = var4;
        this.aAj = var5;
    }

    //add code
    @Generated
    public String mY() {
        return NetworkToggles.remoteScripts() ? this.aAh : "";
    }

    @Generated
    public String qG() {
        return this.aAi;
    }

    @Generated
    public String getType() {
        return this.aAj;
    }

    private static ack[] qH() {
        return new ack[]{CONFIG, SCRIPT};
    }
}
