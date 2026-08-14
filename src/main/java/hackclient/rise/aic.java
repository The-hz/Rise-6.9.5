package hackclient.rise;

import java.util.stream.IntStream;
import net.minecraft.client.Minecraft;
import net.minecraft.inventory.Container;

public class aic {
    public static final int aOc = 5;
    public static final int aOd = 9;
    public static final int aOe = 45;
    public static final int aOf = 36;

    private aic() {
    }

    public static boolean a(Container var0) {
        return IntStream.range(9, 45).allMatch(var1 -> var0.getSlot(var1).getHasStack());
    }

    public static void a(Minecraft var0, int var1, int var2, int var3, aid var4) {
        var0.playerController.windowClick(var1, var2, var3, var4.ordinal(), var0.thePlayer);
    }
}
