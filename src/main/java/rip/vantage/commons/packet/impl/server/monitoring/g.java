package rip.vantage.commons.packet.impl.server.monitoring;

import org.json.JSONObject;

public class g extends rip.vantage.commons.packet.api.abstracts.b {

    public g(JSONObject var1) {
        super((byte)29);
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
    }
}
