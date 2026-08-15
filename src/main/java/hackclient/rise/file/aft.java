package hackclient.rise.file;

import com.alan.clients.Client;
import com.alan.clients.util.file.FileType;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import hackclient.rise.ael;
import hackclient.rise.aem;
import hackclient.rise.aeo;
import hackclient.rise.aep;
import hackclient.rise.aeq;
import hackclient.rise.file.afu;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class aft
extends com.alan.clients.util.file.File {
    private static final SimpleDateFormat aHE = new SimpleDateFormat("dd.MM.yyyy");
    private static final long aHF = 172800000L;

    public aft(File file, FileType fileType) {
        super(file, fileType);
    }

    private static boolean a(ael ael2) {
        if (!(ael2 instanceof aep)) {
            return false;
        }
        String string = ((aep)ael2).so();
        if (string != null && !string.isEmpty()) {
            return false;
        }
        long l2 = ael2.sj();
        if (l2 <= 0L) return false;
        if (System.currentTimeMillis() - l2 <= 172800000L) return false;
        return true;
    }

    @Override
    public boolean te() {
        if (!this.getFile().exists()) {
            return false;
        }
        try {
            FileReader fileReader = new FileReader(this.getFile());
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            JsonObject jsonObject = this.A().fromJson((Reader)bufferedReader, JsonObject.class);
            bufferedReader.close();
            fileReader.close();
            if (jsonObject == null) {
                return false;
            }
            List<ael> list = Client.a.q().tl();
            list.clear();
            JsonArray jsonArray = jsonObject.getAsJsonArray("data");
            if (jsonArray != null) {
                for (int i2 = 0; i2 < jsonArray.size(); ++i2) {
                    JsonObject jsonObject2 = jsonArray.get(i2).getAsJsonObject();
                    ael ael2 = new ael(aem.CRACKED, "", "", "");
                    ael2.b(jsonObject2);
                    switch (afu.aHG[ael2.sg().ordinal()]) {
                        case 1: {
                            ael2 = new aeo("");
                            ael2.b(jsonObject2);
                            break;
                        }
                        case 2: {
                            ael2 = new aep("", "", "", "");
                            ael2.b(jsonObject2);
                            break;
                        }
                        case 3: {
                            ael2 = new aeq("", "", "", "");
                            ael2.b(jsonObject2);
                        }
                    }
                    if (aft.a(ael2)) {
                        System.out.println("purging expired access-only account: " + ael2.getName());
                        continue;
                    }
                    list.add(ael2);
                    System.out.println("loading account: " + ael2.getName());
                }
            }
            return true;
        }
        catch (IOException iOException) {
            return false;
        }
    }

    @Override
    public boolean write() {
        try {
            List<ael> list;
            if (!this.getFile().exists()) {
                this.getFile().createNewFile();
            }
            if ((list = Client.a.q().tl()).isEmpty()) {
                return true;
            }
            JsonObject jsonObject = new JsonObject();
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("version", "6");
            jsonObject2.addProperty("creationDate", aHE.format(new Date()));
            jsonObject.add("Metadata", jsonObject2);
            JsonArray jsonArray = new JsonArray();
            for (ael ael2 : list) {
                jsonArray.add(ael2.sf());
                System.out.println("writing account: " + ael2.getName());
            }
            jsonObject.add("data", jsonArray);
            FileWriter fileWriter = new FileWriter(this.getFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            this.A().toJson((JsonElement)jsonObject, (Appendable)bufferedWriter);
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.flush();
            fileWriter.close();
            return true;
        }
        catch (IOException iOException) {
            return false;
        }
    }
}
