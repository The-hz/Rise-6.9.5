package hackclient.rise;

import com.alan.clients.anticheat.check.Check;
import com.alan.clients.anticheat.check.impl.combat.AutoBlockA;
import com.alan.clients.anticheat.check.impl.combat.AutoBlockB;
import com.alan.clients.anticheat.check.impl.combat.VelocityCancel;
import com.alan.clients.anticheat.check.impl.movement.FlightPrediction;
import com.alan.clients.anticheat.check.impl.movement.SpeedLimit;
import com.alan.clients.anticheat.check.impl.movement.TowerWatchdog;
import com.alan.clients.anticheat.data.PlayerData;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public final class l {
    public static final Class<?>[] ak = new Class[]{
        SpeedLimit.class, FlightPrediction.class, AutoBlockA.class, AutoBlockB.class, VelocityCancel.class, TowerWatchdog.class
    };
    private static final List<Constructor<?>> al = new ArrayList<>();

    public l() {
    }

    public static List<Check> a(PlayerData var0) {
        ArrayList arraylist = new ArrayList();

        for (Constructor constructor : al) {
            try {
                arraylist.add((Check)constructor.newInstance(var0));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        return arraylist;
    }

    public static void U() {
        for (Class oclass : ak) {
            try {
                al.add(oclass.getConstructor(PlayerData.class));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
