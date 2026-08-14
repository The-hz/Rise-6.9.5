package hackclient.rise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

final class adb implements ada {
    private static final String[] aBI = new String[]{"add", "remove"};

    adb() {
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

            for (String s2 : aBI) {
                String s3 = s2.toLowerCase(Locale.ROOT);
                if (s1.isEmpty() || s3.startsWith(s1)) {
                    arraylist.add(new acy(s2, "Target subcommand", ".target <add/remove> <player>", s2, 0, true));
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
        if (!s4.equals("add") && !s4.equals("remove")) {
            return Collections.emptyList();
        }

        String s5 = astring[1] == null ? "" : astring[1].toLowerCase(Locale.ROOT);
        ArrayList arraylist1 = new ArrayList();
        Minecraft minecraft = Minecraft.getMinecraft();
        if (minecraft.theWorld == null) {
            return Collections.emptyList();
        }

        for (EntityPlayer entityplayer : minecraft.theWorld.playerEntities) {
            String s6 = entityplayer.getName();
            String s7 = s6.toLowerCase(Locale.ROOT);
            if ((s5.isEmpty() || s7.startsWith(s5)) && (!s4.equals("remove") || bx.n(s6))) {
                arraylist1.add(new acy(s6, "Player", ".target <add/remove> <player>", s6, 1, false));
            }
        }

        arraylist1.sort((var2, var3) -> {
            String s8 = ((acy)var2).aBC.toLowerCase(Locale.ROOT);
            String s9 = ((acy)var3).aBC.toLowerCase(Locale.ROOT);
            boolean flag = !s5.isEmpty() && s8.equals(s5);
            boolean flag1 = !s5.isEmpty() && s9.equals(s5);
            if (flag != flag1) {
                return flag ? -1 : 1;
            }

            long i = acl.b(s, 1, s8);
            long j = acl.b(s, 1, s9);
            return i != j ? Long.compare(j, i) : ((acy)var2).aBC.compareToIgnoreCase(((acy)var3).aBC);
        });
        return arraylist1;
    }
}
