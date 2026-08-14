package hackclient.rise;

import com.alan.clients.newevent.Event;
import net.minecraft.entity.EntityLivingBase;

public final class fx implements Event {
    private final EntityLivingBase ko;
    private Runnable kp;
    private Runnable kq;

    public fx(EntityLivingBase var1, Runnable var2, Runnable var3) {
        this.ko = var1;
        this.kp = var2;
        this.kq = var3;
    }

    public EntityLivingBase dH() {
        return this.ko;
    }

    public Runnable dI() {
        return this.kp;
    }

    public Runnable dJ() {
        return this.kq;
    }

    public void a(Runnable var1) {
        this.kp = var1;
    }

    public void b(Runnable var1) {
        this.kq = var1;
    }
}
