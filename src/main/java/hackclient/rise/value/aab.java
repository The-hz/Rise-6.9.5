package hackclient.rise.value;

import com.alan.clients.module.impl.render.targetinfo.ModernTargetInfo;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.SubMode;

public class aab extends ModeValue {
    public aab(ModernTargetInfo var1, String var2, Mode var3) {
        super(var2, var3);
        this.add(new SubMode("Glass"));
        this.add(new SubMode("Tint"));
        this.add(new SubMode("Solid"));
        this.setDefault("Glass");
    }
}
