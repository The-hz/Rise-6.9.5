package com.alan.clients.module.impl.combat;

import com.alan.clients.component.impl.player.BlinkComponent;
import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.module.impl.combat.velocity.GrimReduceVelocity;
import com.alan.clients.module.impl.combat.velocity.GrimVelocity;
import com.alan.clients.module.impl.combat.velocity.WatchdogPredictionVelocity;
import com.alan.clients.module.impl.combat.velocity.WatchdogVelocity;
import com.alan.clients.module.impl.movement.Speed;
import com.alan.clients.module.impl.movement.speed.GrimSpeed;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PostMotionEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.newevent.impl.render.Render3DEvent;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.NumberValue;
import com.alan.clients.util.render.ColorUtil;
import com.alan.clients.component.impl.combat.TargetComponent;
import java.util.List;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S14PacketEntity;
import net.minecraft.network.play.server.z;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

@ModuleInfo(aliases = {"module.combat.legitreach.name", "Back Track"}, description = "module.combat.legitreach.description", category = Category.COMBAT)
public final class LegitReach extends Module {
    public static AxisAlignedBB pQ;
    public NumberValue maxPingSpoof = new NumberValue("Max Ping Spoof", this, 1000, 50, 10000, 1);
    public BooleanValue renderRealLocation = new BooleanValue("Render Real Location", this, true);
    public BooleanValue watchdogMode = new BooleanValue("Watchdog Mode", this, false);
    private Vec3 realTargetPosition = new Vec3(0.0, 0.0, 0.0);
    private final Animation pV = new Animation(Easing.LINEAR, 50L);
    private final Animation pW = new Animation(Easing.LINEAR, 50L);
    private final Animation pX = new Animation(Easing.LINEAR, 50L);
    public Entity targetEntity;
    public boolean pZ;
    @EventLink
    public final Listener<PostMotionEvent> onPostMotion = var1 -> {
        List list = TargetComponent.f(9.0);
        if (list.isEmpty()) {
            this.pZ = true;
            this.targetEntity = null;
        } else {
            Entity entity = (Entity)list.get(0);
            if (entity != this.targetEntity) {
                this.targetEntity = entity;
                this.realTargetPosition.xCoord = entity.posX;
                this.realTargetPosition.yCoord = entity.posY;
                this.realTargetPosition.zCoord = entity.posZ;
            }

            Speed speed = this.e(Speed.class);
            boolean flag = speed.isEnabled() && speed.hl().wo() instanceof GrimSpeed && ((GrimSpeed)speed.hl().wo()).fastFall.wo();
            if (this.targetEntity != null
                && (aEg.thePlayer.isSwingInProgress || this.e(KillAura.class).isEnabled())
                && !flag
                && !WatchdogVelocity.dj
                && !WatchdogPredictionVelocity.dj
                && !GrimVelocity.dj
                && !GrimReduceVelocity.dj) {
                double d0 = this.targetEntity.width / 2.0;
                double d1 = this.targetEntity.height;
                pQ = new AxisAlignedBB(
                    this.realTargetPosition.xCoord - d0,
                    this.realTargetPosition.yCoord,
                    this.realTargetPosition.zCoord - d0,
                    this.realTargetPosition.xCoord + d0,
                    this.realTargetPosition.yCoord + d1,
                    this.realTargetPosition.zCoord + d0
                );
                double d2 = this.realTargetPosition.N(aEg.thePlayer);
                double d3 = this.targetEntity.getDistanceToEntity(aEg.thePlayer);
                boolean flag1;
                if (this.watchdogMode.wo()) {
                    flag1 = d2 > d3
                        && d2 > 2.5
                        && d2 < 4.4
                        && !WatchdogVelocity.dj
                        && !WatchdogPredictionVelocity.dj
                        && !GrimVelocity.dj
                        && !GrimReduceVelocity.dj
                        && aEg.thePlayer.ae > 2;
                } else {
                    flag1 = d2 > d3 && d2 > 2.5 && d2 < 6.0 && !WatchdogPredictionVelocity.dj && !GrimVelocity.dj && !GrimReduceVelocity.dj;
                }

                if (flag1) {
                    BlinkComponent.a(this.maxPingSpoof.wo().intValue(), true, true, false, true);
                } else {
                    BlinkComponent.disable();
                    BlinkComponent.dispatch();
                }
            }
        }
    };
    @EventLink
    public final Listener<PacketReceiveEvent> onPacketReceiveEvent = var1 -> {
        Packet packet = var1.getPacket();
        if (this.targetEntity != null) {
            if (packet instanceof S14PacketEntity s14packetentity) {
                if (s14packetentity.entityId == this.targetEntity.getEntityId()) {
                    this.realTargetPosition.xCoord = this.realTargetPosition.xCoord + s14packetentity.agC() / 32.0;
                    this.realTargetPosition.yCoord = this.realTargetPosition.yCoord + s14packetentity.agD() / 32.0;
                    this.realTargetPosition.zCoord = this.realTargetPosition.zCoord + s14packetentity.agE() / 32.0;
                }
            } else if (packet instanceof z z && z.getEntityId() == this.targetEntity.getEntityId()) {
                this.realTargetPosition = new Vec3(z.we() / 32.0, z.wf() / 32.0, z.wi() / 32.0);
            }
        }
    };
    @EventLink
    public final Listener<Render2DEvent> onRender2D = var1 -> {
        if (this.targetEntity != null && aEg.thePlayer != null) {
            double d0 = this.realTargetPosition.N(aEg.thePlayer);
            double d1 = this.targetEntity.getDistanceToEntity(aEg.thePlayer);
            boolean flag;
            if (this.watchdogMode.wo()) {
                flag = d0 > d1 && d0 > 2.8 && d0 < 4.4 && !WatchdogVelocity.dj;
            } else {
                flag = d0 > d1 && d0 > 2.5 && d0 < 6.0;
            }

            if (aEg.thePlayer.isSwingInProgress && flag && d0 > 3.0 && this.watchdogMode.wo()) {
                aEg.fontRendererObj.b("Reach: " + d0, aEg.jY.getScaledWidth() / 2.0, aEg.jY.getScaledHeight() / 2.0 + 20.0, -1);
            }
        }
    };
    @EventLink
    public final Listener<Render3DEvent> onRender3D = var1 -> {
        if (this.targetEntity != null && this.renderRealLocation.wo()) {
            if (this.watchdogMode.wo()) {
                this.pV.h(0L);
                this.pW.h(0L);
                this.pX.h(0L);
            } else {
                this.pV.h(150L);
                this.pW.h(150L);
                this.pX.h(150L);
            }

            this.pV.Q(this.realTargetPosition.xCoord);
            this.pW.Q(this.realTargetPosition.yCoord);
            this.pX.Q(this.realTargetPosition.zCoord);
            GlStateManager.pushMatrix();
            GlStateManager.pushAttrib();
            GlStateManager.enableBlend();
            GlStateManager.disableTexture2D();
            GlStateManager.disableLighting();
            GL11.glDepthMask(false);
            double d0 = 0.14;
            RenderUtil.color(ColorUtil.d(this.rz().rA(), 50));
            RenderUtil.drawBoundingBox(
                aEg.thePlayer
                    .getEntityBoundingBox()
                    .offset(-aEg.thePlayer.posX, -aEg.thePlayer.posY, -aEg.thePlayer.posZ)
                    .offset(this.pV.sG(), this.pW.sG(), this.pX.sG())
                    .expand(d0, d0, d0)
            );
            GlStateManager.enableTexture2D();
            GlStateManager.enableLighting();
            GlStateManager.disableBlend();
            GL11.glDepthMask(true);
            GlStateManager.popAttrib();
            GlStateManager.popMatrix();
            GlStateManager.resetColor();
        }
    };

    public LegitReach() {
    }
}
