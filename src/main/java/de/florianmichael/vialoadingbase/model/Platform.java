package de.florianmichael.vialoadingbase.model;

import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import de.florianmichael.vialoadingbase.ViaLoadingBase;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.logging.Logger;

public class Platform {
    public static int COUNT = 0;
    private final String name;
    private final BooleanSupplier load;
    private final Runnable executor;
    private final Consumer<List<ProtocolVersion>> versionCallback;

    public Platform(String var1, BooleanSupplier var2, Runnable var3) {
        this(var1, var2, var3, null);
    }

    public Platform(String var1, BooleanSupplier var2, Runnable var3, Consumer<List<ProtocolVersion>> var4) {
        this.name = var1;
        this.load = var2;
        this.executor = var3;
        this.versionCallback = var4;
    }

    public String getName() {
        return this.name;
    }

    public void createProtocolPath() {
        if (this.versionCallback != null) {
            this.versionCallback.accept(ViaLoadingBase.PROTOCOLS);
        }
    }

    public void build(Logger var1) {
        if (this.load.getAsBoolean()) {
            try {
                this.executor.run();
                var1.info("Loaded Platform " + this.name);
                COUNT++;
            } catch (Throwable throwable) {
                var1.severe("An error occurred while loading Platform " + this.name + ":");
                throwable.printStackTrace();
            }
        } else {
            var1.severe("Platform " + this.name + " is not present");
        }
    }
}
