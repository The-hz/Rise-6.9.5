package hackclient.rise;

import com.alan.clients.util.interfaces.InstanceAccess;
import java.util.List;
import lombok.Generated;

public abstract class aix implements InstanceAccess {
    private boolean active;

    public aix() {
    }

    public abstract void a(aiz var1, float var2, List<Runnable> runnables);

    public abstract void update();

    @Generated
    public boolean isActive() {
        return this.active;
    }

    @Generated
    public void setActive(boolean active) {
        this.active = active;
    }
}
