package hackclient.rise;

import com.google.gson.JsonObject;

final class aez {
    private final int aFP;
    final JsonObject aFQ;
    final String aFR;

    aez(int var1, JsonObject json, String var3) {
        this.aFP = var1;
        this.aFQ = json;
        this.aFR = var3;
    }

    boolean st() {
        return this.aFQ != null;
    }
}
