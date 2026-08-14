package hackclient.rise;

import com.alan.clients.module.impl.combat.KillAura;
import com.alan.clients.module.impl.combat.TeleportAura;
import com.alan.clients.util.interfaces.InstanceAccess;
import java.awt.Color;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class cm implements InstanceAccess {
    public cn hP;
    public Entity by;
    public int hQ;
    public static KillAura gj;
    public static TeleportAura hR;

    public cm(cn var1) {
        this.hP = var1;
        this.hQ = aEg.thePlayer.ticksExisted;
    }

    public void co() {
    }

    public void cp() {
    }

    public void a(EntityPlayer var1, ModelBiped var2) {
    }

    public void cq() {
        if (gj == null) {
            gj = this.e(KillAura.class);
        }

        if (hR == null) {
            hR = this.e(TeleportAura.class);
        }

        if (gj.jE != null) {
            this.by = gj.jE;
        } else if (hR.jE != null) {
            this.by = hR.jE;
        } else {
            this.by = null;
        }
    }

    public Color a(EntityLivingBase var1) {
        Color color = this.hP.cr();
        if (var1 == null) {
            return color;
        }

        if (var1.hurtTime > 0) {
            color = this.hP.cs();
        } else if (this.by == var1) {
            color = this.hP.ct();
        }

        return color;
    }
}
