package com.alan.clients.module.impl.movement.phase;

import com.alan.clients.module.impl.movement.Phase;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.other.TickEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.NumberValue;
import com.alan.clients.value.impl.SubMode;
import hackclient.rise.ahj;
import hackclient.rise.aih;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer.C06PacketPlayerPosLook;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;

public class GrimPhase extends Mode<Phase> {
    private final List<Packet<?>> NU = new ArrayList<>();
    private final ModeValue NV = new ModeValue("Release Mode", this)
        .add(new SubMode("Simple"))
        .add(new SubMode("Double"))
        .add(new SubMode("Desync"))
        .add(new SubMode("None"))
        .setDefault("Simple");
    private final NumberValue NW = new NumberValue("Semi Packets", this, 2, 1, 15, 1);
    private boolean NX;
    private boolean NY;
    @EventLink
    public final Listener<PacketSendEvent> NZ = var1x -> {
        if (aEg.thePlayer != null) {
            Packet packet = var1x.dq();
            if (packet instanceof C03PacketPlayer) {
                this.NU.add(packet);
                var1x.setCancelled();
            }
        }
    };
    @EventLink
    public final Listener<TickEvent> Oa = var1x -> {
        if (aEg.thePlayer != null && aEg.theWorld != null) {
            boolean flag = aih.vk();
            if (!this.NX && flag) {
                double d0 = aEg.thePlayer.posX;
                double d1 = aEg.thePlayer.posY;
                double d2 = aEg.thePlayer.posZ;
                float f = aEg.thePlayer.pl;
                float f1 = aEg.thePlayer.rotationPitch;
                boolean flag1 = aEg.thePlayer.onGround;

                for (int i = 0; i < this.NW.wo().intValue(); i++) {
                    ahj.m(new C06PacketPlayerPosLook(d0, d1, d2, f, f1, flag1));
                }

                this.NX = true;
            } else {
                if (this.NX && !flag) {
                    this.NY = true;
                    this.toggle();
                }
            }
        }
    };
    @EventLink
    public final Listener<PreMotionEvent> Ob = var0 -> {};
    @EventLink
    public final Listener<PacketReceiveEvent> Oc = var0 -> {
        boolean flag = var0.dq() instanceof S08PacketPlayerPosLook;
    };

    public GrimPhase(String var1, Phase var2) {
        super(var1, var2);
    }

    @Override
    public void onEnable() {
        this.NU.clear();
        this.NX = false;
        this.NY = false;
    }

    @Override
    public void onDisable() {
        if (!this.NY && this.NX) {
            if (!this.NV.wo().getName().equals("None")) {
                this.A(this.NV.wo().getName());
            } else {
                ahj.m(
                    new C06PacketPlayerPosLook(
                        aEg.thePlayer.posX, aEg.thePlayer.posY, aEg.thePlayer.posZ, aEg.thePlayer.pl, aEg.thePlayer.rotationPitch, aEg.thePlayer.onGround
                    )
                );
            }
        }

        if (aEg.thePlayer != null && !this.NU.isEmpty()) {
            this.NU.forEach(ahj::m);
            this.NU.clear();
        }
    }

    private void A(String var1) {
        double d0;
        double d1;
        double d2;
        float f;
        float f1;
        label44: {
            label30: {
                d0 = aEg.thePlayer.posX;
                d1 = aEg.thePlayer.posY;
                d2 = aEg.thePlayer.posZ;
                f = aEg.thePlayer.pl;
                f1 = aEg.thePlayer.rotationPitch;
                String s = var1.toLowerCase();
                byte b0 = -1;
                switch (s.hashCode()) {
                    case -1335230820:
                        if (s.equals("desync")) {
                            break label30;
                        }
                        break;
                    case -1325958191:
                        if (s.equals("double")) {
                            break label44;
                        }
                        break;
                    case -902286926:
                        if (s.equals("simple")) {
                            b0 = 0;
                        }
                }

                switch (b0) {
                    case 0:
                        ahj.m(new C06PacketPlayerPosLook(d0 - 5000.0, d1, d2 - 5000.0, f, f1, false));
                        ahj.m(new C06PacketPlayerPosLook(d0, d1, d2, f, f1, aEg.thePlayer.onGround));
                        return;
                    case 1:
                        break label44;
                    case 2:
                        break;
                    default:
                        return;
                }
            }

            ahj.m(new C06PacketPlayerPosLook(d0, d1 + 0.0625, d2, f, f1, false));
            ahj.m(new C06PacketPlayerPosLook(d0, d1, d2, f, f1, false));
            ahj.m(new C06PacketPlayerPosLook(d0, d1 + 0.03125, d2, f, f1, true));
            ahj.m(new C06PacketPlayerPosLook(d0, d1, d2, f, f1, aEg.thePlayer.onGround));
            return;
        }

        ahj.m(new C06PacketPlayerPosLook(d0 - 5000.0, d1, d2 - 5000.0, f, f1, false));
        ahj.m(new C06PacketPlayerPosLook(d0 + 5000.0, d1, d2 + 5000.0, f, f1, false));
        ahj.m(new C06PacketPlayerPosLook(d0, d1, d2, f, f1, aEg.thePlayer.onGround));
    }
}
