package hackclient.rise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

final class acp implements ada {
    private static final String[] aBi = new String[]{"up", "down", "forward", "back", "left", "right"};

    acp() {
    }

    @Override
    public List<acy> b(acz var1) {
        String[] astring = var1.rk();
        if (astring.length == 0) {
            return Collections.emptyList();
        }

        String s = acl.aQ(var1.rj());
        String s1 = var1.rj().toLowerCase(Locale.ROOT);
        if (!s1.equals("vclip") && !s1.equals("hclip")) {
            if (!s1.equals("clip")) {
                return Collections.emptyList();
            }

            if (astring.length != 1) {
                return Collections.emptyList();
            }

            String s2 = astring[0] == null ? "" : astring[0].toLowerCase(Locale.ROOT);
            ArrayList arraylist = new ArrayList();

            for (String s3 : aBi) {
                String s4 = s3.toLowerCase(Locale.ROOT);
                if (s2.isEmpty() || s4.startsWith(s2)) {
                    arraylist.add(new acy(s3, "Clip direction", ".clip <up/down/forward/back/left/right> <amount>", s3, 0, true));
                }
            }

            arraylist.sort((var2, var3) -> {
                String s5 = ((acy)var2).aBC.toLowerCase(Locale.ROOT);
                String s6 = ((acy)var3).aBC.toLowerCase(Locale.ROOT);
                int i = s5.equals(s2) ? 2 : (s5.startsWith(s2) ? 1 : 0);
                int j = s6.equals(s2) ? 2 : (s6.startsWith(s2) ? 1 : 0);
                if (i != j) {
                    return Integer.compare(j, i);
                }

                long k = acl.b(s, 0, s5);
                long l = acl.b(s, 0, s6);
                return k != l ? Long.compare(l, k) : ((acy)var2).aBC.compareToIgnoreCase(((acy)var3).aBC);
            });
            return arraylist;
        }
        return Collections.emptyList();
    }
}
