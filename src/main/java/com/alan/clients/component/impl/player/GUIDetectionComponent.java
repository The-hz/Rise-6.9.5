package com.alan.clients.component.impl.player;

import com.alan.clients.component.Component;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.entity.EntityList;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public final class GUIDetectionComponent extends Component {
    private static boolean userInterface;
    @EventLink(value = 4)
    public final Listener<PreMotionEvent> onPreMotionEvent = var1 -> {
        userInterface = false;
        if (aEg.currentScreen instanceof GuiChest) {
            Container container = aEg.thePlayer.openContainer;
            int i = 0;
            int j = 0;
            int k = 0;

            for (Slot slot : container.inventorySlots) {
                if (slot.getHasStack() && k++ <= 26) {
                    ItemStack itemstack = slot.getStack();
                    if (itemstack != null) {
                        String s = itemstack.getDisplayName();
                        String s1 = this.expectedName(itemstack);
                        String s2 = s.toLowerCase().replace(" ", "");
                        String s3 = s1.toLowerCase().replace(" ", "");
                        if (s2.contains(s3)) {
                            i = (int)(i - 0.1);
                        } else {
                            i++;
                        }

                        j++;
                    }
                }
            }

            userInterface = (float)i / j > 0.5F;
        }
    };

    public GUIDetectionComponent() {
    }

    public static boolean inGUI() {
        return userInterface;
    }

    private String expectedName(ItemStack var1) {
        String s = (StatCollector.translateToLocal(var1.getUnlocalizedName() + ".name") + "").trim();
        String s1 = EntityList.getStringFromID(var1.getMetadata());
        if (s1 != null) {
            s = s + " " + StatCollector.translateToLocal("entity." + s1 + ".name");
        }

        return s;
    }
}
