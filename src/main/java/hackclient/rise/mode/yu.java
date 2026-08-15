package hackclient.rise.mode;

import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.SubMode;

class yu extends ModeValue {
    yu(ys var1, String var2, Mode mode) {
        super(var2, mode);
        this.add(new SubMode("Right"));
        this.add(new SubMode("Left"));
        this.setDefault("Right");
    }
}
