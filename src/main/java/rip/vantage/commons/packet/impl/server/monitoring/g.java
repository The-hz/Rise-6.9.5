package rip.vantage.commons.packet.impl.server.monitoring;

import org.json.JSONObject;

public class g extends rip.vantage.commons.packet.api.abstracts.b {
    public static Object[] oO00O0OO0ooO = new Object[1];
    public static Object[] o0Oo000O0oO = new Object[2];
    public static int[] O0OoOO0OOOOO;

    public g(JSONObject var1) {
        super((byte)29);
    }

    public static void Oo0o00000O00() {
    }

    @Override
    public void a(rip.vantage.commons.handler.api.c var1) {
        var1.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", true);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    static {
        Oo0o00000O00();
        oO00O0OO0ooO[0] = "\u0000\u0001a\u0000\u0002id";
        o0Oo000O0oO[0] = "a";
        o0Oo000O0oO[1] = "id";
    }
}
