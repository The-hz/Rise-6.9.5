package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.ui.click.standard.RiseClickGUI;
import com.alan.clients.util.file.FileType;
import java.io.File;
import java.util.ArrayList;

public class afz extends ArrayList<afy> {
    public static final File aHQ = new File(afr.aHy, "data");

    public afz() {
    }

    public void init() {
        Client.a.a(new RiseClickGUI());
        if (!aHQ.exists()) {
            aHQ.mkdir();
        }

        this.update();
    }

    public afy e(String var1, boolean var2) {
        File file1 = new File(aHQ, var1 + ".json");
        afy afy = new afy(file1, FileType.CONFIG);
        if (var2) {
            afy.tp();
        }

        return afy;
    }

    public afy bM(String var1) {
        File file1 = new File(aHQ, var1 + ".json");
        afy afy = new afy(file1, FileType.CONFIG);
        afy.tp();
        return afy;
    }

    public void bN(String var1) {
        File file1 = new File(aHQ, var1 + ".json");
        afy afy = this.bM(var1);
        if (afy == null) {
            afy = new afy(file1, FileType.CONFIG);
            this.add(afy);
            System.out.println("Creating new config...");
        } else {
            System.out.println("Overwriting existing config...");
        }

        afy.tf();
        System.out.println("Config saved to files.");
    }

    public boolean update() {
        this.clear();
        File[] afile = aHQ.listFiles();
        if (afile == null) {
            return false;
        }

        for (File file1 : afile) {
            if (file1.getName().endsWith(".json")) {
                this.add(new afy(file1, FileType.CONFIG));
            }
        }

        return true;
    }

    public boolean bL(String var1) {
        afy afy = this.bM(var1);
        if (afy == null) {
            return false;
        }

        this.remove(afy);
        return afy.sK().delete();
    }
}
