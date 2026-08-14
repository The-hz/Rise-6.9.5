package com.alan.clients.module.impl.player;

import com.alan.clients.component.impl.player.RotationComponent;
import com.alan.clients.component.impl.player.rotationcomponent.MovementFix;
import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.other.TickEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.impl.BooleanValue;
import hackclient.rise.ahj;
import hackclient.rise.aih;
import hackclient.rise.aiu;
import hackclient.rise.bb;
import java.util.HashSet;
import java.util.UUID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.network.play.client.C02PacketUseEntity.Action;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.m;
import rip.vantage.commons.util.time.a;

@ModuleInfo(aliases = "module.player.antifireball.name", description = "module.player.antifireball.description", category = Category.PLAYER)
public class AntiFireBall extends Module {
    private final BooleanValue aaS = new BooleanValue("Rotate", this, true);
    private final BooleanValue aaT = new BooleanValue("Movement Correction", this, true, () -> !this.aaS.wo());
    private final BooleanValue aaU = new BooleanValue("Bad Packets Check", this, false);
    public final a aaV = new a();
    public int aaW = 0;
    private final HashSet<UUID> aaX = new HashSet<>();
    @EventLink(cH = -100)
    public final Listener<PreUpdateEvent> aaY = var1 -> this.js();
    @EventLink(cH = -100)
    public final Listener<TickEvent> aaZ = var1 -> this.js();

    public AntiFireBall() {
    }

    public final void js() {
        if ((!bb.aW() || !this.aaU.wo()) && this.aaV.T(this.aaW)) {
            for (Entity entity : aEg.theWorld.loadedEntityList) {
                if (entity instanceof EntityFireball && entity.getDistanceToEntity(aEg.thePlayer) < 6.0F) {
                    if (this.aaS.wo()) {
                        RotationComponent.setRotations(aiu.y(entity), 10.0, this.aaT.wo() ? MovementFix.NORMAL : MovementFix.OFF);
                    }

                    MoveUtil.strafe(0.0);
                    if (entity.getDistanceToEntity(aEg.thePlayer) <= 3.0F && !this.aaX.contains(entity.getUniqueID())) {
                        ahj.l(new m());
                        ahj.l(new C02PacketUseEntity(entity, Action.ATTACK));
                        this.aaX.add(entity.getUniqueID());
                        break;
                    }

                    aih.h(0, true);
                    aih.h(0, false);
                    break;
                }
            }
        }
    }
}
