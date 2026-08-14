package hackclient.rise;

import com.alan.clients.util.interfaces.InstanceAccess;
import java.util.List;
import lombok.Generated;

public abstract class aix implements InstanceAccess {
    private boolean dj;

    public aix() {
    }

    public abstract void a(aiz var1, float var2, List<Runnable> var3);

    public abstract void ju();

    @Generated
    public boolean bd() {
        return this.dj;
    }

    @Generated
    public void c(boolean var1) {
        this.dj = var1;
    }
}
