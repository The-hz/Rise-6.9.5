package com.alan.clients.module.impl.movement.inventorymove.bypass;

import com.alan.clients.module.impl.movement.InventoryMove;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.JumpEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.other.WorldChangeEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.NumberValue;
import com.alan.clients.util.packet.PacketUtil;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C0EPacketClickWindow;

public class BufferAbuseBypass extends Mode<InventoryMove> {
    private final NumberValue clicksSetting = new NumberValue("Clicks", this, 3, 2, 10, 1);
    private final NumberValue amount = new NumberValue("Amount", this, 5, 1, 10, 1);
    private final ConcurrentLinkedQueue<Packet<?>> Jp = new ConcurrentLinkedQueue<>();
    private boolean Jq;
    private boolean GU;
    private int Jr;
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var1x -> {
        if (this.ht()) {
            if (!this.GU) {
                if (!this.Jq) {
                    this.Jq = true;
                } else {
                    for (int i = 0; i < this.amount.wo().intValue(); i++) {
                        PacketUtil.m(new C0EPacketClickWindow());
                    }

                    this.Jp.forEach(PacketUtil::m);
                    this.Jp.clear();
                    this.GU = true;
                }
            }
        } else {
            this.Jq = false;
            this.GU = false;
        }
    };
    @EventLink
    public final Listener<StrafeEvent> onStrafe = var1x -> {
        if (this.ht() && !this.GU) {
            var1x.setCancelled();
        }
    };
    @EventLink
    public final Listener<JumpEvent> onJump = var1x -> {
        if (this.ht() && !this.GU) {
            var1x.setCancelled();
        }
    };
    @EventLink
    public final Listener<PacketSendEvent> onPacketSend = var1x -> {
        Packet packet = var1x.dq();
        if (packet instanceof C0EPacketClickWindow) {
            if (this.ht() && !this.GU) {
                var1x.setCancelled();
                this.Jp.add(packet);
                return;
            }

            this.Jr++;
        }
    };
    @EventLink
    public final Listener<WorldChangeEvent> onWorldChange = var1x -> this.Jp.clear();
    private final KeyBinding[] Jx = new KeyBinding[]{
        aEg.gameSettings.keyBindForward,
        aEg.gameSettings.keyBindBack,
        aEg.gameSettings.keyBindRight,
        aEg.gameSettings.keyBindLeft,
        aEg.gameSettings.keyBindJump
    };
    @EventLink
    public final Listener<PreUpdateEvent> onPreUpdate = var1x -> {
        if (!(aEg.currentScreen instanceof GuiChat) && aEg.currentScreen != this.getStandardClickGUI()) {
            for (KeyBinding keybinding : this.Jx) {
                keybinding.setPressed(GameSettings.isKeyDown(keybinding));
            }
        }
    };

    public BufferAbuseBypass(String var1, InventoryMove inventoryMove) {
        super(var1, inventoryMove);
    }

    private boolean ht() {
        return this.Jr > 0 && this.Jr % this.clicksSetting.wo().intValue() == 0;
    }
}
