package hackclient.rise;

import com.alan.clients.component.Component;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.other.TickEvent;
import com.alan.clients.newevent.impl.other.WorldChangeEvent;
import com.mojang.authlib.GameProfile;
import hackclient.rise.event.er;
import io.netty.buffer.Unpooled;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityTrackerEntry;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.EnumPacketDirection;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.login.server.S02PacketLoginSuccess;
import net.minecraft.network.play.server.S01PacketJoinGame;
import net.minecraft.network.play.server.S03PacketTimeUpdate;
import net.minecraft.network.play.server.S06PacketUpdateHealth;
import net.minecraft.network.play.server.S07PacketRespawn;
import net.minecraft.network.play.server.S08PacketPlayerPosLook.EnumFlags;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S14PacketEntity.S15PacketEntityRelMove;
import net.minecraft.network.play.server.S14PacketEntity.S16PacketEntityLook;
import net.minecraft.network.play.server.S14PacketEntity.S17PacketEntityLookMove;
import net.minecraft.network.play.server.S20PacketEntityProperties;
import net.minecraft.network.play.server.S26PacketMapChunkBulk;
import net.minecraft.network.play.server.S30PacketWindowItems;
import net.minecraft.network.play.server.S38PacketPlayerListItem.AddPlayerData;
import net.minecraft.network.play.server.S38PacketPlayerListItem;
import net.minecraft.network.play.server.S39PacketPlayerAbilities;
import net.minecraft.network.play.server.S3BPacketScoreboardObjective;
import net.minecraft.network.play.server.S3CPacketUpdateScore;
import net.minecraft.network.play.server.S3EPacketTeams;
import net.minecraft.network.play.server.S41PacketServerDifficulty;
import net.minecraft.network.play.server.S44PacketWorldBorder.Action;
import net.minecraft.network.play.server.S44PacketWorldBorder;
import net.minecraft.network.play.server.ad;
import net.minecraft.network.play.server.ag;
import net.minecraft.network.play.server.e;
import net.minecraft.network.play.server.f;
import net.minecraft.network.play.server.k;
import net.minecraft.network.play.server.m;
import net.minecraft.network.play.server.z;
import net.minecraft.potion.PotionEffect;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.s;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings.GameType;
import net.minecraft.world.chunk.Chunk;
import rip.vantage.commons.packet.impl.server.monitoring.h;
import rip.vantage.network.core.a;

public class bo extends Component {
    public int eX;
    public Method ez;
    public boolean eM;
    public static Object[] fld_0oOOoOo0O00O_11;
    public long fa;
    public DataOutputStream ff;
    public int eE;
    public boolean eH;
    public volatile boolean eF;
    public Object ex = new Object();
    public int eN;
    public byte eT;
    public boolean eY;
    public boolean eW;
    public ByteArrayOutputStream fe;
    public boolean eG;
    public static Object[] o0Oo000O0oO = new Object[38];
    public static int ew;
    public String fc;
    public boolean eK;
    public static UUID ev;
    @EventLink
    public Listener<TickEvent> onTick;
    public static Object[] oO00O0OO0ooO;
    public boolean eJ;
    @EventLink
    public Listener<WorldChangeEvent> onWorldChange;
    public byte eS;
    public long eI;
    public List<byte[]> eB;
    public ItemStack[] eU;
    @EventLink
    public Listener<er> fg;
    public byte eR;
    public int fd;
    public Field eA;
    public int eP;
    public byte eQ;
    public Object ey = new Object();
    public static Object[] fld_0OOOoo00o0_12;
    public String eZ;
    public Set<UUID> eC;
    public int eO;
    public Map<UUID, GameProfile> eD;
    public boolean eL;
    public int fb;
    public ItemStack eV;
    public static Object Oo0o00000O00;

    public void a(String var1, byte[] var2, String var3) {

        try {
            if (var1 == null || a.aKB().aKK() == null) {
                return;
            }

            String s3 = h(var1);
            int l = var2.length;
            String s = h(var3);
            int l2 = l;
            String s1 = s3;
            String s2 = "{\"id\":30,\"a\":\"" + s1 + "\",\"b\":" + l2 + ",\"c\":\"" + s + "\"}";
            a.aKB().aKK().sendMessage(s2);
            a.aKB().aKK().o(var2);
        } catch (Exception exception) {
        }
    }

    public byte[] a(byte[] var1, String var2, long var3, long var5) throws java.io.IOException {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        ZipOutputStream zipoutputstream = new ZipOutputStream(bytearrayoutputstream);
        CRC32 crc32 = new CRC32();
        crc32.update(var1);
        zipoutputstream.putNextEntry(new ZipEntry("recording.tmcpr"));
        zipoutputstream.write(var1);
        zipoutputstream.closeEntry();
        zipoutputstream.putNextEntry(new ZipEntry("metaData.json"));
        String s = this.bE();
        String s4 = h(var2);
        String s1 = s;
        long k = var5;
        long l = var3;
        String s2 = s4;
        String s3 = "{\"singleplayer\":false,\"serverName\":\""
            + s2
            + "\",\"duration\":"
            + l
            + ",\"date\":"
            + k
            + ",\"mcversion\":\"1.8.9\",\"fileFormat\":\"MCPR\",\"fileFormatVersion\":14,\"protocol\":47,\"generator\":\"rise\",\"selfId\":-1,\"players\":"
            + s1
            + "}";
        zipoutputstream.write(s3.getBytes(StandardCharsets.UTF_8));
        zipoutputstream.closeEntry();
        zipoutputstream.putNextEntry(new ZipEntry("markers.json"));
        zipoutputstream.write("[]".getBytes(StandardCharsets.UTF_8));
        zipoutputstream.closeEntry();
        zipoutputstream.putNextEntry(new ZipEntry("mods.json"));
        zipoutputstream.write(("{\"requiredMods\":[]}").getBytes(StandardCharsets.UTF_8));
        zipoutputstream.closeEntry();
        zipoutputstream.putNextEntry(new ZipEntry("recording.tmcpr.crc32"));
        zipoutputstream.write(Long.toString(crc32.getValue()).getBytes(StandardCharsets.UTF_8));
        zipoutputstream.closeEntry();
        zipoutputstream.close();
        return bytearrayoutputstream.toByteArray();
    }

    public void a(WorldClient var1, EntityPlayer var2, Set<UUID> var3) {
        if (var1 != null && var2 != null) {
            ArrayList arraylist = new ArrayList();
            this.bB();
            this.a(new S41PacketServerDifficulty(var1.getDifficulty(), false), EnumConnectionState.PLAY);
            this.a(new f(var1.getSpawnPoint()), EnumConnectionState.PLAY);
            this.a(new S44PacketWorldBorder(var1.getWorldBorder(), Action.INITIALIZE), EnumConnectionState.PLAY);
            this.a(
                new S03PacketTimeUpdate(var1.getTotalWorldTime(), var1.getWorldTime(), var1.getGameRules().getBoolean("doDaylightCycle")),
                EnumConnectionState.PLAY
            );
            this.a(
                new S06PacketUpdateHealth(var2.getHealth(), var2.getFoodStats().getFoodLevel(), var2.getFoodStats().getSaturationLevel()),
                EnumConnectionState.PLAY
            );
            this.a(new k(var2.inventory.currentItem), EnumConnectionState.PLAY);
            this.a(new S39PacketPlayerAbilities(var2.capabilities), EnumConnectionState.PLAY);
            this.a(new ag(var2.experience, var2.experienceTotal, var2.experienceLevel), EnumConnectionState.PLAY);
            this.b(var2);
            if (!this.a(var1.getScoreboard())) {
                this.bz();
            }

            this.a(var1, var2);
            this.a(var1, var2, var3, arraylist);
            this.b(arraylist);
            this.a(
                new S08PacketPlayerPosLook(var2.posX, var2.posY, var2.posZ, var2.pl, var2.rotationPitch, EnumSet.noneOf(EnumFlags.class)),
                EnumConnectionState.PLAY
            );
        }
    }

    public String bE() {
        if (aEg.getNetHandler() == null && aEg.theWorld == null) {
            return "[]";
        }

        StringBuilder stringbuilder = new StringBuilder("[");
        LinkedHashSet linkedhashset = new LinkedHashSet();
        int k_hi = 1;
        if (aEg.getNetHandler() != null) {
            Iterator iterator = aEg.getNetHandler().getPlayerInfoMap().iterator();

            while (iterator.hasNext()) {
                NetworkPlayerInfo networkplayerinfo = (NetworkPlayerInfo)iterator.next();
                if (networkplayerinfo != null && networkplayerinfo.getGameProfile() != null && networkplayerinfo.getGameProfile().getId() != null) {
                    linkedhashset.add(networkplayerinfo.getGameProfile().getId());
                }
            }
        }

        if (aEg.theWorld != null) {
            Iterator iterator1 = aEg.theWorld.playerEntities.iterator();

            while (iterator1.hasNext()) {
                EntityPlayer entityplayer = (EntityPlayer)iterator1.next();
                if (entityplayer != null && entityplayer.getGameProfile() != null && entityplayer.getGameProfile().getId() != null) {
                    linkedhashset.add(entityplayer.getGameProfile().getId());
                }
            }
        }

        for (Iterator iterator2 = linkedhashset.iterator(); iterator2.hasNext(); k_hi = 0) {
            UUID uuid = (UUID)iterator2.next();
            if (k_hi == 0) {
                stringbuilder.append(',');
            }

            stringbuilder.append('"').append(uuid.toString()).append('"');
        }

        stringbuilder.append((char)('A' ^ '\u001c'));
        return stringbuilder.toString();
    }

    public void bB() {
        if (aEg.thePlayer != null) {
            this.eM = true;
            this.a(new net.minecraft.network.play.server.n(aEg.thePlayer), EnumConnectionState.PLAY);
            this.a(new ad(aEg.thePlayer.getEntityId(), aEg.thePlayer.getDataWatcher(), true), EnumConnectionState.PLAY);
            this.a(
                new net.minecraft.network.play.server.aa(aEg.thePlayer, (byte)(aEg.thePlayer.getRotationYawHead() * 256.0F / 360.0F)), EnumConnectionState.PLAY
            );
            this.a(
                new S16PacketEntityLook(
                    aEg.thePlayer.getEntityId(),
                    (byte)(aEg.thePlayer.renderYawOffset * 256.0F / 360.0F),
                    (byte)(aEg.thePlayer.rotationPitch * 256.0F / 360.0F),
                    aEg.thePlayer.onGround
                ),
                EnumConnectionState.PLAY
            );
            BaseAttributeMap baseattributemap = aEg.thePlayer.getAttributeMap();
            if (baseattributemap != null) {
                this.a(new S20PacketEntityProperties(aEg.thePlayer.getEntityId(), baseattributemap.getAllAttributes()), EnumConnectionState.PLAY);
            }

            this.c(aEg.thePlayer);

            for (int i = 0; i < 5; i++) {
                ItemStack itemstack = aEg.thePlayer.getEquipmentInSlot(i);
                if (itemstack != null) {
                    this.a(new e(aEg.thePlayer.getEntityId(), i, itemstack), EnumConnectionState.PLAY);
                }

                this.eU[i] = ItemStack.copyItemStack(itemstack);
            }

            Iterator iterator = aEg.thePlayer.getActivePotionEffects().iterator();

            while (iterator.hasNext()) {
                PotionEffect potioneffect = (PotionEffect)iterator.next();
                this.a(new net.minecraft.network.play.server.ae(aEg.thePlayer.getEntityId(), potioneffect), EnumConnectionState.PLAY);
            }

            this.eN = (int)Math.floor(aEg.thePlayer.posX * 32.0);
            this.eO = (int)Math.floor(aEg.thePlayer.posY * 32.0);
            this.eP = (int)Math.floor(aEg.thePlayer.posZ * 32.0);
            this.eQ = (byte)(aEg.thePlayer.renderYawOffset * 256.0F / 360.0F);
            this.eR = (byte)(aEg.thePlayer.rotationPitch * 256.0F / 360.0F);
            this.eS = (byte)(aEg.thePlayer.getRotationYawHead() * 256.0F / 360.0F);
            this.eT = aEg.thePlayer.getDataWatcher().getWatchableObjectByte(0);
            this.eV = ItemStack.copyItemStack(aEg.thePlayer.inventory.getCurrentItem());
            this.eW = aEg.thePlayer.isSwingInProgress;
            this.eX = aEg.thePlayer.swingProgressInt;
            this.eY = true;
        }
    }

    public Packet<?> b(Entity var1) {
        try {
            if (var1 instanceof EntityPlayer) {
                return new net.minecraft.network.play.server.n((EntityPlayer)var1);
            }

            if (this.ez == null) {
                this.ez = EntityTrackerEntry.class.getDeclaredMethod("Wd");
                this.ez.setAccessible(true);
            }

            return (Packet<?>)this.ez.invoke(new EntityTrackerEntry(var1, 0, 0, true));
        } catch (Exception exception) {
            return null;
        }
    }

    public void bw() {
        if (this.bu()) {
            WorldClient worldclient = aEg.theWorld;
            NetHandlerPlayClient nethandlerplayclient = aEg.getNetHandler();
            HashSet hashset = new HashSet();
            this.fd = Math.max(0, (int)(System.currentTimeMillis() - this.fa));

            try {
                this.a(new S02PacketLoginSuccess(new GameProfile(ev, "Player")), EnumConnectionState.LOGIN);
                this.a(worldclient, nethandlerplayclient, hashset);
                this.a(this.bG(), EnumConnectionState.PLAY);
                this.a(this.bx(), EnumConnectionState.PLAY);
                this.a(this.by(), EnumConnectionState.PLAY);
                this.a(worldclient, aEg.thePlayer, hashset);
            } catch (Throwable throwable) {
                this.fd = -1;
                throw throwable;
            }

            this.fd = -1;
        }
    }

    public void a(GameProfile var1, int var2, GameType var3, IChatComponent var4) {
        if (this.a(var1)) {
            this.b(var1);
            this.eC.add(var1.getId());
            S38PacketPlayerListItem s38packetplayerlistitem = new S38PacketPlayerListItem(
                net.minecraft.network.play.server.S38PacketPlayerListItem.Action.ADD_PLAYER, Collections.emptyList()
            );
            List list = s38packetplayerlistitem.getEntries();
            S38PacketPlayerListItem s38packetplayerlistitem1 = s38packetplayerlistitem;
            Objects.requireNonNull(s38packetplayerlistitem);
            list.add(new AddPlayerData(s38packetplayerlistitem1, var1, var2, var3 != null ? var3 : GameType.SURVIVAL, var4));
            this.a(s38packetplayerlistitem, EnumConnectionState.PLAY);
        }
    }

    public boolean a(Scoreboard var1) {
        if (var1 == null) {
            return false;
        }

        int i1_hi = 0;
        HashSet hashset = new HashSet();
        Iterator iterator2 = var1.getScoreObjectives().iterator();

        while (iterator2.hasNext()) {
            ScoreObjective scoreobjective = (ScoreObjective)iterator2.next();
            if (scoreobjective != null && scoreobjective.getName() != null && hashset.add(scoreobjective.getName())) {
                this.a(new S3BPacketScoreboardObjective(scoreobjective, 0), EnumConnectionState.PLAY);
                i1_hi = 1;
            }
        }

        for (int i = 0; i < 19; i = i + 1) {
            ScoreObjective scoreobjective1 = var1.getObjectiveInDisplaySlot(i);
            if (scoreobjective1 != null) {
                this.a(new net.minecraft.network.play.server.bq(i, scoreobjective1), EnumConnectionState.PLAY);
                i1_hi = 1;
            }
        }

        Iterator iterator = var1.getScores().iterator();

        while (iterator.hasNext()) {
            Score score = (Score)iterator.next();
            if (score != null && score.getObjective() != null) {
                this.a(new S3CPacketUpdateScore(score), EnumConnectionState.PLAY);
                i1_hi = 1;
            }
        }

        Iterator iterator1 = var1.getTeams().iterator();

        while (iterator1.hasNext()) {
            ScorePlayerTeam scoreplayerteam = (ScorePlayerTeam)iterator1.next();
            if (scoreplayerteam != null) {
                this.a(new S3EPacketTeams(scoreplayerteam, 0), EnumConnectionState.PLAY);
                i1_hi = 1;
            }
        }

        return (i1_hi) != 0;
    }

    public void b(Packet<?> var1, EnumConnectionState var2, byte[] var3) {
        if (var2 == EnumConnectionState.PLAY && var1 != null) {
            if (var1 instanceof S01PacketJoinGame) {
                this.bA();
            } else if (var1 instanceof S3BPacketScoreboardObjective
                || var1 instanceof S3CPacketUpdateScore
                || var1 instanceof net.minecraft.network.play.server.bq
                || var1 instanceof S3EPacketTeams) {
                byte[] abyte = var3 != null && var3.length > 0 ? var3 : this.b(var1, var2);
                if (abyte != null && abyte.length != 0) {
                    synchronized (this.ey) {
                        this.eB.add(abyte);
                        this.eE += abyte.length;

                        while (this.eE > 262144 && !this.eB.isEmpty()) {
                            byte[] abyte1 = this.eB.remove(0);
                            this.eE -= abyte1.length;
                        }
                    }
                }
            }
        }
    }

    public S07PacketRespawn by() {
        WorldClient worldclient = aEg.theWorld;
        EntityPlayerSP entityplayersp = aEg.thePlayer;
        return new S07PacketRespawn(entityplayersp.dimension, worldclient.getDifficulty(), worldclient.getWorldType(), this.a(worldclient));
    }

    public void d(Packet<?> var1, EnumConnectionState var2) {
        if (var2 == EnumConnectionState.PLAY && var1 instanceof S38PacketPlayerListItem s38packetplayerlistitem) {
            net.minecraft.network.play.server.S38PacketPlayerListItem.Action action = s38packetplayerlistitem.getAction();
            Iterator iterator = s38packetplayerlistitem.getEntries().iterator();

            while (iterator.hasNext()) {
                AddPlayerData addplayerdata = (AddPlayerData)iterator.next();
                if (addplayerdata != null && addplayerdata.getProfile() != null && addplayerdata.getProfile().getId() != null) {
                    if (action == net.minecraft.network.play.server.S38PacketPlayerListItem.Action.REMOVE_PLAYER) {
                        this.eC.remove(addplayerdata.getProfile().getId());
                    } else {
                        if (action == net.minecraft.network.play.server.S38PacketPlayerListItem.Action.ADD_PLAYER && this.a(addplayerdata.getProfile())) {
                            this.b(addplayerdata.getProfile());
                        }

                        this.eC.add(addplayerdata.getProfile().getId());
                    }
                }
            }
        }
    }

    public GameType a(World var1) {
        if (aEg.playerController != null && aEg.playerController.getCurrentGameType() != null) {
            return aEg.playerController.getCurrentGameType();
        }
        return var1 != null && var1.getWorldInfo() != null && var1.getWorldInfo().getGameType() != null
            ? var1.getWorldInfo().getGameType()
            : GameType.SURVIVAL;
    }

    public void b(List<GameProfile> var1) {
        if (var1 != null && !var1.isEmpty()) {
            HashSet hashset = new HashSet();
            Iterator iterator = var1.iterator();

            while (iterator.hasNext()) {
                GameProfile gameprofile = (GameProfile)iterator.next();
                if (this.a(gameprofile) && hashset.add(gameprofile.getId())) {
                    this.eC.remove(gameprofile.getId());
                    S38PacketPlayerListItem s38packetplayerlistitem = new S38PacketPlayerListItem(
                        net.minecraft.network.play.server.S38PacketPlayerListItem.Action.REMOVE_PLAYER, Collections.emptyList()
                    );
                    List list = s38packetplayerlistitem.getEntries();
                    S38PacketPlayerListItem s38packetplayerlistitem1 = s38packetplayerlistitem;
                    Objects.requireNonNull(s38packetplayerlistitem);
                    list.add(new AddPlayerData(s38packetplayerlistitem1, gameprofile, 0, GameType.SURVIVAL, null));
                    this.a(s38packetplayerlistitem, EnumConnectionState.PLAY);
                }
            }
        }
    }

    public void bF() {
        this.eC.clear();
        this.eD.clear();
    }

    public void b(EntityPlayer var1) {
        if (var1 != null && var1.inventoryContainer != null) {
            this.a(new S30PacketWindowItems(var1.inventoryContainer.windowId, var1.inventoryContainer.getInventory()), EnumConnectionState.PLAY);
        }
    }

    public void a(S38PacketPlayerListItem var1) {
        if (var1 != null) {
            net.minecraft.network.play.server.S38PacketPlayerListItem.Action action = var1.getAction();
            Iterator iterator = var1.getEntries().iterator();

            while (iterator.hasNext()) {
                AddPlayerData addplayerdata = (AddPlayerData)iterator.next();
                if (addplayerdata != null && addplayerdata.getProfile() != null && addplayerdata.getProfile().getId() != null) {
                    if (action == net.minecraft.network.play.server.S38PacketPlayerListItem.Action.ADD_PLAYER) {
                        this.b(addplayerdata.getProfile());
                        this.eC.add(addplayerdata.getProfile().getId());
                    } else if (!this.eC.contains(addplayerdata.getProfile().getId())) {
                        GameProfile gameprofile = this.a(addplayerdata.getProfile().getId(), addplayerdata.getProfile().getName());
                        if (gameprofile != null) {
                            this.a(
                                gameprofile,
                                0,
                                this.a(aEg.theWorld),
                                (net.minecraft.network.play.server.S38PacketPlayerListItem.Action)action
                                        == net.minecraft.network.play.server.S38PacketPlayerListItem.Action.UPDATE_DISPLAY_NAME
                                    ? addplayerdata.getDisplayName()
                                    : null
                            );
                        }
                    }
                }
            }
        }
    }

    public static Object o0Oo000O0oO(Object[] var0) {
        try {
            int i = (Integer)var0[1];
            String s = (String)var0[2];
            Object object17 = var0[0];
            Object secretkeyspec = oO00O0OO0ooO;
            if (oO00O0OO0ooO == null) {
                secretkeyspec = oO00O0OO0ooO = new Object[1];
            }

            secretkeyspec = ((Object[])secretkeyspec)[i];
            if (secretkeyspec == null) {
                secretkeyspec = (Object[])object17;
                if ((Object[])object17 == null) {
                    secretkeyspec = fld_0OOOoo00o0_12 = new Object[1];
                    byte[] abyte = new byte[16];
                    abyte[5] = -81;
                    abyte[10] = -125;
                    abyte[2] = 68;
                    abyte[14] = 40;
                    abyte[12] = 3;
                    abyte[4] = 81;
                    abyte[1] = -117;
                    abyte[15] = 110;
                    abyte[6] = 5;
                    abyte[0] = 80;
                    abyte[11] = 111;
                    abyte[3] = 35;
                    abyte[7] = 79;
                    abyte[13] = 99;
                    abyte[9] = 37;
                    abyte[8] = 57;
                    ((Object[])secretkeyspec)[0] = abyte;
                }

                byte[] abyte1 = (byte[])((Object[])secretkeyspec)[0];
                if (Oo0o00000O00 == null) {
                    byte[] abyte2 = new byte[32];
                    abyte2[10] = 10;
                    abyte2[13] = 96;
                    abyte2[5] = -55;
                    abyte2[16] = 104;
                    abyte2[24] = 90;
                    abyte2[17] = -32;
                    abyte2[21] = 43;
                    abyte2[20] = 71;
                    abyte2[14] = 103;
                    abyte2[6] = 117;
                    abyte2[29] = 123;
                    abyte2[31] = -109;
                    abyte2[26] = -64;
                    abyte2[2] = -102;
                    abyte2[12] = -64;
                    abyte2[28] = 115;
                    abyte2[22] = -49;
                    abyte2[23] = -125;
                    abyte2[3] = -6;
                    abyte2[27] = 77;
                    abyte2[0] = 93;
                    abyte2[18] = -65;
                    abyte2[15] = 24;
                    abyte2[19] = -110;
                    abyte2[30] = 27;
                    abyte2[4] = 117;
                    abyte2[8] = -90;
                    abyte2[9] = 29;
                    abyte2[1] = 15;
                    abyte2[25] = -75;
                    abyte2[11] = 28;
                    abyte2[7] = 23;
                    byte[] abyte3 = new byte[abyte1.length + abyte2.length];
                    System.arraycopy(abyte1, 0, abyte3, 0, abyte1.length);
                    System.arraycopy(abyte2, 0, abyte3, abyte1.length, abyte2.length);
                    secretkeyspec = mth_0OOOoo00o0_5()[1];
                    if (secretkeyspec == null) {
                        char[] achar = "ᝎ\u1754ᝋᝒ\u1758ᚤᝇ\u1775ᝢ\u1776\u1756ᝩ\u177dᝳᝃ\u1756\u175dᚭ".toCharArray();

                        for (int j = 0; j < 18; j++) {
                            char c0 = achar[j];
                            int k = c0 - 27365;
                            int l = k - 8615;
                            int i1 = l + 49001;
                            int j1 = i1 + 52329;
                            int k1 = j1 + 37770;
                            int l1 = k1 - 13997;
                            int i2 = l1 - 41777;
                            int j2 = i2 + 14389;
                            int k2 = j2 + 16472;
                            int l2 = k2 ^ 6491;
                            int i3 = l2 + 27227;
                            int j3 = i3 + 10430;
                            int k3 = j3 - 58463;
                            achar[j] = (char)k3;
                        }

                        secretkeyspec = mth_0OOOoo00o0_5()[1] = new String(achar);
                    }

                    SecretKeyFactory secretkeyfactory = SecretKeyFactory.getInstance((String)secretkeyspec);
                    byte[] abyte4 = new byte[16];
                    abyte4[4] = -113;
                    abyte4[3] = 112;
                    abyte4[9] = 36;
                    abyte4[12] = -83;
                    abyte4[13] = -96;
                    abyte4[0] = -45;
                    abyte4[6] = 13;
                    abyte4[8] = -105;
                    abyte4[11] = -10;
                    abyte4[7] = 76;
                    abyte4[5] = 113;
                    abyte4[2] = 73;
                    abyte4[14] = 6;
                    abyte4[1] = 117;
                    abyte4[10] = 100;
                    abyte4[15] = 86;
                    PBEKeySpec pbekeyspec = new PBEKeySpec(new String(abyte3, StandardCharsets.UTF_8).toCharArray(), abyte4, 11, 256);
                    byte[] abyte5 = secretkeyfactory.generateSecret(pbekeyspec).getEncoded();
                    byte[] abyte10 = abyte5;
                    Object object19 = mth_0OOOoo00o0_5()[2];
                    if (object19 == null) {
                        char[] achar1 = "亖今令".toCharArray();

                        for (int l3 = 0; l3 < 3; l3++) {
                            char c1 = achar1[l3];
                            int i4 = c1 + 'ꌂ';
                            int j4 = i4 + 13188;
                            int k4 = j4 ^ 11337;
                            int l4 = k4 - 4041;
                            int i5 = l4 - 45292;
                            int j5 = i5 + 65201;
                            int k5 = j5 + 55763;
                            int l5 = k5 + 5139;
                            int i6 = l5 + 21555;
                            int j6 = i6 + 39636;
                            int k6 = j6 ^ 14324;
                            int l6 = k6 ^ 8086;
                            int i7 = l6 - 3099;
                            achar1[l3] = (char)i7;
                        }

                        object19 = mth_0OOOoo00o0_5()[2] = new String(achar1);
                    }

                    secretkeyspec = new SecretKeySpec(abyte10, (String)object19);
                    Oo0o00000O00 = secretkeyspec;
                }

                byte[] abyte6 = Base64.getDecoder().decode(s);
                byte[] abyte7 = Arrays.copyOfRange(abyte6, 0, 16);
                byte[] abyte8 = Arrays.copyOfRange(abyte6, 16, abyte6.length);
                Object object18 = mth_0OOOoo00o0_5()[3];
                if (object18 == null) {
                    char[] achar2 = "缗绫缙绵绩绦绩绵缔缑绩缙绻缔肷脈脈胿育脍".toCharArray();

                    for (byte b0 = 0; b0 < 20; b0 += 1) {
                        char c2 = achar2[b0];
                        int j7 = c2 - 31648;
                        int k7 = j7 - 19522;
                        int l7 = k7 + 11972;
                        int i8 = l7 ^ 65318;
                        int j8 = i8 - 58119;
                        int k8 = j8 + 5944;
                        int l8 = k8 ^ 39177;
                        int i9 = l8 + 30170;
                        int j9 = i9 + 40316;
                        int k9 = j9 - 7372;
                        int l9 = k9 + 23324;
                        int i10 = l9 ^ 10238;
                        achar2[b0] = (char)i10;
                    }

                    object18 = mth_0OOOoo00o0_5()[3] = new String(achar2);
                }

                Cipher cipher = Cipher.getInstance((String)object18);
                cipher.init(2, (SecretKey)Oo0o00000O00, new IvParameterSpec(abyte7));
                byte[] abyte9 = cipher.doFinal(abyte8);
                secretkeyspec = oO00O0OO0ooO[i] = new String(abyte9, StandardCharsets.UTF_8);
            }

            return secretkeyspec;
        } catch (java.security.GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    public void bz() {
        ArrayList arraylist;
        synchronized (this.ey) {
            if (this.eB.isEmpty()) {
                return;
            }

            arraylist = new ArrayList<>(this.eB);
        }

        for (byte[] abyte : (Iterable<byte[]>)arraylist) {
            this.a(abyte);
        }
    }

    public void bv() {
        long k;
        byte[] abyte;
        String s;
        String s1;
        long l;
        synchronized (this.ex) {
            if (!this.eF || this.fe == null) {
                return;
            }

            this.eF = false;
            k = System.currentTimeMillis() - this.fa;
            abyte = this.fe.toByteArray();
            s = this.eZ;
            s1 = this.fc;
            l = this.fa;

            try {
                this.ff.close();
            } catch (IOException ioexception) {
            }

            this.ff = null;
            this.fe = null;
            this.eZ = null;
            this.eG = false;
            this.eH = false;
            this.eI = 0L;
            this.eK = false;
            this.eL = false;
            this.bF();
            this.eM = false;
            this.eY = false;
            Arrays.fill(this.eU, null);
            this.eV = null;
            this.eW = false;
            this.eX = 0;
            this.eJ = false;
            this.fd = -1;
        }

        if (abyte.length != 0) {
            Thread thread = new Thread(() -> {

                try {
                    byte[] abytex = this.a(abyte, s, k, l);
                    this.a(s1, abytex, s);
                } catch (IOException ioexceptionx) {
                }
            }, "ReplayUpload");
            thread.setDaemon((93 + -92) != 0);
            thread.start();
        }
    }

    public byte[] b(Packet<?> var1, EnumConnectionState var2) {
        if (var1 != null && var2 != null) {
            Integer integer = var2.getPacketId(EnumPacketDirection.CLIENTBOUND, var1);
            if (integer == null) {
                return null;
            }

            PacketBuffer packetbuffer = new PacketBuffer(Unpooled.buffer());

            byte[] abyte1;
            label41: {
                Object object4;
                try {
                    try {
                        packetbuffer.writeVarIntToBuffer(integer);
                        var1.writePacketData(packetbuffer);
                        byte[] abyte = new byte[packetbuffer.readableBytes()];
                        packetbuffer.readBytes(abyte);
                        abyte1 = abyte;
                        break label41;
                    } catch (Exception exception) {
                        object4 = null;
                    }
                } catch (Throwable throwable) {
                    packetbuffer.release();
                    throw throwable;
                }

                packetbuffer.release();
                return (byte[])object4;
            }

            packetbuffer.release();
            return abyte1;
        }
        return null;
    }

    public void a(Packet<?> var1, EnumConnectionState var2) {
        byte[] abyte = this.b(var1, var2);
        if (abyte != null && abyte.length != 0) {
            this.a(abyte);
        }
    }

    static {
        int k3_hi = 0;
        Object[] achar3 = new Object[]{fld_0OOOoo00o0_12, 0, null};
        Object object3 = mth_0OOOoo00o0_5()[0];
        if (object3 == null) {
            char[] achar = "⁍₈₎⁊⁌ₒ₉⁺\u209d\u206c₁\u209f\u209e⁓₁₋\u206a\u206d⁓\u2069⁵\u209d⁵⁵⁙\u2069\u206f\u206a₁⁌⁴‹₣₈\u206e₡⁒ₒₓ₁⁎⁺⁍ₗ₈⁶⁸ₕₗ₃ₓ₠\u206e⁒₌\u206d₊ₗₒ\u2069ₜ\u206d\u2061⁒⁍ₚ₍\u2073₊‸₡⁌\u206a⁏ⁿ⁵⁶₊ₓ₃\u2064\u208f‹⁕₊ₔ₊₡₍\u206a₈⁘₍⁹‹‹⁹\u206d⁎⁓⁕⁵⁶⁵ₓₚ⁶⁋ₔ\u209d⁻ₗ₠⁻⁼⁙\u209e⁾₎⁼₡\u206d₁\u206d₉⁕⁍⁏ₜ⁏\u2064\u209e\u2068₉\u206c\u2072⁊⁓\u2061⁋ⁿ\u206c⁌₌\u206f\u209d⁸\u206e\u206d₠\u2072⁽₁⁷ₚ\u206f₌⁍\u206dⁿ⁘ⁿ⁹₊⁍ₗ\u2072₠ₕ₉₈⁺⁒⁾₍₣⁍\u206a\u206c₍₍⁓⁋\u209e⁾⁙⁴\u208f⁺⁘\u209f⁕₌ₗ\u206dₓ⁽\u2064⁵⁏⁼\u206c\u206b₊₍⁴\u206e₎\u206c⁊⁷₎₃₠\u206bₚₜₚ⁘⁋₌₉\u209f‸\u2069\u209f\u2073ₛ⁽₌⁍\u2068⁶⁒⁻₃⁊⁸₋⁓⁏⁼⁺₁\u2064⁊ₜ₁⁷⁼⁓‸⁙\u208f⁙‹₠₄⁽⁙₄⁻\u209e₀\u209eₚₕ\u2069ₖ₣ₓ₡⁓\u206c\u209f₈⁎⁴⁵‸ⁿ⁙₉⁼\u206a⁎\u2069₎ₛ⁒\u206e⁶⁍ₚ\u206e⁺⁹⁏ₕₚ\u2069ₒ⁎⁌₌‹\u208f\u2068\u206d⁺ₓₜ⁽₌\u209d⁶ₖ₊₃\u2061\u206fₚ\u2068⁼\u206e\u208fₓ\u2069₀⁊⁊⁘\u209e⁾\u208f₉\u206e⁺⁾ₒ₊\u209eₔⁿ₉⁒ₚ⁍\u209d⁘⁾₋⁌\u206e⁒₠⁵⁶⁏ₖ\u2061\u209e⁘\u2069₠\u209e⁼\u209e⁒₌\u209d₄⁹⁹\u2069\u209d₀⁵₌₋ₔ⁼⁽ⁿ⁙₁₉ₖ\u208f⁹\u208f⁊\u206fₓ⁌⁵⁓⁕\u206c₊⁴₀ₔ₍⁹ₛ⁻₈\u2068\u206c₌⁴⁕₁\u209e⁷\u206e₊⁕₌⁻ₒₜ⁼⁋\u2072ₔ₍\u208f₀⁸⁍ₖ⁙⁼ₒ₎\u206d₈\u2073ₓ⁕ⁿ⁽\u209d⁙⁏ₗ\u2073₎₡⁙₣₈\u206b₊⁽⁊₈ₔ⁹⁍\u2072\u208f⁕\u209d⁙⁻\u208f\u206e\u206a₎ₓ\u2073ₓ₉\u2072\u2068⁌ₚ₀⁒⁕⁙₈\u2061⁕₣⁌⁕ₛ⁾⁷⁓\u206b\u206c⁹₡₎⁼⁶ₖ⁋⁾₊\u206a₁₣\u206f⁌⁌ₕ⁾⁕₌‸₌\u2068⁓⁷₊⁓₌₠⁋⁺₈₍ₔₔ\u209e⁎⁾\u209e⁓ₖ\u2072⁙‸⁵⁺ₖ\u2073\u209eₕ₄ₜ\u2064₀ₜ⁶⁸⁏ₗ\u2069⁌⁾\u2064₣\u206b⁹ₕ\u208f\u206c\u206b⁏₉⁊₡⁷₄⁍⁍⁋\u206b₈₣ₕ\u2064⁻₣⁵‹\u2072ⁿ\u206e⁍ₖ⁹ₖ₀‸⁸ₔ\u2064⁕⁌⁺\u206b₠\u206f⁏⁵\u209d⁽ₜ\u206c⁶⁷₈\u2064⁍⁎₡₊₁⁙\u209d⁵₍₠\u206d₉⁒‹‹ₖ₄⁕₄⁓\u206f₃₍\u2073ₖ\u209fₒ⁒₄₣ₚ⁒⁽\u206e\u2072⁾₊\u206f₋⁊⁏⁘⁼\u209e\u2068⁵₋⁺₌⁕⁻\u206e⁷⁋⁒⁎\u2073\u206aₜ\u209e\u2061⁎\u209eₗ\u206f\u209d‹⁒⁒⁏\u206f₡⁇"
                .toCharArray();

            for (int b0 = 0; b0 < 684; b0 += 1) {
                char c0 = achar[b0];
                int l3 = c0 + '\uf883';
                int i4 = l3 + 50660;
                int j4 = i4 - 48101;
                int k4 = j4 - 13158;
                int l4 = k4 ^ 8714;
                int i5 = l4 + 35018;
                int j5 = i5 - 10314;
                int k5 = j5 - 15726;
                int l5 = k5 - 4337;
                int i6 = l5 - 63571;
                int j6 = i6 + 1652;
                int k6 = j6 ^ 2038;
                int l6 = k6 ^ 41626;
                int i7 = l6 ^ 18682;
                achar[b0] = (char)i7;
            }

            object3 = mth_0OOOoo00o0_5()[0] = new String(achar);
        }

        achar3[2] = object3;
        char[] achar2 = ((String)o0Oo000O0oO(achar3)).toCharArray();
        int limit = 484;
        int i = 0;

        while (i < limit) {
            int j8 = i;
            int i2 = i + 1;
            int i2_lo = achar2[j8];
            j8 = i2;
            int i3 = i2 + 1;
            int j2_hi = achar2[j8];
            int limit2 = i2_lo << 16 | j2_hi;
            char[] achar1 = new char[limit2];

            for (int j = 0; j < limit2; j++) {
                achar1[j] = achar2[i3 + j];
            }

            j8 = k3_hi;
            k3_hi++;
            o0Oo000O0oO[j8] = new String(achar1);
            i = i3 + limit2;
        }

        ev = UUID.fromString("d41d8cd9-8f00-3204-a980-0998ecf8427e");
    }

    public void b(GameProfile var1) {
        if (this.a(var1)) {
            this.eD.put(var1.getId(), var1);
        }
    }

    public void bD() {
        if (aEg.thePlayer != null) {
            if (!this.eY) {
                this.a(new z(aEg.thePlayer), EnumConnectionState.PLAY);
            } else {
                int floor2 = (int)Math.floor(aEg.thePlayer.posX * 32.0);
                int floor3 = (int)Math.floor(aEg.thePlayer.posY * 32.0);
                int floor4 = (int)Math.floor(aEg.thePlayer.posZ * 32.0);
                int renderYawOffset2 = (byte)(aEg.thePlayer.renderYawOffset * 256.0F / 360.0F);
                int rotationPitch2 = (byte)(aEg.thePlayer.rotationPitch * 256.0F / 360.0F);
                int rotationYawHead = (byte)(aEg.thePlayer.getRotationYawHead() * 256.0F / 360.0F);
                int dJ4 = floor2 - this.eN;
                int i5_lo = floor3 - this.eO;
                int dK4 = floor4 - this.eP;
                int notFlag = dJ4 == 0 && i5_lo == 0 && dK4 == 0 ? 0 : 1;
                int notFlag2 = renderYawOffset2 == this.eQ && rotationPitch2 == this.eR ? 0 : 1;
                if (dJ4 < -128 || dJ4 > 127 || i5_lo < -128 || i5_lo > 127 || dK4 < -128 || dK4 > 127) {
                    this.a(new z(aEg.thePlayer), EnumConnectionState.PLAY);
                } else if (notFlag != 0 && notFlag2 != 0) {
                    this.a(
                        new S17PacketEntityLookMove(
                            aEg.thePlayer.getEntityId(),
                            (byte)dJ4,
                            (byte)i5_lo,
                            (byte)dK4,
                            (byte)(renderYawOffset2),
                            (byte)(rotationPitch2),
                            aEg.thePlayer.onGround
                        ),
                        EnumConnectionState.PLAY
                    );
                } else if (notFlag != 0) {
                    this.a(
                        new S15PacketEntityRelMove(aEg.thePlayer.getEntityId(), (byte)dJ4, (byte)i5_lo, (byte)dK4, aEg.thePlayer.onGround),
                        EnumConnectionState.PLAY
                    );
                } else if (notFlag2 != 0) {
                    this.a(
                        new S16PacketEntityLook(aEg.thePlayer.getEntityId(), (byte)(renderYawOffset2), (byte)(rotationPitch2), aEg.thePlayer.onGround),
                        EnumConnectionState.PLAY
                    );
                }

                if (rotationYawHead != this.eS) {
                    this.a(new net.minecraft.network.play.server.aa(aEg.thePlayer, (byte)(rotationYawHead)), EnumConnectionState.PLAY);
                }

                this.eN = floor2;
                this.eO = floor3;
                this.eP = floor4;
                this.eQ = (byte)(renderYawOffset2);
                this.eR = (byte)(rotationPitch2);
                this.eS = (byte)(rotationYawHead);
            }
        }
    }

    public List<GameProfile> c(Packet<?> var1, EnumConnectionState var2) {
        if (var2 != EnumConnectionState.PLAY || var1 == null) {
            return Collections.emptyList();
        }

        if (var1 instanceof S38PacketPlayerListItem) {
            this.a((S38PacketPlayerListItem)var1);
            return Collections.emptyList();
        }

        if (var1 instanceof net.minecraft.network.play.server.n) {
            GameProfile gameprofile = this.a((net.minecraft.network.play.server.n)var1);
            if (gameprofile != null) {
                return Collections.singletonList(gameprofile);
            }
        }

        return Collections.emptyList();
    }

    public void a(WorldClient var1, EntityPlayer var2, Set<UUID> var3, List<GameProfile> var4) {
        HashSet hashset = new HashSet();
        Iterator iterator = var1.loadedEntityList.iterator();

        while (iterator.hasNext()) {
            Entity entity = (Entity)iterator.next();
            this.a(entity, var2, hashset, var3, var4);
        }

        Iterator iterator1 = var1.playerEntities.iterator();

        while (iterator1.hasNext()) {
            EntityPlayer entityplayer = (EntityPlayer)iterator1.next();
            this.a(entityplayer, var2, hashset, var3, var4);
        }
    }

    public static String h(String var0) {
        return var0 == null ? "" : var0.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    public net.minecraft.network.play.server.cd bG() {
        net.minecraft.network.play.server.cd cd = new net.minecraft.network.play.server.cd(new s(""));

        try {
            Field field = net.minecraft.network.play.server.cd.class.getDeclaredField("bqe");
            field.setAccessible(true);
            field.set(cd, new s(""));
        } catch (Exception exception) {
        }

        while (true) {
            try {
                return cd;
            } catch (Exception exception1) {
            }
        }
    }

    public void bC() {
        if (aEg.thePlayer != null && this.eY) {
            int watchableObjectByte = aEg.thePlayer.getDataWatcher().getWatchableObjectByte(0);
            if (watchableObjectByte != this.eT) {
                this.a(new ad(aEg.thePlayer.getEntityId(), aEg.thePlayer.getDataWatcher(), true), EnumConnectionState.PLAY);
                this.eT = (byte)(watchableObjectByte);
            }

            for (int i = 0; i < this.eU.length; i++) {
                ItemStack itemstack = aEg.thePlayer.getEquipmentInSlot(i);
                if (!ItemStack.areItemStacksEqual(itemstack, this.eU[i])) {
                    this.a(new e(aEg.thePlayer.getEntityId(), i, itemstack), EnumConnectionState.PLAY);
                    this.eU[i] = ItemStack.copyItemStack(itemstack);
                }
            }

            ItemStack itemstack1 = aEg.thePlayer.inventory.getCurrentItem();
            this.eV = ItemStack.copyItemStack(itemstack1);
            int swingProgressInt2 = aEg.thePlayer.swingProgressInt;
            if (aEg.thePlayer.isSwingInProgress && (!this.eW || swingProgressInt2 < this.eX)) {
                this.a(new m(aEg.thePlayer, 0), EnumConnectionState.PLAY);
            }

            this.eW = aEg.thePlayer.isSwingInProgress;
            this.eX = swingProgressInt2;
        }
    }

    public boolean bu() {
        return aEg.theWorld != null && aEg.thePlayer != null && aEg.getNetHandler() != null && aEg.getNetHandler().doneLoadingTerrain;
    }


    public GameProfile a(net.minecraft.network.play.server.n var1) {
        if (var1 != null && var1.agh() != null && !this.eC.contains(var1.agh())) {
            GameProfile gameprofile = this.a(var1.agh(), null);
            if (gameprofile == null) {
                return null;
            }

            this.a(gameprofile, 0, this.a(aEg.theWorld), null);
            return aEg.getNetHandler() != null && aEg.getNetHandler().getPlayerInfo(gameprofile.getId()) != null ? null : gameprofile;
        }
        return null;
    }

    public void c(Entity var1) {
        if (var1 != null) {
            if (var1.motionX != 0.0 || var1.motionY != 0.0 || var1.motionZ != 0.0) {
                this.a(new S12PacketEntityVelocity(var1), EnumConnectionState.PLAY);
            }
        }
    }

    public void a(Entity var1, EntityPlayer var2, Set<Integer> var3, Set<UUID> var4, List<GameProfile> var5) {
        if (var1 != null && var1 != var2 && var1.isEntityAlive() && var3.add(var1.getEntityId())) {
            if (var1 instanceof EntityPlayer entityplayer && this.a(entityplayer.getGameProfile()) && var4.add(entityplayer.getGameProfile().getId())) {
                this.a(entityplayer.getGameProfile(), -94 - -34 - -60, this.a(var1.worldObj), null);
                var5.add(entityplayer.getGameProfile());
            }

            Packet packet = this.b(var1);
            if (packet != null) {
                this.a(packet, EnumConnectionState.PLAY);
                this.a(new ad(var1.getEntityId(), var1.getDataWatcher(), true), EnumConnectionState.PLAY);
                this.c(var1);
                if (var1 instanceof EntityLivingBase entitylivingbase) {
                    this.a(
                        new net.minecraft.network.play.server.aa(entitylivingbase, (byte)(entitylivingbase.getRotationYawHead() * 256.0F / 360.0F)),
                        EnumConnectionState.PLAY
                    );
                    BaseAttributeMap baseattributemap = entitylivingbase.getAttributeMap();
                    if (baseattributemap != null) {
                        this.a(new S20PacketEntityProperties(var1.getEntityId(), baseattributemap.getAllAttributes()), EnumConnectionState.PLAY);
                    }

                    for (int i = 0; i < 5; i++) {
                        if (entitylivingbase.getEquipmentInSlot(i) != null) {
                            this.a(new e(var1.getEntityId(), i, entitylivingbase.getEquipmentInSlot(i)), EnumConnectionState.PLAY);
                        }
                    }

                    Iterator iterator = entitylivingbase.getActivePotionEffects().iterator();

                    while (iterator.hasNext()) {
                        PotionEffect potioneffect = (PotionEffect)iterator.next();
                        this.a(new net.minecraft.network.play.server.ae(var1.getEntityId(), potioneffect), EnumConnectionState.PLAY);
                    }
                }
            }
        }
    }

    public void a(byte[] var1) {
        if (var1 == null || var1.length == 0) {
            return;
        }

        int currentTimeMillis2 = this.fd >= 0 ? this.fd : (int)(System.currentTimeMillis() - this.fa);

        try {
            synchronized (this.ex) {
                if (!this.eF || this.ff == null || this.fe == null) {
                    return;
                }

                this.ff.writeInt(currentTimeMillis2);
                this.ff.writeInt(var1.length);
                this.ff.write(var1);
            }
        } catch (IOException ioexception) {
        }

        if (currentTimeMillis2 > this.fb) {
            this.bv();
        }
    }

    public void bA() {
        synchronized (this.ey) {
            this.eB.clear();
            this.eE = 0;
        }
    }

    public GameProfile a(UUID var1, String var2) {
        if (var1 == null) {
            return null;
        }

        GameProfile gameprofile2 = this.eD.get(var1);
        if (this.a(gameprofile2)) {
            return gameprofile2;
        }

        if (aEg.getNetHandler() != null) {
            NetworkPlayerInfo networkplayerinfo = aEg.getNetHandler().getPlayerInfo(var1);
            if (networkplayerinfo != null && this.a(networkplayerinfo.getGameProfile())) {
                GameProfile gameprofile3 = networkplayerinfo.getGameProfile();
                this.b(gameprofile3);
                return gameprofile3;
            }
        }

        if (aEg.theWorld != null) {
            EntityPlayer entityplayer = aEg.theWorld.getPlayerEntityByUUID(var1);
            if (entityplayer != null && this.a(entityplayer.getGameProfile())) {
                GameProfile gameprofile = entityplayer.getGameProfile();
                this.b(gameprofile);
                return gameprofile;
            }
        }

        String s = this.i(var2 != null ? var2 : this.b(var1));
        if (s == null) {
            return null;
        }

        GameProfile gameprofile1 = new GameProfile(var1, s);
        this.b(gameprofile1);
        return gameprofile1;
    }

    public static Object[] mth_0OOOoo00o0_5() {
        Object[] aobject = fld_0oOOoOo0O00O_11;
        if (fld_0oOOoOo0O00O_11 == null) {
            aobject = fld_0oOOoOo0O00O_11 = new Object[4];
        }

        return aobject;
    }

    public void c(String var1, int var2) {
        if (this.eF) {
            this.bv();
        }

        this.eZ = var1;
        this.fb = var2 * 1000;
        this.fc = aEg.getCurrentServerData() != null ? aEg.getCurrentServerData().serverIP : "unknown";
        this.fe = new ByteArrayOutputStream();
        this.ff = new DataOutputStream(this.fe);
        this.fa = System.currentTimeMillis();
        this.eF = true;
        this.eG = !this.bu();
        this.eH = this.eG;
        this.eI = this.eH ? System.currentTimeMillis() : 0L;
        this.eK = false;
        this.eL = !this.eG;
        this.bF();
        this.eM = false;
        this.eY = false;
        Arrays.fill(this.eU, null);
        this.eV = null;
        this.eW = false;
        this.eX = 0;
        boolean flag1;
        if (!this.eG) {
            flag1 = true;
        } else {
            boolean flag = false;
            flag1 = flag;
        }

        this.eJ = flag1;
        if (!this.eG) {
            this.bw();
            this.eJ = false;
        }
    }

    public void a(WorldClient var1, EntityPlayer var2) {
        long i1 = -5999452370710010159L;
        long j1 = -8132256309763312687L;
        long k1 = 1975227560856581487L;
        HashSet hashset = new HashSet();
        ArrayList arraylist = new ArrayList();

        label100: {
            label95: {
                try {
                    if (this.eA != null) {
                        break label95;
                    }
                } catch (Exception exception8) {
                    break label100;
                }

                try {
                    this.eA = var1.getChunkProvider().getClass().getDeclaredField("chunkListing");
                    this.eA.setAccessible(true);
                } catch (Exception exception7) {
                    break label100;
                }
            }

            List list;
            try {
                list = (List)this.eA.get(var1.getChunkProvider());
                if (list == null) {
                    break label100;
                }
            } catch (Exception exception6) {
                break label100;
            }

            Iterator iterator;
            try {
                iterator = list.iterator();
            } catch (Exception exception3) {
                break label100;
            }

            while (true) {
                try {
                    if (!iterator.hasNext()) {
                        break;
                    }
                } catch (Exception exception2) {
                    break;
                }

                Chunk chunk;
                try {
                    chunk = (Chunk)iterator.next();
                    if (chunk == null) {
                        continue;
                    }
                } catch (Exception exception5) {
                    break;
                }

                try {
                    if (!hashset.add((long)chunk.xPosition << 32 ^ chunk.zPosition & 4294967295L)) {
                        continue;
                    }
                } catch (Exception exception4) {
                    break;
                }

                try {
                    arraylist.add(chunk);
                } catch (Exception exception1) {
                    break;
                }
            }
        }

        while (true) {
            long j2 = (long)Math.min(aEg.gameSettings.renderDistanceChunks + 1, 8) << 32;
            long i2 = j1;
            j2 ^= j1;
            long k2 = -1L;
            byte b0 = 11;
            byte b1 = 121;

            try {
                j1 = i2 ^ j2 & k2 << (b0 - b1 ^ -78);

                for (i1 ^= ((long)(var2.chunkCoordX - (int)(j1 >>> 32)) << 32 ^ i1) & -1L << 32;
                    (int)(i1 >>> 32) <= var2.chunkCoordX + (int)(j1 >>> 32);
                    i1 += 4294967296L
                ) {
                    for (k1 ^= ((long)(var2.chunkCoordZ - (int)(j1 >>> 32)) << 32 ^ k1) & -1L << 32;
                        (int)(k1 >>> 32) <= var2.chunkCoordZ + (int)(j1 >>> 32);
                        k1 += 4294967296L
                    ) {
                        long l1 = (long)((int)(i1 >>> 32)) << 32 ^ (int)(k1 >>> 32) & 4294967295L;
                        if (hashset.add(l1)) {
                            Chunk chunk1 = var1.getChunkFromChunkCoords((int)(i1 >>> 32), (int)(k1 >>> 32));
                            if (chunk1 != null) {
                                arraylist.add(chunk1);
                            }
                        }
                    }
                }

                if (arraylist.isEmpty()) {
                    return;
                }

                i1 ^= (274877906944L ^ i1) & -1L << 32;

                for (k1 ^= (0L ^ k1) & -1L << 32; (int)(k1 >>> 32) < arraylist.size(); k1 += 274877906944L) {
                    k1 ^= (Math.min((int)(k1 >>> 32) + 64, arraylist.size()) ^ k1) & -1L >>> 32;
                    this.a(new S26PacketMapChunkBulk(arraylist.subList((int)(k1 >>> 32), (int)k1)), EnumConnectionState.PLAY);
                }

                return;
            } catch (Exception exception) {
            }
        }
    }

    public bo() {
        this.eB = new ArrayList<>();
        this.eC = new HashSet<>();
        this.eD = new HashMap<>();
        this.eU = new ItemStack[5];
        this.fd = -1;
        this.fg = var1 -> {
            if (var1.dd() instanceof rip.vantage.commons.packet.impl.server.monitoring.a) {
                rip.vantage.commons.packet.impl.server.monitoring.a a = (rip.vantage.commons.packet.impl.server.monitoring.a)var1.dd();
                this.c(a.ajm(), a.aJV());
            } else if (var1.dd() instanceof h) {
                h h = (h)var1.dd();
                if (this.eF && h.ajm().equals(this.eZ)) {
                    this.bv();
                }
            }
        };
        this.onTick = var1 -> {
            if (this.eG && this.bu() && this.eH && System.currentTimeMillis() - this.eI > 1500L) {
                this.eJ = true;
                this.bw();
                this.eJ = false;
                this.eH = false;
                this.eG = false;
                this.eK = false;
                this.eL = true;
            }

            if (this.eF && aEg.thePlayer != null) {
                if ("unknown".equals(this.fc) && aEg.getCurrentServerData() != null && aEg.getCurrentServerData().serverIP != null) {
                    this.fc = aEg.getCurrentServerData().serverIP;
                }

                if (this.bu() && !this.eM) {
                    this.bB();
                }

                this.bC();
                this.bD();
            }
        };
        this.onWorldChange = var1 -> {
            this.bA();
            this.bF();
            if (this.eF) {
                this.eM = false;
                this.eY = false;
                Arrays.fill(this.eU, null);
                this.eV = null;
                this.eW = false;
                this.eX = 0;
            }
        };
    }

    public void a(Packet<?> var1, EnumConnectionState var2, byte[] var3) {
        this.b(var1, var2, var3);
        if (this.eF && var2 != null && !this.eJ) {
            if (this.eH) {
                if (var2 != EnumConnectionState.LOGIN || !(var1 instanceof S02PacketLoginSuccess)) {
                    return;
                }

                this.eH = false;
                this.eL = true;
                synchronized (this.ex) {
                    if (this.fe != null && this.fe.size() == 0) {
                        this.fa = System.currentTimeMillis();
                    }
                }
            }

            if (var2 == EnumConnectionState.LOGIN || var2 == EnumConnectionState.PLAY) {
                if (var2 != EnumConnectionState.LOGIN || var1 instanceof S02PacketLoginSuccess) {
                    if (var2 == EnumConnectionState.PLAY && var1 instanceof S01PacketJoinGame) {
                        this.eM = false;
                        this.eY = false;
                        Arrays.fill(this.eU, null);
                        this.eV = null;
                        this.eW = false;
                        this.eX = 0;
                    }

                    if (var1 instanceof net.minecraft.network.play.server.n
                        && aEg.thePlayer != null
                        && aEg.thePlayer.getGameProfile() != null
                        && ((net.minecraft.network.play.server.n)var1).agh().equals(aEg.thePlayer.getGameProfile().getId())) {
                        this.eM = true;
                    }

                    List list = this.c(var1, var2);
                    if (var3 != null && var3.length > 0) {
                        this.a(var3);
                    } else {
                        this.a(var1, var2);
                    }

                    this.d(var1, var2);
                    this.b(list);
                }
            }
        }
    }

    public String i(String var1) {
        if (var1 != null && !var1.isEmpty()) {
            return var1.length() > 16 ? var1.substring(0, 16) : var1;
        }
        return null;
    }

    public S01PacketJoinGame bx() {
        WorldClient worldclient = aEg.theWorld;
        NetHandlerPlayClient nethandlerplayclient = aEg.getNetHandler();
        EntityPlayerSP entityplayersp = aEg.thePlayer;
        return new S01PacketJoinGame(
            entityplayersp.getEntityId(),
            aEg.playerController != null ? aEg.playerController.getCurrentGameType() : worldclient.getWorldInfo().getGameType(),
            worldclient.getWorldInfo().isHardcoreModeEnabled(),
            entityplayersp.dimension,
            worldclient.getDifficulty(),
            nethandlerplayclient.currentServerMaxPlayers,
            worldclient.getWorldType(),
            false
        );
    }

    public String b(UUID var1) {
        String s = var1.toString().replace("-", "");
        String s1 = s.substring(0, Math.min(14, s.length()));
        return "p_" + s1;
    }

    public boolean a(GameProfile var1) {
        return var1 != null && var1.getId() != null && var1.getName() != null;
    }

    public void a(WorldClient var1, NetHandlerPlayClient var2, Set<UUID> var3) {
        if (var2 != null) {
            GameType gametype = this.a(var1);
            Iterator iterator = var2.getPlayerInfoMap().iterator();

            while (iterator.hasNext()) {
                NetworkPlayerInfo networkplayerinfo = (NetworkPlayerInfo)iterator.next();
                if (networkplayerinfo != null && this.a(networkplayerinfo.getGameProfile()) && var3.add(networkplayerinfo.getGameProfile().getId())) {
                    this.a(
                        networkplayerinfo.getGameProfile(),
                        networkplayerinfo.getResponseTime(),
                        networkplayerinfo.getGameType() != null ? networkplayerinfo.getGameType() : gametype,
                        networkplayerinfo.getDisplayName()
                    );
                }
            }

            if (aEg.thePlayer != null && this.a(aEg.thePlayer.getGameProfile()) && var3.add(aEg.thePlayer.getGameProfile().getId())) {
                this.a(aEg.thePlayer.getGameProfile(), 73 + -73, gametype, null);
            }
        }
    }
}
