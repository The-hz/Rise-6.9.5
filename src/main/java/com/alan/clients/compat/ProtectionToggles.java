package com.alan.clients.compat;

//add code
public final class ProtectionToggles {

    private static final boolean ANTI_CRACK =
            Boolean.getBoolean("rise.protection.anticrack");

    private static final boolean CHECKS =
            Boolean.getBoolean("rise.protection.checks");

    private static final boolean PROXY_LOOKUP =
            Boolean.getBoolean("rise.protection.proxylookup");

    private ProtectionToggles() {
    }

    public static boolean antiCrackScan() {
        return ANTI_CRACK;
    }

    public static boolean checks() {
        return CHECKS;
    }

    public static boolean proxyLookup() {
        return PROXY_LOOKUP;
    }
}
