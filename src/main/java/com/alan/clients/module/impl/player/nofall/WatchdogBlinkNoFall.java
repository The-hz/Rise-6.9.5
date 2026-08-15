package com.alan.clients.module.impl.player.nofall;

import com.alan.clients.component.impl.player.BlinkComponent;
import com.alan.clients.module.impl.player.NoFall;
import com.alan.clients.module.impl.player.Scaffold;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.util.packet.PacketUtil;
import hackclient.rise.aih;
import com.alan.clients.component.impl.player.FallDistanceComponent;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.util.BlockPos;

public final class WatchdogBlinkNoFall extends Mode<NoFall> {
    public int aiX = 0;
    public boolean IJ;
    public final BooleanValue packet = new BooleanValue("Packet", this, true);
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = var1x -> {
        if (aih.vh() && !this.e(Scaffold.class).isEnabled()) {
            if (aEg.thePlayer.tR == 1 && aEg.thePlayer.motionY < 0.0 && aih.vh() && !aih.ad(3.0)) {
                this.IJ = true;
            }

            if (this.IJ) {
                BlinkComponent.a(99999, true, false, false, false, true);
                var1x.setOnGround(true);
                this.aiX++;
            }

            if (this.IJ && aEg.thePlayer.onGround) {
                BlinkComponent.dispatch();
                this.IJ = false;
                this.aiX = 0;
            }

            if (this.aiX <= 0 && FallDistanceComponent.cY > 2.9 && !this.e(Scaffold.class).isEnabled()) {
                var1x.setPosY(var1x.getPosY() + 1.0E-13);
                PacketUtil.l(new C08PacketPlayerBlockPlacement(BlockPos.ORIGIN, 0, new ItemStack(Items.water_bucket, 1), 0.5F, 0.5F, 0.5F));
                aEg.timer.dzD = 0.5F;
                PacketUtil.l(new C03PacketPlayer(true));
                FallDistanceComponent.cY = 0.0F;
            }
        }
    };
    @EventLink
    public final Listener<Render2DEvent> onRender2D = var1x -> {
        if (this.aiX > 0) {
            aEg.fontRendererObj.c("Blinking: " + this.aiX, aEg.jY.getScaledWidth() / 2.0, aEg.jY.getScaledHeight() / 2.0 + 20.0, -1);
        }
    };

    public WatchdogBlinkNoFall(String var1, NoFall var2) {
        super(var1, var2);
    }
}
