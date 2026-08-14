package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.module.impl.other.Insults;
import com.alan.clients.util.file.File;
import com.alan.clients.util.file.FileType;
import com.alan.clients.value.impl.SubMode;
import java.nio.file.Files;

public final class aga extends File {
    public aga(java.io.File var1, FileType var2) {
        super(var1, var2);
    }

    @Override
    public boolean te() {
        if (this.sK().exists() && this.sK().isFile() && this.sK().canRead()) {
            try {
                Insults insults = Client.a.g().c(Insults.class);
                String s = this.sK().getName().replace(".txt", "");
                insults.mode.add(new SubMode(s));
                insults.map.put(s, Files.readAllLines(this.sK().toPath()));
                return true;
            } catch (Exception exception) {
                exception.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean tf() {
        try {
            if (!this.sK().exists()) {
                this.sK().createNewFile();
            }

            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }
}
