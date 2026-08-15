package com.alan.clients.module.impl.combat.mimic;

import com.alan.clients.module.impl.combat.Mimic;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.Mode;
import hackclient.rise.aiu;
import hackclient.rise.bv;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class RotationsMimic extends Mode<Mimic> {
    Vector2f sg = new Vector2f(0.0F, 0.0F);
    Vector2f fu = new Vector2f(0.0F, 0.0F);
    Animation sh = new Animation(Easing.LINEAR, 150L);
    Animation si = new Animation(Easing.LINEAR, 150L);
    @EventLink
    public final Listener<PreUpdateEvent> onPreUpdate = var1x -> {
        EntityLivingBase entitylivingbase = bv.e(6.0);
        if (entitylivingbase != null && aEg.gameSettings.cgK.isKeyDown()) {
            float f = entitylivingbase.pl;
            float f1 = entitylivingbase.rotationPitch;
            float f2 = f - 180.0F;
            float f3 = -f1;
            this.sh.Q(f2);
            this.sg.x = (float)this.sh.sG();
            this.si.Q(f3);
            this.sg.y = (float)this.si.sG();
            Vector2f vector2f = aiu.a(new Vector2f(f2, f3), aiu.y(entitylivingbase), 1000.0);
            Vector2f vector2f1 = aiu.a(
                new Vector2f(f2, f3), aiu.y(entitylivingbase), (Math.abs(vector2f.getX()) + Math.abs(vector2f.getY())) / (vector2f.getX() > 90.0F ? 1.05 : 1.5)
            );
            float f4 = f2 + vector2f1.x;
            float f5 = f3 + vector2f1.y;
            this.fu = new Vector2f(MathHelper.wrapAngleTo180_float(f4 - aEg.thePlayer.pl), f5 - aEg.thePlayer.rotationPitch);
            this.fu.x = this.fu.x + (float)((Math.random() - 0.5) * this.fu.getX() / 10.0);
            this.fu.y = this.fu.y + (float)((Math.random() - 0.5) * this.fu.getY() / 10.0);
        } else {
            this.sh.T(aEg.thePlayer.pl);
            this.si.T(aEg.thePlayer.rotationPitch);
            this.fu = new Vector2f(0.0F, 0.0F);
        }
    };
    private long sk;
    @EventLink
    public final Listener<Render2DEvent> onRender2D = var1x -> {
        double d0 = 50.0 / (System.currentTimeMillis() - this.sk);
        this.sk = System.currentTimeMillis();
        double d1 = aEg.gameSettings.mouseSensitivity * 0.6F + 0.2F;
        double d2 = d1 * d1 * d1 * 8.0;
        double d3 = (int)(this.fu.getX() / d2);
        double d4 = (int)(this.fu.getY() / d2);
        double d5 = d3 * (1.0 / d2) * 6.6666665F;
        double d6 = d4 * (1.0 / d2) * 6.6666665F;
        double d7 = d5 / d0;
        double d8 = d6 / d0;
        aEg.thePlayer.setAngles((float)d7, (float)(d8 * (aEg.gameSettings.invertMouse ? 1.0 : -1.0)));
    };

    public RotationsMimic(String var1, Mimic var2) {
        super(var1, var2);
    }
}
