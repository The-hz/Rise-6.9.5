package hackclient.rise;

import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.SubMode;

class yy extends ModeValue {
    yy(yv var1, String var2, Mode var3) {
        super(var2, var3);
        this.add(new SubMode("Glow"));
        this.add(new SubMode("Shadow"));
        this.setDefault("Shadow");
    }
}
