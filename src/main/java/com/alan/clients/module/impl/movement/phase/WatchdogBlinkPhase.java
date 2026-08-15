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
                    label43: {
                        String s = ((c)packet).getChatComponent().getUnformattedText();
                        byte b0 = -1;
                        switch (s.hashCode()) {
                            case -1374273025:
                                if (s.equals("§r§e§r§eThe game starts in §r§a§r§c3§r§e seconds!§r§e§r")) {
                                    byte b3 = 4;
                                    break label56;
                                }
                                break;
                            case -1013464198:
                                if (s.equals("The game starts in 3 seconds!")) {
                                    byte b2 = 3;
                                    break label56;
                                }
                                break;
                            case -815930779:
                                if (s.equals("§r§r§r                               §r§f§lSkyWars Duel§r")) {
                                    boolean flag = true;
                                    break label55;
                                }
                                break;
                            case 445216674:
                                if (s.equals("Cages opened! FIGHT!")) {
                                    b0 = 0;
                                }
                                break;
                            case 1119124025:
                                if (s.equals("§r§eCages open in: §r§c3 §r§eseconds!§r")) {
                                    byte b4 = 5;
                                    break label56;
                                }
                                break;
                            case 1865777181:
                                if (s.equals("§r§eCages opened! §r§cFIGHT!§r")) {
                                    byte b1 = 2;
                                    break label55;
                                }
                                break;
                            case 1915313797:
                                if (s.equals("The games begin in 3 seconds!")) {
                                    byte b5 = 6;
                                    break label43;
                                }
                        }

                        switch (b0) {
                            case 0:
                            case 1:
                            case 2:
                                break label55;
                            case 3:
                            case 4:
                            case 5:
                                break label56;
                            case 6:
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

    public WatchdogBlinkPhase(String var1, Phase var2) {
        super(var1, var2);
    }
}
