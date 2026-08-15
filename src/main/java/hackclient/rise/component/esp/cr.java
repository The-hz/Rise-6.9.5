package hackclient.rise.component.esp;

import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.render.RenderUtil;
import hackclient.rise.component.bv;
import com.alan.clients.component.impl.render.espcomponent.api.ESP;
import com.alan.clients.component.impl.render.espcomponent.api.ESPColor;
import hackclient.rise.gg;
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


    public void cp() {
        this.b(gg.BLOOM).c(() -> {
            final float bWm = cr.aEg.timer.bWm;
            final Iterator iterator = bv.bR().iterator();
            while (iterator.hasNext()) {
                final Entity entity = (Entity)((Iterator)iterator).next();
                final Render render = cr.aEg.getRenderManager().getEntityRenderObject((Entity)entity);
                if (cr.aEg.getRenderManager() != null && entity instanceof EntityPlayer && render != null) {
                    if (!RenderUtil.isInViewFrustrum((Entity)entity)) {
                        continue;
                    }
                    final Color color = (((EntityPlayer)entity).hurtTime > 0) ? Color.RED : this.getColor((EntityLivingBase)(EntityPlayer)entity);
                    if (color.getAlpha() <= 0) {
                        continue;
                    }
                    final double n = entity.prevPosX + (entity.posX - entity.prevPosX) * bWm;
                    final double n2 = entity.prevPosY + (entity.posY - entity.prevPosY) * bWm;
                    final double n3 = entity.prevPosZ + (entity.posZ - entity.prevPosZ) * bWm;
                    final float n4 = entity.prevRotationYaw + (entity.pl - entity.prevRotationYaw) * bWm;
                    final int n5 = entity.isInvisible() ? 1 : 0;
                    entity.setInvisible(false);
                    RendererLivingEntity.setShaderBrightness((Color)color);
                    final Render render2 = (Render)render;
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

    public cr(final ESPColor cn) {
        super(cn);
    }

    static {
    }
}
