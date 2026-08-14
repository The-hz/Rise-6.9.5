package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.ui.click.standard.RiseClickGUI;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2f;
import java.awt.Color;

public class abh implements InstanceAccess {
    public Vector2f alh;

    public abh() {
    }

    public void pJ() {
        RiseClickGUI riseclickgui = Client.a.v();
        double d0 = riseclickgui.axI.x;
        double d1 = riseclickgui.axI.y;
        double d2 = riseclickgui.alh.x;
        double d3 = riseclickgui.alh.y;
        if (this.alh != null) {
            RenderUtil.dropShadow(
                60, (float)(d0 + d2 / 2.0 - this.alh.x / 2.0F), (float)(d1 + d3 / 2.0 - this.alh.y / 2.0F), this.alh.x, this.alh.y, 50.0, 34.0
            );
            RenderUtil.roundedRectangle(
                d0 + d2 / 2.0 - this.alh.x / 2.0F, d1 + d3 / 2.0 - this.alh.y / 2.0F, this.alh.x, this.alh.y, 9.0, new Color(0, 0, 0, 230)
            );
        }
    }
}
