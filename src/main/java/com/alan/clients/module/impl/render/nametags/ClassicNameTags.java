package com.alan.clients.module.impl.render.nametags;

import com.alan.clients.component.impl.render.ProjectionComponent;
import com.alan.clients.module.impl.player.HealthBypass;
import com.alan.clients.module.impl.render.NameTags;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import hackclient.rise.adv;
import hackclient.rise.agd;
import hackclient.rise.aih;
import hackclient.rise.bv;
import hackclient.rise.bx;
import hackclient.rise.gg;
import java.awt.Color;
import java.util.List;
import javax.vecmath.Vector4d;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;

public class ClassicNameTags extends Mode<NameTags> {
    private final BooleanValue atv = new BooleanValue("Show Team Tag", this, false);
    private final BooleanValue atw = new BooleanValue("Show Target Tag", this, false);
    private final BooleanValue atx = new BooleanValue("Show Friend Tag", this, false);
    private final BooleanValue aty = new BooleanValue("Shortened Tags", this, false);
    @EventLink
    public final Listener<Render2DEvent> atz = var1x -> {
        agd agd = aEg.fontRendererObj;
        GlStateManager.pushMatrix();
        List list = bv.b(this.wj().aoZ.wo(), this.wj().apa.wo(), this.wj().apb.wo(), this.wj().apc.wo(), this.wj().apd.wo(), true);
        if (aEg.gameSettings.thirdPersonView != 0 && this.wj().aoZ.wo()) {
            list.add(aEg.thePlayer);
        }

        for (EntityLivingBase entitylivingbase : (Iterable<EntityLivingBase>)list) {
            HealthBypass healthbypass = this.e(HealthBypass.class);
            float f = healthbypass != null && healthbypass.isEnabled() ? HealthBypass.B(entitylivingbase) : entitylivingbase.getHealth();
            String s = entitylivingbase.getDisplayName().getFormattedText() + " §7[§4❤" + Math.round(f) + "§7]";
            if (this.atv.wo() && aih.D(entitylivingbase)) {
                s = "§a§l" + (this.aty.wo() ? "[TM]" : "[TEAM]") + "§r " + s;
            }

            if (this.atw.wo() && bx.n(entitylivingbase.getName())) {
                s = "§4§l" + (this.aty.wo() ? "[T]" : "[TARGET]") + "§r " + s;
            }

            if (this.atx.wo() && bx.isFriend(entitylivingbase.getName())) {
                s = "§b§l" + (this.aty.wo() ? "[F]" : "[FRIEND]") + "§r " + s;
            }

            entitylivingbase.Tc();
            Vector4d vector4d = ProjectionComponent.e(entitylivingbase);
            if (vector4d != null) {
                float f1 = 2.0F;
                byte b0 = 8;
                float f2 = agd.getStringWidth(s);
                float f3 = (float)(vector4d.x + (vector4d.z - vector4d.x) / 2.0);
                float f4 = (float)vector4d.y - b0;
                String s1 = s;
                this.b(gg.REGULAR).c(() -> {
                    double d0 = f3 - f2 / 2.0F - f1;
                    double d1 = f4 - f1 - 3.0F;
                    double d2 = f2 + f1 * 2.0F;
                    double d3 = b0 + f1 * 2.0F;
                    this.rz();
                    RenderUtil.d(d0, d1, d2, d3, adv.rK());
                    float f5 = f3 - f2 / 2.0F;
                    agd.b(s1, f5 + 0.5F, f4 - 2.0F, Color.WHITE.getRGB());
                });
            }
        }

        GlStateManager.popMatrix();
    };

    public ClassicNameTags(String var1, NameTags var2) {
        super(var1, var2);
    }
}
