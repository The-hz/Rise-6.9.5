package hackclient.rise;

import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2f;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.opengl.GL11;

public class ace implements abx, InstanceAccess {
    private final ArrayList<abg> languages = new ArrayList<>();
    private final agk azQ = new agk();

    public ace() {
        for (ahc ahc : ahc.values()) {
            this.languages.add(new abg(ahc, ahd.a("language_local", ahc), ahd.a("language_english", ahc)));
        }
    }

    @Override
    public void b(int var1, int var2, float var3) {
        this.azQ.qx();
        Vector2f vector2f = this.getStandardClickGUI().getScale();
        Vector2f vector2f1 = this.getStandardClickGUI().getPosition();
        double d0 = this.getStandardClickGUI().oY().aym;
        double d1 = vector2f.getX() + d0;
        double d2 = vector2f.getY() + 40.0;
        double d3 = vector2f1.x - d0;
        double d4 = Math.max(0.0, vector2f1.y - 40.0);
        GL11.glPushAttrib(524288);
        air.hK();
        air.a(new ScaledResolution(aEg), d1, d2, d3, d4);

        for (int i = 0; i < this.languages.size(); i++) {
            this.languages.get(i).draw((i + 1) * 46 + this.azQ.tE());
        }

        air.disable();
        GL11.glPopAttrib();
        RenderUtil.a(
            vector2f.getX() + d0, vector2f.getY(), vector2f1.x - d0, 40.0, this.getStandardClickGUI().round, abw.BACKGROUND.pV(), true, true, false, false
        );
        gb.MAIN
            .a(16, gd.REGULAR)
            .d(ahd.ce("ui.language.text"), vector2f.getX() + vector2f1.getX() - 20.0F, vector2f.getY() + 20.0F, new Color(255, 255, 255, 128).getRGB());
        this.azQ.V(-2000.0);
    }

    @Override
    public void f(int var1, int var2, int var3) {
        Iterator iterator = this.languages.iterator();

        while (iterator.hasNext()) {
            ((abg)iterator.next()).click(var1, var2);
        }
    }
}
