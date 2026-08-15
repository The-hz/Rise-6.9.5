package com.alan.clients.module.impl.movement.speed;

import com.alan.clients.component.impl.player.RotationComponent;
import com.alan.clients.component.impl.player.rotationcomponent.MovementFix;
import com.alan.clients.module.impl.combat.velocity.GrimVelocity;
import com.alan.clients.module.impl.movement.Speed;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PostMotionEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.NumberValue;
import com.viaversion.viarewind.protocol.v1_9to1_8.Protocol1_9To1_8;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ServerboundPackets1_9;
import de.florianmichael.vialoadingbase.ViaLoadingBase;
import net.minecraft.entity.EntityLivingBase;

public class GrimSpeed extends Mode<Speed> {
    private final NumberValue boundingBoxSize = new NumberValue("Bounding Box Size", this, 0.4, 0, 1, 0.1);
    private final NumberValue inPlayerSpeed = new NumberValue("in Player Speed", this, 0.08, 0, 0.08, 0.01);
    private final NumberValue moveFlyingIncrease = new NumberValue("Move Flying Increase", this, 1.0E-4, 0, 0.001, 1.0E-5);
    public final BooleanValue fastFall = new BooleanValue("Fast Fall", this, true);
    private int Gq = 0;
    private int Py = 0;
    @EventLink(value = 1)
    public final Listener<PreUpdateEvent> onPreUpdate = var1x -> {
        if (!aEg.thePlayer.onGround) {
            this.Gq++;
        } else {
            this.Gq = 0;
        }

        if (!aEg.thePlayer.isInWeb
            && !aEg.thePlayer.onGround
            && (!aEg.gameSettings.keyBindForward.isKeyDown() || !aEg.gameSettings.keyBindRight.isKeyDown())
            && (!aEg.gameSettings.keyBindForward.isKeyDown() || !aEg.gameSettings.keyBindLeft.isKeyDown())
            && !this.fastFall.wo()) {
            RotationComponent.setRotations(
                new Vector2f((float)(aEg.thePlayer.pl + 45.0F + Math.random()), aEg.thePlayer.rotationPitch), 10.0, MovementFix.NORMAL
            );
        }
    };
    @EventLink(value = 4)
    public final Listener<PreMotionEvent> onPreMotion = var1x -> {
        if (this.fastFall.wo()) {
            if (this.Py == 0) {
                this.Py = var1x.isOnGround() ? 1 : 0;
            } else {
                this.Py = 0;
            }

            var1x.setOnGround(this.Py != 0);
            if (aEg.thePlayer.onGround) {
                aEg.thePlayer.jump();
            }
        }
    };
    @EventLink(value = 4)
    public final Listener<PostMotionEvent> onPostMotion = var1x -> {
        if (this.fastFall.wo()) {
            if (!aEg.thePlayer.onGround && this.Py >= 0) {
                if (this.Gq < 1 || this.Gq > 5) {
                    return;
                }

                this.hp();
                aEg.thePlayer.setSneaking(false);
                if (this.Gq == 2) {
                    aEg.thePlayer.jump();
                }
            }
        }
    };
    @EventLink(value = 4)
    public final Listener<StrafeEvent> onStrafe = var1x -> {
        aEg.theWorld
            .loadedEntityList
            .stream()
            .filter(var0 -> var0 instanceof EntityLivingBase)
            .map(var0 -> (EntityLivingBase)var0)
            .filter(
                var1xx -> var1xx != aEg.thePlayer
                    && aEg.thePlayer
                        .getEntityBoundingBox()
                        .expand(this.boundingBoxSize.wo().doubleValue(), this.boundingBoxSize.wo().doubleValue(), this.boundingBoxSize.wo().doubleValue())
                        .intersectsWith(var1xx.getEntityBoundingBox())
            )
            .forEach(var1xx -> MoveUtil.moveFlying(this.inPlayerSpeed.wo().doubleValue()));
        MoveUtil.moveFlying(this.moveFlyingIncrease.wo().doubleValue());
        if ((!GrimVelocity.dj && (GrimVelocity.tS == 0 || GrimVelocity.tS >= 6) || !aEg.thePlayer.onGround)
            && aEg.thePlayer.hurtTime == 0
            && aEg.thePlayer.onGround
            && aEg.gameSettings.keyBindJump.isKeyDown()) {
            aEg.thePlayer.jump();
        }
    };

    public GrimSpeed(String var1, Speed speed) {
        super(var1, speed);
    }

    @Override
    public void onDisable() {
        aEg.gameSettings.keyBindSneak.setPressed(false);
        aEg.gameSettings.keyBindJump.setPressed(false);
        this.Gq = 0;
        this.Py = 0;
    }

    private void hp() {
        if (ViaLoadingBase.getInstance().getTargetVersion().newerThanOrEqualTo(ProtocolVersion.v1_9)) {
            UserConnection userconnection = Via.getManager().getConnectionManager().getConnections().iterator().next();
            PacketWrapper packetwrapper = PacketWrapper.create(ServerboundPackets1_9.PLAYER_COMMAND, userconnection);
            packetwrapper.write(Types.VAR_INT, aEg.thePlayer.getEntityId());
            packetwrapper.write(Types.VAR_INT, 8);
            packetwrapper.write(Types.VAR_INT, 0);
            packetwrapper.sendToServer(Protocol1_9To1_8.class);
        }
    }
}
