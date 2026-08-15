package com.alan.clients.module.impl.movement;

import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.module.impl.combat.KillAura;
import com.alan.clients.module.impl.player.Manager;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.MoveInputEvent;
import com.alan.clients.newevent.impl.motion.JumpEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.impl.BooleanValue;
import hackclient.rise.afi;
import com.alan.clients.util.player.SlotUtil;
import hackclient.rise.en;
import java.util.Iterator;
import java.util.UUID;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.network.play.server.S20PacketEntityProperties.Snapshot;
import net.minecraft.network.play.server.S20PacketEntityProperties;
import net.minecraft.util.BlockPos;

@ModuleInfo(aliases = "module.movement.sprint.name", description = "module.movement.sprint.description", category = Category.MOVEMENT)
public class Sprint extends Module {
    private float jp;
    private float jq;
    public static int Ek;
    private boolean dk;
    private boolean El;
    private BlockPos Em;
    private int En;
    public static boolean Eo;
    public static boolean Ep;
    private final BooleanValue legit = new BooleanValue("Legit", this, true);
    private final BooleanValue watchdogPrediction = new BooleanValue("Watchdog Prediction", this, false);
    @EventLink(value = 2)
    public final Listener<StrafeEvent> onStrafe = var1 -> {
        if (!this.watchdogPrediction.wo() || aEg.gameSettings.keyBindJump.isKeyDown() || Ek < 12 && KillAura.nQ || SlotUtil.vy() == -1 || this.e(Manager.class).kb() && Ek < 12) {
            aEg.gameSettings.cgG.setPressed(true);
            Ek = 0;
            Eo = false;
        }

        if (aEg.thePlayer.cqL == 2 && !KillAura.nQ && this.watchdogPrediction.wo()) {
            aEg.gameSettings.cgG.setPressed(false);
        }

        if (!this.legit.wo() && !this.watchdogPrediction.wo()) {
            aEg.thePlayer.bjQ = MoveUtil.isMoving();
            MoveUtil.preventDiagonalSpeed();
            aEg.thePlayer
                .setSprinting(
                    !this.legit.wo()
                        && MoveUtil.isMoving()
                        && !aEg.thePlayer.isCollidedHorizontally
                        && !aEg.thePlayer.isSneaking()
                        && !aEg.thePlayer.isUsingItem()
                );
        }

        if (this.watchdogPrediction.wo()) {
            if (Ek < 12 && aEg.thePlayer.cqL > 3 && aEg.thePlayer.moveForward > 0.0F && !KillAura.nQ && SlotUtil.vy() != -1 && !this.e(Manager.class).kb()) {
                aEg.thePlayer.inventory.currentItem = SlotUtil.vy();
                Ek++;
                if (Ek > 1) {
                    aEg.gameSettings.cgI.setPressed(true);
                }
            } else if (!aEg.gameSettings.keyBindJump.isKeyDown() && aEg.thePlayer.moveForward > 0.0F && !KillAura.nQ) {
                aEg.gameSettings.cgI.setPressed(false);
            }
        }
    };
    @EventLink
    Listener<JumpEvent> onJump = var0 -> {};
    @EventLink
    Listener<en> Eu = var0 -> {};
    @EventLink
    Listener<PreMotionEvent> onPreMotion = var0 -> {};
    @EventLink
    public final Listener<PacketReceiveEvent> onPacketReceive = var0 -> {
        if (var0.getPacket() instanceof S20PacketEntityProperties s20packetentityproperties && s20packetentityproperties.getEntityId() == aEg.thePlayer.getEntityId()) {
            Iterator iterator = s20packetentityproperties.func_149441_d().iterator();

            while (iterator.hasNext()) {
                Iterator iterator1 = ((Snapshot)iterator.next()).func_151408_c().iterator();

                while (iterator1.hasNext()) {
                    if (!((AttributeModifier)iterator1.next()).getID().equals(UUID.fromString("662A6B8D-DA3E-4C1C-8813-96EA6097278D"))
                        && !aEg.thePlayer.isSprinting()) {
                        Ek = Ek;
                    }
                }
            }
        }
    };
    @EventLink
    Listener<MoveInputEvent> onMoveInput = var1 -> {
        this.jp = var1.getForward();
        this.jq = var1.getStrafe();
    };
    @EventLink
    Listener<PreUpdateEvent> onPreUpdate = var0 -> {
        if (aEg.thePlayer == null || aEg.theWorld == null) {
            ;
        }
    };

    public Sprint() {
    }

    @Override
    public void onEnable() {
        afi.b("don't start on an edge when enabling");
        Eo = false;
        Ep = false;
        this.El = true;
        Ek = 0;
    }

    @Override
    public void onDisable() {
        aEg.thePlayer.setSprinting(aEg.gameSettings.cgG.isKeyDown());
        aEg.thePlayer.bjQ = false;
        Eo = false;
        Ek = 0;
        Ep = false;
        this.El = true;
        aEg.gameSettings.cgI.setPressed(false);
    }
}
