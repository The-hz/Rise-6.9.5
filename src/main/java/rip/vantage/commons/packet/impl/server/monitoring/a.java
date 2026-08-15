package rip.vantage.commons.packet.impl.server.monitoring;

import org.json.JSONObject;

public class a extends rip.vantage.commons.packet.api.abstracts.b {
    public int ePV;
    public String ePU;

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
    }

    @Override
    public void a(rip.vantage.commons.handler.api.c var1) {
        var1.a(this);
    }

    public a(JSONObject json) {
        super((byte)22);
        this.ePU = json.getString("a");
        this.ePV = json.optInt("b", 600);
    }
}
