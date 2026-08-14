package com.alan.clients.module.impl.other;

import com.alan.clients.Client;
import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.DragValue;
import hackclient.rise.adv;
import hackclient.rise.afi;
import hackclient.rise.aha;
import hackclient.rise.ahg;
import hackclient.rise.cf;
import hackclient.rise.gg;
import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S27PacketExplosion;
import net.minecraft.network.play.server.S32PacketConfirmTransaction;
import net.minecraft.network.play.server.S39PacketPlayerAbilities;
import net.minecraft.util.EnumChatFormatting;
import rip.vantage.commons.util.time.a;

@ModuleInfo(aliases = "module.other.debugger.name", category = Category.PLAYER, description = "module.other.debugger.description")
public final class Debugger extends Module implements aha {
    private final BooleanValue Up = new BooleanValue("Transactions", this, true);
    private final BooleanValue Uq = new BooleanValue("Keep Alive", this, true);
    private final BooleanValue Ur = new BooleanValue("Teleport", this, true);
    private final BooleanValue Us = new BooleanValue("Velocity", this, true);
    private final BooleanValue Ut = new BooleanValue("Abilities", this, true);
    private final BooleanValue Uu = new BooleanValue("Display All", this, true);
    private final BooleanValue Uv = new BooleanValue("Blacklist", this, true, () -> !this.Uu.wo());
    private final BooleanValue Uw = new BooleanValue("Time Since Move", this, true, () -> !this.Uu.wo());
    private final BooleanValue Ux = new BooleanValue("Dev Panel", this, false);
    private final BooleanValue Uy = new BooleanValue("Event Calls", this, false);
    private final DragValue position = new DragValue("", this, new Vector2d(200.0, 200.0), true);
    private final DateTimeFormatter date = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    private final ArrayList<String> UB = new ArrayList<>();
    public static HashMap<String, Integer> calls = new HashMap<>();
    private long threadLag;
    private boolean measuring;
    private a bN = new a();
    @EventLink
    public final Listener<PacketSendEvent> UF = var1 -> {};
    @EventLink
    public final Listener<PacketReceiveEvent> UG = var1 -> {
        Packet packet = var1.dq();
        if (this.Up.wo() && packet instanceof S32PacketConfirmTransaction s32packetconfirmtransaction) {
            afi.b(
                EnumChatFormatting.RED + " Transaction " + EnumChatFormatting.RESET + " (ID: %s)   (WindowID: %s)",
                s32packetconfirmtransaction.actionNumber,
                s32packetconfirmtransaction.windowId
            );
        } else if (this.Uq.wo() && packet instanceof net.minecraft.network.play.server.a a) {
            afi.b(EnumChatFormatting.GREEN + " Keep Alive " + EnumChatFormatting.RESET + " (ID: %s)", a.func_149134_c());
        } else if (this.Ur.wo() && packet instanceof S08PacketPlayerPosLook s08packetplayerposlook) {
            afi.b(
                EnumChatFormatting.BLUE + " Server Teleport " + EnumChatFormatting.RESET + " (Position: %s)",
                ahg.a(s08packetplayerposlook.x, 3) + " " + ahg.a(s08packetplayerposlook.y, 3) + " " + ahg.a(s08packetplayerposlook.z, 3)
            );
        } else if (this.Us.wo() && packet instanceof S12PacketEntityVelocity s12packetentityvelocity) {
            if (s12packetentityvelocity.getEntityID() == aEg.thePlayer.getEntityId()) {
                afi.b(
                    EnumChatFormatting.LIGHT_PURPLE + " Velocity " + EnumChatFormatting.RESET + " (DeltaX: %s) (DeltaY: %s)  (DeltaZ: %s) ",
                    s12packetentityvelocity.motionX / 8000.0,
                    s12packetentityvelocity.motionY / 8000.0,
                    s12packetentityvelocity.motionZ / 8000.0
                );
            }
        } else if (this.Us.wo() && packet instanceof S27PacketExplosion s27packetexplosion) {
            afi.b(
                EnumChatFormatting.LIGHT_PURPLE + " Explosion (Velocity) " + EnumChatFormatting.RESET + " (DeltaX: %s) (DeltaY: %s)  (DeltaZ: %s) ",
                s27packetexplosion.func_149149_c(),
                s27packetexplosion.func_149144_d(),
                s27packetexplosion.func_149147_e()
            );
        } else if (this.Ut.wo() && packet instanceof S39PacketPlayerAbilities s39packetplayerabilities) {
            afi.b(
                EnumChatFormatting.YELLOW
                    + " Abilities "
                    + s39packetplayerabilities.getFlySpeed()
                    + " "
                    + s39packetplayerabilities.isAllowFlying()
                    + " "
                    + s39packetplayerabilities.isFlying()
            );
        }
    };
    @EventLink
    public final Listener<Render2DEvent> UH = var1 -> {
        if (this.Ux.wo()) {
            double d0 = 10.0;
            this.position.aHe = new Vector2d(180.0, 207.0);
            this.b(gg.REGULAR, 1).c(() -> {
                double d1 = this.position.apP.x;
                double d2 = this.position.apP.y;
                double d3 = this.position.aHe.x;
                double d4 = this.position.aHe.y;
                double d5 = this.rz().pl();
                this.rz();
                RenderUtil.roundedRectangle(d1, d2, d3, d4, d5, adv.rK());
            });
            this.b(gg.BLUR)
                .c(
                    () -> RenderUtil.roundedRectangle(
                        this.position.apP.x, this.position.apP.y, this.position.aHe.x, this.position.aHe.y, this.rz().pl(), Color.BLACK
                    )
                );
            this.b(gg.BLOOM)
                .c(
                    () -> RenderUtil.roundedRectangle(
                        this.position.apP.x, this.position.apP.y, this.position.aHe.x, this.position.aHe.y, this.rz().pl(), this.rz().rE()
                    )
                );
            this.b(gg.REGULAR, 1)
                .c(
                    () -> {
                        aEg.fontRendererObj
                            .b(
                                Client.b + " 6 INDEV " + this.date.format(LocalDateTime.now()),
                                this.position.apP.x + d0,
                                this.position.apP.y + d0,
                                new Color(255, 255, 0).getRGB()
                            );
                        aEg.fontRendererObj
                            .b(
                                "FPS: " + Minecraft.getDebugFPS() + " [target " + aEg.getLimitFramerate() + "]",
                                this.position.apP.x + d0,
                                this.position.apP.y + d0 * 2.0,
                                new Color(255, 255, 0).getRGB()
                            );
                        aEg.fontRendererObj.a("Debugger", this.position.apP.x + d0, this.position.apP.y + d0 * 4.0, this.rz().rA().hashCode());
                        aEg.fontRendererObj
                            .a("Hidden due to not in dev mode", this.position.apP.x + d0, this.position.apP.y + d0 * 5.0, Color.WHITE.hashCode());
                        aEg.fontRendererObj
                            .a("Hidden due to not in dev mode", this.position.apP.x + d0, this.position.apP.y + d0 * 6.0, Color.WHITE.hashCode());
                        aEg.fontRendererObj.a("ESPs Amount: " + cf.hc.size(), this.position.apP.x + d0, this.position.apP.y + d0 * 8.0, Color.WHITE.hashCode());
                        aEg.fontRendererObj.a("Performance", this.position.apP.x + d0, this.position.apP.y + d0 * 9.0, this.rz().rA().hashCode());
                        aEg.fontRendererObj
                            .a("ThreadLag: " + this.threadLag, this.position.apP.x + d0, this.position.apP.y + d0 * 16.0, Color.WHITE.hashCode());
                        aEg.fontRendererObj.a("Other", this.position.apP.x + d0, this.position.apP.y + d0 * 18.0, this.rz().rA().hashCode());
                        aEg.fontRendererObj.a("Timer: " + aEg.timer.dzD, this.position.apP.x + d0, this.position.apP.y + d0 * 19.0, Color.WHITE.hashCode());
                    }
                );
        }
    };
    @EventLink
    public final Listener<PreMotionEvent> UI = var1 -> {
        if (!this.measuring) {
            long i = System.currentTimeMillis();
            this.measuring = true;
            boolean flag = aEg.thePlayer.ticksExisted % 100 == 0 && this.Uy.wo();
            aMR.execute(() -> {
                this.threadLag = System.currentTimeMillis() - i;
                this.measuring = false;
                if (flag) {
                    afi.b("Displaying Calls: ");

                    for (String s : calls.keySet()) {
                        afi.b(s + ": " + calls.get(s));
                    }

                    calls.clear();
                }
            });
        }
    };

    public Debugger() {
    }

    @Override
    public void onEnable() {
        this.UB.clear();
    }
}
