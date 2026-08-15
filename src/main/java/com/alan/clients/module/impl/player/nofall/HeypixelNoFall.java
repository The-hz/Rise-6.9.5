package com.alan.clients.module.impl.player.nofall;

import com.alan.clients.module.impl.player.NoFall;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.MoveInputEvent;
import com.alan.clients.newevent.impl.motion.JumpEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.other.TeleportEvent;
import com.alan.clients.value.Mode;
import com.alan.clients.util.player.PlayerUtil;
import com.alan.clients.component.impl.player.FallDistanceComponent;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.BlockPos;

public class HeypixelNoFall extends Mode<NoFall> {
    private boolean ahZ;
    private boolean aiz;
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var1x -> {
        if (this.aiz) {
            aEg.gameSettings.keyBindJump.setPressed(true);
        }

        if (this.ahZ) {
            aEg.thePlayer.motionY = 0.0;
            var1x.setOnGround(false);
            var1x.setPosY(var1x.getPosY() - 0.098F);
            aEg.thePlayer.setPositionAndUpdate(aEg.thePlayer.posX, var1x.getPosY(), aEg.thePlayer.posZ);
        } else if (!(aEg.thePlayer.motionY > 0.0) && !(FallDistanceComponent.cY <= 3.0F)) {
            if (PlayerUtil.block(new BlockPos(var1x.getPosX(), var1x.getPosY() + aEg.thePlayer.motionY, var1x.getPosZ())).getMaterial().isSolid()) {
                FallDistanceComponent.cY = 0.0F;
                this.ahZ = true;
                this.aiz = true;
                aEg.gameSettings.keyBindJump.setPressed(true);
            }
        }
    };
    @EventLink(value = -1)
    public final Listener<MoveInputEvent> onMoveInput = var1x -> {
        if (this.aiz) {
            var1x.setJump(true);
        }
    };
    @EventLink(value = -1)
    public final Listener<JumpEvent> onJump = var1x -> {
        if (this.aiz && !this.ahZ && !var1x.isCancelled()) {
            this.kA();
        }
    };
    @EventLink
    public final Listener<TeleportEvent> onTeleport = var1x -> this.ahZ = false;

    public HeypixelNoFall(String var1, NoFall var2) {
        super(var1, var2);
    }

    @Override
    public void onEnable() {
        this.ahZ = false;
        this.aiz = false;
    }

    @Override
    public void onDisable() {
        this.ahZ = false;
        this.kA();
    }

    private void kA() {
        this.aiz = false;
        aEg.gameSettings.keyBindJump.setPressed(GameSettings.isKeyDown(aEg.gameSettings.keyBindJump));
    }
}
