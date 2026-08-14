package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.util.interfaces.InstanceAccess;
import java.io.File;

public class afr {
    public static final File aHy = new File(InstanceAccess.aEg.mcDataDir, Client.b);

    public afr() {
    }

    public void init() {
        if (!aHy.exists()) {
            aHy.mkdir();
        }
    }
}
