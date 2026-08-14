package hackclient.rise;

import com.alan.clients.ui.click.standard.RiseClickGUI;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.vector.Vector2f;

public final class acc implements abx, InstanceAccess {
    public acc() {
    }

    @Override
    public void b(int var1, int var2, float var3) {
        RiseClickGUI riseclickgui = this.getStandardClickGUI();
        new Vector2f(riseclickgui.axI.x + 20.0F, riseclickgui.axI.y + 20.0F);
        new Vector2f(riseclickgui.axI.x + riseclickgui.alh.x / 2.0F, riseclickgui.axI.y + riseclickgui.alh.y - 14.0F);
    }
}
