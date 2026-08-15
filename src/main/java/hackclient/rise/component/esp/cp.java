package hackclient.rise.component.esp;

import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.render.RenderUtil;
import hackclient.rise.aip;
import com.alan.clients.component.impl.render.espcomponent.api.ESP;
import com.alan.clients.component.impl.render.espcomponent.api.ESPColor;
import java.awt.Color;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import org.lwjgl.opengl.GL11;

public class cp extends ESP implements InstanceAccess {
    int hV = 255;

    public cp(ESPColor var1) {
        super(var1);
    }

    public cp(EntityLivingBase var1, ESPColor var2) {
        super(var2);
        this.target = var1;
    }

    @Override
    public void cp() {
        EntityLivingBase entitylivingbase = (EntityLivingBase)this.target;
        if (aEg.getRenderManager() != null && entitylivingbase != null) {
            GL11.glPushMatrix();
            GL11.glEnable(3042);
            GL11.glLineWidth(1.8F);
            GL11.glBlendFunc(770, 771);
            GL11.glEnable(2848);
            GlStateManager.depthMask(true);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glDisable(3553);
            GL11.glEnable(2848);
            GL11.glDisable(2929);
            GL11.glDepthMask(false);
            float f = aEg.timer.bWm;
            double d0 = this.target.lastTickPosX + (this.target.posX - this.target.lastTickPosX) * f;
            double d1 = this.target.lastTickPosY + (this.target.posY - this.target.lastTickPosY) * f;
            double d2 = this.target.lastTickPosZ + (this.target.posZ - this.target.lastTickPosZ) * f;
            float f1 = this.target.width / 1.15F;
            float f2 = this.target.height + (this.target.isSneaking() ? -0.2F : 0.1F);
            boolean flag = false;
            if (entitylivingbase.hurtTime > 0) {
                flag = true;
                this.hV = 0;
                if (entitylivingbase.hurtTime <= 10) {
                    flag = true;
                }
            }

            if (this.hV <= 23) {
                flag = true;
            }

            this.hV++;
            RenderUtil.color(aip.d(flag ? Color.red : this.rz().rA(), 60));
            RenderUtil.drawBoundingBox(new AxisAlignedBB(d0 - f1 + 0.1, d1 + f2 + 0.1, d2 - f1 + 0.1, d0 + f1 - 0.1, d1, d2 + f1 - 0.1));
            GL11.glDisable(2848);
            GL11.glEnable(3553);
            GL11.glEnable(2929);
            GL11.glDepthMask(true);
            GL11.glDisable(3042);
            GL11.glDisable(3042);
            GL11.glDisable(2848);
            GL11.glPopMatrix();
            RenderUtil.color(Color.WHITE);
        }
    }
}
