package hackclient.rise;

import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.SubMode;

class yx extends ModeValue {
    yx(yv var1, String var2, Mode var3) {
        super(var2, var3);
        this.add(new SubMode("Apple UI"));
        this.add(new SubMode("Minecraft"));
        this.add(new SubMode("Custom"));
        this.setDefault("Apple UI");
    }
}
