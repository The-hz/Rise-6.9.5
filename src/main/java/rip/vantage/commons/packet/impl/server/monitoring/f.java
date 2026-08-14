package rip.vantage.commons.packet.impl.server.monitoring;

import org.json.JSONArray;
import org.json.JSONObject;

public class f extends rip.vantage.commons.packet.api.abstracts.b {
    public static Object[] oO00O0OO0ooO = new Object[1];
    public static Object[] o0Oo000O0oO = new Object[6];
    public JSONArray ePS;
    public static int[] O0OoOO0OOOOO;
    public String ePT;

    public JSONArray aJU() {
        return this.ePS;
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.ePS);
        jsonobject.put("b", this.ePT);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    @Override
    public void a(rip.vantage.commons.handler.api.c var1) {
        var1.b(this);
    }

    public String getVersion() {
        return this.ePT;
    }

    static {
        Oo0o00000O00();
        oO00O0OO0ooO[0] = "\u0000\u0002id\u0000\u00011\u0000\u0001a\u0000\u0001b\u0000\u0001a\u0000\u0001b";
        o0Oo000O0oO[0] = "id";
        o0Oo000O0oO[1] = "1";
        o0Oo000O0oO[2] = "a";
        o0Oo000O0oO[3] = "b";
        o0Oo000O0oO[4] = "a";
        o0Oo000O0oO[5] = "b";
    }

    public static void Oo0o00000O00() {
    }

    public f(JSONObject var1) {
        super((byte)27);
        this.ePS = var1.optJSONArray("a");
        this.ePT = var1.optString("b", (String)o0Oo000O0oO[1]);
    }
}
