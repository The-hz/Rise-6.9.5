package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.component.impl.player.LastConnectionComponent;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import lombok.Generated;
import net.minecraft.block.Block;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.network.OldServerPinger;
import net.minecraft.init.Blocks;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import org.apache.commons.lang3.StringUtils;

public class ahm implements InstanceAccess
{
    public static long aOR;
    public static Object[] oO00O0OO0ooO;
    public static Object[] fld_0oOOoOo0O00O_6;
    public static Object aPd;
    public static Object[] fld_0OOOoo00o0_7;
    public static Map<String, Boolean> aPg;
    public static boolean aPf;
    public static Pattern aOP;
    public static Object aOX;
    public static int aPb;
    public static Pattern aOL;
    public static Pattern aOM;
    public static Map<String, aij> aOS;
    public static String aPc;
    public static Pattern aOO;
    public static boolean aOZ;
    public static Object[] o0Oo000O0oO;
    public static long aOQ;
    public static Object aPa;
    public static int aPe;
    public static int aOT;
    public static int aOW;
    public static String aOV;
    public static Object Oo0o00000O00;
    public static int aOY;
    public static Pattern aON;
    public static boolean aOU;
    public static OldServerPinger aPh;

    public static boolean vv() {
        final ScoreObjective vw = vw();
        if (vw == null) {
            return false;
        }
        final List<Object> list = (List<Object>)((Collection)((ScoreObjective)vw).getScoreboard().getSortedScores((ScoreObjective)vw)).stream().filter(score2 -> ((Score)score2).getPlayerName() != null && !((Score)score2).getPlayerName().startsWith("#")).collect((Collector<? super Object, ?, List<Object>>)Collectors.toList());
        final ArrayList list2 = (ArrayList)((list.size() > 15) ? Lists.newArrayList(Iterables.skip((Iterable)list, list.size() - 15)) : list);
        final StringBuilder sb = new StringBuilder();
        final Iterator iterator = list2.iterator();
        while (((Iterator)iterator).hasNext()) {
            final Score score = (Score)((Iterator)iterator).next();
            final String textWithoutFormattingCodes = EnumChatFormatting.getTextWithoutFormattingCodes(ScorePlayerTeam.formatPlayerName((Team)(ScorePlayerTeam)((ScoreObjective)vw).getScoreboard().getPlayersTeam(((Score)score).getPlayerName()), ((Score)score).getPlayerName()));
            if (textWithoutFormattingCodes != null && !((String)textWithoutFormattingCodes).isEmpty()) {
                if (((StringBuilder)sb).length() > 0) {
                    ((StringBuilder)sb).append(' ');
                }
                ((StringBuilder)sb).append(textWithoutFormattingCodes);
            }
        }
        return ahm.aOP.matcher(sb).find();
    }

    public static ServerData d(final String s, final int n, final int n2) {
        try {
            final String string = (Object)(String)s + ":" + n;
            final ServerData serverData = new ServerData((String)string, (String)string, false);
            ahm.aPh.ping(serverData, n2);
            return serverData;
        }
        catch (final Exception ex) {
            return null;
        }
    }

    public static Object o0Oo000O0oO(final Object[] array) {
        try {
            final int intValue = (int)array[1];
            final String s = (String)array[2];
            final Object o = array[0];
            Object[] oo00O0OO0ooO;
            if ((oo00O0OO0ooO = ahm.oO00O0OO0ooO) == null) {
                oo00O0OO0ooO = (ahm.oO00O0OO0ooO = new Object[] { null });
            }
            Object o2;
            if ((o2 = oo00O0OO0ooO[intValue]) == null) {
                Object[] array2;
                if ((array2 = (Object[])o) == null) {
                    final Object[] array3 = ahm.fld_0OOOoo00o0_7 = (array2 = new Object[] { null });
                    final int n = 0;
                    final byte[] array4 = new byte[16];
                    ((byte[])array4)[10] = 32;
                    ((byte[])array4)[7] = 60;
                    ((byte[])array4)[13] = -99;
                    ((byte[])array4)[11] = 37;
                    ((byte[])array4)[15] = -59;
                    ((byte[])array4)[4] = 114;
                    ((byte[])array4)[12] = 45;
                    ((byte[])array4)[2] = -31;
                    ((byte[])array4)[0] = -3;
                    ((byte[])array4)[6] = -107;
                    ((byte[])array4)[3] = 53;
                    ((byte[])array4)[14] = 53;
                    ((byte[])array4)[8] = 124;
                    ((byte[])array4)[1] = -4;
                    ((byte[])array4)[9] = 94;
                    ((byte[])array4)[5] = 86;
                    array3[n] = array4;
                }
                final byte[] array5 = (byte[])array2[0];
                if (ahm.Oo0o00000O00 == null) {
                    final byte[] array6 = new byte[32];
                    ((byte[])array6)[22] = -91;
                    ((byte[])array6)[8] = -74;
                    ((byte[])array6)[20] = 72;
                    ((byte[])array6)[24] = 31;
                    ((byte[])array6)[23] = -6;
                    ((byte[])array6)[3] = -51;
                    ((byte[])array6)[1] = -26;
                    ((byte[])array6)[11] = -98;
                    ((byte[])array6)[19] = -122;
                    ((byte[])array6)[9] = -34;
                    ((byte[])array6)[28] = 68;
                    ((byte[])array6)[14] = -110;
                    ((byte[])array6)[7] = 45;
                    ((byte[])array6)[2] = 121;
                    ((byte[])array6)[16] = 21;
                    ((byte[])array6)[12] = -85;
                    ((byte[])array6)[0] = -52;
                    ((byte[])array6)[10] = 99;
                    ((byte[])array6)[17] = -118;
                    ((byte[])array6)[15] = 98;
                    ((byte[])array6)[25] = -7;
                    ((byte[])array6)[21] = 2;
                    ((byte[])array6)[18] = 71;
                    ((byte[])array6)[29] = -12;
                    ((byte[])array6)[6] = 75;
                    ((byte[])array6)[27] = 72;
                    ((byte[])array6)[31] = 75;
                    ((byte[])array6)[4] = 107;
                    ((byte[])array6)[13] = -1;
                    ((byte[])array6)[5] = 84;
                    ((byte[])array6)[26] = -51;
                    ((byte[])array6)[30] = -41;
                    final byte[] array7 = new byte[((byte[])array5).length + ((byte[])array6).length];
                    System.arraycopy(array5, 0, array7, 0, ((byte[])array5).length);
                    System.arraycopy(array6, 0, array7, ((byte[])array5).length, ((byte[])array6).length);
                    Object o3;
                    if ((o3 = mth_0OOOoo00o0_3()[1]) == null) {
                        final char[] charArray = "\u20b2\u20e4\u20b3\u20de\u2090\u2094\u2097\u9451\u944e\u208a\u20ea\u944d\u2089\u208b\u20bb\u20ea\u20e9\u2099".toCharArray();
                        for (int i = 0; i < 18; ++i) {
                            ((char[])charArray)[i] = (char)(((((((char[])charArray)[i] - '\u1ac0' ^ 0x3C22) - 60868 ^ 0xA2E6) + 6569 - 46351 - 27279 ^ 0x2B12) - 15635 ^ 0xD413) - 3701 - 3638 + 60630 + 49981 - 58847);
                        }
                        o3 = (mth_0OOOoo00o0_3()[1] = new String(charArray));
                    }
                    final SecretKeyFactory instance = SecretKeyFactory.getInstance((String)o3);
                    final byte[] array8 = new byte[16];
                    ((byte[])array8)[14] = 107;
                    ((byte[])array8)[10] = -54;
                    ((byte[])array8)[4] = 6;
                    ((byte[])array8)[7] = -44;
                    ((byte[])array8)[8] = 91;
                    ((byte[])array8)[2] = 113;
                    ((byte[])array8)[6] = -16;
                    ((byte[])array8)[0] = 20;
                    ((byte[])array8)[12] = 33;
                    ((byte[])array8)[11] = -72;
                    ((byte[])array8)[9] = -21;
                    ((byte[])array8)[3] = -31;
                    ((byte[])array8)[5] = -71;
                    ((byte[])array8)[1] = -94;
                    ((byte[])array8)[13] = 68;
                    ((byte[])array8)[15] = 50;
                    final byte[] key = (byte[])((SecretKeyFactory)instance).generateSecret(new PBEKeySpec(new String(array7, StandardCharsets.UTF_8).toCharArray(), array8, 9, 256)).getEncoded();
                    Object o4;
                    if ((o4 = mth_0OOOoo00o0_3()[2]) == null) {
                        final char[] charArray2 = "\ue6b2\ue6a6\ue718".toCharArray();
                        for (int j = 0; j < 3; ++j) {
                            ((char[])charArray2)[j] = (char)(((((((char[])charArray2)[j] - '\uc1e0' - 62276 ^ 0x8125 ^ 0xE9E5) + 50729 - 5516 ^ 0x966E ^ 0x5B13) - 39604 ^ 0xBA54 ^ 0xB4B7) - 24984 + 6298 ^ 0x3C3A) - 64699 ^ 0xE53F);
                        }
                        o4 = (mth_0OOOoo00o0_3()[2] = new String(charArray2));
                    }
                    ahm.Oo0o00000O00 = new SecretKeySpec(key, (String)o4);
                }
                final byte[] decode = Base64.getDecoder().decode(s);
                final byte[] copyOfRange = Arrays.copyOfRange(decode, 0, 16);
                final byte[] copyOfRange2 = Arrays.copyOfRange(decode, 16, ((byte[])decode).length);
                Object o5;
                if ((o5 = mth_0OOOoo00o0_3()[3]) == null) {
                    final char[] charArray3 = "\u79d2\u79d6\u79c8\u7964\u79d8\u79d7\u79d8\u7964\u79c1\u79d0\u79d8\u79c8\u7966\u79c1\u79b2\u79b5\u79b5\u7a2a\u7a33\u7a2c".toCharArray();
                    for (int k = 0; k < 20; ++k) {
                        ((char[])charArray3)[k] = (char)(((((char[])charArray3)[k] + '\u2201' - 51554 ^ 0xBE25 ^ 0xDD67) + 43147 + 23629 - 146 + 51443 + 46069 - 17557 + 48022 ^ 0xB238) - 6937);
                    }
                    o5 = (mth_0OOOoo00o0_3()[3] = new String(charArray3));
                }
                final Cipher instance2 = Cipher.getInstance((String)o5);
                ((Cipher)instance2).init(2, (java.security.Key)ahm.Oo0o00000O00, (AlgorithmParameterSpec)new IvParameterSpec(copyOfRange));
                o2 = (ahm.oO00O0OO0ooO[intValue] = new String(((Cipher)instance2).doFinal(copyOfRange2), StandardCharsets.UTF_8));
            }
            return o2;
        } catch (java.security.GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object[] mth_0OOOoo00o0_3() {
        Object[] fld_0oOOoOo0O00O_6;
        if ((fld_0oOOoOo0O00O_6 = ahm.fld_0oOOoOo0O00O_6) == null) {
            fld_0oOOoOo0O00O_6 = (ahm.fld_0oOOoOo0O00O_6 = new Object[4]);
        }
        return fld_0oOOoOo0O00O_6;
    }

    public static boolean a(final Pattern[] array) {
        return b(array) != null;
    }

    public static boolean a(final ScoreObjective scoreObjective) {
        if (scoreObjective == null) {
            return false;
        }
        final Iterator iterator = scoreObjective.getScoreboard().getSortedScores(scoreObjective).iterator();
        while (((Iterator)iterator).hasNext()) {
            final Score score = (Score)((Iterator)iterator).next();
            if (score != null && ((Score)score).getPlayerName() != null && !((Score)score).getPlayerName().startsWith("#")) {
                return true;
            }
        }
        return false;
    }

    public static String vu() {
        if (ahm.aEg == null || ahm.aEg.theWorld == null || ahm.aEg.thePlayer == null) {
            return "";
        }
        int totalWorldTime = (int)((int)(ahm.aEg.theWorld.getTotalWorldTime() / 5L));
        if (ahm.aPd == ahm.aEg.theWorld && ahm.aPb == totalWorldTime) {
            return ahm.aPc;
        }
        final ScoreObjective vw = vw();
        if (vw == null) {
            ahm.aPd = ahm.aEg.theWorld;
            ahm.aPb = totalWorldTime;
            return ahm.aPc = "";
        }
        final List<Object> list = (List<Object>)((Collection)((ScoreObjective)vw).getScoreboard().getSortedScores((ScoreObjective)vw)).stream().filter(score2 -> {
            boolean b;
            if (((Score)score2).getPlayerName() != null && !((Score)score2).getPlayerName().startsWith("#")) {
                b = true;
            }
            else {
                b = (9 - 9 != 0);
            }
            return b;
        }).collect((Collector<? super Object, ?, List<Object>>)Collectors.toList());
        final ArrayList list2 = (ArrayList)((list.size() > 15) ? Lists.newArrayList(Iterables.skip((Iterable)list, list.size() - 15)) : list);
        final StringBuilder sb = new StringBuilder();
        final Iterator iterator = list2.iterator();
        while (((Iterator)iterator).hasNext()) {
            final Score score = (Score)((Iterator)iterator).next();
            final String textWithoutFormattingCodes = EnumChatFormatting.getTextWithoutFormattingCodes(ScorePlayerTeam.formatPlayerName((Team)(ScorePlayerTeam)((ScoreObjective)vw).getScoreboard().getPlayersTeam(((Score)score).getPlayerName()), ((Score)score).getPlayerName()));
            if (textWithoutFormattingCodes != null && !((String)textWithoutFormattingCodes).isEmpty()) {
                if (((StringBuilder)sb).length() > 0) {
                    ((StringBuilder)sb).append(' ');
                }
                ((StringBuilder)sb).append(textWithoutFormattingCodes);
            }
        }
        ahm.aPd = ahm.aEg.theWorld;
        ahm.aPb = totalWorldTime;
        return ahm.aPc = cj(((StringBuilder)sb).toString());
    }

    public static boolean vm() {
        if (ahm.aEg == null || ahm.aEg.theWorld == null || ahm.aEg.thePlayer == null) {
            return false;
        }
        int totalWorldTime = (int)((int)(ahm.aEg.theWorld.getTotalWorldTime() / 5L));
        if (ahm.aPa == ahm.aEg.theWorld && ahm.aOY == totalWorldTime) {
            return ahm.aOZ;
        }
        ahm.aOZ = (vv() || ci("www.hypixel"));
        ahm.aOY = totalWorldTime;
        ahm.aPa = ahm.aEg.theWorld;
        return false;
    }

    public static ScoreObjective vw() {
        if (ahm.aEg == null || ahm.aEg.theWorld == null || ahm.aEg.thePlayer == null) {
            return null;
        }
        final Scoreboard scoreboard = ahm.aEg.theWorld.getScoreboard();
        if (scoreboard == null) {
            return null;
        }
        final ScoreObjective objectiveInDisplaySlot = ((Scoreboard)scoreboard).getObjectiveInDisplaySlot(1);
        ScoreObjective objectiveInDisplaySlot2 = null;
        final ScorePlayerTeam playersTeam = ((Scoreboard)scoreboard).getPlayersTeam(ahm.aEg.thePlayer.getName());
        if (playersTeam != null) {
            final EnumChatFormatting chatFormat = ((ScorePlayerTeam)playersTeam).getChatFormat();
            if (chatFormat != null) {
                int colorIndex = ((EnumChatFormatting)chatFormat).getColorIndex();
                if (colorIndex > -1) {
                    objectiveInDisplaySlot2 = ((Scoreboard)scoreboard).getObjectiveInDisplaySlot(3 + colorIndex);
                }
            }
        }
        if (a(objectiveInDisplaySlot2)) {
            return objectiveInDisplaySlot2;
        }
        if (a(objectiveInDisplaySlot)) {
            return objectiveInDisplaySlot;
        }
        return (objectiveInDisplaySlot2 != null) ? objectiveInDisplaySlot2 : objectiveInDisplaySlot;
    }

    public static String b(final Pattern[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        final String vu = vu();
        if (((String)vu).isEmpty()) {
            return null;
        }
        int limit = ((Pattern[])array).length;
        for (int i = 0; i < limit; i++) {
            final Pattern pattern = ((Pattern[])array)[i];
            if (pattern != null) {
                final Matcher matcher = pattern.matcher(vu);
                if (((Matcher)matcher).find()) {
                    return ((Matcher)matcher).group();
                }
            }
        }
        return null;
    }


    public static String cj(final String s) {
        final String lowerCase = StringUtils.trimToEmpty(s).toLowerCase(Locale.ROOT);
        if (((String)lowerCase).isEmpty()) {
            return "";
        }
        return ((String)Normalizer.normalize(lowerCase, Normalizer.Form.NFD).replaceAll("\\p{M}+", "")).replaceAll("\\s+", " ");
    }

    public static boolean nS() {
        if (ahm.aEg == null || ahm.aEg.thePlayer == null || ahm.aEg.theWorld == null) {
            return false;
        }
        int totalWorldTime = (int)ahm.aEg.theWorld.getTotalWorldTime();
        if (ahm.aPe == totalWorldTime) {
            return ahm.aPf;
        }
        int n11_hi = 0;
        int floor_double2 = MathHelper.floor_double(ahm.aEg.thePlayer.posX);
        int floor_double3 = MathHelper.floor_double(ahm.aEg.thePlayer.posZ);
        for (int i2 = -2; i2 <= 2; i2++) {
            for (int j = -2; j <= 2; j++) {
                if (i(floor_double2 + i2, floor_double3 + j)) {
                    n11_hi++;
                }
            }
        }
        ahm.aPf = (((n11_hi >= 16) ? 1 : 0) != 0);
        ahm.aPe = totalWorldTime;
        return false;
    }

    public static String aC(final String s) {
        final String trimToEmpty = StringUtils.trimToEmpty(s);
        int indexOf2 = trimToEmpty.indexOf(58);
        return (indexOf2 >= 0) ? trimToEmpty.substring(0, indexOf2) : trimToEmpty;
    }

    static {
        ahm.o0Oo000O0oO = new Object[51];
        int n10_hi = 0;
        final Object[] array = { ahm.fld_0OOOoo00o0_7, Integer.valueOf(0), null };
        final int n11 = 2;
        Object o;
        if ((o = mth_0OOOoo00o0_3()[0]) == null) {
            final char[] charArray = "\u2393\u2159\u214c\u238d\u2153\u20f3\u20e6\u20a8\u238d\u2147\u2144\u20ea\u20e7\u2159\u215f\u20a9\u20f6\u238c\u20ae\u208f\u20b6\u2146\u20cf\u2387\u2152\u2387\u2155\u2155\u2153\u214b\u2089\u20ec\u2083\u20ed\u20fd\u20e1\u238c\u20e0\u20ba\u20cf\u215f\u20a8\u20e5\u238d\u20f6\u20c8\u2387\u20c8\u20ae\u214c\u2141\u20f8\u20eb\u2146\u20ae\u20f2\u2088\u20a9\u20e6\u20b4\u214d\u20fa\u2146\u2089\u2089\u20f3\u2144\u20eb\u2154\u2155\u20f2\u20c8\u2387\u20e4\u20b5\u2159\u2393\u2387\u20fa\u20e7\u20e5\u208f\u208f\u20ea\u20af\u20eb\u20f8\u20eb\u2156\u2147\u238d\u2088\u20e1\u20f2\u20fa\u2141\u20fa\u238b\u20b6\u20fd\u20e5\u2140\u20ed\u2163\u20fd\u20b4\u214b\u20f8\u215a\u2152\u20ae\u20f9\u2145\u2147\u2163\u215f\u20b5\u215c\u20e0\u215c\u20e5\u20e6\u2152\u20e1\u2158\u238d\u238d\u20b6\u2147\u20eb\u20fd\u215f\u20c8\u2152\u20ec\u2163\u20fa\u2141\u214b\u20f2\u20ae\u2154\u20ff\u20e4\u214d\u208f\u208f\u20b5\u214b\u20af\u20e5\u2140\u2147\u20f6\u214b\u20ce\u20fc\u2393\u2158\u20b6\u2141\u20eb\u214a\u2158\u2387\u20ba\u20e6\u20ce\u20fc\u238d\u2163\u20cf\u20fc\u20f2\u20ec\u2155\u2141\u2393\u20e4\u2153\u20ce\u20ff\u20e6\u20fc\u2089\u215d\u20f5\u214a\u20eb\u20e4\u2147\u2146\u20ee\u2152\u215c\u2089\u20fa\u20ae\u20ce\u20c9\u215a\u20e0\u2083\u215c\u2159\u20ff\u2089\u208f\u20b5\u20f8\u208f\u20e0\u2387\u2146\u214c\u20f5\u20e0\u215f\u2144\u20e7\u214a\u20e5\u20b4\u2145\u20fd\u215f\u20e5\u2156\u215f\u2163\u2146\u2156\u20ea\u20e4\u214c\u20b5\u215f\u238c\u2152\u20ba\u2159\u2156\u214c\u208f\u2088\u20a8\u20b6\u2156\u214d\u2145\u215f\u208f\u20c8\u2089\u2088\u238b\u2163\u238b\u20e4\u2156\u2163\u20e5\u214d\u2146\u215a\u2153\u214d\u20e4\u20ae\u215c\u208f\u20ee\u238d\u20b6\u238d\u208f\u20e5\u20e0\u20f5\u20e1\u20af\u215c\u238c\u208f\u215a\u20fa\u2088\u20e1\u2145\u215c\u20ec\u238c\u238b\u2083\u2144\u208f\u20ae\u214c\u2144\u20f3\u20e5\u20af\u20ff\u2144\u214a\u2146\u214a\u215d\u2156\u20fc\u20cf\u20ec\u20b6\u2145\u20fd\u2153\u238c\u20e6\u2147\u215c\u2083\u238c\u2387\u215d\u20e4\u2083\u2144\u2147\u238b\u2152\u2163\u20e6\u20b5\u2088\u20e5\u20e4\u2156\u2144\u2144\u20ec\u20ed\u2141\u215d\u2156\u20eb\u20ff\u20c9\u20e1\u20b5\u20f2\u20e7\u20fd\u2153\u20ae\u20e1\u20f8\u2088\u2159\u20e4\u20b6\u238c\u20e7\u20a8\u2159\u20fa\u2158\u2083\u20e7\u20fa\u2155\u20ce\u214c\u20f9\u2152\u20fd\u215c\u2088\u20fc\u215d\u2140\u2144\u238b\u20c8\u20f9\u2154\u2088\u2153\u214b\u20cf\u2153\u2141\u2158\u208f\u2141\u20b5\u2154\u208f\u2140\u20f3\u2152\u20ae\u214a\u238c\u20f8\u20eb\u2147\u2141\u214b\u20b6\u2144\u20b4\u215a\u20f9\u20ed\u238c\u2152\u20fa\u2156\u2141\u20fa\u214c\u2393\u214a\u20ff\u20f8\u20ba\u20e7\u20f3\u2159\u2141\u20a9\u2146\u2159\u20eb\u20eb\u20c9\u238c\u2140\u20f2\u20eb\u20f6\u2155\u2155\u20c8\u214c\u2159\u20cf\u238d\u2156\u2146\u20e1\u238b\u20b4\u20eb\u20ce\u2155\u2155\u215a\u20b5\u2088\u2140\u2147\u20f6\u20a9\u20a9\u2156\u238d\u20fd\u20b4\u238d\u214d\u2141\u20a9\u20e6\u2387\u20ae\u214d\u2152\u2156\u2089\u20c9\u2145\u215c\u20cf\u215f\u214d\u20e0\u208f\u2156\u238c\u2141\u20ae\u20e0\u20ff\u20fc\u20f8\u20e1\u2155\u2083\u238d\u20e4\u20fd\u2158\u2156\u20e6\u20ce\u20b6\u215f\u20ff\u2153\u215a\u20cf\u2144\u2145\u215a\u20a8\u238d\u2159\u2154\u20ed\u20ee\u214d\u2145\u20e1\u2089\u2140\u20c8\u20e6\u2153\u20e1\u20fc\u215c\u2156\u20f8\u20c8\u20a9\u20f3\u20b5\u214c\u20f9\u215f\u20f2\u20b4\u2140\u2146\u2393\u20e6\u238d\u20e7\u20c9\u20a8\u20c9\u20a9\u215a\u20f6\u2156\u20f8\u2145\u2155\u20ea\u20fd\u20e6\u20e0\u20e1\u20b5\u2387\u2140\u2088\u2393\u20b6\u20b5\u2159\u2152\u20f2\u20b4\u2393\u214c\u20ec\u2387\u20ce\u20fc\u2145\u214a\u20ee\u20f3\u2159\u2140\u214d\u2156\u2152\u20e4\u20e4\u20b6\u215f\u2140\u20eb\u20c8\u2083\u20f6\u215f\u20a9\u2141\u20af\u2156\u238b\u20fa\u2153\u20af\u2153\u20e7\u2154\u2155\u215f\u238b\u214c\u20e1\u2144\u2156\u20f9\u20ea\u20ba\u20f2\u214a\u2089\u2153\u20ff\u20e5\u20f5\u20ae\u20f5\u20f6\u2145\u214c\u20e5\u20e1\u20f9\u2153\u215f\u20ba\u214a\u20ce\u20f3\u20e6\u2163\u215d\u20e5\u2141\u20ea\u20e6\u215d\u215d\u20f6\u20f6\u20f6\u238d\u20f2\u215a\u2144\u20b5\u20ed\u215f\u2154\u2088\u2387\u20e7\u238c\u20b4\u20cf\u20ba\u2163\u214d\u2153\u2159\u2144\u20cf\u214a\u2387\u208f\u20e5\u214a\u20ed\u2155\u20ec\u20b5\u20eb\u20ce\u238d\u20f5\u2083\u2152\u20f5\u20e5\u20e5\u20f3\u20b5\u2145\u2145\u2146\u20eb\u2156\u2155\u20eb\u20f6\u2387\u2141\u215d\u20e0\u20a9\u20ed\u20e7\u20ae\u2393\u20fc\u20cf\u2144\u215f\u2155\u215c\u20ba\u2141\u20c8\u238b\u238c\u2155\u20ba\u2155\u20ff\u215f\u20e4\u20ba\u2141\u20c9\u20a8\u215a\u20c8\u20c9\u2146\u20e7\u2140\u2155\u238b\u238b\u20ed\u2088\u20b6\u208f\u2152\u2089\u2140\u238b\u20fa\u214b\u20eb\u20ed\u20cf\u2155\u20ea\u20ae\u2088\u238b\u20e5\u214c\u2083\u2159\u215c\u20e7\u20f2\u2140\u20ce\u215d\u2163\u20a8\u2159\u20e7\u238c\u20f2\u238d\u20ba\u20ae\u20f2\u20e5\u2158\u20fc\u20f3\u20fa\u20a8\u2153\u20f2\u20e0\u214c\u2144\u215f\u20a9\u20b6\u20fa\u214c\u20f3\u20eb\u20c9\u20cf\u20a9\u20ba\u2089\u2083\u20c9\u208f\u2159\u20f3\u20f8\u20ec\u20f3\u2158\u20fd\u2088\u2156\u20ce\u2141\u20a9\u2154\u20f8\u20e5\u215c\u2141\u214a\u20f8\u238c\u20f5\u215a\u2156\u20e5\u214b\u20ed\u2088\u20f8\u20ed\u20b6\u20c8\u20e0\u20f2\u2387\u20f6\u20ec\u2147\u20fc\u20f6\u20e0\u215a\u2145\u20b6\u20b4\u20c9\u20f2\u2141\u20fc\u214b\u2163\u20e1\u20e7\u20fa\u20ec\u20a8\u2140\u20a8\u238b\u20b6\u20f6\u20b4\u20f2\u2155\u2089\u20ae\u2158\u20ff\u20e0\u20ec\u20eb\u20ee\u2163\u2083\u20ea\u20f3\u20e4\u2088\u20e5\u20f9\u20fa\u20e1\u20f6\u2387\u20ae\u2156\u20af\u20f8\u238c\u2153\u2155\u20c9\u214a\u2163\u2141\u20c8\u215f\u20e5\u2083\u2147\u20fa\u2152\u2156\u20e5\u20fd\u2152\u2146\u20f5\u20f5\u20fc\u208f\u238d\u2140\u2152\u20f9\u2083\u2155\u20f6\u2146\u2141\u2089\u20ec\u20c9\u20f9\u2163\u2083\u2158\u2163\u20ee\u20f3\u2140\u20eb\u2393\u20ba\u20e0\u20a9\u20e5\u20b5\u2152\u20e5\u20fc\u2387\u214d\u2088\u20e1\u20ce\u2154\u20e7\u20a9\u20c8\u2089\u20ff\u20b6\u20ea\u2088\u20ec\u20c9\u20ae\u20ec\u2153\u2163\u20e5\u20a8\u20c8\u215f\u2154\u214a\u2155\u2140\u238b\u2145\u20ba\u214a\u2144\u2387\u20ce\u2144\u20ce\u20ec\u238b\u215c\u20ae\u20f3\u215d\u20af\u2153\u20f8\u20ed\u20af\u20f2\u215f\u20c9\u2146\u20fc\u20c9\u20ae\u20c9\u215c\u2158\u20e6\u20fa\u208f\u20a8\u238b\u238c\u215c\u20af\u20ae\u2088\u20ce\u2393\u215f\u2140\u20b6\u20cf\u2089\u20f6\u20af\u2163\u20b6\u208f\u2141\u2154\u2387\u2145\u215d\u20ce\u2156\u2145\u2156\u20fd\u20b4\u20b6\u20cf\u20ce\u2083\u20c9\u20b5\u2156\u238c\u20fd\u2158\u20b5\u20e0\u20fc\u20e6\u2153\u2156\u20f6\u2083\u20f5\u20f9\u214c\u20ce\u20f2\u20ec\u20a9\u238c\u2146\u214a\u2153\u20e4\u215c\u20ae\u2145\u2154\u215c\u215f\u20fd\u214a\u20fd\u20e5\u20f8\u20c8\u20ff\u215c\u2387\u208f\u2154\u20eb\u238b\u2163\u20fc".toCharArray();
            for (int i = 0; i < 1088; ++i) {
                ((char[])charArray)[i] = (char)(((((((char[])charArray)[i] ^ '\udc42') + 50437 - 40263 ^ 0x1268) + 38632 - 4940 ^ 0x87AE) + 50639 ^ 0xEA73) - 821 + 48729 - 47261 + 5149);
            }
            o = (mth_0OOOoo00o0_3()[0] = new String(charArray));
        }
        array[n11] = o;
        final char[] charArray2 = ((String)o0Oo000O0oO(array)).toCharArray();
        int limit = 786;
        int n33;
        for (int n17_lo = 0; n17_lo < limit; n17_lo = n33) {
            final char[] array2 = (char[])charArray2;
            final int n18 = n17_lo;
            int n17_lo2 = n17_lo + 1;
            int n2_lo = array2[n18];
            final char[] array3 = (char[])charArray2;
            final int n23 = n17_lo2;
            int n17_lo3 = n17_lo2 + 1;
            int n3_hi = array3[n23];
            int limit2 = n2_lo << 16 | n3_hi;
            final char[] array4 = new char[limit2];
            for (int j = 0; j < limit2; j++) {
                ((char[])array4)[j] = ((char[])charArray2)[n17_lo3 + j];
            }
            final Object[] o0Oo000O0oO = ahm.o0Oo000O0oO;
            final int n32 = n10_hi;
            n10_hi++;
            o0Oo000O0oO[n32] = new String(array4);
            n33 = n17_lo3 + limit2;
        }
        ahm.aOL = Pattern.compile("^(?:[a-zA-Z0-9-]+\\.)*(?:hypixel\\.net|hypixel\\.io|technoblade\\.club)(?:\\.)?$", 2);
        ahm.aOM = Pattern.compile("^([a-zA-Z0-9-]+)\\.[a-zA-Z0-9-]+\\.[a-zA-Z0-9-]+\\.fisx\\.uk$", 2);
        ahm.aON = Pattern.compile("^([a-zA-Z0-9-]+)(?:\\.[a-zA-Z0-9-]+)*\\.liquidproxy\\.net$", 2);
        ahm.aOO = Pattern.compile("Hypixel BungeeCord \\(.+\\) <- .+");
        ahm.aOP = Pattern.compile("[^\\s/]{1,4}/[^\\s/]{1,4}/[^\\s/]{1,8}");
        ahm.aOS = new ConcurrentHashMap<String, aij>();
        ahm.aOT = Integer.MIN_VALUE;
        ahm.aOV = "";
        ahm.aOW = Integer.MIN_VALUE;
        ahm.aOY = Integer.MIN_VALUE;
        ahm.aPb = Integer.MIN_VALUE;
        ahm.aPc = "";
        ahm.aPe = Integer.MIN_VALUE;
        ahm.aPg = new HashMap<String, Boolean>();
        ahm.aPh = new OldServerPinger();
    }

    public static boolean ci(final String s) {
        final ScoreObjective vw = vw();
        if (vw == null) {
            return false;
        }
        final List<Object> list = (List<Object>)((Collection)((ScoreObjective)vw).getScoreboard().getSortedScores((ScoreObjective)vw)).stream().filter(score2 -> ((Score)score2).getPlayerName() != null && !((Score)score2).getPlayerName().startsWith("#")).collect((Collector<? super Object, ?, List<Object>>)Collectors.toList());
        final Iterator iterator = ((list.size() > 15) ? Lists.newArrayList(Iterables.skip((Iterable)list, list.size() - 15)) : list).iterator();
        while (((Iterator)iterator).hasNext()) {
            final Score score = (Score)((Iterator)iterator).next();
            if (StringUtils.containsIgnoreCase((CharSequence)(String)EnumChatFormatting.getTextWithoutFormattingCodes(ScorePlayerTeam.formatPlayerName((Team)(ScorePlayerTeam)((ScoreObjective)vw).getScoreboard().getPlayersTeam(((Score)score).getPlayerName()), ((Score)score).getPlayerName())), (CharSequence)s)) {
                return true;
            }
        }
        return false;
    }

    public static boolean cg(final String s) {
        if (Client.a.s().nN()) {
            return false;
        }
        if (ahm.aPg.containsKey(s)) {
            return Boolean.valueOf(ahm.aPg.get((Object)s));
        }
        int containsIgnoreCase2 = (!ahm.aEg.isIntegratedServerRunning() && StringUtils.containsIgnoreCase((CharSequence)LastConnectionComponent.ip, (CharSequence)s)) ? 1 : 0;
        ahm.aPg.put(s, Boolean.valueOf((boolean)(containsIgnoreCase2 != 0)));
        return containsIgnoreCase2 != 0;
    }

    public static String ch(final String s) {
        final Matcher matcher = ahm.aOM.matcher(s);
        if (((Matcher)matcher).matches()) {
            return c(s, "https://redacted.invalid/lookup-route/" + (Object)(String)((Matcher)matcher).group(1), "target");
        }
        final Matcher matcher2 = ahm.aON.matcher(s);
        if (((Matcher)matcher2).matches()) {
            return c(s, "https://api.liquidbounce.net/api/v2/proxy/lookup-route/" + (Object)(String)((Matcher)matcher2).group(1), "domain");
        }
        return null;
    }

    public static boolean vn() {
        if (ahm.aEg == null || ahm.aEg.thePlayer == null || ahm.aEg.theWorld == null) {
            return false;
        }
        int ticksExisted2 = ahm.aEg.thePlayer.ticksExisted / 20;
        final String trimToEmpty = StringUtils.trimToEmpty(LastConnectionComponent.ip);
        int port2 = LastConnectionComponent.port;
        if (ahm.aOX == ahm.aEg.theWorld && ahm.aOT == ticksExisted2 && ahm.aOW == port2 && StringUtils.equals((CharSequence)ahm.aOV, (CharSequence)(String)trimToEmpty)) {
            return ahm.aOU;
        }
        ahm.aOU = vo();
        ahm.aOT = ticksExisted2;
        ahm.aOV = trimToEmpty;
        ahm.aOW = port2;
        ahm.aOX = ahm.aEg.theWorld;
        return ahm.aOU;
    }

    public static String c(final String s, final String spec, final String s2) {
        final long currentTimeMillis = System.currentTimeMillis();
        final aij aij = (aij)ahm.aOS.get(s);
        if (aij != null && ((aij)aij).awJ > currentTimeMillis) {
            return ((aij)aij).aPi;
        }
        final aij aij2 = new aij();
        try {
            final HttpsURLConnection httpsURLConnection = (HttpsURLConnection)new URL(spec).openConnection();
            ((HttpsURLConnection)httpsURLConnection).setRequestMethod("GET");
            ((HttpsURLConnection)httpsURLConnection).setConnectTimeout(2500);
            ((HttpsURLConnection)httpsURLConnection).setReadTimeout(2500);
            ((HttpsURLConnection)httpsURLConnection).setUseCaches(false);
            try {
                final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(((HttpsURLConnection)httpsURLConnection).getInputStream()));
                try {
                    final StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = ((BufferedReader)bufferedReader).readLine()) != null) {
                        ((StringBuilder)sb).append(line);
                    }
                    final JsonObject asJsonObject = new JsonParser().parse(((StringBuilder)sb).toString()).getAsJsonObject();
                    ((aij)aij2).aPi = ((((JsonObject)asJsonObject).has(s2) && !((JsonObject)asJsonObject).get(s2).isJsonNull()) ? aC(StringUtils.trimToEmpty(((JsonObject)asJsonObject).get(s2).getAsString()).toLowerCase(Locale.ENGLISH)) : "");
                    ((aij)aij2).awJ = currentTimeMillis + 300000L;
                    ((BufferedReader)bufferedReader).close();
                }
                catch (final Throwable t) {
                    try {
                        ((BufferedReader)bufferedReader).close();
                    }
                    catch (final Throwable t2) {
                        ((Throwable)t).addSuppressed(t2);
                    }
                    throw t;
                }
                ((HttpsURLConnection)httpsURLConnection).disconnect();
            }
            finally {
                ((HttpsURLConnection)httpsURLConnection).disconnect();
            }
        }
        catch (final Exception ex) {
            ((aij)aij2).aPi = "";
            ((aij)aij2).awJ = currentTimeMillis + 30000L;
        }
        ahm.aOS.put(s, aij2);
        return ((aij)aij2).aPi;
    }

    public static boolean vr() {
        if (ahm.aEg == null || ahm.aEg.thePlayer == null) {
            return false;
        }
        final String clientBrand = ahm.aEg.thePlayer.getClientBrand();
        return ((!StringUtils.isBlank((CharSequence)(String)clientBrand) && ahm.aOO.matcher(clientBrand).matches()) ? 1 : 0) != 0;
    }

    public static Path vt() {
        final aee rv = aed.rV();
        if (rv == aee.WINDOWS) {
            final String getenv = System.getenv("WinDir");
            if (StringUtils.isBlank((CharSequence)(String)getenv)) {
                return null;
            }
            final String first = (String)getenv;
            final String[] more = { "System32", "drivers", null, null };
            more[2] = "etc";
            more[3] = "hosts";
            return Paths.get(first, more);
        }
        if (rv == aee.LINUX || rv == aee.MACOS || rv == aee.SOLARIS) {
            return Paths.get("/etc/hosts", new String[0]);
        }
        return null;
    }

    public static Block c(final int n, final int n2, final int n3) {
        return ahm.aEg.theWorld.getBlockState(new BlockPos(n, n2, n3)).getBlock();
    }

    public static boolean vp() {
        final String ac = aC(StringUtils.trimToEmpty(LastConnectionComponent.ip).toLowerCase(Locale.ENGLISH));
        if (((String)ac).isEmpty()) {
            return false;
        }
        if (((String)ac).equals("localhost") || ((String)ac).startsWith("127.") || ((String)ac).equals("::1") || ((String)ac).equals("0:0:0:0:0:0:0:1")) {
            return false;
        }
        final Matcher matcher = ahm.aOM.matcher(ac);
        if (((Matcher)matcher).matches()) {
            final String c = c(ac, "https://redacted.invalid/lookup-route/" + (Object)(String)((Matcher)matcher).group(1), "target");
            return ((String)c).isEmpty() || ahm.aOL.matcher(c).matches();
        }
        final Matcher matcher2 = ahm.aON.matcher(ac);
        if (((Matcher)matcher2).matches()) {
            final String c2 = c(ac, "https://api.liquidbounce.net/api/v2/proxy/lookup-route/" + (Object)(String)((Matcher)matcher2).group(1), "domain");
            return ((String)c2).isEmpty() || ahm.aOL.matcher(c2).matches();
        }
        return ahm.aOL.matcher(ac).matches() && LastConnectionComponent.port == 25565;
    }

    @Generated
    ahm() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static boolean vs() {
        try {
            final Path vt = vt();
            if (vt == null || !Files.exists(vt, new LinkOption[0]) || !Files.isReadable(vt)) {
                return false;
            }
            final String lowerCase = new String(Files.readAllBytes(vt)).toLowerCase(Locale.ENGLISH);
            return ((String)lowerCase).contains((CharSequence)"riseclient.com") || ((String)lowerCase).contains((CharSequence)"vantage") || ((String)lowerCase).contains((CharSequence)"hypixel.net") || ((String)lowerCase).contains((CharSequence)"www.hypixel.net") || ((String)lowerCase).contains((CharSequence)"hypixel");
        }
        catch (final Exception ex) {
            return false;
        }
    }

    public static boolean vq() {
        final String clientBrand = ahm.aEg.thePlayer.getClientBrand();
        return StringUtils.isBlank((CharSequence)(String)clientBrand) || ahm.aOO.matcher(clientBrand).matches();
    }

    public static boolean a(final Pattern pattern) {
        if (pattern == null) {
            return false;
        }
        final String ac = aC(StringUtils.trimToEmpty(LastConnectionComponent.ip).toLowerCase(Locale.ENGLISH));
        if (((String)ac).isEmpty()) {
            return false;
        }
        if (pattern.matcher(ac).find()) {
            return true;
        }
        final String ch = ch(ac);
        return ch != null && !((String)ch).isEmpty() && pattern.matcher(ch).find();
    }

    public static boolean vo() {
        if (Client.a.s().nN()) {
            return false;
        }
        if (ahm.aEg == null || ahm.aEg.thePlayer == null || ahm.aEg.theWorld == null || ahm.aEg.isIntegratedServerRunning()) {
            return false;
        }
        return !StringUtils.containsIgnoreCase((CharSequence)LastConnectionComponent.ip, (CharSequence)"test") && !vs() && !nS() && vp() && vq() && vm();
    }

    public static boolean i(final int n, final int n2) {
        return c(n, 0, n2) == Blocks.bedrock && c(n, 1, n2) == Blocks.dirt && c(n, 2, n2) == Blocks.dirt && c(n, 3, n2) == Blocks.grass && c(n, 4, n2) == Blocks.air && c(n, 5, n2) == Blocks.air;
    }
}
