package com.alan.clients.module.impl.movement.phase;

import com.alan.clients.module.impl.movement.Phase;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PushOutOfBlockEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.other.BlockAABBEvent;
import com.alan.clients.newevent.impl.other.TickEvent;
import com.alan.clients.value.Mode;
import net.minecraft.block.BlockLiquid;

public class BlocksMCPhase extends Mode<Phase> {
    private int NP = 1;
    @EventLink
    public final Listener<TickEvent> NQ = var1x -> {
        if (aEg.thePlayer != null && aEg.theWorld != null) {
            switch (this.NP) {
                case 1:
                    if (aEg.gameSettings.keyBindJump.isKeyDown() && !aEg.theWorld.isAirBlock(aEg.thePlayer.getPosition())) {
                        aEg.thePlayer.motionY = 0.42;
                        this.NP++;
                    }

                    aEg.thePlayer.onGround = true;
                    break;
                case 2:
                    aEg.thePlayer.motionY = 0.33;
                    this.NP++;
                    break;
                case 3:
                    aEg.thePlayer.motionY = 0.25;
                    this.NP++;
            }

            if (this.NP > 3 || this.NP == 0) {
                this.NP = 1;
            }

            aEg.thePlayer.noClip = true;
        }
    };
    @EventLink
    public final Listener<StrafeEvent> NR = var0 -> {
        if (aEg.thePlayer != null) {
            if (aEg.thePlayer.isSneaking()) {
                var0.setSpeed(0.179);
            }
        }
    };
    @EventLink
    public final Listener<BlockAABBEvent> NS = var0 -> {
        if (aEg.thePlayer != null) {
            if (!(var0.df() instanceof BlockLiquid)) {
                if (var0.dg().getY() >= aEg.thePlayer.posY) {
                    var0.a(null);
                }
            }
        }
    };
    @EventLink
    public final Listener<PushOutOfBlockEvent> NT = var0 -> var0.setCancelled();

    public BlocksMCPhase(String var1, Phase var2) {
        super(var1, var2);
    }

    @Override
    public void onEnable() {
        this.NP = 1;
        if (aEg.thePlayer != null) {
            aEg.thePlayer.motionY = 0.0;
        }
    }

    @Override
    public void onDisable() {
        if (aEg.thePlayer != null) {
            aEg.thePlayer.noClip = false;
        }

        this.NP = 1;
    }
}
