package rip.vantage.commons.packet.impl.server.management;

import org.json.JSONObject;
import rip.vantage.commons.handler.api.c;
import rip.vantage.commons.packet.api.abstracts.b;

public class a extends b {
    public a() {
        super((byte)5);
    }

    @Override
    public void a(c var1) {
        var1.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }
}
