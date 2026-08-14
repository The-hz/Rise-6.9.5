package hackclient.rise;

import com.alan.clients.module.Module;
import com.alan.clients.module.impl.render.Interface;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.SubMode;

public class xh extends ModeValue {
    public xh(Interface var1, String var2, Module var3) {
        super(var2, var3);
        this.add(new SubMode("All"));
        this.add(new SubMode("Exclude render"));
        this.add(new SubMode("Only bound"));
        this.setDefault("Exclude render");
    }
}
