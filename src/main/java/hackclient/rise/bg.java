package hackclient.rise;

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

public final class bg extends Component {
    public static boolean dj;
    private static boolean dk;
    private static int dl;
    private static int dm;
    public static bh dn;
    @EventLink(cH = 0)
    public final Listener<PreMotionEvent> fld_do_10 = var1 -> {
        if (dj) {
            int i = aik.e(Items.bow);
            int j = aik.e(Items.fishing_rod);
            int k = aik.e(Items.clay_ball);
            int l = aik.e(Items.snowball);
            int i1 = aik.e(Items.egg);
            if (i != -1 && this.ba()) {
                SlotComponent slotcomponent3 = this.d(SlotComponent.class);
                SlotComponent.setSlot(i);
                dn = bh.BOW;
            } else if (j != -1) {
                SlotComponent slotcomponent8 = this.d(SlotComponent.class);
                SlotComponent.setSlot(j);
                dn = bh.ROD;
            } else if (k != -1) {
                SlotComponent slotcomponent = this.d(SlotComponent.class);
                SlotComponent.setSlot(k);
                dn = bh.CLAY;
            } else if (l != -1) {
                SlotComponent slotcomponent1 = this.d(SlotComponent.class);
                SlotComponent.setSlot(l);
                dn = bh.PROJECTILES;
            } else if (i1 != -1) {
                SlotComponent slotcomponent2 = this.d(SlotComponent.class);
                SlotComponent.setSlot(i1);
                dn = bh.PROJECTILES;
            }

            if (bb.a(true, false, false, false, true)) {
                dm = 0;
            }

            if (!bb.a(true, false, false, false, true)) {
                dm++;
                if (dn != null) {
                    label53:
                    switch (dn) {
                        case BOW:
                            switch (dm) {
                                case 3:
                                    SlotComponent slotcomponent7 = this.d(SlotComponent.class);
                                    ahj.l(new C08PacketPlayerBlockPlacement(SlotComponent.getItemStack()));
                                    break label53;
                                case 7:
                                    ahj.l(new C07PacketPlayerDigging(Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, EnumFacing.DOWN));
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
                                    ahj.l(new C08PacketPlayerBlockPlacement(SlotComponent.getItemStack()));
                                    break;
                                case 95:
                                    dj = false;
                            }

                            if (aEg.thePlayer.hurtTime == 9) {
                                SlotComponent slotcomponent6 = this.d(SlotComponent.class);
                                ahj.l(new C08PacketPlayerBlockPlacement(SlotComponent.getItemStack()));
                            }
                            break;
                        case CLAY:
                            if (dm == 3) {
                                SlotComponent slotcomponent4 = this.d(SlotComponent.class);
                                ahj.l(new C08PacketPlayerBlockPlacement(SlotComponent.getItemStack()));
                            }
                            break;
                        case PROJECTILES:
                            switch (dm) {
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                    SlotComponent slotcomponent9 = this.d(SlotComponent.class);
                                    ahj.l(new C08PacketPlayerBlockPlacement(SlotComponent.getItemStack()));
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
    public final Listener<MoveInputEvent> dp = var0 -> {
        if (dk && dj) {
            var0.setForward(0.0F);
            var0.setStrafe(0.0F);
        }
    };
    @EventLink
    public final Listener<PreUpdateEvent> dq = var0 -> {
        if (dj) {
            RotationComponent.setRotations(new Vector2f(aEg.thePlayer.pl, -90.0F), ahg.l(8.0, 10.0), MovementFix.NORMAL);
        }
    };
    @EventLink(cH = 0)
    public final Listener<PacketReceiveEvent> dr = var0 -> {
        Packet packet = var0.dq();
        if (packet instanceof S12PacketEntityVelocity) {
            if (((S12PacketEntityVelocity)packet).getEntityID() == aEg.thePlayer.getEntityId()) {
                dj = false;
            }
        } else if (packet instanceof S27PacketExplosion) {
            dj = false;
        }
    };

    public bg() {
    }

    public static void damage(boolean var0) {
        dj = true;
        dk = var0;
        dl = aEg.thePlayer.inventory.currentItem;
        dm = 0;
        dn = null;
    }

    public boolean ba() {
        for (int i = 0; i < aEg.thePlayer.inventory.mainInventory.length; i++) {
            ItemStack itemstack = aEg.thePlayer.inventory.mainInventory[i];
            if (itemstack != null && itemstack.getItem().getUnlocalizedName().contains("arrow")) {
                return true;
            }
        }

        return false;
    }
}
