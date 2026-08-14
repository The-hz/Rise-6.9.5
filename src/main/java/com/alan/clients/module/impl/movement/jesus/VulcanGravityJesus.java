package com.alan.clients.module.impl.movement.jesus;

import com.alan.clients.module.impl.movement.Jesus;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import net.minecraft.potion.Potion;

public class VulcanGravityJesus extends Mode<Jesus> {
    private boolean Kl = true;
    private boolean gD = true;
    private int Km = 0;
    private double gX = 50.0;
    @EventLink
    public final Listener<PreMotionEvent> Kn = var1x -> {
        if (!aEg.gameSettings.keyBindJump.isPressed()
            && aEg.thePlayer.isInWater()
            && this.Kl
            && aEg.thePlayer.posY % 1.0 != 0.0
            && aEg.thePlayer.posY * 2.0 % 1.0 != 0.0) {
            aEg.thePlayer.setPosition(aEg.thePlayer.posX, aEg.thePlayer.posY - 0.85, aEg.thePlayer.posZ);
            this.Kl = false;
        }

        if (aEg.thePlayer.isInWater() && !aEg.gameSettings.keyBindJump.isKeyDown() && aEg.thePlayer.posY % 1.0 != 0.0 && aEg.thePlayer.posY * 2.0 % 1.0 != 0.0) {
            MoveUtil.strafe(0.34 - Math.random() / 1000.0);
            aEg.thePlayer.motionY = 0.0;
        }

        if (this.Kl) {
            this.gX = aEg.thePlayer.posY - 1.6;
        }

        if (aEg.thePlayer.isInWater()) {
            this.Km = 0;
        }

        if (this.Km < 20) {
            MoveUtil.strafe();
        }

        this.Km++;
        if (!aEg.gameSettings.keyBindJump.isKeyDown() && !aEg.gameSettings.keyBindJump.isPressed()) {
            this.gD = false;
        } else {
            this.gD = true;
        }

        if (this.gD && aEg.thePlayer.isInWater() && !aEg.gameSettings.keyBindJump.isKeyDown() && !aEg.gameSettings.keyBindJump.isPressed()) {
            aEg.thePlayer.setPosition(aEg.thePlayer.posX, this.gX, aEg.thePlayer.posZ);
        }

        if (aEg.thePlayer.isPotionActive(Potion.moveSpeed) && aEg.thePlayer.isInWater() && !aEg.gameSettings.keyBindJump.isKeyDown()) {
            MoveUtil.strafe(0.05 * (1 + aEg.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier()) + 0.34 - Math.random() / 1000.0);
        }

        if (!aEg.gameSettings.keyBindJump.isKeyDown() && aEg.thePlayer.isInWater() && aEg.thePlayer.posY % 1.0 != 0.0 && aEg.thePlayer.posY * 2.0 % 1.0 != 0.0) {
            aEg.thePlayer.setPosition(aEg.thePlayer.posX, this.gX, aEg.thePlayer.posZ);
        }

        if (aEg.gameSettings.keyBindJump.isKeyDown() && aEg.thePlayer.isInWater()) {
            aEg.thePlayer.motionY = 0.6;
            MoveUtil.strafe(0.1);
        }

        if (aEg.thePlayer.isInWater()
            && !aEg.gameSettings.keyBindJump.isKeyDown()
            && !aEg.gameSettings.keyBindJump.isPressed()
            && aEg.thePlayer.posY % 1.0 != 0.0
            && aEg.thePlayer.posY * 2.0 % 1.0 != 0.0) {
            aEg.thePlayer.setPosition(aEg.thePlayer.posX, this.gX - 0.2, aEg.thePlayer.posZ);
        }

        if (!aEg.thePlayer.isInWater() && !this.Kl && aEg.thePlayer.posY % 1.0 != 0.0 && aEg.thePlayer.posY * 2.0 % 1.0 != 0.0) {
            this.Kl = true;
        }
    };

    public VulcanGravityJesus(String var1, Jesus var2) {
        super(var1, var2);
    }
}
