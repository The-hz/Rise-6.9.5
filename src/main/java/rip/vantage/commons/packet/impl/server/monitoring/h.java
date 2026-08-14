package rip.vantage.commons.packet.impl.server.monitoring;

import org.json.JSONObject;

public class h extends rip.vantage.commons.packet.api.abstracts.b {
    private final String ePZ;

    public h(String var1) {
        super((byte)23);
        this.ePZ = var1;
    }

    public h(JSONObject var1) {
        super((byte)23);
        this.ePZ = var1.getString("a");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.c var1) {
        var1.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.ePZ);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public String ajm() {
        return this.ePZ;
    }
}
