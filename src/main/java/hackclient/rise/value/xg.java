package hackclient.rise.value;

import com.alan.clients.module.Module;
import com.alan.clients.module.impl.render.Interface;
import com.alan.clients.value.impl.ModeValue;
import hackclient.rise.mode.yr;
import hackclient.rise.mode.ys;
import com.alan.clients.module.impl.render.interfaces.ModernInterface;
import com.alan.clients.module.impl.render.interfaces.WurstInterface;

public class xg extends ModeValue {
    public xg(Interface var1, String var2, Module module) {
        super(var2, module);
        this.add(new ModernInterface("Modern", (Interface)this.wq()));
        this.add(new WurstInterface("Wurst", (Interface)this.wq()));
        this.add(new ys("Classic", (Interface)this.wq()));
        this.add(new yr("Creida", (Interface)this.wq()));
        this.setDefault("Modern");
    }
}
