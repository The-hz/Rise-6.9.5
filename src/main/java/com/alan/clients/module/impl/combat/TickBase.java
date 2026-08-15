package com.alan.clients.module.impl.combat;

import com.alan.clients.component.impl.player.BlinkComponent;
import com.alan.clients.component.impl.player.PingSpoofComponent;
import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.other.TickEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.newevent.impl.render.Render3DEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.SubMode;
import com.alan.clients.util.player.PlayerUtil;
import com.alan.clients.util.render.ColorUtil;
import hackclient.rise.aka;
import com.alan.clients.component.impl.player.BadPacketsComponent;
import com.alan.clients.component.impl.combat.TargetComponent;
import java.util.List;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import org.lwjgl.opengl.GL11;

@ModuleInfo(aliases = "module.combat.tickbase.name", description = "module.combat.legitreach.description", category = Category.COMBAT)
public final class TickBase extends Module {
    private ModeValue mode = new ModeValue("Mode", this).add(new SubMode("Post")).setDefault("Legit");
    private aka qL = new aka(0.0, 0.0, 0.0);
    private int qM = 0;
    private int qN;
    private int qO;
    @EventLink
    Listener<TickEvent> onTick = var1 -> {
        label53: {
            String s = this.mode.wo().getName();
            switch (s) {
                case "Post":
                    if (aEg.thePlayer.ticksExisted <= 20) {
                        aEg.timer.dzD = 0.5F;
                    }

                    this.qM--;
                    if (this.qN > 0) {
                        if (this.qO > 0) {
                            this.qO--;
                        } else {
                            var1.setCancelled();
                            aEg.timer.cancel();
                            this.qN--;
                        }
                    }

                    List list = TargetComponent.f(6.0);
                    if (list.isEmpty()) {
                        return;
                    }

                    EntityLivingBase entitylivingbase = (EntityLivingBase)list.get(0);
                    this.qL = this.k(entitylivingbase);
                    if (aEg.thePlayer.getDistance(this.qL.x, this.qL.y, this.qL.z) < 8.0 && PlayerUtil.v(entitylivingbase) > 3.0 && this.qM < 0) {
                        int i = this.j(entitylivingbase);
                        if (i == -1) {
                            return;
                        }

                        aEg.timer.elapsedTicks += i;
                        this.qN += i;
                        this.qO += i + 5;
                        this.qM = 10;
                    }

                    return;
                case "Legit":
                    break;
                default:
                    return;
            }
        }

        EntityLivingBase entitylivingbase1 = TargetComponent.e(8.0);
        if (entitylivingbase1 != null
            && !BadPacketsComponent.bad(false, true, false, false, false)
            && this.qL.g(entitylivingbase1.Ty()) >= aEg.thePlayer.Ty().g(entitylivingbase1.Ty())) {
            BlinkComponent.blink();
        }
    };
    @EventLink
    Listener<PacketSendEvent> onPacketSend = var1 -> {
        Packet packet = var1.dq();
        if (!var1.isCancelled() && packet instanceof C03PacketPlayer) {
            this.qL = new aka(((C03PacketPlayer)packet).getX(), ((C03PacketPlayer)packet).getY(), ((C03PacketPlayer)packet).getZ());
        }
    };
    @EventLink
    Listener<Render3DEvent> onRender3D = var1 -> {
        GlStateManager.pushMatrix();
        GlStateManager.pushAttrib();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.disableLighting();
        GL11.glDepthMask(false);
        RenderUtil.color(ColorUtil.d(this.rz().rA(), 50));
        GlStateManager.enableTexture2D();
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GL11.glDepthMask(true);
        GlStateManager.popAttrib();
        GlStateManager.popMatrix();
        GlStateManager.resetColor();
    };

    public TickBase() {
    }

    int j(Entity entity) {
        byte b0 = 10;
        aka aka = new aka(aEg.thePlayer.posX, aEg.thePlayer.posY, aEg.thePlayer.posZ);

        int i;
        for (i = 0; i < b0 && entity.getDistance(aka.x, aka.y, aka.z) > 4.4; i++) {
            aka = MoveUtil.a(
                aka,
                new aka(aEg.thePlayer.motionX, 0.0, aEg.thePlayer.motionZ),
                (float)Math.toDegrees(MoveUtil.direction()),
                new Vector2f(aEg.thePlayer.moveStrafing, aEg.thePlayer.moveForward)
            );
        }

        return i == b0 ? -1 : i;
    }

    aka k(Entity entity) {
        aka aka = new aka(entity.posX, entity.posY, entity.posZ);

        for (int i = 0; i <= PingSpoofComponent.getPing() / 50L; i++) {
            double dx = entity.posX - entity.lastTickPosX;
            double dz = entity.posZ - entity.lastTickPosZ;
            int j = dz == 0.0 && dx == 0.0 ? 0 : 1;
            aka = MoveUtil.a(aka, new aka(dx, 0.0, dz), entity.pl, new Vector2f(0.0F, j));
        }

        return aka;
    }
}
