package hackclient.rise.value;

import com.alan.clients.module.Module;
import com.alan.clients.module.impl.render.Ambience;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.SubMode;

public class wc extends ModeValue {
    public wc(Ambience var1, String var2, Module var3) {
        super(var2, var3);
        this.add(new SubMode("Unchanged"));
        this.add(new SubMode("Clear"));
        this.add(new SubMode("Rain"));
        this.add(new SubMode("Heavy Snow"));
        this.add(new SubMode("Light Snow"));
        this.add(new SubMode("Nether Particles"));
        this.setDefault("Unchanged");
    }
}
