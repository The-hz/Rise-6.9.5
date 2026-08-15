package com.alan.clients.module.impl.combat;

import com.alan.clients.Client;
import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.ClickEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.other.AttackEvent;
import com.alan.clients.newevent.impl.render.Render3DEvent;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.BoundsNumberValue;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.NumberValue;
import com.alan.clients.value.impl.SubMode;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.Protocol1_21_2To1_21;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPackets1_21_2;
import de.florianmichael.vialoadingbase.ViaLoadingBase;
import com.alan.clients.util.math.MathUtil;
import com.alan.clients.util.packet.PacketUtil;
import com.alan.clients.util.pathfinding.unlegit.MainPathFinder;
import hackclient.rise.ahy;
import hackclient.rise.component.bv;
import hackclient.rise.hc;
import java.awt.Color;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSword;
import net.minecraft.item.bw;
import net.minecraft.item.cn;
import net.minecraft.network.play.client.C02PacketUseEntity.Action;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;
import net.minecraft.potion.Potion;
import rip.vantage.commons.util.time.a;

@ModuleInfo(
    aliases = {"module.combat.teleportaura.name", "Infinite Aura", "Infinite", "TP Aura"},
    description = "module.combat.teleportaura.description",
    category = Category.COMBAT
)
public final class TeleportAura extends Module {
    private final ModeValue mode = new ModeValue("Mode", this).add(new SubMode("Single")).add(new SubMode("Multiple")).setDefault("Single");
    private final NumberValue range = new NumberValue("Range", this, 32, 3, 100, 0.1);
    private final BoundsNumberValue cps = new BoundsNumberValue("CPS", this, 10, 15, 1, 20, 1);
    private final BooleanValue ql = new BooleanValue("1.9 Cooldown", this, false);
    private final BooleanValue render = new BooleanValue("Render", this, true);
    private final a qn = new a();
    private KillAura gj;
    private List<ahy> path;
    public EntityLivingBase jE;
    private long nextSwing;
    @EventLink
    public final Listener<PreUpdateEvent> onPreUpdate = var1 -> {
        if (this.gj == null) {
            this.gj = this.e(KillAura.class);
        }

        List list = bv.a(this.range.wo().doubleValue(), this.gj.player.wo(), this.gj.invisibles.wo(), this.gj.animals.wo(), this.gj.mobs.wo(), this.gj.playerTeammates.wo());
        if (list.isEmpty()) {
            this.jE = null;
        } else {
            list.sort(Comparator.comparingDouble(var0 -> aEg.thePlayer.getDistanceToEntity((Entity)var0)));
            this.jE = (EntityLivingBase)list.get(0);
            if (this.jE != null && !aEg.thePlayer.isDead) {
                this.doAttack(list);
            }
        }
    };
    @EventLink
    public final Listener<Render3DEvent> onRender3D = var1 -> {
        if (this.render.wo() && this.path != null && this.jE != null) {
            ahy ahyx = null;

            for (ahy ahyx2 : this.path) {
                if (ahyx != null) {
                    RenderUtil.drawLine(ahyx.getX(), ahyx.getY() + 0.01, ahyx.getZ(), ahyx2.getX(), ahyx2.getY() + 0.01, ahyx2.getZ(), Color.WHITE, 1.0F);
                }

                ahyx = ahyx2;
            }
        }
    };

    public TeleportAura() {
    }

    @Override
    public void onDisable() {
        this.jE = null;
    }

    private void doAttack(List<EntityLivingBase> var1) {
        boolean flag;
        if (this.ql.wo()) {
            double d0 = 4.0;
            if (aEg.thePlayer.getHeldItem() != null) {
                Item item = aEg.thePlayer.getHeldItem().getItem();
                if (item instanceof ItemSword) {
                    d0 = 1.6;
                } else if (item instanceof cn) {
                    d0 = 1.0;
                } else if (item instanceof bw) {
                    d0 = 1.2;
                } else if (item instanceof ItemAxe) {
                    switch (hc.qr[((ItemAxe)item).getToolMaterial().ordinal()]) {
                        case 1:
                        case 2:
                            d0 = 0.8;
                            break;
                        case 3:
                            d0 = 0.9;
                            break;
                        case 4:
                        default:
                            d0 = 1.0;
                    }
                } else if (item instanceof ItemHoe) {
                    switch (hc.qr[((ItemHoe)item).getToolMaterial().ordinal()]) {
                        case 1:
                        case 5:
                            d0 = 1.0;
                            break;
                        case 2:
                            d0 = 2.0;
                            break;
                        case 3:
                            d0 = 3.0;
                            break;
                        case 4:
                        default:
                            d0 = 4.0;
                    }
                }
            }

            double d1 = 1.0 / d0 * 20.0 - 1.0;
            flag = this.qn.T((long)(d1 * 50.0));
        } else {
            flag = this.qn.T(this.nextSwing);
        }

        if (flag && this.jE != null && !aEg.gameSettings.cgK.isKeyDown() && !aEg.gameSettings.cgI.isKeyDown()) {
            if (!this.ql.wo()) {
                long i = Math.round(MathUtil.l(this.cps.wo().intValue(), this.cps.wA().intValue()));
                this.nextSwing = 1000L / i;
            }

            label66: {
                double d2;
                label65: {
                    d2 = this.range.wo().doubleValue();
                    String s = this.mode.wo().getName();
                    byte b0 = -1;
                    switch (s.hashCode()) {
                        case -1818398616:
                            if (s.equals("Single")) {
                                b0 = 0;
                            }
                            break;
                        case 718473776:
                            if (s.equals("Multiple")) {
                                break label65;
                            }
                    }

                    switch (b0) {
                        case 0:
                            if (aEg.thePlayer.getDistanceToEntity(this.jE) <= d2) {
                                this.e(this.jE);
                            }
                            break label66;
                        case 1:
                            break;
                        default:
                            break label66;
                    }
                }

                var1.removeIf(var2 -> aEg.thePlayer.getDistanceToEntity(var2) > d2);
                if (!var1.isEmpty()) {
                    var1.forEach(this::e);
                }
            }

            this.qn.aX();
        }
    }

    private void e(EntityLivingBase var1) {
        aEg.playerController.syncCurrentPlayItem();
        AttackEvent attackevent = new AttackEvent(var1);
        Client.a.e().d(attackevent);
        if (!attackevent.isCancelled()) {
            EntityLivingBase entitylivingbase = attackevent.dc();
            this.path = MainPathFinder.a(
                new ahy(aEg.thePlayer.posX, aEg.thePlayer.posY, aEg.thePlayer.posZ),
                new ahy(entitylivingbase.posX, entitylivingbase.posY, entitylivingbase.posZ),
                true
            );
            if (this.path != null) {
                for (ahy ahy : this.path) {
                    PacketUtil.m(new C04PacketPlayerPosition(ahy.getX(), ahy.getY(), ahy.getZ(), true));
                    if (ViaLoadingBase.getInstance().getTargetVersion().newerThanOrEqualTo(ProtocolVersion.v1_21_2)
                        && aEg.thePlayer != null
                        && aEg.theWorld != null
                        && Via.getManager().getConnectionManager() != null
                        && !Via.getManager().getConnectionManager().getConnections().isEmpty()) {
                        PacketWrapper.create(
                                ServerboundPackets1_21_2.CLIENT_TICK_END, null, Via.getManager().getConnectionManager().getConnections().iterator().next()
                            )
                            .sendToServer(Protocol1_21_2To1_21.class);
                    }
                }

                if (ViaLoadingBase.getInstance().getTargetVersion().olderThanOrEqualTo(ProtocolVersion.v1_8)) {
                    Client.a.e().d(new ClickEvent());
                    aEg.thePlayer.swingItem();
                }

                PacketUtil.m(new C02PacketUseEntity(entitylivingbase, Action.ATTACK));
                if (ViaLoadingBase.getInstance().getTargetVersion().newerThan(ProtocolVersion.v1_8)) {
                    Client.a.e().d(new ClickEvent());
                    aEg.thePlayer.swingItem();
                }

                Collections.reverse(this.path);

                for (ahy ahyx : this.path) {
                    PacketUtil.m(new C04PacketPlayerPosition(ahyx.getX(), ahyx.getY(), ahyx.getZ(), true));
                    if (ViaLoadingBase.getInstance().getTargetVersion().newerThanOrEqualTo(ProtocolVersion.v1_21_2)
                        && aEg.thePlayer != null
                        && aEg.theWorld != null
                        && Via.getManager().getConnectionManager() != null
                        && !Via.getManager().getConnectionManager().getConnections().isEmpty()) {
                        PacketWrapper.create(
                                ServerboundPackets1_21_2.CLIENT_TICK_END, null, Via.getManager().getConnectionManager().getConnections().iterator().next()
                            )
                            .sendToServer(Protocol1_21_2To1_21.class);
                    }
                }

                if (this.e(Criticals.class).isEnabled()
                    || aEg.thePlayer.fallDistance > 0.0F
                        && !aEg.thePlayer.onGround
                        && !aEg.thePlayer.isOnLadder()
                        && !aEg.thePlayer.isInWater()
                        && !aEg.thePlayer.isPotionActive(Potion.blindness)
                        && aEg.thePlayer.ridingEntity == null) {
                    aEg.thePlayer.onCriticalHit(entitylivingbase);
                }
            }
        }
    }
}
