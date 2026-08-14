package com.alan.clients.module.impl.movement.inventorymove.bypass;

import com.alan.clients.component.impl.player.RotationComponent;
import com.alan.clients.component.impl.player.rotationcomponent.MovementFix;
import com.alan.clients.module.impl.movement.InventoryMove;
import com.alan.clients.module.impl.movement.Speed;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.MoveInputEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.other.MoveEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.NumberValue;
import hackclient.rise.bb;
import hackclient.rise.en;
import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C0EPacketClickWindow;
import net.minecraft.network.play.client.q;
import net.minecraft.potion.Potion;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class WatchdogBypass
extends Mode<InventoryMove> {
    private boolean JM = false;
    private boolean JN = false;
    private long JO = 0L;
    private float jp;
    private float jq;
    public static boolean JP;
    public static boolean JQ;
    int dm;
    int JR;
    private final KeyBinding[] JS;
    public final BooleanValue JT;
    public final NumberValue JU;
    public final BooleanValue JV;
    private int JW;
    private int JX;
    private int JY;
    private int JZ;
    private BlockPos Ka;
    private BlockPos Kb;
    private String Kc;
    private String Kd;
    private boolean Ke;
    private boolean Kf;
    @EventLink
    private final Listener<PreMotionEvent> Kg;
    @EventLink
    private final Listener<PacketSendEvent> Kh;
    @EventLink
    public final Listener<PreMotionEvent> Ki;
    @EventLink(cH=3)
    Listener<MoveInputEvent> yv;
    @EventLink(cH=1)
    Listener<en> pb;
    @EventLink(cH=1)
    Listener<PreUpdateEvent> dq;
    @EventLink
    public final Listener<MoveInputEvent> Kj;
    @EventLink
    public final Listener<MoveEvent> Kk;

    public WatchdogBypass(String string, InventoryMove inventoryMove) {
        super(string, inventoryMove);
        this.JS = new KeyBinding[]{WatchdogBypass.aEg.gameSettings.keyBindForward, WatchdogBypass.aEg.gameSettings.keyBindBack, WatchdogBypass.aEg.gameSettings.keyBindRight, WatchdogBypass.aEg.gameSettings.keyBindLeft, WatchdogBypass.aEg.gameSettings.keyBindJump};
        this.JT = new BooleanValue("Prediction Mode", (Mode<?>)this, (Boolean)false);
        this.JU = new NumberValue("Ticks", this, (Number)1, (Number)1, (Number)20, (Number)1);
        this.JV = new BooleanValue("Measure Chest Open", (Mode<?>)this, (Boolean)true);
        this.JX = -1;
        this.JY = -1;
        this.JZ = -1;
        this.Kc = "unknown";
        this.Kd = "unknown";
        this.Kg = preMotionEvent -> {
            if (WatchdogBypass.aEg.currentScreen == null || WatchdogBypass.aEg.currentScreen instanceof GuiChat || WatchdogBypass.aEg.currentScreen == this.getStandardClickGUI()) {
                return;
            }
            boolean cfr_ignored_0 = WatchdogBypass.aEg.currentScreen instanceof GuiChest;
            for (KeyBinding keyBinding : this.JS) {
                keyBinding.setPressed(GameSettings.isKeyDown((KeyBinding)keyBinding));
            }
            if (JQ) {
                int cfr_ignored_1 = WatchdogBypass.aEg.thePlayer.ticksExisted % 2;
            }
        };
        this.Kh = packetSendEvent -> {
            Packet<?> packet = packetSendEvent.dq();
            if (!packetSendEvent.isCancelled() && WatchdogBypass.aEg.thePlayer != null && WatchdogBypass.aEg.theWorld != null && ((Boolean)this.JV.wo()).booleanValue() && packet instanceof C08PacketPlayerBlockPlacement) {
                C08PacketPlayerBlockPlacement c08PacketPlayerBlockPlacement = (C08PacketPlayerBlockPlacement)packet;
                BlockPos blockPos = c08PacketPlayerBlockPlacement.getPosition();
                if (!(WatchdogBypass.aEg.currentScreen instanceof GuiChest) && this.h(blockPos)) {
                    this.Kb = blockPos;
                    this.Kd = "C08 at " + String.valueOf(blockPos);
                    this.Ke = true;
                }
            } else if (!packetSendEvent.isCancelled() && WatchdogBypass.aEg.thePlayer != null && WatchdogBypass.aEg.theWorld != null && ((Boolean)this.JV.wo()).booleanValue() && packet instanceof C02PacketUseEntity) {
                C02PacketUseEntity c02PacketUseEntity = (C02PacketUseEntity)packet;
                Entity entity = c02PacketUseEntity.getEntityFromWorld((World)WatchdogBypass.aEg.theWorld);
                if (!(WatchdogBypass.aEg.currentScreen instanceof GuiChest) && c02PacketUseEntity.getAction() != C02PacketUseEntity.Action.ATTACK && this.o(entity)) {
                    this.Kb = null;
                    this.Kd = "C02 at " + entity.getName() + " (" + entity.getEntityId() + ")";
                    this.Ke = true;
                }
            }
            if (packet instanceof C0EPacketClickWindow) {
                C0EPacketClickWindow c0EPacketClickWindow = (C0EPacketClickWindow)packet;
                if (WatchdogBypass.aEg.currentScreen instanceof GuiInventory && c0EPacketClickWindow.getMode() < 1 && c0EPacketClickWindow.getClickedItem() != null) {
                    JP = true;
                }
            }
        };
        this.Ki = preMotionEvent -> {
            GuiScreen guiScreen;
            if (!(WatchdogBypass.aEg.currentScreen instanceof GuiInventory)) {
                JP = false;
            }
            if ((guiScreen = WatchdogBypass.aEg.currentScreen) instanceof GuiInventory) {
                GuiInventory guiInventory = (GuiInventory)guiScreen;
                if (!JP && !bb.a(false, false, false, false, true)) {
                    WatchdogBypass.aEg.thePlayer.sendQueue.u((Packet)new q(guiInventory.inventorySlots.windowId));
                }
            }
            if ((WatchdogBypass.aEg.currentScreen instanceof GuiChest || JP) && !((Boolean)this.JT.wo()).booleanValue()) {
                if (this.e(Speed.class).isEnabled() && !this.JM) {
                    WatchdogBypass.aEg.thePlayer.motionZ *= -0.1;
                    WatchdogBypass.aEg.thePlayer.motionX *= -0.1;
                    this.JM = true;
                }
                if (WatchdogBypass.aEg.thePlayer.cqL < 10 && !(Math.abs(WatchdogBypass.aEg.thePlayer.posY - (double)Math.round(WatchdogBypass.aEg.thePlayer.posY)) > 0.03) && !(WatchdogBypass.aEg.currentScreen instanceof GuiChest)) {
                    MoveUtil.strafe(0.0365);
                } else if (!WatchdogBypass.aEg.thePlayer.onGround) {
                    MoveUtil.stop();
                } else if (WatchdogBypass.aEg.thePlayer.isPotionActive(Potion.moveSpeed) && 1 + WatchdogBypass.aEg.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() > 1) {
                    MoveUtil.strafe(0.0185 * (double)(1 + WatchdogBypass.aEg.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier()));
                } else if (WatchdogBypass.aEg.thePlayer.isPotionActive(Potion.moveSpeed) && 1 + WatchdogBypass.aEg.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() == 1) {
                    MoveUtil.strafe(0.0635 * (double)(1 + WatchdogBypass.aEg.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier()));
                } else {
                    MoveUtil.strafe(0.09);
                }
                if (WatchdogBypass.aEg.thePlayer.isJumping && WatchdogBypass.aEg.thePlayer.onGround) {
                    MoveUtil.stop();
                } else if (WatchdogBypass.aEg.thePlayer.isJumping) {
                    MoveUtil.stop();
                }
                MoveUtil.preventDiagonalSpeed();
            } else if (this.JM) {
                this.e(Speed.class).setEnabled(true);
                this.JM = false;
            }
            if ((WatchdogBypass.aEg.currentScreen instanceof GuiChest || JP) && ((Boolean)this.JT.wo()).booleanValue() && !WatchdogBypass.aEg.thePlayer.isPotionActive(Potion.moveSpeed)) {
                KeyBinding[] keyBindingArray;
                preMotionEvent.setSprinting(false);
                WatchdogBypass.aEg.gameSettings.cgG.setPressed(false);
                WatchdogBypass.aEg.gameSettings.keyBindJump.setPressed(false);
                KeyBinding[] keyBindingArray2 = keyBindingArray = new KeyBinding[]{WatchdogBypass.aEg.gameSettings.keyBindForward, WatchdogBypass.aEg.gameSettings.keyBindRight, WatchdogBypass.aEg.gameSettings.keyBindBack, WatchdogBypass.aEg.gameSettings.keyBindLeft};
                int n2 = keyBindingArray2.length;
                int n3 = 0;
                while (n3 < n2) {
                    if (keyBindingArray2[n3].isKeyDown()) {
                        ++this.JR;
                    }
                    ++n3;
                }
                return;
            }
            if (!(WatchdogBypass.aEg.currentScreen instanceof GuiChest)) {
                if (!JP) return;
            }
            if ((Boolean)this.JT.wo() == false) return;
            preMotionEvent.setSprinting(false);
        };
        this.yv = moveInputEvent -> {
            this.jp = moveInputEvent.getForward();
            this.jq = moveInputEvent.getStrafe();
        };
        this.pb = en2 -> {
            if (WatchdogBypass.aEg.currentScreen instanceof GuiChest || JP) {
                WatchdogBypass.aEg.thePlayer.setSprinting(false);
            }
        };
        this.dq = preUpdateEvent -> {
            if (WatchdogBypass.aEg.thePlayer == null || WatchdogBypass.aEg.theWorld == null || WatchdogBypass.aEg.thePlayer.ticksExisted < 50) {
                return;
            }
            this.hw();
            this.hv();
            this.hx();
            KeyBinding[] keyBindingArray = new KeyBinding[]{WatchdogBypass.aEg.gameSettings.keyBindForward, WatchdogBypass.aEg.gameSettings.keyBindRight, WatchdogBypass.aEg.gameSettings.keyBindBack, WatchdogBypass.aEg.gameSettings.keyBindLeft};
            int n2 = 0;
            KeyBinding[] keyBindingArray2 = keyBindingArray;
            int n3 = keyBindingArray2.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                if (!keyBindingArray2[i2].isKeyDown()) continue;
                ++n2;
            }
            if ((WatchdogBypass.aEg.currentScreen instanceof GuiChest || JP) && n2 > 1) {
                RotationComponent.setRotations(new Vector2f((float)Math.toDegrees(MoveUtil.g(this.jp, this.jq)), WatchdogBypass.aEg.thePlayer.rotationPitch), 10.0, MovementFix.NORMAL);
            }
        };
        this.Kj = moveInputEvent -> {
            KeyBinding[] keyBindingArray = new KeyBinding[]{WatchdogBypass.aEg.gameSettings.keyBindForward, WatchdogBypass.aEg.gameSettings.keyBindRight, WatchdogBypass.aEg.gameSettings.keyBindBack, WatchdogBypass.aEg.gameSettings.keyBindLeft};
            int n2 = 0;
            KeyBinding[] keyBindingArray2 = keyBindingArray;
            int n3 = keyBindingArray2.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                if (!keyBindingArray2[i2].isKeyDown()) continue;
                ++n2;
            }
            if (JQ && WatchdogBypass.aEg.thePlayer.ticksExisted % 5 != 0 && WatchdogBypass.aEg.currentScreen instanceof GuiChest) {
                moveInputEvent.setStrafe(0.0f);
                moveInputEvent.setForward(0.0f);
            }
            if (!(WatchdogBypass.aEg.currentScreen instanceof GuiChest)) {
                JQ = false;
            }
            if ((WatchdogBypass.aEg.currentScreen instanceof GuiChest || JP) && ((Boolean)this.JT.wo()).booleanValue() && (WatchdogBypass.aEg.thePlayer.isPotionActive(Potion.moveSpeed) || !WatchdogBypass.aEg.thePlayer.onGround)) {
                moveInputEvent.setStrafe(0.0f);
                moveInputEvent.setForward(0.0f);
            } else if (JP && !this.JN) {
                moveInputEvent.setStrafe(0.0f);
                moveInputEvent.setForward(0.0f);
                if (this.JO == 0L) {
                    this.JO = System.currentTimeMillis();
                }
            } else {
                this.JO = 0L;
            }
            if (this.JO != 0L && System.currentTimeMillis() - this.JO >= 60L) {
                this.JN = true;
                this.JO = 0L;
            }
            if (!(WatchdogBypass.aEg.currentScreen instanceof GuiChest) && !JP) {
                this.JN = false;
            }
        };
        this.Kk = moveEvent -> {
            if ((WatchdogBypass.aEg.currentScreen instanceof GuiChest || JP) && !((Boolean)this.JT.wo()).booleanValue() && !WatchdogBypass.aEg.thePlayer.onGround) {
                moveEvent.setPosZ(0.0);
                moveEvent.setPosX(0.0);
            }
        };
    }

    private void hv() {
        if (!this.Kf) {
            return;
        }
        if (WatchdogBypass.aEg.currentScreen instanceof GuiChest) {
            int n2;
            this.JY = n2 = WatchdogBypass.aEg.thePlayer.ticksExisted - this.JX;
            if (this.JZ == -1) {
                this.JZ = WatchdogBypass.aEg.thePlayer.ticksExisted;
            }
            this.Kf = false;
            return;
        }
        if (WatchdogBypass.aEg.thePlayer.ticksExisted - this.JX > 40) {
            this.Kf = false;
        }
    }

    private void hw() {
        if (!this.Ke) {
            return;
        }
        this.JX = WatchdogBypass.aEg.thePlayer.ticksExisted;
        this.Ka = this.Kb;
        this.Kc = this.Kd;
        this.Ke = false;
        this.Kf = true;
    }

    private void hx() {
        if (!(WatchdogBypass.aEg.currentScreen instanceof GuiChest)) {
            this.JZ = -1;
            JQ = false;
            return;
        }
        if (this.JZ == -1) {
            this.JZ = WatchdogBypass.aEg.thePlayer.ticksExisted;
        }
        if (!JQ && this.JY >= 0 && WatchdogBypass.aEg.thePlayer.ticksExisted - this.JZ >= this.JY - ((Number)this.JU.wo()).intValue()) {
            JQ = true;
        }
    }

    private boolean h(BlockPos blockPos) {
        if (blockPos == null) return false;
        if (WatchdogBypass.aEg.theWorld == null) return false;
        if (blockPos.equals((Object)new BlockPos(-1, -1, -1))) {
            return false;
        }
        Block block = WatchdogBypass.aEg.theWorld.getBlockState(blockPos).getBlock();
        if (block == Blocks.chest) return true;
        if (block == Blocks.trapped_chest) return true;
        if (block != Blocks.ender_chest) return false;
        return true;
    }

    private boolean o(Entity entity) {
        if (entity == null) return false;
        if (entity == WatchdogBypass.aEg.thePlayer) {
            return false;
        }
        if (entity instanceof EntityPlayer) {
            if (aEg.getNetHandler().getPlayerInfo(((EntityPlayer)entity).getUniqueID()) != null) return false;
            return true;
        }
        if (entity.adr) return false;
        if (!this.p(entity)) return false;
        return true;
    }

    private boolean p(Entity entity) {
        if (!(Math.abs(entity.posX - entity.lastTickPosX) < 0.03)) return false;
        if (!(Math.abs(entity.posY - entity.lastTickPosY) < 0.03)) return false;
        if (!(Math.abs(entity.posZ - entity.lastTickPosZ) < 0.03)) return false;
        if (!(Math.abs(entity.motionX) < 0.03)) return false;
        if (!(Math.abs(entity.motionY) < 0.03)) return false;
        if (!(Math.abs(entity.motionZ) < 0.03)) return false;
        return true;
    }
}
