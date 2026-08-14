package hackclient.rise;

import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.render.RenderUtil;
import java.awt.Color;
import java.util.Iterator;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class cr extends cm implements InstanceAccess
{
    public static int[] fld_0OOOoo00o0_13;

    public static void o0Oo000O0oO() {
        (cr.fld_0OOOoo00o0_13 = new int[12])[5] = 41;
        cr.fld_0OOOoo00o0_13[10] = -102;
        cr.fld_0OOOoo00o0_13[0] = 21;
        cr.fld_0OOOoo00o0_13[2] = 102;
        cr.fld_0OOOoo00o0_13[1] = 83;
        cr.fld_0OOOoo00o0_13[6] = 119;
        cr.fld_0OOOoo00o0_13[8] = 7;
        cr.fld_0OOOoo00o0_13[9] = -92;
        cr.fld_0OOOoo00o0_13[11] = -30;
        cr.fld_0OOOoo00o0_13[3] = -90;
        cr.fld_0OOOoo00o0_13[4] = 81;
        cr.fld_0OOOoo00o0_13[7] = 112;
    }

    public void cp() {
        this.b(gg.BLOOM).c(() -> {
            final float bWm = cr.aEg.timer.bWm;
            final Iterator iterator = bv.bR().iterator();
            while (((Iterator)iterator).hasNext()) {
                final Entity entity = (Entity)((Iterator)iterator).next();
                final Render render = cr.aEg.getRenderManager().getEntityRenderObject((Entity)entity);
                if (cr.aEg.getRenderManager() != null && ((Entity)entity) instanceof EntityPlayer && render != null) {
                    if (!RenderUtil.isInViewFrustrum((Entity)entity)) {
                        continue;
                    }
                    final Color color = (((EntityPlayer)entity).hurtTime > 0) ? Color.RED : this.a((EntityLivingBase)(EntityPlayer)entity);
                    if (((Color)color).getAlpha() <= 0) {
                        continue;
                    }
                    final double n = ((Entity)entity).prevPosX + (((Entity)entity).posX - ((Entity)entity).prevPosX) * bWm;
                    final double n2 = ((Entity)entity).prevPosY + (((Entity)entity).posY - ((Entity)entity).prevPosY) * bWm;
                    final double n3 = ((Entity)entity).prevPosZ + (((Entity)entity).posZ - ((Entity)entity).prevPosZ) * bWm;
                    final float n4 = ((Entity)entity).prevRotationYaw + (((Entity)entity).pl - ((Entity)entity).prevRotationYaw) * bWm;
                    final long n5 = (long)(((Entity)entity).isInvisible() ? 1 : 0) << 32;
                    ((Entity)entity).setInvisible(false);
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
                    ((Entity)entity).setInvisible((int)(n5 >>> (0xFFFFFFA4 ^ 0xFFFFFF9A) - 30) != 0);
                }
            }
            RenderHelper.disableStandardItemLighting();
            cr.aEg.entityRenderer.IU();
        });
    }

    public cr(final cn cn) {
        super(cn);
    }

    static {
        o0Oo000O0oO();
    }
}
