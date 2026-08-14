package hackclient.rise;

import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.vector.Vector2d;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Mouse;

public class afl implements InstanceAccess {
    public afl() {
    }

    public static Vector2d sW() {
        ScaledResolution scaledresolution = aEg.jY;
        int i = Mouse.getX() * scaledresolution.getScaledWidth() / aEg.displayWidth;
        int j = scaledresolution.getScaledHeight() - Mouse.getY() * scaledresolution.getScaledHeight() / aEg.displayHeight - 1;
        return new Vector2d(i, j);
    }
}
