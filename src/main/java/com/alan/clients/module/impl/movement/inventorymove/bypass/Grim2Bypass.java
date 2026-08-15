package com.alan.clients.module.impl.movement.inventorymove.bypass;

import com.alan.clients.module.impl.movement.InventoryMove;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.value.Mode;
import hackclient.rise.en;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;

public final class Grim2Bypass extends Mode<InventoryMove> {
    private final KeyBinding[] JH = new KeyBinding[]{
        aEg.gameSettings.keyBindForward,
        aEg.gameSettings.keyBindBack,
        aEg.gameSettings.keyBindRight,
        aEg.gameSettings.keyBindLeft,
        aEg.gameSettings.keyBindJump
    };
    @EventLink
    public final Listener<en> JI = var0 -> {
        if (aEg.currentScreen instanceof GuiInventory || aEg.currentScreen instanceof GuiChest) {
            aEg.thePlayer.setSprinting(false);
        }
    };
    @EventLink
    private final Listener<PreUpdateEvent> onPreUpdate = var1x -> {
        if (aEg.currentScreen != null && !(aEg.currentScreen instanceof GuiChat) && aEg.currentScreen != this.getStandardClickGUI()) {
            for (KeyBinding keybinding : this.JH) {
                keybinding.setPressed(GameSettings.isKeyDown(keybinding));
            }
        }
    };

    public Grim2Bypass(String var1, InventoryMove var2) {
        super(var1, var2);
    }
}
