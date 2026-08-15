package com.alan.clients.module.impl.player.scaffold.sprint;

import com.alan.clients.component.impl.player.RotationComponent;
import com.alan.clients.component.impl.player.SlotComponent;
import com.alan.clients.component.impl.player.rotationcomponent.MovementFix;
import com.alan.clients.module.impl.player.Scaffold;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.MoveInputEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.Mode;
import hackclient.rise.afi;
import hackclient.rise.ahj;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer.C05PacketPlayerLook;
import net.minecraft.network.play.client.C03PacketPlayer.C06PacketPlayerPosLook;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.server.S23PacketBlockChange;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;

public class WatchdogPredictiSprint extends Mode<Scaffold> {
    private float gZ;
    private boolean dk;
    private boolean El;
    private BlockPos Em;
    private int En;
    @EventLink
    public final Listener<PreUpdateEvent> onPreUpdate = var1x -> {
        MathHelper.wrapAngleTo180_float(this.gZ);
        RotationComponent.d(false);
        RotationComponent.setRotations(new Vector2f(this.gZ, 94.0F), 10.0, MovementFix.NORMAL);
    };
    @EventLink
    public final Listener<PacketSendEvent> onPacketSend = var0 -> {
        if (var0.dq() instanceof C03PacketPlayer c03packetplayer
            && (c03packetplayer instanceof C05PacketPlayerLook || c03packetplayer instanceof C06PacketPlayerPosLook)
            && Math.abs(c03packetplayer.getPitch() - 90.0F) < 0.001F) {
            c03packetplayer.setPitch(94.0F);
        }
    };
    @EventLink
    public final Listener<PacketReceiveEvent> onPacketReceive = var1x -> {
        Packet packet = var1x.getPacket();
        if (aEg.thePlayer.ticksExisted >= this.En) {
            this.dk = false;
        }

        if (packet instanceof S23PacketBlockChange) {
            BlockPos blockpos = ((S23PacketBlockChange)packet).getBlockPosition();
            if (!blockpos.equals(this.Em)) {
                this.Em = blockpos;
                this.En = aEg.thePlayer.ticksExisted + 10;
            }

            if (this.El) {
                this.dk = true;
                this.El = false;
            }
        }
    };
    @EventLink
    public final Listener<MoveInputEvent> onMoveInput = var1x -> {
        if (this.dk) {
            var1x.setSneak(true);
        }

        if (this.dk) {
            var1x.setForward(0.0F);
        }
    };

    public WatchdogPredictiSprint(String var1, Scaffold var2) {
        super(var1, var2);
    }

    @Override
    public void onEnable() {
        this.En = aEg.thePlayer.ticksExisted + 10;
        this.El = true;
        this.dk = true;
        SlotComponent slotcomponent = this.d(SlotComponent.class);
        ahj.l(new C08PacketPlayerBlockPlacement(SlotComponent.getItemStack()));
        slotcomponent = this.d(SlotComponent.class);
        ahj.l(new C08PacketPlayerBlockPlacement(SlotComponent.getItemStack()));
        slotcomponent = this.d(SlotComponent.class);
        ahj.l(new C08PacketPlayerBlockPlacement(SlotComponent.getItemStack()));
        MathHelper.wrapAngleTo180_float(this.gZ);
        RotationComponent.d(false);
        double d0 = MathHelper.wrapAngleTo180_double(Math.toDegrees(MoveUtil.direction()));
        MathHelper.wrapAngleTo180_double(Math.toDegrees(Math.atan2(aEg.thePlayer.motionZ, aEg.thePlayer.motionX)) - 90.0);
        boolean flag = Math.abs(d0 % 90.0) <= 10.0 || Math.abs(d0 % 90.0) >= 80.0;
        double d1 = Math.round(d0 / 45.0) * 45.0;
        aEg.thePlayer.pl = (float)d1;
        afi.c(d0);
        if (flag && d0 >= -10.0 && d0 <= 100.0 && aEg.thePlayer.onGround) {
            this.gZ = aEg.thePlayer.pl + 43.0F;
        } else if (flag && aEg.thePlayer.onGround) {
            this.gZ = aEg.thePlayer.pl - 43.0F;
        } else {
            this.gZ = aEg.thePlayer.pl;
        }
    }
}
