package com.alan.clients.module.impl.render;

import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PostMotionEvent;
import com.alan.clients.newevent.impl.render.Render3DEvent;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.util.math.MathUtil;
import com.alan.clients.module.impl.render.jumpcircles.JumpCircle;
import java.awt.Color;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

@ModuleInfo(aliases = "Jump Circles", description = "Draws circles around the player when they jump", category = Category.RENDER)
public final class JumpCircles extends Module {
    private final Queue<JumpCircle> aoy = new ConcurrentLinkedQueue<>();
    private final Animation aoz = new Animation(Easing.EASE_IN_OUT_CUBIC, 300L);
    private boolean aoA = false;
    private static final float aoB = 0.004F;
    private static final int aoC = 2;
    private static final float aoD = 2.0F;
    private static final float aoE = 4.0F;
    @EventLink
    private final Listener<PostMotionEvent> onPostMotion = var1 -> {
        if (aEg.thePlayer.onGround && this.aoA) {
            double d0 = MathUtil.m(aEg.thePlayer.prevPosX, aEg.thePlayer.posX, aEg.timer.bWm);
            double d1 = MathUtil.m(aEg.thePlayer.prevPosY, aEg.thePlayer.posY, aEg.timer.bWm);
            double d2 = MathUtil.m(aEg.thePlayer.prevPosZ, aEg.thePlayer.posZ, aEg.timer.bWm);
            this.aoy.add(new JumpCircle(new Vec3(d0, d1, d2), 0.0, 255.0F));
            this.aoA = false;
        } else if (!aEg.thePlayer.onGround) {
            this.aoA = true;
        }

        Iterator iterator = this.aoy.iterator();

        while (iterator.hasNext()) {
            if (((JumpCircle)iterator.next()).aoJ > 0.0F) {
                return;
            }

            this.aoy.clear();
        }
    };
    @EventLink
    private final Listener<Render3DEvent> onRender3D = var1 -> {
        for (JumpCircle xl : this.aoy) {
            Vec3 vec3 = xl.ma();
            double d1 = vec3.yCoord;
            aEg.getRenderManager();
            double d0 = d1 - RenderManager.bUP;
            xl.y(0.004F);
            if (xl.mb() <= 2.0) {
                this.lY();
                this.aoz.Q(xl.aoJ = xl.aoJ - (float)(xl.mb() / 4.0));
                if (xl.mc() > 0.0F) {
                    xl.p(xl.aoJ = xl.aoJ - (float)(xl.mb() / 4.0));
                }

                this.a(xl, vec3, d0);
                this.lZ();
            } else {
                this.aoy.remove();
            }
        }
    };

    public JumpCircles() {
    }

    @Override
    public void onDisable() {
        if (!this.aoy.isEmpty()) {
            this.aoy.clear();
        }
    }

    private void lY() {
        GL11.glPushMatrix();
        GL11.glDisable(2929);
        GL11.glDisable(3553);
        GL11.glDisable(3008);
        GL11.glEnable(2848);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
    }

    private void a(JumpCircle var1, Vec3 vec, double var3) {
        GL11.glLineWidth(2.0F);
        GL11.glBegin(2);

        for (int i = 0; i <= 360; i++) {
            Color color = this.e(Interface.class).rz().getAccentColor(new Vector2d(i, i));
            double[] adouble = this.c(vec.xCoord, vec.zCoord, i, var1.aoI);
            double d2 = adouble[0];
            aEg.getRenderManager();
            double d0 = d2 - RenderManager.bUO;
            d2 = adouble[1];
            aEg.getRenderManager();
            double d1 = d2 - RenderManager.bUQ;
            GL11.glColor4f(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, var1.mc() / 255.0F);
            GL11.glVertex3d(d0, var3, d1);
        }

        GL11.glEnd();
        GL11.glPopMatrix();
    }

    private void lZ() {
        GlStateManager.disableBlend();
        GL11.glDisable(2848);
        GL11.glEnable(3008);
        GL11.glEnable(3553);
        GL11.glEnable(2929);
    }

    public double[] c(double var1, double var3, double var5, double var7) {
        double d0 = MathHelper.wrapAngleTo180_double(var5);
        double d1 = d0 * Math.PI / 180.0;
        double d2 = var1 - Math.sin(d1) * var7;
        double d3 = var3 + Math.cos(d1) * var7;
        return new double[]{d2, d3};
    }
}
