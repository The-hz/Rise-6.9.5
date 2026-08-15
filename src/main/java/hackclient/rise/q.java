package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.KeyboardInputEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Keyboard;

public class q {
    @EventLink(value = 0)
    public final Listener<KeyboardInputEvent> onKeyboardInput = var1 -> {
        if (!var1.isCancelled()) {
            if (var1.getKeyCode() == 25 && GuiScreen.isCtrlKeyDown() && GuiScreen.isShiftKeyDown()) {
                if (Keyboard.isRepeatEvent()) {
                    var1.setCancelled();
                } else {
                    boolean flag = agx.uB();
                    if (Minecraft.getMinecraft() != null && Minecraft.getMinecraft().theWorld != null && Minecraft.getMinecraft().thePlayer != null) {
                        cg.a(ahd.ce("module.render.chat.pinyin_ime"), ahd.ce(flag ? "ui.chat.pinyin_ime.hint.on" : "ui.chat.pinyin_ime.hint.off"), 1500);
                    }

                    var1.setCancelled();
                }
            } else if (var1.getGuiScreen() == null) {
                this.aP().stream().filter(var1x -> var1x.getKey() == var1.getKeyCode()).forEach(p::onKey);
            }
        }
    };
    @EventLink(value = 0)
    public final Listener<dy> bm = var1 -> {
        if (Minecraft.getMinecraft().currentScreen == null) {
            int i = var1.cW() - 100;
            this.aP().stream().filter(var1x -> var1x.getKey() == i).forEach(p::onKey);
        }
    };

    public q() {
    }

    public void init() {
        Client.a.e().b(this);
    }

    public List<p> aP() {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(Client.a.g().ef());
        arraylist.addAll(Client.a.p());
        return arraylist;
    }

    public <T extends p> T a(String var1) {
        return (T)this.aP()
            .stream()
            .filter(var1x -> Arrays.stream(var1x.getAliases()).anyMatch(var1xx -> var1xx.replace(" ", "").equalsIgnoreCase(var1.replace(" ", ""))))
            .findAny()
            .orElse(null);
    }
}
