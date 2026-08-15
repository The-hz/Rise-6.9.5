package com.alan.clients.module.impl.player.scaffold.downwards;

import com.alan.clients.module.impl.player.Scaffold;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.value.Mode;
import hackclient.rise.aka;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.util.EnumFacing;
import org.lwjgl.input.Keyboard;

public class VerusDownwards extends Mode<Scaffold> {
    int bj;
    @EventLink(value = 0)
    public final Listener<StrafeEvent> onStrafe = var0 -> {
        if (Keyboard.isKeyDown(aEg.gameSettings.keyBindSneak.getKeyCode())) {
            aEg.gameSettings.cgG.setPressed(false);
            aEg.thePlayer.setSprinting(false);
        }
    };
    @EventLink(value = 3)
    public final Listener<PreUpdateEvent> onPreUpdate = var1x -> {
        if (Keyboard.isKeyDown(aEg.gameSettings.keyBindSneak.getKeyCode()) && aEg.thePlayer.crH <= 20) {
            this.bj++;
            if (aEg.thePlayer.posY % 1.0 != 0.0) {
                this.bj = 0;
            }

            if (aEg.thePlayer.motionY <= 0.0 && this.bj >= 15) {
                this.getParent().agy = this.getParent().agy.v(0.0, -1.0, 0.0);
            }
        } else {
            this.bj = 1000;
        }
    };
    @EventLink
    public final Listener<PacketSendEvent> onPacketSend = var1x -> {
        if (var1x.dq() instanceof C08PacketPlayerBlockPlacement c08packetplayerblockplacement
            && !c08packetplayerblockplacement.getPosition().h(new aka(-1.0, -1.0, -1.0))) {
            c08packetplayerblockplacement.getPlacedBlockDirection();
            EnumFacing.DOWN.getIndex();
        }
    };

    public VerusDownwards(String var1, Scaffold var2) {
        super(var1, var2);
    }

    @Override
    public void onEnable() {
        this.bj = 1000;
    }
}
