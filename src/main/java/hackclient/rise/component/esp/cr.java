package hackclient.rise.component.esp;

import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.component.impl.combat.TargetComponent;
import com.alan.clients.component.impl.render.espcomponent.api.ESP;
import com.alan.clients.component.impl.render.espcomponent.api.ESPColor;
import com.alan.clients.util.shader.ShaderQueueType;
import java.awt.Color;
import java.util.Iterator;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class cr extends ESP implements InstanceAccess
{


    public void render3D() {
        this.b(ShaderQueueType.BLOOM).c(() -> {
            final float bWm = cr.aEg.timer.bWm;
            final Iterator iterator = TargetComponent.bR().iterator();
            while (iterator.hasNext()) {
                final Entity entity = (Entity)iterator.next();
                final Render render = cr.aEg.getRenderManager().getEntityRenderObject(entity);
                if (cr.aEg.getRenderManager() != null && entity instanceof EntityPlayer && render != null) {
                    if (!RenderUtil.isInViewFrustrum(entity)) {
                        continue;
                    }
                    final Color color = (((EntityPlayer)entity).hurtTime > 0) ? Color.RED : this.getColor((EntityPlayer)entity);
                    if (color.getAlpha() <= 0) {
                        continue;
                    }
                    final double n = entity.prevPosX + (entity.posX - entity.prevPosX) * bWm;
                    final double n2 = entity.prevPosY + (entity.posY - entity.prevPosY) * bWm;
                    final double n3 = entity.prevPosZ + (entity.posZ - entity.prevPosZ) * bWm;
                    final float n4 = entity.prevRotationYaw + (entity.pl - entity.prevRotationYaw) * bWm;
                    final int n5 = entity.isInvisible() ? 1 : 0;
                    entity.setInvisible(false);
                    RendererLivingEntity.setShaderBrightness(color);
                    final Render render2 = render;
                    final EntityPlayer entityPlayer = (EntityPlayer)entity;
                    cr.aEg.getRenderManager();
                    final double n6 = n - RenderManager.bUO;
                    cr.aEg.getRenderManager();
                    final double n8 = n2 - RenderManager.bUP;
                    cr.aEg.getRenderManager();
                    render2.doRender((Entity)entityPlayer, n6, n8, n3 - RenderManager.bUQ, n4, bWm);
                    RendererLivingEntity.No();
                    entity.setInvisible(n5 != 0);
                }
            }
            RenderHelper.disableStandardItemLighting();
            cr.aEg.entityRenderer.IU();
        });
    }

    public cr(final ESPColor espColor) {
        super(espColor);
    }

    static {
    }
}
