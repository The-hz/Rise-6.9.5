package com.alan.clients.script.api.wrapper.impl.packet;

import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;
import net.minecraft.network.play.client.C03PacketPlayer.C05PacketPlayerLook;
import net.minecraft.network.play.client.C03PacketPlayer.C06PacketPlayerPosLook;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.network.play.client.C0CPacketInput;
import net.minecraft.network.play.client.C0EPacketClickWindow;
import net.minecraft.network.play.client.C0FPacketConfirmTransaction;
import net.minecraft.network.play.client.C13PacketPlayerAbilities;
import net.minecraft.network.play.client.C14PacketTabComplete;
import net.minecraft.network.play.client.C15PacketClientSettings;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.network.play.client.C17PacketCustomPayload;
import net.minecraft.network.play.client.C18PacketSpectate;
import net.minecraft.network.play.client.C19PacketResourcePackStatus;
import net.minecraft.network.play.client.a;
import net.minecraft.network.play.client.l;
import net.minecraft.network.play.client.m;
import net.minecraft.network.play.client.q;
import net.minecraft.network.play.client.t;
import net.minecraft.network.play.client.u;
import net.minecraft.network.play.client.v;
import net.minecraft.network.play.server.S01PacketJoinGame;
import net.minecraft.network.play.server.S03PacketTimeUpdate;
import net.minecraft.network.play.server.S06PacketUpdateHealth;
import net.minecraft.network.play.server.S07PacketRespawn;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.network.play.server.S0EPacketSpawnObject;
import net.minecraft.network.play.server.S10PacketSpawnPainting;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S13PacketDestroyEntities;
import net.minecraft.network.play.server.S14PacketEntity;
import net.minecraft.network.play.server.S20PacketEntityProperties;
import net.minecraft.network.play.server.S21PacketChunkData;
import net.minecraft.network.play.server.S22PacketMultiBlockChange;
import net.minecraft.network.play.server.S23PacketBlockChange;
import net.minecraft.network.play.server.S24PacketBlockAction;
import net.minecraft.network.play.server.S26PacketMapChunkBulk;
import net.minecraft.network.play.server.S27PacketExplosion;
import net.minecraft.network.play.server.S28PacketEffect;
import net.minecraft.network.play.server.S29PacketSoundEffect;
import net.minecraft.network.play.server.S2APacketParticles;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.network.play.server.S2CPacketSpawnGlobalEntity;
import net.minecraft.network.play.server.S2DPacketOpenWindow;
import net.minecraft.network.play.server.S30PacketWindowItems;
import net.minecraft.network.play.server.S31PacketWindowProperty;
import net.minecraft.network.play.server.S32PacketConfirmTransaction;
import net.minecraft.network.play.server.S34PacketMaps;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.network.play.server.S37PacketStatistics;
import net.minecraft.network.play.server.S38PacketPlayerListItem;
import net.minecraft.network.play.server.S39PacketPlayerAbilities;
import net.minecraft.network.play.server.S3APacketTabComplete;
import net.minecraft.network.play.server.S3BPacketScoreboardObjective;
import net.minecraft.network.play.server.S3CPacketUpdateScore;
import net.minecraft.network.play.server.S3EPacketTeams;
import net.minecraft.network.play.server.S3FPacketCustomPayload;
import net.minecraft.network.play.server.S41PacketServerDifficulty;
import net.minecraft.network.play.server.S42PacketCombatEvent;
import net.minecraft.network.play.server.S44PacketWorldBorder;
import net.minecraft.network.play.server.S45PacketTitle;
import net.minecraft.network.play.server.S48PacketResourcePackSend;
import net.minecraft.network.play.server.S49PacketUpdateEntityNBT;
import net.minecraft.network.play.server.aa;
import net.minecraft.network.play.server.ab;
import net.minecraft.network.play.server.ac;
import net.minecraft.network.play.server.ad;
import net.minecraft.network.play.server.ae;
import net.minecraft.network.play.server.af;
import net.minecraft.network.play.server.ag;
import net.minecraft.network.play.server.ap;
import net.minecraft.network.play.server.ay;
import net.minecraft.network.play.server.az;
import net.minecraft.network.play.server.bd;
import net.minecraft.network.play.server.bg;
import net.minecraft.network.play.server.bq;
import net.minecraft.network.play.server.bt;
import net.minecraft.network.play.server.bx;
import net.minecraft.network.play.server.c;
import net.minecraft.network.play.server.cc;
import net.minecraft.network.play.server.cd;
import net.minecraft.network.play.server.e;
import net.minecraft.network.play.server.f;
import net.minecraft.network.play.server.k;
import net.minecraft.network.play.server.n;
import net.minecraft.network.play.server.o;
import net.minecraft.network.play.server.s;
import net.minecraft.network.play.server.z;

public class ScriptPacketFactory {
    public ScriptPacketFactory() {
    }

    public static ScriptPacket<?> wrap(Packet<?> var0) {
        if (var0 == null) {
            return null;
        } else if (var0 instanceof a) {
            return new ScriptPacketKeepAlive((a)var0);
        } else if (var0 instanceof C01PacketChatMessage) {
            return new ScriptPacketChatMessage((C01PacketChatMessage)var0);
        } else if (var0 instanceof C02PacketUseEntity) {
            return new ScriptPacketUseEntity((C02PacketUseEntity)var0);
        } else if (var0 instanceof C06PacketPlayerPosLook) {
            return new ScriptPacketPosLook((C06PacketPlayerPosLook)var0);
        } else if (var0 instanceof C05PacketPlayerLook) {
            return new ScriptPacketLook((C05PacketPlayerLook)var0);
        } else if (var0 instanceof C04PacketPlayerPosition) {
            return new ScriptPacketPosition((C04PacketPlayerPosition)var0);
        } else if (var0 instanceof C03PacketPlayer) {
            return new ScriptPacketPlayer((C03PacketPlayer)var0);
        } else if (var0 instanceof C07PacketPlayerDigging) {
            return new ScriptPacketDigging((C07PacketPlayerDigging)var0);
        } else if (var0 instanceof C08PacketPlayerBlockPlacement) {
            return new ScriptPacketBlockPlacement((C08PacketPlayerBlockPlacement)var0);
        } else if (var0 instanceof l) {
            return new ScriptPacketHeldItem((l)var0);
        } else if (var0 instanceof m) {
            return new ScriptPacketAnimation((m)var0);
        } else if (var0 instanceof C0BPacketEntityAction) {
            return new ScriptPacketEntityAction((C0BPacketEntityAction)var0);
        } else if (var0 instanceof C0CPacketInput) {
            return new ScriptPacketInput((C0CPacketInput)var0);
        } else if (var0 instanceof q) {
            return new ScriptPacketCloseWindow((q)var0);
        } else if (var0 instanceof C0EPacketClickWindow) {
            return new ScriptPacketClickWindow((C0EPacketClickWindow)var0);
        } else if (var0 instanceof C0FPacketConfirmTransaction) {
            return new ScriptPacketTransaction((C0FPacketConfirmTransaction)var0);
        } else if (var0 instanceof t) {
            return new ScriptPacketCreativeAction((t)var0);
        } else if (var0 instanceof u) {
            return new ScriptPacketEnchantItem((u)var0);
        } else if (var0 instanceof v) {
            return new ScriptPacketUpdateSign((v)var0);
        } else if (var0 instanceof C13PacketPlayerAbilities) {
            return new ScriptPacketAbilities((C13PacketPlayerAbilities)var0);
        } else if (var0 instanceof C14PacketTabComplete) {
            return new ScriptPacketTabComplete((C14PacketTabComplete)var0);
        } else if (var0 instanceof C15PacketClientSettings) {
            return new ScriptPacketClientSettings((C15PacketClientSettings)var0);
        } else if (var0 instanceof C16PacketClientStatus) {
            return new ScriptPacketClientStatus((C16PacketClientStatus)var0);
        } else if (var0 instanceof C17PacketCustomPayload) {
            return new ScriptPacketCustomPayload((C17PacketCustomPayload)var0);
        } else if (var0 instanceof C18PacketSpectate) {
            return new ScriptPacketSpectate((C18PacketSpectate)var0);
        } else if (var0 instanceof C19PacketResourcePackStatus) {
            return new ScriptPacketResourcePackStatus((C19PacketResourcePackStatus)var0);
        } else if (var0 instanceof net.minecraft.network.play.server.a) {
            return new ScriptPacketServerKeepAlive((net.minecraft.network.play.server.a)var0);
        } else if (var0 instanceof S01PacketJoinGame) {
            return new ScriptPacketJoinGame((S01PacketJoinGame)var0);
        } else if (var0 instanceof c) {
            return new ScriptPacketChat((c)var0);
        } else if (var0 instanceof S03PacketTimeUpdate) {
            return new ScriptPacketTimeUpdate((S03PacketTimeUpdate)var0);
        } else if (var0 instanceof e) {
            return new ScriptPacketEntityEquipment((e)var0);
        } else if (var0 instanceof f) {
            return new ScriptPacketSpawnPosition((f)var0);
        } else if (var0 instanceof S06PacketUpdateHealth) {
            return new ScriptPacketUpdateHealth((S06PacketUpdateHealth)var0);
        } else if (var0 instanceof S07PacketRespawn) {
            return new ScriptPacketRespawn((S07PacketRespawn)var0);
        } else if (var0 instanceof S08PacketPlayerPosLook) {
            return new ScriptPacketPlayerPosLook((S08PacketPlayerPosLook)var0);
        } else if (var0 instanceof k) {
            return new ScriptPacketServerHeldItem((k)var0);
        } else if (var0 instanceof net.minecraft.network.play.server.l) {
            return new ScriptPacketUseBed((net.minecraft.network.play.server.l)var0);
        } else if (var0 instanceof net.minecraft.network.play.server.m) {
            return new ScriptPacketServerAnimation((net.minecraft.network.play.server.m)var0);
        } else if (var0 instanceof n) {
            return new ScriptPacketSpawnPlayer((n)var0);
        } else if (var0 instanceof o) {
            return new ScriptPacketCollectItem((o)var0);
        } else if (var0 instanceof S0EPacketSpawnObject) {
            return new ScriptPacketSpawnObject((S0EPacketSpawnObject)var0);
        } else if (var0 instanceof net.minecraft.network.play.server.q) {
            return new ScriptPacketSpawnMob((net.minecraft.network.play.server.q)var0);
        } else if (var0 instanceof S10PacketSpawnPainting) {
            return new ScriptPacketSpawnPainting((S10PacketSpawnPainting)var0);
        } else if (var0 instanceof s) {
            return new ScriptPacketSpawnXPOrb((s)var0);
        } else if (var0 instanceof S12PacketEntityVelocity) {
            return new ScriptPacketVelocity((S12PacketEntityVelocity)var0);
        } else if (var0 instanceof S13PacketDestroyEntities) {
            return new ScriptPacketDestroyEntities((S13PacketDestroyEntities)var0);
        } else if (var0 instanceof S14PacketEntity) {
            return new ScriptPacketEntity((S14PacketEntity)var0);
        } else if (var0 instanceof z) {
            return new ScriptPacketEntityTeleport((z)var0);
        } else if (var0 instanceof aa) {
            return new ScriptPacketEntityHeadLook((aa)var0);
        } else if (var0 instanceof ab) {
            return new ScriptPacketEntityStatus((ab)var0);
        } else if (var0 instanceof ac) {
            return new ScriptPacketEntityAttach((ac)var0);
        } else if (var0 instanceof ad) {
            return new ScriptPacketEntityMetadata((ad)var0);
        } else if (var0 instanceof ae) {
            return new ScriptPacketEntityEffect((ae)var0);
        } else if (var0 instanceof af) {
            return new ScriptPacketRemoveEntityEffect((af)var0);
        } else if (var0 instanceof ag) {
            return new ScriptPacketSetExperience((ag)var0);
        } else if (var0 instanceof S20PacketEntityProperties) {
            return new ScriptPacketEntityProperties((S20PacketEntityProperties)var0);
        } else if (var0 instanceof S21PacketChunkData) {
            return new ScriptPacketChunkData((S21PacketChunkData)var0);
        } else if (var0 instanceof S22PacketMultiBlockChange) {
            return new ScriptPacketMultiBlockChange((S22PacketMultiBlockChange)var0);
        } else if (var0 instanceof S23PacketBlockChange) {
            return new ScriptPacketBlockChange((S23PacketBlockChange)var0);
        } else if (var0 instanceof S24PacketBlockAction) {
            return new ScriptPacketBlockAction((S24PacketBlockAction)var0);
        } else if (var0 instanceof ap) {
            return new ScriptPacketBlockBreakAnim((ap)var0);
        } else if (var0 instanceof S26PacketMapChunkBulk) {
            return new ScriptPacketMapChunkBulk((S26PacketMapChunkBulk)var0);
        } else if (var0 instanceof S27PacketExplosion) {
            return new ScriptPacketExplosion((S27PacketExplosion)var0);
        } else if (var0 instanceof S28PacketEffect) {
            return new ScriptPacketEffect((S28PacketEffect)var0);
        } else if (var0 instanceof S29PacketSoundEffect) {
            return new ScriptPacketSoundEffect((S29PacketSoundEffect)var0);
        } else if (var0 instanceof S2APacketParticles) {
            return new ScriptPacketParticles((S2APacketParticles)var0);
        } else if (var0 instanceof S2BPacketChangeGameState) {
            return new ScriptPacketChangeGameState((S2BPacketChangeGameState)var0);
        } else if (var0 instanceof S2CPacketSpawnGlobalEntity) {
            return new ScriptPacketSpawnGlobalEntity((S2CPacketSpawnGlobalEntity)var0);
        } else if (var0 instanceof S2DPacketOpenWindow) {
            return new ScriptPacketOpenWindow((S2DPacketOpenWindow)var0);
        } else if (var0 instanceof ay) {
            return new ScriptPacketServerCloseWindow((ay)var0);
        } else if (var0 instanceof az) {
            return new ScriptPacketSetSlot((az)var0);
        } else if (var0 instanceof S30PacketWindowItems) {
            return new ScriptPacketWindowItems((S30PacketWindowItems)var0);
        } else if (var0 instanceof S31PacketWindowProperty) {
            return new ScriptPacketWindowProperty((S31PacketWindowProperty)var0);
        } else if (var0 instanceof S32PacketConfirmTransaction) {
            return new ScriptPacketServerTransaction((S32PacketConfirmTransaction)var0);
        } else if (var0 instanceof bd) {
            return new ScriptPacketServerUpdateSign((bd)var0);
        } else if (var0 instanceof S34PacketMaps) {
            return new ScriptPacketMaps((S34PacketMaps)var0);
        } else if (var0 instanceof S35PacketUpdateTileEntity) {
            return new ScriptPacketUpdateTileEntity((S35PacketUpdateTileEntity)var0);
        } else if (var0 instanceof bg) {
            return new ScriptPacketSignEditorOpen((bg)var0);
        } else if (var0 instanceof S37PacketStatistics) {
            return new ScriptPacketStatistics((S37PacketStatistics)var0);
        } else if (var0 instanceof S38PacketPlayerListItem) {
            return new ScriptPacketPlayerListItem((S38PacketPlayerListItem)var0);
        } else if (var0 instanceof S39PacketPlayerAbilities) {
            return new ScriptPacketServerAbilities((S39PacketPlayerAbilities)var0);
        } else if (var0 instanceof S3APacketTabComplete) {
            return new ScriptPacketServerTabComplete((S3APacketTabComplete)var0);
        } else if (var0 instanceof S3BPacketScoreboardObjective) {
            return new ScriptPacketScoreboardObjective((S3BPacketScoreboardObjective)var0);
        } else if (var0 instanceof S3CPacketUpdateScore) {
            return new ScriptPacketUpdateScore((S3CPacketUpdateScore)var0);
        } else if (var0 instanceof bq) {
            return new ScriptPacketDisplayScoreboard((bq)var0);
        } else if (var0 instanceof S3EPacketTeams) {
            return new ScriptPacketTeams((S3EPacketTeams)var0);
        } else if (var0 instanceof S3FPacketCustomPayload) {
            return new ScriptPacketServerCustomPayload((S3FPacketCustomPayload)var0);
        } else if (var0 instanceof bt) {
            return new ScriptPacketDisconnect((bt)var0);
        } else if (var0 instanceof S41PacketServerDifficulty) {
            return new ScriptPacketServerDifficulty((S41PacketServerDifficulty)var0);
        } else if (var0 instanceof S42PacketCombatEvent) {
            return new ScriptPacketCombatEvent((S42PacketCombatEvent)var0);
        } else if (var0 instanceof bx) {
            return new ScriptPacketCamera((bx)var0);
        } else if (var0 instanceof S44PacketWorldBorder) {
            return new ScriptPacketWorldBorder((S44PacketWorldBorder)var0);
        } else if (var0 instanceof S45PacketTitle) {
            return new ScriptPacketTitle((S45PacketTitle)var0);
        } else if (var0 instanceof cc) {
            return new ScriptPacketSetCompressionLevel((cc)var0);
        } else if (var0 instanceof cd) {
            return new ScriptPacketPlayerListHeaderFooter((cd)var0);
        } else if (var0 instanceof S48PacketResourcePackSend) {
            return new ScriptPacketResourcePackSend((S48PacketResourcePackSend)var0);
        } else {
            return var0 instanceof S49PacketUpdateEntityNBT
                ? new ScriptPacketUpdateEntityNBT((S49PacketUpdateEntityNBT)var0)
                : new ScriptPacketFactory.ScriptPacketGeneric(var0);
        }
    }

    public static class ScriptPacketGeneric extends ScriptPacket<Packet<?>> {
        public ScriptPacketGeneric(Packet<?> var1) {
            super(var1);
        }
    }
}
