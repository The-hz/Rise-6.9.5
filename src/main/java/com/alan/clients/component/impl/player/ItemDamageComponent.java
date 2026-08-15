package com.alan.clients.component.impl.player;

import com.alan.clients.component.Component;
import com.alan.clients.component.impl.player.RotationComponent;
import com.alan.clients.component.impl.player.SlotComponent;
import com.alan.clients.component.impl.player.rotationcomponent.MovementFix;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.MoveInputEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.util.math.MathUtil;
import com.alan.clients.util.packet.PacketUtil;
import com.alan.clients.util.player.SlotUtil;
import com.alan.clients.component.impl.player.BadPacketsComponent;
import com.alan.clients.component.impl.player.ItemDamageType;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C07PacketPlayerDigging.Action;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S27PacketExplosion;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public final class ItemDamageComponent extends Component {
    public static boolean dj;
    private static boolean dk;
    private static int dl;
    private static int dm;
    public static ItemDamageType dn;
    @EventLink(value = 0)
    public final Listener<PreMotionEvent> onPreMotionEvent = var1 -> {
        if (dj) {
            int i = SlotUtil.findItem(Items.bow);
            int j = SlotUtil.findItem(Items.fishing_rod);
            int k = SlotUtil.findItem(Items.clay_ball);
            int l = SlotUtil.findItem(Items.snowball);
            int i1 = SlotUtil.findItem(Items.egg);
            if (i != -1 && this.arrow()) {
                SlotComponent slotcomponent3 = this.d(SlotComponent.class);
                SlotComponent.setSlot(i);
                dn = ItemDamageType.BOW;
            } else if (j != -1) {
                SlotComponent slotcomponent8 = this.d(SlotComponent.class);
                SlotComponent.setSlot(j);
                dn = ItemDamageType.ROD;
            } else if (k != -1) {
                SlotComponent slotcomponent = this.d(SlotComponent.class);
                SlotComponent.setSlot(k);
                dn = ItemDamageType.CLAY;
            } else if (l != -1) {
                SlotComponent slotcomponent1 = this.d(SlotComponent.class);
                SlotComponent.setSlot(l);
                dn = ItemDamageType.PROJECTILES;
            } else if (i1 != -1) {
                SlotComponent slotcomponent2 = this.d(SlotComponent.class);
                SlotComponent.setSlot(i1);
                dn = ItemDamageType.PROJECTILES;
            }

            if (BadPacketsComponent.bad(true, false, false, false, true)) {
                dm = 0;
            }

            if (!BadPacketsComponent.bad(true, false, false, false, true)) {
                dm++;
                if (dn != null) {
                    label53:
                    switch (dn) {
                        case BOW:
                            switch (dm) {
                                case 3:
                                    SlotComponent slotcomponent7 = this.d(SlotComponent.class);
                                    PacketUtil.l(new C08PacketPlayerBlockPlacement(SlotComponent.getItemStack()));
                                    break label53;
                                case 7:
                                    PacketUtil.l(new C07PacketPlayerDigging(Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, EnumFacing.DOWN));
                                    break label53;
                                case 40:
                                    dj = false;
                                default:
                                    break label53;
                            }
                        case ROD:
                            switch (dm) {
                                case 3:
                                    SlotComponent slotcomponent5 = this.d(SlotComponent.class);
                                    PacketUtil.l(new C08PacketPlayerBlockPlacement(SlotComponent.getItemStack()));
                                    break;
                                case 95:
                                    dj = false;
                            }

                            if (aEg.thePlayer.hurtTime == 9) {
                                SlotComponent slotcomponent6 = this.d(SlotComponent.class);
                                PacketUtil.l(new C08PacketPlayerBlockPlacement(SlotComponent.getItemStack()));
                            }
                            break;
                        case CLAY:
                            if (dm == 3) {
                                SlotComponent slotcomponent4 = this.d(SlotComponent.class);
                                PacketUtil.l(new C08PacketPlayerBlockPlacement(SlotComponent.getItemStack()));
                            }
                            break;
                        case PROJECTILES:
                            switch (dm) {
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                    SlotComponent slotcomponent9 = this.d(SlotComponent.class);
                                    PacketUtil.l(new C08PacketPlayerBlockPlacement(SlotComponent.getItemStack()));
                                    break label53;
                                case 100:
                                    dj = false;
                                default:
                                    break label53;
                            }
                        default:
                            dj = false;
                    }
                } else {
                    dj = false;
                }

                if (aEg.thePlayer.hurtTime == 9) {
                    dj = false;
                }

                dk = true;
            }
        }
    };
    @EventLink
    public final Listener<MoveInputEvent> onMove = var0 -> {
        if (dk && dj) {
            var0.setForward(0.0F);
            var0.setStrafe(0.0F);
        }
    };
    @EventLink
    public final Listener<PreUpdateEvent> onPreUpdate = var0 -> {
        if (dj) {
            RotationComponent.setRotations(new Vector2f(aEg.thePlayer.pl, -90.0F), MathUtil.l(8.0, 10.0), MovementFix.NORMAL);
        }
    };
    @EventLink(value = 0)
    public final Listener<PacketReceiveEvent> onPacketReceiveEvent = var0 -> {
        Packet packet = var0.getPacket();
        if (packet instanceof S12PacketEntityVelocity) {
            if (((S12PacketEntityVelocity)packet).getEntityID() == aEg.thePlayer.getEntityId()) {
                dj = false;
            }
        } else if (packet instanceof S27PacketExplosion) {
            dj = false;
        }
    };

    public ItemDamageComponent() {
    }

    public static void damage(boolean var0) {
        dj = true;
        dk = var0;
        dl = aEg.thePlayer.inventory.currentItem;
        dm = 0;
        dn = null;
    }

    public boolean arrow() {
        for (int i = 0; i < aEg.thePlayer.inventory.mainInventory.length; i++) {
            ItemStack itemstack = aEg.thePlayer.inventory.mainInventory[i];
            if (itemstack != null && itemstack.getItem().getUnlocalizedName().contains("arrow")) {
                return true;
            }
        }

        return false;
    }
}
