package hackclient.rise;

import com.alan.clients.component.Component;
import com.alan.clients.component.impl.player.SlotComponent;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import net.minecraft.entity.EntityList;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public final class bt extends Component {
    private static boolean selector;
    @EventLink(value = 4)
    public final Listener<PreUpdateEvent> onPreUpdate = var1 -> {
        SlotComponent slotcomponent = this.d(SlotComponent.class);
        if (SlotComponent.getItemStack() != null) {
            slotcomponent = this.d(SlotComponent.class);
            ItemStack itemstack = SlotComponent.getItemStack();
            selector = !trueName(itemstack).contains(itemstack.getDisplayName());
        } else {
            selector = false;
        }
    };

    public bt() {
    }

    public static boolean selector() {
        return selector;
    }

    public static boolean c(ItemStack var0) {
        if (var0 == null) {
            return false;
        }
        return var0 == aEg.thePlayer.inventory.getItemStack() ? selector() : !trueName(var0).contains(var0.getDisplayName());
    }

    public static boolean a(ItemStack var0, boolean var1) {
        if (var0 == null) {
            return false;
        } else if (var0 == aEg.thePlayer.inventory.getItemStack()) {
            return selector();
        }
        return var1 ? !trueName(var0).contains(var0.getDisplayName()) : false;
    }

    public static boolean h(int var0) {
        return c(aEg.thePlayer.inventory.getStackInSlot(var0));
    }

    public static boolean a(int var0, boolean var1) {
        return a(aEg.thePlayer.inventory.getStackInSlot(var0), var1);
    }

    public static String trueName(ItemStack var0) {
        String s = (StatCollector.translateToLocal(var0.getUnlocalizedName() + ".name") + "").trim();
        String s1 = EntityList.getStringFromID(var0.getMetadata());
        if (s1 != null) {
            s = s + " " + StatCollector.translateToLocal("entity." + s1 + ".name");
        }

        return s;
    }
}
