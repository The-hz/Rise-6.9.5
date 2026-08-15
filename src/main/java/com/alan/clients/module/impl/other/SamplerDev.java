package com.alan.clients.module.impl.other;

import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.util.vector.Vector2f;
import hackclient.rise.afi;
import hackclient.rise.aka;
import hackclient.rise.component.bv;
import hackclient.rise.sg;
import java.util.HashMap;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;

@ModuleInfo(aliases = "Sampler (Dev)", description = "module.other.antiafk.description", category = Category.PLAYER)
public final class SamplerDev extends Module {
    private final HashMap<String, Vector2f> VK = new HashMap<>();
    private Vector2f Ul;
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var1 -> {
        EntityLivingBase entitylivingbase = bv.e(6.0);
        EntityPlayerSP entityplayersp = aEg.thePlayer;
        Vector2f vector2f = new Vector2f(entityplayersp.pl % 360.0F, entityplayersp.rotationPitch);
        if (entitylivingbase != null && this.Ul != null) {
            sg sg = new sg(
                new aka(entitylivingbase.posX - entityplayersp.posX, entitylivingbase.posY - entityplayersp.posY, entitylivingbase.posZ - entityplayersp.posZ),
                new Vector2f(vector2f.getX(), vector2f.getY())
            );
            String s = sg.hM();
            if (this.VK.containsKey(s)) {
                Vector2f vector2f1 = this.VK.get(sg.hM());
                aEg.thePlayer.pl = aEg.thePlayer.pl + vector2f1.getX();
                aEg.thePlayer.rotationPitch = aEg.thePlayer.rotationPitch + vector2f1.getY();
                afi.b("Contained: " + s);
                afi.b("Yaw: " + vector2f1.getX() + " Pitch: " + vector2f1.getY());
            } else {
                afi.b("None " + s);
            }
        }

        this.Ul = new Vector2f(vector2f.getX(), vector2f.getY());
    };

    public SamplerDev() {
    }

    @Override
    public void onEnable() {
        if (aEg.gameSettings.keyBindSneak.isKeyDown()) {
            this.VK.clear();
        }
    }
}
