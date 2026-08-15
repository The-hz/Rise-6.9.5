package com.alan.clients.module.impl.movement.terrainspeed;

import com.alan.clients.module.impl.combat.KillAura;
import com.alan.clients.module.impl.movement.Speed;
import com.alan.clients.module.impl.movement.TerrainSpeed;
import com.alan.clients.module.impl.player.Scaffold;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.other.MoveEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import com.alan.clients.util.player.PlayerUtil;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.potion.Potion;

public final class WatchdogTerrainSpeed extends Mode<TerrainSpeed> {
    private int SE;
    private int SF;
    @EventLink
    public final Listener<StrafeEvent> onStrafe = var1x -> {
        if (PlayerUtil.o(aEg.thePlayer.posX, aEg.thePlayer.posY - 0.5, aEg.thePlayer.posZ) instanceof BlockSlab
            && aEg.thePlayer.posY == Math.floor(aEg.thePlayer.posY) + 0.5
            && !this.e(Scaffold.class).isEnabled()
            && !this.e(Speed.class).isEnabled()
            && this.e(KillAura.class).jE == null
            && !aEg.gameSettings.keyBindBack.isKeyDown()) {
            if (aEg.thePlayer.isPotionActive(Potion.moveSpeed)) {
                double[] adouble = new double[]{0.276, 0.309, 0.349, 0.3967};
            }

            this.SF = 0;
        } else {
            this.SF++;
            if (this.SF == 1) {
                var1x.setFriction(var1x.getFriction() * 0.9F);
            }
        }

        if (PlayerUtil.o(aEg.thePlayer.posX, aEg.thePlayer.posY - 0.5, aEg.thePlayer.posZ) instanceof BlockStairs
            && !this.e(Scaffold.class).isEnabled()
            && !this.e(Speed.class).isEnabled()
            && this.e(KillAura.class).jE == null
            && aEg.gameSettings.keyBindForward.isKeyDown()) {
            if (aEg.thePlayer.posY == Math.floor(aEg.thePlayer.posY) + 0.5 || this.SE == 0) {
                var1x.setFriction((float)(var1x.getFriction() * 3.98));
                this.SE = 0;
            }
        } else {
            this.SE++;
            if (this.SE == 1) {
                MoveUtil.stop();
            }
        }
    };
    @EventLink
    public final Listener<MoveEvent> onMove = var1x -> {
        if (this.SE < 2) {
            var1x.setPosY(-0.0784);
            aEg.gameSettings.keyBindJump.setPressed(false);
        }
    };

    public WatchdogTerrainSpeed(String var1, TerrainSpeed terrainSpeed) {
        super(var1, terrainSpeed);
    }
}
