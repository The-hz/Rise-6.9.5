package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.component.impl.player.LastConnectionComponent;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.other.ServerJoinEvent;
import com.alan.clients.newevent.impl.other.ServerKickEvent;
import com.alan.clients.newevent.impl.other.TickEvent;
import com.alan.clients.newevent.impl.other.WorldChangeEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.security.SecurityFeature;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer.Form;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.server.c;
import org.apache.commons.lang3.StringUtils;

public class zq extends SecurityFeature {
    public static long awf;
    public int awu;
    public static String avX;
    public static Pattern awb;
    public static Object[] fld_0OOOoo00o0_65;
    public String awy;
    public static Pattern awe;
    @EventLink
    public Listener<WorldChangeEvent> awC;
    public static Object Oo0o00000O00;
    public static Pattern awc;
    public static String avW;
    public static long avS;
    public long awt;
    public int awv;
    public static long awg;
    public boolean avH;
    public static long awh;
    public static Pattern awj;
    public static Pattern awm;
    public Map<Integer, aai> awn = new HashMap<>();
    @EventLink
    public Listener<ServerKickEvent> awD;
    public static Pattern awa;
    public static Object[] fld_0oOOoOo0O00O_66;
    @EventLink
    public Listener<PacketReceiveEvent> awB;
    public static Pattern awl;
    public long aws;
    public Set<String> awp;
    public static Pattern[] avY;
    public Object awq;
    public static Pattern awd;
    public long awr;
    public static Object[] oO00O0OO0ooO;
    public static double avT;
    @EventLink
    public Listener<TickEvent> awA;
    public static Object[] o0Oo000O0oO = new Object[540];
    public static aag[] awi;
    public Set<Integer> awo = new HashSet<>();
    public Map<String, aah> awz;
    public static int avU;
    public static int avV;
    @EventLink
    public Listener<ServerJoinEvent> awE;
    public boolean awx;
    public static Pattern awk;
    public static Pattern[] avZ;
    public Object avG;
    public long aww;

    public void aD(String var1) {
        if (awj.matcher(var1).find()) {
            if (this.awp.add("numeric_countdown_combined")) {
                this.aE("numeric_countdown_combined");
            }
        } else if (var1.matches("^\\d+$")) {
            int parseInt2;
            try {
                parseInt2 = Integer.parseInt(var1);
            } catch (NumberFormatException numberformatexception) {
                return;
            }

            if (parseInt2 >= 1 && parseInt2 <= 5) {
                Long olong = System.currentTimeMillis();
                if (this.awu == parseInt2 + 1 && olong - this.aww <= 4000L) {
                    this.awv++;
                } else {
                    this.awv = 1;
                }

                this.awu = parseInt2;
                this.aww = olong;
                if (this.awv >= 3 && this.awp.add("numeric_countdown_sequence")) {
                    this.aE("numeric_countdown_sequence");
                }
            }
        }
    }

    public String aC(String var1) {
        String s = StringUtils.trimToEmpty(var1);
        int indexOf2 = s.indexOf(58);
        return indexOf2 >= 0 ? s.substring(0, indexOf2) : s;
    }

    public String p(String var1, String var2) throws java.io.IOException, java.net.MalformedURLException, java.net.ProtocolException {
        HttpsURLConnection httpsurlconnection = (HttpsURLConnection)new URL(var1).openConnection();
        httpsurlconnection.setRequestMethod("GET");
        httpsurlconnection.setConnectTimeout(3000);
        httpsurlconnection.setReadTimeout(3000);
        httpsurlconnection.setUseCaches(false);

        String s1;
        label95: {
            String s2;
            try {
                BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(httpsurlconnection.getInputStream()));

                label91: {
                    try {
                        StringBuilder stringbuilder = new StringBuilder();

                        String s;
                        while ((s = bufferedreader.readLine()) != null) {
                            stringbuilder.append(s);
                        }

                        JsonObject jsonobject = new JsonParser().parse(stringbuilder.toString()).getAsJsonObject();
                        if (jsonobject.has(var2) && !jsonobject.get(var2).isJsonNull()) {
                            s2 = StringUtils.trimToEmpty(jsonobject.get(var2).getAsString()).toLowerCase(Locale.ROOT);
                            break label91;
                        }

                        s1 = "";
                    } catch (Throwable throwable1) {
                        try {
                            bufferedreader.close();
                        } catch (Throwable throwable) {
                            throwable1.addSuppressed(throwable);
                        }

                        throw throwable1;
                    }

                    bufferedreader.close();
                    break label95;
                }

                bufferedreader.close();
            } catch (Throwable throwable2) {
                httpsurlconnection.disconnect();
                throw throwable2;
            }

            httpsurlconnection.disconnect();
            return s2;
        }

        httpsurlconnection.disconnect();
        return s1;
    }

    public void nT() {
        if (aEg != null && !aEg.isIntegratedServerRunning() && aEg.theWorld != null && aEg.thePlayer != null) {
            String s = StringUtils.trimToEmpty(LastConnectionComponent.ip);
            if (!this.az(s)) {
                if (this.awq != aEg.theWorld) {
                    this.av("new_world_detected");
                    this.f(aEg.theWorld);
                }
            }
        }
    }

    public void nU() {
        this.awq = null;
        this.awr = 0L;
        this.awn.clear();
        this.awo.clear();
        this.awp.clear();
        this.aws = 0L;
        this.awt = 0L;
        this.awu = -1;
        this.awv = 0;
        this.aww = 0L;
        this.awx = false;
        this.awy = "";
    }


    public boolean a(c var1, String var2) {
        if (var1 == null) {
            return true;
        } else if (var1.getType() != 0) {
            return false;
        }
        String s = this.ax(var2);
        if (s.isEmpty()) {
            return true;
        } else if (awa.matcher(s).find()) {
            return false;
        }
        return awm.matcher(s).matches() ? false : awk.matcher(s).matches() || awl.matcher(s).matches();
    }

    public static Object[] mth_0OOOoo00o0_31() {
        Object[] aobject = fld_0oOOoOo0O00O_66;
        if (fld_0oOOoOo0O00O_66 == null) {
            aobject = fld_0oOOoOo0O00O_66 = new Object[9];
        }

        return aobject;
    }

    public void nW() {
        if (!this.awx && this.awq != null && this.awq != this.avG && aEg != null && aEg.theWorld != null && aEg.thePlayer != null) {
            long j = aEg.theWorld.getTotalWorldTime();
            if (j >= this.awt) {
                this.awt = j + 5L;
                String s = ahm.b(avZ);
                if (s != null && this.awp.add("scoreboard_mode_marker")) {
                    String s1 = s;
                    this.aE("scoreboard:" + s1);
                }
            }
        }
    }

    public void aE(String var1) {
        if (!this.awx) {
            this.awx = true;
            this.awy = StringUtils.abbreviate(StringUtils.defaultString(var1), 160);
        }
    }

    public void aw(String var1) {
        if (!this.awx && this.awq != null && this.awq != this.avG) {
            if (var1 != null && this.ay(var1) && aEg != null && aEg.theWorld != null) {
                this.avG = aEg.theWorld;
                this.avH = true;
            } else {
                String s = this.ax(var1);
                if (!s.isEmpty()) {
                    Matcher matcher = awa.matcher(s);
                    if (matcher.find() && this.awp.add("global_exempt_survival_smp_minehut")) {
                        String s1 = matcher.group();
                        this.aE("chat:" + s1);
                    } else {
                        this.aD(s);
                        if (!this.awx) {
                            aag[] aaag = awi;
                            int count = aaag.length;

                            for (int i = 0; i < count; i++) {
                                aag aag = aaag[i];
                                Matcher matcher1 = aag.awG.matcher(s);
                                if (matcher1.find() && this.awp.add(aag.awF)) {
                                    String s4 = aag.awF;
                                    String s2 = matcher1.group();
                                    String s3 = s4;
                                    this.aE(s3 + ":" + s2);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean aA(String var1) {
        long k = 2208356211311774096L;
        String s = this.aB(var1);
        if (s == null) {
            return false;
        }

        long l = System.currentTimeMillis();
        aah aah = this.awz.get(var1);
        if (aah != null && aah.awJ > l) {
            return aah.awH || aah.awI;
        }

        aah aahx = new aah();
        aahx.awH = true;
        aahx.awI = false;
        aahx.awJ = l + 300000L;
        this.awz.put(var1, aahx);
        long i1 = k ^ ((awc.matcher(var1).matches() ? 1L : 0L) << 32 ^ k) & -1L << 32;
        String s4;
        if ((int)(i1 >>> 32) != 0) {
            String s1 = s;
            s4 = "https://redacted.invalid/lookup-route/" + s1;
        } else {
            String s3 = s;
            s4 = "https://api.liquidbounce.net/api/v2/proxy/lookup-route/" + s3;
        }

        String s2 = s4;
        Thread thread = new Thread(() -> {
            int j2_hi = 0;
            long l1 = 30000L;

            try {
                String s5 = this.p(s2, (int)(i1 >>> 32) != 0 ? "target" : "domain");
                j2_hi = (String)s5 != null && awe.matcher(s5).find() ? 1 : 0;
                l1 = 300000L;
            } catch (Exception exception) {
            }

            aah aahxx = new aah();
            aahxx.awH = false;
            aahxx.awI = (j2_hi) != 0;
            aahxx.awJ = System.currentTimeMillis() + l1;
            this.awz.put(var1, aahxx);
        }, "WorldActivityProxyLookup");
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    public zq() {
        this.awp = new HashSet<>();
        this.awu = -1;
        this.awy = "";
        this.awz = new ConcurrentHashMap<>();
        this.awA = var1 -> {
            this.nT();
            this.nW();
            this.nV();
        };
        this.awB = var1 -> {
            if (var1.dq() instanceof c) {
                c c = (c)var1.dq();
                String s = c.getChatComponent() != null ? c.getChatComponent().getUnformattedText() : "";
                int flag = !this.a(c, s) ? 1 : 0;
                String s1 = this.ax(s);
                if (flag != 0
                    && s != null
                    && (s1.contains("you were spawned in limbo.") || s1.contains("you are afk, move around to return from afk."))
                    && aEg != null
                    && aEg.theWorld != null) {
                    this.avG = aEg.theWorld;
                    this.avH = true;
                    return;
                }

                if (s != null && this.ay(s) && aEg != null && aEg.theWorld != null) {
                    this.avG = aEg.theWorld;
                    this.avH = true;
                    return;
                }

                if (flag != 0) {
                    this.aw(s);
                }
            }
        };
        this.awC = var1 -> {
            this.av("world_change");
            if (this.avH) {
                this.avG = aEg != null ? aEg.theWorld : null;
                this.avH = false;
            } else {
                this.avG = null;
            }
        };
        this.awD = var1 -> this.av("server_kick");
        this.awE = var1 -> this.av("server_join");
    }

    public String aB(String var1) {
        Matcher matcher = awc.matcher(var1);
        if (matcher.matches()) {
            return matcher.group(1);
        }

        Matcher matcher1 = awd.matcher(var1);
        return matcher1.matches() ? matcher1.group(1) : null;
    }

    public void av(String var1) {
        if (this.awq != null) {
            if (this.awq != this.avG && !this.avH) {
                long l = System.currentTimeMillis() - this.awr;
                int size2 = this.awo.size();
                int empty = !this.awp.isEmpty() ? 1 : 0;
                if (l >= 30000L && size2 < 5 && !this.awx && empty == 0) {
                    Client.a.s().at(this.getReason());
                }

                this.nU();
            } else {
                this.nU();
            }
        }
    }

    public String ax(String var1) {
        String s = StringUtils.trimToEmpty(var1).toLowerCase(Locale.ROOT);
        return s.isEmpty()
            ? ""
            : Normalizer.normalize(s, Form.NFD).replaceAll("\\p{M}+", "").replaceAll("\\s+", " ");
    }

    public boolean ay(String var1) {
        String s = this.ax(var1);
        if (s.isEmpty()) {
            return false;
        }

        Pattern[] apattern = avY;
        int count = apattern.length;

        for (int i = 0; i < count; i++) {
            if (apattern[i].matcher(s).find()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String getReason() {
        return "lowactivityworld";
    }

    public void f(Object var1) {
        this.awq = var1;
        this.awr = System.currentTimeMillis();
        this.awn.clear();
        this.awo.clear();
        this.awp.clear();
        this.aws = 0L;
        this.awt = 0L;
        this.awu = -1;
        this.awv = 0;
        this.aww = 0L;
        this.awx = false;
        this.awy = "";
    }

    public void nV() {
        if (!this.awx && this.awq != null && this.awq != this.avG && aEg != null && aEg.theWorld != null && aEg.thePlayer != null) {
            if (this.awo.size() < 5) {
                long j1 = aEg.theWorld.getTotalWorldTime();
                if (j1 >= this.aws) {
                    this.aws = j1 + 5L;
                    Iterator iterator = aEg.theWorld.playerEntities.iterator();

                    while (iterator.hasNext()) {
                        EntityPlayer entityplayer = (EntityPlayer)iterator.next();
                        if (entityplayer != null && entityplayer != aEg.thePlayer) {
                            int entityId = entityplayer.getEntityId();
                            aai aai = this.awn.computeIfAbsent(entityId, var1 -> new aai(entityplayer.posX, entityplayer.posY, entityplayer.posZ));
                            double d3 = entityplayer.posX - aai.at;
                            double d4 = entityplayer.posY - aai.au;
                            double d5 = entityplayer.posZ - aai.av;
                            aai.awK = aai.awK + Math.sqrt(d3 * d3 + d4 * d4 + d5 * d5);
                            aai.at = entityplayer.posX;
                            aai.au = entityplayer.posY;
                            aai.av = entityplayer.posZ;
                            if (aai.awK > 10.0 && this.awo.add(entityId) && this.awo.size() >= 5) {
                                int size2 = this.awo.size();
                                this.aE("moving_players:" + size2);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    static {
        int k1_hi = 0;
        Object[] aobject = new Object[]{fld_0OOOoo00o0_65, 0, null};
        Object object = mth_0OOOoo00o0_31()[0];
        if (object == null) {
            char[] achar = "ᾢᾥᾫᾢᾢᾭṛῒᾧῒᾢιᾣᾪᾦῖᾄṘᾤᾆᾋṅᾊᾴᾉΆᾀᾯṄ\u1fb5ᾁᾫᾛῒᾎṃṀᾅᾊᾥᾈṘᾉ\u1fb5ᾇῗι\u1fd4Άᾴ\u1fb5ᾭᾌᾆṀῑᾣᾭᾣᾮṄṁᾏᾬ\u1fb5ᾪṁṘᾯṇΐᾨ\u1fb5ᾋῖᾅᾪᾭ῞ṄṁṃᾆᾫῖᾠṉᾏᾍᾇᾴᾬᾊᾄṄᾭᾅᾅṀᾳṘΐᾘṁᾬᾮᾘᾘᾀᾢ\u1fd4ṀᾄᾍᾊᾍṛṘᾆᾩᾁṀᾲᾱᾧᾶṄᾇᾄṇᾣᾊᾳιιᾋᾩῗᾮṉῒῖṛᾮᾠṛᾘι῞\u1fd5ṀṘᾣᾇᾆᾌᾈᾠᾫᾶṄᾦ\u1fd4ῑᾈᾤṍᾎᾧṁ\u1fd5ᾪᾧῑᾧᾩ\u1fd4ᾊṘᾸṎᾍᾲᾢ\u1fb5ᾸᾇᾘᾀᾄṅᾬṛιῒῖᾷṍᾦᾭᾲᾋᾎᾣṃṉᾥᾩṄṍιᾣᾇΐṘᾸῒιᾷᾦᾥṁṍᾇᾶᾫᾠῑᾘᾇᾤᾛΐᾱṃ\u1fd4ᾭṍᾛᾛᾧṅ\u1fd5ᾭᾨṉᾡᾋᾳᾮᾂ\u1fd4ῖᾍῖᾀᾛᾠᾇᾀῒᾭᾆᾬᾫᾡᾣᾠᾏṛṎῒ\u1fb5ᾩᾡᾬᾣᾣᾴῗṘ\u1fd4ᾋᾶᾩᾏᾱṄᾮᾇṎᾶ\u1fb5ᾷᾊᾩ\u1fd5ᾡᾁᾬᾧṇṘΆ\u1fd4ᾨιᾨṀᾷṉᾩᾨṎῑṅᾈᾭᾘᾘᾧᾃᾥᾘṎṎᾨῗṂᾘᾉᾏṃṎᾸᾳ\u1fb5ᾌᾥᾸᾈ\u1fd4ᾛṘᾠᾩᾸᾘṁᾊᾪᾧᾸṉᾫᾶΐᾳᾨṅῗᾌᾌᾢᾉᾘᾘᾲᾂᾢṁṘᾅᾠᾦṇῑᾆᾫ῞Ṅ῞ṇṅᾍṍᾴᾤᾄᾊᾈ\u1fd4ᾉᾣṂᾧᾫῑṄᾮᾬᾣᾸᾊᾪῖᾪṎΆᾪᾲṉᾲ\u1fb5\u1fd4ᾍ\u1fd4ᾴᾋᾏᾌṇᾉι\u1fb5ᾯᾊᾄῒᾃṘΐᾃṁᾱᾭṍᾁ\u1fd5ᾃṉᾈᾪ\u1fd4ιᾴṂᾡ\u1fd4ΐᾣᾇᾄᾢᾢ῞῞ᾦᾁṛᾧ\u1fb5ṁᾷᾌᾧᾥ\u1fd4ᾅᾸῑ῞ᾉᾆᾫᾆṃᾷ\u1fd4ṅιᾉṅṄṃ῞ᾇᾯῒιᾣᾲᾡᾭṂᾡṀᾮᾃᾅᾪᾛṛΐṃᾃᾃ\u1fd4ᾃᾱιᾤᾨᾮᾡᾢṎᾧᾳṎṘ῞ᾯᾈῗῖᾇᾁᾂιᾎᾅᾪᾫᾏᾲṇᾉᾁ῞ṀᾫᾷᾊῖṛᾆᾷᾩṄᾯṅṃᾢᾱᾨᾛᾌΆᾆ῞\u1fd5ᾉᾘṍᾡᾴᾦᾦṄᾨ\u1fd4ᾣᾦᾇᾪᾀᾘṉᾊᾤῖῖᾥṂῖṁᾛṎ\u1fd5ᾁᾪ\u1fd4ᾌṁᾅῑṅṇᾦᾉῗᾫῑιᾂᾸᾨᾆᾇṂṛṀᾳᾭῒᾨᾶῗᾄᾂṀῗᾇᾨᾈṛᾠᾧ\u1fb5ṃᾯᾱṁᾯᾩι\u1fd4ṇᾛᾥṘ῞ᾅᾌ\u1fb5ᾁᾃᾸᾈᾧῑṅᾀᾉᾏᾎᾂᾥ\u1fb5ᾃιᾸᾠᾮᾛᾳṎ\u1fd4ᾦᾢᾯᾈᾇᾱᾸᾦᾇᾉᾭιᾇᾉᾂᾲῗᾪᾷṍᾁᾧῑᾥᾫῗᾆᾢᾉṇᾍᾬᾆṃṛᾀᾨᾇᾥᾧᾷᾘᾤṃṘᾲᾤᾡᾩᾭṅᾛᾘṂᾌṁᾧᾅṀᾩṅṅᾦᾄᾉᾳṘᾁᾀΆᾄ\u1fb5ᾍṉᾥṅᾧιᾣᾃ῞ᾇᾶᾡṎṃᾄᾬᾪῗ῞ᾲ\u1fd5ᾣ῞ṀΆ῞ᾀṄᾌᾶṃ\u1fd5ᾈᾇᾯῗᾧᾩᾇῗ\u1fd4ᾡṂᾠᾋᾢᾫᾢṎῑᾋᾇ\u1fd4ᾣṁᾶᾨᾲᾧᾊṂᾋῒᾮ\u1fd4ᾀᾎᾄᾁᾲᾆΐṂῖῒṇᾯᾯᾠṍᾎιᾛᾣᾧᾳᾎᾳ\u1fb5ᾍṍῑᾥᾣᾥᾆᾀ῞ᾪῗῒᾋṀ\u1fd4ᾎṘᾳᾪᾣᾌṅᾘṁᾄᾤṃᾸᾨᾴᾂṂᾅᾨᾲᾲṛᾍᾤᾯᾶῑṅᾲΐΐᾧᾠṄᾀᾨᾧᾈῑᾣṅᾨṃṎᾇᾘᾌṎᾋᾳṃṛᾆᾀᾡᾲᾩᾷῗṄᾣᾡΆᾩᾮᾁṘᾤᾨᾦ\u1fb5ᾄᾏᾎᾂṄṀᾪᾳᾱᾎᾢιṛᾯᾭᾄᾁῒᾤᾌᾃᾴᾳ\u1fb5\u1fd4ṍᾫᾨᾳᾬṉṅᾄᾳᾱṄᾅᾈᾧᾬᾪῖ\u1fb5ᾏῑ\u1fd4ṛᾧᾀṘṎᾫῑṎṉΆᾋᾇᾅᾌ\u1fb5ᾱᾎᾱᾢᾠᾢᾷᾍᾸᾈᾄṂᾂᾎᾂᾲṄṘṘᾥᾴᾷᾠᾤᾉᾴᾆᾭᾊᾭᾭᾥᾌṅᾯᾥṛᾉṛῒᾨᾌᾯᾎᾯᾏᾏᾌᾦᾩᾨᾛᾆᾀᾣᾨṎᾋᾤᾩᾢᾍᾤᾢṍ\u1fd5ῗᾌᾘῑᾥᾌṘᾋᾲᾠṇᾡᾳᾨᾫᾦṃᾫᾄṉᾏ\u1fb5ᾲṘᾋᾪᾮῒᾮᾈᾅṉṁᾩᾲṉᾇᾠ\u1fd5ṂᾢᾘᾩṀᾸṘ\u1fd4Ᾰṁṇ\u1fb5ΐᾤᾛᾘṛᾌᾃᾣᾪᾷᾫιᾘṅᾨᾤṀᾅῑᾨᾥᾄᾳᾂΐᾄᾢṃᾲᾀᾣᾧᾫΆᾮᾨᾦᾠᾈṃᾇᾤῒᾄᾶᾧᾃῗᾋᾊᾸᾬᾤṇᾴᾲᾢᾍᾷ\u1fb5ṀṉṘᾍᾨᾍ\u1fb5ᾧṇᾊ\u1fd4ᾊῗᾲᾳᾘᾮᾄᾫṎᾂῑṎᾬṍᾄᾘᾎῑᾦᾷṉṛᾴṅᾱṄῑᾁᾲᾛᾎ῞ῑῗῖᾇᾣᾀᾎᾩ῞ᾲ\u1fb5ᾣΆᾠΐῖṍ\u1fb5ṇᾳṘ῞ᾆṅṅṇᾘ\u1fd5Ṙᾂᾨᾂᾄᾁ\u1fd5ᾎṍᾣᾈṂṅṀᾲᾱᾸᾬᾆᾁᾅṛ\u1fb5Άᾄῖᾇᾀᾤ῞ᾱᾤ῞ΐṛᾫṍᾤᾯṂᾭᾅ\u1fb5\u1fb5ᾛ\u1fd5ᾥ\u1fb5ṇṃᾬᾭ\u1fb5ṛᾫṀᾦ\u1fd4ᾛᾯᾶᾧιᾊᾛṀᾏᾷᾮṎᾆ\u1fb5ᾠᾯᾅῖ\u1fd5ṘΆῑᾣṃᾌṉᾉᾩᾡᾋιᾁṄᾅᾤΐΐṃᾀᾇᾸᾎṁᾀṃṘṄṎᾭᾴᾌῗῒṀṎᾊᾉṁṃ῞ᾶι\u1fb5ᾢᾧᾩṛᾂᾋṘᾢᾅṛṘᾮᾂᾍṃ῞ᾧῑᾳΐᾇṇᾡΆᾥᾄᾨṍ῞ṘṀṃṇṀᾀᾯᾅᾃᾬᾅᾧᾄ῞ṉᾳᾷᾠṁᾊᾘ\u1fb5ᾶṉᾷṅ῞ᾲᾛᾸ\u1fd4ᾳᾠᾳᾭΆᾷᾇᾂᾃᾅᾷᾳᾤᾬ῞\u1fd4ΆṃᾎᾭΆᾛᾶᾬṉᾫᾘ\u1fd5ῒᾫᾴᾶṅῗᾶῑᾄᾭῑᾸᾏῑᾫṍᾏ῞ᾂΆᾂṎᾸᾥ\u1fd5ᾬṇᾭṛᾫṇιᾭᾥᾦᾫᾧᾠῗᾤᾄṅᾌιṁΆᾎᾍᾩᾳᾋᾊṍᾅᾧṘΆᾫᾥᾢᾫᾭᾱᾬᾁṂ\u1fd5ᾛᾉṃΐΆᾣᾤᾱᾷᾍᾇᾄᾘᾠᾡṁᾶᾃᾎᾶᾂᾋṅᾃᾯᾋῖᾏῗ῞ᾍᾛ\u1fd4ᾨῖᾯṁᾲᾇᾋᾩ\u1fb5ᾏᾋᾀΆΐᾬᾂᾏᾆᾧᾫṃṛ\u1fb5ῒṂᾎᾦṇ\u1fb5ᾅᾳᾋᾬᾬᾭᾴᾭᾎᾮᾉṇᾪ῞ᾥṅᾨṄιᾷᾋᾀṇṛᾋΐῖṍṛ\u1fb5῞ṇᾫᾶᾉṅ\u1fd5ᾧ\u1fd4Ṏᾮṇṅᾧΐᾭᾉᾭᾮᾁᾤᾪṛᾌᾎᾎᾲ\u1fd4ᾘṍᾳᾘᾫᾶᾫᾭṉᾈᾱ\u1fd4ṘῒᾎᾏᾩᾯᾤᾆᾯᾇᾆṄᾸᾂῖᾌᾸῗṎΐᾛᾁᾮᾶᾍᾣᾩṁᾧ῞ᾍṅṅᾈ\u1fd4ΐṛᾏᾘᾅṇᾩᾮṎῒᾦᾲᾯṍᾭᾁᾋᾤᾭᾳΐᾘṃῖᾢṎᾁṅṇᾬᾅᾦṄᾈṃṁᾃṇᾁῑᾂ῞ᾉṁΐιᾆᾬᾆṇΐ\u1fd5ΐᾎᾣᾇṎᾢᾶṎᾮᾇṘṄṃᾘᾷᾠᾮ\u1fd4ᾏᾴṉῖᾏᾳᾊ\u1fd5\u1fd5ῗṇᾠᾷᾅᾱṘᾅṀᾃᾘᾅῑ\u1fb5ᾡ῞ῗᾊᾅᾘṉᾠᾄṉῖᾨᾬ\u1fd5\u1fb5ṍᾃṄᾶṎṇῖᾫᾩ\u1fd5ᾊᾱṘᾲᾧṘᾶᾈᾁᾨṄṁᾌιᾉᾆᾌᾭᾘΐᾤᾇᾎṎᾦ\u1fd4ᾅᾸ\u1fd4ṀᾅṂṂᾩṇᾌᾪṄῗῗᾫῑṉ\u1fd5ᾠᾋᾎᾠᾌᾬᾊᾫᾨῒᾦᾌᾋṁṃῑṉᾊᾁ\u1fd5ᾱΐᾧᾲᾧṀᾲᾅᾲΐṃᾳᾭῖṍᾯᾈ\u1fb5ῒᾫᾌṉᾢᾷᾌṎᾸᾡᾘᾬᾩᾈᾮᾮṄᾢ\u1fd5Ṙ\u1fd5Ṁ῞ᾴ῞ᾆᾇṀ\u1fb5ᾊᾭᾮᾇṉṀᾬᾸᾍᾇᾁᾫᾀᾷṄṁῑᾛᾸᾶṅᾌᾥᾩṍᾋᾃᾤιᾇᾈᾷṛᾇᾤᾘᾋιᾸᾶṂṀᾋᾘṅᾱᾤᾸᾄᾉ\u1fd5ᾉᾸᾈṛᾯṎᾶṍ\u1fd5ᾶΆᾘᾈ῞ᾮ῞ᾇᾴᾱᾋΆᾍᾫṂṃᾤᾋῗᾋᾱṅṃᾏᾈṄ\u1fb5ᾄᾤᾮᾘᾢᾅṛᾢᾶΐṂᾉᾘᾫ῞ṃᾳᾤᾡᾮᾳṀᾉṁṄᾁᾯᾲṀṉṄᾥᾍṄᾱ\u1fb5ᾯᾥᾣ\u1fd4Ά\u1fd4ῑᾲᾴᾫṅṄᾸᾌᾉᾨᾌΐᾢᾈῖᾅᾷᾋṇι\u1fd4ṁᾳᾮṛ\u1fb5\u1fd4ᾂᾘᾤᾤῒᾏᾢᾈᾂᾩᾦᾡᾲṎᾀῗᾪ\u1fd4ᾌᾠᾣᾤᾍṀᾲᾸᾋΐᾆᾮᾌᾳṘᾂṂᾴ῞ᾥᾯṂᾨῑᾠᾮᾣᾳᾧᾂᾇᾷᾪᾂ\u1fd5ᾉᾂᾬᾏ\u1fd4῞ᾣᾴᾆṇᾡṘṅᾆῖᾤῒᾉṘṄᾡᾤᾴᾶᾈᾧᾛ\u1fb5\u1fb5ᾆῖᾛΆᾭῑᾎ῞ᾸᾁᾏᾁᾬᾅῖᾧṍṎᾊᾃ\u1fd4ᾏ\u1fb5ṛιᾀᾃῑᾠᾯῗᾢΆᾷᾦᾧᾇ\u1fd5ᾮᾨῗᾆᾛᾏᾸᾇᾄᾶᾧᾎṁᾆΐᾭṍṅᾄΐᾡᾍṎᾧ\u1fd4ṍ\u1fd5ᾨᾇᾪῒᾸṎᾏῒᾩᾧᾳᾬṃṇ῞\u1fb5ᾳᾱṘᾨᾢᾳῑṉᾴᾅᾲṉῖᾨᾫᾯᾤṘᾉᾱṉᾢᾧᾅᾷᾩᾌᾣṂᾮṘ\u1fd5ᾮᾥṂᾆᾡᾨᾤᾁιᾅᾃᾛᾶᾧΆᾮᾬᾎᾆṃᾲṉ῞ṛ῞ᾎΐᾡ\u1fb5\u1fd4ᾂᾂᾷᾋᾁṅᾅᾠṃᾎᾬᾅᾉᾸᾍᾍᾍᾏᾱᾧᾧᾌᾫῗᾳΆᾠᾍᾶᾃᾶᾶᾀṘᾡᾆᾴᾶᾠᾄᾸᾫᾸᾊṅᾫῑᾥᾪṍṀ\u1fd4ᾨᾶιᾂṍᾢᾱ\u1fd4ṉᾎᾶᾁᾩᾇᾮᾈῒṄᾆᾁᾅᾊᾯᾊᾬᾫᾠᾣᾉῗᾧᾆᾥᾤṁṄᾧṄῖᾭῒᾬᾈᾲιṄᾳᾶᾶΐᾨᾱᾫᾲṀᾃ῞ᾫ\u1fd4ᾀᾇᾩᾦᾉᾛᾎῒᾥᾯᾃ\u1fd5ῗΆᾩṄṍᾱᾂᾄᾶṄᾌ\u1fd4Ṅ\u1fd4ṅᾅῖ\u1fd4ᾈᾴ῞ṅᾷṂᾳᾡṛῗᾋᾉṃᾭ῞ᾡṍῖᾄᾡᾬᾏṎᾋᾸιᾬιᾶᾮᾧṃᾘ\u1fd5ᾉᾢ\u1fd5ᾆᾸᾮṛᾸṄῖᾪᾎᾡᾬΐιῒᾆᾴΆᾨᾢΐṍᾪṄᾇᾸΆṁṀΐ῞\u1fd5ᾫᾷᾬṛᾍᾏᾩṘῑᾆᾸṍᾳᾃᾛṘᾀᾏṛᾮᾅ῞ᾋ\u1fd5ᾉṅᾢᾶṛṁᾱᾧΐΐᾈᾡᾇΆ῞ᾆṘṉṛṇṄᾄṉᾍᾧṍᾇᾦᾸῖᾭᾸᾇᾢᾧᾤᾨᾊᾡᾣᾳṄᾨᾮṉ\u1fd4\u1fd5ᾯᾩᾛṅᾲᾎᾫᾲᾂᾥṉ\u1fd5\u1fd5ᾅᾳṀᾨᾀ\u1fd4ṄᾎᾧṁᾡᾶᾋᾍṀᾏᾂᾃᾀ῞ᾌᾃᾭṂ\u1fd4\u1fd4ιᾠ\u1fb5ᾍᾠῗṂᾧᾋᾇιṅᾃᾪιᾁᾍᾉṍᾣṀṛᾥṇᾃΐṇṘᾏ\u1fb5ᾬṃᾆᾈṂᾯṄṃᾴᾂ῞ṇ\u1fb5ᾫᾲᾄṉᾭᾳῗᾥᾮᾅᾧ\u1fb5ᾷᾨᾪṛᾦᾋᾏᾮῒᾊᾇᾦᾣᾉṃᾴṁṄᾨᾴᾊṛᾌᾣᾠ῞ᾏṍᾋᾧῑᾧῗṍᾯᾀᾛῗᾴᾭᾷᾈᾣιᾣṄᾨΐᾌᾆ῞\u1fb5ṇᾩᾷᾅᾎᾠᾅṀῗṂṄᾠΐṍῗᾲΆᾬᾍṘᾶᾀῒᾸιᾊῑᾇᾛᾩᾏᾥΐᾊᾉᾭᾤᾣᾁᾎᾦῒṛᾂᾥᾅᾅᾤᾳᾀᾎῒ\u1fd4ᾫᾄᾌᾀṉᾣᾂᾣᾪᾌᾮᾱᾎṁᾛ\u1fd5ᾴιṉᾘᾏᾍᾇᾴṎᾇᾧᾮ῞ᾅᾬᾈ῞ᾍᾏᾯ\u1fd5ṉᾯᾏᾃᾬᾩṘᾏᾦᾤᾛṃᾤᾸᾪṛᾫᾍṄᾪᾴṁṎᾱᾁṄᾴᾘᾶᾇᾋᾯᾪᾎᾨᾬᾧᾇ\u1fd5ᾡᾍᾩᾈᾸ\u1fd4ᾉῑᾶᾴᾅᾪṇṉᾳṅṄᾍῗᾂᾩṘᾮΆῖṍᾦᾫᾎῒΐᾘᾊᾲᾏᾂᾋᾶᾭṍῒṇᾧṎῑᾆΆῑιᾀᾱιṉᾭṘṀᾴṄΆᾪᾉᾘ\u1fd5ᾦᾃᾡΆῑᾡᾢᾊᾀᾇΐ῞ᾠᾘṉṅᾫᾫῖṅᾪιᾮῗ῞ᾴΆ῞ᾁᾬ\u1fd4ᾛṀṂᾌṂᾎᾆᾄᾤṁᾥᾉᾧῒῗᾈṘᾴᾲᾬᾂᾛᾴιᾌᾅᾁᾢᾛᾱ\u1fd5ᾀᾎṛᾦᾬᾛᾩᾯᾬṛᾇ῞ᾭᾸᾇᾭῗᾨᾁᾧῖᾪᾇᾇṍᾅᾮᾄᾉᾯᾈᾋᾤᾎ\u1fb5ᾣᾮᾈṅṎᾂ῞ᾭᾎᾣᾣṄᾀᾦᾢ῞Ṅᾏᾤ\u1fb5ᾃῗᾇᾀᾪᾠᾁᾄᾀᾋᾶᾪᾥᾮᾭῑᾡᾌΆᾂᾄᾢ῞ῒᾘῖᾂῗᾨᾯῗ῞ᾷᾂᾧᾤṁᾭṛṅῗᾭ\u1fd5ᾁᾩᾨᾊᾴṘṂ῞ᾮᾷ\u1fd5\u1fb5ᾮṛṛᾪᾫᾘῒᾴṍᾤṄῖᾛᾊᾪᾶᾇṅ῞῞ᾪΆᾢ῞ᾈᾘ\u1fb5ᾏΆᾪᾧᾊṁṇᾳῒᾬᾫ\u1fd4ᾋᾌᾣᾶᾣᾉṇᾲᾃᾏ\u1fd5ᾛᾪᾷᾃṛῖᾯṁᾳ\u1fb5ṉΆᾷᾍΐᾀᾌῒṘᾊᾀᾡᾄᾭᾡᾘṉᾅῖṁᾅᾏᾈṘῖᾀᾇΐṅ῞ṇṂᾏᾮᾂᾢṇ\u1fb5ᾂᾣᾱᾢᾳᾱᾇᾷᾇᾢ῞\u1fd5ᾈῒᾇ῞ṂΐᾮᾎᾯᾋᾮᾸṁᾭ\u1fb5ṉᾢᾤᾃΐ\u1fd4ᾤᾛᾎᾈᾷΆ\u1fd5ᾪᾤᾛιᾆᾏᾈᾬᾌᾣṎᾩῗᾣṛṘṘᾏᾀ῞ΐṎᾌ\u1fb5ᾡᾈᾬῖᾬᾌṂῒᾱᾁᾶᾯᾤᾀᾸᾷᾘṍᾥᾛṛᾩᾡᾲṘᾪῗᾅṍṃṘᾛᾠ῞ᾬᾸṃῒᾳᾁᾏᾷṇῒᾸᾄᾴᾀᾤιᾳṘᾃᾣṃṁᾳᾇᾤᾘᾦΆṇᾸṍᾤᾃᾶᾤṘṉṇᾉΆῑῗᾊṃᾴΆᾎᾸᾀᾛṁΆ\u1fd4ᾬṇᾯᾃᾠᾧᾠᾯᾡᾴṄᾣṂṎᾮᾩᾱᾧᾸᾲᾶṃᾆᾮᾘᾂᾍᾪᾢᾈṂᾪṀᾪᾀᾈᾲᾈᾛᾲᾶṛ\u1fb5ᾇ῞ῒΐᾪᾬṄᾯṃṀᾳᾘᾀᾧᾋṉ\u1fd5῞ᾊᾬᾠᾫΆᾨιᾨ\u1fd4\u1fb5ṉᾸᾍᾋᾳṃᾭᾭᾍᾭᾬᾄᾡ῞ᾯῒᾆᾆᾆṘᾨ\u1fd5ᾠᾮΆΆᾮᾴ\u1fb5ṃᾥᾄᾯᾆᾤᾬṎṁᾂᾴᾴῗᾉṀΐṅᾘṂᾁᾪ\u1fd5ᾴᾁᾢᾪᾛᾤᾪᾤᾢᾘῑᾬᾋιᾪᾢṀṘΆ\u1fd5ᾇᾃᾘᾌᾘᾘᾭᾥᾦΐṇᾥῒᾡᾫᾡῒṘᾋṍᾱ\u1fb5ῑṁᾡṘṅᾏᾈṍᾸ\u1fb5ᾁᾤᾫṇᾮᾨᾉᾄᾦᾄᾩṄᾋᾸᾩᾯᾀ\u1fd5ᾫᾋιᾩ\u1fd4ῑᾣΆᾊṍᾬᾣᾍῖᾯᾢ\u1fd5ṃṅᾢṅᾣᾌΐᾥṅᾁΆᾅᾬᾆᾈᾛᾸᾉᾀᾉᾁᾌᾱᾘῑṁṂᾉᾅᾎᾂᾫᾳᾸᾎᾍᾳᾣṍṘᾮᾄᾊᾮṁᾛᾤᾈᾆῗᾧᾨᾊ\u1fd5ᾭᾀᾉᾳṛᾥᾦṉṉᾢ\u1fd4ᾮᾷᾠᾋᾅΐṘṃᾧᾩᾦṁᾃᾫᾥṉᾌᾱῒᾡᾣιᾉᾨ\u1fd4ᾫᾧṀṅ\u1fd5ᾨῖΐᾡᾊᾏᾶᾉṃᾘᾍᾣᾂṛᾇṃᾥᾏṂᾀᾯῒᾴṎṍᾧᾎῒṅᾧ\u1fd4ᾸṛῒᾘΆᾅᾆᾤᾋᾆᾘṀᾊṂᾊᾶᾊῒᾇᾯᾩᾭᾸᾊ῞ῖᾎ\u1fd5ᾍᾤᾋᾎᾛΆᾊ῞ᾢᾊᾪᾶᾶṂᾉṇᾪᾭᾎṍῒᾈᾆᾃᾨṛṃᾲṄᾯ\u1fd5Ṏῖιᾲᾤṉᾈṇῗᾎᾷᾢᾉ\u1fd4ṍᾃᾳṇṛᾛᾴṃᾀṇᾠṎṃᾈᾈᾠᾣᾭᾛᾀῑᾃṁᾯᾦᾡṇᾢṃᾅᾣᾂᾣᾛᾯῖᾳᾪṄᾴᾢᾄῒΆᾂῖ῞ΐ\u1fd5ᾷῑᾬṁṀᾇιṃᾌῑᾢᾏᾢᾪᾣᾦῒṇṇᾤᾭᾬΆᾉᾌᾅṍᾠᾋᾀᾢᾦ\u1fd4ᾋ\u1fb5ᾦᾮᾀᾊᾳṛᾠᾋᾧᾋᾣṂᾍᾴᾋᾣṅᾡᾣΆṛᾳṀᾮᾬῖᾉ῞ᾃṀῒᾡṄᾋ῞ᾫᾈᾱᾃιᾨṅᾛᾩῖᾃᾊῗᾎᾠᾠᾠιᾨᾘᾠῑṍᾴᾆᾠṄᾳṘῑṇṍᾊᾏᾬιῑᾤᾛṛṂᾢ῞ᾂΆῖᾌṘṉᾘᾅᾨᾸᾌᾃᾯṍῑᾊιᾮᾛṉᾯᾮᾉᾫṁᾩᾍṂᾮΆṍṃῒᾂ\u1fd4ṍᾤᾳṅᾄῗᾥᾲᾡᾈṘῑᾬῑṂᾫᾫᾶᾲῗᾊᾱᾏᾄṍᾁῒṄ\u1fd5ῑṂᾄᾂᾱᾂᾂᾶᾤᾈᾠᾢᾎᾍᾇᾣᾁᾉΐῖᾷῗᾇῗᾸᾁṁṁṍᾷΐᾷᾂᾊᾍᾈᾪᾢῖṍṄᾃᾀᾅṍṄᾱṎιṍᾋᾲῒᾭῖᾨṉṃᾤṇῗᾧṄṂΐᾁᾍṂᾶᾅᾡᾪṀᾷιṛᾨᾋᾊᾁᾍ\u1fd4ᾥṅᾅṇṅṀṃᾭṃᾄᾁᾄᾨ\u1fd5ιṀᾉṍῑᾤᾊᾶᾛᾋᾋᾌṅᾉṘṂ῞\u1fd5ΆᾥᾃῒṘᾨṎᾂᾍṍῑᾂᾋ\u1fd5ᾲᾭṎᾮṇᾤι\u1fb5ᾣᾆῑῒṂṀ\u1fd4ᾄῑᾳᾩᾮΆṄṀᾷᾴᾉṍΐṎᾱᾩᾋᾢṍṛ῞ᾈᾄᾢᾄᾘᾨᾮṀᾉ\u1fd4ṃῑῖᾦῑ\u1fd4ᾴᾠṇᾷṄᾋᾱῑᾋ\u1fb5ᾶᾁΐᾆ\u1fd4\u1fd5\u1fd5ᾢᾴᾀᾂ\u1fd5ΐᾥᾘᾁῒᾍῖᾍṇᾬṉᾈṉᾢᾢṀᾂῒᾋᾅṂᾬṀΆῖᾘᾎᾤᾅᾊᾏᾥṁᾃᾮᾄᾱᾱᾎᾴᾱṘᾇᾠᾢᾨᾠṃῗ\u1fb5ᾭᾀṄᾴṀṄῑᾀᾠᾨᾛ\u1fb5ΐᾭṃᾊᾴᾇ\u1fd4ῑῑᾳᾀṇᾊᾄᾣṀᾸᾉᾦᾸᾨṃᾨῖᾬṀᾌṉᾥᾦᾤιᾩᾯᾋΐᾴιṁᾴᾡᾬᾫᾯᾩᾌᾩᾭᾬṁṍᾊᾏᾸιᾆᾸṉᾦᾪᾡῖῑᾶᾏṘᾫᾂᾭᾘΐᾛᾫᾯᾯᾁᾛᾧᾛᾬṍᾄᾎΆᾋᾏᾷΆ῞ᾄᾎᾣᾛṅᾤᾧᾃΐᾥ῞ᾆṁᾶ\u1fd5ṁᾡᾋᾀᾢᾦᾢᾦᾪ\u1fb5ᾁᾏ\u1fd5ṇṉᾇᾮᾱᾋᾳṉṛᾋᾸ\u1fd4ṂṉᾄṀᾣṂᾭᾶᾲᾆ\u1fd4ᾩᾲᾧṍᾪṎᾄῑᾡᾳᾍᾢᾢ\u1fd4ṅṄṎᾘᾢᾢῖᾦᾭᾉῗᾮᾂᾶᾷᾃᾯṍ\u1fd4ᾱᾅṇᾧṅᾪᾅ\u1fd4ᾬᾃᾩᾘᾈ῞ṅṁṂṘᾈᾂᾂᾂ῞ṄṘᾆᾠṀᾆᾃṉᾯᾋᾯᾋṇ\u1fb5ᾉṎᾪṅᾧṄ῞ᾠᾨᾶᾭᾛᾩṎ῞ᾅΐᾂΆᾲΆᾨῒṎ\u1fd4ᾊᾢᾴṄṎṉᾛᾭᾂᾯᾁṂᾴᾶᾉᾀᾬιΆᾳᾂΆṁᾥᾃṛᾊῑᾎṇΆᾭᾊᾀ῞Ṃᾱᾎᾍᾡᾘᾴᾬ\u1fd5ᾫᾨᾋῒ῞ΐΆṁι\u1fd4ᾠᾌᾡᾊṅᾶṛ\u1fb5ᾉᾏᾩᾡ῞ᾏṎᾉᾧᾧᾌᾉṎᾂᾧᾶṉᾷᾫᾊᾊᾀᾥᾩ῞ᾮᾩῗ῞ᾘṃᾦṁῑṎᾮᾭᾶΆᾨᾴᾀᾬᾲᾮᾨᾩᾶṅṄ\u1fd4ṅᾣῑᾴᾫᾪᾂṍᾮṇᾮᾫᾮᾎṂᾯᾀᾢᾡᾲṘᾠᾭῑᾃᾛᾌᾨᾇᾛṄṂᾇ\u1fd4ᾥᾏṛ῞ΐᾩᾲΆᾢῖᾊṍᾨᾀ\u1fd4ᾦṘᾧᾏᾫᾷ\u1fd4Ṏṛ\u1fd5ῒᾆᾆᾂṅṄῗιᾢᾡῖᾤᾳΐΆᾷᾌᾮᾂṍᾅṎṄᾣιᾥᾆᾢᾆᾃᾥᾄῑᾏᾋᾊᾬᾪΐ\u1fd5ῖᾳᾬᾨᾠᾢᾋᾛṉῖᾭᾅᾊᾧᾧᾨᾅᾳᾨιṁᾴᾄṀᾪῑᾤΐᾳᾶᾭᾠᾴṘᾨᾪᾇᾛ\u1fd5ᾂᾮᾪṘᾄᾛᾇṀṉᾈᾩῗṇᾮᾨᾮᾪᾭᾋṛᾛᾸᾀᾈᾤᾣᾶṎᾃᾦᾋΐᾀ\u1fd4ᾏᾮṛᾡᾱᾠᾉṅᾋᾃᾮᾎᾷᾥᾩΆᾷᾘᾄῖιᾸᾳṘ\u1fd4ṍᾎᾅṅṛṉᾍᾠᾊᾮᾥṉᾮᾍᾍᾏṍᾌῑιᾩῗᾤᾭᾇᾥᾍᾏᾦṘᾢ\u1fb5ᾢᾡᾠᾁᾌᾳΐṛᾣᾤῖṃᾳΐᾎᾋ\u1fb5ṘᾯᾁᾊᾆᾇᾷṅᾎᾈᾁᾶῗᾯᾭᾱᾏᾥᾮῖᾶᾮᾈᾠᾇᾷᾃᾮιᾈṘᾤᾧᾣ\u1fd5ΆṀᾅᾃṀ῞ᾃᾶᾱᾅῒṄṘᾛᾉṎṁṛᾥᾘᾨᾌᾛᾱᾨᾬᾎ\u1fd5ṉṘᾘᾛ\u1fb5ᾛṁᾉᾇΆṁᾅṎΐṅῗᾶᾂ\u1fd4Ᾰᾥ\u1fb5ᾠṄᾂᾩṁᾎᾧᾉᾊᾃᾆᾲᾨᾠᾡᾈᾮῖṀᾌᾣΆᾄᾀῑᾱᾱᾅᾫᾥᾲṎᾱᾉṘᾭṉῒᾶṁῒῒᾌᾄᾀṎᾊᾸᾁᾩᾷᾃᾌᾂ῞ᾪṇṉᾧᾦᾭᾊᾎᾨṛᾸᾦᾪṀᾍᾊᾨᾴῒṃᾆ\u1fd4ᾡᾣṛᾫᾭῒᾶῒ῞ᾋᾏᾁᾠᾴᾭᾂᾠᾭιᾬᾘᾀᾋᾛṉᾁ\u1fd5ᾭᾛᾃῖᾪṁᾉᾶᾂᾭṁᾢṃᾣṉᾆῑṇᾶᾤ\u1fb5ῒᾫᾫᾢᾨᾮṂṄᾉᾪᾦᾫᾈᾎṉᾆᾘṉᾂᾷῗᾄᾛṃᾀṅᾴṉᾨᾠṘᾁᾢᾀᾠ῞ᾪ\u1fd5ᾯᾊᾮᾊᾃιᾉ\u1fd4ᾶῖᾠṉᾫΐ\u1fb5ṂᾲṂᾎΆṛᾁṄᾆṀṃṇᾭᾀṄῒᾋ\u1fd5\u1fb5Ṙᾩᾀṛ\u1fd4ᾪιᾥᾘι\u1fd5ṉᾇᾮ\u1fb5ᾨᾧᾯṃῗṀᾣᾯᾮ\u1fd5ᾀᾴᾃΐᾛṀ\u1fb5ᾳ\u1fd5ᾌᾋᾯṛᾬᾨᾸᾘῑᾇ῞ᾫṃᾈᾩᾄᾫ\u1fb5ᾷῗᾅᾁᾇᾁ῞ΐᾈᾡᾲᾅᾨᾩᾶῑṅᾦᾌᾦ\u1fb5ᾄᾛᾧṉᾱᾇᾲᾅṃᾇᾡιᾈṘᾬᾍᾋᾫᾣᾈᾦṛᾇᾋᾷᾆᾋᾦṛᾤᾈᾀᾢṛᾪΐᾁᾀṘᾍṛῑᾎᾛṉ\u1fd4ῒᾀᾧᾡᾛᾠᾡᾬᾳṘᾛṎṅᾈῗᾆᾤᾇ\u1fd5ῒᾡṄ\u1fb5ᾱᾶᾸΆᾨᾭῑᾌṃṉᾶᾮᾀᾸṅᾭᾃᾫ\u1fb5ᾌᾱṁῗ\u1fd4ᾎᾃᾅΆῑᾆᾇᾳᾴṍᾦṃ\u1fd4ᾳᾀΐᾶᾢῑιῒᾃᾧᾦᾪᾤᾯᾧṛᾬᾍᾠṃᾧᾍῒΐᾦ\u1fd5ᾪṛιṂᾃᾍᾯᾉᾁᾍᾌᾢṘῖᾯṅᾱᾩ\u1fb5ᾫᾢᾣ\u1fb5ṛᾉᾡᾡᾶᾁᾪᾅᾨᾳᾲᾭᾮᾷᾠᾂᾮᾩṉᾦ῞ιᾳῒᾭᾣᾄῒ\u1fb5ᾂᾂᾀᾃΆᾂᾧᾬᾋᾤᾇᾏ\u1fb5ᾶᾲṀᾦᾈṎᾦᾶṉᾀᾇᾮᾎῒᾢᾳῒṂᾇᾎᾥṛᾀᾍᾏᾆᾀṄΐᾥᾨᾉᾲᾫᾯᾅᾭᾮṘᾇᾱᾈṘᾃ\u1fd5ṍṇᾡᾱᾏᾶᾍᾘᾸṎᾶᾥᾯᾠᾱᾇΆᾋᾂᾡᾨṍᾊᾢῒῒᾫᾱᾥṍᾍᾇᾱṅᾀᾅṛᾦᾯᾀṘᾏᾌᾌᾤᾦᾸṄῖ\u1fd4ᾮᾸṄᾦ῞ᾎᾧᾘᾃᾍᾏᾌṛᾯᾈṀᾢṁᾪΆᾠᾴῑṍṃᾆᾍᾩᾭ῞ṍᾫᾃᾍᾧᾁᾪᾧΆῑṅṂᾮᾡᾨᾋṛṁ\u1fb5ᾠ῞ṃᾄᾥᾳᾱᾌῗᾤᾪᾤṉῗᾬᾶṂᾘᾎᾡᾡᾣ\u1fd4\u1fd4ᾧῗṘṉᾲᾢᾘᾆṇᾱᾮᾭᾴΆṘṃ῞ᾂᾄᾛᾳᾘṂᾷᾳᾋᾴᾌᾈᾲṘᾮᾏᾃ\u1fb5ᾆṇᾪṛṃᾶΆᾣᾨᾮιᾋᾭᾇᾡᾴṍᾇῑᾆ\u1fd5\u1fb5Ᾰᾪᾡṅᾯᾤᾷᾡῒᾷᾧ\u1fb5ᾅᾆᾧᾸῑᾡᾆᾯῗᾲᾳᾢῑιᾸΐᾎᾳṁᾂṇᾘᾊᾂᾶᾴᾤῒᾩṇᾦṘιῗᾎᾳᾨᾎᾯᾁᾄᾴᾄᾄᾸṛᾳᾭᾇṉᾯᾠ\u1fd4ΐṅ\u1fd5ᾊᾈῒᾍΐᾇᾧᾦᾀ\u1fb5ᾍᾸᾉᾥᾨᾩᾎῒᾯᾬῒṅᾷᾨṉṀ\u1fb5ᾴᾉṄᾉᾴᾸᾣᾃᾌΆᾃᾡᾯᾂᾃᾇῗṁ\u1fd4ῖṎṍᾡᾱᾴᾢῖṃᾈᾘṅṍᾍᾮṁᾎᾷṉΆᾡᾤᾣ\u1fd4ᾳᾊᾆᾪᾆᾴῗᾋṉᾂᾭṉᾉᾅṅᾃᾭṇᾊᾘᾱᾄᾬṁṉᾎῒᾮṉᾉṉᾶῗ\u1fd5ᾮᾅᾏᾬᾁᾮᾛᾇᾊΐṃ\u1fd4ᾀṍṘᾮṎῑᾇῖṍṇᾣᾥᾩṛṛᾈᾷᾣṛᾈᾋᾋᾴᾆ\u1fd5ΐᾋᾥῑᾮᾀᾋᾧᾩᾭᾤΐṀᾳᾯᾋιῑ\u1fd4ṍΆ῞ᾇᾨᾷῑᾂᾳΐᾪṉ\u1fd5ᾢᾍᾬᾭṇᾫᾘᾴᾨᾄᾭΐᾭᾧᾭᾂᾊᾋ῞Ṁᾢᾤᾶᾳ\u1fd4ᾏῑᾁᾆᾫᾣṄ\u1fb5ṃ῞ᾍ\u1fb5ᾛᾸᾆ\u1fd4ιᾘṍṂᾨᾯṇᾠṃ\u1fd4ᾷᾴṂᾳῒṁᾎᾄᾛᾷṃᾳᾊᾲᾦᾌΆṂᾄᾎᾠᾣᾀᾴᾩ\u1fd4ᾪᾌᾸᾄᾀᾩᾂᾡᾇ\u1fd5ΆᾪᾳṅṃᾨṃᾴᾱᾘᾈṛΐᾦṀᾱᾊᾍᾍṘᾭᾛ\u1fd5\u1fb5ᾭᾳᾍᾘᾫᾩṃᾡ\u1fb5ῖᾉ῞ᾴᾥᾁᾱᾃ῞ṃṛᾭᾁṂᾧᾂᾏᾋ\u1fd5\u1fd5ᾉᾄᾎᾳᾀᾆᾦᾯιᾎῖᾀṀṀᾮᾣᾪᾊᾲ\u1fd4ιᾈᾢᾃῑᾅᾘᾛᾂᾍᾉᾯᾷᾧᾭᾬᾢᾛΐᾷᾯᾳᾀᾂᾀᾴṘᾉᾈᾨᾶᾆṅᾍᾦᾫṎᾥ\u1fb5ῒᾊΆᾃṃᾛᾴṛṅᾣṃῖ῞ᾯᾮᾨ῞῞ᾥṁιᾋΐᾩῗṂᾏ\u1fd4ᾫṍᾇᾸᾎᾳṀṛᾦᾛṄᾄ῞ᾅᾃ\u1fd5ᾤῒṛṁ\u1fb5ᾛᾎᾇṁᾲᾥṃᾮᾨ῞ᾥṘᾏᾊᾏᾲᾩṍῗᾬῖᾏ῞ṘṃᾩᾦᾤᾸᾷᾋᾱᾣΆṛ\u1fd4ṛᾠṁᾭᾅᾂᾏᾶᾪṘᾋᾨᾳᾆ\u1fd5ᾮᾫᾬᾃᾴᾧᾳᾥᾄᾸᾯ\u1fd4ᾀᾇᾨṇᾭᾏṂṉṂᾬΆᾍᾴᾯᾆᾂᾌᾁΐᾯῑΐᾱᾩᾁᾳṍᾁṇᾊᾱᾉᾪᾏᾱᾘ\u1fb5\u1fd5ṍṃᾯᾌᾧṉ\u1fb5ṃᾪᾅᾍᾡᾌᾂᾱ῞ᾦᾮᾛᾷᾡᾍ῞ṛṅᾅΐῗᾶṘῑṛᾦṅᾣῗᾯᾉṂᾭᾌᾯ῞ᾏṘᾆᾍᾱᾌṂΐΐᾩᾶᾄᾎᾢᾩῑᾧΐᾂᾃṅᾨᾢᾭᾡᾏᾡᾪᾧᾈΆᾃᾅᾈᾂᾴṛῗṍᾎῗῑṛᾶᾣᾲᾩᾍᾧᾢᾀᾭᾥᾪᾫᾭᾌᾏᾠῑṁᾦᾣᾉᾄṁᾇᾮᾴṘ\u1fd4ᾮ῞ᾀᾀᾬᾈᾩᾪᾌᾂᾈṅᾦιᾥᾶṎṇᾉΆṀᾍᾲᾄῑᾭᾂᾅᾬṍṅᾷᾶṁᾥῑιΐᾣᾫ\u1fd5\u1fd5ᾅᾊᾈᾧῖᾬᾆᾉᾳᾢᾴᾈῗᾸṉᾊᾦᾣᾦᾏṄᾉᾎᾇᾪᾴΆᾳᾨᾧᾪ\u1fb5\u1fb5\u1fb5ṍᾣᾴᾅΆᾸᾇṎᾤᾄᾳṃΐ\u1fd4ᾄᾪιᾢᾉᾍᾸΆᾏᾥṇṎᾯᾷᾄᾷᾷῑᾊᾤᾃᾱᾋΆᾃᾮᾛᾏ\u1fd5ṂᾸᾋṄṀᾃᾉṂᾫῒᾴῒᾪᾇᾋ\u1fd4\u1fb5ᾅᾫᾸṁṁṍᾫṘᾭṀᾧᾃ\u1fd4ΐᾏῗᾘṎᾌᾃᾌᾎᾧṎᾥᾉᾥᾘΆᾡῑᾭᾁᾉṂᾫṛᾪᾋṁᾲṅΆṛṛᾤᾏᾱᾶᾃᾭṄ\u1fd5ᾥᾥΐ῞ΐ῞ṃῖᾆṍᾸṎᾍᾦᾧṃᾣΐᾄᾋᾀᾛᾈᾇᾂᾲ\u1fb5ᾣ\u1fd4ιᾍᾥᾭṛᾄᾨṎᾏιᾧṍᾳᾲṁṉᾛṁΆῒṎ\u1fd4ᾊᾤᾮᾩṂᾫᾃᾈᾫᾨΆᾸᾎṎᾦᾩᾬᾴᾢṃᾂᾭᾡṀᾋᾋᾉᾉᾇᾛῒᾮ\u1fd5ᾭ῞ΐᾧιΆᾩᾌᾶᾇῖᾎᾇᾯᾂᾪᾃᾮᾏᾌᾃṎᾧᾃᾎᾥṛᾅᾂᾢ῞ῑᾣᾛ\u1fd4ᾫᾨᾘᾘᾧᾆᾬṃᾁᾨᾥᾃᾅΐΆΆṅᾍṅᾸΐṀ\u1fd4ᾦᾷᾡᾡᾠᾧᾤᾛᾦᾉṅιᾸᾭṃᾫ῞ᾏᾷṍᾸᾢᾏᾍᾯᾛᾂᾆᾤῖᾡᾩΐᾸᾦᾄᾂᾬᾯᾌᾍᾭᾳᾴṁᾡṇῒᾤᾋᾦṍᾪᾳᾠᾯᾇῒᾫṂṇᾨᾱṄṀᾬᾡṀ\u1fd4ᾅῒῑᾳᾏῖᾲṉṅṃᾸᾊṛᾳᾍᾱṇᾣᾲᾘᾠᾯᾋᾥ῞ᾪ\u1fb5ṇṍᾛṛṃᾨᾋᾭῒ\u1fb5ΆᾧᾆᾸᾥᾠΐᾊᾬᾲᾠᾩᾣṄᾷᾧᾍᾂᾯ\u1fb5ᾘᾶᾂᾸΆᾛᾯᾫιιᾱᾪΆṉΆṄᾢṛᾷᾎῗṀᾎṇᾴῑΆᾬᾈ\u1fb5ṃιṄᾲᾪᾈᾋṂṁΐᾄιṄᾸᾈᾉᾱᾍᾸᾯᾆᾋṃᾌᾬᾌᾴᾫᾤṇᾇᾁᾯᾍᾛῑṂᾤᾀῑṛᾛṉṃᾈ\u1fd4ᾍ῞ᾌᾶᾇᾃᾍṃᾂṃᾃιᾮᾫᾸᾬῗᾭṎᾦᾷᾷᾯᾇṛ\u1fd5ṅᾥṇᾯᾍᾧᾷṅᾧᾄᾇῒṘᾠῑᾧᾛṘᾯᾡῒ῞ᾫ\u1fd5ῖ\u1fd4ᾌᾋṄṍᾪᾲṎᾄᾸṄᾃᾌṘᾱ\u1fd5ᾪᾛṉᾲᾴῗῗᾅᾀᾊṉᾴᾧᾠᾀΆṁᾱᾅᾊṇᾘᾏῑιᾨ\u1fd5ιᾏᾳᾊᾀᾇᾨṍṁᾧΆṁῑᾳṂ῞ᾠᾫᾩṅᾊṅᾄᾛṍᾳṍᾅᾇᾆṛᾛᾢῖᾡṁᾇᾄᾡᾬΐΆᾬṍᾶᾷῒᾉᾡṅṇᾉᾀᾷᾷᾂᾛᾨṁᾧᾆῖᾴΆᾭᾅᾛṇᾨᾲṃᾃᾥᾨᾆ\u1fd5ṂῒṂᾛΐ῞ᾤ\u1fb5ᾏᾍᾋṉᾨᾄᾷᾳṉᾦᾁṘᾄᾏᾦιṂᾶᾁᾭᾪᾈ\u1fb5ᾈᾌᾃᾭΆΆΐῗᾸῖᾡṉᾷῗᾈṃṍṁṂᾦᾷιᾛᾢᾃᾂᾥṁᾱῑῖᾇṎᾄιᾱᾡ\u1fd4ᾡ῞ᾍᾎᾬᾈᾩᾂᾧᾅᾭṄᾅᾭᾊṂῒᾸΆᾁῒᾶᾳᾢṎᾫᾊῗᾊᾦᾏṘṂᾁᾦṍιᾥᾌᾢᾀ\u1fd4ṉᾏᾴᾉΐᾮṘΆᾳΆᾋṂṂṂṁṇ῞ᾮᾋᾉṂᾩṄᾤᾢᾥᾩᾍᾷᾡᾦᾢᾍṇṘṍᾳᾬῒᾃ῞῞\u1fd5ṘᾷᾍᾁᾎᾉᾸᾛᾅṀᾲᾌᾁᾉ῞ᾱΆᾎᾱᾉᾈᾛᾊᾘᾱᾯ\u1fd5ᾀᾱṁιᾣᾱᾣᾸṀᾥᾆṉᾪṅιᾇᾈᾈᾛᾴᾛᾉῖΐṛ\u1fd5ᾴᾉ\u1fd5ṎᾯᾀṎ\u1fd5ΆᾡΆᾂᾶᾦᾃᾯᾩᾯᾊṘᾅᾛᾳᾪᾌᾷᾤᾥ\u1fd5ṇᾳṄᾅῗᾯᾋῗᾛᾤᾇᾴᾲᾦᾯᾧᾌᾩΆṎ῞ṀιᾈῑᾡṘᾲᾎᾈᾛᾲᾴᾪᾎṂᾳᾃṉᾣᾅṉᾉΐṉ\u1fb5ᾃᾋṅᾈᾘṍᾏṅṀᾴᾇᾎῒᾄᾤᾢᾌᾏᾍᾠᾴṃ\u1fb5ᾴṀᾍᾯᾁᾫᾇᾌᾯᾯᾀᾳῑᾀᾱᾫῑṎᾄᾍῗᾫṉᾭṂᾱᾸᾡᾲ῞\u1fb5ᾊṇṉᾌᾄᾴᾋṂᾮᾠᾮṀᾃᾳṂᾴṎ\u1fd5\u1fb5ᾷῖᾧṅᾶᾲṄṛṛᾆṍṍῖᾯṛ\u1fb5ṇᾡᾡᾉᾱᾆᾈṍᾶᾊᾧᾫṀᾢṉᾍΐᾎῗΐᾣᾤῒΆṉᾅ\u1fb5\u1fd4ιᾦᾃ\u1fb5ᾨᾸᾸ\u1fb5ᾉ\u1fd5ΐṛῑᾮ῞ṃᾍᾇᾍᾳιᾋᾏᾆᾸᾇᾸ\u1fd5ᾋᾃṛᾏṛᾯ\u1fb5ᾁᾏᾱṀᾤᾏᾛᾴιᾍᾌιᾱᾤṅᾭᾋ῞ᾦᾤᾷᾩᾘ\u1fb5ᾎᾩᾫιᾅṅ\u1fd5ᾸᾊᾎṛṃṇᾫῖῒᾶṉᾥᾧᾳṛṂᾊᾣᾏṃᾮᾌᾮ\u1fd5\u1fb5ῗᾦᾸᾃᾃᾇᾦᾷᾬṇṇṅṄ\u1fd5ΐᾤᾭᾦΆᾉᾋᾡᾬᾤᾯṄᾠᾳᾃᾫᾋᾷᾀιᾡṄᾩᾲᾩΐᾢṀῖ\u1fd5ṇᾬᾥᾆᾁṀᾈ\u1fd5ᾫᾫᾀṁᾄṃ\u1fd4ᾦᾫᾥᾩῗᾌṀᾶᾇᾡᾊṎṘᾣᾡ\u1fd4ᾶᾫῒᾬᾸṇᾠᾄᾦ\u1fd5ᾌᾯᾷṘṄṂᾬᾅᾦᾡᾶᾉṅᾎᾱᾮᾩ῞ᾋᾇᾪṛᾠṃᾠᾍᾦῑᾏῗᾂᾤᾅᾅᾳῒᾇ῞ᾀᾏᾱᾨῗᾲῑṃᾣᾥṇṅṎṉᾱṃᾥᾸῗᾥṁᾌṉᾊᾯᾇṅᾍṃᾏ\u1fd5ᾂᾩῒ\u1fb5ṅᾏᾧᾈṂῒᾬᾁᾷᾬᾤᾢ῞ᾡᾅᾠṇᾣᾡṍᾦᾁṇᾏᾄṍᾶῖᾅṁᾥᾊṉᾨṅṛᾅᾆṎṁᾆṄ\u1fd5ᾀṀᾶṄᾨᾧᾋᾤ\u1fd5ᾷῒᾣṅᾥṇṀᾭᾱᾩᾘᾲᾋᾳᾦᾳῗᾌῑᾳᾈᾘΆᾃῖῖᾸᾘᾧṎᾃᾊṂṛᾡṎᾢᾊιΆṀṎṄṍṛᾀΆᾆᾢᾏṀᾛṁᾌᾸṂᾈᾎᾎᾃṁᾲᾊᾠṄṇιᾃᾠṛᾛᾘ\u1fd4ᾸᾆṄ῞ᾭᾃṛᾛᾅΐ\u1fd4ΆṀᾘ\u1fd4ᾊᾩ\u1fb5ᾱṇᾢ\u1fb5\u1fd4ṍ\u1fd5ᾯṂΆᾘᾨῑΐṁΐᾫᾄṀᾎᾃᾱᾡᾩᾢᾶῒṅΐᾍᾩ῞ᾡᾠᾡᾉᾥᾮᾃᾫᾴῑᾩᾇᾷᾇᾀᾩᾁᾯṘṛᾶιᾥᾩᾲ῞ᾪΐᾉṀᾬᾈṘ\u1fb5ᾳᾩṍᾍᾢῒᾩιᾸᾬṛᾬᾈᾭᾈᾱᾶῒᾇῖῗᾋᾇᾌῒᾃ\u1fb5ᾬᾏᾦṘṍῒῖᾌᾪΐᾪᾧṁ῞ῗṇᾠᾯᾊṀῑṄᾬṛᾮῒᾩᾢᾠᾘ῞ᾘᾷιṂᾃṇᾶ\u1fb5῞\u1fd4ᾨṁṘṃΆᾧᾆṉΐᾱῖᾦᾮᾊᾸᾴṃᾄᾊᾨῖᾄΆ\u1fd4ῒᾈᾤᾎṎᾴῗᾁᾠᾱᾀᾩᾪṛᾭᾛᾈ῞\u1fd5ιᾠΆṉ\u1fd5ΐᾳᾉῑṎᾶᾄᾲῒṘῖṎᾡ῞ᾊᾦᾫᾃᾱῖᾭᾥᾈᾄᾤῑᾠᾭᾎᾛᾪᾣᾠṉᾃᾈᾫᾴᾪῗᾀᾋ῞ᾆᾏᾸᾩᾏΐᾫᾤ\u1fd4ᾲṍṁᾋᾎṘᾈᾠᾊ\u1fd5ᾡṉᾌᾌᾷṍᾦᾥᾩᾂῗῒᾭṇṃᾀᾛṍᾋṁṍᾧᾱᾡᾃṎᾘᾄᾶṃῑᾅᾛᾢᾎᾣᾁῑᾠᾀᾏᾬῖ\u1fd5ṃᾮṇᾩṂᾦᾪṍṄṍṁῖᾉῑṉᾌᾀṉᾷᾷṄᾭᾇᾱ\u1fb5ṘᾸṎᾂᾃᾦᾥᾭΐṅṅᾘΐᾁṁᾨᾱᾱ\u1fd5ᾃᾛᾏᾪῗᾊᾤῑṁᾨᾦᾩᾉ῞ᾴṉ\u1fd4\u1fb5ṅ῞ῑᾱᾍῖῑῒᾴᾸ\u1fd5Ṅᾋᾡᾇῖιᾲṉ\u1fb5ᾬᾉᾨΐṍᾁᾫ\u1fd4Ṁṉ\u1fd4ᾪᾎṀᾯᾱιᾀᾆᾠṍῗṘᾂᾅṂῗᾢᾢῗᾀᾡᾪᾀṃᾇṍᾅ῞ṃᾉᾥᾘῗᾏᾮῑᾮᾴ\u1fd4\u1fd4ᾋᾘᾆᾯṇᾬᾫṅṃᾱṛᾌᾬΆᾛ\u1fb5ᾲᾪᾯᾳᾬᾈᾢᾷṀṂᾴṘᾮᾷᾸᾂᾧᾘᾡᾨṘ\u1fb5ᾶ\u1fd4ṍ\u1fd5ṇᾥῖṄᾌᾏᾢᾁṛᾩṁᾨᾦᾧᾮᾷᾥᾇᾋᾷᾈᾇᾦᾣᾄᾲᾨ\u1fd5ᾂῗ\u1fd5ᾌṇṄᾄᾤᾁṇᾇṁᾥᾂᾱᾧṘᾲᾯᾥᾁᾭΆᾉṟ"
                .toCharArray();

            for (int b0 = 0; b0 < 8300; b0 += 1) {
                char c0 = achar[b0];
                int l1 = c0 ^ '롰';
                int i2 = l1 ^ 15537;
                int j2 = i2 ^ 42627;
                int k2 = j2 ^ 57556;
                int l2 = k2 + 56245;
                int i3 = l2 + 60840;
                int j3 = i3 - 64906;
                int k3 = j3 - 38940;
                int l3 = k3 ^ 55997;
                int i4 = l3 - 31022;
                int j4 = i4 + 58367;
                int k4 = j4 + 52015;
                achar[b0] = (char)k4;
            }

            object = mth_0OOOoo00o0_31()[0] = new String(achar);
        }

        aobject[2] = (String)object;
        char[] achar10 = ((String)o0Oo000O0oO(aobject)).toCharArray();
        int limit = 5083;
        int i20_hi = 0;

        while (i20_hi < limit) {
            int k30 = i20_hi;
            int j20_hi = i20_hi + 1;
            char c10 = achar10[k30];
            k30 = j20_hi;
            int k20_hi = j20_hi + 1;
            char c11 = achar10[k30];
            int l20_hi = c10 << 16 | c11;
            char[] achar11 = new char[l20_hi];

            for (int limit2 = 0; limit2 < l20_hi; limit2 = limit2 + 1) {
                achar11[limit2] = achar10[k20_hi + limit2];
            }

            k30 = k1_hi;
            k1_hi++;
            o0Oo000O0oO[k30] = new String(achar11);
            i20_hi = k20_hi + l20_hi;
        }

        aobject = new Object[]{fld_0OOOoo00o0_65, 1, null};
        object = mth_0OOOoo00o0_31()[1];
        if (object == null) {
            char[] achar12 = "ꝵ꜅ꝳ꜔꜒꜃Ꝥ꜎돇ꝴ돇ꜙꝯ돏Ꝿꝴ돃ꝰ도꜕돂꜃ꢞꝰꝠꝲ꣨꜃Ꝺ도Ꝥ꜕Ꝯ꜕돏ꜙ도ꢞ꣡ꢚ꜅꜐꜉Ꞧꝼꜟ꜕ꞡꝚ꣡Ꝥꝿ돈돇ꜘꝿꝯꝩ돏돎돃꜐꣨꜔돎ꝴ꜎ꜙꜙꢞ꜔돂ꜥ돏돃꣡ꝰ꣡ꢚꝴꝿꜙ도꣨Ꝥ돘꜂ꢚ돃ꝩꢞꢜꝵ돃ꝁ꣨ꝣ돐돐ꝼꝺ돘꜎ꝩꝿ꜂꜂돕꜃꜄ꝚꝚ꜔꣡꜂ꜘ도꣨ꢚ꜕Ꝯ꣦ꝺ돂Ꝼ꜅꜅ꝲ꜏ꝰ꜕꜓ꜥꜥꝹ꜔Ꝛꜘꢞ돏Ꝼꝺꜘ꜐ꝁꢞ꣡ꢛꝰ도돘꜓ꢜꝵ돍ꢜꢛ돏ꜘꢚꝹ돈ꝻꢜꜟꝤ꣭돇꜕꣡ꢜꝁꜟꝯꝰꜟꝷ돍도ꝲꢜꝚ꜐꣭ꝮꝸꞡꝢ돂꜎ꜗꝸ꣧ꝷꜥꞦꝩꝚ꜕ꝺꢚꢜꜟ꣦ꝷ꜒ꝁ도꜎ꝵꝠ돇꜔꣭ꝲ꜃꜐돈ꝸꝚ꜂도ꜘꝷꝵ꜃꜐ꝣꜟꜟ꜅돆돏ꝩꝢꝠ꜒돈ꢚꝴ돃ꜘ꣡ꝢꝳꝚꜟ돆ꢞ꜏꜎Ꞧꝳ꜔돎꜉ꝩꝢ꣭Ꝥꝴꜘ꜎돂Ꝡꝵꝼꝩ꜅돇꜃ꝴ돏돏ꢚ꜏꜓ꝾꝠꢚꜙ꜏돆ꝳꝚꝺꝢ돇돆돕돕돘돈돏돆ꜟꝲꝰꢜꜥ꜐ꝷꢞꞡꝳꞡ돍ꢚꝮꝚꞡꝸ꜏꜂꜒돃ꝳꝲ꣧ꝼꢞꝳꝴ꜅돂ꝢꝹꢚꝣꜘꝮ꜅돂꜒꣡ꝯ꜅ꝿꝠꜥ꜐ꝹꝮ돏Ꝺꜥꝺ돃꜔꣡ꝵ꣧ꝳꝹꜙꞦꝹ돈돇ꝰ꜕ꝚꝠ돇ꜘ돂꜕ꝩ돘ꝸꜙꝯꝮꝣ돐꜅ꝴ꜅ꜗ꜐Ꝺꝯ꣧돇ꝻꝠꝾ돎돈꜕ꝁꞦ돎꜏ꝵ돍꣧돎ꝯ꜅ꜘ돆꣡꣧ꝯ꣦ꢜꢚꝁ돈Ꝥ돂꜏ꝿꝺ돃Ꝯꞡ돈ꝚꝚ꜃Ꝛ돂ꜥ꣦꜓꣦ꝤꝠꢞ꜕Ꝼ돆꜃꜐꣧돂ꢛꝩꝤ돇Ꝡꜟ돉ꝰ돐ꝸꝴ꜅ꜘ돉Ꝯ돏돐돎꜓돂꜒ꜥ돂ꝰ꣧돏돆ꢚꜗꝯꝼꝾ도돆돉돈꜓돏ꜗ꣦Ꝿ돐ꜥꝳꢚ돃Ꝥꝺꝯ꣦꜒ꢜ꣡Ꞧ돂ꝯꝴꝰ꜂꣡돎ꜟꢞ꜄Ꝯ돉돎돍돘돇Ꝣꜘ꣦ꝁ꜒돃ꝠꝾꝾꝠ돂돇ꝷꜟꢚꝿꢜ꣨ꝢꞦ돆꜐돇ꝯ돃꜉ꝳꝣ꜎Ꝁ꜕ꝩ돇돂꣭ꞡ돕꣨돍꜕ꢛ꜂ꝵ돂ꝸ꣨꣦돇돘돉돏ꝀꝹꝷ돎ꜘ돘ꝿꝸ돏꜅꜔Ꝛ꜕꜏꜒ꝳ꣧돃꣦꣧ꜥ꜎돉ꜟ꜔꜉꜐Ꝛꝺ돈ꝩ꣡꜉꣭돆ꢜꝼꝹꝺꝸ꜎꜄ꜙ돃꣨돕ꢚ돈돐Ꝺ꣨꜓꜏ꝰ꜅꜉ꝸꝤꝲ꜐ꝵꝰ꜔꣧꣦돂꣧도꜒ꢞ돕꜒꜒꜃돂ꝩꝢꝢꝲꝤ꜅꣭꜄ꢜꝣꝠꝸꝁꝵ돍ꝼ꜎돂ꢜꝰꝴꝼ돈ꜥꝹꝵꝩ돂돉꜉ꝰ꣧ꢛ돃ꜥꜘ꜓돕꜕꜅Ꝯꢚ꜂Ꝁ꜒꜎꣦ꝩꝰ꜐Ꝣꝲ돂ꝳ꜉ꢞ꣧돐ꝷꝼꝸꝠꝚꢜꝣꝼ꣭ꝣ꜒돈돃돆ꜙꝚꜗꜙ꣨돎ꝲ돈돇꜕ꝳ꣡ꝲ돐꜕ꢛ꜐꜏Ꝼ꜔돂돘ꝿ꣨ꜥ꣧돈ꢛ돃Ꝥ꜃ꢚ꣧Ꝡ돕꣭돏Ꝛ꜓ꝰ도Ꝯꜘꢚ꣧꜎Ꝿ꜂ꢞ꜒ꝯꝢꝀ돇꜏ꝰ꜎돍Ꝯ꜐꣨ꝳ돈ꝁꝯꞦꜗꝴ꜐돈Ꝿ꜏꜕Ꝼ돂Ꝁꜟꝷ돇꜉꜒꣡돕Ꝛꝿ꜓돆ꢜꝩꜘ꜒ꝿ돇ꢞꝁ꜏Ꞧ돂돈꜕ꜙ돘ꝲ돍돃ꢞꝳ돇꜄ꝿꜗ돎꜃ꝺꝯ돕꣨Ꝡ꜃돍ꝤꜥꝠ꜎돂ꝳꝯ꣧돂ꝣꢜ꜏돏돘ꝴꝾ꜓ꜙ꜄ꝺꝮ돕ꜘꜗꝣꞦ돉ꝼ꣧꣦도ꢞ꜄돐꜒Ꝛꝯꝲ꜒도ꜟ꣭꣨ꢞ꜔꣦ꜘꞡ돇ꝰꝴ돆ꢛꝲꝩꜥ돏꜅꜓꣡돘돐ꝰꞡ꜂꣭ꝼ돎꣦꜂Ꝿꝲ꜒ꝴ돕ꜗꢛ꣭ꝺ돆ꜗꝣ꣭Ꝿꝺ꜉Ꝥꝰꝵ꜒꜐꣭ꜥ꜒ꝼꜘ돉돇ꝵꢚꝩꝀ돂돐돇돉ꜙꢚꝿꝹꞦꜗꝻ꜔돍ꢜꝼꝵ꜔Ꝿ돏ꝁ꜎ꝀꝤ꣧꜃ꝩꢞꝀꝢ꜐꜕꣦ꜟ돕돆ꢛ돐꜏꣡Ꝿ꜉Ꝛ꣨꣦ꞡ꜄돈Ꝿ돂도Ꝥ꣡ꞡ돃ꜙ돎돐꜓ꝺꜥ돇ꝷ돉ꝸ꜏꜓ꜥ꜅꜂Ꝛ꜓돐ꜘ돆도꜄꜏돎돇돕꜂ꜟꝀ도꜂돘ꜟ꣨꣦ꜟ돂돈돘ꜥꝰ돘꜉꜄돉ꜗ꣭꣡ꜘ꜄ꢚꞡꢜ돎Ꞧꝩꝲ꜃돇돈꜐돎꣨ꝵ돕꜓ꞡꝷ꣦Ꝺ돈ꜙꜗ돘꜂꜔꜄ꝚꝰꝯꝠꝰꝼ꜏ꝴ꜎돇ꜙ꜎Ꝺ돍Ꝛꝿ꜒Ꝿ꜄꣨ꝸꝯ돘ꝿꝮꝹ꜕ꝮꝢꢜꜘ돐꜐돐돘돕ꜙꝲ돘돆ꞡꝼꝣꝤꝾ꣡돆ꞡ돇ꢞꢜꝷ돇꣧ꜗꜙ꣭ꢜꝁ꣡ꝯꝚ돘꜂ꝣ꜒돃ꝺ꜂ꢚ돃ꝷ돐ꝿꜥꝴꢜ꜕ꜟꝵ꜓꜓돆꜄꜂ꝼꝲꝴ돆돏꜓꜎꜎돘ꝺ도돂꜓돘꣨꜉ꝢꝠꝚꝚ꣡ꢚ꜄꜔ꝾꝮꝵꢜ돆돂ꝾꝮꝣ도돏꜒돇Ꝯ돐돏돇ꜥ돇도ꝳꝸꢜ꣧ꞡ돆ꝳ꣦도ꞦꝚ꜄꣭꣦ꜙꝠꞡ꜂돎Ꝁꝩꜟ꜉꜎ꝸ돎돃돏ꜙꝤ돐돏ꝵ돈꜉돇돆Ꝿꝰ꣨ꜥ돎돇Ꝿꜥ꜔꣭돐ꞡ꣧ꝣꝿꝚ꜎꜄도ꜘ돃꜃꜏ꝵꝢ꜂돃ꜥ꜉ꝯꝢ돕꜂꣨ꝁꜟꝳ꣧Ꝯ꜅돘ꞡꝩ돍꜃꜉도ꝵꝠꝮꝰꝻ돐ꜗ돉ꢚ돎꜄돈ꢜꝷꝺꜥꢜꜥꝿꝮ꣡ꝯꝿ돘꜅ꞡ돘ꢜ돃꜏ꝼ꜄ꝀꝹ돇ꜙꢛꝚꝾꝾꢛ돆꜓ꞡꝸꜗ꜄Ꞧꝳ꣦ꝰ꣧꜔ꝴꞡ꜒ꝁ꣡ꝼꝲꜥ돕ꝼꢞ꜄꜄ꝯ꣨꜔꜂Ꝿꝼ꜔돐꜒돕ꝴꝩꝚꝮꢛ돍꜃돎ꝴꜥ돐Ꝥꝲꝼ꜐꜕꜓ꝷ돕꜐Ꝥ돇꣨도도꜔ꝰꢞꝳ돐ꝲꝠꝿ돕ꢞꜗ꜓돉돐꜃ꢞ꣭꜏돎꜎도ꢚꢛ꜃꜎ꢛꝿ꣧ꜙꝾꝯꢜꝰ돎ꝩꝚꜥꜟ꜒ꝣ돆Ꝯꢛ꜄ꜥ꜉ꝲ꜎꣭ꜟꜘꝼ꣡꜐도꜎ꝁꜗꝼ꣡도ꝺ꜔돏돐꜄돎ꝼꝣꝁꜙ꜅꜐꜎돍ꝵ꜔ꝺ꜐ꝿꞡꜗ꜕ꢛ돂ꝳ돂꜅ꝲ돏돇돎꣡ꢛꝸ꣨ꜟ돆꣨ꝩ꜂꣧꜎ꝣ돎ꝺ돐꣭도꜉ꢜꝵꝢ꜄돆ꢚ꜓돍꣦ꞡꝲꜙ꜂돏ꜘ꜂ꝀꝚꝴꝺ꜔Ꝿ꜓꣧꣨돘ꝵ꣧꜄Ꝺꜗ돕꣭ꝿꜥꝰꝴꝰ꜐ꝼ꜃Ꝿ돂ꝩꝠ꜐돈ꝀꝁꞦ꜒ꝠꝺꝾ꜐ꢚꢞꝼꝩꝵꜙꝤ꣧ꝣꝚ돎돃ꝳ꣧ꜗꝾ꜅ꜘ꣭Ꝺ돎ꝩꝤ꜅Ꝼ돃ꝲꝴꢚ꜄ꝷ꜓ꝹꝼꞦ꜔ꝣ꣡꣦ꝿ돎도돈Ꝛꞡꝯ돕ꢞꜘꢜ꣨Ꝿ꜄꜃돉돉돉꜃Ꝡ꜄Ꝯꜥꜗ돂돇ꝳ꣭ꜟ돂돐Ꝿ꣦꜏도꜎ꝰ꜓돎꜏ꞡ꜅꜕ꝻꝾꝮꝀꢜꝾꜘ꜎돈ꢞꝿ꜅꜓ꜙꝵ돈돂꣦Ꝡ돏꜅Ꝁꝩ돎돃돘ꝁꝯ꣨Ꝡ꜃도돈Ꞧ꜂Ꝯ돐ꝺꝀ돃돏ꝷ꜏꣨꣨돈도도꜓꜐ꝳꝹ꜒꣧Ꝁꝲ꜓꣡꜐ꝯ꣨돏Ꝛ돇꜏Ꝯ돕도꜕ꝴꝁꜘ돈돈ꝯ꜐Ꞧ돈꜂ꢛ꣦ꝺ꜄돏돈꜅꜎도ꜟ꣨돍돏Ꝡꜙ꜓ꞦꝢꝤ돎ꢞꝼ꜔돉꜓ꝺꝩꝚꝁ꜂ꞡꝠꝾ꜓ꜙ돏ꜗꞦ돉Ꝯ꜏꜏ꝣ돉돕ꝯ꜂돃돆ꜗꝀ돘돘ꝺ꜃ꝺꝿꝴꝲ꜄ꝸ꣦ꝼ돕ꝺꝀ돈꜕ꝿ돃꜕ꝿꝻꝯ돂Ꝛꝲ꜅꣨ꜙ돘ꝷꝺꢜꝮꜟꝷꝿꝠ꜐Ꝛ돘Ꝥꝿꝯ돏ꝿꝣꝺ돍꜎ꝳ돈꜎ꝤꝮ꜏꜉돕ꝰꝻ꜅ꢞ꜃Ꝼ꜔ꝤꝳꜗꝚ돇ꝣ꣨Ꝯ돃ꜟꝲ꜃꜒ꝺꝿꢛ꜓꣭돈도꜃꜄돍꜕ꝠꝺꝤꝚ꜏Ꝛ꣧ꜟꢞꝷꢜꢚ꣨ꝻꝤꝰ꣭Ꝥ꜃돇꣦ꝲ꜃꜕ꜙꜘ꣨꜂꜐ꜘ꜅돂꜕돃돎돕ꝁ돉Ꞧ꜎ꞦꝴꝹꝯꢜ꜎ꝯꜥꝢꢜ꜃ꢚꝩꝻꝵꝻ돆ꝷ꣨꜔ꝴꜥꞡ꣨ꝁꝺ돈ꝲ도꜂꜕꜓ꝿ꣭ꜙꝤꝀꞦꝿꝤ꜕ꝰ꜎ꜗꝯꜥ돃ꝼ꜉ꜥ돍꜂꜅ꝲꝮ꜐ꜘꝵꝳꝼꝀ돉돆돎ꝰ돉ꝺꝩꝩꜟ돐꜂Ꝥ꜄꜄ꝲ돇Ꝁꢚ돘Ꝣ꣧ꝁ돉ꝩ돂ꝴꝚ돆꜂Ꝯꝯ꜂돉꜎ꝯ돘돂꜒Ꝯ꜓ꝺꝮ돎돈돆ꝯꝢ꜒ꜟ꜎ꝢꝻ꜏꜄꜉꜕돕꜅돘꜃돇ꝳꢚꝤ꜐돈돉ꝳ꣦돍ꜗ돐ꜘꝹ꜅돈ꝵ돆ꝺꜘꝲ꣧ꝣꝣꝳ꜂돆꜉돎ꝲꝣ꜏ꝯꝁꝚ꜒돂ꝴꝢ꜉돃도꜏ꝷꝿ돃ꝷꝼ돎ꝁꞦꝲꝰ꜄ꝷ돂꜐꜓Ꝯ돂돇ꢜꝻ꜃돕ꝺꞦꜗꝺꝵꜥ꜔ꢚ돂Ꝼꝯ꜒꜎ꜙꢛ돈ꝷ꣡ꝰꝤ돎돕꣦꜅Ꝡ돎Ꝺꜘꜘ돕ꝼ돘돇돘꜔ꝼꜥꝩꜟ꜉꜄Ꝣꝺ도ꜙꢛ돃돆돈Ꞧ돎ꜥ꣦ꝵ돈ꢚꝺꝲ꜃꜅꣦돃Ꝥ꜒도돎ꝵ꣧ꜥꝺꝵꜥꜙꞡ돘꜎ꝣ꜔ꝼꝤ꣦꣭ꢚꝮ꜄ꜟ돐Ꝼꢞꝲꝳ돃Ꝁ돈ꢜꢞ꜂돇ꢜꝤ꜎돆돕꜅돎꣨돆ꞡꜟꞡ꜅ꝚꝹ돃ꝠꝼꞦ돏Ꝛ돆ꝵꝤꝿꝹꝸ꣡ꝵꝺꝣꢞꝺꜟꝀꝻꝁ꜐돏ꝺ꜔돃돏ꝣꝵ돐돂꜏Ꝡꝺ꣨Ꝺ돘ꢚꝀ돐꣦ꝩ꜒ꢛ꣡돉Ꝼ돕ꢚ돕ꢛ꜐ꝁꝠ돐Ꝯꝺ돏ꢞ돍꜉ꜥꢞ돃꜐ꝰ꜔꣦ꝢꝾꝸꝲꞡ돕꜒ꝸ꣡ꝰꝩꢜꝀ돎꣦꣭ꝤꝠꢞꝩꝁꜟ돃ꝹꝩꝹꝸ꜎꣡ꜗꝳ꜒ꝢꝀꝣ꣨돐꜅꣧ꢜꝷ꜏돃꜂꜔ꝩꝠ꜉ꝲꝷ돕돈꜕돈ꝵ꜐ꝷ꜎Ꝼ꜄ꜗ꜓Ꝛ꜂도ꝯꢛ꣧꜕꜐꣧ꝁꝯ꜐ꝵꝼꞡ꜕돇ꢚ돏돕꜎ꝿꝴ꜏꜂ꢚꝻ돏ꝩꝰ꜂ꢛꝰ꜎ꝀꢞꝸꝢꜥꝀꝼꝴꝿ도꜕돍꜉꜎꜒ꝰ돎ꝸ돕꣡ꝵꝾꝩꞦꝷ돇ꝼꢞꝩ돐Ꝛꝳ꜕꜎돏ꝲꝤꝹꝸꝩꝼꝾꝺꜟ돕ꢛ돘ꝁꜗ도ꜟ돉ꝴ꜉ꝲꞦꝚ돃Ꞧ꜃돍돂꜉ꜘ꣨꜐ꢚꜗ돈돏Ꝁ돕꜂꣧돐꜕Ꞧ돉ꝣ꜅도ꢞ꜎돉ꜗ꜎도ꝰꝲ꜅꜒ꝁ돐돏Ꝣꞡ꜂꣦ꝰꝤ꜎ꜙ돏ꢛꢜꝺ꜄ꜙ돍꣦ꝸ꣨ꝷꝿ돎돃돍꜔ꝴ도돍꜃ꝸ꣦Ꝣꝣ돏ꞡ돆Ꝼ돎돎ꝳꜘꝚꝷꞦꝳ꜐Ꝯ꜎ꝳ돂ꢚ도도꜃ꝰꜙ돎꜏Ꝯꝣ돆꜏ꞡꢚꝣꝳ도Ꝡ돃도돏꣦도ꝵꜗꝸꝁ꜕ꝚꝾ꜄돈꜄ꝼ돉Ꝡꝴ돆꣦돍꜓꜐ꜥꢚꢚꝤꜙ꜂ꝰ꜐ꜙ꜏ꝼ돂ꢛ돐Ꝛꝸ돂꣦꜅ꝸ꜉돍Ꝣꝵꝲ돃Ꝁ돏Ꝯ돃돘돍ꢜꝼ꣦ꝁ돎돏ꝯ꜉ꝳꝴꜟ꜏ꝲꝰ꜉ꜗꝠꜙ돎꜅ꢜ꜂꜂ꝸ꜅ꝵꝰꝴ꜓ꝚꝢ돇돃Ꝛ돇꜓돇ꜘꝴꜗ돎도꜄꜕Ꝼ꣧ꝲ꜐Ꝁ돉돇ꝣ꜏ꝵ꣭ꝸ꜐꣨돈ꝷꝺ꜉꜕꜃꜅꣡ꝁꞦꝼꞡ돇꜄ꝀꝲꝹ꜃돘ꜗ꜉돃돐ꜥ꜂ꞦꢜꝀ꣦ꢞꜙ꜓ꝣ꜕ꝤꝀ돂ꝸ꜉ꢛ꣦ꜘ꣧ꝵꝤꝩ돆ꜗ돂ꢚꝹ꜒도ꝴꜙ꜐꜄Ꝥꝣ돇꜕ꢚꝻꝣ돍꜉ꝷ꜐꣭ꝯꜗ돕꣧꜉ꢚꝾ꜕ꞡ꜎ꝿꜗꝩꝵ꜏돕꜅ꢜꝠꢚ돇ꢚꜗꜗꜥ돃ꝼꝁꝳꜗ돐Ꝼꝩꝴ돃꣨ꝹꝮꜙꜟꝵ꜒ꜟꝲ꜂ꝯꝣ돍ꝁꜘꝣ돈ꝿꝁꝀꝺꝢꝺꞦ꜅Ꞧ꜅돍돂Ꝥ도꜏Ꝁꜙꝩ돐ꝁꝰꝁꝳ꣭ꝺꝣꝲꝳꝷ돃꣡Ꞧ꣧ꢚꝳꝰ돇돇ꞦꝩꞦ꜔꜅Ꝯꞡ꜔ꝩꝀ꜄꣭ꝩ돂꜉ꢚ꣦꜔꣨ꝠꜙꝻ꣧ꢞ꜒꣨ꝳꝚ돐Ꝺ돂돈꜒도꜏ꞡ꜄Ꝺꢞ돘ꝷ꜒돕도꜎ꢛꢚꢞꝹ돇돕ꝻꝷꜟꝤꝷꝸ꣦ꝴꝯꢚ꣡돐ꞦꝩꝿꝷꝮꢜ꜕돃Ꝡ꜂ꞡꝰꝸꜟꝯ꜓ꝵꝻ돇ꝩ꜃꣧ꢜꝼ꣨돉돍돂꜅꣦꜎ꝵꝾꜥ꣡ꜟ꜐ꝼ꜉꜕돂꜐꜏꜓꜅ꢛꝺ돆꜅돎꜎돆ꝁ꜅꣨돃Ꝣꜟ꜕꜂꜃ꜘꝹꝺꜥꝿ꜂ꝺ돇돈꣭꜉ꝳ돘Ꝯꝳ꜐ꝼꝮꜥ돇Ꝣ꜄Ꝺ꜓돏돃ꝁꝿꝳ돍ꝰ꜐Ꝿ돍꜏ꝤꝲꝠꢜ돉꜓ꢚ꜅돉꜅ꝺꝀ돈ꜙ꜕ꢜꝮꝣꜘꝯꝼꝲꝤ도ꜥ돂꣡돐ꝳ돃ꜗ꣭꜅돇Ꝼ꜉꜂돈Ꝯ꣦꜒꜉Ꝁ돐ꜥꝾꝰ돘ꜘꝻꝮ꜐돕꣧ꢚ돃돕꣡ꝴꜥ꣭돃ꝼ꜄ꜥ꣦ꜗꜥꝰ꣭꜂ꜟꝢꝮꝼꝲ꜎꜂돉꣭ꝣꝷꢛ돕ꝻꝾ돕ꝰ돕Ꝛꝵꝷ돉ꝸ돏도ꝸꝣꝵ꜎꜒Ꝺ꜎Ꝛꝯ꜒ꝣꝼ돏꜄ꢜꢞꜟ돐돂ꢛ꜎돇ꝺꜟ돈ꝁ돏꜄돏ꝣ꜔돃돇Ꝺ도돈돏꜔ꜥꞡ꜓꜎꣧ꝯ꣦꜄돐돕ꝳꜘꜙ꣧돉ꢛ꣦ꜟꜥꝩ꜓꣭ꜗ꣡꣭ꝁꝤꞦꝺ돏ꞡꝀꝻꜥꝩꝚꝸ돍ꢞ꜏ꞦꝾꞦ꜓꜓ꝣꞦ꜏ꜥꜘꝿꝴ꣭돉돍꜂ꝷꜘꝮ돉Ꝡ돆ꝮꝚ꣧꣡돃돂돍ꢚ꜒꣭도꣡ꝯ돍ꝯ꜂ꝼꜙꜟ꣧돈꣧ꝿ돏ꝲꝵ꜔ꝳ꣡ꝁꝴꝸ꜓ꜟꝩꝩꝻꞡ꜅Ꝁ꣡꜉ꢚꞡ돕돂꣦돎ꝴꢜꝷ꣧돘ꝲꝮ꜎돂ꜟꞦꝁꝵ돃Ꝁ꜎ꝷꝼ꜏꜄꜄돎돘꜓ꝸꝩꢛꝢ꣭ꝸ꣧꜅ꝚꝹꝴ꜅돕돘꜐ꜘ돍꜃돇돇ꢚ돉돐ꢛ돈ꜙꝵꝺ꜅꜎꜎ꢞ꜕ꝾꝯꝾ꜔Ꝛꢚꝺꝿ꣨Ꝯꜥ돘꜏ꝿ꜅꜎꜓Ꝿ꜐ꝯ돇Ꝁ꣭ꞡꞡꢛ꣦돂돘ꝠꝣꝠꢛꝣ꜎꣭돂꜎꣭꜉꜃돂ꝣ꜐꜔Ꝥꜗꝸ꜓도돘Ꝿ돎ꝁ꜕ꢞꝸ도ꢞ돇ꝷ꣦ꜥꝿꝾꝣ꜔꣡꜒ꝲ꜕ꢜ돆ꝼꝯ돍ꜙ꜉돘ꜥ꜔ꝁ꜐꣦꣨ꝷꢚ꣡ꝣꞡꝣ돉돍돘ꝾꝢꝤ꜐ꝵ돇꣡ꝩ꜐ꝷꝚ꣡도꜃ꝺ꣧꜒ꝲꝠꝲ돇꣭Ꝁ꜅꜂돈Ꝁ꣨꜐ꝺ꣡ꢚꝳꝴ꣦ꜟꝁꝀ돃ꜥꝰꢚꝀꜗꝀ돂ꜟ꜏ꝁ돘꣡꜂ꢜ돘ꝰ꜓돃ꝳꢛ꣨돈꣦ꝠꝁꝀ꜂돆돃꣭Ꝛ꜒ꝲꝼꝤꜟ꜃Ꝣꝳꝵꜗꝴ돐ꢛꜙ꜄Ꝡ돂Ꝥ꜅꜅ꝼ꣧돂ꢞꝠꝵ돂Ꝺꢚ돇ꝲꝳꝚ돘ꝳꝀꝰ꜄ꝰ꣧ꝮꢚꝚ꜂ꞦꜘꝀ돘돈ꢞꢚꝁ꜄ꜗꢜ꣧돇꣧꜉꜔ꞡ돎꜎꣨ꜘꝚꢜꝲ꣭ꢛ꣭꜏ꝮꝾꝣ돘돎ꜙ꜓Ꝛ돈돎도돏Ꝛ꜕꜉ꝿꢜ돆ꝵꝹ돈꣨돈ꝵ돘꜐꣦돕ꝳꜙ돈꜓꜄꜕꜕꣭도돃ꝵꝣꝚꝤꝴꜥ돏ꜙꝺ돂Ꝡ꣨ꝯ돐돍꜄ꝿꢛꝁꝮ꜏꜂ꝣꝴꢜ꜄꜎ꝷꜘ꣭ꝯꢜ꜓꣨ꝸ꜐ꢛ돘꜎꜂꜃돆Ꝥꜘ꜄Ꝼ꜅ꝼꝴ돏Ꝼ돍Ꝡ꜒ꜙ꜐ꝳꝾ돘꜉ꢛ꜕ꝿ꜓ꝁꝳ꜕ꝮꝠ돇ꝯ꣧꣡ꝵ돆Ꝡꝁꝁꝿ돍ꜘ꣭ꢞꜥꢜꝤ꜐돆Ꝯꝴ돈ꝩ꜉ꜙ돕돂ꝷꝲ꣦돈Ꞧ꜓돇ꝀꝻ꣡ꝲꝵ돘ꢜꝷ돇ꝠꜟꝰꝤꝲ꣡꜏ꝰꝴ꜐Ꞧ꜔ꝰꝾꝾꜙ꜎ꜗꝁꢜꝮ돈Ꝯꝸ도Ꝯ꜃돏ꝴꝺꝻ꜃돂ꜙꝺ꜕ꜟ돈ꢞ돍Ꝣ꣡돃Ꝣꝵꜘ돈ꝵ돇도ꝺꝳꝀꝿꢛꝾꢜꝁꝾꝳ꜂꜕ꝸ꜉ꝼꜟꝹꜟꢜꝚ돆돇ꝺ꜔ꜘꝳ돘돃ꢚꝩ꣦꜂돉Ꝛꝣ돆돇꜂꜓ꞡꝚꝳ돃꜃ꝸ꜔ꝼ꜔꣡ꝚꝩꝾ돐ꢞ꜓Ꝡ꜓ꜗ꣨Ꝛ꜓꣦꜏꣨돏도ꝢꝰꝾ돍꜔돈돎ꝀꝻ꜒ꝸ꜅꣧ꝰ꜏Ꝺ돐ꝩ돘ꜟꝢ꣦ꞡꝳꝻꝳ돘꜒Ꞧꞡꝰ꣭ꜟꜙ돈ꝳ돕꣨꜓ꢞꝢꝰꝼꝁ돉ꢜ꣡꜔돇돕돎ꝴ꜔ꝿ꜄ꜟꝠ꜔ꢜ돂ꝺ꜃ꝴꝸ돃Ꞧ돉꣭꜓돂꜃Ꝡꜥ돕ꝲꜥꝴ돂돎Ꝛ돏꣧Ꝛꜗꝣ도ꢞ꜎ꢚ꣭ꜙꜗꜙꝿ돍ꝲ꜐ꝿ돐ꢜ꣦ꝿꝾꝵ꣭꜒ꝳ꜔ꝴ꣡꜎돕꜓돎꣧돇꜓꜐돈Ꝣ꜔ꢛꜟꞡꝚꢛꝩꢞꝩꞦ꣨ꝼꝢ꜒꜄Ꝼ돇돍꜓돍ꞡꝁꝀꜘ꣡ꝺꝢ돏ꢛꝯꜗꝲ꜅돍돕꜔ꜙ돎ꢚꝮ돂꜐ꝩ꜐돇ꝷꝮ돇돎ꝻꜥꜙꢛꝤ돂꜐꣨돂꜕꜂꜅꜃돇돉꜕ꝵꜘꝚ돉돂ꝴ꜓돕ꝢꝩꝣꝻꝁ꣡ꝳꝢ꜎꜐꜔ꜘꝣ도돏돐ꜘꢞꝯ돐ꝩ돃꣧돃ꝼ돕Ꝼ꣧ꝁꝠꝻ꜄돍돂ꝼ꜄Ꝁ돂도Ꝿꝵ돏ꢚꜟ꜃ꝯꝀ돂돎돐돈돆돐돆ꝲꝀ꜏ꝣ돕꜅꜎ꝺꝼꝹꢞ돃돃꜎돆ꢜꜙꝁꢜ꣧ꝲꜥꝸ돐ꢜꝣꜙ꜔ꝿ꜉Ꝺ꜓돈꜔꜎ꝺ꣧ꢛꝲ꜓ꢜ돃꜓꜅돏꣧돏꜂ꝿꝢꢞꝳ돏꜔ꝳ꜐꜒돍ꢞ돍ꜙ돍ꝼꝮꜟꜘꝣꢚ꣧꜔ꝁꝳꞡ꜕돂ꞡꝷ꜔Ꝥꝁ꣦ꝺꝤꞦꝀꜟꢜ돎Ꞧ꜉꜔ꝳꜗ돆ꝵꝴ꜉돎돍꜎ꜗꝼꝩ꜎ꝿ돇ꝣ돂ꝲꝁ돉꣦돇ꝷ꜓ꝷ꜐Ꝡ도꜏ꢞꜙ꜕돍꣭꜏꣧꜕ꝷꢚꢚ꜂돂Ꝁ돎꣦ꝴꢚꝣꝻ꜅ꝺꝤ꜏도돇ꝵꜙ꜎꜕ꜟ꜅ꢞꝢꝴꝸ꣨ꝵ꣦꜓ꢚꝚ돕ꢜ돇ꝁ꜎꣭꜐ꝳ돇돂ꝿꞦ돂꣦꜉꣨꜐돇ꝯꝴꜗ꣧꜐ꝰꜘ꜕꜕돏ꝤꞦ꣧꜐돏ꝵ꜕ꝺ꜐ꝣ꜃ꝴꢞꝻꜗꝩ돎Ꝥꝸꝁ돘ꝲ꣦ꝿꝯ돎돎ꝁꝠ돐ꜘꜘꝳ도ꝿꢜꝁ돃ꝿ돍Ꝼ꜅ꝣꝵ꣡ꢜꝢ꜒꣡Ꝯ꜅꜎Ꝛ꣭돕돂꣨ꢜꢜꜥꝤ꣨꣨ꜘ꜕ꜟ꣭Ꝡ꣦Ꝼꜙꝿ꜐ꜙꝀ돃ꝵꢜꢚ꣧돂돈ꝲ꜎Ꝿ꜒꣦Ꝡꝁ도꣧돈Ꝛ돕돘꜅ꜟ꜃꜉Ꝿ꜅꣭ꝻꝿꜗꝮꝸ돂ꝷ돎ꝰꞡꝹꝿ꣭꜉꜉ꢚꜥ꜎꜓ꝴ돆ꝺ돉꜎꜏ꝵꝼꝤ돕돇꣭꜓돉돘돐ꝵꝻ꣭돆꜔ꝳ꜒돃ꝺꞡꞡ돃ꢜ꜂꜒돂꜓ꜘ꜓꣧Ꞧꜗꢞ꜂꣧꜔꜉꜄ꢞꝤ꜃ꝰ꣭돇ꜘ꜅꣨꜅꣡돈돕ꜟ돐꜉ꜟ돉ꝺꝲ꜂Ꝡ꜐ꝵ도Ꝥ돈ꝲꝺ돘ꜟ꜎돐꜒ꢞ꜅꜉ꜗꝿꝳ꣧돇도ꜙꝤ꜏꜕ꝣꝤꝁ꜎꜄ꞡꜟꝯꝰ꣨돈꣭ꞡꜘ꣡꜄돆ꝴ돈Ꝥ돂꣨돆꜐ꝿ꜄Ꝺ꜅돏ꝯ돇꜐ꜥ꜃꜂꜄돎ꢚ돍꜏돃꜒돆꜄꜔꣭돆ꝁꝴ돍꣨꜎꜎ꝰꝸꝲꝠꝳꜥꝼ돕ꝮꞦ꣦ꝷ꜃도Ꝛ꣧돃Ꝥꢜꝳꢜ꜃ꝿꝁꝤꜟꢚ돉돇Ꝛ돉돆꜐Ꞧꝸ돏돉ꝲ꜉Ꞧ꣭ꝼ꜐ꝁꢚ꜓ꝵꝳꝣꝳꝺꢞꢜꝠ돃돕꜉돈Ꞧꢞꝸꝴ꜓ꝁ꜂ꜗ꣨도Ꝼꝿ꣨ꝼ꜒ꝺ꣧ꢜ꜒ꢛ꜅꜒Ꝿ꜎ꢚꢛ돎돕ꝺ꜕돃ꝸ꜂ꝿꝾ꜅Ꞧꜥ꜒꜔ꝼꝯ꜔Ꝛ꜄돕돕ꝸꜥ돐돇ꜟꝼ꜓꜃ꝳꜙꝰ돏Ꝥ꜎ꝴꢛꝼ꜐ꝩꝵ꣨ꝳꝿꢜꝣꝣꝹꝺ돘ꝯꝣ돐ꜗꜙꝼꝸꝸ돈돇ꜥꢛꞦ꜉ꝷ꣡꜓꜉Ꝥ꜅꜐ꜗꜟꝯ꜄ꜥ꜔ꝵ꜎ꝰ꜂Ꝡꢚꢛꝳ꜄Ꝣ꣡ꜥ돃ꝿ도꜎Ꞧꜟ꣡꜃ꝷꝯ돆돈꣦도꜒Ꝡ돏꣭꣨ꜘ돆돆ꜥꝢꝁꝠ꜐꜒Ꝿ꜐꣡꜃ꜟꢞ꜓ꜗꝹꞡ꜉ꜗ돂돈ꝴꢞ돘ꜗ꜒ꢚꜥꝳ돎꣧돇Ꝿ도Ꝥꝼ돇꣦ꝠꝀ꜎꜉ꜥꜟꝲꝳ꜕돃꣡Ꝼ돐ꜗ꜎ꝷ돇ꝸꜙ꜏ꜟꢞꞡꝳ꣧ꝣ꜐ꝲꜟꝸ꜒꜄Ꝼ꣧꜉ꝿ꜅ꝸ꣭ꝴꞡ돎돉꜐꜂꜔ꝲꝹ꜏꣧ꝵꝼꞦꞦ꜕ꢞꢚ도ꝴ돕꜔꜒도ꜟꝻꝻꝣꝹꢜ돎돍돇ꝼꝾꝲꝩꝷꝀꝠꢞ돏ꝢꝮꝴ꜄ꝷ돘돃꣨ꜥꝰꝿꝺ돇ꝤꝁꝚꝣꢞꝷꝢꢞꝤꝚ꜉Ꝡ꜏도꜔ꝩ꜏돆꜐도돘ꝻꜙꝚꝾꝼ돕ꝰ꜕꣦돃Ꝿ꜉꜔꣭ꢛꝰ꣨Ꝣꞡ돍꣦ꝩꝷ꜃돆ꝰꞡ꜏꜔꜅꜓꜓ꝵ돈꜂돐ꜟ돕Ꝥꝵ꣨꜉Ꞧ꜄ꝩ꣭Ꝁꝁ꣡꜐꣧ꝸ꜃도ꜥꜙꝲ꣨ꢞ꣨Ꝁ꣭Ꝡꢛꝯ꜏꜔돈ꝸꝮꝚ꜅꜎돇ꜥꝷ돎Ꞧꝣ돃돐ꝸ도ꢚ꜐돘Ꝼ꜎ꝯ꣭꣭ꝮꝷꝀꝁꞦꝳꝣꝹ꜕ꝩ돆ꝩꝺ꜅Ꝛ돏돍꜃꜕ꝾꝀ꣦꜄ꝩ돇돕돇ꝁꝼ꣡ꝷꝮ꣦꜔ꜥꜥꝚꜟꝮꝮꝰꢜ돐돏ꞦꝮꝯ도돎ꝴꝢꝣ도ꝣꝮꜘ돐꜕ꝚꝁꝺꝚꝯ꣭돂ꜗꢞꝀꝁ돕돉꣧Ꝯ꜅ꝺꜗꝢ돂돉ꝣꝹꝵꜘ꜅꜔돇꣦돕꣭꜒ꜙꢚꝿ돆Ꝣꝷꝿꜙ돃ꜟ꜕돆돇ꝯꝚ꜒꣨ꝩ꜏도ꢚ꣧돆ꢞꜥ돇ꝯꜙꝾ돆도도도ꝩ돘ꝁ꜅ꝣꝀ돐ꝯꝩ꣦ꝰꜙ돆꜅꜅ꢛ꜐꜔꣡ꝼꝚꝸꢚ돏도ꜙꜗ꣡꜔Ꝺꝵ꜎Ꝼꢞꜙ돘ꝿꜟ꜄ꜟꞡꜥꝾ꜐ꜗ꣦꜔ꢚꝹ돃Ꝥꝺ꜎ꝳꝯ돐꜉ꢞ돎ꜘ꜓돍ꜗ꣭Ꝁ꜔ꜗꝰ꣦돈ꜙꞡ꣭ꢛ돈돂ꢜꝴꝩ돐ꝮꝠꜙ꜉돎돐Ꝿꢚ돉ꝲ꜂ꝼ꜒ꝵ꜃꜐ꝲ꜅꣧ꝯ꣨도Ꝼꢛꜟꢜ꜂돈Ꝛ도ꞦꝻꝲꝻꢛꝼꜙꜥ돆돂ꞡ꜄꜂꜄꜔꜅ꢜ돍돐Ꝿꝩ꣡ꝣꢚ꣦ꝵꝵꝰꜗꢛ돘ꢛꝷꝸ꜔ꝀꝸꝢꝵ돎꣦ꜗꢞ꜒꜕ꝀꝻꝳ꣧ꝩ돕돕돉돘ꞦꝠꢜꜘ돏꜒돇돈돐돕ꝵ꜐꜕ꝩꝿ꣡ꝩꝷ꜔ꝯꝼ돎ꝣ꜓Ꝿ돘Ꝺꜥ꜓ꝳꞦꝰꜟꝀꝻꝸ꜎ꝷꝤ꜃꣭ꢞ꣦꜕꜅ꝣꝵ꣡꣧ꝺꝚꝿꝾꝠ꜏돍ꝴꝺ돎꣨ꝷꝵꝣ꜔ꝴ돇ꝰ꜎ꝷꢜ도돇꜅ꜥꝸ돆ꝣ꣭꜏ꜘ꜒Ꝛ돉돐꜓돎ꝰ꣦꜏Ꝥꝴ꜕ꝯꝣꝵꝵ꜅Ꝿꝸꝩ꣭꣨꣧Ꝥꢛꜥ돇꣭Ꝥꝼ꣭ꢚ꜕ꝵꞡꜙꜙꞦꝯꝳꝼ꣡ꝮꝮꝰꝠꢛꝵꝲꜟꝚꝁꝀꢚ꜓돂꜔돘ꝿꝳ꣭꜒돆꣦Ꝡ돍ꝺꝠꜥ돉꜃돈Ꝛ돎꣭꣭ꝲ꣧꜐ꜗꢛ꣭꣭ꝣ꣭ꝣꝣꝷ꜔ꜟ도꜏Ꝣ꣨ꢜꝳ꜔ꝿ꜓ꜟꝼ꜔꣡꣦돉ꝰ돎Ꝺ꜄ꝢꝿꝤ돕꜔돇Ꝿꜟꝷ꜉Ꝡꜥ돈꜔ꝲꝚ돃돐ꝲ꜔ꝰꜟ꣦꜂Ꝥ꣭꜏ꝁ꣧Ꞧ꜂ꜥꝹ돆ꝵꝲꢚ돎꜓꜐꜄ꜘ돍Ꝿ돎ꝵꝤ돆ꝲꝚꝰꝼ돏꜕ꝲꢚꝿ꜏ꜘꝮꝴꝾꢚ돉ꝩꝼ꜎Ꝡ돂ꜗꝸꝢꝺꞦꢜꞦꜙꜘꝳ꜅꜔ꝷꝲꞡ꜔꜏ꝷ돂돕꜒ꢚ도ꝩꜘꜥ돂Ꝣꝣ꜎돏ꝵꝾ꜕돐ꝷꝵꜘ돘돆ꢞ돆ꝩꝸꝰ꜂ꝷ돕ꢞ돂ꢚ꜓꣦꜔꜅돆꜃도ꝼ돇꜄돕ꜟꝷ도돆ꜟ꣧도ꝷꝻꞦꜟꜟ돏ꝁ꣡꜕ꢞꝻꝾ꣧돕Ꝁ꣭ꝴꢞꝸꝣ돃ꜟꝤꝺ꜂ꝀꝮ꜒꜂꣭Ꝛ꣭꜓ꢞꝮ돇꜏꜎ꢞꝵ꜉ꝳꜘ꜒Ꝁ돏ꝚꝠ꣨Ꝥ꜒돃ꜘꝼ꣧돐꜃ꝿ돃돘돉돈꣦ꝚꝷꝀꝮ돐Ꝛꝳꜥꝯꝿ돍ꝴ꣦꜕꜏ꝵ꜅돎ꝁꝾ꜕돕Ꝣ돉돐꜐ꢛꝴꝤ돐꜏꜔ꞦꝢꜘ돂꣧돕돇ꢛ돇Ꝛ꜓돆ꜥ돂꜏ꝸꝤꜟ꜐ꝯꞦ꣦ꞡꝾ돘ꝷ꜄Ꝣ돐돈ꝵ꜄Ꝡꢜꜙ꜔꜏꜕돃ꝁ꜂Ꝁꢜ꜄ꝵꝴꝮ도도Ꝿ꜎ꝸ꣨ꝿ꜉도ꜗꞡꝠꞦꝀꝯ돘ꝴꝻꝾ꜏ꢜꝩ꣦돕ꝼ꜔꣡꜐꜄ꜘ꜄돐돈돈Ꝿ돎Ꝿ꣦ꝰ꜃꜐꜉ꝚꝻ돐꜅ꝩꢞꝢꜗꞦ돉도Ꝼ돇ꝲ꜎꣭ꜘ꜔돆돍꣧돍돈ꜙ돈돎꜎꣧ꝾꢜꞡꝴꝹꝚꝸ도꜄ꝁꝴ꜂ꝴꝠ꜎ꜗ꜃꣭꜃꣨ꝿ꜉꣦Ꞧ돉ꝯꝿꝳꝸꝣ꜒ꜘꝲꞡꝁꜙꝷꝸꢛ돇ꝿꝠꝺ꜓ꢜꝸ돂돍돏돇ꜟ돕ꢜꝀ꣨ꝁ꜂꣨Ꝡ꜄돆ꜘ꜃ꢚ꜅돉ꢚꜟ돉ꢜ꣡ꝁ돍꜂돂ꝺ꜎ꝵ돆돘ꞡ꣭ꝳ돉돇ꞡꝩꝺꝤ꣧꜕ꜗꜗ꣧꣭Ꝛ꜃ꝵꝰꢜꝺꝸ꜒꜄돈꣡ꝯꝤ꜓ꝼ꜓꜅Ꝡ꜄ꝲ꣧꣨Ꞧ돕ꝰ꜓ꝷ돆ꝩ꜓돕ꝻꜟꝚꝮꝁꢜ꜂ꜘ돏꜓ꝣꝸ돐ꝷꝢ꜂꜃ꝁ꣡ꝩꝵ도ꝺꜘꝁ꜕꣡Ꝛ돎ꢜ돏꣭꜃꜎꜕돆꜉꣡꜂ꝤꢞꝢꝁ꜄Ꝡ꣧돇Ꝛ꜄Ꝣ돈꜂돏ꝮꢛꝢ돂꣦꣭Ꝡꝯ꜔ꝼꝀꢞ꜅ꝩ꣦꜂돂돎꜔ꝷꢚꝵꝁꝻꢞꝼ돍꜎ꢜ꜏ꝷ도꣧ꢜꝲꜟꝮ꜂ꝸ꜕돂돉Ꝯꜥꝁ돆ꝳ돇돉꣨Ꝺ꣧ꝁ꣧꣭꣧ꝣꝯꝠꝳꜙ꜅돈ꝢꝤ돃ꜥ돇돈ꝼꢜ꣦ꞡ꣧Ꝥ꣦ꢞ꜂ꝴ꜃Ꝣ꣡ꝣꝯ돘꣧ꞡ꜎ꜗꝮꝀ꣭ꢚꝾ돐ꝷ돕꜎ꝳꜗ돎Ꝡꢛꜥ돃ꝮꝢ돐ꝣꜙ꣨Ꝺꝿ꣦ꝸ돈ꝁ꣨돐ꝩꝰꝴꢛꝤ꜔꜃Ꝡꢛ돂ꝷ돃Ꝣꝰ꜅돃Ꝡ꣡Ꝣꝴꝳ돍돉ꝷ꜓ꜙ꜉꜉ꝵ꜎ꝴꢚ꜃ꢞ도ꢞꜗꝤ꜃돍돂돏ꞡ꣭Ꝯꝿꞡ돆ꜥꝵꝮꝳ돎ꢞꝷ꣧Ꝥꝺ꜃꜓돆Ꝣ꜒ꝤꝚ꜎돕ꝴ꜏ꝿꝚꜥ도꜒Ꝁ돏돐Ꝺ돘ꢛ돍꜄돏ꞡ돎Ꝣ돃ꝳꝸ꜕ꢜ돘꣧Ꝛ꜃꣧꜎ꜘꝰꢛꞦ꜅ꜥ꜅꣧ꢜ돆Ꝯ돇돘꜎돎ꝁꝤ꣧돕도꜒ꢞ꜏꜔ꢛ돎꣧꜏ꢞ돆ꝣꜙ꜒돐꜄Ꝥꜗꝷ돍돎ꝵꝤ돏ꜙꝼꝳꜘ돏꜎꣭Ꞧꜗꝷꜥꝷꜘ꜒Ꝡꝺꝼꢚ꜔돕ꝸꜙ꣨ꝳ꜅꜒ꝹꝻ꜕ꝯꝲ꜅ꢚꝣꝴꞦ돈ꝣ꣡ꝺꝰ돘돂ꝵꝷꝺ돕돈ꜥ돍꜎돇꣦꜒돇돆ꝷꝰꝢꝁ꜂ꞡ돐돘꜔꣦돕돐ꝸꢞꞡꢛꜗ돎돃Ꝁꝯ돈ꢞꝯꝠ꜏ꞡꝠꢜ꜉돎Ꝡꢛ도돆꜂꜂돘꜕꜄돏돃돇돃ꝠꢛꜘꝻꝲ돏ꜗ돆ꝳꝚꢞꝰ돘돃꜅돐ꜟ돇꜏ꝰ돇ꝺꝵꝯꝁꝲ꜏도도돃ꝲꝸꝤ돐도Ꝁꝁ꜐ꝁꢜꝾꝮꝚꝮ돍꣭ꝴꝠꜥꢛ꜐ꝩꢚꢜꝳ돇돉돆돎돈ꜗ꜂ꜟꞦ꜐ꝳꢚ꜂ꞡ돍꜐Ꝣ꣨돆꜐Ꞧ꜄ꝰ꣨Ꝁꝸ꜉돕Ꝛꜥꝺ꜓도꜔꜐Ꝺ꜏꜔ꞡ돐ꝣꢚ돎꜄꜄돉ꜘꝩ꜅돃돕꜄꜂꜓꜏돉ꝯꝻ꣭돏돈돏ꜟ도꜃ꝷꝼ꜂꜄꣧꜔ꝵꝳꝀ꜔ꝯ도돇Ꞧ꣦꜄Ꝿ돍꜃돉도ꢚꝩ돘ꝤꝹꝚꝺꝹꝲꢜ꜒ꞦꝢꝣꜘ꜂ꝤꝢꝚꝣ꜂Ꝥ꜓ꝸꝵ꜎꜄꜅꜂꜔ꜗ돃돈ꝸ돏돆Ꝣꝵ꣭꜄꜕돕ꝵ꣨ꢚꜟ꜕꜐ꝵ도ꝵ꜐돕ꞡꝠꝾ돃ꝩ꜅꣦ꝰꜟꝯꝢ돍꜕ꝣꝼꝴꝹꜘꝀꝚ도돍ꝩꞡ꜓Ꝥꢚ돎ꝴ돐꣨돐돇돏ꜥꝚꝳ돏ꜙꜥ꣦ꝼ꜒돎Ꞧ꜉꜓꜎돃ꝼ꣡ꜗ꜐꜏ꜙꝸꝺ돇ꝸ꜐ꝷ꜐돇돏ꜟ돉ꝳ꜏ꝤꝵꞦꢜ꣧ꝮꝹꝁꝷꢜꝴ꜓ꜥ꣦Ꝁ돇꜏꜅꣭ꝩꜟꝹꢚ꜕ꝳ돇꜂ꢛ꣡ꝷ꜕돂돈꜕꣧ꜗ돂꣦ꝷ돍꜏돍꜒ꝷꝀ꜂꣨꜒ꞡꢜ돇ꝢꝻꜥꞡꝩꝿ돇돉꜐ꢞꝰꝰꢞꢚꝣꢚꝠꝸ돆Ꝁ꜎꜄Ꝼ돍돎돈Ꝁ꜃ꜗ돂Ꝣ돐꜂ꜥꝣ돏돍ꝳꝠ돈도꜕ꝳꝳ꣧꣨Ꝥꝼ꜉꜔돍꜕ꢞ꜕꣦ꞡ돐ꝵ돆ꝺꝮꝣ꜅ꝲ돉돃꜃ꝮꝾꝚ돘ꜙꢛꜗꝳ꜏돆꜐꜏도돉꣭Ꝥ돉ꝠꝚꝴꝣ돎꜅ꞡꝠꝲ꜏돘돉꜂꣡꜏꜓ꝲꝢꝲꝻꝻꝵꝩ꜂꜂Ꝼ꜉꜃ꝷꢜ돆ꝿꝼꢞꢛꜟꜘꝮꝿꢞꝰꜟꝢꝠ꣭ꝸꜥꝹꝁꝣꝼꝾ돕꜎ꝸ돎돃돘돏ꝻꝮ돇ꝿ꜄ꝼꝮ꜂ꝣꜗꝺꝤ돈꜔꜅꜏꜎돏ꢜꜟꝠꜗꝰ돎도ꝸ꜏꜅ꞡ돆돈꜅꜎ꢞꝤꜥ꜃꣦Ꝼꢞ꜕ꝚꝠ꜉Ꝿ꜔꜃Ꝣꝿ돘ꝸ꣦꣦꜐꜓ꝩ돎꣡ꝿꝾꜗ꜕ꝺꢞꝠꝯ꜅Ꞧ꜒Ꝥꝺꜗ꣨돕Ꝿꜟ돂ꢚ돎꣨ꝲꝼꝾꝼ꜕꜎꜎ꝩ돕돐꜃꜒ꝣꜥꝸ돐꜅돃꣭Ꝼ꣨Ꞧꞡ돇ꝼꢞ꜓돆ꞡ꜕꜃ꢜꢚ꜏ꝿ꣡돂꜉ꝲ꜏ꝵ돉꜉Ꝡ도꜏꜓Ꝯ돎Ꝁ꣦Ꝣ꜕돆돉Ꝣꝳ꣡Ꝣ꣡Ꝥ꜔돏ꜗꢚ꜔돎꣦ꜘ꜒Ꝛꜗꝺꜥ꜎꣨꣡돐꣭돉ꢞ돇꜒꜒ꞡꝢ꜂ꝼꜙ꣨ꢛ돃ꝴꝚ꜔ꜘꜗ꜐Ꝼꝩ꜕Ꝯ돎꜃꣨꜓Ꝥ꣭돕돏돃돘Ꝺ돃돕ꝺ꜒돎꜐ꜘ돈Ꝺ꣨꜅ꢚꝹ꣡꜔꣨꜒돘돂ꜥ꣦꜎돕꜉꜒ꝷꝹ돘ꜥ돏돈돉ꝚꝚꝚꝠ꜐Ꝺ꜃ꝾꝮꝮꝀꝠ돃돍ꢛꝸꜥ돍ꢞꜥꝰꝩꜗꝾꝢ돉돎ꝻꝻ꜔ꞦꝹꝠ꜉ꝣꜥ꣨Ꝺ꜄꜐ꞡꜥ꜂꜂꜏돐ꢚꢞꝲꝲꝣꢞ돉ꝰꝀ꜎꜐ꝳ돘Ꝺꝼ돉Ꝿ돈돃꣨돇ꝲꢜꝚꜙꝠꜗꝰꝠ돆Ꝼ돃Ꝼ꜄ꝁ꜂ꝰ꣡돇돉ꝣ꣭돕Ꝥ꣨ꝢꝸꝢ꜉Ꝯꢞꝿꝵꝯ꣧Ꝥꝁ돘ꜘꝴ꜂꜏돂Ꝺꝼ꜐돕돃ꞡꝾꝲꜥꞦ돐ꢛꢚꝼꝾꝩꝿ돏ꝣꢜꝩꝳꝸ도ꝾꝮꝺꝵꝚꝠ돐Ꞧꝺ꜂ꜥꢛ꜒ꢞ돃꣦꜉ꝳꝀꝳ돂ꝰꝣ돍ꜟ돉ꝲ돘ꝲꝴꝤꝹꝹ돐ꝰ꜓ꢛ꜂ꝯꝯꝴꝵꝲꞡꝼꝲꝹ돆꜄꜄돉돆ꜘ돍꜓Ꝛꝷꝿꝁ돃ꢚ돕Ꝼ돃Ꝥ돈ꝺ돈꜓ꜥꝤꝿꞦ꣧ꜥꝲꝿꝹ꜒ꝵꝵꞡꝤ꣡Ꝯꝸ돈ꝸꝤꝳ돍돎꣧ꝩ돐ꜙꝲꝲꝸꜥ꜉ꜟ돎ꝩꝹ꜃돂돃돎ꝯ꜒꣡꜔돕ꞡ꜐ꝲꝺ도Ꝡ꜕ꝴ꜐돃꜓꜕꣨꜓ꝩꝿ돃돏꜒돕꜃돘돏Ꝥ돎ꝸꝲꝩ돎꜄꜅Ꝿ꣦ꜘ돃돉꜏ꝳ돆ꝵꝵ꣨ꝁ돎Ꝯ꜅꜂ꝀꝻꝠ꜅꜐Ꝣ꜕ꢜ꜅꣦꣡Ꝿꜘꢜ돏ꜘ꜓ꝣ꜄꣨ꝷꝼꜗ돐꜒돈ꝳꢚ돍Ꞧ꜓ꢛ꜂ꝩ돆Ꝿꢜꝳꜟ꜓ꝸ꜅ꝁ도Ꝣ돍ꝠꝢ돏꜄ꜗꝤ꜒ꜗ돇꜕ꝩ꜕꜉꜃Ꝡ꜂ꝰ꣡ꢜ꣦ꝰ꜏Ꝯ꜂ꝺ돇Ꝯꝷ꜄돈ꝣꝵ꣧ꜥ꜉ꝾꝻꝵ꜕ꢛꝁ꜐돘Ꝯꜙꝷ돕꣧Ꝿ꜃꜒꜂ꝴꜗ돐꜒ꝼꝵꝵꝤ꜏ꝷꢞ돂ꝲꢚꢜ꣧ꢜ꜏Ꝡꝵ꜒ꢛꝲ꣧돕돂ꜘ꜕돂돉꜐Ꝼꢚꝷꝴ돐꣭ꢞ돆꣭ꝲ꜂꣡꜕ꜘ꜐ꝲꝀ돎ꜘꞦ도돏ꢜꢞꝰꜙꜙ돃ꢜꜥ도ꜟꝵꝣꝮꝵꝳꢜꝿꝻꜙꝿꝾ꣡꜓도꣭ꝼ꣭꜓돎ꝵ꜃꜄ꞡꝳ꣨ꝁꢜꝩꝲ돘ꝷ꣨Ꞧ돍도ꝁꞡꝠ꜓ꝩꝴ돇꜉Ꝥ꜎돘꜔돈ꢚ꜃Ꝺ돈돆ꝿꝀꜘꢚꝹ돏Ꝣ돘ꝵ돎ꜘ돇돕꜐돕Ꞧꝣ꜃ꢛꝺ돈꜄돕ꜗ돈ꝢꝳꝾꢚꝣꝣꝀꢛꝢ돉돌"
                .toCharArray();

            for (int b4 = 0; b4 < 7468; b4 += 1) {
                char c12 = achar12[b4];
                int i21 = c12 ^ 7969;
                int j21 = i21 - 23202;
                int k21 = j21 ^ 5538;
                int l21 = k21 + 31555;
                int i22 = l21 - 38692;
                int j22 = i22 ^ 7397;
                int k22 = j22 + 49350;
                int l22 = k22 ^ 52968;
                int i23 = l22 ^ 64809;
                int j23 = i23 - 21258;
                int k23 = j23 ^ 32403;
                int l23 = k23 ^ 22105;
                int i24 = l23 ^ 25598;
                int j24 = i24 - 9247;
                achar12[b4] = (char)j24;
            }

            object = mth_0OOOoo00o0_31()[1] = new String(achar12);
        }

        aobject[2] = (String)object;
        char[] achar13 = ((String)o0Oo000O0oO(aobject)).toCharArray();
        int k24_hi = 4886;
        int limit3 = 0;

        while (limit3 < k24_hi) {
            int j29 = limit3;
            int i25_hi = limit3 + 1;
            char c13 = achar13[j29];
            j29 = i25_hi;
            int j25_hi = i25_hi + 1;
            char c14 = achar13[j29];
            int k25_hi = c13 << 16 | c14;
            char[] achar14 = new char[k25_hi];

            for (int limit4 = 0; limit4 < k25_hi; limit4 = limit4 + 1) {
                achar14[limit4] = achar13[j25_hi + limit4];
            }

            j29 = k1_hi;
            k1_hi++;
            o0Oo000O0oO[j29] = new String(achar14);
            limit3 = j25_hi + k25_hi;
        }

        aobject = new Object[]{fld_0OOOoo00o0_65, 2, null};
        object = mth_0OOOoo00o0_31()[2];
        if (object == null) {
            char[] achar15 = "醯陫醴铴铞霊靆靃靇铷醡钔铥靊靂靆铰阏铠钙铺靌醰钑醴霂阐铟霊铟铢铠陬钾霂钿铽铢醡靄阏钿铞醡靝霊铹醡钓铴铟铠醴靅铱醹醰铷醰靅铥靝陦铽靄醳钿铷阐铺铞铞阐醡霂阏铽靈醯靝铢醡铮铨铧霂铰铢铼铳靀醳霂霌铥醮铡铽钓醯钙钓陬靀铠靇钑铥铰靅靆钁铷靆钎靝铽醮靄钾陪铺靊陫靆醰靝靍钾陭陪靍铹靚霍靜醮铨陬靌铷钁铠铣铽铮铤钿铴靇霆靜铱靇醡靀醡铧钔靀阏铤铣醴醯醮钑靊靊靅铧醰陪醴靜阐霆霊靌钙靄醯阐钙靝铠铱靃铟钙钁钗靜铤靋钎霆霍铽陦钓钿铼靆铴铷霆霍钑霊钗霂铱铠醯阐醹钎靜醴醯靚醳铟靀靀阐靄铹铴铧阏钔靋陦霆铳醳靈霆靋醹醹铮铠靃钓铯醰靇靜铥霊醴靋铯钿靆铽醮钾铯靂靋铺铹铣陪钗靈钿霍铣陬阐铹靊陦靝钑醡铳陦靃靚醹靊醰铨靝钓靄靋陭陭醹铟钎靌醯靆铧靋阏靆钎铥陪铡靚铮靇靌霊铤靃陪靝钑钓铞铧铤靚靄铮陭靚靝铥铺靝靅靅铴铣钔陦铡铢铣铢醯靜钎铱醯钔钾铺铼霂铢靆靅铨霊钾铯陦霌靂铴靅靅靝铤铟铹陭铷靆钿钿铡靝钎铣靅陭阐铯铷霆阏靝铮靆靈靈铡钔霂陦铨钔靊钗醴陫陬铹靜靌靃铮铳醯醰铳铳霌靇醡铣钎铮铰醮铧靇钿靍霆靇铟铺铣铨靜钾靇陭醹靇霌醮铷阏醮铧铳铴醮靌铨钙靋靍铠铷霍铟醮钓铹醡钙霊铣铟阐铳铮陬醰钁靀靀钙阐靜铷陭钓靝陦靌铱钿霂铥霆钾靂铷醴陪铳钔陪铢靈铱霍醰钿铠钁靊霌铴钙阏钔醰铼钎铥陫钾靂铱铰陭钑铢靃陫铺铹靋醰靄靋靍靊铤靚钿钁铯霂铴铳靊铥钾钁铼钙靜钓铳陫铟陭靀铹铹霊陭靆靋靆钔铟钔钿铡铧陭铼靝靆靊钎铷靃靇霊铣铢铱霆醮钙铼醮陦陭铤陭霆铟铷醹钔陬铣铟醹醮钁铨铺靋铺靋铷铹铟钗铺靇钙醡铧铰靂铢陦铡铢靈靝铠阐铹靈靍铢铥铰靜钎陭醰铷霌陭铥靍靅铼铼铽靚霂铤铥靜陬铹钁霊靚钔铧钾陪钎霊靊铡铣霂阏钿铨钑醡铷铰醹靊铤铤铮霆陦铢霆铠陦铣醳钾醹铧铺靚铨靄靈铣铰钓醡靝铤阐靃钎铯陦阐铺靀靊靀霍靇醡铟陪铡钗钑醰靜铹醡钑钑醰靊钁钓靊阐靊铡靅陭霆靊铣铯钾靈铼铞靈铨霌铟阐醯霍靄陪铟醹钿靌靊铧陬靄靈霌醹阏醹铼钾陬铞铧靚钓霌陬陫铞靅霍靅醴靍陪铨铟钾靜钿霊靈钗醯靀铷铨铮霊陭陪铱铠铰霂霍陬霂铯铰铮醴醡靂靇钗靃陬醴醮霌陬阐靚霌醯醳铟钓钗陪靂靄钓铥霊铱铹靄醳铨铣霌铰钁铰醹靀醳阏阏阏靂钑铽霆铹铷靍钑阏铡靍铰霊铤醰铼靀钑铴醡霆钁铺铱陫钁铧陬铹铣醰醳靂靇靊靍醹醡铹靋霌陫钁铴陭铥醳靌铰铨醯陦霍钑醹靜钾钔霌钔钓醮钿靆靚铯钿靌陦铤靅靇铯铴靅靊铡霆靌醮靜铥靃陬霂霂钓靅靋钎醳钁靇铥铢醴靇靌铴阐醴霍陦钁铠铼钓钎靃靚铽靂靜霍铧钾钑靃铰铮铠铧醮醮铨靇靋靜靜铽靚醳醴陫靀铰霍铠阏醴钗陬醹钓钗靂靀陦铧靋铰钓靆靀陫钑靚钗铮霍铥铢钙铳醳阐铧铰铺霊钓陫靀铽陭铞醳钁钙钿钓铥钓铯铰霆靄陫铰靚铧铢钔铥钙靚阐靊铧靜铺醮陪铤铮铼铡霊醡铥陪靋钑铢靝铴陬靄陫霍阏靇靆陬铥靝靄钔陫靀霆铤陭阐铷铣靈铢钙靌阐铴铤醰铤阏铱钿靀靃靊铹醰钔阐钗霍铟铞铨铨铳陭铳钗铷醳钙霂靄靌醴铯钓铠钎霆钗醮铤靜阏铺钾铼铱铮霊靆钑陭钾铮霊霊铥靝霆陬靀阐阏铟钗霍醰钾阏铺钾钙陫铴霌靅铞阏铨陦陪醰钾霊霊靝铨阐靄铣铼钑靝靆铺铞靍霍铷醰靆铯靃钿霍阏阏铟靜靚铤铰陪陫铣霌铯铯醰靝铤陬醴靃靄铧铡钙靜铼铼靜靂靝钙霆靄铧醯钾铡铡钁霊钓霂钎靈铳阐靈靆靀钿靊靈钓铣钙靂铥靈靍钔阏靜陭铺铧铨靈醳醯铳靇靅钓靍钁靍铣靃靆醯铢钗铰铴铺靊陬铮靆铤钙靂靆阐陭钗靄钎醮铡靃阏醮铟铧铟铳铤靈钙钎铤陬陦铴霂靃靇霍陪靇醹醴钿醹靋霊铰铡靜霊铣钑陫铱霆钎钓铠醰醳铹铢钓铡铰铠陫霍陦靊霍铞醴铽铽钑陪靂钑陦铤阐铤靋靜钑铯靃靜靍靈靅靍醳铞靂靇霂陭铴铥铰靇靆阐靌霂靜靀铹铯靂钿陭陬靂铤铧靊铼靌铴醮铺铱铽靊钿铴铣醰铽靋钿霂铱铯靀靄陦铟陫醳铽钔靃铞醳铷铮铡铴铮钾醰靋铷钁铽铡靊靄阏铯靆钾铯阏醯靜靄铞铹醯阐陬阐阐钑靈铣靍铷靜靊铯铯陭霆铠靋钿铼铧醮醳钗靀醯铧铯靜醰阏钓铳阐铰霍醳靈钙陦醰靌霍钿醡靃醯醯铞醡钗霂铮铞靋铴醴铹靆铢钿霂钓靅醡铹靅铞陭铞靀铢霂铠霂铢钿钙靈钁阏靅靀醮钙铯靚靝靄铤陪陬钿霌陫霂铱靄铴铱醰醯陦铯霂陦铤霊醯铤钓霍靍铳霊铱陬靄阏陬霍靝醮醰靊铴铤铺铰靆醳阏铽钗铠霍铞醡铤靋铽靋靈陪铯醴铮靍钙醡铟靜靈铯靍靅铢铧靈铢铧霍醴靃铴靄铱钑铳铯铞靚靂靇靝铥阐靊醰醴靚铴靅钓钿霂靚铮靈铴靋靅铢靚靆靅钎霆靇铯靋铣靅霌霂铠靄阏醴阐铨铧铴靆靝钓靝钁铰钙铞阐陬钁铮铹霌铟靋靍醴陦钁靂铡靌靝铢钿铢醴铳铧铨靈醰靇陪陪陭醴醯钁霌靆铹钔靜陫铺靊钾靈钎陦铣钑醯铹铰靂阏钾靊钁醯陭霊陬铢醰陭铞靅铤钙醳铠靚醮醳钓靅霌钙钿铳铹霌靃铢靆铨醯陦钾靂钁铥铳铳醳靜钎靋靋钁钔霍阐靜铞霂铴靅铡铢铰靂铟靀钙陪铼阐铧钓铮靅钑钿靋霌靃靆陫钁霊靂钿醡靈靌醴靀铽霍醴醰钙靅阏钾霆醹阏靃霆铹钗钔铽铣靍铮铱钎铯靍陬靂陬铠靈铥陪阐霌铡陪铹靂霊铼铼霆铺陦铽铢醳铢钙醡阏铱靂陪醹铼陭靇铺钎铣陫霌铱铷钁醴陭铟靝靈铢铹铳铰铧陪铯霂铯铡陦铟钁铞陪铮铮霌钾铴霆霂铨醯钑铷醹铯铼陭醰醹陭靅醹钎醡铰靅陫陭靇铥霆醮铢钑铹醳靚钗钔靋靍铧靂阏靍靅钔铷陬靈霊钾钑霍钑靊靌靊铠铟铧靀醴钁钓铼钑靊陬钗铥醮靊陬钑霍靋靂醰铯陪铯靂铤铴陬陬陭陪铱钿醯醴铺钑铥醡靝钓钓靆靂靋靄靝霊铳靊阐钾钙铹霌钾钓钑钿霆钔醹靅靚醰钿靝醹陭霌铟陬铽醳靆靄醰钙靅铨醮铰霍铳铽醹靊铼阐铨陦钑铹靚醹钎铺阐靅铳靊铹霊醹靋陬铳靇铨铣阏靜钾靋铣醡钓靍铨醳靆陦铰陪靜靄靆铤霊霂陭铞靚铹铮靌霌靆钾陦霍霂铢铼陪铤钗钗阏阐靂靇霆醡霌靆阏铴钓醴霂靀靌钔靝钁陭陭铱醳铰铧靀铢铳铟钎霆铧钙钑铟霌铳钿靄钿铣铽铞醡铠钿靋铺醰靌阏铢铼靇钎霊靊陭醴醮阐醡霌醴铴靋靀靝陦铽霊靜铮陬靍铢铷铺醳钾陬铹铳钁铷钙铮靜铠铟靌钓陭铯靅铴靆铳铤阐钗铥靈铮霌铟陪铷钁铢霍靇靂钑铽铼钎靆阐霂靚靌醴醴醡靜靀铥钑铽靈钔醴陦钑靍钓醹铧铠靊铠靜靝靍铣陦铽阐钾霌陭陦铮钑靃铷钓靂阐铧铰靆铟陫醡铳铺霌靃霂铼铰铞钓霌铟靂醯钾铹靅靍醮铨醴铨钙铣靅醳霂铽钓醡铴钎靅醳钾醹钓钗醹靇醮铨阐阏醳铰靇铨陬钁霌铡钎醡霂铧醮陫靃霂霂霊陫霆钑阐铟陭铴靃铼陪靅醰靈醳靄靊靇铞铺铯铡钑靝铽钎醳铣靊铽铟靇霌靊阐钔靇铴铨靆铨霆铢铽钔铯铷靆醯铢霆靊铺钿铤铳铱铺铱钙霊铯钙醰铰靌铢铣铮陫靂霂阏靄铢靄陬铤霆钑铤陦铼铮靃钑铢钑靈靆钑靌靝陫钿靜钑醳铹靝靜靂霌霂陫铢铽铴靇醳醮陫霂霂霍醰钔铷靝醹钙醰钎钾钓醴靋铧醴铺铯铥铷霊铷钎钔霌铤靆靄霂铥陭靊钓靃醳铥醮霍靝铯醯铤醰钾阏铱靃铰靌铰铧靇醡靃铠铡铠醮靅醯铞铴醮钗靋陦陫陫钗醴铱铯陪铮铷铟陭醡霍靃陦铴靇霊钙铥钾陬阐铤醴阐阐陫陭靍靀铺醰霆阐靅霆靜靄靀铟醴铺醳阐靇靋铮铮钿醡醴钓铮霌醮醮铮醳铤钑铟铞靌陭钁醴醹铠靚铢靝靋陭铤靃靂铢靀钾陪霌铧醳霌霆铰铧铥霊靊铴铳钿陦陪靂靚醴铯钾铽霍靈醰钎霌钔铢铢靝钗铺靝阐陪霊靈霌钎陪钔靅霊霌陫铨铽靝靂陬铥靆铟铟陭靈铹醮钑靚钾靇醡钿钾铼铥铞铮铠铽靝靇铠霍铟靄铳靆靜钁靄铰靂陬醡霂铢靜醳钙靝醡陬霊钾铷钎靝靍钓铢醡靂醯醴醮陫铣醳铧醴靝靂醡阐霆铰醡靊霆铠铱靝靆靊钁钓醰铰靊铯铥铼铞靋铨靃霂靌铨铴靆铱铽霍靜醹陬靊铞陭靌铱靀钿钙铼铠铼铣铠陦铧铳铼霌铥陭钙铤靚醯铧陭靅铽铢钙醮钗铥霆铤钗铼铧铷钿钾阐霂醰陪铥陪铼陦铤钾陭钔铰铼铮铞靃靂靝霍铢靝陦陫铽铟靇陦钓阏靋铱醳铱霍铢铯霆醮醴钔霍霆醰陪钗靝靊钿钎铣霆霍靀霍钔铤钿钔铨铺钎醰铤霊靝铺醳铯醮铤铹钁陪靃陫铨阐铞铱靋铠靊铠霆铥铮钿靃钿铠靍陫铞醰靅霍钓靌醴铴靀醯霌铥靍靝陫醹铡靝靆靂靈霌铺钓靂铧铱陪靊靋靈铴陫铮铥铷靇醳铨靅铡铱铯靌钾霌铼靋靃铱钾陫铷钗铨铢陭靆铞钓靊阏钎铹钓陭霊靚霌铠霊靈醴霆靄醴霊靝靋霍钙醡醰靌钁阐铴钗钁钎铱铨阐霂铯霍铠铯钿铳醮铽醡铼铥靊醡钁霊霂醯钙陭靄醮靜铤铼陦醮铞铹钙靄霊铺陪醹铥醰阏钗霊铼醹霍阏靄铱铞铢醰钔靀陫钙铴靊靍醮陦靂霊铨铽铯铧醴醹铣醯靃铽钙靇钓靌铥靚靚靜醴钗钾铱铼醡靚靚铠靍霊钗醡钑靋阏阐钁靝铴钿铯靇醯钙钔靜铠铠醡靚陭靀靜钁靌钁醡阏阐靜陦铽钙铨钙钿铼陬靚钗醳铷铱铠铡铠铺靃醡靀铣钿醡铯铞陬醰靊铣铞陬靇铺靇霌铮靊靚陬铨铢铠铮铮钎醯霆靋霌阐铴钙铼铴靚靈醳陬靄钓钾铮钿铤钎铧醴钔铺靀霆靂钗靅铺铤靊钎醯霆靍靚靝铯醡靋钔靜醹铳霂靈霍陦霊钓钗醰靇陫靃阐钔醴霍铷靈钾靂靋靊铳靃铴霆阏铢钓霂钑钔钔钔钁靈靀陫阐霆铼铼醹醮醳铢铱钾铮霌钔铷铞铟靂靀铹靇陭靍靋醰靆靈铯靌霌霆霊钿靂陪钓陭醴陦钔铠钾醯钗铤靝靚靂靆铧靍铹靋铯铠陦醮铺铠铼陦靅霍靜陫陪阏铟靃霂靆铧靋醰铟靌铞靊靆钙钑铱钗铳铞霍靆靝靌靄铞霆铷阐铡靈靋醹铣铥醹铞铺陭靊钔霍陭霂铺铟铟靝靈铟靊靈铰陪钁铥靄钾霂铢钓铰醳靌铨铺钑靜靃霍铳钁霌铥陪铤靚钓铹霆钗铽靈靌铽霍钑铽铷铤醴醡铴醹铹靈陦靅霌钗阏陪铯靋靂陪铴铢醰陫靀陦醯醹醡铯铥铮铰醴靂霌醯陪陪霍靜醡铴铥陫醴靝靄醳钙钙霍钔靀靀靝铴醮霊醳靜钔钁醡阏靆铨钁铺钔靆铳铡醡铼阐钁钁铡霍陬醯铡铣靄靇陫醰钗铨靊靀铼铠铹霊铣铴靆铯靈陬靅醹靋靈铞靝靀靚铥铞陦靝铮醳铼铽铹铴钿靄霊铟靍铞铺靊钙钓醳靇陪靋醹铼霂铢醡靂醯靈醹靜铼醴铽铟铢铮靇醰霍靋钎醳铠醮阐铥钔铷钿铨靆钔铧靋陬钙靜铟钁靈靈靀靄钁陬铣铷铯霌靄醰醡钎铺霆铽铤霍铴铱铢钾铢醡钙钿陭钔钁醯霊醮靆靀霊霊铰靌靋靊醮陫醹钔陭铢铣陫铯铯铤霌陫靀醰醯钎靃陦钔靀醮醰钗霆霂陫阏靈陫钔靊靆钙靅陬铴铷醯钗霍靇铮铰铥霌钔铱靇铞钾铞铟铞靀醡铴铯铽铯霍靇靊靇靋靚靜醡铥靆铧霊钑铷铼铡铱铹醯醹醹霌醰铽铣阐靀靇醯霊阏陪靇醰靀靈霆铠靀醹陫霍陪醰靍铡铮铷钑铱靅钓靊靊靜靅陭靜陦钔靋靀陭陦靇铧靇醳霌阐铢靇钁铯铨铯霊醳靋钔靃铟霂醡醯钎靂铺铧靌靇靍钗靊钗霂霍钾钙靌钙靃靋醰陦阐陪钁醰钔铮铷铥铢靊铣醡霊铰靇靀铤铤醳铨靀钑阐陪钙铢陪钾铴靝霍霊靋铴靆靍钁钔醹钾靄靚铥铳钓霊靜陫霆阏钿陪醡铳靂醡铨铮霊靅霂铱陭靌铥钓靜钿铥靊铣钾铹醴铮铴铰靂铠钔铟靍醰铟钿陬铥醯铰醴陭铱铽陦霍醰铥靍铱钙靚钗铣靈钾铹铺铢铺靂靜醳铺铧靋铧铯醯醯铞铤钾霆钎钾霍铴钔靚铰钾靄钾陪铮靚靋靄靍铹醯铯铷霂铳铣醴霌醡靌霍铳霍铯铞铨靍醮醴霍靀钾铰靅醰靅铡铺钾陬靂铢靀醳靍靀铧靜靃陫铹醴靀醮靌阐霆阐霂靆阏铷醹靀铤铤铢陭铱靅靜醮铤铽铹靃靄铢霊靊靊钁铤醰醹铹醹陦铴铴靊靅铰靆霍铹霊醳醮靇铰钑霍靄阐霆靋铡铠陬铠醹醡铯靜靃靄铮钑铨靊铤钁钓钾铣钙靃钿靚铤铷钗醹钾铯靈钁铞钾钔靈醳钗铷铷靍钑铰铡霌醰靈靍钿铷靃阏霆靍陪铱铡钓铽铣钾霂铤陭钁钑醹钗醡阐铟铼靋醳钎铴霆铢钎铴靜靜靋铺铯醰醡靃铢铠铱铽铢铼铟靃铴铮铢钔铮钓靊钎醳钗靍铰钿钑靂阏陭霂陦陫靃铴阐铡醮铟霊钾霊铳阏醯铧钾霆钙霊铮铢钑霊靀铱铠靜铞陪铥靋铹靜铼靋醮铟陫醳钗铠铴霆钎铞铤靆铠钑靇钔钁靈靂靇铽靊霆铺钎陬靚铞阏钗铡阐阏醰霌铽靈靆铤靀靆铨靅靍铡铠铽陬铹靈醮靈铥靝陭钿铥醯靋铼铡铱醰靀醰铺醳霂铳靃陪陭铡靈靍铤钙钔靅醴铽靀醮陪钑铥靌醳铥铳靈霊醮铰铥铞铳陦醴霊铷铽铯铴醯铣钎铠铽钎醹陪陪醯铣醯钗靄醹铮铢靋钙铷靜铢铤铺钿醳钔靋霌霂靊铹铤铤钾铠铠铳醯铴陬陬钿靃陪靅铢铯霆靚铹钔醴靃钔铼靌靀铽铺铣靝霆醴靝靈醡钾钎铮铴靄陫靜醮靌铥钿靀靅醮靀钿钎钿铧陭陪钔霆醹靇靝铳陪钎铴铟霌钾钓铰醰陦铺靈靂钑铟靜醳霊铣陬铴铱靂铤靅铺靄醮钿醳醳靀铼靃靈陦靅铷醡钿陭铨霍铳铯铮铮钎靂醰铱铯霍霊陬铧铳霍阏靃靊铱醳靃钔霆醴陬铨醳钙醳陪醡铱钾醮醯靚靆陭霆霆钎靊铣铮钗铟靄钔靇铯醯醳铷铟阏陭靋铞醰钗醴钓靝靀醡靅铧铮陬铥霌铧靀醡铟铞铽醯陪铳靊钿陦靋靋靆靅铳靆铷靚铢靜醹铴铯醳铺铼铱铴霍铡靋铼靌陫醡铴靍醴铷铺靝靚醡靄铢霂铧靍靈陦陪霆铧靈铽靇靇醴靀靂靝钗铢靚陪陭醹陭靈陫霆铞陭靃钑醮铹铹铳铰铽靊铡霊铢铽靊铷陦醹靊靅陫靚霆靝钑陫霂醰靜靍陫靂钗陫钔陦陦靃钎铤铠靄铤铞铧钔铞靚阐铹阏醳阐霂靂霆陪醮醯靀钁钾靂铰铤铼醹钾醰陭铡钿靇醯铧铼靌霌霆铨靅靇靊铽靚醡陫铰陭铯铥靂铼靝铽铰铺铡铰靈铳铥铼靊铣霆靂醳陬阏霊陦靊醯铡靈醴靚钗靄靅霆铴钁靃铮铠陪靅铷钾钔钑铷陭霌铴靆钿铯靂靄铡钙钾霆钁钑靈靜靆靊醯铽靝陪醴钔铴陦铴霍醮铴靀钾靇霌铡霌陦钓醰靂钙靊靝铱铤醮钓钙钙钾醰醮铼霂铥靌钗靍铴靇靂铰靊铡铺醰铮霍醮铴阐霌霂靅铼靚陬靃铳铟铷醮铯霊醯醰陬醹铧钎醰铰铷铥靌靍钙靋靆醹醹靇铴靋醡醯靇醳靜靂霂钓铴醹铷醰钎靌铣靇醰醳铟靍铱阏铟霂靄钁阏醰醮铹醰铨靂铞铺醳铢铹靀铧阐靇铯铽铡靆钔醮钑靅靆靝铴靅陭靇钑铠铽靇霆醡醮铞铥铴阐醴铳铳靜陭霊钗钁钎陪钁铼铴钓靊钁醹铣靄霌陭铼醡霌钔铟铼靄钔靆铳醮阐铺靃醳铞霂靍铧霂靀陦醹钁醹陬靌陬铥靃靇陬铰陫铨醮醰铹铤醡醳靂钁醳陦铨醮钿靂陪陭醮醡靂醮陫铟靈靊陬钾陪铴靂靜铳靂铣铹铱靇铢靜靈靊铮靝钎靄靄钾铳铧靚铮铡钎醳醴靋霌铨铰铟靆靇靈陬霌霂钔醮钔钾霂靅靚钙铰陪铼霆霍铽醴陪靇靊钑醰铯铥铤铧铰铤醴铺靀陬陫靍陪靌钁铠靋铞靄铼靂阐铳铼阐铹靜铮钗靋靊铟靈靋陫钎靍铢陫霍靀铨铥铰铣铠阏铺陦钑靃靇铠靍靂铽钾靝醴铥铺陭醰靃铠醮陬铢醡陫醡靃铳靄铧铰靄醮醹钓铯阐靊靆铤铱铣霌铴陦铠醡铳铰阏铤霌铠靊靆靃醮阐醴靍陭陭靆钙醯铳铞铥铮靄钿靅醳霂铷陦铰阐铡靄铡铼铽铼醮靍钁靋铤霍陭醴铺靚醹靋霊陬铳铥醮靝钓铠醳醴钔钎靝铨铠靚铠铡靃铰铮钁钁陬铷霊靝铹钎铱靆霌铞陫靌醡铴铠铨钁铯醳靜陬醴铽靍钗钿阐铞铤铨靃铥靆醹铷陦铤铺钓铢靋靝靃靊靃霂钔霌铯靀靅铰钔靃铼铡钾阏铨铴靈铮钾铯铡靌铧铰铳铷铥霊醡铨靊霆钙靌靜靝钔靅钑铳铽铡铣钎铞铱钙铴醡靄铴铠铧靚铤铯靇钓醯靚铣陬铤铠铟靍靀铽铰陫靃醯醰铺靋钎铯铺靍靊阏霌靝阏醡靆铴钗钔铡靈铨靃铞铧钓钎铳铮铢靃铨铼靜钿铺靝阐铤霌醰铤靋铡霌钔醮靝铞醹铱铡靆铳铱靃钙铥靆醡靆靋陦醰靌铼钿铹醰钓靚铯霌铨铰靆靅铮钾钎靀陫陭钎陭靆铯铧陪醳靜靅靂铤醹靇靄醹钁靀陪铨醰钔铳靝靍靇醹铮醡铯霂铥阐铷钔钑钔靄铢醳醯陭靋醯靋钁陦陦霆铹铥醯靀霆醮铴靜靋钔陦钗醡铹靇铹钎铣铤霍靀钑铽霌铞靜靃铤钑钾霍醴铹铨陫靆醰铽靀靈钙铳靄钙钿靆钿靜铥铷铴钎铢靈钿铼铨靆钑钎铷铷铞霆醰铤陦铷陫陭陭靄铟铰铥铮醡陫醰钓靝钎钿铱陦靃钿铺霍靋霆铯钙铯钿铟铷铴钓钾霂醯钓钔醴铺铢铰陪醳醯铮靅铠醰醹铟铠霌霍钙铮陫铧靈醹铱靋铺铱铥阐醮钙铣靄铮铣铤霌铽靆霌靄靜钙铡铱铥铮铡陬铢陫铨陬陬钓陫钗醮钗钾霆靀靝醹霆靜铧铞钿陫铟钾醯醹陪铡钔霂陭铨铡靆靊醡靃铰靊靋铰铹铤靝阐钙铥铽醳靜靋铮醯阏铨铣铤靀醯霊铯霌靆铱铨靈醮钙阏铞钓醡靀醯钁阏陬靈铹靇靊钑钑霊铱铣铳醴陬铡铨阏醯铮铼醴铼靜醡钗铰铡铹醡钔阏靂靃陦铡陭靃靃陦靈铯铟钔铴铴铞铥钑钿陫醴铨靇靝醴陦铤靋铟靀钎靝铡陬霌铴铨醮钾醴铢陭醹铹靈铼铞靆醳铧靄铺醹靄钎阐陦靝铢钙醡铰钗钁铡铽陭靊钗钙靇铯靊靌铞靄陪铧陭钗铺铴霂钿醰陪铹靅铢铥陬钔靃钓霊霂陦铼靂铥铠靀铱钾铟霆靈铣铣陪铹靂钁钑铺钎铥铼钓钁铽靌霂靌霆铥陦铰陦醹铰霍醯霊铤铰阏陪阐靝靄霂铱铷钑霊铣钁靍铥靊陫靈钙靂陫铼铢靈铨阐醯铡醳靚霌靂霆靄醳钑靍阏铧铣铷靋铷靋靍钿醳阏铮陬靃醴钗铽靌钁钗铼醹醹靍钁醰靚铰霍霆钑铨铹铼铴铞铥陦阏钿钑醹钁靀靜铡钙醰霂醮铯铼靚陪靍陪钙靍靍铣醹霍霆陭醡靜铣阐霂铨铧靃铥钑靆醳钾阐陪醹醮霂钓铞钙靆铯铳钗陬醹铴陬钿靊铯铞铨霆铷霆靌钔醳靚铢铯靇钎陫钎阐靄阐靀靍醮铞陭铷铺铡醯靚靊铣铼霌陪陪靊醳靍醴陪霂铨铯靆陦铨铨铞靚铟铡靀醹铰靄靀铴靇靃铴钎铼霊靂醡靜靚铰陦铣靝陬醳铰陦铤铥霍铣铡钑靃陫霌陪靊钗霆醰霆铱靋铱铡铞铨醳靝醹铽靊铥靅钑铴铤铮钔醰铥铥钾铧霍霌靅醳铢钗靀钔醮铯陪铷靃铱靇靃靇靚霆靋铠陬靜靌铧醰靀醹钔铴铤铱醹醮铺阏陫靌铯醡醰醮醡陫醮陭铟钑醰靚铣钎铤钎靈铼铯霍钗铴铥靀靍钓陫阐靄钓靝铧靅陭铣铯铹靊铟铠铱钔钓靂钑靄醮铷靇铷靝醴阐铴钁靚钓钁霍铽霊钎铢醯钿靚铼靚铳铨铷醡靀醯霂铽靝醡靂陭靌靌铨醡铡钾铼靇陦铡钿霆铳靆醴铣铽铟靈铤铳靝铳霆靈铴靃铢醰醰靚醡铺铼靋靌醯靋靄铡铺铧靚醮醯靂陬钙铤醳靌钎铰靈钎钎铳醯靄钎醴靇靈靆霊钑钁陪铱铯钗霊靍铥铥靋靈醴靀铼阏陦铢醹阐靌铟铴钙铡钎铮靋霌靍靍霌铞霊靌铧铰铱铹铞醳靂靂铷铤陬钓靚钁醳靃靇钾靅铠铷靀靆铣霌靀钿靋铡靚靍霍铠铥靄醡陫陭醮铷铡霊钓铷钔铮铼铼铹铨铯铮铥靄铮铨铨陬铥靇醳钿钑钓靍霊阐靊醮铣醯铤醹靚铮陪霍铞钙铞钔霍靈醮阐铣醯陫醹铷铱铧铤钙靆铳铽靆靅铨铺铳阏铳醯靀铡铴铮靇靝醹钎铢靃钗铟靈靜钁霆霊铤铴靄陭霌霆靅铡铥铹霆钙铱陪铢铼醹醴钑陭铯靋钙陪靌霂铥铨陫靂陫铳钾靋靄靂醯铠钑醹铷陬靝靜醳霍霌铢靊醴醮铢铟铨靂钿钑靄铠阏铢阐醡陫靚钙阐靆铤陬醳铺霆铡铳铴醰铠靄霌钑霊铮靌靋铣靚陬铥钿霍醹陦铣铮铧靂阐铴霍铺陦醮醡铹陭钎铤钓钙陦铷铷靈醳霆钔铨阏铰钔钁靀霆铠醮靃钙铧铰铳阏铢靝铴陦醡铠醯靆靌铨靝霍铧铨醡铹靀靄靚霆钓靂铢铞钔靃铹铢靊靆醮钾钿陪霊靄醡铷钗靆陫靆阏靋靌霊铷靈铱靄醮醰铣靄醰铺靂靊铣靍阏靋铡铱铮铣靇铽醳醯铺铞靍靈阏铺铮钗铞靋醯铧靇钑钙铯铞靂铴靋钗钓霂靊铤铰靊陦铰霆铮霊钁靄陦霂铷陦钙霊钑靅阏醳靆靚钓陬钿铴钓钔钎靍铹靚陦铥靊钑铣铼靚霌铷铨钁靂钾阏钓铢铠霌霌陫靆钿铞陫醹铨阏铞铥陭钙钁靇靅霌靋铹钑铯陭铰陪陬靇霍靈铞铟钾铽霍靄醡铰铨霂铺铷陭靌铥钔钎霊霌靚铴靃醮铱陫钑靈铤铼陭靅靅霍醴靌铺醡铯铯陬霂陦靀醮铴陬钿霌醳醹陬靈阐陭铨陭铰陪靅铨靊铨铺钔铟铱阐霊靋铯钔靄铷铳铽靄铹铡钿靊铰靀靅醹铢靇铠靆铠靂钙靄铼铞钑铺陬铢靆钗醴靇靊靃铽铰靂阐靅阐铧陦醰醮霌靈阏霂铞醯铮阐铧靅靄靌铨靇靃钾靝钓铤钓陭陭靌钁霊靚铠铠靍铧铼醳铹钑霍铱铞醯霊铡陫钎靌靀铯铹靚醰铴铤阏铼铡铱铯霆钓钁醯霌靈醰铥霆霍陦钗钿靋靍陫铞铹醡铳靈钿靇铼钗铢醴铴铢钁钙霊霊铷铮靄醰铰陫靈靄靍铱铼靚靊阏醡靃铡阏钿铡陦陭铣靌靂靍陬钗钑靊靍醰醹阐铨靃铴铣靂铧靍醰醡陭钿靌铥钑铷铳钿醯钿靃钔钾铽铹铤醮靜钁铼霆靌霂钙靇钾霍阏铞铞靄靍靍靈钎醯铰铢铣铡铺铟陭醮铰醮醹钓靅铠钔靜醡阐钎陭铯钗铣铷铷铨霍靍铞钔靊霌铞钁钔陪靋铯铳靍陭靍钿铼铼铟阐钙靇霌醴霍铰钑霂铱靆钿铮靚靀霍霂靅铧霍靃铳铮铷铧霆铮铯靈靀霊霍钎阐霍铹陭铺钙靀霆靚靈醹钾钁靌醳霊陬陪铷铟铧铯钎阐铡陬靃霂靈靍铰靄靍铷醰钑霆陭靚靊钔醯靃铣铽陫铺霂靇陪醡霊钾铴靊霌铣醴醹铟靂铣铟阐钎靜铢靀醳钾铣铟铨阏铹铺铺陦靊铰醰靇铞靅钁钾铴醡靝靂钎铹铰铱铹陬靝靋靀靌铷醮靍铴钿铢钿钗铺靆霍铼霆靂铼靍铮铤钎铧靍铧靈铽靌靂钗钾钾铞醹靝铺铹陭铴靝陦靆钙铤醹铧霍靇铥靚醳铣霆靃靈醡霍陭铱铢铯阐靊铧铴靈陦铞铱铞醰铷靋醮靈钙靈靅钾铽靌铰铮铠靅醮铼铧铳醳铤铯铷靜阐钓铴铥铹靅铼铱靌铱铹钗靂铣铹钿靄陫靃陭靍醳霊铡靍靍铢钗铹醡靚钙醰铼铴铟铮铴钗靃铧靌醹靆铷铣醡铞铮铟靍钎铳醡靄陬醰铥钁铹靋阐靈靀铷铰醡霊铱霆霌靇铷钁铱靃铷钿铮钔陬钓靋陫铟陦靈靃钔铥钿铨陦靆阐靚铧陭铹铺霌靍靆靃铮靚靆靊霌醮铞铨陭铰靆铟阏靜铡醹醮铢靌醰铮铤靍铼钔靊铯醰醡钑霊铥铰靈靆陭铹靄醰醯铤铮陬靅铰醰霌靆醴靚铨醡铮霌铺铧铮靝陫铱铨靍醮钿醳靚陦靊靃霊钙醮陦钔铠醮铯醳铼醴醴铮铰钓钑铱钿铹铧陦钙铣醯靌钑铣铞铯陭铟钁靍醴铞靅铥霊钾霍铹铽铡靆靈铢靅钁霊醯铠钿铧钗醡靃靝铟铤靅靍靍醹霍靆铥阐钿醹铮铣铴靅铠铳靊陬靄靆陭醰霂阏醴铥霆铽靈醰钙醴霂钙铺钗铮钾铹醴铨醹铨陫靅靍钿醴铱铨陭铟铺铴铱铽靃靌钗靆靍陬靂陭铨铰铧靂铡钓钓醴铳铮铤铨靝阏靋铞靋霍陪醴铼阏靚霍陬陫铳靜靚铳靀靌霍铮钁钑铣靇霂靋靊铧阐铧阐靃霍陭阐铞铧铥靚靃靍醡钙陬霊靚铨靜醹霍醡醹陭钗靝醳靀铮铳靄钑靊阐阏霌铼醳铷铢铰靌靃靈铣靂靄钑铞醴醰铳醹霊醯醳醯铮靚铹陪霂阐靋霍钔靃陪陦靜阐醮霌陬醳陦钓陫钗醳醯铣铠铠铥铨靌铠钎霍陫铷铰靌靅靃铮铢钾钗醮铹霊醴靄靆靍靝铢醰铥铺霂铮铣钑靅靝钑钑陪靅铡醯铰醳靚铱醯铟靚铼铯铹醮醡阐铤钿铳铹陬铟靆铥阏铳霍醡靝铰铴陦醳钔铳铨铮醮靂铞霍陦霂铟铳阏醴铽靈陫铯霍霆霌醡铯钓铴靋铠钎靅铧铞陪醴靌钙铣靊靅靍醴靜靅钙钾靚霍靃铥靇霆铮醡靌醡铧霊靍霂钎靊陭阐陪霌铽陬钗醯靍靍铨铹靃靊铡钔靇霍靍钾铠靀铡霂靂铤铟靃醳霌霆靊陬靋钎阐陪陬铢铠钓陬醮醡铴铡醯靊铠铟钿铼靆铯醡钎靝靂阏铞铡陬铴醯铴钿靜铤铞醹钙靈霊醹陫靝靃阐陫铺醳靅钓铴靀铷靚铥醡钔陦陪霆陫铼铴铱陫靂阐铳铞钓靍靈靂铥铯陭铳醴靊阐靈铣钎靄醡靝醰铧靚铥铷醡钎靈铥铰靜霍阏靈靍铹铠阐铽铥铨铺靆钾铰靈霂铢铼铯靊陪铞靂钙铱铠钗铽陫钾铣醯醰靇铤钿钙靄铮醰铮靀铟铥陬铯靇钿霊钾靃醹醯醴钁陫靋醴靅靅靈铮靋铴靂钎醹靆靃铨醯靍靍铳靝靂靚醳钓醴铴靝靜钗醴铴靆靇钁霆铴靆醡醯醳钿铣靂铹醴靋铮靅铱靂陦铮钗醹钁铷铷陦陭阐钔铡靈霍陬霂铧醮霊铴陭铳陬钎靂铴霍铷靚霂铤醹醯陦靆铥霊钾铟铺醯铞靄靀铱靊霍靄铡霂霂霊陬铰钑钎铱钎铥醳靝铰靅铹霆靄钙霍醰靝陫铡靂钑醹靅靆靄陦铺醡钎陪醹靄钙铨铯铟铡铞靇铳霆靍靊陭陭铨靇霂醯陫"
                .toCharArray();

            for (int b5 = 0; b5 < 8064; b5 += 1) {
                char c15 = achar15[b5];
                int l25 = c15 ^ '腁';
                int i26 = l25 + 31842;
                int j26 = i26 ^ 56658;
                int k26 = j26 - 57379;
                int l26 = k26 ^ 48709;
                int i27 = l26 - 57974;
                int j27 = i27 + 25527;
                int k27 = j27 - 54266;
                int l27 = k27 ^ 2362;
                int i28 = l27 - 11243;
                int j28 = i28 + 50941;
                int k28 = j28 ^ 4831;
                achar15[b5] = (char)k28;
            }

            object = mth_0OOOoo00o0_31()[2] = new String(achar15);
        }

        aobject[2] = (String)object;
        char[] achar16 = ((String)o0Oo000O0oO(aobject)).toCharArray();
        int limit5 = 5091;
        int i5_hi = 0;

        while (i5_hi < limit5) {
            int k29 = i5_hi;
            int l28_hi = i5_hi + 1;
            char c16 = achar16[k29];
            k29 = l28_hi;
            int l4_hi = l28_hi + 1;
            char c17 = achar16[k29];
            int i29_hi = c16 << 16 | c17;
            char[] achar17 = new char[i29_hi];

            for (int limit6 = 0; limit6 < i29_hi; limit6 = limit6 + 1) {
                achar17[limit6] = achar16[l4_hi + limit6];
            }

            k29 = k1_hi;
            k1_hi++;
            o0Oo000O0oO[k29] = new String(achar17);
            i5_hi = l4_hi + i29_hi;
        }

        aobject = new Object[]{fld_0OOOoo00o0_65, 3, null};
        object = mth_0OOOoo00o0_31()[3];
        if (object == null) {
            char[] achar1 = "\uf0ae\uf0bc\uf6a2\uf6f8\uf098\uf69f\uf0ae\uf74e\uf761\uf753\uf0b0\uf0b1\uf75d\uf75e\uf74f\uf689\uf747\uf74b\uf0b2\uf762\uf0ad\uf765\uf753\uf0bd\uf6a6\uf6ab\uf763\uf0b4\uf0bd\uf741\uf0a9\uf0be\uf0af\uf740\uf76a\uf741\uf6a0\uf0ae\uf6a7\uf743\uf6a7\uf747\uf0a9\uf746\uf6f8\uf6a0\uf746\uf763\uf6a2\uf750\uf74d\uf6ab\uf76a\uf0b2\uf746\uf0b3\uf0bd\uf69c\uf6f8\uf765\uf688\uf6aa\uf74f\uf0be\uf742\uf0ad\uf0af\uf740\uf0a8\uf75e\uf761\uf74a\uf753\uf6f8\uf74d\uf6a2\uf75e\uf752\uf74b\uf0bc\uf749\uf0bc\uf0b2\uf0b4\uf74e\uf0b4\uf754\uf6a1\uf6a6\uf742\uf747\uf0b1\uf0b2\uf6ab\uf761\uf754\uf743\uf762\uf760\uf75d\uf0b4\uf69f\uf0b2\uf0bd\uf751\uf0ad\uf69d\uf750\uf6a6\uf753\uf0b7\uf6a0\uf749\uf6a6\uf747\uf6a5\uf746\uf75f\uf0be\uf741\uf0b0\uf6a2\uf0b3\uf740\uf69d\uf740\uf0a8\uf753\uf689\uf6a0\uf757\uf762\uf743\uf753\uf757\uf745\uf754\uf0bf\uf0b0\uf743\uf0bc\uf76a\uf763\uf0bd\uf747\uf760\uf74e\uf0b4\uf6f8\uf75f\uf750\uf742\uf0af\uf0b1\uf6aa\uf6ab\uf0b0\uf0b1\uf6ab\uf0a9\uf0be\uf76a\uf69c\uf0a8\uf0ad\uf750\uf69c\uf6a1\uf750\uf747\uf0bd\uf754\uf69c\uf6a7\uf6a6\uf6a4\uf74e\uf753\uf69d\uf6aa\uf6a0\uf69f\uf763\uf761\uf751\uf746\uf0bf\uf689\uf0bf\uf74a\uf765\uf752\uf689\uf0af\uf0b7\uf746\uf0b2\uf75f\uf744\uf6a7\uf0b0\uf0bc\uf0b1\uf6f8\uf761\uf75e\uf762\uf6a5\uf6a6\uf6a4\uf6a1\uf742\uf6a4\uf0bc\uf098\uf750\uf098\uf6a3\uf6a5\uf0a8\uf0a9\uf69e\uf742\uf697\uf6a3\uf74b\uf750\uf6a0\uf752\uf743\uf746\uf75d\uf74d\uf0b7\uf6a3\uf0bf\uf752\uf6a7\uf0ae\uf74d\uf6a4\uf6a5\uf0b2\uf76a\uf75e\uf747\uf749\uf76a\uf6aa\uf0af\uf75e\uf74d\uf0b1\uf746\uf098\uf69e\uf746\uf765\uf0b1\uf74f\uf751\uf6a1\uf0bd\uf0a9\uf0b2\uf753\uf0ad\uf69c\uf0b0\uf742\uf098\uf760\uf689\uf754\uf751\uf0bd\uf098\uf0ae\uf754\uf761\uf0be\uf6a4\uf0b0\uf694\uf0ae\uf741\uf762\uf0ae\uf0bd\uf694\uf0af\uf743\uf6a5\uf6a3\uf0b1\uf0b4\uf765\uf75e\uf760\uf745\uf098\uf75f\uf0bf\uf741\uf76a\uf688\uf745\uf761\uf745\uf6a0\uf0a9\uf0a8\uf0b2\uf6a1\uf765\uf6a7\uf6f8\uf6a5\uf744\uf763\uf6a3\uf741\uf0b2\uf69e\uf6a3\uf74f\uf74f\uf75f\uf0ad\uf6aa\uf0bc\uf760\uf74e\uf697\uf753\uf74e\uf098\uf761\uf760\uf750\uf74a\uf749\uf69f\uf0bd\uf6a6\uf689\uf753\uf752\uf6ab\uf741\uf6a2\uf74d\uf744\uf0a9\uf743\uf0af\uf0b1\uf743\uf763\uf74b\uf74e\uf741\uf0ad\uf749\uf694\uf74b\uf6aa\uf762\uf761\uf0b0\uf6a1\uf765\uf6a2\uf0b7\uf765\uf6a3\uf75f\uf0bc\uf69d\uf6a0\uf761\uf0b2\uf752\uf6a4\uf688\uf740\uf762\uf74b\uf75d\uf688\uf74d\uf760\uf741\uf0ae\uf0ad\uf752\uf69c\uf740\uf745\uf753\uf688\uf74d\uf752\uf6a0\uf0b1\uf0ae\uf75f\uf74d\uf0ae\uf75e\uf757\uf74a\uf0af\uf6a3\uf747\uf689\uf6a1\uf69e\uf6a6\uf694\uf6f8\uf745\uf0b1\uf751\uf69c\uf6a7\uf740\uf757\uf0ae\uf69f\uf6a2\uf6a6\uf75d\uf6a2\uf74e\uf763\uf75e\uf0bc\uf098\uf69f\uf75f\uf763\uf098\uf0b4\uf74e\uf69c\uf0ad\uf098\uf750\uf74b\uf765\uf0b7\uf76a\uf752\uf0b7\uf765\uf0bd\uf757\uf74d\uf098\uf0b1\uf6aa\uf745\uf760\uf69c\uf6a6\uf6a3\uf6ab\uf742\uf747\uf69c\uf6a7\uf0bc\uf75d\uf751\uf75d\uf747\uf75d\uf69d\uf741\uf69e\uf747\uf098\uf751\uf74f\uf743\uf6a2\uf74b\uf6a2\uf74d\uf6a3\uf694\uf6a4\uf688\uf6f8\uf694\uf6a0\uf0ae\uf761\uf74b\uf74d\uf098\uf0be\uf0be\uf750\uf0b4\uf69e\uf6aa\uf0b7\uf6ab\uf689\uf0b2\uf6a5\uf74d\uf0b4\uf750\uf0b0\uf757\uf0b7\uf746\uf0a8\uf74e\uf0b3\uf742\uf6a5\uf6a0\uf0af\uf6a4\uf751\uf75f\uf69c\uf0b7\uf6f8\uf69f\uf76a\uf754\uf0be\uf763\uf75f\uf74a\uf762\uf6a7\uf0b1\uf74f\uf0b1\uf0ad\uf740\uf741\uf69c\uf752\uf747\uf762\uf688\uf75f\uf0be\uf0be\uf754\uf750\uf6a1\uf742\uf743\uf752\uf0af\uf6a1\uf6a7\uf757\uf0a9\uf6f8\uf6aa\uf753\uf688\uf0bd\uf6aa\uf688\uf6a6\uf6a7\uf762\uf6a2\uf0b0\uf6a6\uf757\uf74f\uf6a2\uf6a4\uf6a1\uf0b7\uf74a\uf0b0\uf74f\uf694\uf754\uf0ae\uf688\uf6a2\uf697\uf750\uf0bc\uf751\uf751\uf760\uf762\uf743\uf751\uf0b3\uf740\uf0a8\uf694\uf689\uf0bc\uf6a2\uf75f\uf74f\uf750\uf689\uf751\uf6a3\uf746\uf697\uf0be\uf74d\uf0a8\uf749\uf6a3\uf75d\uf0ae\uf0a9\uf0bf\uf6a6\uf0bc\uf6a0\uf6a4\uf69d\uf6a4\uf74f\uf0a8\uf6f8\uf760\uf757\uf74b\uf74d\uf69d\uf0ae\uf0a9\uf761\uf74b\uf689\uf6a6\uf745\uf6a3\uf6a4\uf0bf\uf0b3\uf763\uf6f8\uf752\uf74e\uf0ae\uf763\uf744\uf69f\uf689\uf0af\uf763\uf752\uf0ad\uf0b2\uf76a\uf098\uf0ae\uf751\uf754\uf762\uf69c\uf763\uf743\uf742\uf762\uf75e\uf098\uf752\uf0be\uf765\uf0b7\uf0bf\uf762\uf0ae\uf752\uf0b7\uf6a2\uf0b0\uf0bf\uf6f8\uf743\uf746\uf0ad\uf6f8\uf75d\uf761\uf0bf\uf0af\uf0ae\uf6a2\uf6a6\uf74e\uf6a6\uf747\uf74b\uf765\uf74e\uf750\uf75f\uf688\uf689\uf0b2\uf75f\uf0a9\uf0a9\uf74d\uf761\uf098\uf697\uf69d\uf747\uf752\uf6a4\uf0b4\uf742\uf6a7\uf69c\uf761\uf69d\uf0bc\uf74d\uf760\uf6a3\uf754\uf760\uf753\uf0b0\uf74a\uf757\uf6a7\uf0be\uf69d\uf765\uf69c\uf74d\uf753\uf74a\uf76a\uf0b7\uf757\uf747\uf747\uf746\uf74f\uf689\uf740\uf6a0\uf6a5\uf6a5\uf751\uf740\uf0a8\uf753\uf762\uf763\uf6a4\uf0b7\uf0b4\uf750\uf098\uf743\uf0a9\uf0b4\uf0b0\uf6a2\uf742\uf747\uf69d\uf0b4\uf69f\uf75e\uf6aa\uf6f8\uf688\uf754\uf688\uf75d\uf0af\uf742\uf750\uf765\uf760\uf762\uf0a8\uf6a2\uf0b3\uf75f\uf765\uf75d\uf689\uf69e\uf689\uf741\uf098\uf0b2\uf751\uf757\uf762\uf0b2\uf69e\uf74a\uf6a4\uf765\uf74a\uf6f8\uf0b1\uf749\uf69d\uf745\uf6a6\uf694\uf753\uf6a1\uf6a2\uf743\uf69f\uf0b0\uf741\uf762\uf74f\uf0b3\uf749\uf694\uf743\uf75d\uf6ab\uf750\uf744\uf753\uf74b\uf754\uf69e\uf6a2\uf6a7\uf6a6\uf741\uf6a7\uf752\uf6a2\uf098\uf098\uf765\uf0b3\uf752\uf754\uf749\uf0bd\uf757\uf74b\uf0bf\uf760\uf69c\uf746\uf0b3\uf6a1\uf741\uf745\uf75d\uf743\uf6a0\uf0bd\uf6aa\uf0a9\uf694\uf6ab\uf6a4\uf0b1\uf0b2\uf689\uf75e\uf752\uf742\uf74a\uf741\uf6a1\uf746\uf750\uf0a8\uf76a\uf742\uf760\uf69c\uf6a4\uf749\uf6aa\uf0b2\uf750\uf6a0\uf746\uf0bd\uf0bc\uf6a1\uf6a6\uf754\uf0bc\uf757\uf747\uf6a1\uf0b4\uf754\uf750\uf69e\uf6ab\uf761\uf751\uf697\uf749\uf0bc\uf741\uf6ab\uf0bc\uf74e\uf6a1\uf69f\uf761\uf0b2\uf0af\uf0bf\uf0b3\uf749\uf6f8\uf6a7\uf74d\uf743\uf0af\uf0a8\uf6a2\uf74b\uf0b1\uf752\uf745\uf762\uf0bc\uf0af\uf69c\uf762\uf6a3\uf6a6\uf69c\uf747\uf760\uf74a\uf6a2\uf0ad\uf6a5\uf697\uf763\uf765\uf6a7\uf741\uf75e\uf0bf\uf750\uf6a3\uf0ad\uf6a0\uf6a4\uf6ab\uf753\uf741\uf749\uf751\uf74a\uf750\uf752\uf75f\uf6f8\uf69d\uf763\uf750\uf74b\uf098\uf0b7\uf6a0\uf0a9\uf74f\uf746\uf69f\uf740\uf751\uf697\uf0bf\uf697\uf6a6\uf0bd\uf751\uf75d\uf0b0\uf6ab\uf745\uf75f\uf743\uf6a1\uf688\uf741\uf0b0\uf747\uf0b4\uf098\uf0a8\uf75f\uf688\uf6ab\uf761\uf761\uf754\uf76a\uf741\uf098\uf689\uf688\uf69f\uf098\uf0b1\uf69d\uf761\uf6f8\uf753\uf69d\uf689\uf761\uf0be\uf751\uf6a3\uf69c\uf6a1\uf6aa\uf6a2\uf757\uf0bf\uf745\uf762\uf74f\uf746\uf76a\uf6a7\uf6a4\uf740\uf0b3\uf751\uf757\uf743\uf098\uf0bf\uf69c\uf688\uf765\uf0b1\uf760\uf0bd\uf747\uf6ab\uf69e\uf740\uf6aa\uf75e\uf751\uf741\uf744\uf0bd\uf0af\uf0bd\uf763\uf0b0\uf694\uf6ab\uf0af\uf6aa\uf740\uf0bf\uf6a1\uf0b4\uf0bd\uf689\uf0b3\uf0b0\uf6a7\uf74d\uf0be\uf0ad\uf6a1\uf69d\uf76a\uf74d\uf75f\uf0be\uf740\uf697\uf0b0\uf0af\uf6a7\uf0af\uf0ae\uf6a0\uf0af\uf760\uf688\uf0ad\uf762\uf69c\uf757\uf749\uf6a7\uf0bc\uf0bd\uf69c\uf6a5\uf747\uf74a\uf0ad\uf0ad\uf6a4\uf757\uf751\uf75d\uf757\uf74d\uf0be\uf742\uf751\uf694\uf761\uf6a0\uf74d\uf6ab\uf0bc\uf760\uf75d\uf74d\uf765\uf75e\uf75d\uf762\uf752\uf6a3\uf765\uf6f8\uf0b0\uf765\uf6a7\uf6aa\uf742\uf6a4\uf74b\uf74d\uf6a7\uf744\uf6a3\uf74e\uf6a4\uf6a2\uf697\uf0bc\uf098\uf0af\uf6a1\uf74d\uf697\uf098\uf0b0\uf74a\uf098\uf0b7\uf0ae\uf761\uf752\uf6ab\uf0b2\uf688\uf697\uf761\uf75f\uf0b2\uf0bd\uf6aa\uf76a\uf754\uf6a1\uf69d\uf0bc\uf741\uf6a1\uf750\uf74d\uf74e\uf754\uf6a6\uf760\uf765\uf6a5\uf757\uf74f\uf0b4\uf6a1\uf0b2\uf75e\uf763\uf74e\uf75e\uf745\uf0b1\uf752\uf743\uf761\uf0bd\uf75d\uf6a5\uf754\uf76a\uf098\uf0bc\uf745\uf74d\uf74d\uf0a9\uf751\uf741\uf6a7\uf743\uf0be\uf0a8\uf74f\uf098\uf694\uf0b3\uf0a8\uf6aa\uf74e\uf0af\uf0b4\uf757\uf75e\uf6a5\uf6a3\uf0b4\uf747\uf75d\uf0bd\uf6a0\uf6a7\uf0bd\uf743\uf0a8\uf74d\uf0b3\uf0b3\uf69d\uf741\uf762\uf0ad\uf745\uf0bf\uf69f\uf742\uf75d\uf0b7\uf69e\uf689\uf762\uf6a4\uf6a5\uf0ad\uf0b4\uf0ad\uf0bc\uf75f\uf0b3\uf688\uf746\uf74f\uf0a8\uf6a1\uf0bc\uf0ae\uf75e\uf697\uf6a2\uf69f\uf747\uf74f\uf757\uf74d\uf6ab\uf74b\uf747\uf753\uf765\uf0b4\uf0b2\uf753\uf746\uf75d\uf0b7\uf754\uf740\uf694\uf697\uf69d\uf74e\uf0af\uf0b3\uf0b3\uf750\uf0b4\uf753\uf0b0\uf6f8\uf6ab\uf76a\uf69e\uf6a3\uf747\uf754\uf74f\uf0be\uf762\uf75e\uf6ab\uf6a0\uf757\uf76a\uf0be\uf0bc\uf0bf\uf75f\uf0be\uf0be\uf6a1\uf6a7\uf6a7\uf69e\uf0af\uf750\uf0ae\uf0ad\uf754\uf74a\uf0ad\uf0b2\uf743\uf75d\uf74e\uf741\uf745\uf742\uf6a0\uf69c\uf753\uf744\uf744\uf76a\uf6a0\uf0bc\uf753\uf6a6\uf76a\uf0ae\uf0ae\uf69c\uf0b4\uf6a0\uf74d\uf0b2\uf745\uf757\uf74b\uf69c\uf765\uf0b7\uf689\uf761\uf6a4\uf69d\uf0be\uf744\uf0a8\uf75f\uf0ae\uf6a4\uf0be\uf6a6\uf747\uf74d\uf74f\uf6a5\uf757\uf0ae\uf6aa\uf69f\uf688\uf0bf\uf75e\uf741\uf6a5\uf74a\uf752\uf0a8\uf6aa\uf740\uf0b7\uf69c\uf0bc\uf689\uf69f\uf74a\uf697\uf754\uf750\uf0bd\uf74b\uf0ad\uf6a2\uf6a7\uf6a5\uf6a5\uf6a7\uf6a4\uf694\uf697\uf742\uf0af\uf0bf\uf750\uf74f\uf75d\uf6a7\uf0af\uf0b2\uf744\uf0ae\uf0b2\uf0be\uf743\uf742\uf6a5\uf75d\uf752\uf765\uf0a9\uf0b1\uf76a\uf74b\uf744\uf69d\uf750\uf0b0\uf0b1\uf74e\uf741\uf749\uf746\uf697\uf74e\uf688\uf0b3\uf763\uf743\uf0b2\uf098\uf69e\uf098\uf69d\uf6a2\uf6a7\uf0a9\uf0be\uf6ab\uf69c\uf747\uf754\uf0b7\uf0bc\uf742\uf688\uf6a2\uf689\uf69f\uf760\uf697\uf747\uf697\uf6a2\uf0af\uf0bd\uf6a3\uf694\uf6a2\uf697\uf0ae\uf69f\uf749\uf0ae\uf0ae\uf6a1\uf743\uf749\uf74e\uf740\uf0bd\uf69f\uf69d\uf745\uf688\uf6a5\uf6a5\uf6a4\uf6a3\uf0a9\uf688\uf742\uf74f\uf74b\uf75e\uf745\uf0b1\uf757\uf6a5\uf0bf\uf6a5\uf0b1\uf74e\uf0a8\uf0a8\uf760\uf74a\uf6ab\uf743\uf6a2\uf689\uf0ad\uf6a1\uf6a3\uf75f\uf746\uf762\uf747\uf74b\uf69f\uf6a4\uf765\uf753\uf0af\uf689\uf744\uf753\uf751\uf746\uf6a0\uf749\uf751\uf6a3\uf754\uf6a1\uf747\uf69c\uf749\uf74f\uf0bd\uf75f\uf0bd\uf0b7\uf6f8\uf6ab\uf694\uf6a5\uf6a0\uf757\uf760\uf743\uf0b7\uf0b3\uf74e\uf6a7\uf0b1\uf757\uf69e\uf744\uf69c\uf746\uf69c\uf0a8\uf761\uf6ab\uf0a9\uf749\uf0ae\uf749\uf694\uf754\uf74a\uf6aa\uf69d\uf762\uf742\uf74b\uf74e\uf6a7\uf697\uf745\uf69f\uf6f8\uf752\uf0b0\uf740\uf0bd\uf745\uf746\uf0b3\uf0af\uf0b1\uf0b2\uf6a6\uf75d\uf6a6\uf0bc\uf6a1\uf753\uf697\uf763\uf6a2\uf6a4\uf6a7\uf0bd\uf75d\uf747\uf742\uf6a3\uf6f8\uf6a3\uf749\uf6a0\uf0b7\uf0b3\uf751\uf763\uf69c\uf6ab\uf0be\uf0bc\uf74b\uf76a\uf0b7\uf0b7\uf69c\uf69c\uf0af\uf74a\uf753\uf0b4\uf744\uf761\uf741\uf75e\uf74d\uf0a9\uf761\uf745\uf6f8\uf74e\uf750\uf69d\uf69f\uf6aa\uf0a8\uf0af\uf74d\uf742\uf6a1\uf6a1\uf747\uf0b7\uf694\uf742\uf6a6\uf760\uf69d\uf69d\uf694\uf744\uf75f\uf0b3\uf0bd\uf6a0\uf746\uf0b2\uf69d\uf6a2\uf69c\uf740\uf750\uf688\uf760\uf6f8\uf688\uf76a\uf753\uf0b0\uf0bf\uf0ad\uf742\uf0b0\uf6a3\uf6a4\uf74e\uf74b\uf0b7\uf743\uf75e\uf0b3\uf0a9\uf750\uf6a4\uf75f\uf749\uf69e\uf749\uf0af\uf763\uf6f8\uf0bc\uf75e\uf743\uf6a3\uf0bc\uf757\uf752\uf744\uf0b7\uf098\uf694\uf76a\uf0b1\uf6ab\uf69f\uf0bd\uf0b0\uf0b4\uf6a5\uf750\uf69d\uf0a9\uf69e\uf747\uf0af\uf6a7\uf6a1\uf6ab\uf0ad\uf6a5\uf746\uf74e\uf0b0\uf753\uf69c\uf0bf\uf0ae\uf6aa\uf74d\uf757\uf74f\uf752\uf689\uf75e\uf744\uf0b1\uf75e\uf0bf\uf688\uf098\uf765\uf743\uf098\uf69f\uf740\uf69e\uf751\uf0be\uf0ae\uf6a1\uf689\uf75e\uf0ae\uf0b7\uf0b1\uf0b4\uf0b1\uf0ad\uf6a3\uf6a2\uf0b2\uf762\uf743\uf0b4\uf749\uf6a6\uf689\uf69c\uf694\uf744\uf750\uf749\uf75d\uf0b3\uf6a1\uf752\uf0b0\uf750\uf0bd\uf0be\uf754\uf76a\uf0a8\uf743\uf69f\uf0a8\uf762\uf688\uf762\uf0a8\uf0b2\uf0bf\uf754\uf765\uf0af\uf740\uf69f\uf754\uf6a5\uf750\uf754\uf0bd\uf76a\uf6a2\uf75e\uf0af\uf098\uf69e\uf75e\uf0ae\uf76a\uf76a\uf0bd\uf74f\uf6a4\uf689\uf75d\uf751\uf760\uf0bc\uf744\uf69f\uf6a1\uf0b0\uf0b7\uf0b3\uf69f\uf0ae\uf753\uf74b\uf744\uf0ad\uf75f\uf757\uf746\uf6f8\uf765\uf0bc\uf6a4\uf74a\uf765\uf0b3\uf0bf\uf747\uf0b3\uf74a\uf0be\uf74d\uf6f8\uf0bf\uf0ad\uf6a4\uf69d\uf75d\uf6ab\uf762\uf0a9\uf75e\uf0af\uf74b\uf0bf\uf745\uf689\uf740\uf744\uf757\uf0b1\uf76a\uf762\uf765\uf6ab\uf6a4\uf745\uf6a1\uf75e\uf760\uf752\uf6f8\uf6a1\uf6a5\uf760\uf6a5\uf6a1\uf765\uf6a3\uf747\uf6a4\uf0af\uf741\uf69d\uf74a\uf6a2\uf75e\uf6f8\uf750\uf76a\uf0af\uf0b3\uf760\uf752\uf742\uf74d\uf752\uf0b0\uf0b0\uf0be\uf6aa\uf6a4\uf0b4\uf6a5\uf76a\uf69e\uf697\uf76a\uf0bd\uf743\uf69d\uf753\uf765\uf6a7\uf6ab\uf74d\uf762\uf69f\uf74f\uf75e\uf69f\uf694\uf6a0\uf743\uf0b3\uf74d\uf69d\uf6a0\uf0af\uf0b7\uf743\uf0bd\uf760\uf6a3\uf765\uf0ad\uf753\uf740\uf0bf\uf689\uf098\uf741\uf746\uf765\uf0b1\uf0b1\uf098\uf74b\uf744\uf765\uf697\uf6aa\uf763\uf6f8\uf694\uf6a6\uf745\uf0ae\uf0b7\uf6a3\uf0bc\uf69c\uf750\uf74a\uf694\uf744\uf74e\uf697\uf762\uf753\uf689\uf75f\uf746\uf744\uf746\uf0bc\uf75f\uf69f\uf751\uf753\uf0bf\uf0a9\uf762\uf689\uf6a3\uf761\uf740\uf74a\uf688\uf751\uf765\uf0bc\uf0bf\uf0b4\uf6a5\uf0b3\uf69c\uf746\uf6a5\uf0b0\uf0b4\uf0b3\uf6a6\uf763\uf745\uf747\uf0b0\uf75d\uf751\uf754\uf751\uf69e\uf746\uf74f\uf6a6\uf0b3\uf747\uf74e\uf74b\uf750\uf6aa\uf0ad\uf69e\uf0ad\uf754\uf763\uf0bf\uf754\uf745\uf6f8\uf6a4\uf750\uf747\uf6f8\uf761\uf6a1\uf0af\uf745\uf69e\uf762\uf747\uf757\uf697\uf69f\uf74d\uf750\uf0b0\uf69f\uf0bd\uf6a1\uf0b0\uf694\uf745\uf745\uf749\uf761\uf688\uf0ad\uf765\uf0b3\uf74e\uf742\uf689\uf6f8\uf0bc\uf0b3\uf765\uf745\uf75d\uf6a3\uf69f\uf74f\uf0b2\uf740\uf750\uf763\uf0b0\uf6a0\uf6a4\uf757\uf688\uf743\uf74d\uf760\uf762\uf747\uf6a3\uf74a\uf0be\uf753\uf757\uf754\uf69f\uf0bd\uf6a6\uf697\uf74a\uf746\uf740\uf6aa\uf0ae\uf0ae\uf740\uf0a8\uf761\uf745\uf746\uf742\uf69e\uf745\uf745\uf754\uf761\uf6a6\uf6a0\uf74d\uf741\uf69d\uf753\uf0a9\uf0ae\uf69e\uf741\uf0ad\uf741\uf0bf\uf0bd\uf742\uf744\uf69e\uf74d\uf0bf\uf098\uf697\uf74d\uf762\uf760\uf0ad\uf765\uf0be\uf6a6\uf0bc\uf751\uf74e\uf0b3\uf745\uf0bf\uf0b4\uf76a\uf6a4\uf743\uf0b3\uf098\uf740\uf6ab\uf754\uf74e\uf0b1\uf754\uf76a\uf741\uf740\uf765\uf6ab\uf6a6\uf0af\uf6a4\uf762\uf0b1\uf6a0\uf760\uf6aa\uf740\uf741\uf6a7\uf69c\uf0b7\uf69c\uf0be\uf697\uf0b0\uf0af\uf746\uf743\uf75e\uf75d\uf763\uf0bc\uf69e\uf742\uf743\uf746\uf75f\uf0b0\uf689\uf0af\uf098\uf69c\uf750\uf757\uf741\uf754\uf749\uf0b4\uf743\uf69c\uf6a7\uf761\uf0b3\uf744\uf0be\uf745\uf6a7\uf694\uf694\uf69f\uf69e\uf747\uf6a2\uf74d\uf6aa\uf757\uf742\uf74e\uf765\uf761\uf6a5\uf749\uf69c\uf6a5\uf74d\uf744\uf74f\uf74b\uf75d\uf688\uf745\uf74a\uf0be\uf6a0\uf765\uf765\uf0b7\uf74b\uf750\uf69c\uf0b0\uf6aa\uf753\uf6a3\uf69f\uf098\uf751\uf0bc\uf757\uf751\uf6a2\uf744\uf75d\uf74e\uf0b4\uf0a9\uf749\uf76a\uf747\uf74e\uf6aa\uf6f8\uf744\uf0ad\uf0a9\uf0b2\uf749\uf74b\uf765\uf761\uf0b2\uf0b4\uf0bd\uf751\uf688\uf0a9\uf688\uf6ab\uf6a6\uf6a4\uf750\uf749\uf744\uf0bd\uf74a\uf750\uf6a1\uf689\uf760\uf0a9\uf744\uf74a\uf75f\uf6a0\uf746\uf0a9\uf688\uf744\uf74a\uf0bc\uf6a6\uf0b7\uf69f\uf74f\uf0bc\uf69e\uf751\uf6a2\uf749\uf761\uf745\uf750\uf0af\uf761\uf6a2\uf765\uf6a3\uf69e\uf0ad\uf6a4\uf740\uf743\uf697\uf0ae\uf0a9\uf0b3\uf75d\uf753\uf694\uf754\uf6a3\uf69e\uf69f\uf750\uf0b4\uf0a8\uf6aa\uf76a\uf6a2\uf69c\uf75d\uf0b0\uf6a3\uf744\uf6a7\uf741\uf6aa\uf744\uf754\uf69d\uf76a\uf0bd\uf69e\uf6a2\uf0a8\uf6a3\uf752\uf760\uf74d\uf74a\uf0b3\uf761\uf757\uf098\uf69d\uf0be\uf74a\uf753\uf754\uf74e\uf0bf\uf6a1\uf760\uf753\uf0af\uf747\uf74d\uf75e\uf697\uf74b\uf6a2\uf0bf\uf74d\uf0a8\uf69d\uf6a5\uf098\uf752\uf6a1\uf754\uf750\uf0be\uf697\uf0b7\uf69c\uf74d\uf742\uf75e\uf0bd\uf741\uf0bc\uf6a6\uf0be\uf761\uf69e\uf69f\uf754\uf0b4\uf751\uf761\uf753\uf6a6\uf74b\uf740\uf753\uf0b0\uf753\uf6a5\uf763\uf694\uf689\uf0ae\uf0bf\uf098\uf740\uf69e\uf6a4\uf749\uf0ae\uf688\uf743\uf75e\uf69d\uf743\uf689\uf689\uf6a6\uf74d\uf6aa\uf6a1\uf69f\uf688\uf0ad\uf745\uf76a\uf746\uf689\uf741\uf6a3\uf0be\uf0ad\uf689\uf6a0\uf76a\uf6ab\uf742\uf762\uf744\uf69d\uf760\uf0b1\uf6a6\uf74f\uf74e\uf0b7\uf745\uf0be\uf0ae\uf75f\uf74e\uf6a0\uf69d\uf098\uf697\uf6ab\uf742\uf6a0\uf744\uf69f\uf741\uf6a3\uf752\uf69d\uf75e\uf6a0\uf69e\uf689\uf6aa\uf765\uf0b7\uf0be\uf74a\uf098\uf6ab\uf740\uf0b4\uf745\uf744\uf0b3\uf753\uf0bc\uf752\uf747\uf6f8\uf744\uf6ab\uf74d\uf76a\uf0bc\uf6a2\uf6ab\uf0ae\uf69e\uf746\uf762\uf745\uf749\uf0ae\uf69f\uf750\uf6ab\uf688\uf6a1\uf763\uf75e\uf6a0\uf0b7\uf0b0\uf69e\uf0be\uf0af\uf747\uf69c\uf74e\uf098\uf75d\uf742\uf745\uf6a2\uf760\uf751\uf694\uf6a1\uf75f\uf6f8\uf6a5\uf740\uf74e\uf765\uf69e\uf689\uf0ae\uf69c\uf74a\uf6a0\uf760\uf74a\uf74d\uf0b3\uf6a0\uf75f\uf69f\uf742\uf749\uf0b4\uf751\uf0b0\uf741\uf76a\uf0bf\uf0ae\uf740\uf689\uf69c\uf753\uf763\uf753\uf6a0\uf740\uf74e\uf765\uf0ae\uf0bf\uf6a7\uf74a\uf74b\uf745\uf69f\uf76a\uf751\uf744\uf6a5\uf0bd\uf6f8\uf69c\uf0ae\uf0a8\uf6a0\uf69e\uf744\uf763\uf741\uf751\uf743\uf0a9\uf75d\uf744\uf750\uf744\uf74f\uf69c\uf0b7\uf0b7\uf74a\uf69e\uf6a7\uf760\uf0a8\uf762\uf753\uf74e\uf688\uf751\uf0a9\uf6a2\uf0ae\uf750\uf74d\uf697\uf754\uf6a3\uf751\uf0af\uf0a9\uf6a4\uf0be\uf0bc\uf749\uf6f8\uf763\uf751\uf75f\uf747\uf0bd\uf69c\uf749\uf6a0\uf689\uf754\uf689\uf0b0\uf689\uf760\uf76a\uf69c\uf751\uf744\uf0a8\uf74d\uf6a4\uf689\uf0a8\uf763\uf6a5\uf740\uf688\uf74e\uf754\uf754\uf745\uf69c\uf0a9\uf6aa\uf0a9\uf6f8\uf75e\uf744\uf760\uf760\uf6a5\uf0b0\uf741\uf0b7\uf750\uf6a0\uf0a9\uf0af\uf098\uf765\uf0a8\uf697\uf74a\uf740\uf6a7\uf740\uf75e\uf0b1\uf765\uf697\uf6f8\uf0a9\uf6aa\uf74e\uf743\uf6a3\uf750\uf6f8\uf69c\uf0be\uf0bc\uf6a4\uf6a1\uf0af\uf0b1\uf688\uf74d\uf75e\uf688\uf742\uf751\uf69d\uf6a5\uf6aa\uf0ad\uf74e\uf6aa\uf694\uf754\uf0b2\uf69e\uf0b7\uf6aa\uf74f\uf6a2\uf74a\uf0be\uf0af\uf6a4\uf0bf\uf740\uf0a8\uf75e\uf741\uf76a\uf69f\uf760\uf6a7\uf760\uf69e\uf0b3\uf0a9\uf6a2\uf6a6\uf0ae\uf0b2\uf76a\uf0b7\uf74e\uf6a6\uf098\uf0a8\uf689\uf74b\uf0b2\uf762\uf69f\uf761\uf741\uf742\uf761\uf694\uf6a5\uf752\uf69d\uf75f\uf6ab\uf688\uf6a2\uf76a\uf6a6\uf750\uf74e\uf0ad\uf742\uf69f\uf0bf\uf6a0\uf098\uf0a9\uf754\uf749\uf749\uf0bf\uf750\uf6aa\uf757\uf75f\uf6a4\uf763\uf0ae\uf752\uf751\uf747\uf0b3\uf0af\uf0ae\uf0ad\uf751\uf0ae\uf0a8\uf763\uf6a6\uf0ad\uf751\uf69e\uf75e\uf69d\uf6ab\uf763\uf742\uf0ad\uf74e\uf69c\uf6a6\uf741\uf761\uf749\uf740\uf688\uf0b4\uf69d\uf752\uf6a2\uf753\uf0b3\uf6a2\uf0b3\uf69e\uf0ae\uf0b4\uf0b7\uf6a6\uf745\uf69c\uf75e\uf689\uf760\uf741\uf757\uf6a6\uf0a9\uf6a3\uf697\uf746\uf69c\uf0bd\uf6aa\uf0b1\uf765\uf688\uf0be\uf69d\uf6a3\uf69f\uf69f\uf69d\uf74d\uf74e\uf0b1\uf69e\uf747\uf69c\uf746\uf6a3\uf763\uf0ad\uf69c\uf0bc\uf761\uf741\uf0bc\uf74f\uf0be\uf0b2\uf0b7\uf744\uf746\uf763\uf0ae\uf6a1\uf69f\uf749\uf697\uf75e\uf6a4\uf0b3\uf0b3\uf74b\uf69c\uf0a8\uf757\uf75f\uf753\uf752\uf757\uf74d\uf74d\uf752\uf6a0\uf751\uf0b1\uf742\uf688\uf69f\uf6a5\uf757\uf0bd\uf744\uf6ab\uf69e\uf0b1\uf757\uf0b2\uf749\uf0b4\uf6a2\uf0af\uf69f\uf749\uf6ab\uf0ad\uf742\uf6a1\uf694\uf763\uf6a7\uf754\uf6a4\uf752\uf761\uf760\uf0a9\uf74b\uf0b7\uf742\uf751\uf74b\uf0b3\uf0b7\uf0b3\uf745\uf098\uf6f8\uf75d\uf6ab\uf0b4\uf688\uf0bf\uf0b3\uf0ae\uf757\uf6a1\uf0b7\uf694\uf694\uf741\uf6a5\uf0ae\uf6f8\uf0bc\uf749\uf74a\uf6a0\uf74b\uf743\uf6a6\uf0bd\uf0bd\uf741\uf0a8\uf757\uf0bf\uf0bd\uf742\uf6f8\uf747\uf76a\uf0a8\uf761\uf69e\uf0b3\uf697\uf697\uf743\uf753\uf0ad\uf763\uf741\uf0ae\uf6a3\uf0ad\uf0b2\uf6a3\uf6ab\uf754\uf689\uf74b\uf762\uf765\uf74f\uf6a5\uf6a5\uf688\uf0a8\uf747\uf0be\uf69d\uf6aa\uf751\uf751\uf69c\uf6f8\uf697\uf74b\uf0a8\uf741\uf745\uf74e\uf760\uf697\uf697\uf740\uf765\uf0be\uf6a3\uf754\uf69e\uf752\uf75d\uf0ae\uf6a2\uf74d\uf6ab\uf762\uf750\uf6a6\uf74b\uf74e\uf6f8\uf0ae\uf6a7\uf74a\uf0bc\uf694\uf750\uf0bd\uf0b1\uf0b1\uf757\uf0ae\uf753\uf694\uf740\uf74d\uf74a\uf694\uf6f8\uf747\uf763\uf754\uf6a6\uf746\uf688\uf0ad\uf74d\uf0a8\uf6a4\uf6aa\uf098\uf6a1\uf743\uf0ad\uf6a4\uf69c\uf6aa\uf74e\uf6a4\uf098\uf0be\uf757\uf0bd\uf757\uf697\uf0a8\uf6a1\uf746\uf6aa\uf753\uf0a8\uf098\uf74d\uf765\uf6aa\uf74b\uf6a6\uf689\uf74e\uf753\uf098\uf741\uf697\uf0b0\uf6a2\uf6a5\uf0ad\uf69c\uf0a9\uf688\uf752\uf754\uf69d\uf0ae\uf0b1\uf74f\uf745\uf74e\uf6a1\uf752\uf749\uf0ae\uf744\uf742\uf0bf\uf743\uf6a6\uf0b2\uf0ae\uf752\uf69f\uf0af\uf6a5\uf74b\uf0ae\uf740\uf740\uf6a2\uf6a4\uf746\uf747\uf763\uf0bc\uf689\uf0a8\uf0af\uf69f\uf74e\uf76a\uf763\uf0a8\uf6a5\uf0b2\uf0bf\uf6f8\uf6a4\uf0b7\uf697\uf6a1\uf697\uf0bf\uf697\uf0a9\uf75e\uf0a9\uf745\uf6a3\uf697\uf0bc\uf098\uf0be\uf0bc\uf762\uf6a4\uf6a6\uf76a\uf752\uf74a\uf0b3\uf6a2\uf6a3\uf6ab\uf69e\uf743\uf744\uf098\uf6a7\uf69c\uf740\uf746\uf0b2\uf742\uf754\uf749\uf76a\uf0b3\uf742\uf760\uf0a9\uf74e\uf76a\uf742\uf0b0\uf6a5\uf0bc\uf69d\uf761\uf6a5\uf761\uf0a8\uf0a9\uf689\uf697\uf0b0\uf745\uf741\uf6aa\uf750\uf763\uf74f\uf69d\uf0ae\uf69e\uf757\uf0ae\uf689\uf69c\uf6a6\uf098\uf745\uf0af\uf69d\uf743\uf0af\uf0ad\uf098\uf69d\uf6f8\uf0bc\uf752\uf69f\uf74e\uf75d\uf751\uf69f\uf0b3\uf76a\uf0bf\uf761\uf740\uf0b0\uf0b1\uf754\uf6a3\uf6f8\uf098\uf6a4\uf750\uf76a\uf74d\uf0be\uf697\uf0a8\uf6aa\uf749\uf69e\uf74a\uf0b1\uf6a5\uf098\uf763\uf6a3\uf745\uf74f\uf6a1\uf69f\uf749\uf761\uf0ad\uf098\uf69f\uf749\uf0bf\uf74a\uf0bd\uf754\uf0b3\uf749\uf6a3\uf74b\uf765\uf75e\uf75d\uf754\uf69e\uf6a4\uf0bf\uf69c\uf754\uf6a0\uf762\uf74e\uf743\uf753\uf760\uf74f\uf6a3\uf0b1\uf688\uf763\uf6a2\uf6a6\uf0b1\uf741\uf6a3\uf0ae\uf69e\uf6a2\uf0ad\uf740\uf6a4\uf098\uf689\uf74f\uf76a\uf0bc\uf6a0\uf763\uf75f\uf0b1\uf74f\uf74e\uf6f8\uf69c\uf762\uf75f\uf0af\uf0bc\uf689\uf762\uf745\uf688\uf0bf\uf74d\uf743\uf0b1\uf0bf\uf74d\uf749\uf750\uf740\uf69d\uf763\uf69e\uf6a6\uf74f\uf0bc\uf0a9\uf6a1\uf753\uf6a6\uf757\uf6a3\uf760\uf74a\uf69d\uf6a3\uf6a3\uf74b\uf75d\uf6a1\uf745\uf6a6\uf743\uf0bd\uf694\uf0b3\uf751\uf75d\uf6a3\uf6a6\uf747\uf741\uf0b7\uf6a2\uf6a0\uf753\uf0af\uf741\uf762\uf747\uf6ab\uf69d\uf6aa\uf6a1\uf0b4\uf744\uf75d\uf752\uf74b\uf0a9\uf6ab\uf688\uf75d\uf6f8\uf0b0\uf0b0\uf6a1\uf74e\uf745\uf744\uf761\uf74f\uf0bd\uf6a2\uf75d\uf744\uf6f8\uf760\uf69e\uf688\uf0ad\uf6a3\uf694\uf761\uf6f8\uf6a0\uf0b7\uf0b1\uf75e\uf0b4\uf69c\uf762\uf0b1\uf761\uf760\uf0be\uf746\uf6a2\uf69f\uf744\uf0b2\uf0a8\uf6a6\uf6ab\uf6a3\uf747\uf741\uf6a2\uf74e\uf745\uf761\uf741\uf6a1\uf74f\uf6a1\uf6a4\uf69d\uf75e\uf743\uf6f8\uf744\uf0b2\uf749\uf760\uf0bd\uf742\uf747\uf6a6\uf0af\uf74b\uf098\uf0b7\uf697\uf6ab\uf76a\uf761\uf747\uf750\uf747\uf75e\uf745\uf0bf\uf75d\uf75f\uf0ae\uf0ad\uf76a\uf0b0\uf0b4\uf762\uf0bc\uf749\uf6a6\uf0b2\uf765\uf0ae\uf0af\uf744\uf69d\uf0ae\uf6a3\uf0a8\uf750\uf76a\uf746\uf0a9\uf689\uf74b\uf69c\uf697\uf740\uf74b\uf762\uf0b7\uf75e\uf6a4\uf0be\uf688\uf757\uf754\uf0be\uf6a6\uf697\uf751\uf741\uf0bc\uf74e\uf6a7\uf688\uf6a2\uf0b7\uf751\uf750\uf75f\uf74e\uf745\uf740\uf743\uf6a5\uf0b2\uf694\uf0bd\uf0b1\uf69c\uf6aa\uf688\uf742\uf760\uf0ad\uf762\uf0a8\uf688\uf765\uf757\uf74e\uf697\uf098\uf6a1\uf689\uf0bd\uf741\uf694\uf752\uf69e\uf74b\uf743\uf75f\uf749\uf689\uf75d\uf0ad\uf74d\uf745\uf762\uf6aa\uf69d\uf750\uf750\uf6a5\uf747\uf75e\uf747\uf754\uf0b3\uf0a9\uf689\uf0b3\uf6f8\uf0ad\uf757\uf0bc\uf74d\uf0b1\uf6f8\uf0b2\uf0b1\uf765\uf689\uf6a5\uf0af\uf761\uf74e\uf098\uf0a8\uf6a1\uf745\uf76a\uf745\uf76a\uf6ab\uf0b2\uf0af\uf0a9\uf098\uf6a4\uf743\uf763\uf0a9\uf0b2\uf75e\uf744\uf69f\uf751\uf6ab\uf75e\uf0af\uf69d\uf69e\uf0bc\uf69d\uf098\uf0b7\uf761\uf69d\uf744\uf0b3\uf74e\uf0bf\uf689\uf75d\uf0b7\uf74d\uf750\uf0b4\uf0b3\uf0b4\uf760\uf760\uf761\uf754\uf69e\uf689\uf6a5\uf0b4\uf689\uf74f\uf765\uf6a7\uf689\uf74a\uf752\uf746\uf749\uf75f\uf697\uf0b4\uf761\uf747\uf747\uf0be\uf6a2\uf0b0\uf6a7\uf6a3\uf751\uf0af\uf69e\uf753\uf754\uf754\uf0b4\uf752\uf6f8\uf6ab\uf6f8\uf6ab\uf762\uf74d\uf743\uf762\uf6f8\uf0b3\uf6a2\uf745\uf741\uf753\uf743\uf6a4\uf763\uf69e\uf752\uf753\uf75f\uf74f\uf6a3\uf76a\uf0bc\uf6a3\uf6ab\uf0ae\uf75f\uf0af\uf0bd\uf751\uf0b2\uf0be\uf6a1\uf0ae\uf0b4\uf688\uf76a\uf69c\uf098\uf763\uf6f8\uf0b0\uf75e\uf689\uf6ab\uf753\uf742\uf0bd\uf74b\uf694\uf0be\uf69f\uf0b0\uf6f8\uf740\uf760\uf0b2\uf74a\uf752\uf0b4\uf75d\uf745\uf0a9\uf0af\uf76a\uf0a9\uf740\uf6a2\uf742\uf0af\uf743\uf0b0\uf0b2\uf6a6\uf697\uf69c\uf0b2\uf751\uf746\uf69f\uf757\uf751\uf761\uf765\uf6a3\uf6a2\uf0ad\uf751\uf76a\uf752\uf0bc\uf0bf\uf765\uf765\uf750\uf0b3\uf0b2\uf74b\uf745\uf6a3\uf6a0\uf74b\uf743\uf0b0\uf6ab\uf740\uf743\uf0b1\uf750\uf69f\uf098\uf750\uf6a3\uf69c\uf749\uf750\uf75d\uf742\uf0a9\uf0b7\uf697\uf0ad\uf75f\uf0be\uf0ae\uf6aa\uf694\uf0a8\uf0b3\uf74e\uf742\uf75f\uf745\uf75e\uf741\uf0bf\uf74f\uf754\uf74d\uf0a8\uf0b1\uf74b\uf0b3\uf6a6\uf74b\uf745\uf0b0\uf757\uf6a0\uf743\uf754\uf69c\uf0b2\uf6a6\uf098\uf69c\uf6a1\uf75f\uf746\uf752\uf763\uf760\uf747\uf742\uf75d\uf75f\uf0bd\uf746\uf75f\uf750\uf6aa\uf74f\uf746\uf69f\uf69d\uf743\uf69d\uf0a9\uf0bf\uf740\uf754\uf69c\uf740\uf760\uf6a2\uf6f8\uf754\uf744\uf753\uf6a4\uf0af\uf0ae\uf0b3\uf74f\uf761\uf0bd\uf760\uf760\uf0a8\uf0be\uf0bd\uf0a9\uf765\uf750\uf0b0\uf697\uf689\uf0bd\uf749\uf69d\uf761\uf763\uf740\uf750\uf0a9\uf0bf\uf765\uf0bc\uf689\uf6a7\uf75f\uf74f\uf6ab\uf743\uf0b7\uf743\uf0a8\uf0bd\uf0af\uf757\uf746\uf74a\uf0b1\uf0b0\uf0b3\uf760\uf744\uf0ae\uf74a\uf0a8\uf69e\uf0b3\uf760\uf74a\uf754\uf751\uf6f8\uf0b7\uf74b\uf6a4\uf76a\uf74e\uf69d\uf0bf\uf0bd\uf0a8\uf0be\uf75d\uf75e\uf76a\uf688\uf0ae\uf744\uf757\uf746\uf6aa\uf6aa\uf6a0\uf0bf\uf69f\uf0ae\uf751\uf6a4\uf747\uf69d\uf74d\uf697\uf74a\uf688\uf75e\uf0b7\uf69c\uf6a1\uf74b\uf740\uf742\uf751\uf0a8\uf0b7\uf0b0\uf0ad\uf69e\uf6aa\uf740\uf0ad\uf0b4\uf69d\uf765\uf762\uf760\uf6a1\uf745\uf749\uf0b1\uf740\uf688\uf0bc\uf697\uf754\uf0b0\uf74a\uf689\uf0ad\uf098\uf750\uf74a\uf69e\uf745\uf6a7\uf69c\uf752\uf760\uf752\uf754\uf69d\uf757\uf742\uf0b4\uf74d\uf6a6\uf6a6\uf0b1\uf751\uf75e\uf0af\uf0a9\uf753\uf6a1\uf69c\uf0ae\uf742\uf6a2\uf749\uf750\uf0bd\uf6a5\uf6a0\uf6a1\uf0be\uf744\uf69e\uf69d\uf75f\uf752\uf743\uf740\uf760\uf0a8\uf69c\uf098\uf0bf\uf754\uf750\uf6a3\uf6a4\uf0af\uf74f\uf0be\uf0b2\uf6aa\uf689\uf69e\uf761\uf75f\uf6a1\uf0af\uf765\uf0b0\uf749\uf747\uf0b2\uf0b0\uf746\uf757\uf6a4\uf0b2\uf0b7\uf75e\uf6a3\uf6a7\uf6a2\uf74d\uf741\uf6ab\uf74d\uf742\uf763\uf0bf\uf0b7\uf6a3\uf757\uf746\uf74a\uf0a8\uf6a2\uf752\uf0a8\uf689\uf74e\uf763\uf69c\uf0a8\uf0a8\uf742\uf6a1\uf747\uf0be\uf746\uf6f8\uf6a1\uf75e\uf6a2\uf69e\uf69d\uf74d\uf0ae\uf6a2\uf757\uf697\uf76a\uf744\uf744\uf75f\uf74b\uf747\uf6a5\uf746\uf6a2\uf74d\uf0ad\uf746\uf757\uf0b2\uf741\uf6f8\uf6f8\uf0b2\uf0bd\uf74d\uf742\uf762\uf744\uf740\uf74f\uf69d\uf694\uf752\uf741\uf0a8\uf6ab\uf6a6\uf6f8\uf74e\uf763\uf751\uf098\uf0b0\uf697\uf747\uf69e\uf740\uf098\uf74a\uf6aa\uf6a4\uf0bc\uf6a7\uf0b7\uf751\uf0a8\uf6a5\uf74e\uf750\uf688\uf762\uf76a\uf742\uf753\uf751\uf69c\uf6a3\uf0bc\uf0bf\uf69c\uf6ab\uf0b3\uf753\uf749\uf746\uf0b7\uf6a6\uf697\uf0a8\uf6a2\uf761\uf743\uf74f\uf742\uf0b1\uf745\uf6ab\uf752\uf0b4\uf6ab\uf765\uf757\uf742\uf6a7\uf0be\uf6f8\uf69d\uf6a0\uf742\uf69d\uf743\uf754\uf69d\uf765\uf6a3\uf0b3\uf749\uf69d\uf74a\uf0af\uf752\uf6a4\uf754\uf75d\uf74b\uf752\uf74d\uf0bc\uf0bd\uf754\uf760\uf0ae\uf0a8\uf6a3\uf0bf\uf754\uf757\uf0a8\uf688\uf0b1\uf746\uf69e\uf6a4\uf6ab\uf6f8\uf754\uf744\uf74b\uf6a1\uf6a7\uf0be\uf746\uf6a5\uf741\uf763\uf752\uf0b0\uf752\uf0be\uf697\uf751\uf761\uf74f\uf0b0\uf743\uf763\uf757\uf0a8\uf741\uf754\uf6a6\uf6a4\uf6a3\uf757\uf746\uf751\uf69c\uf0b2\uf6a0\uf0b3\uf6a7\uf74a\uf0b7\uf75d\uf761\uf75d\uf744\uf0a8\uf6a5\uf0b3\uf6a1\uf753\uf0a8\uf0b4\uf75f\uf0be\uf762\uf745\uf751\uf74b\uf0b1\uf747\uf75f\uf689\uf0be\uf6a2\uf742\uf741\uf098\uf0af\uf0be\uf0ae\uf0af\uf6aa\uf69c\uf0bf\uf751\uf6a1\uf6aa\uf74d\uf0bf\uf743\uf74f\uf74a\uf757\uf69e\uf74e\uf754\uf762\uf762\uf6a4\uf0b2\uf0ae\uf0b3\uf761\uf74b\uf746\uf697\uf098\uf747\uf75e\uf744\uf757\uf752\uf0bf\uf6a7\uf760\uf740\uf74d\uf750\uf752\uf0be\uf6a5\uf69c\uf6a6\uf688\uf742\uf0bd\uf76a\uf0b0\uf74d\uf744\uf6a1\uf75d\uf69e\uf69e\uf74d\uf0bf\uf749\uf6a7\uf757\uf688\uf757\uf6a5\uf0b3\uf6a4\uf746\uf6a7\uf6a4\uf0bc\uf0a9\uf6a7\uf751\uf6a2\uf752\uf0bf\uf098\uf6a0\uf751\uf763\uf6f8\uf757\uf0a8\uf74d\uf6ab\uf6ab\uf747\uf747\uf6a7\uf74f\uf74d\uf747\uf75d\uf0b0\uf75e\uf0af\uf69f\uf757\uf0b4\uf753\uf0bc\uf747\uf697\uf74f\uf74f\uf0a9\uf0a8\uf74f\uf0b4\uf763\uf0a9\uf750\uf0ae\uf694\uf757\uf753\uf0b3\uf6a7\uf0b7\uf0be\uf6a2\uf6aa\uf69c\uf763\uf742\uf0bc\uf75d\uf761\uf6aa\uf6a4\uf75f\uf765\uf6f8\uf69d\uf0b0\uf747\uf746\uf6aa\uf69c\uf74b\uf6a1\uf751\uf753\uf74e\uf0b7\uf6a1\uf6f8\uf750\uf74b\uf69f\uf76a\uf744\uf74d\uf0ad\uf688\uf740\uf0b3\uf74f\uf742\uf0a9\uf740\uf749\uf0b2\uf0bd\uf750\uf757\uf6f8\uf74d\uf6a0\uf69c\uf0b3\uf0bf\uf6a2\uf763\uf6a6\uf75d\uf741\uf751\uf6a5\uf697\uf0b0\uf740\uf761\uf0ad\uf6a2\uf6a4\uf751\uf752\uf0af\uf74d\uf697\uf69f\uf6aa\uf0b4\uf740\uf746\uf0bd\uf742\uf762\uf750\uf76a\uf6a7\uf0ad\uf746\uf0b7\uf6aa\uf6aa\uf765\uf0a8\uf74e\uf6aa\uf6a5\uf751\uf69c\uf757\uf0ad\uf0bd\uf69c\uf0b3\uf0bd\uf754\uf74b\uf740\uf0a9\uf74f\uf74d\uf6a2\uf753\uf742\uf6a1\uf0af\uf0b3\uf75d\uf6a7\uf0b0\uf6aa\uf6a2\uf74f\uf6a7\uf760\uf6a5\uf6a0\uf744\uf744\uf6a7\uf694\uf689\uf753\uf697\uf6f8\uf752\uf760\uf0bf\uf6a4\uf689\uf747\uf69c\uf6f8\uf0b7\uf740\uf6a6\uf74b\uf741\uf6a1\uf6ab\uf74d\uf0a9\uf747\uf694\uf744\uf753\uf740\uf0b2\uf740\uf742\uf6a3\uf694\uf76a\uf0b2\uf697\uf6aa\uf689\uf742\uf76a\uf753\uf098\uf6aa\uf0b0\uf69d\uf751\uf741\uf740\uf741\uf098\uf740\uf74b\uf761\uf0bd\uf69c\uf752\uf0ae\uf762\uf754\uf742\uf741\uf763\uf760\uf74e\uf0b7\uf757\uf6a7\uf6a1\uf6a0\uf753\uf752\uf75d\uf751\uf74b\uf6a0\uf74b\uf76a\uf6a7\uf757\uf74b\uf6aa\uf740\uf0b0\uf742\uf6a6\uf760\uf69f\uf765\uf0b4\uf0ad\uf6a5\uf69c\uf0b4\uf0af\uf6a4\uf0b7\uf75d\uf75f\uf6a5\uf76a\uf745\uf757\uf743\uf6aa\uf751\uf0be\uf0bc\uf76a\uf762\uf689\uf0bd\uf689\uf0b0\uf74e\uf74d\uf6ab\uf740\uf0bf\uf746\uf694\uf0b4\uf6aa\uf6a2\uf0a8\uf746\uf69e\uf752\uf697\uf694\uf6aa\uf0af\uf6a5\uf757\uf745\uf751\uf746\uf0b4\uf688\uf6a1\uf6a5\uf694\uf688\uf69d\uf6a4\uf69c\uf0a9\uf742\uf6f8\uf69e\uf0bd\uf746\uf75e\uf6f8\uf753\uf6aa\uf0b7\uf763\uf0ad\uf6a6\uf765\uf6a7\uf6a4\uf763\uf75f\uf0bd\uf74e\uf76a\uf763\uf0ae\uf6ab\uf6a5\uf74e\uf741\uf752\uf6a6\uf694\uf74a\uf745\uf0b4\uf69f\uf757\uf6a6\uf0b7\uf6a6\uf6a3\uf697\uf741\uf6a2\uf6a1\uf0bd\uf75d\uf752\uf753\uf745\uf0b2\uf0b1\uf745\uf0a8\uf743\uf754\uf6a1\uf760\uf0a9\uf745\uf69f\uf747\uf6a0\uf6a4\uf75f\uf694\uf740\uf0b2\uf0bd\uf0ae\uf0b3\uf76a\uf76a\uf741\uf6ab\uf74f\uf74f\uf6a3\uf697\uf689\uf741\uf0bd\uf751\uf74f\uf0bd\uf6a2\uf69d\uf6ab\uf75e\uf75f\uf741\uf76a\uf0b3\uf765\uf6a2\uf6a4\uf69e\uf0bc\uf760\uf76a\uf689\uf751\uf0b7\uf6a0\uf744\uf0ae\uf0b1\uf0bf\uf0bf\uf688\uf0b3\uf6ab\uf765\uf743\uf6a6\uf760\uf75e\uf6ab\uf745\uf69d\uf75e\uf0b3\uf0b4\uf6a0\uf689\uf763\uf098\uf0b3\uf765\uf0b7\uf689\uf751\uf75e\uf744\uf694\uf746\uf6a3\uf689\uf740\uf0bd\uf688\uf69f\uf6a0\uf0a9\uf69e\uf0b2\uf0b4\uf74b\uf69d\uf0be\uf75f\uf75e\uf740\uf757\uf6a0\uf6a5\uf746\uf762\uf0b0\uf69c\uf0bd\uf0ad\uf743\uf6a7\uf697\uf760\uf6a6\uf0be\uf762\uf0b4\uf763\uf753\uf0ae\uf751\uf751\uf743\uf74a\uf694\uf762\uf697\uf74f\uf6a5\uf0af\uf76a\uf0bd\uf0b7\uf751\uf743\uf6a6\uf0b0\uf6f8\uf741\uf6a6\uf74a\uf0b1\uf74b\uf0ae\uf0ae\uf6a5\uf69d\uf747\uf744\uf69f\uf0b3\uf757\uf741\uf69c\uf0bc\uf6a3\uf0b7\uf0b0\uf6a2\uf752\uf0af\uf6f8\uf6a7\uf6a1\uf0be\uf752\uf689\uf0ae\uf6ab\uf0bf\uf0b1\uf744\uf6a3\uf753\uf744\uf0bd\uf689\uf688\uf0b2\uf740\uf74b\uf0b4\uf689\uf6f8\uf688\uf754\uf697\uf0a9\uf689\uf6a4\uf6a2\uf0bc\uf763\uf6ab\uf75d\uf689\uf74f\uf754\uf688\uf745\uf6a3\uf749\uf6a5\uf750\uf0a8\uf743\uf74b\uf6a1\uf0b2\uf74b\uf75e\uf0b4\uf69c\uf688\uf75e\uf75d\uf761\uf697\uf6a3\uf0b3\uf749\uf741\uf0bc\uf69e\uf740\uf762\uf0b2\uf747\uf742\uf74e\uf752\uf6ab\uf6a5\uf6a1\uf761\uf746\uf743\uf76a\uf0a9\uf6a0\uf753\uf6a5\uf76a\uf098\uf743\uf762\uf0bc\uf765\uf69d\uf74a\uf0bf\uf0ad\uf0ad\uf0bf\uf744\uf69e\uf74a\uf69d\uf74f\uf74f\uf0af\uf69c\uf761\uf75d\uf0bd\uf750\uf0b4\uf697\uf0b2\uf0ad\uf740\uf74a\uf750\uf689\uf74b\uf74a\uf74d\uf75d\uf74a\uf753\uf76a\uf75e\uf697\uf688\uf76a\uf0ad\uf69f\uf6a6\uf0bc\uf75f\uf74d\uf760\uf76a\uf746\uf6a6\uf76a\uf76a\uf69c\uf0ad\uf688\uf6a2\uf688\uf6f8\uf0b7\uf6a1\uf69f\uf765\uf749\uf0b7\uf0af\uf69c\uf0a9\uf0ae\uf6ab\uf697\uf69f\uf0ae\uf75e\uf762\uf0a9\uf749\uf69c\uf6a0\uf69c\uf740\uf0b2\uf0af\uf6a5\uf757\uf0bc\uf747\uf0ae\uf6ab\uf752\uf6f8\uf697\uf0be\uf0bc\uf69e\uf74a\uf0b0\uf6a3\uf740\uf74e\uf74b\uf694\uf0a9\uf0bf\uf69d\uf6a4\uf6a2\uf689\uf0b2\uf0be\uf0ae\uf6a6\uf750\uf747\uf6ab\uf0bd\uf0b2\uf75f\uf749\uf0b3\uf0b7\uf697\uf0b3\uf762\uf74e\uf762\uf0af\uf74b\uf0a8\uf694\uf751\uf74b\uf740\uf74e\uf6a0\uf0ae\uf6ab\uf74d\uf0b0\uf0ad\uf747\uf75f\uf74f\uf6a0\uf6f8\uf697\uf744\uf760\uf763\uf0b4\uf6a4\uf76a\uf6a2\uf74b\uf6a5\uf762\uf747\uf697\uf762\uf745\uf763\uf69e\uf750\uf750\uf76a\uf0be\uf76a\uf098\uf6a2\uf754\uf762\uf749\uf742\uf688\uf745\uf6aa\uf742\uf689\uf750\uf6f8\uf0b3\uf0ae\uf740\uf6f8\uf750\uf0b1\uf742\uf688\uf0b0\uf0b7\uf74a\uf69c\uf0bf\uf6ab\uf69f\uf742\uf0ad\uf75f\uf742\uf746\uf098\uf75d\uf6a6\uf69c\uf0b1\uf745\uf74e\uf763\uf740\uf098\uf0ae\uf74d\uf0af\uf6a7\uf0af\uf688\uf747\uf0b0\uf0ad\uf760\uf0b3\uf69e\uf69f\uf0a9\uf0b0\uf6a7\uf765\uf750\uf6a7\uf0ad\uf742\uf0b1\uf0ae\uf760\uf0af\uf0ad\uf6a6\uf74a\uf763\uf0ad\uf0af\uf741\uf749\uf0a8\uf750\uf0b0\uf0b4\uf0b2\uf6a5\uf75d\uf75f\uf754\uf6a0\uf74e\uf0b0\uf741\uf0b7\uf0be\uf69f\uf741\uf0a9\uf74a\uf765\uf0bf\uf761\uf0b2\uf6a0\uf747\uf75e\uf753\uf751\uf6f8\uf765\uf74e\uf744\uf6a4\uf0bd\uf75f\uf0af\uf0bc\uf751\uf761\uf6a3\uf751\uf6a1\uf689\uf0b1\uf0a8\uf744\uf76a\uf69c\uf761\uf6a7\uf761\uf0a8\uf69e\uf747\uf74b\uf741\uf6a7\uf742\uf740\uf74d\uf762\uf6a7\uf6ab\uf743\uf6a6\uf741\uf0b1\uf750\uf761\uf0bc\uf751\uf0bd\uf752\uf6a2\uf689\uf0bc\uf761\uf750\uf751\uf69c\uf0b0\uf746\uf744\uf0a9\uf689\uf0bf\uf0b4\uf74a\uf751\uf6a2\uf6a3\uf0b1\uf746\uf742\uf6a7\uf0b2\uf0be\uf747\uf6a0\uf742\uf74d\uf6a2\uf752\uf6aa\uf76a\uf688\uf75f\uf0a8\uf765\uf74d\uf0a9\uf74e\uf697\uf757\uf74e\uf75d\uf761\uf6a2\uf0ad\uf747\uf750\uf6a4\uf75f\uf752\uf6a5\uf75d\uf742\uf6f8\uf0a8\uf751\uf746\uf6a7\uf752\uf6f8\uf69c\uf0af\uf74d\uf0b4\uf6a2\uf0b7\uf689\uf0a9\uf0af\uf74f\uf0a9\uf6a2\uf0ae\uf6f8\uf743\uf0b1\uf0b1\uf75f\uf6a3\uf750\uf6a2\uf0b3\uf0b1\uf6a5\uf697\uf0a9\uf750\uf746\uf0b3\uf6ab\uf74d\uf6a5\uf6aa\uf74e\uf6a1\uf0be\uf743\uf74d\uf743\uf697\uf765\uf74b\uf0ad\uf750\uf741\uf689\uf689\uf098\uf689\uf69c\uf747\uf6a1\uf0bf\uf6a1\uf694\uf74e\uf0b4\uf0b2\uf6a0\uf75f\uf6a0\uf0bf\uf750\uf69f\uf753\uf744\uf0b7\uf69f\uf0b0\uf760\uf6f8\uf750\uf765\uf0a8\uf752\uf749\uf6a1\uf752\uf745\uf0bc\uf0a9\uf0ad\uf697\uf0be\uf0b2\uf0bc\uf6a2\uf74b\uf757\uf74f\uf765\uf689\uf75e\uf0b1\uf757\uf765\uf0b2\uf098\uf757\uf6a6\uf6a0\uf6ab\uf6f8\uf6a2\uf0ae\uf697\uf74d\uf0ad\uf74f\uf750\uf0a8\uf0b7\uf745\uf742\uf6ab\uf689\uf0b3\uf741\uf76a\uf694\uf745\uf745\uf74b\uf6a6\uf0be\uf6a1\uf741\uf742\uf0bd\uf0b7\uf74b\uf740\uf743\uf6f8\uf688\uf0af\uf69c\uf0a9\uf760\uf0b1\uf6a6\uf746\uf0b7\uf751\uf0bd\uf697\uf697\uf6a4\uf74f\uf761\uf763\uf747\uf761\uf694\uf75e\uf0b4\uf752\uf6a7\uf6aa\uf69f\uf0b3\uf6a5\uf0a8\uf689\uf747\uf6a4\uf688\uf760\uf0b1\uf75f\uf74e\uf0a8\uf6a7\uf75f\uf74d\uf0a8\uf762\uf6a7\uf760\uf0bc\uf751\uf740\uf743\uf753\uf74a\uf0bd\uf743\uf762\uf752\uf0b0\uf745\uf6ab\uf75f\uf6aa\uf74d\uf69c\uf0b1\uf0bc\uf75e\uf0be\uf0bc\uf751\uf0b7\uf0b2\uf0be\uf75e\uf6a4\uf747\uf75d\uf688\uf0a8\uf75d\uf74d\uf0b2\uf765\uf6a5\uf751\uf0ad\uf6a0\uf749\uf6a5\uf0b3\uf752\uf69d\uf6aa\uf0be\uf747\uf69d\uf0af\uf747\uf0bf\uf763\uf694\uf752\uf0af\uf0b7\uf747\uf694\uf746\uf69f\uf74a\uf0bf\uf74f\uf0b0\uf098\uf6f8\uf0b3\uf0b4\uf6a1\uf760\uf6a2\uf75d\uf0b1\uf69e\uf6a3\uf0a8\uf697\uf0b1\uf0ae\uf762\uf740\uf0bc\uf69d\uf0af\uf745\uf760\uf742\uf69f\uf745\uf6aa\uf6a7\uf0a8\uf0b2\uf6a5\uf6a5\uf742\uf752\uf757\uf098\uf69e\uf746\uf6a7\uf76a\uf6aa\uf0bd\uf6a2\uf75f\uf744\uf6a0\uf744\uf750\uf69e\uf0af\uf0bd\uf6f8\uf6a1\uf0a9\uf744\uf740\uf0b3\uf6aa\uf689\uf69d\uf0bf\uf6a3\uf761\uf0bc\uf762\uf69d\uf6ab\uf0af\uf749\uf0b4\uf74d\uf0bf\uf6a1\uf69c\uf749\uf760\uf751\uf689\uf743\uf0be\uf744\uf74d\uf697\uf762\uf757\uf75f\uf0bd\uf0b3\uf0bf\uf762\uf0be\uf74f\uf0a9\uf750\uf0a9\uf098\uf0bd\uf746\uf74f\uf746\uf0bf\uf0ad\uf74d\uf0a9\uf697\uf75d\uf6a1\uf75e\uf75f\uf6a7\uf75e\uf753\uf0b3\uf745\uf697\uf763\uf0b7\uf74d\uf74b\uf688\uf754\uf74f\uf0ae\uf765\uf747\uf6a7\uf0bd\uf0ae\uf6a6\uf752\uf74e\uf69d\uf694\uf0b2\uf6a0\uf6a0\uf0ad\uf75f\uf0a8\uf6a7\uf762\uf752\uf69e\uf745\uf0af\uf0ae\uf69c\uf74f\uf0b7\uf746\uf74d\uf0bf\uf0bc\uf746\uf689\uf760\uf0b7\uf69d\uf762\uf6a0\uf6a6\uf741\uf0af\uf0af\uf0a9\uf0b1\uf765\uf69c\uf6a7\uf0a8\uf0be\uf747\uf0ae\uf0b2\uf752\uf75d\uf75d\uf6a0\uf6a6\uf6aa\uf0bc\uf0b4\uf098\uf0b0\uf0a8\uf0b3\uf749\uf6a6\uf0b2\uf0be\uf740\uf747\uf742\uf0bf\uf0b4\uf0bc\uf689\uf754\uf747\uf6a0\uf743\uf6a5\uf69f\uf74a\uf751\uf6a7\uf76a\uf0af\uf69c\uf0b2\uf0b3\uf6a4\uf0b2\uf098\uf0b4\uf69c\uf0ad\uf74f\uf745\uf6aa\uf75e\uf745\uf740\uf751\uf765\uf75f\uf0ae\uf76a\uf763\uf761\uf0b0\uf761\uf750\uf69e\uf6a7\uf763\uf741\uf757\uf0be\uf75f\uf0b2\uf76a\uf69e\uf0b1\uf0ae\uf689\uf747\uf74a\uf689\uf6a7\uf6a0\uf0ad\uf0bf\uf0b4\uf74a\uf0bd\uf745\uf0be\uf69c\uf6a4\uf098\uf0a8\uf752\uf74e\uf0b7\uf6a3\uf0b0\uf0ad\uf765\uf098\uf74a\uf6a4\uf6a3\uf741\uf763\uf751\uf0b2\uf6aa\uf6aa\uf754\uf0b2\uf0b4\uf0bd\uf0b3\uf0a8\uf69d\uf747\uf757\uf0b7\uf0b2\uf689\uf745\uf0af\uf694\uf0a8\uf740\uf6a6\uf745\uf688\uf76a\uf6a1\uf0b0\uf745\uf754\uf754\uf765\uf74e\uf6a7\uf0b3\uf753\uf6aa\uf0ad\uf6a6\uf74f\uf6a4\uf0af\uf742\uf689\uf761\uf0ad\uf0bd\uf69d\uf76a\uf754\uf6f8\uf694\uf0bf\uf74e\uf763\uf69d\uf75d\uf75d\uf742\uf69f\uf75f\uf0b2\uf6a0\uf757\uf753\uf0ae\uf0a9\uf0a8\uf762\uf6a7\uf0b0\uf0b2\uf69e\uf69c\uf762\uf0b7\uf75f\uf689\uf6a5\uf6a2\uf746\uf751\uf0bd\uf75d\uf74d\uf742\uf688\uf69e\uf749\uf0b1\uf6a0\uf0b0\uf69f\uf75f\uf760\uf6a5\uf694\uf74f\uf6a2\uf6a7\uf744\uf6a0\uf75e\uf74d\uf098\uf0b3\uf6f8\uf6a5\uf69e\uf74a\uf6a7\uf0af\uf0b0\uf760\uf6a3\uf743\uf745\uf757\uf75e\uf761\uf6a6\uf762\uf753\uf6ab\uf74d\uf6a3\uf749\uf0a9\uf69c\uf0b4\uf0a8\uf742\uf750\uf751\uf74d\uf750\uf761\uf747\uf742\uf0b3\uf6a3\uf6a7\uf0b1\uf75e\uf741\uf0bc\uf689\uf750\uf74f\uf694\uf0b2\uf69e\uf743\uf742\uf0b7\uf0be\uf697\uf0ae\uf6a6\uf74a\uf6a5\uf69f\uf744\uf760\uf6a0\uf745\uf69d\uf765\uf75f\uf6a6\uf69d\uf75e\uf6a4\uf0b3\uf750\uf6a6\uf0ad\uf0b7\uf750\uf688\uf0b3\uf76a\uf754\uf741\uf74a\uf757\uf74f\uf6a2\uf752\uf757\uf0b4\uf0b1\uf76a\uf751\uf6f8\uf746\uf751\uf0b3\uf0b0\uf0ae\uf0b3\uf751\uf75e\uf0be\uf0b0\uf69c\uf740\uf762\uf75d\uf740\uf6a6\uf765\uf098\uf69c\uf747\uf0a8\uf750\uf0bf\uf752\uf69d\uf0ae\uf751\uf762\uf0b3\uf0b4\uf749\uf0b0\uf0b2\uf0ad\uf6a1\uf69f\uf6ab\uf0ad\uf761\uf0bc\uf0bc\uf0ad\uf752\uf0bc\uf760\uf0a9\uf6aa\uf0b4\uf763\uf0bc\uf6a6\uf749\uf752\uf689\uf0b0\uf762\uf753\uf6a7\uf0ad\uf6a0\uf74b\uf697\uf6a5\uf0b1\uf765\uf761\uf6a3\uf746\uf762\uf750\uf75d\uf688\uf098\uf0b3\uf0b3\uf751\uf0b7\uf745\uf751\uf6a1\uf749\uf74b\uf761\uf0b2\uf74a\uf763\uf752\uf694\uf6a4\uf69d\uf0bf\uf749\uf74e\uf76a\uf744\uf74e\uf0b1\uf757\uf74f\uf098\uf754\uf750\uf0b0\uf76a\uf750\uf0b2\uf0a9\uf752\uf694\uf0b1\uf75e\uf76a\uf746\uf757\uf0b4\uf0b4\uf6a4\uf6a7\uf69f\uf752\uf75d\uf0a9\uf752\uf761\uf0b7\uf0a9\uf762\uf740\uf6f8\uf75f\uf74e\uf6a2\uf6f8\uf74d\uf0a9\uf69e\uf750\uf0ad\uf69f\uf6a4\uf750\uf6a3\uf761\uf750\uf6a6\uf761\uf6a0\uf749\uf75f\uf741\uf74f\uf741\uf76a\uf6a6\uf0a8\uf0b7\uf689\uf0be\uf744\uf750\uf0bf\uf757\uf74d\uf6a3\uf6f8\uf752\uf747\uf0ae\uf743\uf74a\uf0bf\uf0b7\uf0b1\uf689\uf0bd\uf0b1\uf6a4\uf757\uf744\uf6aa\uf751\uf0b2\uf74f\uf74b\uf6a2\uf6a5\uf749\uf745\uf747\uf74a\uf742\uf746\uf0be\uf6a5\uf760\uf6aa\uf750\uf740\uf0a9\uf753\uf6a1\uf757\uf743\uf697\uf749\uf6a4\uf6a7\uf69e\uf6a0\uf751\uf751\uf697\uf0ae\uf0b3\uf697\uf762\uf6a0\uf0b1\uf69c\uf752\uf749\uf746\uf75e\uf0a8\uf6a6\uf74a\uf697\uf689\uf69e\uf75f\uf74f\uf0b1\uf0b2\uf753\uf741\uf0b7\uf69c\uf6f8\uf69c\uf098\uf765\uf741\uf0af\uf74b\uf69d\uf6a5\uf760\uf0b4\uf74f\uf6ab\uf750\uf747\uf742\uf74f\uf0bc\uf6f8\uf746\uf0af\uf745\uf765\uf746\uf6a7\uf761\uf6a2\uf69e\uf0bd\uf0af\uf746\uf0ad\uf753\uf0b3\uf697\uf0af\uf6a4\uf76a\uf75e\uf760\uf0bf\uf754\uf0b7\uf0ad\uf6a3\uf74e\uf098\uf0bf\uf762\uf761\uf69d\uf74a\uf6a5\uf0af\uf763\uf6a7\uf0b4\uf6a5\uf757\uf0bc\uf6ab\uf765\uf744\uf0bc\uf74a\uf0af\uf0bf\uf763\uf6a1\uf6f8\uf694\uf753\uf740\uf742\uf6a0\uf6a7\uf745\uf0a8\uf742\uf6a1\uf746\uf763\uf740\uf752\uf098\uf0b2\uf0b0\uf0be\uf74a\uf6f8\uf6a0\uf0b1\uf689\uf0b0\uf760\uf6a7\uf6a3\uf688\uf75d\uf6a0\uf0ae\uf0bc\uf74f\uf74a\uf74f\uf763\uf76a\uf741\uf0bf\uf749\uf6a7\uf0ad\uf0bd\uf765\uf0b0\uf6a7\uf744\uf098\uf689\uf6a7\uf747\uf6a1\uf6f8\uf757\uf69f\uf747\uf69c\uf697\uf6a3\uf74e\uf0bc\uf74b\uf760\uf76a\uf69f\uf0a8\uf747\uf0b4\uf74e\uf0a9\uf0b7\uf694\uf6a0\uf69e\uf6a4\uf740\uf0b3\uf0bf\uf751\uf0b3\uf754\uf6a3\uf760\uf746\uf745\uf0b2\uf6a2\uf744\uf741\uf0a8\uf0a9\uf0b4\uf757\uf75e\uf6a4\uf751\uf744\uf6a0\uf688\uf0be\uf757\uf74d\uf69d\uf0ad\uf0af\uf742\uf69c\uf69f\uf6a7\uf688\uf74f\uf0af\uf0a9\uf688\uf6a1\uf6aa\uf6a4\uf74f\uf746\uf751\uf749\uf763\uf69e\uf0bd\uf69f\uf688\uf697\uf74d\uf740\uf75e\uf688\uf6a2\uf694\uf762\uf69c\uf688\uf75f\uf0b3\uf098\uf0bc\uf69f\uf74b\uf0bd\uf76a\uf757\uf0bf\uf74e\uf0b3\uf750\uf688\uf6a2\uf0b1\uf751\uf75e\uf694\uf763\uf761\uf6a4\uf753\uf741\uf6a3\uf75d\uf753\uf0b0\uf751\uf74d\uf762\uf75f\uf0b0\uf6a3\uf0b1\uf0ad\uf74a\uf753\uf75f\uf749\uf750\uf74e\uf746\uf74e\uf688\uf747\uf74d\uf741\uf750\uf0bd\uf6a6\uf6a1\uf0a8\uf0b1\uf6a0\uf741\uf74b\uf098\uf740\uf688\uf75d\uf69c\uf69d\uf0be\uf697\uf0a8\uf0b1\uf6a6\uf0b1\uf6a7\uf754\uf744\uf747\uf0bd\uf0ad\uf697\uf74a\uf742\uf74b\uf757\uf689\uf753\uf6a1\uf6a7\uf6ab\uf754\uf0b1\uf0b0\uf744\uf746\uf76a\uf0ad\uf0b1\uf6aa\uf69e\uf0b2\uf760\uf74d\uf74f\uf763\uf6a0\uf6a3\uf747\uf752\uf69e\uf74d\uf74a\uf6a7\uf746\uf749\uf697\uf0b7\uf751\uf694\uf752\uf0bd\uf6ab\uf743\uf0b4\uf69d\uf0be\uf740\uf6a5\uf0bd\uf0a8\uf6a2\uf754\uf69e\uf741\uf688\uf75f\uf6a0\uf6a1\uf763\uf763\uf754\uf763\uf6a1\uf6a7\uf0ae\uf6a7\uf752\uf762\uf0b3\uf747\uf75e\uf747\uf69f\uf762\uf0ae\uf762\uf69d\uf689\uf6a1\uf749\uf6a5\uf69c\uf752\uf745\uf746\uf75f\uf689\uf741\uf6f8\uf751\uf74a\uf697\uf694\uf0b3\uf765\uf744\uf69f\uf744\uf762\uf754\uf75e\uf74f\uf75d\uf74a\uf69e\uf6a5\uf757\uf0a8\uf744\uf740\uf745\uf74a\uf75e\uf0bf\uf6ab\uf751\uf0b3\uf69e\uf098\uf6a6\uf74e\uf0b4\uf74f\uf0be\uf747\uf6f8\uf74f\uf75e\uf74b\uf0bc\uf0be\uf6ab\uf694\uf6ab\uf689\uf74e\uf688\uf746\uf0bc\uf760\uf746\uf745\uf746\uf0af\uf689\uf69f\uf0a9\uf0bd\uf760\uf6a1\uf763\uf0a8\uf761\uf0b4\uf6aa\uf74b\uf0af\uf74e\uf74b\uf6a7\uf69e\uf747\uf69d\uf6f8\uf6a4\uf746\uf6a3\uf0b2\uf761\uf6ab\uf6aa\uf744\uf0ae\uf0bc\uf76a\uf753\uf6a1\uf69f\uf75e\uf761\uf76a\uf757\uf74b\uf6a4\uf69f\uf749\uf0b4\uf742\uf743\uf0ae\uf6f8\uf098\uf0b4\uf6a4\uf750\uf74a\uf765\uf0ad\uf743\uf754\uf0ad\uf688\uf6aa\uf762\uf69c\uf743\uf0b7\uf688\uf6a1\uf0a9\uf6a5\uf74b\uf0b1\uf75f\uf750\uf0be\uf0b0\uf6a5\uf765\uf74f\uf6ab\uf0ae\uf6aa\uf76a\uf75d\uf0bf\uf6a2\uf765\uf0b4\uf754\uf6a3\uf751\uf75f\uf741\uf69e\uf6ab\uf69e\uf0bd\uf762\uf0be\uf743\uf0b2\uf0b0\uf743\uf742\uf0b1\uf0b0\uf69e\uf763\uf0be\uf74e\uf69f\uf74b\uf694\uf0a8\uf742\uf743\uf6a4\uf0bc\uf69c\uf6ab\uf746\uf76a\uf76a\uf6a7\uf749\uf689\uf6aa\uf694\uf750\uf6a2\uf0bc\uf753\uf688\uf6a4\uf74a\uf0b2\uf098\uf744\uf752\uf6ab\uf763\uf765\uf0b1\uf697\uf761\uf75e\uf74d\uf751\uf0ae\uf74e\uf0a8\uf753\uf0be\uf750\uf69d\uf741\uf751\uf741\uf0bf\uf75e\uf694\uf0ad\uf6a1\uf689\uf6a2\uf6a4\uf0a8\uf74e\uf0af\uf0bd\uf6ab\uf0b0\uf746\uf74d\uf74e\uf745\uf6a5\uf749\uf74a\uf740\uf6aa\uf75e\uf0b2\uf762\uf6aa\uf0af\uf75e\uf6aa\uf6a5\uf765\uf762\uf750\uf688\uf0b4\uf69f\uf757\uf6a0\uf0ae\uf74d\uf757\uf0be\uf75f\uf0b1\uf6aa\uf0b0\uf6a2\uf0a8\uf688\uf688\uf74f\uf6a3\uf689\uf745\uf744\uf6a2\uf744\uf0be\uf74b\uf75e\uf742\uf757\uf0bf\uf689\uf0b3\uf740\uf6ab\uf6a1\uf6ab\uf74a\uf742\uf745\uf6a2\uf744\uf0b0\uf6a4\uf744\uf74a\uf0be\uf6aa\uf0bc\uf098\uf75f\uf0b1\uf76a\uf697\uf742\uf743\uf6a0\uf746\uf0b1\uf0b2\uf0b7\uf750\uf0af\uf744\uf751\uf761\uf74f\uf6ab\uf0bc\uf6aa\uf6a3\uf6a0\uf74b\uf744\uf750\uf742\uf75f\uf6a6\uf74d\uf0ae\uf6f8\uf74e\uf749\uf74b\uf6a1\uf6a5\uf69c\uf0b7\uf6ab\uf098\uf0be\uf6a7\uf69c\uf740\uf6a1\uf6f8\uf6a5\uf0b1\uf69d\uf0b4\uf6aa\uf6a3\uf0b4\uf69e\uf0a9\uf0a9\uf6f8\uf760\uf740\uf757\uf0b2\uf0bc\uf69f\uf761\uf74b\uf765\uf74a\uf6a7\uf6a5\uf098\uf749\uf741\uf0b4\uf75d\uf69c\uf75e\uf75f\uf6a5\uf0be\uf752\uf76a\uf762\uf742\uf0b1\uf0a8\uf6a6\uf0b2\uf0b0\uf743\uf689\uf0b0\uf745\uf0b3\uf689\uf742\uf749\uf753\uf0bf\uf753\uf74e\uf6a3\uf6a5\uf760\uf0b1\uf75e\uf745\uf6a7\uf741\uf74d\uf74f\uf0a9\uf76a\uf76a\uf74a\uf751\uf6a5\uf0b2\uf0a8\uf740\uf0be\uf765\uf76a\uf6a1\uf0a9\uf760\uf747\uf6a0\uf743\uf0b1\uf0b3\uf743\uf0af\uf74f\uf763\uf744\uf697\uf75e\uf6a5\uf6a1\uf0b0\uf0ae\uf0be\uf6a1\uf0a9\uf757\uf75f\uf763\uf74a\uf74f\uf0b4\uf69e\uf6ab\uf6a2\uf743\uf69c\uf74d\uf0b2\uf740\uf0bd\uf762\uf0af\uf69e\uf69f\uf697\uf0bf\uf74e\uf0b0\uf74e\uf76a\uf0b4\uf0af\uf0a9\uf74d\uf749\uf74f\uf6a0\uf747\uf688\uf763\uf750\uf69c\uf763\uf762\uf74e\uf0b3\uf754\uf752\uf694\uf688\uf0ae\uf6ab\uf0ad\uf6a3\uf74b\uf6aa\uf74f\uf0b1\uf0b0\uf75e\uf69c\uf6a1\uf6a3\uf741\uf760\uf0be\uf689\uf752\uf74b\uf740\uf750\uf697\uf0b2\uf0b7\uf75d\uf0bd\uf69d\uf697\uf6aa\uf74e\uf752\uf0be\uf6a4\uf6ab\uf0b4\uf744\uf765\uf0a9\uf745\uf740\uf688\uf74f\uf6a0\uf0a8\uf745\uf6a5\uf75f\uf0b4\uf744\uf75d\uf757\uf69f\uf745\uf69e\uf76a\uf098\uf747\uf74d\uf0b7\uf75e\uf6f8\uf694\uf74a\uf0b4\uf0b2\uf74d\uf741\uf752\uf0bc\uf0bc\uf6a7\uf69d\uf754\uf6a5\uf763\uf0ae\uf0b2\uf74a\uf0bd\uf74d\uf6aa\uf0b7\uf750\uf754\uf765\uf0b3\uf0be\uf69f\uf6a4\uf0b7\uf750\uf74d\uf6a3\uf697\uf761\uf6a0\uf752\uf6a2\uf763\uf753\uf0af\uf69f\uf75f\uf0be\uf6a4\uf6a1\uf74f\uf6aa\uf75f\uf6a6\uf098\uf757\uf744\uf742\uf750\uf6a0\uf744\uf0b0\uf0ad\uf763\uf74a\uf697\uf0be\uf0ae\uf0bd\uf0a9\uf742\uf742\uf763\uf0ae\uf749\uf6a6\uf74e\uf0b3\uf6a6\uf751\uf6a0\uf697\uf6aa\uf6a3\uf6a2\uf75d\uf098\uf740\uf0be\uf744\uf75d\uf749\uf6a3\uf740\uf765\uf697\uf688\uf74b\uf6f8\uf69c\uf741\uf0b0\uf6a1\uf74a\uf0b4\uf76a\uf0b2\uf743\uf098\uf754\uf0b4\uf76a\uf6a1\uf6a7\uf694\uf0b4\uf0ad\uf763\uf0b1\uf745\uf0be\uf6a4\uf6a2\uf74b\uf760\uf6f8\uf760\uf752\uf761\uf742\uf754\uf6a1\uf763\uf0be\uf0ad\uf0b2\uf74e\uf688\uf69f\uf74e\uf0b0\uf69e\uf743\uf689\uf0a8\uf753\uf0a9\uf745\uf0b4\uf75e\uf75e\uf74e\uf76a\uf744\uf689\uf765\uf746\uf757\uf753\uf0af\uf69c\uf74a\uf6a0\uf761\uf760\uf741\uf744\uf740\uf098\uf0be\uf0be\uf765\uf760\uf75d\uf689\uf754\uf74f\uf6a3\uf760\uf6a7\uf757\uf0b0\uf76a\uf69c\uf742\uf6aa\uf742\uf747\uf0b3\uf0af\uf74a\uf69f\uf0b4\uf763\uf688\uf0b4\uf69f\uf697\uf6a7\uf752\uf745\uf0b0\uf0be\uf694\uf688\uf6a5\uf74a\uf76a\uf753\uf6a6\uf742\uf6a7\uf0b1\uf752\uf757\uf6a0\uf688\uf761\uf745\uf69e\uf743\uf69e\uf753\uf0b4\uf0ad\uf6f8\uf74a\uf75f\uf76a\uf69e\uf747\uf753\uf6a0\uf098\uf69e\uf752\uf75d\uf6a4\uf098\uf744\uf6aa\uf0bd\uf752\uf6aa\uf761\uf69e\uf761\uf6a4\uf742\uf749\uf6a0\uf742\uf6a0\uf752\uf746\uf69c\uf6a3\uf74f\uf6a0\uf6a1\uf0bd\uf0bd\uf0bf\uf6a1\uf74e\uf740\uf0ad\uf6a6\uf6a5\uf098\uf0b3\uf0b0\uf742\uf750\uf697\uf743\uf747\uf763\uf740\uf747\uf6a5\uf763\uf0b1\uf760\uf74a\uf6a3\uf0ad\uf0b4\uf747\uf6a6\uf6a4\uf749\uf0bf\uf098\uf75f\uf742\uf0a9\uf743\uf74f\uf0bc\uf6a3\uf752\uf6ab\uf0ae\uf749\uf75d\uf76a\uf74b\uf746\uf0af\uf0ae\uf694\uf69e\uf751\uf751\uf745\uf757\uf0bc\uf740\uf763\uf69e\uf6a4\uf0a9\uf74d\uf697\uf749\uf69e\uf749\uf6a0\uf69f\uf763\uf763\uf754\uf6a6\uf749\uf752\uf0b4\uf6a5\uf0a8\uf0b0\uf74e\uf760\uf6a7\uf746\uf694\uf760\uf749\uf688\uf760\uf75f\uf74f\uf744\uf746\uf689\uf743\uf740\uf743\uf69d\uf6aa\uf745\uf763\uf0a8\uf751\uf6a6\uf697\uf6a4\uf74f\uf75f\uf6a2\uf741\uf6a7\uf75f\uf754\uf0b4\uf0af\uf6ab\uf752\uf751\uf098\uf6f8\uf6a7\uf757\uf098\uf689\uf688\uf0bc\uf69e\uf753\uf69f\uf743\uf0bc\uf0ae\uf0bd\uf0b0\uf0b1\uf740\uf0b0\uf6ab\uf762\uf765\uf0b4\uf69c\uf74f\uf0b1\uf6ab\uf098\uf751\uf6a4\uf098\uf743\uf6aa\uf744\uf746\uf6aa\uf6ab\uf6a2\uf0ad\uf752\uf0ae\uf0b3\uf0b3\uf757\uf6f8\uf754\uf0b0\uf69d\uf0be\uf69d\uf745\uf0bd\uf760\uf0be\uf762\uf745\uf69f\uf697\uf0ad\uf697\uf689\uf763\uf694\uf69d\uf761\uf0b1\uf752\uf743\uf0b4\uf6a5\uf6f8\uf747\uf74a\uf0b7\uf753\uf74d\uf747\uf6aa\uf0bd\uf6a7\uf744\uf694\uf745\uf754\uf6a5\uf750\uf0b2\uf69e\uf744\uf76a\uf6a7\uf0b1\uf74e\uf749\uf753\uf689\uf0ad\uf752\uf0ae\uf6a7\uf6a2\uf760\uf763\uf0b4\uf745\uf6a3\uf0ad\uf688\uf761\uf0bd\uf75d\uf761\uf0bf\uf74f\uf753\uf694\uf688\uf75e\uf6ab\uf74a\uf6a3\uf0b4\uf0b1\uf0a8\uf750\uf0be\uf0bc\uf0a8\uf742\uf743\uf0ad\uf6f8\uf688\uf0bd\uf74a\uf69d\uf69e\uf75e\uf74f\uf6ab\uf0bd\uf69d\uf74b\uf6f8\uf746\uf753\uf6a6\uf0a9\uf6ab\uf69e\uf75f\uf761\uf0bf\uf746\uf688\uf69c\uf76a\uf751\uf74b\uf6a6\uf0bf\uf6ab\uf0b2\uf765\uf098\uf76a\uf765\uf76a\uf74e\uf753\uf747\uf75f\uf765\uf74f\uf750\uf0be\uf6f8\uf689\uf76a\uf75f\uf6ab\uf0be\uf694\uf742\uf6aa\uf763\uf6f8\uf74e\uf694\uf6a0\uf0ad\uf6a0\uf74b\uf0bd\uf744\uf69f\uf6ab\uf0b2\uf745\uf0a8\uf6aa\uf6ab\uf753\uf69d\uf0ad\uf6a5\uf752\uf098\uf76a\uf697\uf689\uf746\uf75d\uf744\uf689\uf0b0\uf688\uf688\uf0b3\uf69d\uf74d\uf763\uf75f\uf6a5\uf761\uf0b2\uf6a6\uf0b1\uf689\uf0b2\uf694\uf0b3\uf689\uf0ae\uf098\uf745\uf752\uf74d\uf743\uf74d\uf763\uf74e\uf688\uf0bf\uf6ab\uf74d\uf0b3\uf0be\uf69e\uf0b1\uf69f\uf742\uf74b\uf0a8\uf0bf\uf69f\uf6ab\uf0af\uf761\uf750\uf694\uf6a1\uf0bf\uf76a\uf763\uf745\uf0b2\uf0b3\uf740\uf75d\uf6a2\uf6a7\uf0a9\uf6aa\uf0ad\uf69e\uf6a7\uf754\uf0a8\uf74d\uf752\uf742\uf0b3\uf6a7\uf6a4\uf74a\uf74d\uf757\uf75d\uf6a6\uf74e\uf6a7\uf762\uf688\uf747\uf75d\uf744\uf69c\uf6aa\uf753\uf6aa\uf745\uf0be\uf762\uf762\uf6a6\uf0b2\uf6a0\uf76a\uf761\uf69f\uf6aa\uf0bf\uf6a3\uf760\uf76a\uf745\uf6f8\uf69d\uf757\uf0b7\uf757\uf0bc\uf69d\uf0b2\uf750\uf69c\uf6a7\uf74f\uf760\uf0b7\uf697\uf6a6\uf0b1\uf6a4\uf75e\uf75e\uf098\uf6f8\uf0b2\uf0ad\uf6a4\uf74e\uf746\uf740\uf76a\uf752\uf0b0\uf741\uf6a6\uf6a6\uf0b0\uf0af\uf0b7\uf746\uf0bc\uf74d\uf694\uf752\uf741\uf744\uf76a\uf6a6\uf6a7\uf6aa\uf765\uf743\uf6f8\uf74d\uf689\uf689\uf69c\uf6a5\uf6a0\uf0be\uf0be\uf74e\uf0af\uf689\uf744\uf761\uf0be\uf689\uf76a\uf74f\uf689\uf0be\uf697\uf0af\uf6a5\uf744\uf0b2\uf0bd\uf74f\uf746\uf6a6\uf0b1\uf0b2\uf6a5\uf746\uf745\uf6a1\uf6a7\uf765\uf6a6\uf747\uf75f\uf6f8\uf694\uf697\uf6a2\uf746\uf765\uf0a9\uf6a3\uf746\uf0bf\uf0be\uf0b1\uf6f8\uf0b0\uf744\uf69c\uf689\uf762\uf750\uf0b1\uf0af\uf752\uf75d\uf0b4\uf762\uf0ad\uf6ab\uf6a7\uf741\uf0b3\uf69e\uf0be\uf75d\uf69f\uf0be\uf757\uf69e\uf6a0\uf694\uf6a2\uf746\uf745\uf75e\uf0af\uf6a3\uf761\uf6a5\uf69c\uf098\uf763\uf0b1\uf761\uf0b1\uf0bd\uf752\uf697\uf694\uf0ad\uf0b4\uf757\uf69c\uf0b0\uf76a\uf6a4\uf6a3\uf763\uf6a0\uf761\uf6a4\uf740\uf747\uf749\uf0ae\uf0a8\uf0af\uf761\uf75d\uf762\uf740\uf757\uf0b2\uf6a3\uf742\uf0b4\uf74f\uf69e\uf76a\uf74e\uf0a9\uf697\uf745\uf762\uf74f\uf0ad\uf6a2\uf0b4\uf0be\uf098\uf69d\uf743\uf744\uf75f\uf6ab\uf750\uf74b\uf6a4\uf0b1\uf75f\uf697\uf0b1\uf0b2\uf741\uf746\uf6f8\uf75d\uf754\uf75d\uf0b1\uf740\uf741\uf697\uf75e\uf0bf\uf749\uf753\uf6a1\uf762\uf745\uf098\uf747\uf0bd\uf763\uf0b2\uf6aa\uf0ad\uf75e\uf751\uf0ad\uf762\uf0b7\uf6aa\uf0ae\uf743\uf75f\uf0a8\uf0a8\uf69e\uf742\uf688\uf0b4\uf76a\uf0b3\uf098\uf697\uf740\uf749\uf74d\uf74f\uf697\uf689\uf0bd\uf688\uf0bc\uf6a7\uf753\uf0bf\uf74e\uf69e\uf098\uf757\uf0af\uf6a6\uf6a1\uf6aa\uf6aa\uf0b0\uf760\uf0ad\uf689\uf741\uf75e\uf0bc\uf762\uf6a1\uf741\uf69f\uf752\uf746\uf75f\uf747\uf742\uf098\uf69f\uf751\uf69d\uf0be\uf754\uf0bc\uf6a4\uf744\uf744\uf0a8\uf754\uf688\uf75e\uf74e\uf74d\uf6a1\uf744\uf763\uf688\uf75e\uf0be\uf0ad\uf75d\uf752\uf762\uf761\uf6a2\uf746\uf6a5\uf743\uf6a7\uf75e\uf0ad\uf744\uf0ad\uf689\uf0ae\uf75d\uf6a2\uf75f\uf69d\uf0b7\uf69c\uf0b1\uf750\uf0b2\uf751\uf69d\uf0a8\uf753\uf6a2\uf746\uf688\uf763\uf6a1\uf744\uf749\uf75f\uf0bf\uf745\uf0af\uf6aa\uf752\uf757\uf688\uf741\uf697\uf751\uf754\uf747\uf6a6\uf69e\uf0b4\uf0b4\uf750\uf0bf\uf69b\uf69b"
                .toCharArray();

            for (int b1 = 0; b1 < 8344; b1 += 1) {
                char c1 = achar1[b1];
                int k5 = c1 ^ '耡';
                int l5 = k5 ^ 21347;
                int i6 = l5 + 11590;
                int j6 = i6 - 58762;
                int k6 = j6 + 49290;
                int l6 = k6 ^ 37007;
                int i7 = l6 - 35503;
                int j7 = i7 - 35471;
                int k7 = j7 - 39280;
                int l7 = k7 ^ 14069;
                int i8 = l7 - 22453;
                int j8 = i8 ^ 30906;
                int k8 = j8 ^ 60187;
                int l8 = k8 + 52476;
                int i9 = l8 ^ 30365;
                int j9 = i9 ^ 21694;
                int k9 = j9 - 7519;
                achar1[b1] = (char)k9;
            }

            object = mth_0OOOoo00o0_31()[3] = new String(achar1);
        }

        aobject[2] = (String)object;
        char[] achar2 = ((String)o0Oo000O0oO(aobject)).toCharArray();
        int limit7 = 5084;
        int i10_hi = 0;

        while (i10_hi < limit7) {
            int l29 = i10_hi;
            int j10_hi = i10_hi + 1;
            char c2 = achar2[l29];
            l29 = j10_hi;
            int k10_hi = j10_hi + 1;
            char c3 = achar2[l29];
            int l10_hi = c2 << 16 | c3;
            char[] achar3 = new char[l10_hi];

            for (int limit8 = 0; limit8 < l10_hi; limit8 = limit8 + 1) {
                achar3[limit8] = achar2[k10_hi + limit8];
            }

            l29 = k1_hi;
            k1_hi++;
            o0Oo000O0oO[l29] = new String(achar3);
            i10_hi = k10_hi + l10_hi;
        }

        aobject = new Object[]{fld_0OOOoo00o0_65, 4, null};
        object = mth_0OOOoo00o0_31()[4];
        if (object == null) {
            char[] achar4 = "Ჺ᳤ᴎ᳸ᳫ᳇᳚ᰚລᰦືᴐᳲ᳇ᴃ\u0ea4᳷ᰨລᰚᳶື᱒ᳲᴅ᱒Ჽᰨᳰຢᳯᴄ᳟ᰝᴙᳶᰜ᳣ᴌᰩ᱕ᳬᳲ᳴ᰩ\u1cbcᰛᰩ᳷ᳰᳲᲽ᱔ᳬລᳱᳶຫᰧᳶ᳹ᰜ\u1cbbຶ᳚ᳲ᳢ຶᰛᰜᴄ᳢᳟᳚ᳰຬ᳚\u1cc8ᴅᴂᲽᴗᰧᰚຮ᳤ᴐᲽ\u0ea4᳢᳟Ჿື\u1cc9ູ᳚ᳬ᳤᱕ᰛ᳣᱔ᰨ᳤\u1cbb\u1cc8ᴎລຬ᳇ຬᴃ᱔᳟Ჽ\u1cc9ᴋᳶᰩລᴋᴐລᴋᳱᲺᳬ᱒ລ\u1cbbຶᴅᲺ᳟ᰦᰚຬᴄᰦᰩᳵ᱒᳇ᰦ᳇᳆᱒᳇᳹ᳲ᳷ᴘລ᳇ᴌᴐ\u1cc9ᳱ᳤\u1cbc᳴ᴅຢᰜᰛᴂᴏᴙ᳟\u0ea4ᴖᰚᴌᳱ᳥ຫᰦ᱔ື᳢ᴄ᳷ᴃ᳚ᴙ᳣᳤᳹᳹ᰜᴄຢᴎᰨᴃᰝᴋ\u1cbbຮᴃᴗᳶ\u1cbcຫᴅᴌ᳥ᳶ᳴ᳱᳯᳬᴐᴐ᱕᳸Ჽᰛᴏຸ᱕ລ\u1cbc᳣ᲿᲽ\u1cbb᳥ᴗᰩᰝᰚᴐ᳴ᴌ᳴\u0ea4ᴂᴙᳱ᳥᳚ᰝຶ᳆ᴃ\u1cc9ᳵᴘᴖᲽᴂຢັᰦ\u1cc8ᰛᰧ᳆ຶᰛ᱔ື᱔ᲽᲿᳵຬ᳷ຸ\u0ea4ᴅᳱ᳣᳸᳹᳷ᴙᳱᴄᴅᳲ᱔ᳬᴃ᳸᳸᱔ັ᳣᳹ᳮᴄ᳴ᰨ᳤\u1cc9ᰜᳬᰦ᳥᳹ᰦັᰩᳬᴃᳯ᱕\u1cbbᰛ᳢ᰝᲿູູຶ᳤ູ᳟ᴘᴑ᳇Ჽ᱕ᰩᰛ᳷ᴏ᳆ᴖ\u1cc9ືᴂᳫᰩᴏຶຮ᳢ᴗຶ᳴ᴙᰧᳰ᳣ᲿຮᴅᴐຢᰚືᳯᲽᳫ᳷᳇᳷᳇ᳱ᳆\u1cbb᳥᳤ᴎ᳸ᴂ\u1cbcᰚᳲ᳥᳇ᴋᴐᲿᴎᰩລ᳢᳢᳢ᳵຮ᳥᳷Ჺᰚᳬᴐຫᳬ᳸ᳲ᳴ᰝᴎᴌᳱ\u0ea4Ჽᰩᳶ᳷Ჿ\u0ea4Ჿ᳆Ჺ᱕ᳮᳫ\u1cbcᳮ᳷\u1cc8ᰜᳰᳶ᳤ᰛᳲ᳣᳇ᳯຶຬᳮᴌᰛ\u1cc8ᴙᲺᰝᳱ᱕ᰛ᳚᱕Ჺ᳹ᴏ᱒ᳶ᳣ືຮᰛຮ᳥ᰩືᳮ\u0ea4ູ᳆ᴂ᱕ᰝ᳚Ჿ᱔᳇ຫᴋᳮᴎᳯ᳢ᴌᰚᳫᴗູ\u0ea4ູຬᳶ᳆ᴖᰛັᰩᳵᴏ᱒ᴑູຢ᳷᳤ᳬ᳆ᴂ\u1cbb\u0ea4Ჽᳫ᳸᱔ຮᳵᲿᴘᳬ᳆\u1cbc᱔ᳮᰛᴗᴙᳱᳶᴙᴄᴂᲽ᱔ᴗᲿ᳟ᳵᰧຢຸຸ᳚\u0ea4ຸᳱᴅᴄ᳚ᳯᲽᳫᴌᴗᴘ᱔ຫ᳥ᴎᳬᳬ\u1cbcືຶᲽᴄᴋູ᳟ຬ\u1cc9ᰚᴗ᳣\u1cbbᴅᴎᴃᴃᰧ᳆ᰧᳰᰜᴗᰧᰧ᳢ᴏᳮᳱᰦ᱒\u1cbcᴙᳫᰝᳰ᳴ᰧᴖᴎᰧᴎຫ᳤ຬຸᲽ᱕᳟ᴎᳮ᳷\u1cc8ᴖᴏᳶᳫᳵ᳚ᳵຶᴖᰦᴋ\u1cbc᱔ᴅຫູᴂ᳤ᳰ᳷\u0ea4ᰝ᳴\u1cbc\u1cc9᳸\u1cc9ᳮ\u1cc8\u1cc8Ჽຸᴙຸ᳚ᰜ᳚ᳮᰚᳯ᳣᳹ᳫຶᰝ\u1cbc\u1cbbᰚຢ᳴ຶືᰩᳶᴏᴎᰚ᳇\u1cc8ᰧᴑᴗᴎᴐᰩᴘᲽᳲᳶ\u0ea4ຮᳯᰝᰛᳶᰧ᳹\u1cbbᳫᰦ᱒᳴ᳫ᳢ລᳫຶᴌᰧᴋᳯ᳢ᳫᴌຸ᳸ຢᰛᰚູ᳴ᰩᰦ᱕ᴌ\u1cbcູᴘᴑᴏ᳇᳤ᰚᰛᴘᴑ᱒ᰦᴙ᳣᳸ᴗ᱕ᰨ\u0ea4ᳮ᱒Ჽ᱕ᰛᴙᴌᲽ᳣\u1cbbᳲ\u0ea4ᳫᲺᰝຫຶ᳇ᳯ᳆ຢᳫ᳤᳆ᳱᴃ᳴ຶ᳇᳢᳷ᴄ᳢᱕ᳮຶᴄᳶ\u1cbbᴑ᳷ຫᰨ\u1cbcᴌ᳤ᳶ᳥ຢ᱔ᳬᲽᰩᴘ᱕ᰨᰧᳯᳬ\u1cc8ᳫᴋຶ᱔ᳶ᳚ຢᲽຶᳲຸ᳷\u1cc9ᴅູᰚᳬ᳥ຢ\u1cc8᳟᳆ᴋᰝᴑລັຶັ᳹ᰦລᳶຫ᳤ᴖᴅᳱᰝຸᴃັᴅᴃᴅᳲືᳲຢᴃᴑᰜᴅ᳥ຮ᳣ᳬᳫᴏᰨᴐᰜᳰᴎᴃືᳵ\u1cc8᱔᱕ᳱᴅᳲᴅᲺ\u1cbc\u1cc8ᴙᳲັຬ᱒ຬ᱒ᳵᴗᳬᲽຮຸ᳴ᰚ᳚᱒ຶᴅᳵ\u1cbbᴘ᳇ᴎ\u1cbb᳷ᴙᳱຸ\u1cc8ᴅᳯᴙᰛᳮᳯᴋ᳥ືືᳱᰦ᱒᳴Ჿ᱕ᴌᰩᰧຸ᱒᱒ᳬ\u0ea4ᰧᳱᲽᳲᳶᴘᴄ\u1cc9ᰝᲺັᰜᳵᰩᳵᴘຢᳶືᴅᳰ᳷ᴙᴂᰚລᳬᴄູ᱔᳚᱒ᰚ\u1cbbᴑᳱᳬᳯ᱒᳢᳴\u1cc9ັᴏᲽᰩᳱ᳴ᴄᳶ᳇ᴋᰜ᳤ᴃᳵຮັᰩ᳥᳢\u1cbbᴗᳮ᳢᳴ᳵᴐᳮ᳴᳷ᴘ\u1cbcᴏᳰᴗ\u1cc8ຫᳫᴏ᳣ᰩ᳴ᳱᳯᴋ᳢ᴂ᳹ືᰜᴋᳫᴅ᳴᳚ᴘᳬᲽᴃູᰦᴂᲽᰧ᱔ᴅᴌᴌᳯ᳣ᳰᳫᳵຢᴐ\u1cc8ᳰᴋ᱒ູᰦ᳣ᳫື᳹Ჺຢᴏ᳇᳢ູ᱔ᰩᳶᴎᰚຶ᳆ᴂຮ᳥᳟᳇᳣\u1cc9ᳯᴙລູᰦᴘᲿᴌຬᲽᳲᳰຮᰜᰦᴂᴏ\u1cbc᳤᳤ᴘᴖ᳥ᳵ᳚ᴏ᳢ᳶຶ\u1cc9ᳵᰧ᳆ᴅᰝᴃᰛລ᳣ᳬ\u1cc9ᴏ\u1cbbື\u0ea4ᳫᳰᴗᰧລᴖຢᴎᴌ᳚᱔ᳲᰜຬᰧ᳥᳤ູᰧᰩᴎᴖ᳆Ჽᰦᴗᴂᰝ\u1cbbᴖຫຢ᳷ᴃ᳆᳟ᳫᴑᳲᴂᰝᴖᴌ᳴ຮື᳸᳆Ჿᰧᰝ\u1cbb᳷ᰦ᱔ᴑᴘᳵᳵᳬᰩ᳥ᴑ᱕ᰧ\u1cbcັᴂᲿ᳟᱔ᳶᳮᴌᰚຢᴋᰚᴌᴘᴐᰜᴙᴅ᳟᳸᳆ᰝᳫ᳷Ჽᴏ\u1cc8ຮᴏ᳥ᴐᴋ᳢ᳱᰨ᳸᳸ᴑᴑᴖᰚ᱕ᰜᳶ\u1cc8ᰚᴎᴋᴑᳫຮᲿᴙ᱒᳢᳹ᴗ\u1cc9ᴘ\u1cc9ᴙᴏ᳇ູ\u1cbb᱕Ჺᴎᴅຸ᳟ᳲᳯ᱕ᲺືᰨᰦຫຫືᳱᲿᳲຸຢᲺᰝᴅູᴐᴃ᳸ᰝຮ᳷ᰧ᳢ຶᴏ\u0ea4ຬᲽ᳆᳤᳴ᰦ᳷\u1cbbᲿᴑ᳆᳇᳢Ჽ᳸ᳮᰛᴃ᱕ᴎ᳢ᴑᴃຢᰜ᳸᳆ᴐᳯຫᳫᳰ\u1cc9ᳰᰚ\u1cc9ᴅᲽᳱᰧᴘ᳆᱕ᴑᴌᴌᴗᴖᰧ\u1cc8ᴗ᱒᱔᳆ᳰ᳷ຸັᳰ᳢᳟ᳯ\u1cc8᳥\u1cbb᳤᳇ຶື᱔ᴙᴘᴌᴘᴘ᱒᳣ູຮ᳚ຮᴑ᳇ᴐᴏ᱔ᴌຶᴂᲽᴙຸ\u1cc9᳆ຶ᳇ᳮ᳢\u1cbc᳸ᴙᰨ᳢\u1cbcᳶᲽ᱕ᰩ\u0ea4ຫຫᰝ᳤\u1cc8᳤Ჺ᳢᳚ᰨᴎ᳇ᰦᳫຬᰧᰚᳮ᳣\u1cc9ᰨᴂᴎᳱᴋᳯᳶᴌᴐᰩᳲᰨᰧ\u1cbc᳥ᴅືຮᳱ᳇ᴙຶᴗຸ᳚ᴙ᳆᳸᳚ᰩ᳸ᰩ\u1cc8ᳱ᳣᳴᳸ຢᰝ\u1cc8᳥᳚ᴗ᳸ᴙᳱຸ\u1cc9᳢ຶᴏᴗᳶ᳸᳴ຢᰚ᳇ᴌຬ᳸ᰝ᳆ᴗᳲຶᴅᰚ᳹ᳰᳰᴅູ᳴Ჺ᳷ᳯຫ᱔ᰦᴅ\u0ea4\u1cc9ᴎᴂᰨᴋᲺລᴐ᳚ᴌ᱒᱔ᰨᴐᴗ\u1cc9\u0ea4ᳶູ\u1cc9ᳯᴄᲽᴌᴄᲺ᳇ᰨᴋᳮᳫ᳴᱒ລຶᴙູᴋ᳤ᰨ᳸ᰨᰦᴋᳱᲽຶ᱕᳸ᴖᳯ᳢ᳶ᳤ຶᴌຮᴗᳫᳵᰧ᳹ᴅᳯ\u1cc9ᳮᲽᰩᰦᲿᳬᴃᰧᰧᰛຸ\u0ea4ᴋᴂᴙ᳇ᴏ᱕ᴖ᳸ᳯᴏᴑຸ᳸ືᴘລ᳆ᳶᰜູᴏຬᳫᴋ᱔᳆ᲽᴏᲽ\u1cc9ᳶᴂᳫ᳟᱔ᰨັູᳯᳫືᴐᳮື᳟ᰦᳰື᳇ᴄືຬ\u1cc8ᴄᳬ᱔ᴋᳵ᳹ᴅ\u1cc9᳤᱒ᳶ᳢ᴂᳵ᳆᳹ᴙᳯ\u1cc9ᴌᴅᲽᴅ\u1cc8ᳶᳱᰛ᳟᳟ᰦᳱᴑᴅᰛᰜᳵ᳹ᴂᴂᰝᴅຫ\u1cc8\u1cc8Ჺ\u1cc8᱕᳸\u0ea4\u1cbc᱒ᴏᳲ\u1cc8ᴗᴎᴗᴌ\u1cbcᳯᳯ᳟ືᳵຢ\u1cbc᳢ᳵᲿᰨᲿᴙຸᴌູ᳴᱕᳢ᴌᰧᴏ᳣᳹ລ\u1cc8Ჿ᳷ᰨᴖᲿᴃᴑ\u0ea4ຬᳬᴑຮ᳹ᴎ᳷ᰚᳲ\u1cbc᳥ᳱᴘ᳚ᴖᰜ\u1cbcᴋຶ᱕Ჺᳯᴙ᳣ᰨᰜᳶ᳷᱕ᰦັᳮ᳣ᴙᰝᴙ᳇ᳮᴏᴙᲽᴅᰩᳱ᳤ູᰜᰝᴙຸຢᴘູᲺ᳇ືᴄ᳢ᳯັ᳆ᰚᰧ᳤ັᴙູ\u1cbcᰦ᳸ᳵᳲ\u1cc9ຬຢᴏ᳴᳚ᳱ᳴ᴘᰜຫ\u1cc9Ჽືລ᳷ຢᳶᳬᳫᴎ᳢ູᴗ᳴ᳫ᳷ᴅ᳤ᳰᰝᰝᴑ᱔ᳶᳮᳮ᳟ᰛᴎᴅ\u1cbc᳆ᰝ᳸ᳵູᰚᴅᴖ\u1cc8ᴑ᳴ລ᳣ᰛᳯ᳸ᴎຬ᱕ᴗ᳸ᳵᴏᴃᴄ᳥ືᴘᴌຶ\u1cbcᰛຢᴑ᳆ັ᳟ຢຬᴃລᲺ᳢᳚ᳮຸᴃᰦᴏູຸᳲ᳚ᴂ᳟ᴏᲺ᳥ຢ᳣᳚ᰜᴙູ᳟ᴌຶ᳷ᰛᰩᴑᰚᰛᰝᳰᰝᴗ᳹ᴎᳶᴄᴋ᳸ᴖ᳇ᴘᴑ᳤\u1cc9Ჺ\u1cc8ຸ᱒\u1cbcᳶລ᳥᳤ᳵ᳸\u1cbc\u0ea4Ჿ᳆ᴎᴂᰧᲿᳰᰚ\u1cc8ᴅ᳷᳥\u1cc8᳣ᴘᲺ᳢ລᴎືᴗᲺᴗ᱕ᰛᴑ᳇ᴗᰦᳵᴄ᳇ᴏᰛᴅລຸᴅັຶᳰᴐᴙ᱕᱔᳇ᴅᳲ᱕ᳱ᳆ᴂᰨᴐູັ᳤ູຮ᳣ຸັ᳣Ჿᳬຢᰨ᱕ᴘ\u1cbb\u1cc8ᴏᴌ\u0ea4ᴋ᳸ᰦ᳥\u1cc8ᴗᳱ\u1cbbᴐ᳥ᰜᴋຶ᳴ᰨ᳟ᰜᳫᴗᴗລ᳤ᰝᴄ\u1cbcᲿ\u1cbcᳮᲽຫᴑ᳤ᴄ᱔\u0ea4᱔ັ᳥᳚ຶ᳹ᳵ᳴\u1cbbᴄᳫᳱຶᳰ᳆\u1cbbᴑ᳢Ჽᴂຮຢᳶື᱔\u0ea4ຮຢ᳣᳤᳴᱔\u1cc8\u1cc9᳴\u1cc9ᳱ᳤ຮ᱕ᳶ\u1cbcᴗລ᳚᳆ລᴌᳫ᳸ᰜ\u1cbc᳸᳹ຫ᱕ᴙລᰝຫ\u0ea4ᴃ᱒ᰜᳬ᳟᳟\u0ea4ᳯ᳣ᰝᰧ\u1cc8ᳮ᳢ᰩᳶᴃᳰᴏລຶຬᳫຮ᳚ᰨᴘᴋຶᳯ᱕ᴗຬ᱒ᴅ\u0ea4᱕᳣ᴘ᳷᳷\u0ea4Ჽᳮᳱ᳢ູᲿᳱ᳟ᴐᴄ᳹ᴅ᳢᱒᳣\u0ea4ᳰᰨ᳷ᴎᴘᰨ᱒ᴅᲽᳶᳶ\u0ea4ᴗᴏᰦᴏ\u1cc9ᳲ\u1cbcຸᳵᳰᰝᴂ᳚ᳰᴃ\u1cc8ລັ᳹\u0ea4ᳮᴅᳫ᳟\u1cbcᳱᰩᴂ\u1cbc᳆ᰝ᳥᳟\u0ea4ᰨᳲᴅᴃᴄᴋຢᴑᴂᳫ᳹ື᱔\u1cc8ᳲᲽຮᴌᳰັູ\u1cbbᴄᳲຸᳲຢᰚ᳴ຶᴌᳮᴑᳶ᳹ᴋູ᳸᳚ᴐᴙᴂᴌ᳇ັᴂᲺຮ᱒᳆᳚ᳬ᱒\u1cbbᴋຮᴎ᳢᳤ᰚᴑ\u1cbb᱒ᰜᰩ\u1cc8᳇\u1cbbຫᴙᰜ᱒Ჿ᳣ຸᴋ\u0ea4ᰧᴏັᳮ᳆ᴎᴎᰧ᳣ᴘᴙᴏ\u0ea4ᴗᰜ᳆\u1cc8ᳮ\u1cbcᴃᰚᲿᳯᳮᰦᰧᰦຬᳫᴄ\u1cc9ັູᲿ\u1cbb\u1cc9ຮᰧᴏ\u1cc9ᴘ᳴ᴑຶᰛ\u1cc8ᴃຮ᳆ᴄ᳤ᴂᰦ\u1cbcຫ\u1cbbᰛື᳷ᴌᴘᰦᴅ᳥᳟᳴ᳶ᳷ᳯᴂᰜᴑ\u1cbbືᲿᰧ᱔\u1cbb᳤ູ᳚᳴ᴂᴗັ᳟᳸᳴ᳰ᳥ᴌᴋຸ᳟Ჺ᳇ູ᳴\u1cbbᳯັᰧ᳢᱕Ჿᴙ᳇ຬ᱒᱕᱕᳤᱒ᰧ᱔᳸ᳬືᴅᴙᰛ᳹᱒ຸᴑື᳟᱔ᳵຢຬຬ\u0ea4᳸᳸ᴂᰩຮᴏᳰᴘ\u1cc8ᴖ᳣Ჿູᰚ\u0ea4ᴖᰧᴖ᳥ັຢຮᰝᳯᲽຶຶᴏ\u0ea4\u1cbbລ\u1cc9ᴄᴃູັᴃᴐᴋ᱕ᴅຢᴋᴏᴙᳰᳮ᱒᳟ᰩᴗ\u1cc9᳴ᳶᰚ᳷᳤ᴗᲿᰛ᱕᳆ຮຬ\u1cbc᳣᳴ᰦ᱕ᴋ᳣᳇᳣ᴗᲺᴂ\u1cbbᳬᰩຬຫᴗຮ᳣ຫຶັᴌᲺ᳹ᰜ᳸ᴎᰧ᳤ຬ\u1cc9ᰧᳲᳯຸ\u1cc8ᲽᴑລືᰨᲿ᱔᳢ᴗລື᱔ᳯᴑᳲᳯືᳶᴄ᳢ᴂ᳢ູᳮຫᴑ᳚᱔ᴃᴅᰧ᳹ᳫᴗ᳇ᴋ᳤᳟ຢᴏຫᰝ᳢ᴂᲿᴌᴖᲺᳯᳲᳱᰨᴏືᴐᲺᴎᴂ᳹᱕᳹ᳶ᱕᳚ລᳰ\u0ea4ᳰᰛ᳴ᴅ᳹ᰚᰩᰧ\u1cbb\u0ea4᳇ູᰚູຬ\u1cbc\u1cbbຢᴅ᱕ᰩຸ\u0ea4ᳱᳲᴙᰛ᳢ᴖᴃᰧ᳇ູ᳸ᴂᴏᴐᰚᴑ᳆ᰛຬᴐᳮ\u1cc8ᰩ\u1cbcຮ᳴ᴎ᳥ᳶᳯᳰ᳹Ჽ᳴Ჽᰛᴅ᳹ᴎ᳇ᴙ᱔\u1cbbᳶᰝຸ᳸ᰚ᳹᳴ᳲຫᴂᳫຢ᱒ᰩ\u1cc8ຶ\u1cbcᴑᳱ᳣᳢Ჺຸᳶ᳷\u1cbbື\u1cbb᳸ᳯᰨັᰚ᳆᳣᳚᳷ຮຬ\u1cc9Ჽຫᳯᴙᰛᰧຫᴗ᳷ᴅັᴙᴋຶ᳢᳸ຬᳱᴅຫ᳥ᴗᰜ\u1cbbᴑຸᰝᰚ᳹ᳯ᳆ᴃ᳸ᴋ᳆ᴋ\u1cc9ᴖᰜ᳥\u1cc8ᴘຸᲿᴌ᱒ູᴐ᳟ᳯᰦᳵᴑᴘᴃ᳷ᴋຮ᳤ᳲັ᳆ᴃᴏᰛຶᰦᴖᰜᴑຶຫ᳇ᳶᴐ᳢ᰨᰚູᳬᴘ\u1cbbᴋᴂᳯ᳥ᳫຫຫᳵ᱕ຶ\u1cc8\u1cbcᴂ᳸᱔ᴂ\u1cbbᴎຫ᳥Ჽᴘᴖຶᳵᰜ᱔\u1cc9\u1cbbᴅຫᲽ\u1cbbຸ᳹Ჺ᳚ຫᲿັ᳣ᴋᲿᴎຢᴖᴑ᳆ູᴙᴖᴗᴖᴂᴅᰚᰚ᳢ື᳴\u1cbbືᲺ᳤ຶᴄ\u1cbbᳯᴅ᳤ຮᴄᲿᰦᲿ᱒ᴏ᳟ຫᰝ\u1cbbᳵ᳢ຸ᳹᳆᳇ຫຶᴖᴗ᳸ລᰚᲽᴃᴐᳵᴘ᳢ᴌᰜ᳣\u0ea4ຢᴃᳫᴗᳲᳲᰛᴄ\u1cbc᳹\u1cc8\u0ea4ᴌᳫᰜᲺ᳚\u1cbbᲿᴏᲽᴙᴋ᱔ᳲ\u1cbc᳤᳹Ჺᴐ᳚ᳵ᳟᳴ᳫ᳹ຶᳰລᰚ᱔ᴎຶ᳟ᴋ᳷ᰧᳮືᰨຢᳲᰜ᳇ᰧ᳴ᴙᴂᳵ\u1cc9ᰜ\u1cbc᳇ຢᲺᰨᴗᴏືᴏᳵᳰᰨᰩ\u1cbb᳣᱒᳷ᰨັᴋᳫ᳢᳚ᴎᳲລᲿᴗᴋ᳸ᰝ᳸ᰜᴅᳰᴋᴖᳯᳵᳰ᳆᳤ᰦᳰລᴌ᳟\u1cbb\u1cbcᴏᲽ᳷ᳵ\u1cbcᴋᰦ᳤᳣ᳮᴎᴏ᳹ᴄᳵᳬຫ\u0ea4Ჿᴙᳵຸຢᰝ\u1cbcᲽᰦ᳇\u1cbc\u1cc9ຬ\u1cbcຫᴐᰛᳲ\u1cbbຬᴎຬᴖᴗᴅᴂຶᳵ᳹\u1cc8ᴌ᱔᳹ᴅ᳹ᳯູ᳟ᴏᰦᳬ\u0ea4ᴅᴂᰜ\u1cc9᳴ᴐᴘຶ᳤᳷ຬᲺᰚ᳴᳆ᴖ᳷ຸ᳟ᴙᳬᴐ\u1cbbຬᳮᰧ᳣Ჺຬຫລᴎ᳥᳴᱔ᳬ᱔ᳰᰜ᳣ັᴋᴐ᳇᳟ᳲ᳇ᰜ\u1cc8ຮᴎᴎᴅᴗᴏᴗᰧັັᰚᴅ\u0ea4᳴ᴅᰨັᰜ᳢Ჽᰨຶຸᴙᴎ\u1cc9ᴖᳰ᳸ᰚᴙᰝ᳣ᳬ᳢᱔\u0ea4ᴋᳮᰧᴃᴋລຶᴖᴅᳬ᱔ᰚᴐ᳹\u1cbcᳵᲿᳰᲺ᱒᳴ᰦᴖᲽᳵᰛ᳚ຢᳱᴑ᳣ᳰᴖັᴐᰛᴄຶູ᱔ᴐᰨᳵᳬລ\u1cc9ᳯᰝ᱕\u0ea4Ჺ᳥ᰧᳲᲿᰜᴋᴙຢᴗ᳣᱔ᴏᴏ᳆ᴅຫ᳤ᴄᳫᲺᲽᳶ᳆\u1cc9ᰧືຢᳶ᳴ᴄᴑᰜᴘ\u0ea4᳇ᴋᰦᳯ᳴ᴃᰚ\u1cbcᳰລᰧຶᲿᰚັᳵ\u0ea4᱒᳣ູᳬᳶᴃᰨᲿᴋᰧᴎຫູᰨᰦᳵລລᰩᴄຸᴌ᱒\u1cc8᳣ᴘᳶລຮᴌລລᴃᴐຮ᳴᳇᱔ᰨ\u0ea4ລᴖັᰜᴗ᳸᳸ᴗຸᲿᰛຶ᳷ᳰ᳆᳚ັᴋᰧື᳸Ჽᳵຢᳶᰨᴑ\u1cc8᳸ᰚູ\u1cbcᴃ᳇᳢ᴙᴐᳮᳰᴄ\u1cbb᱒ᴌᴄ᱔ᰛ᳤᳣ᰝ᳴ᳮ᳢ᴖᲿຫᰛᴗᴋ᳢᱒ᴙ᳥᳆ᰚᴄລ᳣ຮຢᳶᳱຫ᳸ᰦລ᳣ູູ᳟᱔ຬ\u1cc9᳸ᰦ᱔ຮᰛ᳢᳷᳟᳷ືᴂᳬᴘ᱕ᴄ\u1cbbᳮ᱒ᳵᴂຫຫຬ᳆ືຢᰦᰧᰦᳬᴗ᱔ᲽᲺຢ᱔ᰛᰩຢຢ\u1cc8ᰚ᳢᱕ᳬຸລᴑ᳢ᳯᰨᰜ᳢ຸຮᳮᳮᴑᴖᳶᰝᴖຫᴂᰝᴎᰨᴃ᳆ᴙᴅᴏᳫᳯᳱ᳸ᴘᳮລᴖᲿູູັ᳥ᳯᰧᳬູ᳸ືᲺᳰᴗᴂᴋᲺᰝ᳇᳴᳴ᳰ᳟\u1cc8᳥᳢᳢ᴐᳶᰛᲿᰧᴘᴖ\u1cbcᰜ᳢᳹Ჿູᴑ᳆ᴘ᳇ᰦᳶ\u1cbb\u1cbbᰝᰛ\u1cbcᴑᰜ᳆ຶຮ\u1cbb᳆᳤Ჿᴂຢᰦᴗᰨᴐᰧ\u0ea4ᰚ᳤᳸ᳲᳶຮᴗᴃᲽ᳆ᰜຶູᳲᴋᳱᲺ᳢ᳵᴋ᱕ຢ᳆ᴐᳰ᳢ᴙູᰛᴄᰨ\u0ea4᳹\u0ea4\u1cbbຮ\u1cbc᳤ຶᴑᰩ᳹ຫᰩᲿᴗຸᳰ᳢᳟\u0ea4᳆᳢ᳵ᳥᳸᳹᱔ᰩລᰨ\u1cc9ᳮᳮຢᲺ᳹ᰦ᳢ᰝᳱᰧ᳷ᴂ᳟᱕ᰜᴃ᱒Ჽᴑ᱒\u1cc8ᴄᲿຫ\u0ea4᳸\u1cbcᳵᴎ᳴ᳱຸ᱒ᴃ\u1cbcᰜຫᰜ᳹ຢ᳤\u1cbb\u1cc9ᴄᳮᳱ\u1cbbລᰦᲿᲿ᱕Ჺᴅᴐ᳹ᳯᳲᳯ᳹ᰦ᳷\u1cbcᴗᴂຮᴂᴑᳬ᳣Ჽລᴃລᰦᳲᰜᴋᰜ᳷᳥\u0ea4᳤\u1cbcລັ᳸᳷ᴂຬ\u1cc8ᴑ᳆ᳮຢ\u1cbbັᳰᴄ᳟᳷ᰨᲽ\u1cc8ᴎᲿᴗ᱕᱕\u0ea4ᴃຫᲽູᳱ\u0ea4ຶᳶᳯລᰧືᳰລᴃᲽᰝᳬᲺᴌ᳣ᴌ᳷ᴐᳫຫᳵ᳢\u1cbb᳸ᳱᰨᴐຫᲽᳫ᱔ຮ᱕ᴎᲿ᳷ັ᳢᳤᱔᳢ᴖັᳵລ᱒᳣ຫ\u0ea4ຶູᴏᳶຬᰨᳰຸᴏᳶᴂ᳹\u1cbb\u1cbcᳱᳱຶ᳥᳴\u1cc9ᳫᳫᴑຮᰝᰦᴎᴄᳲ᱒ᴖᲺ᳥ᳬ᱒\u1cbbᲺັᰝᰜ᳥᳢᳟ᳶ᳚ຶ᳢᱕ᰨᴂᳰᰝຶᴂ᳴ᰦ᳸ᳫᳲᰩᳰຸᴋᰚᴄᴂᴎᰜືຶᰚ᳟ᴎᴄᰧ᳟ຢຫᴑຬᴋᴗ᳆\u1cbc᳢᳆ᴗᳱᳫ᳸ᴃᴃᰚᳶᴘ᳟ັᰛຢᴋ᳤ຢຶᳱᳮᰝ᳆ᳶ᳥ຸ᳟᳹ᴙຬ᳹ᴌᳵᳫ᳣ᴋ᱒ᳶຢᰩລᴅຢᴅᰨ᳚ຢᴗ\u1cc9ᴌຶ\u1cbb᳣Ჿຶ\u1cbcᳯືᲿ᳚ᰧᲺ᱒ᰨᴘᴂ᳢᱔Ჺຶ\u1cbbᳵᰜᴂᴑᳯຢᳫ᳴ັᴂᲺᳯຸ᳆ັ᳥᳹ᰩᳫᴗ᳢ᴅຢᴑᴋ᳇ᴖᲽᴖລ᳆᳷\u1cbbᴏ᳣ᴑᴅ᳆ᴋ᳣\u1cc9᳢ᴐᳵᴐ᳴ᳵᳲᳱ\u1cc8᳟᳆ᰨᰝᳶ᱔᳇ᴎᴋᴋᴑ᳚\u1cbbຮᴂ\u1cc8ᳵ᳹ᰧ᱒ᰛ᳢ᳯᳱᴗຢ\u1cbcຫ\u1cc8ᴄຫᰝᴂຸ\u0ea4ຮᴖ᱔᳴\u1cbcຢᰝᳱຸູ᳚᳴ᳮຸᲺᳬᰨᴎᳶᴑູᰛᴑᰜ\u1cc9Ჺືᴏᴖᳬᰝᰛ᳟ᴏ᳢\u1cc8Ჿ\u0ea4ᴋᰨ᳆ຢᰛ᳸᳸᱕ᰚລᴗᴑᴑ᳹ᰩ᳇ᴏᳫᴋᰛ᳤Ჿᴂᴑັ\u1cc9ັᳬື᳣ຫັᴎຬᲽᰛᴌᴌ\u1cc8᱕\u1cc8ᰚᴋᰨ᳢ᰜ᳸᳹Ჿᰝ\u1cc8ᰧᳲᲺ᳥ູᴗ᳣᳹\u1cc8ᴘຫ᳤\u1cbbᳲ᳣ᳰᴂᴄ᳹\u1cc8᳚ᰝ\u1cbbᰝᰚ᳷᳴ᰩ᳇ຬᰛᴂᳬᴎᰩᳲᰜ\u1cbbຫᳬᴗᰦູᰧᴙᳬ᱕\u1cc8ᰛᴎᰦ᳚᳴Ჺ᳣ᴙຬᴅᰧູᳯ᳢ູᴐຮᲺᴐຬᰜᴄ᳢ᴙᳲ᳥ᴂᰩູ᱔ᴗᴋ᱒ືັᲽຶ᳴ᴎᴏᳵᳶ\u1cc9ᰨຢᰛຮᴏຮ᳢ᳲ᳢᳷ᴎັ\u0ea4\u1cc8ᰚ᳆ᰦ\u1cbcᰨ᳆ຬ᳇\u0ea4ᴖᴌᴑື᳇ᴎ\u1cbcᰧᴂᲺ᳚\u0ea4ᳰ᳣ᰝ᳆ᴖ᳣᱒ᴘᳫᴐᴖູັ᳆᳣᳟᱔ᴗ᳹ᴋᳲᳱ᱒ᳬᰝᰧᴋ᳢ຸᴋᰚᴄᰝ᳆ᴃ᳣᳹ᰨຫ᳚ᳰᲺᴑᳯ\u1cc8ᳶᴗᲿᴂᳯ\u1cbc᳇ᴙ᳤ລᴙ\u1cbcᴋ᳢᱒Ჿᳵᳫ᳥ຸ\u1cbcᰨᴘᳯຮ᳚ᴙຮ᳣ᴎᴏ᳥Ჿື᳴\u1cc8᱔ຢᰩຸ\u1cbb᳣ᴂᴅᳵ᳤ᳱᰧᳮ\u1cbcᴂ᳥ᴖຮᳫ᳢ູ᳚\u0ea4᳸᳹ᳶຢ᱕ᴃລᰩ᳤\u1cc9ᴖ᳢ᳫᴏᴙᰜᴋᰦືᰩᳵᰦᴌື᳟᳹ᰦ\u1cc8ᰜᲿᳯᰚ᳆ᳲ᳆᳚ᴑ᳹ລᴗᳬ\u0ea4ᰨᳶᴘᳬᴄᴎ᳴ᴋᳶᲿ\u1cbbᴄᴏ᳸Ჿᳰ\u1cbc᳤᳢᳢ᳶᴃᳵ᳹Ჽᳱ᳥Ჺ᳹\u1cbcᰦຫᳱᲿᴖ᳇ᴅᴐᰧᰛຫᴗຫ᳣ᳵᴘᰧັᰨລ᱔᳇᱔ູᴅ᱒ᴄ᳢ᴃ\u0ea4᳚ຢᳬ\u1cc8\u0ea4ᰨ᳤Ჽຬᰛ\u1cbbᰛ᱒ᴎᴘᴘᴐᴙᰧᴂᴖᴎᰝᲽຶᴏ\u1cc8᳥᳟\u1cc8ᳲ\u1cbbᴐຢ\u1cc8᳇ᴌᴐ\u1cbc᳣ᳵᰩᴙ᳤᳥ᴋᰦᴏ\u1cbb᳴\u1cc8ᰦᰜᳯ\u1cc9ᴑ᳥ᰧᳫᴑᴎᴃຮᴌᰜᰨລᳯ᳢ᴋᳱຬᳶᴂຬຢᳵᴑ᳹\u0ea4ຸᲺ᳆ᰨᳰᴖ᱒᱕᳹ᳵຶᳮ᳹ᳰ᳢᱔᳤ຸ\u1cbcᳵັ᳚\u1cc9ຸື᱔ຮ\u1cbbᰩᴑᰨູ᳆ຮᳱᴏᳱᴑ᳴᳆ᴗᴂ᳤ᰦᳰລູ᳇᱒ᴎຫລ᳷᳚ᳶ᳤ᴅᲺᳫ᱔ູᲺᰜູ᳚ᰧᴌ\u1cbbູ᳹ᳶᲿᲿᴂᰜᴙ᳷ᴎ᱔᳸᳴ຬᰨᰝ᳤ᴐູຢᴌᳰᳬᴎຬ᳴Ჿ᱕ູᴖᳶຫᲽᰚ᳤ᳶᴗ\u0ea4ᴎລᴎᳫᰝᰧ᱕ᴑᰛ\u1cbc᱒ᳱ᳷ᰦᰚ᱕ᰦᳶ᳤᳇ັຢ᳷ᴘᲽᴐຬᳫ᱒᱒Ჺ\u1cbbᴎᴑ᳸ᴃᴃ᱒ᴙᴘ᳇\u1cbbᲿᴙ᳆ູᲺᳮᳰຫ\u1cbcᴅູᲺᳲᴑຫັລᴌᲺຸᴄ\u1cc9\u0ea4᳹ᳯᴙᳯ\u0ea4ືᴘᴏ\u1cbcᲺᰜຸ\u0ea4ᴃᴌຮᰚᴎᳵ᳇᳢ᴋລ᳇᱒ᳱ\u1cbc᳢ᳮᴙᰚ᳚ᴋຸᴗ\u1cbbᳱ\u1cbbᳰᳰᰛᰨ᳤ຮᴅᴑ᳹\u1cc8ᳮᳬ᳟᳸᳚᱒ຶᲺᳮືᴄື\u1cc8᱔᱔ັຫᴖຶᴖ᱕ᴑᰜ᳹᱒Ჿᴃ᱒\u1cbcᴂ᳷᳥᳣᱔ᰚຢᴏ᳢ᳲᴏຮᰨ᳢ᰦ᳚\u1cbbᳮᴄᰛຢᳲູຮᴌᴋ᳤ᴋᲿᴄລᳮᴏ᳢\u1cbc᳚ᴃᳯᰝᴖᴑຮᴎ᳇᳟ᳫᰧ᳷Ჺᳵຮ᳤᳸ᴂຫ᳆ᴃ᳢ລູຫ᳴\u0ea4᳢ᴃ\u0ea4ຢຮᰝຶᰨᳱᰧ᳚ຶ᳷ᳲຬືᰨຮູᴖ\u1cc8ᰩᴌ᳣᱒᳥᳴ᴐື᳇ຸᰚᲺ\u1cc9\u0ea4\u1cbcᳰ᳟ᳲᴏ᳟ᳯຢ\u1cc9ᳫື᱒ᴏᲿ\u1cbb᳣᳣ᴘຮ᱔᳴ຮູັ\u1cc8ᰚᴅᳰᴄຢᰛᳵຢᰝ᳢᳤ລຶຶᳶຮᴎ᳴ᳯ᳥ᴋᳬᳰᰝ\u0ea4᱒᳣᳆Ჽᴄ᳴ຫᲿ᱔ᰝ᳣ᴙ᱒ຬ᳴ᴏᲿᴖᴌᴑ\u1cc9ᳲຶᴐᴎᰝᰦᴑᰚ\u1cc8ᴄᴐᴅ᳇\u1cbcᲺລ᳆ᳯ᳴ຬᴏຶᲿᳶື᳷ᴗᳯᲺᴃᴗᴑ᳴ᳬᳶຮຶᴗື\u1cc8ຸ᳇Ჿᰩᴃᳬᰜ᱔᱕ᴌຶᰨຶᰝູຸᲿ᳤᳴ᰦᰚ᱒᳢Ჺᴙ᳇᳢ᳱᳰᰚᴗᰚᰛ᳢Ჿᴗᴑ\u1cc8ᳮᲺ\u1cc9ᴎᳮᴅ᳇ລᴐᳱᰧ᱕ຶ᳤\u1cbcᴋຢᴐ᳆᱔ᴏຮᴑᴎᳮᴑᳵᴋຸᴅ᳥ᰧᴂຶຸᴖᳯ\u1cc8ᴑᳶᳯ\u1cc9᱕᱒ᳮᴗ\u1cbb\u1cbbᰝᳯᴌຮᴅ᳤ᴌᰚ᳟᳹ᴖືັᳰ\u1cc9᳤ᰝ᱔ᴎຸᰨ᳆ຬᰦᰚᳶᴖᰚ᳹ᰜᲺᲽᰧູຫຶᳯᴘ᳷ᳰ᳚᱒ᴋຬຮᳮຫ\u1cbb᳟ᴎᰩ᳆ᳬᴑ᳸ᰛ᳹ຮᳲຶ᳴ᰦ᳆ᴌ᳣ᳯᴄᰧ\u1cbcᴏູ᳚ᳬ᱒ᴑ\u0ea4ລᰧᰚ\u0ea4ᰩᳯᳫັ\u1cc9ᳯᲽ\u1cbb\u1cc9ᳰᴖ᱔᳥᱕ᳲᴏᰨᴖຢ\u1cbbᴅ᳴ືᴋᴂູູᳰᴗ᳆\u1cc8ຫ\u1cbb᳥᳴᱔\u0ea4ᴑᴌᴐ\u1cbcᰦືຶᳲᰛᳲᴗᳯᴏᴃᴃ᳆ᰩ᳷ᴐ᳣ᳶᴋ᳆Ჿᰦᳫ\u1cbcຬᳱ᱕ᳫ᱒ᳲᴎᴐ᱕᳴᳸Ჺ᳇ຫᴏᴎຮᳯ᳥ᴖ᳴᳴ᴋຶᳲ\u1cc9ᰨຬື᳴ᰦ\u1cbcᳫັ᳸ລᳱຶ᳴ᴗᰜ᳆᱔ᳶ᳚ັ᳇᳆ᳰ᳢\u1cc8\u1cbcᰛᴅ\u1cbbᰝ᳹᳹᳹ᴋᴗ᳢ຢᰩຢຮຬᳫᰨᳰ᳸ᴏຬᴖ᱔᳟᳴ᰩ᳴Ჽᴏ᳢᳹ᳰᳲᰩᰧ᳢ᴘᴘ᳹ᴑຮᰜຸ᳚\u1cbcᴙຶ᳆ᳬລ\u1cc8ᴎᴌᴎᴐᰜᳰᴐືᴃຸᲿຬᴙຫᴎ\u1cbbᴖ᳸ᰨ᳢ᴘᴗᴏຫᳶᰦ\u1cc9᳥\u1cbcູᳲຮ\u1cc9\u0ea4᳢ຬᳬ᳟᳷ᴘᴋᲺ᳹ᰚᳶ\u1cbb᳆ᰜຶ᳸ᴂ\u1cc9ູᴄຢຢື᱕ᰛᰦᰧᳬ᳴Ჽ᳥ᳰᴖ\u1cc9ᰝᴎᰧັ᳥ຸᴏᲽ\u1cc8ᰦᰦᴘ᱕ລᲿᳬᴐຶ᳣ᳫᲺ᱕᳤Ჽັ᳹Ჺ᳤ᳵᴗ᳹᳴ຬᴅᳯຮ᳥ູ᳟᳚ᴖ\u1cc9ᴅᰧ᱒᳥Ჽ᳣Ჿᳫᳵᳵຸ\u1cbbᴅ᳚ᰧ᳚ັᰚ\u0ea4᳥ຬᴂ᳚Ჿᳮᰜ᳣ᴗᳫຶ\u0ea4ᴙᴖᴗ᳷ູ᳹ᴗᰛᳮᴌᳶᳬ᳹᳴᱔᳚ᳮຸ\u1cc8ັᴃᲺᴖᴌັᴏᲿ᱕ᰚ\u0ea4᳷\u1cbbຮ᳣ລຮຢຮᴄᴃᴑັ᳟Ჿ\u1cc9ᰚ\u1cbbᴐ᱒᳢ᴖຮᴖᳮᴅᳮᴏᳮຫ᳣ᰝ᱒ᴎຫ᳢᳚ᰛᲺ᳣᳚᳇ᰝຸᴏᴘᴃ᳣᳹ᴄຬᰚລ᳥ᰩᴑᳬᳶᴎ᳸ᰩ᱔Ჿັᰩຶᴂᳮᳯᰨᴄ\u1cc8ᴖᳮູ᳚ᴃᴃ᳸ᳱ\u0ea4ᰩᴄັᴅ᱕ລຬᰝᳫຸຢᴑᳲᰝ᳣᳹ᳵᴏᴐᳫᰜ᳢ᰜຫ᳸\u1cbc᳷ຸ\u1cc9ᰦ\u1cbcᳰᳬᳬᳵᳰᰧᴄ᱔ລᴃᳱຢᲽᴌຶᴑᳮᴗᳶᴘᰜᰜ᳟᱕\u1cbb᳚ᳲᴋຶືຶᲿ᳚᱔Ჺᴘᳰᴄᳯᳵᴐᳬᴅ᳸᳆\u1cc9᳚᳆ᳰᰜᴐ᳢ᴂ\u1cbc᳴ຶັᲽᳶັຮ\u1cc8\u1cbb᳢ᴗᴃ᳹ᰝຶຫ᳤ᰜᳱᰩᴌ᳥᳚ᳱᴙᰧᳶ᳇᳹ᴅᴂᲺ\u1cbcᲺ᱕ᴌ᳟᱔\u1cc8᳴᱒ᴖ᳴ᰜᰚᲿᴋᴐᳱ᳆ᰨ᳢᳸ᳵᴌᴂຮᳯ᳣ᴙᴏັຶᴋ\u1cbbັ᳚ᰛັ᳤ᴗᴙືຸ᳹ᰚ᳚ᳬᰧᴂᰚ᳥\u1cc8ᳱᴗຢᳶᰩᳲᰜᴌᳫᳫ᳥᳴᳆ᰜ᳇ᰨᰦᴗᲺ᳤\u1cbcᳯຬູᳰᳰ᳆ᰛᰝᳯ᳹ᳲລ᳇ᳯᳵ\u1cc8ᰨ᳆ᴄ᳟ᳶᲿᰝᴙᰩᴐᴅ᳴ᰚᳲᰝᰝ\u1cc8ᳵᴐ᱒᳢᳤ຸູ᳚ᳲ᳥᳷ᰧᴏᴄ\u1cc8\u1cbcᴌລᰧ᳢᳴ᳶ᳤ᳫᴏ᳢\u1cbc᱔ᰛᰚື᳹\u1cc9\u1cc9᱔ລລ᳹\u1cc8ຶ᱒Ჿᳵຢ᳹᳹ᳶᴗຢᴗ᳸ᳬᳫᰚᴙᴃᴄຶᴏຶ\u1cc8᳆ᰜ᳢ᳱᳵᳰ᳴ᴄ᳢ᰨັᲽ᱔ᳲᴂᳵ᳴ᰨᰜ᳆\u1cbbᲽᳮ᳷᳥\u1cbc᳇ᰦᳫᴋᰩᳯ᳢ᳬᳯᰛ᳴\u1cbbຫຸ\u1cbb\u1cc9ᴂ᳹ᳶᰜᴘᰝᰜ\u1cc8᳢᳥ᴖᳬ᱔ᴎᴑᳰᴋᳰ\u1cbb᳢᳸ືᴏ᳥᳷ᳫຢᳰᲿᳯ᳚ᰦ\u0ea4᳆ᰧ\u1cc8᳆\u1cbbᴏᰦᳫᴋᰝ᳤ᰩ᳸ືᰦᴄ᱔᳆ᴑᴃ᳇ᴘຫᴂ᳴᱕᳣ຫᳵᴄ᱕ᳵᳮᲿ\u0ea4ᳶᴙᲿ᳣ᴌᰨ᳴\u1cc9᳢᳢ᳰᳶ᱕ᰨᴙᴄ᳹ᳵ᳆ູᴋᴃ\u1cbcᰧຬ᳢ᳶᳰ᳷ᴗຫᴋᳬᰧ᱒\u1cc8Ჺᳬᴗᴋຶ᳚ືລᳲຶᴎᳲ᱕ᰩ᳚ᳫᰛᳶᰚᳰᰛᳵ\u1cbbູ᳟ລᳫ᱕ᴑᴘᴏᴌຶᰚ᳤Ჽ\u1cbb\u1cc8ᳶᰜ᳥ᴋᴙᲽᴑᰦᰝᴃລᴄ᱔ຮ᳥ᴂᴅᴋຶ᳢ᳰັᰧ\u1cbcᳯᴎᰛᴄᴌᲿᳯ᳴\u1cbc᳢ᰜ᳟ᴏຶ᳢Ჺ᳸ᳫᰦືᴙລື\u1cbbᳬᴐ\u1cc9᳣᳥ᰨ᳚\u1cbc᱕᳸ᰝᲺᴎᴙຢ᱕ᰧຸᳬ᳷ᴋ᳣᳥Ჽ᳟ຢ᳷᳥\u1cc8Ჿᰝᰝᴗ᳢᳟ᳰຸ᳚\u0ea4᳇ᴖ᳇ᰝᰦᳶᳲຮ᳴ᰨᴋ᳥ᴏລᴖ\u0ea4ᳰັຫຬ᳣᳚᳹ᰚᴖᴘᰧ᳇ᳰᰨᴋᴄຸ᳆\u1cc9ຫ᱕ᰚᴎຮᲿᲿ᳚ᳮລຶᲽ᱕ᳬ\u1cbcᳮ᳥ຢ\u1cc9᱕\u1cbb᳇ຬᴑ᳚ᰩ᳚Ჿືᴋ᳹ᰛᴃ᳤ᰚ᱔\u0ea4ᰛᳵᰦᴐຸᳲ᳥᳚Ჺູ\u1cc8ᳫ᱒᳚ᳰ᳣ືᲽ\u1cc9ື᳹ᰛᲺຶᴐ᳸ືຢຬຫᲿᳮ᳟ᴄᴋ᳆ᳶ᳇ᰧᳯᴏ᳇ᰜᰧᰝ\u1cbbᲿຫຮᴏᴄᳲ᳇ᰝᲺ᳹ᰨ᱕ᴎᴄᳶᴙᲿᴄ᳟᳇ᰨຬᰨᳶᳯᰨᴎຸᴗᲿລລᴃ᱒ູᳵ᳸᳸ᳵຸᰝᳵັ\u0ea4᱕ᰧᳮ᱕ັᳱᳯ᳆Ჽᴏ᳸ᰩᴐᰧᰝᴑᳰ᳆ᳯᳶ᳇᳸ᳶᰜᰦᴖ᳇ᴅຢᲽ᱒᳟᳟\u1cc8ᴃᴎ᳹᳴᳇ᴂᳲຸᳫᴂ\u1cbbᳬ᱕ᴎືັᴗ᳴Ჽ᳷\u1cc8᳤ᰜັᰝᳫᲿᳮᳫᴄᴅ\u1cc9ᳵᲽᰧ\u1cc8᳴ᳫᳱ᱒ᳯຸᰩᰛᴖᲺຢᳮᰝືᴃ᱕᳚ᴎ᳥ᰦ᳹᳹ᴋᰝຫᳲᳶᰨຶ᳤᳚ᰝ᱕ᰛຶ\u1cc9ᰨ\u1cc8ᴎᴋ᳚ᳰຮᴑᴐຸ᳴\u1cbbᴖື\u1cbbᰚᳶ᳹ຫຶᳱ\u1cc8ັ᳇᳸ᳮᰚᴙ\u1cbcᰧຮᲽᳲ\u0ea4᳇ᳫ\u1cc9ᴐᴏຫᳮᳫຢᰚ᱕Ჺ\u1cbbᳲ᳤ຢ᳸ᴐᳯᴙᴂ\u1cbb᳹\u1cbc᳢ᳰᰧᲽᴎ᱒ᰝລᰜᰨᲽᴖᴎᴄᰦ᱔ᴑື᳴ᰝᰛᳰᴘູ᱔ᰨ᳷ᴃᳮᴘᴄᳫᴙຢᰩᴏ\u1cc8᱔᳟ᰜᲺᲺᴐ\u0ea4ᴑ᳷\u1cbcᴌຫ᳢᳥᳟\u0ea4ᳵ᳥ᲽັᰛᳰᴃᰚᳶັᴂᴄᲽᴙລᴌᳯᰧᳬ᳆ᴙᰝᴄ᳤ຸᴙᴋᰧ᳷᳤ᳬᳶᳯ᱔ᴎᳰລᴌᴅᴃᴄື᳤ᴎຫ᳤ᳫ\u1cc8ຮᴑ\u1cc8ᳲ᳆ᳫᴎ᳣᳥᳤ຶ᱔᳸᳷᱔᱕ᴖᴙᴖᴐᳰᴙᴃ᱒ຫ᱕ᳬᴅ᱔᳷ື\u1cbbຶ᳤ᴋ\u1cbbᰧᴐᳯᰩ᳢ᰚ᳤\u1cbbᰝ\u1cc8Ჽᴑ᳴᳆᳆\u1cc9ᴅ᱕ᰛ᳴᳷᳴ᴃᳮᰚຸᴋື\u1cc9᳣ᴋັᰜຸᰨᲽᳱ᳸ᴑ᳇ᳶᴋᴌ᳤ᳲᰦ᳟\u1cc8ᰩຶᴋᳰ᳴\u1cc8ຶ\u1cbb\u1cbc᳆ᳬັຫ᳸ᳱᰚຸຫᰛ᳆ᴘᴄຢ᳟ᰚຸᴐຶ᳣ᳵᴌᴋᴗຸ᳚᱔᳷᱕ᰨᴃ᳚ຬ᳸ᴋູᲽ᳹ຢ᳇᳟\u1cbcᴗັᲿ᳴ᳱᴋᳱᳰᰨ᳥ᴃᴙ᳇᳚ᴏ᳣᱕ລᴘ᱒ᳰᴑᰨᳵᳶᴄູ᳸ᰝᳫᰩຬᳲຫ\u0ea4ᰚ᱒ຸᴌᴌᳫຬᰛູᰧ᳚ᴏ᳴ᳯູ\u1cc9ᴋᳱᳬᴎᰚ᳴ᳲᲽ᳷᳷᱔᱕ຬᴙᴐ᳷ᴖᴖᰨຶᴗ᳚\u1cbcᴐᴎ\u1cc8᳸ᳬᳰᴙ᳚ລ᱔ᳫ᱒\u1cbbᴏᴏ\u1cbbຬ᱕᳣ᴖ᳆ᴎ\u1cbbᳰᴗᰝᴘᳫᰨ᳥ᴘᴖ\u1cc9ᴘᲽ᳆ᴘ᱒ᴄᰜ᱔ᳱᳮᴖᳯᳲ᱕ຸᴑᴏັ᳚ᳫູᰧ᳣ᰩ\u0ea4ᴘ᳇ᴃຫᴅ\u1cc8ᳱᴎ᳇ᳮᰦ᳥᳢᳷ᰚຶ᳇ᴑᳲᳲັᴑ᳥ຸ᳸ຮᳲ᳹ຫືᰛ᳢ᳵᲺᰩ᳟ᰧຸᴙᳶᴄᳶᳵᲿᲽᳮູᰛᳲᴋຸᳬᴙᴘᳵᴄ\u1cc9ᴅູᴙ\u1cc9ລᴗᰜᴗᴐᲽ᱒ᳱᴗᴂ᳹ᳫᳵ᱒ᴂ᳸᳹ື᳤᳣ᳵ᱕ᴅᴅ᳸ᴑ᱕ᳮᳵ᳆ᰧᴎᴌᲿᴐ᱒ᳲືᳶᴐᳵ᳴ັᴂᰝᴃຬ\u1cbcᴋຫຮᰝᴑັᴅ\u1cbbᳱ᳇ᰩ᳥ᳲᳫᴂ\u0ea4᱒᳤ຸ᳹ᰩ᳹ᴖຸᰧᴏ᳆ᳶᴎຶຶᳫᴅ\u1cc9ᴎຫ᳚ᳲᴑᴂᴏຫᴄᴅູᰝᳬᳮᳶ᳚ᴅᴖᳫ᳆\u1cbbᳬ᳟\u1cc8ᳱᲿ᳷ᴅᲽ᱕ຢᳫ᱒᳤Ჺ᳹ຫᴏᴅ᳇ᴂ᳆\u1cbbᴐ\u1cbbᴙ᳣ᳬᰦᴙ\u1cbbຮຶᴏ\u1cc8ᰝ\u1cc9ᳱᲽᲺᳮູືᰧᴅᲿ᳟᳆ᳬᲺᴃᰝລᳵ\u1cbcᴑ᳇ຮᲿᴎ᳷ᳯ\u1cc8ᴖ᳚ᲽᰛᲺᴙᲿ᳴ᴗᰝᰨຸᴌᴋᴋັᴄᴏັ᱔ᰩລ\u0ea4\u0ea4ᰨᴏ᳷ລລ᳢ຫ᳷\u1cc8ᴗᳯᰚᰦູᳬຶᰨᳶᴃ᳟ຫ᳢ᴖ᳴ືᴄᳲᲽຮᳬ᳤᳇ᳮᴗ\u1cc9ᰚ᳣ᰧᴎ᳹᳴ᳶ᳴\u1cbb᳟\u1cbb᳴\u1cc9ᰦᳫᳶື᳢᳷ຮ᳥᳥ᰚຸᴅᳬᴙ\u1cbbຶ\u1cc9ᴖ᱕ᴃᰚູᰝ᳇ᰛ\u1cbcᴋ᳆ᳵ᱕᳣᳚Ჽຢ᳷ᰜ᳴ᳫᴅᳱᳫᰚ᳹ᰩᴃᰧᰜᰝລຬ᳹ᰩ᳚ᴎ᳇᳟ᰦ᳥᳹ລ᳥ຸ᳸ᰛລᳲ᳥᳸ᴖᳲ᳹᱔ᴑᴂ᳷᳥ᰨ\u0ea4ᳮᲺ᳤ᳲᰜᴗ\u1cbbᴖᳲᴖ᳇ື\u1cbc᳥᳇Ჿᰨᴙᴖຢຬ\u0ea4᳷ᳮᴎ᳇᳇Ჺᳱ᳹ᳶ᳷ᰧ᳆ᰩ᳇ື᳥ᴖᰚ᳣ᳰຶ\u0ea4\u1cc8\u0ea4ລᰜᴋ\u1cc9ᰛᲿ᳴ັᳵ\u0ea4ᴄᴂᳶ᳆ᴎᴑᳰ᳣Ჽ᳣ᳵຶ᳚\u0ea4ᴗᳰᰩ᱔ᳫຢᴅ᳟ᰨ᳷ᴖ\u1cbbᳮ᳴ᳶ᱔ᳫ᳹ᰧ᳟\u0ea4᱔ᴘᳱᳯᴗຫᴄລ᳣᳸ຬ᳢ຢᳬຢ\u1cbb᳚ຫຮ᳹ᴌᴋ\u1cbcື\u1cc8᳷ຢຶᴃ᳤ᳯᳰᴙ᱒᳇ᴐᴅ᳷ູᰜᴘᴃ\u1cc9ᰝᰨᳮ᳷ᳫᳯຫᳬᳯᲿຬ᳷᱕ᳲ᱕᱔᱕ᰨ᳣᳟ᴅ᳴ᳮᴐᳶᴅᰚື᳷ᳵᰧᳶᴏ\u1cc9᳢ᴋᲺ\u0ea4ᳲᰛᴃᳶᲺຬᳮ᳢ᰩᴅ\u1cc9ᴑ᳣ຢັູ\u1cbbຢᲿᴘᲿ᳚ᳲᳮᳲᴄຬ᳟ᴃᴖູᳮᲽᴅᴑᳰᰦᴏᳱ᳢\u1cc8\u0ea4ᴂ\u1cc8ຶ᳆᳇\u1cc9ᴑᳲຮᳰ᱕ᰝᴌᴂ᳤ᳰ᳸ᴐ\u1cc8ᴐᳱືᲽᳲᴅᰩᴖຸ᳸ᴋຮᰝ᱔᱔᱒ຶ᱔Ჿຫᴗᴄ᳥᱒ᰝᴃ᳸ᴑᴄ\u1cc8᳸ᴖ\u1cbcᴗᴐᰜ᳇᳥᳟ັᳫᳶ᱔᳣ᰜ᳹᳆ᳬຮᴘັᳫຸູ᳴᱒ລ᳤ᴏᴄືᰛᴎᳮ᳸ᰦᴎᰨຬᴄ᳢Ჽᰝ\u1cbbຶᴏ᳟\u1cbbᰩᰨᴖ᳥᳹ᳮຫᳮ\u1cc9ᴑᴐຸ᳟ᴘ᳥ᴙᴗᲺᴖᴄ\u1cbbᳮ᱔ᴐᳮᴂ᳸ᴗ᳸ᰧᳱ᳆᳴ᳮ᳹ᰩ\u1cbb᳢ᳰᳯᴑຬᴐᴌᳬᰛᴐᳶ\u1cc8ᴅᲺ᳣ຮᴏᳮ\u0ea4ᴎ᱒᱕᳆Ჽᳯຮᴖ\u0ea4᳸ᰜຬᰦᴌᰝᲿᳲᴗ᳴ᴌຸᴃᴃ᳇ᳵᳬᴂລᰜຢᳵັᴖᰛᴄຫᳫລᴌᴘຢᴌຶᳲᳯ᱒᳣᱒ᴗ᳸᳇ᰛລ᳥ຫᲽᰧ᳴᳸Ჽ᳥᳸᳷᳹ᰝ᳇ຬᲺ᳤ຬ᳴ᰚᴄᳲᰚᳰ\u0ea4ᴃᳫ᳥᳟ᲺᲿ\u1cc9ືᴄᴃᳰ᳣ᴌᳰᴐᳬ᳟᳚ᰛ᳤ᳱ\u1cc8ᳯᴅᴋᲺᴋ\u0ea4ຶ᳟ᰚᴙ\u0ea4᳣ᴙᴐᴅᲺຫ᱒ຫᲽᴋᴗᰚᳫᳫ᳇ຫᰛ\u1cbcᳵ\u0ea4ᴄᳰᳱᳵᳰືᴘᰧຫᲺᰧᳯᰚຬຬ᳢ᰜᳫ\u1cc8᱔ᳶ\u1cc8ᴄᲽຮ᳚\u1cc9\u1cc9ᳮ᳆ຫᴐᴗᲺᳮ\u1cc9ຶ᳸᳹\u1cc8ᴐᴌᲿຮຮᳶ᱕ᴖຸᲽᲺ᳤ັຫ\u1cbc᱒\u1cbcᴋᴄᴗືᴅᰦᳫ᱒᳢\u1cbcᳶ᳹᱔ᳮ᳣ᴘᳵᰛᲺᳲᴄຮᴅ\u1cbcᰨᰜຶ᳟ᳶᰝᴗᴄຢᳫᴙᰦ᳢\u0ea4ᲿᴅຢᲽᳲຶຶᳲ᱒Ჿᴗᴄ᱕ᰧᴗ᳚ᳶᰧ᳟ᳲ᳇Ჽᰝᳬᴙᳶᴌ\u1cbb᳹᱔ᴙᳯᳮᳵ\u1cc9᱕ᳱ᳆ᰦ᳟ᴂຮᰨ᳆ຮ\u1cbcຬ᳸Ჺ\u1cc9᳇ັᴙᴃᴂ᳣᳸ᴖ᳷ᳫ᱔᳆ຸ᳸᱒ᳬᲺᰦ᱕ᰦ᳟᳟ᳱᴏᴙᴐᲺູᴅ᳥ຢຶຫູᴘᴖᳶ᳟ᳲᲿ᱒ຮᴄᲺຫັ᳹ᰛᰝᳱᴙ᳆᳚ᴂᳵᴄᰩᴖᴅᴗ᳆᳥ຮ᳸ລᴘᳯື᳇ືᰜᳬ\u0ea4\u1cbb\u1cc9᳴᳆ᳰᰨᴘᳮᳮᴋ᱔᳷ᳲ᳥\u0ea4ᰩᳯຮᴎ᳹᱔᳟᳸ᰚᴐ᳷ᰨ᳚ᴑ᳆ᴎᴗ\u1cbcᳱຢᳵ᱒᳢ᴌᴅ\u1cc9ᰦᴖᴂᳮᴙᴑᳯᴐᰩຸᰦᰝᳶᴘ᳟ᰜᲺຮᰨᰦᳯຬ᳢᱕᳥᳇ຬᴎᰧᰨັᴃ\u0ea4ᳫᴅᴖᴌລᳮᲺᳲᴅືຸລ᳇ᳵ᱔\u1cc8\u1cbbᴐᰨᳰ᳇᳹ᰦຶ᳷᱒ᰚັ᳤ᴄᰦᰛᳶᴖᳵ᱔᳆\u0ea4ᳮ᳢ᴗᳫ᳟\u1cbcᴖᰨ᳇Ჺᰚ᳥᳥ᴘᴄᴏ᳥᳢ຸᳯᴅຮᴅᲽᴏ᳢᳤\u1cc8ຸᴗᴙູ\u1cc8ᳮ᳷ᴅᳮᰚᳫᴏ\u1cc8ᳱ\u1cc9ັັ᱔᳇ᴄ᳢ຫᴘᴎᴗᳵᰚᰜᴅ\u1cc8ᰜᴙືᰧᳵᴄ\u1cc9ຮᳵ᳣ᴃᳶᴄູັᴖᳶຬ᳥᳆᳷᳢ᳵ᳷ᴙ᱕ᰧᴐັᲺ᳸\u1cc9᳇᳥ᴄ᳤ᳲᳵ᳢ື᱕ᳱᴐᲿັᴌᴑᳯᳱᰛືᰛ᱔\u1cbbᰛᳯ᱔Ჺ᳸Ჽᰚ᳴ᴎᰩᰚᳬ᱕ᰜᳮᰚᳫᳲືᴑຫᳱᳶຬ᳚᱕ᳰᳯ\u0ea4\u1cbcᳫᴂᰚ᳟ᰜᳮᳫ\u1cc9ືᴙ\u1cbc᳴ᳱຫ᳇ᴙຬᳯ᳥ᳫ᳆ᳵᰜຬᴗᴏᳰᳲ᳷ຶᰧᰛᰩᴐᴏᴙᲿᴗູຬ᳷᳥᳴ຶ\u1cbc᳥Ჽᳶᴗᴙᴗᴄືᴋᳰᰛຫᰨ᳹ັᳰᴖ᳢Ჿືຢ᳣᳟᳆ᴐ᳢ᰜູᲽᴂ\u1cc8ᴅᴙຸ\u1cbc᳹\u1cbcᳱᰩᳯᲿ᱕ᳵᳮᴙᰜᴑືᳶືຢ᳤᳴᳹ᳮᴎᴌᰨᲿ᳟ຶ᳣ຬລ᳢\u0ea4ᴗ᱔\u0ea4ᰝຸᴃ᳆᳴᱔᳹᳹ᰜᲿລ\u1cc9\u1cbcᴖ\u1cc8ຮᲽ\u1cbb᳇ᳯ᳥ᳮᴋᳫຮᰚັ᳇ᳰᴅᴑᲽᴄ᳣ᳮ\u1cbc᳟ຬᳲ᳚ᴅູᴃຮᰨ\u0ea4ຬ\u1cbcᳬᴄ᳷ຶຫᴅ\u1cc9ᴗᳲᴖ᳸ຮ᳇ᴅ᳚᳆ᳯັຮືᳱᰚᴏ\u0ea4ᴖᴑ᳟ᰜ᳥ᰦᴗຮᳮᰨູᰛᴏ᳆ᳶᴗᰜ᳆᳚ຶ᳸᳷ຶᳬᴌᴗᴅᳬᴏᰩຢᰜ᳟\u1cc8ᳲ\u0ea4ຶ\u1cc8\u0ea4ᰦᴗ᳆᳤᳟ຮᴎᴅᳵ᳚ᴂັ᳆᱕᳴ᴑ\u1cc8᳥ᴂຮᴃᴌ\u1cc9ᳱ᳷ᴐᴖᴗᰜᰨᳯ\u1cbcຫᳯຸ᱒᳆\u0ea4᳇\u1cc9ຬລᳰᴐᳰ᳢᳟᳹᳆ᴐᳱᳵ\u1cc8ᰦ᳣ຸ᳟ᴎᴂᰝᴃ᱔ᴂᴎᴑລᲽᳰᰦ᳴ຮᰨ\u1cbbᰦຢᲺ\u0ea4᳢ລᴘ᱒ᳰລຶ\u1cbb᳢ᳰ\u1cc9᳇ᰧືᴑᴑ᳆ᴖື᳹ᴙᰩູᲿᰝᳯᳲᴘ\u1cc9ຫᳱᰩᰨᰩ\u1cbbᴌ᳥᳹᳷ᴅ᳇ᴗᴋᴎᴘ᳆ູᳶᰝᴌᰛᳲᴎ᳹\u1cbbᳲ᳢\u1cbbᳶᳵ\u0ea4ᳬᳫ\u1cbc᱕᳟ᳰ᱔᳟᳷Ჿຶᴑᰚᳵᰚᳰᰨູ᳇᳤ᳱ᱔ᰚ᳤ᴎᰚ᳟ᰜᲿ᱔ᳲᰩຮ᱔ᴎᰜᳮᰦᳱ᱒᳤ᴗ᳥᳤ᳫᲺᰛ᳤ᴂ᳣ຶᴑ᳹᳹ᳱᴙ\u1cc9ᴑᴗᴂຫ᳤ᴄ᱔ᳬ᳢ᴙᰛᰩᴐຸຸືᴌᴋ᳹ᳶ᳟᱔ຮᲿ\u1cbc\u0ea4ᰛລᳬᳵᴃᳱລᳱᰝᴂᴖᴐᴖᳯᰚᴖᴅື᳢ᳫᴗᰝᴌᳮᰚᴄ᱒ᰧ\u1cc9᳤ᲽᲿᴗຮᰨᳮᳮຬ᳤ູ\u1cbbᳲ\u1cc8ᰚᴅᳮᰨᰨᰜᴗᴐ᳹ᳱᳲᰛᴅᳱຸ᱕ᴂᳰ\u1cc9ᴖ᳟᳷᳆ᳲᴎᴋ᳸ᳱ\u1cc8ᴘ\u0ea4ລᳱຮᰦ᳥᱒ᴅᰩᴃᰩລᰦᴏᰩູ᳹᳆ᴂຸ᳷᳸ᴄᴂ᳢ັ᳆ᰜᴃᴘຫᴗືᳱᳵᴗຮᳱᳰ\u1cc9ᴖᳲ\u0ea4᳹ᴌຫᴐᳬᴘລᴙᳬ᱒᱕᳥ັᳬຢຶᲿᳬ\u1cbbᳬ᱒ູ᳇ᴏᴗᴎ᳸Ჽ᱒\u1cc8\u1cc9᳥ᰛ\u0ea4ᳫຶᳲᳲᳰᲺ\u1cbbᴖ᱔ᴏ᱕᱔Ჿຮᳬ᱒ᳵືຢᴄᰩ᳹ᰛᴌຢᳮᴃ᳆ູᳶᳶ᱕᳸\u1cbcᴌᳯᲿᴘືᳰ᳤ຸᲿᳱັᰚᴂ᳷ຸᳶᰩ᳷᱒Ჿᰨᳵᴋ᳢\u1cc9ᰜ᳆᳤ຸ᳴ລ\u1cbc᳚ᳫᰝ᱒ᳱᳶᰨຮᳬືᴙᴄລᳮᴎᴙ᳚᳇\u1cbcᴋᴗັᴄᳮູຮᴋ᳴ᆀᆀ"
                .toCharArray();

            for (int b2 = 0; b2 < 8792; b2 += 1) {
                char c4 = achar4[b2];
                int i11 = c4 + 656;
                int j11 = i11 + 47939;
                int k11 = j11 + 39955;
                int l11 = k11 ^ 25956;
                int i12 = l11 + 21300;
                int j12 = i12 ^ 46373;
                int k12 = j12 - 51015;
                int l12 = k12 + 13048;
                int i13 = l12 + 37466;
                int j13 = i13 ^ 7100;
                int k13 = j13 ^ 15454;
                int l13 = k13 - 62911;
                achar4[b2] = (char)l13;
            }

            object = mth_0OOOoo00o0_31()[4] = new String(achar4);
        }

        aobject[2] = (String)object;
        char[] achar5 = ((String)o0Oo000O0oO(aobject)).toCharArray();
        int i14_hi = 5035;
        int limit9 = 0;

        while (limit9 < i14_hi) {
            int i30 = limit9;
            int k14_hi = limit9 + 1;
            char c5 = achar5[i30];
            i30 = k14_hi;
            int l14_hi = k14_hi + 1;
            char c6 = achar5[i30];
            int i15_hi = c5 << 16 | c6;
            char[] achar6 = new char[i15_hi];

            for (int limit10 = 0; limit10 < i15_hi; limit10 = limit10 + 1) {
                achar6[limit10] = achar5[l14_hi + limit10];
            }

            i30 = k1_hi;
            k1_hi++;
            o0Oo000O0oO[i30] = new String(achar6);
            limit9 = l14_hi + i15_hi;
        }

        aobject = new Object[]{fld_0OOOoo00o0_65, 5, null};
        object = mth_0OOOoo00o0_31()[5];
        if (object == null) {
            char[] achar7 = "\udd41\udd5c\udd3c\udd54\udd4e\udd40\udd5c\udd5b\udd83\udd86\udd2e\udd4e\udd61\udd61\udd59\udd9d\udd22\udd27\udd99\udd89\udd37\udd3c\udd57\udda1\udd3d\udd56\udd83\udd39\udd4f\udd45\udda0\udd5a\udd2e\udd45\udd5b\udd83\udd88\udd4f\udd61\udd9f\udd5c\udd45\udd8a\udd24\udd88\udd9b\udd9f\udd89\udd9a\udd9f\udd96\udd85\udda0\udd3c\udd2b\udd3a\udd9f\udd3f\udd3d\udd94\udd9c\udd9a\udd2b\udd2e\udd34\udd3d\udd8d\udd4f\udd99\udd3a\udd3a\udd4e\udd88\udd5d\udd3d\udda0\udd4e\udd3d\udd5c\udd4e\udd86\udd3c\udd3b\udd22\udd2f\udd88\udd4e\udd30\udd57\udd94\udd3d\udd85\udd56\udd84\udd84\udd2d\udd24\udd24\udd9d\udd3e\udda1\udd2b\udd9f\udd86\udd5d\udd9c\udd29\udd3e\udd9b\udd30\udd90\udd61\udd86\udd88\udd37\udd88\udd3f\udd54\udd94\udd8a\udd27\udd24\udd85\udd39\udd39\udd37\udd9d\udd3c\udd59\udd5a\udd23\udda1\udd97\udd24\udd84\udd30\udd28\udd5d\udd85\udd5c\udd3a\udd83\udd89\udd9b\udd3c\udd40\udd29\udd59\udd60\udd28\udd5d\udd36\udd85\udd26\udd8d\udd29\udd9e\udd59\udd9a\udd45\udd3a\udd4e\udda0\udd3a\udd34\udd3a\udd40\udd97\udda0\udd9a\udd39\udd9f\udd36\udd88\udd96\udd9f\udd3a\udd8b\udda1\udd3a\udda0\udd3a\udd57\udda1\udd59\udd9f\udd84\udd86\udd61\udd5b\udd2e\udd23\udd9d\udd94\udd3a\udd9f\udd89\udd9e\udd9a\udd8d\udd60\udd24\udd22\udd34\udd30\udd5d\udd41\udd3d\udd25\udd8a\udd5a\udd89\udd28\udd8d\udd61\udd27\udd30\udd4f\udd29\udd3d\udd61\udd40\udd54\udd9a\udd28\udd9c\udd84\udd54\udd8a\udd3f\udd30\udd60\udd90\udd28\udd57\udd82\udd3f\udd30\udd87\udd2a\udd37\udd3b\udd9b\udd5d\udda1\udd3b\udd34\udd9a\udd37\udd34\udd5a\udd5c\udd8d\udd96\udd27\udd3b\udd23\udd94\udd2d\udd2a\udd99\udd9e\udd60\udd3c\udda1\udd83\udd5a\udd85\udd83\udd87\udd5d\udd9c\udd5b\udd3d\udd8a\udd96\udd8a\udd3c\udd3b\udeef\udd9d\udd2e\udd5d\udd25\udd57\udd54\udd5b\udd9a\udd22\udd29\udd2d\udd9b\udd25\udd59\udd36\udd96\udd3e\udd61\udd8d\udd9a\udd3a\udd24\udd59\udd9d\udd9a\udd5a\udd94\udd96\udd96\udd90\udd87\udd97\udd60\udd5b\udd22\udd60\udd57\udd82\udd3f\udd23\udd30\udda0\udd9e\udd87\udd34\udd2b\udd29\udd57\udd29\udd89\udd8d\udd86\udd25\udd34\udd84\udd9a\udd99\udd3f\udd82\udd3c\udd30\udd2f\udd37\udd5a\udd4f\udd5a\udd85\udd30\udd5c\udd8b\udd27\udd3f\udd57\udd57\udd94\udd90\udd34\udd54\udd56\udd2a\udd34\udd8d\udd8a\udda0\udd23\udd41\udd96\udd5b\udd29\udda0\udd97\udda0\udd40\udd3d\udd45\udd4f\udd3b\udd9b\udd90\udd5c\udd2e\udd30\udd3e\udd97\udd29\udd30\udd37\udd34\udd60\udd40\udd40\udd3e\udda1\udd2b\udd5a\udd8b\udd99\udd57\udd23\udd94\udd41\udd3f\udd87\udda1\udd37\udd40\udd45\udd84\udd83\udd5d\udd96\udd5b\udd30\udd99\udd56\udd5c\udd41\udd84\udd83\udda0\udd97\udd57\udd84\udd9d\udd3e\udd34\udd9f\udd82\udd89\udd8a\udd2f\udd2d\udd30\udd5c\udd2f\udd9a\udd86\udd36\udd2f\udd8d\udd5d\udd36\udd2e\udd8a\udd37\udd26\udd5c\udd4e\udda1\udd89\udd2a\udd2d\udd4f\udd5c\udd9c\udd26\udd23\udd3d\udd8b\udd9f\udd60\udd82\udd3c\udd83\udd3d\udd34\udd84\udd97\udd5a\udd3e\udd56\udd25\udda0\udd2d\udda1\udd87\udd3d\udd39\udeef\udd56\udd36\udd2e\udd8a\udd8b\udd88\udd2a\udd39\udd85\udd2f\udd3f\udd8d\udd5d\udd3f\udd45\udd29\udd3c\udd57\udd3a\udd9d\udd5b\udd9d\udd54\udd83\udd59\udd40\udd34\udd3e\udd99\udd34\udd84\udd60\udda1\udd36\udd9c\udd8d\udd88\udd89\udeef\udd28\udd61\udd3a\udd25\udd3a\udd5b\udd8a\udd97\udd37\udd56\udd8b\udd9c\udd56\udd4e\udd41\udd2d\udd4e\udd87\udd28\udd54\udd96\udd54\udd37\udd3d\udd27\udd3b\udd8d\udd24\udd3c\udd3f\udd8b\udd3a\udd85\udd9d\udd83\udd4f\udd5d\udd8d\udd88\udd5d\udd4f\udd40\udd25\udd5c\udd2f\udd9a\udd2d\udd9b\udd37\udd54\udd30\udd57\udd2e\udd2a\udd94\udda0\udd99\udd99\udd59\udd3b\udd3f\udd3d\udd82\udd82\udd24\udd37\udd96\udd2d\udd60\udd3b\udd8d\udeef\udd90\udd8b\udda1\udd9d\udd9c\udd89\udd9b\udd5a\udd5a\udd8a\udd24\udd34\udd94\udd30\udd96\udd40\udd9d\udd40\udd23\udd29\udd88\udd27\udd83\udda0\udd4e\udd96\udd29\udd24\udd3b\udd61\udd26\udd5c\udd22\udd96\udd30\udd2d\udd57\udd9e\udd3e\udd84\udd45\udd57\udd59\udd2a\udd41\udd85\udd87\udd25\udd45\udd4e\udd5c\udd86\udda1\udd37\udd25\udd9f\udd59\udd24\udd3d\udd4f\udd88\udd9b\udd56\udd27\udd36\udd57\udd5a\udd3e\udd9a\udd3c\udd3f\udd5b\udd9e\udd97\udd84\udd28\udd9b\udd29\udd61\udd3c\udd5c\udd45\udd57\udd83\udd54\udd2e\udd9a\udd5c\udd90\udd2b\udeef\udd36\udd9a\udd8d\udd2b\udd3e\udd25\udd59\udda0\udd39\udd82\udd3d\udd2b\udd41\udd30\udd9e\udd87\udd23\udd28\udd4e\udd37\udd54\udd2a\udd39\udd87\udd22\udd3a\udd89\udd2a\udd88\udd29\udd34\udd56\udd8b\udd89\udd57\udd5d\udd82\udd28\udd36\udd97\udd40\udd94\udd3d\udd9a\udd84\udd94\udd60\udd8d\udd5d\udd39\udd36\udd84\udd3e\udd83\udd99\udd36\udd9e\udd96\udd9f\udd9f\udd59\udd45\udda0\udd9f\udd23\udd59\udd5c\udd3b\udd45\udd30\udd36\udd3a\udd36\udd25\udd9d\udd94\udd3d\udd8b\udd3b\udd9e\udd36\udd2b\udd96\udd2e\udd56\udd90\udd59\udd5d\udd9e\udd8b\udda0\udd22\udd57\udeef\udd9f\udeef\udd3e\udd87\udd9f\udd9f\udeef\udd8a\udd61\udd56\udd90\udd61\udd23\udd94\udda0\udd9a\udd40\udd8d\udd3a\udd9b\udd39\udd96\udd96\udd5a\udd26\udd27\udd60\udd97\udd97\udd40\udd5d\udd90\udd97\udd24\udd59\udd86\udd34\udd82\udd2d\udd96\udd84\udd24\udda1\udd23\udd3a\udd2f\udd9a\udd3b\udd2a\udd4e\udd36\udd3c\udd90\udd9e\udd59\udd60\udd3e\udd94\udd2e\udd2b\udd54\udd54\udd5c\udd9f\udd54\udd88\udd9f\udd23\udd60\udd39\udd3d\udd5b\udd36\udd3b\udd5b\udd87\udd4f\udd3d\udd87\udd9d\udd54\udd90\udd89\udd27\udd3f\udd3f\udd3c\udeef\udd85\udd8d\udd5c\udd3e\udd5d\udd2d\udeef\udd29\udd39\udd59\udd3a\udd4e\udd5b\udd89\udd27\udd2d\udd60\udd5c\udd26\udd85\udd9e\udd23\udd54\udd3c\udd88\udd3f\udd3e\udd2a\udd30\udd3f\udd4e\udd56\udd2d\udd24\udd25\udd8a\udda0\udd9a\udd86\udd8b\udd99\udd2a\udd8d\udd8b\udd9a\udd57\udd5a\udd90\udd37\udd94\udd89\udeef\udd28\udd87\udd82\udd61\udd56\udd3b\udd3b\udd41\udd83\udd36\udd9d\udd83\udd3c\udeef\udda1\udd84\udd5a\udeef\udd36\udd3d\udd4e\udd2a\udd23\udd36\udd94\udd86\udd37\udd99\udd88\udd85\udd26\udd23\udd57\udd3e\udd24\udd3e\udd22\udd34\udd39\udd25\udd28\udd87\udd9b\udd26\udd3f\udd37\udd39\udd85\udd8a\udd4e\udd3a\udd2d\udd84\udd30\udd99\udd89\udd59\udd9c\udd54\udd90\udd23\udd37\udd86\udd85\udd97\udd9f\udd28\udd83\udd84\udd4e\udd8b\udda1\udda1\udd87\udd3d\udd9a\udd84\udd26\udd9a\udd3f\udd8d\udda0\udd30\udd25\udd3d\udd8a\udd9c\udd9c\udd29\udd85\udd3f\udd9a\udd97\udd36\udd2b\udd61\udd36\udd99\udd26\udd2f\udd94\udd3f\udd59\udd45\udd29\udd57\udd89\udd3a\udd2e\udd37\udd36\udd89\udd97\udd61\udd26\udd9e\udd27\udd2e\udd2e\udd96\udd90\udd5d\udd39\udd23\udd9a\udd8d\udd8d\udd40\udd85\udd45\udd3f\udd99\udd5c\udd2e\udd25\udd54\udd25\udd61\udd2b\udd3e\udd26\udd5d\udd22\udd84\udd82\udd84\udd83\udd5c\udd90\udd2e\udd9a\udd34\udd3f\udd84\udd34\udd9f\udd25\udd9d\udd99\udd27\udd28\udd90\udd23\udd99\udd90\udd61\udd4e\udd9a\udd5a\udd59\udd4f\udd4f\udd24\udd29\udd4e\udd94\udd82\udd3f\udd96\udd5b\udd2a\udd84\udd28\udd9b\udd57\udd8a\udd28\udd2f\udd9c\udd37\udd8a\udd5d\udd56\udd86\udd87\udd36\udd2d\udd30\udd83\udd90\udd56\udd3b\udd57\udd8b\udd5a\udd3a\udd2f\udd9b\udd8d\udd37\udd8a\udd85\udd8a\udd4e\udd56\udd3b\udd9b\udd84\udd3e\udd94\udd60\udd3e\udd56\udd28\udd2b\udd8a\udd9f\udd61\udd26\udda0\udd3c\udd9a\udd2d\udd22\udd34\udd9f\udd2e\udd9a\udd5b\udd85\udd30\udd29\udd82\udd9d\udd54\udd3d\udd60\udd23\udd3e\udd5c\udeef\udd94\udd22\udd41\udd3e\udd41\udd34\udd90\udd8a\udda1\udd9c\udd26\udd86\udda1\udd57\udd86\udd86\udd45\udd2a\udd37\udd59\udd88\udd8a\udd23\udd25\udd5b\udd27\udd87\udd27\udd5d\udd2e\udd29\udd83\udd5d\udd82\udd3f\udd9a\udd90\udd3a\udd40\udd86\udd5d\udd3d\udd9e\udd4f\udd9d\udd23\udd54\udd8d\udd39\udd56\udd9c\udd88\udd8a\udd30\udd29\udd2f\udd9c\udd8b\udd29\udd4e\udd83\udeef\udd3d\udd28\udd9e\udd83\udd25\udd23\udd23\udd30\udd86\udd26\udd82\udd2e\udd99\udd60\udd99\udd5b\udd3a\udd5c\udd30\udd90\udd26\udd25\udd9f\udd2f\udd4e\udd22\udd30\udd3b\udd30\udd94\udd5b\udd39\udd82\udd39\udd4f\udd97\udd8b\udd9c\udd22\udd3b\udd23\udd45\udd96\udd2b\udd39\udd8a\udd86\udd5d\udd3d\udd88\udd94\udd56\udd3a\udd83\udd56\udd5a\udd57\udd88\udd29\udd9e\udd54\udd3c\udd3b\udd5d\udda1\udd54\udd3b\udd86\udd9e\udd9e\udd5b\udd29\udd30\udd22\udd9c\udd3b\udd45\udd9f\udd86\udd8b\udd89\udd3c\udd36\udd59\udd8b\udd5b\udd5b\udd22\udd24\udd83\udd24\udd9a\udd26\udd30\udd39\udd4f\udd22\udd2f\udd2f\udd30\udd41\udd2e\udd29\udd59\udd4e\udd9a\udd24\udd41\udd59\udd3f\udd99\udd5c\udd8a\udd5c\udd29\udd89\udd45\udd3a\udd83\udd5c\udd3a\udd3d\udd3a\udd85\udd61\udd9b\udd3e\udd9b\udd9e\udd5d\udd88\udd3d\udd9d\udd30\udd8d\udd2a\udd54\udd83\udd94\udd9a\udd61\udd3c\udd2e\udd88\udd2a\udd8b\udd29\udd85\udd86\udd3f\udd3a\udd8d\udd9c\udd88\udd56\udd56\udd29\udeef\udda1\udd28\udd26\udd3f\udd3a\udd83\udd26\udda0\udd3e\udd8b\udd37\udd9f\udd2b\udd82\udd2b\udd4e\udd37\udd86\udd29\udd26\udd3e\udd39\udd4f\udd2f\udd36\udd22\udd3a\udd39\udd9e\udd9a\udd3a\udd90\udd3f\udd4e\udd27\udd3d\udd9c\udd54\udd34\udd41\udd28\udd9a\udd2f\udeef\udd86\udd99\udd2d\udd29\udeef\udd25\udd97\udd57\udd8d\udd56\udda0\udd9b\udd9a\udd5a\udd2a\udd25\udd4e\udd3c\udd3a\udd57\udd9b\udd22\udd82\udd4e\udda1\udd2e\udd24\udd2d\udd4f\udd96\udd40\udd5d\udd45\udd25\udd37\udd24\udd3a\udd26\udd5b\udd9a\udd5c\udd57\udd34\udd54\udd85\udd4f\udd37\udd34\udeef\udd94\udd36\udd82\udd3d\udd40\udd9d\udd27\udd23\udd3e\udd5a\udd8d\udd2e\udd82\udd3c\udda0\udd8a\udd5a\udd41\udd8a\udd45\udd23\udd85\udd40\udd8b\udd94\udd61\udd2b\udd45\udd99\udd94\udd8d\udda0\udd61\udd54\udd60\udd28\udd28\udd45\udd2b\udd45\udd28\udd26\udd3f\udd87\udd94\udd28\udd54\udd22\udd4e\udd27\udd9d\udd2e\udd4f\udd94\udd8a\udd84\udeef\udd86\udd94\udd57\udd85\udd9b\udd37\udd9c\udd36\udda1\udeef\udd30\udd9b\udd61\udd2e\udd56\udd30\udd24\udd29\udd34\udd3d\udd89\udd5c\udd3f\udd3a\udd57\udd5a\udd2b\udd57\udd85\udd9b\udd61\udd3b\udd59\udd4f\udd99\udd8a\udd84\udd85\udd2a\udd56\udd34\udd57\udd41\udd8b\udd96\udd41\udd30\udd97\udd3b\udd9e\udd29\udd2f\udd9a\udd94\udd22\udda0\udd3b\udd27\udeef\udd3f\udd8b\udd39\udd9f\udd96\udd88\udd61\udd8d\udd61\udd85\udd60\udd2a\udd25\udd28\udd9c\udd83\udd22\udd99\udd2d\udd87\udda0\udd22\udd8d\udd2f\udd3e\udd34\udd99\udd87\udd85\udd25\udd9b\udd30\udd34\udd27\udd34\udd24\udd59\udd59\udd3d\udd87\udd29\udd5a\udd9e\udd34\udd3f\udd34\udd39\udd2f\udd4e\udd22\udd5c\udd4f\udd85\udd27\udd2a\udd29\udd34\udd3b\udd84\udd5c\udd27\udd9b\udd82\udeef\udd27\udd60\udd4e\udd2e\udd4f\udd5d\udd36\udd9c\udd8d\udd3c\udeef\udd3b\udd3e\udd23\udd26\udd57\udd83\udd29\udd3b\udd87\udd82\udd2a\udd84\udd56\udd83\udd3a\udd41\udd28\udd40\udd8d\udd9e\udd24\udd26\udd5d\udd84\udd9b\udd39\udd5d\udd57\udd9b\udd36\udd2d\udd27\udd9d\udd5d\udd85\udd24\udd3c\udd59\udd25\udd8b\udd36\udd2d\udd9b\udd39\udd89\udd24\udd96\udd3c\udda1\udd41\udd82\udd40\udd97\udd4e\udd26\udd2a\udd88\udd56\udeef\udd37\udd87\udd56\udd40\udd83\udd61\udda0\udd25\udd9b\udd5d\udd9b\udd28\udd4f\udd90\udd87\udd9f\udd37\udd8a\udd5d\udd41\udd2e\udd22\udd3c\udd94\udda0\udd22\udd3d\udd56\udd26\udd97\udd8a\udd89\udd56\udd2f\udd27\udd40\udd82\udd61\udd39\udd3d\udd84\udd3d\udd3e\udd88\udd60\udd3e\udd83\udd90\udd45\udd59\udd24\udd5c\udd60\udd5a\udd57\udd85\udd9b\udd82\udd2f\udd5d\udd54\udd8d\udd86\udd28\udd56\udd86\udd25\udd3e\udd2a\udd5b\udd27\udd57\udd2a\udd2d\udd90\udd94\udd56\udd29\udd24\udd5c\udd99\udd45\udd27\udd88\udd5c\udd9a\udd54\udd83\udd57\udd23\udd41\udd27\udd37\udd59\udd45\udda1\udd82\udd26\udd9a\udd4f\udd94\udd90\udd60\udda0\udd23\udd9c\udd60\udd86\udd41\udd9f\udd27\udd60\udd9a\udd54\udd89\udd22\udd9d\udd9a\udd83\udd8a\udd40\udd2f\udd8a\udd45\udd3a\udd9c\udd61\udd26\udd60\udd57\udeef\udd2a\udd24\udd5c\udeef\udd9e\udd2b\udd22\udd36\udd4f\udd45\udd37\udd84\udd3a\udd2d\udd99\udd94\udd28\udd57\udd94\udd37\udd2d\udd3d\udd94\udd5d\udd85\udd2f\udd25\udd8b\udd28\udd9e\udd27\udd90\udd86\udd23\udd9a\udd84\udd36\udd9e\udd96\udd9f\udd87\udd29\udd9c\udd2d\udd3f\udd3e\udd36\udd2b\udd5c\udd5d\udd4e\udd85\udd97\udd28\udd9f\udd90\udd45\udd39\udd45\udd9f\udd3f\udd83\udd2b\udd2b\udd94\udd59\udd8a\udd56\udd85\udd99\udd3f\udd86\udd86\udd40\udd85\udd40\udd3f\udd87\udd29\udd30\udd82\udd96\udd86\udd56\udda1\udd83\udd27\udeef\udd2b\udd4e\udd9b\udd3c\udd2f\udd26\udd4e\udeef\udd2e\udd85\udd61\udd9c\udd5a\udd3e\udd45\udd3e\udd88\udd41\udd9f\udd5d\udd3b\udd30\udd30\udd56\udd30\udd27\udd39\udd86\udd9e\udd3f\udd27\udd9a\udd61\udd82\udd22\udd8b\udd3f\udd5a\udd61\udd39\udd9f\udd82\udd61\udd8b\udd23\udd27\udda1\udd36\udd9d\udd9f\udd45\udd3a\udd5a\udd5d\udd9d\udd97\udd84\udd24\udeef\udd29\udd2d\udd45\udd3d\udd2e\udd37\udd24\udd36\udd8a\udd4f\udd3b\udd8b\udd97\udd4e\udd5b\udd30\udd8a\udd26\udd8b\udd5c\udd2a\udd41\udd9c\udd56\udd96\udd28\udd94\udd96\udd3c\udd29\udd24\udd9b\udd27\udd96\udd23\udd3f\udd82\udd2d\udd41\udd94\udd39\udd56\udd96\udd5a\udd3d\udd89\udd2d\udd5a\udd9c\udd3f\udda0\udd30\udd27\udd45\udd96\udd3d\udd96\udd3e\udd60\udd9f\udd34\udda1\udd27\udd45\udd30\udd40\udd34\udd57\udd87\udd86\udd30\udd40\udd9b\udd97\udd3c\udda0\udd88\udd3b\udda0\udd85\udd60\udd22\udd90\udda0\udeef\udd99\udd2f\udd2e\udd40\udd86\udd5c\udd99\udeef\udd30\udd3f\udd8b\udd3e\udd3d\udd9a\udd24\udd82\udd8b\udd9c\udd88\udd90\udd9f\udd89\udd30\udd9d\udda0\udd2f\udd5c\udd3d\udd2a\udd94\udd54\udd59\udd8b\udd3c\udd57\udd40\udd40\udd9a\udd56\udd27\udd9f\udd28\udd5b\udd9c\udd45\udd29\udd3a\udd45\udd2b\udd5d\udeef\udd9c\udd4f\udd34\udd3d\udd29\udd8d\udd3f\udd54\udd39\udd3a\udd2e\udd87\udd2e\udd41\udd61\udd2f\udeef\udd9f\udd87\udd27\udd3b\udd61\udd41\udd3a\udd36\udd88\udd25\udd5c\udd59\udd3a\udd9f\udd2a\udd28\udd60\udd3c\udd37\udd9b\udd24\udd59\udd9c\udd5b\udd36\udd99\udd40\udd99\udd9b\udd4f\udd8b\udd8a\udd36\udd57\udd3d\udd88\udd4e\udd29\udd3e\udd22\udd8a\udd4f\udd57\udd9a\udd2d\udd97\udd90\udd40\udd5b\udd85\udd45\udd9c\udd3d\udd23\udd39\udd23\udd83\udd57\udd40\udd54\udda1\udd30\udd2e\udd28\udd85\udd88\udd9e\udd3c\udd5a\udd29\udd5c\udd3b\udd9d\udd84\udd2a\udd8d\udd9b\udd9f\udd3a\udd90\udd39\udd30\udd34\udd9b\udd26\udd97\udd57\udd9a\udd28\udd9d\udd56\udd39\udd3c\udd99\udd25\udd24\udd56\udda0\udd8d\udd82\udd8d\udda0\udd57\udd57\udd87\udd9f\udd41\udd3e\udd26\udd84\udd4f\udd26\udd2d\udd37\udd85\udeef\udd3f\udd96\udd2f\udd39\udd24\udd3d\udd29\udd86\udd59\udd28\udd2a\udd23\udd25\udd23\udd99\udd59\udd36\udd59\udd30\udd2d\udd30\udd54\udd9e\udd40\udd9a\udeef\udd90\udd2f\udd45\udd59\udd96\udd29\udd5c\udd27\udeef\udd5a\udd23\udd24\udd30\udd5b\udd3c\udd40\udda0\udd41\udd5b\udd9f\udd36\udd89\udd3e\udd61\udda1\udda0\udd25\udd23\udd3b\udeef\udd8b\udd2a\udd27\udd9c\udd4f\udd9e\udd30\udd2d\udd29\udd8a\udd8a\udd2d\udd37\udd99\udd87\udd25\udd23\udd88\udd90\udd85\udd97\udd4e\udd9a\udd61\udd22\udd61\udd5c\udd23\udd9e\udd9a\udd40\udd2d\udd45\udd24\udd2f\udd4e\udd60\udd9c\udd9b\udd26\udd5a\udd9a\udd99\udd84\udd82\udd86\udd28\udd3c\udd88\udd4e\udd4e\udeef\udd22\udd3c\udd37\udd22\udd37\udd96\udd90\udd56\udd4f\udd97\udd88\udd54\udd85\udd60\udd2d\udd40\udd88\udd4f\udd89\udd9d\udd34\udd9a\udd9d\udd9b\udd5d\udd9e\udd84\udd40\udd39\udd3b\udd9f\udd30\udd28\udd5b\udd3b\udd56\udd8a\udd4e\udd2f\udd26\udd37\udd37\udd9e\udd99\udd85\udd88\udd85\udd2f\udd89\udd39\udd3f\udd3c\udd84\udd27\udd8a\udd3b\udd99\udd34\udd2e\udd23\udd99\udd5a\udd34\udd9a\udd3b\udd86\udd8b\udd22\udd2f\udd37\udd39\udd4f\udd3b\udd97\udda0\udd97\udd54\udd5a\udd4f\udd82\udd54\udd34\udd4f\udd9d\udd2a\udd3e\udd3a\udd59\udd39\udd34\udd89\udd8d\udd84\udd3e\udda0\udd2e\udd8b\udd5a\udd8a\udd89\udd94\udd3f\udd87\udd8a\udd23\udd5b\udd97\udd8b\udd28\udd9b\udeef\udd24\udd9f\udd30\udd85\udd3b\udd37\udd22\udd85\udd28\udd5b\udd3d\udd28\udd3c\udd86\udd2a\udd94\udeef\udd5d\udd9d\udd2d\udd28\udd5c\udd5a\udd9d\udd86\udd3d\udd4e\udd87\udd2e\udd34\udd83\udd94\udd24\udd3a\udd36\udd89\udeef\udda1\udd36\udd9a\udeef\udd2d\udd26\udd3e\udd61\udd41\udd2e\udd3f\udd82\udd59\udd96\udd5b\udda1\udd40\udd99\udd88\udd88\udd5a\udd41\udd2e\udd5d\udd5a\udd59\udd86\udd5a\udd5b\udd3d\udd4f\udd2d\udd36\udd25\udd2f\udd41\udd82\udda0\udd4e\udd2e\udd54\udd34\udd23\udd3b\udd2b\udd5c\udd41\udd9d\udd5a\udd3e\udd97\udd29\udd3d\udd40\udd4f\udd5d\udd9d\udd90\udd25\udda0\udd26\udd4f\udd9f\udd8d\udd9e\udd60\udd2e\udd34\udd45\udd61\udd2a\udd2e\udd96\udd8a\udda1\udd5c\udd4f\udd9f\udd29\udd3f\udd5c\udd56\udd61\udd9d\udd2a\udd97\udd3f\udd9a\udd86\udd3a\udd3c\udd96\udd8b\udd2e\udd28\udd86\udd25\udd5b\udd3b\udd60\udd41\udd2e\udd9b\udd9a\udd3a\udd83\udd8b\udd89\udd26\udd61\udd8a\udd5d\udd85\udd97\udd8b\udd37\udd90\udd60\udd3c\udd26\udd4e\udd2e\udd39\udd83\udd86\udd4f\udd29\udd5a\udd94\udd3b\udd94\udd29\udd59\udd90\udd3b\udd8d\udd9d\udd27\udd87\udd99\udd9f\udd30\udd84\udd59\udd25\udd25\udd27\udd41\udd89\udd2e\udd54\udd22\udd60\udd85\udd37\udd3d\udd85\udd3e\udd99\udd83\udd84\udd3d\udd27\udd3d\udd85\udd5c\udd30\udd25\udd5b\udd27\udd61\udd84\udd84\udd89\udd37\udd24\udd86\udd5b\udd45\udd41\udd9b\udd9e\udd96\udda0\udd59\udd85\udd36\udd60\udd3e\udd45\udd54\udd28\udd5c\udd3e\udd2b\udd24\udd3d\udd41\udd59\udd99\udd83\udd57\udd94\udd5a\udd2a\udd94\udd3b\udd3f\udd96\udd40\udd9e\udd89\udd5b\udd9d\udd54\udd2d\udd54\udd96\udd86\udd3c\udd59\udd61\udd40\udd24\udd3c\udd5d\udd36\udeef\udd9e\udd30\udd3b\udd4f\udda0\udd40\udd54\udd89\udd39\udd9f\udd3a\udd9a\udd94\udd5c\udd8d\udd94\udd88\udd30\udd2b\udd8d\udd3c\udd88\udd28\udd22\udd4e\udd3c\udd3b\udd4e\udda1\udd59\udd94\udd97\udd9b\udd99\udd3f\udd4e\udd3a\udd5b\udd82\udd9d\udd61\udd40\udd3a\udd39\udd2b\udd82\udd61\udd22\udd36\udd5a\udd5a\udd37\udd84\udd39\udd3d\udd85\udd9c\udd3c\udd40\udd3d\udd2e\udd40\udd39\udd2a\udd34\udd3e\udd89\udd39\udd5d\udd84\udd9a\udd23\udd2b\udda0\udd40\udd2e\udd56\udd9d\udd39\udd3d\udd4e\udd3a\udd8a\udd2e\udd4e\udd24\udd94\udd3b\udd2a\udd37\udd96\udd8a\udd82\udd82\udd29\udd3c\udd37\udd3b\udd56\udd8d\udd27\udd3e\udd25\udd9e\udd88\udd2e\udd88\udd29\udeef\udd5b\udd5b\udd8a\udd94\udd86\udd54\udd3b\udd88\udd34\udd94\udd57\udd99\udd26\udd5c\udd3e\udd84\udd29\udd96\udd26\udd36\udd9c\udd82\udd60\udd9e\udd45\udd9a\udd2e\udd2d\udd30\udd24\udd89\udd86\udd2e\udd34\udd24\udd39\udd59\udd3e\udd8a\udd37\udd22\udd25\udd2b\udd94\udd2e\udd23\udd45\udd9d\udd29\udd4e\udd4e\udd29\udd27\udd3b\udd3d\udd89\udd60\udd54\udd24\udd9c\udd60\udd25\udd2e\udd4e\udd25\udd9f\udd28\udd61\udd2d\udda0\udd41\udd3a\udd99\udd87\udd26\udd39\udd9e\udd24\udd9f\udd97\udd4e\udd40\udd9d\udd59\udd5c\udd45\udd22\udd8b\udd3d\udd5a\udd54\udd27\udd59\udd5c\udd39\udd2e\udd25\udd8b\udd89\udd5d\udd96\udd90\udd4e\udd85\udd3f\udd90\udd96\udd94\udd3a\udd3b\udd60\udd23\udd57\udd4f\udd25\udd5c\udd8a\udd61\udda0\udeef\udd61\udd3c\udd54\udd96\udd84\udd9d\udd99\udd9b\udd26\udd56\udd89\udd3c\udd9b\udd9e\udd27\udd37\udd9f\udd2b\udeef\udd57\udd4f\udd37\udd5d\udd61\udd60\udd9c\udd41\udd2b\udda1\udd28\udd2f\udd94\udd5d\udda0\udd5d\udd59\udd26\udd9b\udd9a\udd2e\udd85\udd5c\udd3c\udd99\udd2e\udd54\udd9a\udd87\udd2f\udd3e\udd24\udd94\udd8a\udd45\udd5c\udd34\udd2f\udd96\udd9b\udd2f\udd5b\udd59\udd8b\udd54\udd5a\udd23\udd61\udd27\udd5c\udda0\udd88\udd3d\udd45\udd26\udd85\udd87\udd37\udd34\udd45\udd97\udd83\udd22\udd2d\udd9e\udd59\udd9a\udd41\udd89\udd5a\udd2f\udd82\udd9c\udd5c\udd2e\udd9c\udd85\udd27\udd85\udd84\udd3d\udd23\udd59\udd99\udd26\udd2d\udd25\udd29\udd61\udd2f\udd8a\udd36\udd2b\udd28\udd94\udd2b\udd61\udd36\udd85\udd2d\udd3c\udd87\udeef\udd3c\udeef\udd2d\udd9a\udd84\udd36\udd27\udd97\udda0\udd22\udd57\udd5d\udd23\udd23\udd8d\udd24\udd4f\udd85\udd2d\udd87\udd8b\udd30\udd34\udd27\udd60\udd23\udd37\udd3f\udd2a\udd5a\udd54\udd86\udd5a\udd82\udd9e\udd37\udd23\udd59\udd27\udd9d\udd4e\udd34\udd3e\udd5a\udd27\udd59\udd60\udd54\udd9c\udd57\udd2a\udd8d\udd96\udd3f\udd27\udd2b\udd30\udd27\udd28\udd82\udda0\udd96\udd3f\udd8a\udd5d\udda0\udd41\udd30\udd41\udda0\udd30\udd85\udd23\udd3f\udd2f\udd29\udd83\udd9f\udd29\udd28\udd22\udd8a\udd2a\udd89\udd57\udd2b\udd40\udd97\udd29\udd26\udd5b\udd82\udd8d\udd8b\udd2f\udd9b\udd37\udd4f\udd3a\udd22\udd4f\udd9e\udd5c\udd61\udd2b\udd29\udd45\udd9a\udd60\udd59\udd5d\udd99\udd9e\udd3f\udd9c\udd56\udd34\udd5b\udd30\udd3e\udd2e\udd97\udd25\udd85\udd84\udd26\udd9e\udd9d\udd28\udd88\udd89\udd84\udd23\udda0\udd5b\udeef\udd8d\udd23\udd89\udd96\udd39\udd5b\udd61\udd2b\udd29\udd88\udd3b\udd36\udd30\udd22\udd86\udd61\udd56\udd8a\udd85\udd23\udd8b\udd5b\udd99\udd26\udd5b\udd88\udd45\udd99\udd60\udd88\udd9b\udd9f\udd94\udeef\udd3c\udd40\udd40\udd57\udd9e\udd39\udd8b\udd8a\udd9e\udd59\udd34\udd2b\udd29\udd4f\udd30\udd60\udda0\udd94\udd8d\udd2d\udd4f\udd3b\udd3f\udd25\udd9e\udd8b\udd61\udda0\udda0\udeef\udd54\udd5b\udd82\udd4e\udd24\udda1\udd2d\udd3e\udd56\udd2a\udda0\udd26\udd87\udd86\udd88\udd90\udd96\udd86\udd61\udda1\udd4f\udd24\udd39\udd86\udd9e\udd22\udd90\udd45\udd27\udd5d\udd94\udeef\udd41\udd34\udd2b\udd5d\udd8d\udd40\udd2d\udd9c\udd2b\udd34\udeef\udd60\udd84\udd61\udd37\udd28\udd4e\udd34\udd8b\udd3c\udd99\udd25\udd85\udd5a\udd3e\udd8d\udd60\udd97\udd2b\udd9e\udd59\udd82\udd41\udd8d\udda1\udd86\udd37\udd5b\udd36\udd5a\udd8d\udd5a\udd29\udd99\udd9a\udd36\udd9c\udd9e\udeef\udd99\udd86\udd2f\udd94\udd45\udd2b\udd9e\udd45\udd9a\udd27\udd9c\udd8a\udd9f\udd28\udd9d\udd28\udd54\udd2a\udda1\udd9b\udd40\udd9b\udd57\udd37\udd5a\udd9a\udd3a\udd24\udd83\udd90\udd88\udd83\udd3f\udd25\udd3f\udd88\udd2e\udd83\udd61\udd9a\udd5d\udd9c\udd2a\udd39\udd26\udd3f\udd59\udd9b\udd39\udd8a\udd8d\udd3c\udd5d\udd23\udd59\udd27\udd25\udd2e\udd88\udd9b\udd96\udd2f\udd57\udd85\udd56\udd23\udd86\udd3d\udd36\udd34\udd59\udd3b\udd87\udd5b\udd9e\udd54\udd39\udd23\udd5b\udd34\udd4f\udd30\udd60\udd3c\udd3b\udd87\udd61\udd57\udd90\udd9b\udd2f\udd5d\udd30\udd57\udeef\udd3f\udd2f\udd28\udd59\udd2e\udd34\udd84\udd57\udd8a\udd5a\udd54\udd54\udd53"
                .toCharArray();

            for (int b3 = 0; b3 < 3500; b3 += 1) {
                char c7 = achar7[b3];
                int j15 = c7 - 6726;
                int k15 = j15 + 39017;
                int l15 = k15 + 36043;
                int i16 = l15 ^ 2827;
                int j16 = i16 ^ 38573;
                int k16 = j16 ^ 26960;
                int l16 = k16 + 58256;
                int i17 = l16 ^ 51027;
                int j17 = i17 ^ 64151;
                int k17 = j17 + 64215;
                int l17 = k17 - 23930;
                int i18 = l17 - 14522;
                int j18 = i18 ^ 41499;
                achar7[b3] = (char)j18;
            }

            object = mth_0OOOoo00o0_31()[5] = new String(achar7);
        }

        aobject[2] = (String)object;
        char[] achar8 = ((String)o0Oo000O0oO(aobject)).toCharArray();
        int k18_hi = 2129;
        int limit11 = 0;

        while (limit11 < k18_hi) {
            int j30 = limit11;
            int i19_hi = limit11 + 1;
            char c8 = achar8[j30];
            j30 = i19_hi;
            int j19_hi = i19_hi + 1;
            char c9 = achar8[j30];
            int k19_hi = c8 << 16 | c9;
            char[] achar9 = new char[k19_hi];

            for (int limit12 = 0; limit12 < k19_hi; limit12 = limit12 + 1) {
                achar9[limit12] = achar8[j19_hi + limit12];
            }

            j30 = k1_hi;
            k1_hi++;
            o0Oo000O0oO[j30] = new String(achar9);
            limit11 = j19_hi + k19_hi;
        }

        avY = new Pattern[]{
            Pattern.compile("\\b(?:register|registration|signup|sign\\s*up|login|log\\s*in|signin|sign\\s*in|authenticate|authentication|authme|password|passwd)\\b", 66),
            Pattern.compile("/(?:register|reg|login|l|signup|signin|auth|captcha)\\b", 66),
            Pattern.compile("\\b(?:registrate|registrarse|registrar|registro|inicia\\s+sesion|iniciar\\s+sesion|inicie\\s+sesion|logueate|loguearse|ingresa|ingresar|contrasena|clave)\\b", 66),
            Pattern.compile("\\b(?:registre|inscris(?:-toi)?|inscription|connecte(?:z|r)?|connexion|mot\\s+de\\s+passe)\\b", 66),
            Pattern.compile("\\b(?:registrati|registrazione|accedi|accedere|accesso|password)\\b", 66),
            Pattern.compile("\\b(?:registre-se|registrar|registrado|logar|entrar|acessar|acesso|senha)\\b", 66),
            Pattern.compile("\\b(?:anmelden|anmeldung|einloggen|einlogg?en|passwort|registrieren)\\b", 66),
            Pattern.compile("\\b(?:registreer|registreren|aanmelden|inloggen|wachtwoord)\\b", 66),
            Pattern.compile("\\b(?:zarejestruj|rejestruj|rejestracja|zaloguj|logowanie|haslo)\\b", 66),
            Pattern.compile("\\b(?:registrace|registrovat|prihlas(?:it|eni)|heslo)\\b", 66),
            Pattern.compile("\\b(?:registrati-va|registrati|autentificare|autentifica-te|parola)\\b", 66),
            Pattern.compile("\\b(?:kayit\\s*ol|kaydol|giris\\s*yap|sifre|parola|dogrula)\\b", 66),
            Pattern.compile("\\b(?:dang\\s*ky|dang\\s*nhap|mat\\s*khau|xac\\s*thuc)\\b", 66),
            Pattern.compile("\\b(?:daftar|masuk|kata\\s*sandi|sandi|otentikasi)\\b", 66),
            Pattern.compile("\\b(?:rekisteroidy|rekisterointi|kirjaudu|salasana)\\b", 66),
            Pattern.compile("\\b(?:\u03b5\u03b3\u03b3\u03c1\u03b1\u03c6\u03b7|\u03c3\u03c5\u03bd\u03b4\u03b5\u03c3\u03b7|\u03ba\u03c9\u03b4\u03b9\u03ba\u03bf\u03c2|\u03ba\u03c9\u03b4\u03b9\u03ba\u03bf\u03c3|\u03c0\u03b9\u03c3\u03c4\u03bf\u03c0\u03bf\u03b9\u03b7\u03c3\u03b7)\\b", 66),
            Pattern.compile("\\b(?:\u0440\u0435\u0433\u0438\u0441\u0442(?:\u0440\u0430\u0446\u0438\u044f|\u0440\u0438\u0440\u0443\u0439\u0441\u044f|\u0440\u0438\u0440\u0443\u0439\u0442\u0435\u0441\u044c)|\u0437\u0430\u0440\u0435\u0433\u0438\u0441\u0442\u0440(?:\u0438\u0440\u0443\u0439\u0441\u044f|\u0438\u0440\u0443\u0439\u0442\u0435\u0441\u044c)|\u0432(?:\u043e\u0438|\u043e\u0439)\u0434\u0438(?:\u0442\u0435)?|\u0432\u0445\u043e\u0434|\u0430\u0432\u0442\u043e\u0440\u0438\u0437(?:\u0443\u0439\u0441\u044f|\u0443\u0439\u0442\u0435\u0441\u044c|\u0430\u0446\u0438\u044f)|\u043f\u0430\u0440\u043e\u043b\u044c)\\b", 66),
            Pattern.compile("\\b(?:\u0440\u0435\u0454\u0441\u0442\u0440(?:\u0430\u0446\u0456\u044f|\u0443\u0439\u0441\u044f|\u0443\u0439\u0442\u0435\u0441\u044f)|\u0437\u0430\u0440\u0435\u0454\u0441\u0442\u0440(?:\u0443\u0439\u0441\u044f|\u0443\u0439\u0442\u0435\u0441\u044f)|\u0443\u0432\u0456\u0439\u0434(?:\u0438|\u0456\u0442\u044c)|\u0432\u0445\u0456\u0434|\u0430\u0432\u0442\u043e\u0440\u0438\u0437(?:\u0443\u0439\u0441\u044f|\u0443\u0439\u0442\u0435\u0441\u044f|\u0430\u0446\u0456\u044f)|\u043f\u0430\u0440\u043e\u043b\u044c)\\b", 66),
            Pattern.compile("(?:\u6ce8\u518c|\u8a3b\u518a|\u767b\u5f55|\u767b\u5165|\u5bc6[\u7801\u78bc]|\u8ba4\u8bc1|\u9a57\u8b49)", 66),
            Pattern.compile("(?:\u767b\u9332|\u30ed\u30b0\u30a4\u30f3|\u30d1\u30b9\u30ef\u30fc\u30c9|\u8a8d\u8a3c)", 66),
            Pattern.compile("(?:\ud68c\uc6d0\uac00\uc785|\ub85c\uadf8\uc778|\ube44\ubc00\ubc88\ud638|\uc778\uc99d)", 66),
            Pattern.compile("(?:\u062a\u0633\u062c\u064a\u0644|\u062f\u062e\u0648\u0644|\u0643\u0644\u0645\u0629\\s*(?:\u0627\u0644\u0645\u0631\u0648\u0631|\u0627\u0644\u0633\u0631)|\u062a\u0623\u0643\u064a\u062f|\u062a\u062d\u0642\u0642)", 66),
            Pattern.compile("(?:\u0e25\u0e07\u0e17\u0e30\u0e40\u0e1a\u0e35\u0e22\u0e19|\u0e40\u0e02\u0e49\u0e32\u0e2a\u0e39\u0e48\u0e23\u0e30\u0e1a\u0e1a|\u0e23\u0e2b\u0e31\u0e2a\u0e1c\u0e48\u0e32\u0e19|\u0e22\u0e37\u0e19\u0e22\u0e31\u0e19\u0e15\u0e31\u0e27\u0e15\u0e19)", 66),
            Pattern.compile("(?:\u092a\u0902\u091c\u0940\u0915\u0930\u0923|\u0930\u091c\u093f\u0938\u094d\u091f\u0930|\u0932\u0949\u0917\u093f\u0928|\u092a\u093e\u0938\u0935\u0930\u094d\u0921|\u092a\u094d\u0930\u092e\u093e\u0923\u0940\u0915\u0930\u0923)", 66),
            Pattern.compile("\\b(?:captcha|verify|verification|verifying|verified|security\\s*check|auth\\s*code|pin\\s*code|access\\s*code|enter\\s+the\\s+code|type\\s+the\\s+code|enter\\s+the\\s+image\\s+code|image\\s+code|code\\s+from\\s+the\\s+image|code\\s+in\\s+chat|please\\s+wait|please\\s+verify|verify\\s+your\\s+client|verify\\s+your\\s+account|anti\\s*bot|human\\s*verification|robot\\s*check|complete\\s+the\\s+captcha)\\b", 66),
            Pattern.compile("\\b(?:verificando\\s+tu\\s+cliente|verifica(?:ndo|cion)?\\s+tu\\s+cliente|por\\s+favor\\s+espera|espera(?:\\s+un\\s+momento)?|introduce\\s+el\\s+codigo\\s+de\\s+la\\s+imagen|introduzca\\s+el\\s+codigo\\s+de\\s+la\\s+imagen|codigo\\s+de\\s+la\\s+imagen|codigo\\s+en\\s+el\\s+chat|verificacion\\s+humana|completa\\s+el\\s+captcha|cliente\\s+verificado)\\b", 66),
            Pattern.compile("\\b(?:verificando\\s+seu\\s+cliente|verifique\\s+seu\\s+cliente|por\\s+favor\\s+aguarde|aguarde(?:\\s+um\\s+momento)?|digite\\s+o\\s+codigo\\s+da\\s+imagem|codigo\\s+da\\s+imagem|codigo\\s+no\\s+chat|verificacao\\s+humana|complete\\s+o\\s+captcha)\\b", 66),
            Pattern.compile("\\b(?:verification\\s+de\\s+votre\\s+client|veuillez\\s+patienter|entrez\\s+le\\s+code\\s+de\\s+l'?image|code\\s+de\\s+l'?image|code\\s+dans\\s+le\\s+chat|verification\\s+humaine|completez\\s+le\\s+captcha)\\b", 66),
            Pattern.compile("\\b(?:verifiziere\\s+deinen\\s+client|bitte\\s+warten|gib\\s+den\\s+code\\s+aus\\s+dem\\s+bild\\s+ein|bildcode|code\\s+im\\s+chat|menschliche\\s+verifizierung|captcha\\s+abschliessen)\\b", 66),
            Pattern.compile("\\b(?:verifica(?:zione)?\\s+del\\s+client|attendi(?:\\s+un\\s+momento)?|inserisci\\s+il\\s+codice\\s+dell'?immagine|codice\\s+dell'?immagine|codice\\s+nella\\s+chat|verifica\\s+umana|completa\\s+il\\s+captcha)\\b", 66),
            Pattern.compile("\\b(?:weryfikacj(?:a|e)\\s+klienta|prosze\\s+czekac|wpisz\\s+kod\\s+z\\s+obrazka|kod\\s+z\\s+obrazka|kod\\s+na\\s+czacie|weryfikacja\\s+czlowieka|uzupelnij\\s+captcha)\\b", 66),
            Pattern.compile("\\b(?:\u043f\u0440\u043e\u0432\u0435\u0440(?:\u043a\u0430|\u044f\u0435\u043c)\\s+\u043a\u043b\u0438\u0435\u043d\u0442|\u043f\u043e\u0436\u0430\u043b\u0443\u0439\u0441\u0442\u0430\\s+\u043f\u043e\u0434\u043e\u0436\u0434\u0438\u0442\u0435|\u0432\u0432\u0435\u0434\u0438\u0442\u0435\\s+\u043a\u043e\u0434\\s+\u0441\\s+\u0438\u0437\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u044f|\u043a\u043e\u0434\\s+\u0441\\s+\u043a\u0430\u0440\u0442\u0438\u043d\u043a\u0438|\u043a\u043e\u0434\\s+\u0432\\s+\u0447\u0430\u0442|\u0447\u0435\u043b\u043e\u0432\u0435\u0447\u0435\u0441\u043a\u0430\u044f\\s+\u043f\u0440\u043e\u0432\u0435\u0440\u043a\u0430|\u043a\u0430\u043f\u0447\u0430)\\b", 66),
            Pattern.compile("\\b(?:\u043f\u0435\u0440\u0435\u0432\u0456\u0440(?:\u043a\u0430|\u044f\u0454\u043c\u043e)\\s+\u043a\u043b\u0456\u0454\u043d\u0442|\u0431\u0443\u0434\u044c\\s+\u043b\u0430\u0441\u043a\u0430\\s+\u0437\u0430\u0447\u0435\u043a\u0430\u0439\u0442\u0435|\u0432\u0432\u0435\u0434\u0456\u0442\u044c\\s+\u043a\u043e\u0434\\s+\u0437\\s+\u0437\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u043d\u044f|\u043a\u043e\u0434\\s+\u0456\u0437\\s+\u0437\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u043d\u044f|\u043a\u043e\u0434\\s+\u0432\\s+\u0447\u0430\u0442|\u043f\u0435\u0440\u0435\u0432\u0456\u0440\u043a\u0430\\s+\u043b\u044e\u0434\u0438\u043d\u0438|\u043a\u0430\u043f\u0447\u0430)\\b", 66),
            Pattern.compile("(?:\u9a57\u8b49\u4f60\u7684\u5ba2\u6236\u7aef|\u9a8c\u8bc1\u4f60\u7684\u5ba2\u6237\u7aef|\u6b63\u5728\u9a8c\u8bc1\u4f60\u7684\u5ba2\u6237\u7aef|\u8acb\u7a0d\u5019|\u8bf7\u7a0d\u5019|\u8acb\u8f38\u5165\u5716\u50cf\u4e2d\u7684\u4ee3\u78bc|\u8bf7\u8f93\u5165\u56fe\u50cf\u4e2d\u7684\u4ee3\u7801|\u5716\u7247\u4ee3\u78bc|\u56fe\u50cf\u4ee3\u7801|\u804a\u5929\u4e2d\u7684\u4ee3\u78bc|\u804a\u5929\u4e2d\u7684\u4ee3\u7801|\u4eba\u5de5\u9a57\u8b49|\u4eba\u5de5\u9a8c\u8bc1|\u5b8c\u6210\u9a57\u8b49\u78bc|\u5b8c\u6210\u9a8c\u8bc1\u7801|captcha)", 66),
            Pattern.compile("(?:\u30af\u30e9\u30a4\u30a2\u30f3\u30c8\u3092\u78ba\u8a8d|\u78ba\u8a8d\u4e2d|\u3057\u3070\u3089\u304f\u304a\u5f85\u3061\u304f\u3060\u3055\u3044|\u753b\u50cf\u306e\u30b3\u30fc\u30c9\u3092\u5165\u529b|\u753b\u50cf\u30b3\u30fc\u30c9|\u30c1\u30e3\u30c3\u30c8\u306b\u30b3\u30fc\u30c9\u3092\u5165\u529b|\u4eba\u9593\u78ba\u8a8d|\u30ad\u30e3\u30d7\u30c1\u30e3|captcha)", 66),
            Pattern.compile("(?:\ud074\ub77c\uc774\uc5b8\ud2b8\ub97c\\s*\ud655\uc778|\ud655\uc778\\s*\uc911|\uc7a0\uc2dc\ub9cc\\s*\uae30\ub2e4\ub824|\uc774\ubbf8\uc9c0\\s*\ucf54\ub4dc\ub97c\\s*\uc785\ub825|\uc774\ubbf8\uc9c0\\s*\ucf54\ub4dc|\ucc44\ud305\uc5d0\\s*\ucf54\ub4dc\\s*\uc785\ub825|\uc0ac\ub78c\\s*\ud655\uc778|\ucea1\ucc28|captcha)", 66),
            Pattern.compile("(?:\u0627\u0644\u062a\u062d\u0642\u0642\\s*\u0645\u0646\\s*\u0627\u0644\u0639\u0645\u064a\u0644|\u062c\u0627\u0631(?:\u064d|\u064a)\\s*\u0627\u0644\u062a\u062d\u0642\u0642|\u064a\u0631\u062c\u0649\\s*\u0627\u0644\u0627\u0646\u062a\u0638\u0627\u0631|\u0627\u062f\u062e\u0644\\s*\u0631\u0645\u0632\\s*\u0627\u0644\u0635\u0648\u0631\u0629|\u0631\u0645\u0632\\s*\u0627\u0644\u0635\u0648\u0631\u0629|\u0627\u062f\u062e\u0644\\s*\u0627\u0644\u0631\u0645\u0632\\s*\u0641\u064a\\s*\u0627\u0644\u062f\u0631\u062f\u0634\u0629|\u062a\u062d\u0642\u0642\\s*\u0628\u0634\u0631\u064a|\u0643\u0627\u0628\u062a\u0634\u0627|captcha)", 66),
            Pattern.compile("(?:\u0e01\u0e23\u0e38\u0e13\u0e32\u0e23\u0e2d|\u0e01\u0e33\u0e25\u0e31\u0e07\u0e15\u0e23\u0e27\u0e08\u0e2a\u0e2d\u0e1a\u0e44\u0e04\u0e25\u0e40\u0e2d\u0e19\u0e15\u0e4c|\u0e43\u0e2a\u0e48\u0e23\u0e2b\u0e31\u0e2a\u0e08\u0e32\u0e01\u0e23\u0e39\u0e1b\u0e20\u0e32\u0e1e|\u0e23\u0e2b\u0e31\u0e2a\u0e23\u0e39\u0e1b\u0e20\u0e32\u0e1e|\u0e43\u0e2a\u0e48\u0e23\u0e2b\u0e31\u0e2a\u0e43\u0e19\u0e41\u0e0a\u0e17|\u0e22\u0e37\u0e19\u0e22\u0e31\u0e19\u0e27\u0e48\u0e32\u0e40\u0e1b\u0e47\u0e19\u0e21\u0e19\u0e38\u0e29\u0e22\u0e4c|\u0e41\u0e04\u0e1b\u0e0a\u0e32|captcha)", 66),
            Pattern.compile("(?:\u0915\u0943\u092a\u092f\u093e\\s*\u092a\u094d\u0930\u0924\u0940\u0915\u094d\u0937\u093e\\s*\u0915\u0930\u0947\u0902|\u0915\u094d\u0932\u093e\u0907\u0902\u091f\\s*\u0938\u0924\u094d\u092f\u093e\u092a\u093f\u0924|\u091b\u0935\u093f\\s*\u0915\u094b\u0921\\s*\u0926\u0930\u094d\u091c\\s*\u0915\u0930\u0947\u0902|\u091a\u093f\u0924\u094d\u0930\\s*\u0915\u094b\u0921|\u091a\u0948\u091f\\s*\u092e\u0947\u0902\\s*\u0915\u094b\u0921|\u092e\u093e\u0928\u0935\\s*\u0938\u0924\u094d\u092f\u093e\u092a\u0928|\u0915\u0948\u092a\u094d\u091a\u093e|captcha)", 66)
        };
        avZ = new Pattern[]{
            Pattern.compile("\\b(?:survival|smp|minehut)\\b", 66),
            Pattern.compile("\\b(?:ranked|unranked)\\b", 66),
            Pattern.compile("\\b(?:clasificado|clasificada|sin\\s+clasificar|classe|classee|non\\s+classe|classificata|classificato|non\\s+classificato|ranqueada|ranqueado|sem\\s+rank|besorolt|nem\\s+besorolt)\\b", 66),
            Pattern.compile("\\b(?:duel|duels)\\b", 66),
            Pattern.compile("\\b(?:bedwars|skywars|skyblock|factions|prison|lifesteal|practice|kitpvp|eggwars|oneblock|survival\\s+games|hungergames|hunger\\s+games|anarchy|towny|creative)\\b", 66),
            Pattern.compile("\\bbuild\\s*uhc\\b", 66),
            Pattern.compile("\\bclasico\\b|\\bclassico\\b|\\bclassic\\b", 66),
            Pattern.compile("\\barena\\s*pvp\\b", 66),
            Pattern.compile("\\barenapvp\\b", 66),
            Pattern.compile("\\belo\\b", 66),
            Pattern.compile("\\belo\\s+global\\b|\\branking\\s*\\(?elo\\)?\\b|\\btemporada\\s+ranked\\b", 66),
            Pattern.compile("\\b(?:coins?|tokens?|credits?|eco(?:nomy)?|dollars?)\\b", 66),
            Pattern.compile("\\b(?:creditos?|cr[e\u00e9]ditos?|economia|econom[i\u00ed]a)\\b", 66),
            Pattern.compile("\\b(?:creditos?|cr[e\u00e9]ditos?|economia|grana)\\b", 66),
            Pattern.compile("\\b(?:credits?|cr[e\u00e9]dits|economie|[\u00e9e]conomie)\\b", 66),
            Pattern.compile("\\b(?:muenzen|m\u00fcnzen|wirtschaft)\\b", 66),
            Pattern.compile("\\bwins?\\b", 66),
            Pattern.compile("\\b(?:victorias|victoria|vitorias|vitoria|victoires|victoire|siege|sieg|wygrane|wygrana|wygra|gyozelmek|gyozelem|castiguri|castig|vittorie|vittoria|thang|\u80dc\u5229|\u52dd\u5229|\uc2b9\ub9ac|\u52dd|\u043f\u043e\u0431\u0435\u0434)\\b", 66),
            Pattern.compile("\\bloss(?:es)?\\b", 66),
            Pattern.compile("\\b(?:derrotas|derrota|defeats?|defaites|defaite|perdidas|perdida|porazky|sconfitte|sconfitta|veszteseg|vesztesegek|infrangeri|thua|\u043f\u043e\u0440\u0430\u0436\u0435\u043d\u0438|\u8d25\u5317|\u6557\u5317|\ud328\ubc30|niederlage|niederlagen)\\b", 66),
            Pattern.compile("\\bwinstreak\\b|\\bwin\\s*streak\\b|\\bws\\b", 66),
            Pattern.compile("\\b(?:racha|racha\\s+de\\s+victorias|serie\\s+de\\s+vitorias|serie\\s+de\\s+vitto?rie|serie\\s+de\\s+victoires|sorozat|\u043f\u043e\u0431\u0435\u0434\u043d|\u80dc\u573a|\u9023\u52dd|\uc5f0\uc2b9)\\b", 66),
            Pattern.compile("\\bkit\\b|\\bmap\\b|\\bmapa\\b|\\bmappa\\b|\\bcarte\\b|\\bgegner\\b|\\badversaire\\b|\\bavversario\\b|\\bopponent\\b|\\boponente\\b|\\brivals?\\b|\\brounds?\\b|\\brondas?\\b|\\bmanches?\\b|\\bgoals?\\b|\\bgoles?\\b|\\bbuts?\\b|\\bconectados\\b|\\bconnected\\b|\\bplayers?\\b|\\bspieler\\b|\\bverbunden\\b|\\bwarteschlange\\b", 66),
            Pattern.compile("\\btiempo\\s+vivo\\b|\\basesinatos\\s+finales\\b|\\basesinatos\\b|\\bflechas\\b|\\bgolpes\\b|\\binformacion\\b|\\btemporada\\b|\\bglobal\\b|\\branking\\b|\\brangliste\\b|\\bsaison\\b", 66),
            Pattern.compile("\\b(?:cola|queue|buscando\\s+oponente|matchmaking|oponente|adversario|adversaire|gegner|avversario|encontrado|encontrei|trouve|gefunden|talalt|talalva|contra|versus|vs\\b|warteschlange|gegner\\s+gefunden|\u5f00\u59cb|\u958b\u59cb|\uc2dc\uc791|\u5bfe\u6226\u76f8\u624b|\uc0c1\ub300)\\b", 66),
            Pattern.compile("\\b(?:claim|claims|land|lands|chunk|chunks|home|homes|sethome|warp|warps|shop|shops|auction|auctions|auctionhouse|ah\\b|tpa|tpahere|teleport|teleport\\s+request|spawner|spawners|crate|crates)\\b", 66),
            Pattern.compile("\\b(?:reclamo|reclamos|terreno|terrenos|hogar|hogares|casa|casas|tienda|tiendas|subasta|subastas|teletransporte|proteccion|protecci\u00f3n|warp|warps|tpa|tpahere)\\b", 66),
            Pattern.compile("\\b(?:terreno|terrenos|casa|casas|loja|lojas|leilao|leil\u00e3o|teleporte|warp|warps|tpa|tpahere)\\b", 66),
            Pattern.compile("\\b(?:terrain|terrains|maison|maisons|boutique|boutiques|enchere|ench\u00e8re|encheres|ench\u00e8res|teleportation|warp|warps|tpa|tpahere)\\b", 66),
            Pattern.compile("\\b(?:grundstuck|grundst\u00fcck|home|homes|shop|shops|auktion|auktionen|teleport|warp|warps|tpa|tpahere)\\b", 66),
            Pattern.compile("\\b(?:\uc5f0\uacb0\ub428|\uc811\uc18d\uc911|\ud50c\ub808\uc774\uc5b4|\uc2b9\ub9ac|\ud328\ubc30|\ub7ad\ud06c|\ub7ad\ud0b9|\uc5d8\ub85c|\uc0c1\ub300|\uc2dc\uc98c|\ub300\uae30\uc5f4|\ub4c0\uc5bc|\uc2a4\uce74\uc774\uc6cc\uc988|\ubca0\ub4dc\uc6cc\uc988)\\b", 66),
            Pattern.compile("\\b(?:\u73a9\u5bb6|\u5728\u7ebf|\u9023\u7dda|\u8fde\u63a5|\u52dd\u5229|\u5931\u8d25|\u6557\u5317|\u6392\u540d|\u8d5b\u5b63|\u8cfd\u5b63|\u5c0d\u624b|\u5bf9\u624b|\u6c7a\u9b25|\u51b3\u6597|\u7a7a\u5c9b\u6218\u4e89|\u8d77\u5e8a\u6218\u4e89)\\b", 66),
            Pattern.compile("\\b(?:\u30d7\u30ec\u30a4\u30e4\u30fc|\u52dd\u5229|\u6557\u5317|\u30e9\u30f3\u30ad\u30f3\u30b0|\u30ec\u30fc\u30c8|\u5bfe\u6226\u76f8\u624b|\u30b7\u30fc\u30ba\u30f3|\u30c7\u30e5\u30a8\u30eb|\u30b9\u30ab\u30a4\u30a6\u30a9\u30fc\u30ba|\u30d9\u30c3\u30c9\u30a6\u30a9\u30fc\u30ba)\\b", 66),
            Pattern.compile("\\b(?:\u0433\u0440\u0430\u0432\u0435\u0446\u044c|\u043f\u0435\u0440\u0435\u043c\u043e\u0433\u0430|\u043f\u043e\u0440\u0430\u0437\u043a\u0430|\u0440\u0435\u0439\u0442\u0438\u043d\u0433|\u0441\u0435\u0437\u043e\u043d|\u0441\u0443\u043f\u0435\u0440\u043d\u0438\u043a|\u0447\u0435\u0440\u0433\u0430|\u0434\u0443\u0435\u043b\u044c|\u0441\u043a\u0430\u0439\u0432\u0430\u0440\u0441|\u0431\u0435\u0434\u0432\u0430\u0440\u0441)\\b", 66),
            Pattern.compile("\\b(?:\u03c0\u03b1\u03af\u03ba\u03c4\u03b7\u03c2|\u03bd\u03af\u03ba\u03b7|\u03ae\u03c4\u03c4\u03b1|\u03ba\u03b1\u03c4\u03ac\u03c4\u03b1\u03be\u03b7|\u03c3\u03b5\u03b6\u03cc\u03bd|\u03b1\u03bd\u03c4\u03af\u03c0\u03b1\u03bb\u03bf\u03c2|\u03bf\u03c5\u03c1\u03ac|\u03bc\u03bf\u03bd\u03bf\u03bc\u03b1\u03c7\u03af\u03b1)\\b", 66),
            Pattern.compile("\\b(?:\u0644\u0627\u0639\u0628|\u0641\u0648\u0632|\u062e\u0633\u0627\u0631\u0629|\u062a\u0631\u062a\u064a\u0628|\u0645\u0648\u0633\u0645|\u062e\u0635\u0645|\u0637\u0627\u0628\u0648\u0631|\u0645\u0628\u0627\u0631\u0632\u0629|\u0633\u0643\u0627\u064a\\s*\u0648\u0627\u0631\u0632|\u0628\u062f\\s*\u0648\u0627\u0631\u0632)\\b", 66),
            Pattern.compile("\\b(?:\u0916\u093f\u0932\u093e\u0921\u093c\u0940|\u091c\u0940\u0924|\u0939\u093e\u0930|\u0930\u0948\u0902\u0915|\u0930\u0948\u0902\u0915\u093f\u0902\u0917|\u0938\u0940\u091c\u0928|\u092e\u094c\u0938\u092e|\u092a\u094d\u0930\u0924\u093f\u0926\u094d\u0935\u0902\u0926\u0940|\u0935\u093f\u092a\u0915\u094d\u0937\u0940|\u0915\u0924\u093e\u0930|\u0921\u094d\u092f\u0942\u0932|\u092c\u0947\u0921\u0935\u093e\u0930\u094d\u0938|\u0938\u094d\u0915\u093e\u0908\u0935\u093e\u0930\u094d\u0938)\\b", 66),
            Pattern.compile("\\b(?:\u0e1c\u0e39\u0e49\u0e40\u0e25\u0e48\u0e19|\u0e0a\u0e19\u0e30|\u0e41\u0e1e\u0e49|\u0e2d\u0e31\u0e19\u0e14\u0e31\u0e1a|\u0e24\u0e14\u0e39\u0e01\u0e32\u0e25|\u0e04\u0e39\u0e48\u0e15\u0e48\u0e2d\u0e2a\u0e39\u0e49|\u0e04\u0e34\u0e27|\u0e14\u0e27\u0e25|\u0e2a\u0e01\u0e32\u0e22\u0e27\u0e2d\u0e23\u0e4c|\u0e40\u0e1a\u0e14\u0e27\u0e2d\u0e23\u0e4c)\\b", 66),
            Pattern.compile("\\b(?:classic|clasico|classico|nodebuff|no\\s*debuff|boxing|sumo|bridge|uhc|build\\s*uhc|skywars|bedwars|skyblock|factions|prison|lifesteal|practice|kitpvp|eggwars|oneblock|op|combo|blitz|megawalls|bow|parkour|tnt|gapple|arcade|arcade\\s*games?|warlords?|turbo\\s*kart\\s*racers?|tkr|blitzsg|blitz\\s*sg|blitz\\s*survival|survival\\s*games?|cops\\s*(?:and|&)\\s*criminals?|cnc|battleground|battlegrounds?|vampirez|the\\s*walls|mega\\s*walls|walls|mcgo|murder|murderer?|murder\\s*mystery|smash\\s*heroes?|paintball|quake|the\\s*tnt\\s*games?|tnt\\s*games?|rumble|pvp\\s*run|speed\\s*uhc|wool\\s*wars|party\\s*games|hole\\s*ladder|farm\\s*hunt|build\\s*battle|pixel\\s*paintball|boulevard|pit|pit\\s*xp?|housing|hybrid|ranked|unranked|mega|ult|ultimate|hive|cubecraft|mineville)\\b", 66),
            Pattern.compile("\\b(?:clasificado|clasificada|sin\\s*clasificar|ranqueada|ranqueado|rango| clasificacion|ranked)\\b", 66),
            Pattern.compile("\\b(?:juegos\\s*de\\s*arcade|arcade|warlords?|guerra\\s*de\\s*clanes?|batalla|criminoso|criminales|policias|policias\\s*y\\s*criminales|bsr|copia|en\\s*caja|box\\s*in|box|in\\s*the\\s*box|uno\\s*en\\s*caja|cops?|survival|supervivencia|juegos\\s*de\\s*supervivencia|bedwars|skywars|skyblock|facciones|prision|robo\\s*de\\s*vida|eggwars|isla\\s*unica|partida\\s*rapida|anarquia|pvp\\s*clasico|misterio\\s*de\\s*asesinato|asesinato|herores\\s*de\\s*golpe|paintball|quake|tnt|carreras\\s*de\\s*kart|wool\\s*wars|juegos\\s*de\\s*fiesta|escalera\\s*del\\s*agujero|caza\\s*de\\s*granjas|batalla\\s*de\\s*construccion|bola\\s*de\\s*pintura|pit|vivienda|h\u00edbrido|escarbar|lucha\\s*de\\s*cerdos|tag\\s*l\u00e1ser|esponja|soccer|futbol|scrimmage|duelo|duelos|lobby|vida\\s*robada|equipo\\s*rojo|equipo\\s*azul|jugador|partida|torneo)\\b", 66),
            Pattern.compile("\\b(?:class\u00e9|d\u00e9class\u00e9|non\\s*class\u00e9|ranked|non\\s*rank\u00e9)\\b", 66),
            Pattern.compile("\\b(?:arcade|jeux\\s*d'arcade|war lords?|guerre|flics?|criminels?|flics\\s*et\\s*criminels?|survie|survival|jeux\\s*de\\s*survie|bedwars|skywars|skyblock|factions|prison|vol\\s*de\\s*vie|eggwars|une\\s*seule\\s*ile|anarchie|practice|classique|myst\u00e8re\\s*d'|meurtre|meurtrier|h\u00e9ros?|paintball|quake|tnt|wool\\s*wars|jeux\\s*de\\s*f\u00eate|\u00e9chelle|chasse\\s*\u00e0\\s*la\\s*ferme|bataille\\s*de\\s*construction|peinture|trou|housing|carr\u00e9|h\u00edbrido|h\u00e9t\u00e9ro|hybrid|cochons?|laser\\s*tag|soccer|football|rugby|bot\\s*fight)\\b", 66),
            Pattern.compile("\\b(?:ranqueado|n\u00e3o\\s*ranqueado|rankeado|classificado)\\b", 66),
            Pattern.compile("\\b(?:arcade| jogos\\s*de\\s*arcade|war\\s*lords?|pol\u00edcia|criminoso|survival|sobrevivencia|bedwars|skywars|skyblock|factions|pris\u00e3o|assalto\\s*\u00e0\\s*vida|eggwars|um\\s*bloco|anarquia|pr\u00e1tica|mist\u00e9rio\\s*de\\s*assass\u00ednio|her\u00f3is\\s*de\\s*golpe|paintball|quake|tnt|corrida\\s*de\\s*kart|wool\\s*wars|jogos\\s*de\\s*festa|escada\\s*do\\s*buraco|ca\u00e7a\\s*\u00e0\\s*fazenda|bat\\s*de\\s*constru\u00e7\u00e3o|pit|vida\\s*h\u00edbrida|heterodoxo|hybrid)\\b", 66),
            Pattern.compile("\\b(?:ranglisten|gerankt|unranked|klassiert|rangliste)\\b", 66),
            Pattern.compile("\\b(?:klassiker|arcade|hallenspiel|war\\s*lords?|polizist|kriminelle|survival|\u00fcberleben|bedwars|skywars|skyblock|fraktionen|gef\u00e4ngnis|heben\\s*stehlen|eggwars|ein\\s*block|anarchie|praxis|klassisch|mord|ermordung|r\u00e4tsel|smash|helden|paintball|quake|tnt|kart\\s*fahren|wool\\s*wars|party\\s*spiele|leiter|loch|bau\\s*schlacht|pit|wohnung|hybrid|schildkr\u00f6ten|scheinwerfer)\\b", 66),
            Pattern.compile("\\b(?:ranked|unranked|klasyfikacja|klasy|turniej|ranga)\\b", 66),
            Pattern.compile("\\b(?:arcade|klasyka|wojna|gliniany|morderstwo|zab\u00f3jstwo|survival|surwiwal|bedwars|skywars|skyblock|frakcje|wiezienie|kradziez|eggwars|anarchia|practice|mistyczny|quake|tnt|wool\\s*wars|mini\\s*gry|pit|housing|hybrid)\\b", 66),
            Pattern.compile("\\b(?:\u0440\u0435\u0439\u0442\u0438\u043d\u0433|\u0440\u0430\u043d\u0433|\u0431\u0435\u0437\\s*\u0440\u0435\u0439\u0442\u0438\u043d\u0433\u0430|\u043a\u043b\u0430\u0441\u0441|\u0440\u0430\u043d\u0436\u0438\u0440\u043e\u0432\u0430\u043d\u043d\u044b\u0439)\\b", 66),
            Pattern.compile("\\b(?:\u0430\u0440\u043a\u0430\u0434\u0430|\u043a\u043b\u0430\u0441\u0441\u0438\u043a\u0430|\u0432\u043e\u0439\u043d\u0430|\u0432\u043e\u0440\u043b\u0434\u0441|\u0431\u0430\u043d\u0434\u0438\u0442\u044b|\u043f\u043e\u043b\u0438\u0446\u0438\u044f|\u0432\u044b\u0436\u0438\u0432\u0430\u043d\u0438\u0435|bedwars|skywars|skyblock|\u0444\u0440\u0430\u043a\u0446\u0438\u0438|\u0442\u044e\u0440\u044c\u043c\u0430|\u043a\u0440\u0430\u0436\u0430\\s*\u0436\u0438\u0437\u043d\u0438|eggwars|\u043e\u0434\u0438\u043d\\s*\u0431\u043b\u043e\u043a|\u0430\u043d\u0430\u0440\u0445\u0438\u044f|\u043f\u0440\u0430\u043a\u0442\u0438\u043a\u0430|\u0443\u0431\u0438\u0439\u0441\u0442\u0432\u043e|\u0443\u0431\u0438\u0439\u0446\u0430|\u043c\u0438\u0441\u0442\u0435\u0440\u0438|\u043a\u0432\u0435\u0441\u0442|quake|tnt|wool\\s*wars|\u0432\u0435\u0447\u0435\u0440\u0438\u043d\u043a\u0430|\u043c\u0438\u043d\u0438\\s*\u0438\u0433\u0440\u044b|pit|\u0436\u0438\u043b\u044c\u0435|\u0433\u0438\u0431\u0440\u0438\u0434|\u0447\u0435\u0440\u0435\u043f\u0430\u0445\u0438|\u043b\u0430\u0437\u0435\u0440\\s*\u0442\u0430\u0433|soccer|football)\\b", 66),
            Pattern.compile("\\b(?:s\u0131ral\u0131|s\u0131ras\u0131z|ranked|r\u00fctbe|klasi| klasman)\\b", 66),
            Pattern.compile("\\b(?:klasik|arcade|sava\u015f|b\u00f6lge|hayatta\\s*kalma|bedwars|skywars|skyblock|cephe|cezaevi|ya\u011fma|eggwars|tek\\s*blok|anarsi|pratik|macerac\u0131|katil|\u00f6ld\u00fcrme|gizem|quake|tnt|wool\\s*wars|parti\\s*oyunlar\u0131|pit|konut|hibrit|kaplumba\u011fa)\\b", 66),
            Pattern.compile("\\b(?:arcade| klasik|war\\s*lords?|polisi|kriminal|survival|bedwars|skywars|skyblock|faksi|tahanan|eggwars|satu\\s*blok|anarki|latihan|pembantaian|pembunuh|teka\\s*teki|quake|tnt|wool\\s*wars|party\\s*games|pit|housing|hybrid)\\b", 66),
            Pattern.compile("\\b(?:x\u1ebfp\\s*h\u1ea1ng|kh\u00f4ng\\s*x\u1ebfp\\s*h\u1ea1ng|h\u1ea1ng|ranked)\\b", 66),
            Pattern.compile("\\b(?:arcade|c\u1ed5\\s*\u0111i\u1ec3n|war\\s*lords?|c\u01b0\u1edbp|c\u1ea3nh\\s*s\u00e1t|sinh\\s*t\u1ed3n|bedwars|skywars|skyblock|chi\u1ebfn\\s*tranh|t\u00f9|eggwars|m\u1ed9t\\s*kh\u1ed1i|v\u00f4\\s*ch\u00ednh\\s*ph\u1ee7|th\u1ef1c\\s*h\u00e0nh|nghi\\s*can|th\u1ee7\\s*ph\u1ea1m|quake|tnt|wool\\s*wars|tr\u00f2\\s*ch\u01a1i\\s*ti\u1ec7c\\s*\u00edch|pit|nh\u00e0\\s*\u1edf|hybird|con\\s*r\u00f9a)\\b", 66),
            Pattern.compile("\\b(?:\uc21c\uc704|\ub7ad\ud06c|\ube44\uc21c\uc704|\ub7ad\ud0b9|\ub9ac\ub354\ubcf4\ub4dc)\\b", 66),
            Pattern.compile("\\b(?:\uc544\ucf00\uc774\ub4dc|\uace0\uc804|\uc804\uc7c1|\uc6cc\ub85c\ub4dc|\uc878\uc5c5|\ubc94\uc8c4|\uc11c\ubc14\uc774\ubc8c|bedwars|skywars|skyblock|\ud30c\ubc8c|\uad50\ub3c4\uc18c|eggwars|\uc6d0\ube14\ub85d|\ubb34\u653f\u5e9c|\uad00\ud589|\uc5f0\uc2b5|\uc0b4\uc778|\ubbf8\uc2a4\ud130\ub9ac|quake|tnt|\uc591\\s*\uc804\uc7c1|\ud30c\ud2f0\\s*\uac8c\uc784|pit|\uc8fc\uac70|\ud558\uc774\ube0c\ub9ac\ub4dc|\uac70\ubd81\uc774)\\b", 66),
            Pattern.compile("\\b(?:\u30e9\u30f3\u30af|\u30ec\u30fc\u30c8|\u975e\u30e9\u30f3\u30af|\u30e9\u30f3\u30ad\u30f3\u30b0)\\b", 66),
            Pattern.compile("\\b(?:\u30a2\u30fc\u30b1\u30fc\u30c9|\u30af\u30e9\u30b7\u30c3\u30af|\u30a6\u30a9\u30fc\u30ba|\u6226\u58eb|\u8b66\u5bdf|\u72af\u4eba|\u30b5\u30d0\u30a4\u30d0\u30eb|bedwars|skywars|skyblock|\u6d3e\u95a5|\u5211\u52d9\u6240|eggwars|\u30ef\u30f3\u30d6\u30ed\u30c3\u30af|\u7121\u653f\u5e9c|\u7df4\u7fd2|\u6bba\u4eba|\u30df\u30b9\u30c6\u30ea\u30fc|quake|tnt|\u30a6\u30fc\u30eb\u30a6\u30a9\u30fc\u30ba|\u30d1\u30fc\u30c6\u30a3\u30fc\u30b2\u30fc\u30e0|pit|\u4f4f\u5b85|\u30cf\u30a4\u30d6\u30ea\u30c3\u30c9|\u4e80)\\b", 66),
            Pattern.compile("\\b(?:\u6392\u540d|\u65e0\u6392\u540d|\u6bb5\u4f4d|\u5929\u68af|\u6392\u4f4d|\u5929\u68af\u8d5b)\\b", 66),
            Pattern.compile("\\b(?:\u8857\u673a|\u7ecf\u5178|\u6218\u4e89|\u6218\u9738|\u751f\u5b58|\u8d77\u5e8a\u6218\u4e89|\u7a7a\u5c9b\u6218\u4e89|\u7a7a\u5c9b|\u9635\u8425|\u76d1\u72f1|\u8d77\u5e8a\u6218\u4e89|\u5355\u65b9\u5757|\u65e0\u653f\u5e9c|\u7ec3\u4e60|\u8c0b\u6740|\u8c1c\u9898|quake|tnt|\u7f8a\u6bdb\u6218\u4e89|\u6d3e\u5bf9\u6e38\u620f|\u6d1e\u68af|\u730e\u573a|\u5efa\u7b51\u6218|\u5c0f\u7403|\u732a\u732a|\u6fc0\u5149\u67aa|\u8db3\u7403|football|\u7bee\u7403)\\b", 66),
            Pattern.compile("\\b(?:\u0930\u0948\u0902\u0915|\u0930\u0948\u0902\u0915\u093f\u0902\u0917|\u0905\u0928\u0930\u0948\u0902\u0915|\u0926\u0930\u094d\u091c\u093e)\\b", 66),
            Pattern.compile("\\b(?:\u0906\u0930\u094d\u0915\u0947\u0921|\u0915\u094d\u0932\u093e\u0938\u093f\u0915|\u0935\u093e\u0930\\s*\u0932\u0949\u0930\u094d\u0921\u094d\u0938?|\u092a\u0941\u0932\u093f\u0938|\u0905\u092a\u0930\u093e\u0927\u0940|\u0938\u0930\u094d\u0935\u093e\u0907\u0935\u0932|bedwars|skywars|skyblock|\u0917\u0941\u091f|\u0915\u093e\u0930\u093e\u0917\u093e\u0930|eggwars|\u090f\u0915\\s*\u092c\u094d\u0932\u0949\u0915|\u0905\u0930\u093e\u091c\u0915\u0924\u093e|\u0905\u092d\u094d\u092f\u093e\u0938|\u0939\u0924\u094d\u092f\u093e|\u0939\u0924\u094d\u092f\u093e\u0930\u093e|\u0930\u0939\u0938\u094d\u092f|quake|tnt|\u090a\u0928\\s*\u092f\u0941\u0926\u094d\u0927|\u092a\u093e\u0930\u094d\u091f\u0940\\s*\u0916\u0947\u0932|pit|\u0906\u0935\u093e\u0938|\u0939\u093e\u0907\u092c\u094d\u0930\u093f\u0921|\u0915\u091b\u0941\u0906)\\b", 66),
            Pattern.compile("\\b(?:\u0645\u0631\u062a\u0628|\u062a\u0631\u062a\u064a\u0628|\u0644\u0627\u0639\u0628|\u0644\u0639\u0628\u0629|\u062a\u0635\u0646\u064a\u0641|\u0628\u062f\u0648\u0646\\s*\u062a\u0631\u062a\u064a\u0628)\\b", 66),
            Pattern.compile("\\b(?:\u0627\u0631\u0643\u064a\u062f|\u0643\u0644\u0627\u0633\u064a\u0643|\u062d\u0631\u0628|\u0628\u0648\u0644\u064a\u0633|\u062c\u0627\u0646\u0627|\u0628\u0642\u0627\u0621|bedwars|skywars|skyblock|\u0641\u0635\u064a\u0644|\u0633\u062c\u0646|eggwars|\u062c\u0632\u064a\u0631\u0629\\s*\u0648\u0627\u062d\u062f\u0629|\u0641\u0648\u0636\u0648\u064a\u0629|\u0627\u0644\u0642\u062a\u0644| \u0627\u0644\u0642\u0627\u062a\u0644|\u0627\u0644\u063a\u0645\u0648\u0636|quake|tnt|\u0635\u0648\u0641\\s*\u062d\u0631\u0628|\u062d\u0641\u0644\u0629\\s*\u0627\u0644\u0639\u0627\u0628|pit|\u0633\u0643\u0646|\u0647\u062c\u064a\u0646)\\b", 66),
            Pattern.compile("\\b(?:\u0e2d\u0e31\u0e19\u0e14\u0e31\u0e1a|\u0e44\u0e21\u0e48\u0e21\u0e35\u0e2d\u0e31\u0e19\u0e14\u0e31\u0e1a|\u0e41\u0e23\u0e07\u0e04\u0e4c|\u0e40\u0e14\u0e47\u0e14\u0e02\u0e32\u0e14)\\b", 66),
            Pattern.compile("\\b(?:\u0e2d\u0e32\u0e23\u0e4c\u0e40\u0e04\u0e14|\u0e04\u0e25\u0e32\u0e2a\u0e2a\u0e34\u0e01|\u0e2a\u0e07\u0e04\u0e23\u0e32\u0e21|\u0e15\u0e33\u0e23\u0e27\u0e08|\u0e2d\u0e32\u0e0a\u0e0d\u0e32\u0e01\u0e23|\u0e40\u0e2d\u0e32\u0e15\u0e34\u0e14\u0e15\u0e31\u0e27|bedwars|skywars|skyblock|\u0e1d\u0e48\u0e32\u0e22|\u0e04\u0e38\u0e01|eggwars|\u0e2b\u0e19\u0e36\u0e48\u0e07\\s*\u0e1a\u0e25\u0e47\u0e2d\u0e01|\u0e1b\u0e48\u0e32\u0e40\u0e16\u0e37\u0e48\u0e2d\u0e19|\u0e1d\u0e36\u0e01\u0e1d\u0e19|\u0e06\u0e32\u0e15\u0e01\u0e23|\u0e15\u0e31\u0e27\u0e25\u0e30\u0e04\u0e23|quake|tnt|\u0e02\u0e19\u0e41\u0e01\u0e30\\s*\u0e2a\u0e07\u0e04\u0e23\u0e32\u0e21|\u0e1b\u0e32\u0e23\u0e4c\u0e15\u0e35\u0e49\\s*\u0e40\u0e01\u0e21|pit|\u0e17\u0e35\u0e48\u0e2d\u0e22\u0e39\u0e48\u0e2d\u0e32\u0e28\u0e31\u0e22|\u0e44\u0e2e\u0e1a\u0e23\u0e34\u0e14|\u0e40\u0e15\u0e48\u0e32)\\b", 66),
            Pattern.compile("\\b(?:\u03ba\u03b1\u03c4\u03ac\u03c4\u03b1\u03be\u03b7|ranted|\u03c7\u03c9\u03c1\u03af\u03c2\\s*\u03ba\u03b1\u03c4\u03ac\u03c4\u03b1\u03be\u03b7|elo)\\b", 66),
            Pattern.compile("\\b(?:\u03b1\u03c1\u03ba\u03ac\u03bd\u03c4|\u03ba\u03bb\u03b1\u03c3\u03b9\u03ba\u03ac|war\\s*lords?|\u03b1\u03c3\u03c4\u03c5\u03bd\u03bf\u03bc\u03af\u03b1|\u03b5\u03b3\u03ba\u03bb\u03b7\u03bc\u03b1\u03c4\u03af\u03b5\u03c2|\u03b5\u03c0\u03b9\u03b2\u03af\u03c9\u03c3\u03b7|bedwars|skywars|skyblock|\u03c0\u03b1\u03c1\u03b1\u03c4\u03ac\u03be\u03b5\u03b9\u03c2|\u03c6\u03c5\u03bb\u03b1\u03ba\u03ae|eggwars|\u03ad\u03bd\u03b1\\s*\u03bc\u03c0\u03bb\u03bf\u03ba|\u03b1\u03bd\u03b1\u03c1\u03c7\u03af\u03b1|\u03c0\u03c1\u03b1\u03ba\u03c4\u03b9\u03ba\u03ae|\u03b4\u03bf\u03bb\u03bf\u03c6\u03bf\u03bd\u03af\u03b1|\u03b4\u03bf\u03bb\u03bf\u03c6\u03cc\u03bd\u03bf\u03c2|\u03bc\u03c5\u03c3\u03c4\u03ae\u03c1\u03b9\u03bf|quake|tnt|\u03bc\u03ac\u03bb\u03bb\u03b9\u03bd\u03bf\u03b9\\s*\u03c0\u03cc\u03bb\u03b5\u03bc\u03bf\u03b9|\u03c0\u03ac\u03c1\u03c4\u03b9\\s*\u03c0\u03b1\u03b9\u03c7\u03bd\u03af\u03b4\u03b9\u03b1|pit|\u03c3\u03c0\u03af\u03c4\u03b9|\u03c5\u03b2\u03c1\u03af\u03b4\u03b9\u03bf)\\b", 66),
            Pattern.compile("\\b(?:ranglista|ranked|rangl\u00f3|szint)\\b", 66),
            Pattern.compile("\\b(?:arcade|klasszikus|war\\s*lords?|rend\u0151r|b\u0171n\u00f6z\u0151|t\u00fal\u00e9l\u00e9s|bedwars|skywars|skyblock|t\u00f6bbs\u00e9g|bt\u00f6n|eggwars|egy\\s*blokk|anarchia|gyakorlat|gyilkoss\u00e1g|gyilkos|rejt\u00e9ly|quake|tnt|gyapj\u00fa\\s*h\u00e1bor\u00fa|p\u00e1rty\\s*j\u00e1t\u00e9kok|pit|sz\u00e1ll\u00e1s|hibrid)\\b", 66),
            Pattern.compile("\\b(?:ranked|neranked|po\u0159ad\u00ed|\u017eeb\u0159\u00ed\u010dek|klasifikace)\\b", 66),
            Pattern.compile("\\b(?:arcade|klasika|war\\s*lords?|policie|zlo\u010dinec|p\u0159e\u017eit\u00ed|bedwars|skywars|skyblock|strana|v\u011bzen\u00ed|eggwars|jeden\\s*blok|anarchie|praxe|vra\u017eda|vrah|tajemstv\u00ed|quake|tnt|vln\u011bn\u00e9\\s*v\u00e1lky|strana\\s*hry|pit|bydlen\u00ed|hybrid)\\b", 66),
            Pattern.compile("\\b(?:ranked|unranked|klassement|ranglijst)\\b", 66),
            Pattern.compile("\\b(?:arcade|klassiek|war\\s*lords?|politie|criminelen|overleving|bedwars|skywars|skyblock|fractie|gevangenis|eggwars|een\\s*blok|anarchie|oefening|moord|moordenaar|raadsel|quake|tnt|woon|hybrid)\\b", 66),
            Pattern.compile("\\b(?:clasat|neclasat|rang|ranked|clasament)\\b", 66),
            Pattern.compile("\\b(?:arcad\u0103|clasic|war\\s*lords?|poli\u021bie|criminal|supravie\u021buire|bedwars|skywars|skyblock|fac\u021biuni|\u00eenchisoare|eggwars|un\\s*bloc|anarhie|practic\u0103|uciga\u0219|omor| mister|quake|tnt|vat\u0103\\s*r\u0103zboi|petrecere\\s*jocuri|pit|locuin\u021b\u0103|hibrid)\\b", 66),
            Pattern.compile("\\b(?:classificato|non\\s*classificato|ranked|graduatoria|rango)\\b", 66),
            Pattern.compile("\\b(?:arcade|classico|war\\s*lords?|polizia|criminali|sopravvivenza|bedwars|skywars|skyblock|fazioni|prigione|eggwars|un\\s*blocco|anarchia|pratica|assassino|omicidio|mistero|quake|tnt|guerra\\s*lana|party\\s*games|pit|casa|ibrido)\\b", 66)
        };
        awa = Pattern.compile("\\b(?:survival|smp|minehut)\\b", 66);
        awb = Pattern.compile("\\b(?:eu\\.loyisa\\.cn|mc\\.loyisa\\.cn|tcpshield\\.anticheat-test\\.com|spectrum\\.anticheat-test\\.com|(?:[a-z0-9-]+\\.)*blocksmc\\.(?:com|net|club|org))\\b", 2);
        awc = Pattern.compile("^([a-z0-9]+)\\.[a-z0-9-]+\\.[a-z0-9-]+\\.[a-z0-9-]+\\.fisx\\.uk(?::\\d+)?$", 2);
        awd = Pattern.compile("^([A-Za-z0-9]+)(?:\\.[a-z0-9-]+)*\\.liquidproxy\\.net(?::\\d+)?$", 2);
        awe = Pattern.compile("\\b(?:[a-z0-9-]+\\.)*(?:loyisa\\.cn|anticheat-test\\.com)\\b", 2);
        awi = new aag[]{
            new aag("game_start_en", "(?:game|match|round)\\s+(?:is\\s+)?(?:starting|beginning)|(?:game|match|round)\\s+starts?\\s+in|starting\\s+in|begins?\\s+in|countdown|waiting\\s+for\\s+players"),
            new aag("player_join_en", "player\\s+joined|joined\\s+the\\s+game|has\\s+joined|has\\s+entered|joined\\s+the\\s+lobby|has\\s+joined\\s*\\("),
            new aag("duels_mode_en", "\\b(?:ranked|unranked)\\b|\\bbuild\\s*uhc\\b|\\b(?:duel|duels)\\b.*\\b(?:classic|nodebuff|no\\s*debuff|boxing|sumo|bridge|uhc|skywars|op|combo|blitz|megawalls|bow|parkour|tnt|gapple|mega|ult|ultimate)\\b|\\b(?:classic|nodebuff|no\\s*debuff|boxing|sumo|bridge|uhc|build\\s*uhc|skywars|op|combo|blitz|megawalls|bow|parkour|tnt|gapple|mega|ult|ultimate)\\b.*\\b(?:duel|duels)\\b|\\b(?:classic|nodebuff|boxing|sumo|bridge|uhc|build\\s*uhc|skywars|op|combo|blitz|megawalls|bow|parkour|tnt|gapple|mega|ult|ultimate)\\s+(?:duel|duels)\\b"),
            new aag("minigame_mode_en", "\\b(?:skyblock|bedwars|skywars|factions|prison|lifesteal|practice|kitpvp|eggwars|oneblock|survival\\s+games|hunger\\s+games|hungergames|anarchy|towny|creative|arcade|warlords?|turbo\\s*kart\\s*racers?|tkr|blitzsg|blitz\\s*sg|cops\\s*(?:and|&)\\s*criminals?|cnc|battleground|battlegrounds?|vampirez|the\\s*walls|mega\\s*walls|walls|mcgo|murder\\s*(?:mystery)?|smash\\s*heroes?|paintball|quake|the\\s*tnt\\s*games?|tnt\\s*games?|rumble|pvp\\s*run|speed\\s*uhc|wool\\s*wars|party\\s*games|hole\\s*ladder|farm\\s*hunt|build\\s*battle|pixel\\s*paintball|boulevard|pit|housing|hybrid|turtles?|pig\\s*fight|laser\\s*tag|ender\\s*spleef|soccer|football|scrimmage|hive|cubecraft|lunar|mineville|oneninja|drop|instant\\s*respawn|mega|ult|ultimate)\\b"),
            new aag("economy_smp_en", "\\b(?:coins?|tokens?|credits?|eco(?:nomy)?|claim|claims|land|lands|chunk|chunks|home|homes|sethome|warp|warps|shop|shops|auction|auction\\s+house|ah\\b|tpa|tpahere|teleport\\s+request|spawner|crate|survival|smp|anarchy|pit|pit\\s*xp?|housing)\\b"),
            new aag("game_mode_es", "\\b(?:clasificado|clasificada|sin\\s*clasificar|ranqueado|ranked|arcade|juegos\\s*de\\s*arcade|warlords?|batalla|criminoso|polic\u00edas|survival|supervivencia|bedwars|skywars|skyblock|facciones|prisi\u00f3n|robo\\s*de\\s*vida|eggwars|isla\\s*unica|anarqu\u00eda|duelo|duelos|misterio|asesinato|lobby|vida\\s*robada|torneo)\\b"),
            new aag("game_mode_fr", "\\b(?:class\u00e9|d\u00e9class\u00e9|non\\s*class\u00e9|ranked|arcade|survie|bedwars|skywars|skyblock|factions|prison|vol\\s*de\\s*vie|eggwars|une\\s*seule\\s*\u00eele|anarchie|duel|duels?|meurtrier|myst\u00e8re|bot\\s*fight|spawn|instant\\s*respawn|drop)\\b"),
            new aag("game_mode_de", "\\b(?:gerankt|ranglisten|klassiert|rangliste|arcade|\u00fcberleben|bedwars|skywars|skyblock|fraktionen|gef\u00e4ngnis|anarchie|kampf|duell|hive|cubecraft|lunar)\\b"),
            new aag("game_mode_pl", "\\b(?:ranked|unranked|klasyfikacja|arcade|surwiwal|bedwars|skywars|skyblock|frakcje|wiezienie|anarchia|gra|duel|hive)\\b"),
            new aag("game_mode_ru", "\\b(?:\u0440\u0435\u0439\u0442\u0438\u043d\u0433|\u0431\u0435\u0437\\s*\u0440\u0435\u0439\u0442\u0438\u043d\u0433\u0430|\u0430\u0440\u043a\u0430\u0434\u0430|\u0432\u044b\u0436\u0438\u0432\u0430\u043d\u0438\u0435|bedwars|skywars|skyblock|\u0444\u0440\u0430\u043a\u0446\u0438\u0438|\u0442\u044e\u0440\u044c\u043c\u0430|\u0430\u043d\u0430\u0440\u0445\u0438\u044f|\u0434\u0443\u044d\u043b\u044c|\u0443\u0431\u0438\u0439\u0441\u0442\u0432\u043e)\\b"),
            new aag("game_mode_tr", "\\b(?:s\u0131ral\u0131|s\u0131ras\u0131z|arcade|hayatta\\s*kalma|bedwars|skywars|skyblock|cephe|cezaevi|anarsi|duello|\u00f6ld\u00fcrme)\\b"),
            new aag("game_mode_pt", "\\b(?:ranqueado|n\u00e3o\\s*ranqueado|arcade|sobrevivencia|bedwars|skywars|skyblock|fra\u00e7\u00f5es|pris\u00e3o|anarquia|duelo|assassinato)\\b"),
            new aag("game_mode_it", "\\b(?:classificato|non\\s*classificato|arcade|sopravvivenza|bedwars|skywars|skyblock|fazioni|prigione|anarchia|duello|omicidio)\\b"),
            new aag("game_mode_nl", "\\b(?:ranked|unranked|arcade|overleving|bedwars|skywars|skyblock|fractie|gevangenis|anarchie|gevecht|duel)\\b"),
            new aag("game_mode_ro", "\\b(?:clasat|neclasat|arcad\u0103|supravie\u021buire|bedwars|skywars|skyblock|fac\u021biuni|\u00eenchisoare|anarchie|duel|uciga\u0219)\\b"),
            new aag("game_mode_cs_sk", "\\b(?:ranked|neranked|arcade|p\u0159e\u017eit\u00ed|bedwars|skywars|skyblock|strany|v\u011bzen\u00ed|anarchie|souboj|duel|vra\u017eda)\\b"),
            new aag("game_mode_hu", "\\b(?:ranglista|ranked|arcade|t\u00fal\u00e9l\u00e9s|bedwars|skywars|skyblock|t\u00f6bbs\u00e9g|b\u00f6rt\u00f6n|anarchia|harc|k\u00fczdelem|gyilkoss\u00e1g)\\b"),
            new aag("game_mode_id_ms", "\\b(?:arcade|keramat|survival|bedwars|skywars|skyblock|faksi|tahanan|anarki|pertempuran|duel|pembantaian)\\b"),
            new aag("game_mode_vi", "\\b(?:x\u1ebfp\\s*h\u1ea1ng|kh\u00f4ng\\s*x\u1ebfp\\s*h\u1ea1ng|arcade|sinh\\s*t\u1ed3n|bedwars|skywars|skyblock|chi\u1ebfn\\s*tranh|t\u00f9|anarchy|nhatt\\s*\u0111\u1ea5u|gi\u1ebft)\\b"),
            new aag("game_mode_ru_translit", "\\b(?:reiting|bez\\s*reitinga|arkada|vyzhivanie|bedwars|skywars|skyblock|fraktsii|tyurma|anarkhiya|duel|ubiystvo)\\b"),
            new aag("game_mode_zh", "\\b(?:\u6392\u540d|\u65e0\u6392\u540d|\u8857\u673a|\u751f\u5b58|\u8d77\u5e8a\u6218\u4e89|\u7a7a\u5c9b\u6218\u4e89|\u7a7a\u5c9b|\u9635\u8425|\u76d1\u72f1|\u65e0\u653f\u5e9c|\u51b3\u6597|\u8c0b\u6740)\\b"),
            new aag("game_mode_ja", "\\b(?:\u30e9\u30f3\u30af|\u975e\u30e9\u30f3\u30af|\u30a2\u30fc\u30b1\u30fc\u30c9|\u751f\u5b58|\u30d9\u30c3\u30c9\u30a6\u30a9\u30fc\u30ba|\u30b9\u30ab\u30a4\u30a6\u30a9\u30fc\u30ba|\u30b9\u30ab\u30a4\u30d6\u30ed\u30c3\u30af|\u6d3e\u95a5|\u5211\u52d9\u6240|\u7121\u653f\u5e9c|\u6c7a\u95d8|\u6bba\u4eba)\\b"),
            new aag("game_mode_ko", "\\b(?:\uc21c\uc704|\ube44\uc21c\uc704|\uc544\ucf00\uc774\ub4dc|\uc11c\ubc14\uc774\ubc8c|bedwars|skywars|skyblock|\ud30c\ubc8c|\uad50\ub3c4\uc18c|\ubb34\uc815\ubd80|\uacb0\ud22c|\uc0b4\uc778)\\b"),
            new aag("game_mode_el", "\\b(?:\u03ba\u03b1\u03c4\u03ac\u03c4\u03b1\u03be\u03b7|\u03c7\u03c9\u03c1\u03af\u03c2\\s*\u03ba\u03b1\u03c4\u03ac\u03c4\u03b1\u03be\u03b7|\u03b1\u03c1\u03ba\u03ac\u03bd\u03c4|\u03b5\u03c0\u03b9\u03b2\u03af\u03c9\u03c3\u03b7|bedwars|skywars|skyblock|\u03c0\u03b1\u03c1\u03b1\u03c4\u03ac\u03be\u03b5\u03b9\u03c2|\u03c6\u03c5\u03bb\u03b1\u03ba\u03ae|\u03b1\u03bd\u03b1\u03c1\u03c7\u03af\u03b1|\u03bc\u03ac\u03c7\u03b7|\u03b4\u03bf\u03bb\u03bf\u03c6\u03bf\u03bd\u03af\u03b1)\\b"),
            new aag("game_mode_ar", "\\b(?:\u062a\u0635\u0646\u064a\u0641|\u0628\u062f\u0648\u0646\\s*\u062a\u0631\u062a\u064a\u0628|\u0627\u0631\u0643\u064a\u062f|\u0628\u0642\u0627\u0621|\u0633\u0631\u064a\u0631|\u0633\u0643\u0627\u064a|\u0641\u0635\u064a\u0644|\u0633\u062c\u0646|\u0641\u0648\u0636\u0648\u064a\u0629|\u0642\u062a\u0627\u0644| \u0443\u0431\u0438\u0644)\\b"),
            new aag("game_mode_hi", "\\b(?:\u0930\u0948\u0902\u0915|\u0905\u0928\u0930\u0948\u0902\u0915|\u0906\u0930\u094d\u0915\u0947\u0921|\u092c\u091a\u093e\u0935|bedwars|skywars|skyblock|\u0917\u0941\u091f|\u0915\u093e\u0930\u093e\u0917\u093e\u0930|\u0905\u0930\u093e\u091c\u0915\u0924\u093e|\u0932\u0921\u093c\u093e\u0908|\u0939\u0924\u094d\u092f\u093e)\\b"),
            new aag("game_mode_th", "\\b(?:\u0e2d\u0e31\u0e19\u0e14\u0e31\u0e1a|\u0e44\u0e21\u0e48\u0e21\u0e35\u0e2d\u0e31\u0e19\u0e14\u0e31\u0e1a|\u0e2d\u0e32\u0e23\u0e4c\u0e40\u0e04\u0e14|\u0e40\u0e2d\u0e32\u0e15\u0e34\u0e14\u0e15\u0e31\u0e27|bedwars|skywars|skyblock|\u0e1d\u0e48\u0e32\u0e22|\u0e04\u0e38\u0e01|\u0e1b\u0e48\u0e32\u0e40\u0e16\u0e37\u0e48\u0e2d\u0e19|\u0e15\u0e48\u0e2d\u0e2a\u0e39\u0e49|\u0e06\u0e32\u0e15\u0e01\u0e23)\\b"),
            new aag("game_mode_uk", "\\b(?:\u0440\u0435\u0439\u0442\u0438\u043d\u0433|\u0431\u0435\u0437\\s*\u0440\u0435\u0439\u0442\u0438\u043d\u0433\u0443|\u0430\u0440\u043a\u0430\u0434\u0430|\u0432\u0438\u0436\u0438\u0432\u0430\u043d\u043d\u044f|bedwars|skywars|skyblock|\u0444\u0440\u0430\u043a\u0446\u0456\u0457|\u0432'\u044f\u0437\u043d\u0438\u0446\u044f|\u0430\u043d\u0430\u0440\u0445\u0456\u044f|\u0434\u0443\u0435\u043b\u044c|\u0432\u0431\u0438\u0432\u0441\u0442\u0432\u043e)\\b"),
            new aag("game_start_pl", "gra\\s+rozpocz(?:yna|nie)|gra\\s+rozpoczyna\\s*sie\\s+za|rozpocznie\\s*sie\\s+za|start\\s+za|odliczan"),
            new aag("player_join_pl", "gracz\\s+do[l\u0142]acz(?:yl|y[\u0142l])|do[l\u0142]acz(?:yl|y[\u0142l])\\s+do\\s+gry|wchodzi\\s+do\\s+gry"),
            new aag("game_start_de", "spiel\\s+startet|das\\s+spiel\\s+startet\\s+in|startet\\s+in|beginnt\\s+in|countdown"),
            new aag("player_join_de", "spieler\\s+ist\\s+beigetreten|spieler\\s+hat\\s+das\\s+spiel\\s+betreten|ist\\s+beigetreten|hat\\s+das\\s+spiel\\s+betreten"),
            new aag("economy_smp_de", "\\b(?:geld|kontostand|konto|bank|claim|claims?|grundstuck|grundst\u00fcck|home|homes|shop|shops|auktion|auktionshaus|survival|anarchie|smp)\\b"),
            new aag("game_start_tr", "oyun\\s+basliyor|oyun\\s+baslamasina|baslangica|geri\\s+sayim"),
            new aag("player_join_tr", "oyuncu\\s+katildi|oyuna\\s+katildi|katildi|giris\\s+yapti|oyuna\\s+girdi"),
            new aag("game_start_es", "la\\s+partida\\s+(?:empieza|comienza)|empieza\\s+en|comienza\\s+en|cuenta\\s+regresiva|esperando\\s+jugadores|anadido\\s+a\\s+la\\s+cola|aniadido\\s+a\\s+la\\s+cola|agregado\\s+a\\s+la\\s+cola|buscando\\s+oponente|has\\s+encontrado\\s+a|ha?s\\s+ganado|oponente:|informacion:"),
            new aag("player_join_es", "jugador\\s+se\\s+ha\\s+unido|se\\s+ha\\s+unido\\s+al\\s+juego|entro\\s+al\\s+juego|se\\s+unio|ha\\s+entrado\\s+al\\s+servidor|ha\\s+entrado\\s+al\\s+lobby|joined\\s+the\\s+lobby"),
            new aag("game_state_es", "asesinatos\\s+finales|tiempo\\s+vivo|flechas:|golpes:|cps:|salido\\s+de\\s+la\\s+cola|deseas\\s+salirte\\s+de\\s+la\\s+arena|verificando\\s+tu\\s+cliente|introduce\\s+el\\s+codigo\\s+de\\s+la\\s+imagen|has\\s+pasado\\s+el\\s+test\\s+antibot|eres\\s+jugador\\s+con\\s+cuenta\\s+premium|verificando\\s+cuenta\\s+en\\s+minecraft\\.net|te\\s+has\\s+registrado\\s+correctamente|registrate"),
            new aag("economy_smp_es", "\\b(?:saldo|dinero|banco|monedas?|economia|econom[i\u00ed]a|reclamo|reclamos|terreno|terrenos|hogar|hogares|casa|casas|tienda|tiendas|subasta|subastas|teletransporte|proteccion|protecci\u00f3n|survival|anarquia|anarqu[i\u00ed]a|smp)\\b"),
            new aag("game_start_pt", "o\\s+jogo\\s+comeca|o\\s+jogo\\s+comeca|o\\s+jogo\\s+come\u00e7a|comeca\\s+em|comeca\\s+em|come\u00e7a\\s+em|iniciando\\s+em|contagem\\s+regressiva|aguardando\\s+jogadores"),
            new aag("player_join_pt", "jogador\\s+entrou|entrou\\s+no\\s+jogo|se\\s+juntou|juntou-se"),
            new aag("economy_smp_pt", "\\b(?:saldo|dinheiro|banco|moedas?|economia|terreno|terrenos|casa|casas|loja|lojas|leilao|leil\u00e3o|teleporte|survival|anarquia|smp)\\b"),
            new aag("game_start_fr", "la\\s+partie\\s+commence|la\\s+partie\\s+commence\\s+dans|commence\\s+dans|debut\\s+dans|d\u00e9but\\s+dans|compte\\s+a\\s+rebours|compte\\s+\u00e0\\s+rebours|en\\s+attente\\s+de\\s+joueurs"),
            new aag("player_join_fr", "joueur\\s+a\\s+rejoint|a\\s+rejoint\\s+la\\s+partie|a\\s+rejoint|est\\s+entre\\s+dans\\s+la\\s+partie|est\\s+entr\u00e9\\s+dans\\s+la\\s+partie"),
            new aag("economy_smp_fr", "\\b(?:argent|solde|banque|claim|claims|terrain|terrains|maison|maisons|boutique|boutiques|enchere|ench\u00e8re|survie|anarchie|smp)\\b"),
            new aag("game_start_it", "la\\s+partita\\s+inizia|la\\s+partita\\s+inizia\\s+tra|inizia\\s+tra|comincia\\s+tra|conto\\s+alla\\s+rovescia|in\\s+attesa\\s+di\\s+giocatori"),
            new aag("player_join_it", "giocatore\\s+entrato|si\\s+e\\s+unito\\s+alla\\s+partita|si\\s+e\\s+unito|e\\s+entrato\\s+nel\\s+gioco"),
            new aag("game_start_nl", "spel\\s+begint|spel\\s+begint\\s+over|begint\\s+over|aftellen|wachten\\s+op\\s+spelers"),
            new aag("player_join_nl", "speler\\s+is\\s+toegetreden|is\\s+toegetreden|heeft\\s+de\\s+game\\s+betreden"),
            new aag("game_start_cs_sk", "hra\\s+zacina|hra\\s+zacne\\s+za|zacina\\s+za|odpocet|odpoctavani|caka\\s+sa\\s+na\\s+hracov"),
            new aag("player_join_cs_sk", "hrac\\s+se\\s+pripojil|hrac\\s+sa\\s+pripojil|pripojil\\s+se\\s+do\\s+hry|sa\\s+pripojil\\s+do\\s+hry"),
            new aag("game_start_ro", "jocul\\s+incepe|jocul\\s+incepe\\s+in|incepe\\s+in|numaratoare\\s+inversa|asteptam\\s+jucatori"),
            new aag("player_join_ro", "jucatorul\\s+s-a\\s+alaturat|s-a\\s+alaturat\\s+jocului|a\\s+intrat\\s+in\\s+joc"),
            new aag("game_start_hu", "jatek\\s+kezdodik|jatek\\s+kezdodik\\s+ennyi\\s+ido\\s+mulva|kezdes\\s+ennyi\\s+ido\\s+mulva|visszaszamlalas|jatekosokra\\s+varunk"),
            new aag("player_join_hu", "jatekos\\s+csatlakozott|csatlakozott\\s+a\\s+jatekhoz|belepett\\s+a\\s+jatekba"),
            new aag("game_start_id_ms", "permainan\\s+dimulai|game\\s+dimulai|mulai\\s+dalam|hitung\\s+mundur|menunggu\\s+pemain"),
            new aag("player_join_id_ms", "pemain\\s+bergabung|bergabung\\s+ke\\s+permainan|masuk\\s+ke\\s+permainan"),
            new aag("game_start_vi", "tran\\s+dau\\s+bat\\s+dau|bat\\s+dau\\s+sau|dem\\s+nguoc|dang\\s+doi\\s+nguoi\\s+choi"),
            new aag("player_join_vi", "nguoi\\s+choi\\s+da\\s+tham\\s+gia|da\\s+vao\\s+tran|tham\\s+gia\\s+tro\\s+choi"),
            new aag("game_start_ru_translit", "igra\\s+nachinaetsya|igra\\s+nachnetsya|igra\\s+nachnetsa|nachalo\\s+cherez|start\\s+cherez|otschet|obratnyy\\s+otschet|ozhidanie\\s+igrokov"),
            new aag("player_join_ru_translit", "igrok\\s+prisoedinilsya|igrok\\s+voshel|voshyol\\s+v\\s+igru|zashel\\s+v\\s+igru"),
            new aag("game_start_ru", "\u0438\u0433\u0440\u0430\\s+\u043d\u0430\u0447\u0438\u043d\u0430\u0435\u0442\u0441\u044f|\u0438\u0433\u0440\u0430\\s+\u043d\u0430\u0447\u043d[\u0435\u0451]\u0442\u0441\u044f|\u043d\u0430\u0447\u0430\u043b\u043e\\s+\u0447\u0435\u0440\u0435\u0437|\u0441\u0442\u0430\u0440\u0442\\s+\u0447\u0435\u0440\u0435\u0437|\u043e\u0442\u0441\u0447[\u0435\u0451]\u0442|\u043e\u0431\u0440\u0430\u0442\u043d\u044b\u0439\\s+\u043e\u0442\u0441\u0447[\u0435\u0451]\u0442|\u043e\u0436\u0438\u0434\u0430\u043d\u0438\u0435\\s+\u0438\u0433\u0440\u043e\u043a\u043e\u0432"),
            new aag("player_join_ru", "\u0438\u0433\u0440\u043e\u043a\\s+\u043f\u0440\u0438\u0441\u043e\u0435\u0434\u0438\u043d\u0438\u043b\u0441\u044f|\u0438\u0433\u0440\u043e\u043a\\s+\u0432\u043e\u0448[\u0435\u0451]\u043b|\u0432\u043e\u0448[\u0435\u0451]\u043b\\s+\u0432\\s+\u0438\u0433\u0440\u0443|\u0437\u0430\u0448[\u0435\u0451]\u043b\\s+\u0432\\s+\u0438\u0433\u0440\u0443"),
            new aag("game_start_zh", "\u6e38\u620f\u5373\u5c06\u5f00\u59cb|\u6e38\u620f\u5f00\u59cb\u5012\u8ba1\u65f6|\u5c06\u5728\\s*\\d+\\s*\u79d2\u540e\u5f00\u59cb|\u5012\u8ba1\u65f6|\u7b49\u5f85\u73a9\u5bb6|\u6bd4\u8d5b\u5f00\u59cb"),
            new aag("player_join_zh", "\u73a9\u5bb6\u5df2\u52a0\u5165|\u52a0\u5165\u4e86\u6e38\u620f|\u8fdb\u5165\u4e86\u6e38\u620f|\u52a0\u5165\u5927\u5385|\u8fdb\u5165\u5927\u5385"),
            new aag("game_start_ja", "\u30b2\u30fc\u30e0\u958b\u59cb|\u30b2\u30fc\u30e0\u306f.*\u79d2\u5f8c\u306b\u958b\u59cb|\u958b\u59cb\u307e\u3067|\u30ab\u30a6\u30f3\u30c8\u30c0\u30a6\u30f3|\u30d7\u30ec\u30a4\u30e4\u30fc\u3092\u5f85\u3063\u3066\u3044\u307e\u3059"),
            new aag("player_join_ja", "\u30d7\u30ec\u30a4\u30e4\u30fc\u304c\u53c2\u52a0|\u30b2\u30fc\u30e0\u306b\u53c2\u52a0\u3057\u307e\u3057\u305f|\u30ed\u30d3\u30fc\u306b\u53c2\u52a0\u3057\u307e\u3057\u305f"),
            new aag("game_start_ko", "\uac8c\uc784\\s*\uc2dc\uc791|\uac8c\uc784\uc774\\s*.*\ucd08\\s*\ud6c4\uc5d0\\s*\uc2dc\uc791|\uce74\uc6b4\ud2b8\ub2e4\uc6b4|\ud50c\ub808\uc774\uc5b4\ub97c\\s*\uae30\ub2e4\ub9ac\ub294\\s*\uc911"),
            new aag("player_join_ko", "\ud50c\ub808\uc774\uc5b4\uac00\\s*\ucc38\uac00\ud588\uc2b5\ub2c8\ub2e4|\uac8c\uc784\uc5d0\\s*\ucc38\uac00\ud588\uc2b5\ub2c8\ub2e4|\ub85c\ube44\uc5d0\\s*\ucc38\uac00\ud588\uc2b5\ub2c8\ub2e4"),
            new aag("game_start_uk", "\u0433\u0440\u0430\\s+\u043f\u043e\u0447\u0438\u043d\u0430\u0454\u0442\u044c\u0441\u044f|\u0433\u0440\u0430\\s+\u043f\u043e\u0447\u043d\u0435\u0442\u044c\u0441\u044f\\s+\u0447\u0435\u0440\u0435\u0437|\u043f\u043e\u0447\u0430\u0442\u043e\u043a\\s+\u0447\u0435\u0440\u0435\u0437|\u0432\u0456\u0434\u043b\u0456\u043a|\u043e\u0447\u0456\u043a\u0443\u0432\u0430\u043d\u043d\u044f\\s+\u0433\u0440\u0430\u0432\u0446\u0456\u0432"),
            new aag("player_join_uk", "\u0433\u0440\u0430\u0432\u0435\u0446\u044c\\s+\u043f\u0440\u0438\u0454\u0434\u043d\u0430\u0432\u0441\u044f|\u043f\u0440\u0438\u0454\u0434\u043d\u0430\u0432\u0441\u044f\\s+\u0434\u043e\\s+\u0433\u0440\u0438|\u0443\u0432\u0456\u0439\u0448\u043e\u0432\\s+\u0443\\s+\u0433\u0440\u0443"),
            new aag("game_start_el", "\u03c4\u03bf\\s+\u03c0\u03b1\u03b9\u03c7\u03bd\u03b9\u03b4\u03b9\\s+\u03be\u03b5\u03ba\u03b9\u03bd\u03b1|\u03c4\u03bf\\s+\u03c0\u03b1\u03b9\u03c7\u03bd\u03b9\u03b4\u03b9\\s+\u03b1\u03c1\u03c7\u03b9\u03b6\u03b5\u03b9|\u03be\u03b5\u03ba\u03b9\u03bd\u03b1\\s+\u03c3\u03b5|\u03b1\u03bd\u03c4\u03b9\u03c3\u03c4\u03c1\u03bf\u03c6\u03b7\\s+\u03bc\u03b5\u03c4\u03c1\u03b7\u03c3\u03b7|\u03b1\u03bd\u03b1\u03bc\u03bf\u03bd\u03b7\\s+\u03c0\u03b1\u03b9\u03ba\u03c4\u03c9\u03bd"),
            new aag("player_join_el", "\u03bf\\s+\u03c0\u03b1\u03b9\u03ba\u03c4\u03b7\u03c2\\s+\u03bc\u03c0\u03b7\u03ba\u03b5|\u03bf\\s+\u03c0\u03b1\u03b9\u03ba\u03c4\u03b7\u03c2\\s+\u03c3\u03c5\u03bd\u03b4\u03b5\u03b8\u03b7\u03ba\u03b5|\u03bc\u03c0\u03b7\u03ba\u03b5\\s+\u03c3\u03c4\u03bf\\s+\u03c0\u03b1\u03b9\u03c7\u03bd\u03b9\u03b4\u03b9"),
            new aag("game_start_ar", "\u062a\u0628\u062f\u0623\\s+\u0627\u0644\u0644\u0639\u0628\u0629|\u0627\u0644\u0644\u0639\u0628\u0629\\s+\u062a\u0628\u062f\u0623\\s+\u062e\u0644\u0627\u0644|\u062a\u0628\u062f\u0623\\s+\u062e\u0644\u0627\u0644|\u0627\u0644\u0639\u062f\\s+\u0627\u0644\u062a\u0646\u0627\u0632\u0644\u064a|\u0628\u0627\u0646\u062a\u0638\u0627\u0631\\s+\u0627\u0644\u0644\u0627\u0639\u0628\u064a\u0646"),
            new aag("player_join_ar", "\u0627\u0646\u0636\u0645\\s+\u0627\u0644\u0644\u0627\u0639\u0628|\u062f\u062e\u0644\\s+\u0627\u0644\u0644\u0627\u0639\u0628|\u0627\u0646\u0636\u0645\\s+\u0627\u0644\u0649\\s+\u0627\u0644\u0644\u0639\u0628\u0629|\u062f\u062e\u0644\\s+\u0627\u0644\u0649\\s+\u0627\u0644\u0644\u0639\u0628\u0629"),
            new aag("game_start_hi", "\u0917\u0947\u092e\\s+\u0936\u0941\u0930\u0942|\u0916\u0947\u0932\\s+\u0936\u0941\u0930\u0942|\u0936\u0941\u0930\u0942\\s+\u0939\u094b\u0928\u0947\\s+\u092e\u0947\u0902|\u0909\u0932\u091f\u0940\\s+\u0917\u093f\u0928\u0924\u0940|\u0916\u093f\u0932\u093e\u0921\u093c\u093f\u092f\u094b\u0902\\s+\u0915\u0940\\s+\u092a\u094d\u0930\u0924\u0940\u0915\u094d\u0937\u093e"),
            new aag("player_join_hi", "\u0916\u093f\u0932\u093e\u0921\u093c\u0940\\s+\u091c\u0941\u0921\u093c|\u0916\u0947\u0932\\s+\u092e\u0947\u0902\\s+\u0936\u093e\u092e\u093f\u0932|\u0917\u0947\u092e\\s+\u092e\u0947\u0902\\s+\u0936\u093e\u092e\u093f\u0932"),
            new aag("game_start_th", "\u0e40\u0e01\u0e21\u0e40\u0e23\u0e34\u0e48\u0e21|\u0e08\u0e30\u0e40\u0e23\u0e34\u0e48\u0e21\u0e43\u0e19|\u0e19\u0e31\u0e1a\u0e16\u0e2d\u0e22\u0e2b\u0e25\u0e31\u0e07|\u0e01\u0e33\u0e25\u0e31\u0e07\u0e23\u0e2d\u0e1c\u0e39\u0e49\u0e40\u0e25\u0e48\u0e19"),
            new aag("player_join_th", "\u0e1c\u0e39\u0e49\u0e40\u0e25\u0e48\u0e19\u0e40\u0e02\u0e49\u0e32\u0e23\u0e48\u0e27\u0e21|\u0e40\u0e02\u0e49\u0e32\u0e23\u0e48\u0e27\u0e21\u0e40\u0e01\u0e21|\u0e40\u0e02\u0e49\u0e32\u0e25\u0e47\u0e2d\u0e1a\u0e1a\u0e35\u0e49")
        };
        awj = Pattern.compile("(?:\\b5\\b\\D*\\b4\\b\\D*\\b3\\b)|(?:\\b4\\b\\D*\\b3\\b\\D*\\b2\\b\\D*\\b1\\b)|(?:\\b3\\b\\D*\\b2\\b\\D*\\b1\\b)", 66);
        awk = Pattern.compile("^(?:\\[[^\\]]+\\]\\s*){0,5}[\\p{L}0-9_]{1,24}\\s*:\\s+.+$", 66);
        awl = Pattern.compile("^<[^>]{1,24}>\\s+.+$", 66);
        awm = Pattern.compile("^(?:opponent|oponente|adversaire|adversario|avversario|gegner|informacion|information|info|cuenta|account|uc|pit|fiesta|party|sistema|system|server)\\s*[:\u00bb].*$", 66);
    }

    public static Object o0Oo000O0oO(Object[] var0) {
        try {
            int i = (Integer)var0[1];
            String s = (String)var0[2];
            Object object17 = var0[0];
            Object secretkeyspec = oO00O0OO0ooO;
            if (oO00O0OO0ooO == null) {
                secretkeyspec = oO00O0OO0ooO = new Object[6];
            }

            secretkeyspec = ((Object[])secretkeyspec)[i];
            if (secretkeyspec == null) {
                secretkeyspec = (Object[])object17;
                if ((Object[])object17 == null) {
                    secretkeyspec = fld_0OOOoo00o0_65 = new Object[1];
                    byte[] abyte = new byte[16];
                    abyte[10] = -98;
                    abyte[0] = -102;
                    abyte[12] = 110;
                    abyte[4] = -62;
                    abyte[8] = -89;
                    abyte[15] = -127;
                    abyte[7] = 98;
                    abyte[14] = 78;
                    abyte[2] = 78;
                    abyte[1] = 43;
                    abyte[3] = -80;
                    abyte[9] = -35;
                    abyte[6] = -78;
                    abyte[13] = -47;
                    abyte[5] = 101;
                    abyte[11] = 16;
                    ((Object[])secretkeyspec)[0] = abyte;
                }

                byte[] abyte1 = (byte[])((Object[])secretkeyspec)[0];
                if (Oo0o00000O00 == null) {
                    byte[] abyte2 = new byte[32];
                    abyte2[8] = 35;
                    abyte2[31] = -96;
                    abyte2[26] = -31;
                    abyte2[30] = 6;
                    abyte2[23] = -20;
                    abyte2[5] = 115;
                    abyte2[6] = -40;
                    abyte2[21] = -68;
                    abyte2[7] = -118;
                    abyte2[9] = 77;
                    abyte2[19] = 57;
                    abyte2[13] = -33;
                    abyte2[10] = -38;
                    abyte2[27] = -124;
                    abyte2[12] = -92;
                    abyte2[24] = -9;
                    abyte2[14] = -47;
                    abyte2[29] = 48;
                    abyte2[28] = -81;
                    abyte2[0] = 96;
                    abyte2[2] = -61;
                    abyte2[4] = 110;
                    abyte2[22] = -77;
                    abyte2[11] = -8;
                    abyte2[25] = -21;
                    abyte2[1] = -45;
                    abyte2[17] = 96;
                    abyte2[18] = 7;
                    abyte2[20] = 15;
                    abyte2[3] = -42;
                    abyte2[15] = -88;
                    abyte2[16] = 41;
                    byte[] abyte3 = new byte[((byte[])abyte1).length + ((byte[])abyte2).length];
                    System.arraycopy(abyte1, 0, abyte3, 0, abyte1.length);
                    System.arraycopy(abyte2, 0, abyte3, abyte1.length, abyte2.length);
                    secretkeyspec = mth_0OOOoo00o0_31()[6];
                    if (secretkeyspec == null) {
                        char[] achar = "蜌蜺蜹蜸蜆蝪蜍蛓蚨蛔蜴蛏蛛蚡蜑蜴蜻蝫".toCharArray();

                        for (int j = 0; j < 18; j++) {
                            char c0 = achar[j];
                            int k = c0 + 6913;
                            int l = k ^ 41954;
                            int i1 = l + 29161;
                            int j1 = i1 + 27849;
                            int k1 = j1 ^ 53709;
                            int l1 = k1 ^ 59214;
                            int i2 = l1 + 14895;
                            int j2 = i2 - 24628;
                            int k2 = j2 ^ 64980;
                            int l2 = k2 - 22232;
                            int i3 = l2 + 4601;
                            int j3 = i3 ^ 60089;
                            int k3 = j3 ^ 43097;
                            int l3 = k3 ^ 19034;
                            achar[j] = (char)l3;
                        }

                        secretkeyspec = mth_0OOOoo00o0_31()[6] = new String(achar);
                    }

                    SecretKeyFactory secretkeyfactory = SecretKeyFactory.getInstance((String)secretkeyspec);
                    byte[] abyte7 = new byte[16];
                    abyte7[11] = 61;
                    abyte7[3] = -63;
                    abyte7[10] = -103;
                    abyte7[13] = 61;
                    abyte7[0] = -49;
                    abyte7[5] = 45;
                    abyte7[6] = -23;
                    abyte7[9] = -4;
                    abyte7[1] = 24;
                    abyte7[15] = -25;
                    abyte7[7] = 103;
                    abyte7[14] = 66;
                    abyte7[8] = 100;
                    abyte7[12] = -18;
                    abyte7[4] = -27;
                    abyte7[2] = -66;
                    PBEKeySpec pbekeyspec = new PBEKeySpec(new String(abyte3, StandardCharsets.UTF_8).toCharArray(), abyte7, 22, 256);
                    byte[] abyte8 = secretkeyfactory.generateSecret(pbekeyspec).getEncoded();
                    byte[] abyte10 = abyte8;
                    Object object19 = mth_0OOOoo00o0_31()[7];
                    if (object19 == null) {
                        char[] achar2 = "\ue53b\ue53f\ue52d".toCharArray();

                        for (byte b0 = 0; b0 < 3; b0 += 1) {
                            char c2 = achar2[b0];
                            int i7 = c2 - 17216;
                            int j7 = i7 ^ 31857;
                            int k7 = j7 ^ 57122;
                            int l7 = k7 + 63171;
                            int i8 = l7 - 38067;
                            int j8 = i8 ^ 901;
                            int k8 = j8 - 18585;
                            int l8 = k8 + 42666;
                            int i9 = l8 ^ 58447;
                            int j9 = i9 - 43599;
                            int k9 = j9 + 35215;
                            achar2[b0] = (char)k9;
                        }

                        object19 = mth_0OOOoo00o0_31()[7] = new String(achar2);
                    }

                    secretkeyspec = new SecretKeySpec(abyte10, (String)object19);
                    Oo0o00000O00 = secretkeyspec;
                }

                byte[] abyte9 = Base64.getDecoder().decode(s);
                byte[] abyte4 = Arrays.copyOfRange(abyte9, 0, 16);
                byte[] abyte5 = Arrays.copyOfRange(abyte9, 16, abyte9.length);
                Object object18 = mth_0OOOoo00o0_31()[8];
                if (object18 == null) {
                    char[] achar1 = "쭝쭙쮋쬿쭛쭘쭛쬿쮊쬳쭛쮋쫩쮊챽챶챶쳕챼쳇".toCharArray();

                    for (int i4 = 0; i4 < 20; i4++) {
                        char c1 = achar1[i4];
                        int j4 = c1 - '駠';
                        int k4 = j4 ^ 29521;
                        int l4 = k4 ^ 4963;
                        int i5 = l4 ^ 62227;
                        int j5 = i5 + 39785;
                        int k5 = j5 ^ 17065;
                        int l5 = k5 + 47338;
                        int i6 = l5 ^ 44122;
                        int j6 = i6 ^ 25389;
                        int k6 = j6 ^ 7598;
                        int l6 = k6 ^ 60110;
                        achar1[i4] = (char)l6;
                    }

                    object18 = mth_0OOOoo00o0_31()[8] = new String(achar1);
                }

                Cipher cipher = Cipher.getInstance((String)object18);
                cipher.init(2, (SecretKey)Oo0o00000O00, new IvParameterSpec(abyte4));
                byte[] abyte6 = cipher.doFinal(abyte5);
                secretkeyspec = oO00O0OO0ooO[i] = new String(abyte6, StandardCharsets.UTF_8);
            }

            return secretkeyspec;
        } catch (java.security.GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean nG() {
        return false;
    }

    public boolean az(String var1) {
        String s = StringUtils.trimToEmpty(this.aC(var1)).toLowerCase(Locale.ROOT);
        if (s.isEmpty()) {
            return false;
        }
        return awb.matcher(s).find() ? true : this.aA(s);
    }
}
