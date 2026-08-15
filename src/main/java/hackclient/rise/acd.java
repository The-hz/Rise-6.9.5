package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.vector.Vector2f;
import java.awt.Color;
import net.minecraft.client.gui.ScaledResolution;

public class acd implements abx, InstanceAccess {
    public acd() {
    }

    @Override
    public void b(int var1, int var2, float var3) {
        Vector2f vector2f = this.getStandardClickGUI().getScale();
        Vector2f vector2f1 = this.getStandardClickGUI().getPosition();
        double d0 = this.getStandardClickGUI().oY().aym;
        gb.MAIN.a(32, gd.REGULAR).a(Client.b, vector2f.getX() + d0 + 20.0, vector2f.getY() + 20.0F, Color.WHITE.getRGB());
        gb.MAIN
            .a(16, gd.REGULAR)
            .a(
                "6",
                vector2f.getX() + d0 + 20.0 + gb.MAIN.a(32, gd.REGULAR).getStringWidth(Client.b),
                vector2f.getY() + 18.0F,
                new Color(255, 255, 255, 100).getRGB()
            );
        gb.MAIN.a(17, gd.REGULAR).a("6.9.5", vector2f.getX() + d0 + 20.0, vector2f.getY() + 50.0F, new Color(255, 255, 255, 164).getRGB());
        double d1 = System.currentTimeMillis() / 1000.0 % 45.0 * 11.0;
        air.hK();
        air.a(new ScaledResolution(aEg), vector2f.getX() + d0, vector2f.getY() + 90.0F, vector2f1.getX(), vector2f1.getY() - 175.0F);
        gb.MAIN
            .a(17, gd.REGULAR)
            .a(qt(), vector2f.getX() + d0 + 20.0, vector2f.getY() + 100.0F - d1 + (vector2f1.getY() - 175.0F), new Color(164, 164, 164, 64).getRGB());
        gb.MAIN
            .a(17, gd.REGULAR)
            .a(qu(), vector2f.getX() + d0 + 155.0, vector2f.getY() + 100.0F - d1 + (vector2f1.getY() - 175.0F), new Color(164, 164, 164, 64).getRGB());
        air.disable();
    }

    private static String qt() {
        return "Rise 6 (riseclient.com)\n\nDesigned and built by Alan and Hazsi.\n\nAdditional Development\n  -> Nicklas, Tecnio, Patrick, Strikeless\n\nUI/UX Design\n  -> Hazsi, Alan\n\nRendering/OpenGL\n  -> Patrick, Strikeless\n\nProtection and Obfuscation\n  -> Alan, NyanCatForEver\n\nScripting Documentation\n  -> Alice\n\nLocalization\n-> a cat (Romanian)\n-> Alice (Russian)\n-> Bx2 (Arabic)\n-> El Gatito Grande (Portuguese)\n-> days (Hebrew)\n-> Duits/Jess (Indonesian)\n-> fan87 (Chinese Traditional)\n-> Grekgamer13 (Greek)\n-> Jb (Austrian)\n-> kinja (Polish)\n-> I_only_die_twice (Swedish)\n\nSpecial Thanks\n  -> Auth and Error as contributing to development\n  -> Config and script makers\n  -> You, as a user of Rise. Thank you, on behalf of all of us!\n";
    }

    private static String qu() {
        return "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n-> im ray (Latvian)\n-> Novus (Spanish)\n-> Mongrall (Hungarian)\n-> MOON (Italian)\n-> Stimular (Czech)\n-> Tapludeforfair (French)\n-> toastedwaffles (Vietnamese)\n-> trollo (German)\n-> Velcola (Norwegian)\n-> whoistinywifi (Thai)\n-> YK_FCZ (Chinese Simplified)\n";
    }
}
