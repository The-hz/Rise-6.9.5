package com.alan.clients.module.impl.ghost;

import com.alan.clients.Client;
import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.other.AttackEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.impl.NumberValue;
import hackclient.rise.adz;
import hackclient.rise.aef;
import hackclient.rise.afi;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.client.m;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.MovingObjectPosition;

@ModuleInfo(aliases = "module.ghost.aimbacktrack.name", description = "module.ghost.aimbacktract.description", category = Category.GHOST)
public class AimBacktrack extends Module {
    private final NumberValue backtrack = new NumberValue("Rotation Backtrack Amount", this, 1, 1, 20, 1);
    private adz<Vector2f> AB = new adz<>(1);
    private boolean attacked;
    private int lastSize;
    @EventLink
    public final Listener<PreMotionEvent> AD = var1 -> {
        if (this.lastSize != this.backtrack.wo().intValue()) {
            this.AB = new adz<>(this.backtrack.wo().intValue());
            this.lastSize = this.backtrack.wo().intValue();
        }

        this.AB.add(new Vector2f(var1.getYaw(), var1.getPitch()));
        this.attacked = false;
    };
    @EventLink
    public final Listener<PacketSendEvent> AE = var1 -> {
        if (var1.dq() instanceof m && aEg.objectMouseOver.typeOfHit == MovingObjectType.MISS) {
            for (Vector2f vector2f : this.AB) {
                Reach reach = this.e(Reach.class);
                MovingObjectPosition movingobjectposition = aef.c(vector2f, reach.isEnabled() ? 3.0 + reach.BQ.wo().doubleValue() : 3.0);
                if (movingobjectposition.entityHit != null && !this.attacked && movingobjectposition.entityHit instanceof EntityLivingBase) {
                    AttackEvent attackevent = new AttackEvent((EntityLivingBase)movingobjectposition.entityHit);
                    Client.a.e().d(attackevent);
                    if (attackevent.isCancelled()) {
                        return;
                    }

                    aEg.playerController.attackEntity(aEg.thePlayer, movingobjectposition.entityHit);
                }
            }
        }
    };
    @EventLink
    public final Listener<AttackEvent> AF = var1 -> {
        if (this.attacked) {
            var1.setCancelled();
        }

        this.attacked = true;
    };

    public AimBacktrack() {
    }

    @Override
    public void onEnable() {
        afi.b("this is a blatant module");
    }
}
