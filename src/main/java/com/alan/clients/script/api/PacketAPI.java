package com.alan.clients.script.api;

import com.alan.clients.Client;
import com.alan.clients.component.impl.player.SlotComponent;
import com.alan.clients.script.api.wrapper.impl.ScriptEntity;
import com.alan.clients.script.api.wrapper.impl.ScriptItemStack;
import com.alan.clients.script.api.wrapper.impl.packet.ScriptPacket;
import com.alan.clients.script.api.wrapper.impl.vector.ScriptVector3d;
import hackclient.rise.ahj;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.client.C02PacketUseEntity.Action;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;
import net.minecraft.network.play.client.C03PacketPlayer.C06PacketPlayerPosLook;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.network.play.client.C0CPacketInput;
import net.minecraft.network.play.client.C0FPacketConfirmTransaction;
import net.minecraft.network.play.client.C13PacketPlayerAbilities;
import net.minecraft.network.play.client.C14PacketTabComplete;
import net.minecraft.network.play.client.C15PacketClientSettings;
import net.minecraft.network.play.client.C16PacketClientStatus.EnumState;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.network.play.client.a;
import net.minecraft.network.play.client.l;
import net.minecraft.network.play.client.m;
import net.minecraft.network.play.client.q;
import net.minecraft.network.play.client.u;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;

public class PacketAPI extends API {
    public PacketAPI() {
    }

    public void receivePacket(ScriptPacket<?> var1) {
        if (var1 != null && var1.getWrapped() != null) {
            ahj.p(var1.getWrapped());
        }
    }

    public void sendBlockPlacement(int var1, int var2, int var3, int var4, float var5, float var6, float var7) {
        BlockPos blockpos = new BlockPos(var1, var2, var3);
        SlotComponent slotcomponent = Client.a.h().b(SlotComponent.class);
        ahj.l(new C08PacketPlayerBlockPlacement(blockpos, var4, SlotComponent.getItemStack(), var5, var6, var7));
    }

    public void sendKeepAlive(int var1) {
        ahj.l(new a(var1));
    }

    public void sendMessage(String var1) {
        ahj.l(new C01PacketChatMessage(var1));
    }

    public void sendUseEntity(ScriptEntity var1, String var2) {
        this.sendUseEntity(var1.getEntityId(), var2);
    }

    public void sendUseEntity(int var1, String var2) {
        ahj.l(new C02PacketUseEntity(Minecraft.getMinecraft().theWorld.getEntityByID(var1), Action.valueOf(var2)));
    }

    public void sendUseEntity(int var1, ScriptVector3d var2) {
        ahj.l(new C02PacketUseEntity(Minecraft.getMinecraft().theWorld.getEntityByID(var1), new Vec3(var2.getX(), var2.getY(), var2.getZ())));
    }

    public void sendUseEntity(ScriptEntity var1, ScriptVector3d var2) {
        this.sendUseEntity(var1.getEntityId(), var2);
    }

    public void sendPosition(boolean var1) {
        ahj.l(new C03PacketPlayer(var1));
    }

    public void sendPosition(double var1, double var3, double var5, boolean var7) {
        ahj.l(new C04PacketPlayerPosition(var1, var3, var5, var7));
    }

    public void sendPosition(double var1, double var3, double var5, float var7, float var8, boolean var9) {
        ahj.l(new C06PacketPlayerPosLook(var1, var3, var5, var7, var8, var9));
    }

    public void sendDigging(String var1, ScriptVector3d var2, String var3) {
        ahj.l(
            new C07PacketPlayerDigging(
                net.minecraft.network.play.client.C07PacketPlayerDigging.Action.valueOf(var1),
                new BlockPos(var2.getX(), var2.getY(), var2.getZ()),
                EnumFacing.valueOf(var3)
            )
        );
    }

    public void sendPlacement() {
        SlotComponent slotcomponent = Client.a.h().b(SlotComponent.class);
        ahj.l(new C08PacketPlayerBlockPlacement(SlotComponent.getItemStack()));
    }

    public void sendPlacement(ScriptVector3d var1, int var2, float var3, float var4, float var5) {
        BlockPos blockpos = new BlockPos(var1.getX(), var1.getY(), var1.getZ());
        SlotComponent slotcomponent = Client.a.h().b(SlotComponent.class);
        ahj.l(new C08PacketPlayerBlockPlacement(blockpos, var2, SlotComponent.getItemStack(), var3, var4, var5));
    }

    public void sendPlacement(ScriptVector3d var1, int var2, ScriptItemStack var3, float var4, float var5, float var6) {
        ahj.l(new C08PacketPlayerBlockPlacement(new BlockPos(var1.getX(), var1.getY(), var1.getZ()), var2, var3.getWrapped(), var4, var5, var6));
    }

    public void sendChangeItem(int var1) {
        ahj.l(new l(var1));
    }

    public void sendAnimation(int var1, String var2) {
        ahj.l(new m());
    }

    public void sendEntityAction(int var1, String var2) {
        ahj.l(
            new C0BPacketEntityAction(
                Minecraft.getMinecraft().theWorld.getEntityByID(var1), net.minecraft.network.play.client.C0BPacketEntityAction.Action.valueOf(var2)
            )
        );
    }

    public void sendInput(float var1, float var2, boolean var3, boolean var4) {
        ahj.l(new C0CPacketInput(var1, var2, var3, var4));
    }

    public void sendCloseWindow(int var1) {
        ahj.l(new q(var1));
    }

    public void sendCloseWindow() {
        ahj.l(new q(Minecraft.getMinecraft().thePlayer.openContainer.windowId));
    }

    public void sendEnchantItem(int var1, int var2) {
        ahj.l(new u(var1, var2));
    }

    public void sendEnchantItem(int var1) {
        ahj.l(new u(Minecraft.getMinecraft().thePlayer.openContainer.windowId, var1));
    }

    public void sendTransaction(int var1, short var2, boolean var3) {
        ahj.l(new C0FPacketConfirmTransaction(var1, var2, var3));
    }

    public void sendAbilities() {
        ahj.l(new C13PacketPlayerAbilities(Minecraft.getMinecraft().thePlayer.capabilities));
    }

    public void sendAbilities(boolean var1, boolean var2, boolean var3) {
        PlayerCapabilities playercapabilities = new PlayerCapabilities();
        playercapabilities.isFlying = var1;
        playercapabilities.allowFlying = var2;
        playercapabilities.isCreativeMode = var3;
        ahj.l(new C13PacketPlayerAbilities(playercapabilities));
    }

    public void sendTabComplete(String var1) {
        ahj.l(new C14PacketTabComplete(var1));
    }

    public void sendTabComplete(String var1, ScriptVector3d var2) {
        ahj.l(new C14PacketTabComplete(var1, new BlockPos(var2.getX(), var2.getY(), var2.getZ())));
    }

    public void sendStatus(String var1) {
        ahj.l(new C16PacketClientStatus(EnumState.valueOf(var1)));
    }

    public void sendSettings() {
        ahj.l(new C15PacketClientSettings());
    }
}
