package com.alan.clients.compat;

//add code
public final class ProtectionToggles {

    private static final boolean ANTI_CRACK =
            Boolean.getBoolean("rise.protection.anticrack");

    private ProtectionToggles() {
    }

    public static boolean antiCrackScan() {
        return ANTI_CRACK;
    }
}
