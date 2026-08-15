package hackclient.rise;

import com.sun.tools.attach.VirtualMachine;
import java.util.Arrays;

public final class aar extends aaj {
    private static final String[] HARAM = new String[]{"dump", "packetlog", "logger", "recaf", "jbyte", "bytecode", "decompile", "log"};

    public aar() {
        super(aak.JOIN, false);
    }

    @Override
    public boolean check() {
        return VirtualMachine.list().stream().anyMatch(var0 -> {
            String s = var0.displayName().toLowerCase().trim();
            return Arrays.stream(HARAM).anyMatch(s::contains);
        });
    }
}
