package hackclient.rise;

import com.alan.clients.util.file.FileType;
import com.alan.clients.util.file.config.ConfigFile;
import java.io.File;
import java.util.ArrayList;
import lombok.Generated;
import rip.vantage.commons.util.time.a;

public class afx extends ArrayList<ConfigFile> {
    public static final File aHL = new File(afr.aHy, "configs");
    private ConfigFile aHM;
    private final a aHN = new a();

    public afx() {
    }

    public void init() {
        if (!aHL.exists()) {
            aHL.mkdir();
        }

        this.aHN.i(5000L);
        this.update();
    }

    public void tn() {
        File file1 = new File(aHL, "latest.json");
        ConfigFile configfile = new ConfigFile(file1, FileType.CONFIG);
        configfile.tm();
        configfile.te();
        this.aHM = configfile;
    }

    public ConfigFile bK(String var1) {
        File file1 = new File(aHL, var1 + ".json");
        return new ConfigFile(file1, FileType.CONFIG);
    }

    public void d(String var1, boolean var2) {
        File file1 = new File(aHL, var1 + ".json");
        ConfigFile configfile = this.bK(var1);
        if (var2) {
            configfile.tm();
        }

        if (configfile == null) {
            configfile = new ConfigFile(file1, FileType.CONFIG);
            this.add(configfile);
            System.out.println("Creating new config...");
        } else {
            System.out.println("Overwriting existing config...");
        }

        configfile.tf();
        System.out.println("Config saved to files.");
    }

    public boolean update() {
        this.clear();
        File[] afile = aHL.listFiles();
        if (afile == null) {
            return false;
        }

        for (File file1 : afile) {
            if (file1.getName().endsWith(".json")) {
                this.add(new ConfigFile(file1, FileType.CONFIG, file1.getName().replace(".json", "")));
            }
        }

        return true;
    }

    public boolean bL(String var1) {
        ConfigFile configfile = this.bK(var1);
        if (configfile == null) {
            return false;
        }

        this.remove(configfile);
        return configfile.sK().delete();
    }

    public a mQ() {
        return this.aHN;
    }

    @Generated
    public ConfigFile to() {
        return this.aHM;
    }
}
