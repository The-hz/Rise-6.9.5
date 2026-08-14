package hackclient.rise;

import com.alan.clients.module.Module;
import com.alan.clients.module.impl.render.Interface;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.SubMode;

public class xi extends ModeValue {
    public xi(Interface var1, String var2, Module var3) {
        super(var2, var3);
        this.add(new SubMode("Rise"));
        this.add(new SubMode("Traditional"));
        this.setDefault("Rise");
    }
}
