package com.alan.clients.module.impl.movement.longjump;

import com.alan.clients.component.impl.player.RotationComponent;
import com.alan.clients.component.impl.player.SlotComponent;
import com.alan.clients.component.impl.player.rotationcomponent.MovementFix;
import com.alan.clients.module.impl.movement.LongJump;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.NumberValue;
import com.alan.clients.value.impl.SubMode;
import hackclient.rise.afi;
import hackclient.rise.ahj;
import hackclient.rise.aik;
import net.minecraft.init.Items;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;

public class FireBallLongJump extends Mode<LongJump> {
    public ModeValue mode = new ModeValue("Mode", this).add(new SubMode("Custom")).add(new SubMode("Hypixel")).setDefault("Hypixel");
    private final NumberValue KT = new NumberValue("Height", this, 1, 0.42, 9, 0.1, () -> !this.mode.wo().getName().equals("Custom"));
    private final NumberValue KU = new NumberValue("Speed", this, 1, 0.1, 3, 0.1, () -> !this.mode.wo().getName().equals("Custom"));
    private int tick;
    private double moveSpeed = 0.0;
    private float yawAtDamage;
    @EventLink
    public final Listener<PreUpdateEvent> onPreUpdate = var1x -> {
        label47: {
            label46: {
                String s = this.mode.wo().getName();
                byte b0 = -1;
                switch (s.hashCode()) {
                    case -1248403467:
                        if (s.equals("Hypixel")) {
                            b0 = 0;
                        }
                        break;
                    case 2029746065:
                        if (s.equals("Custom")) {
                            boolean flag = true;
                            break label46;
                        }
                }

                switch (b0) {
                    case 0:
                        if (aEg.thePlayer.hurtTime == 10) {
                            this.yawAtDamage = aEg.thePlayer.pl;
                            aEg.thePlayer.motionY = 1.5;
                            this.moveSpeed = 1.4;
                        }

                        if (aEg.thePlayer.hurtTime == 9) {
                            this.moveSpeed = 2.0 - Math.random() / 100.0;
                        }

                        if (aEg.thePlayer.ae <= 11) {
                            MoveUtil.a(this.moveSpeed, this.yawAtDamage);
                            this.moveSpeed = this.moveSpeed - (this.moveSpeed / 249.9 + Math.random() / 100.0);
                        }
                        break label47;
                    case 1:
                        break;
                    default:
                        break label47;
                }
            }

            if (aEg.thePlayer.ae <= 1) {
                aEg.thePlayer.motionY = this.KT.wo().doubleValue();
                MoveUtil.strafe(this.KU.wo().doubleValue());
            }
        }

        int i = aik.e(Items.fire_charge);
        if (aEg.thePlayer.cqL == 1) {
            MoveUtil.stop();
        }

        if (i != -1) {
            this.tick++;
            SlotComponent slotcomponent = this.d(SlotComponent.class);
            SlotComponent.setSlot(i);
            if (this.tick == 2) {
                SlotComponent slotcomponent1 = this.d(SlotComponent.class);
                ahj.l(new C08PacketPlayerBlockPlacement(SlotComponent.getItemStack()));
            }

            RotationComponent.setRotations(new Vector2f(aEg.thePlayer.pl, 90.0F), 10.0, MovementFix.OFF);
        }
    };

    public FireBallLongJump(String var1, LongJump var2) {
        super(var1, var2);
    }

    @Override
    public void onEnable() {
        this.tick = 0;
        if (this.mode.wo().getName().equals("Hypixel")) {
            afi.b("Don't enable on bridges, the ac falses, also make sure you take the velocity when on the ground.");
        }
    }
}
