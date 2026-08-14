package hackclient.rise;

import com.alan.clients.component.impl.player.SlotComponent;
import com.alan.clients.module.impl.player.Scaffold;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import net.minecraft.block.BlockAir;
import net.minecraft.init.Blocks;

public class vd extends Mode<Scaffold> {
    @EventLink
    public final Listener<PreMotionEvent> aji = var0 -> {};
    @EventLink(cH = 1)
    public final Listener<PreUpdateEvent> ajj = var1x -> {
        boolean flag = aEg.thePlayer.aI == this.wj().Me;
        SlotComponent slotcomponent = this.d(SlotComponent.class);
        if (SlotComponent.getItemStack() != null
            && aEg.thePlayer.posY > this.wj().Me
            && aEg.thePlayer.posY + MoveUtil.predictedMotion(aEg.thePlayer.motionY, 3) < this.wj().Me + 1.0) {
            slotcomponent = this.d(SlotComponent.class);
            SlotComponent.setSlot(aik.vx());
            slotcomponent = this.d(SlotComponent.class);
            if (SlotComponent.getItemStack().cWo > 0) {
                aEg.Az();
            }
        }

        if (!flag && aEg.thePlayer.onGround) {
            aEg.thePlayer.jump();
            MoveUtil.strafe();
        }

        if (aEg.thePlayer.tR == 4 && !aEg.gameSettings.keyBindJump.isKeyDown()) {
            aEg.thePlayer.motionY -= -0.09800000190735147;
        }

        if (aEg.thePlayer.tR == 1 && !aEg.gameSettings.keyBindJump.isKeyDown()) {
            MoveUtil.strafe();
        }

        if (aih.p(0.0, aEg.thePlayer.motionY, 0.0) != Blocks.air && aEg.thePlayer.tR > 2) {
            MoveUtil.strafe();
        }

        aEg.thePlayer.bjQ = MoveUtil.isMoving();
    };

    public vd(String var1, Scaffold var2) {
        super(var1, var2);
    }

    @Override
    public void onEnable() {
        if (!(aih.o(aEg.thePlayer.posX, aEg.thePlayer.aI - 2.0, aEg.thePlayer.posY) instanceof BlockAir)) {
            this.wj().Me = aEg.thePlayer.aI - 1.0;
        }
    }

    @Override
    public void onDisable() {
        if (!(aih.o(aEg.thePlayer.posX, aEg.thePlayer.aI - 2.0, aEg.thePlayer.posY) instanceof BlockAir)) {
            this.wj().Me = aEg.thePlayer.aI - 1.0;
        }
    }
}
