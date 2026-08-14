package com.alan.clients.module.impl.ghost;

import com.alan.clients.component.impl.player.SlotComponent;
import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.MoveInputEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.BoundsNumberValue;
import com.alan.clients.value.impl.NumberValue;
import hackclient.rise.aih;
import net.minecraft.block.BlockAir;
import net.minecraft.item.ItemBlock;

@ModuleInfo(aliases = {"module.ghost.legitscaffold.name", "Eagle"}, description = "module.ghost.eagle.description", category = Category.GHOST)
public class LegitScaffold extends Module {
    private final BoundsNumberValue AU = new BoundsNumberValue("Length", this, 1, 1, 1, 4, 1);
    private final NumberValue AV = new NumberValue("Sneak speed multiplier", this, 0.3, 0.2, 1, 0.05);
    private final BooleanValue AW = new BooleanValue("Only on ground", this, false);
    private final BooleanValue AX = new BooleanValue("Only when holding blocks", this, false);
    private final BooleanValue AY = new BooleanValue("Only when moving backwards", this, false);
    private final BooleanValue AZ = new BooleanValue("Only on Sneak", this, true);
    private boolean Ba;
    private int Bb;
    private int Bc;
    @EventLink
    public final Listener<PreMotionEvent> Bd = var1 -> {
        if (aEg.thePlayer.getHeldItem() != null && !(aEg.thePlayer.getHeldItem().getItem() instanceof ItemBlock) && this.AX.wo()) {
            if (this.Ba) {
                this.Ba = false;
            }
        } else {
            if ((aEg.thePlayer.onGround || !this.AW.wo())
                && aih.p(0.0, -1.0, 0.0) instanceof BlockAir
                && (!aEg.gameSettings.keyBindForward.isKeyDown() || !this.AY.wo())) {
                if (!this.Ba) {
                    this.Ba = true;
                }
            } else if (this.Ba) {
                this.Ba = false;
            }

            if (this.Ba) {
                this.Bc = this.AU.wv().intValue();
                aEg.gameSettings.cgG.setPressed(false);
            }

            if (this.Ba) {
                this.Bb++;
            } else {
                this.Bb = 0;
            }
        }
    };
    @EventLink
    public final Listener<MoveInputEvent> Be = var1 -> {
        SlotComponent slotcomponent = this.d(SlotComponent.class);
        if (SlotComponent.getItemStack() != null) {
            slotcomponent = this.d(SlotComponent.class);
            if (SlotComponent.getItemStack().getItem() instanceof ItemBlock) {
                var1.setSneak(
                    this.Bc > 0 && (aEg.gameSettings.keyBindSneak.isKeyDown() || !this.AZ.wo()) || aEg.gameSettings.keyBindSneak.isKeyDown() && !this.AZ.wo()
                );
            }
        }

        this.Bc--;
        if (this.Bc > 0 && this.Bb <= 2) {
            var1.setSneakSlowDownMultiplier(this.AV.wo().doubleValue());
        }
    };

    public LegitScaffold() {
    }

    @Override
    public void onDisable() {
        if (this.Ba) {
            this.Ba = false;
        }
    }
}
