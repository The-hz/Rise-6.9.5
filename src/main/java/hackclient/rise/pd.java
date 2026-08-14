package hackclient.rise;

import com.alan.clients.component.impl.player.BlinkComponent;
import com.alan.clients.component.impl.player.SlotComponent;
import com.alan.clients.module.impl.movement.NoSlow;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.motion.SlowDownEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.value.Mode;
import net.minecraft.item.ItemFood;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;

public class pd extends Mode<NoSlow> {
    private boolean enabled;
    @EventLink
    public final Listener<PreUpdateEvent> Nb = var1x -> {
        if (aEg.thePlayer.isUsingItem()) {
            SlotComponent slotcomponent = this.d(SlotComponent.class);
            if (SlotComponent.getItemStack().getItem() instanceof ItemFood) {
                BlinkComponent.blink();
                if (aEg.thePlayer.itemInUseCount < -1) {
                    aEg.gameSettings.cgI.setPressed(false);
                }

                return;
            }
        }
    };
    @EventLink
    public final Listener<PacketSendEvent> Nc = var1x -> {
        Packet packet = var1x.dq();
        if (packet instanceof C07PacketPlayerDigging) {
            afi.b("digging " + ((C07PacketPlayerDigging)packet).getStatus() + " " + var1x.isCancelled());
            this.enabled = false;
        } else if (!this.enabled && packet instanceof C08PacketPlayerBlockPlacement) {
            SlotComponent slotcomponent = this.d(SlotComponent.class);
            if (SlotComponent.getItemStack() != null) {
                slotcomponent = this.d(SlotComponent.class);
                if (SlotComponent.getItemStack().getItem() instanceof ItemFood) {
                    this.enabled = true;
                    BlinkComponent.blink();
                    BlinkComponent.enabled = true;
                    var1x.setCancelled();
                    ahj.m(packet);
                    afi.b("Started");
                }
            }
        }
    };
    @EventLink
    public final Listener<SlowDownEvent> Nd = var1x -> {
        SlotComponent slotcomponent = this.d(SlotComponent.class);
        if (SlotComponent.getItemStack() != null) {
            slotcomponent = this.d(SlotComponent.class);
            if (SlotComponent.getItemStack().getItem() instanceof ItemFood) {
                var1x.setCancelled();
            }
        }
    };

    public pd(String var1, NoSlow var2) {
        super(var1, var2);
    }
}
