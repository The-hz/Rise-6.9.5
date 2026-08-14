package hackclient.rise;

import com.alan.clients.util.interfaces.InstanceAccess;
import java.util.ArrayList;
import lombok.Generated;

public class ge implements InstanceAccess {
    private final ArrayList<Runnable> kK = new ArrayList<>();
    aix kL = null;

    public ge(aix var1) {
        this.kL = var1;
    }

    public ge() {
    }

    public void a(aiz var1) {
        if (!this.kK.isEmpty()) {
            if (this.kL == null) {
                aEg.getFramebuffer().bindFramebuffer(false);
                this.kK.forEach(Runnable::run);
            } else {
                this.kL.a(var1, 0.0F, this.kK);
                if (var1 == aiz.OVERLAY) {
                    this.kL.ju();
                }
            }
        }
    }

    public void clear() {
        this.kK.clear();
    }

    public void c(Runnable var1) {
        this.kK.add(var1);
    }

    @Generated
    public ArrayList<Runnable> dT() {
        return this.kK;
    }

    @Generated
    public aix dU() {
        return this.kL;
    }
}
