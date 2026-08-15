package com.alan.clients.module.impl.movement;

import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PostStrafeEvent;
import com.alan.clients.newevent.impl.other.TickEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.NumberValue;
import hackclient.rise.aka;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer.C05PacketPlayerLook;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;

@ModuleInfo(aliases = {"module.movement.stuck.name", "stasis"}, description = "module.movement.stuck.description", category = Category.MOVEMENT)
public class Stuck extends Module {
    private aka savedMotion;
    private final BooleanValue rotations = new BooleanValue("Rotate", this, false);
    private final BooleanValue test = new BooleanValue("Test", this, false);
    private final NumberValue pulseTicks = new NumberValue("Pulse Ticks", this, 0, 0, 30, 1);
    private boolean EG;
    private int EH;
    private int EI;
    @EventLink
    public final Listener<PostStrafeEvent> onPostStrafe = var1 -> {
        if (this.EG) {
            MoveUtil.stop();
            aEg.thePlayer.motionY = 0.0;
        }
    };
    @EventLink
    public final Listener<TickEvent> onTick = var1 -> {
        int i = this.pulseTicks.wo().intValue();
        if (i <= 0) {
            if (!this.EG) {
                this.hm();
            }

            this.EH = 0;
            this.EI = 0;
        } else if (this.EG) {
            if (++this.EH >= i) {
                this.hn();
                this.EH = 0;
                this.EI = 1;
            }
        } else {
            if (this.EI > 0 && --this.EI <= 0) {
                this.hm();
            }
        }
    };
    @EventLink
    public final Listener<PacketSendEvent> onPacketSend = var1 -> {
        Packet packet = var1.dq();
        if (this.test.wo()
            && this.EG
            && (packet instanceof C02PacketUseEntity || packet instanceof C07PacketPlayerDigging || packet instanceof C08PacketPlayerBlockPlacement)) {
            this.ho();
        }

        if (this.EG && packet instanceof C03PacketPlayer) {
            if (!this.rotations.wo()) {
                var1.setCancelled();
                return;
            }

            if (!(packet instanceof C05PacketPlayerLook)) {
                var1.setCancelled();
            }
        }
    };

    public Stuck() {
    }

    @Override
    public void onEnable() {
        this.EG = false;
        this.EH = 0;
        this.EI = 0;
        this.hm();
    }

    @Override
    public void onDisable() {
        this.EH = 0;
        this.EI = 0;
        this.hn();
    }

    private void hm() {
        if (!this.EG) {
            this.savedMotion = new aka(aEg.thePlayer.motionX, aEg.thePlayer.motionY, aEg.thePlayer.motionZ);
            this.EG = true;
        }
    }

    private void hn() {
        if (this.EG) {
            if (this.savedMotion != null) {
                aEg.thePlayer.motionX = this.savedMotion.x;
                aEg.thePlayer.motionY = this.savedMotion.y;
                aEg.thePlayer.motionZ = this.savedMotion.z;
            }

            this.EG = false;
        }
    }

    private void ho() {
        this.hn();
        this.EH = 0;
        this.EI = 1;
    }
}
