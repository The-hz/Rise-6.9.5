package hackclient.rise;

import com.alan.clients.module.Module;
import com.alan.clients.module.impl.render.Interface;
import com.alan.clients.module.impl.render.TargetInfo;
import com.alan.clients.value.Mode;
import lombok.Generated;

public class zb<I extends Module> extends Mode<Interface> {
    private final Mode<TargetInfo> atf;

    public zb(String var1, Interface var2, Mode<TargetInfo> var3) {
        super(var1, var2);
        this.atf = var3;
    }

    @Generated
    public Mode<TargetInfo> np() {
        return this.atf;
    }
}
