package hackclient.rise;

import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.SubMode;

class yu extends ModeValue {
    yu(ys var1, String var2, Mode var3) {
        super(var2, var3);
        this.add(new SubMode("Right"));
        this.add(new SubMode("Left"));
        this.setDefault("Right");
    }
}
