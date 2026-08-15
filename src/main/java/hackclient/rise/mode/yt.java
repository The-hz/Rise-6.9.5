package hackclient.rise.mode;

import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.SubMode;

class yt extends ModeValue {
    yt(ys var1, String var2, Mode var3) {
        super(var2, var3);
        this.add(new SubMode("Static"));
        this.add(new SubMode("Rainbow"));
        this.add(new SubMode("Fade"));
        this.setDefault("Rainbow");
    }
}
