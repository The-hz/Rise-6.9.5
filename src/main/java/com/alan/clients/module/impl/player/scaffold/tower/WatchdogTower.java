package com.alan.clients.module.impl.player.scaffold.tower;

import com.alan.clients.Client;
import com.alan.clients.component.impl.player.RotationComponent;
import com.alan.clients.component.impl.player.SlotComponent;
import com.alan.clients.component.impl.player.rotationcomponent.MovementFix;
import com.alan.clients.module.impl.exploit.Disabler;
import com.alan.clients.module.impl.movement.Speed;
import com.alan.clients.module.impl.player.Scaffold;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.KeyboardInputEvent;
import com.alan.clients.newevent.impl.input.MoveInputEvent;
import com.alan.clients.newevent.impl.motion.JumpEvent;
import com.alan.clients.newevent.impl.motion.PostStrafeEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.other.TickEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.Mode;
import com.alan.clients.util.player.PlayerUtil;
import com.alan.clients.util.player.SlotUtil;
import com.alan.clients.util.rotation.RotationUtil;
import hackclient.rise.aka;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;

public class WatchdogTower extends Mode<Scaffold> {
    public static int qH;
    int dm;
    public static int hV;
    private boolean akl;
    private boolean HJ;
    private int akm = 0;
    private int akn = 0;
    float ako;
    boolean akp = true;
    boolean akq = false;
    private int rW;
    public static float akr;
    double aks = Double.NaN;
    double akt = Double.NaN;
    private int aku;
    private boolean gD = false;
    @EventLink
    public final Listener<JumpEvent> akv = var0 -> {};
    @EventLink(value = 1)
    public Listener<PreMotionEvent> onPreMotion = var1x -> {
        double d0 = Math.toRadians(aEg.thePlayer.pl);
        double d27 = -Math.sin(d0);
        if (Math.cos(d0) * 1.0 < 0.0) {
            boolean flag = true;
        } else {
            boolean flag1 = false;
        }

        if (aEg.thePlayer.ticksExisted % 3 != 0 || !aEg.thePlayer.onGround || aEg.thePlayer.cqL <= 2) {
            if (!aEg.gameSettings.keyBindJump.isKeyDown() && MoveUtil.isMoving()) {
                akr = aEg.thePlayer.pl;
                hV = 0;
                qH = 0;
            } else if (!aEg.gameSettings.keyBindJump.isKeyDown()) {
                hV = 100;
                return;
            }

            if (MoveUtil.isMoving()) {
                qH++;
            } else if (qH > 20) {
                qH--;
            }

            if (aEg.gameSettings.keyBindJump.isKeyDown()) {
                hV++;
            }

            if (qH >= 23) {
                qH = 1;
                akr = aEg.thePlayer.pl;
                hV = 99;
            }

            if (aEg.thePlayer.onGround) {
                hV = 0;
                this.rW = 0;
                akr = aEg.thePlayer.pl;
            } else if (hV == 100) {
                MoveUtil.strafe(0.0);
            }

            if (!MoveUtil.isMoving()) {
                double d1 = aEg.thePlayer.pl;
                double d2 = Math.toRadians(d1);
                d27 = -Math.sin(d2);
                boolean flag2 = Math.cos(d2) * 1.0 < 0.0;
                this.getParent().agF = 1;
                if (!this.akq) {
                    if (flag2) {
                        this.akt = Math.floor(aEg.thePlayer.posX) + 0.999999999999;
                        this.aks = Double.NaN;
                    } else {
                        this.aks = Math.floor(aEg.thePlayer.posZ) + 0.999999999999;
                        this.akt = Double.NaN;
                    }

                    this.akq = true;
                }

                this.rW++;
                if (Math.abs(this.aku - aEg.thePlayer.posY) >= 1.0) {
                    if (this.rW == 1) {
                        MoveUtil.stop();
                        if (!this.kE()) {
                            if (!Double.isNaN(this.akt)) {
                                double d3 = aEg.thePlayer.posX + (this.akt - aEg.thePlayer.posX) / 3.0;
                                double d4 = aEg.thePlayer.posY;
                                double d5 = aEg.thePlayer.posZ;
                                if (this.e(d3, d4, d5)) {
                                    aEg.thePlayer.setPosition(d3, d4, d5);
                                }
                            } else if (!Double.isNaN(this.aks)) {
                                double d6 = aEg.thePlayer.posX;
                                double d7 = aEg.thePlayer.posY;
                                double d8 = aEg.thePlayer.posZ + (this.aks - aEg.thePlayer.posZ) / 3.0;
                                if (this.e(d6, d7, d8)) {
                                    aEg.thePlayer.setPosition(d6, d7, d8);
                                }
                            }
                        }
                    } else if (this.rW == 2) {
                        MoveUtil.stop();
                        if (!this.kE()) {
                            if (!Double.isNaN(this.akt)) {
                                double d9 = aEg.thePlayer.posX + 2.0 * (this.akt - aEg.thePlayer.posX) / 3.0;
                                double d10 = aEg.thePlayer.posY;
                                double d11 = aEg.thePlayer.posZ;
                                if (this.e(d9, d10, d11)) {
                                    aEg.thePlayer.setPosition(d9, d10, d11);
                                }
                            } else if (!Double.isNaN(this.aks)) {
                                double d12 = aEg.thePlayer.posX;
                                double d13 = aEg.thePlayer.posY;
                                double d14 = aEg.thePlayer.posZ + 2.0 * (this.aks - aEg.thePlayer.posZ) / 3.0;
                                if (this.e(d12, d13, d14)) {
                                    aEg.thePlayer.setPosition(d12, d13, d14);
                                }
                            }

                            this.kD();
                        } else {
                            this.kD();
                        }
                    } else if (this.rW == 3) {
                        MoveUtil.stop();
                        if (!this.kE()) {
                            if (!Double.isNaN(this.akt)) {
                                double d15 = this.akt;
                                double d16 = aEg.thePlayer.posY;
                                double d17 = aEg.thePlayer.posZ;
                                if (this.e(d15, d16, d17)) {
                                    aEg.thePlayer.setPosition(d15, d16, d17);
                                    this.kD();
                                }
                            } else if (!Double.isNaN(this.aks)) {
                                double d21 = aEg.thePlayer.posX;
                                double d22 = aEg.thePlayer.posY;
                                double d23 = this.aks;
                                if (this.e(d21, d22, d23)) {
                                    aEg.thePlayer.setPosition(d21, d22, d23);
                                }
                            }

                            double d18 = aEg.thePlayer.posX;
                            double d19 = aEg.thePlayer.posY;
                            double d20 = this.aks;
                            this.e(d18, d19, d20);
                            this.kD();
                            this.rW = 0;
                            this.akq = false;
                        } else {
                            this.kD();
                        }
                    }
                } else {
                    this.kD();
                    this.rW = 0;
                    this.akq = false;
                }
            } else {
                this.akq = false;
            }

            if (this.HJ && !MoveUtil.isMoving()) {
                aEg.gameSettings.keyBindJump.setPressed(true);
            }

            if (aEg.thePlayer.Zl < 1) {
                this.akq = false;
            }

            if (aEg.gameSettings.keyBindJump.isKeyDown()) {
                this.gD = true;
            }

            qH = 0;
            if (aEg.thePlayer.motionY < 0.3 && this.HJ && aEg.thePlayer.motionY > 0.17) {
                this.getParent().toggle();
                if (aEg.thePlayer.onGround) {
                    aEg.thePlayer.jump();
                }

                this.HJ = false;
            }

            if (this.gD && !aEg.gameSettings.keyBindJump.isKeyDown()) {
                if (aEg.thePlayer.motionY < 0.3 && this.HJ) {
                    double d24;
                    int i = (d24 = aEg.thePlayer.motionY - 0.17) == 0.0 ? 0 : (d24 < 0.0 ? -1 : 1);
                }

                this.gD = false;
            }

            if (!aEg.gameSettings.keyBindJump.isPressed()) {
                aEg.gameSettings.keyBindJump.isKeyDown();
            }

            float f = hV == 1 ? 90.0F : 0.0F;
            if (MathHelper.wrapAngleTo180_float(aEg.thePlayer.pl - akr) < f) {
                akr = aEg.thePlayer.pl;
            } else if (MathHelper.wrapAngleTo180_float(aEg.thePlayer.pl - akr) < 0.0F) {
                akr -= f;
            } else if (MathHelper.wrapAngleTo180_float(aEg.thePlayer.pl - akr) > 0.0F) {
                akr += f;
            }

            if (qH < 20 && !Client.a.g().c(Speed.class).isEnabled()) {
                aEg.thePlayer.isPotionActive(Potion.moveSpeed);
                if (aEg.gameSettings.keyBindJump.isKeyDown()) {
                    aEg.thePlayer.isPotionActive(Potion.moveSpeed);
                    switch (hV) {
                        case 0:
                            MoveUtil.strafe();
                            if (aEg.thePlayer.isPotionActive(Potion.moveSpeed) && aEg.thePlayer.getActivePotionEffect(Potion.moveSpeed).amplifier + 1 >= 2) {
                                aEg.thePlayer.motionZ *= 1.045;
                                aEg.thePlayer.motionX *= 1.045;
                            } else if (aEg.thePlayer.isPotionActive(Potion.moveSpeed)) {
                                aEg.thePlayer.motionZ *= 1.035;
                                aEg.thePlayer.motionX *= 1.035;
                            }

                            Client.a.g().c(Scaffold.class).sameY.wo().getName().equals("Off");
                            double d26;
                            int l = (d26 = MoveUtil.speed() - 0.24) == 0.0 ? 0 : (d26 < 0.0 ? -1 : 1);
                            aEg.thePlayer.motionY = 0.42;
                            break;
                        case 1:
                            MoveUtil.strafe();
                            double d25;
                            int j = (d25 = MoveUtil.speed() - 0.24) == 0.0 ? 0 : (d25 < 0.0 ? -1 : 1);
                            if (aEg.thePlayer.isPotionActive(Potion.moveSpeed)) {
                                int k = aEg.thePlayer.getActivePotionEffect(Potion.moveSpeed).amplifier + 1;
                            }

                            aEg.thePlayer.motionY = 0.33;
                            if (aEg.thePlayer.isPotionActive(Potion.moveSpeed) && aEg.thePlayer.getActivePotionEffect(Potion.moveSpeed).amplifier + 1 >= 2) {
                                aEg.thePlayer.motionZ *= 1.015;
                                aEg.thePlayer.motionX *= 1.015;
                            } else if (aEg.thePlayer.isPotionActive(Potion.moveSpeed)) {
                                aEg.thePlayer.motionZ *= 1.005;
                                aEg.thePlayer.motionX *= 1.005;
                            }

                            if (Client.a.g().c(Scaffold.class).sameY.wo().getName().equals("Off")) {
                            }
                            break;
                        case 2:
                            aEg.thePlayer.isPotionActive(Potion.moveSpeed);
                            if (this.e(Disabler.class).watchdogFly.wo() && this.e(Disabler.class).isEnabled()) {
                                MoveUtil.strafe();
                            }

                            aEg.thePlayer.motionY = 1.0 - aEg.thePlayer.posY % 1.0;
                    }
                }
            } else if (!aEg.thePlayer.onGround) {
            }

            if (aEg.thePlayer.motionY > 0.0) {
                aEg.gameSettings.keyBindJump.isKeyDown();
            }

            if (qH != 20 && qH != 21) {
                if (qH > 20) {
                }
            } else {
                this.ako = akr;
            }

            if (qH == 22 && !Client.a.g().c(Speed.class).isEnabled()) {
                if (aEg.thePlayer.cqL == 0) {
                    aEg.thePlayer.isPotionActive(Potion.moveSpeed);
                }

                if (aEg.thePlayer.motionY < 0.2 && aEg.thePlayer.motionY > 0.1) {
                    aEg.thePlayer.motionY -= 0.42;
                } else {
                    aEg.thePlayer.motionY = -0.0784000015258789;
                }

                aEg.thePlayer.isPotionActive(Potion.moveSpeed);
            }

            if (hV == 2) {
                hV = -1;
            }

            this.getParent().agF = 1;
        }
    };
    @EventLink
    public final Listener<PostStrafeEvent> onPostStrafe = var0 -> {};
    @EventLink
    public final Listener<MoveInputEvent> onMoveInput = var1x -> {
        if (MoveUtil.isMoving() && aEg.gameSettings.keyBindJump.isKeyDown() && !this.e(Speed.class).isEnabled()) {
            var1x.setForward(var1x.getForward() * 5.0F);
        }
    };
    @EventLink
    public final Listener<StrafeEvent> onStrafe = var0 -> {
        if (aEg.gameSettings.keyBindJump.isKeyDown() && (aEg.gameSettings.keyBindRight.isKeyDown() || aEg.gameSettings.keyBindLeft.isKeyDown())) {
            MoveUtil.strafe(0.25);
        }

        if (MoveUtil.speed() < 0.19 && aEg.gameSettings.keyBindJump.isKeyDown() && aEg.thePlayer.Zl > 9) {
            MoveUtil.strafe(0.19);
        }

        if (qH >= 16) {
            aEg.thePlayer.isPotionActive(Potion.moveSpeed);
        }
    };
    @EventLink
    public final Listener<KeyboardInputEvent> onKeyboardInput = var1x -> {
        if (var1x.getKeyCode() == this.getParent().getKey() && !this.HJ && aEg.gameSettings.keyBindJump.isKeyDown() && !Client.a.g().c(Speed.class).isEnabled()) {
            var1x.setCancelled();
            this.HJ = true;
        }
    };
    @EventLink
    public final Listener<TickEvent> onTick = var0 -> {};
    @EventLink
    public final Listener<PacketSendEvent> onPacketSend = var1x -> {
        double d0 = Math.toRadians(aEg.thePlayer.pl);
        double d1 = -Math.sin(d0);
        if (Math.cos(d0) * 1.0 < 0.0) {
            boolean flag = true;
        } else {
            boolean flag1 = false;
        }

        if (var1x.dq() instanceof C08PacketPlayerBlockPlacement c08packetplayerblockplacement
            && c08packetplayerblockplacement.getPlacedBlockDirection() == 1
            && (c08packetplayerblockplacement.getStack() == null || c08packetplayerblockplacement.getStack().getItem() != Item.getItemFromBlock(Blocks.ice))) {
            this.akl = true;
            this.akm++;
        } else if (var1x.dq() instanceof C08PacketPlayerBlockPlacement c08packetplayerblockplacement1
            && (c08packetplayerblockplacement1.getStack() == null || c08packetplayerblockplacement1.getStack().getItem() != Item.getItemFromBlock(Blocks.ice))) {
            this.akm = 0;
            this.akl = false;
        }

        if (this.akl && !this.e(Speed.class).isEnabled() && this.akm >= 2) {
            ;
        }
    };
    @EventLink
    public final Listener<JumpEvent> akC = var1x -> {
        if (!this.e(Speed.class).isEnabled() && aEg.gameSettings.keyBindJump.isKeyDown() && !aEg.thePlayer.isPotionActive(Potion.moveSpeed)) {
            MoveUtil.strafe(0.15);
        }

        if (this.HJ) {
            MoveUtil.strafe(0.0);
        }
    };

    public WatchdogTower(String var1, Scaffold var2) {
        super(var1, var2);
    }

    @Override
    public void onEnable() {
        this.akl = false;
        SlotComponent slotcomponent = this.d(SlotComponent.class);
        SlotComponent.setSlot(SlotUtil.vx());
        this.akn = 0;
        this.HJ = false;
        this.aks = Double.NaN;
        qH = 0;
        this.rW = 0;
        akr = aEg.thePlayer.pl;
        this.akq = false;
        if (aEg.thePlayer.onGround) {
            hV = 0;
        } else {
            hV = 100;
        }

        if (Client.a.g().c(Scaffold.class).sameY.wo().getName().equals("Off") && !aEg.thePlayer.onGround) {
            this.akp = true;
        }

        this.gD = false;
    }

    @Override
    public void onDisable() {
        this.akq = false;
        this.akp = false;
        this.HJ = false;
        akr = aEg.thePlayer.pl;
        hV = 100;
        this.rW = 0;
        if (aEg.gameSettings.keyBindJump.isKeyDown()) {
            MoveUtil.strafe(0.23);
        }
    }

    public void kD() {
        this.aku = (int)Math.floor(aEg.thePlayer.posY);
        double d0 = aEg.thePlayer.pl;
        double d1 = Math.toRadians(d0);
        double d2 = -Math.sin(d1);
        boolean flag = Math.cos(d1) * 1.0 < 0.0;
        aka aka;
        if (flag) {
            RotationComponent.d(false);
            RotationComponent.setRotations(new Vector2f((float)(aEg.thePlayer.pl - 164.0F + (Math.random() - 0.5) * 3.0), 86.0F), 10.0, MovementFix.OFF);
            aka = new aka(1.0, 0.0, 0.0);
        } else {
            aka = new aka(0.0, 0.0, 1.0);
        }

        this.getParent().agy = aka;
        RotationUtil.d(aka);
        if (!MoveUtil.isMoving() && !flag) {
            RotationComponent.d(false);
            float f = (float)(d0 + 164.0 + (Math.random() - 0.5) * 3.0);
            float f1 = 86.0F;
            RotationComponent.d(false);
            RotationComponent.setRotations(new Vector2f(f, f1), 10.0, MovementFix.OFF);
        }
    }

    private boolean kE() {
        int i = (int)Math.floor(aEg.thePlayer.posX);
        int j = (int)Math.floor(aEg.thePlayer.posY);
        int k = (int)Math.floor(aEg.thePlayer.posZ);
        Block[] ablock = new Block[]{PlayerUtil.o(i + 1, j, k), PlayerUtil.o(i - 1, j, k), PlayerUtil.o(i, j, k + 1), PlayerUtil.o(i, j, k - 1)};
        int l = ablock.length;

        for (int i1 = 0; i1 < l; i1++) {
            if (ablock[i1] instanceof BlockAir) {
                return false;
            }
        }

        return true;
    }

    private boolean e(double var1, double var3, double var5) {
        float f = aEg.thePlayer.width / 2.0F;
        double d0 = var1 - f;
        double d1 = var3;
        double d2 = var5 - f;
        double d3 = var1 + f;
        double d4 = var3 + aEg.thePlayer.height;
        double d5 = var5 + f;

        for (int i = MathHelper.floor_double(d0); i <= MathHelper.floor_double(d3); i++) {
            for (int j = MathHelper.floor_double(d1); j <= MathHelper.floor_double(d4); j++) {
                for (int k = MathHelper.floor_double(d2); k <= MathHelper.floor_double(d5); k++) {
                    if (!(PlayerUtil.o(i, j, k) instanceof BlockAir)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
