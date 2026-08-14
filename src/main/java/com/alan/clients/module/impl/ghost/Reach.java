package com.alan.clients.module.impl.ghost;

import com.alan.clients.component.impl.player.RotationComponent;
import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.other.AttackEvent;
import com.alan.clients.newevent.impl.render.MouseOverEvent;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.BoundsNumberValue;
import com.alan.clients.value.impl.NumberValue;
import hackclient.rise.aef;
import hackclient.rise.ahg;
import hackclient.rise.ea;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.MovingObjectPosition;

@ModuleInfo(aliases = "module.ghost.reach.name", description = "module.ghost.reach.description", category = Category.GHOST)
public class Reach extends Module {
    public final BoundsNumberValue BQ = new BoundsNumberValue("Range", this, 3, 4, 3, 6, 0.01);
    private final NumberValue BR = new NumberValue("Buffer Decrease", this, 1, 0.1, 10, 0.1, () -> !this.bufferAbuse.wo());
    private final NumberValue BS = new NumberValue("Max Buffer", this, 5, 1, 200, 1, () -> !this.bufferAbuse.wo());
    private final BooleanValue bufferAbuse = new BooleanValue("Buffer Abuse", this, false);
    private int BU;
    private int BV;
    private double combo;
    @EventLink
    public final Listener<PreMotionEvent> BW = var1 -> this.BV++;
    @EventLink
    public final Listener<MouseOverEvent> BX = var1 -> {
        double d0 = ahg.l(this.BQ.wo().doubleValue(), this.BQ.wA().doubleValue());
        var1.i(d0);
        if (!this.gR()) {
            MovingObjectPosition movingobjectposition = aef.a(RotationComponent.bH(), d0, var1.dB(), aEg.thePlayer, false);
            if (movingobjectposition != null && movingobjectposition.typeOfHit == MovingObjectType.ENTITY) {
                var1.a(movingobjectposition);
            }
        }
    };
    @EventLink
    public final Listener<ea> BY = var0 -> aEg.objectMouseOver = aef.c(RotationComponent.fk, 4.5);
    @EventLink
    public final Listener<AttackEvent> BZ = var1 -> {
        EntityLivingBase entitylivingbase = var1.dc();
        if (this.bufferAbuse.wo()) {
            if (aef.c(RotationComponent.fk, 3.0).typeOfHit != MovingObjectType.ENTITY) {
                if ((this.BV > 9 || entitylivingbase.getEntityId() != this.BU) && this.combo < this.BS.wo().intValue()) {
                    this.combo++;
                } else {
                    var1.setCancelled();
                }
            } else {
                this.combo = Math.max(0.0, this.combo - this.BR.wo().doubleValue());
            }
        } else {
            this.combo = 0.0;
        }

        this.BU = entitylivingbase.getEntityId();
        this.BV = 0;
    };

    public Reach() {
    }

    private boolean gR() {
        if (!aEg.bgA || aEg.currentScreen != null) {
            return false;
        }

        if (!aEg.gameSettings.cgI.isKeyDown() && !aEg.gameSettings.cgK.isKeyDown()) {
            return false;
        }

        MovingObjectPosition movingobjectposition = aef.a(
            new Vector2f(aEg.thePlayer.pl, aEg.thePlayer.rotationPitch), aEg.playerController.getBlockReachDistance(), 0.0F, aEg.thePlayer, false
        );
        return movingobjectposition != null && movingobjectposition.typeOfHit == MovingObjectType.BLOCK;
    }
}
