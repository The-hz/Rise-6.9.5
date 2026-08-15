package com.alan.clients.util.account.localts;

import com.google.gson.JsonObject;

final class LocaltsResponse {
    private final int aFP;
    final JsonObject aFQ;
    final String aFR;

    LocaltsResponse(int var1, JsonObject json, String var3) {
        this.aFP = var1;
        this.aFQ = json;
        this.aFR = var3;
    }

    boolean st() {
        return this.aFQ != null;
    }
}
