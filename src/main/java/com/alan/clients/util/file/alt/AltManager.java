package com.alan.clients.util.file.alt;

import com.alan.clients.util.account.localts.LocaltsConfig;
import com.alan.clients.util.file.FileManager;
import com.alan.clients.util.file.FileType;
import com.alan.clients.util.file.account.AccountFile;
import hackclient.rise.AltAccount;
import com.alan.clients.util.account.localts.LocaltsOrderStore;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AltManager {
    public static final File aHH = new File(FileManager.DIRECTORY, "alts");
    private final List<AltAccount> aHI = new ArrayList<>();

    public AltManager() {
    }

    public void init() {
        if (!aHH.exists()) {
            aHH.mkdir();
        }

        LocaltsOrderStore.init();
        LocaltsConfig.init();
    }

    public AccountFile tj() {
        return new AccountFile(this.sK(), FileType.ACCOUNT);
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

    public List<AltAccount> tl() {
        return this.aHI;
    }
}
