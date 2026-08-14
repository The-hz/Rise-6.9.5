package rip.vantage.commons.packet.impl.server.monitoring;

import org.json.JSONObject;

public class a extends rip.vantage.commons.packet.api.abstracts.b {
    public int ePV;
    public String ePU;
    public static Object[] o0Oo000O0oO = new Object[5];
    public static Object[] oO00O0OO0ooO = new Object[1];

    public String ajm() {
        return this.ePU;
    }

    public int aJV() {
        return this.ePV;
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.ePU);
        jsonobject.put("b", this.ePV);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public a(String var1, int var2) {
        super((byte)22);
        this.ePU = var1;
        this.ePV = var2;
    }

    static {
        oO00O0OO0ooO[0] = "\u0000\u0002id\u0000\u0001b\u0000\u0001a\u0000\u0001b\u0000\u0001a";
        o0Oo000O0oO[0] = "id";
        o0Oo000O0oO[1] = "b";
        o0Oo000O0oO[2] = "a";
        o0Oo000O0oO[3] = "b";
        o0Oo000O0oO[4] = "a";
    }

    @Override
    public void a(rip.vantage.commons.handler.api.c var1) {
        var1.a(this);
    }

    public a(JSONObject var1) {
        super((byte)22);
        this.ePU = var1.getString("a");
        this.ePV = var1.optInt((String)o0Oo000O0oO[3], 600);
    }
}
