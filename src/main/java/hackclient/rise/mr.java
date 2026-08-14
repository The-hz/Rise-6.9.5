package hackclient.rise;

import com.alan.clients.module.impl.movement.Flight;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.MoveInputEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.other.BlockAABBEvent;
import com.alan.clients.value.Mode;
import net.minecraft.block.BlockAir;
import net.minecraft.util.AxisAlignedBB;

public class mr extends Mode<Flight> {
    private double y;
    @EventLink
    public final Listener<PreMotionEvent> Fm = var1x -> {
        if (aEg.gameSettings.keyBindJump.isKeyDown() || aEg.gameSettings.keyBindSneak.isKeyDown()) {
            this.y = aEg.thePlayer.posY;
        }

        if (aEg.thePlayer.onGround) {
            aEg.thePlayer.jump();
        }
    };
    @EventLink
    public final Listener<BlockAABBEvent> Fn = var1x -> {
        if (var1x.df() instanceof BlockAir
            && !aEg.gameSettings.keyBindSneak.isKeyDown()
            && (aEg.thePlayer.posY < this.y + 1.0 || aEg.gameSettings.keyBindJump.isKeyDown())) {
            double d0 = var1x.dg().getX();
            double d1 = var1x.dg().getY();
            double d2 = var1x.dg().getZ();
            if (d1 < aEg.thePlayer.posY) {
                var1x.a(AxisAlignedBB.fromBounds(-15.0, -1.0, -15.0, 15.0, 1.0, 15.0).offset(d0, d1, d2));
            }
        }
    };
    @EventLink
    public final Listener<MoveInputEvent> Fo = var0 -> var0.setSneak(false);

    public mr(String var1, Flight var2) {
        super(var1, var2);
    }

    @Override
    public void onEnable() {
        this.y = Math.floor(aEg.thePlayer.posY);
    }
}
