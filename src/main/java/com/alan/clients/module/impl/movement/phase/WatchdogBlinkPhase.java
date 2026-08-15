package com.alan.clients.module.impl.movement.phase;

import com.alan.clients.component.impl.player.BlinkComponent;
import com.alan.clients.module.impl.movement.Phase;
import com.alan.clients.module.impl.player.nofall.WatchdogBlinkNoFall;
import com.alan.clients.newevent.CancellableEvent;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.motion.PushOutOfBlockEvent;
import com.alan.clients.newevent.impl.other.BlockAABBEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.value.Mode;
import net.minecraft.block.BlockBarrier;
import net.minecraft.block.BlockGlass;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.c;
import rip.vantage.commons.util.time.a;

public class WatchdogBlinkPhase extends Mode<Phase> {
    private boolean Op;
    private final a Oq = new a();
    private final WatchdogBlinkNoFall Or = null;
    @EventLink
    public final Listener<PreUpdateEvent> onPreUpdate = var1x -> {
        if (this.Op && !this.Oq.T(4000L)) {
            BlinkComponent.blink();
        }
    };
    @EventLink
    public final Listener<BlockAABBEvent> onBlockAABB = var1x -> {
        if (this.Op && BlinkComponent.enabled && var1x.getBlock() instanceof BlockGlass) {
            var1x.setCancelled();
        }

        if (this.Op && BlinkComponent.enabled && var1x.getBlock() instanceof BlockBarrier) {
            var1x.setCancelled();
        }
    };
    @EventLink
    public final Listener<PacketReceiveEvent> onPacketReceive = var1x -> {
        Packet packet = var1x.getPacket();
        if (packet instanceof c) {
            label55: {
                label56: {
                    {
                        String s = ((c)packet).getChatComponent().getUnformattedText();
                        switch (s) {
                            case "§r§r§r                               §r§f§lSkyWars Duel§r":
                            case "Cages opened! FIGHT!":
                            case "§r§eCages opened! §r§cFIGHT!§r":
                                break label55;
                            case "§r§e§r§eThe game starts in §r§a§r§c3§r§e seconds!§r§e§r":
                            case "The game starts in 3 seconds!":
                            case "§r§eCages open in: §r§c3 §r§eseconds!§r":
                                break label56;
                            case "The games begin in 3 seconds!":
                                break;
                            default:
                                return;
                        }
                    }

                    this.Op = true;
                    this.Oq.aX();
                    return;
                }

                this.Op = true;
                this.Oq.aX();
                return;
            }

            this.Op = false;
        }
    };
    @EventLink
    public final Listener<PushOutOfBlockEvent> onPushOutOfBlock = CancellableEvent::setCancelled;

    public WatchdogBlinkPhase(String var1, Phase phase) {
        super(var1, phase);
    }
}
