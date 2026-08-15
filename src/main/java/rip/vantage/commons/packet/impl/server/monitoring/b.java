package rip.vantage.commons.packet.impl.server.monitoring;

import org.json.JSONObject;

public class b extends rip.vantage.commons.packet.api.abstracts.b {
    public String ePW;
    public int ePX;
    public String ePY;

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.ePW);
        jsonobject.put("b", this.ePX);
        jsonobject.put("d", this.ePY);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public b(JSONObject var1) {
        super((byte)24);
        this.ePW = var1.getString("a");
        this.ePX = var1.optInt("b", 300);
        this.ePY = var1.optString("d", "screenshot");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.c var1) {
        var1.a(this);
    }

    public b(String var1, int var2, String var3) {
        super((byte)24);
        this.ePW = var1;
        this.ePX = var2;
        this.ePY = var3;
    }

    public String ajm() {
        return this.ePW;
    }


    public int aJV() {
        return this.ePX;
    }

    public String aJW() {
        return this.ePY;
    }

    static {
    }
}
