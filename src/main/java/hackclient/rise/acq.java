package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.util.file.config.ConfigFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

final class acq implements ada {
    private static final String[] aBj = new String[]{"save", "load", "list", "folder", "create"};

    acq() {
    }

    @Override
    public void a(acz var1) {
        try {
            Client.a.p().update();
        } catch (Throwable throwable) {
        }
    }

    @Override
    public List<acy> b(acz var1) {
        String[] astring = var1.rk();
        if (astring.length == 0) {
            return Collections.emptyList();
        }

        String s = acl.aQ(var1.rj());
        if (astring.length == 1) {
            String s1 = astring[0] == null ? "" : astring[0].toLowerCase(Locale.ROOT);
            ArrayList arraylist = new ArrayList();

            for (String s2 : aBj) {
                String s3 = s2.toLowerCase(Locale.ROOT);
                if (s1.isEmpty() || s3.startsWith(s1)) {
                    boolean flag = s3.equals("save") || s3.equals("load") || s3.equals("create");
                    arraylist.add(new acy(s2, "Config subcommand", ".config " + String.join("/", aBj), s2, 0, flag));
                }
            }

            arraylist.sort((var2, var3) -> {
                String s8 = ((acy)var2).aBC.toLowerCase(Locale.ROOT);
                String s9 = ((acy)var3).aBC.toLowerCase(Locale.ROOT);
                int i = s8.equals(s1) ? 2 : (s8.startsWith(s1) ? 1 : 0);
                int j = s9.equals(s1) ? 2 : (s9.startsWith(s1) ? 1 : 0);
                if (i != j) {
                    return Integer.compare(j, i);
                }

                long k = acl.b(s, 0, s8);
                long l = acl.b(s, 0, s9);
                return k != l ? Long.compare(l, k) : ((acy)var2).aBC.compareToIgnoreCase(((acy)var3).aBC);
            });
            return arraylist;
        }
        String s4 = astring[0] == null ? "" : astring[0].toLowerCase(Locale.ROOT);
        if (!s4.equals("load") && !s4.equals("save") && !s4.equals("create")) {
            return Collections.emptyList();
        }

        String s5 = astring[1] == null ? "" : astring[1].toLowerCase(Locale.ROOT);
        ArrayList arraylist1 = new ArrayList();

        for (ConfigFile configfile : Client.a.p()) {
            String s6 = configfile.sK().getName().replace(".json", "");
            String s7 = s6.toLowerCase(Locale.ROOT);
            if (s5.isEmpty() || s7.startsWith(s5)) {
                arraylist1.add(new acy(s6, "Config", ".config " + s4 + " " + s6, s6, 1, false));
            }
        }

        if (!arraylist1.isEmpty()) {
            arraylist1.sort((var2, var3) -> {
                String s8 = ((acy)var2).aBC.toLowerCase(Locale.ROOT);
                String s9 = ((acy)var3).aBC.toLowerCase(Locale.ROOT);
                boolean flag1 = !s5.isEmpty() && s8.equals(s5);
                boolean flag2 = !s5.isEmpty() && s9.equals(s5);
                if (flag1 != flag2) {
                    return flag1 ? -1 : 1;
                }

                long i = acl.b(s, 1, s8);
                long j = acl.b(s, 1, s9);
                return i != j ? Long.compare(j, i) : ((acy)var2).aBC.compareToIgnoreCase(((acy)var3).aBC);
            });
        }

        return arraylist1;
    }
}
