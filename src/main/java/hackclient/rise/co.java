package hackclient.rise;

import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.render.RenderUtil;
import java.awt.Color;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import org.lwjgl.opengl.GL11;

public class co extends cm implements InstanceAccess {
    public co(cn var1) {
        super(var1);
    }

    public co(EntityLivingBase var1, cn var2) {
        super(var2);
        this.by = var1;
    }

    @Override
    public void cp() {
        EntityLivingBase entitylivingbase = (EntityLivingBase)this.by;
        if (aEg.getRenderManager() != null && entitylivingbase != null) {
            Color color = entitylivingbase.hurtTime > 0 ? Color.red : this.rz().rA();
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
            double d0 = this.by.lastTickPosX + (this.by.posX - this.by.lastTickPosX) * f;
            double d1 = this.by.lastTickPosY + (this.by.posY - this.by.lastTickPosY) * f + entitylivingbase.getEyeHeight() * 1.2;
            double d2 = this.by.lastTickPosZ + (this.by.posZ - this.by.lastTickPosZ) * f;
            float f1 = this.by.width;
            float f2 = this.by.height + (this.by.isSneaking() ? -0.2F : 0.1F);
            RenderUtil.color(aip.d(color, 40));
            RenderUtil.drawBoundingBox(new AxisAlignedBB(d0 - f1 / 1.75, d1, d2 - f1 / 1.75, d0 + f1 / 1.75, d1 + 0.1, d2 + f1 / 1.75));
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
