package com.alan.clients.module.impl.movement;

import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.module.impl.combat.KillAura;
import com.alan.clients.module.impl.player.Scaffold;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.JumpEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.other.WorldChangeEvent;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.newevent.impl.render.Render3DEvent;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.NumberValue;
import hackclient.rise.ahf;
import hackclient.rise.aip;
import hackclient.rise.aiu;
import hackclient.rise.aka;
import hackclient.rise.bv;
import hackclient.rise.gg;
import java.util.List;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

@ModuleInfo(aliases = "module.movement.targetstrafe.name", description = "module.movement.targetstrafe.description", category = Category.MOVEMENT)
public class TargetStrafe extends Module {
    private final NumberValue EM = new NumberValue("Range", this, 1, 0.2, 6, 0.1);
    private final BooleanValue EN = new BooleanValue("Hold Jump", this, true);
    private final BooleanValue EO = new BooleanValue("Hold Jump Speed or Flight only", this, true, () -> !this.EN.wo());
    private final BooleanValue EP = new BooleanValue("Auto third person camera", this, false);
    private final BooleanValue EQ = new BooleanValue("Circle", this, true);
    private final BooleanValue ER = new BooleanValue("Glow", this, false);
    private final NumberValue ES = new NumberValue("Dots", this, 1, 1, 20, 1);
    private final NumberValue ET = new NumberValue("Thickness", this, 1.5, 1, 10, 0.5);
    private final BooleanValue EU = new BooleanValue("Behind", this, false);
    private float yaw;
    private EntityLivingBase target;
    private boolean cp;
    private boolean EV;
    private boolean dj;
    private boolean EW = false;
    @EventLink(cH = 1)
    public final Listener<WorldChangeEvent> EX = var1 -> {
        this.EW = false;
        aEg.gameSettings.thirdPersonView = 0;
    };
    @EventLink(cH = 1)
    public final Listener<Render2DEvent> EY = var1 -> {
        if (this.target == null) {
            if (aEg.gameSettings.thirdPersonView == 1 && this.EW) {
                this.EW = false;
                aEg.gameSettings.thirdPersonView = 0;
            }
        } else {
            if (this.EP.wo()) {
                aEg.gameSettings.thirdPersonView = 1;
                this.EW = true;
            }
        }
    };
    @EventLink(cH = 3)
    public final Listener<JumpEvent> EZ = var1 -> {
        if (this.target != null && this.dj) {
            var1.setYaw(this.yaw);
        }
    };
    @EventLink(cH = 3)
    public final Listener<StrafeEvent> Fa = var1 -> {
        if (this.target != null && this.dj) {
            var1.setYaw(this.yaw);
        }
    };
    @EventLink(cH = 3)
    public final Listener<PreUpdateEvent> Fb = var1 -> {
        Module module = this.e(Scaffold.class);
        KillAura killaura = this.e(KillAura.class);
        if (module != null && !module.isEnabled() && killaura != null && killaura.isEnabled()) {
            this.dj = true;
            Module module1 = this.e(Speed.class);
            Module module2 = this.e(Flight.class);
            if ((!this.EN.wo() || aEg.gameSettings.keyBindJump.isKeyDown())
                && (!this.EO.wo() || module1 != null && module1.isEnabled() || module2 != null && module2.isEnabled())) {
                if (this.EN.wo() || module1 != null && module1.isEnabled() || module2 != null && module2.isEnabled()) {
                    List list = bv.f(this.EM.wo().doubleValue() + 6.0);
                    if (list.isEmpty()) {
                        this.target = null;
                    } else {
                        if (this.EP.wo()) {
                            aEg.gameSettings.thirdPersonView = 1;
                            this.EW = true;
                        }

                        this.target = (EntityLivingBase)list.get(0);
                        if (this.target != null) {
                            boolean flag = aEg.gameSettings.keyBindLeft.isKeyDown();
                            boolean flag1 = aEg.gameSettings.keyBindRight.isKeyDown();
                            if (flag && !flag1) {
                                this.cp = true;
                            } else if (flag1 && !flag) {
                                this.cp = false;
                            }

                            if (this.EU.wo()) {
                                this.yaw = this.target.pl + 180.0F;
                            } else {
                                this.yaw = aiu.y(this.target).getX() + 135 * (this.cp ? -1 : 1);
                            }

                            double d0 = this.EM.wo().doubleValue() + Math.random() / 100.0;
                            double d1 = -MathHelper.sin((float)Math.toRadians(this.yaw)) * d0 + this.target.posX;
                            double d2 = MathHelper.cos((float)Math.toRadians(this.yaw)) * d0 + this.target.posZ;
                            this.yaw = aiu.d(new aka(d1, this.target.posY, d2)).getX();
                            aEg.thePlayer.pp = this.yaw;
                        }
                    }
                } else {
                    this.target = null;
                }
            } else {
                this.target = null;
            }
        } else {
            this.dj = false;
            this.target = null;
        }
    };
    @EventLink(cH = 1)
    public final Listener<Render3DEvent> Fc = var1 -> {
        if (this.EQ.wo() && this.target != null && this.dj) {
            this.j(var1.getPartialTicks());
        }
    };

    public TargetStrafe() {
    }

    @Override
    public void onEnable() {
        this.EW = false;
    }

    private void j(float var1) {
        double d0 = ahf.l(this.target.posX, this.target.lastTickPosX, var1) - aEg.getRenderManager().viewerPosX;
        double d1 = ahf.l(this.target.posY, this.target.lastTickPosY, var1) - aEg.getRenderManager().viewerPosY;
        double d2 = ahf.l(this.target.posZ, this.target.lastTickPosZ, var1) - aEg.getRenderManager().viewerPosZ;
        GlStateManager.pushMatrix();
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.disableDepth();
        GL11.glPointSize(this.ET.wo().floatValue());
        GL11.glEnable(2832);
        GL11.glHint(3153, 4354);
        GL11.glBegin(0);
        aip.d(this.rz().rD());
        double d3 = this.EM.wo().doubleValue();
        double d4 = Math.PI * 2;

        for (int i = 0; i < 360; i += this.ES.wo().intValue()) {
            double d5 = i * d4 / 360.0;
            double d6 = d0 + Math.sin(d5) * d3;
            double d7 = d2 + Math.cos(d5) * d3;
            GL11.glVertex3d(d6, d1, d7);
        }

        GL11.glEnd();
        GL11.glDisable(2832);
        GlStateManager.enableDepth();
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
        GlStateManager.popMatrix();
        this.b(gg.BLOOM).c(() -> {
            if (this.ER.wo()) {
                GlStateManager.pushMatrix();
                GlStateManager.disableTexture2D();
                GlStateManager.enableBlend();
                GlStateManager.disableAlpha();
                GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                GlStateManager.disableDepth();
                GL11.glPointSize(this.ET.wo().floatValue() + 2.0F);
                GL11.glEnable(2832);
                GL11.glHint(3153, 4354);
                GL11.glBegin(0);
                aip.d(this.rz().rD());

                for (int j = 0; j < 360; j += this.ES.wo().intValue()) {
                    double d8 = j * d4 / 360.0;
                    double d9 = d0 + Math.sin(d8) * d3;
                    double d10 = d2 + Math.cos(d8) * d3;
                    GL11.glVertex3d(d9, d1, d10);
                }

                GL11.glEnd();
                GL11.glDisable(2832);
                GlStateManager.enableDepth();
                GlStateManager.enableAlpha();
                GlStateManager.enableTexture2D();
                GlStateManager.popMatrix();
            }
        });
    }
}
