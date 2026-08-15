package hackclient.rise;

import com.alan.clients.util.file.FileType;
import java.io.File;
import java.util.ArrayList;

public final class agb extends ArrayList<aga> {
    public static final File INSULT_DIRECTORY = new File(afr.DIRECTORY, "insults");

    public agb() {
    }

    public void init() {
        if (!INSULT_DIRECTORY.exists()) {
            INSULT_DIRECTORY.mkdir();
        }
    }

    public aga bO(String var1) {
        for (aga aga : this) {
            if (aga.getFile().getName().equalsIgnoreCase(var1 + ".txt")) {
                return aga;
            }
        }

        return null;
    }

    public void set(String var1) {
        File file1 = new File(INSULT_DIRECTORY, var1 + ".txt");
        aga aga = this.bO(var1);
        if (aga == null) {
            aga = new aga(file1, FileType.INSULT);
            this.add(aga);
            System.out.println("Creating new ..");
        } else {
            System.out.println("Overwriting existing ..");
        }

        aga.write();
        System.out.println("Insults saved to files.");
    }

    public boolean update() {
        this.clear();
        File[] afile = INSULT_DIRECTORY.listFiles();
        if (afile == null) {
            return false;
        }

        for (File file1 : afile) {
            if (file1.getName().endsWith(".txt")) {
                this.add(new aga(file1, FileType.INSULT));
            }
        }

        return true;
    }

    public boolean delete(String var1) {
        aga aga = this.bO(var1);
        if (aga == null) {
            return false;
        }

        this.remove(aga);
        return aga.getFile().delete();
    }
}
