package hackclient.rise;

import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.SubMode;

class yw extends ModeValue {
    yw(yv var1, String var2, Mode var3) {
        super(var2, var3);
        this.add(new SubMode("Static"));
        this.add(new SubMode("Fade"));
        this.add(new SubMode("Breathe"));
        this.setDefault("Fade");
    }
}
