package hackclient.rise;

import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.SubMode;

class yz extends ModeValue {
    yz(yv var1, String var2, Mode var3) {
        super(var2, var3);
        this.add(new SubMode("Off"));
        this.add(new SubMode("Normal"));
        this.setDefault("Normal");
    }
}
