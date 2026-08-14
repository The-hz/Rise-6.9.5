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
    public static int[] O0OoOO0OOOOO;
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
        final long n3 = 6664250340152746196L;
        try {
            final long n4 = (long)n << 32;
            final long n5 = n3;
            final String string = (Object)(String)s + ":" + (int)((n5 ^ ((n4 ^ n5) & -1L << 32)) >>> 32);
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
        final long n = -4753052636897831104L;
        if (ahm.aEg == null || ahm.aEg.theWorld == null || ahm.aEg.thePlayer == null) {
            return "";
        }
        final long n2 = (long)(int)(ahm.aEg.theWorld.getTotalWorldTime() / 5L) << 32;
        final long n3 = n;
        final long n4 = n3 ^ ((n2 ^ n3) & -1L << 32);
        if (ahm.aPd == ahm.aEg.theWorld && ahm.aPb == (int)(n4 >>> 32)) {
            return ahm.aPc;
        }
        final ScoreObjective vw = vw();
        if (vw == null) {
            ahm.aPd = ahm.aEg.theWorld;
            ahm.aPb = (int)(n4 >>> 32);
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
        ahm.aPb = (int)(n4 >>> 32);
        return ahm.aPc = cj(((StringBuilder)sb).toString());
    }

    public static boolean vm() {
        final long n = -8681006949482774149L;
        if (ahm.aEg == null || ahm.aEg.theWorld == null || ahm.aEg.thePlayer == null) {
            return false;
        }
        final long n2 = (long)(int)(ahm.aEg.theWorld.getTotalWorldTime() / 5L) << 32;
        final long n3 = n;
        final long n4 = n3 ^ ((n2 ^ n3) & -1L << 32);
        if (ahm.aPa == ahm.aEg.theWorld && ahm.aOY == (int)(n4 >>> 32)) {
            return ahm.aOZ;
        }
        ahm.aOZ = (vv() || ci("www.hypixel"));
        ahm.aOY = (int)(n4 >>> 32);
        ahm.aPa = ahm.aEg.theWorld;
        return false;
    }

    public static ScoreObjective vw() {
        final long n = -2568480668365641905L;
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
                final long n2 = (long)((EnumChatFormatting)chatFormat).getColorIndex() << 32;
                final long n3 = n;
                final long n4 = n3 ^ ((n2 ^ n3) & -1L << 32);
                if ((int)(n4 >>> 32) > -1) {
                    objectiveInDisplaySlot2 = ((Scoreboard)scoreboard).getObjectiveInDisplaySlot(3 + (int)(n4 >>> 32));
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
        final long n = 7415200234058367088L;
        final long n2 = -6480405972923604784L;
        if (array == null || array.length == 0) {
            return null;
        }
        final String vu = vu();
        if (((String)vu).isEmpty()) {
            return null;
        }
        final long n3 = (long)((Pattern[])array).length;
        final long n4 = n;
        final long n5 = n4 ^ ((n3 ^ n4) & -1L >>> 32);
        final long n6 = 0L;
        final long n7 = n2;
        for (long n8 = n7 ^ ((n6 ^ n7) & -1L << 32); (int)(n8 >>> 32) < (int)n5; n8 += 4294967296L) {
            final Pattern pattern = ((Pattern[])array)[(int)(n8 >>> 32)];
            if (pattern != null) {
                final Matcher matcher = pattern.matcher(vu);
                if (((Matcher)matcher).find()) {
                    return ((Matcher)matcher).group();
                }
            }
        }
        return null;
    }

    public static void Oo0o00000O00() {
        (ahm.O0OoOO0OOOOO = new int[400])[81] = -108;
        ahm.O0OoOO0OOOOO[170] = -128;
        ahm.O0OoOO0OOOOO[163] = -13;
        ahm.O0OoOO0OOOOO[321] = -44;
        ahm.O0OoOO0OOOOO[78] = 98;
        ahm.O0OoOO0OOOOO[113] = -97;
        ahm.O0OoOO0OOOOO[176] = 2627;
        ahm.O0OoOO0OOOOO[317] = 164;
        ahm.O0OoOO0OOOOO[324] = 38;
        ahm.O0OoOO0OOOOO[375] = -31;
        ahm.O0OoOO0OOOOO[385] = 83;
        ahm.O0OoOO0OOOOO[28] = 1;
        ahm.O0OoOO0OOOOO[111] = 48;
        ahm.O0OoOO0OOOOO[61] = 61;
        ahm.O0OoOO0OOOOO[122] = -55;
        ahm.O0OoOO0OOOOO[90] = -84;
        ahm.O0OoOO0OOOOO[0] = 56;
        ahm.O0OoOO0OOOOO[263] = -21;
        ahm.O0OoOO0OOOOO[140] = 40;
        ahm.O0OoOO0OOOOO[83] = -112;
        ahm.O0OoOO0OOOOO[160] = -48;
        ahm.O0OoOO0OOOOO[240] = 48;
        ahm.O0OoOO0OOOOO[45] = -81;
        ahm.O0OoOO0OOOOO[211] = 114;
        ahm.O0OoOO0OOOOO[284] = -68;
        ahm.O0OoOO0OOOOO[286] = -59;
        ahm.O0OoOO0OOOOO[164] = -25475;
        ahm.O0OoOO0OOOOO[151] = -123;
        ahm.O0OoOO0OOOOO[247] = 12;
        ahm.O0OoOO0OOOOO[393] = -94;
        ahm.O0OoOO0OOOOO[186] = -67;
        ahm.O0OoOO0OOOOO[21] = -21;
        ahm.O0OoOO0OOOOO[206] = -108;
        ahm.O0OoOO0OOOOO[352] = 26;
        ahm.O0OoOO0OOOOO[333] = -74;
        ahm.O0OoOO0OOOOO[167] = -25;
        ahm.O0OoOO0OOOOO[216] = 1;
        ahm.O0OoOO0OOOOO[243] = 3;
        ahm.O0OoOO0OOOOO[188] = -24;
        ahm.O0OoOO0OOOOO[195] = -29;
        ahm.O0OoOO0OOOOO[5] = -88;
        ahm.O0OoOO0OOOOO[266] = 60;
        ahm.O0OoOO0OOOOO[250] = -9;
        ahm.O0OoOO0OOOOO[392] = 19;
        ahm.O0OoOO0OOOOO[332] = 99;
        ahm.O0OoOO0OOOOO[395] = -125;
        ahm.O0OoOO0OOOOO[312] = 117;
        ahm.O0OoOO0OOOOO[181] = 62;
        ahm.O0OoOO0OOOOO[329] = 115;
        ahm.O0OoOO0OOOOO[244] = -42;
        ahm.O0OoOO0OOOOO[68] = 118;
        ahm.O0OoOO0OOOOO[293] = -2;
        ahm.O0OoOO0OOOOO[255] = 40;
        ahm.O0OoOO0OOOOO[304] = -99;
        ahm.O0OoOO0OOOOO[335] = -132;
        ahm.O0OoOO0OOOOO[215] = -77;
        ahm.O0OoOO0OOOOO[224] = 66;
        ahm.O0OoOO0OOOOO[231] = 103;
        ahm.O0OoOO0OOOOO[87] = -91;
        ahm.O0OoOO0OOOOO[141] = -83;
        ahm.O0OoOO0OOOOO[303] = 17;
        ahm.O0OoOO0OOOOO[323] = 77;
        ahm.O0OoOO0OOOOO[207] = 85;
        ahm.O0OoOO0OOOOO[343] = 60;
        ahm.O0OoOO0OOOOO[308] = 15;
        ahm.O0OoOO0OOOOO[149] = -104;
        ahm.O0OoOO0OOOOO[377] = -91;
        ahm.O0OoOO0OOOOO[161] = 60;
        ahm.O0OoOO0OOOOO[337] = 31;
        ahm.O0OoOO0OOOOO[70] = 46;
        ahm.O0OoOO0OOOOO[56] = 15;
        ahm.O0OoOO0OOOOO[241] = -39;
        ahm.O0OoOO0OOOOO[154] = 78;
        ahm.O0OoOO0OOOOO[145] = -96;
        ahm.O0OoOO0OOOOO[213] = -102;
        ahm.O0OoOO0OOOOO[143] = -167;
        ahm.O0OoOO0OOOOO[69] = 104;
        ahm.O0OoOO0OOOOO[9] = -42;
        ahm.O0OoOO0OOOOO[360] = 13;
        ahm.O0OoOO0OOOOO[341] = 57;
        ahm.O0OoOO0OOOOO[391] = 114;
        ahm.O0OoOO0OOOOO[344] = 27;
        ahm.O0OoOO0OOOOO[314] = 200;
        ahm.O0OoOO0OOOOO[342] = -3;
        ahm.O0OoOO0OOOOO[148] = 123;
        ahm.O0OoOO0OOOOO[162] = 73;
        ahm.O0OoOO0OOOOO[189] = -90;
        ahm.O0OoOO0OOOOO[248] = -94;
        ahm.O0OoOO0OOOOO[109] = -19;
        ahm.O0OoOO0OOOOO[345] = -27;
        ahm.O0OoOO0OOOOO[268] = 24;
        ahm.O0OoOO0OOOOO[361] = 53;
        ahm.O0OoOO0OOOOO[246] = -123;
        ahm.O0OoOO0OOOOO[330] = 35;
        ahm.O0OoOO0OOOOO[369] = -40;
        ahm.O0OoOO0OOOOO[236] = 75;
        ahm.O0OoOO0OOOOO[349] = 55;
        ahm.O0OoOO0OOOOO[370] = 136;
        ahm.O0OoOO0OOOOO[217] = -78;
        ahm.O0OoOO0OOOOO[60] = -10;
        ahm.O0OoOO0OOOOO[97] = -7;
        ahm.O0OoOO0OOOOO[200] = 92;
        ahm.O0OoOO0OOOOO[155] = -22;
        ahm.O0OoOO0OOOOO[287] = -56;
        ahm.O0OoOO0OOOOO[29] = 47;
        ahm.O0OoOO0OOOOO[294] = 35;
        ahm.O0OoOO0OOOOO[37] = -114;
        ahm.O0OoOO0OOOOO[128] = -54;
        ahm.O0OoOO0OOOOO[318] = -105;
        ahm.O0OoOO0OOOOO[101] = 95;
        ahm.O0OoOO0OOOOO[299] = 90;
        ahm.O0OoOO0OOOOO[316] = -77;
        ahm.O0OoOO0OOOOO[359] = -58;
        ahm.O0OoOO0OOOOO[269] = 19;
        ahm.O0OoOO0OOOOO[358] = -44;
        ahm.O0OoOO0OOOOO[242] = 40;
        ahm.O0OoOO0OOOOO[150] = 23;
        ahm.O0OoOO0OOOOO[10] = 114;
        ahm.O0OoOO0OOOOO[235] = 108;
        ahm.O0OoOO0OOOOO[119] = 30;
        ahm.O0OoOO0OOOOO[267] = -51;
        ahm.O0OoOO0OOOOO[48] = 49;
        ahm.O0OoOO0OOOOO[132] = -123;
        ahm.O0OoOO0OOOOO[281] = -55;
        ahm.O0OoOO0OOOOO[50] = 96;
        ahm.O0OoOO0OOOOO[64] = 73;
        ahm.O0OoOO0OOOOO[183] = -102;
        ahm.O0OoOO0OOOOO[273] = 21;
        ahm.O0OoOO0OOOOO[353] = 115;
        ahm.O0OoOO0OOOOO[374] = 38;
        ahm.O0OoOO0OOOOO[256] = 30;
        ahm.O0OoOO0OOOOO[222] = -5;
        ahm.O0OoOO0OOOOO[136] = 86;
        ahm.O0OoOO0OOOOO[221] = -35;
        ahm.O0OoOO0OOOOO[230] = 225;
        ahm.O0OoOO0OOOOO[291] = 68;
        ahm.O0OoOO0OOOOO[82] = -111;
        ahm.O0OoOO0OOOOO[156] = -51;
        ahm.O0OoOO0OOOOO[327] = 65;
        ahm.O0OoOO0OOOOO[88] = -13;
        ahm.O0OoOO0OOOOO[74] = 168;
        ahm.O0OoOO0OOOOO[254] = -70;
        ahm.O0OoOO0OOOOO[278] = 181;
        ahm.O0OoOO0OOOOO[99] = 2;
        ahm.O0OoOO0OOOOO[192] = -82;
        ahm.O0OoOO0OOOOO[158] = -87;
        ahm.O0OoOO0OOOOO[79] = -55;
        ahm.O0OoOO0OOOOO[309] = -52;
        ahm.O0OoOO0OOOOO[233] = 198;
        ahm.O0OoOO0OOOOO[270] = 105;
        ahm.O0OoOO0OOOOO[289] = -29;
        ahm.O0OoOO0OOOOO[260] = -1;
        ahm.O0OoOO0OOOOO[252] = 33;
        ahm.O0OoOO0OOOOO[114] = -18;
        ahm.O0OoOO0OOOOO[66] = -81;
        ahm.O0OoOO0OOOOO[27] = -48;
        ahm.O0OoOO0OOOOO[51] = -53;
        ahm.O0OoOO0OOOOO[210] = 32;
        ahm.O0OoOO0OOOOO[351] = 22;
        ahm.O0OoOO0OOOOO[159] = -40;
        ahm.O0OoOO0OOOOO[118] = -112;
        ahm.O0OoOO0OOOOO[22] = -41;
        ahm.O0OoOO0OOOOO[205] = -88;
        ahm.O0OoOO0OOOOO[237] = -39;
        ahm.O0OoOO0OOOOO[53] = -103;
        ahm.O0OoOO0OOOOO[301] = 38;
        ahm.O0OoOO0OOOOO[174] = 6;
        ahm.O0OoOO0OOOOO[72] = 0;
        ahm.O0OoOO0OOOOO[77] = -121;
        ahm.O0OoOO0OOOOO[4] = 37;
        ahm.O0OoOO0OOOOO[172] = -96;
        ahm.O0OoOO0OOOOO[80] = -187;
        ahm.O0OoOO0OOOOO[42] = -6;
        ahm.O0OoOO0OOOOO[346] = -58;
        ahm.O0OoOO0OOOOO[373] = -57;
        ahm.O0OoOO0OOOOO[219] = -121;
        ahm.O0OoOO0OOOOO[47] = 12;
        ahm.O0OoOO0OOOOO[36] = 146;
        ahm.O0OoOO0OOOOO[98] = 48;
        ahm.O0OoOO0OOOOO[142] = -124;
        ahm.O0OoOO0OOOOO[115] = -107;
        ahm.O0OoOO0OOOOO[363] = 10;
        ahm.O0OoOO0OOOOO[253] = -39;
        ahm.O0OoOO0OOOOO[71] = -92;
        ahm.O0OoOO0OOOOO[165] = -104;
        ahm.O0OoOO0OOOOO[46] = -102;
        ahm.O0OoOO0OOOOO[350] = 35;
        ahm.O0OoOO0OOOOO[283] = 106;
        ahm.O0OoOO0OOOOO[315] = -91;
        ahm.O0OoOO0OOOOO[135] = 85;
        ahm.O0OoOO0OOOOO[131] = -32;
        ahm.O0OoOO0OOOOO[89] = 221;
        ahm.O0OoOO0OOOOO[8] = -92;
        ahm.O0OoOO0OOOOO[276] = -72;
        ahm.O0OoOO0OOOOO[55] = -20;
        ahm.O0OoOO0OOOOO[257] = 2;
        ahm.O0OoOO0OOOOO[199] = -62;
        ahm.O0OoOO0OOOOO[14] = -54;
        ahm.O0OoOO0OOOOO[95] = 95;
        ahm.O0OoOO0OOOOO[49] = -37;
        ahm.O0OoOO0OOOOO[386] = 21;
        ahm.O0OoOO0OOOOO[296] = -9;
        ahm.O0OoOO0OOOOO[153] = -114;
        ahm.O0OoOO0OOOOO[63] = -5;
        ahm.O0OoOO0OOOOO[368] = 55;
        ahm.O0OoOO0OOOOO[334] = 75;
        ahm.O0OoOO0OOOOO[238] = -64;
        ahm.O0OoOO0OOOOO[397] = -2;
        ahm.O0OoOO0OOOOO[225] = 38;
        ahm.O0OoOO0OOOOO[201] = -116;
        ahm.O0OoOO0OOOOO[34] = -33;
        ahm.O0OoOO0OOOOO[390] = -75;
        ahm.O0OoOO0OOOOO[43] = 7;
        ahm.O0OoOO0OOOOO[382] = 34;
        ahm.O0OoOO0OOOOO[24] = 179;
        ahm.O0OoOO0OOOOO[279] = 116;
        ahm.O0OoOO0OOOOO[223] = -78;
        ahm.O0OoOO0OOOOO[307] = -80;
        ahm.O0OoOO0OOOOO[175] = -122;
        ahm.O0OoOO0OOOOO[108] = 2;
        ahm.O0OoOO0OOOOO[362] = -42;
        ahm.O0OoOO0OOOOO[196] = 79;
        ahm.O0OoOO0OOOOO[387] = 102;
        ahm.O0OoOO0OOOOO[178] = 125;
        ahm.O0OoOO0OOOOO[298] = -76;
        ahm.O0OoOO0OOOOO[126] = 10;
        ahm.O0OoOO0OOOOO[226] = 9;
        ahm.O0OoOO0OOOOO[147] = 39;
        ahm.O0OoOO0OOOOO[204] = 37;
        ahm.O0OoOO0OOOOO[18] = -98;
        ahm.O0OoOO0OOOOO[15] = -213;
        ahm.O0OoOO0OOOOO[198] = -36;
        ahm.O0OoOO0OOOOO[356] = -56;
        ahm.O0OoOO0OOOOO[35] = -66;
        ahm.O0OoOO0OOOOO[288] = 43;
        ahm.O0OoOO0OOOOO[25] = -121;
        ahm.O0OoOO0OOOOO[152] = -21;
        ahm.O0OoOO0OOOOO[277] = 11;
        ahm.O0OoOO0OOOOO[232] = 123;
        ahm.O0OoOO0OOOOO[338] = 68;
        ahm.O0OoOO0OOOOO[381] = -44;
        ahm.O0OoOO0OOOOO[354] = 106;
        ahm.O0OoOO0OOOOO[326] = 143;
        ahm.O0OoOO0OOOOO[297] = 99;
        ahm.O0OoOO0OOOOO[184] = 27;
        ahm.O0OoOO0OOOOO[383] = -3;
        ahm.O0OoOO0OOOOO[185] = -72;
        ahm.O0OoOO0OOOOO[106] = 77;
        ahm.O0OoOO0OOOOO[295] = -69;
        ahm.O0OoOO0OOOOO[366] = -111;
        ahm.O0OoOO0OOOOO[394] = 92;
        ahm.O0OoOO0OOOOO[399] = 12;
        ahm.O0OoOO0OOOOO[310] = -5;
        ahm.O0OoOO0OOOOO[144] = 71;
        ahm.O0OoOO0OOOOO[17] = -110;
        ahm.O0OoOO0OOOOO[52] = -117;
        ahm.O0OoOO0OOOOO[92] = 82;
        ahm.O0OoOO0OOOOO[86] = 86;
        ahm.O0OoOO0OOOOO[16] = 104;
        ahm.O0OoOO0OOOOO[340] = -101;
        ahm.O0OoOO0OOOOO[40] = 76;
        ahm.O0OoOO0OOOOO[117] = 27;
        ahm.O0OoOO0OOOOO[292] = 78;
        ahm.O0OoOO0OOOOO[275] = -26;
        ahm.O0OoOO0OOOOO[93] = -39;
        ahm.O0OoOO0OOOOO[26] = 59;
        ahm.O0OoOO0OOOOO[320] = 122;
        ahm.O0OoOO0OOOOO[372] = 36;
        ahm.O0OoOO0OOOOO[180] = -58;
        ahm.O0OoOO0OOOOO[100] = 50;
        ahm.O0OoOO0OOOOO[274] = -43;
        ahm.O0OoOO0OOOOO[20] = 81;
        ahm.O0OoOO0OOOOO[190] = 46;
        ahm.O0OoOO0OOOOO[146] = 163;
        ahm.O0OoOO0OOOOO[249] = -85;
        ahm.O0OoOO0OOOOO[265] = 40;
        ahm.O0OoOO0OOOOO[137] = -105;
        ahm.O0OoOO0OOOOO[376] = 120;
        ahm.O0OoOO0OOOOO[259] = -92;
        ahm.O0OoOO0OOOOO[388] = 47;
        ahm.O0OoOO0OOOOO[290] = 178;
        ahm.O0OoOO0OOOOO[84] = -70;
        ahm.O0OoOO0OOOOO[57] = -23;
        ahm.O0OoOO0OOOOO[251] = -5;
        ahm.O0OoOO0OOOOO[348] = -110;
        ahm.O0OoOO0OOOOO[258] = 90;
        ahm.O0OoOO0OOOOO[300] = 96;
        ahm.O0OoOO0OOOOO[3] = -83;
        ahm.O0OoOO0OOOOO[262] = -100;
        ahm.O0OoOO0OOOOO[389] = 96;
        ahm.O0OoOO0OOOOO[121] = 39;
        ahm.O0OoOO0OOOOO[173] = -100;
        ahm.O0OoOO0OOOOO[110] = 95;
        ahm.O0OoOO0OOOOO[130] = -89;
        ahm.O0OoOO0OOOOO[65] = -151;
        ahm.O0OoOO0OOOOO[208] = -23;
        ahm.O0OoOO0OOOOO[264] = 84;
        ahm.O0OoOO0OOOOO[347] = 85;
        ahm.O0OoOO0OOOOO[209] = -145;
        ahm.O0OoOO0OOOOO[218] = -66;
        ahm.O0OoOO0OOOOO[380] = 7;
        ahm.O0OoOO0OOOOO[123] = -34;
        ahm.O0OoOO0OOOOO[325] = 75;
        ahm.O0OoOO0OOOOO[107] = -21;
        ahm.O0OoOO0OOOOO[322] = -76;
        ahm.O0OoOO0OOOOO[166] = -8;
        ahm.O0OoOO0OOOOO[227] = 7;
        ahm.O0OoOO0OOOOO[91] = -89;
        ahm.O0OoOO0OOOOO[116] = 131;
        ahm.O0OoOO0OOOOO[280] = -64;
        ahm.O0OoOO0OOOOO[11] = 40;
        ahm.O0OoOO0OOOOO[127] = 123;
        ahm.O0OoOO0OOOOO[191] = 40;
        ahm.O0OoOO0OOOOO[379] = -50;
        ahm.O0OoOO0OOOOO[38] = -13;
        ahm.O0OoOO0OOOOO[197] = 98;
        ahm.O0OoOO0OOOOO[193] = 90;
        ahm.O0OoOO0OOOOO[157] = 10;
        ahm.O0OoOO0OOOOO[202] = -16;
        ahm.O0OoOO0OOOOO[129] = 36;
        ahm.O0OoOO0OOOOO[67] = -82;
        ahm.O0OoOO0OOOOO[212] = -75;
        ahm.O0OoOO0OOOOO[59] = -21;
        ahm.O0OoOO0OOOOO[124] = -117;
        ahm.O0OoOO0OOOOO[30] = 103;
        ahm.O0OoOO0OOOOO[120] = 37;
        ahm.O0OoOO0OOOOO[139] = 33;
        ahm.O0OoOO0OOOOO[328] = 110;
        ahm.O0OoOO0OOOOO[378] = 11;
        ahm.O0OoOO0OOOOO[203] = -115;
        ahm.O0OoOO0OOOOO[33] = -1;
        ahm.O0OoOO0OOOOO[182] = -127;
        ahm.O0OoOO0OOOOO[239] = -84;
        ahm.O0OoOO0OOOOO[13] = 52;
        ahm.O0OoOO0OOOOO[6] = -113;
        ahm.O0OoOO0OOOOO[105] = -55;
        ahm.O0OoOO0OOOOO[112] = 111;
        ahm.O0OoOO0OOOOO[103] = 46;
        ahm.O0OoOO0OOOOO[39] = 39;
        ahm.O0OoOO0OOOOO[261] = -99;
        ahm.O0OoOO0OOOOO[229] = -109;
        ahm.O0OoOO0OOOOO[62] = 68;
        ahm.O0OoOO0OOOOO[104] = -21;
        ahm.O0OoOO0OOOOO[311] = 194;
        ahm.O0OoOO0OOOOO[271] = 111;
        ahm.O0OoOO0OOOOO[245] = -135;
        ahm.O0OoOO0OOOOO[282] = 51;
        ahm.O0OoOO0OOOOO[364] = 144;
        ahm.O0OoOO0OOOOO[357] = 46;
        ahm.O0OoOO0OOOOO[85] = 42;
        ahm.O0OoOO0OOOOO[313] = 75;
        ahm.O0OoOO0OOOOO[214] = -46;
        ahm.O0OoOO0OOOOO[306] = 43;
        ahm.O0OoOO0OOOOO[1] = -33;
        ahm.O0OoOO0OOOOO[75] = -57;
        ahm.O0OoOO0OOOOO[171] = 32;
        ahm.O0OoOO0OOOOO[285] = 9;
        ahm.O0OoOO0OOOOO[168] = 98;
        ahm.O0OoOO0OOOOO[302] = 114;
        ahm.O0OoOO0OOOOO[44] = 52;
        ahm.O0OoOO0OOOOO[125] = 113;
        ahm.O0OoOO0OOOOO[54] = -115;
        ahm.O0OoOO0OOOOO[177] = 2;
        ahm.O0OoOO0OOOOO[220] = 56;
        ahm.O0OoOO0OOOOO[169] = 72;
        ahm.O0OoOO0OOOOO[339] = -34;
        ahm.O0OoOO0OOOOO[94] = 43;
        ahm.O0OoOO0OOOOO[23] = 28;
        ahm.O0OoOO0OOOOO[331] = 118;
        ahm.O0OoOO0OOOOO[2] = -25;
        ahm.O0OoOO0OOOOO[234] = 123;
        ahm.O0OoOO0OOOOO[32] = 86;
        ahm.O0OoOO0OOOOO[138] = -81;
        ahm.O0OoOO0OOOOO[365] = -33;
        ahm.O0OoOO0OOOOO[228] = 119;
        ahm.O0OoOO0OOOOO[31] = -83;
        ahm.O0OoOO0OOOOO[19] = -17;
        ahm.O0OoOO0OOOOO[384] = -36;
        ahm.O0OoOO0OOOOO[179] = -2496;
        ahm.O0OoOO0OOOOO[367] = -21;
        ahm.O0OoOO0OOOOO[355] = 14;
        ahm.O0OoOO0OOOOO[396] = -46;
        ahm.O0OoOO0OOOOO[73] = -124;
        ahm.O0OoOO0OOOOO[58] = 40;
        ahm.O0OoOO0OOOOO[102] = 113;
        ahm.O0OoOO0OOOOO[96] = -102;
        ahm.O0OoOO0OOOOO[76] = 79;
        ahm.O0OoOO0OOOOO[272] = -20;
        ahm.O0OoOO0OOOOO[371] = 96;
        ahm.O0OoOO0OOOOO[12] = -45;
        ahm.O0OoOO0OOOOO[319] = 27;
        ahm.O0OoOO0OOOOO[133] = 78;
        ahm.O0OoOO0OOOOO[7] = 53;
        ahm.O0OoOO0OOOOO[41] = -3;
        ahm.O0OoOO0OOOOO[305] = -69;
        ahm.O0OoOO0OOOOO[398] = -4;
        ahm.O0OoOO0OOOOO[134] = 8;
        ahm.O0OoOO0OOOOO[336] = 117;
        ahm.O0OoOO0OOOOO[194] = 82;
        ahm.O0OoOO0OOOOO[187] = -63;
    }

    public static String cj(final String s) {
        final String lowerCase = StringUtils.trimToEmpty(s).toLowerCase(Locale.ROOT);
        if (((String)lowerCase).isEmpty()) {
            return "";
        }
        return ((String)Normalizer.normalize(lowerCase, Normalizer.Form.NFD).replaceAll("\\p{M}+", "")).replaceAll("\\s+", " ");
    }

    public static boolean nS() {
        final long n = 6569774662330232845L;
        final long n2 = 5896440137033813237L;
        final long n3 = 96340977250276011L;
        final long n4 = 7673091319941414627L;
        final long n5 = 1427631417133289638L;
        if (ahm.aEg == null || ahm.aEg.thePlayer == null || ahm.aEg.theWorld == null) {
            return false;
        }
        final long n6 = (long)(int)ahm.aEg.theWorld.getTotalWorldTime();
        final long n7 = n;
        final long n8 = n7 ^ ((n6 ^ n7) & -1L >>> 32);
        if (ahm.aPe == (int)n8) {
            return ahm.aPf;
        }
        final long n9 = 0L;
        final long n10 = n2;
        long n11 = n10 ^ ((n9 ^ n10) & -1L << 32);
        final long n12 = (long)MathHelper.floor_double(ahm.aEg.thePlayer.posX);
        final long n13 = n5;
        long n14 = n13 ^ ((n12 ^ n13) & -1L >>> 32);
        final long n15 = (long)MathHelper.floor_double(ahm.aEg.thePlayer.posZ) << 32;
        final long n16 = n3;
        final long n17 = n16 ^ ((n15 ^ n16) & -1L << 32);
        final long n18 = -8589934592L;
        final long n19 = n4;
        for (long n20 = n19 ^ ((n18 ^ n19) & -1L << 32); (int)(n20 >>> 32) <= 2; n20 += 4294967296L) {
            final long n21 = -8589934592L;
            final long n22 = n14;
            for (n14 = (n22 ^ ((n21 ^ n22) & -1L << 32)); (int)(n14 >>> 32) <= 2; n14 += 4294967296L) {
                if (i((int)n14 + (int)(n20 >>> 32), (int)(n17 >>> 32) + (int)(n14 >>> 32))) {
                    n11 += 4294967296L;
                }
            }
        }
        ahm.aPf = ((((int)(n11 >>> 32) >= 16) ? (68 - ahm.O0OoOO0OOOOO[339] - 101) : 0) != 0);
        ahm.aPe = (int)n8;
        return false;
    }

    public static String aC(final String s) {
        final long n = 3533539338652921970L;
        final String trimToEmpty = StringUtils.trimToEmpty(s);
        final long n2 = (long)trimToEmpty.indexOf(58) << 32;
        final long n3 = n;
        final long n4 = n3 ^ ((n2 ^ n3) & -1L << 32);
        return ((int)(n4 >>> 32) >= 0) ? trimToEmpty.substring(0, (int)(n4 >>> 32)) : trimToEmpty;
    }

    static {
        Oo0o00000O00();
        final long n = 7304845158243551325L;
        long n2 = 3250603806144659290L;
        long n3 = -837757541339888883L;
        long n4 = -1918666578368439142L;
        final long n5 = 3860586101013374902L;
        long n6 = 7902275193184149917L;
        final long n7 = -9019677273848784340L;
        ahm.o0Oo000O0oO = new Object[51];
        final long n8 = 0L;
        final long n9 = n7;
        long n10 = n9 ^ ((n8 ^ n9) & -1L << 32);
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
        final long n12 = 3375844294656L;
        final long n13 = n;
        final long n14 = n13 ^ ((n12 ^ n13) & -1L << 32);
        final long n15 = 0L;
        final long n16 = n5;
        long n33;
        long n34;
        for (long n17 = n16 ^ ((n15 ^ n16) & -1L >>> 32); (int)n17 < (int)(n14 >>> 32); n17 = (n34 ^ ((n33 ^ n34) & -1L >>> 32))) {
            final char[] array2 = (char[])charArray2;
            final int n18 = (int)n17;
            final long n19 = n17;
            final long n20 = n19 ^ ((n19 ^ n19 + 1) & -1L >>> 32);
            final long n21 = (long)array2[n18];
            final long n22 = n2;
            n2 = (n22 ^ ((n21 ^ n22) & -1L >>> 32));
            final char[] array3 = (char[])charArray2;
            final int n23 = (int)n20;
            final long n24 = n20;
            final long n25 = n24 ^ ((n24 ^ n24 + 1) & -1L >>> 32);
            final long n26 = (long)array3[n23] << 32;
            final long n27 = n3;
            n3 = (n27 ^ ((n26 ^ n27) & -1L << 32));
            final long n28 = (long)((int)n2 << 16 | (int)(n3 >>> 32));
            final long n29 = n4;
            n4 = (n29 ^ ((n28 ^ n29) & -1L >>> 32));
            final char[] array4 = new char[(int)n4];
            final long n30 = 0L;
            final long n31 = n6;
            for (n6 = (n31 ^ ((n30 ^ n31) & -1L << 32)); (int)(n6 >>> 32) < (int)n4; n6 += 4294967296L) {
                ((char[])array4)[(int)(n6 >>> 32)] = ((char[])charArray2)[(int)n25 + (int)(n6 >>> 32)];
            }
            final Object[] o0Oo000O0oO = ahm.o0Oo000O0oO;
            final int n32 = (int)(n10 >>> 32);
            n10 += 4294967296L;
            o0Oo000O0oO[n32] = new String(array4);
            n33 = (int)n25 + (int)n4;
            n34 = n25;
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
        final long n = 8853192015720880671L;
        if (Client.a.s().nN()) {
            return false;
        }
        if (ahm.aPg.containsKey(s)) {
            return Boolean.valueOf(ahm.aPg.get((Object)s));
        }
        final long n2 = (long)((!ahm.aEg.isIntegratedServerRunning() && StringUtils.containsIgnoreCase((CharSequence)LastConnectionComponent.ip, (CharSequence)s)) ? 1 : 0) << 32;
        final long n3 = n;
        final long n4 = n3 ^ ((n2 ^ n3) & -1L << 32);
        ahm.aPg.put(s, Boolean.valueOf((boolean)((int)(n4 >>> 32) != 0)));
        return (int)(n4 >>> 32) != 0;
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
        final long n = -5988082233906822015L;
        if (ahm.aEg == null || ahm.aEg.thePlayer == null || ahm.aEg.theWorld == null) {
            return false;
        }
        final long n2 = (long)(ahm.aEg.thePlayer.ticksExisted / 20) << 32;
        final long n3 = n;
        final long n4 = n3 ^ ((n2 ^ n3) & -1L << 32);
        final String trimToEmpty = StringUtils.trimToEmpty(LastConnectionComponent.ip);
        final long n5 = (long)LastConnectionComponent.port;
        final long n6 = n4;
        final long n7 = n6 ^ ((n5 ^ n6) & -1L >>> 32);
        if (ahm.aOX == ahm.aEg.theWorld && ahm.aOT == (int)(n7 >>> 32) && ahm.aOW == (int)n7 && StringUtils.equals((CharSequence)ahm.aOV, (CharSequence)(String)trimToEmpty)) {
            return ahm.aOU;
        }
        ahm.aOU = vo();
        ahm.aOT = (int)(n7 >>> 32);
        ahm.aOV = trimToEmpty;
        ahm.aOW = (int)n7;
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
        return ((!StringUtils.isBlank((CharSequence)(String)clientBrand) && ahm.aOO.matcher(clientBrand).matches()) ? 1 : (-30 + ahm.O0OoOO0OOOOO[256])) != 0;
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
            more[104 - ahm.O0OoOO0OOOOO[387]] = "etc";
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
            return (-108 + ahm.O0OoOO0OOOOO[207] ^ 0xFFFFFFE9) != 0x0;
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
            return (ahm.O0OoOO0OOOOO[86] ^ 0xFFFFFFA5) + 13 != 0;
        }
        return !StringUtils.containsIgnoreCase((CharSequence)LastConnectionComponent.ip, (CharSequence)"test") && !vs() && !nS() && vp() && vq() && vm();
    }

    public static boolean i(final int n, final int n2) {
        return c(n, 0, n2) == Blocks.bedrock && c(n, 1, n2) == Blocks.dirt && c(n, 2, n2) == Blocks.dirt && c(n, 3, n2) == Blocks.grass && c(n, 4, n2) == Blocks.air && c(n, 5, n2) == Blocks.air;
    }
}
