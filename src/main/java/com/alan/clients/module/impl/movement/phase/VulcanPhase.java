package com.alan.clients.module.impl.movement.phase;

import com.alan.clients.module.impl.movement.Phase;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.PushOutOfBlockEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.other.BlockAABBEvent;
import com.alan.clients.newevent.impl.other.TickEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import hackclient.rise.afi;
import com.alan.clients.util.player.PlayerUtil;
import com.alan.clients.util.player.SlotUtil;
import hackclient.rise.cl;
import net.minecraft.block.BlockAir;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.potion.Potion;
import net.minecraft.util.AxisAlignedBB;

public class VulcanPhase extends Mode<Phase> {
    @EventLink
    public Listener<BlockAABBEvent> onBlockAABB;
    public boolean Oi;
    public boolean El;
    @EventLink
    public Listener<PushOutOfBlockEvent> onPushOutOfBlock;
    public int Og;
    public int qH;
    public int Oh;
    public boolean ys = false;
    public boolean Jq;
    public boolean GQ;
    public boolean JM = false;
    @EventLink
    public Listener<TickEvent> onTick;
    @EventLink
    public Listener<PacketReceiveEvent> onPacketReceive;
    @EventLink
    public Listener<PreMotionEvent> onPreMotion;
    @EventLink
    public Listener<StrafeEvent> onStrafe;

    static {
    }

    @Override
    public void onDisable() {
        this.JM = false;
    }


    @Override
    public void onEnable() {
        this.JM = false;
        this.Jq = true;
        this.GQ = true;
        this.Oh = 0;
        this.Og = 0;
        this.ys = false;
        this.El = true;
        if (aEg.thePlayer.onGround) {
            aEg.thePlayer.setPosition(aEg.thePlayer.posX, aEg.thePlayer.posY - 1.0, aEg.thePlayer.posZ);
            MoveUtil.stop();
        } else {
            afi.b("You must me on the ground to do this");
            this.e(Phase.class).toggle();
        }
    }

    public VulcanPhase(String var1, Phase phase) {
        super(var1, phase);
        this.El = true;
        this.Og = 0;
        this.Oh = 0;
        this.qH = 0;
        this.Oi = false;
        this.Jq = true;
        this.GQ = true;
        this.onPreMotion = var1x -> {
            aEg.thePlayer.cameraYaw = 0.1F;
            if (this.Oh > 25 && PlayerUtil.vk()) {
                double d0;
                int i = (d0 = aEg.thePlayer.motionY - 0.0) == 0.0 ? 0 : (d0 < 0.0 ? -1 : 1);
                aEg.thePlayer.onGround = false;
            }

            if (PlayerUtil.vk()) {
                this.Oh++;
            }

            if (this.Jq && this.Oh < 25) {
                cl.cn();
            }

            if (PlayerUtil.vk() && !this.El && this.GQ) {
                this.GQ = false;
                afi.b("Phased");
            }

            if (PlayerUtil.vk()) {
                ;
            }
        };
        this.onBlockAABB = var1x -> {
            double d0 = 0.0;
            if (PlayerUtil.vk()) {
                var1x.setBoundingBox(null);
                if (!(var1x.getBlock() instanceof BlockAir) && !aEg.gameSettings.keyBindSneak.isKeyDown()) {
                    double d3 = var1x.getBlockPos().getX();
                    double d4 = var1x.getBlockPos().getY();
                    double d5 = var1x.getBlockPos().getZ();
                    if (d4 < aEg.thePlayer.posY) {
                        var1x.setBoundingBox(AxisAlignedBB.fromBounds(-15.0, -1.0, -15.0, 15.0, 1.0, 15.0).offset(d3, d4, d5));
                    }
                }
            } else if (!this.ys) {
                if (var1x.getBlock() instanceof BlockAir && !aEg.thePlayer.isSneaking()) {
                    double d6 = var1x.getBlockPos().getX();
                    double d7 = var1x.getBlockPos().getY();
                    double d8 = var1x.getBlockPos().getZ();
                    if (d7 < aEg.thePlayer.posY) {
                        var1x.setBoundingBox(AxisAlignedBB.fromBounds(-15.0, -1.0, -15.0, 15.0, 1.0, 15.0).offset(d6, d7, d8));
                    }
                }
            } else if (this.ys && !PlayerUtil.vk()) {
                afi.b("Disabled due to not being in a block");
                this.e(Phase.class).toggle();
            }
        };
        this.onTick = var0 -> {};
        this.onStrafe = var1x -> {
            int vx2 = SlotUtil.vx();
            if ((!aEg.gameSettings.keyBindJump.isKeyDown() || aEg.thePlayer.hurtTime <= 0)
                && !aEg.gameSettings.keyBindSneak.isKeyDown()
                && !aEg.gameSettings.keyBindJump.isKeyDown()
                && PlayerUtil.vk()) {
                ;
            }

            if (PlayerUtil.vk()) {
                if (aEg.thePlayer.isPotionActive(Potion.moveSpeed)) {
                    var1x.setSpeed(0.0605 * (1 + aEg.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier()) + 0.306);
                } else {
                    var1x.setSpeed(0.306);
                }
            }

            if (aEg.thePlayer.onGround && this.El && this.ys) {
                aEg.thePlayer.jump();
                this.ys = false;
                this.El = false;
            }

            if (aEg.thePlayer.onGround && !this.ys && !this.El) {
                if (aEg.thePlayer.ticksExisted % 2 != 1 && aEg.thePlayer.moveForward == 0.0F) {
                    MoveUtil.strafe(0.0);
                    var1x.setForward(-1.0F);
                } else {
                    var1x.setForward(1.0F);
                }
            }
        };
        this.onPacketReceive = var1x -> {
            if (var1x.getPacket() instanceof S08PacketPlayerPosLook) {
                this.ys = true;
                this.Og++;
            }

            if (this.Og > 4) {
                this.Jq = false;
            } else {
                this.Jq = true;
            }
        };
        this.onPushOutOfBlock = var0 -> var0.setCancelled();
    }
}
