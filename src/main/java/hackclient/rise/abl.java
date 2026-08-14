package hackclient.rise;

import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.value.Value;
import lombok.Generated;

public abstract class abl implements InstanceAccess {
    public double jy = 14.0;
    public Vector2d apP;
    public Value<?> ayC;
    public int ayD = 255;

    public abl(Value<?> var1) {
        this.ayC = var1;
    }

    public abstract void a(Vector2d var1, int var2, int var3, float var4);

    public abstract boolean e(int var1, int var2, int var3);

    public abstract void pz();

    public abstract void ci();

    public abstract void b(char var1, int var2);

    @Generated
    public double da() {
        return this.jy;
    }

    @Generated
    public Vector2d nr() {
        return this.apP;
    }

    @Generated
    public Value<?> pS() {
        return this.ayC;
    }

    @Generated
    public int pT() {
        return this.ayD;
    }

    @Generated
    public void U(int var1) {
        this.ayD = var1;
    }
}
