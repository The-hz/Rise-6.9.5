package com.alan.clients.module.impl.combat;

import com.alan.clients.Client;
import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.other.AttackEvent;
import com.alan.clients.newevent.impl.other.WorldChangeEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.NumberValue;
import hackclient.rise.afi;
import com.alan.clients.util.packet.PacketUtil;
import com.alan.clients.util.rotation.RotationUtil;
import hackclient.rise.component.bv;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.m;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.util.MathHelper;
import rip.vantage.commons.util.time.a;

@ModuleInfo(aliases={"Watchdog TP Aura", "WatchdogTPAura"}, description="Teleport-based aura for Hypixel Watchdog", category=Category.COMBAT)
public final class WatchdogTPAura
extends Module {
    private final NumberValue range = new NumberValue("Range", this, (Number)20, (Number)6, (Number)20, (Number)1);
    private final BooleanValue players = new BooleanValue("Players", (Module)this, (Boolean)true);
    private final BooleanValue hostile = new BooleanValue("Hostile", (Module)this, (Boolean)false);
    private final BooleanValue teammates = new BooleanValue("Teammates", (Module)this, (Boolean)false);
    private final BooleanValue invisibles = new BooleanValue("Invisibles", (Module)this, (Boolean)true);
    private boolean qW = true;
    private boolean cR = false;
    private EntityLivingBase jE;
    private EntityLivingBase qX;
    private int qY;
    private final a qZ = new a();
    private final ConcurrentLinkedQueue<Packet<?>> ra = new ConcurrentLinkedQueue();
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = preMotionEvent -> {
        if (this.qW) {
            this.qW = false;
            return;
        }
        this.gv();
        if (this.jE == null) {
            return;
        }
        if (this.cR) {
            preMotionEvent.setPosX(this.jE.posX);
            preMotionEvent.setPosY(this.jE.posY);
            preMotionEvent.setPosZ(this.jE.posZ);
            this.qX = this.jE;
            Vector2f vector2f = RotationUtil.y((Entity)this.jE);
            preMotionEvent.setYaw(vector2f.x);
            preMotionEvent.setPitch(vector2f.y);
        } else {
            preMotionEvent.setPosX(0.0);
            preMotionEvent.setPosY(0.0);
            preMotionEvent.setPosZ(0.0);
        }
        WatchdogTPAura.aEg.thePlayer.positionUpdateTicks = 20;
    };
    @EventLink
    public final Listener<PacketReceiveEvent> onPacketReceive = packetReceiveEvent -> {
        if (packetReceiveEvent.getPacket() instanceof S08PacketPlayerPosLook && !this.cR) {
            this.gw();
        }
    };
    @EventLink(value=0)
    public final Listener<PacketSendEvent> onPacketSend = packetSendEvent -> {
        if (this.cR && !packetSendEvent.isCancelled()) {
            Packet<?> packet = packetSendEvent.dq();
            this.ra.add(packet);
            packetSendEvent.setCancelled();
        }
    };
    @EventLink
    public final Listener<WorldChangeEvent> onWorldChange = worldChangeEvent -> {
        if (this.cR) {
            this.gx();
        }
        this.ra.clear();
    };
    @EventLink
    public final Listener<PreUpdateEvent> onPreUpdate = preUpdateEvent -> {
        if (this.qX != null && this.cR) {
            WatchdogTPAura.aEg.playerController.syncCurrentPlayItem();
            AttackEvent attackEvent = new AttackEvent(this.qX);
            Client.a.e().d(attackEvent);
            if (!attackEvent.isCancelled()) {
                PacketUtil.l(new m());
                afi.c("attacked", new Object[0]);
                PacketUtil.l(new C02PacketUseEntity((Entity)this.qX, C02PacketUseEntity.Action.ATTACK));
            }
            this.qX = null;
        }
        if (this.cR && ++this.qY > 1) {
            this.gx();
        }
    };
    @EventLink
    public final Listener<Render2DEvent> onRender2D = render2DEvent -> {
        if (this.jE != null && this.cR) {
            ScaledResolution scaledResolution = new ScaledResolution(aEg);
            String string = this.jE.getName();
            float f2 = this.jE.getHealth();
            float f3 = this.jE.getMaxHealth();
            int n2 = (int)(f2 / f3 * 100.0f);
            String string2 = String.format("Target: %s [%d%%]", string, n2);
            int n3 = WatchdogTPAura.aEg.fontRendererObj.getStringWidth(string2);
            WatchdogTPAura.aEg.fontRendererObj.b(string2, (float)scaledResolution.getScaledWidth() / 2.0f - (float)n3 / 2.0f, (float)scaledResolution.getScaledHeight() / 2.0f + 20.0f, -1);
        }
    };

    private void gv() {
        List<EntityLivingBase> list = bv.a(((Number)this.range.wo()).doubleValue(), (boolean)((Boolean)this.players.wo()), (boolean)((Boolean)this.invisibles.wo()), false, (boolean)((Boolean)this.hostile.wo()), (Boolean)this.teammates.wo());
        if (list.isEmpty()) {
            this.jE = null;
            return;
        }
        list.sort(Comparator.comparingDouble(entityLivingBase -> {
            Vector2f vector2f = RotationUtil.y((Entity)entityLivingBase);
            float f2 = Math.abs(MathHelper.wrapAngleTo180_float((float)(vector2f.x - WatchdogTPAura.aEg.thePlayer.pl)));
            float f3 = Math.abs(MathHelper.wrapAngleTo180_float((float)(vector2f.y - WatchdogTPAura.aEg.thePlayer.rotationPitch)));
            return Math.sqrt(f2 * f2 + f3 * f3);
        }));
        this.jE = list.get(0);
    }

    private void gw() {
        if (!this.cR) {
            this.cR = true;
            this.qY = 0;
            this.ra.clear();
            this.qZ.aX();
            afi.c("Started blinking", new Object[0]);
        }
    }

    private void gx() {
        if (this.cR) {
            this.cR = false;
            afi.c("Dispatching " + this.ra.size() + " packets", new Object[0]);
            while (!this.ra.isEmpty()) {
                PacketUtil.m(this.ra.poll());
            }
            this.qW = false;
            afi.c("Stopped blinking", new Object[0]);
        }
    }

    @Override
    public void onEnable() {
        afi.b("CREDIT TO https://youtube.com/@authh FOR THIS GOD BYPASS", new Object[0]);
        this.qW = true;
        this.cR = false;
        this.jE = null;
        this.qX = null;
        this.qY = 0;
        this.ra.clear();
    }

    @Override
    public void onDisable() {
        if (this.cR) {
            this.gx();
        }
        this.ra.clear();
        this.jE = null;
        this.qX = null;
        this.qY = 0;
        this.qW = true;
    }
}
