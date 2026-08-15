package hackclient.rise;

import com.alan.clients.util.file.FileType;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class afv {
    public static final File aHH = new File(afr.DIRECTORY, "alts");
    private final List<ael> aHI = new ArrayList<>();

    public afv() {
    }

    public void init() {
        if (!aHH.exists()) {
            aHH.mkdir();
        }

        afc.init();
        afb.init();
    }

    public aft tj() {
        return new aft(this.sK(), FileType.ACCOUNT);
    }

    public boolean tk() {
        return this.tj().te();
    }

    public boolean update() {
        return this.tj().write();
    }

    private File sK() {
        return new File(aHH, "alts.json");
    }

    public List<ael> tl() {
        return this.aHI;
    }
}
