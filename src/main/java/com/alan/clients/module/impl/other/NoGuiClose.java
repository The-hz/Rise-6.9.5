package com.alan.clients.module.impl.other;

import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.value.impl.BooleanValue;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.network.play.server.ay;

@ModuleInfo(aliases = "module.other.noguiclose.name", category = Category.PLAYER, description = "module.other.noguiclose.description")
public class NoGuiClose extends Module {
    public BooleanValue chatonly = new BooleanValue("Chat Only", this, false);
    public static Object[] o0Oo000O0oO = new Object[1];
    public static Object[] fld_0oOOoOo0O00O_44 = new Object[4];
    public static Object[] oO00O0OO0ooO = new Object[1];
    public static int[] O0OoOO0OOOOO;
    @EventLink
    public Listener<PacketReceiveEvent> onPacketReceive = var1 -> {
        var1.dq();
        if (var1.dq() instanceof ay && (aEg.currentScreen instanceof GuiChat || !this.chatonly.wo())) {
            var1.setCancelled();
        }
    };

    static {
        Oo0o00000O00();
        oO00O0OO0ooO[0] = "\u0000\tChat Only";
        o0Oo000O0oO[0] = "Chat Only";
        fld_0oOOoOo0O00O_44[0] = "HiTWt/9wgEr4OEwkpmeI4hBC301ho7TuCk1MPoMD5e4=";
        fld_0oOOoOo0O00O_44[1] = "PBKDF2WithHmacSHA1";
        fld_0oOOoOo0O00O_44[2] = "AES";
        fld_0oOOoOo0O00O_44[3] = "AES/CBC/PKCS5Padding";
    }

    public NoGuiClose() {
    }

    public static void Oo0o00000O00() {
    }
}
